package java.game;

import java.io.*;
import java.util.*;
import java.util.resource.*;
import java.render.*;	//Text
import java.render.osd.*;	//Text
import java.render.osd.dialog.*;	//Text
import java.sound.*;
import java.game.parts.*;
import java.game.*;

/********************************************
*			Track Selector v1.1				*
*		By Miran, base on Wichur's script	*
*				XII.2007					*
********************************************/

public class TrackSelect extends Scene implements GameState
{
	final static int  	CMD_BACK	= 0;
	final static int  	CMD_OK		= 1;
	final static int  	CMD_ABOUT	= 2;
	final static int  	CMD_UP		= 3;
	final static int  	CMD_DOWN	= 4;

	final static int	CMD_MAP0  = 10;
	final static int	CMD_MAP1  = 11;
	final static int	CMD_MAP2  = 12;
	final static int	CMD_MAP3  = 13;
	final static int	CMD_MAP4  = 14;
	final static int	CMD_MAP5  = 15;
	final static int	CMD_MAP6  = 16;
	final static int	CMD_MAP7  = 17;
	final static int	CMD_MAP8  = 18;
	final static int	CMD_MAP9  = 19;

// OSD stuff:
	Rectangle CurrentTrackImage;
	Button OkButton, UpButton, DownButton, Map0_Button, Map1_Button, Map2_Button, Map3_Button, Map4_Button, Map5_Button, Map6_Button, Map7_Button, Map8_Button, Map9_Button;
	Style Menu_Button, bsm, Menu_Left, Menu_Right;
	Text CurrentTrackNameText, FoundTrackText, CurrentTrackAuthorText, CurrentPageText;
	TextBox CurrentTrackDescriptionText;
	Menu m;
	GameState prev_state;

	final static int	 Mode, BackGroundVideo, MapsAmount, CurrentPage, CurrentName, CurrentMapNumber, TrackSelected;
	final static String		MapName, MapAuthor, MapDescription;
	final static ResourceRef	MapImage;
	
	Osd				osd;
	GameState		parentState;
	Bot				bot;
	Player			player;
	Vehicle			Vehicle;
	
	public TrackSelect(int mode)
	{
		float key = Math.random()*100;
		if( MainMenu.Check(key) != Math.sqrt(key)+3.75 ) Mirans_Mod_protection_error______Please_Resintal_Mirans_Mod();

		Mode = mode;

		createNativeInstance();

		MapsAmount = GameLogic.MapBox.size();
	}

	public TrackSelect()
	{
		float key = Math.random()*100;
		if( MainMenu.Check(key) != Math.sqrt(key)+3.75 ) Mirans_Mod_protection_error______Please_Resintal_Mirans_Mod();

		Mode = 0;

		createNativeInstance();

		MapsAmount = GameLogic.MapBox.size();
	}

	final static public float Check( float key )
	{
		return Math.sqrt(key)+3.75;
	}

    public void enter( GameState prevState )
    {
		//Frontend.loadingScreen.show();

		osd = new Osd();
		osd.globalHandler = this;

		setEventMask( EVENT_TIME );

		createOSDObjects();
		osd.show();

		Input.cursor.enable(1);
		setEventMask( EVENT_CURSOR );

		if( !parentState )
			parentState=prevState;

		if( !prevState instanceof Garage )
			new SfxRef( GameLogic.SFX_LEAVEGARAGE ).play();

		//Frontend.loadingScreen.display();
	}

	public void exit( GameState nextState )
	{
		//Frontend.loadingScreen.show();

		clearEventMask( EVENT_ANY );
		removeAllTimers();
		Input.cursor.enable(0);

		osd.hide();
		osd.finalize();

		if( !nextState instanceof Garage )
		{
			new SfxRef( GameLogic.SFX_LEAVEGARAGE ).play(); 
		}
		//osd background renderer cleanup
		//if( BackGroundVideo )
			//GfxEngine.closeVideo();

		//Frontend.loadingScreen.display();
	}

