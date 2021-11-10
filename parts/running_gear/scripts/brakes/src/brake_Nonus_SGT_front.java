package java.game.parts.running_gear.brakes;

import java.game.parts.rgearpart.reciprocatingrgearpart.brake.*;

public class brake_Nonus_SGT_front extends DiscBrake
{
	public brake_Nonus_SGT_front( int id )
	{
		super( id );

		diam_mm			= 275.0;
		friction_disc		= RT_VENTEDGROOVED;
		friction_pad		= BP_RED_STUFF;
		number_of_calipers	= 3.0;
		force			= CL_FORCE_1;

		name_prefix = "Emer Nonus StreetGT front";
		brand_prestige_factor = 1.75;
		calcStuffs();

		renderID_FL = parts:0x000000A1r;
		renderID_FR = parts:0x000000C1r;
		renderID_RL = parts:0x000000C3r;
		renderID_RR = parts:0x000000C5r;
	}
}
