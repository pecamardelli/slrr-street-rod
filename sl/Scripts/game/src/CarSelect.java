package java.game;

import java.io.*;
import java.util.*;
import java.util.resource.*;
import java.render.*;	//Text
import java.render.osd.*;	//Text
import java.render.osd.dialog.*;	//Text
import java.sound.*;
import java.game.parts.*;

import java.game.parts.bodypart.*;

/********************************************
*			Track Selector v1.1				*
*		By Miran, base on Wichur's script	*
*				XII.2007					*
********************************************/

public class CarSelect extends Scene implements GameState
{

	final static int  	CMD_BACK	= 1;
	final static int  	CMD_OK		= 2;
	final static int  	CMD_ABOUT	= 3;
	final static int  	CMD_TUNNING	= 4;
	final static int  	CMD_LIGHTS	= 5;
	final static int  	CMD_COLOR	= 6;
	final static int  	CMD_UP		= 7;
	final static int  	CMD_DOWN	= 8;

	final static int	CMD_VEH0	= 20;
	final static int	CMD_VEH1	= 21;
	final static int	CMD_VEH2	= 22;
	final static int	CMD_VEH3	= 23;
	final static int	CMD_VEH4	= 24;
	final static int	CMD_VEH5	= 25;
	final static int	CMD_VEH6	= 26;
	final static int	CMD_VEH7	= 27;
	final static int	CMD_VEH8	= 28;
	final static int	CMD_VEH9	= 29;
	final static int	CMD_VEH10	= 30;
	final static int	CMD_VEH11	= 31;
	final static int	CMD_VEH12	= 32;
	final static int	CMD_VEH13	= 33;
	final static int	CMD_VEH14	= 34;
	final static int	CMD_VEH15	= 35;
	final static int	CMD_VEH16	= 36;
	final static int	CMD_VEH17	= 37;
	final static int	CMD_VEH18	= 38;
	final static int	CMD_VEH19	= 39;
	final static int	CMD_VEH20	= 40;
	final static int	CMD_VEH21	= 41;
	final static int	CMD_VEH22	= 42;
	final static int	CMD_VEH23	= 43;
	final static int	CMD_VEH24	= 44;
	final static int	CMD_VEH25	= 45;
	final static int	CMD_VEH26	= 46;
	final static int	CMD_VEH27	= 47;
	final static int	CMD_VEH28	= 48;
	final static int	CMD_VEH29	= 49;

	final static int	CMD_LIST = 69;
	final static int	CMD_AMBULANCE = 70;
	final static int	CMD_ARMOREDVAN = 71;
	final static int	CMD_BADGE = 72;
	final static int	CMD_CIVILVAN = 73;
	final static int	CMD_COACH = 74;
	final static int	CMD_ERBILAC = 75;
	final static int	CMD_FIREENGINE = 76;
	final static int	CMD_NINJA = 77;
	final static int	CMD_POLICE = 78;
	final static int	CMD_RCTRUCK = 79;
	final static int	CMD_SCHOOLBUS = 80;
	final static int	CMD_STALLION = 81;
	final static int	CMD_SUNSET = 82;
	final static int	CMD_TAXI = 83;
	final static int	CMD_TEG = 84;
	final static int	CMD_WAGON = 85;

// OSD stuff:
	Button TunningButton, UpButton, DownButton, TakeButton, VehButton0, VehButton1, VehButton2, VehButton3, VehButton4, VehButton5, VehButton6, VehButton7, VehButton8, VehButton9, VehButton10, VehButton11, VehButton12, VehButton13, VehButton14, VehButton15, VehButton16, VehButton17, VehButton18, VehButton19, VehButton20, VehButton21, VehButton22, VehButton23, VehButton24, VehButton25, VehButton26, VehButton27, VehButton28, VehButton29;
	Style Menu_Button, Menu_Center, Menu_Left, Menu_Right, Menu_Left_Small, Menu_Right_Small;
	Text PageTxt, CurrentCarName;
	Menu m;
	GameState prev_state;

	int			actGroup, MainGroup, ListGroup;

	final static int	 BackGroundVideo;
	int			Tunning=1, Mode, ButtonNum, VehAmount, LastCommand, ColorIDX, CurrentName, CurrentPage;
	float		OldTime, colorSeed;
	GameRef		CarScene, Cam;
	//Camera		Cam;
	RenderRef	SceneSun;
	Thread		CamThread;
	Ypr			CamYpr;
	Vector3		CamVector;
	Viewport	CarViewport;
	Vehicle		CurrentCar;
	GameRef		CurrentChassis;
	Vector3		Size;

	Osd				osd;
	GameState		parentState;
	Player			player;
	
	public CarSelect()
	{
		player = GameLogic.player;
		Mode = 0;

		float key = Math.random()*100;
		if( MainMenu.Check(key) != Math.sqrt(key)+3.75 ) Mirans_Mod_protection_error______Please_Resintal_Mirans_Mod();

		createNativeInstance();
	}

	public CarSelect( Player TMPplayer )
	{
		player = TMPplayer;
		Mode = 1;

		float key = Math.random()*100;
		if( MainMenu.Check(key) != Math.sqrt(key)+3.75 ) Mirans_Mod_protection_error______Please_Resintal_Mirans_Mod();

		createNativeInstance();
	}

