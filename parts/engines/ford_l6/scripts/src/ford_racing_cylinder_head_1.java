package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.cylinderhead.*;
import java.game.cars.*;
 

public class ford_racing_cylinder_head_1 extends OHV_CylinderHead
{
	public ford_racing_cylinder_head_1( int id )
	{
		super( id );
		name = "Ford Racing cylinder head - Extreme alluminium version";
		description = "";

		value = tHUF2USD(225);
		brand_new_prestige_value = 78.54;
		setMaxWear(kmToMaxWear(317000.0));
		
		intake_efficiency_tuning = 1.15; // 0.1-2.0
		exhaust_efficiency_tuning = 1.15;// 0.1-2.0

		intake_rocker_ratio = 1.7; // common 1.5 - 1.9
		exhaust_rocker_ratio = 1.7; // common 1.5 - 1.9

		engine_block_slot_ID = 19;
		intake_manifold_slot_ID = 11;
		exhaust_header_slot_ID = 13;
		//camshaft_bearing_slot_ID = 24;
		cover_slot_ID = 18;
		
		intake_valve_diam = 45.2;
		number_of_intake_valves_per_cylinder = 1.0;
		exhaust_valve_diam = 42.7;
		number_of_exhaust_valves_per_cylinder = 1.0;

		cc_dome_safe_clearance = 18.7;
		maxRPM = 20000.0;
		inertia = kgToInertia(6*0.3);

		T_loss = 80.0;
		Vmin = 61.74; // in cc //

		check4warnings();
	}

	public String isDynoable()
	{
		Part p;

		p = partOnSlot( 11 );
		if (!p)
			return "the engine is missing the intake manifold.";

		return super.isDynoable();
	}
}
