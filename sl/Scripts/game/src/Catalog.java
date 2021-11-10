package java.game;

import java.io.*;
import java.util.*;
import java.util.resource.*;
import java.render.*;
import java.render.osd.*;
import java.render.osd.dialog.*;
import java.sound.*;

import java.game.parts.*;
import java.game.parts.bodypart.*;
import java.game.parts.rgearpart.reciprocatingrgearpart.*;

public class Catalog extends GameType implements GameState
{
	final static ResourceRef RR_ICON_CAR_COMP = new ResourceRef( misc.catalog:0x0004r );
	final static ResourceRef RR_ICON_CAR_1STEP = new ResourceRef( misc.catalog:0x0005r );
	final static ResourceRef RR_ICON_INV_COMP = new ResourceRef( misc.catalog:0x0007r );


	final static int DECALPRICE = 20;

	final static int SC_ENGINE	= 0;
	final static int SC_BODY	= 1;
	final static int SC_RGEAR	= 2;
	final static int SC_NONE	= 3;	//max+1

	final static int CMD_EXIT  = 0;
	final static int CMD_FRONTPAGE = 1;
	final static int CMD_MAIN1 = 2;
	final static int CMD_MAIN2 = 3;
	final static int CMD_MAIN3 = 4;
	final static int CMD_MAIN4 = 5;
	final static int CMD_MAIN5 = 6;
	final static int CMD_MAIN6 = 7;

	final static int CMD_MAIN1_1 = 8;
	final static int CMD_MAIN1_2 = 9;
	final static int CMD_MAIN1_3 =10;
	final static int CMD_MAIN1_4 =11;
	final static int CMD_MAIN1_5 =12;
	final static int CMD_MAIN1_6 =13;
	final static int CMD_MAIN1_7 =14;
	final static int CMD_MAIN1_8 =15;
	final static int CMD_MAIN1_9 =16;
	final static int CMD_MAIN1_10 =17;
	final static int CMD_MAIN1_11 =18;
	final static int CMD_MAIN1_12 =19;
	final static int CMD_MAIN1_13 =20;
	final static int CMD_MAIN1_14 =21;
	final static int CMD_MAIN1_15 =22;
	final static int CMD_MAIN1_16 =23;
	final static int CMD_MAIN1_17 =24;
	final static int CMD_MAIN1_18 =25;
	final static int CMD_MAIN1_19 =26;
	final static int CMD_MAIN1_20 =27;

	final static int CMD_MAIN2_1 =28;
	final static int CMD_MAIN2_2 =29;
	final static int CMD_MAIN2_3 =30;
	final static int CMD_MAIN2_4 =31;
	final static int CMD_MAIN2_5 =32;
	final static int CMD_MAIN2_6 =33;
	final static int CMD_MAIN2_7 =34;

	final static int CMD_MAIN3_1 =35;
	final static int CMD_MAIN3_2 =36;
	final static int CMD_MAIN3_3 =37;
	final static int CMD_MAIN3_4 =38;
	final static int CMD_MAIN3_5 =39;
	final static int CMD_MAIN3_6 =40;
	final static int CMD_MAIN3_7 =41;
	final static int CMD_MAIN3_8 =42;
	final static int CMD_MAIN3_9 =43;
	//Factory
	final static int CMD_MAIN3_10 =44;
	final static int CMD_MAIN3_11 =45;
	final static int CMD_MAIN3_12 =46;
	final static int CMD_MAIN3_13 =47;
	final static int CMD_MAIN3_14 =48;
	final static int CMD_MAIN3_15 =49;
	//Rims
	final static int CMD_MAIN3_5_1 =50;
	final static int CMD_MAIN3_5_2 =51;
	final static int CMD_MAIN3_5_3 =52;
	final static int CMD_MAIN3_5_4 =53;
	final static int CMD_MAIN3_5_5 =54;
	final static int CMD_MAIN3_5_6 =55;
	final static int CMD_MAIN3_5_7 =56;
	final static int CMD_MAIN3_5_8 =57;
	final static int CMD_MAIN3_5_9 =58;
	final static int CMD_MAIN3_5_10 =59;
	//Tyres
	final static int CMD_MAIN3_6_1 =60;
	final static int CMD_MAIN3_6_2 =61;
	final static int CMD_MAIN3_6_3 =62;
	final static int CMD_MAIN3_6_4 =63;
	final static int CMD_MAIN3_6_5 =64;
	final static int CMD_MAIN3_6_6 =65;
	final static int CMD_MAIN3_6_7 =66;
	final static int CMD_MAIN3_6_8 =67;
	final static int CMD_MAIN3_6_9 =68;
	final static int CMD_MAIN3_6_10 =69;

	final static int CMD_MAIN4_1 =70;
	final static int CMD_MAIN4_2 =71;
	final static int CMD_MAIN4_3 =72;
	final static int CMD_MAIN4_4 =73;
	final static int CMD_MAIN4_5 =74;
	final static int CMD_MAIN4_6 =75;
	final static int CMD_MAIN4_7 =76;
	final static int CMD_MAIN4_8 =77;

	final static int CMD_MAIN5_1 =78;
	final static int CMD_MAIN5_2 =79;
	final static int CMD_MAIN5_3 =80;
	final static int CMD_MAIN5_4 =81;
	final static int CMD_MAIN5_5 =82;
	final static int CMD_MAIN5_6 =83;

	final static int CMD_MAIN6_1 =84;
	final static int CMD_MAIN6_2 =85;
	final static int CMD_MAIN6_3 =86;
	final static int CMD_MAIN6_4 =87;
	final static int CMD_MAIN6_5 =88;
	final static int CMD_MAIN6_6 =89;
	final static int CMD_MAIN6_7 =90;

	final static int CMD_DB0 =91;
	final static int CMD_DB1 =92;
	final static int CMD_DB2 =93;
	final static int CMD_DB3 =94;
	final static int CMD_DB4 =95;
	final static int CMD_DB5 =96;
	final static int CMD_DB6 =97;
	final static int CMD_DB7 =98;

	final static int CMD_PREVDECALPAGE = 99;
	final static int CMD_NEXTDECALPAGE =100;

	final static int CMD_PREVPARTPAGE =101;
	final static int CMD_NEXTPARTPAGE =102;

// Chassis shop
	final static int CMD_VEHICLE =103;
	final static int CMD_VEH0	 =104;
	final static int CMD_VEH1	 =105;
	final static int CMD_VEH2	 =106;
	final static int CMD_VEH3	 =107;
	final static int CMD_VEH4	 =108;
	final static int CMD_VEH5	 =109;
	final static int CMD_VEH6	 =110;
	final static int CMD_VEH7	 =111;
	final static int CMD_VEH8	 =112;
	final static int CMD_VEH9	 =113;
	final static int CMD_UP		 =114;
	final static int CMD_DOWN	 =115;
	final static int CMD_VEHI	 =116;
	final static int CMD_CHAS	 =117;
	final static int CMD_VBUY	 =118;
	final static int CMD_VCOLOR	 =119;

	final static int NO_FILTER	 =120;
	final static int RIMS_FILTER	 =121;
	final static int TYRES_FILTER	 =122;


	final static int DEFAULT_VEHICLE_COLOR = cars:0x0025r;

	final static String pageNumberPrefix;

	final static float PRICERATIO = 1.1;	//katalogus ar-szorzo

	Player			player;

	Osd				osd;

	int				actGroup;

	Text			moneytxt, pgNumberL, pgNumberR;
	Text[]			pageNumberL = new Text[8];
	Text[]			pageNumberR = new Text[8];

	CatalogInventory	inventory;
	Vector			collector;
	GameRef			parts;

	int				curpage=1;

	int				step, filter, currentCarPackId, partsPackId;

	Decal[]			curDecals;
	Button[]		decalButtons;
	Vector			decals;
	int				showDecals;

	int				mainGroup, VehicleGroup, main1Group, main2Group, main3Group, main4Group, main5Group, main6Group, main7Group, main8Group;
	int				decalsGroup, parts1Group, parts2Group, parts3Group, parts4Group, parts5Group, parts7Group, parts8Group;

	ResourceRef[]	carTypes;
	Button			VColor_Button, VehButton0, VehButton1, VehButton2, VehButton3, VehButton4, VehButton5, VehButton6, VehButton7, VehButton8, VehButton9, UpButton, DownButton;
	int				rimSize, tyreSize, VehAmount, ColorIDX, CurrentPage, CurrentName, CompleteCar, RetailP, DeliveryP, TotalP, ButtonNum;
	Text			CurrentPageText;
	GameRef			CarScene, Cam;
	//Camera		Cam;
	RenderRef		SceneSun;
	Thread			CamThread;
	Ypr				CamYpr;
	Vector3			CamVector;
	Viewport		CarViewport;
	Vehicle			CurrentCar;
	GameRef			CurrentChassis;
	Text			CurrentCarName, RetailText, DeliveryText, TotalText;
	TextBox			CurrentCarDescription;
	Vector3			Size;

	public Catalog()
	{
		createNativeInstance();

		player = GameLogic.player;

		carTypes = GameLogic.VEHICLETYPE_ROOT.getChildNodes();
	}

	public static Vector collectDecals( String subdir )
	{
		Vector ds = new Vector();

		FindFile ff = new FindFile();
		String name=ff.first( "decals/textures/catalog/" + subdir + "/*.png" );
		while( name )
		{
			Decal decal = new Decal( "decals/textures/catalog/" +subdir + "/" + name );	//extends ResourceRef
			ds.addElement( decal );
			name = ff.next();
		}
		ff.close();

		return ds;
	}

	public void clearObjectCache()
	{
		if( inventory )
		{
			inventory.hide();
			inventory.flushAll();
			inventory = null;
		}

		collector = null;
	}

	//puts parts of the given category and car type (+common parts) to the given inventory
	public void collectObjectsBegin()
	{
		clearObjectCache();

		inventory = new CatalogInventory( this, player, 0.02, 0.25, 0.96, 0.50 );
		collector = new Vector();

		if( player.car )
			currentCarPackId = player.car.getInfo( GII_TYPE ) >> 16;
		else
			currentCarPackId = 0;

		partsPackId = System.openLib( "parts.rpk" );
	}

	public void collectObjectsEnd()
	{
		collectObjectsStep(9);

		inventory.update();
		inventory.show();
	}
	
	public void collectObjects( GameRef root )
	{
		collectObjects( root, null, null, null, null);
	}

	public void collectObjects( GameRef root1, GameRef root2 )
	{
		collectObjects( root1, root2, null, null, null);
	}

	public void collectObjects( GameRef root1, GameRef root2, GameRef root3 )
	{
		collectObjects( root1, root2, root3, null, null);
	}

	public void collectObjects( GameRef root1, GameRef root2, GameRef root3, GameRef root4 )
	{
		collectObjects( root1, root2, root3, root4, null);
	}

	public void collectObjects( GameRef root1, GameRef root2, GameRef root3, GameRef root4, GameRef root5 )
	{
		if( root1 ) collector.addElement( root1 );
		if( root2 ) collector.addElement( root2 );
		if( root3 ) collector.addElement( root3 );
		if( root4 ) collector.addElement( root4 );
		if( root5 ) collector.addElement( root5 );
	}

	//return false if finished collecting
	public int collectObjectsStep( int int_step )
	{
		step = int_step;

		if( collector )
		{
			while( !collector.isEmpty() && step )
			{
				parts=collector.removeLastElement();

				if( parts.isScripted( "java.game.parts.Part" ) )//it's a part
				{
					//inventory.items.addElement( new InventoryItem_Part( inventory, parts.id() ) );
					//step--;
					osdCommand( filter );// run parts filter
				}
				else
				if( parts.isScripted( "java.game.parts.Set" ) )	//set?
				{
					Set set = parts.create( null, parts, null, "set_loader" );

					InventoryItem_Folder tmp = new InventoryItem_Folder( inventory );
					tmp.set = set;
					set.build( tmp.inv );
					inventory.items.addElement( tmp ); 
				}
				else
				{	//dummy eloszto node!
					if( parts=parts.getFirstChild() )
					{
						while( parts )
						{
							if( parts.isScripted() )
								collector.addElement( parts );
							else
							{
								int	carPack;
								int packId = parts.id() >> 16;
	
								for( int i=carTypes.length-1; i>=0; i-- )
								{
									if( packId == carTypes[i].id()>>16 )
									{
										carPack=1;
										break;
									}
								}
								
								if( !carPack || packId == currentCarPackId )
									collector.addElement( parts );
								//
							}

							parts=parts.getNextChild();
						}
					}
				}
			}

			inventory.update();

			return !collector.isEmpty();
		}

		return 0;
	}

