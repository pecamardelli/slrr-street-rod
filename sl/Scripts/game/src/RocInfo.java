package java.game;

import java.io.*;
import java.util.*;
import java.util.resource.*;
import java.render.*;	//Text
import java.render.osd.*;	//Text
import java.sound.*;


public class RocInfo extends GameType implements GameState
{
	// resource ID constants
	final static int  RID_BG = frontend:0x009Fr;

	GameState		parentState;
	Osd				osd;

	Roc				roc;
	int				showRound;

	Text[]			table1, table2;
	Text			title;

	public RocInfo()
	{
		createNativeInstance();
	}

	public void enter( GameState prevState )
	{
		parentState=prevState;

		roc = ((Garage)parentState).roc;

		osd = new Osd();
		osd.globalHandler = this;

		showRound = roc.getCurrentRound();

		createOSDObjects();
		fillTable();

		osd.show();

		Input.cursor.enable(1);

		setEventMask( EVENT_CURSOR );
	}

	public void exit( GameState nextState )
	{
		clearEventMask( EVENT_ANY );
		Input.cursor.enable(0);
		osd.hide();
		parentState=null;
	}

	public void osdCommand( int cmd )
	{
		if( cmd == Input.AXIS_CANCEL )
		{
			GameLogic.changeActiveSection( parentState );
		}
		if( cmd == Input.AXIS_MENU_LEFT )
		{
			if( showRound > 0 )
			{
				showRound--;
				fillTable();
			}
		}
		if( cmd == Input.AXIS_MENU_RIGHT )
		{
			if( showRound < Roc.ROUNDS-1 )
			{
				showRound++;
				fillTable();
			}
		}
	}

	public void createOSDObjects()
	{
		osd.createBG( new ResourceRef(RID_BG) );

		osd.createHeader( "RACE OF CHAMPIONS" );

		// icon background stripe
		osd.createRectangle( 1.20, -0.82, 1.2, 0.22, -1, new ResourceRef(frontend:0x0024r) );
		
		title = osd.createText( "x", Frontend.mediumFont, Text.ALIGN_RIGHT,		0.98, -0.98);

		Style buttonStyle = new Style( 0.12, 0.12, Frontend.mediumFont, Text.ALIGN_RIGHT, null );
		Menu m = osd.createMenu( buttonStyle, 0.98, -0.82, 0, Osd.MD_HORIZONTAL );

		m.addItem( new ResourceRef( frontend:0x0126r ), Input.AXIS_CANCEL, null );
		m.addSeparator();
		m.addSeparator();
		m.addItem( new ResourceRef( Osd.RID_ARROWRG ), Input.AXIS_MENU_RIGHT, null );
		m.addItem( new ResourceRef( Osd.RID_ARROWLF ), Input.AXIS_MENU_LEFT, null );

		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL|Osd.HK_STATIC, Input.AXIS_CANCEL, this );

		table1 = new Text[ Roc.COMPETITORS ];
		table2 = new Text[ Roc.COMPETITORS/2 ];

		float y=-0.6;
		for( int i=0; i<table1.length; i++ )
		{
			table1[i]=osd.createText( "x", Frontend.mediumFont, Text.ALIGN_LEFT,		-0.80,  y );

			if( i%2 == 0)
				table2[i/2]=osd.createText( "x", Frontend.mediumFont, Text.ALIGN_RIGHT,	-0.80,  y+0.035);
			else
				y+=0.03;

			y+=0.07;
		}
	}	

	public void fillTable()
	{
		int	curRound = roc.getCurrentRound();
		Racer[] racers = roc.rounds[showRound];

		int color;
		int i;
		for( ; i<racers.length; i++ )
		{
			color=0xFFFFFFFF;

			if( showRound == curRound )
			{
				if( i<2 )
					color=0xFFFFFF55;
			}

			if( racers[i] )
				table1[i].changeText( racers[i].name );
			else
				table1[i].changeText( "-" );

			table1[i].changeColor( color );

			if( i%2 == 0 )
			{
				table2[i/2].changeText( (i/2+1) + ". " );
				table2[i/2].changeColor( color );
			}
		}

		for( ; i<table1.length; i++ )
		{
			table1[i].changeText( null );
			if( i%2 == 0 )
				table2[i/2].changeText( null );
		}

		title.changeText( Roc.roundNames[Roc.ROUNDS-showRound-1] );
		if( showRound < curRound )
			title.changeColor( 0xFFFFFF55 );
	}
}

