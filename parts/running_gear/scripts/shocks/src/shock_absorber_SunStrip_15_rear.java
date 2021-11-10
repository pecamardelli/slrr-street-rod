package java.game.parts.running_gear.shocks;

import java.game.parts.rgearpart.*;

public class shock_absorber_SunStrip_15_rear extends AdjustableShockAbsorber
{
	public shock_absorber_SunStrip_15_rear( int id )
	{
		super( id );

		damping				= 3300.0;
		max_length			= 550.0 / 1000.0;
		min_length			= 350.0 / 1000.0;
		whats_inside			= WI_GAS;

		name_prefix = "Duhen SunStrip 1.5 DVC rear";
		brand_prestige_factor = 1.00;
		calcStuffs();
	}
}

