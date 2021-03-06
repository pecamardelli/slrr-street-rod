package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.cylinderhead.*;
import java.game.cars.*;


public class Ford_312_water_pomp extends EnginePart
{
	public Ford_312_water_pomp( int id )
	{
		super( id );
		name = "Ford 312 V8 water pomp";
		description = "";
		brand_new_prestige_value = 28.67;

		value = tHUF2USD(18);
		setMaxWear(kmToMaxWear(211000.0));

		check4warnings();
	}
	
	public String isDynoable()
	{
		Part p;

		p = partOnSlot( 1 );
		if (!p)
			return "the engine is missing the fan.";
		
		p = partOnSlot( 11 );
		if (!p)
			return "the engine is missing the drive belt.";

		return super.isDynoable();
	}
}
