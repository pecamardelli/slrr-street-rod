package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;


public class kit_GTLE_body extends Set
{
	public kit_GTLE_body( int id )
	{
		super( id );
		name = "Chevrolet Chevelle GTLE body kit";
		description = "";
	}

	public void build( Inventory inv )
	{
		inv.insertItem( cars.racers.Chevrolet_Chevelle:0x0000010Br ); // F bumper 2
		inv.insertItem( cars.racers.Chevrolet_Chevelle:0x000000ABr ); // R wing
	}
}
