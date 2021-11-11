package java.game.parts;

import java.util.*;
import java.game.*;
import java.game.parts.*;

public class EngineModels extends Part
{
	private float number;
	private float number2;
	private float number3;
	private float number4;
	private int motor;
	
	public int[] getGmEngine(){
		number = random();
		int[] stock_parts_list_E  = new int[34];
		stock_parts_list_E[ 0] = parts:0x000053FFr; // "stock battery" //
		
		motor = 0;
		
		if ( number < 0.2 )
		{
			stock_parts_list_E  = new int[34];
			stock_parts_list_E[ 0] = parts:0x000053FFr; // "stock battery" //
			stock_parts_list_E[ 1] = parts.engines.GM_V8_pak:0x0000003Fr; // "GM 283-307 small block" //
			
			number2 = random();
					
			if ( number2 < 0.52 )
			{
				stock_parts_list_E[ 2] = parts.engines.GM_V8_pak:0x0000003Er; // "GM 283 cui small block crankshaft" //
				stock_parts_list_E[ 6] = parts.engines.GM_V8_pak:0x00000055r; // "V8 Small Block Rods" //
				motor = 283;
			}
			else
			{
				stock_parts_list_E[ 2] = parts.engines.GM_V8_pak:0x0000A03Er; // "GM 302 crankshaft" //
				stock_parts_list_E[ 6] = parts.engines.GM_V8_pak:0x0000A055r; // "V8 302 Rods" //
				motor = 302;
			}
			
			stock_parts_list_E[ 3] = parts.engines.GM_V8_pak:0x0000E23Er; // "GM Small Block Crank Gear" //
			stock_parts_list_E[ 4] = parts.engines.GM_V8_pak:0x00000003r; // "V8 Camshaft" //
			stock_parts_list_E[ 5] = parts.engines.GM_V8_pak:0x0000E103r; // "GM Small block stock camshaft timing gear" //
			stock_parts_list_E[ 7] = parts.engines.GM_V8_pak:0x00000056r; // "GM Small block stock pistons (283, 302)" //
			stock_parts_list_E[ 8] = parts.engines.GM_V8_pak:0x000000ADr; // "V8 Small Block Left head" //
			stock_parts_list_E[ 9] = parts.engines.GM_V8_pak:0x000000AFr; // "V8 Small Block Right Head" //
			stock_parts_list_E[ 10] = parts.engines.GM_V8_pak:0x000000BDr; // "V8 Small Block Left head Cover" //
			stock_parts_list_E[ 11] = parts.engines.GM_V8_pak:0x0000C1BDr; // "GM Small block left cylinder head cover cup" //
			stock_parts_list_E[ 12] = parts.engines.GM_V8_pak:0x000000BCr; // "V8 Small Block Right head Cover" //
			stock_parts_list_E[ 13] = parts.engines.GM_V8_pak:0x000000B0r; // "V8 Small Block Left Exhaust Header" //
			stock_parts_list_E[ 14] = parts.engines.GM_V8_pak:0x000000B2r; // "V8 Small Block Right Exhaust Header" //
			stock_parts_list_E[ 15] = parts.engines.GM_V8_pak:0x00000043r; // "V8 Small block stock timing chain" //
			stock_parts_list_E[ 16] = parts.engines.GM_V8_pak:0x0000F303r; // "GM 283-302 Small block stock timing chain cover" //
			stock_parts_list_E[ 17] = parts.engines.GM_V8_pak:0x0000F103r; // "GM Small block stock harmonic damper" //
			stock_parts_list_E[ 18] = parts.engines.GM_V8_pak:0x0000E303r; // "GM Small block stock water pump" //
			stock_parts_list_E[ 19] = parts.engines.GM_V8_pak:0x00009049r; // "GM Small block stock cooling fan" //
			stock_parts_list_E[ 32] = parts.engines.GM_V8_pak:0x000000C7r; // "Stock Ignition Distributor" //
			stock_parts_list_E[ 21] = parts.engines.GM_V8_pak:0x0000004Ar; // "Stock Oil Filter" //
			stock_parts_list_E[ 22] = parts.engines.GM_V8_pak:0x00000083r; // "V8 Small Block Flywheel" //
			stock_parts_list_E[ 23] = parts.engines.GM_V8_pak:0x00000084r; // "V8 Small Block Clutch" //
			stock_parts_list_E[ 24] = parts.engines.GM_V8_pak:0x00000089r; // "V8 3speed Tranny" //
			stock_parts_list_E[ 25] = parts.engines.GM_V8_pak:0x00000048r; // "V8 Small Block Oil Pan" //
			stock_parts_list_E[ 26] = parts.engines.GM_V8_pak:0x00000047r; // "Alternator" //
			stock_parts_list_E[ 27] = parts.engines.GM_V8_pak:0x00000049r; // "Alternator Belt" //
			stock_parts_list_E[ 28] = parts.engines.GM_V8_pak:0x0000B103r; // "Radiator" //

			number2 = random();
					
			if ( number2 < 0.27 )
			{
				stock_parts_list_E[ 29] = parts.engines.GM_V8_pak:0x0000A0A1r; // "V8 Small Block 2brl Intake Manifold" //
				stock_parts_list_E[ 30] = parts.engines.GM_V8_pak:0x000000A3r; // "Stock 2brl Carb" //
				stock_parts_list_E[ 31] = parts.engines.GM_V8_pak:0x00000086r; // "GM stock air filter" //
			}
			else if ( number2 < 0.48 )
			{
				stock_parts_list_E[ 29] = parts.engines.GM_V8_pak:0x000000BEr; // "Edelbrock 3x2brl V8 intake" //
				stock_parts_list_E[ 30] = parts.engines.GM_V8_pak:0x0000108Br; // "holley 2300 2brl 3 carb set" //
				stock_parts_list_E[ 31] = parts.engines.GM_V8_pak:0x000020A5r; // "summit polished-aluminium air filter" //
			}
			else if ( number2 < 0.78 )
			{
				stock_parts_list_E[ 29] = parts.engines.GM_V8_pak:0x0000004Br; // "GM Small block stock 4brl intake manifold" //
				
				number3 = random();
					
				if ( number3 < 0.62 )
				{
					stock_parts_list_E[ 30] = parts.engines.GM_V8_pak:0x0000A0A3r; // "stock 4brl carb" //
				}
				else
				{
					stock_parts_list_E[ 30] = parts.engines.GM_V8_pak:0x0000B1A3r; // "Holley dominator" //
				}
				
				number3 = random();
				
				if ( number3 < 0.33 )
				{
					stock_parts_list_E[ 31] = parts.engines.GM_V8_pak:0x00000086r; // "GM stock air filter" //
				}
				else if ( number3 < 0.66 )
				{
					stock_parts_list_E[ 31] = parts.engines.GM_V8_pak:0x000030A5r; // "GM stock low-resistance air filter" //
				}
				else
				{
					stock_parts_list_E[ 31] = parts.engines.GM_V8_pak:0x000080A5r; // "GM stock hi-flow air filter" //
				}
			}
			else
			{
				// Fuelie
				stock_parts_list_E[ 29] = parts.engines.GM_V8_pak:0x0000B0BEr; // "Holley_sb_fi_manifold 283 302" //
				stock_parts_list_E[ 30] = parts.engines.GM_V8_pak:0x0000B2A3r; // "Holley_fuel_rail" //
			}
		}
		else if ( number < 0.3 )
		{
			motor = 327;
			stock_parts_list_E[ 1] = parts.engines.GM_V8_pak:0x0000A03Fr; // "GM 327 Block" //
			stock_parts_list_E[ 2] = parts.engines.GM_V8_pak:0x0000B03Er; // "GM 327 Crank" //
			stock_parts_list_E[ 3] = parts.engines.GM_V8_pak:0x0000AA01r; // "GM_small_block_crank_gear" //
			stock_parts_list_E[ 4] = parts.engines.GM_V8_pak:0x0000A003r; // "GM small block camshaft" //
			stock_parts_list_E[ 5] = parts.engines.GM_V8_pak:0x0000AA02r; // "GM_small_block_cam_gear" //
			stock_parts_list_E[ 6] = parts.engines.GM_V8_pak:0x00001055r; // "GM 327 connecting rods" //
			stock_parts_list_E[ 7] = parts.engines.GM_V8_pak:0x00001056r; // "GM 327 pistons" //
			stock_parts_list_E[ 8] = parts.engines.GM_V8_pak:0x0000A0ADr; // "GM_small_block_L_head" //
			stock_parts_list_E[ 9] = parts.engines.GM_V8_pak:0x0000A0AFr; // "GM_small_block_R_head" //
			stock_parts_list_E[ 10] = parts.engines.GM_V8_pak:0x0000A0BDr; // "GM_small_block_L_cover" //
			stock_parts_list_E[ 11] = parts.engines.GM_V8_pak:0x0000C1BDr; // "GM Small block left cylinder head cover cup" //
			stock_parts_list_E[ 12] = parts.engines.GM_V8_pak:0x0000A1BDr; // "GM_small_block_R_cover" //
			stock_parts_list_E[ 13] = parts.engines.GM_V8_pak:0x0000A0B0r; // "GM_small_block_L_header" //
			stock_parts_list_E[ 14] = parts.engines.GM_V8_pak:0x0000A0B2r; // "GM_small_block_R_header" //
			stock_parts_list_E[ 15] = parts.engines.GM_V8_pak:0x0000A043r; // "GM small block chain" //
			stock_parts_list_E[ 16] = parts.engines.GM_V8_pak:0x00001303r; // "GM_small_block_timing_cover" //
			stock_parts_list_E[ 17] = parts.engines.GM_V8_pak:0x0000F113r; // "GM_small_block_stock_harmonic_damper_327-350" //
			stock_parts_list_E[ 18] = parts.engines.GM_V8_pak:0x000021B7r; // "GM_small_block_pump" //
			stock_parts_list_E[ 19] = parts.engines.GM_V8_pak:0x000021BBr; // "GM_small_block_fan" //
			stock_parts_list_E[ 32] = parts.engines.GM_V8_pak:0x000000C7r; // "Stock Ignition Distributor" //
			stock_parts_list_E[ 21] = parts.engines.GM_V8_pak:0x0000004Ar; // "Stock Oil Filter" //
			stock_parts_list_E[ 22] = parts.engines.GM_V8_pak:0x00000083r; // "V8 Small Block Flywheel" //
			stock_parts_list_E[ 23] = parts.engines.GM_V8_pak:0x00000084r; // "V8 Small Block Clutch" //
			stock_parts_list_E[ 24] = parts.engines.GM_V8_pak:0x00001048r; // "GM Small block oil pan" //
			stock_parts_list_E[ 25] = parts.engines.GM_V8_pak:0x00002047r; // "GM_small_block_alternator" //
			stock_parts_list_E[ 26] = parts.engines.GM_V8_pak:0x00002049r; // "GM_small_block_alternator_belt" //
			stock_parts_list_E[ 27] = parts.engines.GM_V8_pak:0x0000B103r; // "Radiator" //
			
			number2 = random();
					
			if ( number2 < 0.17 )
			{
				stock_parts_list_E[ 28] = parts.engines.GM_V8_pak:0x000000A1r; // "V8 Small Block 2brl Intake Manifold (327-396)" //
				stock_parts_list_E[ 29] = parts.engines.GM_V8_pak:0x000000A3r; // "Stock 2brl Carb" //
				stock_parts_list_E[ 30] = parts.engines.GM_V8_pak:0x00000086r; // "GM stock air filter" //
			}
			else if ( number2 < 0.53 )
			{
				number3 = random();
					
				if ( number3 < 0.62 )
				{
					stock_parts_list_E[ 28] = parts.engines.GM_V8_pak:0x0000A0BEr; // "Holley aluminium dual-plane intake manifold" //
				}
				else
				{
					stock_parts_list_E[ 28] = parts.engines.GM_V8_pak:0x0000104Br; // "GM Small block stock 4brl intake manifold (327-396)" //
				}			
				
				number3 = random();
					
				if ( number3 < 0.62 )
				{
					stock_parts_list_E[ 29] = parts.engines.GM_V8_pak:0x0000A0A3r; // "stock 4brl carb" //
				}
				else
				{
					stock_parts_list_E[ 29] = parts.engines.GM_V8_pak:0x0000B1A3r; // "Holley dominator" //
				}
				
				number3 = random();
				
				if ( number3 < 0.33 )
				{
					stock_parts_list_E[ 30] = parts.engines.GM_V8_pak:0x00000086r; // "GM stock air filter" //
				}
				else if ( number3 < 0.66 )
				{
					stock_parts_list_E[ 30] = parts.engines.GM_V8_pak:0x000030A5r; // "GM stock low-resistance air filter" //
				}
				else
				{
					stock_parts_list_E[ 30] = parts.engines.GM_V8_pak:0x000080A5r; // "GM stock hi-flow air filter" //
				}
			}
			else
			{
				stock_parts_list_E[ 28] = parts.engines.GM_V8_pak:0x0000B04Br; // "Edelbrock Dual Quad intake manifold (327, 350)" //
				
				number3 = random();
					
				if ( number3 < 0.62 )
				{
					stock_parts_list_E[ 29] = parts.engines.GM_V8_pak:0x0000A1A3r; // "Stock 2x4brl carbs" //
				}
				else
				{
					stock_parts_list_E[ 29] = parts.engines.GM_V8_pak:0x0000C1A3r; // "Holley 750 cfm carburettors //
				}
				
				number3 = random();
					
				if ( number3 < 0.62 )
				{
					stock_parts_list_E[ 30] = parts.engines.GM_V8_pak:0x000021A5r; // "Holley 2x4brl air filter" //
				}
				else
				{
					stock_parts_list_E[ 30] = parts.engines.GM_V8_pak:0x000020A5r; // "summit polished-aluminium air filter" //
				}
			}
		}
		else if ( number < 0.4 )
		{
			motor = 350;
			stock_parts_list_E[ 1] = parts.engines.GM_V8_pak:0x0000A03Fr; // "GM 327-396 Small Block" //
			stock_parts_list_E[ 2] = parts.engines.GM_V8_pak:0x0000B13Er; // "GM 350 small block crankshaft" //
			stock_parts_list_E[ 3] = parts.engines.GM_V8_pak:0x0000AA01r; // "GM_small_block_crank_gear" //
			stock_parts_list_E[ 4] = parts.engines.GM_V8_pak:0x0000A003r; // "GM small block camshaft" //
			stock_parts_list_E[ 5] = parts.engines.GM_V8_pak:0x0000AA02r; // "GM_small_block_cam_gear" //
			stock_parts_list_E[ 6] = parts.engines.GM_V8_pak:0x00002055r; // "GM 350 connecting rods" //
			stock_parts_list_E[ 7] = parts.engines.GM_V8_pak:0x00001056r; // "GM 327 pistons" //
			stock_parts_list_E[ 8] = parts.engines.GM_V8_pak:0x0000A1ADr; // "GM_small_block_L_head II" //
			stock_parts_list_E[ 9] = parts.engines.GM_V8_pak:0x0000A1AFr; // "GM_small_block_R_head_II" //
			stock_parts_list_E[ 10] = parts.engines.GM_V8_pak:0x0000A0BDr; // "GM_small_block_L_cover" //
			stock_parts_list_E[ 11] = parts.engines.GM_V8_pak:0x0000C1BDr; // "GM Small block left cylinder head cover cup" //
			stock_parts_list_E[ 12] = parts.engines.GM_V8_pak:0x0000A1BDr; // "GM_small_block_R_cover" //
			stock_parts_list_E[ 13] = parts.engines.GM_V8_pak:0x0000A0B0r; // "GM_small_block_L_header" //
			stock_parts_list_E[ 14] = parts.engines.GM_V8_pak:0x0000A0B2r; // "GM_small_block_R_header" //
			stock_parts_list_E[ 15] = parts.engines.GM_V8_pak:0x0000A043r; // "GM small block chain" //
			stock_parts_list_E[ 16] = parts.engines.GM_V8_pak:0x00001303r; // "GM_small_block_timing_cover" //
			stock_parts_list_E[ 17] = parts.engines.GM_V8_pak:0x0000F113r; // "GM_small_block_stock_harmonic_damper_327-350" //
			stock_parts_list_E[ 18] = parts.engines.GM_V8_pak:0x000021B7r; // "GM_small_block_pump" //
			stock_parts_list_E[ 19] = parts.engines.GM_V8_pak:0x000021BBr; // "GM_small_block_fan" //
			stock_parts_list_E[ 32] = parts.engines.GM_V8_pak:0x000000C7r; // "Stock Ignition Distributor" //
			stock_parts_list_E[ 21] = parts.engines.GM_V8_pak:0x0000004Ar; // "Stock Oil Filter" //
			stock_parts_list_E[ 22] = parts.engines.GM_V8_pak:0x00000083r; // "V8 Small Block Flywheel" //
			stock_parts_list_E[ 23] = parts.engines.GM_V8_pak:0x00000084r; // "V8 Small Block Clutch" //
			stock_parts_list_E[ 24] = parts.engines.GM_V8_pak:0x00001048r; // "GM Small block oil pan" //
			stock_parts_list_E[ 25] = parts.engines.GM_V8_pak:0x00002047r; // "GM_small_block_alternator" //
			stock_parts_list_E[ 26] = parts.engines.GM_V8_pak:0x00002049r; // "GM_small_block_alternator_belt" //
			stock_parts_list_E[ 27] = parts.engines.GM_V8_pak:0x0000B103r; // "Radiator" //
			
			number2 = random();
					
			if ( number2 < 0.48 )
			{
				number3 = random();
					
				if ( number3 < 0.52 )
				{
					stock_parts_list_E[ 28] = parts.engines.GM_V8_pak:0x0000A0BEr; // "Holley aluminium dual-plane intake manifold" //
				}
				else
				{
					stock_parts_list_E[ 28] = parts.engines.GM_V8_pak:0x0000104Br; // "GM Small block stock 4brl intake manifold (327-396)" //
				}			
				
				number3 = random();
					
				if ( number3 < 0.52 )
				{
					stock_parts_list_E[ 29] = parts.engines.GM_V8_pak:0x0000A0A3r; // "stock 4brl carb" //
				}
				else
				{
					stock_parts_list_E[ 29] = parts.engines.GM_V8_pak:0x0000B1A3r; // "Holley dominator" //
				}
				
				number3 = random();
				
				if ( number3 < 0.33 )
				{
					stock_parts_list_E[ 30] = parts.engines.GM_V8_pak:0x00000086r; // "GM stock air filter" //
				}
				else if ( number3 < 0.66 )
				{
					stock_parts_list_E[ 30] = parts.engines.GM_V8_pak:0x000030A5r; // "GM stock low-resistance air filter" //
				}
				else if ( number3 < 0.87 )
				{
					stock_parts_list_E[ 30] = parts.engines.GM_V8_pak:0x000080A5r; // "GM stock hi-flow air filter" //
				}
				else
				{
					number4 = random();
					
					if ( number4 < 0.5 )
					{
						stock_parts_list_E[ 30] = parts.engines.GM_V8_pak:0x00003AA5r; // "Summit street scoop polished single carb" //
					}
					else
					{
						stock_parts_list_E[ 30] = parts.engines.GM_V8_pak:0x00003BA5r; // "Summit street scoop black single carb" //
					}
				}
			}
			else
			{
				stock_parts_list_E[ 28] = parts.engines.GM_V8_pak:0x0000B04Br; // "Edelbrock Dual Quad intake manifold (327, 350)" //
				number3 = random();
					
				if ( number3 < 0.62 )
				{
					stock_parts_list_E[ 29] = parts.engines.GM_V8_pak:0x0000A1A3r; // "Stock 2x4brl carbs" //
				}
				else
				{
					stock_parts_list_E[ 29] = parts.engines.GM_V8_pak:0x0000C1A3r; // "Holley 750 cfm carburettors //
				}
				
				number3 = random();
					
				if ( number3 < 0.25 )
				{
					stock_parts_list_E[ 30] = parts.engines.GM_V8_pak:0x000021A5r; // "Holley 2x4brl air filter" //
				}
				else if ( number3 < 0.50 )
				{
					stock_parts_list_E[ 30] = parts.engines.GM_V8_pak:0x000020A5r; // "summit polished-aluminium air filter" //
				}
				else
				{
					number4 = random();
					
					if ( number4 < 0.5 )
					{
						stock_parts_list_E[ 30] = parts.engines.GM_V8_pak:0x00004AA5r; // "Summit street scoop polished dual quad" //
					}
					else
					{
						stock_parts_list_E[ 30] = parts.engines.GM_V8_pak:0x00004BA5r; // "Summit street scoop black dual quad" //
					}
				}
			}
		}
		else if ( number < 0.5 )
		{
			motor = 327;
			stock_parts_list_E[ 1] = parts.engines.GM_V8_pak:0x0000993Fr; // "Vette 63 Block" //
			stock_parts_list_E[ 2] = parts.engines.GM_V8_pak:0x0000993Er; // "Vette 63 crank" //
			stock_parts_list_E[ 3] = parts.engines.GM_V8_pak:0x00009901r; // "Vette 63 crank gear" //
			stock_parts_list_E[ 4] = parts.engines.GM_V8_pak:0x000099E3r; // "Vette 63 camshaft" //
			stock_parts_list_E[ 5] = parts.engines.GM_V8_pak:0x00009902r; // "Vette 63 cam gear" //
			stock_parts_list_E[ 6] = parts.engines.GM_V8_pak:0x00009955r; // "Vette 63 connecting rods" //
			stock_parts_list_E[ 7] = parts.engines.GM_V8_pak:0x00009956r; // "Vette_63_pistons" //
			stock_parts_list_E[ 8] = parts.engines.GM_V8_pak:0x000099ADr; // "Vette_63_L_head" //
			stock_parts_list_E[ 9] = parts.engines.GM_V8_pak:0x000099AFr; // "Vette_63_R_head" //
			stock_parts_list_E[ 10] = parts.engines.GM_V8_pak:0x000099BDr; // "Vette_63_L_cover" //
			stock_parts_list_E[ 11] = parts.engines.GM_V8_pak:0x000099BCr; // "Vette_63_R_cover" //
			stock_parts_list_E[ 12] = parts.engines.GM_V8_pak:0x00009946r; // "Vette_63_L_header" //
			stock_parts_list_E[ 13] = parts.engines.GM_V8_pak:0x00009945r; // "Vette_63_R_header" //
			stock_parts_list_E[ 14] = parts.engines.GM_V8_pak:0x00009943r; // "Vette 63 chain" //
			stock_parts_list_E[ 15] = parts.engines.GM_V8_pak:0x00009903r; // "Vette chain cover" //
			stock_parts_list_E[ 16] = parts.engines.GM_V8_pak:0x000099F1r; // "Vette dumper" //
			stock_parts_list_E[ 17] = parts.engines.GM_V8_pak:0x000022B7r; // "Summit_sb_pump 327, 350" //
			stock_parts_list_E[ 18] = parts.engines.GM_V8_pak:0x000099F9r; // "vette stock fan" //
			stock_parts_list_E[ 19] = parts.engines.GM_V8_pak:0x0000B1BEr; // "Holley_sb_fi_manifold 327 350" //
			stock_parts_list_E[ 20] = parts.engines.GM_V8_pak:0x0000B3A3r; // "Holley_fuel_rail_2" //
			stock_parts_list_E[ 21] = parts.engines.GM_V8_pak:0x000098BBr; // "Vette 63 Oil Filter" //
			stock_parts_list_E[ 22] = parts.engines.GM_V8_pak:0x00000083r; // "V8 Small Block Flywheel" //
			stock_parts_list_E[ 23] = parts.engines.GM_V8_pak:0x00000084r; // "V8 Small Block Clutch" //
			//stock_parts_list_E[ 24] = parts.engines.GM_V8_pak:0x00001B99r; // "RG 5spd tranny" //
			stock_parts_list_E[ 25] = parts.engines.GM_V8_pak:0x00009948r; // "Vette oil pan" //
			stock_parts_list_E[ 26] = parts.engines.GM_V8_pak:0x00009947r; // "Vette 63 Alternator" //
			stock_parts_list_E[ 27] = parts.engines.GM_V8_pak:0x00009949r; // "Vette 63 Alternator Drive Belt" //
			stock_parts_list_E[ 28] = parts.engines.GM_V8_pak:0x000000C7r; // "Stock ignition distributor" //
			//stock_parts_list_E[ 29] = parts.engines.GM_V8_pak:0x0000339Ar; // "Vette_C3_radiator" //
			stock_parts_list_E[ 29] = parts.engines.GM_V8_pak:0x0000009Ar; // "GM_427_radiator" //
			stock_parts_list_E[ 30] = parts.engines.GM_V8_pak:0x0000C5BDr; // "PROFORM GM breather" //
		}
		else if ( number < 0.60 )
		{
			motor = 383;
			stock_parts_list_E[ 1] = parts.engines.GM_V8_pak:0x0000A13Fr; // "GTO65_block" //
			stock_parts_list_E[ 2] = parts.engines.GM_V8_pak:0x0000D13Er; // "GTO65_crank" //
			stock_parts_list_E[ 3] = parts.engines.GM_V8_pak:0x00003355r; // "GTO65_rods" //
			stock_parts_list_E[ 4] = parts.engines.GM_V8_pak:0x00001056r; // "GM 327 pistons" //
			stock_parts_list_E[ 5] = parts.engines.GM_V8_pak:0x0000B04Ar; // "MOROSO oil filter" //
			stock_parts_list_E[ 6] = parts.engines.GM_V8_pak:0x000010A1r; // "GTO65_intake" //
			stock_parts_list_E[ 7] = parts.engines.GM_V8_pak:0x0000108Br; // "Holley 3x2brl carbs" //
			stock_parts_list_E[ 8] = parts.engines.GM_V8_pak:0x000020A5r; // "Summit 2x4 3x2 air filter" //
			stock_parts_list_E[ 9] = parts.engines.GM_V8_pak:0x0000AA01r; // "GM_small_block_crank_gear" //
			stock_parts_list_E[ 10] = parts.engines.GM_V8_pak:0x0000A003r; // "GM small block camshaft" //
			stock_parts_list_E[ 11] = parts.engines.GM_V8_pak:0x0000AA02r; // "GM_small_block_cam_gear" //
			stock_parts_list_E[ 12] = parts.engines.GM_V8_pak:0x0000A043r; // "GM small block chain" //
			stock_parts_list_E[ 13] = parts.engines.GM_V8_pak:0x0000ADADr; // "GTO65_L_head" //
			stock_parts_list_E[ 14] = parts.engines.GM_V8_pak:0x0000F0B0r; // "GTO65_L_header" //
			stock_parts_list_E[ 15] = parts.engines.GM_V8_pak:0x0000AABDr; // "GTO65_L_cover" //
			stock_parts_list_E[ 16] = parts.engines.GM_V8_pak:0x0000A148r; // "GTO65_oil_pan" //
			stock_parts_list_E[ 17] = parts.engines.GM_V8_pak:0x0000ADAFr; // "GTO65_R_head" //
			stock_parts_list_E[ 18] = parts.engines.GM_V8_pak:0x0000ABBDr; // "GTO65_R_cover" //
			stock_parts_list_E[ 19] = parts.engines.GM_V8_pak:0x0000F0B2r; // "GTO65_R_header" //
			stock_parts_list_E[ 20] = parts.engines.GM_V8_pak:0x0000133Er; // "GTO65_timing_cover" //
			stock_parts_list_E[ 21] = parts.engines.GM_V8_pak:0x00002BB7r; // "GTO65_pump" //
			stock_parts_list_E[ 22] = parts.engines.GM_V8_pak:0x000021BBr; // "GM_small_block_fan" //
			stock_parts_list_E[ 23] = parts.engines.GM_V8_pak:0x00002047r; // "GM_small_block_alternator" //
			stock_parts_list_E[ 24] = parts.engines.GM_V8_pak:0x00001F13r; // "TCI_sb_damper 327-350" //
			stock_parts_list_E[ 25] = parts.engines.GM_V8_pak:0x00002049r; // "GM_small_block_alternator_belt" //
			stock_parts_list_E[ 26] = parts.engines.GM_V8_pak:0x000000C7r; // "stock ignition distributor" //
			stock_parts_list_E[ 27] = parts.engines.GM_V8_pak:0x0000B103r; // "radiator" //
			stock_parts_list_E[ 28] = parts.engines.GM_V8_pak:0x00000083r; // "flywheel" //
			stock_parts_list_E[ 29] = parts.engines.GM_V8_pak:0x00000084r; // "clutch" //
			stock_parts_list_E[ 30] = parts.engines.GM_V8_pak:0x00000099r; // "GM 4spd tranny" //
			stock_parts_list_E[ 31] = parts.engines.GM_V8_pak:0x0000C5BDr; // "PROFORM GM breather" //
			stock_parts_list_E[ 32] = parts.engines.GM_V8_pak:0x0000C5BDr; // "PROFORM GM breather" //
		}
		else if ( number < 0.7 )
		{
			motor = 396;
			stock_parts_list_E[ 1] = parts.engines.GM_V8_pak:0x0000A03Fr; // "GM 327-396 Small Block" //
			stock_parts_list_E[ 2] = parts.engines.GM_V8_pak:0x0000C13Er; // "GM 396 small block crankshaft" //
			stock_parts_list_E[ 3] = parts.engines.GM_V8_pak:0x0000AA01r; // "GM_small_block_crank_gear" //
			stock_parts_list_E[ 4] = parts.engines.GM_V8_pak:0x0000A003r; // "GM small block camshaft" //
			stock_parts_list_E[ 5] = parts.engines.GM_V8_pak:0x0000AA02r; // "GM_small_block_cam_gear" //
			stock_parts_list_E[ 6] = parts.engines.GM_V8_pak:0x00003055r; // "GM 396 connecting rods" //
			stock_parts_list_E[ 7] = parts.engines.GM_V8_pak:0x00001056r; // "GM 327-396 pistons" //
			stock_parts_list_E[ 8] = parts.engines.GM_V8_pak:0x0000A1ADr; // "GM_small_block_L_head II" //
			stock_parts_list_E[ 9] = parts.engines.GM_V8_pak:0x0000A1AFr; // "GM_small_block_R_head_II" //
			stock_parts_list_E[ 10] = parts.engines.GM_V8_pak:0x0000A0BDr; // "GM_small_block_L_cover" //
			stock_parts_list_E[ 11] = parts.engines.GM_V8_pak:0x0000C1BDr; // "GM Small block left cylinder head cover cup" //
			stock_parts_list_E[ 12] = parts.engines.GM_V8_pak:0x0000A1BDr; // "GM_small_block_R_cover" //
			stock_parts_list_E[ 13] = parts.engines.GM_V8_pak:0x0000A0B0r; // "GM_small_block_L_header" //
			stock_parts_list_E[ 14] = parts.engines.GM_V8_pak:0x0000A0B2r; // "GM_small_block_R_header" //
			stock_parts_list_E[ 15] = parts.engines.GM_V8_pak:0x0000A043r; // "GM small block chain" //
			stock_parts_list_E[ 16] = parts.engines.GM_V8_pak:0x00001303r; // "GM_small_block_timing_cover" //
			stock_parts_list_E[ 17] = parts.engines.GM_V8_pak:0x0000F113r; // "GM_small_block_stock_harmonic_damper_327-350" //
			stock_parts_list_E[ 18] = parts.engines.GM_V8_pak:0x000021B7r; // "GM_small_block_pump" //
			stock_parts_list_E[ 19] = parts.engines.GM_V8_pak:0x000021BBr; // "GM_small_block_fan" //
			stock_parts_list_E[ 32] = parts.engines.GM_V8_pak:0x000000C7r; // "Stock Ignition Distributor" //
			stock_parts_list_E[ 21] = parts.engines.GM_V8_pak:0x0000004Ar; // "Stock Oil Filter" //
			stock_parts_list_E[ 22] = parts.engines.GM_V8_pak:0x00000083r; // "V8 Small Block Flywheel" //
			stock_parts_list_E[ 23] = parts.engines.GM_V8_pak:0x00000084r; // "V8 Small Block Clutch" //
			stock_parts_list_E[ 24] = parts.engines.GM_V8_pak:0x00001048r; // "GM Small block oil pan" //
			stock_parts_list_E[ 25] = parts.engines.GM_V8_pak:0x00002047r; // "GM_small_block_alternator" //
			stock_parts_list_E[ 26] = parts.engines.GM_V8_pak:0x00002049r; // "GM_small_block_alternator_belt" //
			stock_parts_list_E[ 27] = parts.engines.GM_V8_pak:0x0000B103r; // "Radiator" //
			
			number2 = random();
					
			if ( number2 < 0.32 )
			{
				number3 = random();
					
				if ( number3 < 0.62 )
				{
					stock_parts_list_E[ 28] = parts.engines.GM_V8_pak:0x0000A0BEr; // "Holley aluminium dual-plane intake manifold" //
				}
				else
				{
					stock_parts_list_E[ 28] = parts.engines.GM_V8_pak:0x0000104Br; // "GM Small block stock 4brl intake manifold (327-396)" //
				}			
				
				number3 = random();
					
				if ( number3 < 0.62 )
				{
					stock_parts_list_E[ 29] = parts.engines.GM_V8_pak:0x0000A0A3r; // "stock 4brl carb" //
				}
				else
				{
					stock_parts_list_E[ 29] = parts.engines.GM_V8_pak:0x0000B1A3r; // "Holley dominator" //
				}
				
				number3 = random();
				
				if ( number3 < 0.33 )
				{
					stock_parts_list_E[ 30] = parts.engines.GM_V8_pak:0x00000086r; // "GM stock air filter" //
				}
				else if ( number3 < 0.66 )
				{
					stock_parts_list_E[ 30] = parts.engines.GM_V8_pak:0x000030A5r; // "GM stock low-resistance air filter" //
				}
				else if ( number3 < 0.87 )
				{
					stock_parts_list_E[ 30] = parts.engines.GM_V8_pak:0x000080A5r; // "GM stock hi-flow air filter" //
				}
				else
				{
					number4 = random();
					
					if ( number4 < 0.5 )
					{
						stock_parts_list_E[ 30] = parts.engines.GM_V8_pak:0x00003AA5r; // "Summit street scoop polished single carb" //
					}
					else
					{
						stock_parts_list_E[ 30] = parts.engines.GM_V8_pak:0x00003BA5r; // "Summit street scoop black single carb" //
					}
				}
			}
			else
			{
				stock_parts_list_E[ 28] = parts.engines.GM_V8_pak:0x0000B04Br; // "Edelbrock Dual Quad intake manifold (327, 350)" //
				number3 = random();
					
				if ( number3 < 0.62 )
				{
					stock_parts_list_E[ 29] = parts.engines.GM_V8_pak:0x0000A1A3r; // "Stock 2x4brl carbs" //
				}
				else
				{
					stock_parts_list_E[ 29] = parts.engines.GM_V8_pak:0x0000C1A3r; // "Holley 750 cfm carburettors //
				}
				
				number3 = random();
					
				if ( number3 < 0.25 )
				{
					stock_parts_list_E[ 30] = parts.engines.GM_V8_pak:0x000021A5r; // "Holley 2x4brl air filter" //
				}
				else if ( number3 < 0.50 )
				{
					stock_parts_list_E[ 30] = parts.engines.GM_V8_pak:0x000020A5r; // "summit polished-aluminium air filter" //
				}
				else
				{
					number4 = random();
				
					if ( number4 < 0.5 )
					{
						stock_parts_list_E[ 30] = parts.engines.GM_V8_pak:0x00004AA5r; // "Summit street scoop polished dual quad" //
					}
					else
					{
						stock_parts_list_E[ 30] = parts.engines.GM_V8_pak:0x00004BA5r; // "Summit street scoop black dual quad" //
					}
				}
			}
		}
		else if ( number < 0.8 )
		{
			motor = 427;
			stock_parts_list_E[ 1] = parts.engines.GM_V8_pak:0x0000000Ar; // "GM 427 Block" //
			stock_parts_list_E[ 2] = parts.engines.GM_V8_pak:0x0000000Br; // "GM_427_crankshaft" //
			stock_parts_list_E[ 3] = parts.engines.GM_V8_pak:0x000000B3r; // "GM_427_crank_gear" //
			stock_parts_list_E[ 4] = parts.engines.GM_V8_pak:0x000000B4r; // "GM_427_cam //
			stock_parts_list_E[ 5] = parts.engines.GM_V8_pak:0x000000B5r; // "GM_427_cam_gear" //
			stock_parts_list_E[ 6] = parts.engines.GM_V8_pak:0x000000A8r; // "GM_427_rods" //
			stock_parts_list_E[ 7] = parts.engines.GM_V8_pak:0x000000AAr; // "GM_427_pistons" //
			stock_parts_list_E[ 8] = parts.engines.GM_V8_pak:0x0000004Fr; // "GM_427_L_head" //
			stock_parts_list_E[ 9] = parts.engines.GM_V8_pak:0x00000052r; // "GM_427_R_head" //
			stock_parts_list_E[ 10] = parts.engines.GM_V8_pak:0x00003042r; // "GM_427_L_head_cover" //
			stock_parts_list_E[ 11] = parts.engines.GM_V8_pak:0x0000004Er; // "GM_427_L_head_cover_cup" //
			stock_parts_list_E[ 12] = parts.engines.GM_V8_pak:0x00003044r; // "GM_427_R_head_cover" //
			stock_parts_list_E[ 13] = parts.engines.GM_V8_pak:0x00003046r; // "GM 427 L header" //
			stock_parts_list_E[ 14] = parts.engines.GM_V8_pak:0x00003045r; // "GM_427_R_header" //
			stock_parts_list_E[ 15] = parts.engines.GM_V8_pak:0x000000B7r; // "GM_427_chain" //
			stock_parts_list_E[ 16] = parts.engines.GM_V8_pak:0x000000BAr; // "GM_427_timing_cover" //
			stock_parts_list_E[ 17] = parts.engines.GM_V8_pak:0x000000BBr; // "GM_427_damper" //
			stock_parts_list_E[ 18] = parts.engines.GM_V8_pak:0x000010B7r; // "GM_427_pump" //
			stock_parts_list_E[ 19] = parts.engines.GM_V8_pak:0x000010BBr; // "GM_427_fan" //
			stock_parts_list_E[ 32] = parts.engines.GM_V8_pak:0x0000104Dr; // "Mallory_427_Distributor" //
			stock_parts_list_E[ 21] = parts.engines.GM_V8_pak:0x000020BBr; // "GM_427_oil_filter" //
			stock_parts_list_E[ 22] = parts.engines.GM_V8_pak:0x000000A6r; // "GM_427_flywheel" //
			stock_parts_list_E[ 23] = parts.engines.GM_V8_pak:0x000000A7r; // "GM_427_clutch" //
			stock_parts_list_E[ 24] = parts.engines.GM_V8_pak:0x00003048r; // "GM 427 oil pan" //
			stock_parts_list_E[ 25] = parts.engines.GM_V8_pak:0x00003047r; // "GM 427 alternator" //
			stock_parts_list_E[ 26] = parts.engines.GM_V8_pak:0x00000097r; // "GM_427_alternator_drive_belt" //
			stock_parts_list_E[ 27] = parts.engines.GM_V8_pak:0x0000009Ar; // "GM_427_radiator" //
			
			number2 = random();
					
			if ( number2 < 0.25 )
			{
				stock_parts_list_E[ 28] = parts.engines.GM_V8_pak:0x000030A1r; // "GM_427_4brl_intake" //
				
				number3 = random();
					
				if ( number3 < 0.62 )
				{
					stock_parts_list_E[ 29] = parts.engines.GM_V8_pak:0x0000A0A3r; // "stock 4brl carb" //
				}
				else
				{
					stock_parts_list_E[ 29] = parts.engines.GM_V8_pak:0x0000B1A3r; // "Holley dominator" //
				}
				
				number3 = random();
				
				if ( number3 < 0.33 )
				{
					stock_parts_list_E[ 30] = parts.engines.GM_V8_pak:0x00000086r; // "GM stock air filter" //
				}
				else if ( number3 < 0.66 )
				{
					stock_parts_list_E[ 30] = parts.engines.GM_V8_pak:0x000030A5r; // "GM stock low-resistance air filter" //
				}
				else if ( number3 < 0.87 )
				{
					stock_parts_list_E[ 30] = parts.engines.GM_V8_pak:0x000080A5r; // "GM stock hi-flow air filter" //
				}
				else
				{
					number4 = random();
					
					if ( number4 < 0.5 )
					{
						stock_parts_list_E[ 30] = parts.engines.GM_V8_pak:0x00003AA5r; // "Summit street scoop polished single carb" //
					}
					else
					{
						stock_parts_list_E[ 30] = parts.engines.GM_V8_pak:0x00003BA5r; // "Summit street scoop black single carb" //
					}
				}
			}
			else
			{
				number3 = random();
					
				if ( number3 < 0.62 )
				{
					stock_parts_list_E[ 28] = parts.engines.GM_V8_pak:0x000036A1r; // "GM_427_2x4brl_intake" //
				}
				else
				{
					stock_parts_list_E[ 28] = parts.engines.GM_V8_pak:0x0000B0A1r; // "TrickFlow_427_Dual_Tunnel_Ram" //
				}
				
				number3 = random();
					
				if ( number3 < 0.62 )
				{
					stock_parts_list_E[ 29] = parts.engines.GM_V8_pak:0x0000A1A3r; // "Stock 2x4brl carbs" //
				}
				else if ( number3 < 0.78 )
				{
					stock_parts_list_E[ 29] = parts.engines.GM_V8_pak:0x0000C1A3r; // "Holley 750 cfm carburettors //
				}
				else
				{
					stock_parts_list_E[ 29] = parts.engines.GM_V8_pak:0x0000C004r; // "Weiand methanol system" //
				}
				
				number3 = random();
					
				if ( number3 < 0.25 )
				{
					stock_parts_list_E[ 30] = parts.engines.GM_V8_pak:0x000021A5r; // "Holley 2x4brl air filter" //
				}
				else if ( number3 < 0.50 )
				{
					stock_parts_list_E[ 30] = parts.engines.GM_V8_pak:0x000020A5r; // "summit polished-aluminium air filter" //
				}
				else
				{
					number4 = random();
					
					if ( number4 < 0.5 )
					{
						stock_parts_list_E[ 30] = parts.engines.GM_V8_pak:0x00004AA5r; // "Summit street scoop polished dual quad" //
					}
					else
					{
						stock_parts_list_E[ 30] = parts.engines.GM_V8_pak:0x00004BA5r; // "Summit street scoop black dual quad" //
					}
				}
			}			
		}
		else if ( number < 0.9 )
		{
			motor = 500;
			stock_parts_list_E[ 1] = parts.engines.GM_V8_pak:0x0000800Ar; // "GM_500_block" //
			stock_parts_list_E[ 2] = parts.engines.GM_V8_pak:0x0000800Br; // "GM_500_crankshaft" //
			stock_parts_list_E[ 3] = parts.engines.GM_V8_pak:0x000080A8r; // "GM_500_rods" //
			stock_parts_list_E[ 4] = parts.engines.GM_V8_pak:0x000080AAr; // "GM_500_pistons" //
			stock_parts_list_E[ 5] = parts.engines.GM_V8_pak:0x000020BBr; // "GM_427_oil_filter" //
			stock_parts_list_E[ 6] = parts.engines.GM_V8_pak:0x000080A1r; // "GM_500_4brl_intake" //
			stock_parts_list_E[ 7] = parts.engines.GM_V8_pak:0x0000A0A3r; // "Stock 4brl carb" //
			stock_parts_list_E[ 8] = parts.engines.GM_V8_pak:0x000001A5r; // "MOROSO air filter" //
			stock_parts_list_E[ 9] = parts.engines.GM_V8_pak:0x000080B3r; // "GM_500_crank_gear" //
			stock_parts_list_E[ 10] = parts.engines.GM_V8_pak:0x000080B4r; // "GM_500_cam //
			stock_parts_list_E[ 11] = parts.engines.GM_V8_pak:0x000080B5r; // "GM_500_cam_gear" //
			stock_parts_list_E[ 12] = parts.engines.GM_V8_pak:0x000080B7r; // "GM_500_chain" //
			stock_parts_list_E[ 13] = parts.engines.GM_V8_pak:0x0000804Fr; // "GM_500_L_head" //
			stock_parts_list_E[ 14] = parts.engines.GM_V8_pak:0x00008A46r; // "GM 500 L header" //
			stock_parts_list_E[ 15] = parts.engines.GM_V8_pak:0x00008042r; // "GM_500_L_cover" //
			stock_parts_list_E[ 16] = parts.engines.GM_V8_pak:0x00008048r; // "GM 500 oil pan" //
			stock_parts_list_E[ 17] = parts.engines.GM_V8_pak:0x00008052r; // "GM_500_R_head" //
			stock_parts_list_E[ 18] = parts.engines.GM_V8_pak:0x00008045r; // "GM_500_R_header" //
			stock_parts_list_E[ 19] = parts.engines.GM_V8_pak:0x00008044r; // "GM_500_R_cover" //
			stock_parts_list_E[ 20] = parts.engines.GM_V8_pak:0x000080BAr; // "GM_500_timing_cover" //
			stock_parts_list_E[ 21] = parts.engines.GM_V8_pak:0x000081B7r; // "GM_500_pump" //
			stock_parts_list_E[ 22] = parts.engines.GM_V8_pak:0x000081BBr; // "GM_500_fan" //
			stock_parts_list_E[ 23] = parts.engines.GM_V8_pak:0x00008047r; // "GM 500 alternator" //
			stock_parts_list_E[ 24] = parts.engines.GM_V8_pak:0x000080BBr; // "GM_500_damper" //
			stock_parts_list_E[ 25] = parts.engines.GM_V8_pak:0x00008097r; // "GM_500_alternator_drive_belt" //
			stock_parts_list_E[ 26] = parts.engines.GM_V8_pak:0x0000804Dr; // "GM_500_Distributor" //
			stock_parts_list_E[ 27] = parts.engines.GM_V8_pak:0x0000E123r; // "BE Cool radiator" //
			stock_parts_list_E[ 28] = parts.engines.GM_V8_pak:0x000080A6r; // "GM_500_flywheel" //
			stock_parts_list_E[ 29] = parts.engines.GM_V8_pak:0x000080A7r; // "GM_500_clutch" //
			//stock_parts_list_E[ 30] = parts.engines.GM_V8_pak:0x00008098r; // "GM 500 4spd tranny" //
			stock_parts_list_E[ 31] = parts.engines.GM_V8_pak:0x0000104Er; // "Hardcore_Breather" //
		}
		else
		{
			motor = 454;
			stock_parts_list_E[ 1] = parts.engines.GM_V8_pak:0x0000200Ar; // "Motown 454 Cast Iron Block" //
			stock_parts_list_E[ 2] = parts.engines.GM_V8_pak:0x0000100Br; // "Eagle_4340_crankshaft" //
			stock_parts_list_E[ 3] = parts.engines.GM_V8_pak:0x000010A8r; // "Eagle_4340_rods" //
			stock_parts_list_E[ 4] = parts.engines.GM_V8_pak:0x000010AAr; // "Keith_Black_427_pistons" //
			stock_parts_list_E[ 5] = parts.engines.GM_V8_pak:0x000020BBr; // "GM_427_oil_filter" //
			stock_parts_list_E[ 6] = parts.engines.GM_V8_pak:0x000030A1r; // "GM_427_4brl_intake" //
			stock_parts_list_E[ 7] = parts.engines.GM_V8_pak:0x0000A0A3r; // "Stock 4brl carb" //
			stock_parts_list_E[ 8] = parts.engines.GM_V8_pak:0x000001A5r; // "MOROSO air filter" //
			stock_parts_list_E[ 9] = parts.engines.GM_V8_pak:0x000000B3r; // "GM_427_crank_gear" //
			stock_parts_list_E[ 10] = parts.engines.GM_V8_pak:0x000000B4r; // "GM_427_cam //
			stock_parts_list_E[ 11] = parts.engines.GM_V8_pak:0x000000B5r; // "GM_427_cam_gear" //
			stock_parts_list_E[ 12] = parts.engines.GM_V8_pak:0x000000B7r; // "GM_427_chain" //
			stock_parts_list_E[ 13] = parts.engines.GM_V8_pak:0x0000304Fr; // "DART_L_head" //
			stock_parts_list_E[ 14] = parts.engines.GM_V8_pak:0x00003046r; // "GM 427 L header" //
			stock_parts_list_E[ 15] = parts.engines.GM_V8_pak:0x00003B42r; // "Edelbrock_427_L_cover" //
			stock_parts_list_E[ 16] = parts.engines.GM_V8_pak:0x00003048r; // "GM 427 oil pan" //
			stock_parts_list_E[ 17] = parts.engines.GM_V8_pak:0x00003052r; // "DART_R_head" //
			stock_parts_list_E[ 18] = parts.engines.GM_V8_pak:0x00003045r; // "GM_427_R_header" //
			stock_parts_list_E[ 19] = parts.engines.GM_V8_pak:0x00003B44r; // "Edelbrock_427_R_cover" //
			stock_parts_list_E[ 20] = parts.engines.GM_V8_pak:0x000000BAr; // "GM_427_timing_cover" //
			stock_parts_list_E[ 21] = parts.engines.GM_V8_pak:0x000010B7r; // "GM_427_pump" //
			stock_parts_list_E[ 22] = parts.engines.GM_V8_pak:0x000010BBr; // "GM_427_fan" //
			stock_parts_list_E[ 23] = parts.engines.GM_V8_pak:0x00003047r; // "GM 427 alternator" //
			stock_parts_list_E[ 24] = parts.engines.GM_V8_pak:0x000000BBr; // "GM_427_damper" //
			stock_parts_list_E[ 25] = parts.engines.GM_V8_pak:0x00000097r; // "GM_427_alternator_drive_belt" //
			stock_parts_list_E[ 26] = parts.engines.GM_V8_pak:0x0000104Dr; // "Mallory_427_Distributor" //
			stock_parts_list_E[ 27] = parts.engines.GM_V8_pak:0x0000009Ar; // "GM_427_radiator" //
			stock_parts_list_E[ 28] = parts.engines.GM_V8_pak:0x000000A6r; // "GM_427_flywheel" //
			stock_parts_list_E[ 29] = parts.engines.GM_V8_pak:0x000000A7r; // "GM_427_clutch" //
			//stock_parts_list_E[ 30] = parts.engines.GM_V8_pak:0x00003798r; // "GM 427 4spd 2,78:1 tranny" //
			stock_parts_list_E[ 31] = parts.engines.GM_V8_pak:0x0000104Er; // "Hardcore_Breather" //
		}
		
		//////////////////////
		// TRANSMISSION SET //
		//////////////////////
		
		if ( motor < 427 )
		{
			number2 = random();
					
			if ( number2 < 0.18 )
			{
				stock_parts_list_E[ 33] = parts.engines.GM_V8_pak:0x00000089r; // "V8 3speed Tranny" //	
			}
			else if ( number2 < 0.36 )
			{
				stock_parts_list_E[ 33] = parts.engines.GM_V8_pak:0x00000099r; // "V8 4speed Tranny" //
			}
			else if ( number2 < 0.54 )
			{
				stock_parts_list_E[ 33] = parts.engines.GM_V8_pak:0x00001099r; // "Richmond Gear Super T-10 4-Speed Tranny (GM 283-396)" //
			}
			else if ( number2 < 0.72 )
			{
				stock_parts_list_E[ 33] = parts.engines.GM_V8_pak:0x00001A99r; // "Richmond Gear Super T-10 Plus 4-Speed (GM 283-396)" //
			}
			else if ( number2 < 0.82 )
			{
				stock_parts_list_E[ 33] = parts.engines.GM_V8_pak:0x00001B99r; // "Richmond Gear 5-Speed Tranny (GM 283-396)" //
			}
			else if ( number2 < 0.92 )
			{
				stock_parts_list_E[ 33] = parts.engines.GM_V8_pak:0x00001C99r; // "Richmond Gear Street 5-Speed Tranny (GM 283-396)" //
			}
			else
			{
				stock_parts_list_E[ 33] = parts.engines.GM_V8_pak:0x00001D99r; // "Richmond Gear 6-Speed ROD Transmissions (GM 283-396)" //
			}
		}
		else if ( motor == 427 || motor == 454 )
		{
			number2 = random();
					
			if ( number2 < 0.18 )
			{
				stock_parts_list_E[ 33] = parts.engines.GM_V8_pak:0x00000098r; // "GM TH-400 (3L80) 3 spd. tranny (427-454)" //
			}
			else if ( number2 < 0.36 )
			{
				stock_parts_list_E[ 33] = parts.engines.GM_V8_pak:0x00003798r; // "GM TH-700-R4 (4L60) 4 spd. tranny (427-454)" //
			}
			else if ( number2 < 0.54 )
			{
				stock_parts_list_E[ 33] = parts.engines.GM_V8_pak:0x00003998r; // "Richmond Gear Super T-10 4-Speed tranny (427-454)" //
			}
			else if ( number2 < 0.72 )
			{
				stock_parts_list_E[ 33] = parts.engines.GM_V8_pak:0x00003A98r; // "Tremec TKO 600 5spd. Tranny (GM 427/454)" //
			}
			else if ( number2 < 0.82 )
			{
				stock_parts_list_E[ 33] = parts.engines.GM_V8_pak:0x00003B98r; // "Richmond Gear Super Street 5-Speed Tranny (GM 427/454)" //
			}
			else if ( number2 < 0.92 )
			{
				stock_parts_list_E[ 33] = parts.engines.GM_V8_pak:0x00003098r; // "Tremec T-56 6spd. Tranny (GM 427/454)" //
			}
			else
			{
				stock_parts_list_E[ 33] = parts.engines.GM_V8_pak:0x00003898r; // "Richmond Gear 6-Speed ROD Tranny (GM 427/454)" //
			}
		}
		else
		{
			number2 = random();
					
			if ( number2 < 0.18 )
			{
				stock_parts_list_E[ 33] = parts.engines.GM_V8_pak:0x00008198r; // "GM TH-125C (3T40) 3spd. FWD stock tranny (500+)" //
			}
			else
			{
				stock_parts_list_E[ 33] = parts.engines.GM_V8_pak:0x00008098r; // "GM 4L30-E 4spd. stock tranny (500+)" //
			}
		}		
		
		return stock_parts_list_E;
	}
	
