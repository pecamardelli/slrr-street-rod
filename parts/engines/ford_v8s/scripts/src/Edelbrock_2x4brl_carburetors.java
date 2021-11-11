package java.game.parts.engines.ford_v8s;

import java.game.parts.*;
import java.game.parts.enginepart.airfueldeliverysystem.*;
import java.game.cars.*;


public class Edelbrock_2x4brl_carburetors extends FuelInjectorSystem
{
	public Edelbrock_2x4brl_carburetors( int id )
	{
		super( id );
		name = "Edelbrock Performer series 500 CFM dual four-barrel carburetors";
		description = "";
		brand_new_prestige_value = 62.53;

		value = tHUF2USD(100);
		setMaxWear(kmToMaxWear(326000.0));

		mixture_ratio		= 13.5;
		max_fuel_consumption	= 0.14;
		fuel_type		= FT_GAS_100;
		calcStuffs();

		check4warnings();
	}

	public void updatevariables()
	{
		max_air_consumption	= 0.9;

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