	public void createOSDObjects()
	{
	// Create Styles:
		Menu_Button = new Style( 0.12, 0.12, Frontend.mediumFont, Text.ALIGN_CENTER, null );
		bsm = new Style( 0.70, 0.13, Frontend.largeFont, Text.ALIGN_LEFT, Osd.RRT_TEST );
		Menu_Left = new Style( 0.60, 0.13, Frontend.mediumFont, Text.ALIGN_LEFT, Osd.RRT_TEST );
		Menu_Right = new Style( 0.60, 0.13, Frontend.mediumFont, Text.ALIGN_RIGHT, Osd.RRT_TEST );

		osd.createHeader( "TRACK SELECTOR" );
		osd.createBG( new ResourceRef(system:0x0016r) );

		CurrentPageText = osd.createText( "", Frontend.largeFont, Text.ALIGN_LEFT, -0.95, -0.86 ); CurrentPageText.changeColor(0xFFC0C0C0);// "Unselected" gray
		if (MapsAmount > 10)
			CurrentPageText.changeText( "Current Page: " + (CurrentPage+1) ); 

		CurrentTrackNameText = osd.createText( GameLogic.MapBox.elementData[CurrentMapNumber].MapName, Frontend.largeFont, Text.ALIGN_CENTER, 0.55, -0.03 ); CurrentTrackNameText.changeColor(0xFFC0C0C0);// "Unselected" gray
		CurrentTrackAuthorText = osd.createText( GameLogic.MapBox.elementData[CurrentMapNumber].MapAuthor, Frontend.largeFont, Text.ALIGN_CENTER, 0.55, 0.68 ); CurrentTrackAuthorText.changeColor(0xFFC0C0C0);// "Unselected" gray
		FoundTrackText = osd.createText( "Found Maps: " + MapsAmount, Frontend.largeFont, Text.ALIGN_CENTER, 0.0, 0.915 ); FoundTrackText.changeColor(0xFFC0C0C0);// "Unselected" gray
		CurrentTrackImage = osd.createRectangle( 0.52, -0.35, 0.9, 0.6, -1, new ResourceRef(GameLogic.MapBox.elementData[CurrentMapNumber].MapImage) );
		osd.createRectangle( 0.52, -0.35, 0.9, 0.6, -1, new ResourceRef(MW_Mod:0x0162r) );//Text box frame ptx
		osd.createRectangle( 0.52, 0.35, 0.9, 0.6, -1, new ResourceRef(MW_Mod:0x0030r) );//Text box frame ptx
		CurrentTrackDescriptionText = osd.createTextBox( GameLogic.MapBox.elementData[CurrentMapNumber].MapDescription, Frontend.smallFont, Text.ALIGN_CENTER, 0.1, 0.1, 0.85 );

		m = osd.createMenu( Menu_Left, -0.98, 0.95, 0 );
		m.addItem( "BACK", CMD_BACK );
		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL|Osd.HK_STATIC, CMD_BACK, this );// ESC key = CMD_BACK

		m = osd.createMenu( Menu_Right, 0.98, -0.95, 0 );
		m.addItem( "ABOUT", CMD_ABOUT );

		m = osd.createMenu( Menu_Right, 0.98, 0.95, 0 );
		OkButton = m.addItem( "TAKE IT", CMD_OK );
		OkButton.enable();

		if( Mode == 1 )
		{
			OkButton.changeLabelText( "" );
			OkButton.disable();
		}

		// Up/Down Buttons:
		if (MapsAmount > 10)// If more than 10 track found
		{
			m = osd.createMenu( Menu_Button, 0.0, -0.60, 0, Osd.MD_VERTICAL ); 
			UpButton = m.addItem( new ResourceRef( frontend:0x004Cr ), CMD_UP, "Prev Page" );
		
			m = osd.createMenu( Menu_Button, 0.0, 0.60, 0, Osd.MD_VERTICAL );
			DownButton = m.addItem( new ResourceRef( frontend:0x0084r ), CMD_DOWN, "Next Page" );

			if (CurrentPage == 0)
			{
				UpButton.changeTexture( new ResourceRef( frontend:0x00AFr ) ); // Empty.ptx
				UpButton.disable();
			}
	
			CurrentName = CurrentPage*10;
			if (MapsAmount < CurrentName+10)
			{
				DownButton.changeTexture( new ResourceRef(frontend:0x00AFr) ); // Empty.ptx
				DownButton.disable();
			}
		}

		CurrentName = CurrentPage*10;

