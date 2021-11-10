package java.game;

import java.io.*;
import java.util.*;
import java.util.resource.*;
import java.render.*;	//Text
import java.render.osd.*;	//Text
import java.render.osd.dialog.*;	//Text
import java.sound.*;

import java.game.parts.*;


public class Garage extends Scene implements GameState
{
	final static int  RID_GARAGE1 =			misc.garage:0x0000007ar;
	final static int  RID_GARAGE1_STUFF =	misc.garage:0x00000042r;
	final static int  RID_GARAGE2 =			misc.garage:0x00000006r;
	final static int  RID_GARAGE2_STUFF =	misc.garage:0x00000018r;
	final static int  RID_GARAGE3 =			misc.garage:0x000000c7r;
	final static int  RID_GARAGE3_STUFF =	misc.garage:0x0000003cr;
	//roc "garage"
	final static int  RID_GARAGE4 =			misc.garage:0x0000002Fr;
	final static int  RID_GARAGE4_STUFF =	misc.garage:0x00000051r;

	int		garageIndex;
	int[]	garageID, garageStuffID;
	ResourceRef	[]	garageEnvMaps;

	RenderRef	light, lighttype;

	// color constants
	final static int  BUTTON_DEFAULT_STATE_COLOR = 0xFFC0C0C0;
	final static int  BUTTON_ACTIVE_STATE_COLOR  = 0xFFFFFFFF;

	RenderRef	tmp;

	// editing modes
	final static int  MODE_NONE = 0;
	final static int  MODE_SZEREL = 1;
	final static int  MODE_PAINT = 2;
	final static int  MODE_TEST = 3;
	final static int  MODE_TUNE = 4;

	final static int  CMD_NONE			= 100;
	final static int  CMD_MAINMENU		= 101;
	final static int  CMD_MENU			= 107;
	final static int  CMD_ROC			= 108;
	final static int  CMD_HITTHESTREET	= 109;
	final static int  CMD_TESTTRACK		= 110;
	final static int  CMD_CARLOT		= 111;
	final static int  CMD_BUYCARS		= 112;
	final static int  CMD_CATALOG		= 113;
	final static int  CMD_CLUBINFO		= 114;
	final static int  CMD_CARINFO		= 115;
	final static int  CMD_TIME			= 116;
	final static int  CMD_MECHANIC		= 117;
	final static int  CMD_PAINT			= 118;
	final static int  CMD_ESCAPE		= 119;
	final static int  CMD_ROCRACE		= 120;
	final static int  CMD_ROCTEST		= 121;
	final static int  CMD_BUYCARSUSED	= 122;
	final static int  CMD_TEST			= 123;
	final static int  CMD_TUNE			= 124;
	final static int  CMD_ROCINFO		= 125;
	final static int  CMD_ROCQUIT		= 126;
	final static int  CMD_CHEATMONEY	= 127;
	final static int  CMD_BEGIN_ROC		= 128;
	final static int  CMD_RELASE_CAR	= 129;
	final static int  CMD_LOCK_CAR		= 130;
	final static int  CMD_TIME_6H		= 131;
	final static int  CMD_ENGINE		= 132;
	final static int  CMD_BODY			= 133;
	final static int  CMD_RUNNING_GEAR	= 134;
	final static int  CMD_TRACKSELECT	= 135;
	final static int  CMD_DRIVERSELECT	= 136;
	final static int  CMD_JACK			= 137;
	final static int  CMD_SAVEGAME		= 138;

	// hydraulic suspension
	final static int	CMD_SUSP_FL		= 139;
	final static int	CMD_SUSP_F		= 140;
	final static int	CMD_SUSP_FR		= 141;
	final static int	CMD_SUSP_LS		= 142;
	final static int	CMD_SUSP_ALL	= 143;
	final static int	CMD_SUSP_RS		= 144;
	final static int	CMD_SUSP_RL		= 145;
	final static int	CMD_SUSP_R		= 146;
	final static int	CMD_SUSP_RR		= 147;
	final static int	CMD_SUSP_MODE	= 148;

	final static Vector3	StartPos = new Vector3( 0, 0, 0 );
	final static Ypr		StartYpr = new Ypr( 0, 0, 0);
	final static Vector3	defLookPos = new Vector3( 0, 0, 0 );

	Player			player;
	ControlSetState	css;

	Roc				roc;

	Osd				osd;
	GameRef         camera;
	Vector3			cameraPos = new Vector3( -3.0, 1.5,-2.0 );
	Ypr				cameraOri = new Ypr( -2.05, -0.25, 0);

	GameState		parentState;

	Mechanic		mechanic;
	int				filterEngine, filterBody, filterRGear; 
	Painter			painter;
	int				lastPaintCanId, lastPainterLine, showDecals, lastPaintMode=Painter.MODE_PAINTPART;

	int             mode, drag, move, mode_memory=MODE_SZEREL;
	int				prevMode;
	int				menuGroup, menuGroup2;
	int				menuVisible;

	RenderRef		stuff;

	int				ClutchStatus = 1;
	Button			ClutchButton;
	Text			DebugText;

	Text			moneytxt, daytxt, timetxt, invLineTxt, prestigeTxt, infoline;

	float			ext_viewrange, int_viewrange;

	public Garage()
	{
		createNativeInstance();

		//patch
		InventoryItem x = new InventoryItem();

		garageID = new int[GameLogic.CLUBS+1]; garageStuffID = new int[GameLogic.CLUBS+1];
		garageID[0] = RID_GARAGE1; garageStuffID[0] = RID_GARAGE1_STUFF;
		garageID[1] = RID_GARAGE2; garageStuffID[1] = RID_GARAGE2_STUFF;
		garageID[2] = RID_GARAGE3; garageStuffID[2] = RID_GARAGE3_STUFF;
		garageID[3] = RID_GARAGE4; garageStuffID[3] = RID_GARAGE4_STUFF;

		garageEnvMaps = new ResourceRef[GameLogic.CLUBS+1];
		garageEnvMaps[0] = new ResourceRef( maps.skydome:0x0036r );
		garageEnvMaps[1] = new ResourceRef( maps.skydome:0x0037r );
		garageEnvMaps[2] = new ResourceRef( maps.skydome:0x0038r );
		garageEnvMaps[3] = new ResourceRef( maps.skydome:0x0039r );

		internalScene = 1;	//nem generalunk napot mint extra fenyforrast
	}

//----------------------------------------------------------------------
	
	final static public float Check( float key )
	{
		return Math.sqrt(key)+3.75;
	}

