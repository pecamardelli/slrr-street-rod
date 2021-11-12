package java.game;

import java.io.*;
import java.util.*;
import java.util.resource.*;
import java.render.*;	//Text
import java.render.osd.*;	//Text
import java.render.osd.dialog.*;	//Text
import java.sound.*;

public class CarMarket extends Scene implements GameState
{
	// resource ID constants
	final static int  RID_MAP_DEALER = misc.dealer:0x0001r;
	final static int  RID_MAP_DEALER2 = misc.dealer2:0x0001r;

	final static int  RID_STUFF_DEALER = misc.dealer:0x000Fr;
	final static int  RID_STUFF_DEALER2 = misc.dealer2:0x000Dr;

	final static float	FLOOR_HEIGHT =3.3;

	final static float PRICERATIO_NEW = 1.3;	//dealer ar-szorzo
	final static float PRICERATIO_USED = 0.90;	//dealer ar-szorzo
	final static float PRICERATIO_BUY = 0.98;	//dealer ar-szorzo
	final static float PRESTIGE_RATIO_BUY = 0.15;	//dealer prestige-szorzo
	final static float PRESTIGE_RATIO_SELL = 40.00;	//dealer prestige-szorzo

	final static int	CMD_PREVCAR = 0;
	final static int	CMD_NEXTCAR = 1;

	Player			player;
	GameState		parentState;

	GameRef			cam;
	int				move;

	//display
	Osd				osd;
	Text			moneytxt;
	Text			carName;
	Gadget			buyButton;

	int				used;
	DealerData		positions;
	int				numpos;
	int				welcomeTextureId, sellTextureId;
	float			priceRatio;

	RenderRef		stuff1;

	VehicleDescriptor[] carDescriptors;
	Vehicle[]		cars;
	int				curcar;

	public static VehicleDescriptor[] getInitialCars( int used )
	{
		VehicleDescriptor[] result = new VehicleDescriptor[20];

		int	i;
		int	vt;

		if( used )//fix kezdeti szett a hasznalt dealernel!
		{
			System.rpkScan( "cars\\racers\\" );
			vt = VehicleType.VS_USED;
		}
		else
		{
			System.rpkScan( "cars\\racers\\" );
			vt = VehicleType.VS_STOCK;
		}

		for( ; i<result.length; i++ )	
			result[i] = GameLogic.getVehicleDescriptor( vt );

		return result;
	}

	public static void alterCars( int used, VehicleDescriptor[] cars, float hoursPassed )
	{
		int	vt;
		if( used )
			vt = VehicleType.VS_USED;
		else
			vt = VehicleType.VS_STOCK;

		for( int i = 0; i<cars.length; i++ )
		{
			
			if( !cars[i] || Math.random() < 0.30*hoursPassed )
			{//ures volt: feltoltjuk, vagy orankent 2% esellyel csereljuk
				cars[i] = GameLogic.getVehicleDescriptor( vt );
			}
			else
			{//ha nem valtozott, 2% hogy megvette valaki
				if( Math.random() < 0.30*hoursPassed )
					cars[i] = null;
			}
		}
	}
	

	public CarMarket( int used, VehicleDescriptor[] carDescriptors )
	{
		createNativeInstance();

		this.used = used;
		this.carDescriptors = carDescriptors;
		this.player = GameLogic.player;
	}
	
	public Vector3 getCarPos( int n )
	{
		return new Vector3( positions.carPos[n] );
	}

	public Ypr getCarOri( int n )
	{
		Ypr ypr = new Ypr( positions.carOri[n] );
		ypr.y += 0.2-Math.random()*0.4;
		return ypr;
	}

