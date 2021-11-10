package java.render;

import java.render.osd.*;
import java.io.*;
import java.util.*;
import java.util.resource.*;

//called Osd but it's more and more like a Window
public class Osd extends GameType
{
	//design related constants
	final static int COLOR_UNSELECTED = 0xFFFFFFFF;
	final static int COLOR_SELECTED   = 0xFFFB9A12;
	final static int COLOR_DISABLED   = 0x752C2C2C;
	final static int COLOR_PRESSED	  = 0xFF2C2C2C;

	final static int  RID_SLD_BACK = frontend:0x0089r;
	final static int  RID_SLD_KNOB = frontend:0x0091r;

	final static int  RID_ARROWUP = frontend:0x004Cr;
	final static int  RID_ARROWDN = frontend:0x0084r;
	final static int  RID_ARROWLF = frontend:0x0085r;
	final static int  RID_ARROWRG = frontend:0x0088r;

	final static int  RID_OK = frontend:0x0010r;
	final static int  RID_CANCEL = frontend:0x001Dr;
	final static int  RID_BACK = frontend:0x0126r;
	final static int  RID_EXIT = frontend:0x0135r;

	final static ResourceRef RRT_HEADERBG = new ResourceRef(frontend:0x0028r);

	final static ResourceRef	RRT_TOOLTIP = new ResourceRef(frontend:0x00CBr);
	
	//internal constants

	final static int HL_LABELCOLOR	  = 0x00000001;
	final static int HL_BACKLIGHT	  = 0x00000002;

	final static int MD_VERTICAL	= 0;
	final static int MD_HORIZONTAL = 1;


	final static int RID_GHOSTBUTTON	= frontend:0x00000038r;

	final static ResourceRef RRT_NONE = new ResourceRef(frontend:0x00000018r);	//atlatszo textura, mesh-t se renderelunk ha ezt kapja
	final static ResourceRef RRT_EMPTY = new ResourceRef(frontend:0x00AFr);		//default ures atlatszo textura
	final static ResourceRef RRT_DARKEN = new ResourceRef(frontend:0x00A2r);	//sotetito textura

	final static ResourceRef RRT_TEST = RRT_NONE;
	//final static ResourceRef RRT_TEST = new ResourceRef(frontend:0x00D8r);

	final static int HK_STATIC   = 0x04;
	final static int PRIVATEEVENT = 0x80000000;

	final static int CMD_MENU_INC = 0x00010000;
	final static int CMD_MENU_DEC = 0x00020000;
	final static int CMD_MENU_UP =	0x00030000;
	final static int CMD_MENU_DN =	0x00040000;
	final static int CMD_MENU_LF =	0x00050000;
	final static int CMD_MENU_RG =	0x00060000;
	final static int CMD_MENU_SEL=	0x00070000;


	final static float CAM_AOV = 60;		//osd camera latoszoge 
	final static float CAM_OFFSET = 5.48;	//pozicioja (vpHeight foggo!)
	final static float SCALE_FS = 1.47;	//1x1m mesh fullscreen scale faktora (y) (FS = 2.0 width!)
	final static float SCALE_3D = 1.469;	//a (-1;1) FS tartomanynak a 3Ds ter Z=0 FS sikrakepezesehez

	//egyelore csak a click()-re hat, bovitendo!
	final static int OF_MODAL = 0x00000001;
	int				flags;

	ParticleSystem	psPress, psMove;

	Viewport		vp;

	Camera			cam;

	float			screenAspect;
	float			vpAspect, vpWidth, vpHeight, vpTop, vpLeft;
	int				orientation, menuKeysCreated;

	MessagePort		alienMp;	//egyelore csak hotkeyhez!

	Object			globalHandler;	//egyelore csak uj buttonokhoz!
					//for osdCommand(x);


	final static int IL_NONE = 0;
	final static int IL_TIPS = 1;
	final static int IL_KEYS = 2;
	final static int IL_MENU = 3;

	//level of interactiveness: 0-no; 1-hotkeys only; 2-hotkeys and menus 
	int iLevel=IL_MENU;	//egyelore csak hideolt allapotban szabad kivulrol allitani, nem onmukodo (meg)!

	float			lastUserActivityTimeStamp;
	int				focusTracker;

	int				controlCount;	//for un-running keys
	int				prevKey;
	int				prevKeyCount;

	float			sliderValue;	//return value patch for slider gadgets
	int				multiValue;		//return value patch for multichoice gadgets
	String			stringValue;	//return value patch for stringinput gadgets

	GameRef			dropObject;		//amit a gadgetre rahajitottak
	//or
	Gadget			dropGadget;		//amit a gadgetre rahajitottak

	//vektorra cserelendo, habar a nagyja mar megvan..
	GameRef[]		button = new GameRef[100];
	Object[]		buttonHandler = new Object[100];
	int[]			buttonCommand = new int[100];
	int[]			textIndex = new int[100];
	String[]		description = new String[100];
	int				buttons=0;

	Vector			text = new Vector();
	Vector			textbox = new Vector();
	Vector			groups = new Vector();
	Vector			hotkey = new Vector();	//for osd-global hotkeys
	Vector			object = new Vector();
	Vector			rectangles = new Vector();

	int				init=1;
	int				defSelection = 0;
	Gadget			pointedGadget;			//amire mutatunk, vagy allunk a billentyukkel
	//Vector3			pointedGadgetpos;	//for text shaking
	Group			pointedGadgetGroup;
	int				activeCommand = 0;
	int				selectionMoved = 0;
	int				selected = 1;

	int				clickLock;
	Gadget			actDown;				//az epp lenyomva tartott gadget
	Gadget			actGadget;				//az epp mukodo gadget (slider csuszik, stringinput, etc)

	int				controlMode;			//0:mouse; 1:keyboard
	Gadget			lastPointedGadget;		//itt jegyezzuk meg az utoljara kijelolt gadgetet
											//akkor kell, ha billentyus kontrollra valtunk

	Text			tooltipText;
	Rectangle		tooltipRect;

	Text			textInput;
	String			textInputString;


	//def fullscreen viewportot fog hasznalni
	public Osd()
	{
		this( 1.0, 0.0, 10 );
	}

