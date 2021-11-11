package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.camshaft.*;

public class Ford_351_camshaft extends OHV_Camshaft
{
	public Ford_351_camshaft( int id )
	{
		super( id );
		name = "Ford 351 Boss V8 camshaft";
		description = "";
		brand_new_prestige_value = 65.80;

		value = tHUF2USD(87);
		setMaxWear(kmToMaxWear(390000.0));

		maxRPM = 25000.0/2.0;

		static_input_lobe_separation	= 218;
		static_input_lift_in_open	= 13.1;
		static_input_lift_in_close	= 0;
		static_input_lift_out_open	= 13.1;
		static_input_lift_out_close	= 0;
		static_input_time_in_duration	= 174.0;
		static_input_time_out_duration	= 184.0;

		/*
		advance_positive_peak		= +15.0;
		advance_negative_peak		= -15.0;
		advance_minimum_step		= 1.0;

		advance				= 0.0;
		*/
		
		inertia = kgToInertia(4.5);

		check4warnings();
	}
	
	public String isDynoable()
	{
		Part p;

		p = partOnSlot( 5 );
		if (!p)
			return "it's missing the camshaft timing gear";

		return super.isDynoable();
	}
}
