package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.*;
import java.game.parts.enginepart.airfueldeliverysystem.*;
import java.game.cars.*;


public class Ford_supercharger_manifold_small_block extends IntakeManifold
{
	public Ford_supercharger_manifold_small_block( int id )
	{
		super( id );
		name = "Ford V8 supercharger manifold (260/292/332)";
		description = "";
		brand_new_prestige_value = 95.01;

		value = tHUF2USD(99.535);
		setMaxWear(kmToMaxWear(426000.0));

		fuel_rail_slot_ID=7;

		efficiency = 1;

		check4warnings();
	}

	public void updatevariables()
	{
		mixture_ratio = 1.08;
		max_fuel_consumption = 0.0;
		max_air_consumption = 0.3;
		mixture_H = 1.0;
		time_burn = 0.1;

		Part unsafePart;
		if ( (unsafePart = partOnSlot(7)) && unsafePart instanceof AirFuelDeliverySystem)
		{
			AirFuelDeliverySystem mixture_intake = unsafePart;

			mixture_intake.updatevariables();

			mixture_ratio = mixture_intake.mixture_ratio;
			max_fuel_consumption = mixture_intake.max_fuel_consumption;
			mixture_H = mixture_intake.mixture_H;
			time_burn = mixture_intake.time_burn;
		}
	}
	
	public String isDynoable()
	{
		Part p;

		p = partOnSlot( 7 );
		if (!p)          
			return "it's missing the supercharger.";
		
		return super.isDynoable();
	}
}
