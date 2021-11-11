package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;


public class Kit_302 extends Set
{
	public Kit_302( int id )
	{
		super( id  ); // 
		name = "Ford 302 V8 engine kit";
		description = "";
	}

	public void build( Inventory inv )
	{		
		inv.insertItem( parts.engines.ford_v8s:0x00006001r ); // "Ford_302_block" // 
		inv.insertItem( parts.engines.ford_v8s:0x000060FEr ); // "Ford_302_crankshaft" // 
		inv.insertItem( parts.engines.ford_v8s:0x000000BBr ); // "Ford_stock_crankshaft_timing_gear" // 
		inv.insertItem( parts.engines.ford_v8s:0x000060A8r ); // "Ford_302_connecting_rods" // 
		inv.insertItem( parts.engines.ford_v8s:0x00005056r ); // "Ford_302_332_351_pistons" // 
		inv.insertItem( parts.engines.ford_v8s:0x00006A51r ); // "Ford_302_camshaft" // 
		inv.insertItem( parts.engines.ford_v8s:0x000000BAr ); // "Ford_stock_camshaft_timing_gear" // 
		inv.insertItem( parts.engines.ford_v8s:0x0000004Fr ); // "Ford_stock_timing_chain" // 
		inv.insertItem( parts.engines.ford_v8s:0x000000B5r ); // "Ford_stock_timing_cover" // 
		inv.insertItem( parts.engines.ford_v8s:0x00005095r ); // "Ford_302_332_351_oil_pan" // 
		inv.insertItem( parts.engines.ford_v8s:0x00000048r ); // "Motorcraft_oil_filter" // 
		inv.insertItem( parts.engines.ford_v8s:0x00003583r ); // "Ford_302_332_351_flywheel" // 
		inv.insertItem( parts.engines.ford_v8s:0x00003584r ); // "Ford_302_332_351_clutch" // 
		inv.insertItem( parts.engines.ford_v8s:0x0000009Br ); // "Ford_stock_pulley" // 
		inv.insertItem( parts.engines.ford_v8s:0x00000052r ); // "Ford_stock_water_pomp" // 
		inv.insertItem( parts.engines.ford_v8s:0x000060ADr ); // "Ford_302_left_cylinder_head" // 
		inv.insertItem( parts.engines.ford_v8s:0x000060B0r ); // "Ford_302_left_exhaust_header" // 
		inv.insertItem( parts.engines.ford_v8s:0x00000842r ); // "Edelbrock_left_cylinder_head_cover" // 
		inv.insertItem( parts.engines.ford_v8s:0x000060AFr ); // "Ford_302_right_cylinder_head" // 
		inv.insertItem( parts.engines.ford_v8s:0x000060B2r ); // "Ford_302_right_exhaust_header" // 
		inv.insertItem( parts.engines.ford_v8s:0x00000844r ); // "Edelbrock_right_cylinder_head_cover" //
		inv.insertItem( parts.engines.ford_v8s:0x00001A48r ); // "Ford_351_block_cover" //
		inv.insertItem( parts.engines.ford_v8s:0x00006BBEr ); // "Ford_302_4brl_intake_manifold" // 
		inv.insertItem( parts.engines.ford_v8s:0x0000008Br ); // "carb_4brl" // 
		inv.insertItem( parts.engines.ford_v8s:0x00000886r ); // "Edelbrock_4brl_air_filter" // 
		inv.insertItem( parts.engines.ford_v8s:0x0000A811r ); // "Mallory_Ignition" // 
		inv.insertItem( parts.engines.ford_v8s:0x00000047r ); // "Ford_stock_alternator" // 
		inv.insertItem( parts.engines.ford_v8s:0x00000043r ); // "Ford_stock_alt_drive_belt" // 
		inv.insertItem( parts.engines.ford_v8s:0x00000097r ); // "Ford_5_blade_fan" // 
		inv.insertItem( parts.engines.ford_v8s:0x00003548r ); // "Ford_351_390_radiator_1" // 
		inv.insertItem( parts.engines.ford_v8s:0x00003099r ); // "Tranny_borg_warner_t10_4spd" // 
	}
}