	public void setDecalButtons()
	{
		int	max = decals.size();

		clearDecalButtons();

		for( int i=0; i<decalButtons.length; i++ )
		{
			//a gomb tipus (nagy)
			RenderRef	base = new RenderRef( frontend:0x00AEr );
	
			if( max > showDecals+i )
			{
				curDecals[i] = decals.elementAt( showDecals+i );
				decalButtons[i].rect.changeTexture( decals.elementAt( showDecals+i ) );
			}
		}
	}

	public void clearDecalButtons()
	{
		for( int i=0; i<decalButtons.length; i++ )
		{
			decalButtons[i].rect.changeTexture( Osd.RRT_EMPTY );
			if( curDecals[i] )
			{
				curDecals[i].unload();
				curDecals[i] = null;
			}
		}
	}

	public void enter( GameState prev_state )
	{
		osd = new Osd();
		osd.globalHandler = this;

		showDecals=0;

		setEventMask( EVENT_TIME );

		createOSDObjects();
		osd.show();

		Input.cursor.enable(1);
		setEventMask( EVENT_CURSOR );

		GfxEngine.setGlobalEnvmap( new ResourceRef( MW_Mod:0x0069r ));
	}

	public void exit( GameState next_state )
	{
		Frontend.loadingScreen.hide();

		clearEventMask( EVENT_ANY );
		removeAllTimers();
		Input.cursor.enable(0);

		pageNumberPrefix=null;

		osd.hide();
	}

	public void VehicleScene()
	{
		CarScene = new Dummy( WORLDTREEROOT );

		//CarViewport = new Viewport( 12, 0.53, 0.205, 0.45, 0.40 );//MWM
		CarViewport = new Viewport( 12, 0.50, 0.190, 0.45, 0.50 );
		CarViewport.activate( Viewport.RENDERFLAG_CLEARDEPTH | Viewport.RENDERFLAG_CLEARTARGET );
		//Cam = new Camera( CarScene, CarViewport, 0 );
		Cam = new GameRef( CarScene, GameRef.RID_CAMERA, "-2,1,-3 , -2.5,0,0 ,0x02", "camera" );
		Cam.setMatrix( new Vector3( -2, 1, -4), new Ypr( -2.7, -0.2, 0));
		Cam.command( "render " + CarViewport.id() + " 0 0 1 " + (Viewport.RENDERFLAG_CLEARDEPTH | Viewport.RENDERFLAG_CLEARTARGET) );
		Cam.command( "look " + CarScene.id() + " 0.3,-0.6,0" );
		Cam.command( "zoom 35 10");
		
		CurrentCar = new Vehicle();
			
		RenderRef CarSun = new RenderRef(misc.garage:0x001Dr);
		SceneSun = new RenderRef( CarScene, CarSun, "light for this scene" );

	// Reset at start
		ColorIDX = 0;
		CurrentPage = 0;
		CompleteCar = 0;

		osdCommand( CMD_UP ); // Refresh page
		osdCommand( CMD_VEH0 );// Show 1st car

		//getInfo( GameType.GII_SIZE )/100.0, 1 );	//size, enableRotate
		
		//CamThread = new Thread( this, "Cam Animate Refresher" );
		//CamThread.start();
	}

	private void createCatalogHeader( String text )
	{
		if( Config.catalogStyle == 1 )
			osd.createText( text, Frontend.largeFont, Text.ALIGN_LEFT, -0.95, -0.94 );
	}

	public void createOSDObjects()
	{
		Style bsm = new Style( 0.70, 0.13, Frontend.largeFont, Text.ALIGN_RIGHT, Osd.RRT_TEST );
		Style bs = new Style( 0.70, 0.13, Frontend.mediumFont, Text.ALIGN_RIGHT, Osd.RRT_TEST );
		
		Style bbsr = new Style( 0.12, 0.12, 1.0, Frontend.mediumFont, Text.ALIGN_RIGHT, new ResourceRef(Osd.RID_ARROWRG) );
		Style bbsl = new Style( 0.12, 0.12, 1.0, Frontend.mediumFont, Text.ALIGN_LEFT, new ResourceRef(Osd.RID_ARROWLF) );

		Style bex = new Style( 0.12, 0.12, 1.0, Frontend.mediumFont, Text.ALIGN_CENTER, new ResourceRef(Osd.RID_EXIT) );
		Style bek = new Style( 0.12, 0.12, 1.0, Frontend.mediumFont, Text.ALIGN_CENTER, new ResourceRef(Osd.RID_BACK) );

		Style Menu_Left = new Style( 0.7, 0.13, Frontend.mediumFont, Text.ALIGN_LEFT, Osd.RRT_TEST );
		Style Menu_Right = new Style( 0.7, 0.13, Frontend.mediumFont, Text.ALIGN_RIGHT, Osd.RRT_TEST );
		Style Menu_Center = new Style( 0.4, 0.13, Frontend.mediumFont, Text.ALIGN_CENTER, Osd.RRT_TEST );
		Style Menu_Button = new Style( 0.12, 0.12, Frontend.mediumFont, Text.ALIGN_CENTER, null );
		Style Midle_Button = new Style( 0.17, 0.17, Frontend.mediumFont, Text.ALIGN_CENTER, null );
		Style Big_Button = new Style( 0.2, 0.25, Frontend.mediumFont, Text.ALIGN_CENTER, new ResourceRef( frontend:0x0125r ) );

		float bbcy = 0.675;
		if( Config.catalogStyle == 1 ) bbcy = 0.875;

		Menu m;

		//always visible objects:
		moneytxt=osd.createText( null, Frontend.mediumFont, Text.ALIGN_CENTER,	0.50, -0.94 );
		osd.endGroup();

		//----------------------------------------Grand Index

		osd.createBG( new ResourceRef(misc.catalog:0x0006r) );
		createCatalogHeader( "INDEX" );

		m= osd.createMenu( bsm, 1.0, -0.55, 0.18 );
		m.addItem( "VEHICLE", CMD_VEHICLE );
		m.addItem( "ENGINE", CMD_MAIN1 );
		m.addItem( "BODY", CMD_MAIN2 );
		m.addItem( "RUNNING GEAR", CMD_MAIN3 );
		m.addItem( "INTERIOR", CMD_MAIN4 );
		m.addItem( "AUDIO", CMD_MAIN5 );
		m.addItem( "DECALS", CMD_MAIN6 );
		
		osd.createButton( bex, 0.92, -0.92, CMD_EXIT, null );

		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_EXIT, this );
		actGroup = mainGroup = osd.endGroup();

		//----------------------------------------Engine Index

		osd.createBG( new ResourceRef(misc.catalog:0x0009r) );
		createCatalogHeader( "ENGINE" );

		m= osd.createMenu( Menu_Left, -0.98, -0.65, 0.14 );
		m.addItem( "ENGINE BLOCKS", CMD_MAIN1_1 );
		m.addItem( "CRANKSHAFTS & BEARING", CMD_MAIN1_2 );
		m.addItem( "CONNECTING RODS", CMD_MAIN1_3 );
		m.addItem( "PISTONS", CMD_MAIN1_4 );
		m.addItem( "CYLINDER HEADS", CMD_MAIN1_6 );
		m.addItem( "INTAKE & EXHAUST CAMSHAFTS", CMD_MAIN1_7 );
		m.addItem( "AIR DELIVERY", CMD_MAIN1_8 );
		m.addItem( "FUEL DELIVERY", CMD_MAIN1_9 );
		m.addItem( "CLUTCHS & FLYWHEELS", CMD_MAIN1_10 );
		m.addItem( "TRANSMISSION & DRIVETRAIN", CMD_MAIN1_11 );

		m= osd.createMenu( bs, 1.0, -0.65, 0.14 );
		m.addItem( "EXHAUST SYSTEM", CMD_MAIN1_12 );
		m.addItem( "EXHAUST PIPES", CMD_MAIN1_20 );
		m.addItem( "EXHAUST TIPS", CMD_MAIN1_13 );
		m.addItem( "DRIVE BELTS", CMD_MAIN1_14 );
		m.addItem( "ACCESSORIES & OTHERS", CMD_MAIN1_15 );
		m.addItem( "BATTERIES", CMD_MAIN1_16 );
		m.addItem( "OIL PANS", CMD_MAIN1_5 );
		m.addItem( "CHARGING SYSTEM", CMD_MAIN1_17 );
		m.addItem( "PRO TUNING", CMD_MAIN1_18 );
		m.addItem( "ENGINE KITS", CMD_MAIN1_19 );
		