	public Osd( float size, float aspect, int pri )
	{
		this( new Viewport( pri, 0.5, 0.5, size, aspect, -0.5, -0.5 ) );
	}

	public Osd( float size, float aspect, float cx, float cy, float refx, float refy, int pri )
	{
		this( new Viewport( pri, cx, cy, size, aspect, refx, refy ) );
	}


	private Osd( Viewport viewport )
	{
		createNativeInstance();

		vp = viewport;

		setFlags( WORLDTREEROOT );

		vpWidth=vp.getWidth();
		vpHeight=vp.getHeight();
		vpAspect=vp.getAspect();
		vpTop=vp.getTop();
		vpLeft=vp.getLeft();

		screenAspect = (Config.video_x*vpWidth)/(1.0*Config.video_y*vpHeight);

		//create default group
		groups.addElement( new Group(this) );
	}

	public void finalize()
	{
		//hide();	->emiatt megfagy ALTF4-es kilepeskor,
		//mivel eloszor megszunit az inputqueue ->lehet h a statikuskent letrejott instanceokat a vegere kellene hagyni?
		//talan most mar jo lenne

		//groups.removeAllElements();	//a destroyt a rootokra a kozos root vegzi el, amit a super.finalize intez!
		for( int i=groups.size()-1; i>=0; i-- )
			groups.elementAt(i).deactivate();

		while( !hotkey.isEmpty() )
		{
			Hotkey hk =  hotkey.removeLastElement();
			hk.inactivate();
		}

		vp.destroy();

		super.finalize();
	}

	public void rebuild()
	{
		int hidden = (cam == null);

		if( !hidden )
			hide();

		vp.destroy();
		vp = new Viewport( 10, vpTop, vpLeft, vpWidth, vpHeight );

		vpAspect=vp.getAspect();

		//text, textbox, gadget.label.txt....
		//Text tartson nyilvan egy listat?
		//hash tabla kell hogy legyen, kulonben q lassu lesz!!
		//oooo, mir nem skalazhatoak a fontjaink!!!!!????!!!


		if( !hidden )
			show();
	}

	public Viewport getViewport()
	{
		return vp;
	}

	//altalanositas szukseges!!
	//barmalyik gadget [ amelyik implemental ilyen 'mousemapper' interfacet (x0, x1, y0, y1 ) ]
	//kerhet hookot az eger mozgasara akar sima, akar clickelt allapotban
	//ezalatt eventeket kell kapjon az eger poziciojarol, ha az valtozik (mar mappelve!)
	public float mapClickPosH( Vector3 cv, float x0, float x1 )
	{
		cv.x = (cv.x - (vpLeft + vpLeft + vpWidth - 1.0)) / vpWidth;
		cv.y = (cv.y - (vpTop + vpTop + vpHeight - 1.0)) / vpHeight;

		if (cv.x < x0)
			cv.x = x0;
		if (cv.x > x1)
			cv.x = x1;

		return (cv.x - x0) / (x1-x0);
	}

	public int idleFor( float sec )
	{
		//nem tudjuk, mikor jon le rola/m,egy ra a focus :(
		if( focusTracker )
		{
			if( isFocused() )
				return ( lastUserActivityTimeStamp+sec < System.currentTime() );
			else
				focusTracker = 0;
		}
		else
		{
			if( isFocused() )
			{
				lastUserActivityTimeStamp = System.currentTime();
				focusTracker = 1;
			}
		}

		return 0;
	}

	public float getIdleTime()
	{
		return 	System.currentTime() - lastUserActivityTimeStamp;
	}

	public void setIdleTime(float sec)
	{
		lastUserActivityTimeStamp = System.currentTime() - sec;
	}



	public void deactivateText()
	{
		if( pointedGadget )
		{
			//restore shaking texts
			//Text text = pointedGadget.getLabel();
			//if (text)
			//	text.setPos(pointedGadgetpos.x, pointedGadgetpos.y);

			pointedGadget.unfocus();
			pointedGadget = null;
			//pointedGadgetpos = null;

			if( tooltipText )
			{
				tooltipText.changeText( null );
				tooltipText = null;

				tooltipRect.finalize();
				tooltipRect = null;
			}
		}
	}

	public void activateText(Group grp, Gadget g)
	{
		if( g )
		{
			lastUserActivityTimeStamp = System.currentTime();

			pointedGadget = g;
			lastPointedGadget = g;
			pointedGadgetGroup = grp;
			activeCommand = g.cmd;

			//for text shaking
			//Text text = pointedGadget.getLabel();
			//if (text)
			//	pointedGadgetpos = text.getPos();

			g.focus();

			//visszamentek egy eredetileg lenyomottra, amirol eljottek, de kozben nyomva tartottak
			if( actDown == pointedGadget )
			{
				pointedGadget.press();
			}
		}
	}

	public void changeSelection2( int direction, int playsnd )
	{
		Group	grp, newgrp;
		Gadget	gad, newgad;
		int		grpIndex, index;

		//init
		if( direction == -1 )
			controlMode = 1;		//billentyus kontroll ON!

		if( !pointedGadget || direction == -1 )
		{
			for( grpIndex=0; grpIndex<groups.size(); grpIndex++ )
			{
				grp = groups.elementAt(grpIndex);

				if( grp.active )
				{
					for( index=0; index<grp.gadget.size(); index++ )
					{
						gad = grp.gadget.elementAt(index);

						if( !(gad.disabled || gad.nofocus) )
						{
							newgad=gad;
							newgrp=grp;
							break;
						}

						gad = grp.gadget.elementAt(index);
					}
				}

				if( newgad )
					break;
			}
		}
		else
		{
			Vector3 cur = pointedGadget.getHotSpot();

			float	d=100000;
			float	t;

			for( grpIndex=0; grpIndex<groups.size(); grpIndex++ )
			{
				grp = groups.elementAt(grpIndex);

				if( grp.active )
				{
					for( index=0; index<grp.gadget.size(); index++ )
					{
						gad = grp.gadget.elementAt(index);

						if( !(gad.disabled || gad.nofocus) && gad!=pointedGadget )
						{
							Vector3 pos = gad.getHotSpot();
							pos.sub( cur );
							
							//fol/le/bal/jobb
							if( direction == 0 && pos.y > 0 && (t=pos.x*pos.x+pos.y*pos.y*0.4) < d ||
								direction == 1 && pos.y < 0 && (t=pos.x*pos.x+pos.y*pos.y*0.4) < d ||
								direction == 2 && pos.x < 0 && (t=pos.x*pos.x*0.14+pos.y*pos.y) < d ||
								direction == 3 && pos.x > 0 && (t=pos.x*pos.x*0.14+pos.y*pos.y) < d 	)
							{
								d=t;
								newgad=gad;
								newgrp=grp;
							}
						}
					}
				}
			}
		}

		if( newgad )
		{
			deactivateText();
			activateText( newgrp, newgad );
			if( playsnd )
			{
				new SfxRef( Frontend.SFX_MENU_MOVE ).play();
			}
		}
	}

