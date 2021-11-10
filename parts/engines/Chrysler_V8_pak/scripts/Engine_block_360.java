package java.game.parts.engines.Crysler_V8_pak;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.*;
import java.game.parts.enginepart.block.block_vee.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.*;
import java.game.cars.*;


public class Engine_block_360 extends Block_Vee_OHV
{
	public Engine_block_360( int id )
	{
		super( id );
		name = "Chrysler LA 360 V8 engine Block 1971";
		description = "";

		brand_new_prestige_value = 80.85;
		value = tHUF2USD(170.90);
		setMaxWear(kmToMaxWear(500000.0));

		bore = 104.9;

		cylinder_length_from_top = 133.43;
		crank_center_to_cylinder_top = 280.60;

		camshaft_slot_ID = 10;

		crankshaft_slot_ID = 8;
		transmission_slot_ID = 5;
		oil_pan_slot_ID = 9;

		L_cylinder_head_slot_ID = 45;
		R_cylinder_head_slot_ID = 46;
		intake_manifold_slot_ID = 14;

		rpm_idle = 1200.0;
		time_spark_min	= sparkAngleTo4cycleTime(330.0);
		time_spark_inc	= sparkAngleTo4cycleTime(335.0)-time_spark_min;
		time_spark_RPM0	= 1500;
		time_spark_RPM1	= 4000;
		RPM_limit	= 5750;

		cylinders	= 8;

		check4warnings();
	}

	public void updatevariables()
	{
		super.updatevariables();

		if (the_car)
		{
			SfxTable tab;

			if (tab = the_car.getSfxTable(0))
			{
				tab.clear();
				tab.addItem(new ResourceRef(parts.engines.Crysler_V8_pak:0x000001A0r), 1100.0,  600.0, 2200.0, 0.40, 0.45);
				tab.addItem(new ResourceRef(parts.engines.Crysler_V8_pak:0x000002A2r), 2200.0, 1600.0, 3800.0, 0.45, 0.55);
				tab.addItem(new ResourceRef(parts.engines.Crysler_V8_pak:0x000003A4r), 3800.0, 2600.0, 5250.0, 0.55, 0.70);
				tab.addItem(new ResourceRef(parts.engines.Crysler_V8_pak:0x000004A9r), 5250.0, 4400.0, 6250.0, 0.70, 0.90);
				tab.addItem(new ResourceRef(parts.engines.Crysler_V8_pak:0x000005ABr), 6250.0, 5750.0, 9000.0, 0.90, 0.95);
			}

			if (tab = the_car.getSfxTable(1))
			{
				tab.clear();
			}

			if (tab = the_car.getSfxTable(2))
			{
				tab.clear();
				tab.addItem(new ResourceRef(parts.engines.Crysler_V8_pak:0x000001A0r), 1100.0*1,  600.0, 2200.0, 0.40, 0.45);
				tab.addItem(new ResourceRef(parts.engines.Crysler_V8_pak:0x000002A2r), 2200.0*1, 1600.0, 3800.0, 0.45, 0.55);
				tab.addItem(new ResourceRef(parts.engines.Crysler_V8_pak:0x000003A4r), 3800.0*1, 3000.0, 5250.0, 0.55, 0.70);
				tab.addItem(new ResourceRef(parts.engines.Crysler_V8_pak:0x000004A9r), 5250.0*1, 4400.0, 6250.0, 0.70, 0.90);
				tab.addItem(new ResourceRef(parts.engines.Crysler_V8_pak:0x000005ABr), 6250.0*1, 5750.0, 9000.0, 0.90, 0.95);
				the_car.setSfxExhaustMinVol(1.9);
			}
		}
	}


	public String isDynoable()
	{
		Part p;

	

		p = partOnSlot( 20 );
		if (!p)
			return "looks like you forget about alternator!";

		p = partOnSlot( 56 );
		if (!p)
			return "timing chain/belt cover missed.";

		p = partOnSlot( 55 );
		if (!p)
			return "oil filter missed.";

		p = partOnSlot( 58 );
		if (!p)
			return "looks like you forget about radiator!";

		p = partOnSlot( 56 );
		if (!p)
			return "timing cover missed.";

		p = partOnSlot( 57 );
		if (!p)
			return "water pump missed.";

		p = partOnSlot( 59 );
		if (!p)
			return "ignition distributor missed.";

		return super.isDynoable();
	}

	public String isDriveable()
	{
		Part p;

		p = partOnSlot( 20 );
		if (!p)
			return "looks like you forget about alternator!";

		p = partOnSlot( 56 );
		if (!p)
			return "timing chain/belt cover missed.";

		p = partOnSlot( 55 );
		if (!p)
			return "oil filter missed.";
	
		p = partOnSlot( 58 );
		if (!p)
			return "looks like you forget about radiator!";

		p = partOnSlot( 56 );
		if (!p)
			return "timing cover missed.";

		p = partOnSlot( 57 );
		if (!p)
			return "water pump missed.";

		p = partOnSlot( 59 );
		if (!p)
			return "ignition distributor missed.";

		return super.isDriveable();
	}

}
