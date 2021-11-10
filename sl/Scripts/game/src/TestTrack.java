package java.game;

import java.io.*;
import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.render.*;	//Text
import java.render.osd.*;	//Text
import java.sound.*;
import java.render.osd.dialog.*; //Dialog Window

public class TestTrack extends Track
{
	final static String MapName = "Test Track";
	final static String MapDescription = "\n It is default game's Test Track \n \n There You can test Your car acceleration, handling etc or simply: take a ride. \n \n \n \n Also you may save your own bots from 'Main Menu' -> 'Save car' \n \n Bot names: TT_1, TT_2, TT_3, TT_4, TT_5, TT_6, TT_7, TT_8,TT_9, TT_10, TT_11, \n \n		TT_12, TT_13, TT_14, TT_15, TT_16, TT_17, TT_18, TT_19, TT_20, TT_21, TT_22";
	final static String MapAuthor = "Authors: Invictus & Miran";
	final static ResourceRef MapImage = new ResourceRef(MW_Mod:0x0032r);
	final static float	TS_Version = 1.0;
	final static int RivalOption = 0;
	final static int PoliceOption = 0;

	final static int MPH_60 = 771.604938271604938271604938271605;
	final static int MPH_124 = 3086.41975308641975308641975308642;

	Vector3 posExit = new Vector3( 189.2, -3.8, -1417.0 );
	Ypr		oriExit = new Ypr( 2.88, 0.05, 0.0 );
	Vector3 PolicePos = new Vector3( 14, 0, -1128);

	Text	messageTextA;
	Text	messageTextB;
	Text	messageText0;
	Text	messageText1;
	Text	messageText2;

	// Bots
	Bot[]		parkingBot;
	Vector3[]	parkingBot_posStart;
	Ypr[]		parkingBot_oriStart;
	final static int parkingBot_count = 22;

	int		testStatus = 0;
	int		triggerIndex = 0;
	int		acceleration = 0;
	int		acceleration120 = 0;
	float	testStartTime = 0.0f;

	Marker	mPolice;

	Round	actRound = null;
	Round[]	round = new Round[2];
	int		rounds = 2;

	// Miran's:
	Text		TimeInfo, SpeedInfo, PosInfo, YprInfo;
	final static RenderRef	GMarker;
	Bot[]	raceBot = new Bot[2];