	public void changeSelection( int relMove, int playsnd )
	{
		Group	grp = pointedGadgetGroup;
		Gadget	gad = pointedGadget;
		int		grpIndex, index;
		int		fail, valid, grpChange, grpChange2;

		if( grp )
		{
			grpIndex = groups.indexOf( grp );
	
			if( gad )
				index = grp.gadget.indexOf( gad );	//else 0
		}
		else
		{
			grp=groups.elementAt(grpIndex);	//0
			pointedGadgetGroup = grp;
		}

		index += relMove;

		int		dir;
		if( relMove < 0 )
			dir=-1;
		else
			dir=1;

		while( !fail && !valid )
		{
			if( index < 0 || index >= grp.gadget.size() || !grp.active )
			{
				grpChange2 = 1;
			}
			else
			{
				if( grp.gadget.elementAt( index ).disabled || grp.gadget.elementAt( index ).nofocus )
				{
					index += dir;
					continue;
				}
				else
					valid = 1;
			}

			while( (grpChange2 || !grp.active) && !fail )
			{
				grpIndex+=dir;
				if( grpIndex < 0 )
					grpIndex = groups.size()-1;
				else
				if( grpIndex >= groups.size() )
					grpIndex = 0;

				grp=groups.elementAt(grpIndex);

				if( grp == pointedGadgetGroup )	//ezen kezdtuk, visszaertunk
					fail = 1;

				grpChange = 1;
				grpChange2 = 0;
			}

			if( grpChange )
			{
				if( dir < 0 )
					index = grp.gadget.size()-1;
				else
					index = 0;

				grpChange = 0;
			}

		}

		if( !fail )
		{
			gad = grp.gadget.elementAt( index );

			deactivateText();
			activateText( grp, gad );
			if( playsnd )
			{
				new SfxRef( Frontend.SFX_MENU_MOVE ).play();
			}
		}
	}
	

	public void animate()
	{
		//tooltip handling
		if( pointedGadget && !controlMode && pointedGadget.tooltip && !tooltipText && idleFor(1) )
		{
			Vector3 cv = Input.cursor.getPos();

			float	fontYCorrection = 0.4;
			float	aspect = Input.cursor.vp.getAspect();

			float	h = Text.getHeight( Frontend.smallFont, Input.cursor.vp );
			float	w = Text.getWidth(pointedGadget.tooltip, Frontend.smallFont, Input.cursor.vp);
			float	border = h*0.6;

			h+=border;
			w+=border;

			cv.x+=w*0.5+0.05;
			cv.y+=h*0.5+0.1;

			float right = cv.x + 0.5*w;
			if( right > 1.0 )
				cv.x-=right - 1.0;

			float bottom = cv.y + 0.5*h;
			if( bottom > 1.0 )
				cv.y-=bottom - 1.0;

			tooltipText = new Text( Input.cursor, Frontend.smallFont, pointedGadget.tooltip, cv.x, cv.y-fontYCorrection*h );
			tooltipText.changeAlign( Text.ALIGN_CENTER );

			cv.x *= Osd.SCALE_3D*aspect;
			cv.y *= -Osd.SCALE_3D;

			tooltipRect = new Rectangle( Input.cursor, cv, new RectangleTemplate( w*Osd.SCALE_FS*aspect, h*Osd.SCALE_FS, RRT_TOOLTIP ) );
		}

		if( !isFocused() )
			deactivateText();


		if( Frontend.inputQueue.lastElement() == this )
		{
			controlCount++;

			int lastKey = Input.lastKey();
			
			if( controlMode && idleFor( 10 ) )
			{
				deactivateText();
				controlMode = 0;	//billentyus kontroll AUTO OFF!
			}

			//text shaking
			//if ( pointedGadget && pointedGadgetpos)
			//{
			//	Text text = pointedGadget.getLabel();
			//	if (text)
			//		text.setPos(pointedGadgetpos.x-0.01f+Math.random()*0.02f, pointedGadgetpos.y-0.01f+Math.random()*0.02f);
			//
			//	if (actDown == pointedGadget)
			//		pressEffect();
			//}

			if( lastKey )
			{
				int runningKey;
				if( prevKey==lastKey && prevKeyCount+1==controlCount)
					runningKey=1;
				
				prevKeyCount=controlCount;
				prevKey=lastKey;

				/* nativ szinten implementalva!!
				else
				//hotkey kezeles
				if( !hotkey.isEmpty() )
				{
					Hotkey hk;
					for( int i = hotkey.size()-1; i >= 0 ; i-- )
					{
						hk = hotkey.elementAt(i);
						if( ( lastKey & 0xFF ) == hk.key )
						{
							Integer wrapper = groupStates.elementAt(hk.group);
							if( wrapper.intValue() == 1 )
							{	//in active group!
								hk.handler.osdCommand( hk.command );
								break;
							}
						}
					}
				}
				*/
			}

			//slider handling
			//if( pointedGadget )
			//{
				if( pointedGadget instanceof Slider )
				{
					if( pointedGadget.pressed )
					{
						Slider sl = (Slider)pointedGadget;

						Vector3 cv = Input.cursor.getPos();
						float value = mapClickPosH( cv, sl.x0, sl.x1 ) * (sl.b - sl.a) + sl.a;						

						if( value != sl.value )
						{
							lastUserActivityTimeStamp = System.currentTime();

							sl.setValue( value );
							sl.sendMessage();
						}
					}
			//	}
			}

			//string input handling
			if( actGadget )
			{
				if( actGadget instanceof StringInput )
				{
					int ascii = lastKey >> 16;
					if( ascii > 0 )
					{
						lastUserActivityTimeStamp = System.currentTime();

						if( actGadget.key( ascii ) )
						{
							new SfxRef( Frontend.SFX_MENU_SELECT ).play();
						}
					}
				}

			}
		}
	}