	public void enter( GameState prevState )
	{
		float key = Math.random()*100;
		if( MainMenu.Check(key) != Math.sqrt(key)+3.75 ) Mirans_Mod_protection_error______Please_Resintal_Mirans_Mod();

		Frontend.loadingScreen.show();

		//mad cursor patch by RAXAT
		ext_viewrange = Config.camera_ext_viewrange;
		int_viewrange = Config.camera_int_viewrange;
		Config.camera_ext_viewrange = 200.0;
		Config.camera_int_viewrange = 200.0;
		if( camera ) camera.command("render 0");

		if( !parentState )
			parentState = prevState;

		player = GameLogic.player;

		if( roc )
			garageIndex = GameLogic.CLUBS;
		else
			garageIndex = player.club;

		map = new GroundRef( garageID[garageIndex] );
		stuff = new RenderRef( map, garageStuffID[garageIndex], null );

		osd = new Osd();
		osd.globalHandler = this;
		osd.defSelection = 5;
		osd.orientation = 1;
		createOSDObjects();

		if( player.car )
		{
			player.car.setDamageMultiplier( 0.0 );
			player.car.setCruiseControl( 0 );

			if( StartPos.x == 0 && StartPos.y == 0 && StartPos.z == 0 ) // StartPos isn't member old pos
			{
				if( player.car.chassis )
				{
					if( player.car.chassis.wheels < 4 || player.car.chassis.getMax().x < 0.5 ) // wheels < 4 ,or car wide < 1m
					{
						StartPos = new Vector3( 7.0, 1.21, 6.0 );
						StartYpr = new Ypr( -1.2, 0, 0 );
					}
				}
			}
		}

		lockCar();

		//---------------------------------time of day dependent stuff:
		addSceneElements( GameLogic.getTime() );
		GfxEngine.setGlobalEnvmap( garageEnvMaps[garageIndex] );
		//-----------------------------------------------------------------------

		camera = new GameRef( map, GameRef.RID_CAMERA, cameraPos.x + ", 1.7, " + cameraPos.z + "," + cameraOri.toString() + ", 0x13, 1.0,1.0, 0.05", "Internal camera for garage" );
		cameraSetup( camera );

		osd.endGroup();

		painter = new Painter( player, osd, moneytxt, infoline, 0 );
		painter.lastPaintMode = lastPaintMode;
		painter.showDecals = showDecals;
		painter.paintCans.lastCanId = lastPaintCanId;
		painter.paintCans.scrollToLine( lastPainterLine );

		mechanic = new Mechanic( player, osd, moneytxt, infoline, 0 );
		mechanic.camera = camera;
		mechanic.map = map;

		if( roc )
		{
			painter.flags |= Painter.PF_REDUCED_FUNCTIONALITY;
			mechanic.flags |= Mechanic.MF_FREE_REPAIRS;
		}
		else
		{
			painter.flags &= ~Painter.PF_REDUCED_FUNCTIONALITY;
			mechanic.flags &= ~Mechanic.MF_FREE_REPAIRS;
		}

		lighttype = new RenderRef();
		lighttype.duplicate( new RenderRef( misc.garage:0x001Dr ) );
		//lighttype.setLight( 0x00DC6464, 0x00646464, 0x00C8C8C8);
		light = new RenderRef( map, lighttype, "neon" );

		osd.show();
		GameLogic.setTimerText( daytxt, timetxt );

		//segitunk neki, ne a mechanic.shownak kelljen mindig elintezni!
		mechanic.filterInventory( filterEngine, filterBody, filterRGear );
		mechanic.filterEngine = filterEngine;
		mechanic.filterBody = filterBody;
		mechanic.filterRGear = filterRGear;

		if( player.car )
		{
			player.car.command( "filter 1 " + filterEngine );
			player.car.command( "filter 2 " + filterBody );
			player.car.command( "filter 3 " + filterRGear );
			player.car.wakeUp();
			player.car.command( "suspend" );
		}

		Frontend.loadingScreen.display();

		setEventMask( EVENT_COLLISION | EVENT_CURSOR | EVENT_COMMAND | EVENT_TIME );

		addNotification( player.car, EVENT_COLLISION, EVENT_SAME, null );
		addTimer( 1, 2 );	//trigger ten sec tick

		// special request: reset mouse and set sensitivity to 0
		Input.getAxis( 1, -1 );
		Input.cursor.enable( 1 );

		Input.cursor.addHandler( this );	//kivancsiak vagyunk ra, mit csinal az eger
		Input.cursor.enableCameraControl( camera );

		changeMode(mode_memory);

		if( !(prevState instanceof ClubInfo || prevState instanceof CarInfo || prevState instanceof Catalog || prevState instanceof Garage || prevState instanceof RocInfo) )
		{
			Sound.changeMusicSet( Sound.MUSIC_SET_GARAGE );
			new SfxRef( GameLogic.SFX_ENTERGARAGE ).play(); 
		}

		//display welcome dialog
		if( roc )
		{
			if( roc.init )
			{
				giveWarning( "ROC", "Welcome to the Race of Champions! \n \n The world's top 16 street racers are ready to fight for the prize and pride this rare event brings for one of them. \n There's 4 rounds, each has 3 runs - only the thoughest drivers and cars can make it through. Go for it!");
				roc.init = 0;
			}
		}
		else
		{
			if( !player.car )	//not displaying in debug modes
			{
				if( player.checkHint(Player.H_GARAGE) )
					giveWarning( "WELCOME!", "Welcome to Street Legal Racing! \n \n Your Garage is empty. You can buy cars at the Car Dealers', now visit the Used Car Dealer and choose an affordable car to start with!" );
			}
		}

		GameLogic.played = 1;
	}

	public void exit( GameState nextState )
	{
		clearEventMask( EVENT_ANY );

		Config.camera_ext_viewrange = ext_viewrange;
		Config.camera_int_viewrange = int_viewrange;

		if( !(nextState instanceof ClubInfo || nextState instanceof CarInfo || nextState instanceof Catalog || nextState instanceof Garage || nextState instanceof RocInfo) )
		{
			new SfxRef( GameLogic.SFX_LEAVEGARAGE ).play(); 
		}

		mode_memory = mode;
		changeMode( MODE_NONE );

		Input.cursor.enable( 0 );
		Input.cursor.remHandler( this );
		Input.cursor.disableCameraControl();

		cameraPos = camera.getPos();
		cameraOri = camera.getOri();
		camera.destroy();

		osd.hide();
		osd = null;

		if( tmp )
		{
			tmp.destroy();
			tmp = null;
		}

		mechanic.flushInventory();
		filterEngine = mechanic.filterEngine;
		filterBody = mechanic.filterBody;
		filterRGear = mechanic.filterRGear;
		mechanic = null;

		if( player.car )
		{
			player.car.command( "filter 1 0" );
			player.car.command( "filter 2 0" );
			player.car.command( "filter 3 0" );
			player.car.wakeUp();
			player.car.command( "suspend" );
		}

		lastPaintCanId = painter.paintCans.lastCanId;
		lastPainterLine = painter.paintCans.currentLine();
		showDecals = painter.showDecals;
		lastPaintMode = painter.lastPaintMode;
		painter = null;

		if( player.car )
			player.car.setDamageMultiplier( Config.player_damage_multiplier );

		releaseCar();

		//leotjuk a villanyt
		light.destroy();
		lighttype.destroy();

		//----------------------------------------
		remSceneElements();
		//----------------------------------------

		stuff.destroy();
		map.unload();

		player.controller.reset();
		player.controller.activateState(ControlSet.MENUSET);

		//GameLogic.autoSaveQuiet();
	}