	public int[] getFordEngine(){
		number = random();
		int[] stock_parts_list_E  = new int[2];
		stock_parts_list_E[ 0] = parts:0x000053FFr; // "stock battery" //
		
		if ( number < 0.1 )
		{
			stock_parts_list_E[ 1] = parts.engines.fordi6_data:0x00000041r; // "Ford_188_Block" //
		}
		else if ( number < 0.2 )
		{
			stock_parts_list_E[ 1] = parts.engines.fordi6_data:0x00000052r; // "Ford_221_Block" //
		}
		else if ( number < 0.3 )
		{
			stock_parts_list_E[ 1] = parts.engines.ford_v8s:0x00008001r; // "Ford_260_block" //
		}
		else if ( number < 0.36 )
		{
			stock_parts_list_E[ 1] = parts.engines.ford_v8s:0x00000001r; // "Ford_292_block" //
		}
		else if ( number < 0.4 )
		{
			stock_parts_list_E[ 1] = parts.engines.ford_v8s:0x00006001r; // "Ford_302_block" //
		}
		else if ( number < 0.53 )
		{
			stock_parts_list_E[ 1] = parts.engines.ford_v8s:0x00009001r; // "Ford_312_block" //
		}
		else if ( number < 0.6 )
		{
			stock_parts_list_E[ 1] = parts.engines.ford_v8s:0x00007001r; // "Ford_332_block" //
		}
		else if ( number < 0.7 )
		{
			stock_parts_list_E[ 1] = parts.engines.ford_v8s:0x00005001r; // "Ford_351_block" //
		}
		else if ( number < 0.82 )
		{
			stock_parts_list_E[ 1] = parts.engines.ford_v8s:0x00003001r; // "Ford_390_block" //
		}
		else if ( number < 0.90 )
		{
			stock_parts_list_E[ 1] = parts.engines.ford_v8s:0x00004261r; // "Cobra_Jet_429_block" //
		}
		else
		{
			stock_parts_list_E[ 1] = parts.engines.ford_v8s:0x00004001r; // "Ford_460_block" //
		}
		
		return stock_parts_list_E;
	}
	
