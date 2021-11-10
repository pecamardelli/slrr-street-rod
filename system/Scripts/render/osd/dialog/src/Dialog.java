package java.render.osd.dialog;

import java.io.*;
import java.util.*;
import java.util.resource.*;
import java.render.*;
import java.render.osd.*;

public class Dialog extends GameType
{
	final static int RID_DIALOGBG	= frontend:0x000Er;
	
	final static float DEF_SIZE		= 0.6;
	final static float DEF_ASPECT	= 4.0/3.0;
	final static float DEF_BODYRATIO= 0.9;

	final static int DF_MODAL		= 0x00000001;
	final static int DF_FULLSCREEN	= 0x00000002;	//otherwise defaults to 60%
	final static int DF_DEFAULTBG	= 0x00000004;	//uses a default backgroung image
	final static int DF_FREEZE		= 0x00000008;	//stop physics
	final static int DF_LEAVEPOINTER= 0x00000010;	//do not alter the pointer's state (otherwise it'll be turned on)
	final static int DF_LOWPRI		= 0x00000020;	//ha tobb dalogus lehet kint, ezzel lehet megadni a sorrendet
	final static int DF_HIGHPRI		= 0x00000040;	//ha tobb dalogus lehet kint, ezzel lehet megadni a sorrendet
	final static int DF_WIDE		= 0x00000080;	//szeles, nem fullscreen dialogus
	final static int DF_DARKEN		= 0x00000100;	//tesz a hatterbe egy sotetitett alfas lapot
	final static int DF_SILENT		= 0x00000200;	//a show() nem jatssza le a default hangot

	final static int SIF_NOEMPTY	= 0x00001000;	//StringRequester - no empty strings allowed
	final static int FRF_SAVE		= 0x00001000;	//FileRequester - save mode (owerwrite question)

	int				priority = 22;	//low: 19/20, normal: 21/22; highr: 23/24
	Osd				osd;
	int				flags;
	String			title;
	String			buttonTexts;
	float			timewarp;

	int				result;
	int				escapeCmd = -1;

	Controller		controller;
	ControlSetState	css;

	int				prevPointerState;

	Osd				backShieldOsd;

	float			bodyRatio = DEF_BODYRATIO;
	
	int				shown;

	private Dialog()
	{
		System.log( "private constructor access (Dialog)" );
	}

	public Dialog( Controller ctrl, int myFlags, String myTitle, String myButtons )
	{
		this( ctrl, myFlags, myTitle, myButtons, DEF_SIZE, DEF_ASPECT, 0.5, 0.5, -0.5, -0.5 );
	}

	public Dialog( Controller ctrl, int myFlags, String myTitle, String myButtons, float size, float aspect )
	{
		this( ctrl, myFlags, myTitle, myButtons, size, aspect, 0.5, 0.5, -0.5, -0.5 );
	}

	public Dialog( Controller ctrl, int myFlags, String myTitle, String myButtons, float size, float aspect, float cx, float cy, float refx, float refy )
	{
		createNativeInstance();

		controller = ctrl;
		flags=myFlags;
		title=myTitle;
		buttonTexts=myButtons;

		if( flags&DF_HIGHPRI )
			priority+=2;
		else
		if( flags&DF_LOWPRI )
			priority-=2;

		if( flags&DF_FULLSCREEN )
			osd = new Osd( 1.0, 0.0, priority );
		else
			if( flags&DF_WIDE )
				osd = new Osd( 0.9, 6.0/3.0, priority );
			else
				osd = new Osd( size, aspect, cx, cy, refx, refy, priority );

		if( flags&DF_DEFAULTBG )
			osd.createBG( new ResourceRef( RID_DIALOGBG ) );

		if( title )
			osd.createText( title, Frontend.mediumFont, Text.ALIGN_CENTER,	0.0, 2*((1-bodyRatio)/4)-1 );

		osd.globalHandler = this;
	}