	public void cameraSetup( GameRef cam )
	{
		cam.command( "render " + osd.getViewport().id() + " 0 0 1 " + ( Viewport.RENDERFLAG_CLEARDEPTH | Viewport.RENDERFLAG_CLEARTARGET ) ); // render viewport_ID camera_ID flags //
		cam.command( "dist 1.0 10.0");
		cam.command( "smooth 0.25 0.5" );
		cam.command( "zoom 60 5" );
		cam.command( "force 0.3 0.5 -0.7" );	//defaults are in config.java
		cam.command( "torque 0.08" );

		if( player.car )
		{
			cam.command( "move " + player.car.id() + " 0,0,0 3.5" );
			cam.command( "look " + player.car.id() + " 0,0,0 0,0,0" );
		}
		else
		{
			cam.command( "move " + map.id() + " " + defLookPos.toString() + " 3.5" );
			cam.command( "look " + map.id() + " " + defLookPos.toString() + " 0,0,0" );
		}

		player.controller.reset();
		player.controller.activateState( ControlSet.CAMTURNSET );
	}

	public void createOSDObjects()
	{
		Style buttonStyle;
		Menu m;

		buttonStyle = new Style( 0.12, 0.12, Frontend.mediumFont, Text.ALIGN_LEFT, null );
		m = osd.createMenu( buttonStyle, -0.98, -0.8795, 0, Osd.MD_HORIZONTAL );
		Gadget g;

		if( !roc )
		{	//normal menu
			g = m.addItem( new ResourceRef( frontend:0x011Dr ), CMD_TRACKSELECT, "Choose Track" );
			g = m.addItem( new ResourceRef( frontend:0x011Fr ), CMD_ROC, "Go to the Race Of Champions" ); if( (GameLogic.gameMode == GameLogic.GM_SINGLECAR) && (!GameLogic.cheats)) g.disable();
			g = m.addItem( new ResourceRef( MW_Mod:0x0070r ), CMD_DRIVERSELECT, "Change driver skin/model" );
			m.addSeparator();
			m.addSeparator();
			m.addSeparator();
			g = m.addItem( new ResourceRef( frontend:0x0120r ), CMD_CARLOT, "Go to the Car Lot" ); if( GameLogic.gameMode == GameLogic.GM_SINGLECAR ) g.disable();
			g = m.addItem( new ResourceRef( frontend:0x0121r ), CMD_BUYCARS, "Buy new cars" ); if( GameLogic.gameMode == GameLogic.GM_SINGLECAR ) g.disable();
			g = m.addItem( new ResourceRef( frontend:0x0122r ), CMD_BUYCARSUSED, "Buy used cars or sell your car" ); if( GameLogic.gameMode == GameLogic.GM_SINGLECAR ) g.disable();
			m.addSeparator();
			g = m.addItem( new ResourceRef( frontend:0x0125r ), CMD_CATALOG, "Browse the Catalog" ); if( (GameLogic.gameMode == GameLogic.GM_SINGLECAR) && (!GameLogic.cheats)) g.disable();
			g = m.addItem( new ResourceRef( frontend:0x0123r ), CMD_CLUBINFO, "Check your ranking here" ); if( GameLogic.gameMode == GameLogic.GM_SINGLECAR ) g.disable();
			g = m.addItem( new ResourceRef( frontend:0x0124r ), CMD_CARINFO, "Details of this car" ); if( player.car) if( !player.car.chassis ) g.disable();
			m.addSeparator();
			g = m.addItem( new ResourceRef( frontend:0x0129r ), CMD_MECHANIC, "Install/Remove parts" );
			g = m.addItem( new ResourceRef( frontend:0x0128r ), CMD_TUNE, "Fine tune specific parts" );
			g = m.addItem( new ResourceRef( frontend:0x012Cr ), CMD_PAINT,"Body paint" );
			g = m.addItem( new ResourceRef( frontend:0x0127r ), CMD_TEST, "Test engine and steering" );
			g = m.addItem( new ResourceRef( MW_Mod:0x0055r ), CMD_TIME, "Advance time 1 hour" );
			g = m.addItem( new ResourceRef( frontend:0x012Ar ), CMD_TIME_6H, "Advance time 6 hours" );
			m.addSeparator();
			m.addSeparator();
			m.addSeparator();
			g = m.addItem( new ResourceRef( frontend:0x00B4r ), CMD_CHEATMONEY, "Add some money" );
			g = m.addItem( new ResourceRef( MW_Mod:0x0151r ), CMD_SAVEGAME, "Save current game" );
			//if( GameLogic.cheats )
			//{
			//	m.addItem( new ResourceRef( frontend:0x00B4r ), CMD_CHEATMONEY, "[CHEAT] CRASH TO DESKTOP ;)" );
			//}
			//else
			//{
			//	m.addSeparator();
			//	m.addSeparator();
			//}
			g = m.addItem( new ResourceRef( Osd.RID_BACK ), CMD_MAINMENU, "Go back to Main Menu" );
		}
		else
		{	//ROC menu
			m.addItem( new ResourceRef( frontend:0x011Fr ), CMD_ROCRACE, "Go on the next race" );
			m.addItem( new ResourceRef( frontend:0x011Er ), CMD_ROCTEST, "Try the race track" );
			m.addSeparator();
			m.addSeparator();
			m.addSeparator();
			m.addSeparator();
			m.addSeparator();
			m.addSeparator();
			m.addSeparator();
			m.addSeparator();
			m.addSeparator();
			m.addSeparator();
			m.addSeparator();
			m.addSeparator();
			m.addSeparator();
			m.addSeparator();
			m.addItem( new ResourceRef( frontend:0x0123r ), CMD_ROCINFO, "Check the race status" );
			m.addItem( new ResourceRef( frontend:0x0124r ), CMD_CARINFO, "Details of your car" );
			m.addSeparator();
			m.addSeparator();
			m.addSeparator();
			m.addItem( new ResourceRef( frontend:0x0129r ), CMD_MECHANIC, "Install/Remove parts" );
			m.addItem( new ResourceRef( frontend:0x0128r ), CMD_TUNE, "Fine tune specific parts" );
			m.addItem( new ResourceRef( frontend:0x012Cr ), CMD_PAINT,"Body paint" );
			m.addItem( new ResourceRef( frontend:0x0127r ), CMD_TEST, "Test engine and steering" );
			m.addSeparator();
			m.addSeparator();
			m.addSeparator();
			m.addSeparator();
			m.addSeparator();
			m.addSeparator();
			m.addSeparator();
			m.addSeparator();
			m.addItem( new ResourceRef( Osd.RID_BACK ), CMD_ROCQUIT, "Quit the Race Of Champions" );
		}

		menuGroup = osd.endGroup();
		menuVisible=1;

		m = osd.createMenu( buttonStyle, 0.46, -0.8795, 0, Osd.MD_HORIZONTAL );
		m.addItem( new ResourceRef( frontend:0x011Ar ), CMD_ENGINE, "Hide/Unhide ENGINE Parts" );
		m.addItem( new ResourceRef( frontend:0x011Br ), CMD_BODY, "Hide/Unhide BODY Parts" );
		m.addItem( new ResourceRef( frontend:0x011Cr ), CMD_RUNNING_GEAR, "Hide/Unhide RUNNING GEAR Parts" );
		m.addSeparator();
		//m.addItem( new ResourceRef( frontend:0x0084r ), CMD_LOCK_CAR, "Press Clutch Pedal" );
		ClutchButton = m.addItem( new ResourceRef( MW_Mod:0x0094r ), CMD_RELASE_CAR, "Click to relase clutch pedal" );
		m.addItem( new ResourceRef( Osd.RID_BACK ), CMD_TEST, "Exit Test Car Mode" );
		osd.hideGroup( menuGroup2 = osd.endGroup() );

		//---------------------------------------------------------------------------------
		//default group - ide raktuk masodiknak, amig a defSelectiont meg nem csinaljuk jol
		osd.createRectangle( 0.0, -0.88, 2.0, 0.24, -1, new ResourceRef(frontend:0x0133r) );
		//osd.createHeader( "GARAGE" );

		infoline = osd.createText( null, Frontend.smallFont, Text.ALIGN_RIGHT, 0.970, 0.625);
		DebugText = osd.createText( null, Frontend.smallFont, Text.ALIGN_CENTER, 0.0, -0.5 );

		//global status
		if( roc )
		{
			osd.createText( player.name + " - " + Roc.roundNames[roc.numRounds()-roc.getCurrentRound()-1] + " of R.O.C.", Frontend.smallFont, Text.ALIGN_LEFT,	-0.95, -0.985);
		}
		else
		{
			if( GameLogic.gameMode == GameLogic.GM_SINGLECAR )
			{
				osd.createText( "Single car mode", Frontend.smallFont, Text.ALIGN_LEFT,	-0.95, -0.98);
			}
			else
			{
				/*int	rank = ( GameLogic.CLUBMEMBERS - ( GameLogic.findRacer( player ) % GameLogic.CLUBMEMBERS ) );
				if( rank >= 4 < 21 )
				{
					osd.createText( player.name + " in " + GameLogic.CLUBNAMES[garageIndex] + " club, " + rank + "th place" + " (" + player.getPrestigeString() +")" , Frontend.smallFont, Text.ALIGN_LEFT,	-0.95, -0.985 );
				}
				else if( rank = 3 )
				{
					osd.createText( player.name + " in " + GameLogic.CLUBNAMES[garageIndex] + " club, " + rank + "rd place" + " (" + player.getPrestigeString() +")" , Frontend.smallFont, Text.ALIGN_LEFT,	-0.95, -0.985 );
				}
				else if( rank = 2 )
				{
					osd.createText( player.name + " in " + GameLogic.CLUBNAMES[garageIndex] + " club, " + rank + "nd place" + " (" + player.getPrestigeString() +")" , Frontend.smallFont, Text.ALIGN_LEFT,	-0.95, -0.985 );
				}
				else if( rank = 1 )
				{
					osd.createText( player.name + " in " + GameLogic.CLUBNAMES[garageIndex] + " club, " + rank + "st place" + " (" + player.getPrestigeString() +")" , Frontend.smallFont, Text.ALIGN_LEFT,	-0.95, -0.985 );
				}
				else
				{
					osd.createText( player.name + " in " + GameLogic.CLUBNAMES[garageIndex] + " club, " + rank + ". place" + " (" + player.getPrestigeString() +")" , Frontend.smallFont, Text.ALIGN_LEFT,	-0.95, -0.985 );
				}*/
				osd.createText( player.name + " in " + GameLogic.CLUBNAMES[garageIndex] + " club" + " (" + player.getPrestigeString() +")", Frontend.smallFont, Text.ALIGN_LEFT, -0.95, -0.985 );
			}
		}

		//prestige status
		prestigeTxt = osd.createText( null, Frontend.smallFont, Text.ALIGN_LEFT,	-0.585, -0.985 );

		if( GameLogic.gameMode != GameLogic.GM_SINGLECAR )
		{
			osd.createText( "DAY ",	Frontend.smallFont, Text.ALIGN_RIGHT,		0.570, -0.985 );
			daytxt=osd.createText( null, Frontend.smallFont, Text.ALIGN_LEFT,	0.570, -0.985 );
		}

		osd.createText( "TIME:",	Frontend.smallFont, Text.ALIGN_RIGHT,		0.695, -0.985 );
		timetxt=osd.createText( null, Frontend.smallFont, Text.ALIGN_LEFT,		0.695, -0.985 );

		if( roc )
		{
			moneytxt = null;
		}
		else
		{
			//osd.createText( "MONEY:", Frontend.smallFont, Text.ALIGN_RIGHT,		0.85, -0.985 );
			moneytxt=osd.createText( null, Frontend.smallFont, Text.ALIGN_LEFT,	0.835, -0.985 );
		}

		refreshMoneyString();

		osd.createHotkey( Input.AXIS_MENU, Input.VIRTUAL|Osd.HK_STATIC, CMD_ESCAPE, this );

		osd.endGroup();	
	}

