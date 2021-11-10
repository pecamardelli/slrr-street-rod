package java.game.parts.running_gear.shocks;

import java.game.parts.rgearpart.*;

public class shock_absorber_SunStrip_20_front extends AdjustableShockAbsorber
{
	public shock_absorber_SunStrip_20_front( int id )
	{
		super( id );

		damping				= 6000.0;
		max_length			= 550.0 / 1000.0;
		min_length			= 350.0 / 1000.0;
		whats_inside			= WI_GAS;

		name_prefix = "Duhen Racing SunStrip 2.0 CDVC front";
		brand_prestige_factor = 2.25;
		calcStuffs();
	}
}
