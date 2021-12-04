package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.airfueldeliverysystem.*;


public class Baiern_GT_III_fuel_rail extends FuelInjectorSystem
{
	public Baiern_GT_III_fuel_rail( int id )
	{
		super( id );
		name = "Baiern CoupeSport GT III fuel-rail";
		description = "This is the stock serial fuel injector railing for the 6-tunnel intake manifold. \n It has 6 injectors totalling a max delivery capacity of 450 lbs/hr, enough for about 900 HP.";

		value = tHUF2USD(6*22+35);
		brand_new_prestige_value = 63.87;
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
