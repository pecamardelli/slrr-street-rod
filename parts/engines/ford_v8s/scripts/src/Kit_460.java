package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;


public class Kit_460 extends Set
{
	public Kit_460( int id )
	{
		super( id  );
		name = "Ford 460 V8 engine kit";
		description = "";
	}

	public void build( Inventory inv )
	{		
		inv.insertItem( parts.engines.ford_v8s:0x00004001r ); // "Ford_460_block" // 
		inv.insertItem( parts.engines.ford_v8s:0x000040FEr ); // "Ford_460_crankshaft" // 
		inv.insertItem( parts.engines.ford_v8s:0x000000BBr ); // "Ford_stock_crankshaft_timing_gear" // 
		inv.insertItem( parts.engines.ford_v8s:0x00004055r ); // "Ford_460_connecting_rods" // 
		inv.insertItem( parts.engines.ford_v8s:0x00004056r ); // "Ford_460_pistons" // 
		inv.insertItem( parts.engines.ford_v8s:0x000040B4r ); // "Ford_460_camshaft" // 
		inv.insertItem( parts.engines.ford_v8s:0x000000BAr ); // "Ford_stock_camshaft_timing_gear" // 
		inv.insertItem( parts.engines.ford_v8s:0x0000004Fr ); // "Ford_stock_timing_chain" // 
		inv.insertItem( parts.engines.ford_v8s:0x000040B5r ); // "Ford_460_timing_cover" // 
		inv.insertItem( parts.engines.ford_v8s:0x00004095r ); // "Ford_460_oil_pan" // 
		inv.insertItem( parts.engines.ford_v8s:0x00000048r ); // "Motorcraft_oil_filter" // 
		inv.insertItem( parts.engines.ford_v8s:0x00004083r ); // "Ford_460_flywheel" // 
		inv.insertItem( parts.engines.ford_v8s:0x00004084r ); // "Ford_460_clutch" // 
		inv.insertItem( parts.engines.ford_v8s:0x0000409Br ); // "Ford_460_pulley" // 
		inv.insertItem( parts.engines.ford_v8s:0x00004052r ); // "Ford_460_water_pomp" // 
		inv.insertItem( parts.engines.ford_v8s:0x000040ADr ); // "Ford_460_left_cylinder_head" // 
		inv.insertItem( parts.engines.ford_v8s:0x000040B0r ); // "Ford_460_left_exhaust_header" // 
		inv.insertItem( parts.engines.ford_v8s:0x00004042r ); // "Ford_460_left_cylinder_head_cover" // 
		inv.insertItem( parts.engines.ford_v8s:0x000040AFr ); // "Ford_460_right_cylinder_head" // 
		inv.insertItem( parts.engines.ford_v8s:0x000040B2r ); // "Ford_460_right_exhaust_header" // 
		inv.insertItem( parts.engines.ford_v8s:0x00004044r ); // "Ford_460_right_cylinder_head_cover" //
		inv.insertItem( parts.engines.ford_v8s:0x00003048r ); // "block_cover" //
		inv.insertItem( parts.engines.ford_v8s:0x000040BEr ); // "Ford_460_4brl_intake_manifold" // 
		inv.insertItem( parts.engines.ford_v8s:0x0000008Br ); // "carb_4brl" //
		inv.insertItem( parts.engines.ford_v8s:0x00005686r ); // "Ford_460_4brl_air_filter" // 
		inv.insertItem( parts.engines.ford_v8s:0x0000A811r ); // "Mallory_Ignition" // 
		inv.insertItem( parts.engines.ford_v8s:0x00000047r ); // "Ford_stock_alternator" // 
		inv.insertItem( parts.engines.ford_v8s:0x00000043r ); // "Ford_stock_alt_drive_belt" // 
		inv.insertItem( parts.engines.ford_v8s:0x00000097r ); // "Ford_5_blade_fan" // 
		inv.insertItem( parts.engines.ford_v8s:0x00003548r ); // "Ford_351_390_radiator_1" //
		inv.insertItem( parts.engines.ford_v8s:0x0000A599r ); // "Tranny_borg_warner_t18_4spd" //
	}
}
