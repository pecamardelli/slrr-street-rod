package java.game;

import java.io.*;
import java.util.*;
import java.util.resource.*;
import java.render.*;	//Text
import java.render.osd.*;	//Text
import java.render.osd.dialog.*;	//Text
import java.sound.*;

public class MainMenu implements GameState
{
	MainMenuDialog mmd;

	final static public float Check( float key )
	{
		return Math.sqrt(key)+3.75;
	}

	public void enter( GameState prevState )
	{
		mmd = new MainMenuDialog();
		mmd.show();
	}

	public void exit( GameState nextState )
	{
		mmd.hide();
		mmd = null;
	}
}


public class MainMenuDialog extends OptionsDialog
{
	// Commands
	final static int	CMD_NEW			 = 50;
	final static int	CMD_EXIT		 = 51;
	final static int	CMD_LOAD		 = 52;
	final static int	CMD_BACKTOGARAGE = 53;
	final static int	CMD_DELETE		 = 54;
	final static int	CMD_CREDITS		 = 55;
	final static int	CMD_CREDITS_DONE = 56;
	final static int	CMD_COMPILEFILES = 57;
	final static int	CMD_LOADCAR		 = 58;
	final static int	CMD_SAVECAR		 = 59;
	final static int	CMD_DELETE_CAR   = 60;
	final static int	CMD_DELETE_PAINT = 61;
	final static int	CMD_EXTRAS		 = 62;
	final static int	CMD_EXTRAS_DONE  = 63;

	// Run Track Selector, FreeRide mode
	final static int	CMD_TRACKSELECT  = 64;
	
	// Car Selector:
	final static int	CMD_MENUCAR		 = 65;
	final static int	CMD_CAROK		 = 66;
	final static int	CMD_ABOUT		 = 67;
	final static int	CMD_LIGHTS		 = 68;
	final static int	CMD_MENUCAREXIT  = 69;
	final static int	CMD_RANDOMCAR	 = 70;
	final static int	CMD_AMBULANCE	 = 71;
	final static int	CMD_ARMOREDVAN	 = 72;
	final static int	CMD_BADGE		 = 73;
	final static int	CMD_CIVILVAN	 = 74;
	final static int	CMD_COACH		 = 75;
	final static int	CMD_ERBILAC		 = 76;
	final static int	CMD_FIREENGINE	 = 77;
	final static int	CMD_NINJA		 = 78;
	final static int	CMD_POLICE		 = 79;
	final static int	CMD_SCHOOLBUS	 = 80;
	final static int	CMD_STALLION	 = 81;
	final static int	CMD_SUNSET		 = 82;
	final static int	CMD_TAXI		 = 83;
	final static int	CMD_TEG			 = 84;
	final static int	CMD_WAGON		 = 85;

	// Driver Selector:
	final static int	CMD_MENUDRIVER   = 86;
	final static int	CMD_DRIVEROK     = 87;
	final static int	CMD_DRIVER0      = 88;
	final static int	CMD_DRIVER1      = 89;
	final static int	CMD_DRIVER2      = 90;
	final static int	CMD_DRIVER3      = 91;
	final static int	CMD_DRIVER4      = 92;
	final static int	CMD_DRIVER5      = 93;
	final static int	CMD_DRIVER6      = 94;
	final static int	CMD_DRIVER7      = 95;
	final static int	CMD_DRIVER8      = 96;
	final static int	CMD_DRIVER9      = 97;
	final static int	CMD_DRIVER10     = 98;
	final static int	CMD_DRIVER11     = 99;

	// Credits:
	final static float	CREDITS_SPACING0 = 0.1;		// spacing for small font
	final static float	CREDITS_SPACING1 = 0.15;	// spacing for large font
	final static float	CREDITS_TIMER = 0.20;		// speed
	final static float	CREDITS_BOTTOM = 1.2;		// offscreen pos to start new text
	final static float	CREDITS_TOP = -1.2;			// offscreen pos to stop text

	int				creditsGroup;
	Text[]			creditsTxt;
	float[]			creditsPos;
	float			creditsSpacing = 0.0;
	float			creditsTime;
	int				lastInLine, lastOutLine;
	int				creditLines;

	final static int	bgVideoActive, CarRotate;

	// osd background renderer variables
	GameRef			CarScene, DriverScene;
	RenderRef		DriverRender;
	Camera			CarCam;

	Text			careerHeader;
	Text			versionMain, versionSub;
	String			versionMainString, versionSubString;

	Button			saveCarButton, backGarageButton, TakeItButton, SelectDriverButton;

	//New groups:
	int				ExtrasGroup;
	int				CarGroup;
	int				DriverGroup;

	Style butt3 = new Style( 0.45, 0.08, Frontend.mediumFont, Text.ALIGN_CENTER, Osd.RRT_TEST );
	Style butt4 = new Style( 0.45, 0.05, Frontend.smallFont, Text.ALIGN_RIGHT, Osd.RRT_TEST );
	Style butt5 = new Style( 0.45, 0.05, Frontend.smallFont, Text.ALIGN_LEFT, Osd.RRT_TEST );

	public MainMenuDialog()
	{
		super(0);
	}

	public void show()
	{
		float key = Math.random()*100;
		if( TrackSelect.Check(key) != Math.sqrt(key)+3.75 ) Mirans_Mod_protection_error______Please_Resintal_Mirans_Mod();

		float key2 = Math.random()*100;
		if( Garage.Check(key2) != Math.sqrt(key2)+3.75 ) Mirans_Mod_protection_error______Please_Resintal_Mirans_Mod();

		float key3 = Math.random()*100;
		if( Track.Check(key3) != Math.sqrt(key3)+3.75 ) Mirans_Mod_protection_error______Please_Resintal_Mirans_Mod();

		GameLogic.klampiPatch=0;

		Sound.changeMusicSet( Sound.MUSIC_SET_MENU );

		osd.createBG( new ResourceRef( frontend:0x0006r ) );

		versionMainString = "Street Legal Racing: Redline - Light Edition";
		versionSubString = Config.version + " MWM  (build " + System.buildNumber() + ")";

		versionMain = osd.createText( versionMainString, Frontend.smallFont, Text.ALIGN_RIGHT, 0.95, -0.99 );
		versionSub = osd.createText( versionSubString, Frontend.smallFont, Text.ALIGN_RIGHT, 0.95, -0.94 );

		osd.endGroup();

		super.show();

		changeMode (mainGroup);
	}

