package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.*;
import java.game.parts.enginepart.block.block_vee.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.*;
import java.game.cars.*;


public class Cobra_Jet_429_block extends Block_Vee_OHV
{
	public Cobra_Jet_429_block( int id )
	{
		super( id );
		name = "Ford Cobra Jet 429 V8 Block";
		description = "";

		brand_new_prestige_value = 79.86;
		value = tHUF2USD(500);
		setMaxWear(kmToMaxWear(620000.0));

		bore = 111.74;

		cylinder_length_from_top = 138.43;
		crank_center_to_cylinder_top = 284;

		crankshaft_slot_ID = 8;
		transmission_slot_ID = 5;
		//crankshaft_bearing_slot_ID = 99;
		oil_pan_slot_ID = 9;
		camshaft_slot_ID = 10;

		L_cylinder_head_slot_ID = 45;
		R_cylinder_head_slot_ID = 46;
		intake_manifold_slot_ID = 14;

		rpm_idle = 900.0;
		time_spark_min	= sparkAngleTo4cycleTime(325.0);
		time_spark_inc	= sparkAngleTo4cycleTime(340.0)-time_spark_min;
		time_spark_RPM0	= 2500;
		time_spark_RPM1	= 5000;
		RPM_limit	= 6000;

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
				tab.addItem(new ResourceRef(parts.engines.ford_v8s:0x00004418r), 3000.0,  750.0, 6000.0, 1.72, 1.72);	// 1800	RPM
				tab.addItem(new ResourceRef(parts.engines.ford_v8s:0x00004465r), 5000.0, 2500.0,15000.0, 1.92, 1.92);	// 5500 RPM
			}

			if (tab = the_car.getSfxTable(1))
			{
				tab.clear();
			}

