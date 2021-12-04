package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.*;
import java.game.cars.*;


public class Baiern_Devils_6SFi_3_6_flywheel extends Flywheel
{
	public Baiern_Devils_6SFi_3_6_flywheel( int id )
	{
		super( id );
		name = "Baiern Devils 6SFi 3.6 flywheel";
		description = "This flywheel is heavy - 10.5 kgs (23.1 pounds) - for racing, but it's surface was redesigned to get the most out of the so well designed and light factory clutches.";

		value = tHUF2USD(80);
		brand_new_prestige_value = 51.09;
		setMaxWear(kmToMaxWear(760000.0));

		clutch_slot_ID = 36;

		maxRPM = 12000.0;
		inertia = kgToInertia(10.5);

		check4warnings();
	}

	public void addStockParts( Descriptor desc )
	{
		super.addStockParts( desc );

		getCar_LocalVersion();

		if (the_car.make == the_car.MAKE_BAIERN)
		{
			if (the_car.model == Baiern_models.MODEL_COUPESPORT_GT_III)
			{
				addPart( parts.engines.ford_l6:0x00000043r, "Baiern_Kraftwerk_clutch", desc );
			}
			else
			if (the_car.model == Baiern_models.MODEL_DEVILSPORT)
			{
				addPart( parts.engines.ford_l6:0x00000043r, "Baiern_Kraftwerk_clutch", desc );
			}
			else
			if (the_car.model == Baiern_models.MODEL_DEVILSPORT_TURBO)
			{
				addPart( parts.engines.ford_l6:0x00000043r, "Baiern_Kraftwerk_clutch", desc );
			}
			else
			if (the_car.model == Baiern_models.MODEL_DEVILSPORT_BITURBO)
			{
				addPart( parts.engines.ford_l6:0x00000043r, "Baiern_Kraftwerk_clutch", desc );
			}
		}
	}
}
