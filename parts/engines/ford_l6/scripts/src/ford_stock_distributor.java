package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.cars.*;


public class ford_stock_distributor extends EnginePart
{
	public ford_stock_distributor( int id )
	{
		super( id );
		name = "Ford stock distributor";
		description = "";
		brand_new_prestige_value = 21.37;

		value = tHUF2USD(41.085);
		setMaxWear(kmToMaxWear(400000.0));

		check4warnings();
	}
	
	public String isDynoable()
	{
		Part p;

		p = partOnSlot( 1 );
		if (!p)
			return "the engine is missing the spark plugs and high voltage wires.";

		return super.isDynoable();
	}
}