	public void moveCamera()
	{
		if( cars[curcar] )
		{
			int price = cars[curcar].getTotalPrice();

			if( used && curcar == 0 )
			{
				price *= 1.0+((cars[curcar].getPrestigeMultiplier()-1.0)*PRESTIGE_RATIO_BUY);
				price *= PRICERATIO_BUY;
				carName.changeText( "YOUR CAR  $" + price );
			}
			else
			{
				price *= 1.0+((cars[curcar].getPrestigeMultiplier()-1.0)*PRESTIGE_RATIO_SELL);
				price *= priceRatio;
				carName.changeText( cars[curcar].toString() + " $" + price );
			}

			cam.command( "move " + cars[curcar].id() + " 0,0,0 4.5" );
			cam.command( "look " + cars[curcar].id() + " 0,0,0 0,0,0" );
			cam.command( "height 1.4");

			if( used && curcar == 0 )
				buyButton.changeTexture( new ResourceRef( frontend:0x012Fr ) ); //sel our car
			else
				buyButton.changeTexture( new ResourceRef( frontend:0x0125r ) ); //buy a car

		}
	}


	public void enter( GameState prevState )
	{
		if( prevState instanceof CarInfo )
		{
			osd.show();
		}
		else
		{
			parentState=prevState;

			if( used )
			{
				map = new GroundRef( RID_MAP_DEALER2 );
				positions = new DealerSHData();
				stuff1 = new RenderRef( map, RID_STUFF_DEALER2, null );
				welcomeTextureId = frontend:0x00A4r;
				sellTextureId = frontend:0x00CEr;
				priceRatio = PRICERATIO_USED;
			}
			else
			{
				map = new GroundRef( RID_MAP_DEALER );
				positions = new DealerNewData();
				stuff1 = new RenderRef( map, RID_STUFF_DEALER, null );
				welcomeTextureId = frontend:0x00CAr;
				sellTextureId = frontend:0x00CDr;
				priceRatio = PRICERATIO_NEW;
			}

			Frontend.loadingScreen.show(new ResourceRef(welcomeTextureId));


			numpos = positions.carPos.length;
			cars = new Vehicle[numpos];


			osd = new Osd();
			osd.globalHandler = this;

			carName=osd.createText( null,	Frontend.mediumFont, Text.ALIGN_CENTER, 0.0, -0.98 );
			moneytxt=osd.createText( null, Frontend.mediumFont, Text.ALIGN_RIGHT,	0.95, -0.98);

			osd.createHeader( "Car Dealer" );

			osd.createRectangle( 1.01, -0.82, 1.2, 0.22, -1, new ResourceRef(frontend:0x0024r) );

			Style buttonStyle = new Style( 0.12, 0.12, Frontend.mediumFont, Text.ALIGN_LEFT, null );
			Menu m = osd.createMenu( buttonStyle, 0.45, -0.82, 0, Osd.MD_HORIZONTAL );

			m.addItem( new ResourceRef( Osd.RID_ARROWLF ), Input.AXIS_MENU_LEFT, null );
			m.addItem( new ResourceRef( Osd.RID_ARROWRG ), Input.AXIS_MENU_RIGHT, null );
			m.addItem( new ResourceRef( frontend:0x0124r ), Input.AXIS_HELP, null );
			buyButton = m.addItem( new ResourceRef( frontend:0x0125r ), Input.AXIS_SELECT, null );
			m.addSeparator();
			m.addSeparator();
			m.addItem( new ResourceRef( Osd.RID_BACK ), Input.AXIS_CANCEL, null );

			lockPlayerCar();

			//---------------------------------time of day dependent stuff:
			addSceneElements( GameLogic.getTime() );

			if( !used )
				//habar ez nem internal scene, de gyorsan ujra-at-allitjuk az envmapot!
				GfxEngine.setGlobalEnvmap( new ResourceRef(maps.skydome:0x003Ar) );
			//-----------------------------------------------------------------------

			int emptySpaces = cars.length-carDescriptors.length-used;

			//hasznaltnal a 0-n a player parkol
			int	offsetVd;
			for( int i=used; i<cars.length; i++ )	
			{
				if( ( emptySpaces && Math.random() < 0.4 ) || cars.length-emptySpaces<=i)
				{
					--emptySpaces;
				}
				else
				{
					VehicleDescriptor vd = carDescriptors[offsetVd++];

					if( vd )
					{
						Vehicle	car = new Vehicle( map, vd.id, vd.colorIndex, vd.optical, vd.power, vd.wear, vd.tear );
						//car.chassis.setMileage( (1-vd.wear)*10000000f );
						addCar( car, i );
					}
				}
			}

			//hogy mozoghasson es renderelhessen a kamera!
			System.timeWarp(1.0);
			osd.getViewport().activate( Viewport.RENDERFLAG_CLEARDEPTH | Viewport.RENDERFLAG_CLEARTARGET );


			if( used )
				cam = new GameRef( map, GameRef.RID_CAMERA, "-3,2,0, 0,0,0, 0x13, 1.8,0.0, 0.05", "Car Dealer camera" );
			else
				cam = new GameRef( map, GameRef.RID_CAMERA, "10,2,-3, 0,0,0, 0x13, 1.8,0.0, 0.05", "Car Dealer camera" );

			cam.command( "render " + osd.getViewport().id() + " 0 0 1 " + (Viewport.RENDERFLAG_CLEARDEPTH | Viewport.RENDERFLAG_CLEARTARGET) );
			cam.command( "dist 2.5 4.6");
			cam.command( "smooth 0.05 0.5");
			cam.command( "force 0.3 0.5 -0.7" );
			cam.command( "torque 0.06" );
			cam.command( "zoom 60 5");

			goRight();
			goLeft();

			refreshMoneyString();

			
			//megvarjuk mig befejezi.. osd keyek nem elnek csak utana!
			Frontend.loadingScreen.userWait( 5.0 );


			osd.createHotkey( Input.AXIS_MENU_LEFT, Input.VIRTUAL|Osd.HK_STATIC, Input.AXIS_MENU_LEFT, this );
			osd.createHotkey( Input.AXIS_MENU_RIGHT, Input.VIRTUAL|Osd.HK_STATIC, Input.AXIS_MENU_RIGHT, this );
			osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL|Osd.HK_STATIC, Input.AXIS_CANCEL, this );

			osd.show();

			setEventMask( EVENT_CURSOR );
		}

