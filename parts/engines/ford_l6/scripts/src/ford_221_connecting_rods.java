package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.*;
import java.game.cars.*;

public class ford_221_connecting_rods extends ConnectingRod
{
	public ford_221_connecting_rods( int id )
	{
		super( id );
		name = "Ford 221 connecting rods";
		description = "";

		value = tHUF2USD(6*5.5);
		brand_new_prestige_value = 38.32;
		setMaxWear(kmToMaxWear(278000.0));

		piston_slot_ID = 39;

		length = 130.5;

		maxRPM = 9000.0;
		inertia = kgToInertia(6*0.500);

		check4warnings();
	}
	
	public String isDynoable()
	{
		Part p;

		p = partOnSlot( 39 );
		if (!p)
			return "the engine is missing the pistons.";

		return super.isDynoable();
	}
}
