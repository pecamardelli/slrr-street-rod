package java.game.parts.running_gear.shocks;

import java.game.parts.rgearpart.*;

public class shock_absorber_Baiern_GT_front extends AdjustableShockAbsorber
{
	public shock_absorber_Baiern_GT_front( int id )
	{
		super( id );

		damping				= 6100.0;
		max_length			= 550.0 / 1000.0;
		min_length			= 350.0 / 1000.0;
		whats_inside			= WI_GAS;

		name_prefix = "Baiern CoupeSport GT III front";
		brand_prestige_factor = 4.00;
		calcStuffs();
	}
}