	public void handleEvent( Hotkey hk )
	{
		lastUserActivityTimeStamp = System.currentTime();

		if( hk.command & PRIVATEEVENT )
		{
			int command = hk.command&~PRIVATEEVENT;

			if( Frontend.inputQueue.lastElement() == this && iLevel >= IL_MENU )
			{
				if( !actGadget )//csak ha nincs stringinput, etc hiperaktiv gadget!
				{
					if( !controlMode && (command == CMD_MENU_UP || command == CMD_MENU_DN || command == CMD_MENU_LF || command == CMD_MENU_RG || command == CMD_MENU_SEL) && lastPointedGadget && !pointedGadget )
					{
						activateText( pointedGadgetGroup, lastPointedGadget );
						controlMode = 1;	//billentyus kontroll ON!
					}
					else
					{
						if( !controlMode )
							controlMode = 1;	//billentyus kontroll ON!

						if( command == CMD_MENU_UP )
						{
							changeSelection2( 0, 1 );
						}
						else
						if( command == CMD_MENU_DN )
						{
							changeSelection2( 1, 1 );
						}
						else
						if( command == CMD_MENU_LF )
						{
							changeSelection2( 2, 1 );
						}
						else
						if( command == CMD_MENU_RG )
						{
							changeSelection2( 3, 1 );
						}
						else 
						if( command == CMD_MENU_SEL )
						{
							if( pointedGadget && !pointedGadget.disabled )
							{
								if( hk.state )
								{	//lenyomas
									new SfxRef( Frontend.SFX_MENU_SELECT ).play(); 
									pointedGadget.press();	//ENTER KEY -> press
									actDown = pointedGadget;
								}
								else
								{	//felengedes
									if( actDown == pointedGadget )
									{
										pointedGadget.release();
										pointedGadget.click();	//ENTER KEY
									}
									actDown = null;
								}
							}
						}
						else 
						if( command == CMD_MENU_INC )
						{
							if( pointedGadget )
							{
								pointedGadget.increase();
							}
						}
						else 
						if( command == CMD_MENU_DEC )
						{
							if( pointedGadget )
							{
								pointedGadget.decrease();
							}
						}
					}
				}
			}
		}
		else
		{
			if( hk.handler )
				hk.handler.osdCommand( hk.command );
			else
				if( alienMp )
				{
					alienMp.putMessage( new Event( hk.command, hk.state ));
				}
		}
	}

	//old kiirtando:
	public void event_handler(GameRef obj_ref, int event, String param)
	{
		int	ec = param.token(0).intValue();

		if (ec == GameType.EC_LCLICK)
		{
			int i=button.length;
			while( i-- )
			{
				if( button[i] )
					if( button[i].id() == obj_ref.id() )
					{
						buttonHandler[i].osdCommand(buttonCommand[i]);
						break;
					}
			}
		}
	}

	//for compatibility:
	public void show()
	{
		show(1);
	}

	public void hide()
	{
		hide(1);
	}


	public void show( int full )
	{
		if( init )
		{
			init=0;
			resetSelection();		//kivillantjuk a megfelelo gombot
									//at lehetne alakitani, hogy csak billentyus modban tegye!
			controlMode = 1;		//billentyus kontroll ON!
		}
		else
		{
			changeSelection2( -1, 0 );
		}

		lastUserActivityTimeStamp = System.currentTime();

			cam = new Camera( this, vp, 2, CAM_AOV, 0.1, 10.0 );
			cam.setMatrix( new Vector3(0.0, 0.0, CAM_OFFSET*vpHeight), null );

		if( full )
		{
			vp.activate( Viewport.RENDERFLAG_CLEARDEPTH | Viewport.RENDERFLAG_CLEARTARGET );

			if( iLevel > IL_NONE )
			{
				enableControl();
			}

		}

		if( iLevel >= IL_MENU )
			if( !menuKeysCreated )
				createMenuKeys();
	}

	public void hide( int full )
	{
		deactivateText();

		if( full )
		{
			if( iLevel > IL_NONE )
				disableControl();

			vp.deactivate();
		}

		if( cam )
		{	
			cam.destroy();	//stop rendering right now
			cam = null;		//wait for gc to collect
		}
	}

	public void enableControl( )
	{
		setEventMask( EVENT_CURSOR|EVENT_HOTKEY );
		enableAnimateHook();

		if( iLevel > IL_TIPS )
			setFocus(1);
	}

	public void disableControl()
	{
		if( iLevel > IL_TIPS )
			setFocus(0);

		disableAnimateHook();
		clearEventMask( EVENT_ANY );
	}

	//ha valaki allitgatni akarja 1 gadget erteket, de nem tarolta el:
	public Gadget findGadget( Object h, int cmd )
	{
		int ng = groups.size();
		while( ng-- )
		{
			Group grp = groups.elementAt( ng );
			
			int n=grp.gadget.size();
			Gadget g;

			while( n-- )
			{
				g = grp.gadget.elementAt(n);
				if( g.handler == h && g.cmd == cmd )
				{
					//lehet tobb ilyen is, csak az utolsot adjuk vissza!
					return g;
				}
			}
		}
		return null;
	}


	//pri: higher overlaps lower
	public Vector3 convertTextCoordinates( float x, float y, int pri )
	{
		return new Vector3( x*SCALE_3D*vpAspect*vpWidth, -y*SCALE_3D*vpHeight, pri/1000.0 );
	}

	public void addHook( GameRef obj, GameRef handler )
	{
		addHook( obj, handler, null );
	}

	public void addHook( GameRef obj, GameRef handler, String handlerName )
	{
		handler.addNotification( obj, GameType.EVENT_CURSOR, GameType.EVENT_SAME, null, "event_handler" + handlerName );
	}

	//osd builder methods:
	public Menu createMenu( Style s, float x, float y, float spc, int ori )
	{
		return new Menu( this, s, x, y, spc, ori );
	}

