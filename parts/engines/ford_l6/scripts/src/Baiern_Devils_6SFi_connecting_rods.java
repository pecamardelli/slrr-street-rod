package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.*;
import java.game.cars.*;

public class Baiern_Devils_6SFi_connecting_rods extends ConnectingRod
{
	public Baiern_Devils_6SFi_connecting_rods( int id )
	{
		super( id );
		name = "Baiern Devils 6SFi 3.6 connecting rods";
		description = "These high durability lightened steel rods weigh 350 grams (12.3 ounces) per piece and come in a pack of 6. \n The length is 132.5 mm (5.22 inch) to assure compatiblity with its CoupeSport ancestor. Can be built into the engine with both short and high pistons from 50.0 mm (1.97 inch) to 90.0 mm (3.54 inch).";

		value = tHUF2USD(6*6);
		brand_new_prestige_value = 63.87;
		setMaxWear(kmToMaxWear(348000.0));

		piston_slot_ID = 39;

		length = 132.5;

		maxRPM = 10000.0;
		inertia = kgToInertia(6*0.350);

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
				addPart( parts.engines.ford_l6:0x00000057r, "Baiern_Devils_6SFi_HC_pistons", desc );
			}
			else
			if (the_car.model == Baiern_models.MODEL_DEVILSPORT)
			{
				addPart( parts.engines.ford_l6:0x00000057r, "Baiern_Devils_6SFi_HC_pistons", desc );
			}
			else
			if (the_car.model == Baiern_models.MODEL_DEVILSPORT_TURBO)
			{
				addPart( parts.engines.ford_l6:0x00000057r, "Baiern_Devils_6SFi_HC_pistons", desc );
			}
			else
			if (the_car.model == Baiern_models.MODEL_DEVILSPORT_BITURBO)
			{
				addPart( parts.engines.ford_l6:0x00000057r, "Baiern_Devils_6SFi_HC_pistons", desc );
			}
		}
	}
}
