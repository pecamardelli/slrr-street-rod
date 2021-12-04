package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.*;
import java.game.cars.*;


public class Emer_MotorSport_GT2_84er_crankshaft extends Crankshaft
{
	public Emer_MotorSport_GT2_84er_crankshaft( int id )
	{
		super( id );
		name = "Emer MotorSport Nonus GT2 crankshaft";
		description = "";
		brand_new_prestige_value = 28.81;

		value = tHUF2USD(133.515);
		setMaxWear(kmToMaxWear(526000.0));

		con_rod_slot_ID = 9;
		flywheel_slot_ID = 37;

		stroke = 83.8;
		main_bearing_diam = 0.0;
		con_bearing_diam = 0.0;

		maxRPM = 15000.0;
		inertia = kgToInertia(10.000);

		check4warnings();
	}

	public void addStockParts( Descriptor desc )
	{
		super.addStockParts( desc );

		getCar_LocalVersion();

		if (the_car.make == the_car.MAKE_EMER)
		{
			if (the_car.model == Emer_models.MODEL_MOTORSPORT_NONUS_GT2)
			{
				addPart( parts.engines.ford_l6:0x00000093r, "Emer_Nonus_136er_connecting_rods", desc );
				addPart( parts.engines.ford_l6:0x0000000Ar, "Baiern_Devils_6SFi_3_6_flywheel", desc );
					addPart( parts.engines.ford_l6:0x00000043r, "Baiern_Kraftwerk_clutch", desc ); // utolagos felszereles, hogy ne kelljen elronditani a Baiern motor addStockParts-at - Sala //
			}
		}
	}
}