	public Menu createMenu( Style s, float x, float y, float spc )
	{
		return new Menu( this, s, x, y, spc );
	}

	public Menu createMenu( Style s, float x, float y, float spc, Style ss, Style sks )
	{
		Menu m = new Menu( this, s, x, y, spc );
		m.setSliderStyle( ss, sks );
		return m;
	}

	public Text createHeader( String title )
	{
		if( RRT_HEADERBG )
			createRectangle( 0.0, -0.95, 2.0, 0.1, -1, RRT_HEADERBG );

		Text txt = createText( title, Frontend.largeFont, Text.ALIGN_LEFT,	-0.95, -0.98 );
		return txt;
	}


	public Rectangle createBG( ResourceRef texture )
	{
		return createRectangle( 0, 0, 2, 2, -2, texture );
	}

	//viewport aspectusu rectangles:
	public Rectangle createRectangle( float x, float y, float w, float h, int pri, ResourceRef texture )
	{
		Group	group = groups.lastElement();

		Vector3 pos = convertTextCoordinates( x, y, pri );

		Rectangle rect =  new Rectangle( group, pos, new RectangleTemplate( w*Osd.SCALE_FS*vpAspect*vpWidth, h*Osd.SCALE_FS*vpHeight, texture ) );
		rectangles.addElement( rect );
		return rect;
	}

	//adott aspect
	public Rectangle createRectangle( float x, float y, float w, float h, float aspect, float dx, float dy, int pri, ResourceRef texture )
	{
		Group	group = groups.lastElement();

		x += dx*w*aspect/vpAspect;
		y += dy*h;

		Vector3 pos = convertTextCoordinates( x, y, pri );

		Rectangle rect =  new Rectangle( group, pos, new RectangleTemplate( w*Osd.SCALE_FS*aspect*vpWidth, h*Osd.SCALE_FS*vpHeight, texture ) );
		rectangles.addElement( rect );
		return rect;
	}


	public RenderRef createObject( int rid, float x, float y, int pri )
	{
		Vector3	pos = convertTextCoordinates( x, y, pri );
		return createObject( rid, pos );
	}

	public RenderRef createObject( int rid, float x, float y )
	{
		return createObject( rid, x, y, 0 );
	}

	public RenderRef createObject( int rid, Vector3 pos )
	{
		return createObject( rid, pos, null );
	}

	public RenderRef createObject( int rid, Vector3 pos, Ypr ori )
	{
		GameRef	cast = groups.lastElement();

		RenderRef	obj = new RenderRef( cast, rid, null );
		obj.setMatrix( pos, ori );
		object.addElement( obj );
		return obj;
	}

	//+sor
	public Text createText( String string, ResourceRef charset, int align, float x, float y, int line )
	{
		Group group = groups.lastElement();

		Text txt = new Text( group, charset, string, x, y, line, vp );
		txt.changeAlign( align );
		text.addElement( txt );
		return txt;
	}

	public Text createText( String string, ResourceRef charset, int align, float x, float y )
	{
		return createText( string, charset, align, x, y, 0 );
	}

	public TextBox createTextBox( String string, ResourceRef charset, int align, float x, float y, float width )
	{
		return createTextBox( string, charset, align, x, y, width, null );
	}

	public TextBox createTextBox( String string, ResourceRef charset, int align, float x, float y, float width, ResourceRef bg )
	{
		Group group = groups.lastElement();

		TextBox tb = new TextBox( group, charset, vp, align, string, x, y, width, bg );
		textbox.addElement( tb );
		return tb;
	}

	public TextBox createTextBox( String string, ResourceRef charset, int align, float x, float y, float width, ResourceRef bg, int maxLines )
	{
		Group group = groups.lastElement();

		TextBox tb = new TextBox( group, charset, vp, align, string, x, y, width, bg, maxLines );
		textbox.addElement( tb );
		return tb;
	}

	//uj gadget interface:

	//icon gombokhoz:
	public Button createButton( Style sty, float x, float y, int command, String tooltip )
	{
		Button b = createButton( sty, x, y, 0, null, command );
		b.setToolTip( tooltip );
		b.highliteMethod=HL_BACKLIGHT;
		return b;
	}

	//szoveges gombokhoz:
	public Button createButton( Style sty, float x, float y, String string, int command )
	{
		return createButton( sty, x, y, 0, string, command );
	}

	public Button createButton( Style sty, float x, float y, int pri, String string, int command )
	{
		Group g = groups.lastElement();

		float width = (sty.width/2)*sty.aspect*sty.aspect/vpAspect;

		float ax;
		if( sty.align == Text.ALIGN_LEFT )
			ax = x+width;
		else
		if( sty.align == Text.ALIGN_RIGHT )
			ax = x-width;
		else
			ax=x;

		Vector3 pos = convertTextCoordinates( ax, y, pri );

		Rectangle rect;

		if( sty.rt )
			rect =  new Rectangle( g, pos, sty.rt );

		PhysicsRef phy = new PhysicsRef();
		phy.createBox( g, sty.rWidth, sty.rHeight, 0.001, string );	//string used here just for debugging
		phy.setMatrix( pos, null );

		Button btn = new Button( this, rect, phy, command, globalHandler );
		g.gadget.addElement( btn );

		if( string )	//create label if exists
		{
			//igazitas; 0.1-el dolgozunk, hogy ne erjen hozza pont a szelehez!
			if( sty.align == Text.ALIGN_LEFT )
				x+=sty.width*0.1;
			else
			if( sty.align == Text.ALIGN_RIGHT )
				x-=sty.width*0.1;

			//a font def fogoja a teteje, nekunk a kozepe kell
			y-=(Text.getFontSize( sty.charset ))/(Config.video_y*vp.getHeight());

			Text txt = createText( string, sty.charset, sty.align, x, y );
			txt.changeColor( COLOR_UNSELECTED );

			btn.setLabel( txt );
		}

		return btn;
	}