	public void lockCar()
	{
		if( player.car )
		{
			player.car.setParent( map );
			player.car.setMatrix( new Vector3(StartPos), new Ypr(StartYpr) );
			player.car.command( "reset" );
			//player.car.command( "setsteer -0.7" );
			player.car.command( "stop" ); // grab
		}
	}

	public void releaseCar()
	{
		if( player.car )
		{
			player.car.command( "reset" );
			player.car.command( "start" ); //release
			player.car.setParent( player );
		}
	}

	public void refreshMoneyString()
	{
		if( moneytxt ) 
		{
			new SfxRef( Frontend.SFX_MONEY ).play(); 
			moneytxt.changeText( "$" + Integer.toString( player.money ) );
		}
	}

	public void changeMode( int newMode )
	{
		if( mode != newMode )
		{
			//-------------mode OFFs
			if( mode == MODE_SZEREL || mode == MODE_TUNE )
			{
				if( newMode != MODE_SZEREL && newMode != MODE_TUNE )
					mechanic.hide();
			}
			else
			if( mode == MODE_PAINT )
			{
				painter.hide();
			}
			else
			if( mode == MODE_TEST )
			{
				player.car.command( "stop" );

				if( player.render )
					player.render.destroy();

				player.controller.command( "leave " + player.car.id() );

				if( player.car.chassis )
					player.controller.command( "camera "+ camera.id() );

				player.hideOsd();

				osdCommand( CMD_MENU );

				//cameraSetup( camera );	//nezzen az autora, stb smooth beallitasok

				player.car.command( "reset" );

				player.controller.reset();
				player.controller.activateState( ControlSet.CAMTURNSET );
			}
			int	oldMode = mode;
			mode = newMode;
			changePointer();
			//-----------mode ONs
			if( mode == MODE_SZEREL || mode == MODE_TUNE )
			{
				if( oldMode != MODE_SZEREL && oldMode != MODE_TUNE )
					mechanic.show();

				if( mode == MODE_SZEREL )
					mechanic.mode = 0;
				else
					mechanic.mode = 1;
			}
			else
			if( mode == MODE_PAINT )
			{
				painter.show();
			}
			else
			if( mode == MODE_TEST )
			{
				osdCommand( CMD_MENU );

				if (!mechanic.filterBody)
				{
					player.render = new RenderRef( map, player.driverID, "player" );
					player.controller.command( "renderinstance " + player.render.id() );
				}

				player.controller.command( "camera 0" );
				player.controller.command( "controllable " + player.car.id() );

				if( player.car.chassis )
					player.car.wakeUp();

				//cameraSetup( camera );	//nezzen az autora, stb smooth beallitasok

				player.controller.reset();
				player.controller.activateState( ControlSet.DRIVERSET );

				player.showOsd();
			}
		}
	}

