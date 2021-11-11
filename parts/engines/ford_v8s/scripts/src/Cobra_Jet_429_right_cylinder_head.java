package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.cylinderhead.*;
import java.game.cars.*;


public class Cobra_Jet_429_right_cylinder_head extends OHV_CylinderHead
{
	public Cobra_Jet_429_right_cylinder_head( int id )
	{
		super( id );
		name = "Ford Cobra Jet 429 V8 right cylinder head";
		description = "";
		brand_new_prestige_value = 73.16;

		value = tHUF2USD(108);
		setMaxWear(kmToMaxWear(411000.0));

		engine_block_slot_ID = 46;
		intake_efficiency_tuning = 1.15;
		exhaust_efficiency_tuning = 1.25;
		
		intake_rocker_ratio = 1.7; // common 1.5 - 1.9
		exhaust_rocker_ratio = 1.7; // common 1.5 - 1.9
		
		exhaust_header_slot_ID = 16;
		cover_slot_ID = 23;

		intake_valve_diam = 55.5;
		number_of_intake_valves_per_cylinder = 1.0;
		exhaust_valve_diam = 43.3;
		number_of_exhaust_valves_per_cylinder = 1.0;

		cc_dome_safe_clearance = 18.7;

		T_loss = 75.0;
		Vmin = 86.26; // in cc //

		maxRPM = 12000;
		inertia = kgToInertia(4*0.55);

		check4warnings();
	}
	
	public String isDynoable()
	{
		Part p;

		p = partOnSlot( 23 );
		if (!p)
			return "the engine is missing the cylinder head cover.";
		
		p = partOnSlot( 16 );
		if (!p)
			return "the engine is missing the right exhaust header.";

		return super.isDynoable();
	}
}