	public TestTrack()
	{
		map = new GroundRef( maps.test_track:0x00000001r );
		nav = new Navigator( -5.317-2.64, -15.996, 2.64, maps.test_track.smallmap:0x00000001r, maps.test_track.smallmap:0x00000002r, maps.test_track.smallmap:0x00000005r, 6, 8, 10 );	

		if( RivalOption == 1 )
		{
			parkingBot = new Bot[parkingBot_count];
			parkingBot_posStart = new Vector3[parkingBot_count];
			parkingBot_oriStart = new Ypr[parkingBot_count];

			// difference = 2.515

			parkingBot_posStart[0] = new Vector3( 56.335, 0.118, -1258.375 );
			parkingBot_oriStart[0] = new Ypr( -0.011, -0.007, 0.000 );

			parkingBot_posStart[1] = new Vector3( 53.820, 0.118, -1258.375 );
			parkingBot_oriStart[1] = new Ypr( -0.011, -0.007, 0.000 );

			parkingBot_posStart[2] = new Vector3( 51.305, 0.118, -1258.375 );
			parkingBot_oriStart[2] = new Ypr( -0.011, -0.007, 0.000 );

			parkingBot_posStart[3] = new Vector3( 48.790, 0.118, -1258.375 );
			parkingBot_oriStart[3] = new Ypr( -0.011, -0.007, 0.000 );

			parkingBot_posStart[4] = new Vector3( 46.275, 0.118, -1258.375 );
			parkingBot_oriStart[4] = new Ypr( -0.011, -0.007, 0.000 );

			parkingBot_posStart[5] = new Vector3( 43.760, 0.118, -1258.375 );
			parkingBot_oriStart[5] = new Ypr( -0.011, -0.007, 0.000 );

			parkingBot_posStart[6] = new Vector3( 41.245, 0.118, -1258.375 );
			parkingBot_oriStart[6] = new Ypr( -0.011, -0.007, 0.000 );

			parkingBot_posStart[7] = new Vector3( 38.730, 0.118, -1258.375 );
			parkingBot_oriStart[7] = new Ypr( -0.011, -0.007, 0.000 );

			parkingBot_posStart[8] = new Vector3( 36.215, 0.118, -1258.375 );
			parkingBot_oriStart[8] = new Ypr( -0.011, -0.007, 0.000 );

			parkingBot_posStart[9] = new Vector3( 33.700, 0.118, -1258.375 );
			parkingBot_oriStart[9] = new Ypr( -0.011, -0.007, 0.000 );

			parkingBot_posStart[10] = new Vector3( 31.185, 0.118, -1258.375 );
			parkingBot_oriStart[10] = new Ypr( -0.011, -0.007, 0.000 );

			parkingBot_posStart[11] = new Vector3( 56.335, 0.118, -1272.709 );
			parkingBot_oriStart[11] = new Ypr( -3.141, -0.000, 0.000 );

			parkingBot_posStart[12] = new Vector3( 53.820, 0.118, -1272.709 );
			parkingBot_oriStart[12] = new Ypr( -3.141, -0.000, 0.000 );

			parkingBot_posStart[13] = new Vector3( 51.305, 0.118, -1272.709 );
			parkingBot_oriStart[13] = new Ypr( -3.141, -0.000, 0.000 );

			parkingBot_posStart[14] = new Vector3( 48.790, 0.118, -1272.709 );
			parkingBot_oriStart[14] = new Ypr( -3.141, -0.000, 0.000 );

			parkingBot_posStart[15] = new Vector3( 46.275, 0.118, -1272.709 );
			parkingBot_oriStart[15] = new Ypr( -3.141, -0.000, 0.000 );

			parkingBot_posStart[16] = new Vector3( 43.760, 0.118, -1272.709 );
			parkingBot_oriStart[16] = new Ypr( -3.141, -0.000, 0.000 );

			parkingBot_posStart[17] = new Vector3( 41.245, 0.118, -1272.709 );
			parkingBot_oriStart[17] = new Ypr( -3.141, -0.000, 0.000 );

			parkingBot_posStart[18] = new Vector3( 38.730, 0.118, -1272.709 );
			parkingBot_oriStart[18] = new Ypr( -3.141, -0.000, 0.000 );

			parkingBot_posStart[19] = new Vector3( 36.215, 0.118, -1272.709 );
			parkingBot_oriStart[19] = new Ypr( -3.141, -0.000, 0.000 );

			parkingBot_posStart[20] = new Vector3( 33.700, 0.118, -1272.709 );
			parkingBot_oriStart[20] = new Ypr( -3.141, -0.000, 0.000 );

			parkingBot_posStart[21] = new Vector3( 31.185, 0.118, -1272.709 );
			parkingBot_oriStart[21] = new Ypr( -3.141, -0.000, 0.000 );
		}
	}

	public void StartMap()
	{
		// GameLogic.changeActiveSection( new TestTrack() );
		// Track selector run this void when you click "TAKE IT"
		RivalOption = 0;
		PoliceOption = 1;
		new TestTrack_Options().display();
	}

