package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.cars.*;


public class ford_stock_fuel_pump extends EnginePart
{
	public ford_stock_fuel_pump( int id )
	{
		super( id );
		name = "Ford stock fuel pump";
		description = "";

		value = tHUF2USD(16);
		brand_new_prestige_value = 44.71;
		setMaxWear(kmToMaxWear(205000.0));

		check4warnings();
	}
}