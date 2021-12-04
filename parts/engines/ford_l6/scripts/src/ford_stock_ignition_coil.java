package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.cars.*;


public class ford_stock_ignition_coil extends EnginePart
{
	public ford_stock_ignition_coil( int id )
	{
		super( id );
		name = "Ford stock 28000 volt ignition coil";
		description = "";
		brand_new_prestige_value = 21.37;

		value = tHUF2USD(15.085);
		setMaxWear(kmToMaxWear(400000.0));

		check4warnings();
	}
}