	public void enter( GameState prev_state )
	{
		Frontend.loadingScreen.show();
		GfxEngine.flush();

		posStart=posExit;
		oriStart=oriExit;

		// 1/4 miles
		round[0] = new Round( this, "Go straight ahead", "to time the accelearation of your car!" );
		round[0].startdir( 3.14 );
		round[0].point( 0.000, 0.000, -1461.785, 1, 10 );
		round[0].point( 0.000, 0.000, -1059.785, 1, 20 );	//quartermile
		round[0].point( 0.000, 0.000, 148.215, 1, 20 );		//mile

		round[1] = new Round( this, "Test lap time!", "GO!" );
		round[1].startdir( 3.14 );
		round[1].point( -450.598, 0.000, -524.816, 1 );
		round[1].point( -450.598, 0.000, -223.142, 1 );
		round[1].point( -444.736, 1.011, 72.270, 1 );
		round[1].point( -27.535, 1.425, 450.475, 1 );
		round[1].point( 444.689, 1.011, 72.560, 1 );
		round[1].point( 450.598, 0.000, -223.142, 1 );
		round[1].point( 450.598, 0.000, -544.816, 1 );
		round[1].point( 450.598, 0.000, -893.995, 1 );
		round[1].point( 446.293, 0.965, -1124.731, 1 );
		round[1].point( -40.000, 1.425, -1513.328, 1 );	
		round[1].point( -446.000, 1.425, -1124.000, 1 );
		round[1].point( -450.598, 0.000, -893.996, 1 );
		round[1].loop();

		actRound = null;

		super.enter( prev_state );

		messageTextA = osd.createText( "", Frontend.largeFont, Text.ALIGN_CENTER, 0.0, -0.8 );
		messageTextB = osd.createText( "", Frontend.largeFont, Text.ALIGN_CENTER, 0.0, -0.7 );
		messageText0 = osd.createText( "", Frontend.largeFont, Text.ALIGN_RIGHT, 0.0, -0.7 );
		messageText1 = osd.createText( "", Frontend.largeFont, Text.ALIGN_LEFT, 0.0, -0.7 );
		messageText2 = osd.createText( "", Frontend.largeFont, Text.ALIGN_CENTER, 0.0, -0.6 );

		PosInfo = osd.createText( "", Frontend.smallFont, Text.ALIGN_LEFT, -0.85, -0.9);	PosInfo.changeColor(0xFF82FF00);
		YprInfo = osd.createText( "", Frontend.smallFont, Text.ALIGN_RIGHT, 0.85, -0.9);	YprInfo.changeColor(0xFF82FF00);
		SpeedInfo = osd.createText( "", Frontend.smallFont, Text.ALIGN_LEFT, -0.85, -0.8);	SpeedInfo.changeColor(0xFF82FF00);
		TimeInfo = osd.createText( "", Frontend.smallFont, Text.ALIGN_RIGHT, 0.85, -0.8);	TimeInfo.changeColor(0xFF82FF00);

		if (player.club == 2)
		{
			GMarker	= new RenderRef( frontend:0x0073r );
		}
		else
		if (player.club == 1)
		{
			GMarker	= new RenderRef( frontend:0x005Fr );
		}
		else
		{
			GMarker	= new RenderRef( frontend:0x005Br );
		}

		addTrigger( new Vector3(193, -4.5, -1427), null, GMarker, "Exit_Trigger", 3.0, "trigger" );

		if( PoliceOption == 1 )
		{
			addTrigger( new Vector3(PolicePos), null, null, "Police_Trigger", 15.0, "trigger" );

			// Police car
			raceBot[0] = new Bot( Math.random()*59, 4, 1, 2.0, 2.0, 20.0);

			GameRef policeCar = new GameRef( map, cars.Misc.Police:0x0006r, "0,0,0"+","+"0,0,0," + 1, "Police Bot" );
			raceBot[0].createCar( map, new Vehicle(policeCar) );

			RenderRef policeman = new RenderRef( map, GameLogic.HUMAN_POLICEMAN, "driver" );
			raceBot[0].car.command( "corpse 0 " + policeman.id() );

			raceBot[0].brain.queueEvent( null, EVENT_COMMAND, "AI_params 50.0 50.35" ); // bardziej kozaczy :D

			raceBot[0].car.setMatrix(new Vector3(PolicePos), new Ypr( 1.5, 0, 0 ));
			raceBot[0].car.wakeUp();

			changeCamTarget2(raceBot[0].car);
			if(nav) mPolice = nav.addMarker( new RenderRef(MW_Mod:0x0101r), raceBot[0].car );
		}

		if ( RivalOption == 1 )
		{
			for(int i = 0; i < parkingBot_count; ++i)
			{
				if( File.exists( GameLogic.carSaveDir + "TT_" + (i+1) ) )
				{
					parkingBot[i] = new Bot( Math.random()*59, 3, 1, 2.0, 2.0, 20.0);

					parkingBot[i].createCar( map, GameLogic.carSaveDir + "TT_" + (i+1) );

					parkingBot[i].brain.queueEvent( null, EVENT_COMMAND, "AI_params 15.5 2.5" );
					parkingBot[i].car.queueEvent( null, EVENT_COMMAND, "reset" );
					parkingBot[i].car.queueEvent( null, EVENT_COMMAND, "reload" );
					parkingBot[i].car.setMatrix( parkingBot_posStart[i], parkingBot_oriStart[i] );
					parkingBot[i].car.setParent( map );
					parkingBot[i].car.wakeUp();
					parkingBot[i].car.queueEvent( null, EVENT_COMMAND, "brake" );
					parkingBot[i].car.queueEvent( null, EVENT_COMMAND, "set" );
				}
			}
		}
	}

	public void exit( GameState next_state )
	{
        if( !(next_state instanceof RaceSetup) )
			removeAllTimers();

		if( round[0] )
		{
			round[0].destroy();
			round[0] = null;
		}
		if( round[1] )
		{
			round[1].destroy();
			round[1] = null;
		}

		if( PoliceOption == 1 )
		{
			nav.remMarker( mPolice );
			mPolice = null;
		}

		if ( RivalOption == 1 )
		{
			for(int i = 0; i < parkingBot_count; ++i)
			{
				parkingBot[i] = null;
				parkingBot_posStart[i] = null;
				parkingBot_oriStart[i] = null;
			}
			parkingBot = null;
			parkingBot_posStart = null;
			parkingBot_oriStart = null;
		}

		super.exit( next_state );
	}

