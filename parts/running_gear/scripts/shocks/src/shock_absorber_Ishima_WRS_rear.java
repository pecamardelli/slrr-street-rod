package java.game.parts.running_gear.shocks;

import java.game.parts.rgearpart.*;

public class shock_absorber_Ishima_WRS_rear extends AdjustableShockAbsorber
{
	public shock_absorber_Ishima_WRS_rear( int id )
	{
		super( id );

		damping				= 5200.0;
		max_length			= 550.0 / 1000.0;
		min_length			= 350.0 / 1000.0;
		whats_inside			= WI_GAS;

		name_prefix = "Ishima Enula WR SuperTurizmo rear";
		brand_prestige_factor = 3.30;
		calcStuffs();
	}
}

