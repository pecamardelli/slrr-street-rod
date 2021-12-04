package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.*;
import java.game.parts.enginepart.block.block_inline.*;
import java.game.cars.*;


public class Baiern_Devils_6SFi_3_6_block extends Block_Inline_OHC
{
	public Baiern_Devils_6SFi_3_6_block( int id )
	{
		super( id );
		name = "Baiern Devils 6SFi 3.6 block";
		description = "DevilSport models use this block as the base of their engines. \n As these blocks are mechanically 100% compatible with the Baiern Kraftwerk 2.5 engine block, these can replace the stock blocks in all Baiern models and also all compatible with those. \n It's bored to 93.0 mm (3.66 inch) and support a maximum stroke of 95.0 mm (3.74 inch).";

		value = tHUF2USD(190);
		brand_new_prestige_value = 76.64;
		setMaxWear(kmToMaxWear(420000.0));

		bore = 93.0;

		crankshaft_slot_ID = 33;
		crankshaft_bearing_slot_ID = 41;
		cylinder_head_slot_ID = 19;
		transmission_slot_ID = 35;
		oil_pan_slot_ID = 31;

		cylinder_length_from_top = 177.44;
		crank_center_to_cylinder_top = 222.23;

		rpm_idle = 1000.0;
		time_spark_min	= sparkAngleTo4cycleTime(318.0);
		time_spark_inc	= sparkAngleTo4cycleTime(340.0)-time_spark_min;
		time_spark_RPM0	= 3250;
		time_spark_RPM1	= 6250;
		RPM_limit	= 7250;

		cylinders	= 6;

		check4warnings();
	}

	public void updatevariables()
	{
		super.updatevariables();

		if (the_car)
		{
			the_car.starter_torque = 40.0;

			SfxTable tab;
			if (tab = the_car.getSfxTable(0))
			{
				tab.clear();
				tab.addItem(new ResourceRef(parts.engines.ford_l6:0x000000A2r), 3500.0,  500.0, 6500.0, 0.42, 0.42);
				tab.addItem(new ResourceRef(parts.engines.ford_l6:0x000000AAr), 5000.0, 3000.0,18000.0, 0.42, 0.42);
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
				tab.addItem(new ResourceRef(parts.engines.ford_l6:0x000000B1r), 6200.0, 4000.0, 18000.0, 1.0, 0.7);
				the_car.setSfxExhaustMinVol(0.6);
			}
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
				rpm_idle = 1250.0;
				time_spark_min	= sparkAngleTo4cycleTime(399.0);
				time_spark_inc	= sparkAngleTo4cycleTime(363.0)-time_spark_min;
				time_spark_RPM0	= 2250;
				time_spark_RPM1	= 7250;
				RPM_limit	= 8500;

				addPart( parts.engines.ford_l6:0x00000044r, "Baiern_88er_crankshaft", desc );
				addPart( parts.engines.ford_l6:0x0000004Er, "Baiern_crankshaft_bearing_bridge", desc );
				addPart( parts.engines.ford_l6:0x00000042r, "Baiern_Devils_6SFi_cylinder_head", desc );
				addPart( parts.engines.ford_l6:0x0000000Br, "Baiern_Devils_RaceMan6_transmission", desc );
				addPart( parts.engines.ford_l6:0x00000049r, "Baiern_oil_pan", desc );
				addPart( parts.engines.ford_l6:0x0000004Dr, "Baiern_alternator", desc );
			}
			else
			if (the_car.model == Baiern_models.MODEL_DEVILSPORT)
			{
				addPart( parts.engines.ford_l6:0x00000044r, "Baiern_88er_crankshaft", desc );
				addPart( parts.engines.ford_l6:0x0000004Er, "Baiern_crankshaft_bearing_bridge", desc );
				addPart( parts.engines.ford_l6:0x00000042r, "Baiern_Devils_6SFi_cylinder_head", desc );
				addPart( parts.engines.ford_l6:0x000000BCr, "Baiern_Devils_Tourist6_transmission", desc );
				addPart( parts.engines.ford_l6:0x00000049r, "Baiern_oil_pan", desc );
				addPart( parts.engines.ford_l6:0x0000004Dr, "Baiern_alternator", desc );
			}
			else
			if (the_car.model == Baiern_models.MODEL_DEVILSPORT_TURBO)
			{
				addPart( parts.engines.ford_l6:0x00000044r, "Baiern_88er_crankshaft", desc );
				addPart( parts.engines.ford_l6:0x0000004Er, "Baiern_crankshaft_bearing_bridge", desc );
				addPart( parts.engines.ford_l6:0x00000042r, "Baiern_Devils_6SFi_cylinder_head", desc );
				addPart( parts.engines.ford_l6:0x000000BCr, "Baiern_Devils_Tourist6_transmission", desc );
				addPart( parts.engines.ford_l6:0x00000049r, "Baiern_oil_pan", desc );
				addPart( parts.engines.ford_l6:0x0000004Dr, "Baiern_alternator", desc );
			}
			else
			if (the_car.model == Baiern_models.MODEL_DEVILSPORT_BITURBO)
			{
				addPart( parts.engines.ford_l6:0x00000044r, "Baiern_88er_crankshaft", desc );
				addPart( parts.engines.ford_l6:0x0000004Er, "Baiern_crankshaft_bearing_bridge", desc );
				addPart( parts.engines.ford_l6:0x00000042r, "Baiern_Devils_6SFi_cylinder_head", desc );
				addPart( parts.engines.ford_l6:0x000000BCr, "Baiern_Devils_Tourist6_transmission", desc );
				addPart( parts.engines.ford_l6:0x00000049r, "Baiern_oil_pan", desc );
				addPart( parts.engines.ford_l6:0x0000004Dr, "Baiern_alternator", desc );
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
