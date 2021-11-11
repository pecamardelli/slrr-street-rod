package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.cars.*;


public class Ford_stock_alternator extends EnginePart
{
	public Ford_stock_alternator( int id )
	{
		super( id );
		name = "Ford stock alternator";
		description = "";
		brand_new_prestige_value = 24.37;

		value = tHUF2USD(25.085);
		setMaxWear(kmToMaxWear(400000.0));

		check4warnings();
	}
}
