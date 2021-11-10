package java.game.parts.running_gear.brakes;

import java.game.parts.rgearpart.reciprocatingrgearpart.brake.*;

public class brake_MC_GT_front extends DiscBrake
{
	public brake_MC_GT_front( int id )
	{
		super( id );

		diam_mm			= 245.0;
		friction_disc		= RT_VENTEDGROOVED;
		friction_pad		= BP_BLACK_STUFF;
		number_of_calipers	= 2.0;
		force			= CL_FORCE_BRUTAL;

		name_prefix = "MC GT front";
		brand_prestige_factor = 2.00;
		calcStuffs();

		renderID_FL = parts:0x000000A1r;
		renderID_FR = parts:0x000000C1r;
		renderID_RL = parts:0x000000C3r;
		renderID_RR = parts:0x000000C5r;
	}
}
