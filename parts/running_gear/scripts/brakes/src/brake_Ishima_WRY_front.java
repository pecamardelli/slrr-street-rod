package java.game.parts.running_gear.brakes;

import java.game.parts.rgearpart.reciprocatingrgearpart.brake.*;

public class brake_Ishima_WRY_front extends DiscBrake
{
	public brake_Ishima_WRY_front( int id )
	{
		super( id );

		diam_mm			= 275.0;
		friction_disc		= RT_STEEL;
		friction_pad		= BP_RED_STUFF;
		number_of_calipers	= 2.0;
		force			= CL_FORCE_1;

		name_prefix = "Ishima Enula WRY front";
		brand_prestige_factor = 1.30;
		calcStuffs();

		renderID_FL = parts:0x000000A1r;
		renderID_FR = parts:0x000000C1r;
		renderID_RL = parts:0x000000C3r;
		renderID_RR = parts:0x000000C5r;
	}
}
