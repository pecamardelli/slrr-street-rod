package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;


public class Kit_390 extends Set
{
	public Kit_390( int id )
	{
		super( id  ); // 
		name = "Ford 390 V8 engine kit";
		description = "";
	}

	public void build( Inventory inv )
	{		
		inv.insertItem( parts.engines.ford_v8s:0x00003001r ); // "Ford_390_block" // 
		inv.insertItem( parts.engines.ford_v8s:0x000030FEr ); // "Ford_390_crankshaft" // 
		inv.insertItem( parts.engines.ford_v8s:0x000000BBr ); // "Ford_stock_crankshaft_timing_gear" // 
		inv.insertItem( parts.engines.ford_v8s:0x00003055r ); // "Ford_390_connecting_rods" // 
		inv.insertItem( parts.engines.ford_v8s:0x00003156r ); // "Ford_390_pistons" // 
		inv.insertItem( parts.engines.ford_v8s:0x000030B4r ); // "Ford_390_camshaft" // 
		inv.insertItem( parts.engines.ford_v8s:0x000000BAr ); // "Ford_stock_camshaft_timing_gear" // 
		inv.insertItem( parts.engines.ford_v8s:0x0000004Fr ); // "Ford_stock_timing_chain" // 
		inv.insertItem( parts.engines.ford_v8s:0x000030B5r ); // "Ford_390_timing_cover" // 
		inv.insertItem( parts.engines.ford_v8s:0x00003095r ); // "Ford_390_oil_pan" // 
		inv.insertItem( parts.engines.ford_v8s:0x00000048r ); // "Motorcraft_oil_filter" // 
		inv.insertItem( parts.engines.ford_v8s:0x00003083r ); // "Ford_390_flywheel" // 
		inv.insertItem( parts.engines.ford_v8s:0x00003084r ); // "Ford_390_clutch" // 
		inv.insertItem( parts.engines.ford_v8s:0x0000309Br ); // "Ford_390_pulley" // 
		inv.insertItem( parts.engines.ford_v8s:0x00003052r ); // "Ford_390_water_pomp" // 
		inv.insertItem( parts.engines.ford_v8s:0x00003142r ); // "Ford_351_390_left_cylinder_head_cover_chrome" // 
		inv.insertItem( parts.engines.ford_v8s:0x000030B0r ); // "Ford_351_390_left_exhaust_header" // 
		inv.insertItem( parts.engines.ford_v8s:0x00000842r ); // "Edelbrock_left_cylinder_head_cover" // 
		inv.insertItem( parts.engines.ford_v8s:0x000030AFr ); // "Ford_351_390_right_cylinder_head" // 
		inv.insertItem( parts.engines.ford_v8s:0x000030B2r ); // "Ford_351_390_right_exhaust_header" // 
		inv.insertItem( parts.engines.ford_v8s:0x00003144r ); // "Ford_351_390_right_cylinder_head_cover_chrome" //
		inv.insertItem( parts.engines.ford_v8s:0x00004048r ); // "block_cover_hr" //
		inv.insertItem( parts.engines.ford_v8s:0x000030BEr ); // "Ford_390_4brl_intake_manifold" // 
		inv.insertItem( parts.engines.ford_v8s:0x0000008Br ); // "carb_4brl" //
		inv.insertItem( parts.engines.ford_v8s:0x00004686r ); // "Ford_390_4brl_air_filter" // 
		inv.insertItem( parts.engines.ford_v8s:0x0000A811r ); // "Mallory_Ignition" // 
		inv.insertItem( parts.engines.ford_v8s:0x00000047r ); // "Ford_stock_alternator" // 
		inv.insertItem( parts.engines.ford_v8s:0x00000043r ); // "Ford_stock_alt_drive_belt" // 
		inv.insertItem( parts.engines.ford_v8s:0x00000097r ); // "Ford_5_blade_fan" // 
		inv.insertItem( parts.engines.ford_v8s:0x00003548r ); // "Ford_351_390_radiator_1" //
		inv.insertItem( parts.engines.ford_v8s:0x00003099r ); // "Tranny_borg_warner_t10_4spd" // 
	}
}
