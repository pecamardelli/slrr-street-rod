package java.game.parts.running_gear.shocks;

import java.game.parts.rgearpart.*;

public class shock_absorber_Baiern_DS_rear extends AdjustableShockAbsorber
{
	public shock_absorber_Baiern_DS_rear( int id )
	{
		super( id );

		damping				= 4600.0;
		max_length			= 550.0 / 1000.0;
		min_length			= 350.0 / 1000.0;
		whats_inside			= WI_GAS;

		name_prefix = "Baiern DevilSport rear";
		brand_prestige_factor = 1.60;
		calcStuffs();
	}
}

