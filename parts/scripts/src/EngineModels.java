package java.game.parts;

import java.util.*;
import java.game.*;
import java.game.parts.engines.*;

public class EngineModels extends Part
{
	final static int engineCode			= 0;
	final static int GM_V8_283			= engineCode++;
	final static int GM_V8_302			= engineCode++;
	
	final static int CHRYSLER_V8_318	= engineCode++;
	final static int CHRYSLER_V8_340	= engineCode++;
	final static int CHRYSLER_V8_360	= engineCode++;
	final static int CHRYSLER_V8_361	= engineCode++;
	final static int CHRYSLER_V8_383	= engineCode++;
	final static int CHRYSLER_V8_400	= engineCode++;
	final static int CHRYSLER_V8_440	= engineCode++;
	final static int CHRYSLER_V8_426	= engineCode++;

	final static int FORD_L6_188		= engineCode++;
	final static int FORD_L6_221		= engineCode++;
	final static int FORD_V8_260		= engineCode++;
	final static int FORD_V8_292		= engineCode++;
	final static int FORD_V8_302		= engineCode++;
	final static int FORD_V8_312		= engineCode++;
	final static int FORD_V8_332		= engineCode++;
	final static int FORD_V8_351		= engineCode++;
	final static int FORD_V8_390		= engineCode++;
	final static int FORD_V8_429		= engineCode++;
	final static int FORD_V8_460		= engineCode++;

	private static float number;
	private static float number2;
	private static float number3;
	private static float number4;
	private static int motor;
	
	public static int[] getGmEngine( int code ){
		int[] engine_part_list;
		int position;

		if (code == GM_V8_283)
		{
			position = 0;
			engine_part_list  = new int[32];
			engine_part_list[ position++] = parts:0x000053FFr; // "stock battery" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x0000003Fr; // "GM 283-307 small block" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x0000003Er; // "GM 283 cui small block crankshaft" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x00000055r; // "V8 Small Block Rods" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x0000E23Er; // "GM Small Block Crank Gear" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x00000003r; // "V8 Camshaft" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x0000E103r; // "GM Small block stock camshaft timing gear" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x00000056r; // "GM Small block stock pistons (283, 302)" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x000000ADr; // "V8 Small Block Left head" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x000000AFr; // "V8 Small Block Right Head" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x000000BDr; // "V8 Small Block Left head Cover" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x0000C1BDr; // "GM Small block left cylinder head cover cup" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x000000BCr; // "V8 Small Block Right head Cover" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x000000B0r; // "V8 Small Block Left Exhaust Header" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x000000B2r; // "V8 Small Block Right Exhaust Header" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x00000043r; // "V8 Small block stock timing chain" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x0000F303r; // "GM 283-302 Small block stock timing chain cover" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x0000F103r; // "GM Small block stock harmonic damper" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x0000E303r; // "GM Small block stock water pump" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x00009049r; // "GM Small block stock cooling fan" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x0000A0A1r; // "V8 Small Block 2brl Intake Manifold" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x000000A3r; // "Stock 2brl Carb" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x00000086r; // "GM stock air filter" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x000000C7r; // "Stock Ignition Distributor" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x0000004Ar; // "Stock Oil Filter" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x00000083r; // "V8 Small Block Flywheel" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x00000084r; // "V8 Small Block Clutch" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x00000089r; // "V8 3speed Tranny" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x00000048r; // "V8 Small Block Oil Pan" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x00000047r; // "Alternator" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x00000049r; // "Alternator Belt" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x0000B103r; // "Radiator" //
		}
		else if (code == GM_V8_302)
		{
			position = 0;
			engine_part_list  = new int[32];
			engine_part_list[ position++] = parts:0x000053FFr; // "stock battery" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x0000003Fr; // "GM 283-307 small block" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x0000003Er; // "GM 283 cui small block crankshaft" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x00000055r; // "V8 Small Block Rods" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x0000E23Er; // "GM Small Block Crank Gear" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x00000003r; // "V8 Camshaft" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x0000E103r; // "GM Small block stock camshaft timing gear" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x00000056r; // "GM Small block stock pistons (283, 302)" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x000000ADr; // "V8 Small Block Left head" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x000000AFr; // "V8 Small Block Right Head" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x000000BDr; // "V8 Small Block Left head Cover" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x0000C1BDr; // "GM Small block left cylinder head cover cup" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x000000BCr; // "V8 Small Block Right head Cover" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x000000B0r; // "V8 Small Block Left Exhaust Header" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x000000B2r; // "V8 Small Block Right Exhaust Header" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x00000043r; // "V8 Small block stock timing chain" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x0000F303r; // "GM 283-302 Small block stock timing chain cover" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x0000F103r; // "GM Small block stock harmonic damper" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x0000E303r; // "GM Small block stock water pump" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x00009049r; // "GM Small block stock cooling fan" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x0000A0A1r; // "V8 Small Block 2brl Intake Manifold" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x000000A3r; // "Stock 2brl Carb" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x00000086r; // "GM stock air filter" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x000000C7r; // "Stock Ignition Distributor" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x0000004Ar; // "Stock Oil Filter" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x00000083r; // "V8 Small Block Flywheel" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x00000084r; // "V8 Small Block Clutch" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x00000089r; // "V8 3speed Tranny" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x00000048r; // "V8 Small Block Oil Pan" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x00000047r; // "Alternator" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x00000049r; // "Alternator Belt" //
			engine_part_list[ position++] = parts.engines.GM_V8_pak:0x0000B103r; // "Radiator" //
		}
		else {
			Logger.log("Error getting GM engine: unknown engine code (" + code + ")");
		}

		return engine_part_list;
	}
	
