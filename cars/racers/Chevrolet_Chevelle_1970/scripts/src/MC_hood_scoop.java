package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.enginepart.airfueldeliverysystem.*;


public class MC_hood_scoop extends AirFilter
{
	public MC_hood_scoop( int id )
	{
		super( id );
		carCategory = COMMON;

		name = "Chevrolet Chevelle hood scoop";
		description = "";

		value = tHUF2USD(50.206);
		brand_new_prestige_value = 42.49;

		stock_max_air_consumption = 0.5;
		setMaxWear(500000.0);
		dusted_efficiency = 0.90;

		check4warnings();
	}
}
