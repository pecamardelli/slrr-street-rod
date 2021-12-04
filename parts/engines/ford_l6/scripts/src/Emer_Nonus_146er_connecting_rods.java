package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.*;
import java.game.cars.*;

public class Emer_Nonus_146er_connecting_rods extends ConnectingRod
{
	public Emer_Nonus_146er_connecting_rods( int id )
	{
		super( id );
		name = "Emer Nonus StreetGT connecting rods";
		description = "";
		brand_new_prestige_value = 40.01;

		value = tHUF2USD(6*6);
		setMaxWear(kmToMaxWear(348000.0));

		piston_slot_ID = 39;

		length = 160.0;

		maxRPM = 16000.0;
		inertia = kgToInertia(6*0.350);

		check4warnings();
	}

	public void addStockParts( Descriptor desc )
	{
		super.addStockParts( desc );

		getCar_LocalVersion();

		if (the_car.make == the_car.MAKE_EMER)
		{
			if (the_car.model == Emer_models.MODEL_NONUS_STREET_GT)
			{
				addPart( parts.engines.ford_l6:0x00000095r, "Emer_Nonus_StreetGT_pistons", desc );
			}
		}
	}
}
