package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;


public class Kit_260 extends Set
{
	public Kit_260( int id )
	{
		super( id  ); // 
		name = "Ford 260 V8 engine kit";
		description = "";
	}

	public void build( Inventory inv )
	{		
		inv.insertItem( parts.engines.ford_v8s:0x00008001r ); // "Ford_260_block" // 
		inv.insertItem( parts.engines.ford_v8s:0x000080FEr ); // "Ford_260_crankshaft" // 
		inv.insertItem( parts.engines.ford_v8s:0x000000BBr ); // "Ford_stock_crankshaft_timing_gear" // 
		inv.insertItem( parts.engines.ford_v8s:0x000080A8r ); // "Ford_260_connecting_rods" // 
		inv.insertItem( parts.engines.ford_v8s:0x00000056r ); // "Ford_260_292_312_pistons" // 
		inv.insertItem( parts.engines.ford_v8s:0x00008051r ); // "Ford_260_camshaft" // 
		inv.insertItem( parts.engines.ford_v8s:0x000000BAr ); // "Ford_stock_camshaft_timing_gear" // 
		inv.insertItem( parts.engines.ford_v8s:0x0000004Fr ); // "Ford_stock_timing_chain" // 
		inv.insertItem( parts.engines.ford_v8s:0x000080B5r ); // "Ford_260_timing_cover" // 
		inv.insertItem( parts.engines.ford_v8s:0x00008095r ); // "Ford_260_oil_pan" // 
		inv.insertItem( parts.engines.ford_v8s:0x00000048r ); // "Motorcraft_oil_filter" // 
		inv.insertItem( parts.engines.ford_v8s:0x00008083r ); // "Ford_260_flywheel" // 
		inv.insertItem( parts.engines.ford_v8s:0x00008084r ); // "Ford_260_clutch" // 
		inv.insertItem( parts.engines.ford_v8s:0x0000809Br ); // "Ford_260_pulley" // 
		inv.insertItem( parts.engines.ford_v8s:0x00008052r ); // "Ford_260_water_pomp" // 
		inv.insertItem( parts.engines.ford_v8s:0x000080ADr ); // "Ford_260_left_cylinder_head" // 
		inv.insertItem( parts.engines.ford_v8s:0x000080B0r ); // "Ford_260_left_exhaust_header" // 
		inv.insertItem( parts.engines.ford_v8s:0x00008042r ); // "Ford_260_left_cylinder_head_cover" // 
		inv.insertItem( parts.engines.ford_v8s:0x000080AFr ); // "Ford_260_right_cylinder_head" // 
		inv.insertItem( parts.engines.ford_v8s:0x000080B2r ); // "Ford_260_right_exhaust_header" // 
		inv.insertItem( parts.engines.ford_v8s:0x00008044r ); // "Ford_260_right_cylinder_head_cover" // 
		inv.insertItem( parts.engines.ford_v8s:0x000080BEr ); // "Ford_260_4brl_intake_manifold" // 
		inv.insertItem( parts.engines.ford_v8s:0x0000008Br ); // "carb_4brl" // 
		inv.insertItem( parts.engines.ford_v8s:0x00008086r ); // "Ford_260_4brl_air_filter" // 
		inv.insertItem( parts.engines.ford_v8s:0x0000004Ar ); // "Ford_stock_distributor" // 
		inv.insertItem( parts.engines.ford_v8s:0x00000047r ); // "Ford_stock_alternator" // 
		inv.insertItem( parts.engines.ford_v8s:0x00000043r ); // "Ford_stock_alt_drive_belt" // 
		inv.insertItem( parts.engines.ford_v8s:0x00003097r ); // "Ford_4_blade_fan" // 
		inv.insertItem( parts.engines.ford_v8s:0x00000548r ); // "Ford_stock_radiator" //
		inv.insertItem( parts.engines.ford_v8s:0x00000099r ); // "Tranny_HED_BH_3spd" // 
	}
}