	final static public float Check( float key )
	{
		return Math.sqrt(key)+3.75;
	}

    public void enter( GameState prevState )
    {
		Frontend.loadingScreen.show();

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

		GfxEngine.setGlobalEnvmap( new ResourceRef( MW_Mod:0x0069r ));

		OldTime = GameLogic.getTime();
		GameLogic.setTime(0); //Set Time 0.00 a.m

		CarScene = new Dummy( WORLDTREEROOT );
		
		CarViewport = new Viewport( 11.5, 0.0, 0.15, 1.00, 0.65 ); //create( altezza, sinistra/destra, profondità(su/giù? bho), rapporto orizzontale rapporto verticale ) -> public Viewport( int pri, float x, float y, float w, float h )
		CarViewport.activate( Viewport.RENDERFLAG_CLEARDEPTH | Viewport.RENDERFLAG_CLEARTARGET );
		//Cam = new Camera( CarScene, CarViewport, 0 );
		Cam = new GameRef( CarScene, GameRef.RID_CAMERA, "0,0,0 , 0,0,0 ,0", "camera" );
		Cam.setMatrix( new Vector3( 0, 0, 0), new Ypr( 0, 0, 0));
		Cam.command( "render " + CarViewport.id() + " 0 0 0 " + (Viewport.RENDERFLAG_CLEARDEPTH | Viewport.RENDERFLAG_CLEARTARGET) );
		Cam.command( "zoom 25 60");
		
		CurrentCar = new Vehicle();
			
		RenderRef CarSun = new RenderRef(misc.garage:0x001Dr);
		SceneSun = new RenderRef( CarScene, CarSun, "light for this scene" );

		if(Mode==1) 
		{
			if(player.car)
			{
				player.car.setParent( CarScene );
				CurrentCarName.changeText( "Dummy car" );

				if(player.car.chassis) CurrentCarName.changeText( player.car.chassis.vehicleName );
			}
		}
		
		CamThread = new Thread( this, "Cam Animate Refresher" );
		CamThread.start();


		Frontend.loadingScreen.display();
	}

	public void exit( GameState nextState )
	{
		Frontend.loadingScreen.show();

		clearEventMask( EVENT_ANY );
		removeAllTimers();
		Input.cursor.enable(0);

		osd.hide();
		osd.finalize();

		SceneSun.destroy();
		CamThread.stop();
		CamThread=null;

		GameLogic.setTime( OldTime );

		if( !nextState instanceof Garage )
		{
			new SfxRef( GameLogic.SFX_LEAVEGARAGE ).play(); 
		}
		//osd background renderer cleanup
		if( BackGroundVideo )
			GfxEngine.closeVideo();

		Frontend.loadingScreen.display();
	}

	public void createOSDObjects()
	{
	// Create Styles:
		Menu_Center = new Style( 0.4, 0.13, Frontend.mediumFont, Text.ALIGN_CENTER, null );
		Menu_Left = new Style( 0.4, 0.13, Frontend.mediumFont, Text.ALIGN_LEFT, Osd.RRT_TEST );
		Menu_Right = new Style( 0.6, 0.13, Frontend.mediumFont, Text.ALIGN_RIGHT, Osd.RRT_TEST );
		Menu_Left_Small = new Style( 0.6, 0.13, Frontend.smallFont, Text.ALIGN_LEFT, Osd.RRT_TEST );
		Menu_Right_Small = new Style( 0.6, 0.13, Frontend.smallFont, Text.ALIGN_RIGHT, Osd.RRT_TEST );
		Menu_Button = new Style( 0.12, 0.12, Frontend.mediumFont, Text.ALIGN_CENTER, null );

	// Always visable elements:
		osd.createHeader( "CAR SELECTOR" );
		osd.createBG( new ResourceRef(system:0x0016r) ); // Background image

		CurrentCarName = osd.createText( "- NO CAR SELECTED -", Frontend.largeFont, Text.ALIGN_CENTER, 0.0, -0.985 ); CurrentCarName.changeColor(0xFFC0C0C0);// "Unselected" gray

		m = osd.createMenu( Menu_Right, 0.98, -0.95, 0 );
		m.addItem( "ABOUT", CMD_ABOUT );

		m = osd.createMenu( Menu_Left, -0.98, 0.95, 0 );
		m.addItem( "BACK", CMD_BACK );
		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL|Osd.HK_STATIC, CMD_BACK, this );// ESC key = CMD_BACK

		osd.endGroup();

	// Main Osd Group:
		//osd.hideGroup( MainGroup = osd.beginGroup() );

		m = osd.createMenu( Menu_Center, 0.25, 0.95, 0 );
		m.addItem( "LIGHTS ON/OFF", CMD_LIGHTS );

		m = osd.createMenu( Menu_Center, -0.25, 0.95, 0 );
		m.addItem( "COLOR", CMD_COLOR );

		m = osd.createMenu( Menu_Right, 0.98, 0.95, 0 );
		TakeButton = m.addItem( "TAKE IT", CMD_OK );
		if(!player.car) TakeButton.disable();