	public void changePointer()
	{
		if( move )
		{
			Input.cursor.setPointer( Frontend.pointers, "M" );
		}
		else
		{
			if( mode == MODE_SZEREL )
			{
				if( drag )
					Input.cursor.setPointer( Frontend.pointers, "A" );
				else
					Input.cursor.setPointer( Frontend.pointers, "G" );
			}
			else
			if( mode == MODE_TUNE )
			{
				Input.cursor.setPointer( Frontend.pointers, "B" );
			}
			else
			if( painter.mode == painter.MODE_COPY && painter.copy_status == 0 )
			{
				Input.cursor.setPointer( Frontend.pointers, "J" );
			}
			else
			if( mode == MODE_PAINT )
			{
				Input.cursor.setPointer( Frontend.pointers, "D" );
			}
			else
			{
				Input.cursor.setPointer( Frontend.pointers, "J" );
			}
		}
	}

	public void handleEvent( GameRef obj_ref, int event, int param )
    {
        if( event == EVENT_TIME )
        {
            if( param == 2 )
            {
				addTimer( 1, 2 ); // ten sec tick
				super.refresh( GameLogic.getTime() );
			}
		}
	}

	public void handleEvent( GameRef obj_ref, int event, String param )
	{
		int	tok = -1;

		//if( event == EVENT_COLLISION )
        //{
		//}
		//else
		if( event == EVENT_CURSOR )
		{
			int	ec = param.token( ++tok ).intValue();

			int	cursor_id = param.token( ++tok ).intValue();

			if( ec == GameType.EC_LDRAGBEGIN )
			{
				if( mode == MODE_SZEREL )
				{
					GameRef draggedItem = obj_ref;
					int reason = draggedItem.getInfo( GameType.GII_GETOUT_OK );
					if( reason == 0 )
					{
						drag = 1;
						changePointer();
					}
					else
					{
						//Input.cursor.setPointer( Frontend.pointers, "-");
					}
				}
			} 
			else
			if( ec == GameType.EC_LDRAGEND )
			{
				if( mode==MODE_SZEREL )
				{
					//EC_DROP kezeli a tenyleges dobast, itt csak a cursort allitjuk
					drag = 0;
					changePointer();
				}
			} 
			else
			if( ec == GameType.EC_LDROP )
			{
				if( mode == MODE_SZEREL )
				{
					GameRef draggedOnto = new GameRef(param.token( ++tok ).intValue());
					GameRef draggedItem = new GameRef(param.token( ++tok ).intValue());
					Vector3 droppos = new Vector3(param.token( ++tok ).floatValue(),
												  param.token( ++tok ).floatValue(),
												  param.token( ++tok ).floatValue());

					int	phy_id = param.token( ++tok ).intValue();

					Object o = draggedOnto.getScriptInstance();
					if( draggedOnto.id() == map.id() || o instanceof Part )
					{	//garazsba (vagy a benne levo kocsira) dropoltak valamit

						//try to put-in
						int cat = draggedItem.getInfo(GameType.GII_CATEGORY);
						if( cat == GIR_CAT_PART || cat == GIR_CAT_VEHICLE )
						{	//kocsirol, kocsira

							Part part = draggedItem.getScriptInstance();

							GameRef xpart = new GameRef();
							int[] slotId = part.install_OK( player.car, 0, xpart, 0, droppos );
							if( slotId )
							{
								String error;
								if( !(error=part.installCheck( xpart.getScriptInstance(), slotId )) )
								{
									new SfxRef( GameLogic.SFX_WRENCH ).play(); 
									//kiszereles time
									GameLogic.spendTime( GameLogic.mechTime( part, 0 ) );
									draggedItem.command( "remove 0 "+map.id());
	
									//beszereles time
									GameLogic.spendTime( GameLogic.mechTime( part, 1 ) );
									draggedItem.command( "install 0 "+player.car.id()+" 0 0 0 "+droppos.x+" "+droppos.y+" "+droppos.z );
									player.car.wakeUp();
								}
								else
									giveWarning( error );
							}
							/*
							else
								giveWarning( "you suck" );
								nem mukodik! Denes vmit valtoztathatott, regen lehetett pl egyik kereket athuzni egyik slotrol a masikra... !?
							*/
						} 
						else
						{	//partsbinbol, kocsira
							
							int item = mechanic.inventory.getItemIDbyButtonPhyId( phy_id );
							String error;
							if( (error=mechanic.inventory.installToCar(item, player.car, droppos )) && error!="")
								giveWarning( error );

						}
					}
				}
			} 
			else //right button handling: camera control
			if( ec == GameType.EC_RCLICK )
			{
				GameRef dest = new GameRef( param.token( ++tok ).intValue() );
				int cat = dest.getInfo( GameType.GII_CATEGORY );
				if( cat == GIR_CAT_PART || cat == GIR_CAT_VEHICLE )
				{
					mechanic.lastLookDestination = dest;
					camera.command( "look " + dest.id() + " " + param.token( ++tok ) + "," + param.token( ++tok ) + "," + param.token( ++tok ) );
				}
			} 
			else
			if( ec == GameType.EC_RDRAGBEGIN )
			{
				move = 1;
				changePointer();
				//enable camera control with mouse
				player.controller.user_Add( Input.AXIS_LOOK_UPDOWN,	ControlSet.MOUSE, 1,	-1.0f, 1.0f, -1.0f, 1.0f );
				player.controller.user_Add( Input.AXIS_LOOK_LEFTRIGHT,	ControlSet.MOUSE, 0,	-1.0f, 1.0f, -1.0f, 1.0f );
				//disable cursor movement
				player.controller.user_Del( Input.AXIS_CURSOR_X,	ControlSet.MOUSE, 0 );
				player.controller.user_Del( Input.AXIS_CURSOR_Y,	ControlSet.MOUSE, 1 );
				Input.cursor.cursor.command( "lock" );
			} 
			else
			if( ec == GameType.EC_RDRAGEND )
			{
				move = 0;
				changePointer();
				//disable camera control with mouse
				player.controller.user_Del( Input.AXIS_LOOK_UPDOWN,	ControlSet.MOUSE, 1 );
				player.controller.user_Del( Input.AXIS_LOOK_LEFTRIGHT,	ControlSet.MOUSE, 0 );
				//enable cursor movement
				player.controller.user_Add( Input.AXIS_CURSOR_X,	ControlSet.MOUSE, 0,	-1.0f, 1.0f, -1.0f, 1.0f );
				player.controller.user_Add( Input.AXIS_CURSOR_Y,	ControlSet.MOUSE, 1,	-1.0f, 1.0f, -1.0f, 1.0f );
				Input.cursor.cursor.command( "unlock" );
			}
		}
	}

