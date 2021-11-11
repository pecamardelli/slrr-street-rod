package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.cylinderhead.*;
import java.game.cars.*;


public class Edelbrock_dual_crankshaft_timing_gear extends EnginePart
{
	public Edelbrock_dual_crankshaft_timing_gear( int id )
	{
		super( id );
		name = "Edelbrock dual crankshaft timing gears";
		description = "";
		brand_new_prestige_value = 38.67;

		value = tHUF2USD(35);
		setMaxWear(kmToMaxWear(511000.0));

		check4warnings();
	}
}
