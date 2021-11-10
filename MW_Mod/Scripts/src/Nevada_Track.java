package java.game;

import java.io.*;
import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.render.*;	//Text
import java.render.osd.*;	//Text
import java.sound.*;
import java.render.osd.dialog.*; //Dialog Window

import java.game.parts.*;
import java.game.parts.enginepart.*;

public class Nevada_Track extends Track
{	
	final static String MapName = "Nevada Desert";
	final static String MapDescription = "\n There take a place ROC \n \n Now you can try the race track.";
	final static String MapAuthor = "Authors: Invictus & Miran";
	final static ResourceRef MapImage = new ResourceRef( MW_Mod:0x0099r );
	final static float	TS_Version = 1.0;

	final static int TimerOption = 1;

	Text		current_time_text, best_time_text, check_text;
	Trigger[]	fence;
	Round		actRound;
	int			Checked;
	float		StartTime, BestTime = 9999;

	public Nevada_Track()
	{
		posStart = new Vector3( 5.4, 0.0, -6 ); // Start car position
		oriStart = new Ypr( -0.55, 0.0, 0.0 ); // Start car rotation

		map = new GroundRef( maps.ROC_track:0x00000001r );
		nav = new Navigator( -17.1137, -26.6, 4.9404, maps.ROC_Track.smallmap:0x00000001r, maps.ROC_Track.smallmap:0x00000002r, maps.ROC_Track.smallmap:0x00000005r, 8, 8, 8 );

		fence = new Trigger[3];

		fence[0] = new Trigger( map, null, new Vector3( 814, 0, -1109 ), 30, 300, 30, "fence 0" );
		fence[1] = new Trigger( map, null, new Vector3( -22, 0,   218 ), 30, 300, 30, "fence 1" );
		fence[2] = new Trigger( map, null, new Vector3(-134, 0, -1254 ), 30, 300, 30, "fence 2" );

        addNotification( fence[0].trigger, EVENT_TRIGGER_ON, EVENT_SAME, null, "event_handlerRocFence" );
        addNotification( fence[1].trigger, EVENT_TRIGGER_ON, EVENT_SAME, null, "event_handlerRocFence" );
        addNotification( fence[2].trigger, EVENT_TRIGGER_ON, EVENT_SAME, null, "event_handlerRocFence" );
	}

	public void enter( GameState prev_state )
	{
		Frontend.loadingScreen.show();
		GfxEngine.flush();

		actRound = new Round( this, null, null );
		actRound.startdir( -0.55 );
		actRound.point(	12, 0.0, -20, 0, 8.0 );

		actRound.point(	360.000, 87.000,  -993.000, 0 );
		actRound.point(	180.000, 72.000, -1011.000, 0 );
		actRound.point(	-76.700,  0.710, -1057.000, 0 );
		actRound.point(	 62,   0, -100, 0 );	// debug shrtcut point!
		actRound.point(	-24, 0.8, -55, 0, 8.0 );	// 8.0: a celban kisebb a trigger sugara!!

		super.enter( prev_state );

		if( TimerOption == 1 )
		{
			best_time_text = osd.createText( "Best Time: N/A", Frontend.largeFont, Text.ALIGN_LEFT, -0.9, -0.9 );
			current_time_text = osd.createText( "Current Time", Frontend.largeFont, Text.ALIGN_LEFT, -0.9, -0.82 );

			check_text = osd.createText( "Checkpoints: 0/4", Frontend.largeFont, Text.ALIGN_RIGHT, 0.9, -0.9 );
		}

		player.car.wakeUp();
		player.car.command( "idle" );

	}

	public void exit( GameState next_state )
	{
        if( !(next_state instanceof RaceSetup) )
			removeAllTimers();

		actRound.destroy();
		actRound = null;

		super.exit( next_state );
	}

