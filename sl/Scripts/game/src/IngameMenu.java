package java.game;

import java.io.*;
import java.util.*;
import java.util.resource.*;
import java.render.*;	//Text
import java.render.osd.*;	//Text
import java.sound.*;

public class IngameMenu extends OptionsDialog
{
	// commands
	final static int	CMD_BACKTOGARAGE = 50;
	final static int	CMD_MODIFY = 51;
	final static int	CMD_MECHANIC = 52;
	final static int	CMD_PAINT = 53;
	final static int	CMD_QUICKREPAIR = 54;
	final static int	CMD_CONTINUE = 55;

	final static int	MM_ROC = 0;
	final static int	MM_CITY = 1;
	final static int	MM_TESTTRACK = 2;

	int				mode;

	Track			track;
	int				reqTrackExit;

	int				modifyGroup;

	Button			goBackButton;
	int				towCarFee;
	int				agatyadisramegy;

	public IngameMenu( Track track )
	{
		super( DF_DARKEN|DF_MODAL|DF_FREEZE );

		this.track = track;

		if( track instanceof ROCTrack )
			mode = MM_ROC;
		else
		if( track instanceof City )
			mode = MM_CITY;
		else
		//if( track instanceof TestTrack )
			mode = MM_TESTTRACK;

		createOSDObjects();

		changeMode ( mainGroup );
	}

//----------------------------------------------------------------------

	public void show()
	{
		//set "go back" text and fee:
		String towText;
		towCarFee=0;
		agatyadisramegy = 0;

		if(	GameLogic.gameMode == GameLogic.GM_CARREER )
		{
			if( mode == MM_CITY )
			{
				City cty = track;

				//mennyibe fog kerulni?
				Vector3 distance = player.car.getPos();
				distance.sub( cty.posStart );
				towCarFee += distance.length() * 0.03 + 10;

				towText = "TOW CAR TO GARAGE FOR $";

				if( cty.nightTime )
				{
					if( cty.nrPlayerRace == 2 )
					{
						if( cty.nrPrize )
						{
							towText = "PAY BET AND " + towText;
							towCarFee += cty.nrPrize;
						}
						else
						{
							towText = "LOOSE CAR AND " + towText;
							agatyadisramegy = 1;
						}
					}
				}
				else
				{
					if( cty.raceState )
					{
						if( cty.prize )
							towText = "PAY BET AND " + towText;
						else
							towText = "QUIT RACE AND " + towText;

						towCarFee += cty.prize;	
					}
				}


				if( cty.policeState )
				{
					towText = "PAY FINE AND " + towText;
					int[] fine = cty.calculateFineSum(0);
					towCarFee += fine[0];
				}

				towText = towText + towCarFee;

				//ha nagyon kozel vagyunk, es nincs rendor/verseny, ne szopasson ilyesmivel:
				if( towCarFee < 13 )
				{
					towCarFee = 0;
					towText = "GO BACK TO GARAGE";
				}
			}
			else
			if( mode == MM_ROC )
			{
				if( ((ROCTrack)track).testMode )
					towText = "EXIT TEST RUN";
				else
					towText = "GIVE UP RACE";
			}
			else
			{
				towText = "GO BACK TO GARAGE";
			}
		}
		else
		if(	GameLogic.gameMode == GameLogic.GM_SINGLECAR )
		{
			towText = "GO BACK TO GARAGE";
		}
		else
		{
			towText = "EXIT TO MAIN MENU";
		}

		goBackButton.changeLabelText( towText );

		super.show();
	}

	public void createOSDObjects()
	{
		Menu	m;

		//---------main menu--------------
		osd.createBG( RID_GENERALBG );
		osd.createHeader( "INGAME MENU" );

		m = osd.createMenu( butt1, 0.0, -0.5, 0 );
		m.addItem( "CONTINUE", CMD_CONTINUE );
	//	m.addItem( "MODIFY CAR", CMD_MODIFY );
		m.addItem( "OPTIONS", CMD_OPTIONS );
		goBackButton = m.addItem( "CHANGE ME", CMD_BACKTOGARAGE );

		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_CONTINUE, this );
		osd.hideGroup( mainGroup = osd.endGroup() );

		//---------modify menu--------------
		osd.createBG( RID_GENERALBG );
		osd.createHeader( "MODIFY CAR" );

		m = osd.createMenu( butt1, 0.0, -0.5, 0 );
		m.addItem( "QUICK REPAIR", CMD_QUICKREPAIR );
		m.addItem( "MANUAL REPAIR", CMD_MECHANIC );
		m.addItem( "BODY PAINT", CMD_PAINT );
		m.addItem( "BACK", CMD_MAIN );

		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_MAIN, this );
		osd.hideGroup( modifyGroup = osd.endGroup() );
	}


	public void osdCommand (int command)
	{
		if( command == CMD_MODIFY )
		{
			changeMode ( modifyGroup );
		}
		else
		if( command == CMD_QUICKREPAIR )
		{
			osdCommand( CMD_MAIN );
			osdCommand( CMD_CONTINUE );
			player.car.repair();
		}
		else
		if( command == CMD_MECHANIC )
		{
			osdCommand( CMD_MAIN );
			osdCommand( CMD_CONTINUE );
			track.osdCommand( track.CMD_MECHANIC );
		}
		else
		if( command == CMD_PAINT )
		{
			osdCommand( CMD_MAIN );
			osdCommand( CMD_CONTINUE );
			track.osdCommand( track.CMD_PAINT );
		}
		else
		if( command == CMD_BACKTOGARAGE )
		{
			if( mode == MM_CITY )
			{
				track.calculateFineSum(1);	//nullazza ki a szamlalokat!
				player.money-=towCarFee;
				if( player.money < 0 )
					player.money = 0;
				if( agatyadisramegy )
					track.killCar = 1;

				GameLogic.spendTime( towCarFee*60 );
			}

			reqTrackExit = 1;
			track.osdCommand( Track.CMD_INGAMEMENU );
		}
		else
		if( command == CMD_CONTINUE )
		{
			new SfxRef( Frontend.SFX_MENU_BACK ).play();
			track.osdCommand( Track.CMD_INGAMEMENU );
		}
		else
			super.osdCommand( command );
	}

}

