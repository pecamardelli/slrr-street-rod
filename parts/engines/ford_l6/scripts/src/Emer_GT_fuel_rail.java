package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.airfueldeliverysystem.*;


public class Emer_GT_fuel_rail extends FuelInjectorSystem
{
	public Emer_GT_fuel_rail( int id )
	{
		super( id );
		name = "Emer Nonus StreetGT fuel-rail";
		description = "";
		brand_new_prestige_value = 48.01;

		value = tHUF2USD(6*7+15);
		setMaxWear(kmToMaxWear(380000.0));

		max_fuel_consumption	= 0.03;
		default_mixture_ratio	= 13.0;
		default_fuel_type	= FT_GAS_98;
		mixture_ratio		= default_mixture_ratio;
		fuel_type		= default_fuel_type;
		calcStuffs();

		check4warnings();
	}
}