		// special request: reset mouse and set sensitivity to 0
		Input.getAxis (1, -1);
		Input.cursor.enable(1);
		Input.cursor.addHandler(this);	//kivancsiak vagyunk ra, mit csinal az eger
		Input.cursor.enableCameraControl( cam );
	}

	public void exit( GameState nextState )
	{
		Input.cursor.enable(0);
		Input.cursor.remHandler(this);
		Input.cursor.disableCameraControl();

		if( nextState instanceof CarInfo )
		{
 			osd.hide();
		}
		else
		{
			clearEventMask( EVENT_ANY );

			cam.destroy();

			releasePlayerCar();

			for( int i=0; i<cars.length; i++ )
				if( cars[i] )
				{
					cars[i].destroy();	//
					cars[i]=null;		//eleg lenne..
				}

			remSceneElements();

			map.unload();

			osd.hide();
			osd=null;

			stuff1.destroy();

			parentState=null;
		}
	}


	public void lockPlayerCar()
	{
		if( used && GameLogic.player.car )
		{
			addCar( GameLogic.player.car, 0 );
			GameLogic.player.car=null;
		}
	}

	public void releasePlayerCar()
	{
		if( used && cars[0] )
		{
			cars[0].command( "start" );	//release
			GameLogic.player.car = cars[0];
			GameLogic.player.car.setParent( GameLogic.player );

			cars[0] = null;
		}
	}

	public int addCar( Vehicle car, int slot )
	{
		if( car )
		{
			if( !cars[slot] )
			{
				cars[slot] = car;

				car.setParent( map );
				Vector3 pos = getCarPos(slot);
				// pos.z += Math.random()*0.1;
				pos.x += Math.random()*0.1;
				car.setMatrix( pos, getCarOri(slot) );
				car.command( "reset" );
				car.command( "setsteer "+ (-0.7+(Math.random()*1.4)) );
				car.command( "stop" );	//grab

				return 1;
			}
		}

		return 0;
	}

	public GameRef createCar( GameRef carType )
	{
		Vehicle car;

		float opti, engi, wear, tear;

		if( used )
		{
			opti = 0.3 + Math.random()*1.5;	//0.3-1.8
			engi = 0.5 + Math.random()*1.0;	//0.5-1.5
			wear = 0.4 + Math.random()*0.6;
			tear = 0.7 + Math.random()*0.3;
		}
		else
		{
			opti = 1.0;
			engi = 1.0;
			wear = 1.0;
			tear = 1.0;
		}

		car = new Vehicle( map, carType.id(), Math.random(), opti, engi, wear, tear );
		car.chassis.setMileage( (1-wear)*10000000f );

		return car;
	}

	public void refreshMoneyString()
	{
		new SfxRef( Frontend.SFX_MONEY ).play(); 
		moneytxt.changeText( "$" + Integer.toString( player.money ) );
	}

