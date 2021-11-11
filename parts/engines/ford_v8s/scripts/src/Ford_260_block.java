package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.*;
import java.game.parts.enginepart.block.block_vee.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.*;
import java.game.cars.*;


public class Ford_260_block extends Block_Vee_OHV
{
	public Ford_260_block( int id )
	{
		super( id );
		name = "Ford 260 Block";
		description = "";

		brand_new_prestige_value = 45.86;
		value = tHUF2USD(150);
		setMaxWear(kmToMaxWear(720000.0));

		bore = 96.52;

		cylinder_length_from_top = 130.43;
		crank_center_to_cylinder_top = 274.20;

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
		time_spark_RPM1	= 9000;
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
				tab.addItem(new ResourceRef(parts.engines.ford_v8s:0x00003418r), 3500.0,  500.0, 6500.0, 1.72, 1.72);
				tab.addItem(new ResourceRef(parts.engines.ford_v8s:0x00003455r), 5000.0, 3000.0,18000.0, 1.92, 1.92);
			}

			if (tab = the_car.getSfxTable(1))
			{
				tab.clear();
			}

			if (tab = the_car.getSfxTable(2))
			{
				tab.clear();
				tab.addItem(new ResourceRef(parts.engines.ford_v8s:0x00003409r), 1500.0,  750.0, 2500.0, 2.0, 2.5);		//  900	RPM
				tab.addItem(new ResourceRef(parts.engines.ford_v8s:0x00003430r), 3000.0, 1500.0, 5200.0, 2.3, 2.7);		// 2000	RPM
				tab.addItem(new ResourceRef(parts.engines.ford_v8s:0x00003455r), 4500.0, 4000.0, 18000.0, 2.5, 3.0);	// 4000	RPM
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

		addPart( parts.engines.ford_v8s:0x000080FEr, "Ford_260_crankshaft", desc );
		addPart( parts.engines.ford_v8s:0x000000BBr, "Ford_stock_crankshaft_timing_gear", desc );
		addPart( parts.engines.ford_v8s:0x000080A8r, "Ford_260_connecting_rods", desc );
		addPart( parts.engines.ford_v8s:0x00000056r, "Ford_260_292_312_pistons", desc );
		
		number = random();
		
		if( number < 0.7 )
		{
			addPart( parts.engines.ford_v8s:0x00008051r, "Ford_260_camshaft", desc );
		}
		else
		{
			number2 = random();
			
			if ( number2 < 0.33 )
			{
				addPart( parts.engines.ford_v8s:0x000010B4r, "Ford_racing_camshaft_small_block_1", desc );
			}
			else if ( number2 < 0.66 )
			{
				addPart( parts.engines.ford_v8s:0x000020B4r, "Ford_racing_camshaft_small_block_2", desc );
			}
			else
			{
				addPart( parts.engines.ford_v8s:0x000050B4r, "Ford_racing_camshaft_small_block_3", desc );
			}			
		}	
		
		addPart( parts.engines.ford_v8s:0x000000BAr, "Ford_stock_camshaft_timing_gear", desc );
		addPart( parts.engines.ford_v8s:0x0000004Fr, "Ford_stock_timing_chain", desc );
		addPart( parts.engines.ford_v8s:0x000080B5r, "Ford_260_timing_cover", desc );
		addPart( parts.engines.ford_v8s:0x00008095r, "Ford_260_oil_pan", desc );
		addPart( parts.engines.ford_v8s:0x00000048r, "Motorcraft_oil_filter", desc );
		addPart( parts.engines.ford_v8s:0x00008083r, "Ford_260_flywheel", desc );
		addPart( parts.engines.ford_v8s:0x00008084r, "Ford_260_clutch", desc );
		addPart( parts.engines.ford_v8s:0x0000809Br, "Ford_260_pulley", desc );
		addPart( parts.engines.ford_v8s:0x00008052r, "Ford_260_water_pomp", desc );
		
		number = random();
		
		if( number < 0.7 )
		{
			addPart( parts.engines.ford_v8s:0x000080ADr, "Ford_260_left_cylinder_head", desc );
			addPart( parts.engines.ford_v8s:0x000080AFr, "Ford_260_right_cylinder_head", desc );
			addPart( parts.engines.ford_v8s:0x000080B0r, "Ford_260_left_exhaust_header", desc );
			addPart( parts.engines.ford_v8s:0x000080B2r, "Ford_260_right_exhaust_header", desc );
		}
		else
		{
			addPart( parts.engines.ford_v8s:0x000008ADr, "Ford_racing_left_cylinder_head_small_block", desc );
			addPart( parts.engines.ford_v8s:0x000008AFr, "Ford_racing_right_cylinder_head_small_block", desc );
			addPart( parts.engines.ford_v8s:0x000008B0r, "Ford_racing_left_exhaust_header_small_block", desc );
			addPart( parts.engines.ford_v8s:0x000008B2r, "Ford_racing_right_exhaust_header_small_block", desc );
		}
		
		number = random();
		
		if( number < 0.7 )
		{
			addPart( parts.engines.ford_v8s:0x00008042r, "Ford_260_left_cylinder_head_cover", desc );
			addPart( parts.engines.ford_v8s:0x00008044r, "Ford_260_right_cylinder_head_cover", desc );
		}
		else
		{
			addPart( parts.engines.ford_v8s:0x00000842r, "Edelbrock_left_cylinder_head_cover", desc );
			addPart( parts.engines.ford_v8s:0x00000844r, "Edelbrock_right_cylinder_head_cover", desc );
		}
		
		number = random();
		
		if( number < 0.32 )
		{
			addPart( parts.engines.ford_v8s:0x000080BEr, "Ford_260_4brl_intake_manifold", desc );
		}
		else if( number < 0.57 )
		{
			addPart( parts.engines.ford_v8s:0x000058BEr, "Holley_4brl_intake_manifold_small_block", desc );
		}
		else if( number < 0.67 )
		{
			addPart( parts.engines.ford_v8s:0x000008BEr, "Ford_racing_4brl_intake_manifold_small_block", desc );
		}
		else if( number < 0.75 )
		{
			addPart( parts.engines.ford_v8s:0x0000C8BEr, "Ford_supercharger_manifold_small_block", desc );
			addPart( parts.engines.ford_v8s:0x00000085r, "Edelbrock_supercharger_small_block", desc );
			addPart( parts.engines.ford_v8s:0x00000087r, "Edelbrock_supercharger_drive_belt_small_block", desc );
			charger = 1;
		}
		else
		{
			addPart( parts.engines.ford_v8s:0x000078BEr, "Trickflow_2x4brl_intake_manifold_small_block", desc );
			trickflow = 1;
		}
	
		number = random();
	
		if ( trickflow == 1 )
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
			
			number2 = random();
		
			if( number2 < 0.5 )
			{
				addPart( parts.engines.ford_v8s:0x00000386r, "Edelbrock_2x4brl_air_filter", desc );
			}
			else if( number2 < 0.7 )
			{
				addPart( parts.engines.ford_v8s:0x00000186r, "KN_2x4brl_air_filter", desc );
			}
			else
			{
				addPart( parts.engines.ford_v8s:0x00009AA5r, "Motorcraft_2x4brl_blower", desc );
			}			
		}
		else
		{
			number = random();
			
			if( number < 0.7 )
			{
				addPart( parts.engines.ford_v8s:0x0000008Br, "carb_4brl", desc );
			}
			else
			{
				addPart( parts.engines.ford_v8s:0x0000388Br, "Holley_street_4brl_carburetor", desc );
			}
			
			number = random();
		
			if( number < 0.5 && charger == 0 )
			{
				addPart( parts.engines.ford_v8s:0x00008086r, "Ford_260_4brl_air_filter", desc );
			}
			else if( number < 0.7 && charger == 0 )
			{
				addPart( parts.engines.ford_v8s:0x00000886r, "Edelbrock_4brl_air_filter", desc );
			}
			else if( number < 1 && charger == 0 )
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
		else if( number < 0.85 )
		{
			addPart( parts.engines.ford_v8s:0x0000A811r, "malory_ignition", desc );
		}
		else
		{
			addPart( parts.engines.ford_v8s:0x0000074Ar, "Ford_racing_distributor", desc );
		}

		addPart( parts.engines.ford_v8s:0x00008047r, "Ford_260_alternator", desc );
		addPart( parts.engines.ford_v8s:0x00000043r, "Ford_stock_alt_drive_belt", desc );
		
		number = random();
		
		if( number < 0.5 )
		{
			addPart( parts.engines.ford_v8s:0x00003097r, "Ford_4_blade_fan", desc );
		}
		else
		{
			addPart( parts.engines.ford_v8s:0x00000097r, "Ford_5_blade_fan", desc );
		}
		
		addPart( parts.engines.ford_v8s:0x00000548r, "Ford_stock_radiator", desc );
		
		//////////////////
		// TRANSMISSION //
		//////////////////
		
		number = random();
		
		if( number < 0.6 )
		{
			number2 = random();
			
			if ( number2 < 0.38 )
			{
				addPart( parts.engines.ford_v8s:0x00000599r, "Tranny_HEG_W_3spd", desc );
			}
			else
			{
				addPart( parts.engines.ford_v8s:0x00000099r, "Tranny_HED_BH_3spd", desc );
			}
		}
		else
		{
			number2 = random();
			
			if ( number2 < 0.57 )
			{
				addPart( parts.engines.ford_v8s:0x00003099r, "Tranny_borg_warner_t10_4spd", desc );
			}
			else if ( number2 < 0.88 )
			{
				addPart( parts.engines.ford_v8s:0x00004099r, "Tranny_borg_warner_super_t10_4spd", desc );
			}
			else
			{
				addPart( parts.engines.ford_v8s:0x0000A599r, "Tranny_borg_warner_t18_4spd", desc );
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