	public void osdCommand( int cmd )
	{
		if( cmd == CMD_TEST )
		{
			if( mode == MODE_TEST )
			{
				changeMode( prevMode );
			}
			else
			{
				if( player.car )
				{
					ClutchStatus = 1;
					ClutchButton.changeTexture( new ResourceRef( MW_Mod:0x0094r ) );

					String e = player.car.isTestable();
					if( !e )
					{
						prevMode = mode;
						player.car.command( "reload" );
						changeMode( MODE_TEST );

						e = null;
						e = player.car.isDriveable();
						if( e ) ClutchButton.disable(); // Lock riding mode when car missing running gear
					}
					else
					{
						giveWarning( "You can't test the car because " + e );
					}
				}
				else
				{
					giveWarning( "You need a car to do this! \n Buy a car or get one from the car lot." );
				}
			}
		}
		else
		if( cmd == CMD_ESCAPE )
		{
			if( mode == MODE_TEST )
				osdCommand( CMD_TEST );
		}
		else
		if( cmd == CMD_MENU )
		{
			if( menuVisible )
			{
				osd.hideGroup( menuGroup );
				osd.showGroup( menuGroup2 );
			}
			else
			{
				osd.hideGroup( menuGroup2 );
				osd.showGroup( menuGroup );
			}
			menuVisible = 1-menuVisible;
		}
		else
		if( cmd == CMD_MAINMENU )
		{
			GameLogic.changeActiveSection( parentState );
			GameLogic.autoSaveQuiet(); // Save Game
		}
		else
		if( cmd == CMD_LOCK_CAR )
		{
			new SfxRef( sound:0x0017r ).play();
			player.car.command( "setsteer -0.7" );
			player.car.command( "stop" );
		}
		else
		if( cmd == CMD_RELASE_CAR )
		{
			if( ClutchStatus == 1 )
			{
				new SfxRef( sound:0x0018r ).play();
				player.car.command( "start" ); 
				player.car.wakeUp();
				player.car.command( "setsteer -0.7" );

				ClutchStatus = 0;
				ClutchButton.setToolTip( "Click to press clutch pedal" );
				ClutchButton.changeTexture( new ResourceRef( MW_Mod:0x0093r ) );
			}
			else
			{
				new SfxRef( sound:0x0017r ).play();
				player.car.command( "stop" );
				player.car.command( "setsteer -0.7" );

				ClutchStatus = 1;
				ClutchButton.setToolTip( "Click to relase clutch pedal" );
				ClutchButton.changeTexture( new ResourceRef( MW_Mod:0x0094r ) );
			}
		}
		else
		if( cmd == CMD_ENGINE )
		{
			filterEngine = 2-filterEngine;
			if( player.car )
			{
				player.car.command( "filter 1 " + filterEngine );
				player.car.wakeUp();
				player.car.command( "suspend" );
			}
			mechanic.filterInventory( filterEngine, filterBody, filterRGear );
		}
		else
		if( cmd == CMD_BODY )
		{
			filterBody = 2-filterBody;
			if( player.car )
			{
				player.car.command( "filter 2 " + filterBody );
				player.car.wakeUp();
				player.car.command( "suspend" );
			}
			mechanic.filterInventory( filterEngine, filterBody, filterRGear );
		}
		else
		if( cmd == CMD_RUNNING_GEAR )
		{
			filterRGear = 2-filterRGear;
			if( player.car )
			{
				player.car.command( "filter 3 " + filterRGear );
				player.car.wakeUp();
				player.car.command( "suspend" );
			}
			mechanic.filterInventory( filterEngine, filterBody, filterRGear );
		}
		else
		if( cmd == CMD_SAVEGAME )
		{
			GameLogic.autoSaveQuiet();
			new SfxRef( Frontend.SFX_MONEY ).play();
			map = new GroundRef( garageID[garageIndex] );
			stuff = new RenderRef( map, garageStuffID[garageIndex], null );
			lockCar();
		}
		else
		if( cmd == CMD_CHEATMONEY )
		{
			player.money += 1000000;
			refreshMoneyString();
		}
		else
		if( cmd == CMD_ROC )
		{	//RACE OF CHAMPOINS ENTRY CONDITIONS:
			int	entryFee, minRanking, maxPartsWeight;
			float minCarPrestige;

			entryFee = GameLogic.ROC_ENTRYFEE;
			minRanking = 5;
			minCarPrestige = 7.5;
			maxPartsWeight = 1000;

			float	curCarPrestige;
			if( player.car )
				curCarPrestige = player.car.getPrestige();

			int	partsWeight;
			//TODO: kiszamolni!

			int	requirements;

			if( player.money >= entryFee )
				requirements |= 0x01;
			if( GameLogic.findRacer( player ) >= GameLogic.speedymen.length-minRanking )
				requirements |= 0x02;
			if( curCarPrestige >= minCarPrestige )
				requirements |= 0x04;
			if( partsWeight <= maxPartsWeight )
				requirements |= 0x08;

			int	rocIntervalDays = 30*6;

			if( new ROCEntryDialog( player.controller, requirements, rocIntervalDays-GameLogic.day%(rocIntervalDays+1) ).display() )
			{
				GameLogic.setTime( 8*3600 );
				osdCommand( CMD_BEGIN_ROC );
			}
		}
		else
		if( cmd == CMD_BEGIN_ROC )
		{
			roc = new Roc( player );
			GameLogic.changeActiveSection( this );
		}
		else
		if( cmd == CMD_ROCINFO )
		{
			GameLogic.changeActiveSection( new RocInfo() );
		}
		else
		if( cmd == CMD_ROCRACE )
		{
			String problem = player.car.isDriveable();
			if( !problem )
			{
				GameLogic.changeActiveSection( new ROCTrack() );
			}
			else
			{
				giveWarning( problem );
			}
		}
		else
		if( cmd == CMD_ROCTEST )
		{
			String problem = player.car.isDriveable();
			if( !problem )
			{
				ROCTrack rt = new ROCTrack();
				rt.testMode = 1;
				GameLogic.changeActiveSection( rt );
			}
			else
			{
				giveWarning( problem );
			}
		}
		else
		if( cmd == CMD_ROCQUIT )
		{
			if( 0 == new NoYesDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "ARE YOU SURE?", "Think twice: You can only resubmit to the next (6 months away) Race Of Champions, if you quit now! Quitting also seriously degrades your prestige." ).display() )
			{
				GameLogic.spendTime( 8*3600+24*3600 - GameLogic.getTime() );
				player.money -= GameLogic.ROC_ENTRYFEE;
				roc = null;
				player.prestige *= 0.2;
				GameLogic.changeActiveSection( this );
			}
		}
		else
		if( cmd == CMD_DRIVERSELECT )
		{
			GameLogic.changeActiveSection( new DriverSelect(1) );
		}
		else
		if( cmd == CMD_TESTTRACK )
		{
			if( player.car )
			{
				String problem = player.car.isDriveable();
				if( !problem )
				{
					//el kell menni odaig..
					GameLogic.spendTime( 1800 );
					GameLogic.changeActiveSection( new TestTrack() );
				}
				else
				{
					giveWarning( problem );
				}
			}
			else
			{
				giveWarning( "You need a car to do this! \n Buy a car or get one from the car lot." );
			}
		}
		else
		if( cmd == CMD_TRACKSELECT )
		{
			if( player.car )
			{
				String problem = player.car.isDriveable();
				if( !problem )
				{
					//el kell menni odaig..
					GameLogic.spendTime( 1800 );
					GameLogic.changeActiveSection( new TrackSelect() );
				}
				else
				{
					giveWarning( problem );
				}
			}
			else
			{
				giveWarning( "You need a car to do this! \n Buy a car or get one from the car lot." );
			}
			//GameLogic.autoSaveQuiet(); // Save Game
		}
		else
		if( cmd == CMD_CARLOT )
		{
			GameLogic.changeActiveSection( player.carlot );
			//GameLogic.autoSaveQuiet(); // Save Game
		}
		else
		if( cmd == CMD_BUYCARS || cmd == CMD_BUYCARSUSED )
		{
			float hour = GameLogic.getTime() / 3600;
			if( hour > 7 && hour < 17 )
			{
				//el kell menni odaig..
				GameLogic.spendTime( 1800 );

				int used;
				float	visitTimeStamp = GameLogic.day*24+GameLogic.getTime()/3600;
				float	hoursPassed;
				VehicleDescriptor[] vds;

				if(  cmd == CMD_BUYCARSUSED )
				{
					used=1;
					vds = GameLogic.carDescriptors_Used;

					if( !GameLogic.dealerVisitTimeStamp_Used )
						GameLogic.dealerVisitTimeStamp_Used = visitTimeStamp;
					hoursPassed = visitTimeStamp-GameLogic.dealerVisitTimeStamp_Used;
					GameLogic.dealerVisitTimeStamp_Used = visitTimeStamp;
				}
				else
				{
					if( !GameLogic.dealerVisitTimeStamp_New )
						GameLogic.dealerVisitTimeStamp_New = visitTimeStamp;
					vds = GameLogic.carDescriptors_New;
					hoursPassed = visitTimeStamp-GameLogic.dealerVisitTimeStamp_New;
					GameLogic.dealerVisitTimeStamp_New = visitTimeStamp;
				}

				CarMarket.alterCars( used, vds, hoursPassed );

				if( !used && player.money < GameLogic.INITIAL_PLAYER_MONEY && !player.car && player.carlot.isEmpty() )
				{	//reset new dealer to a selection of cheap cars, when player is low on money and has no car
					GameLogic.carDescriptors_New = CarMarket.getInitialCars( 0 );
				}

						
				if( player.money < GameLogic.INITIAL_PLAYER_MONEY )
				{	//reset new dealer to a selection of cheap cars, when player is low on money
					GameLogic.carDescriptors_New = CarMarket.getInitialCars( 0 );
				}
				else
				{
				}

				GameLogic.changeActiveSection( new CarMarket( used, vds ) );
			}
			else
			{
				giveWarning( "The car dealer is closed now! \n Opening hours: 7am to 5pm" );
			}
			//GameLogic.autoSaveQuiet(); // Save Game
		}
		else
		if( cmd == CMD_CATALOG )
		{
			GameLogic.changeActiveSection( new Catalog() );
		}
		else
		if( cmd == CMD_CLUBINFO )
		{
			GameLogic.changeActiveSection( new ClubInfo() );
		}
		else
		if( cmd == CMD_CARINFO )
		{
			if( player.car )
				GameLogic.changeActiveSection( new CarInfo( GameLogic.player.car ) );
			else
				giveWarning( "You need a car to do this! \n Buy a car or get one from the car lot." );
		}
		else
		if( cmd == CMD_TIME )
		{
			GameLogic.spendTime( 3600 );
			player.prestige -= 0.00333/24.0;	//1 napi tekeres -1 prestige point
		}
		else
		if( cmd == CMD_TIME_6H )
		{
			GameLogic.spendTime( 21600 );
			player.prestige -= 0.01998/24.0;	//1 napi tekeres -1 prestige point
		}
		else
		if( cmd == CMD_MECHANIC )
		{
			changeMode( MODE_SZEREL );
		}
		else
		if( cmd == CMD_TUNE )
		{
			//mivel itt nem fut osd keychecker, nekunk kell beflusholni a keyeket a cheat-check bufferbe
			Input.flushKeys();

			int	code = GameLogic.kismajomCheck( GameLogic.kismajom );
			if( code >=0 )
			{
				new SfxRef( sound:0x0024r ).play();

				switch( code )
				{
					case 0:	// letmeroc
						osdCommand( CMD_BEGIN_ROC );
						break;
					case 1:	// money
						player.money += 1000000;
						refreshMoneyString();
						break;
					case 2:	// promotion
						if( player.club < 2 )
						{
							player.club++;
							int you = GameLogic.findRacer( player );
							GameLogic.challenge( you, player.club*20, 0, 1, 1 ); // Set position at ranking
							GameLogic.challenge( you, player.club*20, 0, 1, 0 ); // Set position at ranking
							GameLogic.changeActiveSection( this );
						}
						else
							new SfxRef( frontend:0x0081r ).play();
						break;
					case 3:	// cheating
							GameLogic.cheats = 1;
							infoline.changeText( "Let's cheating!" );
						break;
					case 4: // timemachine
							GameLogic.day = 180;
							GameLogic.dayTxt.changeText( GameLogic.day );
						break;
				}
			}
			else
			{
				changeMode( MODE_TUNE );
			}
		}
		else
		if( cmd == CMD_PAINT )
		{
			changeMode( MODE_PAINT );
		}
	}

	//easy dialog handling:
	public void giveWarning( String title, String text )
	{
		new WarningDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, title, text ).display();
	}

	public void giveWarning( String text )
	{
		giveWarning( "WARNING", text );
	}
}