//----------------------------------------------------------------------
	public void osdCommand( int cmd )
	{
		if( cmd == Input.AXIS_MENU_LEFT )
		{
			goLeft();
		}
		else
		if( cmd == Input.AXIS_MENU_RIGHT )
		{
			goRight();
		}
		else
		if( cmd == Input.AXIS_CANCEL )
		{
			GameLogic.changeActiveSection( parentState );
		}
		else
		if( cmd == Input.AXIS_HELP )
		{
			if( cars[curcar] )
			{
				GameLogic.changeActiveSection( new CarInfo( cars[curcar] ) );
			}
		}
		else
		if( cmd == Input.AXIS_SELECT )
		{
			buyCar();
		}
	}

	public void goLeft()
	{
		while(1)
		{
			if( --curcar < 0 )
				curcar=numpos-1;

			if( cars[curcar] )
				break;
		}

		moveCamera();
	}

	public void goRight()
	{
		while(1)
		{
			if( ++curcar >= numpos )
				curcar=0;

			if( cars[curcar] )
				break;
		}

		moveCamera();
	}

	public void changePointer()
	{
		if( move )
			Input.cursor.setPointer( Frontend.pointers, "M");
		else
			Input.cursor.setPointer( Frontend.pointers, "J");
	}

	public void handleEvent( GameRef obj_ref, int event, String param )
	{
		int	tok = -1;

		if( event == EVENT_CURSOR )
		{
			int	ec = param.token( ++tok ).intValue();

			int	cursor_id = param.token( ++tok ).intValue();

//left button handling: car selection
			if (ec == GameType.EC_LCLICK)
			{
				GameRef dest = new GameRef(param.token( ++tok ).intValue());
				int cat = dest.getInfo(GameType.GII_CATEGORY);
				if( cat == GIR_CAT_PART || cat == GIR_CAT_VEHICLE )
				{
					int carID = dest.getScriptInstance().getCar();
					for( int i=0; i<cars.length; i++ )
					{
						if (cars[i])
						if (cars[i].chassis)
						if (cars[i].chassis.id() == carID)
						{
							curcar = i;
							moveCamera();
							break;
						}
					}
				}
			} else

//right button handling: camera control
			if (ec == GameType.EC_RCLICK)
			{
				GameRef dest = new GameRef(param.token( ++tok ).intValue());
				int cat = dest.getInfo(GameType.GII_CATEGORY);
				if( cat == GIR_CAT_PART || cat == GIR_CAT_VEHICLE )
				{
					int carID = dest.getScriptInstance().getCar();
					if (cars[curcar])
					if (cars[curcar].chassis)
					if (cars[curcar].chassis.id() == carID)
					{
						cam.command( "look " + dest.id() + " " + param.token( ++tok ) + "," + param.token( ++tok ) + "," + param.token( ++tok ) );
					}
				}
			} else
			if (ec == GameType.EC_RDRAGBEGIN)
			{
				move=1;
				changePointer();
				//enable camera control with mouse
				player.controller.user_Add( Input.AXIS_LOOK_UPDOWN,	ControlSet.MOUSE, 1,	-1.0f, 1.0f, -1.0f, 1.0f);
				player.controller.user_Add( Input.AXIS_LOOK_LEFTRIGHT,	ControlSet.MOUSE, 0,	-1.0f, 1.0f, -1.0f, 1.0f);
				//disable cursor movement
				player.controller.user_Del( Input.AXIS_CURSOR_X,	ControlSet.MOUSE, 0 );
				player.controller.user_Del( Input.AXIS_CURSOR_Y,	ControlSet.MOUSE, 1 );
				Input.cursor.cursor.command( "lock" );
			}  else
			if (ec == GameType.EC_RDRAGEND)
			{
				move=0;
				changePointer();
				//disable camera control with mouse
				player.controller.user_Del( Input.AXIS_LOOK_UPDOWN,	ControlSet.MOUSE, 1 );
				player.controller.user_Del( Input.AXIS_LOOK_LEFTRIGHT,	ControlSet.MOUSE, 0 );
				//enable cursor movement
				player.controller.user_Add( Input.AXIS_CURSOR_X,	ControlSet.MOUSE, 0,	-1.0f, 1.0f, -1.0f, 1.0f);
				player.controller.user_Add( Input.AXIS_CURSOR_Y,	ControlSet.MOUSE, 1,	-1.0f, 1.0f, -1.0f, 1.0f);
				Input.cursor.cursor.command( "unlock" );
			} else
				;

		}
	}