		osd.createButton( bek, 0.85, -0.92, CMD_FRONTPAGE, null );
		osd.createButton( bex, 0.92, -0.92, CMD_EXIT, null );

		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_FRONTPAGE, this );
		osd.hideGroup( main1Group = osd.endGroup() );

		//----------------------------------------Vehicle Page

		osd.createBG( new ResourceRef(misc.catalog:0x0026r) ); // Background
		createCatalogHeader( "VEHICLE" );

		if( Config.catalogStyle == 1 )
		{	// SLRR LE Style Page
			CurrentName = CurrentPage*10;

			m = osd.createMenu( Menu_Center, 0.675, -0.725, Osd.MD_HORIZONTAL ); 
			m.addItem( "VEHICLE", CMD_VEHI );

			m = osd.createMenu( Menu_Center, 0.325, -0.725, Osd.MD_HORIZONTAL );
			m.addItem( "CHASSIS", CMD_CHAS );

			m = osd.createMenu( Midle_Button, 0.752, 0.157, 0, Osd.MD_VERTICAL );
			if( Config.carCatalogColor == 1 ) VColor_Button = m.addItem( new ResourceRef( frontend:0x00AFr ), CMD_VCOLOR, "Change color" );
			if( VColor_Button ) VColor_Button.disable();

			CurrentPageText = osd.createText( "Current Page: " + (CurrentPage+1), Frontend.largeFont, Text.ALIGN_CENTER, 0, 0.81 ); CurrentPageText.changeColor(0xFFC0C0C0);// "Unselected" gray
			CurrentCarName = osd.createText( "-NO VEHICLE SELECTED-", Frontend.largeFont, Text.ALIGN_CENTER, 0.50, -0.625 ); CurrentCarName.changeColor(0xFFC0C0C0);// "Unselected" gray

			CurrentCarDescription = osd.createTextBox( "Description: N/A", Frontend.smallFont, Text.ALIGN_CENTER, 0.15, 0.34, 0.60, null, 10 ); CurrentCarDescription.changeColor(0xFFC0C0C0);// text box, 10 lines max

			osd.createText( "Retail Price:", Frontend.smallFont, Text.ALIGN_LEFT, 0.305, 0.80 ).changeColor(0xFFC0C0C0);// "Unselected" gray
			RetailText = osd.createText( "N/A", Frontend.smallFont, Text.ALIGN_RIGHT, 0.70, 0.80 ); RetailText.changeColor(0xFFC0C0C0);// "Unselected" gray

			osd.createText( "Delivery Cost:", Frontend.smallFont, Text.ALIGN_LEFT, 0.305, 0.85 ).changeColor(0xFFC0C0C0);// "Unselected" gray
			DeliveryText = osd.createText( "N/A", Frontend.smallFont, Text.ALIGN_RIGHT, 0.70, 0.85 ); DeliveryText.changeColor(0xFFC0C0C0);// "Unselected" gray

			osd.createText( "Total:", Frontend.smallFont, Text.ALIGN_LEFT, 0.305, 0.90 ).changeColor(0xFFC0C0C0);// "Unselected" gray
			TotalText = osd.createText( "N/A", Frontend.smallFont, Text.ALIGN_RIGHT, 0.70, 0.90 ); TotalText.changeColor(0xFFC0C0C0);// "Unselected" gray

			osd.createText( "Choose between " + GameLogic.ChassisBox.size() + " different models." , Frontend.smallFont, Text.ALIGN_CENTER, 0, 0.88 ).changeColor(0xFFC0C0C0);// "Unselected" gray

			VehAmount = GameLogic.ChassisBox.size()-1;

			m= osd.createMenu( Menu_Left, -0.98, -0.60, 0 );
			if( CurrentName + 0 <= VehAmount ) VehButton0 = m.addItem(GameLogic.ChassisBox.elementData[CurrentName+0].vehicleName, CMD_VEH0 ); else { VehButton0 = m.addItem( "", CMD_VEH0 ); VehButton0.disable(); }
			if( CurrentName + 1 <= VehAmount ) VehButton1 = m.addItem(GameLogic.ChassisBox.elementData[CurrentName+1].vehicleName, CMD_VEH1 ); else { VehButton1 = m.addItem( "", CMD_VEH1 ); VehButton0.disable(); }
			if( CurrentName + 2 <= VehAmount ) VehButton2 = m.addItem(GameLogic.ChassisBox.elementData[CurrentName+2].vehicleName, CMD_VEH2 ); else { VehButton2 = m.addItem( "", CMD_VEH2 ); VehButton0.disable(); }
			if( CurrentName + 3 <= VehAmount ) VehButton3 = m.addItem(GameLogic.ChassisBox.elementData[CurrentName+3].vehicleName, CMD_VEH3 ); else { VehButton3 = m.addItem( "", CMD_VEH3 ); VehButton0.disable(); }
			if( CurrentName + 4 <= VehAmount ) VehButton4 = m.addItem(GameLogic.ChassisBox.elementData[CurrentName+4].vehicleName, CMD_VEH4 ); else { VehButton4 = m.addItem( "", CMD_VEH4 ); VehButton0.disable(); }
			if( CurrentName + 5 <= VehAmount ) VehButton5 = m.addItem(GameLogic.ChassisBox.elementData[CurrentName+5].vehicleName, CMD_VEH5 ); else { VehButton5 = m.addItem( "", CMD_VEH5 ); VehButton0.disable(); }
			if( CurrentName + 6 <= VehAmount ) VehButton6 = m.addItem(GameLogic.ChassisBox.elementData[CurrentName+6].vehicleName, CMD_VEH6 ); else { VehButton6 = m.addItem( "", CMD_VEH6 ); VehButton0.disable(); }
			if( CurrentName + 7 <= VehAmount ) VehButton7 = m.addItem(GameLogic.ChassisBox.elementData[CurrentName+7].vehicleName, CMD_VEH7 ); else { VehButton7 = m.addItem( "", CMD_VEH7 ); VehButton0.disable(); }
			if( CurrentName + 8 <= VehAmount ) VehButton8 = m.addItem(GameLogic.ChassisBox.elementData[CurrentName+8].vehicleName, CMD_VEH8 ); else { VehButton8 = m.addItem( "", CMD_VEH8 ); VehButton0.disable(); }
			if( CurrentName + 9 <= VehAmount ) VehButton9 = m.addItem(GameLogic.ChassisBox.elementData[CurrentName+9].vehicleName, CMD_VEH9 ); else { VehButton9 = m.addItem( "", CMD_VEH9 ); VehButton0.disable(); }

			m = osd.createMenu( Menu_Button, -0.35,   -0.73, Osd.MD_VERTICAL ); 
			UpButton = m.addItem( new ResourceRef( frontend:0x00AFr ), CMD_UP, "Prev Page" );

			m = osd.createMenu( Menu_Button, -0.35,   0.865, Osd.MD_VERTICAL );
			DownButton = m.addItem( new ResourceRef( frontend:0x0084r ), CMD_DOWN, "Next Page" );

			osd.createButton( bek, 0.85, -0.92, CMD_FRONTPAGE, null );
			osd.createButton( bex, 0.92, -0.92, CMD_EXIT, null );

			osd.createButton( Big_Button, 0.88, 0.847, CMD_VBUY, "Buy this vehicle" );
		}
		else
		{	// MWM Style Page
			CurrentName = CurrentPage*10;

			m = osd.createMenu( Menu_Center, 0.8, -0.775, Osd.MD_HORIZONTAL ); 
			m.addItem( "VEHICLE", CMD_VEHI );

			m = osd.createMenu( Menu_Center, 0.45, -0.775, Osd.MD_HORIZONTAL );
			m.addItem( "CHASSIS", CMD_CHAS );

			m = osd.createMenu( Midle_Button, 0.9, 0.1, 0, Osd.MD_VERTICAL );
			if( Config.carCatalogColor == 1 ) VColor_Button = m.addItem( new ResourceRef( frontend:0x00AFr ), CMD_VCOLOR, "Change color" );
			if( VColor_Button ) VColor_Button.disable();

			CurrentPageText = osd.createText( "Current Page: " + (CurrentPage+1), Frontend.largeFont, Text.ALIGN_CENTER, -0.45, -0.86 ); CurrentPageText.changeColor(0xFFC0C0C0);// "Unselected" gray
			CurrentCarName = osd.createText( "-NO VEHICLE SELECTED-", Frontend.largeFont, Text.ALIGN_CENTER, 0.50, -0.65 ); CurrentCarName.changeColor(0xFFC0C0C0);// "Unselected" gray

			CurrentCarDescription = osd.createTextBox( "Description: N/A", Frontend.smallFont, Text.ALIGN_CENTER, 0.09, 0.21, 0.85, null, 10 ); CurrentCarDescription.changeColor(0xFFC0C0C0);// text box, 10 lines max

			osd.createText( "Retail Price:", Frontend.smallFont, Text.ALIGN_LEFT, 0.12, 0.77 ).changeColor(0xFFC0C0C0);// "Unselected" gray
			RetailText = osd.createText( "N/A", Frontend.smallFont, Text.ALIGN_RIGHT, 0.65, 0.77 ); RetailText.changeColor(0xFFC0C0C0);// "Unselected" gray

			osd.createText( "Delivery Cost:", Frontend.smallFont, Text.ALIGN_LEFT, 0.12, 0.82 ).changeColor(0xFFC0C0C0);// "Unselected" gray
			DeliveryText = osd.createText( "N/A", Frontend.smallFont, Text.ALIGN_RIGHT, 0.65, 0.82 ); DeliveryText.changeColor(0xFFC0C0C0);// "Unselected" gray

			osd.createText( "Total:", Frontend.smallFont, Text.ALIGN_LEFT, 0.12, 0.88 ).changeColor(0xFFC0C0C0);// "Unselected" gray
			TotalText = osd.createText( "N/A", Frontend.smallFont, Text.ALIGN_RIGHT, 0.65, 0.88 ); TotalText.changeColor(0xFFC0C0C0);// "Unselected" gray

			osd.createText( "What you want to have today?", Frontend.smallFont, Text.ALIGN_CENTER, -0.45, 0.80 ).changeColor(0xFFC0C0C0);// "Unselected" gray
			osd.createText( "We have " + GameLogic.ChassisBox.size() + " vehicles at catalog." , Frontend.smallFont, Text.ALIGN_CENTER, -0.45, 0.85 ).changeColor(0xFFC0C0C0);// "Unselected" gray

			VehAmount = GameLogic.ChassisBox.size()-1;

			m= osd.createMenu( Menu_Left, -0.98, -0.60, 0 );
			if( CurrentName + 0 <= VehAmount ) VehButton0 = m.addItem(GameLogic.ChassisBox.elementData[CurrentName+0].vehicleName, CMD_VEH0 ); else { VehButton0 = m.addItem( "", CMD_VEH0 ); VehButton0.disable(); }
			if( CurrentName + 1 <= VehAmount ) VehButton1 = m.addItem(GameLogic.ChassisBox.elementData[CurrentName+1].vehicleName, CMD_VEH1 ); else { VehButton1 = m.addItem( "", CMD_VEH1 ); VehButton0.disable(); }
			if( CurrentName + 2 <= VehAmount ) VehButton2 = m.addItem(GameLogic.ChassisBox.elementData[CurrentName+2].vehicleName, CMD_VEH2 ); else { VehButton2 = m.addItem( "", CMD_VEH2 ); VehButton0.disable(); }
			if( CurrentName + 3 <= VehAmount ) VehButton3 = m.addItem(GameLogic.ChassisBox.elementData[CurrentName+3].vehicleName, CMD_VEH3 ); else { VehButton3 = m.addItem( "", CMD_VEH3 ); VehButton0.disable(); }
			if( CurrentName + 4 <= VehAmount ) VehButton4 = m.addItem(GameLogic.ChassisBox.elementData[CurrentName+4].vehicleName, CMD_VEH4 ); else { VehButton4 = m.addItem( "", CMD_VEH4 ); VehButton0.disable(); }
			if( CurrentName + 5 <= VehAmount ) VehButton5 = m.addItem(GameLogic.ChassisBox.elementData[CurrentName+5].vehicleName, CMD_VEH5 ); else { VehButton5 = m.addItem( "", CMD_VEH5 ); VehButton0.disable(); }
			if( CurrentName + 6 <= VehAmount ) VehButton6 = m.addItem(GameLogic.ChassisBox.elementData[CurrentName+6].vehicleName, CMD_VEH6 ); else { VehButton6 = m.addItem( "", CMD_VEH6 ); VehButton0.disable(); }
			if( CurrentName + 7 <= VehAmount ) VehButton7 = m.addItem(GameLogic.ChassisBox.elementData[CurrentName+7].vehicleName, CMD_VEH7 ); else { VehButton7 = m.addItem( "", CMD_VEH7 ); VehButton0.disable(); }
			if( CurrentName + 8 <= VehAmount ) VehButton8 = m.addItem(GameLogic.ChassisBox.elementData[CurrentName+8].vehicleName, CMD_VEH8 ); else { VehButton8 = m.addItem( "", CMD_VEH8 ); VehButton0.disable(); }
			if( CurrentName + 9 <= VehAmount ) VehButton9 = m.addItem(GameLogic.ChassisBox.elementData[CurrentName+9].vehicleName, CMD_VEH9 ); else { VehButton9 = m.addItem( "", CMD_VEH9 ); VehButton0.disable(); }

			m = osd.createMenu( Menu_Button, -0.90,  -0.82, Osd.MD_VERTICAL ); 
			UpButton = m.addItem( new ResourceRef( frontend:0x00AFr ), CMD_UP, "Prev Page" );

			m = osd.createMenu( Menu_Button, -0.90,  0.82, Osd.MD_VERTICAL );
			DownButton = m.addItem( new ResourceRef( frontend:0x0084r ), CMD_DOWN, "Next Page" );

			osd.createButton( bek, 0.08, -0.92, CMD_FRONTPAGE, null );
			osd.createButton( bex, 0.92, -0.92, CMD_EXIT, null );

			osd.createButton( Big_Button, 0.88, 0.847, CMD_VBUY, "Buy this vehicle" );
		}

		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_FRONTPAGE, this );
		osd.hideGroup( VehicleGroup = osd.endGroup() );

		//----------------------------------------Body Index

		osd.createBG( new ResourceRef(misc.catalog:0x0010r) );
		createCatalogHeader( "BODY" );

		m= osd.createMenu( bs, 1.0, -0.55, 0.18 );
		m.addItem( "BODY PANELS", CMD_MAIN2_1 );
		m.addItem( "REPLACEMENT PARTS", CMD_MAIN2_2 );
		m.addItem( "LIGHTS & WINDOWS", CMD_MAIN2_3 );
		m.addItem( "NEON LIGHTS", CMD_MAIN2_4 );
		m.addItem( "AERODYNAMIC TUNING", CMD_MAIN2_5 );
		m.addItem( "OTHERS", CMD_MAIN2_6 );
		m.addItem( "BODY KITS", CMD_MAIN2_7 );
		
		osd.createButton( bek, 0.85, -0.92, CMD_FRONTPAGE, null );
		osd.createButton( bex, 0.92, -0.92, CMD_EXIT, null );

		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_FRONTPAGE, this );
		osd.hideGroup( main2Group = osd.endGroup() );

		//----------------------------------------Running Gear Index

		osd.createBG( new ResourceRef(misc.catalog:0x0011r) );
		createCatalogHeader( "RUNNING GEAR" );

		m= osd.createMenu( Menu_Left, -0.98, -0.6, 0.133 );
		m.addItem( "FACTORY SUSPENSIONS", CMD_MAIN3_10 );
		m.addItem( "FACTORY SHOCK ABSORBERS", CMD_MAIN3_11 );
		m.addItem( "FACTORY SPRINGS", CMD_MAIN3_12 );
		m.addItem( "FACTORY BRAKE SYSTEMS", CMD_MAIN3_13 );
		m.addItem( "FACTORY SWAY BARS", CMD_MAIN3_14 );
		m.addSeparator();
		m.addSeparator();
		m.addItem( "OTHERS", CMD_MAIN3_8 );
		m.addItem( "RUNNING GEAR KITS", CMD_MAIN3_9 );

		m= osd.createMenu( Menu_Right, 0.98, -0.6, 0.133 );
		m.addItem( "SUSPENSIONS", CMD_MAIN3_1 );
		m.addItem( "SHOCK ABSORBERS", CMD_MAIN3_2 );
		m.addItem( "SPRINGS", CMD_MAIN3_3 );
		m.addItem( "BRAKE SYSTEMS", CMD_MAIN3_4 );
		m.addItem( "SWAY BARS", CMD_MAIN3_7 );
		m.addSeparator();
		m.addSeparator();
		m.addItem( "RIMS", CMD_MAIN3_5 );
		m.addItem( "TYRES", CMD_MAIN3_6 );

		osd.createButton( bek, 0.85, -0.92, CMD_FRONTPAGE, null );
		osd.createButton( bex, 0.92, -0.92, CMD_EXIT, null );

		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_FRONTPAGE, this );
		osd.hideGroup( main3Group = osd.endGroup() );

		//----------------------------------------Rims Index

		osd.createBG( new ResourceRef(misc.catalog:0x0011r) );
		createCatalogHeader( "RUNNING GEAR: RIMS" );

		m= osd.createMenu( Menu_Right, 0.98, -0.6, 0.133 );
		m.addItem( "SMALLER RIMS", CMD_MAIN3_5_1 );
		m.addItem( "RIMS 14''", CMD_MAIN3_5_2 );
		m.addItem( "RIMS 15''", CMD_MAIN3_5_3 );
		m.addItem( "RIMS 16''", CMD_MAIN3_5_4 );
		m.addItem( "RIMS 17''", CMD_MAIN3_5_5 );
		m.addItem( "RIMS 18''", CMD_MAIN3_5_6 );
		m.addItem( "RIMS 19''", CMD_MAIN3_5_7 );
		m.addItem( "RIMS 20''", CMD_MAIN3_5_8 );
		m.addItem( "RIMS 21''", CMD_MAIN3_5_9 );
		m.addItem( "BIGGER RIMS ", CMD_MAIN3_5_10 );

		osd.createButton( bek, 0.85, -0.92, CMD_MAIN3, null );
		osd.createButton( bex, 0.92, -0.92, CMD_EXIT, null );

		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_MAIN3, this );
		osd.hideGroup( main7Group = osd.endGroup() );

		//----------------------------------------Tyres Index

		osd.createBG( new ResourceRef(misc.catalog:0x0011r) );
		createCatalogHeader( "RUNNING GEAR: TYRES" );

		m= osd.createMenu( Menu_Right, 0.98, -0.6, 0.133 );
		m.addItem( "SMALLER TYRES", CMD_MAIN3_6_1 );
		m.addItem( "TYRES 14''", CMD_MAIN3_6_2 );
		m.addItem( "TYRES 15''", CMD_MAIN3_6_3 );
		m.addItem( "TYRES 16''", CMD_MAIN3_6_4 );
		m.addItem( "TYRES 17''", CMD_MAIN3_6_5 );
		m.addItem( "TYRES 18''", CMD_MAIN3_6_6 );
		m.addItem( "TYRES 19''", CMD_MAIN3_6_7 );
		m.addItem( "TYRES 20''", CMD_MAIN3_6_8 );
		m.addItem( "TYRES 21''", CMD_MAIN3_6_9 );
		m.addItem( "BIGGER TYRES ", CMD_MAIN3_6_10 );

		osd.createButton( bek, 0.85, -0.92, CMD_MAIN3, null );
		osd.createButton( bex, 0.92, -0.92, CMD_EXIT, null );

		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_MAIN3, this );
		osd.hideGroup( main8Group = osd.endGroup() );

		//----------------------------------------Interior Index

		osd.createBG( new ResourceRef(misc.catalog:0x001Er) );
		createCatalogHeader( "INTERIOR" );

		m= osd.createMenu( bs, 1.0, -0.55, 0.16 );
		m.addItem( "STEERING WHEELS", CMD_MAIN4_1 );
		m.addItem( "DASHES", CMD_MAIN4_2 );
		m.addItem( "GEAR KNOBS", CMD_MAIN4_3 );
		m.addItem( "PEDALS", CMD_MAIN4_4 );
		m.addItem( "GAUGES", CMD_MAIN4_5 );
		m.addItem( "SEATS", CMD_MAIN4_6 );
		m.addItem( "ROLLBARS", CMD_MAIN4_7 );
		m.addItem( "DECORATION", CMD_MAIN4_8 );
		
		osd.createButton( bek, 0.85, -0.92, CMD_FRONTPAGE, null );
		osd.createButton( bex, 0.92, -0.92, CMD_EXIT, null );

		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_FRONTPAGE, this );
		osd.hideGroup( main4Group = osd.endGroup() );

		//----------------------------------------Audio Index

		osd.createBG( new ResourceRef(misc.catalog:0x001Fr) );
		createCatalogHeader( "AUDIO" );

		m= osd.createMenu( bs, 1.0, -0.55, 0.18 );
		m.addItem( "HEAD UNITS", CMD_MAIN5_1 );
		m.addItem( "AMPLIFIERS", CMD_MAIN5_2 );
		m.addItem( "BOXES", CMD_MAIN5_3 );
		m.addItem( "SUBWOOFERS", CMD_MAIN5_4 );
		m.addItem( "ACCESSORIES", CMD_MAIN5_5 );
		m.addItem( "AUDIO KITS", CMD_MAIN5_6 );
		
		osd.createButton( bek, 0.85, -0.92, CMD_FRONTPAGE, null );
		osd.createButton( bex, 0.92, -0.92, CMD_EXIT, null );

		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_FRONTPAGE, this );
		osd.hideGroup( main5Group = osd.endGroup() );

		//----------------------------------------Decal Index

		osd.createBG( new ResourceRef(misc.catalog:0x0022r) );
		createCatalogHeader( "DECALS" );

		m= osd.createMenu( bs, 1.0, -0.55, 0.18 );
		m.addItem( "MANUFACTURERS", CMD_MAIN6_1 );
		m.addItem( "LOGOS", CMD_MAIN6_2 );
		m.addItem( "NUMBERS", CMD_MAIN6_3 );
		m.addItem( "DIGITS", CMD_MAIN6_4 );
		m.addItem( "SMILIES", CMD_MAIN6_5 );
		m.addItem( "ANIMALS", CMD_MAIN6_6 );
		m.addItem( "MISC", CMD_MAIN6_7 );
		
		osd.createButton( bek, 0.85, -0.92, CMD_FRONTPAGE, null );
		osd.createButton( bex, 0.92, -0.92, CMD_EXIT, null );

		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_FRONTPAGE, this );
		osd.hideGroup( main6Group = osd.endGroup() );

		//----------------------------------------Akatreszlista oldalak 1

		osd.createBG( new ResourceRef(misc.catalog:0x0009r) );
		createCatalogHeader( "ENGINE" );

		pageNumberL[0] = osd.createText( null, Frontend.mediumFont, Text.ALIGN_LEFT,  -0.88, bbcy-0.025 );
		pageNumberR[0] = osd.createText( null, Frontend.mediumFont, Text.ALIGN_RIGHT,  0.88, bbcy-0.025 );

		osd.createButton( bbsl, -0.96, bbcy, CMD_PREVPARTPAGE, null );
		osd.createButton( bbsr,  0.96, bbcy, CMD_NEXTPARTPAGE, null );

		osd.createButton( bek, 0.85, -0.92, CMD_MAIN1, null );
		osd.createButton( bex, 0.92, -0.92, CMD_EXIT, null );

		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_MAIN1, this );
		osd.hideGroup( parts1Group = osd.endGroup() );

		//----------------------------------------Akatreszlista oldalak 2

		osd.createBG( new ResourceRef(misc.catalog:0x0010r) );
		createCatalogHeader( "BODY" );

		pageNumberL[1] = osd.createText( null, Frontend.mediumFont, Text.ALIGN_LEFT,  -0.88, bbcy-0.025 );
		pageNumberR[1] = osd.createText( null, Frontend.mediumFont, Text.ALIGN_RIGHT,  0.88, bbcy-0.025 );

		osd.createButton( bbsl, -0.96, bbcy, CMD_PREVPARTPAGE, null );
		osd.createButton( bbsr,  0.96, bbcy, CMD_NEXTPARTPAGE, null );

		osd.createButton( bek, 0.85, -0.92, CMD_MAIN2, null );
		osd.createButton( bex, 0.92, -0.92, CMD_EXIT, null );

		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_MAIN2, this );
		osd.hideGroup( parts2Group = osd.endGroup() );

		//----------------------------------------Akatreszlista oldalak 3

		osd.createBG( new ResourceRef(misc.catalog:0x0011r) );
		createCatalogHeader( "RUNNING GEAR" );

		pageNumberL[2] = osd.createText( null, Frontend.mediumFont, Text.ALIGN_LEFT,  -0.88, bbcy-0.025 );
		pageNumberR[2] = osd.createText( null, Frontend.mediumFont, Text.ALIGN_RIGHT,  0.88, bbcy-0.025 );

		osd.createButton( bbsl, -0.96, bbcy, CMD_PREVPARTPAGE, null );
		osd.createButton( bbsr,  0.96, bbcy, CMD_NEXTPARTPAGE, null );

		osd.createButton( bek, 0.85, -0.92, CMD_MAIN3, null );
		osd.createButton( bex, 0.92, -0.92, CMD_EXIT, null );

		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_MAIN3, this );
		osd.hideGroup( parts3Group = osd.endGroup() );

		//----------------------------------------Akatreszlista oldalak 3.5

		osd.createBG( new ResourceRef(misc.catalog:0x0011r) );
		createCatalogHeader( "RUNNING GEAR: RIMS" );

		pageNumberL[3] = osd.createText( null, Frontend.mediumFont, Text.ALIGN_LEFT,  -0.88, bbcy-0.025 );
		pageNumberR[3] = osd.createText( null, Frontend.mediumFont, Text.ALIGN_RIGHT,  0.88, bbcy-0.025 );

		osd.createButton( bbsl, -0.96, bbcy, CMD_PREVPARTPAGE, null );
		osd.createButton( bbsr,  0.96, bbcy, CMD_NEXTPARTPAGE, null );

		osd.createButton( bek, 0.85, -0.92, CMD_MAIN3_5, null );
		osd.createButton( bex, 0.92, -0.92, CMD_EXIT, null );

		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_MAIN3_5, this );
		osd.hideGroup( parts7Group = osd.endGroup() );

		//----------------------------------------Akatreszlista oldalak 3.6

		osd.createBG( new ResourceRef(misc.catalog:0x0011r) );
		createCatalogHeader( "RUNNING GEAR: TYRES" );

		pageNumberL[7] = osd.createText( null, Frontend.mediumFont, Text.ALIGN_LEFT,  -0.88, bbcy-0.025 );
		pageNumberR[7] = osd.createText( null, Frontend.mediumFont, Text.ALIGN_RIGHT,  0.88, bbcy-0.025 );

		osd.createButton( bbsl, -0.96, bbcy, CMD_PREVPARTPAGE, null );
		osd.createButton( bbsr,  0.96, bbcy, CMD_NEXTPARTPAGE, null );

		osd.createButton( bek, 0.85, -0.92, CMD_MAIN3_6, null );
		osd.createButton( bex, 0.92, -0.92, CMD_EXIT, null );

		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_MAIN3_6, this );
		osd.hideGroup( parts8Group = osd.endGroup() );

		//----------------------------------------Akatreszlista oldalak 4

		osd.createBG( new ResourceRef(misc.catalog:0x001Er) );
		createCatalogHeader( "INTERIOR" );

		pageNumberL[4] = osd.createText( null, Frontend.mediumFont, Text.ALIGN_LEFT,  -0.88, bbcy-0.025 );
		pageNumberR[4] = osd.createText( null, Frontend.mediumFont, Text.ALIGN_RIGHT,  0.88, bbcy-0.025 );

		osd.createButton( bbsl, -0.96, bbcy, CMD_PREVPARTPAGE, null );
		osd.createButton( bbsr,  0.96, bbcy, CMD_NEXTPARTPAGE, null );

		osd.createButton( bek, 0.85, -0.92, CMD_MAIN4, null );
		osd.createButton( bex, 0.92, -0.92, CMD_EXIT, null );

		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_MAIN4, this );
		osd.hideGroup( parts4Group = osd.endGroup() );

		//----------------------------------------Akatreszlista oldalak 5

		osd.createBG( new ResourceRef(misc.catalog:0x001Fr) );
		createCatalogHeader( "AUDIO" );

		pageNumberL[5] = osd.createText( null, Frontend.mediumFont, Text.ALIGN_LEFT,  -0.88, bbcy-0.025 );
		pageNumberR[5] = osd.createText( null, Frontend.mediumFont, Text.ALIGN_RIGHT,  0.88, bbcy-0.025 );

		osd.createButton( bbsl, -0.96, bbcy, CMD_PREVPARTPAGE, null );
		osd.createButton( bbsr,  0.96, bbcy, CMD_NEXTPARTPAGE, null );

		osd.createButton( bek, 0.85, -0.92, CMD_MAIN5, null );
		osd.createButton( bex, 0.92, -0.92, CMD_EXIT, null );

		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_MAIN5, this );
		osd.hideGroup( parts5Group = osd.endGroup() );

		//----------------------------------------Altalanos decallista oldal

		osd.createBG( new ResourceRef(misc.catalog:0x0022r) );
		createCatalogHeader( "DECALS" );

		Style dbs = new Style( 0.45, 0.45, Frontend.largeFont, Text.ALIGN_CENTER, Osd.RRT_TEST );

		curDecals = new Decal[8];
		decalButtons=new Button[8];
		decalButtons[0] = osd.createButton( dbs, -0.75, -0.35, "", CMD_DB0 );
		decalButtons[1] = osd.createButton( dbs, -0.25, -0.35, "", CMD_DB1 );
		decalButtons[2] = osd.createButton( dbs,  0.25, -0.35, "", CMD_DB2 );
		decalButtons[3] = osd.createButton( dbs,  0.75, -0.35, "", CMD_DB3 );
		decalButtons[4] = osd.createButton( dbs, -0.75,  0.40, "", CMD_DB4 );
		decalButtons[5] = osd.createButton( dbs, -0.25,  0.40, "", CMD_DB5 );
		decalButtons[6] = osd.createButton( dbs,  0.25,  0.40, "", CMD_DB6 );
		decalButtons[7] = osd.createButton( dbs,  0.75,  0.40, "", CMD_DB7 );

		pageNumberL[6] = osd.createText( null, Frontend.mediumFont, Text.ALIGN_LEFT,  -0.88, bbcy-0.025 );
		pageNumberR[6] = osd.createText( null, Frontend.mediumFont, Text.ALIGN_RIGHT,  0.88, bbcy-0.025 );

		osd.createButton( bbsl, -0.96, bbcy, CMD_PREVDECALPAGE, null );
		osd.createButton( bbsr,  0.96, bbcy, CMD_NEXTDECALPAGE, null );

		osd.createButton( bek, 0.85, -0.92, CMD_MAIN6, null );
		osd.createButton( bex, 0.92, -0.92, CMD_EXIT, null );

		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_MAIN6, this );
		osd.hideGroup( decalsGroup = osd.endGroup() );

		//------------------------------------------

		refreshMoneyString();
		refreshPage();
	}	


	public void changeGroup(int group)
	{
		if( actGroup != group )
		{
			if (actGroup >= 0)
			{
				osd.hideGroup (actGroup);

				//group deinit code:
				if( actGroup == decalsGroup )
				{
					clearDecalButtons();
				}
				else
				if( actGroup >= parts1Group && actGroup <= parts5Group )
				{
					clearObjectCache();
				}
			}

			actGroup = group;

			if (actGroup >= 0)
			{
				osd.showGroup (actGroup);
				osd.changeSelection2( -1, 0 );
			}
		}
	}


	public void refreshMoneyString()
	{
		new SfxRef( Frontend.SFX_MONEY ).play(); 
		moneytxt.changeText( "$" + Integer.toString( player.money ) );
	}

	public void refreshPage()
	{
		if( pageNumberPrefix )
		{
			pgNumberL.changeText( pageNumberPrefix + curpage );
			pgNumberR.changeText( pageNumberPrefix + (curpage+1) );
		}
	}

