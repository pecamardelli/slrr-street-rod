package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;


public class kit_221 extends Set
{
	public kit_221( int id )
	{
		super( id );
		name = "Ford 221 cu.in. engine kit";
		description = "";
	}

	public void build( Inventory inv )
	{
		inv.insertItem( parts.engines.ford_l6:0x0000007Er ); // ford_221_block
		inv.insertItem( parts.engines.ford_l6:0x0000007Dr ); // ford_221_crankshaft
		inv.insertItem( parts.engines.ford_l6:0x0000004Er ); // ford_stock_crankshaft_bearing_bridge
		inv.insertItem( parts.engines.ford_l6:0x00000049r ); // ford_stock_oil_pan
		inv.insertItem( parts.engines.ford_l6:0x00000093r ); // ford_221_connecting_rods
		inv.insertItem( parts.engines.ford_l6:0x00000054r ); // ford_188_221_pistons
		inv.insertItem( parts.engines.ford_l6:0x0000004Dr ); // ford_stock_alternator
		inv.insertItem( parts.engines.ford_l6:0x00000045r ); // ford_stock_flywheel
		inv.insertItem( parts.engines.ford_l6:0x00000043r ); // ford_stock_clutch
		inv.insertItem( parts.engines.ford_l6:0x00000082r ); // ford_stock_cylinder_head
		inv.insertItem( parts.engines.ford_l6:0x0000008Ar ); // ford_221_camshaft
		inv.insertItem( parts.engines.ford_l6:0x0000004Fr ); // ford_stock_cylinder_head_cover
		inv.insertItem( parts.engines.ford_l6:0x000000BAr ); // ford_stock_camshaft_timing_gear
		inv.insertItem( parts.engines.ford_l6:0x000010BBr ); // ford_stock_crank_timing_gear
		inv.insertItem( parts.engines.ford_l6:0x0000104Fr ); // ford_stock_timing_chain
		inv.insertItem( parts.engines.ford_l6:0x000010B5r ); // ford_stock_timing_cover
		inv.insertItem( parts.engines.ford_l6:0x0000504Ar ); // ford_stock_drive_pulley
		inv.insertItem( parts.engines.ford_l6:0x0000404Ar ); // ford_stock_water_pump
        inv.insertItem( parts.engines.ford_l6:0x00000048r ); // ford_stock_alternator_drive_belt
		inv.insertItem( parts.engines.ford_l6:0x000000B7r ); // ford_stock_fuel_pump
		inv.insertItem( parts.engines.ford_l6:0x0000104Ar ); // ford_stock_distributor
		inv.insertItem( parts.engines.ford_l6:0x0000304Ar ); // ford_stock_ignition_coil
		inv.insertItem( parts.engines.ford_l6:0x0000204Ar ); // ford_stock_plugs_and_wires
		inv.insertItem( parts.engines.ford_l6:0x0000604Ar ); // ford_stock_cooling_fan
		inv.insertItem( parts.engines.ford_l6:0x0000704Ar ); // ford_three_line_radiator
		inv.insertItem( parts.engines.ford_l6:0x0000804Ar ); // ford_stock_starter
		inv.insertItem( parts.engines.ford_l6:0x00000092r ); // ford_stock_intake_manifold
		inv.insertItem( parts.engines.ford_l6:0x0000008Dr ); // ford_stock_exhaust_header
		inv.insertItem( parts.engines.ford_l6:0x00000091r ); // carb_holley_1946
		inv.insertItem( parts.engines.ford_l6:0x00000059r ); // ford_stock_air_filter
		
		inv.insertItem( parts.engines.ford_l6:0x00000046r ); // saginaw_4spd_gearbox
	}
}
