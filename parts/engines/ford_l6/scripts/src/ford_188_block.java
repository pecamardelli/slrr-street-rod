package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.*;
import java.game.parts.enginepart.block.block_inline.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.*;
import java.game.cars.*;


public class ford_188_block extends Block_Inline_OHV
{
	public ford_188_block( int id )
	{		
		super( id );
		name = "Ford 188 cu.in. engine block";
		description = "Cast iron block. The best attribute of this block is durability. Bore: 93.47 mm.";

		value = tHUF2USD(74);
		brand_new_prestige_value = 38.32;
		setMaxWear(kmToMaxWear(626000.0));

		bore = 93.47;

		cylinder_length_from_top = 172.14;
		crank_center_to_cylinder_top = 207.13;

		crankshaft_slot_ID = 33;
		transmission_slot_ID = 35;
		crankshaft_bearing_slot_ID = 41;
		oil_pan_slot_ID = 31;
		camshaft_slot_ID = 10;
		camshaft_bearing_slot_ID = 0;

		cylinder_head_slot_ID = 19;

		rpm_idle = 900.0;
		time_spark_min	= sparkAngleTo4cycleTime(325.0);
		time_spark_inc	= sparkAngleTo4cycleTime(340.0)-time_spark_min;
		time_spark_RPM0	= 1500;
		time_spark_RPM1	= 4000;
		RPM_limit	= 5000;

		cylinders	= 6;
	}

	public void updatevariables()
	{
		super.updatevariables();

		if (the_car)
		{
			the_car.starter_torque = 30.0;

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

	public String isDynoable()
	{
		Part p;

		p = partOnSlot( 32 );
		if (!p)
			return "the engine is missing the alternator.";
		
		p = partOnSlot( 56 );
		if (!p)
			return "the engine is missing the timing cover.";
		
		p = partOnSlot( 57 );
		if (!p)
			return "the engine is missing the fuel pump.";
		
		p = partOnSlot( 58 );
		if (!p)
			return "the engine is missing the distributor.";
		
		p = partOnSlot( 59 );
		if (!p)
			return "the engine is missing the ignition coil.";
		
		p = partOnSlot( 60 );
		if (!p)
			return "the engine is missing the water pump.";
		
		p = partOnSlot( 61 );
		if (!p)
			return "the engine is missing the radiator.";
		
		p = partOnSlot( 62 );
		if (!p)
			return "the engine is missing the starter.";

		return super.isDynoable();
	}
}