	public void event_handlerRocFence( GameRef obj_ref, int event, String param )
	{
		int	id = param.token( 0 ).intValue();

		if( id == player.car.id() )
		{
			player.car.command( "stop" );

			new WarningDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "WARNING", "You are not allowed to leave the race area!" ).display();

			player.car.setMatrix( player.car.getPos(), new Ypr( player.car.getOri().y+3.1, player.car.getOri().p, player.car.getOri().r ) );
			player.car.command( "start" );
		}
	}

	public void event_handlerTrigger( GameRef obj_ref, int event, String param )
	{
		int	id = param.token( 0 ).intValue();

		if( TimerOption == 1 && event == EVENT_TRIGGER_ON )
		{
			int	trgId = obj_ref.id();

			if( id == player.car.id() )
			{
				if( actRound.trigger.elementAt( 0 ).trigger.id() == trgId )
				{ // start
					StartTime = System.simTime();
					setMessage( "GO!" );
					Checked = 0;
					check_text.changeText( "Checkpoints: 0/4");
				}
				else
				if( actRound.trigger.elementAt( 5 ).trigger.id() == trgId )
				{ // finish
					if( Checked == 4)
					{
						if(System.simTime()-StartTime < BestTime)
						{
							BestTime = System.simTime()-StartTime;
							best_time_text.changeText( "Best Time: " + String.timeToString( BestTime, String.TCF_NOHOURS ) + " s" );
							setMessage( "New Record: " +  String.timeToString( BestTime, String.TCF_NOHOURS ) + " s" );
							check_text.changeText( "Checkpoints: 0/4");
						}
						else
							setMessage( "To slow man!");

					}
					else
						setMessage( "Checkpoint missed!");
				}
				else
				{ // checkpoints
					setMessage( "Checkpoint passed!" );
					Checked++;
					check_text.changeText( "Checkpoints: "+Checked+"/4" );
				}
			}
		}
		else
		{
			if( id == player.car.id() )
				activeTrigger = 0;
		}
	}

	public void animate()
	{
		super.animate();

		if( TimerOption == 1 )
		{
			float time = System.simTime() - StartTime;
			current_time_text.changeText( "Current Time: " + String.timeToString( time, String.TCF_NOHOURS ) + " s" );
		}
		/*if(player.car)
		{
			current_time_text.changeText( "Pos: x" + player.car.getPos().x + ", y" + player.car.getPos().y + ", z" + player.car.getPos().z);
		}*/
	}

	public void StartMap()
	{
		TimerOption = 1;
		new Nevada_Track_Options().display();
	}
}

public class Nevada_Track_Options extends Dialog
{
	final static int	CMD_BACK = 15;
	final static int	CMD_OK	 = 16;
	final static int	CMD_TIMER = 20;

	Menu	m;
	Style	Menu_Center, Menu_Left;

	int	CurrentTimer;

	Button opt1;

	public Nevada_Track_Options()
	{
		super( GameLogic.player.controller, DF_MODAL|DF_DEFAULTBG|DF_HIGHPRI|DF_DARKEN, "TRACK OPTIONS", "" );

		Menu_Center = new Style( 0.50, 0.13, Frontend.mediumFont, Text.ALIGN_CENTER, Osd.RRT_TEST );

		m = osd.createMenu( Menu_Center, 0.0, -0.6, 0, Osd.MD_VERTICAL );
		opt1 = m.addItem( "Time Attack:  Enabled", CMD_TIMER, "Choose whether do time attack race or not." );

		CurrentTimer = 1;
		Nevada_Track.TimerOption = 1;

		m = osd.createMenu( Menu_Center, -0.4, 0.9, 0, Osd.MD_HORIZONTAL );
		m.addItem( "OK", CMD_OK );

		m = osd.createMenu( Menu_Center, 0.4, 0.9, 0, Osd.MD_HORIZONTAL );
		m.addItem( "BACK", CMD_BACK );

		super.show();
	}

	public void osdCommand( int cmd )
	{
		if( cmd == CMD_TIMER )
		{
			if( CurrentTimer == 0 )
			{
				Nevada_Track.TimerOption = 1;
				opt1.changeLabelText( "Time Attack:  Enabled" );
				CurrentTimer = 1;
			}
			else
			if( CurrentTimer == 1 )
			{
				Nevada_Track.TimerOption = 0;
				opt1.changeLabelText( "Time Attack: Disabled" );
				CurrentTimer = 0;
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
			GameLogic.changeActiveSection( new Nevada_Track() );
		}
	}
}