//----------------------------------------------------------------------

	public void decalButtonPressed( int n )
	{
		if( showDecals+n < decals.size() )
		{
			int price=DECALPRICE;
			if( price <= player.money )
			{
				Decal decal = decals.elementAt( showDecals+n );

				Dialog dialog = new YesNoDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "BUY DECAL SET", "Do you want to buy this decal set for $" + price + " ?\n(Each set contains 5 decals)" );
				if( dialog.display() == 0 )
				{
					player.money-=price;
					player.decals.addElement( new Decal( decal.id() ) );
					refreshMoneyString();
				}
			}
			else
			{
				new WarningDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "NOT ENOUGHT MONEY", "You don't have $" + price + " to buy a decal!" ).display();
			}
		}
	}

//----------------------------------------------------------------------
	public void osdCommand( int cmd )
	{
		if( cmd == CMD_VCOLOR )
		{
			if(CurrentCar)
			{
				if( ColorIDX == GameLogic.CARCOLORS.length - 1) 
					ColorIDX = 0;
				else
					ColorIDX += 1;

				CurrentCar.command( "texture " + GameLogic.CARCOLORS[ColorIDX] + " 1" );
				if( VColor_Button ) VColor_Button.changeTexture( new ResourceRef(GameLogic.CARCOLORS[ColorIDX]) );
			}
		}
		else
		if( cmd == CMD_VBUY )
		{
			if( TotalP <= player.money )
			{
			// Create name: car name or chassis name
				String Vname;
				if( CompleteCar > 0 ) Vname = CurrentCar.chassis.vehicleName;
				else Vname = CurrentCar.chassis.name;

			// Check for free space at garage
				int	GarageFree;

				if( GameLogic.player.car )
				{
					//GameLogic.garage.releaseCar();
					GameLogic.player.carlot.lockPlayerCar();
					GarageFree = GameLogic.player.carlot.getFreeSlot();
					GameLogic.player.carlot.releasePlayerCar();
					
				//Reset car pos at garage
					GameLogic.garage.StartPos = new Vector3(0, 0, 0);
					GameLogic.garage.StartYpr = new Ypr(0, 0, 0);
				}
				else
					GarageFree = 1;

				if( GarageFree >= 0 )
				{
					Dialog dialog = new NoYesDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "BUY CAR", "Do you want to buy this " + Vname  + " for $" + TotalP + " ?" );
					if( dialog.display() == 0 )
					{
						player.money-=TotalP;
						refreshMoneyString();

						player.carlot.addCar( player.car );
						player.carlot.saveCar( player.carlot.curcar );
						player.carlot.flushCars();

						//CurrentCar.command( "start" );	//release
						
						if (File.exists("save/temp/CopyCar"))
						{
							File.delete( "save/temp/CopyCar" );
							File.delete( "save/temp/CopyCar.*" );
						}
						CurrentCar.save( "save/temp/CopyCar" );

						if(CurrentCar) CurrentCar.destroy();
						if(CurrentChassis) CurrentChassis.destroy();

						GameLogic.player.car = Vehicle.load( "save/temp/CopyCar", GameLogic.player );

						changeGroup( -1 );
						GameLogic.changeActiveSection( GameLogic.garage );
					}
				}
				else 
				{ 
					new WarningDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "CAR LOT FULL", "There is no more free space in your car lot. \n Sell some cars to free up parking space!" ).display();
				}
			}
			else
			{
					new WarningDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "NOT ENOUGHT MONEY", "You don't have $" + TotalP + " to buy this car!" ).display();
			}
		}
		else
		if( cmd == CMD_CHAS )
		{
			if( CompleteCar > 0 )
			{
				if(CurrentCar) CurrentCar.destroy();
				if(CurrentChassis) CurrentChassis.destroy();

				CurrentCar = new Vehicle();
				CurrentCar.chassis = new Chassis();
				CurrentCar.chassis = create(CarScene, new GameRef(GameLogic.ChassisRoot[GameLogic.ChassisResNoumber[CurrentName+ButtonNum]]), "0,0,0,0,0,0,", "chassis");
				CurrentCar = new Vehicle(CurrentCar.chassis);

				CurrentCarName.changeText( CurrentCar.chassis.vehicleName );
				if( CurrentCarDescription ) CurrentCarDescription.changeText( CurrentCar.chassis.description );

				RetailP = CurrentCar.getTotalPrice()*PRICERATIO; // Clac retail price
				RetailText.changeText( "$" + RetailP );// show text

				DeliveryP = CurrentCar.chassis.getMass()*5.8; // Calc delivery price
				DeliveryText.changeText( "$" + DeliveryP );// show text

				TotalP = RetailP + DeliveryP; // Calc total price
				TotalText.changeText( "$" + TotalP );// show text

				if( VColor_Button )
				{
					VColor_Button.disable();
					VColor_Button.changeTexture( new ResourceRef( frontend:0x00AFr ) );
				}
				
				if( Config.carCatalogColor == 0 )
				{
					CurrentCar.chassis.setTexture( DEFAULT_VEHICLE_COLOR );
				}
			}

			CompleteCar = 0;
		}
		else
		if( cmd == CMD_VEHI )
		{
			if( CompleteCar == 0 && CurrentCar )
			{
				if( Config.carCatalogColor == 1 )
					CurrentCar.chassis.addStockParts( new Descriptor( CurrentCar.chassis.getTexture(), 1, 1, 1, 1 ) );
				else
					CurrentCar.chassis.addStockParts( new Descriptor( DEFAULT_VEHICLE_COLOR, 1, 1, 1, 1 ) );
				CurrentCar.chassis.command( "reset" );
				CurrentCar.chassis.command( "setsteer -0.6" );

				RetailP = CurrentCar.getTotalPrice()*PRICERATIO; // Clac retail price
				RetailText.changeText( "$" + RetailP );// show text

				DeliveryP = CurrentCar.chassis.getMass()*5.8; // Calc delivery price
				DeliveryText.changeText( "$" + DeliveryP );// show text
				
				TotalP = RetailP + DeliveryP; // Calc total price
				TotalText.changeText( "$" + TotalP );// show text

				if( VColor_Button )
				{
					VColor_Button.enable();
					VColor_Button.changeTexture( new ResourceRef(CurrentCar.chassis.getTexture()) );
				}
			}
			CompleteCar = 1;
		}
		else
		if( cmd >= CMD_VEH0 && cmd <= CMD_VEH9 ) // All 10 buttons
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

			if(CurrentCar) CurrentCar.destroy();
			if(CurrentChassis) CurrentChassis.destroy();

			CurrentCar = new Vehicle();
			CurrentCar.chassis = new Chassis();
			CurrentCar.chassis = create(CarScene, new GameRef(GameLogic.ChassisRoot[GameLogic.ChassisResNoumber[CurrentName+ButtonNum]]), "0,0,0,0,0,0,", "chassis");
			CurrentCar = new Vehicle(CurrentCar.chassis);

			Size = CurrentCar.chassis.getMin();

			//Cam.setMatrix( new Vector3( -2, 1, -4), new Ypr( -2.7, -0.2, 0)); //car size fix, but I don't like it
			Cam.command( "move " + CarScene.id() +" "+(Size.x*2.2)+","+(Size.y*2.2)+","+(Size.z*2.2)+" 1.0 0, -0.2, 0" );

			//Cam.setMatrix( new Vector3(-(Max.x-Min.x+1), Max.y, -(Max.z-Min.z+1)), new Ypr(-2.358, -0.5, 0));
			//float size = CurrentCar.chassis.getInfo(GameType.GII_SIZE)/100.0;

			if( CompleteCar )
			{
				if( Config.carCatalogColor == 1 )
					CurrentCar.chassis.addStockParts( new Descriptor( CurrentCar.chassis.getTexture(), 1, 1, 1, 1 ) );
				else
					CurrentCar.chassis.addStockParts( new Descriptor( DEFAULT_VEHICLE_COLOR, 1, 1, 1, 1 ) );
				CurrentCar.chassis.command( "reset" );
				CurrentCar.chassis.command( "setsteer -0.6" );

				if( VColor_Button )
				{
					VColor_Button.enable();
					VColor_Button.changeTexture( new ResourceRef(CurrentCar.chassis.getTexture()) );
				}
			}
			else if( Config.carCatalogColor == 0 )
			{
				CurrentCar.chassis.setTexture( DEFAULT_VEHICLE_COLOR );
			}

			CurrentCarName.changeText( CurrentCar.chassis.vehicleName );
			if( CurrentCarDescription ) CurrentCarDescription.changeText( CurrentCar.chassis.description );

			RetailP = CurrentCar.getTotalPrice()*PRICERATIO; // Clac retail price
			RetailText.changeText( "$" + RetailP );// show text

			DeliveryP = CurrentCar.chassis.getMass()*5.8; // Calc delivery price
			DeliveryText.changeText( "$" + DeliveryP );// show text

			TotalP = RetailP + DeliveryP; // Calc total price
			TotalText.changeText( "$" + TotalP );// show text
		}
		else
		if( cmd == CMD_UP )
		{
			if (CurrentPage > 0)
				CurrentPage -= 1;

			CurrentName = CurrentPage*10;
			CurrentPageText.changeText( "Current Page: " + (CurrentPage+1) );

			VehAmount = GameLogic.ChassisBox.size()-1;

			DownButton.changeTexture( new ResourceRef( frontend:0x0084r ) ); // Arrow down
			DownButton.enable();
			
			if (CurrentPage == 0)
			{
				UpButton.changeTexture( new ResourceRef( frontend:0x00AFr ) ); // Empty.ptx
				UpButton.disable();
				
				if( VehAmount < 10 )
				{
					DownButton.changeTexture( new ResourceRef( frontend:0x00AFr ) ); // Empty.ptx
					DownButton.disable();
				}
			}

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
		}
		else
		if( cmd == CMD_DOWN )
		{
			if (GameLogic.ChassisRoot.length >= CurrentName+10)
				CurrentPage += 1;

			CurrentName = CurrentPage*10;

			CurrentPageText.changeText( "Current Page: " + (CurrentPage+1) );

			UpButton.changeTexture( new ResourceRef(frontend:0x004Cr) ); // Arrow up
			UpButton.enable();

			VehAmount = GameLogic.ChassisBox.size()-1;

			if (VehAmount < CurrentName+10)
			{
				DownButton.changeTexture( new ResourceRef(frontend:0x00AFr) ); // Empty.ptx
				DownButton.disable();
			}

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
		}
		else
		if( cmd==CMD_EXIT )							//main index pages
		{
			changeGroup( -1 );
			GameLogic.changeActiveSection( GameLogic.garage );

			if(CurrentCar) CurrentCar.destroy();
			if(CurrentChassis) CurrentChassis.destroy();
		}
		else
		if( cmd==CMD_FRONTPAGE )
		{
			changeGroup( mainGroup );

			if(CurrentCar) CurrentCar.destroy();
			if(CurrentChassis) CurrentChassis.destroy();
		}
		else
		if( cmd==CMD_VEHICLE )
		{
			//pgNumberL=pageNumberL[0];
			//pgNumberR=pageNumberR[0];
			changeGroup( VehicleGroup );
			VehicleScene();
		}
		else
		if( cmd==CMD_MAIN1 )
		{
			pgNumberL=pageNumberL[0];
			pgNumberR=pageNumberR[0];
			changeGroup( main1Group );
		}
		else
		if( cmd==CMD_MAIN2 )
		{
			pgNumberL=pageNumberL[1];
			pgNumberR=pageNumberR[1];
			changeGroup( main2Group );
		}
		else
		if( cmd==CMD_MAIN3 )
		{
			pgNumberL=pageNumberL[2];
			pgNumberR=pageNumberR[2];
			changeGroup( main3Group );
		}
		else
		if( cmd==CMD_MAIN3_5 )
		{
			pgNumberL=pageNumberL[3];
			pgNumberR=pageNumberR[3];
			changeGroup( main7Group );
		}
		else
		if( cmd==CMD_MAIN3_6 )
		{
			pgNumberL=pageNumberL[7];
			pgNumberR=pageNumberR[7];
			changeGroup( main8Group );
		}
		else
		if( cmd==CMD_MAIN4 )
		{
			pgNumberL=pageNumberL[4];
			pgNumberR=pageNumberR[4];
			changeGroup( main4Group );
		}
		else
		if( cmd==CMD_MAIN5 )
		{
			pgNumberL=pageNumberL[5];
			pgNumberR=pageNumberR[5];
			changeGroup( main5Group );
		}
		else
		if( cmd==CMD_MAIN6 )
		{
			pgNumberL=pageNumberL[6];
			pgNumberR=pageNumberR[6];
			changeGroup( main6Group );
		}
		else
		if( cmd>=CMD_DB0 && cmd<=CMD_DB7 )			//decal buttons
		{
			decalButtonPressed( cmd - CMD_DB0 );
		}
		else
		if( cmd>=CMD_MAIN6_1 && cmd<=CMD_MAIN6_7 )	//decal subsections
		{
			String decalsDir;
			if( cmd == CMD_MAIN6_1 )
			{
				pageNumberPrefix="D-I/";
				decalsDir = "manufacturers";
			}
			else
			if( cmd == CMD_MAIN6_2 )
			{
				pageNumberPrefix="D-II/";
				decalsDir = "logos";
			}
			else
			if( cmd == CMD_MAIN6_3 )
			{
				pageNumberPrefix="D-III/";
				decalsDir = "numbers";
			}
			else
			if( cmd == CMD_MAIN6_4 )
			{
				pageNumberPrefix="D-IV/";
				decalsDir = "digits";
			}
			else
			if( cmd == CMD_MAIN6_5 )
			{
				pageNumberPrefix="D-V/";
				decalsDir = "smilies";
			}
			else
			if( cmd == CMD_MAIN6_6 )
			{
				pageNumberPrefix="D-VI/";
				decalsDir = "animals";
			}
			else
			if( cmd == CMD_MAIN6_7 )
			{
				pageNumberPrefix="D-VII/";
				decalsDir = "misc";
			}

			decals = collectDecals( decalsDir );

			curpage=1;
			showDecals=0;

			setDecalButtons();
			refreshPage();
			changeGroup( decalsGroup );
		}
		else
		if( cmd == CMD_PREVDECALPAGE )					//page control
		{
			if( showDecals >= decalButtons.length )
			{
				showDecals-=decalButtons.length;
				setDecalButtons();

				curpage-=2;
				refreshPage();
			}
		}
		else
		if( cmd == CMD_NEXTDECALPAGE )
		{
			int	max = decals.size();
			if( showDecals+decalButtons.length < max )
			{
				showDecals+=decalButtons.length;
				setDecalButtons();

				curpage+=2;
				refreshPage();
			}
		}
		else
		if( cmd == CMD_PREVPARTPAGE )
		{
			if( inventory.upScroll() )
			{
				curpage-=2;
				refreshPage();
			}
		}
		else
		if( cmd == CMD_NEXTPARTPAGE )
		{
			//biztositsuk, hogy a kov oldal is tele van (az init csak a legelsot tolti fel rendesen!)
			//ha az user cselez, atugrik masik sectionbe, aztan visszalapoz, megszivja!
			collectObjectsStep( 8 );

			if(	inventory.downScroll() )
			{
				curpage+=2;
				refreshPage();
			}
		}
		else // Collector filters:
		if( cmd == NO_FILTER )
		{
			inventory.items.addElement( new InventoryItem_Part( inventory, parts.id() ) );
			step--;
		}
		else
		if( cmd == RIMS_FILTER )
		{
			Wheel rim = new Wheel();
			rim = create( null, new GameRef(parts), "0,0,0,0,0,0,", "temp rim");

			if( rimSize <= 13 ) // Smaller rims
			{
				if( rim.getRadius() <= 13 )
				{
					inventory.items.addElement( new InventoryItem_Part( inventory, parts.id() ) );
					step--;
				}
			}
			else
			if( rimSize >= 22 ) // Bigger rims
			{
				if( rim.getRadius() >= 22 )
				{
					inventory.items.addElement( new InventoryItem_Part( inventory, parts.id() ) );
					step--;
				}
			}
			else // 14"-21"
			{
				if( rim.getRadius() >= rimSize && rim.getRadius() < rimSize+1 )
				{
					inventory.items.addElement( new InventoryItem_Part( inventory, parts.id() ) );
					step--;
				}
			}
		}
		else
		if( cmd == TYRES_FILTER )
		{
			Tyre rubber = new Tyre();
			rubber = create( null, new GameRef(parts), "0,0,0,0,0,0,", "temp rubber");

			float rimDiameter = rubber.wheel_radius*2/25.4;
			
			if( tyreSize <= 13 ) // Smaller tyres
			{
				if( rimDiameter <= 13 )
				{
					inventory.items.addElement( new InventoryItem_Part( inventory, parts.id() ) );
					step--;
				}
			}
			else
			if( tyreSize >= 22 ) // Bigger tyres
			{
				if( rimDiameter >= 22 )
				{
					inventory.items.addElement( new InventoryItem_Part( inventory, parts.id() ) );
					step--;
				}
			}
			else // 14"-21"
			{
				if( rimDiameter >= tyreSize && rimDiameter < tyreSize+1 )
				{
					inventory.items.addElement( new InventoryItem_Part( inventory, parts.id() ) );
					step--;
				}
			}
		}
		else // Parts collector buttons:
		if( cmd >= CMD_MAIN1_1 && cmd < CMD_MAIN6_1 ) // all parts pages buttons
		{
			collectObjectsBegin();

			if( cmd >= CMD_MAIN1_1 && cmd < CMD_MAIN2_1 ) // all engine part page
			{
				changeGroup( parts1Group );

				if( cmd == CMD_MAIN1_1 )						//engine subsections
				{
					pageNumberPrefix="E-I/";
					collectObjects( new GameRef(parts:0x025Cr), new GameRef(parts:0xA05Cr) ); // Engine Blocks
					collectObjects( new GameRef(parts:0xAB5Cr), new GameRef(parts:0xAA5Cr), new GameRef(parts:0xAD5Cr) ); // 2.3.0 LE
					collectObjects( new GameRef(parts:0xAC5Cr), new GameRef(parts:0xAE5Cr), new GameRef(parts:0xAF5Cr) ); // 2.3.0 LE
					filter = NO_FILTER;
				}
				else
				if( cmd == CMD_MAIN1_2 )
				{
					pageNumberPrefix="E-II/";
					collectObjects( new GameRef(parts:0x025Er), new GameRef(parts:0xA05Er) ); // Crankshafts & Bearning
					collectObjects( new GameRef(parts:0xAA5Er), new GameRef(parts:0xAB5Er), new GameRef(parts:0xAD5Er) ); // 2.3.0 LE
					collectObjects( new GameRef(parts:0xAC5Er), new GameRef(parts:0xAE5Er), new GameRef(parts:0xAF5Er) ); // 2.3.0 LE
					filter = NO_FILTER;
				}
				else
				if( cmd == CMD_MAIN1_3 )
				{
					pageNumberPrefix="E-III/";
					collectObjects( new GameRef(parts:0x00B7r), new GameRef(parts:0x0B7Er) ); // Connecting Rods
					collectObjects( new GameRef(parts:0xAB7Er), new GameRef(parts:0xBB7Er), new GameRef(parts:0xDB7Er) ); // 2.3.0 LE
					collectObjects( new GameRef(parts:0xCB7Er), new GameRef(parts:0xEB7Er), new GameRef(parts:0xFB7Er) ); // 2.3.0 LE
					filter = NO_FILTER;
				}
				else
				if( cmd == CMD_MAIN1_4 )
				{
					pageNumberPrefix="E-IV/";
					collectObjects( new GameRef(parts:0x00B6r) ); // Pistons
					collectObjects( new GameRef(parts:0x0AB6r), new GameRef(parts:0x0BB6r), new GameRef(parts:0x0DB6r) ); // 2.3.0 LE
					collectObjects( new GameRef(parts:0x0CB6r), new GameRef(parts:0x0EB6r), new GameRef(parts:0x0FB6r) ); // 2.3.0 LE
					filter = NO_FILTER;
				}
				else
				if( cmd == CMD_MAIN1_5 )
				{
					pageNumberPrefix="E-V/";
					collectObjects( new GameRef(parts:0x0252r) ); // Oil Pans
					filter = NO_FILTER;
				}
				else
				if( cmd == CMD_MAIN1_6 )
				{
					pageNumberPrefix="E-VI/";
					collectObjects( new GameRef(parts:0x025Dr) ); // Cylinder Heads
					collectObjects( new GameRef(parts:0xA25Dr), new GameRef(parts:0xB25Dr), new GameRef(parts:0xD25Dr) ); // 2.3.0 LE
					collectObjects( new GameRef(parts:0xC25Dr), new GameRef(parts:0xE25Dr), new GameRef(parts:0xF25Dr) ); // 2.3.0 LE
					filter = NO_FILTER;
				}
				else
				if( cmd == CMD_MAIN1_7 )
				{
					pageNumberPrefix="E-VII/";
					collectObjects( new GameRef(parts:0x025Fr) ); // Intake & Exhaust Camshafts
					collectObjects( new GameRef(parts:0xA25Fr), new GameRef(parts:0xB25Fr), new GameRef(parts:0xD25Fr) ); // 2.3.0 LE
					collectObjects( new GameRef(parts:0xC25Fr), new GameRef(parts:0xE25Fr), new GameRef(parts:0xF25Fr) ); // 2.3.0 LE
					filter = NO_FILTER;
				}
				else
				if( cmd == CMD_MAIN1_8 )
				{
					pageNumberPrefix="E-VIII/";
					collectObjects( new GameRef(parts:0x0255r), new GameRef(parts:0x026Fr) ); // Air Delivery
					collectObjects( new GameRef(parts:0xA26Fr), new GameRef(parts:0xB26Fr), new GameRef(parts:0xD26Fr) ); // 2.3.0 LE
					collectObjects( new GameRef(parts:0xC26Fr), new GameRef(parts:0xE26Fr), new GameRef(parts:0xF26Fr) ); // 2.3.0 LE
					filter = NO_FILTER;
				}
				else
				if( cmd == CMD_MAIN1_9 )
				{
					pageNumberPrefix="E-IX/";
					collectObjects( new GameRef(parts:0x026Br), new GameRef(parts:0x026Er) ); // Fuel Delivery
					collectObjects( new GameRef(parts:0xA26Br), new GameRef(parts:0xB26Br), new GameRef(parts:0xD26Br) ); // 2.3.0 LE
					collectObjects( new GameRef(parts:0xC26Br), new GameRef(parts:0xE26Br), new GameRef(parts:0xF26Br) ); // 2.3.0 LE
					filter = NO_FILTER;
				}
				if( cmd == CMD_MAIN1_10 )
				{
					pageNumberPrefix="E-X/";
					collectObjects( new GameRef(parts:0x0249r), new GameRef(parts:0x023Cr) ); // Clutchs & Flywheels
					collectObjects( new GameRef(parts:0xA23Cr), new GameRef(parts:0xB23Cr), new GameRef(parts:0xD23Cr) ); // 2.3.0 LE
					collectObjects( new GameRef(parts:0xC23Cr), new GameRef(parts:0xE23Cr)/*, new GameRef(parts:0xF23Cr)*/ ); // 2.3.0 LE
					filter = NO_FILTER;
				}
				if( cmd == CMD_MAIN1_11 )
				{
					pageNumberPrefix="E-XI/";
					collectObjects( new GameRef(parts:0x024Ar), new GameRef(parts:0x023Br)/*, new GameRef(parts:0x024Br)*/ ); // Transmission & Drivetrain
					collectObjects( new GameRef(parts:0xA24Br), new GameRef(parts:0xB24Br), new GameRef(parts:0xD24Br) ); // 2.3.0 LE
					collectObjects( new GameRef(parts:0xC24Br), new GameRef(parts:0xE24Br), new GameRef(parts:0xF24Br) ); // 2.3.0 LE
					filter = NO_FILTER;
				}
				if( cmd == CMD_MAIN1_12 )
				{
					pageNumberPrefix="E-XII/";
					collectObjects( new GameRef(parts:0x0282r) ); // Exhaust System
					collectObjects( new GameRef(parts:0xA282r), new GameRef(parts:0xB282r), new GameRef(parts:0xD282r) ); // 2.3.0 LE
					collectObjects( new GameRef(parts:0xC282r), new GameRef(parts:0xE282r), new GameRef(parts:0xF282r) ); // 2.3.0 LE
					filter = NO_FILTER;
				}
				if( cmd == CMD_MAIN1_20 )
				{
					pageNumberPrefix="E-XIII/";
					collectObjects( new GameRef(parts:0x0250r) ); // Exhaust Pipes
					filter = NO_FILTER;
				}
				if( cmd == CMD_MAIN1_13 )
				{
					pageNumberPrefix="E-XIV/";
					collectObjects( new GameRef(parts:0x00C9r) ); // Exhaust Tips
					filter = NO_FILTER;
				}
				if( cmd == CMD_MAIN1_14 )
				{
					pageNumberPrefix="E-XIIV/";
					collectObjects( new GameRef(parts:0x00BEr) ); // Drive Belts
					collectObjects( new GameRef(parts:0x0ABEr), new GameRef(parts:0x0BBEr), new GameRef(parts:0x0DBEr) ); // 2.3.0 LE
					collectObjects( new GameRef(parts:0x0CBEr), new GameRef(parts:0x0EBEr), new GameRef(parts:0x0FBEr) ); // 2.3.0 LE
					filter = NO_FILTER;
				}
				if( cmd == CMD_MAIN1_15 )
				{
					pageNumberPrefix="E-XV/";
					collectObjects( new GameRef(parts:0x0012r) ); // Accesories & Others
					filter = NO_FILTER;
				}
				if( cmd == CMD_MAIN1_16 )
				{
					pageNumberPrefix="E-XVI/";
					collectObjects( new GameRef(parts:0x0010r) ); // Batteries
					filter = NO_FILTER;
				}
				if( cmd == CMD_MAIN1_17 )
				{
					pageNumberPrefix="E-XVII/";
					collectObjects( new GameRef(parts:0x00BDr), new GameRef(parts:0x0281r), new GameRef(parts:0x0279r) ); // Charging System
					filter = NO_FILTER;
				}
				if( cmd == CMD_MAIN1_18 )
				{
					pageNumberPrefix="E-XVIII/";
					collectObjects( new GameRef(parts:0xF27Dr), new GameRef(parts:0x0117r), /*new GameRef(parts:0x00B4r),*/ new GameRef(parts:0x0277r) ); // Pro tunning
					collectObjects( new GameRef(parts:0x0AB4r), new GameRef(parts:0x0BB4r), new GameRef(parts:0x0DB4r) ); // 2.3.0 LE
					collectObjects( new GameRef(parts:0x0CB4r), new GameRef(parts:0x0EB4r), new GameRef(parts:0x0FB4r) ); // 2.3.0 LE
					filter = NO_FILTER;
				}
				if( cmd == CMD_MAIN1_19 )
				{
					pageNumberPrefix="E-XIX/";
					collectObjects( new GameRef(parts:0xF23Cr) ); // Engine Kits
					filter = NO_FILTER;
				}
			}
			else
			if( cmd >= CMD_MAIN2_1 && cmd < CMD_MAIN3_1 ) // body subs
			{
				changeGroup( parts2Group );
				if( cmd == CMD_MAIN2_1 )					
				{
					pageNumberPrefix="B-I/";
					collectObjects( new GameRef(parts:0xF242r) ); // Body Panels
					filter = NO_FILTER;
				}
				else
				if( cmd == CMD_MAIN2_2 )					
				{
					pageNumberPrefix="B-II/";
					collectObjects( new GameRef(parts:0xF24Fr) ); // Replacement Parts
					filter = NO_FILTER;
				}
				else
				if( cmd == CMD_MAIN2_3 )					
				{
					pageNumberPrefix="B-III/";
					collectObjects( new GameRef(parts:0xF24Cr) ); // Lights & Windows
					filter = NO_FILTER;
				}
				else
				if( cmd == CMD_MAIN2_4 )				
				{
					pageNumberPrefix="B-IV/";
					collectObjects( new GameRef(parts:0xF266r) ); // Neon Lights
					filter = NO_FILTER;
				}
				else
				if( cmd == CMD_MAIN2_5 )				
				{
					pageNumberPrefix="B-V/";
					collectObjects( new GameRef(parts:0xF233r) ); // Areodynamic Tunning
					filter = NO_FILTER;
				}
				else
				if( cmd == CMD_MAIN2_6 )				
				{
					pageNumberPrefix="B-VI/";
					collectObjects( new GameRef(parts:0xF228r) ); // Others
					filter = NO_FILTER;
				}
				else
				if( cmd == CMD_MAIN2_7 )				
				{
					pageNumberPrefix="B-VII/";
					collectObjects( new GameRef(parts:0xF23Br) ); // Body Kits
					filter = NO_FILTER;
				}
			}
			else
			if( cmd >= CMD_MAIN3_1 && cmd < CMD_MAIN4_1 ) // running gear
			{
				changeGroup( parts3Group );

				if( cmd >= CMD_MAIN3_5_1 && cmd <= CMD_MAIN3_5_10 )	// all rims buttons
				{
					changeGroup( parts7Group );

					collectObjectsBegin();
					collectObjects( new GameRef(parts:0xF235r), new GameRef(parts:0xF23Dr) );
					filter = RIMS_FILTER;

					// Info for RIMS_FILTER
					if( cmd == CMD_MAIN3_5_1 ) rimSize = 13; // Smaller than 14"
					if( cmd == CMD_MAIN3_5_2 ) rimSize = 14;
					if( cmd == CMD_MAIN3_5_3 ) rimSize = 15;
					if( cmd == CMD_MAIN3_5_4 ) rimSize = 16;
					if( cmd == CMD_MAIN3_5_5 ) rimSize = 17;
					if( cmd == CMD_MAIN3_5_6 ) rimSize = 18;
					if( cmd == CMD_MAIN3_5_7 ) rimSize = 19;
					if( cmd == CMD_MAIN3_5_8 ) rimSize = 20;
					if( cmd == CMD_MAIN3_5_9 ) rimSize = 21;
					if( cmd == CMD_MAIN3_5_10) rimSize = 22; // Bigger than 21"

					pageNumberPrefix="R-XIII-"+rimSize+"/";
				}
				else
				if( cmd >= CMD_MAIN3_6_1 && cmd <= CMD_MAIN3_6_10 )	//all Tyres buttons
				{
					changeGroup( parts8Group );

					collectObjectsBegin();
					collectObjects( new GameRef(parts:0xF23Er) );
					filter = TYRES_FILTER;

					// Info for TYRES_FILTER
					if( cmd == CMD_MAIN3_6_1 ) tyreSize = 13; // Smaller than 14"
					if( cmd == CMD_MAIN3_6_2 ) tyreSize = 14;
					if( cmd == CMD_MAIN3_6_3 ) tyreSize = 15;
					if( cmd == CMD_MAIN3_6_4 ) tyreSize = 16;
					if( cmd == CMD_MAIN3_6_5 ) tyreSize = 17;
					if( cmd == CMD_MAIN3_6_6 ) tyreSize = 18;
					if( cmd == CMD_MAIN3_6_7 ) tyreSize = 19;
					if( cmd == CMD_MAIN3_6_8 ) tyreSize = 20;
					if( cmd == CMD_MAIN3_6_9 ) tyreSize = 21;
					if( cmd == CMD_MAIN3_6_10) tyreSize = 22; // Bigger than 21"

					pageNumberPrefix="R-XIV-"+tyreSize+"/";
				}
				else // running gear subsections
				if( cmd == CMD_MAIN3_1 )
				{
					pageNumberPrefix="R-VIII/";
					collectObjects( new GameRef(parts:0xF229r) ); // Suspension
					filter = NO_FILTER;
				}
				else
				if( cmd == CMD_MAIN3_2 )
				{
					pageNumberPrefix="R-IX/";
					collectObjects( new GameRef(parts:0x001Cr)/*, new GameRef(parts:0xF22Br)*/ ); // Shock Absorbers
					filter = NO_FILTER;
				}
				else
				if( cmd == CMD_MAIN3_3 )
				{
					pageNumberPrefix="R-X/";
					collectObjects( new GameRef(parts:0xF22Ar) ); // Springs
					filter = NO_FILTER;
				}
				else
				if( cmd == CMD_MAIN3_4 )
				{
					pageNumberPrefix="R-XI/";
					collectObjects( new GameRef(parts:0xF22Dr) ); // Brakes
					filter = NO_FILTER;
				}
				else
				if( cmd == CMD_MAIN3_7 )
				{
					pageNumberPrefix="R-XII/";
					collectObjects( new GameRef(parts:0x021Fr) ); // Sway Bars
					filter = NO_FILTER;
				}
				else
				if( cmd == CMD_MAIN3_8 )
				{
					pageNumberPrefix="R-VI/";
					collectObjects( new GameRef(parts:0xD120r), new GameRef(parts:0xD121r) ); // Others
					filter = NO_FILTER;
				}
				else
				if( cmd == CMD_MAIN3_9 )
				{
					pageNumberPrefix="R-VII/";
					collectObjects( new GameRef(parts:0xF249r) ); // RG kits
					filter = NO_FILTER;
				}
				else
				if( cmd == CMD_MAIN3_10 )
				{
					pageNumberPrefix="R-I/";
					collectObjects( new GameRef(parts:0x0329r) ); // Factory Suspension
					filter = NO_FILTER;
				}
				else
				if( cmd == CMD_MAIN3_11 )
				{
					pageNumberPrefix="R-II/";
					collectObjects( new GameRef(parts:0x031Cr) ); // Factory Shock Absorbers
					filter = NO_FILTER;
				}
				else
				if( cmd == CMD_MAIN3_12 )
				{
					pageNumberPrefix="R-III/";
					collectObjects( new GameRef(parts:0x032Ar) ); // Factory Springs
					filter = NO_FILTER;
				}
				else
				if( cmd == CMD_MAIN3_13 )
				{
					pageNumberPrefix="R-IV/";
					collectObjects( new GameRef(parts:0x032Dr) ); // Factory Brakes
					filter = NO_FILTER;
				}
				else
				if( cmd == CMD_MAIN3_14 )
				{
					pageNumberPrefix="R-V/";
					collectObjects( new GameRef(parts:0x031Fr) ); // Factory Sway Bars
					filter = NO_FILTER;
				}
				else
				if( cmd == CMD_MAIN3_15 )
				{
					pageNumberPrefix="R-XV/";
					//collectObjects( new GameRef(parts:0x0000r) ); // UR Text Here
					filter = NO_FILTER;
				}
			}
			else
			if( cmd >= CMD_MAIN4_1 && cmd < CMD_MAIN5_1 ) // interior subsection
			{
				changeGroup( parts4Group );

				if( cmd == CMD_MAIN4_1 )
				{
					pageNumberPrefix="I-I/";
					collectObjects( new GameRef(parts:0xF243r) );	//steerwheels
					filter = NO_FILTER;
				}
				else
				if( cmd == CMD_MAIN4_2 )
				{
					pageNumberPrefix="I-II/";
					collectObjects( new GameRef(parts:0xF245r) );	//dashes
					filter = NO_FILTER;
				}
				else
				if( cmd == CMD_MAIN4_3 )
				{
					pageNumberPrefix="I-III/";
					collectObjects( new GameRef(parts:0xF23fr) );	//gearknobs
					filter = NO_FILTER;
				}
				else
				if( cmd == CMD_MAIN4_4 )
				{
					pageNumberPrefix="I-IV/";
					collectObjects( new GameRef(parts:0xF241r) );	//pedals
					filter = NO_FILTER;
				}
				else
				if( cmd == CMD_MAIN4_5 )
				{
					pageNumberPrefix="I-V/";
					collectObjects( new GameRef(parts:0xF244r) );	//gauges
					filter = NO_FILTER;
				}
				else
				if( cmd == CMD_MAIN4_6 )
				{
					pageNumberPrefix="I-VI/";
					collectObjects( new GameRef(parts:0xF246r) );	//seats
					filter = NO_FILTER;
				}
				else
				if( cmd == CMD_MAIN4_7 )
				{
					pageNumberPrefix="I-VII/";
					collectObjects( new GameRef(parts:0xF247r) );	//rollbars
					filter = NO_FILTER;
				}
				else
				if( cmd == CMD_MAIN4_8 )
				{
					pageNumberPrefix="I-VIII/";
					collectObjects( new GameRef(parts:0xF248r) );	//decoration
					filter = NO_FILTER;
				}
			}
			else
			if( cmd >= CMD_MAIN5_1 && cmd < CMD_MAIN6_1 ) // audio subsection
			{
				changeGroup( parts5Group );
				if( cmd == CMD_MAIN5_1 )				
				{
					pageNumberPrefix="A-I/";
					collectObjects( new GameRef(parts:0xF240r) );	//head units
					filter = NO_FILTER;
				}
				else
				if( cmd == CMD_MAIN5_2 )
				{
					pageNumberPrefix="A-II/";
					collectObjects( new GameRef(parts:0x0246r) );	// Amplifiers
					filter = NO_FILTER;
				}
				else
				if( cmd == CMD_MAIN5_3 )
				{
					pageNumberPrefix="A-III/";
					collectObjects( new GameRef(parts:0x0247r) );	// Boxes
					filter = NO_FILTER;
				}
				else
				if( cmd == CMD_MAIN5_4 )
				{
					pageNumberPrefix="A-IV/";
					collectObjects( new GameRef(parts:0x0248r) );	// Subwoofers
					filter = NO_FILTER;
				}
				else
				if( cmd == CMD_MAIN5_5 )
				{
					pageNumberPrefix="A-V/";
					collectObjects( new GameRef(parts:0x024Br) );	// Accesories
					filter = NO_FILTER;
				}
				else
				if( cmd == CMD_MAIN5_6 )
				{
					pageNumberPrefix="A-VI/";
					collectObjects( new GameRef(parts:0x025Br) );	// Audio Kits
					filter = NO_FILTER;
				}
			}

			collectObjectsEnd();
			refreshPage();
		}
	}
}

