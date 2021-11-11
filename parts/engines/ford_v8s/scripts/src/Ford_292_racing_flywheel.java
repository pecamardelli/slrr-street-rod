package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.*;
import java.game.cars.*;


public class Ford_292_racing_flywheel extends Flywheel
{
	public Ford_292_racing_flywheel( int id )
	{
		super( id );
		name = "Ford Racing 292 V8 flywheel";
		description = "";
		brand_new_prestige_value = 67.34;

		value = tHUF2USD(65);
		setMaxWear(kmToMaxWear(760000.0));

		maxRPM = 10000.0;

		clutch_slot_ID = 4;

		inertia = kgToInertia(15.0);

		check4warnings();
	}
	
	public String isDynoable()
	{
		Part p;
		
		p = partOnSlot( 4 );
		if (!p)
			return "the engine is missing the clutch.";

		return super.isDynoable();
	}
}
