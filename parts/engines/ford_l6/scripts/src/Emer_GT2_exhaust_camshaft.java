package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.camshaft.*;


public class Emer_GT2_exhaust_camshaft extends DOHC_Camshaft
{
	public Emer_GT2_exhaust_camshaft( int id )
	{
		super( id );
		name = "Emer MotorSport Nonus GT2 exhaust camshaft";
		description = "";
		brand_new_prestige_value = 16.00;

		value = tHUF2USD(255.000);
		setMaxWear(kmToMaxWear(380000.0));

		police_check_fine_value = 2000;

		static_input_lobe_separation	= 275.0;
		static_input_lift_in_open	= 0.0;
		static_input_lift_in_close	= 0.0;
		static_input_lift_out_open	= 15.5;
		static_input_lift_out_close	= 0.0;
		static_input_time_in_duration	= 0.0;
		static_input_time_out_duration	= 282.0;

		advance_positive_peak		= +15.0;
		advance_negative_peak		= -15.0;
		advance_minimum_step		= 1.0;

		advance				= 0.0;

		maxRPM = 15000.0;
		inertia = kgToInertia(5.5);

		check4warnings();
	}
}
