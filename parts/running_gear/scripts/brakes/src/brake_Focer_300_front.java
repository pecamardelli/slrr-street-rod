package java.game.parts.running_gear.brakes;

import java.game.parts.rgearpart.reciprocatingrgearpart.brake.*;

public class brake_Focer_300_front extends DiscBrake
{
	public brake_Focer_300_front( int id )
	{
		super( id );

		diam_mm			= 285.0;
		friction_disc		= RT_VENTEDGROOVED;
		friction_pad		= BP_BLACK_STUFF;
		number_of_calipers	= 3.0;
		force			= CL_FORCE_1;

		name_prefix = "Shimutshibu Focer 300 front";
		brand_prestige_factor = 1.39;
		calcStuffs();

		renderID_FL = parts:0x000000A1r;
		renderID_FR = parts:0x000000C1r;
		renderID_RL = parts:0x000000C3r;
		renderID_RR = parts:0x000000C5r;
	}
}
