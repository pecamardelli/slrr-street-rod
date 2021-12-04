package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.airfueldeliverysystem.*;


public class Emer_GT_II_fuel_rail extends FuelInjectorSystem
{
	public Emer_GT_II_fuel_rail( int id )
	{
		super( id );
		name = "Emer MotorSport Nonus GT2 fuel-rail";
		description = "This unit injects 100 octane premium gas, up to nearly 1000 HP";
		brand_new_prestige_value = 140.51;

		value = tHUF2USD(6*25+35);
		setMaxWear(kmToMaxWear(380000.0));

		max_fuel_consumption	= 0.04;
		default_mixture_ratio	= 14.0;
		default_fuel_type	= FT_GAS_100;
		mixture_ratio		= default_mixture_ratio;
		fuel_type		= default_fuel_type;
		calcStuffs();

		check4warnings();
	}
}