	public void Police_Trigger( GameRef obj_ref, int event, String param )
	{
		if( param.token(0).intValue() == player.car.id() )
		{
			raceBot[0].followCar( player.car, 0.001 );
			raceBot[0].pressHorn();
		}
	}

	public void Exit_Trigger( GameRef obj_ref, int event, String param )
	{
		if( event == EVENT_TRIGGER_ON )  // only when car go-in triger
		{
			player.car.command( "stop" );
			if( 0 == new YesNoDialog( player.controller, Dialog.DF_LOWPRI|Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "QUESTION", "Go back to the garage?" ).display() )
			{
				player.car.command( "start" );
				GameLogic.changeActiveSection( GameLogic.garage );
			}
			else
				player.car.command( "start" );
		}
	}

	public void event_handlerTrigger( GameRef obj_ref, int event, String param )
	{
		int	id = param.token(0).intValue();
		if (id == player.car.id())
		{
			if( event == EVENT_TRIGGER_ON )
			{
				if( !activeTrigger )
				{
					activeTrigger=obj_ref.id();
				}
			}
			else
			{
				activeTrigger=0;
			}
		}
	}

	public void handleEvent( GameRef obj_ref, int event, int param )
	{
		super.handleEvent( obj_ref, event, param );

		if( event == EVENT_TIME )
		{
			if( param == 2 )	//one sec tick
			{
				if( activeTrigger )
				{
					if( player.car.getSpeedSquare() < 0.25 )	//slow speed?
					{	
						for( int i = 0; i < rounds; i++ )
						{
							if( round[i] )
							{
								if( activeTrigger == round[i].trigger.elementAt(0).trigger.id() )
								{
									Ypr ypr = player.car.getOri();

									float diff = ypr.y-round[i].startOri.y;
									if( diff >= 3.14 )
										diff = 6.28 - diff;
									if( diff <= -3.14 )
										diff = -6.28 - diff;

									if( diff < 0.5f && diff > -0.5f)
									{
										actRound = round[i];
										testStatus = 0;
										triggerIndex = 1;
										if( actRound.type == 0 )
										{
											acceleration = 1;
											acceleration120 = 1;
										}
										else
										{
											acceleration = 0;
											acceleration120 = 0;
										}
									}
								}
							}
						}
					}
				}
			}
			else if( param == 6 )
			{
				messageText0.changeText( "" );
				messageText1.changeText( "" );
				messageText2.changeText( "" );
			}
		}
	}

	public void animate()
	{
		super.animate();

		// Default Tests section:
		if( actRound )
		{
			float speedSquare = player.car.getSpeedSquare();

			if( player.car.maxTestTrackSpeedSq < speedSquare )
				player.car.maxTestTrackSpeedSq = speedSquare;

			if( testStatus == 0 )
			{
				messageTextA.changeText( actRound.messageA );
				messageTextB.changeText( actRound.messageB );
				messageText0.changeText( "" );
				messageText1.changeText( "" );
				messageText2.changeText( "" );
				testStatus = 1;
			}
			if( testStatus == 1 )
			{
				if( speedSquare > 0.25 )
				{
					messageTextA.changeText( "" );
					messageTextB.changeText( "" );
					messageText0.changeText( "Time: " );
					testStartTime = System.simTime();
					testStatus = 2;
					Sound.changeMusicSet( Sound.MUSIC_SET_RACE );
				}
			}
			if( testStatus == 2 )
			{
				float	time = System.simTime() - testStartTime;
				messageText1.changeText( String.timeToString( time, String.TCF_NOHOURS ) + " s" );
				if( acceleration )
				{
					if( speedSquare >= MPH_60 )
					{
						messageText2.changeText( "Acceleration 0-100 KPH (0-62.1 MPH): " + String.timeToString( time, String.TCF_NOHOURS ) + " s" );
						acceleration = 0;
						if( player.car.bestTestTrackAcc > time || player.car.bestTestTrackAcc < 0.10 )
							player.car.bestTestTrackAcc = time;
					}
				}
				if( acceleration120 )
				{
					if( speedSquare >= MPH_124 )
					{
						messageText2.changeText( "Acceleration 0-200 KPH (0-124.2 MPH): " + String.timeToString( time, String.TCF_NOHOURS ) + " s" );
						acceleration120 = 0;
						if( player.car.bestTestTrackAcc120 > time || player.car.bestTestTrackAcc120 < 0.10 )
							player.car.bestTestTrackAcc120 = time;
					}
				}
				if( activeTrigger )
				{
					Trigger tr = actRound.trigger.elementAt( triggerIndex );
					if( activeTrigger == tr.trigger.id() )
					{
						if( triggerIndex == 1 ) // 402 m //
						{
							if( actRound.type == 0 )
							{
								messageText2.changeText( "1/4 mile time: " + String.timeToString( time, String.TCF_NOHOURS ) + " s" );
								if( player.car.bestTestTrackTime2 > time || player.car.bestTestTrackTime2 < 0.10 )
								{
									player.car.bestTestTrackTime2_speedSq = speedSquare;
									player.car.bestTestTrackTime2 = time;
								}
							}
						}
						triggerIndex++;
						if( triggerIndex == actRound.trigger.size() )
						{
							if( actRound.type == 0 )
							{
								messageText2.changeText( "1 mile time: " + String.timeToString( time, String.TCF_NOHOURS ) + " s" );
								if( player.car.bestTestTrackTime0 > time || player.car.bestTestTrackTime0 < 0.10 )
								{
									player.car.bestTestTrackTime0_speedSq = speedSquare;
									player.car.bestTestTrackTime0 = time;
								}
							}
							else
							{
								if( player.car.bestTestTrackTime1 > time || player.car.bestTestTrackTime1 < 0.10 )
									player.car.bestTestTrackTime1 = time;
							}
							addTimer( 4, 6 ); // Removing messages after 4 seconds
							actRound = null;
							Sound.changeMusicSet( Sound.MUSIC_SET_DRIVING );
						}
					}
				}
			}
		}
	}
}

