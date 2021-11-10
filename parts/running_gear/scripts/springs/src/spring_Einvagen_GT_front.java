package java.game.parts.running_gear.springs;

import java.game.parts.rgearpart.*;

public class spring_Einvagen_GT_front extends AdjustableSpring
{
	public spring_Einvagen_GT_front( int id )
	{
		super( id );

		designedMassOnWheel = getMessOnWheel(1292.0, 53.9, WHL_FRONT);
		force = kgfPmm2NPm(4.6);
		restlength = Inch2Meter(9.5);
		minlength = Inch2Meter(7.0);
		maxlength = Inch2Meter(11.5);

		name_prefix = "Einvagen 110 GT front";
		brand_prestige_factor = 1.00;
		calcStuffs();
	}
}
