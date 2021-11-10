package java.game.parts.running_gear.sways;

import java.game.parts.rgearpart.*;


public class swaybar_Focer_200_rear extends AdjustableSwaybar
{
	public swaybar_Focer_200_rear( int id )
	{
		super( id );

		force = 25000.0;
		damping = 2500.0;

		name_prefix = "Shimutshibu Focer 200 rear";
		brand_prestige_factor = 1.28;
		calcStuffs();
	}
}