	public int[] getChryslerEngine(){
		number = random();
		int[] stock_parts_list_E  = new int[34];
		stock_parts_list_E[ 0] = parts:0x000053FFr; // "stock battery" //
		
		if ( number < 0.2 )
		{
			stock_parts_list_E[ 1] = parts.engines.Chrysler_V8_pak:0x0000E318r; // "Engine_block_318" //
			stock_parts_list_E[ 2] = parts.engines.Chrysler_V8_pak:0x000000FEr; // "Crankshaft_318_block" //
			stock_parts_list_E[ 3] = parts.engines.Chrysler_V8_pak:0x00000A6Br; // "Timing_gear_crankshaft" //
			stock_parts_list_E[ 4] = parts.engines.Chrysler_V8_pak:0x000000FFr; // "Connecting_rods_318_block" //
			stock_parts_list_E[ 5] = parts.engines.Chrysler_V8_pak:0x00000102r; // "Pistons_318_block" //
			stock_parts_list_E[ 6] = parts.engines.Chrysler_V8_pak:0x00000003r; // "Camshaft_318_block" //
			stock_parts_list_E[ 7] = parts.engines.Chrysler_V8_pak:0x00000AB4r; // "Timing_gear_camshaft" //
			stock_parts_list_E[ 8] = parts.engines.Chrysler_V8_pak:0x00000097r; // "Timing_chain" //
			stock_parts_list_E[ 9] = parts.engines.Chrysler_V8_pak:0x0000004Fr; // "Timing_gear_cover_B" //
			stock_parts_list_E[ 10] = parts.engines.Chrysler_V8_pak:0x00000095r; // "Oil_pan_small_block_B" //
			stock_parts_list_E[ 11] = parts.engines.Chrysler_V8_pak:0x00000A99r; // "Oill_filter" //
			stock_parts_list_E[ 12] = parts.engines.Chrysler_V8_pak:0x00000100r; // "Flywheel_small_block" //
			stock_parts_list_E[ 13] = parts.engines.Chrysler_V8_pak:0x00000103r; // "Clutch_small_block" //
			stock_parts_list_E[ 14] = parts.engines.Chrysler_V8_pak:0x00000088r; // "Pulley_small_block_B" //
			stock_parts_list_E[ 15] = parts.engines.Chrysler_V8_pak:0x00000047r; // "Water_pomp_small_B" //
			stock_parts_list_E[ 16] = parts.engines.Chrysler_V8_pak:0x000000ADr; // "Cylinder_head_Left_318" //
			stock_parts_list_E[ 17] = parts.engines.Chrysler_V8_pak:0x000000B0r; // "Exhaust_header_left_small" //
			stock_parts_list_E[ 18] = parts.engines.Chrysler_V8_pak:0x00000042r; // "Head_cover_left_B" //
			stock_parts_list_E[ 19] = parts.engines.Chrysler_V8_pak:0x000000AFr; // "Cylinder_head_Right_318" //
			stock_parts_list_E[ 20] = parts.engines.Chrysler_V8_pak:0x000000B2r; // "Exhaust_header_Right_small" //
			stock_parts_list_E[ 21] = parts.engines.Chrysler_V8_pak:0x00000044r; // "Head_cover_Right_B" //
			stock_parts_list_E[ 22] = parts.engines.Chrysler_V8_pak:0x00000F1Br; // "Block_cover_small" //
			stock_parts_list_E[ 23] = parts.engines.Chrysler_V8_pak:0x000002A1r; // "Intake_manifold_small_2brl_B" //
			stock_parts_list_E[ 24] = parts.engines.Chrysler_V8_pak:0x000000A3r; // "Carburetors_2BRL_HOLLEY" //
			stock_parts_list_E[ 25] = parts.engines.Chrysler_V8_pak:0x00000086r; // "Air_cleaner_318_2BRL" //
			stock_parts_list_E[ 26] = parts.engines.Chrysler_V8_pak:0x00000A02r; // "Ignition_distributor" //
			stock_parts_list_E[ 27] = parts.engines.Chrysler_V8_pak:0x00000096r; // "Alternator" //
			stock_parts_list_E[ 28] = parts.engines.Chrysler_V8_pak:0x0000009Ar; // "Belt_alternator_drive" //
			stock_parts_list_E[ 29] = parts.engines.Chrysler_V8_pak:0x00000E08r; // "Fan_4_blade" //
			stock_parts_list_E[ 30] = parts.engines.Chrysler_V8_pak:0x00000A97r; // "Power_Steering_pump" //
			stock_parts_list_E[ 31] = parts.engines.Chrysler_V8_pak:0x0000044Dr; // "Belt_Steering_pump" //
			stock_parts_list_E[ 32] = parts.engines.Chrysler_V8_pak:0x00000E15r; // "Radiator_small" //
			
			number2 = random();
		
			if ( number2 < 0.5 )
			{
				stock_parts_list_E[ 33] = parts.engines.Chrysler_V8_pak:0x00000099r; // "Transmission_A230_3spd" //
			}
			else if ( number2 < 0.9 )
			{
				stock_parts_list_E[ 33] = parts.engines.Chrysler_V8_pak:0x00000104r; // "Transmission_A727_3spd" //
			}
			else
			{
				stock_parts_list_E[ 33] = parts.engines.Chrysler_V8_pak:0x00000F89r; // "Transmission_A833_4spd" //
			}
		}
		else if ( number < 0.3 )
		{
			stock_parts_list_E[ 1] = parts.engines.Chrysler_V8_pak:0x0000E340r; // "Engine_block_340" //
			stock_parts_list_E[ 2] = parts.engines.Chrysler_V8_pak:0x0000000Br; // "Crankshaft_340_block" //
			stock_parts_list_E[ 3] = parts.engines.Chrysler_V8_pak:0x00000A6Br; // "Timing_gear_crankshaft" //
			stock_parts_list_E[ 4] = parts.engines.Chrysler_V8_pak:0x00000106r; // "Connecting_rods_340_block" //
			stock_parts_list_E[ 5] = parts.engines.Chrysler_V8_pak:0x00000101r; // "Pistons_340_block" //
			stock_parts_list_E[ 6] = parts.engines.Chrysler_V8_pak:0x000000FCr; // "Camshaft_340_block" //
			stock_parts_list_E[ 7] = parts.engines.Chrysler_V8_pak:0x00000AB4r; // "Timing_gear_camshaft" //
			stock_parts_list_E[ 8] = parts.engines.Chrysler_V8_pak:0x00000097r; // "Timing_chain" //
			stock_parts_list_E[ 9] = parts.engines.Chrysler_V8_pak:0x00000052r; // "Timing_gear_cover" //
			stock_parts_list_E[ 10] = parts.engines.Chrysler_V8_pak:0x00000048r; // "Oil_pan_small_block_O" //
			stock_parts_list_E[ 11] = parts.engines.Chrysler_V8_pak:0x00000A99r; // "Oill_filter" //
			stock_parts_list_E[ 12] = parts.engines.Chrysler_V8_pak:0x00000100r; // "Flywheel_small_block" //
			stock_parts_list_E[ 13] = parts.engines.Chrysler_V8_pak:0x00000103r; // "Clutch_small_block" //
			stock_parts_list_E[ 14] = parts.engines.Chrysler_V8_pak:0x00000A88r; // "Pulley_small_block" //
			stock_parts_list_E[ 15] = parts.engines.Chrysler_V8_pak:0x00000EE1r; // "Water_pomp_small_O" //
			stock_parts_list_E[ 16] = parts.engines.Chrysler_V8_pak:0x00000040r; // "Cylinder_head_Left_340" //
			stock_parts_list_E[ 17] = parts.engines.Chrysler_V8_pak:0x000000B0r; // "Exhaust_header_left_small" //
			stock_parts_list_E[ 18] = parts.engines.Chrysler_V8_pak:0x000000BDr; // "Head_cover_left_O" //
			stock_parts_list_E[ 19] = parts.engines.Chrysler_V8_pak:0x00000041r; // "Cylinder_head_Right_340" //
			stock_parts_list_E[ 20] = parts.engines.Chrysler_V8_pak:0x000000B2r; // "Exhaust_header_Right_small" //
			stock_parts_list_E[ 21] = parts.engines.Chrysler_V8_pak:0x000000BCr; // "Head_cover_Right_O" //
			stock_parts_list_E[ 22] = parts.engines.Chrysler_V8_pak:0x00000F1Br; // "Block_cover_small" //
			stock_parts_list_E[ 23] = parts.engines.Chrysler_V8_pak:0x000000BEr; // "Intake_manifold_small_4brl_O" //
			stock_parts_list_E[ 24] = parts.engines.Chrysler_V8_pak:0x0000088Br; // "Carburetors_4BRL_street_HOLLEY" //
			stock_parts_list_E[ 25] = parts.engines.Chrysler_V8_pak:0x000000A5r; // "Air_cleaner_340" //
			stock_parts_list_E[ 26] = parts.engines.Chrysler_V8_pak:0x00000A02r; // "Ignition_distributor" //
			stock_parts_list_E[ 27] = parts.engines.Chrysler_V8_pak:0x00000096r; // "Alternator" //
			stock_parts_list_E[ 28] = parts.engines.Chrysler_V8_pak:0x0000009Ar; // "Belt_alternator_drive" //
			stock_parts_list_E[ 29] = parts.engines.Chrysler_V8_pak:0x00000E08r; // "Fan_4_blade" //
			stock_parts_list_E[ 30] = parts.engines.Chrysler_V8_pak:0x00000A97r; // "Power_Steering_pump" //
			stock_parts_list_E[ 31] = parts.engines.Chrysler_V8_pak:0x0000044Dr; // "Belt_Steering_pump" //
			stock_parts_list_E[ 32] = parts.engines.Chrysler_V8_pak:0x00000E15r; // "Radiator_small" //
			
			number2 = random();
		
			if ( number2 < 0.5 )
			{
				stock_parts_list_E[ 33] = parts.engines.Chrysler_V8_pak:0x00000099r; // "Transmission_A230_3spd" //
			}
			else if ( number2 < 0.9 )
			{
				stock_parts_list_E[ 33] = parts.engines.Chrysler_V8_pak:0x00000104r; // "Transmission_A727_3spd" //
			}
			else
			{
				stock_parts_list_E[ 33] = parts.engines.Chrysler_V8_pak:0x00000F89r; // "Transmission_A833_4spd" //
			}
		}
		else if ( number < 0.4 )
		{
			stock_parts_list_E[ 1] = parts.engines.Chrysler_V8_pak:0x0000E360r; // "Engine_block_360" //
			stock_parts_list_E[ 2] = parts.engines.Chrysler_V8_pak:0x0000003Er; // "Crankshaft_360_block" //
			stock_parts_list_E[ 3] = parts.engines.Chrysler_V8_pak:0x00000A6Br; // "Timing_gear_crankshaft" //
			stock_parts_list_E[ 4] = parts.engines.Chrysler_V8_pak:0x000000A8r; // "Connecting_rods_360_block" //
			stock_parts_list_E[ 5] = parts.engines.Chrysler_V8_pak:0x000000AAr; // "Pistons_360_block" //
			stock_parts_list_E[ 6] = parts.engines.Chrysler_V8_pak:0x000000FDr; // "Camshaft_360_block" //
			stock_parts_list_E[ 7] = parts.engines.Chrysler_V8_pak:0x00000AB4r; // "Timing_gear_camshaft" //
			stock_parts_list_E[ 8] = parts.engines.Chrysler_V8_pak:0x00000097r; // "Timing_chain" //
			stock_parts_list_E[ 9] = parts.engines.Chrysler_V8_pak:0x00000052r; // "Timing_gear_cover" //
			stock_parts_list_E[ 10] = parts.engines.Chrysler_V8_pak:0x00000048r; // "Oil_pan_small_block_O" //
			stock_parts_list_E[ 11] = parts.engines.Chrysler_V8_pak:0x00000A99r; // "Oill_filter" //
			stock_parts_list_E[ 12] = parts.engines.Chrysler_V8_pak:0x00000100r; // "Flywheel_small_block" //
			stock_parts_list_E[ 13] = parts.engines.Chrysler_V8_pak:0x00000103r; // "Clutch_small_block" //
			stock_parts_list_E[ 14] = parts.engines.Chrysler_V8_pak:0x00000A88r; // "Pulley_small_block" //
			stock_parts_list_E[ 15] = parts.engines.Chrysler_V8_pak:0x00000EE1r; // "Water_pomp_small_O" //
			stock_parts_list_E[ 16] = parts.engines.Chrysler_V8_pak:0x00000F40r; // "Cylinder_head_Left_360" //
			stock_parts_list_E[ 17] = parts.engines.Chrysler_V8_pak:0x000000B0r; // "Exhaust_header_left_small" //
			stock_parts_list_E[ 18] = parts.engines.Chrysler_V8_pak:0x000000BDr; // "Head_cover_left_O" //
			stock_parts_list_E[ 19] = parts.engines.Chrysler_V8_pak:0x00000F41r; // "Cylinder_head_Right_360" //
			stock_parts_list_E[ 20] = parts.engines.Chrysler_V8_pak:0x000000B2r; // "Exhaust_header_Right_small" //
			stock_parts_list_E[ 21] = parts.engines.Chrysler_V8_pak:0x000000BCr; // "Head_cover_Right_O" //
			stock_parts_list_E[ 22] = parts.engines.Chrysler_V8_pak:0x00000F1Br; // "Block_cover_small" //
			stock_parts_list_E[ 23] = parts.engines.Chrysler_V8_pak:0x000003BEr; // "Intake_manifold_small_2brl_O" //
			stock_parts_list_E[ 24] = parts.engines.Chrysler_V8_pak:0x000000A3r; // "Carburetors_2BRL_HOLLEY" //
			stock_parts_list_E[ 25] = parts.engines.Chrysler_V8_pak:0x00000AA6r; // "Air_cleaner_360" //
			stock_parts_list_E[ 26] = parts.engines.Chrysler_V8_pak:0x00000A02r; // "Ignition_distributor" //
			stock_parts_list_E[ 27] = parts.engines.Chrysler_V8_pak:0x00000096r; // "Alternator" //
			stock_parts_list_E[ 28] = parts.engines.Chrysler_V8_pak:0x0000009Ar; // "Belt_alternator_drive" //
			stock_parts_list_E[ 29] = parts.engines.Chrysler_V8_pak:0x00000E09r; // "Fan_5_blade" //
			stock_parts_list_E[ 30] = parts.engines.Chrysler_V8_pak:0x00000A97r; // "Power_Steering_pump" //
			stock_parts_list_E[ 31] = parts.engines.Chrysler_V8_pak:0x0000044Dr; // "Belt_Steering_pump" //
			stock_parts_list_E[ 32] = parts.engines.Chrysler_V8_pak:0x00000E15r; // "Radiator_small" //
			
			number2 = random();
			
			if ( number2 < 0.3 )
			{
				stock_parts_list_E[ 33] = parts.engines.Chrysler_V8_pak:0x00000099r; // "Transmission_A230_3spd" //
			}
			else if ( number2 < 0.6 )
			{
				stock_parts_list_E[ 33] = parts.engines.Chrysler_V8_pak:0x00000104r; // "Transmission_A727_3spd" //
			}
			else if ( number2 < 0.8 )
			{
				stock_parts_list_E[ 33] = parts.engines.Chrysler_V8_pak:0x00000107r; // "Transmission_A727_4spd" //
			}
			else if ( number2 < 0.95 )
			{
				stock_parts_list_E[ 33] = parts.engines.Chrysler_V8_pak:0x00000F89r; // "Transmission_A833_4spd" //
			}
			else
			{
				stock_parts_list_E[ 33] = parts.engines.Chrysler_V8_pak:0x00000F90r; // "Transmission_TKO500_5spd" //
			}
		}
		else if ( number < 0.6 )
		{
			stock_parts_list_E[ 1] = parts.engines.Chrysler_V8_pak:0x0000E361r; // "Engine_block_361" //
			stock_parts_list_E[ 2] = parts.engines.Chrysler_V8_pak:0x0000004Ar; // "Crankshaft_361_block" //
			stock_parts_list_E[ 3] = parts.engines.Chrysler_V8_pak:0x00000A6Br; // "Timing_gear_crankshaft" //
			stock_parts_list_E[ 4] = parts.engines.Chrysler_V8_pak:0x00000055r; // "Connecting_rods_361_block" //
			stock_parts_list_E[ 5] = parts.engines.Chrysler_V8_pak:0x00000056r; // "Pistons_361_block" //
			stock_parts_list_E[ 6] = parts.engines.Chrysler_V8_pak:0x0000004Er; // "Camshaft_361_block" //
			stock_parts_list_E[ 7] = parts.engines.Chrysler_V8_pak:0x00000AB4r; // "Timing_gear_camshaft" //
			stock_parts_list_E[ 8] = parts.engines.Chrysler_V8_pak:0x00000097r; // "Timing_chain" //
			stock_parts_list_E[ 9] = parts.engines.Chrysler_V8_pak:0x0000004Fr; // "Timing_gear_cover_B" //
			stock_parts_list_E[ 10] = parts.engines.Chrysler_V8_pak:0x00000C49r; // "Oil_pan_big_block_B" //
			stock_parts_list_E[ 11] = parts.engines.Chrysler_V8_pak:0x00000A99r; // "Oill_filter" //
			stock_parts_list_E[ 12] = parts.engines.Chrysler_V8_pak:0x00000083r; // "Flywheel_big_block" //
			stock_parts_list_E[ 13] = parts.engines.Chrysler_V8_pak:0x000000A7r; // "Clutch_big_block" //
			stock_parts_list_E[ 14] = parts.engines.Chrysler_V8_pak:0x00000A90r; // "Pulley_big_block_B" //
			stock_parts_list_E[ 15] = parts.engines.Chrysler_V8_pak:0x00000EE3r; // "Water_pomp_big_B" //
			stock_parts_list_E[ 16] = parts.engines.Chrysler_V8_pak:0x00000F46r; // "Cylinder_head_Left_361" //
			stock_parts_list_E[ 17] = parts.engines.Chrysler_V8_pak:0x000001B0r; // "Exhaust_header_left_big_B" //
			stock_parts_list_E[ 18] = parts.engines.Chrysler_V8_pak:0x00000042r; // "Head_cover_left_B" //
			stock_parts_list_E[ 19] = parts.engines.Chrysler_V8_pak:0x00000F47r; // "Cylinder_head_Right_361" //
			stock_parts_list_E[ 20] = parts.engines.Chrysler_V8_pak:0x000001B2r; // "Exhaust_header_Right_big_B" //
			stock_parts_list_E[ 21] = parts.engines.Chrysler_V8_pak:0x00000044r; // "Head_cover_Right_B" //
			stock_parts_list_E[ 22] = parts.engines.Chrysler_V8_pak:0x00000F2Br; // "Block_cover_big" //
			stock_parts_list_E[ 23] = parts.engines.Chrysler_V8_pak:0x000006FBr; // "Intake_manifold_big_4brl_B" //
			stock_parts_list_E[ 24] = parts.engines.Chrysler_V8_pak:0x0000088Br; // "Carburetors_4BRL_street_HOLLEY" //
			stock_parts_list_E[ 25] = parts.engines.Chrysler_V8_pak:0x00000BA6r; // "Air_cleaner_361" //
			stock_parts_list_E[ 26] = parts.engines.Chrysler_V8_pak:0x00000A02r; // "Ignition_distributor" //
			stock_parts_list_E[ 27] = parts.engines.Chrysler_V8_pak:0x00000096r; // "Alternator" //
			stock_parts_list_E[ 28] = parts.engines.Chrysler_V8_pak:0x0000009Ar; // "Belt_alternator_drive" //
			stock_parts_list_E[ 29] = parts.engines.Chrysler_V8_pak:0x00000E09r; // "Fan_5_blade" //
			stock_parts_list_E[ 30] = parts.engines.Chrysler_V8_pak:0x00000A97r; // "Power_Steering_pump" //
			stock_parts_list_E[ 31] = parts.engines.Chrysler_V8_pak:0x0000044Dr; // "Belt_Steering_pump" //
			stock_parts_list_E[ 32] = parts.engines.Chrysler_V8_pak:0x00000E16r; // "Radiator_big" //
			
			number2 = random();
			
			if ( number2 < 0.3 )
			{
				stock_parts_list_E[ 33] = parts.engines.Chrysler_V8_pak:0x00000107r; // "Transmission_A727_4spd" //
			}
			else if ( number2 < 0.65 )
			{
				stock_parts_list_E[ 33] = parts.engines.Chrysler_V8_pak:0x00000F89r; // "Transmission_A833_4spd" //
			}
			else
			{
				stock_parts_list_E[ 33] = parts.engines.Chrysler_V8_pak:0x00000F90r; // "Transmission_TKO500_5spd" //
			}
		}
		else if ( number < 0.7 )
		{
			stock_parts_list_E[ 1] = parts.engines.Chrysler_V8_pak:0x0000E383r; // "Engine_block_383" //
			stock_parts_list_E[ 2] = parts.engines.Chrysler_V8_pak:0x00000A6Ar; // "Crankshaft_383_block" //
			stock_parts_list_E[ 3] = parts.engines.Chrysler_V8_pak:0x00000A6Br; // "Timing_gear_crankshaft" //
			stock_parts_list_E[ 4] = parts.engines.Chrysler_V8_pak:0x00000B56r; // "Connecting_rods_383_block" //
			stock_parts_list_E[ 5] = parts.engines.Chrysler_V8_pak:0x00000C52r; // "Pistons_383_block" //
			stock_parts_list_E[ 6] = parts.engines.Chrysler_V8_pak:0x00000051r; // "Camshaft_383_block" //
			stock_parts_list_E[ 7] = parts.engines.Chrysler_V8_pak:0x00000AB4r; // "Timing_gear_camshaft" //
			stock_parts_list_E[ 8] = parts.engines.Chrysler_V8_pak:0x00000097r; // "Timing_chain" //
			stock_parts_list_E[ 9] = parts.engines.Chrysler_V8_pak:0x0000004Fr; // "Timing_gear_cover_B" //
			stock_parts_list_E[ 10] = parts.engines.Chrysler_V8_pak:0x00000C49r; // "Oil_pan_big_block_B" //
			stock_parts_list_E[ 11] = parts.engines.Chrysler_V8_pak:0x00000A99r; // "Oill_filter" //
			stock_parts_list_E[ 12] = parts.engines.Chrysler_V8_pak:0x00000083r; // "Flywheel_big_block" //
			stock_parts_list_E[ 13] = parts.engines.Chrysler_V8_pak:0x000000A7r; // "Clutch_big_block" //
			stock_parts_list_E[ 14] = parts.engines.Chrysler_V8_pak:0x00000A90r; // "Pulley_big_block_B" //
			stock_parts_list_E[ 15] = parts.engines.Chrysler_V8_pak:0x00000EE3r; // "Water_pomp_big_B" //
			stock_parts_list_E[ 16] = parts.engines.Chrysler_V8_pak:0x00000F48r; // "Cylinder_head_Left_383" //
			stock_parts_list_E[ 17] = parts.engines.Chrysler_V8_pak:0x000001B0r; // "Exhaust_header_left_big_B" //
			stock_parts_list_E[ 18] = parts.engines.Chrysler_V8_pak:0x00000042r; // "Head_cover_left_B" //
			stock_parts_list_E[ 19] = parts.engines.Chrysler_V8_pak:0x00000F49r; // "Cylinder_head_Right_383" //
			stock_parts_list_E[ 20] = parts.engines.Chrysler_V8_pak:0x000001B2r; // "Exhaust_header_Right_big_B" //
			stock_parts_list_E[ 21] = parts.engines.Chrysler_V8_pak:0x00000044r; // "Head_cover_Right_B" //
			stock_parts_list_E[ 22] = parts.engines.Chrysler_V8_pak:0x00000F2Br; // "Block_cover_big" //
			stock_parts_list_E[ 23] = parts.engines.Chrysler_V8_pak:0x000006FBr; // "Intake_manifold_big_4brl_B" //
			stock_parts_list_E[ 24] = parts.engines.Chrysler_V8_pak:0x0000088Br; // "Carburetors_4BRL_street_HOLLEY" //
			stock_parts_list_E[ 25] = parts.engines.Chrysler_V8_pak:0x00000BA7r; // "Air_cleaner_383" //
			stock_parts_list_E[ 26] = parts.engines.Chrysler_V8_pak:0x00000A02r; // "Ignition_distributor" //
			stock_parts_list_E[ 27] = parts.engines.Chrysler_V8_pak:0x00000096r; // "Alternator" //
			stock_parts_list_E[ 28] = parts.engines.Chrysler_V8_pak:0x0000009Ar; // "Belt_alternator_drive" //
			stock_parts_list_E[ 29] = parts.engines.Chrysler_V8_pak:0x00000E09r; // "Fan_5_blade" //
			stock_parts_list_E[ 30] = parts.engines.Chrysler_V8_pak:0x00000A97r; // "Power_Steering_pump" //
			stock_parts_list_E[ 31] = parts.engines.Chrysler_V8_pak:0x0000044Dr; // "Belt_Steering_pump" //
			stock_parts_list_E[ 32] = parts.engines.Chrysler_V8_pak:0x00000E16r; // "Radiator_big" //
						
			number2 = random();
			
			if ( number2 < 0.3 )
			{
				stock_parts_list_E[ 33] = parts.engines.Chrysler_V8_pak:0x00000107r; // "Transmission_A727_4spd" //
			}
			else if ( number2 < 0.65 )
			{
				stock_parts_list_E[ 33] = parts.engines.Chrysler_V8_pak:0x00000F89r; // "Transmission_A833_4spd" //
			}
			else
			{
				stock_parts_list_E[ 33] = parts.engines.Chrysler_V8_pak:0x00000F90r; // "Transmission_TKO500_5spd" //
			}
		}
		else if ( number < 0.8 )
		{
			stock_parts_list_E[ 1] = parts.engines.Chrysler_V8_pak:0x0000E400r; // "Engine_block_400" //
			stock_parts_list_E[ 2] = parts.engines.Chrysler_V8_pak:0x00000A9Ar; // "Crankshaft_400_block" //
			stock_parts_list_E[ 3] = parts.engines.Chrysler_V8_pak:0x00000A6Br; // "Timing_gear_crankshaft" //
			stock_parts_list_E[ 4] = parts.engines.Chrysler_V8_pak:0x00000B57r; // "Connecting_rods_400_block" //
			stock_parts_list_E[ 5] = parts.engines.Chrysler_V8_pak:0x00000C54r; // "Pistons_400_block" //
			stock_parts_list_E[ 6] = parts.engines.Chrysler_V8_pak:0x00000A50r; // "Camshaft_400_block" //
			stock_parts_list_E[ 7] = parts.engines.Chrysler_V8_pak:0x00000AB4r; // "Timing_gear_camshaft" //
			stock_parts_list_E[ 8] = parts.engines.Chrysler_V8_pak:0x00000097r; // "Timing_chain" //
			stock_parts_list_E[ 9] = parts.engines.Chrysler_V8_pak:0x00000052r; // "Timing_gear_cover" //
			stock_parts_list_E[ 10] = parts.engines.Chrysler_V8_pak:0x00000C50r; // "Oil_pan_big_block_O" //
			stock_parts_list_E[ 11] = parts.engines.Chrysler_V8_pak:0x00000A99r; // "Oill_filter" //
			stock_parts_list_E[ 12] = parts.engines.Chrysler_V8_pak:0x00000083r; // "Flywheel_big_block" //
			stock_parts_list_E[ 13] = parts.engines.Chrysler_V8_pak:0x000000A7r; // "Clutch_big_block" //
			stock_parts_list_E[ 14] = parts.engines.Chrysler_V8_pak:0x00000A91r; // "Pulley_big_block" //
			stock_parts_list_E[ 15] = parts.engines.Chrysler_V8_pak:0x00000EE4r; // "Water_pomp_big_O" //
			stock_parts_list_E[ 16] = parts.engines.Chrysler_V8_pak:0x00000F50r; // "Cylinder_head_Left_400" //
			stock_parts_list_E[ 17] = parts.engines.Chrysler_V8_pak:0x000001B0r; // "Exhaust_header_left_big_B" //
			stock_parts_list_E[ 18] = parts.engines.Chrysler_V8_pak:0x000000BDr; // "Head_cover_left_O" //
			stock_parts_list_E[ 19] = parts.engines.Chrysler_V8_pak:0x00000F51r; // "Cylinder_head_Right_400" //
			stock_parts_list_E[ 20] = parts.engines.Chrysler_V8_pak:0x000001B2r; // "Exhaust_header_Right_big_B" //
			stock_parts_list_E[ 21] = parts.engines.Chrysler_V8_pak:0x000000BCr; // "Head_cover_Right_O" //
			stock_parts_list_E[ 22] = parts.engines.Chrysler_V8_pak:0x00000F2Br; // "Block_cover_big" //
			stock_parts_list_E[ 23] = parts.engines.Chrysler_V8_pak:0x000007FBr; // "Intake_manifold_big_4brl_O" //
			stock_parts_list_E[ 24] = parts.engines.Chrysler_V8_pak:0x0000088Br; // "Carburetors_4BRL_street_HOLLEY" //
			stock_parts_list_E[ 25] = parts.engines.Chrysler_V8_pak:0x00000BA9r; // "Air_cleaner_400" //
			stock_parts_list_E[ 26] = parts.engines.Chrysler_V8_pak:0x00000A02r; // "Ignition_distributor" //
			stock_parts_list_E[ 27] = parts.engines.Chrysler_V8_pak:0x00000096r; // "Alternator" //
			stock_parts_list_E[ 28] = parts.engines.Chrysler_V8_pak:0x0000009Ar; // "Belt_alternator_drive" //
			stock_parts_list_E[ 29] = parts.engines.Chrysler_V8_pak:0x00000E09r; // "Fan_5_blade" //
			stock_parts_list_E[ 30] = parts.engines.Chrysler_V8_pak:0x00000A97r; // "Power_Steering_pump" //
			stock_parts_list_E[ 31] = parts.engines.Chrysler_V8_pak:0x0000044Dr; // "Belt_Steering_pump" //
			stock_parts_list_E[ 32] = parts.engines.Chrysler_V8_pak:0x00000E16r; // "Radiator_big" //
			
			number2 = random();
			
			if ( number2 < 0.3 )
			{
				stock_parts_list_E[ 33] = parts.engines.Chrysler_V8_pak:0x00000099r; // "Transmission_A230_3spd" //
			}
			else if ( number2 < 0.6 )
			{
				stock_parts_list_E[ 33] = parts.engines.Chrysler_V8_pak:0x00000104r; // "Transmission_A727_3spd" //
			}
			else if ( number2 < 0.8 )
			{
				stock_parts_list_E[ 33] = parts.engines.Chrysler_V8_pak:0x00000107r; // "Transmission_A727_4spd" //
			}
			else if ( number2 < 0.95 )
			{
				stock_parts_list_E[ 33] = parts.engines.Chrysler_V8_pak:0x00000F89r; // "Transmission_A833_4spd" //
			}
			else
			{
				stock_parts_list_E[ 33] = parts.engines.Chrysler_V8_pak:0x00000F90r; // "Transmission_TKO500_5spd" //
			}
		}
		else if ( number < 0.9 )
		{
			stock_parts_list_E[ 1] = parts.engines.Chrysler_V8_pak:0x0000E440r; // "Engine_block_440" //
			stock_parts_list_E[ 2] = parts.engines.Chrysler_V8_pak:0x00000A2Br; // "Crankshaft_440_block" //
			stock_parts_list_E[ 3] = parts.engines.Chrysler_V8_pak:0x00000A6Br; // "Timing_gear_crankshaft" //
			stock_parts_list_E[ 4] = parts.engines.Chrysler_V8_pak:0x00000B60r; // "Connecting_rods_440_block" //
			stock_parts_list_E[ 5] = parts.engines.Chrysler_V8_pak:0x00000C5Cr; // "Pistons_440_block" //
			stock_parts_list_E[ 6] = parts.engines.Chrysler_V8_pak:0x00000A52r; // "Camshaft_440_block" //
			stock_parts_list_E[ 7] = parts.engines.Chrysler_V8_pak:0x00000AB4r; // "Timing_gear_camshaft" //
			stock_parts_list_E[ 8] = parts.engines.Chrysler_V8_pak:0x00000097r; // "Timing_chain" //
			stock_parts_list_E[ 9] = parts.engines.Chrysler_V8_pak:0x00000052r; // "Timing_gear_cover" //
			stock_parts_list_E[ 10] = parts.engines.Chrysler_V8_pak:0x00000C50r; // "Oil_pan_big_block_O" //
			stock_parts_list_E[ 11] = parts.engines.Chrysler_V8_pak:0x00000A99r; // "Oill_filter" //
			stock_parts_list_E[ 12] = parts.engines.Chrysler_V8_pak:0x00000083r; // "Flywheel_big_block" //
			stock_parts_list_E[ 13] = parts.engines.Chrysler_V8_pak:0x000000A7r; // "Clutch_big_block" //
			stock_parts_list_E[ 14] = parts.engines.Chrysler_V8_pak:0x00000A91r; // "Pulley_big_block" //
			stock_parts_list_E[ 15] = parts.engines.Chrysler_V8_pak:0x00000EE4r; // "Water_pomp_big_O" //
			stock_parts_list_E[ 16] = parts.engines.Chrysler_V8_pak:0x00000F52r; // "Cylinder_head_Left_440" //
			stock_parts_list_E[ 17] = parts.engines.Chrysler_V8_pak:0x000002B0r; // "Exhaust_header_left_big_RB" //
			stock_parts_list_E[ 18] = parts.engines.Chrysler_V8_pak:0x00000FC0r; // "Head_cover_left_RB" //
			stock_parts_list_E[ 19] = parts.engines.Chrysler_V8_pak:0x00000F53r; // "Cylinder_head_Right_440" //
			stock_parts_list_E[ 20] = parts.engines.Chrysler_V8_pak:0x000002B2r; // "Exhaust_header_Right_big_RB" //
			stock_parts_list_E[ 21] = parts.engines.Chrysler_V8_pak:0x00000FC1r; // "Head_cover_Right_RB" //
			stock_parts_list_E[ 22] = parts.engines.Chrysler_V8_pak:0x00000F2Br; // "Block_cover_big" //
			stock_parts_list_E[ 23] = parts.engines.Chrysler_V8_pak:0x000007FBr; // "Intake_manifold_big_4brl_O" //
			stock_parts_list_E[ 24] = parts.engines.Chrysler_V8_pak:0x0000088Br; // "Carburetors_4BRL_street_HOLLEY" //
			stock_parts_list_E[ 25] = parts.engines.Chrysler_V8_pak:0x00000BB0r; // "Air_cleaner_440" //
			stock_parts_list_E[ 26] = parts.engines.Chrysler_V8_pak:0x00000A02r; // "Ignition_distributor" //
			stock_parts_list_E[ 27] = parts.engines.Chrysler_V8_pak:0x00000096r; // "Alternator" //
			stock_parts_list_E[ 28] = parts.engines.Chrysler_V8_pak:0x0000009Ar; // "Belt_alternator_drive" //
			stock_parts_list_E[ 29] = parts.engines.Chrysler_V8_pak:0x00000E09r; // "Fan_5_blade" //
			stock_parts_list_E[ 30] = parts.engines.Chrysler_V8_pak:0x00000A97r; // "Power_Steering_pump" //
			stock_parts_list_E[ 31] = parts.engines.Chrysler_V8_pak:0x0000044Dr; // "Belt_Steering_pump" //
			stock_parts_list_E[ 32] = parts.engines.Chrysler_V8_pak:0x00000E16r; // "Radiator_big" //
			
			number2 = random();
			
			if ( number2 < 0.3 )
			{
				stock_parts_list_E[ 33] = parts.engines.Chrysler_V8_pak:0x00000107r; // "Transmission_A727_4spd" //
			}
			else if ( number2 < 0.65 )
			{
				stock_parts_list_E[ 33] = parts.engines.Chrysler_V8_pak:0x00000F89r; // "Transmission_A833_4spd" //
			}
			else
			{
				stock_parts_list_E[ 33] = parts.engines.Chrysler_V8_pak:0x00000F90r; // "Transmission_TKO500_5spd" //
			}
		}
		else
		{
			stock_parts_list_E[ 1] = parts.engines.Chrysler_V8_pak:0x0000E426r; // "Engine_block_426_XEMI" //
			stock_parts_list_E[ 2] = parts.engines.Chrysler_V8_pak:0x00000A5Br; // "Crankshaft_HEMI_block" //
			stock_parts_list_E[ 3] = parts.engines.Chrysler_V8_pak:0x00000A7Br; // "Timing_gear_crankshaft_HEMI" //
			stock_parts_list_E[ 4] = parts.engines.Chrysler_V8_pak:0x00000B61r; // "Connecting_rods_HEMI_block" //
			stock_parts_list_E[ 5] = parts.engines.Chrysler_V8_pak:0x00000C7Cr; // "Pistons_HEMI_block" //
			stock_parts_list_E[ 6] = parts.engines.Chrysler_V8_pak:0x000000B4r; // "Camshaft_HEMI_block" //
			stock_parts_list_E[ 7] = parts.engines.Chrysler_V8_pak:0x00000AB5r; // "Timing_gear_camshaft_HEMI" //
			stock_parts_list_E[ 8] = parts.engines.Chrysler_V8_pak:0x00000049r; // "Timing_chain_HEMI" //
			stock_parts_list_E[ 9] = parts.engines.Chrysler_V8_pak:0x000000BBr; // "Timing_gear_cover_HEMI" //
			stock_parts_list_E[ 10] = parts.engines.Chrysler_V8_pak:0x00000CC1r; // "Oil_pan_HEMI_block" //
			stock_parts_list_E[ 11] = parts.engines.Chrysler_V8_pak:0x00000A99r; // "Oill_filter" //
			stock_parts_list_E[ 12] = parts.engines.Chrysler_V8_pak:0x00000F83r; // "Flywheel_HEMI_block" //
			stock_parts_list_E[ 13] = parts.engines.Chrysler_V8_pak:0x00000084r; // "Clutch_HEMI_block" //
			stock_parts_list_E[ 14] = parts.engines.Chrysler_V8_pak:0x00000A92r; // "Pulley_HEMI_block" //
			stock_parts_list_E[ 15] = parts.engines.Chrysler_V8_pak:0x00000EE5r; // "Water_pomp_HEMI" //
			stock_parts_list_E[ 16] = parts.engines.Chrysler_V8_pak:0x00000F56r; // "Cylinder_head_Left_HEMI" //
			stock_parts_list_E[ 17] = parts.engines.Chrysler_V8_pak:0x000004B0r; // "Exhaust_header_left_HEMI_PERFORMANCE" //
			stock_parts_list_E[ 18] = parts.engines.Chrysler_V8_pak:0x00000FC2r; // "Head_cover_left_HEMI" //
			stock_parts_list_E[ 19] = parts.engines.Chrysler_V8_pak:0x00000F57r; // "Cylinder_head_Right_HEMI" //
			stock_parts_list_E[ 20] = parts.engines.Chrysler_V8_pak:0x000004B2r; // "Exhaust_header_Right_HEMI_PERFORMANCE" //
			stock_parts_list_E[ 21] = parts.engines.Chrysler_V8_pak:0x00000FC3r; // "Head_cover_Right_HEMI" //
			stock_parts_list_E[ 22] = parts.engines.Chrysler_V8_pak:0x00000F2Br; // "Block_cover_big" //
			stock_parts_list_E[ 23] = parts.engines.Chrysler_V8_pak:0x000007EBr; // "Intake_manifold_HEMI_Crossram" //
			stock_parts_list_E[ 24] = parts.engines.Chrysler_V8_pak:0x0000093Br; // "Carburetors_2x4BRL_Crassram_HOLLEY" //
			stock_parts_list_E[ 25] = parts.engines.Chrysler_V8_pak:0x00000BB2r; // "Air_cleaner_HEMI_crassram" //
			stock_parts_list_E[ 26] = parts.engines.Chrysler_V8_pak:0x00000A02r; // "Ignition_distributor" //
			stock_parts_list_E[ 27] = parts.engines.Chrysler_V8_pak:0x00000B96r; // "Alternator_HEMI" //
			stock_parts_list_E[ 28] = parts.engines.Chrysler_V8_pak:0x00000043r; // "Belt_alternator_HEMI" //
			stock_parts_list_E[ 29] = parts.engines.Chrysler_V8_pak:0x00000E14r; // "Fan_HEMI" //
			stock_parts_list_E[ 30] = parts.engines.Chrysler_V8_pak:0x00000A97r; // "Power_Steering_pump" //
			stock_parts_list_E[ 31] = parts.engines.Chrysler_V8_pak:0x0000044Dr; // "Belt_Steering_pump" //
			stock_parts_list_E[ 32] = parts.engines.Chrysler_V8_pak:0x00000E19r; // "Radiator_HEMI" //
			
			number2 = random();
			
			if ( number2 < 0.3 )
			{
				stock_parts_list_E[ 33] = parts.engines.Chrysler_V8_pak:0x00000107r; // "Transmission_A727_4spd" //
			}
			else if ( number2 < 0.65 )
			{
				stock_parts_list_E[ 33] = parts.engines.Chrysler_V8_pak:0x00000F89r; // "Transmission_A833_4spd" //
			}
			else if ( number2 < 0.85 )
			{
				stock_parts_list_E[ 33] = parts.engines.Chrysler_V8_pak:0x00000F90r; // "Transmission_TKO500_5spd" //
			}
			else
			{
				stock_parts_list_E[ 33] = parts.engines.Chrysler_V8_pak:0x00000F91r; // "Transmission_TKO600_5spd" //
			}
		}
		
		return stock_parts_list_E;
	}
}
