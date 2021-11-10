package java.game;

import java.io.*;
import java.util.*;
import java.util.resource.*;
import java.render.*;	//Text
import java.render.osd.*;	//Text
import java.render.osd.dialog.*;	//Text
import java.sound.*;


public class ROCTrack extends Track
{
	final static int		RID_STARTBG = frontend:0x0116r;
	final static int		RID_FIN_WIN = frontend:0x013er;
	final static int		RID_FIN_LOSE = frontend:0x013dr;
	final static int		RID_SPEECH3 = sound:0x001dr;
	final static int		RID_SPEECH2 = sound:0x001cr;
	final static int		RID_SPEECH1 = sound:0x001br;
	final static int		RID_SPEECHGO = sound:0x001er;
	final static int		RID_SPEECHYOUWIN = sound:0x001fr;
	final static int		RID_APPLAUSE1 = sound:0x0021r;
	final static int		RID_APPLAUSE2 = sound:0x0022r;

	Text	messageText0;
	Text	messageText1;

	Bot		raceBot;

	Marker	mRaceBot;

	int		testMode; // 0-race; 1-try track
	int		testStatus;
	int		testCountDown;

	float	timerStarted = 0.0f;
	int		displayTimer;

	int		applauseSfxID;
	int		applauseSfxOn;
	int		finishSfxID;
	int		finishSfxOn;

	int		triggerIndex0,triggerIndex1;

	int		plRank;
	int		finished; // 0-none; 1-player; 2-ai; 3-both // 0x4-handled (to avoid multiple calls!)
	float	startTime;
	float	botTime;
	float	playerTime;

	Trigger[]	fence;
	int		fence_repeater_semaphore;

	Round			actRound;

	Vector3			startPos;
	Ypr				startOri;
	Vector3			finishPos;
	Trigger			finishSoundTrigger;

	RenderRef[]		rocMen = new RenderRef[40];
	Animation[]		rocMenAnim = new Animation[40];
	int				nRocMen;

	Roc				roc;

	public ROCTrack()
	{
		map = new GroundRef( maps.ROC_track:0x00000001r );
		nav = new Navigator( -17.1137, -26.6, 4.9404, maps.ROC_Track.smallmap:0x00000001r, maps.ROC_Track.smallmap:0x00000002r, maps.ROC_Track.smallmap:0x00000005r, 8, 8, 8 );

		fence = new Trigger[4];

		fence[0] = new Trigger( map, null, new Vector3( 520, 0, -1371 ), 2000, 300, 1, "fence 0" );
		fence[1] = new Trigger( map, null, new Vector3( 108, 0,   504 ), 2000, 300, 1, "fence 1" );
		fence[2] = new Trigger( map, null, new Vector3(-366, 0,  -436 ), 1, 300, 2000, "fence 2" );
		fence[3] = new Trigger( map, null, new Vector3( 817, 0,  -436 ), 1, 300, 2000, "fence 3" );

        addNotification( fence[0].trigger, EVENT_TRIGGER_ON, EVENT_SAME, null, "event_handlerRocFence" );
        addNotification( fence[1].trigger, EVENT_TRIGGER_ON, EVENT_SAME, null, "event_handlerRocFence" );
        addNotification( fence[2].trigger, EVENT_TRIGGER_ON, EVENT_SAME, null, "event_handlerRocFence" );
        addNotification( fence[3].trigger, EVENT_TRIGGER_ON, EVENT_SAME, null, "event_handlerRocFence" );
	}