			if (tab = the_car.getSfxTable(2))
			{
				tab.clear();
				tab.addItem(new ResourceRef(parts.engines.ford_v8s:0x00004409r), 1300.0,  500.0, 2300.0, 2.0, 2.5);		//  900	RPM
				tab.addItem(new ResourceRef(parts.engines.ford_v8s:0x00004430r), 4000.0, 1400.0, 6500.0, 2.7, 2.9);		// 2000	RPM
				tab.addItem(new ResourceRef(parts.engines.ford_v8s:0x00004455r), 5400.0, 4300.0, 10000.0, 2.5, 2.8);	// 4000	RPM
				the_car.setSfxExhaustMinVol(1.0);
			}
		}
	}
	
	public void addStockParts( Descriptor desc )
	{
		super.addStockParts( desc );
		
		float number;
		float number2;
		int charger = 0;
		int trickflow = 0;

		addPart( parts.engines.ford_v8s:0x0000B261r, "Cobra_Jet_429_crankshaft", desc );
		addPart( parts.engines.ford_v8s:0x00004B20r, "Cobra_Jet_429_crankshaft_timing_gear", desc );
		addPart( parts.engines.ford_v8s:0x0000F661r, "Cobra_Jet_429_connecting_rods", desc );
		addPart( parts.engines.ford_v8s:0x0000F761r, "Cobra_Jet_429_pistons", desc );
		
		number = random();
		
		if( number < 0.65 )
		{
			addPart( parts.engines.ford_v8s:0x0000E261r, "Cobra_Jet_429_camshaft", desc );
		}
		else
		{
			number2 = random();
			
			if ( number2 < 0.33 )
			{
				addPart( parts.engines.ford_v8s:0x000019B4r, "Ford_racing_camshaft_big_block_1", desc );
			}
			else if ( number2 < 0.66 )
			{
				addPart( parts.engines.ford_v8s:0x000029B4r, "Ford_racing_camshaft_big_block_2", desc );
			}
			else
			{
				addPart( parts.engines.ford_v8s:0x000039B4r, "Ford_racing_camshaft_big_block_3", desc );
			}
		}
		
		addPart( parts.engines.ford_v8s:0x00004B12r, "Cobra_Jet_429_camshaft_timing_gear", desc );
		addPart( parts.engines.ford_v8s:0x00004B16r, "Cobra_Jet_429_timing_chain", desc );
		addPart( parts.engines.ford_v8s:0x0000F361r, "Cobra_Jet_429_timing_cover", desc );
		addPart( parts.engines.ford_v8s:0x0000A261r, "Cobra_Jet_429_oil_pan", desc );
		addPart( parts.engines.ford_v8s:0x0000D261r, "FoMoCo_oil_filter", desc );
		addPart( parts.engines.ford_v8s:0x00004B32r, "Cobra_Jet_429_flywheel", desc );
		addPart( parts.engines.ford_v8s:0x00004B36r, "Cobra_Jet_429_clutch", desc );
		addPart( parts.engines.ford_v8s:0x0000F561r, "Cobra_Jet_429_pulley", desc );
		addPart( parts.engines.ford_v8s:0x0000F861r, "Cobra_Jet_429_water_pomp", desc );
		
		number = random();
		
		if( number < 0.5 )
		{
			addPart( parts.engines.ford_v8s:0x0000F93Ar, "Cobra_Jet_429_left_cylinder_head", desc );
			addPart( parts.engines.ford_v8s:0x0000F961r, "Cobra_Jet_429_right_cylinder_head", desc );
		}
		else
		{
			addPart( parts.engines.ford_v8s:0x0000F99Ar, "Cobra_Jet_429_racing_left_cylinder_head", desc );
			addPart( parts.engines.ford_v8s:0x0000F99Br, "Cobra_Jet_429_racing_right_cylinder_head", desc );
		}
		
		number = random();
		
		if( number < 0.5 )
		{
			addPart( parts.engines.ford_v8s:0x00004B44r, "Cobra_Jet_429_left_exhaust_header", desc );
			addPart( parts.engines.ford_v8s:0x00004B40r, "Cobra_Jet_429_right_exhaust_header", desc );
		}
		else
		{
			addPart( parts.engines.ford_v8s:0x00004B87r, "Cobra_Jet_429_racing_left_exhaust_header", desc );
			addPart( parts.engines.ford_v8s:0x00004B83r, "Cobra_Jet_429_racing_right_exhaust_header", desc );
		}
		
		number = random();
		
		if( number < 0.5 )
		{
			addPart( parts.engines.ford_v8s:0x0000414Ar, "Cobra_Jet_429_left_cylinder_head_cover", desc );
			addPart( parts.engines.ford_v8s:0x00004B00r, "Cobra_Jet_429_right_cylinder_head_cover", desc );
		}
		else
		{
			addPart( parts.engines.ford_v8s:0x00004B48r, "Cobra_Jet_429_left_cylinder_head_cover_chrome", desc );
			addPart( parts.engines.ford_v8s:0x00004B52r, "Cobra_Jet_429_right_cylinder_head_cover_chrome", desc );
		}
		
		number = random();
		
		if( number < 0.5 )
		{
			addPart( parts.engines.ford_v8s:0x0000F261r, "Cobra_Jet_429_4brl_intake_manifold", desc );
		}
		else
		{
			addPart( parts.engines.ford_v8s:0x000048BEr, "Ford_supercharger_manifold_big_block", desc );
			addPart( parts.engines.ford_v8s:0x00009085r, "Edelbrock_supercharger_big_block", desc );
			addPart( parts.engines.ford_v8s:0x00009187r, "Edelbrock_supercharger_drive_belt_big_block", desc );
			charger = 1;
		}
	
		number = random();
	
		if ( charger == 1 )
		{
			number2 = random();
			
			if ( number2 < 0.5 )
			{
				addPart( parts.engines.ford_v8s:0x0000428Br, "Holley_2x4brl_carburetors", desc );
			}
			else if ( number2 < 0.75 )
			{
				addPart( parts.engines.ford_v8s:0x0000788Br, "Edelbrock_2x4brl_carburetors", desc );
			}
			else
			{
				addPart( parts.engines.ford_v8s:0x0000788Br, "Edelbrock_2x4brl_carburetors", desc );
			}
			
			addPart( parts.engines.ford_v8s:0x00009AA5r, "Motorcraft_2x4brl_blower", desc );
		}
		else
		{
			number2 = random();
			
			if( number2 < 0.7 )
			{
				addPart( parts.engines.ford_v8s:0x0000008Br, "carb_4brl", desc );
			}
			else
			{
				addPart( parts.engines.ford_v8s:0x0000388Br, "Holley_street_4brl_carburetor", desc );
			}
			
			number2 = random();
		
			if( number2 < 0.3 )
			{
				addPart( parts.engines.ford_v8s:0x00000886r, "Edelbrock_4brl_air_filter", desc );
			}
			else if( number2 < 0.6 )
			{
				addPart( parts.engines.ford_v8s:0x00000816r, "edelbrockracing_cleaner", desc );
			}
			else
			{
				addPart( parts.engines.ford_v8s:0x00008AA5r, "Motorcraft_4brl_blower", desc );
			}
		}
		
		number = random();
		
		if( number < 0.5 )
		{
			addPart( parts.engines.ford_v8s:0x0000004Ar, "Ford_ignition_distributor", desc );
		}
		else if( number < 0.78 )
		{
			addPart( parts.engines.ford_v8s:0x0000A811r, "malory_ignition", desc );
		}
		else
		{
			addPart( parts.engines.ford_v8s:0x0000074Ar, "Ford_racing_distributor", desc );
		}
		
		addPart( parts.engines.ford_v8s:0x0000F461r, "Cobra_Jet_429_alternator", desc );
		addPart( parts.engines.ford_v8s:0x00004B04r, "Cobra_Jet_429_alternator_drive_belt", desc );
		addPart( parts.engines.ford_v8s:0x00000097r, "Cobra_Jet_429_fan", desc );
		addPart( parts.engines.ford_v8s:0x00004B28r, "Cobra_Jet_429_radiator", desc );
		
		//////////////////
		// TRANSMISSION //
		//////////////////
		
		number = random();
		
		if( number < 0.45 )
		{
			number2 = random();
			
			if ( number2 < 0.68 )
			{
				addPart( parts.engines.ford_v8s:0x00004099r, "Tranny_borg_warner_super_t10_4spd", desc );
			}
			else
			{
				addPart( parts.engines.ford_v8s:0x00003099r, "Tranny_borg_warner_t10_4spd", desc );
			}
		}
		else
		{
			number2 = random();
			
			if ( number2 < 0.69 )
			{
				addPart( parts.engines.ford_v8s:0x00005899r, "Tranny_tremec_t45_5spd", desc );
			}
			else
			{
				addPart( parts.engines.ford_v8s:0x00000899r, "Tranny_tremec_t56_6spd", desc );
			}
		}
	}
	
	public String isDynoable()
	{
		Part p;
		
		p = partOnSlot( 10 );
		if (!p)
			return "the engine is missing the camshaft.";
		
		p = partOnSlot( 20 );
		if (!p)
			return "the engine is missing the alternator.";
		
		p = partOnSlot( 55 );
		if (!p)
			return "the engine is missing the oil filter.";
		
		p = partOnSlot( 56 );
		if (!p)
			return "the engine is missing the timing cover.";
		
		p = partOnSlot( 57 );
		if (!p)
			return "the engine is missing the water pomp.";
		
		p = partOnSlot( 58 );
		if (!p)
			return "the engine is missing the radiator.";
		
		p = partOnSlot( 59 );
		if (!p)
			return "the engine is missing the ignition distributor.";

		return super.isDynoable();
	}
}
