package java.game.parts.running_gear.brakes;

import java.game.parts.rgearpart.reciprocatingrgearpart.brake.*;

public class brake_Focer_200_rear extends DiscBrake
{
	public brake_Focer_200_rear( int id )
	{
		super( id );

		diam_mm			= 255.0;
		friction_disc		= RT_STEEL;
		friction_pad		= BP_BLACK_STUFF;
		number_of_calipers	= 2.0;
		force			= CL_FORCE_1;

		name_prefix = "Shimutshibu Focer 200 rear";
		brand_prestige_factor = 1.28;
		calcStuffs();

		renderID_FL = parts:0x000000A1r;
		renderID_FR = parts:0x000000C1r;
		renderID_RL = parts:0x000000C3r;
		renderID_RR = parts:0x000000C5r;
	}
}
