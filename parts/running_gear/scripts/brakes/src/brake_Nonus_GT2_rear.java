package java.game.parts.running_gear.brakes;

import java.game.parts.rgearpart.reciprocatingrgearpart.brake.*;

public class brake_Nonus_GT2_rear extends DiscBrake
{
	public brake_Nonus_GT2_rear( int id )
	{
		super( id );

		diam_mm			= 285.0;
		friction_disc		= RT_CARBON;
		friction_pad		= BP_GREEN_STUFF;
		number_of_calipers	= 2.0;
		force			= CL_FORCE_1;

		name_prefix = "Emer Motorsport Nonus GT2 rear";
		brand_prestige_factor = 3.85;
		calcStuffs();

		renderID_FL = parts:0x000000A1r;
		renderID_FR = parts:0x000000C1r;
		renderID_RL = parts:0x000000C3r;
		renderID_RR = parts:0x000000C5r;
	}
}
