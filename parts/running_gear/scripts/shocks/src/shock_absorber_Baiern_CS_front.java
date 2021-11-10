package java.game.parts.running_gear.shocks;

import java.game.parts.rgearpart.*;

public class shock_absorber_Baiern_CS_front extends AdjustableShockAbsorber
{
	public shock_absorber_Baiern_CS_front( int id )
	{
		super( id );

		damping				= 3500.0;
		max_length			= 550.0 / 1000.0;
		min_length			= 350.0 / 1000.0;
		whats_inside			= WI_GAS;

		name_prefix = "Baiern CoupeSport 2.5 front";
		brand_prestige_factor = 1.20;
		calcStuffs();
	}
}

