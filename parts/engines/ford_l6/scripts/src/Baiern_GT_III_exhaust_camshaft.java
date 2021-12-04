package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.camshaft.*;


public class Baiern_GT_III_exhaust_camshaft extends DOHC_Camshaft
{
	public Baiern_GT_III_exhaust_camshaft( int id )
	{
		super( id );
		name = "Baiern GT III exhaust camshaft";
		description = "This is the exhaust camshaft of the CoupeSport factory 24V DOHC cylinder head. It can be finely adjusted +- 90.0 degrees in 5.0 degree steps, but it's tuned for optimal exhaust up to 7000 RPM. \n Can only be used in DOHC heads. Weighs 5.5 kgs (12.1 pounds), gross lift is 10.9 mm (0.43 inch), duration is ? degrees at ? degrees lobe separation.";

		value = tHUF2USD(182);
		brand_new_prestige_value = 140.51;
		setMaxWear(kmToMaxWear(390000.0));

		static_input_lobe_separation	= 225.0;
		static_input_lift_in_open	= 0.0;
		static_input_lift_in_close	= 0.0;
		static_input_lift_out_open	= 12.5;
		static_input_lift_out_close	= 0.0;
		static_input_time_in_duration	= 0.0;
		static_input_time_out_duration	= 272.0;

		advance_positive_peak		= +15.0;
		advance_negative_peak		= -15.0;
		advance_minimum_step		= 1.0;

		advance				= 0.0;

		maxRPM = 20000.0;
		inertia = kgToInertia(3.5);

		check4warnings();
	}
}
