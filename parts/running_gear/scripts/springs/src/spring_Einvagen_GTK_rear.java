package java.game.parts.running_gear.springs;

import java.game.parts.rgearpart.*;

public class spring_Einvagen_GTK_rear extends AdjustableSpring
{
	public spring_Einvagen_GTK_rear( int id )
	{
		super( id );

		designedMassOnWheel = getMessOnWheel(1309.0, 54.8, WHL_REAR);
		force = kgfPmm2NPm(5.6);
		restlength = Inch2Meter(8.5);
		minlength = Inch2Meter(6.0);
		maxlength = Inch2Meter(10.0);

		name_prefix = "Einvagen 110 GTK rear";
		brand_prestige_factor = 1.03;
		calcStuffs();
	}
}