	//progress bar
/*	public ProgressBar createProgressBar( Style sty, float x, float y, String label, float value )
	{
		//csuszka knob
		Group g = groups.lastElement();

		int	pri = 1;

		//half widths!
		float width	= (sty.width/2)*sty.aspect*sty.aspect/vpAspect;

		float ax;
		if( sty.align == Text.ALIGN_LEFT )
			ax = x+width;
		else
		if( sty.align == Text.ALIGN_RIGHT )
			ax = x-width;
		else
			ax=x;

		Vector3 pos = convertTextCoordinates( ax, y, pri );

		Rectangle rect;
		rect =  new Rectangle( g, pos, sty.rt );

		ProgressBar pb = new ProgressBar( this, rect, ax-width/vpWidth, ax+width/vpWidth, y );

		pb.setValue( value );

//add label:
		//addLabel( where, sring  ); !!!!
		//egyelore bedrotozzuk hogy a szoveg a csuszkatol balra helyezkedjen el, jobbra igazitva!

		//a font def fogoja a teteje, nekunk a kozepe kell
		y-=(Text.getFontSize( sty.charset ))/(Config.video_y*vp.getHeight());

		//Text txt = createText( label, sty.charset, Text.ALIGN_RIGHT, ax-sty.width/vpWidth/2.0, y );
		Text txt = createText( label, sty.charset, Text.ALIGN_RIGHT, ax-(width*1.1)/vpWidth, y );
		txt.changeColor( COLOR_UNSELECTED );
		pb.setLabel( txt );

		g.gadget.addElement( pb );
		return pb;
	}
*/
	//extra, intervallumozhato es diszkretizalhato!
	public Slider createSlider( Style sty, Style styKnob, float x, float y, String label, int command, float value, float a, float b, int t )
	{
		Slider s = createSlider( sty, styKnob, x, y, label, command, value);
		s.setRange( a, b );
		s.setTicks( t );
		s.setValue( value );
		return s;
	}

	public Slider createSlider( Style sty, Style styKnob, float x, float y, String label, int command, float value )
	{
		//csuszka knob
		Group g = groups.lastElement();

		//half widths!
		float width	= (sty.width/2)*sty.aspect*sty.aspect/vpAspect;
		float widthKnob = (styKnob.width/2)*styKnob.aspect*styKnob.aspect/vpAspect;

		float ax;
		if( sty.align == Text.ALIGN_LEFT )
			ax = x+width;
		else
		if( sty.align == Text.ALIGN_RIGHT )
			ax = x-width;
		else
			ax=x;

		Rectangle rect;
		rect =  new Rectangle( g, null, styKnob.rt );

		PhysicsRef phy = new PhysicsRef();
		phy.createBox( g, styKnob.rWidth, styKnob.rHeight, 0.001, "knob" );

		Slider sl = new Slider( this, rect, phy, ax-(width-widthKnob)/vpWidth, ax+(width-widthKnob)/vpWidth, y, command, globalHandler );
		//Slider sl = new Slider( this, rect, phy, ax-width/vpWidth, ax+width/vpWidth, y, command, globalHandler );

		//csuszka alap
		Button b = createButton( sty, x, y, null, command );
		b.parent=sl;	//a button a slidernek kuldi uzeneteit!
		b.nofocus=1;

		//hotspot lekerdezeshez kell
		sl.button = b;

		sl.setValue( value );

//add label:
		//addLabel( where, sring  ); !!!!
		//egyelore bedrotozzuk hogy a szoveg a csuszkatol balra helyezkedjen el, jobbra igazitva!

		//a font def fogoja a teteje, nekunk a kozepe kell
		y-=(Text.getFontSize( sty.charset ))/(Config.video_y*vp.getHeight());

		//Text txt = createText( label, sty.charset, Text.ALIGN_RIGHT, ax-sty.width/vpWidth/2.0, y );
		Text txt = createText( label, sty.charset, Text.ALIGN_RIGHT, ax-(width*1.1)/vpWidth, y );
		txt.changeColor( COLOR_UNSELECTED );
		sl.setLabel( txt );

		//ujabb drot:
		//value label
		txt = createText( null, sty.charset, Text.ALIGN_LEFT, ax+(width*1.1)/vpWidth, y );
		txt.changeColor( COLOR_UNSELECTED );
		sl.setVLabel( txt );


		g.gadget.addElement( sl );
		return sl;
	}

	public MultiChoice createMulti( Style sty, float x, float y, String label, int command, int value, Vector chs, int o )
	{
		MultiChoice mc = createMulti( sty, x, y, label, command, value, chs );
		mc.setOffset( o );
		mc.setValue( value );
		return mc;
	}
	
	public MultiChoice createMulti( Style sty, float x, float y, String label, int command, int value, Vector chs )
	{
		//csuszka knob
		Group g = groups.lastElement();

		float width = (sty.width/2)*sty.aspect*sty.aspect/vpAspect;

		float ax;
		if( sty.align == Text.ALIGN_LEFT )
			ax = x+width;
		else
		if( sty.align == Text.ALIGN_RIGHT )
			ax = x-width;
		else
			ax=x;

		Vector3 pos = convertTextCoordinates( ax, y, 0 );

		Rectangle rect;

		if( sty.rt )
			rect =  new Rectangle( g, pos, sty.rt );

		PhysicsRef phy = new PhysicsRef();
		phy.createBox( g, sty.rWidth, sty.rHeight, 0.001, label );	//string used here just for debugging
		phy.setMatrix( pos, null );


		MultiChoice mc = new MultiChoice( this, rect, phy, chs, command, globalHandler );

//add label:
		//addLabel( where, sring  ); !!!!
		//egyelore bedrotozzuk hogy a szoveg a csuszkatol balra helyezkedjen el, jobbra igazitva!

		//a font def fogoja a teteje, nekunk a kozepe kell
		y-=(Text.getFontSize( sty.charset ))/(Config.video_y*vp.getHeight());

//		Text txt = createText( label, sty.charset, Text.ALIGN_RIGHT, ax-sty.width/vpWidth/2.0, y );
		Text txt = createText( label, sty.charset, Text.ALIGN_RIGHT, ax-width/vpWidth, y );
		txt.changeColor( COLOR_UNSELECTED );
		mc.setLabel( txt );


		//choice text
		if( sty.align == Text.ALIGN_LEFT )
			x+=sty.width*0.1;
		else
		if( sty.align == Text.ALIGN_RIGHT )
			x-=sty.width*0.1;

		//a font def fogoja a teteje, nekunk a kozepe kell
		//y-=(Text.getFontSize( sty.charset ))/(Config.video_y*vp.getHeight());

		mc.ccText = createText( null, sty.charset, sty.align, x, y );
		mc.ccText.changeColor( COLOR_UNSELECTED );
		
		mc.setValue( value );


		g.gadget.addElement( mc );
		return mc;
	}