		m= osd.createMenu( Menu_Left, -0.98, -0.60, 0 );
		if( CurrentName + 0 <= MapsAmount-1 ) Map0_Button = m.addItem(GameLogic.MapBox.elementData[CurrentName + 0].MapName, CMD_MAP0 ); else { Map0_Button = m.addItem( "", CMD_MAP0 ); Map0_Button.disable(); }
		if( CurrentName + 1 <= MapsAmount-1 ) Map1_Button = m.addItem(GameLogic.MapBox.elementData[CurrentName + 1].MapName, CMD_MAP1 ); else { Map1_Button = m.addItem( "", CMD_MAP1 ); Map1_Button.disable(); }
		if( CurrentName + 2 <= MapsAmount-1 ) Map2_Button = m.addItem(GameLogic.MapBox.elementData[CurrentName + 2].MapName, CMD_MAP2 ); else { Map2_Button = m.addItem( "", CMD_MAP2 ); Map2_Button.disable(); }
		if( CurrentName + 3 <= MapsAmount-1 ) Map3_Button = m.addItem(GameLogic.MapBox.elementData[CurrentName + 3].MapName, CMD_MAP3 ); else { Map3_Button = m.addItem( "", CMD_MAP3 ); Map3_Button.disable(); }
		if( CurrentName + 4 <= MapsAmount-1 ) Map4_Button = m.addItem(GameLogic.MapBox.elementData[CurrentName + 4].MapName, CMD_MAP4 ); else { Map4_Button = m.addItem( "", CMD_MAP4 ); Map4_Button.disable(); }
		if( CurrentName + 5 <= MapsAmount-1 ) Map5_Button = m.addItem(GameLogic.MapBox.elementData[CurrentName + 5].MapName, CMD_MAP5 ); else { Map5_Button = m.addItem( "", CMD_MAP5 ); Map5_Button.disable(); }
		if( CurrentName + 6 <= MapsAmount-1 ) Map6_Button = m.addItem(GameLogic.MapBox.elementData[CurrentName + 6].MapName, CMD_MAP6 ); else { Map6_Button = m.addItem( "", CMD_MAP6 ); Map6_Button.disable(); }
		if( CurrentName + 7 <= MapsAmount-1 ) Map7_Button = m.addItem(GameLogic.MapBox.elementData[CurrentName + 7].MapName, CMD_MAP7 ); else { Map7_Button = m.addItem( "", CMD_MAP7 ); Map7_Button.disable(); }
		if( CurrentName + 8 <= MapsAmount-1 ) Map8_Button = m.addItem(GameLogic.MapBox.elementData[CurrentName + 8].MapName, CMD_MAP8 ); else { Map8_Button = m.addItem( "", CMD_MAP8 ); Map8_Button.disable(); }
		if( CurrentName + 9 <= MapsAmount-1 ) Map9_Button = m.addItem(GameLogic.MapBox.elementData[CurrentName + 9].MapName, CMD_MAP9 ); else { Map9_Button = m.addItem( "", CMD_MAP9 ); Map9_Button.disable(); }

