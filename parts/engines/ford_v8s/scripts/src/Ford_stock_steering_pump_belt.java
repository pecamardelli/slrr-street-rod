package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.cars.*;


public class Ford_stock_steering_pump_belt extends EnginePart
{
	public Ford_stock_steering_pump_belt( int id )
	{
		super( id );
		name = "Ford stock steering pump belt";
		description = "";
		brand_new_prestige_value = 15.73;

		value = tHUF2USD(15.902);
		setMaxWear(kmToMaxWear(400000.0));

		check4warnings();
	}
}
