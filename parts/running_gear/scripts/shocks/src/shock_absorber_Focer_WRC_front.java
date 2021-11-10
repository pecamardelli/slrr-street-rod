package java.game.parts.running_gear.shocks;

import java.game.parts.rgearpart.*;

public class shock_absorber_Focer_WRC_front extends AdjustableShockAbsorber
{
	public shock_absorber_Focer_WRC_front( int id )
	{
		super( id );

		damping				= 6100.0;
		max_length			= 550.0 / 1000.0;
		min_length			= 350.0 / 1000.0;
		whats_inside			= WI_GAS;

		name_prefix = "Shimutshibu Focer WRC front";
		brand_prestige_factor = 3.50;
		calcStuffs();
	}
}

