package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;


public class Kit_429_Cobra_Jet extends Set
{
	public Kit_429_Cobra_Jet( int id )
	{
		super( id  );
		name = "Ford Cobra Jet 429 V8 engine kit";
		description = "";
	}

	public void build( Inventory inv )
	{		
		inv.insertItem( parts.engines.ford_v8s:0x00004261r ); // "Cobra_Jet_429_block" // 
		inv.insertItem( parts.engines.ford_v8s:0x0000B261r ); // "Cobra_Jet_429_crankshaft" // 
		inv.insertItem( parts.engines.ford_v8s:0x00004B20r ); // "Cobra_Jet_429_crankshaft_timing_gear" // 
		inv.insertItem( parts.engines.ford_v8s:0x0000F661r ); // "Cobra_Jet_429_connecting_rods" // 
		inv.insertItem( parts.engines.ford_v8s:0x0000F761r ); // "Cobra_Jet_429_pistons" // 
		inv.insertItem( parts.engines.ford_v8s:0x0000E261r ); // "Cobra_Jet_429_camshaft" // 
		inv.insertItem( parts.engines.ford_v8s:0x00004B12r ); // "Cobra_Jet_429_camshaft_timing_gear" // 
		inv.insertItem( parts.engines.ford_v8s:0x00004B16r ); // "Cobra_Jet_429_timing_chain" // 
		inv.insertItem( parts.engines.ford_v8s:0x0000F361r ); // "Cobra_Jet_429_timing_cover" // 
		inv.insertItem( parts.engines.ford_v8s:0x0000A261r ); // "Cobra_Jet_429_oil_pan" // 
		inv.insertItem( parts.engines.ford_v8s:0x0000D261r ); // "FoMoCo_oil_filter" // 
		inv.insertItem( parts.engines.ford_v8s:0x00004B32r ); // "Cobra_Jet_429_flywheel" // 
		inv.insertItem( parts.engines.ford_v8s:0x00004B36r ); // "Cobra_Jet_429_clutch" // 
		inv.insertItem( parts.engines.ford_v8s:0x0000F561r ); // "Cobra_Jet_429_pulley" // 
		inv.insertItem( parts.engines.ford_v8s:0x0000F861r ); // "Cobra_Jet_429_water_pomp" // 
		inv.insertItem( parts.engines.ford_v8s:0x0000F93Ar ); // "Cobra_Jet_429_left_cylinder_head" // 
		inv.insertItem( parts.engines.ford_v8s:0x00004B44r ); // "Cobra_Jet_429_left_exhaust_header" // 
		inv.insertItem( parts.engines.ford_v8s:0x0000414Ar ); // "Cobra_Jet_429_left_cylinder_head_cover" // 
		inv.insertItem( parts.engines.ford_v8s:0x0000F961r ); // "Cobra_Jet_429_right_cylinder_head" // 
		inv.insertItem( parts.engines.ford_v8s:0x00004B40r ); // "Cobra_Jet_429_right_exhaust_header" // 
		inv.insertItem( parts.engines.ford_v8s:0x00004B00r ); // "Cobra_Jet_429_right_cylinder_head_cover" //
		inv.insertItem( parts.engines.ford_v8s:0x00003048r ); // "block_cover" //
		inv.insertItem( parts.engines.ford_v8s:0x0000F261r ); // "Cobra_Jet_429_4brl_intake_manifold" // 
		inv.insertItem( parts.engines.ford_v8s:0x0000008Br ); // "carb_4brl" //
		inv.insertItem( parts.engines.ford_v8s:0x00000816r ); // "edelbrockracing_cleaner" // 
		inv.insertItem( parts.engines.ford_v8s:0x0000A811r ); // "Mallory_Ignition" // 
		inv.insertItem( parts.engines.ford_v8s:0x00000047r ); // "Cobra_Jet_429_alternator" // 
		inv.insertItem( parts.engines.ford_v8s:0x00004B04r ); // "Cobra_Jet_429_alternator_drive_belt" // 
		inv.insertItem( parts.engines.ford_v8s:0x00004B24r ); // "Cobra_Jet_429_fan" // 
		inv.insertItem( parts.engines.ford_v8s:0x00004B28r ); // "Cobra_Jet_429_radiator" //
		inv.insertItem( parts.engines.ford_v8s:0x00000899r ); // "Tranny_tremec_t56_6spd" //
		
	}
}
