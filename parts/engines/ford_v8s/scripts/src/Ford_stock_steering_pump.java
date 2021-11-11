package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.cylinderhead.*;
import java.game.cars.*;


public class Ford_stock_steering_pump extends EnginePart
{
	public Ford_stock_steering_pump( int id )
	{
		super( id );
		name = "Ford stock steering pump";
		description = "";
		brand_new_prestige_value = 35.67;

		value = tHUF2USD(45.512);
		setMaxWear(kmToMaxWear(311000.0));

		check4warnings();
	}
}