	public StringInput createStringInput( Style sty, float x, float y, String label, int command, String value )
	{
		//csuszka knob
		Group g = groups.lastElement();

		float ax;
		if( sty.align == Text.ALIGN_LEFT )
			ax = x+sty.width/2.0;
		else
		if( sty.align == Text.ALIGN_RIGHT )
			ax = x-sty.width/2.0;
		else
			ax=x;

		Vector3 pos = convertTextCoordinates( ax, y, 0 );

		Rectangle rect;

		if( sty.rt )
			rect =  new Rectangle( g, pos, sty.rt );

		PhysicsRef phy = new PhysicsRef();
		phy.createBox( g, sty.rWidth, sty.rHeight, 0.001, label );	//string used here just for debugging
		phy.setMatrix( pos, null );



		StringInput si = new StringInput( this, rect, phy, command, globalHandler );

//add label:
		//addLabel( where, sring  ); !!!!
		//egyelore bedrotozzuk hogy a szoveg a csuszkatol balra helyezkedjen el, jobbra igazitva!

		//a font def fogoja a teteje, nekunk a kozepe kell
		y-=(Text.getFontSize( sty.charset ))/(Config.video_y*vp.getHeight());

		Text txt = createText( label, sty.charset, Text.ALIGN_RIGHT, ax-sty.width/2.0, y );
		txt.changeColor( COLOR_UNSELECTED );
		si.setLabel( txt );


		//input text
		if( sty.align == Text.ALIGN_LEFT )
			x+=sty.width*0.1;
		else
		if( sty.align == Text.ALIGN_RIGHT )
			x-=sty.width*0.1;

		//a font def fogoja a teteje, nekunk a kozepe kell
		//y-=(Text.getFontSize( sty.charset ))/(Config.video_y*vp.getHeight());

		si.inputText = createText( null, sty.charset, sty.align, x, y );
		si.inputText.changeColor( COLOR_UNSELECTED );

		si.setValue( value );

		g.gadget.addElement( si );
		return si;
	}


	//regi cucc:

	//ikonokra nem tarolunk listat azert, hogy toroljuk oket
	//a torlodest a kozos szulo (nagyapa:) halala okozza majd
	public GameRef createIcon( int rid, float x, float y, GameRef handler, String handlerName )
	{
		GameRef	cast = groups.lastElement();

		GameRef icon = new GameRef( cast, rid, convertTextCoordinates( x, y, 0 ).toString() + " 0.0, 0.0, 0.0", null );
		addHook( icon, handler, handlerName );
		//TODO: ide kell tenni par dolgot a createButtonrol, ha az ikonokat is fel akarjuk venni az eger/bill kontroll listaba
		//sajnos egyelore akadaly, hogy nem tudunk ikonokat hilite-olni!
		return icon;
	}

	//using osdcommand
	public Button createButton(  int rid, float x, float y, String string, ResourceRef charset, int align,  Object handler, int command )
	{
		GameRef btn = createIcon( rid, x, y, this, null );	//onmagunknak kuldkjuk,
		y+=(0.1-Text.getFontSize( charset )/(Config.video_y*vp.getHeight()))/2;
		Text txt = createText( string, charset, align, x, y );
		txt.changeColor( COLOR_UNSELECTED );
		textIndex[buttons] = text.size()-1;
		description[buttons] = null;
		button[buttons] = btn;
		buttonHandler[buttons] = handler;	//aztan meghivjuk a cel osdcommandjat
		buttonCommand[buttons++] = command;
		return btn;
	}

	//using own handler
	public GameRef createButton(  int rid, float x, float y, String string, ResourceRef charset, int align,  GameRef handler, String handlerName )
	{
		GameRef btn = createIcon( rid, x, y, handler, handlerName );
		y+=(0.1-Text.getFontSize( charset )/(Config.video_y*vp.getHeight()))/2;
		Text txt = createText( string, charset, align, x, y );
		txt.changeColor( COLOR_UNSELECTED );
		textIndex[buttons] = text.size()-1;
		description[buttons] = null;
		button[buttons] = btn;
		buttonCommand[buttons++] = 0;
		return btn;
	}

	//using handler, osdcommand also set
	public GameRef createButton(  int rid, float x, float y, String string, ResourceRef charset, int align,  GameRef handler, String handlerName, int command )
	{
		GameRef btn = createIcon( rid, x, y, handler, handlerName );
		y+=(0.1-Text.getFontSize( charset )/(Config.video_y*vp.getHeight()))/2;
		Text txt = createText( string, charset, align, x, y );
		txt.changeColor( COLOR_UNSELECTED );
		textIndex[buttons] = text.size()-1;
		description[buttons] = null;
		button[buttons] = btn;
		buttonCommand[buttons++] = command;
		return btn;
	}

	//+with description
	public GameRef createButton(  int rid, float x, float y, String string, ResourceRef charset, int align,  GameRef handler, String handlerName, int command, String desc )
	{
		GameRef btn = createIcon( rid, x, y, handler, handlerName );
		y+=(0.1-Text.getFontSize( charset )/(Config.video_y*vp.getHeight()))/2;
		Text txt = createText( string, charset, align, x, y );
		txt.changeColor( COLOR_UNSELECTED );
		textIndex[buttons] = text.size()-1;
		description[buttons] = desc;
		button[buttons] = btn;
		buttonCommand[buttons++] = command;
		return btn;
	}