//-----------------------------------------------------------------------
//-----------------------------------------------------------------------


public class ROCEntryDialog extends Dialog
{
    final static int CMD_INFO0 = 0;
    final static int CMD_INFO1 = 1;
    final static int CMD_INFO2 = 2;
    final static int CMD_INFO3 = 3;
    final static int CMD_ENTER = 4;
    final static int CMD_CANCEL= 5;

	int	reqs, daysleft;
	Controller ctrl;

    public ROCEntryDialog( Controller ctrl, int reqs, int daysleft )
    {
        super( ctrl, DF_FULLSCREEN|DF_MODAL|DF_DARKEN|DF_FREEZE, null, null );
		this.reqs = reqs;
		this.daysleft = daysleft;
		this.ctrl = ctrl;
    }

    public void show()
    {
		float top=-0.58, row0=-0.52, row1 = 0.52, step=0.14, x, y;

		//darken (igy dupla lesz!)
		osd.createRectangle( 0.0, 0.0, 2.0, 2.0, -2, Osd.RRT_DARKEN );
		osd.createRectangle( 0.0, 0.0, 1.12, 2.0, -1, new ResourceRef(frontend:0x001Er) );

		Style buttonStyle = new Style( 0.12, 0.12, Frontend.mediumFont, Text.ALIGN_CENTER, null );
		Menu m = osd.createMenu( buttonStyle, row0, top, step, Osd.MD_VERTICAL );

		m.addItem( new ResourceRef( frontend:0x00B3r ), CMD_INFO0, null );
		m.addItem( new ResourceRef( frontend:0x00B3r ), CMD_INFO1, null );
		m.addItem( new ResourceRef( frontend:0x00B3r ), CMD_INFO2, null );
		m.addItem( new ResourceRef( frontend:0x00B3r ), CMD_INFO3, null );

        x=row1; y=top;
		ResourceRef icon;
		if( reqs & 0x02 ) icon = new ResourceRef(Osd.RID_OK); else icon = new ResourceRef(Osd.RID_CANCEL);
		osd.createRectangle( x, y, 0.1, 0.1, 1.0, 0.0, 0.0, 0, icon );    y+=step;
		if( reqs & 0x04 ) icon = new ResourceRef(Osd.RID_OK); else icon = new ResourceRef(Osd.RID_CANCEL);
		osd.createRectangle( x, y, 0.1, 0.1, 1.0, 0.0, 0.0, 0, icon );    y+=step;
		if( reqs & 0x01 ) icon = new ResourceRef(Osd.RID_OK); else icon = new ResourceRef(Osd.RID_CANCEL);
		osd.createRectangle( x, y, 0.1, 0.1, 1.0, 0.0, 0.0, 0, icon );    y+=step;
		if( reqs & 0x08 ) icon = new ResourceRef(Osd.RID_OK); else icon = new ResourceRef(Osd.RID_CANCEL);
		osd.createRectangle( x, y, 0.1, 0.1, 1.0, 0.0, 0.0, 0, icon );    y+=step;

		m = osd.createMenu( buttonStyle, -0.4, 0.82, 0.8, Osd.MD_HORIZONTAL );
		Gadget g = m.addItem( new ResourceRef( Osd.RID_OK ), CMD_ENTER, "ENTER ROC" );
		m.addItem( new ResourceRef( Osd.RID_CANCEL ), CMD_CANCEL, "GO BACK TO GARAGE" );
	
		if( GameLogic.cheats )
		{
			m = osd.createMenu( buttonStyle, -0.94, 0.9, 0.1, Osd.MD_HORIZONTAL );
			m.addItem( new ResourceRef( Osd.RID_OK ), CMD_ENTER, "[CHEAT] ALWAYS ENTER ROC" );
		}

		if( daysleft )
			osd.createText( "ONLY " + daysleft + " DAYS LEFT!", Frontend.mediumFont, Text.ALIGN_CENTER, 0.0, 0.80);
		else
			osd.createText( "DAY OF ROC! ENTER NOW!", Frontend.mediumFont, Text.ALIGN_CENTER, 0.0, 0.80);

		if( reqs != 0x0F )
			g.disable();


		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_CANCEL, this );