	public void show()
	{
		new SfxRef( Frontend.SFX_MENU_MOVE ).precache();
		new SfxRef( Frontend.SFX_MENU_SELECT ).precache(); 
		new SfxRef( Frontend.SFX_QUESTION ).precache(); 

		shown=1;

		//FLAG: DF_FREEZE
		if( flags&DF_FREEZE )
			timewarp = System.timeWarp(0.0);

		Osd	shieldHolderOsd;
		if( flags&DF_MODAL )
		{
			backShieldOsd = new Osd( 1.0, 0.0, priority-1 );
			backShieldOsd.iLevel = Osd.IL_NONE;
			backShieldOsd.show();

			shieldHolderOsd = backShieldOsd;
			osd.flags|=Osd.OF_MODAL;
		}
		else
		{
			shieldHolderOsd = osd;
		}

		ResourceRef bgButtonImage;

		if( flags&DF_DARKEN )
			bgButtonImage = Osd.RRT_DARKEN;

		Style shieldButtonStyle = new Style( 2.0, 2.0, shieldHolderOsd.vpAspect, Frontend.mediumFont, Text.ALIGN_CENTER, bgButtonImage );
		shieldHolderOsd.createButton( shieldButtonStyle, 0.0, 0.0, -2, " ", 9999999 ).nofocus = 1;


		//SET UP BUTTONS
		float x,y;

		StringTokenizer tok = new StringTokenizer( buttonTexts, ";" );
		int buttons = tok.countTokens();

		if( buttons )
		{
			Style buttonStyle = new Style( 0.3, 0.1, Frontend.mediumFont, Text.ALIGN_CENTER, new ResourceRef(frontend:0x00D8r) );

			//button = new Button[buttons];
			float step = 2.0/(buttons+1);

			y = 2*(bodyRatio+((1-bodyRatio)/4*3))-1-0.05;
			x=-1;
			for( int i=0; i<buttons; i++ )
			{
				x+=step;
				/*button[i] =*/ osd.createButton( buttonStyle, x, y, tok.nextToken(), i );
			}

			if( escapeCmd < 0 )
				escapeCmd = osd.defSelection;

			osd.orientation = 1;
			osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, escapeCmd, this );
		}

		if( !flags&DF_SILENT )
			new SfxRef( Frontend.SFX_QUESTION ).play(); 
	
		osd.show();
		if( controller )
		{
			css=controller.reset();
			controller.activateState( ControlSet.MENUSET );
		}

		if( !(flags&DF_LEAVEPOINTER) )
			prevPointerState = Input.cursor.enable(1);


		setEventMask( EVENT_CURSOR|EVENT_COMMAND );
	}

	public void hide()
	{
		shown=0;

		clearEventMask( EVENT_ANY );

		if( !(flags&DF_LEAVEPOINTER) )
			Input.cursor.enable(prevPointerState);

		if( controller )
			controller.reset( css );
		
		osd.hide();

		if( backShieldOsd )
		{
			backShieldOsd.hide();
			backShieldOsd = null;
		}

		if( flags&DF_FREEZE )
			System.timeWarp(timewarp);
	}

	public void	osdCommand( int cmd )
	{
		//if( button && cmd < button.length )
		{
			result=cmd;
			notify();
		}
	}

	public int display()
	{
		if( !shown )
			show();	//show(), de csak ha meg nem volt!

		wait();
		hide();
		return result;
	}
		
}


public class YesNoDialog extends TextDialog
{
	public YesNoDialog( Controller ctrl, int myflags, String mytitle, String mybody )
	{
		super( ctrl, myflags, mytitle, "YES;NO", mybody );
		escapeCmd = 1;	//NO
	}

	public YesNoDialog( Controller ctrl, int myflags, String mytitle, String mybody, float size, float aspect )
	{
		super( ctrl, myflags, mytitle, "YES;NO", mybody, size, aspect );
		escapeCmd = 1;	//NO
	}
}

public class NoYesDialog extends TextDialog
{
	public NoYesDialog( Controller ctrl, int myflags, String mytitle, String mybody )
	{
		super( ctrl, myflags, mytitle, "YES;NO", mybody );
		osd.defSelection=1;
	}
	public NoYesDialog( Controller ctrl, int myflags, String mytitle, String mybody, float size, float aspect )
	{
		super( ctrl, myflags, mytitle, "YES;NO", mybody, size, aspect );
		osd.defSelection=1;
	}
}

public class OKCancelDialog extends TextDialog
{
	public OKCancelDialog( Controller ctrl, int myflags, String mytitle, String mybody )
	{
		super( ctrl, myflags, mytitle, "OK;Cancel", mybody );
	}
	public OKCancelDialog( Controller ctrl, int myflags, String mytitle, String mybody, float size, float aspect )
	{
		super( ctrl, myflags, mytitle, "OK;Cancel", mybody, size, aspect );
	}
}

public class WarningDialog extends TextDialog
{
	public WarningDialog( Controller ctrl, int myflags, String mytitle, String mybody )
	{
		super( ctrl, myflags, mytitle, "OK", mybody );
	}
	public WarningDialog( Controller ctrl, int myflags, String mytitle, String mybody, float size, float aspect )
	{
		super( ctrl, myflags, mytitle, "OK", mybody, size, aspect );
	}
}

