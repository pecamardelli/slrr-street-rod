package java.game.parts.engines.ford_v8s;

import java.game.parts.*;
import java.game.parts.enginepart.airfueldeliverysystem.*;
import java.game.cars.*;


public class Holley_street_4brl_carburetor extends FuelInjectorSystem
{
	public Holley_street_4brl_carburetor( int id )
	{
		super( id );
		name = "Holley Street four-barrel carburetor";
		description = "Maximized fuel consumption and 100-octane gas capable.";
		brand_new_prestige_value = 39.53;

		value = tHUF2USD(105.047);
		setMaxWear(kmToMaxWear(226000.0));

		mixture_ratio		= 13.5;
		max_fuel_consumption	= 0.07;
		fuel_type		= FT_GAS_100;
		calcStuffs();

		check4warnings();
	}

	public void updatevariables()
	{
		max_air_consumption	= 0.6;

		Part unsafePart;
		if ( (unsafePart = partOnSlot(11)) && unsafePart instanceof AirFilter )
		{
			AirFilter air_intake = unsafePart;

			air_intake.updatevariables();

			max_air_consumption = air_intake.max_air_consumption;
		}

		super.updatevariables();
	}
}