//----------------------------------------------------------------------

	public void buyCar()
	{
		if( cars[curcar] )
		{
			int	price = cars[curcar].getTotalPrice();

			if( used && curcar == 0)		//eladjuk a kocsinkat!
			{
				price *= 1.0+((cars[curcar].getPrestigeMultiplier()-1.0)*PRESTIGE_RATIO_BUY);
				price *= PRICERATIO_BUY;
				Dialog d = new NoYesDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "SELL CAR", "Do you want to sell your car for $" + price +" ?" ); 
				if( d.display() == 0 )
				{
					player.money+=price;
					refreshMoneyString();

 					//remove car;
					cars[curcar].command( "reset" );
					cars[curcar].command( "start" );	//stoppolva volt!

					//find a new spot for it:
					for( int i=numpos-1; i; i-- )
					{
						if( !cars[i] )
						{
							addCar( cars[curcar], i );
							cars[curcar]=null;
							goRight();
						}
					}

					//kereskedo vesi a kocsinkat:
					Frontend.loadingScreen.display( new SimpleLoadingDialog( Dialog.DF_FULLSCREEN|Dialog.DF_MODAL, new ResourceRef(frontend:0x00A3r) ), 5.0 ); 
				}
			}
			else		//kocsit veszunk!
			{
				price *= 1.0+((cars[curcar].getPrestigeMultiplier()-1.0)*PRESTIGE_RATIO_SELL);
				price*=priceRatio;

				if( price <= player.money )
				{
					//lesz hely az uj jovevenynek?
					releasePlayerCar();
					player.carlot.lockPlayerCar();
					int	freeSlot=player.carlot.getFreeSlot();
					player.carlot.releasePlayerCar();
					lockPlayerCar();

					if( freeSlot >= 0 )
					{
						Dialog dialog = new NoYesDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG|Dialog.DF_WIDE, "BUY CAR", "Do you want to buy this " + cars[curcar].toString()  + " for $" + price + " ? \n \n About the " +cars[curcar].toString()+ ": " + cars[curcar].chassis.description );
						if( dialog.display() == 0 )
						{
							player.money-=price;
							refreshMoneyString();

							//ha kocsival jottunk, visszarakjuk a garazsba
							releasePlayerCar();

							//ha all kocsi a garazsban, bevagjuk a carlotba
							player.carlot.lockPlayerCar();
							player.carlot.saveCar( player.carlot.curcar );
							player.carlot.flushCars();

							//az uj kerul a garazsba
							player.car=cars[curcar];
							GameLogic.garage.releaseCar(); //pont ez kell nekunk!

							cars[curcar] = null;

							//kiutjuk a memory listabol is
							for( int i=0; i<carDescriptors.length; i++ )
								if( carDescriptors[i] && player.car.getInfo( GII_TYPE ) == carDescriptors[i].id )
									carDescriptors[i] = null;

							//kereskedo atad kocsikulcs:
							Frontend.loadingScreen.display( new SimpleLoadingDialog( Dialog.DF_FULLSCREEN|Dialog.DF_MODAL, new ResourceRef(sellTextureId) ), 5.0 );

							osdCommand( Input.AXIS_CANCEL );
						}
					}
					else
					{
						new WarningDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "CAR LOT FULL", "There is no more free space in your car lot.\nSell some cars to free up parking space!" ).display();
					}
				}
				else
				{
					new WarningDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "NOT ENOUGHT MONEY", "You don't have $" + price + " to buy this car!" ).display();
				}
			}
		}
	}
}