	public void placeMen( Vector3 pos, float yaw )
	{
		int man;
		Vector3 rand;

		int[] manID = new int[6];
		manID[ 0 ] = humans:0x002fr;
		manID[ 1 ] = humans:0x0030r;
		manID[ 2 ] = humans:0x0031r;
		manID[ 3 ] = humans:0x0032r;
		manID[ 4 ] = humans:0x0033r;
		manID[ 5 ] = humans:0x0034r;

		int[] manAnimID = new int[6];
		manAnimID[ 0 ] = humans:0x0014r;
		manAnimID[ 1 ] = humans:0x001br;
		manAnimID[ 2 ] = humans:0x007dr;
		manAnimID[ 3 ] = humans:0x007er;
		manAnimID[ 4 ] = humans:0x0017r;
		manAnimID[ 5 ] = humans:0x007fr;

		Vector3 spacin = new Vector3( 1.0, 0, 0 );
		spacin.rotate( new Ypr(yaw+1.57,0.0,0.0) );

		Vector3 sideoffs = new Vector3( 7.2, 0, 0 );
		sideoffs.rotate( new Ypr(yaw,0.0,0.0) );

		Ypr manOri = new Ypr( yaw+1.57, 0, 0 );

		Vector3 manPos = new Vector3( pos );

		for( int i = 0; i < 10; i++)
		{
			rand = new Vector3( Math.random() - 0.5, 0, 0 );
			rand.rotate( new Ypr(yaw,0.0,0.0) );
			manPos.add( rand );
			manPos.sub( sideoffs );
			man = Math.random() * manID.length;
			rocMen [nRocMen] = new RenderRef( map, manID[ man ], "tesztmen" );
			rocMenAnim[nRocMen] = new Animation( rocMen[nRocMen], new ResourceRef(manAnimID[ man ]));
			rocMenAnim[nRocMen].setSpeed( 0.5+Math.random() );
			rocMenAnim[nRocMen].loopPlay();
			rocMen [nRocMen].setMatrix( manPos, manOri );
			nRocMen++;
			manPos.add( sideoffs );
			manPos.sub( rand );

			manOri.y -= 3.14;
			rand = new Vector3( Math.random() - 0.5, 0, 0 );
			rand.rotate( new Ypr(yaw,0.0,0.0) );
			manPos.add( rand );
			manPos.add( sideoffs );
			man = Math.random() * manID.length;
			rocMen [nRocMen] = new RenderRef( map, manID[ man ], "tesztmen" );
			rocMenAnim[nRocMen] = new Animation( rocMen[nRocMen], new ResourceRef(manAnimID[ man ]));
			rocMenAnim[nRocMen].setSpeed( 0.5+Math.random() );
			rocMenAnim[nRocMen].loopPlay();
			rocMen [nRocMen].setMatrix( manPos, manOri );
			nRocMen++;
			manPos.sub( sideoffs );
			manPos.sub( rand );
			manOri.y += 3.14;

			rand = new Vector3( spacin );
			rand.mul( Math.random()*1.0+0.8 );
			manPos.add( rand );
		}
	}

	public void enter( GameState prev_state )
	{
		Frontend.loadingScreen.show();
		GfxEngine.flush();

		roc = ((Garage)prev_state).roc;

		actRound = new Round( this, null, null );
		actRound.startdir( -0.55 );
		actRound.point(	5.4, 0.0,	 -6, 0 );

		actRound.point(	360.000,  87.000,  -993.000, 0 );
		actRound.point(	180.000,  72.000, -1011.000, 0 );
		actRound.point(	-76.700,   0.710, -1057.000, 0 );
		//actRound.point(	62, 0, -100, 0 ); // debug shrtcut point!

		actRound.point(	 -25, 0.8,  -57, 0, 8.0 ); // 8.0: a celban kisebb a trigger sugara!!

		startPos = new Vector3( actRound.getPoint( 0 ) );
		startOri = actRound.startOri;
		finishPos = new Vector3( actRound.getPoint( actRound.size() - 1 ) );

		finished = 0;

		if( !testMode )
		{
			Vector3 pos = new Vector3( -1.75, 0, 0 ); // a ket kocsi kozott 1.75 * 2 m a tavolsag
			pos.rotate( new Ypr( -0.55, 0.0, 0.0) );
			pos.add( startPos );

			placeMen( pos, -0.55 );
			placeMen( finishPos, 0.0 );

			raceBot = roc.getNextOpponent();
			//raceBot.createCar( map ); // under bot
			//raceBot.createCar( map, roc.getCurrentCarName() );
			raceBot.createCar( map, roc.getCurrentVehicle() );
			//raceBot.car.loadSkin( roc.getCurrentPaintJobName() );
			raceBot.brain.queueEvent( null, EVENT_COMMAND, roc.getCurrentAIParam() );

			Vector3 botPos = new Vector3( startOri );
			botPos.mul( 3.5 ); // melle
			botPos.rotate( new Ypr(1.57,0.0,0.0) );
			botPos.add( startPos );
			raceBot.car.queueEvent( null, EVENT_COMMAND, "reset" );
			raceBot.car.queueEvent( null, EVENT_COMMAND, "reload" );
			raceBot.car.setMatrix( botPos, startOri );

			raceBot.car.setParent( map );
			raceBot.car.wakeUp();
			raceBot.car.queueEvent( null, EVENT_COMMAND, "stop" );
			raceBot.car.queueEvent( null, EVENT_COMMAND, "idle" );

			testStatus =- 2;
		}

		super.enter( prev_state );

		messageText0 = osd.createText( null, Frontend.largeFont, Text.ALIGN_RIGHT, 0.0, -0.7 );
		messageText1 = osd.createText( null, Frontend.largeFont, Text.ALIGN_LEFT, 0.0, -0.7 );

		player.car.setMatrix( actRound.getPoint(0), actRound.startOri );
		player.car.wakeUp();

		Vector3 camPos = new Vector3( actRound.startOri );
		camPos.mul( -8.0 ); // moge
		camPos.y += 5; // fole
		camPos.add( player.car.getPos() );
		moveCamera( camPos, actRound.startOri );

		player.car.queueEvent( null, GameType.EVENT_COMMAND, "stop" );
		player.car.command( "idle" );

		if( !testMode )
		{
			applauseSfxID = new SfxRef( RID_APPLAUSE1 ).play( startPos, 0.0, 1.0, 1.0, SfxRef.SFX_LOOP | SfxRef.SFX_NOAUTOSTOP ); // start looped sfx
			applauseSfxOn = 1;

			ResourceRef head1 = raceBot.character;
			ResourceRef head2 = player.character;
			
			String name1 = raceBot.name;
			String name2 = player.name;

			changeCamTarget2(raceBot.car);
			mRaceBot= nav.addMarker( raceBot );
			raceBot.car.command( "idle" );

			Frontend.loadingScreen.display( new RaceDialog(player.controller, Dialog.DF_MODAL, new ResourceRef(RID_STARTBG), head2, head1, name2, name1, 0, 0, roc.wonRuns+roc.lostRuns+1, 2 ), 10.0 );

			cam.command( "angle 0 5.0 0.4853" );

			testCountDown = 8;
		}

		testStatus =- 1;

		Sound.changeMusicSet( Sound.MUSIC_SET_RACE );
	}

