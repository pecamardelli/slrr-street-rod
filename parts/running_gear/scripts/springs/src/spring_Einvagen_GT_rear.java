package java.game.parts.running_gear.springs;

import java.game.parts.rgearpart.*;

public class spring_Einvagen_GT_rear extends AdjustableSpring
{
	public spring_Einvagen_GT_rear( int id )
	{
		super( id );

		designedMassOnWheel = getMessOnWheel(1292.0, 53.9, WHL_REAR);
		force = kgfPmm2NPm(4.5);
		restlength = Inch2Meter(8.5);
		minlength = Inch2Meter(6.0);
		maxlength = Inch2Meter(10.0);

		name_prefix = "Einvagen 110 GT rear";
		brand_prestige_factor = 1.00;
		calcStuffs();
	}
}