public class DealerData
{
	Vector3[]	carPos;
	Ypr[]		carOri;
}

public class DealerNewData extends DealerData
{
	public DealerNewData()
	{
		carPos = new Vector3[7];
		carOri = new Ypr[7];

		carPos[0] = new Vector3( 3.901, 0.000, -3.499 );
		carOri[0] = new Ypr( -1.963, 0.000, 0.000 );
		carPos[1] = new Vector3( 3.901, 0.000, -7.603 );
		carOri[1] = new Ypr( -1.963, 0.000, 0.000 );
		carPos[2] = new Vector3( 5.099, 0.000, -12.927 );
		carOri[2] = new Ypr( -1.876, 0.000, 0.000 );
		carPos[3] = new Vector3( 10.922, 0.000, -11.930 );
		carOri[3] = new Ypr( -2.923, 0.000, 0.000 );
		carPos[4] = new Vector3( 17.295, 0.000, -13.173 );
		carOri[4] = new Ypr( 1.981, 0.000, 0.000 );
		carPos[5] = new Vector3( 17.226, 0.000, -7.603 );
		carOri[5] = new Ypr( 1.981, 0.000, 0.000 );
		carPos[6] = new Vector3( 17.226, 0.000, -3.267 );
		carOri[6] = new Ypr( 1.981, 0.000, 0.000 );
	}
}

public class DealerSHData extends DealerData
{
	public DealerSHData()
	{
		int carNumber = 20;
		int carDistance = 3.2;

		carPos = new Vector3[carNumber + 1];
		carOri = new Ypr[carNumber + 1];

		carPos[0] = new Vector3( 0.380, 0.000, 3.916 );		//itt all a player kocsija, ha azzal jon
		carOri[0] = new Ypr( 2.618, 0.000, 0.000 );
		//carPos[0] = new Vector3( 4.644, 0.000, 3.916 );	//nem egy csomoban vannak, epuletbe belemegy a kamera miattuk
		//carOri[0] = new Ypr( 2.618, 0.000, 0.000 );
		//carPos[0] = new Vector3( 9.140, 0.000, 3.916 );
		//carOri[0] = new Ypr( 2.618, 0.000, 0.000 );

		// carPos[1] = new Vector3( -11.733, 0.000, 5.666 );
		// carOri[1] = new Ypr( -1.552, 0.000, 0.000 );
		// carPos[2] = new Vector3( -11.733, 0.000, 3.452 );
		// carOri[2] = new Ypr( -1.552, 0.000, 0.000 );
		// carPos[3] = new Vector3( -11.733, 0.000, 1.563 );
		// carOri[3] = new Ypr( -1.552, 0.000, 0.000 );
		// carPos[4] = new Vector3( -11.733, 0.000, -20.468 );
		// carOri[4] = new Ypr( -1.552, 0.000, 0.000 );

		// carPos[5] = new Vector3( -4.475, 0.000, -20.492 );
		// carOri[5] = new Ypr( 1.592, 0.000, 0.000 );
		// carPos[6] = new Vector3( -4.475, 0.000, -14.101 );
		// carOri[6] = new Ypr( 1.592, 0.000, 0.000 );
		// carPos[7] = new Vector3( -4.475, 0.000, -8.507 );
		// carOri[7] = new Ypr( 1.592, 0.000, 0.000 );
		// carPos[8] = new Vector3( -4.475, 0.000, -2.775 );
		// carOri[8] = new Ypr( 1.592, 0.000, 0.000 );

		for(int i=1;i<=carNumber;i++){
			if (i <= carNumber/2) {
				carPos[i] = new Vector3( -11.733, 0.000, 8.666 - carDistance*i );
				carOri[i] = new Ypr( -1.552, 0.000, 0.000 );
			}
			else {
				carPos[i] = new Vector3( -4.475, 0.000, -24.492 + carDistance*(i-carNumber/2) );
				carOri[i] = new Ypr( 1.592, 0.000, 0.000 );
			}
		}
	}
}
