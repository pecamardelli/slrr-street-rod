package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.cars.*;


public class ford_stock_plugs_and_wires extends EnginePart
{
	public ford_stock_plugs_and_wires( int id )
	{
		super( id );
		name = "Ford stock spark plugs and high voltage wires";
		description = "";
		brand_new_prestige_value = 21.37;

		value = tHUF2USD(9.085);
		setMaxWear(kmToMaxWear(100000.0));

		check4warnings();
	}
}
