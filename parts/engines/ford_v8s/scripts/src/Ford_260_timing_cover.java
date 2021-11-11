package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.cylinderhead.*;
import java.game.cars.*;


public class Ford_260_timing_cover extends EnginePart
{
	public Ford_260_timing_cover( int id )
	{
		super( id );
		name = "Ford 260 V8 timing cover";
		description = "";
		brand_new_prestige_value = 24.67;

		value = tHUF2USD(10);
		setMaxWear(kmToMaxWear(511000.0));

		check4warnings();
	}
}
