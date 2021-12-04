package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.*;
import java.game.cars.*;


public class ford_stock_crankshaft_bearing_bridge extends SlidingEnginePart
{
	public ford_stock_crankshaft_bearing_bridge( int id )
	{
		super( id );
		name = "Ford stock crankshaft bearing bridge";
		description = "";

		value = tHUF2USD(23);
		brand_new_prestige_value = 38.32;
		setMaxWear(kmToMaxWear(540000.0));

		check4warnings();
	}
}