public class StringRequesterDialog extends OKCancelDialog
{
	String input;

	public StringRequesterDialog( Controller ctrl, int myflags, String mytitle, String init )
	{
		super( ctrl, myflags, mytitle, "OK;Cancel", null );

		input = init;
	}

	public void show()
	{
		Style sty = new Style( 0.75, 0.12, Frontend.mediumFont, Text.ALIGN_CENTER, new ResourceRef(frontend:0x00D8r) );

		osd.createStringInput( sty, 0.0, 0.0, null, 12345, input );

		super.show();
	}

	public void	osdCommand( int cmd )
	{
		if( cmd==12345 )
		{
			input = osd.stringValue;

			if( !((flags&SIF_NOEMPTY) && input.length() == 0) )
			{
				if( !osd.actGadget )		//ha most veszti el a fokuszt
					osdCommand( 0 );	//OK generated
			}
		}
		else
		{
			if( cmd==0 )	//OK de-generated?
			{
				if( ((flags&SIF_NOEMPTY) && input.length() == 0) )
				{
					return;	//nem hagyjuk az ureset!
				}
			}

			super.osdCommand( cmd );
		}
	}
}

public class FileRequesterDialog extends OKCancelDialog
{
	final static int	MAX_ENTRIES = 5;
	final static int	CMD_ENTRIES = 100;

	String		path;
	String		mask;
	Button[]	fileButtons;

	String		fileName;
	Vector		fileNameList = new Vector();
	int			index;

	public FileRequesterDialog( Controller ctrl, int myflags, String mytitle, String OKButtonText, String path, String mask )
	{
		this( ctrl, myflags, mytitle, OKButtonText, path, mask, FindFile.FILES_ONLY );
	}
	public FileRequesterDialog( Controller ctrl, int myflags, String mytitle, String OKButtonText, String path, String mask, int ffFlags )
	{
		super( ctrl, myflags, mytitle, OKButtonText + ";Cancel", null );

		this.path = path;
		this.mask = mask;

		FindFile ff = new FindFile();
		String name=ff.first( path+mask, ffFlags );
		while( name )
		{
			if( validator( path + name ) )
				fileNameList.addElement( name );

			name = ff.next();
		}
		ff.close();
	}

	//--------------------------------------
	public int validator( String filename )
	{
		return 1;
	}
	//--------------------------------------


	public void show()
	{
		Style	sty;
		Menu	m;

		sty = new Style( 0.50, 0.12, Frontend.mediumFont, Text.ALIGN_CENTER, Osd.RRT_NONE/*new ResourceRef(frontend:0x00D8r)*/ );
		m = osd.createMenu( sty, 0.0, -0.55, 0.11 );	//spacing=0.1 ettol kisse egymasralognak, ami vonalazott eredmenyt ad

		fileButtons = new Button[MAX_ENTRIES];

		for( int i=0; i< MAX_ENTRIES; i++ )
		{
			fileButtons[i] = m.addItem( "", CMD_ENTRIES + i );	//fontos az ures string!
		}

		//filenev input mezo
		sty = new Style( 0.50, 0.12, Frontend.mediumFont, Text.ALIGN_CENTER, Osd.RRT_NONE );
		osd.createStringInput( sty, 0.0, 0.54, null, 200, "" );
		osd.createText( "FileName:", Frontend.mediumFont, Text.ALIGN_RIGHT, -0.50, 0.52 );

		//fel scroll gomb
		sty = new Style( 0.10, 0.10, 1.0, Frontend.smallFont, Text.ALIGN_CENTER, new ResourceRef( Osd.RID_ARROWUP ) );
		osd.createButton( sty, 0.55, -0.55, 201, null );

		//le scroll gomb
		sty = new Style( 0.10, 0.10, 1.0, Frontend.smallFont, Text.ALIGN_CENTER, new ResourceRef( Osd.RID_ARROWDN ) );
		osd.createButton( sty, 0.55,  0.25, 202, null );

		setButtonNames();

		super.show();
	}

	public void setButtonNames()
	{
		for( int i=0; i<MAX_ENTRIES; i++ )
			if( fileNameList.size() > index+i )
				fileButtons[i].changeLabelText( fileNameList.elementAt(index+i) );
			else
				fileButtons[i].changeLabelText( null );
	}


