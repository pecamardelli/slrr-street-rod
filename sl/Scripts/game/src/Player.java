package java.game;

import java.io.*;
import java.util.*;
import java.util.resource.*;
import java.render.*;	//Text
import java.render.osd.*;	//Text
import java.sound.*;

public class Player extends Racer
{
	final static int	H_GARAGE	= 0x00000001;
	final static int	H_DAYCITY	= 0x00000002;
	final static int	H_NIGHTCITY = 0x00000004;

	int			hints;
	int			winPinkSlips;

	Osd			osd;
	int			osdGroup = 0;

	Controller	controller;
	Inventory	parts;
	Vector		decals = new Vector();

	int			flags;
	float		record_acceleration, record_speed;
	int			races_won, races_lost;

	CarLot		carlot;


	public Player()
	{
		parts = new Inventory( this );
		carlot = new CarLot( this );

		//pri=18, hogy a loading dialog eltakarja a megjeleno muszereket!
		osd = new Osd( 1.0, 0.0, 18 );
		osd.iLevel=Osd.IL_NONE;

		osd.createRectangle( -0.75, 0.715, 0.55, 0.67, -2, new ResourceRef( frontend:0x0083r ) );
		osd.hideGroup( osdGroup = osd.endGroup() );
	}

	public int checkHint( int hintMask )
	{
		int shown = hints & hintMask;
		hints |= hintMask;
		return !shown;
	}


	public RenderRef getMarker()
	{
		return Marker.RR_PLAYER;
	}

	public void showOsd()
	{
		osd.show();
		controller.queueEvent( null, GameType.EVENT_COMMAND, "osd " + osd.id() );
	}

	public void hideOsd()
	{
		controller.queueEvent( null, GameType.EVENT_COMMAND, "osd 0" );
		osd.hide();
	}

	public void save( File saveGame )
	{
		super.save( saveGame );
		//ToDo: save name, inventory, cars in lot, known places, statistics, etc.
		parts.save( saveGame );
	}

	public void load( File saveGame )
	{
		super.load( saveGame );

		parts.load( saveGame );
	}
}
