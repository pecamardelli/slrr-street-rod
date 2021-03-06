package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.cylinderhead.*;
import java.game.cars.*;


public class Ford_stock_crankshaft_timing_gear extends EnginePart
{
	public Ford_stock_crankshaft_timing_gear( int id )
	{
		super( id );
		name = "Ford stock crankshaft timing gear";
		description = "";
		brand_new_prestige_value = 28.67;

		value = tHUF2USD(19.512);
		setMaxWear(kmToMaxWear(511000.0));

		check4warnings();
	}
}
