package java.game.parts.engines.GM_V8_pak;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;


public class Crate_GM_283_block extends Set
{
	public Crate_GM_283_block( int id )
	{
		super( id  ); // 
		name = "GM 283 cui small block V8 engine";
		description = "";
	}

	public void build( Inventory inv )
	{
        inv.insertItem( parts.engines.GM_V8_pak:0x0000003Fr ); // "GM 283-307 small block" //
        inv.insertItem( parts.engines.GM_V8_pak:0x0000003Er ); // "GM 283 cui small block crankshaft" //
        inv.insertItem( parts.engines.GM_V8_pak:0x00000055r ); // "V8 Small Block Rods" //
        inv.insertItem( parts.engines.GM_V8_pak:0x0000E23Er ); // "GM Small Block Crank Gear" //
        inv.insertItem( parts.engines.GM_V8_pak:0x00000003r ); // "V8 Camshaft" //
        inv.insertItem( parts.engines.GM_V8_pak:0x0000E103r ); // "GM Small block stock camshaft timing gear" //
        inv.insertItem( parts.engines.GM_V8_pak:0x00000056r ); // "GM Small block stock pistons (283, 302)" //
        inv.insertItem( parts.engines.GM_V8_pak:0x000000ADr ); // "V8 Small Block Left head" //
        inv.insertItem( parts.engines.GM_V8_pak:0x000000AFr ); // "V8 Small Block Right Head" //
        inv.insertItem( parts.engines.GM_V8_pak:0x000000BDr ); // "V8 Small Block Left head Cover" //
        inv.insertItem( parts.engines.GM_V8_pak:0x0000C1BDr ); // "GM Small block left cylinder head cover cup" //
        inv.insertItem( parts.engines.GM_V8_pak:0x000000BCr ); // "V8 Small Block Right head Cover" //
        inv.insertItem( parts.engines.GM_V8_pak:0x000000B0r ); // "V8 Small Block Left Exhaust Header" //
        inv.insertItem( parts.engines.GM_V8_pak:0x000000B2r ); // "V8 Small Block Right Exhaust Header" //
        inv.insertItem( parts.engines.GM_V8_pak:0x00000043r ); // "V8 Small block stock timing chain" //
        inv.insertItem( parts.engines.GM_V8_pak:0x0000F303r ); // "GM 283-302 Small block stock timing chain cover" //
        inv.insertItem( parts.engines.GM_V8_pak:0x0000F103r ); // "GM Small block stock harmonic damper" //
        inv.insertItem( parts.engines.GM_V8_pak:0x0000E303r ); // "GM Small block stock water pump" //
        inv.insertItem( parts.engines.GM_V8_pak:0x00009049r ); // "GM Small block stock cooling fan" //
        inv.insertItem( parts.engines.GM_V8_pak:0x0000004Ar ); // "Stock Oil Filter" //
        inv.insertItem( parts.engines.GM_V8_pak:0x00000083r ); // "V8 Small Block Flywheel" //
        inv.insertItem( parts.engines.GM_V8_pak:0x00000084r ); // "V8 Small Block Clutch" //
        inv.insertItem( parts.engines.GM_V8_pak:0x00000089r ); // "V8 3speed Tranny" //
        inv.insertItem( parts.engines.GM_V8_pak:0x00000048r ); // "V8 Small Block Oil Pan" //
        inv.insertItem( parts.engines.GM_V8_pak:0x00000047r ); // "Alternator" //
        inv.insertItem( parts.engines.GM_V8_pak:0x00000049r ); // "Alternator Belt" //
        inv.insertItem( parts.engines.GM_V8_pak:0x0000B103r ); // "Radiator" //
        inv.insertItem( parts.engines.GM_V8_pak:0x0000A0A1r ); // "V8 Small Block 2brl Intake Manifold" //
        inv.insertItem( parts.engines.GM_V8_pak:0x000000A3r ); // "Stock 2brl Carb" //
        inv.insertItem( parts.engines.GM_V8_pak:0x00000086r ); // "GM stock air filter" //
        inv.insertItem( parts.engines.GM_V8_pak:0x000000C7r ); // "Stock Ignition Distributor" //

        // inv.insertItem( parts.engines.GM_V8_pak:0x000000BEr ); // "Edelbrock 3x2brl V8 intake" //
        // inv.insertItem( parts.engines.GM_V8_pak:0x0000108Br ); // "holley 2300 2brl 3 carb set" //
        // inv.insertItem( parts.engines.GM_V8_pak:0x000020A5r ); // "summit polished-aluminium air filter" //
    
        // inv.insertItem( parts.engines.GM_V8_pak:0x0000004Br ); // "GM Small block stock 4brl intake manifold" //
    
        // inv.insertItem( parts.engines.GM_V8_pak:0x0000A0A3r ); // "stock 4brl carb" //

        // inv.insertItem( parts.engines.GM_V8_pak:0x0000B1A3r ); // "Holley dominator" //

        // inv.insertItem( parts.engines.GM_V8_pak:0x00000086r ); // "GM stock air filter" //

        // inv.insertItem( parts.engines.GM_V8_pak:0x000030A5r ); // "GM stock low-resistance air filter" //

        // inv.insertItem( parts.engines.GM_V8_pak:0x000080A5r ); // "GM stock hi-flow air filter" //
    
        // // Fuelie
        // inv.insertItem( parts.engines.GM_V8_pak:0x0000B0BEr ); // "Holley_sb_fi_manifold 283 302" //
        // inv.insertItem( parts.engines.GM_V8_pak:0x0000B2A3r ); // "Holley_fuel_rail" //
        
	}
}
