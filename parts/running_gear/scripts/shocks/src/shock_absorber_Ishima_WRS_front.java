package java.game.parts.running_gear.shocks;

import java.game.parts.rgearpart.*;

public class shock_absorber_Ishima_WRS_front extends AdjustableShockAbsorber
{
	public shock_absorber_Ishima_WRS_front( int id )
	{
		super( id );

		damping				= 5600.0;
		max_length			= 550.0 / 1000.0;
		min_length			= 350.0 / 1000.0;
		whats_inside			= WI_GAS;

		name_prefix = "Ishima Enula WR SuperTurizmo front";
		brand_prestige_factor = 3.30;
		calcStuffs();
	}
}