		m = osd.createMenu( Menu_Left, -0.98, -0.45, 0 );
		m.addItem( "Ambulance", CMD_AMBULANCE );
		m.addItem( "Armored Van", CMD_ARMOREDVAN );
		m.addItem( "Badge", CMD_BADGE );
		m.addItem( "Civil Van", CMD_CIVILVAN );
		m.addItem( "Coach", CMD_COACH );
		m.addItem( "Erbilac", CMD_ERBILAC );
		m.addItem( "Fire Engine", CMD_FIREENGINE );
		m.addItem( "Ninja", CMD_NINJA );

		m = osd.createMenu( Menu_Right, 0.98, -0.45, 0 );
		m.addItem( "Police", CMD_POLICE );
		m.addItem( "School Bus", CMD_SCHOOLBUS );
		m.addItem( "Stallion", CMD_STALLION );
		m.addItem( "Sunset", CMD_SUNSET );		
		m.addItem( "Taxi", CMD_TAXI );
		m.addItem( "Teg", CMD_TEG );
		m.addItem( "Wagon", CMD_WAGON );
		m.addItem( "CARS LIST", CMD_LIST );

		//m = osd.createMenu( Menu_Left, -0.98, -0.45, 0 );
		//m.addItem( "VC EMS Paramedics", CMD_AMBULANCE );
		//m.addItem( "Cement Mixer", CMD_ARMOREDVAN );
		//m.addItem( "Dodge Charger", CMD_BADGE );
		//m.addItem( "GMC Vandura", CMD_CIVILVAN );
		//m.addItem( "VC Public Bus", CMD_COACH );
		//m.addItem( "Chevrolet C10 Tow Truck", CMD_ERBILAC );
		//m.addItem( "VCFD Fire Truck", CMD_FIREENGINE );
		//m.addItem( "Honda Civic", CMD_NINJA );
        //
		//m = osd.createMenu( Menu_Right, 0.98, -0.45, 0 );
		//m.addItem( "VCPD Ford Crown Victoria", CMD_POLICE );
		////m.addItem( "RC Toy Truck", CMD_RCTRUCK );
		//m.addItem( "VC Public School Bus", CMD_SCHOOLBUS );
		//m.addItem( "Nissan GTR(R35)", CMD_STALLION );
		//m.addItem( "Mitsubishi Eclipse", CMD_SUNSET );		
		//m.addItem( "VC Taxi Ford Crown Victoria", CMD_TAXI );
		//m.addItem( "Nissan Skyline GTR(R33)", CMD_TEG );
		//m.addItem( "Oldsmobile Vista Cruiser", CMD_WAGON );
		//m.addItem( "CARS LIST", CMD_LIST );

		actGroup = MainGroup = osd.endGroup();
	
	// ListGroup:
		//osd.hideGroup( ListGroup = osd.beginGroup() );

		m = osd.createMenu( Menu_Center, -0.4, 0.95, 0 );
		TunningButton = m.addItem( "STOCK", CMD_TUNNING );

		m = osd.createMenu( Menu_Center, -0.1, 0.95, 0 );
		m.addItem( "COLOR", CMD_COLOR );

		m = osd.createMenu( Menu_Center, 0.3, 0.95, 0 );
		m.addItem( "LIGHTS ON/OFF", CMD_LIGHTS );

		m = osd.createMenu( Menu_Button, 0.70, 0.95, 0, Osd.MD_HORIZONTAL );
		UpButton = m.addItem( new ResourceRef( frontend:0x00AFr ), CMD_UP, "Prev Page" );

		PageTxt = osd.createText( "p. 1", Frontend.largeFont, Text.ALIGN_LEFT, 0.755, 0.915 ); PageTxt.changeColor(0xFFC0C0C0);// "Unselected" gray

		m = osd.createMenu( Menu_Button, 0.87, 0.95, 0, Osd.MD_HORIZONTAL );
		DownButton = m.addItem( new ResourceRef( frontend:0x0088r ), CMD_DOWN, "Next Page" );

		m= osd.createMenu( Menu_Left_Small, -0.98, -0.805, 0.115 );
		VehButton0 = m.addItem( "", CMD_VEH0 );
		VehButton1 = m.addItem( "", CMD_VEH1 );
		VehButton2 = m.addItem( "", CMD_VEH2 );
		VehButton3 = m.addItem( "", CMD_VEH3 );
		VehButton4 = m.addItem( "", CMD_VEH4 );
		VehButton5 = m.addItem( "", CMD_VEH5 );
		VehButton6 = m.addItem( "", CMD_VEH6 );
		VehButton7 = m.addItem( "", CMD_VEH7 );
		VehButton8 = m.addItem( "", CMD_VEH8 );
		VehButton9 = m.addItem( "", CMD_VEH9 );
		VehButton10 = m.addItem( "", CMD_VEH10 );
		VehButton11 = m.addItem( "", CMD_VEH11 );
		VehButton12 = m.addItem( "", CMD_VEH12 );
		VehButton13 = m.addItem( "", CMD_VEH13 );
		VehButton14 = m.addItem( "", CMD_VEH14 );

