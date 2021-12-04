package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.*;
import java.game.parts.enginepart.block.block_inline.*;
import java.game.cars.*;


public class Emer_MotorSport_GT2_block extends Block_Inline_OHC
{
	public Emer_MotorSport_GT2_block( int id )
	{
		super( id );
		name = "Emer MotorSport GT2 engine block";
		description = "";
		brand_new_prestige_value = 132.03;

		value = tHUF2USD(517.711);
		setMaxWear(kmToMaxWear(420000.0));

		bore = 90.0;

		crankshaft_slot_ID = 33;
		crankshaft_bearing_slot_ID = 41;
		cylinder_head_slot_ID = 19;
		transmission_slot_ID = 35;
		oil_pan_slot_ID = 31;

		cylinder_length_from_top = 177.44;
		crank_center_to_cylinder_top = 222.23;

		rpm_idle = 1500.0;
		time_spark_min	= sparkAngleTo4cycleTime(330.0);
		time_spark_inc	= sparkAngleTo4cycleTime(365.0)-time_spark_min;
		time_spark_RPM0	= 2500;
		time_spark_RPM1	= 9500;
		RPM_limit	= 10000;

		cylinders	= 6;

		check4warnings();
	}

	public void updatevariables()
	{
		super.updatevariables();

		dynodata.cylinders	= 6;

		if (the_car)
		{
			the_car.starter_torque = 40.0;

			SfxTable tab;
			if (tab = the_car.getSfxTable(0))
			{
				tab.clear();
				tab.addItem(new ResourceRef(parts.engines.ford_l6:0x000000A2r), 3500.0,  500.0, 6500.0, 0.42, 0.52);
				tab.addItem(new ResourceRef(parts.engines.ford_l6:0x000000AAr), 5000.0, 3000.0,18000.0, 0.62, 1.00);
			}

			if (tab = the_car.getSfxTable(1))
			{
				tab.clear();
			}

			if (tab = the_car.getSfxTable(2))
			{
				tab.clear();
				tab.addItem(new ResourceRef(parts.engines.ford_l6:0x000000ABr), 1500.0,  750.0, 2500.0, 1.0, 1.0);
				tab.addItem(new ResourceRef(parts.engines.ford_l6:0x000000ADr), 3000.0, 1500.0, 6200.0, 1.0, 1.0);
				tab.addItem(new ResourceRef(parts.engines.ford_l6:0x000000B1r), 6200.0, 4000.0, 18000.0, 0.7, 0.2);
				the_car.setSfxExhaustMinVol(0.6);
			}
		}
	}

	public void addStockParts( Descriptor desc )
	{
		super.addStockParts( desc );

		getCar_LocalVersion();

		if (the_car.make == the_car.MAKE_EMER)
		{
			if (the_car.model == Emer_models.MODEL_MOTORSPORT_NONUS_GT2)
			{
				addPart( parts.engines.ford_l6:0x00000080r, "Emer_MotorSport_GT2_84er_crankshaft", desc );
				addPart( parts.engines.ford_l6:0x0000004Er, "Baiern_crankshaft_bearing_bridge", desc );
				addPart( parts.engines.ford_l6:0x00000082r, "Emer_MotorSport_GT2_cylinder_head", desc );
				addPart( parts.engines.ford_l6:0x00000085r, "Emer_MotorSport_GT2_transmission", desc );
				addPart( parts.engines.ford_l6:0x00000084r, "Emer_oil_pan", desc );
				addPart( parts.engines.ford_l6:0x00000086r, "Emer_alternator", desc );
			}
		}
	}

	public String isDynoable()
	{
		Part p;

		p = partOnSlot( 32 );
		if (!p)
			return "the engine is missing the alternator.";

		return super.isDynoable();
	}
}