	//create default menu hotkeys
	public void createMenuKeys()
	{
		createHotkey( Input.AXIS_MENU_LEFT, Input.VIRTUAL|HK_STATIC, CMD_MENU_LF|PRIVATEEVENT, null );
		createHotkey( Input.AXIS_MENU_RIGHT, Input.VIRTUAL|HK_STATIC, CMD_MENU_RG|PRIVATEEVENT, null );
		createHotkey( Input.AXIS_MENU_UP, Input.VIRTUAL|HK_STATIC, CMD_MENU_UP|PRIVATEEVENT, null );
		createHotkey( Input.AXIS_MENU_DOWN, Input.VIRTUAL|HK_STATIC, CMD_MENU_DN|PRIVATEEVENT, null );
		createHotkey( Input.AXIS_SELECT, Input.VIRTUAL|HK_STATIC, CMD_MENU_SEL|PRIVATEEVENT, null, Event.F_KEY_PRESS|Event.F_KEY_RELEASE );

		menuKeysCreated = 1;
	}

	//handler must implement an osdCommand( int CMD ) method!
	public Hotkey createHotkey( int key, int flags, int command, GameRef handler  )
	{
		return createHotkey( key, flags, command, handler, Event.F_KEY_PRESS );
	}

	//handler must implement an osdCommand( int CMD ) method!
	public Hotkey createHotkey( int key, int flags, int command, GameRef handler, int ef  )
	{
		Hotkey hk;

		if( flags & HK_STATIC )
		{
			flags &= ~HK_STATIC;
			hk = new Hotkey( key, flags, command, handler, this, ef );
			this.hotkey.addElement( hk );
			hk.activate();
		}
		else
		{
			Group g = groups.lastElement();
			hk = new Hotkey( key, flags, command, handler, this, ef );
			g.hotkey.addElement( hk );
			if( g.active )
				hk.activate();
		}

		return hk;
	}


	//ujfajta:
	//alienMp-re kuldi majd a messageket!
	public Hotkey createHotkey( int key, int flags, int command, int ef )
	{
		Group g = groups.lastElement();
		Hotkey hk;

		if( flags & HK_STATIC )
		{
			flags &= ~HK_STATIC;
			hk = new Hotkey( key, flags, command, null, this, ef );
			this.hotkey.addElement( hk );
			hk.activate();
		}
		else
		{
			hk = new Hotkey( key, flags, command, null, this, ef );
			g.hotkey.addElement( hk );
			if( g.active )
				hk.activate();
		}

		return hk;
	}



	//group handling
	public int endGroup()
	{
		//eleg hulye megoldas, hogy most csinaljuk a kovetkezot, hat ez igy alakult ki..
		groups.addElement( new Group(this) );

		return groups.size()-2;	//az eddig activ group id-je, (az elso id-je 0)
	}

	//a begin es az end alapvetoen kulonbozoen mukodik, egyutt csak ovatosan hasznaljuk!!
	//(kulonben felesleges groupokat hoz letre)
	public int beginGroup()
	{
		groups.addElement( new Group(this) );

		return groups.size()-1;	//az most letrehozott group id-je
	}

	public void hideGroup( int n )
	{
		Group	group = groups.elementAt(n);
		group.deactivate();


	}

	public void showGroup( int n )
	{
		Group	group = groups.elementAt(n);
		group.activate();
	}

	public void resetSelection()
	{
		deactivateText();
		pointedGadget = null;
		changeSelection( defSelection, 0 );

		//ha stringinput gadget a def selected, akkor kattanjunk bele!
		if(	pointedGadget )
			if( pointedGadget instanceof StringInput )
				pointedGadget.click();

	}

	public void setFocus( int f )
	{
		Input.flushKeys();

		if( f )
		{
			Frontend.inputQueue.addElement( this );
		}
		else
		{
			//ez kicsit tulbiztositott megoldas, de jo.
			int index = Frontend.inputQueue.lastIndexOf( this );

			if( index >= 0 )	//lehet, hogy az utolso volt!
			{
				Frontend.inputQueue.removeElementAt( index ); 
			}

		//(azert mert a setFocust a show/hide hivja, es a show-hide nem hivodhat tobbszorosen,
		//rossz sorrendben)

		}
	}

	public int isFocused()
	{
		return ( iLevel <= IL_TIPS || Frontend.inputQueue.lastElement() == this);
	}

	public void setCommandText( int cmd, String str )
	{
		for ( int j = 0; j < buttons; j++ )
		{
			if( cmd == buttonCommand[j] )
			{
				Text txt = text.elementAt( textIndex[j] );
				if( txt )
					txt.changeText( str );
				break;
			}
		}
	}

	public void pressEffect()
	{
/*		Vector3 p = Input.cursor.getPos();
		p.x *=  SCALE_3D*Input.cursor.vp.getAspect();
		p.y *= -SCALE_3D;
		Vector3 v1 = new Vector3(0.0, -0.5, 0.0);

		if( !psPress || !psPress.id() )
			psPress = new ParticleSystem( Input.cursor, new RenderRef(particles:0x0024r) );

		Vector3 v2 = new Vector3(0.0, 0.0, 4.0);
		psPress.setSource("hooo", p, 0.0, 0.1, v2, 0.0, 4.0, 1000.0, null);
*/	}

	public void pressEffectStop()
	{
/*		if( psPress )
			psPress.delAction("hooo");
*/	}

	public void hoverEffect()
	{
/*		Vector3 p = Input.cursor.getPos();
		p.x *=  SCALE_3D*Input.cursor.vp.getAspect();
		p.y *= -SCALE_3D;
		Vector3 v1 = new Vector3(0.0, -0.5, 0.0);

		if( !psMove || !psMove.id() )
			psMove = new ParticleSystem( Input.cursor, new RenderRef(particles:0x0024r) );

		Vector3 v2 = new Vector3(0.0, 0.0, 4.0);
		psMove.setDirectSource("ping", p, 0.0, 0.1, v2, 0.0, 4.0, 50.0, null);
*/	}

	public void leaveEffect()
	{
/*		Vector3 p = Input.cursor.getPos();
		p.x *=  SCALE_3D*Input.cursor.vp.getAspect();
		p.y *= -SCALE_3D;
		Vector3 v1 = new Vector3(0.0, -0.5, 0.0);

		if( !psMove || !psMove.id() )
			psMove = new ParticleSystem( Input.cursor, new RenderRef(particles:0x0024r) );

		Vector3 v2 = new Vector3(0.0, 0.0, 4.0);
		psMove.setDirectSource("ping", p, 0.0, 0.1, v2, 0.0, 4.0, 50.0, null);
*/	}
}

