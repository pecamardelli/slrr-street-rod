package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.*;
import java.game.cars.*;


public class Ford_390_racing_connecting_rods extends ConnectingRod
{
	public Ford_390_racing_connecting_rods( int id )
	{
		super( id );
		name = "Ford Racing 390 V8 connecting rods";
		description = "";
		brand_new_prestige_value = 41.68;

		value = tHUF2USD(85);
		setMaxWear(kmToMaxWear(413000.0));

		maxRPM = 8250.0;

		piston_slot_ID = 42;

		length = 171.00;

		inertia = kgToInertia(8*0.750);

		check4warnings();
	}
	
	public String isDynoable()
	{
		Part p;

		p = partOnSlot( 42 );
		if (!p)
			return "the engine is missing the pistons.";

		return super.isDynoable();
	}
}
