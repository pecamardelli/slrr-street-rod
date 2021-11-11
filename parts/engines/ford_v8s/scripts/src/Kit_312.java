package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;


public class Kit_312 extends Set
{
	public Kit_312( int id )
	{
		super( id  ); // 
		name = "Ford 312 V8 engine kit";
		description = "";
	}

	public void build( Inventory inv )
	{		
		inv.insertItem( parts.engines.ford_v8s:0x00009001r ); // "Ford_312_block" // 
		inv.insertItem( parts.engines.ford_v8s:0x000090FEr ); // "Ford_312_crankshaft" // 
		inv.insertItem( parts.engines.ford_v8s:0x000000BBr ); // "Ford_stock_crankshaft_timing_gear" // 
		inv.insertItem( parts.engines.ford_v8s:0x000090A8r ); // "Ford_312_connecting_rods" // 
		inv.insertItem( parts.engines.ford_v8s:0x00000056r ); // "Ford_260_292_312_pistons" // 
		inv.insertItem( parts.engines.ford_v8s:0x00009051r ); // "Ford_312_camshaft" // 
		inv.insertItem( parts.engines.ford_v8s:0x000000BAr ); // "Ford_stock_camshaft_timing_gear" // 
		inv.insertItem( parts.engines.ford_v8s:0x0000004Fr ); // "Ford_stock_timing_chain" // 
		inv.insertItem( parts.engines.ford_v8s:0x000090B5r ); // "Ford_312_timing_cover" // 
		inv.insertItem( parts.engines.ford_v8s:0x00009095r ); // "Ford_312_oil_pan" // 
		inv.insertItem( parts.engines.ford_v8s:0x00000048r ); // "Motorcraft_oil_filter" // 
		inv.insertItem( parts.engines.ford_v8s:0x00009083r ); // "Ford_312_flywheel" // 
		inv.insertItem( parts.engines.ford_v8s:0x00009084r ); // "Ford_312_clutch" // 
		inv.insertItem( parts.engines.ford_v8s:0x0000909Br ); // "Ford_312_pulley" // 
		inv.insertItem( parts.engines.ford_v8s:0x00009052r ); // "Ford_312_water_pomp" // 
		inv.insertItem( parts.engines.ford_v8s:0x000090ADr ); // "Ford_312_left_cylinder_head" // 
		inv.insertItem( parts.engines.ford_v8s:0x000090B0r ); // "Ford_312_left_exhaust_header" // 
		inv.insertItem( parts.engines.ford_v8s:0x00009042r ); // "Ford_312_left_cylinder_head_cover" // 
		inv.insertItem( parts.engines.ford_v8s:0x000090AFr ); // "Ford_312_right_cylinder_head" // 
		inv.insertItem( parts.engines.ford_v8s:0x000090B2r ); // "Ford_312_right_exhaust_header" // 
		inv.insertItem( parts.engines.ford_v8s:0x00009044r ); // "Ford_312_right_cylinder_head_cover" // 
		inv.insertItem( parts.engines.ford_v8s:0x000090BEr ); // "Ford_312_4brl_intake_manifold" // 
		inv.insertItem( parts.engines.ford_v8s:0x0000008Br ); // "carb_4brl" // 
		inv.insertItem( parts.engines.ford_v8s:0x00009086r ); // "Ford_312_4brl_air_filter" // 
		inv.insertItem( parts.engines.ford_v8s:0x0000A811r ); // "Mallory_Ignition" // 
		inv.insertItem( parts.engines.ford_v8s:0x00000047r ); // "Ford_stock_alternator" // 
		inv.insertItem( parts.engines.ford_v8s:0x00000043r ); // "Ford_stock_alt_drive_belt" // 
		inv.insertItem( parts.engines.ford_v8s:0x00000097r ); // "Ford_5_blade_fan" // 
		inv.insertItem( parts.engines.ford_v8s:0x00000548r ); // "Ford_stock_radiator" // 
		inv.insertItem( parts.engines.ford_v8s:0x00003099r ); // "Tranny_borg_warner_t10_4spd" // 
	}
}