//----------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------

public class CatalogInventory extends VisualInventory
{
	Osd			osd;	//for da namez
	TextBox[]	names;

	Catalog	catalog;

	public CatalogInventory( Catalog cat, Player player, float left, float top, float width, float height )
	{
		super(player, left, top, width, height );
		catalog=cat;
	}
		
	public void initVisuals( float left, float top, float width, float height  )
	{
		linesPerPage=2;
		partsPerLine=4;

		//mely itemek lehetnek lathatoak kezdetben?
		cline=0;
		start = cline * partsPerLine;
		stop = start + linesPerPage * partsPerLine;

		//0..1 viewport coordinatarendszerben!
		float	itemWidth=0.20, itemHeight=0.15;
		float	hSpacing = (width-itemWidth*partsPerLine)/partsPerLine;
		float	vSpacing = (height-itemHeight*linesPerPage)/(linesPerPage-1);
		
		//backObject = new RenderRef( misc.catalog:0x00000020r );
		panels=new InventoryPanel[partsPerLine*linesPerPage];
		names=new TextBox[panels.length];

		//eggyel magasabb pri vp kell, mint maga a katalogus, kulonben eltunnek a szovegek!
		osd = new Osd( 1.0, 0.0, 11 );
		osd.iLevel = Osd.IL_NONE;

		int	index;
		float cheight=top;
		for( int i=0; i<linesPerPage; i++ )
		{
			float cwidth=left;
			for( int j=0; j<partsPerLine; j++ )
			{
				if( j == partsPerLine/2 )
					cwidth+=hSpacing;

				index = i*partsPerLine+j; 
				panels[index]=new CatalogInventoryPanel( this, index, cwidth, cheight, itemWidth, itemHeight, player );
				names[index]=osd.createTextBox( null, Frontend.smallFont, Text.ALIGN_CENTER, (cwidth)*2-1, ((cheight+itemHeight)*2)-1, itemWidth*2 );
				//kicsit patch, sajnos a fontnak nics olyan propertyje, hogy multicolor-e!
				if( Frontend.smallFont.id() == Text.RID_CONSOLE10 || Frontend.smallFont.id() == Text.RID_CONSOLE5 )
					names[index].changeColor( 0xFF000000 );

				cwidth+=itemWidth+hSpacing;
			}
			cheight+=itemHeight+vSpacing;
		}
	}

