package java.game.parts.engines.ford_l6;

import java.game.parts.*;
import java.game.parts.enginepart.airfueldeliverysystem.*;
import java.game.cars.*;


public class carb_holley_2300 extends FuelInjectorSystem
{
	public carb_holley_2300( int id )
	{
		super( id );
		name = "Holley 2300 two barrel Carburetor";
		description = "";
		brand_new_prestige_value = 38.53;

		value = tHUF2USD(68.047);
		setMaxWear(kmToMaxWear(226000.0));

		mixture_ratio		= 13.5;
		max_fuel_consumption	= 0.07;
		fuel_type		= FT_GAS_98;
		calcStuffs();

		check4warnings();
	}

	public void updatevariables()
	{
		max_air_consumption	= 0.7;

		Part unsafePart;
		if ( (unsafePart = partOnSlot(11)) && unsafePart instanceof AirFilter )
		{
			AirFilter air_intake = unsafePart;

			air_intake.updatevariables();

			max_air_consumption = air_intake.max_air_consumption;
		}

		super.updatevariables();
	}
	
	public String isDynoable()
	{
		Part p;

		p = partOnSlot( 11 );
		if (!p)
			return "the engine is missing the air filter.";

		return super.isDynoable();
	}
}
