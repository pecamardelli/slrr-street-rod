package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.cylinderhead.*;
import java.game.cars.*;


public class Ford_stock_camshaft_timing_gear extends EnginePart
{
	public Ford_stock_camshaft_timing_gear( int id )
	{
		super( id );
		name = "Ford stock camshaft timing gear";
		description = "";
		brand_new_prestige_value = 28.67;

		value = tHUF2USD(20.512);
		setMaxWear(kmToMaxWear(211000.0));

		check4warnings();
	}
	
	public String isDynoable()
	{
		Part p;

		p = partOnSlot( 22 );
		if (!p)
			return "the engine is missing the timing chain.";

		return super.isDynoable();
	}
}