	public int upScroll()
	{
		if( cline )
		{
			cline-=linesPerPage;
			update();
			return 1;
		}
		return 0;
	}

	public int downScroll()
	{
		if( cline+linesPerPage < pages()*linesPerPage )
		{
			cline+=linesPerPage;
			update();
			return 1;
		}
		return 0;
	}

	//number of twin pages in a catalog section
	public int	pages()
	{
		if( items.size() > 1)
			return (items.size()-1)/(partsPerLine*linesPerPage)+1;
			
		return 1;
	}

	public void panelLeftClick( int index )
	{
		index += currentLine()*partsPerLine;

		if( index<items.size() )
		{
			InventoryItem item = items.elementAt( index );

			int price = item.getPrice() * Catalog.PRICERATIO;
			if( price <= player.money )
			{
				Dialog d = new BuyCatalogItemDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG|Dialog.DF_WIDE, item, price );

				if( d.display() == 0 )
				{
					player.money-= price;
					item.copyToInventory( player.parts );
					catalog.refreshMoneyString();
					//kap egy bonus matricat is, ha spec alkatresz:
					int decalID = item.getLogo();
					if( decalID )
					{
						player.decals.addElement( new Decal( decalID ) );
					}
				}
			}
			else
			{
				new WarningDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "NOT ENOUGHT MONEY", "You don't have enought money to buy this part!" ).display();
			}
		}
	}

	public void update()
	{
		//hol kapcsolodnak ki a buttonok?
		int begin = start;
		int end = stop;

		//mibol lesznek buttonok?
		start = cline * partsPerLine;
		stop = start + linesPerPage * partsPerLine;

		int i, vis;

		//clear changed ones
		vis=0;
		for( i=begin; i<end; i++ )
		{
			names[vis++].changeText( null );
		}

		//add new ones
		vis=0;
		for( i=start; i<stop; i++ )
		{
			if( i<items.size() )
			{
				InventoryItem item = items.elementAt(i);
				names[vis++].changeText( item.getName() + " $"+ (int)(item.getPrice() * Catalog.PRICERATIO) );
			}
		}

		super.update();
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

//----------------------------------------------------------------------------------------------

public class CatalogInventoryPanel extends InventoryPanel
{
	Player	player;

	ResourceRef	infoTex0, infoTex1;
	Rectangle infoRect0, infoRect1;

	public CatalogInventoryPanel( CatalogInventory inventory, int index, float left, float top, float width, float height, Player p )
	{
		super( inventory, index, left, top, width, height );

		infoRect0 = inventory.osd.createRectangle( (left+width/2)*2-1, ((top-0.04)*2)-1, 0.1, 0.1, 1.0, -0.5, 0.0, 0, null );
		infoRect1 = inventory.osd.createRectangle( (left+width/2)*2-1, ((top-0.04)*2)-1, 0.1, 0.1, 1.0,  0.5, 0.0, 0, null );
		player = p;
	}

	public void swap( int index_a, int index_b )
	{
		//nincs swap!!
	}

	public void attachItem( InventoryItem invitem )
	{
		ypr = new Ypr( -1.4, -0.7, 0.0 );

		super.attachItem( invitem );

		infoTex0 = infoTex1 = null;

		if( invitem && invitem instanceof InventoryItem_Part)
		{
			((InventoryItem_Part)invitem).compatibility = 0;

			Part p=invitem.getPart();
			if( player.car )
				if( p.getInfo( p.GII_COMPATIBLE, player.car.id() + "" ) )
				{
					if( p.getInfo( p.GII_INSTALL_OK, player.car.id() + "" ) )
					{
						infoTex0 = Catalog.RR_ICON_CAR_1STEP;
						((InventoryItem_Part)invitem).compatibility |= 1;
					}
					else
					{
						infoTex0 = Catalog.RR_ICON_CAR_COMP;
						((InventoryItem_Part)invitem).compatibility |= 2;
					}
				}


			int compatibleParts;
			for( int i=player.parts.size()-1; i>=0; i-- )
			{
				if( player.parts.items.elementAt(i) instanceof InventoryItem_Part )
					if( p.getInfo( p.GII_INSTALL_OK, player.parts.items.elementAt(i).getPart().id() + "" ) )
					{
						compatibleParts++;
						((InventoryItem_Part)invitem).compatibility |= 4;
						break;	//inkabb ne nezzuk tovabb, lassit
					}
			}

			if( compatibleParts )
				infoTex1 = Catalog.RR_ICON_INV_COMP;
			
		}

		infoRect0.changeTexture( infoTex0 );
		infoRect1.changeTexture( infoTex1 );
	}

}

public class BuyCatalogItemDialog extends YesNoDialog
{
	public BuyCatalogItemDialog( Controller ctrl, int myflags, InventoryItem item, int price )
	{ 
		super( ctrl, myflags, "BUY PART", genBody( item, price) ); 
	}

	public String genBody( InventoryItem item, int price )
	{
		String body = "Do you want to buy this " + item.getName()  + " for $" + price + " ? \n \n \n" + item.getDescription() + " \n \n Note: ";
//		String body = "Do you want to buy this " + item.getName()  + " for $" + price + " ? \n \n Note: ";		

		if( item instanceof InventoryItem_Part )
		{
			if( !((InventoryItem_Part)item).compatibility )
				body = body + "NOT compatible with you current car / parts bin!";
			else
			{
				if( ((InventoryItem_Part)item).compatibility & 1 )
					body = body + "installable right away to your car";
				if( ((InventoryItem_Part)item).compatibility & 2 )
					body = body + "interchangeable with your cars parts";
				if( ((InventoryItem_Part)item).compatibility & 4 )
				{
					if( ((InventoryItem_Part)item).compatibility & 3 )
						body = body + " and ";
					body = body + "parts bin compatible";
				}

			}
		}

		return body;
	}
}