	public void	osdCommand( int cmd )
	{
		if( cmd >= CMD_ENTRIES && cmd < CMD_ENTRIES+MAX_ENTRIES )
		{
			cmd -= CMD_ENTRIES;
			fileName = fileButtons[cmd].getLabelText();

			osdCommand(0);
		}
		else
		if( cmd==200 )
		{
			fileName = osd.stringValue;
			if( !osd.actGadget )		//ha most veszti el a fokuszt
			{
				osdCommand( 0 );	//OK generated
			}
		}
		else
		if( cmd==201 )
		{
			if( index )
			{
				index -= MAX_ENTRIES;
				setButtonNames();		
			}
		}
		else
		if( cmd==202 )
		{
			if( index+MAX_ENTRIES < fileNameList.size() )
			{
				index += MAX_ENTRIES;
				setButtonNames();		
			}
		}
		else
		{
			if( cmd == 0 )	//OK ready?
			{
				if( !fileName || fileName.length() == 0 )
					return;	//no filename - eating up OK

				if( !validator( path + fileName ) )
				{
					if( !(flags & FRF_SAVE) )
					{	//egyeb - csak letezo filenevvel engedjuk ki
						new WarningDialog( controller, DF_HIGHPRI|DF_MODAL|DF_DEFAULTBG, title, "File system error." ).display();
						return;
					}
				}
				else
				{
					if( flags & FRF_SAVE )
					{	//save - feluliras megerositest kerunk
						if( new NoYesDialog( controller, DF_HIGHPRI|DF_MODAL|DF_DEFAULTBG, title, "Overwrite existing file?" ).display() )
							return;	//cancel - eating up OK
					}
				}
			}

			super.osdCommand( cmd );
		}
	}
}


public class MenuDialog extends Dialog
{
	String		info;
	String[]	labels;

	public MenuDialog( Controller ctrl, int myFlags, String myTitle, String info, String[] myLabels )
	{
		super( ctrl, myFlags|DF_DARKEN, myTitle, null );
		labels = myLabels;
		this.info = info;
	}

	public void show()
	{
		float	y = -0.5;

		if( info )
		{
			osd.createText( info, Frontend.mediumFont, Text.ALIGN_CENTER, 0.0, y );
			y+=0.2;
		}

		Style butt1 = new Style( 0.45, 0.10, Frontend.mediumFont, Text.ALIGN_CENTER, new ResourceRef(frontend:0x00D8r) );
		Menu m = osd.createMenu( butt1, 0.0, y, 0 );

		for ( int i=0; i<labels.length; i++ )
			m.addItem( labels[i], i+1 );

		m.addSeparator();

		butt1 = new Style( 0.25, 0.12, Frontend.mediumFont, Text.ALIGN_CENTER, new ResourceRef(frontend:0x00D8r) );
		m.setStyle( butt1 );
		m.addItem( "CANCEL", 0 );

		super.show();
	}

	public void	osdCommand( int cmd )
	{
		if( cmd < labels.length+1 )
		{
			result=cmd;
			notify();
		}
	}

}

public class TextDialog extends Dialog
{
	String	text;

	public TextDialog( Controller ctrl, int myFlags, String myTitle, String myButtons, String mybody )
	{
		super( ctrl, myFlags|DF_DARKEN, myTitle, myButtons );
		text=mybody;
	}

	public TextDialog( Controller ctrl, int myFlags, String myTitle, String myButtons, String mybody, float size, float aspect )
	{
		super( ctrl, myFlags|DF_DARKEN, myTitle, myButtons, size, aspect );
		text=mybody;
	}

	public void show()
	{
		if( text )
		{
			float x = -0.85;
			float y = -0.70;
			float width = 1.7;

			osd.createTextBox( text, Frontend.mediumFont, Text.ALIGN_CENTER, x, y, width );
		}
		super.show();
	}
}


//simpleloading, de atkapcsolja a billentyuzetet hogy biztosan menu modban fusson (azaz az enterrel el lehessen nyomni!)
public class CsDialog extends SimpleLoadingDialog
{
	public CsDialog( Controller ctrl, int myflags, ResourceRef background )
	{
		super( myflags|DF_FULLSCREEN, background );
		controller = ctrl;
	}
}


public class CongratsDialog extends Dialog
{
	GameRef	buttonOk;
	int		bgID;

	public CongratsDialog( Controller ctrl, int myflags, int bgID_ )
	{
		super( ctrl, myflags|DF_DARKEN, null, null );
		bgID=bgID_;
	}

	public void show()
	{
		osd.createBG( new ResourceRef(bgID) );

		Style buttonStyle = new Style( 0.45, 0.12, Frontend.mediumFont, Text.ALIGN_RIGHT, new ResourceRef(frontend:0x00D8r) );

		//button = new Button[1];
		/*button[0] =*/ osd.createButton( buttonStyle, 1.0, 0.88, "OK", 0 );
		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, osd.defSelection, this );

		super.show();
	}
}
