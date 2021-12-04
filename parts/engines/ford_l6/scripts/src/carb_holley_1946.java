package java.game.parts.engines.ford_l6;

import java.game.parts.*;
import java.game.parts.enginepart.airfueldeliverysystem.*;
import java.game.cars.*;


public class carb_holley_1946 extends FuelInjectorSystem
{
	public carb_holley_1946( int id )
	{
		super( id );
		name = "Holley 1946 single barrel carburetor";
		description = "";
		brand_new_prestige_value = 38.53;

		value = tHUF2USD(38.047);
		setMaxWear(kmToMaxWear(226000.0));

		mixture_ratio		= 13.5;
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
	
	public String isDynoable()
	{
		Part p;

		p = partOnSlot( 11 );
		if (!p)
			return "the engine is missing the air filter.";

		return super.isDynoable();
	}
}