		Refresh(); // Set info texts & images
		TrackSelected = 1;
	}

	public void Refresh()
	{
		CurrentTrackNameText.changeText(GameLogic.MapBox.elementData[CurrentMapNumber].MapName);
		CurrentTrackDescriptionText.changeText(GameLogic.MapBox.elementData[CurrentMapNumber].MapDescription); 
		CurrentTrackAuthorText.changeText(GameLogic.MapBox.elementData[CurrentMapNumber].MapAuthor);
		CurrentTrackImage.changeTexture( new ResourceRef(GameLogic.MapBox.elementData[CurrentMapNumber].MapImage));
	
	// Infos for Multi Player etc.
		MapName = GameLogic.MapBox.elementData[CurrentMapNumber].MapName;
		MapDescription = GameLogic.MapBox.elementData[CurrentMapNumber].MapDescription;
		MapAuthor = GameLogic.MapBox.elementData[CurrentMapNumber].MapAuthor;
		MapImage = new ResourceRef(GameLogic.MapBox.elementData[CurrentMapNumber].MapImage);
	}

	public void osdCommand( int cmd )
	{
		if( cmd == CMD_BACK )
		{
			GameLogic.changeActiveSection( parentState );
		}
		else
		if( cmd == CMD_OK )
		{
			if( GameLogic.player.car )
			{
				GameLogic.MapBox.elementData[CurrentMapNumber].StartMap();
				Frontend.loadingScreen.show();
				Thread.sleep( 3000 ); // Wait
				Frontend.loadingScreen.hide();
			}
			else
			{
				new WarningDialog( GameLogic.player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "WARNING", "You need a car to do this! \n Buy a car or get one from the car lot." ).display();
			}
		}
		else
		if( cmd == CMD_ABOUT )
		{
			new WarningDialog( GameLogic.player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG|Dialog.DF_WIDE, "TRACK SELECTOR v1.1", " \n Now Map Addon is easy as Car Addon! \n This Selector looking for addon maps and add it to maps list. \n Amount of new maps isn't limited! \n \n If you want know how create Addon Map take a look at ForModders.rar \n \n By Miran" ).display();
		}
		else
		if( cmd == CMD_UP )
		{
			if (CurrentPage > 0)
				CurrentPage -= 1;
			CurrentName = CurrentPage*10;
			CurrentPageText.changeText( "Current Page: " + (CurrentPage+1) );

			DownButton.changeTexture( new ResourceRef( frontend:0x0084r ) ); // Arrow down
			DownButton.enable();
			
			if (CurrentPage == 0)
			{
				UpButton.changeTexture( new ResourceRef( frontend:0x00AFr ) ); // Empty.ptx
				UpButton.disable();
			}

			if( CurrentName + 0 <= MapsAmount-1 ) { Map0_Button.changeLabelText(GameLogic.MapBox.elementData[CurrentName + 0].MapName); Map0_Button.enable(); } else { Map0_Button.changeLabelText( "" ); Map0_Button.disable(); }
			if( CurrentName + 1 <= MapsAmount-1 ) { Map1_Button.changeLabelText(GameLogic.MapBox.elementData[CurrentName + 1].MapName); Map1_Button.enable(); } else { Map1_Button.changeLabelText( "" ); Map1_Button.disable(); }
			if( CurrentName + 2 <= MapsAmount-1 ) { Map2_Button.changeLabelText(GameLogic.MapBox.elementData[CurrentName + 2].MapName); Map2_Button.enable(); } else { Map2_Button.changeLabelText( "" ); Map2_Button.disable(); }
			if( CurrentName + 3 <= MapsAmount-1 ) { Map3_Button.changeLabelText(GameLogic.MapBox.elementData[CurrentName + 3].MapName); Map3_Button.enable(); } else { Map3_Button.changeLabelText( "" ); Map3_Button.disable(); }
			if( CurrentName + 4 <= MapsAmount-1 ) { Map4_Button.changeLabelText(GameLogic.MapBox.elementData[CurrentName + 4].MapName); Map4_Button.enable(); } else { Map4_Button.changeLabelText( "" ); Map4_Button.disable(); }
			if( CurrentName + 5 <= MapsAmount-1 ) { Map5_Button.changeLabelText(GameLogic.MapBox.elementData[CurrentName + 5].MapName); Map5_Button.enable(); } else { Map5_Button.changeLabelText( "" ); Map5_Button.disable(); }
			if( CurrentName + 6 <= MapsAmount-1 ) { Map6_Button.changeLabelText(GameLogic.MapBox.elementData[CurrentName + 6].MapName); Map6_Button.enable(); } else { Map6_Button.changeLabelText( "" ); Map6_Button.disable(); }
			if( CurrentName + 7 <= MapsAmount-1 ) { Map7_Button.changeLabelText(GameLogic.MapBox.elementData[CurrentName + 7].MapName); Map7_Button.enable(); } else { Map7_Button.changeLabelText( "" ); Map7_Button.disable(); }
			if( CurrentName + 8 <= MapsAmount-1 ) { Map8_Button.changeLabelText(GameLogic.MapBox.elementData[CurrentName + 8].MapName); Map8_Button.enable(); } else { Map8_Button.changeLabelText( "" ); Map8_Button.disable(); }
			if( CurrentName + 9 <= MapsAmount-1 ) { Map9_Button.changeLabelText(GameLogic.MapBox.elementData[CurrentName + 9].MapName); Map9_Button.enable(); } else { Map9_Button.changeLabelText( "" ); Map9_Button.disable(); }
		}
		else
		if( cmd == CMD_DOWN )
		{
			if (MapsAmount >= CurrentName+10)
				CurrentPage += 1;
			CurrentName = CurrentPage*10;
			CurrentPageText.changeText( "Current Page: " + (CurrentPage+1) );

			UpButton.changeTexture( new ResourceRef(frontend:0x004Cr) ); // Arrow up
			UpButton.enable();

			if (MapsAmount < CurrentName+10)
			{
				DownButton.changeTexture( new ResourceRef(frontend:0x00AFr) ); // Empty.ptx
				DownButton.disable();
			}

			if( CurrentName + 0 <= MapsAmount-1 ) { Map0_Button.changeLabelText(GameLogic.MapBox.elementData[CurrentName + 0].MapName); Map0_Button.enable(); } else { Map0_Button.changeLabelText( "" ); Map0_Button.disable(); }
			if( CurrentName + 1 <= MapsAmount-1 ) { Map1_Button.changeLabelText(GameLogic.MapBox.elementData[CurrentName + 1].MapName); Map1_Button.enable(); } else { Map1_Button.changeLabelText( "" ); Map1_Button.disable(); }
			if( CurrentName + 2 <= MapsAmount-1 ) { Map2_Button.changeLabelText(GameLogic.MapBox.elementData[CurrentName + 2].MapName); Map2_Button.enable(); } else { Map2_Button.changeLabelText( "" ); Map2_Button.disable(); }
			if( CurrentName + 3 <= MapsAmount-1 ) { Map3_Button.changeLabelText(GameLogic.MapBox.elementData[CurrentName + 3].MapName); Map3_Button.enable(); } else { Map3_Button.changeLabelText( "" ); Map3_Button.disable(); }
			if( CurrentName + 4 <= MapsAmount-1 ) { Map4_Button.changeLabelText(GameLogic.MapBox.elementData[CurrentName + 4].MapName); Map4_Button.enable(); } else { Map4_Button.changeLabelText( "" ); Map4_Button.disable(); }
			if( CurrentName + 5 <= MapsAmount-1 ) { Map5_Button.changeLabelText(GameLogic.MapBox.elementData[CurrentName + 5].MapName); Map5_Button.enable(); } else { Map5_Button.changeLabelText( "" ); Map5_Button.disable(); }
			if( CurrentName + 6 <= MapsAmount-1 ) { Map6_Button.changeLabelText(GameLogic.MapBox.elementData[CurrentName + 6].MapName); Map6_Button.enable(); } else { Map6_Button.changeLabelText( "" ); Map6_Button.disable(); }
			if( CurrentName + 7 <= MapsAmount-1 ) { Map7_Button.changeLabelText(GameLogic.MapBox.elementData[CurrentName + 7].MapName); Map7_Button.enable(); } else { Map7_Button.changeLabelText( "" ); Map7_Button.disable(); }
			if( CurrentName + 8 <= MapsAmount-1 ) { Map8_Button.changeLabelText(GameLogic.MapBox.elementData[CurrentName + 8].MapName); Map8_Button.enable(); } else { Map8_Button.changeLabelText( "" ); Map8_Button.disable(); }
			if( CurrentName + 9 <= MapsAmount-1 ) { Map9_Button.changeLabelText(GameLogic.MapBox.elementData[CurrentName + 9].MapName); Map9_Button.enable(); } else { Map9_Button.changeLabelText( "" ); Map9_Button.disable(); }
		}
		else
		if( cmd == CMD_MAP0 )
		{
			CurrentMapNumber = CurrentName + 0;
			Refresh();
		}
		else
		if( cmd == CMD_MAP1 )
		{	
			CurrentMapNumber = CurrentName + 1;
			Refresh();
		}
		else
		if( cmd == CMD_MAP2 )
		{	
			CurrentMapNumber = CurrentName + 2;
			Refresh();
		}
		else
		if( cmd == CMD_MAP3 )
		{
			CurrentMapNumber = CurrentName + 3;
			Refresh();
		}
		else
		if( cmd == CMD_MAP4 )
		{
			CurrentMapNumber = CurrentName + 4;
			Refresh();
		}
		else
		if( cmd == CMD_MAP5 )
		{
			CurrentMapNumber = CurrentName + 5;
			Refresh();
		}
		else
		if( cmd == CMD_MAP6 )
		{
			CurrentMapNumber = CurrentName + 6;
			Refresh();
		}
		else
		if( cmd == CMD_MAP7 )
		{
			CurrentMapNumber = CurrentName + 7;
			Refresh();
		}
		else
		if( cmd == CMD_MAP8 )
		{
			CurrentMapNumber = CurrentName + 8;
			Refresh();
		}
		else
		if( cmd == CMD_MAP9 )
		{
			CurrentMapNumber = CurrentName + 9;
			Refresh();
		}
	}

	public void show()
	{
		super.show();
		osd.show();
	}

	public void hide()
	{
		osd.hide();
		super.hide();
	}
}