	public static int[] getFordEngine( int code ){
		int[] engine_part_list  = new int[2];
		engine_part_list[ 0] = parts:0x000053FFr; // "stock battery" //
		
		if ( code == FORD_L6_188 )
		{
			engine_part_list[ 1] = parts.engines.fordi6_data:0x00000041r; // "Ford_188_Block" //
		}
		else if ( code == FORD_L6_221 )
		{
			engine_part_list[ 1] = parts.engines.fordi6_data:0x00000052r; // "Ford_221_Block" //
		}
		else if ( code == FORD_V8_260)
		{
			engine_part_list[ 1] = parts.engines.ford_v8s:0x00008001r; // "Ford_260_block" //
		}
		else if ( code == FORD_V8_292 )
		{
			engine_part_list[ 1] = parts.engines.ford_v8s:0x00000001r; // "Ford_292_block" //
		}
		else if ( code == FORD_V8_302 )
		{
			engine_part_list[ 1] = parts.engines.ford_v8s:0x00006001r; // "Ford_302_block" //
		}
		else if ( code == FORD_V8_312 )
		{
			engine_part_list[ 1] = parts.engines.ford_v8s:0x00009001r; // "Ford_312_block" //
		}
		else if ( code == FORD_V8_332 )
		{
			engine_part_list[ 1] = parts.engines.ford_v8s:0x00007001r; // "Ford_332_block" //
		}
		else if ( code == FORD_V8_351 )
		{
			engine_part_list[ 1] = parts.engines.ford_v8s:0x00005001r; // "Ford_351_block" //
		}
		else if ( code == FORD_V8_390 )
		{
			engine_part_list[ 1] = parts.engines.ford_v8s:0x00003001r; // "Ford_390_block" //
		}
		else if ( code == FORD_V8_429 )
		{
			engine_part_list[ 1] = parts.engines.ford_v8s:0x00004261r; // "Cobra_Jet_429_block" //
		}
		else if ( code == FORD_V8_460 )
		{
			engine_part_list[ 1] = parts.engines.ford_v8s:0x00004001r; // "Ford_460_block" //
		}
		else {
			Logger.log("Error getting Ford engine: unknown engine code (" + code + ")");
		}
		
		return engine_part_list;
	}
	
