package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.cylinderhead.*;
import java.game.cars.*;


public class Ford_260_left_cylinder_head extends OHV_CylinderHead
{
	public Ford_260_left_cylinder_head( int id )
	{
		super( id );
		name = "Ford 260 V8 left cylinder head";
		description = "";
		brand_new_prestige_value = 63.16;

		value = tHUF2USD(82);
		setMaxWear(kmToMaxWear(511000.0));
		
		engine_block_slot_ID = 45;
		intake_efficiency_tuning = 1.15;
		exhaust_efficiency_tuning = 1.25;
		
		intake_rocker_ratio = 1.7; // common 1.5 - 1.9
		exhaust_rocker_ratio = 1.7; // common 1.5 - 1.9
		
		exhaust_header_slot_ID = 37;
		cover_slot_ID = 12;

		intake_valve_diam = 48.5;
		number_of_intake_valves_per_cylinder = 1.0;
		exhaust_valve_diam = 37.0;
		number_of_exhaust_valves_per_cylinder = 1.0;

		cc_dome_safe_clearance = 18.7;

		T_loss = 75.0;
		Vmin = 76.26; // in cc //

		maxRPM = 12000;
		inertia = kgToInertia(4*0.55);

		check4warnings();
	}
	
	public String isDynoable()
	{
		Part p;

		p = partOnSlot( 12 );
		if (!p)
			return "the engine is missing the cylinder head cover.";
		
		p = partOnSlot( 37 );
		if (!p)
			return "the engine is missing the exhaust header.";

		return super.isDynoable();
	}
}
