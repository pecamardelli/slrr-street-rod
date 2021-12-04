package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.*;
import java.game.cars.*;

public class Baiern_90er_crankshaft extends Crankshaft
{
	public Baiern_90er_crankshaft( int id )
	{
		super( id );
		name = "Baiern Kraftwerk 2.5 crankshaft";
		description = "A medium heavy - 11.5 kgs (15.4 pounds) - and strong dinamically balanced 90.0 mm (3.94 inch) stroker crankshaft for the CoupeSport engines. \n Thanks to its almost perfect balance, this shaft withstands 8300 peak RPM. Some balancer can be dropped to fine tune the crank to be good for 9000-10000 peak RPM.";

		value = tHUF2USD(34);
		brand_new_prestige_value = 42.15;
		setMaxWear(kmToMaxWear(326000.0));

		con_rod_slot_ID = 9;
		flywheel_slot_ID = 37;

		stroke = 90.0;
		main_bearing_diam = 0.0;
		con_bearing_diam = 0.0;

		maxRPM = 9000.0;
		inertia = kgToInertia(11.500);

		check4warnings();
	}

	public void addStockParts( Descriptor desc )
	{
		super.addStockParts( desc );

		getCar_LocalVersion();

		if (the_car.make == the_car.MAKE_BAIERN)
		{
			if (the_car.model == Baiern_models.MODEL_COUPESPORT)
			{
				addPart( parts.engines.ford_l6:0x00000055r, "Baiern_Kraftwerk_2_5_connecting_rods", desc );
				addPart( parts.engines.ford_l6:0x00000045r, "Baiern_Kraftwerk_2_5_flywheel", desc );
			}
			else
			if (the_car.model == Baiern_models.MODEL_COUPESPORT_TURBO)
			{
				addPart( parts.engines.ford_l6:0x00000055r, "Baiern_Kraftwerk_2_5_connecting_rods", desc );
				addPart( parts.engines.ford_l6:0x00000045r, "Baiern_Kraftwerk_2_5_flywheel", desc );
			}
		}
	}
}
