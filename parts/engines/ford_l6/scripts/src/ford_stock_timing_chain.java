package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.cylinderhead.*;
import java.game.cars.*;


public class ford_stock_timing_chain extends EnginePart
{
	public ford_stock_timing_chain( int id )
	{
		super( id );
		name = "Ford stock timing chain (for inline 6)";
		description = "";
		brand_new_prestige_value = 28.67;

		value = tHUF2USD(12.512);
		setMaxWear(kmToMaxWear(311000.0));

		check4warnings();
	}
}
