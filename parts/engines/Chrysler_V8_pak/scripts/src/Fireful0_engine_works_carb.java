package java.game.parts.engines.Chrysler_V8_pak;

import java.game.parts.*;
import java.game.parts.enginepart.airfueldeliverysystem.*;
import java.game.cars.*;


public class Fireful0_engine_works_carb extends FuelInjectorSystem
{
	public Fireful0_engine_works_carb( int id )
	{
		super( id );
		name = "Fireful0's Engine Works 4 Barrel Carburetor";
		description = "Made by hand by Fireful0. Completely Tunable!";
		brand_new_prestige_value = 58.53;

		value = tHUF2USD(128.047);
		setMaxWear(kmToMaxWear(390000.0));

		mixture_ratio		= 12.5;
		max_fuel_consumption	= 0.06;
		fuel_type		= FT_GAS_95;
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

	public void addStockParts( Descriptor desc )
	{
		super.addStockParts( desc );

		getCar_LocalVersion();

		if (the_car.make == the_car.MAKE_HAULER_S_HEAVEN)
		{
			if (the_car.model == Hauler_s_models.MODEL_SUPERDUTY_500)
			{
				addPart( parts.engines.MC_Prime_SuperDuty:0x000000A5r, "SuperDuty_airbox", desc );
			}
			else
			if (the_car.model == Hauler_s_models.MODEL_SUPERDUTY_EXTRA_750)
			{
				addPart( parts.engines.MC_Prime_SuperDuty:0x000000A5r, "SuperDuty_airbox", desc );
			}
		}
	}
}
