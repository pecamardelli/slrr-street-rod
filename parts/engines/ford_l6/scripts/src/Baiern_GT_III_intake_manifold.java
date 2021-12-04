package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.*;
import java.game.parts.enginepart.airfueldeliverysystem.*;
import java.game.cars.*;


public class Baiern_GT_III_intake_manifold extends IntakeManifold
{
	public Baiern_GT_III_intake_manifold( int id )
	{
		super( id );
		name = "Baiern CoupeSport GT III intake manifold";
		description = "This is an improved version of the stock Kraftwerk 2.5 intake. Designed for the GT III racecar, this is a masterpiece of air flow dynamics. This unit has a very low air restriction coefficient thanks to the finely welded and glued parts. It's relatively fragile.";

		value = tHUF2USD(255);
		brand_new_prestige_value = 153.28;
		setMaxWear(kmToMaxWear(400000.0));

		fuel_rail_slot_ID=10;

		efficiency = 0.91;

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
		if ( (unsafePart = partOnSlot(10)) && unsafePart instanceof AirFuelDeliverySystem)
		{
			AirFuelDeliverySystem mixture_intake = unsafePart;

			mixture_intake.updatevariables();

			mixture_ratio = mixture_intake.mixture_ratio;
			max_fuel_consumption = mixture_intake.max_fuel_consumption;
			mixture_H = mixture_intake.mixture_H;
			time_burn = mixture_intake.time_burn;
		}

		if ( (unsafePart = partOnSlot(30)) && unsafePart instanceof NOSInjectorSystem)
		{
			NOSInjectorSystem nos_intake = unsafePart;

			nos_intake.updatevariables();

			nitro_H = nos_intake.nitro_H;
			nitro_cooling = nos_intake.nitro_cooling;
			nitro_consumption = nos_intake.nitro_consumption;
			nitro_minRPM = nos_intake.nitro_minRPM;
			nitro_maxRPM = nos_intake.nitro_maxRPM;
			nitro_minThrottle = nos_intake.nitro_minThrottle;
		}
	}

	public void addStockParts( Descriptor desc )
	{
		super.addStockParts( desc );

		getCar_LocalVersion();

		if (the_car.make == the_car.MAKE_BAIERN)
		{
			if (the_car.model == Baiern_models.MODEL_COUPESPORT_GT_III)
			{
				FuelInjectorSystem fr = addPart( parts.engines.ford_l6:0x0000004Br, "Baiern_Kraftwerk_2_5_fuel_rail", desc );
				if (fr)
					fr.randomizeMixtureRatio(desc.power);
			}
		}
	}
}