		m= osd.createMenu( Menu_Right_Small, 0.98, -0.805, 0.115 );
		VehButton15 = m.addItem( "", CMD_VEH15 );
		VehButton16 = m.addItem( "", CMD_VEH16 );
		VehButton17 = m.addItem( "", CMD_VEH17 );
		VehButton18 = m.addItem( "", CMD_VEH18 );
		VehButton19 = m.addItem( "", CMD_VEH19 );
		VehButton20 = m.addItem( "", CMD_VEH20 );
		VehButton21 = m.addItem( "", CMD_VEH21 );
		VehButton22 = m.addItem( "", CMD_VEH22 );
		VehButton23 = m.addItem( "", CMD_VEH23 );
		VehButton24 = m.addItem( "", CMD_VEH24 );
		VehButton25 = m.addItem( "", CMD_VEH25 );
		VehButton26 = m.addItem( "", CMD_VEH26 );
		VehButton27 = m.addItem( "", CMD_VEH27 );
		VehButton28 = m.addItem( "", CMD_VEH28 );
		VehButton29 = m.addItem( "", CMD_VEH29 );

		osd.hideGroup( ListGroup = osd.endGroup() );
	
	}

	public void RefreshOsd()
	{
		CurrentName = CurrentPage*30;
		VehAmount = GameLogic.ChassisBox.size()-1;

		if( CurrentName + 0 <= VehAmount ) { VehButton0.changeLabelText(GameLogic.ChassisBox.elementData[CurrentName+0].vehicleName); VehButton0.enable(); } else { VehButton0.changeLabelText( "" ); VehButton0.disable(); }
		if( CurrentName + 1 <= VehAmount ) { VehButton1.changeLabelText(GameLogic.ChassisBox.elementData[CurrentName+1].vehicleName); VehButton1.enable(); } else { VehButton1.changeLabelText( "" ); VehButton1.disable(); }
		if( CurrentName + 2 <= VehAmount ) { VehButton2.changeLabelText(GameLogic.ChassisBox.elementData[CurrentName+2].vehicleName); VehButton2.enable(); } else { VehButton2.changeLabelText( "" ); VehButton2.disable(); }
		if( CurrentName + 3 <= VehAmount ) { VehButton3.changeLabelText(GameLogic.ChassisBox.elementData[CurrentName+3].vehicleName); VehButton3.enable(); } else { VehButton3.changeLabelText( "" ); VehButton3.disable(); }
		if( CurrentName + 4 <= VehAmount ) { VehButton4.changeLabelText(GameLogic.ChassisBox.elementData[CurrentName+4].vehicleName); VehButton4.enable(); } else { VehButton4.changeLabelText( "" ); VehButton4.disable(); }
		if( CurrentName + 5 <= VehAmount ) { VehButton5.changeLabelText(GameLogic.ChassisBox.elementData[CurrentName+5].vehicleName); VehButton5.enable(); } else { VehButton5.changeLabelText( "" ); VehButton5.disable(); }
		if( CurrentName + 6 <= VehAmount ) { VehButton6.changeLabelText(GameLogic.ChassisBox.elementData[CurrentName+6].vehicleName); VehButton6.enable(); } else { VehButton6.changeLabelText( "" ); VehButton6.disable(); }
		if( CurrentName + 7 <= VehAmount ) { VehButton7.changeLabelText(GameLogic.ChassisBox.elementData[CurrentName+7].vehicleName); VehButton7.enable(); } else { VehButton7.changeLabelText( "" ); VehButton7.disable(); }
		if( CurrentName + 8 <= VehAmount ) { VehButton8.changeLabelText(GameLogic.ChassisBox.elementData[CurrentName+8].vehicleName); VehButton8.enable(); } else { VehButton8.changeLabelText( "" ); VehButton8.disable(); }
		if( CurrentName + 9 <= VehAmount ) { VehButton9.changeLabelText(GameLogic.ChassisBox.elementData[CurrentName+9].vehicleName); VehButton9.enable(); } else { VehButton9.changeLabelText( "" ); VehButton9.disable(); }
		if( CurrentName + 10 <= VehAmount ) { VehButton10.changeLabelText(GameLogic.ChassisBox.elementData[CurrentName+10].vehicleName); VehButton10.enable(); } else { VehButton10.changeLabelText( "" ); VehButton10.disable(); }
		if( CurrentName + 11 <= VehAmount ) { VehButton11.changeLabelText(GameLogic.ChassisBox.elementData[CurrentName+11].vehicleName); VehButton11.enable(); } else { VehButton11.changeLabelText( "" ); VehButton11.disable(); }
		if( CurrentName + 12 <= VehAmount ) { VehButton12.changeLabelText(GameLogic.ChassisBox.elementData[CurrentName+12].vehicleName); VehButton12.enable(); } else { VehButton12.changeLabelText( "" ); VehButton12.disable(); }
		if( CurrentName + 13 <= VehAmount ) { VehButton13.changeLabelText(GameLogic.ChassisBox.elementData[CurrentName+13].vehicleName); VehButton13.enable(); } else { VehButton13.changeLabelText( "" ); VehButton13.disable(); }
		if( CurrentName + 14 <= VehAmount ) { VehButton14.changeLabelText(GameLogic.ChassisBox.elementData[CurrentName+14].vehicleName); VehButton14.enable(); } else { VehButton14.changeLabelText( "" ); VehButton14.disable(); }
		
		if( CurrentName + 15 <= VehAmount ) { VehButton15.changeLabelText(GameLogic.ChassisBox.elementData[CurrentName+15].vehicleName); VehButton15.enable(); } else { VehButton15.changeLabelText( "" ); VehButton15.disable(); }
		if( CurrentName + 16 <= VehAmount ) { VehButton16.changeLabelText(GameLogic.ChassisBox.elementData[CurrentName+16].vehicleName); VehButton16.enable(); } else { VehButton16.changeLabelText( "" ); VehButton16.disable(); }
		if( CurrentName + 17 <= VehAmount ) { VehButton17.changeLabelText(GameLogic.ChassisBox.elementData[CurrentName+17].vehicleName); VehButton17.enable(); } else { VehButton17.changeLabelText( "" ); VehButton17.disable(); }
		if( CurrentName + 18 <= VehAmount ) { VehButton18.changeLabelText(GameLogic.ChassisBox.elementData[CurrentName+18].vehicleName); VehButton18.enable(); } else { VehButton18.changeLabelText( "" ); VehButton18.disable(); }
		if( CurrentName + 19 <= VehAmount ) { VehButton19.changeLabelText(GameLogic.ChassisBox.elementData[CurrentName+19].vehicleName); VehButton19.enable(); } else { VehButton19.changeLabelText( "" ); VehButton19.disable(); }
		if( CurrentName + 20 <= VehAmount ) { VehButton20.changeLabelText(GameLogic.ChassisBox.elementData[CurrentName+20].vehicleName); VehButton20.enable(); } else { VehButton20.changeLabelText( "" ); VehButton20.disable(); }
		if( CurrentName + 21 <= VehAmount ) { VehButton21.changeLabelText(GameLogic.ChassisBox.elementData[CurrentName+21].vehicleName); VehButton21.enable(); } else { VehButton21.changeLabelText( "" ); VehButton21.disable(); }
		if( CurrentName + 22 <= VehAmount ) { VehButton22.changeLabelText(GameLogic.ChassisBox.elementData[CurrentName+22].vehicleName); VehButton22.enable(); } else { VehButton22.changeLabelText( "" ); VehButton22.disable(); }
		if( CurrentName + 23 <= VehAmount ) { VehButton23.changeLabelText(GameLogic.ChassisBox.elementData[CurrentName+23].vehicleName); VehButton23.enable(); } else { VehButton23.changeLabelText( "" ); VehButton23.disable(); }
		if( CurrentName + 24 <= VehAmount ) { VehButton24.changeLabelText(GameLogic.ChassisBox.elementData[CurrentName+24].vehicleName); VehButton24.enable(); } else { VehButton24.changeLabelText( "" ); VehButton24.disable(); }
		if( CurrentName + 25 <= VehAmount ) { VehButton25.changeLabelText(GameLogic.ChassisBox.elementData[CurrentName+25].vehicleName); VehButton25.enable(); } else { VehButton25.changeLabelText( "" ); VehButton25.disable(); }
		if( CurrentName + 26 <= VehAmount ) { VehButton26.changeLabelText(GameLogic.ChassisBox.elementData[CurrentName+26].vehicleName); VehButton26.enable(); } else { VehButton26.changeLabelText( "" ); VehButton26.disable(); }
		if( CurrentName + 27 <= VehAmount ) { VehButton27.changeLabelText(GameLogic.ChassisBox.elementData[CurrentName+27].vehicleName); VehButton27.enable(); } else { VehButton27.changeLabelText( "" ); VehButton27.disable(); }
		if( CurrentName + 28 <= VehAmount ) { VehButton28.changeLabelText(GameLogic.ChassisBox.elementData[CurrentName+28].vehicleName); VehButton28.enable(); } else { VehButton28.changeLabelText( "" ); VehButton28.disable(); }
		if( CurrentName + 29 <= VehAmount ) { VehButton29.changeLabelText(GameLogic.ChassisBox.elementData[CurrentName+29].vehicleName); VehButton29.enable(); } else { VehButton29.changeLabelText( "" ); VehButton29.disable(); }
	}

	public void RefreshCar()
	{
		if( player.car )
		{
			player.car.command( "reset" );
			player.car.setMatrix( null, null );
			player.car.command( "idle" );
			player.car.command( "setsteer -0.6" );

			//player.car.queueEvent( null, GameType.EVENT_COMMAND, "start" );

			TakeButton.enable();
		}
	}

	public void osdCommand( int cmd )
	{
		if( cmd == CMD_BACK )
		{
			if( actGroup == MainGroup )
			{
				if(player.car)
				{
					player.car.command( "reset" );
					player.car.setMatrix( null, null );
					player.car.setParent( player );
				}

				GameLogic.changeActiveSection( parentState );
			}
			else
			if( actGroup = ListGroup )
			{
				if(player.car)
				{
					if(player.car.chassis)
					{
						if (File.exists("save/temp/CopyCar"))
						{
							File.delete( "save/temp/CopyCar" );
							File.delete( "save/temp/CopyCar.*" );
						}
						player.car.save( "save/temp/CopyCar" );
						player.car.destroy();

						player.car = Vehicle.load( "save/temp/CopyCar", CarScene );
						RefreshCar();
					}
				}

				changeGroup( MainGroup );
			}
		}
		else
		if( cmd == CMD_OK )
		{
			if( Mode == 1 )
			{
				player.car.command( "reset" );
				player.car.setMatrix( null, null );
				player.car.setParent( player );

				GameLogic.changeActiveSection( parentState );
			}
			else
			{
				Frontend.loadingScreen.show();

				player.car.command( "reset" );
				player.car.setMatrix( null, null );
				player.car.setParent( player );

				player.driverID = new RenderRef(GameLogic.HUMAN_PLAYER);
				if( !player.character )	//eg for free ride..
				{
					player.character=new ResourceRef( Racer.RID_FEJ );
					player.name = "Player";
				}
				GameLogic.gameMode = GameLogic.GM_SINGLECAR;
				GameLogic.player.money = 1000000;
				player.parts = new Inventory( player );
				player.carlot = new CarLot( player );

				GameLogic.changeActiveSection (GameLogic.garage);
			}
		}
		else
		if( cmd == CMD_UP )
		{
			if (CurrentPage > 0)
				CurrentPage -= 1;

			CurrentName = CurrentPage*30;
			PageTxt.changeText( "p. " + (CurrentPage+1) );

			DownButton.changeTexture( new ResourceRef( frontend:0x0088r ) ); // Arrow down
			DownButton.enable();
			
			if (CurrentPage == 0)
			{
				UpButton.changeTexture( new ResourceRef( frontend:0x00AFr ) ); // Empty.ptx
				UpButton.disable();
			}

			RefreshOsd();
		}
		else
		if( cmd == CMD_DOWN )
		{
			if (GameLogic.ChassisRoot.length >= CurrentName+15)
				CurrentPage += 1;

			CurrentName = CurrentPage*30;

			PageTxt.changeText( "p. " + (CurrentPage+1) );

			UpButton.changeTexture( new ResourceRef(frontend:0x0085r) ); // Arrow up
			UpButton.enable();

			VehAmount = GameLogic.ChassisBox.size()-1;

			if (VehAmount < CurrentName+30)
			{
				DownButton.changeTexture( new ResourceRef(frontend:0x00AFr) ); // Empty.ptx
				DownButton.disable();
			}
			
			RefreshOsd();
		}
		else
		if( cmd == CMD_ABOUT )
		{
			new WarningDialog( GameLogic.player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG|Dialog.DF_WIDE, "CAR SELECTOR v1.1", " \n Choose car and click 'TAKE IT' to drive. \n \n Now you can change color and choose car from list. \n \n By Miran" ).display();
		}
		else
		if( cmd == CMD_COLOR )
		{
			if( player.car.chassis )
			{
				if( ColorIDX == GameLogic.CARCOLORS.length - 1) 
					ColorIDX = 0;
				else
					ColorIDX += 1;

				player.car.command( "texture " + GameLogic.CARCOLORS[ColorIDX] + " 1" );
			}
			else
				osdCommand( LastCommand );
		}
		if( cmd == CMD_TUNNING )
		{
			if( Tunning == 1 )
			{
				Tunning = 2;
				TunningButton.changeLabelText( "TUNNING" );
			}
			else
			{
				Tunning = 1;
				TunningButton.changeLabelText( "STOCK" );
			}
		}
		else
		if( cmd == CMD_LIGHTS )
		{
			player.car.command( "reset" );
			GameLogic.setTime( GameLogic.getTime() + 12*3600 );
			player.car.command( "idle" );
		}
		if( cmd == CMD_LIST )
		{
			changeGroup( ListGroup );

			UpButton.disable();
			CurrentPage = 0;
			osdCommand(CMD_UP); //Refresh page

			RefreshOsd();
		}
		else
		if( cmd >= CMD_VEH0 && cmd <= CMD_VEH29 ) // All 30 buttons
		{
			if(cmd == CMD_VEH0) ButtonNum = 0;
			if(cmd == CMD_VEH1) ButtonNum = 1;
			if(cmd == CMD_VEH2) ButtonNum = 2;
			if(cmd == CMD_VEH3) ButtonNum = 3;
			if(cmd == CMD_VEH4) ButtonNum = 4;
			if(cmd == CMD_VEH5) ButtonNum = 5;
			if(cmd == CMD_VEH6) ButtonNum = 6;
			if(cmd == CMD_VEH7) ButtonNum = 7;
			if(cmd == CMD_VEH8) ButtonNum = 8;
			if(cmd == CMD_VEH9) ButtonNum = 9;
			if(cmd == CMD_VEH10) ButtonNum = 10;
			if(cmd == CMD_VEH11) ButtonNum = 11;
			if(cmd == CMD_VEH12) ButtonNum = 12;
			if(cmd == CMD_VEH13) ButtonNum = 13;
			if(cmd == CMD_VEH14) ButtonNum = 14;
			if(cmd == CMD_VEH15) ButtonNum = 15;
			if(cmd == CMD_VEH16) ButtonNum = 16;
			if(cmd == CMD_VEH17) ButtonNum = 17;
			if(cmd == CMD_VEH18) ButtonNum = 18;
			if(cmd == CMD_VEH19) ButtonNum = 19;
			if(cmd == CMD_VEH20) ButtonNum = 20;
			if(cmd == CMD_VEH21) ButtonNum = 21;
			if(cmd == CMD_VEH22) ButtonNum = 22;
			if(cmd == CMD_VEH23) ButtonNum = 23;
			if(cmd == CMD_VEH24) ButtonNum = 24;
			if(cmd == CMD_VEH25) ButtonNum = 25;
			if(cmd == CMD_VEH26) ButtonNum = 26;
			if(cmd == CMD_VEH27) ButtonNum = 27;
			if(cmd == CMD_VEH28) ButtonNum = 28;
			if(cmd == CMD_VEH29) ButtonNum = 29;

			if(player.car) player.car.destroy();

			player.car = new Vehicle();
			player.car.chassis = new Chassis();
			player.car.chassis = create(CarScene, new GameRef(GameLogic.ChassisRoot[GameLogic.ChassisResNoumber[CurrentName+ButtonNum]]), "0,0,0,0,0,0,", "chassis");
			player.car = new Vehicle(player.car.chassis); //create(null, new GameRef(ChassisRoot[i]), "0,0,0,0,0,0,", "chassis") );

			CurrentCarName.changeText( player.car.chassis.vehicleName );

			player.car.chassis.addStockParts( new Descriptor( player.car.chassis.getTexture(), Tunning, Tunning, 1, 1) );

			player.car.command( "texture " + GameLogic.CARCOLORS[ColorIDX] + " 1" );
			
			RefreshCar();
		}
		if( cmd == CMD_AMBULANCE )
		{
			if( player.car ) player.car.destroy();

			colorSeed = Math.random()*12345;
			GameRef car1 = new GameRef( CarScene, cars.traffic.Ambulance:0x0006r, "-3,0,0"+","+"0,0,0," + colorSeed, "nightracer1" );
			player.car = new Vehicle(car1);
			CurrentCarName.changeText( "VC Ambulance" );

			LastCommand = cmd;
			RefreshCar();
		}
		else
		if( cmd == CMD_ARMOREDVAN )
		{
			if( player.car ) player.car.destroy();

			colorSeed = Math.random()*12345;
			GameRef car1 = new GameRef( CarScene, cars.traffic.ArmoredVan:0x0006r, "0,0,0"+","+"0,0,0," + colorSeed, "nightracer1" );
			player.car = new Vehicle(car1);
			CurrentCarName.changeText( "Cement Mixer" );

			LastCommand = cmd;
			RefreshCar();
		}
		else
		if( cmd == CMD_BADGE )
		{
			if( player.car ) player.car.destroy();

			colorSeed = Math.random()*12345;
			GameRef car1 = new GameRef( CarScene, cars.fake_racers.Badge:0x00000006r, "0,0,0"+","+"0,0,0," + colorSeed, "nightracer1" );
			player.car = new Vehicle(car1);
			CurrentCarName.changeText( "Dodge Charger" );

			LastCommand = cmd;
			RefreshCar();
		}
		else
		if( cmd == CMD_CIVILVAN )
		{
			if( player.car ) player.car.destroy();

			colorSeed = Math.random()*12345;
			GameRef car1 = new GameRef( CarScene, cars.traffic.CIVILVAN:0x0006r, "0,0,0"+","+"0,0,0," + colorSeed, "nightracer1" );
			player.car = new Vehicle(car1);
			CurrentCarName.changeText( "GMC Vandura" );

			RefreshCar();
			LastCommand = cmd;
		}
		else
		if( cmd == CMD_COACH )
		{
			if( player.car ) player.car.destroy();

			colorSeed = Math.random()*12345;
			GameRef car1 = new GameRef( CarScene, cars.traffic.Coach:0x0006r, "0,0,0"+","+"0,0,0," + colorSeed, "nightracer1" );
			player.car = new Vehicle(car1);
			CurrentCarName.changeText( "VC Public Bus" );

			RefreshCar();
			LastCommand = cmd;
		}
		else
		if( cmd == CMD_ERBILAC )
		{
			if( player.car ) player.car.destroy();

			colorSeed = Math.random()*12345;
			GameRef car1 = new GameRef( CarScene, cars.traffic.Erbilac:0x0006r, "0,0,0"+","+"0,0,0," + colorSeed, "nightracer1" );
			player.car = new Vehicle(car1);
			CurrentCarName.changeText( "Chevrolet C10 Tow Truck" );

			RefreshCar();
			LastCommand = cmd;
		}
		else
		if( cmd == CMD_FIREENGINE )
		{
			if( player.car ) player.car.destroy();

			colorSeed = Math.random()*12345;
			GameRef car1 = new GameRef( CarScene, cars.traffic.FireEngine:0x0006r, "0,0,0"+","+"0,0,0," + colorSeed, "nightracer1" );
			player.car = new Vehicle(car1);
			CurrentCarName.changeText( "VCFD Fire Truck" );

			RefreshCar();
			LastCommand = cmd;
		}
		else
		if( cmd == CMD_NINJA )
		{
			if( player.car ) player.car.destroy();

			colorSeed = Math.random()*12345;
			GameRef car1 = new GameRef( CarScene, cars.fake_racers.Ninja:0x0006r, "0,0,0"+","+"0,0,0," + colorSeed, "nightracer1" );
			player.car = new Vehicle(car1);
			CurrentCarName.changeText( "Honda Civic" );

			RefreshCar();
			LastCommand = cmd;
		}
		else
		if( cmd == CMD_POLICE )
		{
			if( player.car ) player.car.destroy();

			colorSeed = Math.random()*12345;
			GameRef car1 = new GameRef( CarScene, cars.Misc.Police:0x0006r, "0,0,0"+","+"0,0,0," + colorSeed, "nightracer1" );
			player.car = new Vehicle(car1);
			CurrentCarName.changeText( "VCPD Ford Crown Victoria" );

			RefreshCar();
			LastCommand = cmd;
		}
		else
		if( cmd == CMD_RCTRUCK )
		{
			if( player.car ) player.car.destroy();

			player.car = new Vehicle( CarScene, cars.Misc.RC_Truck:0x0015r, 1, 1, 1, 1, 1 );

			CurrentCarName.changeText( player.car.chassis.vehicleName );

			player.car.command( "texture " + GameLogic.CARCOLORS[ColorIDX] + " 1" );

			RefreshCar();
			LastCommand = cmd;
		}
		else
		if( cmd == CMD_SCHOOLBUS )
		{
			if( player.car ) player.car.destroy();

			colorSeed = Math.random()*12345;
			GameRef car1 = new GameRef( CarScene, cars.Traffic.Schoolbus:0x0006r, "0,0,0"+","+"0,0,0," + colorSeed, "nightracer1" );
			player.car = new Vehicle(car1);
			CurrentCarName.changeText( "VC Public School Bus" );

			RefreshCar();
			LastCommand = cmd;
		}
		else
		if( cmd == CMD_STALLION )
		{
			if( player.car ) player.car.destroy();

			colorSeed = Math.random()*12345;
			GameRef car1 = new GameRef( CarScene, cars.fake_racers.Stallion:0x0006r, "0,0,0"+","+"0,0,0," + colorSeed, "nightracer1" );
			player.car = new Vehicle(car1);
			CurrentCarName.changeText( "Nissan GTR(R35)" );

			RefreshCar();
			LastCommand = cmd;
		}
		else
		if( cmd == CMD_SUNSET )
		{
			if( player.car ) player.car.destroy();

			colorSeed = Math.random()*12345;
			GameRef car1 = new GameRef( CarScene, cars.fake_racers.Sunset:0x0006r, "0,0,0"+","+"0,0,0," + colorSeed, "nightracer1" );
			player.car = new Vehicle(car1);
			CurrentCarName.changeText( "Mitsubishi Eclipse" );

			RefreshCar();
			LastCommand = cmd;
		}
		else
		if( cmd == CMD_TAXI )
		{
			if( player.car ) player.car.destroy();

			colorSeed = Math.random()*12345;
			GameRef car1 = new GameRef( CarScene, cars.traffic.Taxi:0x0006r, "0,0,0"+","+"0,0,0," + colorSeed, "nightracer1" );
			player.car = new Vehicle(car1);
			CurrentCarName.changeText( "VC Taxi Ford Crown Victoria" );

			RefreshCar();
			LastCommand = cmd;
		}
		else
		if( cmd == CMD_TEG )
		{
			if( player.car ) player.car.destroy();

			colorSeed = Math.random()*12345;
			GameRef car1 = new GameRef( CarScene, cars.fake_racers.Teg:0x0006r, "0,0,0"+","+"0,0,0," + colorSeed, "nightracer1" );
			player.car = new Vehicle(car1);
			CurrentCarName.changeText( "Nissan Skyline GTR(R33)" );

			RefreshCar();
			LastCommand = cmd;
		}
		else
		if( cmd == CMD_WAGON )
		{
			if( player.car ) player.car.destroy();

			colorSeed = Math.random()*12345;
			GameRef car1 = new GameRef( CarScene, cars.traffic.Wagon:0x0006r, "0,0,0"+","+"0,0,0," + colorSeed, "nightracer1" );
			player.car = new Vehicle(car1);
			CurrentCarName.changeText( "Oldsmobile Vista Cruiser" );

			RefreshCar();
			LastCommand = cmd;
		}
	}

	public void run()
	{
		for(;;)
		{
			CamYpr = new Ypr( -0.01f+System.currentTime()*0.5f,-0.15,0 ); 
			CamVector = new Vector3( 0.0, 1.5, 8.5 );
			CamVector.rotate( CamYpr );
			CamYpr.p = -0.23;
			Cam.setMatrix( CamVector, CamYpr );

			CamThread.sleep(35);
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

	public void changeGroup(int group)
	{
		if( actGroup != group )
		{
			if (actGroup >= 0)
			{
				osd.hideGroup (actGroup);
			}

			actGroup = group;

			if (actGroup >= 0)
			{
				osd.showGroup (actGroup);
				osd.changeSelection2( -1, 0 );
			}
		}
	}
}