	public void hide()
	{
		super.hide();
	}

	public void addCustomGroups()
	{
		Menu	m;

		//--------------main menu--------------

		osd.createBG( RID_GENERALBG );
		osd.createHeader( "MAIN MENU" );

		m = osd.createMenu( butt1, 0.0, -0.6, 0 );
		m.addItem( "NEW CAREER", CMD_NEW );
		m.addItem( "LOAD CAREER", CMD_LOAD );
		m.addSeparator();
		m.addItem( "LOAD CAR", CMD_LOADCAR );
		saveCarButton = m.addItem( "SAVE CAR", CMD_SAVECAR );
		m.addSeparator();
		m.addItem( "OPTIONS", CMD_OPTIONS );
		m.addItem( "EXTRAS", CMD_EXTRAS );
		m.addItem( "EXIT", CMD_EXIT );

		m = osd.createMenu( butt2, 0.98, 0.95, 0 );
		backGarageButton = m.addItem( "BACK TO GARAGE", CMD_BACKTOGARAGE );

		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_EXIT, this );
		osd.hideGroup( mainGroup = osd.endGroup() );

		//--------------extras menu--------------

		osd.hideGroup( ExtrasGroup = osd.beginGroup() );

		osd.createBG( RID_GENERALBG );
		osd.createHeader( "EXTRAS" );

		m = osd.createMenu( butt1, 0.0, -0.6, 0 );
		m.addItem( "SELECT CAR", CMD_MENUCAR );
		m.addItem( "SELECT TRACK", CMD_TRACKSELECT );
		m.addSeparator();
		m.addItem( "DELETE CAREER", CMD_DELETE );
		m.addItem( "DELETE CAR", CMD_DELETE_CAR );
		m.addItem( "DELETE PAINTJOB", CMD_DELETE_PAINT );
		m.addSeparator();
		m.addItem( "CREDITS", CMD_CREDITS );

		m = osd.createMenu( butt0, -0.98, 0.95, 0 );
		m.addItem( "DEBUG COMPILE ALL JAVAs", CMD_COMPILEFILES );

