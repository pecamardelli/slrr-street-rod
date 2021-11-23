package java.game.parts;

import java.util.*;
import java.game.*;
import java.game.parts.engines.*;

public class EngineModels extends Part
{
	final static int engineCode			= 0;
	final static int GM_V8_283			= engineCode++;
	final static int GM_V8_307			= engineCode++;
	final static int GM_V8_327			= engineCode++;
	final static int GM_V8_327_VETTE_63 = engineCode++;
	final static int GM_V8_350			= engineCode++;
	final static int GM_V8_389			= engineCode++;
	final static int GM_V8_396			= engineCode++;
	final static int GM_V8_427			= engineCode++;
	final static int GM_V8_454			= engineCode++;
	final static int GM_V8_500			= engineCode++;
	
	final static int CHRYSLER_V8_318	= engineCode++;
	final static int CHRYSLER_V8_340	= engineCode++;
	final static int CHRYSLER_V8_360	= engineCode++;
	final static int CHRYSLER_V8_361	= engineCode++;
	final static int CHRYSLER_V8_383	= engineCode++;
	final static int CHRYSLER_V8_400	= engineCode++;
	final static int CHRYSLER_V8_426	= engineCode++;
	final static int CHRYSLER_V8_440	= engineCode++;

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
	
	public static int[] getGmEngine( int code ){
		int[] engine_part_list = new int[34];
		int index;
		float number1;
		float number2;
		float number3;

		engine_part_list[ 0] = parts:0x000053FFr; // "stock battery" //

		if (code == GM_V8_283 || code == GM_V8_307)
		{
			index = 1;
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000003Fr; // "GM 283-307 small block" //

			if ( code == GM_V8_283 )
			{
				engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000003Er; // "GM 283 cui small block crankshaft" //
				engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00000055r; // "V8 Small Block Rods" //
			}
			else
			{
				engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000A03Er; // "GM 302 crankshaft" //
				engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000A055r; // "V8 302 Rods" //
			}
			
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000E23Er; // "GM Small Block Crank Gear" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00000003r; // "V8 Camshaft" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000E103r; // "GM Small block stock camshaft timing gear" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00000056r; // "GM Small block stock pistons (283, 302)" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000000ADr; // "V8 Small Block Left head" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000000AFr; // "V8 Small Block Right Head" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000000BDr; // "V8 Small Block Left head Cover" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000C1BDr; // "GM Small block left cylinder head cover cup" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000000BCr; // "V8 Small Block Right head Cover" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000000B0r; // "V8 Small Block Left Exhaust Header" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000000B2r; // "V8 Small Block Right Exhaust Header" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00000043r; // "V8 Small block stock timing chain" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000F303r; // "GM 283-302 Small block stock timing chain cover" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000F103r; // "GM Small block stock harmonic damper" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000E303r; // "GM Small block stock water pump" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00009049r; // "GM Small block stock cooling fan" //

			number1 = random();
					
			if ( number1 < 0.27 )
			{
				engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000A0A1r; // "V8 Small Block 2brl Intake Manifold" //
				engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000000A3r; // "Stock 2brl Carb" //
				engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00000086r; // "GM stock air filter" //
			}
			else if ( number1 < 0.48 )
			{
				engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000000BEr; // "Edelbrock 3x2brl V8 intake" //
				engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000108Br; // "holley 2300 2brl 3 carb set" //
				engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000020A5r; // "summit polished-aluminium air filter" //
			}
			else if ( number1 < 0.78 )
			{
				engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000004Br; // "GM Small block stock 4brl intake manifold" //
				
				number2 = random();
					
				if ( number2 < 0.62 )
				{
					engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000A0A3r; // "stock 4brl carb" //
				}
				else
				{
					engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000B1A3r; // "Holley dominator" //
				}
				
				number2 = random();
				
				if ( number2 < 0.33 )
				{
					engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00000086r; // "GM stock air filter" //
				}
				else if ( number2 < 0.66 )
				{
					engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000030A5r; // "GM stock low-resistance air filter" //
				}
				else
				{
					engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000080A5r; // "GM stock hi-flow air filter" //
				}
			}
			else
			{
				// Fuelie
				engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000B0BEr; // "Holley_sb_fi_manifold 283 302" //
				engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000B2A3r; // "Holley_fuel_rail" //
			}

			
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000000C7r; // "Stock Ignition Distributor" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000004Ar; // "Stock Oil Filter" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00000083r; // "V8 Small Block Flywheel" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00000084r; // "V8 Small Block Clutch" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00000089r; // "V8 3speed Tranny" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00000048r; // "V8 Small Block Oil Pan" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00000047r; // "Alternator" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00000049r; // "Alternator Belt" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000B103r; // "Radiator" //
		}
		else if (code == GM_V8_327)
		{
			index = 1;
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000A03Fr; // "GM 327 Block" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000B03Er; // "GM 327 Crank" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000AA01r; // "GM_small_block_crank_gear" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000A003r; // "GM small block camshaft" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000AA02r; // "GM_small_block_cam_gear" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00001055r; // "GM 327 connecting rods" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00001056r; // "GM 327 pistons" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000A0ADr; // "GM_small_block_L_head" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000A0AFr; // "GM_small_block_R_head" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000A0BDr; // "GM_small_block_L_cover" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000C1BDr; // "GM Small block left cylinder head cover cup" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000A1BDr; // "GM_small_block_R_cover" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000A0B0r; // "GM_small_block_L_header" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000A0B2r; // "GM_small_block_R_header" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000A043r; // "GM small block chain" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00001303r; // "GM_small_block_timing_cover" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000F113r; // "GM_small_block_stock_harmonic_damper_327-350" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000021B7r; // "GM_small_block_pump" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000021BBr; // "GM_small_block_fan" //

			number1 = random();
					
			if ( number1 < 0.17 )
			{
				engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000000A1r; // "V8 Small Block 2brl Intake Manifold (327-396)" //
				engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000000A3r; // "Stock 2brl Carb" //
				engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00000086r; // "GM stock air filter" //
			}
			else if ( number1 < 0.53 )
			{
				number2 = random();
					
				if ( number2 < 0.62 )
				{
					engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000A0BEr; // "Holley aluminium dual-plane intake manifold" //
				}
				else
				{
					engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000104Br; // "GM Small block stock 4brl intake manifold (327-396)" //
				}			
				
				number2 = random();
					
				if ( number2 < 0.62 )
				{
					engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000A0A3r; // "stock 4brl carb" //
				}
				else
				{
					engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000B1A3r; // "Holley dominator" //
				}
				
				number2 = random();
				
				if ( number2 < 0.33 )
				{
					engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00000086r; // "GM stock air filter" //
				}
				else if ( number2 < 0.66 )
				{
					engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000030A5r; // "GM stock low-resistance air filter" //
				}
				else
				{
					engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000080A5r; // "GM stock hi-flow air filter" //
				}
			}
			else
			{
				engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000B04Br; // "Edelbrock Dual Quad intake manifold (327, 350)" //
				
				number2 = random();
					
				if ( number2 < 0.62 )
				{
					engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000A1A3r; // "Stock 2x4brl carbs" //
				}
				else
				{
					engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000C1A3r; // "Holley 750 cfm carburettors //
				}
				
				number2 = random();
					
				if ( number2 < 0.62 )
				{
					engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000021A5r; // "Holley 2x4brl air filter" //
				}
				else
				{
					engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000020A5r; // "summit polished-aluminium air filter" //
				}
			}

			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000000C7r; // "Stock Ignition Distributor" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000004Ar; // "Stock Oil Filter" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00000083r; // "V8 Small Block Flywheel" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00000084r; // "V8 Small Block Clutch" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00001048r; // "GM Small block oil pan" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00002047r; // "GM_small_block_alternator" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00002049r; // "GM_small_block_alternator_belt" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000B103r; // "Radiator" //
		}
		else if (code == GM_V8_327_VETTE_63)
		{
			index = 1;
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000993Fr; // "Vette 63 Block" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000993Er; // "Vette 63 crank" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00009901r; // "Vette 63 crank gear" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000099E3r; // "Vette 63 camshaft" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00009902r; // "Vette 63 cam gear" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00009955r; // "Vette 63 connecting rods" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00009956r; // "Vette_63_pistons" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000099ADr; // "Vette_63_L_head" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000099AFr; // "Vette_63_R_head" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000099BDr; // "Vette_63_L_cover" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000099BCr; // "Vette_63_R_cover" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00009946r; // "Vette_63_L_header" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00009945r; // "Vette_63_R_header" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00009943r; // "Vette 63 chain" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00009903r; // "Vette chain cover" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000099F1r; // "Vette dumper" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000022B7r; // "Summit_sb_pump 327, 350" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000099F9r; // "vette stock fan" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000B1BEr; // "Holley_sb_fi_manifold 327 350" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000B3A3r; // "Holley_fuel_rail_2" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000098BBr; // "Vette 63 Oil Filter" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00000083r; // "V8 Small Block Flywheel" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00000084r; // "V8 Small Block Clutch" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00009948r; // "Vette oil pan" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00009947r; // "Vette 63 Alternator" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00009949r; // "Vette 63 Alternator Drive Belt" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000000C7r; // "Stock ignition distributor" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000339Ar; // "Vette_C3_radiator" //
			// engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000009Ar; // "GM_427_radiator" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000C5BDr; // "PROFORM GM breather" //
		}
		else if (code == GM_V8_350)
		{
			index = 1;
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000A03Fr; // "GM 327-396 Small Block" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000B13Er; // "GM 350 small block crankshaft" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000AA01r; // "GM_small_block_crank_gear" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000A003r; // "GM small block camshaft" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000AA02r; // "GM_small_block_cam_gear" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00002055r; // "GM 350 connecting rods" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00001056r; // "GM 327 pistons" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000A1ADr; // "GM_small_block_L_head II" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000A1AFr; // "GM_small_block_R_head_II" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000A0BDr; // "GM_small_block_L_cover" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000C1BDr; // "GM Small block left cylinder head cover cup" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000A1BDr; // "GM_small_block_R_cover" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000A0B0r; // "GM_small_block_L_header" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000A0B2r; // "GM_small_block_R_header" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000A043r; // "GM small block chain" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00001303r; // "GM_small_block_timing_cover" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000F113r; // "GM_small_block_stock_harmonic_damper_327-350" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000021B7r; // "GM_small_block_pump" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000021BBr; // "GM_small_block_fan" //

			number1 = random();
					
			if ( number1 < 0.48 )
			{
				number2 = random();
					
				if ( number2 < 0.52 )
				{
					engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000A0BEr; // "Holley aluminium dual-plane intake manifold" //
				}
				else
				{
					engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000104Br; // "GM Small block stock 4brl intake manifold (327-396)" //
				}			
				
				number2 = random();
					
				if ( number2 < 0.52 )
				{
					engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000A0A3r; // "stock 4brl carb" //
				}
				else
				{
					engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000B1A3r; // "Holley dominator" //
				}
				
				number2 = random();
				
				if ( number2 < 0.33 )
				{
					engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00000086r; // "GM stock air filter" //
				}
				else if ( number2 < 0.66 )
				{
					engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000030A5r; // "GM stock low-resistance air filter" //
				}
				else if ( number2 < 0.87 )
				{
					engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000080A5r; // "GM stock hi-flow air filter" //
				}
				else
				{
					number3 = random();
					
					if ( number3 < 0.5 )
					{
						engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00003AA5r; // "Summit street scoop polished single carb" //
					}
					else
					{
						engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00003BA5r; // "Summit street scoop black single carb" //
					}
				}
			}
			else
			{
				engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000B04Br; // "Edelbrock Dual Quad intake manifold (327, 350)" //
				number2 = random();
					
				if ( number2 < 0.62 )
				{
					engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000A1A3r; // "Stock 2x4brl carbs" //
				}
				else
				{
					engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000C1A3r; // "Holley 750 cfm carburettors //
				}
				
				number2 = random();
					
				if ( number2 < 0.25 )
				{
					engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000021A5r; // "Holley 2x4brl air filter" //
				}
				else if ( number2 < 0.50 )
				{
					engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000020A5r; // "summit polished-aluminium air filter" //
				}
				else
				{
					number3 = random();
					
					if ( number3 < 0.5 )
					{
						engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00004AA5r; // "Summit street scoop polished dual quad" //
					}
					else
					{
						engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00004BA5r; // "Summit street scoop black dual quad" //
					}
				}
			}

			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000000C7r; // "Stock Ignition Distributor" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000004Ar; // "Stock Oil Filter" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00000083r; // "V8 Small Block Flywheel" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00000084r; // "V8 Small Block Clutch" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00001048r; // "GM Small block oil pan" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00002047r; // "GM_small_block_alternator" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00002049r; // "GM_small_block_alternator_belt" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000B103r; // "Radiator" //
		}
		else if (code == GM_V8_389)
		{
			index = 1;
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000A13Fr; // "GTO65_block" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000D13Er; // "GTO65_crank" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00003355r; // "GTO65_rods" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00001056r; // "GM 327 pistons" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000B04Ar; // "MOROSO oil filter" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000010A1r; // "GTO65_intake" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000108Br; // "Holley 3x2brl carbs" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000020A5r; // "Summit 2x4 3x2 air filter" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000AA01r; // "GM_small_block_crank_gear" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000A003r; // "GM small block camshaft" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000AA02r; // "GM_small_block_cam_gear" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000A043r; // "GM small block chain" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000ADADr; // "GTO65_L_head" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000F0B0r; // "GTO65_L_header" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000AABDr; // "GTO65_L_cover" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000A148r; // "GTO65_oil_pan" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000ADAFr; // "GTO65_R_head" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000ABBDr; // "GTO65_R_cover" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000F0B2r; // "GTO65_R_header" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000133Er; // "GTO65_timing_cover" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00002BB7r; // "GTO65_pump" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000021BBr; // "GM_small_block_fan" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00002047r; // "GM_small_block_alternator" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00001F13r; // "TCI_sb_damper 327-350" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00002049r; // "GM_small_block_alternator_belt" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000000C7r; // "stock ignition distributor" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000B103r; // "radiator" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00000083r; // "flywheel" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00000084r; // "clutch" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00000099r; // "GM 4spd tranny" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000C5BDr; // "PROFORM GM breather" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000C5BDr; // "PROFORM GM breather" //
		}
		else if (code == GM_V8_396)
		{
			index = 1;
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000A03Fr; // "GM 327-396 Small Block" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000C13Er; // "GM 396 small block crankshaft" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000AA01r; // "GM_small_block_crank_gear" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000A003r; // "GM small block camshaft" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000AA02r; // "GM_small_block_cam_gear" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00003055r; // "GM 396 connecting rods" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00001056r; // "GM 327-396 pistons" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000A1ADr; // "GM_small_block_L_head II" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000A1AFr; // "GM_small_block_R_head_II" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000A0BDr; // "GM_small_block_L_cover" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000C1BDr; // "GM Small block left cylinder head cover cup" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000A1BDr; // "GM_small_block_R_cover" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000A0B0r; // "GM_small_block_L_header" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000A0B2r; // "GM_small_block_R_header" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000A043r; // "GM small block chain" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00001303r; // "GM_small_block_timing_cover" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000F113r; // "GM_small_block_stock_harmonic_damper_327-350" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000021B7r; // "GM_small_block_pump" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000021BBr; // "GM_small_block_fan" //

			number1 = random();
			
			if ( number1 < 0.32 )
			{
				number2 = random();
					
				if ( number2 < 0.62 )
				{
					engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000A0BEr; // "Holley aluminium dual-plane intake manifold" //
				}
				else
				{
					engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000104Br; // "GM Small block stock 4brl intake manifold (327-396)" //
				}			
				
				number2 = random();
					
				if ( number2 < 0.62 )
				{
					engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000A0A3r; // "stock 4brl carb" //
				}
				else
				{
					engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000B1A3r; // "Holley dominator" //
				}
				
				number2 = random();
				
				if ( number2 < 0.33 )
				{
					engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00000086r; // "GM stock air filter" //
				}
				else if ( number2 < 0.66 )
				{
					engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000030A5r; // "GM stock low-resistance air filter" //
				}
				else if ( number2 < 0.87 )
				{
					engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000080A5r; // "GM stock hi-flow air filter" //
				}
				else
				{
					number3 = random();
					
					if ( number3 < 0.5 )
					{
						engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00003AA5r; // "Summit street scoop polished single carb" //
					}
					else
					{
						engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00003BA5r; // "Summit street scoop black single carb" //
					}
				}
			}
			else
			{
				engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000B04Br; // "Edelbrock Dual Quad intake manifold (327, 350)" //
				
				number2 = random();
					
				if ( number2 < 0.62 )
				{
					engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000A1A3r; // "Stock 2x4brl carbs" //
				}
				else
				{
					engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000C1A3r; // "Holley 750 cfm carburettors //
				}
				
				number2 = random();
					
				if ( number2 < 0.25 )
				{
					engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000021A5r; // "Holley 2x4brl air filter" //
				}
				else if ( number2 < 0.50 )
				{
					engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000020A5r; // "summit polished-aluminium air filter" //
				}
				else
				{
					number3 = random();
				
					if ( number3 < 0.5 )
					{
						engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00004AA5r; // "Summit street scoop polished dual quad" //
					}
					else
					{
						engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00004BA5r; // "Summit street scoop black dual quad" //
					}
				}
			}

			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000000C7r; // "Stock Ignition Distributor" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000004Ar; // "Stock Oil Filter" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00000083r; // "V8 Small Block Flywheel" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00000084r; // "V8 Small Block Clutch" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00001048r; // "GM Small block oil pan" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00002047r; // "GM_small_block_alternator" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00002049r; // "GM_small_block_alternator_belt" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000B103r; // "Radiator" //
		}
		else if (code == GM_V8_427)
		{
			index = 1;
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000000Ar; // "GM 427 Block" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000000Br; // "GM_427_crankshaft" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000000B3r; // "GM_427_crank_gear" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000000B4r; // "GM_427_cam //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000000B5r; // "GM_427_cam_gear" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000000A8r; // "GM_427_rods" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000000AAr; // "GM_427_pistons" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000004Fr; // "GM_427_L_head" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00000052r; // "GM_427_R_head" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00003042r; // "GM_427_L_head_cover" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000004Er; // "GM_427_L_head_cover_cup" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00003044r; // "GM_427_R_head_cover" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00003046r; // "GM 427 L header" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00003045r; // "GM_427_R_header" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000000B7r; // "GM_427_chain" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000000BAr; // "GM_427_timing_cover" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000000BBr; // "GM_427_damper" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000010B7r; // "GM_427_pump" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000010BBr; // "GM_427_fan" //
			
			number1 = random();
					
			if ( number1 < 0.25 )
			{
				engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000030A1r; // "GM_427_4brl_intake" //
				
				number2 = random();
					
				if ( number2 < 0.62 )
				{
					engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000A0A3r; // "stock 4brl carb" //
				}
				else
				{
					engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000B1A3r; // "Holley dominator" //
				}
				
				number2 = random();
				
				if ( number2 < 0.33 )
				{
					engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00000086r; // "GM stock air filter" //
				}
				else if ( number2 < 0.66 )
				{
					engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000030A5r; // "GM stock low-resistance air filter" //
				}
				else if ( number2 < 0.87 )
				{
					engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000080A5r; // "GM stock hi-flow air filter" //
				}
				else
				{
					number3 = random();
					
					if ( number3 < 0.5 )
					{
						engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00003AA5r; // "Summit street scoop polished single carb" //
					}
					else
					{
						engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00003BA5r; // "Summit street scoop black single carb" //
					}
				}
			}
			else
			{
				number2 = random();
					
				if ( number2 < 0.62 )
				{
					engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000036A1r; // "GM_427_2x4brl_intake" //
				}
				else
				{
					engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000B0A1r; // "TrickFlow_427_Dual_Tunnel_Ram" //
				}
				
				number2 = random();
					
				if ( number2 < 0.62 )
				{
					engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000A1A3r; // "Stock 2x4brl carbs" //
				}
				else if ( number2 < 0.78 )
				{
					engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000C1A3r; // "Holley 750 cfm carburettors //
				}
				else
				{
					engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000C004r; // "Weiand methanol system" //
				}
				
				number2 = random();
					
				if ( number2 < 0.25 )
				{
					engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000021A5r; // "Holley 2x4brl air filter" //
				}
				else if ( number2 < 0.50 )
				{
					engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000020A5r; // "summit polished-aluminium air filter" //
				}
				else
				{
					number3 = random();
					
					if ( number3 < 0.5 )
					{
						engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00004AA5r; // "Summit street scoop polished dual quad" //
					}
					else
					{
						engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00004BA5r; // "Summit street scoop black dual quad" //
					}
				}
			}

			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000104Dr; // "Mallory_427_Distributor" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000020BBr; // "GM_427_oil_filter" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000000A6r; // "GM_427_flywheel" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000000A7r; // "GM_427_clutch" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00003048r; // "GM 427 oil pan" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00003047r; // "GM 427 alternator" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00000097r; // "GM_427_alternator_drive_belt" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000009Ar; // "GM_427_radiator" //
		}
		else if (code == GM_V8_454)
		{
			index = 1;
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000200Ar; // "Motown 454 Cast Iron Block" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000100Br; // "Eagle_4340_crankshaft" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000010A8r; // "Eagle_4340_rods" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000010AAr; // "Keith_Black_427_pistons" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000020BBr; // "GM_427_oil_filter" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000030A1r; // "GM_427_4brl_intake" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000A0A3r; // "Stock 4brl carb" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000001A5r; // "MOROSO air filter" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000000B3r; // "GM_427_crank_gear" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000000B4r; // "GM_427_cam //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000000B5r; // "GM_427_cam_gear" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000000B7r; // "GM_427_chain" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000304Fr; // "DART_L_head" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00003046r; // "GM 427 L header" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00003B42r; // "Edelbrock_427_L_cover" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00003048r; // "GM 427 oil pan" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00003052r; // "DART_R_head" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00003045r; // "GM_427_R_header" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00003B44r; // "Edelbrock_427_R_cover" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000000BAr; // "GM_427_timing_cover" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000010B7r; // "GM_427_pump" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000010BBr; // "GM_427_fan" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00003047r; // "GM 427 alternator" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000000BBr; // "GM_427_damper" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00000097r; // "GM_427_alternator_drive_belt" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000104Dr; // "Mallory_427_Distributor" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000009Ar; // "GM_427_radiator" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000000A6r; // "GM_427_flywheel" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000000A7r; // "GM_427_clutch" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000104Er; // "Hardcore_Breather" //
		}
		else if (code == GM_V8_500)
		{
			index = 1;
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000800Ar; // "GM_500_block" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000800Br; // "GM_500_crankshaft" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000080A8r; // "GM_500_rods" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000080AAr; // "GM_500_pistons" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000020BBr; // "GM_427_oil_filter" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000080A1r; // "GM_500_4brl_intake" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000A0A3r; // "Stock 4brl carb" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000001A5r; // "MOROSO air filter" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000080B3r; // "GM_500_crank_gear" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000080B4r; // "GM_500_cam //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000080B5r; // "GM_500_cam_gear" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000080B7r; // "GM_500_chain" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000804Fr; // "GM_500_L_head" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00008A46r; // "GM 500 L header" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00008042r; // "GM_500_L_cover" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00008048r; // "GM 500 oil pan" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00008052r; // "GM_500_R_head" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00008045r; // "GM_500_R_header" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00008044r; // "GM_500_R_cover" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000080BAr; // "GM_500_timing_cover" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000081B7r; // "GM_500_pump" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000081BBr; // "GM_500_fan" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00008047r; // "GM 500 alternator" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000080BBr; // "GM_500_damper" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00008097r; // "GM_500_alternator_drive_belt" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000804Dr; // "GM_500_Distributor" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000E123r; // "BE Cool radiator" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000080A6r; // "GM_500_flywheel" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x000080A7r; // "GM_500_clutch" //
			engine_part_list[ index++] = parts.engines.GM_V8_pak:0x0000104Er; // "Hardcore_Breather" //
		}
		else
		{
			Logger.log("Error getting GM engine: unknown engine code (" + code + ")");
		}

		//////////////////////
		// TRANSMISSION SET //
		//////////////////////
		
		if ( code < GM_V8_427 )
		{
			number1 = random();
					
			if ( number1 < 0.18 )
			{
				engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00000089r; // "V8 3speed Tranny" //	
			}
			else if ( number1 < 0.36 )
			{
				engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00000099r; // "V8 4speed Tranny" //
			}
			else if ( number1 < 0.54 )
			{
				engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00001099r; // "Richmond Gear Super T-10 4-Speed Tranny (GM 283-396)" //
			}
			else if ( number1 < 0.72 )
			{
				engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00001A99r; // "Richmond Gear Super T-10 Plus 4-Speed (GM 283-396)" //
			}
			else if ( number1 < 0.82 )
			{
				engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00001B99r; // "Richmond Gear 5-Speed Tranny (GM 283-396)" //
			}
			else if ( number1 < 0.92 )
			{
				engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00001C99r; // "Richmond Gear Street 5-Speed Tranny (GM 283-396)" //
			}
			else
			{
				engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00001D99r; // "Richmond Gear 6-Speed ROD Transmissions (GM 283-396)" //
			}
		}
		else if ( code == GM_V8_427 || code == GM_V8_454)
		{
			number1 = random();
					
			if ( number1 < 0.18 )
			{
				engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00000098r; // "GM TH-400 (3L80) 3 spd. tranny (427-454)" //
			}
			else if ( number1 < 0.36 )
			{
				engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00003798r; // "GM TH-700-R4 (4L60) 4 spd. tranny (427-454)" //
			}
			else if ( number1 < 0.54 )
			{
				engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00003998r; // "Richmond Gear Super T-10 4-Speed tranny (427-454)" //
			}
			else if ( number1 < 0.72 )
			{
				engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00003A98r; // "Tremec TKO 600 5spd. Tranny (GM 427/454)" //
			}
			else if ( number1 < 0.82 )
			{
				engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00003B98r; // "Richmond Gear Super Street 5-Speed Tranny (GM 427/454)" //
			}
			else if ( number1 < 0.92 )
			{
				engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00003098r; // "Tremec T-56 6spd. Tranny (GM 427/454)" //
			}
			else
			{
				engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00003898r; // "Richmond Gear 6-Speed ROD Tranny (GM 427/454)" //
			}
		}
		else
		{
			number1 = random();
					
			if ( number1 < 0.18 )
			{
				engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00008198r; // "GM TH-125C (3T40) 3spd. FWD stock tranny (500+)" //
			}
			else
			{
				engine_part_list[ index++] = parts.engines.GM_V8_pak:0x00008098r; // "GM 4L30-E 4spd. stock tranny (500+)" //
			}
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
		float number1;
		float number2;
		float number3;
		
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
			
			number1 = random();
		
			if ( number1 < 0.5 )
			{
				engine_part_list[ 33] = parts.engines.Chrysler_V8_pak:0x00000099r; // "Transmission_A230_3spd" //
			}
			else if ( number1 < 0.9 )
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
			
			number1 = random();
		
			if ( number1 < 0.5 )
			{
				engine_part_list[ 33] = parts.engines.Chrysler_V8_pak:0x00000099r; // "Transmission_A230_3spd" //
			}
			else if ( number1 < 0.9 )
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
			
			number1 = random();
			
			if ( number1 < 0.3 )
			{
				engine_part_list[ 33] = parts.engines.Chrysler_V8_pak:0x00000099r; // "Transmission_A230_3spd" //
			}
			else if ( number1 < 0.6 )
			{
				engine_part_list[ 33] = parts.engines.Chrysler_V8_pak:0x00000104r; // "Transmission_A727_3spd" //
			}
			else if ( number1 < 0.8 )
			{
				engine_part_list[ 33] = parts.engines.Chrysler_V8_pak:0x00000107r; // "Transmission_A727_4spd" //
			}
			else if ( number1 < 0.95 )
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
			
			number1 = random();
			
			if ( number1 < 0.3 )
			{
				engine_part_list[ 33] = parts.engines.Chrysler_V8_pak:0x00000107r; // "Transmission_A727_4spd" //
			}
			else if ( number1 < 0.65 )
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
						
			number1 = random();
			
			if ( number1 < 0.3 )
			{
				engine_part_list[ 33] = parts.engines.Chrysler_V8_pak:0x00000107r; // "Transmission_A727_4spd" //
			}
			else if ( number1 < 0.65 )
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
			
			number1 = random();
			
			if ( number1 < 0.3 )
			{
				engine_part_list[ 33] = parts.engines.Chrysler_V8_pak:0x00000099r; // "Transmission_A230_3spd" //
			}
			else if ( number1 < 0.6 )
			{
				engine_part_list[ 33] = parts.engines.Chrysler_V8_pak:0x00000104r; // "Transmission_A727_3spd" //
			}
			else if ( number1 < 0.8 )
			{
				engine_part_list[ 33] = parts.engines.Chrysler_V8_pak:0x00000107r; // "Transmission_A727_4spd" //
			}
			else if ( number1 < 0.95 )
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
			
			number1 = random();
			
			if ( number1 < 0.3 )
			{
				engine_part_list[ 33] = parts.engines.Chrysler_V8_pak:0x00000107r; // "Transmission_A727_4spd" //
			}
			else if ( number1 < 0.65 )
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
			
			number1 = random();
			
			if ( number1 < 0.3 )
			{
				engine_part_list[ 33] = parts.engines.Chrysler_V8_pak:0x00000107r; // "Transmission_A727_4spd" //
			}
			else if ( number1 < 0.65 )
			{
				engine_part_list[ 33] = parts.engines.Chrysler_V8_pak:0x00000F89r; // "Transmission_A833_4spd" //
			}
			else if ( number1 < 0.85 )
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
