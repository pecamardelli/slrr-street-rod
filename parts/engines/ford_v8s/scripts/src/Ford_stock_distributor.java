package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.cars.*;


public class Ford_stock_distributor extends EnginePart
{
	public Ford_stock_distributor( int id )
	{
		super( id );
		name = "Ford stock distributor";
		description = "";
		brand_new_prestige_value = 21.37;

		value = tHUF2USD(21.085);
		setMaxWear(kmToMaxWear(400000.0));

		check4warnings();
	}
}
