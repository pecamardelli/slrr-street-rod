package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.camshaft.*;

public class Ford_racing_camshaft_small_block_2 extends OHV_Camshaft
{
	public Ford_racing_camshaft_small_block_2( int id )
	{
		super( id );
		name = "Ford Racing camshaft high torque (260-351)";
		description = "Best performance on 260, 292 and 332 blocks. Enhances torque at low RPM level.";
		brand_new_prestige_value = 65.80;

		value = tHUF2USD(189.512);
		setMaxWear(kmToMaxWear(390000.0));

		maxRPM = 25000.0/2.0;

		static_input_lobe_separation	= 230.0;
		static_input_lift_in_open	= 13.2;
		static_input_lift_in_close	= 0;
		static_input_lift_out_open	= 13.2;
		static_input_lift_out_close	= 0;
		static_input_time_in_duration	= 175.0;
		static_input_time_out_duration	= 185.0;

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
