package java.game.parts.engines.Chrysler_V8_pak;

import java.game.parts.*;
import java.game.parts.enginepart.airfueldeliverysystem.*;
import java.game.cars.*;


public class carter_4barrel_carb extends FuelInjectorSystem
{
	public carter_4barrel_carb( int id )
	{
		super( id );
		name = "Carter AVS 4 Barrel Carburetor";
		description = "3d model by FLED. Put in game by Fireful0.";
		brand_new_prestige_value = 45.45;

		value = tHUF2USD(208.25);
		setMaxWear(kmToMaxWear(390000.0));

		mixture_ratio		= 8.0;
		max_fuel_consumption	= 0.04;
		fuel_type		= FT_GAS_95;
		calcStuffs();

		check4warnings();
	}

	public int isTuneable()
	{
		return 1;

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
