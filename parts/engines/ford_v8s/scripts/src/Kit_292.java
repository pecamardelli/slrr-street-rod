package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;


public class Kit_292 extends Set
{
	public Kit_292( int id )
	{
		super( id  ); // 
		name = "Ford 292 V8 engine kit";
		description = "";
	}

	public void build( Inventory inv )
	{		
		inv.insertItem( parts.engines.ford_v8s:0x00000001r ); // "Ford_292_block" // 
		inv.insertItem( parts.engines.ford_v8s:0x000000FEr ); // "Ford_292_crankshaft" // 
		inv.insertItem( parts.engines.ford_v8s:0x000000BBr ); // "Ford_stock_crankshaft_timing_gear" // 
		inv.insertItem( parts.engines.ford_v8s:0x000000A8r ); // "Ford_292_connecting_rods" // 
		inv.insertItem( parts.engines.ford_v8s:0x00000056r ); // "Ford_260_292_312_pistons" // 
		inv.insertItem( parts.engines.ford_v8s:0x00000051r ); // "Ford_292_camshaft" // 
		inv.insertItem( parts.engines.ford_v8s:0x000000BAr ); // "Ford_stock_camshaft_timing_gear" // 
		inv.insertItem( parts.engines.ford_v8s:0x0000004Fr ); // "Ford_stock_timing_chain" // 
		inv.insertItem( parts.engines.ford_v8s:0x000000B5r ); // "Ford_stock_timing_cover" // 
		inv.insertItem( parts.engines.ford_v8s:0x00000095r ); // "Ford_292_oil_pan" // 
		inv.insertItem( parts.engines.ford_v8s:0x00000048r ); // "Motorcraft_oil_filter" // 
		inv.insertItem( parts.engines.ford_v8s:0x00000083r ); // "Ford_292_flywheel" // 
		inv.insertItem( parts.engines.ford_v8s:0x00000084r ); // "Ford_292_clutch" // 
		inv.insertItem( parts.engines.ford_v8s:0x0000009Br ); // "Ford_stock_pulley" // 
		inv.insertItem( parts.engines.ford_v8s:0x00000052r ); // "Ford_stock_water_pomp" // 
		inv.insertItem( parts.engines.ford_v8s:0x000000ADr ); // "Ford_292_left_cylinder_head" // 
		inv.insertItem( parts.engines.ford_v8s:0x000000B0r ); // "Ford_292_left_exhaust_header" // 
		inv.insertItem( parts.engines.ford_v8s:0x00000042r ); // "Ford_292_left_cylinder_head_cover" // 
		inv.insertItem( parts.engines.ford_v8s:0x000000AFr ); // "Ford_292_right_cylinder_head" // 
		inv.insertItem( parts.engines.ford_v8s:0x000000B2r ); // "Ford_292_right_exhaust_header" // 
		inv.insertItem( parts.engines.ford_v8s:0x00000044r ); // "Ford_292_right_cylinder_head_cover" // 
		inv.insertItem( parts.engines.ford_v8s:0x000000BEr ); // "Ford_292_4brl_intake_manifold" // 
		inv.insertItem( parts.engines.ford_v8s:0x0000008Br ); // "carb_4brl" // 
		inv.insertItem( parts.engines.ford_v8s:0x00000086r ); // "Ford_292_4brl_air_filter" // 
		inv.insertItem( parts.engines.ford_v8s:0x0000A811r ); // "Mallory_Ignition" // 
		inv.insertItem( parts.engines.ford_v8s:0x00000047r ); // "Ford_stock_alternator" // 
		inv.insertItem( parts.engines.ford_v8s:0x00000043r ); // "Ford_stock_alt_drive_belt" // 
		inv.insertItem( parts.engines.ford_v8s:0x00000097r ); // "Ford_5_blade_fan" // 
		inv.insertItem( parts.engines.ford_v8s:0x00000548r ); // "Ford_stock_radiator" // 
		inv.insertItem( parts.engines.ford_v8s:0x00000599r ); // "Tranny_HEG_W_3spd" // 
	}
}