	public static int[] getChryslerEngine( int code )
	{
		int[] engine_part_list  = new int[34];
		engine_part_list[ 0] = parts:0x000053FFr; // "stock battery" //
		
		if ( code == CHRYSLER_V8_318 )
		{
			engine_part_list[ 1] = parts.engines.Chrysler_V8_pak:0x0000E318r; // "Engine_block_318" //
			engine_part_list[ 2] = parts.engines.Chrysler_V8_pak:0x000000FEr; // "Crankshaft_318_block" //
			engine_part_list[ 3] = parts.engines.Chrysler_V8_pak:0x00000A6Br; // "Timing_gear_crankshaft" //
			engine_part_list[ 4] = parts.engines.Chrysler_V8_pak:0x000000FFr; // "Connecting_rods_318_block" //
			engine_part_list[ 5] = parts.engines.Chrysler_V8_pak:0x00000102r; // "Pistons_318_block" //
			engine_part_list[ 6] = parts.engines.Chrysler_V8_pak:0x00000003r; // "Camshaft_318_block" //
			engine_part_list[ 7] = parts.engines.Chrysler_V8_pak:0x00000AB4r; // "Timing_gear_camshaft" //
			engine_part_list[ 8] = parts.engines.Chrysler_V8_pak:0x00000097r; // "Timing_chain" //
			engine_part_list[ 9] = parts.engines.Chrysler_V8_pak:0x0000004Fr; // "Timing_gear_cover_B" //
			engine_part_list[ 10] = parts.engines.Chrysler_V8_pak:0x00000095r; // "Oil_pan_small_block_B" //
			engine_part_list[ 11] = parts.engines.Chrysler_V8_pak:0x00000A99r; // "Oill_filter" //
			engine_part_list[ 12] = parts.engines.Chrysler_V8_pak:0x00000100r; // "Flywheel_small_block" //
			engine_part_list[ 13] = parts.engines.Chrysler_V8_pak:0x00000103r; // "Clutch_small_block" //
			engine_part_list[ 14] = parts.engines.Chrysler_V8_pak:0x00000088r; // "Pulley_small_block_B" //
			engine_part_list[ 15] = parts.engines.Chrysler_V8_pak:0x00000047r; // "Water_pomp_small_B" //
			engine_part_list[ 16] = parts.engines.Chrysler_V8_pak:0x000000ADr; // "Cylinder_head_Left_318" //
			engine_part_list[ 17] = parts.engines.Chrysler_V8_pak:0x000000B0r; // "Exhaust_header_left_small" //
			engine_part_list[ 18] = parts.engines.Chrysler_V8_pak:0x00000042r; // "Head_cover_left_B" //
			engine_part_list[ 19] = parts.engines.Chrysler_V8_pak:0x000000AFr; // "Cylinder_head_Right_318" //
			engine_part_list[ 20] = parts.engines.Chrysler_V8_pak:0x000000B2r; // "Exhaust_header_Right_small" //
			engine_part_list[ 21] = parts.engines.Chrysler_V8_pak:0x00000044r; // "Head_cover_Right_B" //
			engine_part_list[ 22] = parts.engines.Chrysler_V8_pak:0x00000F1Br; // "Block_cover_small" //
			engine_part_list[ 23] = parts.engines.Chrysler_V8_pak:0x000002A1r; // "Intake_manifold_small_2brl_B" //
			engine_part_list[ 24] = parts.engines.Chrysler_V8_pak:0x000000A3r; // "Carburetors_2BRL_HOLLEY" //
			engine_part_list[ 25] = parts.engines.Chrysler_V8_pak:0x00000086r; // "Air_cleaner_318_2BRL" //
			engine_part_list[ 26] = parts.engines.Chrysler_V8_pak:0x00000A02r; // "Ignition_distributor" //
			engine_part_list[ 27] = parts.engines.Chrysler_V8_pak:0x00000096r; // "Alternator" //
			engine_part_list[ 28] = parts.engines.Chrysler_V8_pak:0x0000009Ar; // "Belt_alternator_drive" //
			engine_part_list[ 29] = parts.engines.Chrysler_V8_pak:0x00000E08r; // "Fan_4_blade" //
			engine_part_list[ 30] = parts.engines.Chrysler_V8_pak:0x00000A97r; // "Power_Steering_pump" //
			engine_part_list[ 31] = parts.engines.Chrysler_V8_pak:0x0000044Dr; // "Belt_Steering_pump" //
			engine_part_list[ 32] = parts.engines.Chrysler_V8_pak:0x00000E15r; // "Radiator_small" //
			
			number2 = random();
		
			if ( number2 < 0.5 )
			{
				engine_part_list[ 33] = parts.engines.Chrysler_V8_pak:0x00000099r; // "Transmission_A230_3spd" //
			}
			else if ( number2 < 0.9 )
			{
				engine_part_list[ 33] = parts.engines.Chrysler_V8_pak:0x00000104r; // "Transmission_A727_3spd" //
			}
			else
			{
				engine_part_list[ 33] = parts.engines.Chrysler_V8_pak:0x00000F89r; // "Transmission_A833_4spd" //
			}
		}
		else if ( code == CHRYSLER_V8_340 )
		{
			engine_part_list[ 1] = parts.engines.Chrysler_V8_pak:0x0000E340r; // "Engine_block_340" //
			engine_part_list[ 2] = parts.engines.Chrysler_V8_pak:0x0000000Br; // "Crankshaft_340_block" //
			engine_part_list[ 3] = parts.engines.Chrysler_V8_pak:0x00000A6Br; // "Timing_gear_crankshaft" //
			engine_part_list[ 4] = parts.engines.Chrysler_V8_pak:0x00000106r; // "Connecting_rods_340_block" //
			engine_part_list[ 5] = parts.engines.Chrysler_V8_pak:0x00000101r; // "Pistons_340_block" //
			engine_part_list[ 6] = parts.engines.Chrysler_V8_pak:0x000000FCr; // "Camshaft_340_block" //
			engine_part_list[ 7] = parts.engines.Chrysler_V8_pak:0x00000AB4r; // "Timing_gear_camshaft" //
			engine_part_list[ 8] = parts.engines.Chrysler_V8_pak:0x00000097r; // "Timing_chain" //
			engine_part_list[ 9] = parts.engines.Chrysler_V8_pak:0x00000052r; // "Timing_gear_cover" //
			engine_part_list[ 10] = parts.engines.Chrysler_V8_pak:0x00000048r; // "Oil_pan_small_block_O" //
			engine_part_list[ 11] = parts.engines.Chrysler_V8_pak:0x00000A99r; // "Oill_filter" //
			engine_part_list[ 12] = parts.engines.Chrysler_V8_pak:0x00000100r; // "Flywheel_small_block" //
			engine_part_list[ 13] = parts.engines.Chrysler_V8_pak:0x00000103r; // "Clutch_small_block" //
			engine_part_list[ 14] = parts.engines.Chrysler_V8_pak:0x00000A88r; // "Pulley_small_block" //
			engine_part_list[ 15] = parts.engines.Chrysler_V8_pak:0x00000EE1r; // "Water_pomp_small_O" //
			engine_part_list[ 16] = parts.engines.Chrysler_V8_pak:0x00000040r; // "Cylinder_head_Left_340" //
			engine_part_list[ 17] = parts.engines.Chrysler_V8_pak:0x000000B0r; // "Exhaust_header_left_small" //
			engine_part_list[ 18] = parts.engines.Chrysler_V8_pak:0x000000BDr; // "Head_cover_left_O" //
			engine_part_list[ 19] = parts.engines.Chrysler_V8_pak:0x00000041r; // "Cylinder_head_Right_340" //
			engine_part_list[ 20] = parts.engines.Chrysler_V8_pak:0x000000B2r; // "Exhaust_header_Right_small" //
			engine_part_list[ 21] = parts.engines.Chrysler_V8_pak:0x000000BCr; // "Head_cover_Right_O" //
			engine_part_list[ 22] = parts.engines.Chrysler_V8_pak:0x00000F1Br; // "Block_cover_small" //
			engine_part_list[ 23] = parts.engines.Chrysler_V8_pak:0x000000BEr; // "Intake_manifold_small_4brl_O" //
			engine_part_list[ 24] = parts.engines.Chrysler_V8_pak:0x0000088Br; // "Carburetors_4BRL_street_HOLLEY" //
			engine_part_list[ 25] = parts.engines.Chrysler_V8_pak:0x000000A5r; // "Air_cleaner_340" //
			engine_part_list[ 26] = parts.engines.Chrysler_V8_pak:0x00000A02r; // "Ignition_distributor" //
			engine_part_list[ 27] = parts.engines.Chrysler_V8_pak:0x00000096r; // "Alternator" //
			engine_part_list[ 28] = parts.engines.Chrysler_V8_pak:0x0000009Ar; // "Belt_alternator_drive" //
			engine_part_list[ 29] = parts.engines.Chrysler_V8_pak:0x00000E08r; // "Fan_4_blade" //
			engine_part_list[ 30] = parts.engines.Chrysler_V8_pak:0x00000A97r; // "Power_Steering_pump" //
			engine_part_list[ 31] = parts.engines.Chrysler_V8_pak:0x0000044Dr; // "Belt_Steering_pump" //
			engine_part_list[ 32] = parts.engines.Chrysler_V8_pak:0x00000E15r; // "Radiator_small" //
			
			number2 = random();
		
			if ( number2 < 0.5 )
			{
				engine_part_list[ 33] = parts.engines.Chrysler_V8_pak:0x00000099r; // "Transmission_A230_3spd" //
			}
			else if ( number2 < 0.9 )
			{
				engine_part_list[ 33] = parts.engines.Chrysler_V8_pak:0x00000104r; // "Transmission_A727_3spd" //
			}
			else
			{
				engine_part_list[ 33] = parts.engines.Chrysler_V8_pak:0x00000F89r; // "Transmission_A833_4spd" //
			}
		}
		else if ( code == CHRYSLER_V8_360 )
		{
			engine_part_list[ 1] = parts.engines.Chrysler_V8_pak:0x0000E360r; // "Engine_block_360" //
			engine_part_list[ 2] = parts.engines.Chrysler_V8_pak:0x0000003Er; // "Crankshaft_360_block" //
			engine_part_list[ 3] = parts.engines.Chrysler_V8_pak:0x00000A6Br; // "Timing_gear_crankshaft" //
			engine_part_list[ 4] = parts.engines.Chrysler_V8_pak:0x000000A8r; // "Connecting_rods_360_block" //
			engine_part_list[ 5] = parts.engines.Chrysler_V8_pak:0x000000AAr; // "Pistons_360_block" //
			engine_part_list[ 6] = parts.engines.Chrysler_V8_pak:0x000000FDr; // "Camshaft_360_block" //
			engine_part_list[ 7] = parts.engines.Chrysler_V8_pak:0x00000AB4r; // "Timing_gear_camshaft" //
			engine_part_list[ 8] = parts.engines.Chrysler_V8_pak:0x00000097r; // "Timing_chain" //
			engine_part_list[ 9] = parts.engines.Chrysler_V8_pak:0x00000052r; // "Timing_gear_cover" //
			engine_part_list[ 10] = parts.engines.Chrysler_V8_pak:0x00000048r; // "Oil_pan_small_block_O" //
			engine_part_list[ 11] = parts.engines.Chrysler_V8_pak:0x00000A99r; // "Oill_filter" //
			engine_part_list[ 12] = parts.engines.Chrysler_V8_pak:0x00000100r; // "Flywheel_small_block" //
			engine_part_list[ 13] = parts.engines.Chrysler_V8_pak:0x00000103r; // "Clutch_small_block" //
			engine_part_list[ 14] = parts.engines.Chrysler_V8_pak:0x00000A88r; // "Pulley_small_block" //
			engine_part_list[ 15] = parts.engines.Chrysler_V8_pak:0x00000EE1r; // "Water_pomp_small_O" //
			engine_part_list[ 16] = parts.engines.Chrysler_V8_pak:0x00000F40r; // "Cylinder_head_Left_360" //
			engine_part_list[ 17] = parts.engines.Chrysler_V8_pak:0x000000B0r; // "Exhaust_header_left_small" //
			engine_part_list[ 18] = parts.engines.Chrysler_V8_pak:0x000000BDr; // "Head_cover_left_O" //
			engine_part_list[ 19] = parts.engines.Chrysler_V8_pak:0x00000F41r; // "Cylinder_head_Right_360" //
			engine_part_list[ 20] = parts.engines.Chrysler_V8_pak:0x000000B2r; // "Exhaust_header_Right_small" //
			engine_part_list[ 21] = parts.engines.Chrysler_V8_pak:0x000000BCr; // "Head_cover_Right_O" //
			engine_part_list[ 22] = parts.engines.Chrysler_V8_pak:0x00000F1Br; // "Block_cover_small" //
			engine_part_list[ 23] = parts.engines.Chrysler_V8_pak:0x000003BEr; // "Intake_manifold_small_2brl_O" //
			engine_part_list[ 24] = parts.engines.Chrysler_V8_pak:0x000000A3r; // "Carburetors_2BRL_HOLLEY" //
			engine_part_list[ 25] = parts.engines.Chrysler_V8_pak:0x00000AA6r; // "Air_cleaner_360" //
			engine_part_list[ 26] = parts.engines.Chrysler_V8_pak:0x00000A02r; // "Ignition_distributor" //
			engine_part_list[ 27] = parts.engines.Chrysler_V8_pak:0x00000096r; // "Alternator" //
			engine_part_list[ 28] = parts.engines.Chrysler_V8_pak:0x0000009Ar; // "Belt_alternator_drive" //
			engine_part_list[ 29] = parts.engines.Chrysler_V8_pak:0x00000E09r; // "Fan_5_blade" //
			engine_part_list[ 30] = parts.engines.Chrysler_V8_pak:0x00000A97r; // "Power_Steering_pump" //
			engine_part_list[ 31] = parts.engines.Chrysler_V8_pak:0x0000044Dr; // "Belt_Steering_pump" //
			engine_part_list[ 32] = parts.engines.Chrysler_V8_pak:0x00000E15r; // "Radiator_small" //
			
			number2 = random();
			
			if ( number2 < 0.3 )
			{
				engine_part_list[ 33] = parts.engines.Chrysler_V8_pak:0x00000099r; // "Transmission_A230_3spd" //
			}
			else if ( number2 < 0.6 )
			{
				engine_part_list[ 33] = parts.engines.Chrysler_V8_pak:0x00000104r; // "Transmission_A727_3spd" //
			}
			else if ( number2 < 0.8 )
			{
				engine_part_list[ 33] = parts.engines.Chrysler_V8_pak:0x00000107r; // "Transmission_A727_4spd" //
			}
			else if ( number2 < 0.95 )
			{
				engine_part_list[ 33] = parts.engines.Chrysler_V8_pak:0x00000F89r; // "Transmission_A833_4spd" //
			}
			else
			{
				engine_part_list[ 33] = parts.engines.Chrysler_V8_pak:0x00000F90r; // "Transmission_TKO500_5spd" //
			}
		}
		else if ( code == CHRYSLER_V8_361 )
		{
			engine_part_list[ 1] = parts.engines.Chrysler_V8_pak:0x0000E361r; // "Engine_block_361" //
			engine_part_list[ 2] = parts.engines.Chrysler_V8_pak:0x0000004Ar; // "Crankshaft_361_block" //
			engine_part_list[ 3] = parts.engines.Chrysler_V8_pak:0x00000A6Br; // "Timing_gear_crankshaft" //
			engine_part_list[ 4] = parts.engines.Chrysler_V8_pak:0x00000055r; // "Connecting_rods_361_block" //
			engine_part_list[ 5] = parts.engines.Chrysler_V8_pak:0x00000056r; // "Pistons_361_block" //
			engine_part_list[ 6] = parts.engines.Chrysler_V8_pak:0x0000004Er; // "Camshaft_361_block" //
			engine_part_list[ 7] = parts.engines.Chrysler_V8_pak:0x00000AB4r; // "Timing_gear_camshaft" //
			engine_part_list[ 8] = parts.engines.Chrysler_V8_pak:0x00000097r; // "Timing_chain" //
			engine_part_list[ 9] = parts.engines.Chrysler_V8_pak:0x0000004Fr; // "Timing_gear_cover_B" //
			engine_part_list[ 10] = parts.engines.Chrysler_V8_pak:0x00000C49r; // "Oil_pan_big_block_B" //
			engine_part_list[ 11] = parts.engines.Chrysler_V8_pak:0x00000A99r; // "Oill_filter" //
			engine_part_list[ 12] = parts.engines.Chrysler_V8_pak:0x00000083r; // "Flywheel_big_block" //
			engine_part_list[ 13] = parts.engines.Chrysler_V8_pak:0x000000A7r; // "Clutch_big_block" //
			engine_part_list[ 14] = parts.engines.Chrysler_V8_pak:0x00000A90r; // "Pulley_big_block_B" //
			engine_part_list[ 15] = parts.engines.Chrysler_V8_pak:0x00000EE3r; // "Water_pomp_big_B" //
			engine_part_list[ 16] = parts.engines.Chrysler_V8_pak:0x00000F46r; // "Cylinder_head_Left_361" //
			engine_part_list[ 17] = parts.engines.Chrysler_V8_pak:0x000001B0r; // "Exhaust_header_left_big_B" //
			engine_part_list[ 18] = parts.engines.Chrysler_V8_pak:0x00000042r; // "Head_cover_left_B" //
			engine_part_list[ 19] = parts.engines.Chrysler_V8_pak:0x00000F47r; // "Cylinder_head_Right_361" //
			engine_part_list[ 20] = parts.engines.Chrysler_V8_pak:0x000001B2r; // "Exhaust_header_Right_big_B" //
			engine_part_list[ 21] = parts.engines.Chrysler_V8_pak:0x00000044r; // "Head_cover_Right_B" //
			engine_part_list[ 22] = parts.engines.Chrysler_V8_pak:0x00000F2Br; // "Block_cover_big" //
			engine_part_list[ 23] = parts.engines.Chrysler_V8_pak:0x000006FBr; // "Intake_manifold_big_4brl_B" //
			engine_part_list[ 24] = parts.engines.Chrysler_V8_pak:0x0000088Br; // "Carburetors_4BRL_street_HOLLEY" //
			engine_part_list[ 25] = parts.engines.Chrysler_V8_pak:0x00000BA6r; // "Air_cleaner_361" //
			engine_part_list[ 26] = parts.engines.Chrysler_V8_pak:0x00000A02r; // "Ignition_distributor" //
			engine_part_list[ 27] = parts.engines.Chrysler_V8_pak:0x00000096r; // "Alternator" //
			engine_part_list[ 28] = parts.engines.Chrysler_V8_pak:0x0000009Ar; // "Belt_alternator_drive" //
			engine_part_list[ 29] = parts.engines.Chrysler_V8_pak:0x00000E09r; // "Fan_5_blade" //
			engine_part_list[ 30] = parts.engines.Chrysler_V8_pak:0x00000A97r; // "Power_Steering_pump" //
			engine_part_list[ 31] = parts.engines.Chrysler_V8_pak:0x0000044Dr; // "Belt_Steering_pump" //
			engine_part_list[ 32] = parts.engines.Chrysler_V8_pak:0x00000E16r; // "Radiator_big" //
			
			number2 = random();
			
			if ( number2 < 0.3 )
			{
				engine_part_list[ 33] = parts.engines.Chrysler_V8_pak:0x00000107r; // "Transmission_A727_4spd" //
			}
			else if ( number2 < 0.65 )
			{
				engine_part_list[ 33] = parts.engines.Chrysler_V8_pak:0x00000F89r; // "Transmission_A833_4spd" //
			}
			else
			{
				engine_part_list[ 33] = parts.engines.Chrysler_V8_pak:0x00000F90r; // "Transmission_TKO500_5spd" //
			}
		}
		else if ( code == CHRYSLER_V8_383 )
		{
			engine_part_list[ 1] = parts.engines.Chrysler_V8_pak:0x0000E383r; // "Engine_block_383" //
			engine_part_list[ 2] = parts.engines.Chrysler_V8_pak:0x00000A6Ar; // "Crankshaft_383_block" //
			engine_part_list[ 3] = parts.engines.Chrysler_V8_pak:0x00000A6Br; // "Timing_gear_crankshaft" //
			engine_part_list[ 4] = parts.engines.Chrysler_V8_pak:0x00000B56r; // "Connecting_rods_383_block" //
			engine_part_list[ 5] = parts.engines.Chrysler_V8_pak:0x00000C52r; // "Pistons_383_block" //
			engine_part_list[ 6] = parts.engines.Chrysler_V8_pak:0x00000051r; // "Camshaft_383_block" //
			engine_part_list[ 7] = parts.engines.Chrysler_V8_pak:0x00000AB4r; // "Timing_gear_camshaft" //
			engine_part_list[ 8] = parts.engines.Chrysler_V8_pak:0x00000097r; // "Timing_chain" //
			engine_part_list[ 9] = parts.engines.Chrysler_V8_pak:0x0000004Fr; // "Timing_gear_cover_B" //
			engine_part_list[ 10] = parts.engines.Chrysler_V8_pak:0x00000C49r; // "Oil_pan_big_block_B" //
			engine_part_list[ 11] = parts.engines.Chrysler_V8_pak:0x00000A99r; // "Oill_filter" //
			engine_part_list[ 12] = parts.engines.Chrysler_V8_pak:0x00000083r; // "Flywheel_big_block" //
			engine_part_list[ 13] = parts.engines.Chrysler_V8_pak:0x000000A7r; // "Clutch_big_block" //
			engine_part_list[ 14] = parts.engines.Chrysler_V8_pak:0x00000A90r; // "Pulley_big_block_B" //
			engine_part_list[ 15] = parts.engines.Chrysler_V8_pak:0x00000EE3r; // "Water_pomp_big_B" //
			engine_part_list[ 16] = parts.engines.Chrysler_V8_pak:0x00000F48r; // "Cylinder_head_Left_383" //
			engine_part_list[ 17] = parts.engines.Chrysler_V8_pak:0x000001B0r; // "Exhaust_header_left_big_B" //
			engine_part_list[ 18] = parts.engines.Chrysler_V8_pak:0x00000042r; // "Head_cover_left_B" //
			engine_part_list[ 19] = parts.engines.Chrysler_V8_pak:0x00000F49r; // "Cylinder_head_Right_383" //
			engine_part_list[ 20] = parts.engines.Chrysler_V8_pak:0x000001B2r; // "Exhaust_header_Right_big_B" //
			engine_part_list[ 21] = parts.engines.Chrysler_V8_pak:0x00000044r; // "Head_cover_Right_B" //
			engine_part_list[ 22] = parts.engines.Chrysler_V8_pak:0x00000F2Br; // "Block_cover_big" //
			engine_part_list[ 23] = parts.engines.Chrysler_V8_pak:0x000006FBr; // "Intake_manifold_big_4brl_B" //
			engine_part_list[ 24] = parts.engines.Chrysler_V8_pak:0x0000088Br; // "Carburetors_4BRL_street_HOLLEY" //
			engine_part_list[ 25] = parts.engines.Chrysler_V8_pak:0x00000BA7r; // "Air_cleaner_383" //
			engine_part_list[ 26] = parts.engines.Chrysler_V8_pak:0x00000A02r; // "Ignition_distributor" //
			engine_part_list[ 27] = parts.engines.Chrysler_V8_pak:0x00000096r; // "Alternator" //
			engine_part_list[ 28] = parts.engines.Chrysler_V8_pak:0x0000009Ar; // "Belt_alternator_drive" //
			engine_part_list[ 29] = parts.engines.Chrysler_V8_pak:0x00000E09r; // "Fan_5_blade" //
			engine_part_list[ 30] = parts.engines.Chrysler_V8_pak:0x00000A97r; // "Power_Steering_pump" //
			engine_part_list[ 31] = parts.engines.Chrysler_V8_pak:0x0000044Dr; // "Belt_Steering_pump" //
			engine_part_list[ 32] = parts.engines.Chrysler_V8_pak:0x00000E16r; // "Radiator_big" //
						
			number2 = random();
			
			if ( number2 < 0.3 )
			{
				engine_part_list[ 33] = parts.engines.Chrysler_V8_pak:0x00000107r; // "Transmission_A727_4spd" //
			}
			else if ( number2 < 0.65 )
			{
				engine_part_list[ 33] = parts.engines.Chrysler_V8_pak:0x00000F89r; // "Transmission_A833_4spd" //
			}
			else
			{
				engine_part_list[ 33] = parts.engines.Chrysler_V8_pak:0x00000F90r; // "Transmission_TKO500_5spd" //
			}
		}
		else if ( code == CHRYSLER_V8_400 )
		{
			engine_part_list[ 1] = parts.engines.Chrysler_V8_pak:0x0000E400r; // "Engine_block_400" //
			engine_part_list[ 2] = parts.engines.Chrysler_V8_pak:0x00000A9Ar; // "Crankshaft_400_block" //
			engine_part_list[ 3] = parts.engines.Chrysler_V8_pak:0x00000A6Br; // "Timing_gear_crankshaft" //
			engine_part_list[ 4] = parts.engines.Chrysler_V8_pak:0x00000B57r; // "Connecting_rods_400_block" //
			engine_part_list[ 5] = parts.engines.Chrysler_V8_pak:0x00000C54r; // "Pistons_400_block" //
			engine_part_list[ 6] = parts.engines.Chrysler_V8_pak:0x00000A50r; // "Camshaft_400_block" //
			engine_part_list[ 7] = parts.engines.Chrysler_V8_pak:0x00000AB4r; // "Timing_gear_camshaft" //
			engine_part_list[ 8] = parts.engines.Chrysler_V8_pak:0x00000097r; // "Timing_chain" //
			engine_part_list[ 9] = parts.engines.Chrysler_V8_pak:0x00000052r; // "Timing_gear_cover" //
			engine_part_list[ 10] = parts.engines.Chrysler_V8_pak:0x00000C50r; // "Oil_pan_big_block_O" //
			engine_part_list[ 11] = parts.engines.Chrysler_V8_pak:0x00000A99r; // "Oill_filter" //
			engine_part_list[ 12] = parts.engines.Chrysler_V8_pak:0x00000083r; // "Flywheel_big_block" //
			engine_part_list[ 13] = parts.engines.Chrysler_V8_pak:0x000000A7r; // "Clutch_big_block" //
			engine_part_list[ 14] = parts.engines.Chrysler_V8_pak:0x00000A91r; // "Pulley_big_block" //
			engine_part_list[ 15] = parts.engines.Chrysler_V8_pak:0x00000EE4r; // "Water_pomp_big_O" //
			engine_part_list[ 16] = parts.engines.Chrysler_V8_pak:0x00000F50r; // "Cylinder_head_Left_400" //
			engine_part_list[ 17] = parts.engines.Chrysler_V8_pak:0x000001B0r; // "Exhaust_header_left_big_B" //
			engine_part_list[ 18] = parts.engines.Chrysler_V8_pak:0x000000BDr; // "Head_cover_left_O" //
			engine_part_list[ 19] = parts.engines.Chrysler_V8_pak:0x00000F51r; // "Cylinder_head_Right_400" //
			engine_part_list[ 20] = parts.engines.Chrysler_V8_pak:0x000001B2r; // "Exhaust_header_Right_big_B" //
			engine_part_list[ 21] = parts.engines.Chrysler_V8_pak:0x000000BCr; // "Head_cover_Right_O" //
			engine_part_list[ 22] = parts.engines.Chrysler_V8_pak:0x00000F2Br; // "Block_cover_big" //
			engine_part_list[ 23] = parts.engines.Chrysler_V8_pak:0x000007FBr; // "Intake_manifold_big_4brl_O" //
			engine_part_list[ 24] = parts.engines.Chrysler_V8_pak:0x0000088Br; // "Carburetors_4BRL_street_HOLLEY" //
			engine_part_list[ 25] = parts.engines.Chrysler_V8_pak:0x00000BA9r; // "Air_cleaner_400" //
			engine_part_list[ 26] = parts.engines.Chrysler_V8_pak:0x00000A02r; // "Ignition_distributor" //
			engine_part_list[ 27] = parts.engines.Chrysler_V8_pak:0x00000096r; // "Alternator" //
			engine_part_list[ 28] = parts.engines.Chrysler_V8_pak:0x0000009Ar; // "Belt_alternator_drive" //
			engine_part_list[ 29] = parts.engines.Chrysler_V8_pak:0x00000E09r; // "Fan_5_blade" //
			engine_part_list[ 30] = parts.engines.Chrysler_V8_pak:0x00000A97r; // "Power_Steering_pump" //
			engine_part_list[ 31] = parts.engines.Chrysler_V8_pak:0x0000044Dr; // "Belt_Steering_pump" //
			engine_part_list[ 32] = parts.engines.Chrysler_V8_pak:0x00000E16r; // "Radiator_big" //
			
			number2 = random();
			
			if ( number2 < 0.3 )
			{
				engine_part_list[ 33] = parts.engines.Chrysler_V8_pak:0x00000099r; // "Transmission_A230_3spd" //
			}
			else if ( number2 < 0.6 )
			{
				engine_part_list[ 33] = parts.engines.Chrysler_V8_pak:0x00000104r; // "Transmission_A727_3spd" //
			}
			else if ( number2 < 0.8 )
			{
				engine_part_list[ 33] = parts.engines.Chrysler_V8_pak:0x00000107r; // "Transmission_A727_4spd" //
			}
			else if ( number2 < 0.95 )
			{
				engine_part_list[ 33] = parts.engines.Chrysler_V8_pak:0x00000F89r; // "Transmission_A833_4spd" //
			}
			else
			{
				engine_part_list[ 33] = parts.engines.Chrysler_V8_pak:0x00000F90r; // "Transmission_TKO500_5spd" //
			}
		}
		else if ( code == CHRYSLER_V8_440 )
		{
			engine_part_list[ 1] = parts.engines.Chrysler_V8_pak:0x0000E440r; // "Engine_block_440" //
			engine_part_list[ 2] = parts.engines.Chrysler_V8_pak:0x00000A2Br; // "Crankshaft_440_block" //
			engine_part_list[ 3] = parts.engines.Chrysler_V8_pak:0x00000A6Br; // "Timing_gear_crankshaft" //
			engine_part_list[ 4] = parts.engines.Chrysler_V8_pak:0x00000B60r; // "Connecting_rods_440_block" //
			engine_part_list[ 5] = parts.engines.Chrysler_V8_pak:0x00000C5Cr; // "Pistons_440_block" //
			engine_part_list[ 6] = parts.engines.Chrysler_V8_pak:0x00000A52r; // "Camshaft_440_block" //
			engine_part_list[ 7] = parts.engines.Chrysler_V8_pak:0x00000AB4r; // "Timing_gear_camshaft" //
			engine_part_list[ 8] = parts.engines.Chrysler_V8_pak:0x00000097r; // "Timing_chain" //
			engine_part_list[ 9] = parts.engines.Chrysler_V8_pak:0x00000052r; // "Timing_gear_cover" //
			engine_part_list[ 10] = parts.engines.Chrysler_V8_pak:0x00000C50r; // "Oil_pan_big_block_O" //
			engine_part_list[ 11] = parts.engines.Chrysler_V8_pak:0x00000A99r; // "Oill_filter" //
			engine_part_list[ 12] = parts.engines.Chrysler_V8_pak:0x00000083r; // "Flywheel_big_block" //
			engine_part_list[ 13] = parts.engines.Chrysler_V8_pak:0x000000A7r; // "Clutch_big_block" //
			engine_part_list[ 14] = parts.engines.Chrysler_V8_pak:0x00000A91r; // "Pulley_big_block" //
			engine_part_list[ 15] = parts.engines.Chrysler_V8_pak:0x00000EE4r; // "Water_pomp_big_O" //
			engine_part_list[ 16] = parts.engines.Chrysler_V8_pak:0x00000F52r; // "Cylinder_head_Left_440" //
			engine_part_list[ 17] = parts.engines.Chrysler_V8_pak:0x000002B0r; // "Exhaust_header_left_big_RB" //
			engine_part_list[ 18] = parts.engines.Chrysler_V8_pak:0x00000FC0r; // "Head_cover_left_RB" //
			engine_part_list[ 19] = parts.engines.Chrysler_V8_pak:0x00000F53r; // "Cylinder_head_Right_440" //
			engine_part_list[ 20] = parts.engines.Chrysler_V8_pak:0x000002B2r; // "Exhaust_header_Right_big_RB" //
			engine_part_list[ 21] = parts.engines.Chrysler_V8_pak:0x00000FC1r; // "Head_cover_Right_RB" //
			engine_part_list[ 22] = parts.engines.Chrysler_V8_pak:0x00000F2Br; // "Block_cover_big" //
			engine_part_list[ 23] = parts.engines.Chrysler_V8_pak:0x000007FBr; // "Intake_manifold_big_4brl_O" //
			engine_part_list[ 24] = parts.engines.Chrysler_V8_pak:0x0000088Br; // "Carburetors_4BRL_street_HOLLEY" //
			engine_part_list[ 25] = parts.engines.Chrysler_V8_pak:0x00000BB0r; // "Air_cleaner_440" //
			engine_part_list[ 26] = parts.engines.Chrysler_V8_pak:0x00000A02r; // "Ignition_distributor" //
			engine_part_list[ 27] = parts.engines.Chrysler_V8_pak:0x00000096r; // "Alternator" //
			engine_part_list[ 28] = parts.engines.Chrysler_V8_pak:0x0000009Ar; // "Belt_alternator_drive" //
			engine_part_list[ 29] = parts.engines.Chrysler_V8_pak:0x00000E09r; // "Fan_5_blade" //
			engine_part_list[ 30] = parts.engines.Chrysler_V8_pak:0x00000A97r; // "Power_Steering_pump" //
			engine_part_list[ 31] = parts.engines.Chrysler_V8_pak:0x0000044Dr; // "Belt_Steering_pump" //
			engine_part_list[ 32] = parts.engines.Chrysler_V8_pak:0x00000E16r; // "Radiator_big" //
			
			number2 = random();
			
			if ( number2 < 0.3 )
			{
				engine_part_list[ 33] = parts.engines.Chrysler_V8_pak:0x00000107r; // "Transmission_A727_4spd" //
			}
			else if ( number2 < 0.65 )
			{
				engine_part_list[ 33] = parts.engines.Chrysler_V8_pak:0x00000F89r; // "Transmission_A833_4spd" //
			}
			else
			{
				engine_part_list[ 33] = parts.engines.Chrysler_V8_pak:0x00000F90r; // "Transmission_TKO500_5spd" //
			}
		}
		else if ( code == CHRYSLER_V8_426 )
		{
			engine_part_list[ 1] = parts.engines.Chrysler_V8_pak:0x0000E426r; // "Engine_block_426_XEMI" //
			engine_part_list[ 2] = parts.engines.Chrysler_V8_pak:0x00000A5Br; // "Crankshaft_HEMI_block" //
			engine_part_list[ 3] = parts.engines.Chrysler_V8_pak:0x00000A7Br; // "Timing_gear_crankshaft_HEMI" //
			engine_part_list[ 4] = parts.engines.Chrysler_V8_pak:0x00000B61r; // "Connecting_rods_HEMI_block" //
			engine_part_list[ 5] = parts.engines.Chrysler_V8_pak:0x00000C7Cr; // "Pistons_HEMI_block" //
			engine_part_list[ 6] = parts.engines.Chrysler_V8_pak:0x000000B4r; // "Camshaft_HEMI_block" //
			engine_part_list[ 7] = parts.engines.Chrysler_V8_pak:0x00000AB5r; // "Timing_gear_camshaft_HEMI" //
			engine_part_list[ 8] = parts.engines.Chrysler_V8_pak:0x00000049r; // "Timing_chain_HEMI" //
			engine_part_list[ 9] = parts.engines.Chrysler_V8_pak:0x000000BBr; // "Timing_gear_cover_HEMI" //
			engine_part_list[ 10] = parts.engines.Chrysler_V8_pak:0x00000CC1r; // "Oil_pan_HEMI_block" //
			engine_part_list[ 11] = parts.engines.Chrysler_V8_pak:0x00000A99r; // "Oill_filter" //
			engine_part_list[ 12] = parts.engines.Chrysler_V8_pak:0x00000F83r; // "Flywheel_HEMI_block" //
			engine_part_list[ 13] = parts.engines.Chrysler_V8_pak:0x00000084r; // "Clutch_HEMI_block" //
			engine_part_list[ 14] = parts.engines.Chrysler_V8_pak:0x00000A92r; // "Pulley_HEMI_block" //
			engine_part_list[ 15] = parts.engines.Chrysler_V8_pak:0x00000EE5r; // "Water_pomp_HEMI" //
			engine_part_list[ 16] = parts.engines.Chrysler_V8_pak:0x00000F56r; // "Cylinder_head_Left_HEMI" //
			engine_part_list[ 17] = parts.engines.Chrysler_V8_pak:0x000004B0r; // "Exhaust_header_left_HEMI_PERFORMANCE" //
			engine_part_list[ 18] = parts.engines.Chrysler_V8_pak:0x00000FC2r; // "Head_cover_left_HEMI" //
			engine_part_list[ 19] = parts.engines.Chrysler_V8_pak:0x00000F57r; // "Cylinder_head_Right_HEMI" //
			engine_part_list[ 20] = parts.engines.Chrysler_V8_pak:0x000004B2r; // "Exhaust_header_Right_HEMI_PERFORMANCE" //
			engine_part_list[ 21] = parts.engines.Chrysler_V8_pak:0x00000FC3r; // "Head_cover_Right_HEMI" //
			engine_part_list[ 22] = parts.engines.Chrysler_V8_pak:0x00000F2Br; // "Block_cover_big" //
			engine_part_list[ 23] = parts.engines.Chrysler_V8_pak:0x000007EBr; // "Intake_manifold_HEMI_Crossram" //
			engine_part_list[ 24] = parts.engines.Chrysler_V8_pak:0x0000093Br; // "Carburetors_2x4BRL_Crassram_HOLLEY" //
			engine_part_list[ 25] = parts.engines.Chrysler_V8_pak:0x00000BB2r; // "Air_cleaner_HEMI_crassram" //
			engine_part_list[ 26] = parts.engines.Chrysler_V8_pak:0x00000A02r; // "Ignition_distributor" //
			engine_part_list[ 27] = parts.engines.Chrysler_V8_pak:0x00000B96r; // "Alternator_HEMI" //
			engine_part_list[ 28] = parts.engines.Chrysler_V8_pak:0x00000043r; // "Belt_alternator_HEMI" //
			engine_part_list[ 29] = parts.engines.Chrysler_V8_pak:0x00000E14r; // "Fan_HEMI" //
			engine_part_list[ 30] = parts.engines.Chrysler_V8_pak:0x00000A97r; // "Power_Steering_pump" //
			engine_part_list[ 31] = parts.engines.Chrysler_V8_pak:0x0000044Dr; // "Belt_Steering_pump" //
			engine_part_list[ 32] = parts.engines.Chrysler_V8_pak:0x00000E19r; // "Radiator_HEMI" //
			
			number2 = random();
			
			if ( number2 < 0.3 )
			{
				engine_part_list[ 33] = parts.engines.Chrysler_V8_pak:0x00000107r; // "Transmission_A727_4spd" //
			}
			else if ( number2 < 0.65 )
			{
				engine_part_list[ 33] = parts.engines.Chrysler_V8_pak:0x00000F89r; // "Transmission_A833_4spd" //
			}
			else if ( number2 < 0.85 )
			{
				engine_part_list[ 33] = parts.engines.Chrysler_V8_pak:0x00000F90r; // "Transmission_TKO500_5spd" //
			}
			else
			{
				engine_part_list[ 33] = parts.engines.Chrysler_V8_pak:0x00000F91r; // "Transmission_TKO600_5spd" //
			}
		}
		else
		{
			Logger.log("Error getting Chrysler engine: unknown engine code (" + code + ")");
		}

		return engine_part_list;
	}
}