	public void exit( GameState next_state )
	{
        if( !(next_state instanceof RaceSetup) )
			removeAllTimers();

		actRound.destroy();
		actRound = null;

		super.exit( next_state );
	}

	public void resetGameMode()
	{
		if( messageText0 )
		{
			messageText0.changeText( null );
			messageText1.changeText( null );
		}

		if( raceBot )
		{
			raceBot.deleteCar();
			nav.remMarker( mRaceBot );	mRaceBot=null;
		}

		stopTimer();
		testStatus++; // finished
	}

	public void event_handlerRocFence( GameRef obj_ref, int event, String param )
	{
		int	id = param.token(0).intValue();

		if( !fence_repeater_semaphore && id == player.car.id() )
		{
			fence_repeater_semaphore = 1;
			player.car.command( "brake" );
			if( testMode )
			{
				new WarningDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "WARNING", "You are not allowed to leave the race area! \n Now going back to the tent..." ).display();
				osdCommand( CMD_EXIT );
			}
			else
			{
				new WarningDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "WARNING", "You are not allowed to leave the race area! \n You lost this run..." ).display();
				giveUpRace();
			}
		}
	}

	public void event_handlerFinishSound( GameRef obj_ref, int event, String param )
	{
		int	id = param.token(0).intValue();

		if( event == EVENT_TRIGGER_ON )
		{
			if( !testMode && (id == player.car.id()) )
			{
				if( triggerIndex0 >= actRound.size() - 1 )
				{
					finishSfxID = new SfxRef( RID_APPLAUSE2 ).play( finishPos, 0.0, 1.0, 1.0, SfxRef.SFX_LOOP | SfxRef.SFX_NOAUTOSTOP ); // start looped sfx
					finishSfxOn = 1;
				}
			}
		}
	}

	public void event_handlerTrigger( GameRef obj_ref, int event, String param )
	{
		if( testStatus == 1 )
		{
			int	id = param.token(0).intValue();

			if( event == EVENT_TRIGGER_ON )
			{
				int	trgId = obj_ref.id();

				// opponent handling
				if( raceBot )
				{
					if( id == raceBot.car.id() )
					{
						if( !(finished&0x02) )
						{
							if( actRound.trigger.lastElement().trigger.id() == trgId )
							{
								// celba ert a bot
								botTime = System.simTime() - startTime;
								finished |= 0x02;
								if( !plRank )
									plRank=0x02;

								raceBot.stop();
							}
						}
					}
				}
				// player handling
				if( id == player.car.id() )
				{
					if( !(finished&0x01) )
					{
						if( !activeTrigger )
						{
							if( actRound.trigger.elementAt( triggerIndex0 ).trigger.id() == trgId )
							{
								activeTrigger = trgId;

								triggerIndex0++;
								if( triggerIndex0 == actRound.size() )
								{
									playerTime = System.simTime() - startTime;
									finished |= 0x01;
									if( !plRank )
										plRank=0x01;

									player.car.command( "brake" );
									// player won

									pauseTimer();
									if( testMode )
									{
										setMessage( "Well done!" );

										Thread.sleep( 6000 );
										resetGameMode();
										GameLogic.changeActiveSection( parentState );
									}
									else
									{
										if( plRank==1 )
										{
											setMessage( "Well done!" );
											new SfxRef( RID_SPEECHYOUWIN ).play();
										}
										else
										{
											setMessage( "Too bad loser." );
										}
									}
								}
								else
								{
									setMessage( "Checkpoint "+(triggerIndex0-1)+" of "+(actRound.size()-2)+" passed!" );
								}
							}
						}
					}
				}

				// csak 1x futhat le!!
				if( !testMode && (finished == 0x01 || finished == 0x02) )
				{
					finished |= 0x04;

					// WIN/LOOSE
					Thread.sleep(3000);	// adunk egy kis idot, hatha beer a masik

					player.car.command( "brake" );
					raceBot.stop();

					cam.command( "angle 0 5.0 0.4853" );
					//new SfxRef( RID_APPLAUSE2 ).play();

					// had porogjon...
					Thread.sleep( 8000 );

					finishRocRace();
				}
			}
			else
			{
				if( id == player.car.id() )
					activeTrigger = 0;
			}
		}
	}

	public void osdCommand( int cmd )
	{
		// nem engedjuk menut nyomkodni a befejezo "cutscene" alatt
		if( cmd == CMD_INGAMEMENU && finished )
			return;
		else
			super.osdCommand( cmd );
	}


	public void giveUpRace()
	{
		plRank = 2;
		finishRocRace();
	}

	public void finishRocRace()
	{
		resetGameMode();

		ResourceRef head1 = raceBot.character;
		ResourceRef head2 = player.character;
		String name1 = raceBot.name;
		String name2 = player.name;

		cam.command( "angle 0.0" );

		if( plRank == 1 )
		{
			roc.wonRuns++;

			int	dialogCode = ( roc.numRounds()-roc.getCurrentRound() ) + 10*roc.lostRuns + 100*roc.wonRuns;
			RaceDialog raceDialog = new RaceDialog(player.controller, Dialog.DF_MODAL, new ResourceRef(RID_FIN_WIN), head2, head1, name2, name1, playerTime, botTime, dialogCode, 3 );

			if( ( roc.isFinalRound() && roc.isRoundClosed() ) )
			{
				changeCamNone();

				Frontend.loadingScreen.show( raceDialog );

				Thread.sleep( 2000 ); // hadd toltse..

				GameLogic.spendTime( 8*3600+24*3600-GameLogic.getTime() );
				player.money -= GameLogic.ROC_ENTRYFEE;
				((Garage)parentState).roc = null;

				// prestige, stb emeles
				player.car.races_won += 1000; // hadd szoljon :)
				player.prestige = 1.0;
				player.money += 500000;

				// emelveny a kocsinak
				Vector3 trailerPos = new Vector3( -25.764, 0.528, -63.022 );
				Ypr trailerOri = new Ypr( -1.569, 0.000, 0.000 );
				Vector3 primePos = new Vector3( -25.480, 1.781, -62.949 );
				Ypr primeOri = new Ypr( 1.7, 0.000, 0.000 );

				RenderRef trailer = new RenderRef( map, new RenderRef( maps.ROC_Track.extras:0x0008r ), "trailer" );
				trailer.setMatrix( trailerPos, trailerOri );

				// congrats banner
				osd.createRectangle( 0.0, 0.0, 2.0, 2.0, -1, new ResourceRef( frontend:0x0090r ) );
				new SfxRef( RID_APPLAUSE2 ).play();
				enableOsd( 0 );

				player.car.setMatrix( primePos, primeOri );

				changeCamTarget( player.car );
				changeCamFollow(); // rescan target

				cam.command( "move " + map.id() + " " + primePos.toString() + " 3.5" );
				cam.command( "look " + map.id() + " " + primePos.toString() + " 0,0,0" );

				Frontend.loadingScreen.display( raceDialog, 10.0 );

				cam.command( "angle 0 5.0 0.4853" );
				Thread.sleep( 16000 );
			}
			else
			{
				roc.closeRun();
				Frontend.loadingScreen.display( raceDialog, 10.0 );
			}
		}
		else
		{
			roc.lostRuns++;

			int	dialogCode = -( (roc.numRounds()-roc.getCurrentRound()) + 10*roc.lostRuns + 100*roc.wonRuns );
			Frontend.loadingScreen.display( new RaceDialog(player.controller, Dialog.DF_MODAL, new ResourceRef(RID_FIN_LOSE), head1, head2, name1, name2, botTime, playerTime, dialogCode, 3 ), 10.0 );

			if( roc.isRoundClosed() )
			{
				GameLogic.spendTime( 8*3600+24*3600-GameLogic.getTime() );
				player.money-=GameLogic.ROC_ENTRYFEE;
				((Garage)parentState).roc = null;
			}
			else
			{
				roc.closeRun();
			}
		}

		if( finishSfxOn )
		{
			new SfxRef( RID_APPLAUSE2 ).stop( finishSfxID ); // end looped sfx
			finishSfxOn = 0;
		}

		if( finishSoundTrigger )
			removeTrigger( finishSoundTrigger );
		finishSoundTrigger = null;

		// vissza a garazsba (roc/normal)
		GameLogic.changeActiveSection( parentState );
	}

	public void handleEvent( GameRef obj_ref, int event, int param )
	{
		super.handleEvent( obj_ref, event, param );

		if( event == EVENT_TIME )
		{
			if( param == 2 ) // one sec tick
			{
				if( testStatus == 0 ) // 3..2..1..
				{
					if( testCountDown )
					{
						if( testCountDown == 3 )
						{
							if( !testMode )
								raceBot.brain.command( "AI_BeginRace 0.5" );

							new SfxRef( RID_SPEECH3 ).play();
						}
						else 
						if( testCountDown == 2 )
						{
							new SfxRef( RID_SPEECH2 ).play();
							cam.command( "angle 0 3.0" );
						}
						else 
						if( testCountDown == 1 )
						{
							new SfxRef( RID_SPEECH1 ).play();

							if( !testMode )
								raceBot.brain.command( "AI_BeginRace 1.0" );
						}
						setMessage( testCountDown-- );
					}
					else
					{
						cam.command( "angle 0 0" );
						testStatus++;

						new SfxRef( RID_SPEECHGO ).play();
						setMessage( "GO!" );

						if( !testMode )
						{
							addTimer( 5, 99 ); // applause off timer
							finishSoundTrigger = addTrigger( finishPos, null, Marker.RR_FINISH, "event_handlerFinishSound", 10, "finish sound trigger" );
						}

						botTime = 0;
						playerTime = 0;
						startTime = System.simTime();
						startTimer();

						activeTrigger = actRound.trigger.elementAt( 0 ).trigger.id();
						triggerIndex0 = 1;
						player.car.queueEvent( null, GameType.EVENT_COMMAND, "start" );
						if (raceBot)
						if (raceBot.car)
							raceBot.car.queueEvent( null, GameType.EVENT_COMMAND, "start" );
						if( raceBot )
							raceBot.followSplineTrack( 0.5, roc.getCurrentSplineName(), player.car.id() );

						plRank=0;
						finished=0;
					}
				}
				else
				if( testStatus == -1 )
				{
					if( --testCountDown < 0 )
					{
						testStatus++;
						testCountDown=3;
					}
				}

			}
			else if( param == 99 ) // applause off timer
			{
				if( applauseSfxOn )
				{
					new SfxRef( RID_APPLAUSE1 ).stop( applauseSfxID ); // end looped sfx
					applauseSfxOn = 0;
				}
			}
		}
	}


	public void animate()
	{
		super.animate();

		if( displayTimer )
		{
			float	time = System.simTime() - timerStarted;

			messageText1.changeText( String.timeToString( time, String.TCF_NOHOURS ) + " s" );
		}
	}
	
	public void moveCamera( Vector3 p, Ypr o )
	{
		Vector3 cur = cam.getPos();
		cur.sub( p );

		if( cur.length() > 10 )
			cam.setMatrix( p, o );
	}

	public void startTimer()
	{
		timerStarted=System.simTime();
		messageText0.changeText( "Time: " );
		displayTimer = 1;
	}

	public void stopTimer()
	{
		displayTimer = 0;
		if( messageText0 )
		{
			messageText0.changeText( null );
			messageText1.changeText( null );
		}
	}

	public void pauseTimer()
	{
		displayTimer = 0;
	}
}

