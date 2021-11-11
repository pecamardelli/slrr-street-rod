package java.game.parts.engines.ford_v8s;

import java.game.parts.*;
import java.game.parts.enginepart.airfueldeliverysystem.*;
import java.game.cars.*;


public class Edelbrock_4brl_carburetor_2 extends FuelInjectorSystem
{
	public Edelbrock_4brl_carburetor_2( int id )
	{
		super( id );
		name = "Edelbrock Performer Marine series 600 CFM four-barrel carburetor";
		description = "";
		brand_new_prestige_value = 43.53;

		value = tHUF2USD(60);
		setMaxWear(kmToMaxWear(226000.0));

		mixture_ratio		= 13.6;
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