		m = osd.createMenu( butt2, 0.98, 0.95, 0 );
		m.addItem( "BACK", CMD_EXTRAS_DONE );

		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_EXTRAS_DONE, this );

		osd.endGroup();

		//---------------------credits menu-------------------

		osd.hideGroup( creditsGroup = osd.beginGroup() );
	
		osd.createBG( new ResourceRef( MW_Mod:0x0160r ) );

		m = osd.createMenu( butt2, 0.98, 0.95, 0 );
		m.addItem( "BACK", CMD_CREDITS_DONE );

		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_CREDITS_DONE, this );
		buildCredits();

		osd.endGroup();

		//--------------Traffic car select menu--------------
		
		osd.hideGroup( CarGroup = osd.beginGroup() );

		osd.createBG( RID_GENERALBG );
		osd.createHeader( "SELECT CAR" );

		m = osd.createMenu( butt0, -0.98, -0.45, 0 );
		m.addItem( "Ambulance", CMD_AMBULANCE );
		m.addItem( "Armored Van", CMD_ARMOREDVAN );
		m.addItem( "Badge", CMD_BADGE );
		m.addItem( "Civil Van", CMD_CIVILVAN );
		m.addItem( "Coach", CMD_COACH );
		m.addItem( "Erbilac", CMD_ERBILAC );
		m.addItem( "Fire Engine", CMD_FIREENGINE );
		m.addItem( "Ninja", CMD_NINJA );

		m = osd.createMenu( butt2, 0.98, -0.45, 0 );
		m.addItem( "Police", CMD_POLICE );
		m.addItem( "School Bus", CMD_SCHOOLBUS );
		m.addItem( "Stallion", CMD_STALLION );
		m.addItem( "Sunset", CMD_SUNSET );		
		m.addItem( "Taxi", CMD_TAXI );
		m.addItem( "Teg", CMD_TEG );
		m.addItem( "Wagon", CMD_WAGON );
		m.addItem( "RANDOM CAR", CMD_RANDOMCAR );

		m = osd.createMenu( butt0, -0.98, 0.85, 0 );
		m.addItem( "BACK", CMD_MENUCAREXIT );

		m = osd.createMenu( butt1, 0.00, 0.85, 0 );
		m.addItem( "LIGHTS ON/OFF", CMD_LIGHTS );

		m = osd.createMenu( butt1, 0.00, -0.83, 0 );
		SelectDriverButton = 
		m.addItem( "SELECT DRIVER", CMD_MENUDRIVER );

		m = osd.createMenu( butt2, 0.98, -0.83, 0 );
		m.addItem( "ABOUT", CMD_ABOUT );

		m = osd.createMenu( butt2, 0.98, 0.85, 0 );
		TakeItButton = 
		m.addItem( "TAKE IT", CMD_CAROK );

		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_MENUCAREXIT, this );

		osd.endGroup();

		//---------------------Driver Slelctor menu-------------------

		osd.hideGroup( DriverGroup = osd.beginGroup() );
	
		osd.createBG( RID_GENERALBG );
		osd.createHeader( "SELECT DRIVER" );

		m = osd.createMenu( butt2, 0.98, -0.83, 0 );
		m.addItem( "ABOUT", CMD_ABOUT );

		m = osd.createMenu( butt0, -0.98, -0.65, 0 );
		m.addItem( "NO DRIVER", CMD_DRIVER0 );
		m.addItem( "Jessy James", CMD_DRIVER5, "From Monster Garage" );
		m.addItem( "Mitch Whole", CMD_DRIVER1, "Default Driver" );
		m.addItem( "Opponent 1", CMD_DRIVER2 );
		m.addItem( "Opponent 2", CMD_DRIVER3 );
		m.addItem( "Policeman", CMD_DRIVER4 );

		m.addItem( "Proffesional racer", CMD_DRIVER6, "By GameRED" );
		m.addItem( "Tommy Vercetti", CMD_DRIVER7, "By Miran" );
		m.addItem( "Common Guy", CMD_DRIVER8, "By Gruchowski" );
		m.addItem( "Elegant racer", CMD_DRIVER9, "By Lokerlol" );
		m.addItem( "Rambo Ziom", CMD_DRIVER10, "By Lokerlol" );
		m.addItem( "Idler style", CMD_DRIVER11, "By Lokerlol" );

		m = osd.createMenu( butt2, 0.98, 0.85, 0 );
		m.addItem( "OK", CMD_DRIVEROK );

		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_DRIVEROK, this );

		osd.endGroup();
	}

	public void osdCommand (int command)
	{
		if (command < 0)
			return;
		else
		if (command == CMD_AMBULANCE)
		{	
			player.car.destroy();
			TakeItButton.enable();
			SelectDriverButton.disable();
			player.driverID = NoDriver:0x0000000Cr ; //No driver in this car
			
			player.car = new Vehicle( CarScene, cars.traffic.Ambulance:0x0006r, 1, 1.0, 0.0, 1.0, 1.0 );
			//player.car.setMatrix( new Vector3(0,0,0), new Ypr(-0.01f+System.currentTime()*1.02f,0,0) );
			player.car.command( "idle" );
			player.car.command( "setsteer -0.6" ); 
		}
		else
		if (command == CMD_ARMOREDVAN)
		{	
			player.car.destroy();
			TakeItButton.enable();
			SelectDriverButton.disable();
			player.driverID = NoDriver:0x0000000Cr ; //No driver in this car

			player.car.destroy();
			player.car = new Vehicle( CarScene, cars.traffic.ArmoredVan:0x0006r, 6, 2.0, 0.0, 1.0, 1.0 );
			player.car.command( "idle" );
			player.car.command( "setsteer -0.6" );
		}
		else
		if (command == CMD_BADGE)
		{	
			player.car.destroy();
			TakeItButton.enable();
			SelectDriverButton.disable();
			player.driverID = NoDriver:0x0000000Cr ; //No driver in this car
			player.car = new Vehicle ( CarScene, cars.fake_racers.Badge:0x00000006r, 0, 0, 0, 0, 0.);

			player.car.command( "idle" );
			player.car.command( "setsteer -0.6" );
		}
		else
		if (command == CMD_CIVILVAN)
		{	
			player.car.destroy();
			TakeItButton.enable();
			SelectDriverButton.disable();
			player.driverID = NoDriver:0x0000000Cr ; //No driver in this car

			player.car = new Vehicle( CarScene, cars.traffic.CIVILVAN:0x0006r, 6, 2.0, 0.0, 1.0, 1.0 );
			player.car.command( "idle" );
			player.car.command( "setsteer -0.6" );

		}
		else
		if (command == CMD_COACH)
		{	
			player.car.destroy();
			TakeItButton.enable();
			SelectDriverButton.disable();
			player.driverID = NoDriver:0x0000000Cr ; //No driver in this car
			
			player.car = new Vehicle( CarScene, cars.traffic.Coach:0x0006r, 6, 2.0, 0.0, 1.0, 1.0 );
			player.car.command( "idle" );
			player.car.command( "setsteer -0.6" );
		}
		else
		if (command == CMD_ERBILAC)
		{	
			player.car.destroy();
			TakeItButton.enable();
			SelectDriverButton.disable();
			player.driverID = NoDriver:0x0000000Cr ; //No driver in this car
			
			player.car = new Vehicle( CarScene, cars.traffic.Erbilac:0x0006r, 6, 2.0, 0.0, 1.0, 1.0 );
			player.car.command( "idle" );
			player.car.command( "setsteer -0.6" );
		}
		else
		if (command == CMD_FIREENGINE)
		{	
			player.car.destroy();
			TakeItButton.enable();
			SelectDriverButton.disable();
			player.driverID = NoDriver:0x0000000Cr ; //No driver in this car
			
			player.car = new Vehicle( CarScene, cars.traffic.FireEngine:0x0006r, 6, 2.0, 0.0, 1.0, 1.0 );
			player.car.command( "idle" );
			player.car.command( "setsteer -0.6" );
		}
		else
		if (command == CMD_NINJA)
		{	
			player.car.destroy();
			TakeItButton.enable();
			SelectDriverButton.disable();
			player.driverID = NoDriver:0x0000000Cr ; //No driver in this car

			player.car = new Vehicle( CarScene, cars.fake_racers.Ninja:0x0006r, 6, 2.5, 0.0, 1.0, 1.0 );
			player.car.command( "idle" );
			player.car.command( "setsteer -0.6" );
		}
		else
		if (command == CMD_POLICE)
		{	
			player.car.destroy();
			TakeItButton.enable();
			SelectDriverButton.enable();
			
			player.car = new Vehicle( CarScene, cars.Misc.Police:0x0006r, 0, 0.0, 0.0, 0.0, 0.0 );
			player.car.command( "idle" );
			player.car.command( "setsteer -0.6" );
			player.driverID = humans:0x0000000Cr ;
		}
		else
		if (command == CMD_SCHOOLBUS)
		{	
			player.car.destroy();
			TakeItButton.enable();
			SelectDriverButton.disable();
			player.driverID = NoDriver:0x0000000Cr ; //No driver in this car
			
			player.car = new Vehicle( CarScene, cars.Traffic.Schoolbus:0x0006r, 6, 2.0, 0.0, 1.0, 1.0 );
			player.car.command( "idle" );
			player.car.command( "setsteer -0.6" );
		}
		else
		if (command == CMD_STALLION)
		{	
			player.car.destroy();
			TakeItButton.enable();
			SelectDriverButton.disable();
			player.driverID = NoDriver:0x0000000Cr ; //No driver in this car
			
			player.car = new Vehicle( CarScene, cars.fake_racers.Stallion:0x0006r, 6, 2.5, 0.0, 1.0, 1.0 );
			player.car.command( "idle" );
			player.car.command( "setsteer -0.6" );
		}
		else
		if (command == CMD_SUNSET)
		{	
			player.car.destroy();
			TakeItButton.enable();
			SelectDriverButton.disable();
			player.driverID = NoDriver:0x0000000Cr ; //No driver in this car
			
			player.car = new Vehicle( CarScene, cars.fake_racers.Sunset:0x0006r, 6, 2.5, 0.0, 1.0, 1.0 );
			player.car.command( "idle" );
			player.car.command( "setsteer -0.6" );
		}
		else
		if (command == CMD_TAXI)
		{	
			player.car.destroy();
			TakeItButton.enable();
			SelectDriverButton.disable();
			player.driverID = NoDriver:0x0000000Cr ; //No driver in this car
			
			player.car = new Vehicle( CarScene, cars.traffic.Taxi:0x0006r, 6, 2.0, 0.0, 1.0, 1.0 );
			player.car.command( "idle" );
			player.car.command( "setsteer -0.6" );
		}
		else
		if (command == CMD_TEG)
		{	
			player.car.destroy();
			TakeItButton.enable();
			SelectDriverButton.disable();
			player.driverID = NoDriver:0x0000000Cr ; //No driver in this car
			
			player.car = new Vehicle( CarScene, cars.fake_racers.Teg:0x0006r, 6, 2.5, 0.0, 1.0, 1.0 );
			player.car.command( "idle" );
			player.car.command( "setsteer -0.6" );
		}
		else
		if (command == CMD_WAGON)
		{	
			player.car.destroy();
			TakeItButton.enable();
			SelectDriverButton.disable();
			player.driverID = NoDriver:0x0000000Cr ; //No driver in this car
			
			player.car = new Vehicle( CarScene, cars.traffic.Wagon:0x0006r, 6, 2.0, 0.0, 1.0, 1.0 );
			player.car.command( "idle" );
			player.car.command( "setsteer -0.6" );
		}
		else
		if (command == CMD_RANDOMCAR)
		{	
			player.car.destroy();
			TakeItButton.enable();
			SelectDriverButton.enable();

			VehicleDescriptor vd = GameLogic.getVehicleDescriptor( VehicleType.VS_DEMO );
			player.car = new Vehicle( CarScene, vd.id, vd.colorIndex, vd.optical, vd.power, vd.wear, vd.tear );
			player.car.command( "idle" );
			player.car.command( "setsteer -0.6" );
			player.driverID = humans:0x0000000Cr ;
		}
		else
		if (command == CMD_CAROK)
		{
			//player.car.wakeUp(); //Spada
			//Thread.sleep( 1000 ); //Czeka chwile
			Frontend.loadingScreen.show();
			GameLogic.gameMode = GameLogic.GM_SINGLECAR;;
			GameLogic.setTime( (Math.random()*14+4)*3600 );
			player.money = 0;
			GameLogic.changeActiveSection (GameLogic.garage);
			CarScene.destroy();
		}
		else
        if (command == CMD_TRACKSELECT)
        {
			if( GameLogic.autoSave() )
			{
				GameLogic.loadDefaults();
				GameLogic.gameMode = GameLogic.GM_FREERIDE;
				GameLogic.setTime( (Math.random()*14+4)*3600 );
				
				if (!player.car)
				{
					VehicleDescriptor vd = GameLogic.getVehicleDescriptor( VehicleType.VS_DEMO );
					player.car = new Vehicle( player, vd.id, vd.colorIndex, vd.optical, vd.power, vd.wear, vd.tear );
				}

				GameLogic.changeActiveSection( new TrackSelect() );
			}
		}
		else
		if (command == CMD_LIGHTS)
		{
			player.car.command( "reset" );
			GameLogic.spendTime( 12*3600 );
			player.car.command( "idle" );
		}
		else
		if (command == CMD_ABOUT)
		{
			new WarningDialog( GameLogic.player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG|Dialog.DF_WIDE, "ABOUT", "It's ALPCHA version! \n \n By Miran" ).display();
		}
		else
		if( command == CMD_MENUCAR )
		{
			GameLogic.changeActiveSection( new CarSelect() );
		}
		else
		if (command == CMD_DRIVEROK)
		{
			changeMode( CarGroup );
			player.car.setMatrix( new Vector3(0,0,0), new Ypr(0,0,0) );
			player.car.command( "reset" );
			player.car.command( "idle" );
			player.car.command( "setsteer -0.6" );
			DriverScene.destroy();
		}
		else
		if (command == CMD_DRIVER0)
		{
			DriverRender.destroy();
			DriverRender = new RenderRef( DriverScene, NoDriver:0x0000000Cr, "No Driver" );
			player.driverID = NoDriver:0x0000000Cr ;
		}
		else
		if (command == CMD_DRIVER1)
		{
			DriverRender.destroy();
			DriverRender = new RenderRef( DriverScene, humans:0x0000000Cr, "Default driver" );
			player.driverID = humans:0x0000000Cr ;
		}
		else
		if (command == CMD_DRIVER2)
		{
			DriverRender.destroy();
			DriverRender = new RenderRef( DriverScene, humans:0x00000007r, "Opponent 1" );
			player.driverID = humans:0x00000007r ;
		}
		else
		if (command == CMD_DRIVER3)
		{
			DriverRender.destroy();
			DriverRender = new RenderRef( DriverScene, humans:0x00000008r, "Opponent 2" );
			player.driverID = humans:0x00000008r ;
		}
		else
		if (command == CMD_DRIVER4)
		{
			DriverRender.destroy();
			DriverRender = new RenderRef( DriverScene, humans:0x00000018r, "Policeman" );
			player.driverID = humans:0x00000018r ;
		}
		else
		if (command == CMD_DRIVER5)
		{
			DriverRender.destroy();
			DriverRender = new RenderRef( DriverScene, MW_Mod:0x00000022r, "MG Jessy James" );
			player.driverID = MW_Mod:0x00000022r ;
		}
		else
		if (command == CMD_DRIVER6)
		{
			DriverRender.destroy();
			DriverRender = new RenderRef( DriverScene, MW_Mod:0x00000059r, "Proffesional racer" );
			player.driverID = MW_Mod:0x00000059r ;
		}
		else
		if (command == CMD_DRIVER7)
		{
			DriverRender.destroy();
			DriverRender = new RenderRef( DriverScene, MW_Mod:0x00000057r, "Tommy Vercetti" );
			player.driverID = MW_Mod:0x00000057r ;
		}
		else
		if (command == CMD_DRIVER8)
		{
			DriverRender.destroy();
			DriverRender = new RenderRef( DriverScene, MW_Mod:0x00000061r, "Common Guy" );
			player.driverID = MW_Mod:0x00000061r ;
		}
		else
		if (command == CMD_DRIVER9)
		{
			DriverRender.destroy();
			DriverRender = new RenderRef( DriverScene, MW_Mod:0x00000063r, "Elegant" );
			player.driverID = MW_Mod:0x00000063r ;
		}
		else
		if (command == CMD_DRIVER10)
		{
			DriverRender.destroy();
			DriverRender = new RenderRef( DriverScene, MW_Mod:0x00000065r, "Rambo" );
			player.driverID = MW_Mod:0x00000065r ;
		}
		else
		if (command == CMD_DRIVER11)
		{
			DriverRender.destroy();
			DriverRender = new RenderRef( DriverScene, MW_Mod:0x00000067r, "Idler" );
			player.driverID = MW_Mod:0x00000067r ;
		}
		else
		if( command == CMD_LOADCAR )
		{
			if( GameLogic.autoSave() )
			{
				VehicleFileReqDialog d = new VehicleFileReqDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "LOAD CAR", "LOAD CAR", GameLogic.carSaveDir, "*" );
				if( d.display() == 0 )
				{
					String filename = GameLogic.carSaveDir + d.fileName;

					Frontend.loadingScreen.show();

					GameLogic.loadDefaults();

					GameLogic.gameMode = GameLogic.GM_SINGLECAR;

					player.car = Vehicle.load( filename, player );

					player.money = 1000000;

					GameLogic.changeActiveSection( GameLogic.garage );
				}

			}
		}
		else
		if( command == CMD_SAVECAR )
		{
			VehicleFileReqDialog d = new VehicleFileReqDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG|Dialog.FRF_SAVE, "SAVE CAR", "SAVE CAR", GameLogic.carSaveDir, "*" );

			if( d.display() == 0 )
			{
				String filename = GameLogic.carSaveDir + d.fileName;
				if( File.exists( filename ) )
				{
					File.delete( filename );
					File.delete( filename + ".*" );
				}

				player.car.save( filename );
				new WarningDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "SAVE CAR", "Your current car has been saved." ).display();
			}
		}
		else
        if( command == CMD_COMPILEFILES )
        {
			System.compileAll( "." );
			new SfxRef( Frontend.SFX_WARNING ).play(); 
		}
		else
		if( command == CMD_NEW )
		{
			if( GameLogic.autoSave() )
			{
				StringRequesterDialog d = new StringRequesterDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG|Dialog.SIF_NOEMPTY, "Enter player name", "" );
				if( d.display() == 0 )
				{
					player.name = d.input;

					new PlayerSetupDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "Choose character", player ).display();

					Frontend.loadingScreen.show();
					GameLogic.loadDefaults();

					GameLogic.carrerInProgress = 1;
					GameLogic.autoSaveQuiet();

					GameLogic.changeActiveSection( GameLogic.garage );
				}
			}
		}
		else
		if( command == CMD_LOAD )
		{
			CarrerFileReqDialog d = new CarrerFileReqDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "LOAD CAREER", "LOAD CAREER", GameLogic.carrerSaveDir, "*", FindFile.DIRS_ONLY );

			if( d.display() == 0 )
			{
				String filename = GameLogic.carrerSaveDir + d.fileName;

				int currentCarreer = 0;

				if( currentCarreer )
				{
					new WarningDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "Load career", "This is your current career file, you cannot reload it." ).display();
				}
				else
				{
					if( GameLogic.autoSave() )
					{
						Frontend.loadingScreen.show();

						int error = GameLogic.load( filename + "/" );
						if( !error )
						{
							GameLogic.carrerInProgress = 1;
							GameLogic.changeActiveSection( GameLogic.garage );
						}
						else
						{
							// give warning sound & text
							new SfxRef( Frontend.SFX_WARNING ).play(); 
							Frontend.loadingScreen.hide();
							new WarningDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "WARNING", "Corupt savegame file. \n Loading terminated." ).display();
							GameLogic.erase();	//ki tudja, mi szemetet hagyot bent?
						}
					}
				}
			}
		}
		else
		if( command == CMD_DELETE )
		{
			CarrerFileReqDialog d = new CarrerFileReqDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "DELETE CAREER", "DELETE CAREER", GameLogic.carrerSaveDir, "*", FindFile.DIRS_ONLY );

			if( d.display() == 0 )
			{
				String filename = GameLogic.carrerSaveDir + d.fileName;

				int currentCarreer = 0;
				if( GameLogic.gameMode == GameLogic.GM_CARREER && GameLogic.carrerInProgress
					&& GameLogic.player.name + "-" + (GameLogic.player.club+1) == d.fileName ) {
					currentCarreer = 1;
				}
				int reallyDelete;

				if( currentCarreer )
					reallyDelete = ( 0 == new NoYesDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "Delete career", "Do you really want to delete your ongoing career?" ).display() );
				else
					reallyDelete = ( 0 == new NoYesDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "Delete career", "Do you really want to continue?" ).display() );

				if( reallyDelete )
				{
					if( currentCarreer )
					{
						GameLogic.erase();
						backGarageButton.disable();
					}

					File.delete( filename + "/", "*" );
					File.delete( filename );
				}
			}
		}
		else
		if( command == CMD_DELETE_CAR )
		{
			VehicleFileReqDialog d = new VehicleFileReqDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "DELETE CAR", "DELETE CAR", GameLogic.carSaveDir, "*" );

			if( d.display() == 0 )
			{
				String filename = GameLogic.carSaveDir + d.fileName;

				int selectedCar = 0;
				int reallyDelete;

				if( selectedCar )
					reallyDelete = ( 0 == new NoYesDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "Delete car", "Do you really want to delete your car?" ).display() );
				else
					reallyDelete = ( 0 == new NoYesDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "Delete car", "Do you really want to continue?" ).display() );

				if( reallyDelete )
				{
					for(int i = 1; i <= 50; ++i)
					{
						File.delete( filename + "." + i );
					}
					File.delete( filename );
				}
			}
		}
		else
		if( command == CMD_DELETE_PAINT )
		{
			VehicleSkinFileReqDialog d = new VehicleSkinFileReqDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "DELETE PAINTJOB", "DELETE PAINTJOB", GameLogic.skinSaveDir, "*" );

			if( d.display() == 0 )
			{
				String filename = GameLogic.skinSaveDir + d.fileName;

				int selectedPJ = 0;
				int reallyDelete;

				if( selectedPJ )
					reallyDelete = ( 0 == new NoYesDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "Delete paintjob", "Do you really want to delete your paintjob?" ).display() );
				else
					reallyDelete = ( 0 == new NoYesDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "Delete paintjob", "Do you really want to continue?" ).display() );

				if( reallyDelete )
				{
					for(int i = 1; i <= 50; ++i)
					{
						File.delete( filename + "." + i );
					}
					File.delete( filename );
				}
			}
		}
		else
		if( command == CMD_BACKTOGARAGE )
		{
			GameLogic.changeActiveSection( GameLogic.garage );
		}
		else
		if( command == CMD_EXIT )
		{
			int reallyExit;
			int	carreerMode = ( GameLogic.gameMode == GameLogic.GM_CARREER && GameLogic.carrerInProgress );

			if( carreerMode )
				reallyExit = ( 0 == new NoYesDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "EXIT", "Do you really want to Exit? \n \n Note that your current career will be automatically saved." ).display() );
			else
				reallyExit = ( 0 == new NoYesDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "EXIT", "Do you really want to Exit?" ).display() );

			if( reallyExit )				
			{
				if( carreerMode )
					GameLogic.autoSaveQuiet();

				GameLogic.changeActiveSection( null );
			}
		}
		else
		if( command == CMD_CREDITS )
		{
			versionMain.changeText( null );
			versionSub.changeText( null );
			Vector3 v = new Vector3( 0.0, 1.0, 0.0 );
			for (int i = 0; i < creditLines; i++)
			{
				creditsTxt[i].renderinst.setMatrix ( v, null );
				creditsPos[i] = 0.0;
			}
			creditsPos[0] = CREDITS_BOTTOM;
			lastInLine = 0;
			lastOutLine = 0;
			creditsSpacing = 0.0;
			changeMode( creditsGroup );
			creditsTime = System.currentTime();
		}
		else
		if( command == CMD_CREDITS_DONE )
		{
			versionMain.changeText( versionMainString );
			versionSub.changeText( versionSubString );
			changeMode( ExtrasGroup );
		}
		else
		if( command == CMD_EXTRAS )
		{
			changeMode( ExtrasGroup );
		}
		else
		if( command == CMD_EXTRAS_DONE )
		{
			changeMode( mainGroup );
		}
		else
			super.osdCommand( command );
	}

	public void changeMode(int group)
	{
		super.changeMode( group );

		if( actGroup == mainGroup )
		{
			if( (GameLogic.gameMode == GameLogic.GM_CARREER || GameLogic.gameMode == GameLogic.GM_SINGLECAR) && GameLogic.player.car )
				saveCarButton.enable();
			else
				saveCarButton.disable();

			if( GameLogic.played )
			{
				//saveButton.enable();
				backGarageButton.enable();
			}
			else
			{
				//saveButton.disable();
				backGarageButton.disable();
			}
		}
	}


	public void animate()
	{
		if (actGroup == CarGroup)
		{
			//CarCamAngle+=0.003;
			Ypr CarYpr = new Ypr( -0.01f+System.currentTime()*0.5f,-0.15,0 ); 
			//Ypr CarYpr = new Ypr( CarCamAngle, 0.0, 0.0 );
			Vector3 CarVector = new Vector3( 0.0, 1.2, 8.5 );
			CarVector.rotate( CarYpr );
			CarYpr.p = -0.23;
			CarCam.setMatrix( CarVector, CarYpr );
		}
		else
		if (actGroup == creditsGroup)
		{
			int i, font;
			float move, time;
			Vector3 v = new Vector3( 0.0, 0.0, 0.0 );
			String str;

			time = System.currentTime();
			move = (time - creditsTime) * CREDITS_TIMER;
			creditsTime = time;

			if( creditsPos[lastInLine] <= CREDITS_BOTTOM - creditsSpacing )
			{
				if( ++lastInLine >= creditLines )
					lastInLine = 0;

				creditsPos[lastInLine] = CREDITS_BOTTOM;
				v.y = creditsPos[lastInLine];
				creditsSpacing = CREDITS_SPACING0;

				creditsTxt[lastInLine].renderinst.setMatrix ( v, null );
			}

			i = lastOutLine;
			int j, endc = lastInLine;
			if( endc < i )
				endc+=creditLines;

			for( ; i <= endc; i++)
			{
				j = i % creditLines;

				creditsPos[j] -= move;
				v.y = creditsPos[j];
				creditsTxt[j].renderinst.setMatrix ( v, null );
				if( v.y < CREDITS_TOP )
					lastOutLine = j;
			}
		}

		super.animate();
	}

	public void buildCredits()
	{
		creditsTxt = new Text[288];
		creditsPos = new float[288];

		creditLines = 0;

		addCreditLine( 1, "STREET LEGAL RACING: REDLINE - LIGHT EDITION" );
		addCreditLine( 1, "" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Did Stuff" );
		addCreditLine( 1, "Michael Shinoda" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Made Stuff" );
		addCreditLine( 1, "Michael Shinoda" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Fixed Stuff" );
		addCreditLine( 1, "Michael Shinoda" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Coolest Guy In The World" );
		addCreditLine( 1, "Michael Shinoda" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Frontend Textures" );
		addCreditLine( 1, "FallVL" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Navigator and Lights Scripts" );
		addCreditLine( 1, "Lyoncha" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Swaybars Sripts" );
		addCreditLine( 1, "Mindeliszz" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Suspension Scripts" );
		addCreditLine( 1, "MisterSir" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Adjustable Engine Scripts" );
		addCreditLine( 1, "Apendix" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Garage Cursor Fix" );
		addCreditLine( 1, "RAXAT" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "NOS Flames Texture" );
		addCreditLine( 1, "G4TNT" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Lights and Smoke Textures" );
		addCreditLine( 1, "BenyUK" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Catalog Kit Texture" );
		addCreditLine( 1, "Jack_1990" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Steelies Model" );
		addCreditLine( 1, "Andrey Sych" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Edited Objects" );
		addCreditLine( 1, "GTR-X-ITE" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Testing, Help and Support" );
		addCreditLine( 1, "Vasya Ivanov" );
		addCreditLine( 1, "Maxim Tiranov" );
		addCreditLine( 1, "Nikita Vishnyovsky" );
		addCreditLine( 1, "Grisha Fagradyan" );
		addCreditLine( 1, "Markovich Lazar" );
		addCreditLine( 1, "Konstantin Kosov" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "SLR God" );
		addCreditLine( 1, "RAXAT" );
		addCreditLine( 1, "" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "" );
		addCreditLine( 1, "STREET LEGAL RACING: REDLINE BY BIGG BOSS93" );
		addCreditLine( 1, "" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Big Boss" );
		addCreditLine( 1, "Bigg Boss93" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Base Game (Stage 1)" );
		addCreditLine( 1, "Diegorborges" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Traffic, Fake Racers and Valo's Meshes Ripping" );
		addCreditLine( 1, "DHR" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Beta Tester for Garage Crash Fix" );
		addCreditLine( 1, "Facepalm" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Painter Script" );
		addCreditLine( 1, "Harrison15" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Extended Memory Executable Tweak Suggestions" );
		addCreditLine( 1, "Illking" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Crash on Startup Bugfix" );
		addCreditLine( 1, "JoeAlex" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "HD Icons" );
		addCreditLine( 1, "Mindeliszz" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Help on Alpha Sorting" );
		addCreditLine( 1, "Miran" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Textures Research" );
		addCreditLine( 1, "Pro7" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Help on Many Issues" );
		addCreditLine( 1, "RAXAT" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Top Alpha/Beta Tester" );
		addCreditLine( 1, "Remco" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Skyline R33 Traffic Car" );
		addCreditLine( 1, "Robban9000" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Beta Test" );
		addCreditLine( 1, "Boss' Crew" );
		addCreditLine( 1, "DS members" );
		addCreditLine( 1, "" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "" );
		addCreditLine( 1, "STREET LEGAL RACING: REDLINE MIRAN WICHUR MOD" );
		addCreditLine( 1, "" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Created by" );
		addCreditLine( 1, "Miran" );
		addCreditLine( 1, "Wichur" );
		addCreditLine( 1, "" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "" );
		addCreditLine( 1, "STREET LEGAL RACING: REDLINE" );
		addCreditLine( 1, "" );
		addCreditLine( 0, "" );
		addCreditLine( 1, "ACTIVISION VALUE CREDITS" );
		addCreditLine( 1, "" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "General Manager " );
		addCreditLine( 1, "Dave Oxford" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Senior Vice President" );
		addCreditLine( 1, "Chad Koehler" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Vice President of Studios" );
		addCreditLine( 1, "Patrick Kelly" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Vice President of Marketing and Creative Services" );
		addCreditLine( 1, "Mark Meadows" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Vice President of Sales" );
		addCreditLine( 1, "Tim Flaherty" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Senior Counsel" );
		addCreditLine( 1, "Joe Hedges" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Producer" );
		addCreditLine( 1, "Sean Dunnigan" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Assistant Producer" );
		addCreditLine( 1, "Jason Lembcke" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Manager of Quality Assurance" );
		addCreditLine( 1, "Chris Arends" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "QA Lead" );
		addCreditLine( 1, "Chad Schilling" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "QA Team" );
		addCreditLine( 1, "Bob Viau" );
		addCreditLine( 1, "Isham Ashour" );
		addCreditLine( 1, "Travis Clarke" );
		addCreditLine( 1, "Bill Hart" );
		addCreditLine( 1, "Donna Johnston" );
		addCreditLine( 1, "Ryan Lee" );
		addCreditLine( 1, "Kris Young" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Brand and Licensing Manager" );
		addCreditLine( 1, "Andy Koehler" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Trade Marketing Manager" );
		addCreditLine( 1, "Robbin Livernois" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Senior Graphic Artist" );
		addCreditLine( 1, "Trevor Harveaux" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Graphic Artist" );
		addCreditLine( 1, "Sean James" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Video Production Coordinator" );
		addCreditLine( 1, "Skye Thomas" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Information Systems Administrator" );
		addCreditLine( 1, "Josh Miedema" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Regional Sales Directors" );
		addCreditLine( 1, "Dan Matschina" );
		addCreditLine( 1, "Jim Holland" );
		addCreditLine( 1, "Jennifer Mirabelli" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Director of OEM & Alternative Channels" );
		addCreditLine( 1, "Brian Johnson" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Music by:" );
		addCreditLine( 1, "Lost City www.wolfpack1.com" );
		addCreditLine( 1, "Nathan Howard" );
		addCreditLine( 1, "David Kellogg" );
		addCreditLine( 1, "Diandre Hodges" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Song list:" );
		addCreditLine( 1, "Redline" );
		addCreditLine( 1, "Ali, Ali" );
		addCreditLine( 1, "We Roll" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Special Thanks" );
		addCreditLine( 1, "Anne Beggs" );
		addCreditLine( 1, "Don Borchers" );
		addCreditLine( 1, "Mike Dalton" );
		addCreditLine( 1, "Nicole Bement" );
		addCreditLine( 1, "Brian Kirkvold" );
		addCreditLine( 1, "Keri Gross" );
		addCreditLine( 1, "Mike Groshens" );
		addCreditLine( 1, "Kurt Niederloh" );
		addCreditLine( 1, "Chris Owen" );
		addCreditLine( 1, "Laura Saugen" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Additional Thanks" );
		addCreditLine( 1, "Emily Bauman" );
		addCreditLine( 1, "" );
		addCreditLine( 1, "" );
		addCreditLine( 1, "" );
		addCreditLine( 1, "" );
		addCreditLine( 1, "INVICTUS CREDITS" );
		addCreditLine( 1, "" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Producer" );
		addCreditLine( 1, "Tamas Kozak" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Lead Programmer" );
		addCreditLine( 1, "Denes Nagymathe" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Programming" );
		addCreditLine( 1, "Akos Divianszky" );
		addCreditLine( 1, "Laszlo Javorszky" );
		addCreditLine( 1, "Zsolt Klampeczki" );
		addCreditLine( 1, "Attila Kocsis" );
		addCreditLine( 1, "Jozsef Punk" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Tool Programming" );
		addCreditLine( 1, "Gabor Simon" );
		addCreditLine( 1, "Jozsef Punk" );
		addCreditLine( 1, "Zsolt Klampeczki" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Artwork" );
		addCreditLine( 1, "Tibor Mester" );
		addCreditLine( 1, "Csaba Csukas" );
		addCreditLine( 1, "Viktor Sass" );
		addCreditLine( 1, "Jozsef Bakos" );
		addCreditLine( 1, "David Szabo" );
		addCreditLine( 1, "Otto Feldmajer" );
		addCreditLine( 1, "Janos Varadi" );
		addCreditLine( 1, "Gabor Simon" );
		addCreditLine( 1, "Laszlo Fesus" );
		addCreditLine( 1, "Peter Gazso" );
		addCreditLine( 1, "Tibor Valyi" );
		addCreditLine( 1, "Zoltan Saghy" );
		addCreditLine( 1, "Balazs Borsos" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "Music by" );
		addCreditLine( 1, "HOTEL SINUS www.hotelsinus.com" );
		addCreditLine( 1, "Laszlo Zizics" );
		addCreditLine( 1, "Gergo Ergelyi" );
		addCreditLine( 0, "" );
		addCreditLine( 0, "SFX" );
		addCreditLine( 1, "Tibor Simon" );
		addCreditLine( 1, "" );
		addCreditLine( 0, "Additional Testing" );
		addCreditLine( 1, "Gabor Szappanos" );
		addCreditLine( 1, "Laszlo Zizics" );
		addCreditLine( 1, "" );
		addCreditLine( 0, "Special Thanks To" );
		addCreditLine( 1, "Daniel 'Furball' Alabaster" );
		addCreditLine( 1, "and the www.buildersedge.org community" );
		addCreditLine( 1, "" );
		addCreditLine( 1, "" );
		addCreditLine( 1, "" );
		addCreditLine( 1, "INVICTUS GAMES LTD. 2003." );
		addCreditLine( 0, "all rights reserved" );
		addCreditLine( 1, "" );
		addCreditLine( 1, "" );
		addCreditLine( 1, "" );
		addCreditLine( 1, "" );
		addCreditLine( 1, "" );
		addCreditLine( 1, "" );
		addCreditLine( 1, "" );
		addCreditLine( 1, "" );
		addCreditLine( 1, "" );
		addCreditLine( 1, "" );
		addCreditLine( 1, "" );
		addCreditLine( 1, "" );
		addCreditLine( 1, "" );
		addCreditLine( 1, "" );
	}

	public void addCreditLine( int type, String line )
	{
		if( type == 0 )
		{
			creditsTxt[creditLines] = osd.createText ( line, Frontend.mediumFont, Text.ALIGN_CENTER, 0.0, 1.0);
			creditsTxt[creditLines++].changeColor( Osd.COLOR_UNSELECTED );
		}
		else
		{
			creditsTxt[creditLines++] = osd.createText ( line, Frontend.largeFont, Text.ALIGN_CENTER, 0.0, 1.0);
		}
	}
}


public class PlayerSetupDialog extends Dialog
{
	final static int CMD_NEXT = 100;
	final static int CMD_PREV = 101;
	final static int CMD_HNEXT = 102;
	final static int CMD_HPREV = 103;

	Player plr;
	int	startId = Racer.RID_FEJ, numId = 60, actId = startId + Math.random()*(60-1);
	Rectangle rect;

	public PlayerSetupDialog( Controller ctrl, int myFlags, String myTitle, Player player )
	{
		super( ctrl, myFlags|DF_DARKEN, myTitle, "OK" );
		plr = player;
	}

	public void show()
	{
		Style btn1 = new Style( 0.10, 0.10, 1.0, Frontend.mediumFont, Text.ALIGN_CENTER, new ResourceRef( Osd.RID_ARROWLF ) );
		osd.createButton( btn1,-0.60, 0.40, CMD_PREV, null );
		Style btn2 = new Style( 0.10, 0.10, 1.0, Frontend.mediumFont, Text.ALIGN_CENTER, new ResourceRef( Osd.RID_ARROWRG ) );
		osd.createButton( btn2, 0.60, 0.40, CMD_NEXT, null );

		osd.createHotkey( Input.AXIS_MENU_LEFT, Input.VIRTUAL, CMD_HPREV, this );
		osd.createHotkey( Input.AXIS_MENU_RIGHT, Input.VIRTUAL, CMD_HNEXT, this );

		osd.createText( plr.name, Frontend.mediumFont, Text.ALIGN_CENTER, 0.00, 0.60 ).changeColor( 0xFFAAAAAA );

		plr.character = new ResourceRef( actId );
		rect = osd.createRectangle( 0.0, 0.04, 0.80, 1.45, 1, plr.character );

		super.show();
	}

	public void	osdCommand( int cmd )
	{
		if( cmd==CMD_HPREV )
		{
			osd.changeSelection2( 2, 0 );
			osd.changeSelection2( 2, 1 );
			osdCommand( CMD_PREV );
		}
		else
		if( cmd==CMD_HNEXT )
		{
			osd.changeSelection2( 3, 0 );
			osd.changeSelection2( 3, 1 );
			osdCommand( CMD_NEXT );
		}
		else
		if( cmd==CMD_PREV )
		{
			if( actId > startId )
				actId--;
			else
				actId = startId+numId-1;

			refreshCharacter();
		}
		else
		if( cmd==CMD_NEXT )
		{
			if( actId < startId+numId-1 )
				actId++;
			else
				actId = startId;

			refreshCharacter();
		}
		else
			super.osdCommand( cmd );
	}

	public void refreshCharacter()
	{
		plr.character = new ResourceRef( actId );
		rect.changeTexture( plr.character );
	}
}

class VehicleSkinFileReqDialog extends FileRequesterDialog
{
	public VehicleSkinFileReqDialog( Controller ctrl, int myflags, String mytitle, String OKButtonText, String path, String mask )
	{
		super( ctrl, myflags, mytitle, OKButtonText, path, mask );
	}
	
	public int validator( String filename )
	{
		return Vehicle.fileCheck_Skin( filename );
	}
}

class VehicleFileReqDialog extends FileRequesterDialog
{
	public VehicleFileReqDialog( Controller ctrl, int myflags, String mytitle, String OKButtonText, String path, String mask )
	{
		super( ctrl, myflags, mytitle, OKButtonText, path, mask );
		if( myflags & FRF_SAVE )
			osd.defSelection = 5;
	}

	public int validator( String filename )
	{
		return Vehicle.fileCheck( filename );
	}
}

class CarrerFileReqDialog extends FileRequesterDialog
{
	public CarrerFileReqDialog( Controller ctrl, int myflags, String mytitle, String OKButtonText, String path, String mask, int ffFlags )
	{
		super( ctrl, myflags, mytitle, OKButtonText, path, mask, ffFlags );
	}

	public int validator( String filename )
	{
		return GameLogic.fileCheck( filename );
	}
}
