package java.game.parts.running_gear.sways;

import java.game.parts.rgearpart.*;


public class swaybar_Einvagen_GTK_rear extends AdjustableSwaybar
{
	public swaybar_Einvagen_GTK_rear( int id )
	{
		super( id );

		force = 25000.0;
		damping = 2500.0;

		name_prefix = "Einvagen 110 GTK rear";
		brand_prestige_factor = 1.03;
		calcStuffs();
	}
}
