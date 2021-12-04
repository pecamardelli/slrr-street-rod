package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.camshaft.*;


public class ford_racing_camshaft_3 extends OHV_Camshaft
{
	public ford_racing_camshaft_3( int id )
	{
		super( id );
		name = "Ford racing high-rpm camshaft";
		description = "";

		value = tHUF2USD(87);
		brand_new_prestige_value = 63.87;
		setMaxWear(kmToMaxWear(380000.0));

		static_input_lobe_separation	= 220.0;
		static_input_lift_in_open	= 13.1;
		static_input_lift_in_close	= 0.0;
		static_input_lift_out_open	= 13.1;
		static_input_lift_out_close	= 0.0;
		static_input_time_in_duration	= 249.0;
		static_input_time_out_duration	= 239.0;

		/*
		advance_positive_peak		= +15.0;
		advance_negative_peak		= -15.0;
		advance_minimum_step		= 1.0;

		advance				= 0.0;
*/
		maxRPM = 12000.0;
		inertia = kgToInertia(5.3);

		check4warnings();
	}
	
	public int isTuneable()
	{
		return 1; // 0 = not tunable; 1 = tunable advance/retard
	}
	
	public String isDynoable()
	{
		Part p;

		p = partOnSlot( 5 );
		if (!p)
			return "the engine is missing the camshaft timing gear.";

		return super.isDynoable();
	}
}