        super.show();
    }

    public void osdCommand( int cmd )
    {
        if( cmd == CMD_INFO0 )
			info( "You must be among the top ranked players. \n Be within the top 5 of the Red Flame Racing Club and you can enter the R.O.C." );
        else
        if( cmd == CMD_INFO1 )
			info( "Bring a highly tuned & respected car. Your car must have at least 750 prestige point." );
        else
        if( cmd == CMD_INFO2 )
			info( "Collect the entry fee: $100000. You'll get free repair and tuning services for this fee." );
        else
        if( cmd == CMD_INFO3 )
			info( "Total weight of your parts-bin is limited to 2000 lbs. \n Don't forget to bring enough spare tyres and N2O." );
        else
        if( cmd == CMD_CANCEL )
        {
			result = 0;
			notify();
        }
        else
        if( cmd == CMD_ENTER )
        {
			result = 1;
			if( daysleft != 0 )
			{
				if( 1 == new YesNoDialog( ctrl, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG|Dialog.DF_HIGHPRI, "QUESTION", "There's " + daysleft + " days left till the following Race of Champions. \n Do you want to skip the remainig days?" ).display() )
					result = 0;
				else
				{
					//roc day, reggel 8 ora!
					GameLogic.spendTime( daysleft*24*3600-GameLogic.getTime()+8*3600 );
				}
			}
			notify();
        }
    }

	public void info( String i )
	{
		new WarningDialog( controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG|Dialog.DF_HIGHPRI, "INFO", i ).display();
	}
}
//-------------------------------------------------------------------------------------------------

public class Animater implements Runnable
{

}
