package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.cylinderhead.*;
import java.game.cars.*;
 

public class ford_stock_cylinder_head extends OHV_CylinderHead
{
	public ford_stock_cylinder_head( int id )
	{
		super( id );
		name = "Ford stock cylinder head (188 and 221)";
		description = "";

		value = tHUF2USD(125);
		brand_new_prestige_value = 48.54;
		setMaxWear(kmToMaxWear(317000.0));
		
		intake_efficiency_tuning = 1.0; // 0.1-2.0
		exhaust_efficiency_tuning = 1.0;// 0.1-2.0

		intake_rocker_ratio = 1.5; // common 1.5 - 1.9
		exhaust_rocker_ratio = 1.5; // common 1.5 - 1.9

		engine_block_slot_ID = 19;
		intake_manifold_slot_ID = 11;
		exhaust_header_slot_ID = 13;
		//camshaft_bearing_slot_ID = 24;
		cover_slot_ID = 18;
		
		intake_valve_diam = 43.0;
		number_of_intake_valves_per_cylinder = 1.0;
		exhaust_valve_diam = 40.5;
		number_of_exhaust_valves_per_cylinder = 1.0;

		cc_dome_safe_clearance = 18.7;
		maxRPM = 20000.0;
		inertia = kgToInertia(6*0.3);

		T_loss = 80.0;
		Vmin = 76.74; // in cc //

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