public class TestTrack_Options extends Dialog
{
	final static int	CMD_BACK = 15;
	final static int	CMD_OK	 = 16;
	final static int	CMD_RIVAL = 20;
	final static int	CMD_POLICE = 21;

	Menu	m;
	Style	Menu_Center, Menu_Left;

	int	CurrentRival;
	int CurrentPolice;

	Button opt1;
	Button opt2;


	public TestTrack_Options()
	{
		super( GameLogic.player.controller, DF_MODAL|DF_DEFAULTBG|DF_HIGHPRI|DF_DARKEN, "TRACK OPTIONS", "" );
		
		Menu_Center = new Style( 0.50, 0.13, Frontend.mediumFont, Text.ALIGN_CENTER, Osd.RRT_TEST );
		
		m = osd.createMenu( Menu_Center, 0.0, -0.6, 0, Osd.MD_VERTICAL );
		opt1 = m.addItem( "Parking bots: Disabled", CMD_RIVAL, "Choose whether to see bots on parking lot or not." );

		m = osd.createMenu( Menu_Center, 0.0, -0.4, 0, Osd.MD_VERTICAL );
		opt2 = m.addItem( "Police chase:  Enabled", CMD_POLICE, "Choose whether to get chased by police car or not." );

		CurrentRival = 0;
		TestTrack.RivalOption = 0;

		CurrentPolice = 1;
		TestTrack.PoliceOption = 1;

		m = osd.createMenu( Menu_Center, -0.4, 0.9, 0, Osd.MD_HORIZONTAL );
		m.addItem( "OK", CMD_OK );
		
		m = osd.createMenu( Menu_Center, 0.4, 0.9, 0, Osd.MD_HORIZONTAL );
		m.addItem( "BACK", CMD_BACK );

		super.show();
	}
		
	public void osdCommand( int cmd )
	{
		if( cmd == CMD_RIVAL )
		{
			if( CurrentRival == 0 )
			{
				TestTrack.RivalOption = 1;
				opt1.changeLabelText( "Parking bots:  Enabled" );
				CurrentRival = 1;
			}
			else
			if( CurrentRival == 1 )
			{
				TestTrack.RivalOption = 0;
				opt1.changeLabelText( "Parking bots: Disabled" );
				CurrentRival = 0;
			}
		}
		else
		if( cmd == CMD_POLICE )
		{
			if( CurrentPolice == 0 )
			{
				TestTrack.PoliceOption = 1;
				opt2.changeLabelText( "Police chase:  Enabled" );
				CurrentPolice = 1;
			}
			else
			if( CurrentPolice == 1 )
			{
				TestTrack.PoliceOption = 0;
				opt2.changeLabelText( "Police chase: Disabled" );
				CurrentPolice = 0;
			}
		}
		else
		if( cmd == CMD_BACK )
		{
			osd.hide();
			super.hide();
		}
		else
		if( cmd == CMD_OK )
		{
			osd.hide();
			super.hide();
			GameLogic.changeActiveSection( new TestTrack() );
		}
	}
}


