package java.game.parts.running_gear.shocks;

import java.game.parts.rgearpart.*;

public class shock_absorber_Ishima_WRZ_front extends AdjustableShockAbsorber
{
	public shock_absorber_Ishima_WRZ_front( int id )
	{
		super( id );

		damping				= 4200.0;
		max_length			= 550.0 / 1000.0;
		min_length			= 350.0 / 1000.0;
		whats_inside			= WI_GAS;

		name_prefix = "Ishima Enula WRZ front";
		brand_prestige_factor = 1.50;
		calcStuffs();
	}
}

