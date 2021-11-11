package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.*;
import java.game.parts.enginepart.airfueldeliverysystem.*;
import java.game.cars.*;


public class Ford_racing_4brl_intake_manifold_big_block extends IntakeManifold
{
	public Ford_racing_4brl_intake_manifold_big_block( int id )
	{
		super( id );
		name = "Ford Racing four-barrel intake manifold for big block";
		description = "Adaptable to 302, 332, 351, 390 and 460 cu.in. blocks.";
		brand_new_prestige_value = 96.01;

		value = tHUF2USD(105.535);
		setMaxWear(kmToMaxWear(426000.0));

		fuel_rail_slot_ID=7;

		efficiency = 1.05;

		check4warnings();
	}

	public void updatevariables()
	{
		mixture_ratio = 1.0;
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
			return "the engine is missing the carburetor.";
		
		return super.isDynoable();
	}
}
