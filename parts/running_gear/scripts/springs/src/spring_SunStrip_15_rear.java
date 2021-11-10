package java.game.parts.running_gear.springs;

import java.game.parts.rgearpart.*;

public class spring_SunStrip_15_rear extends AdjustableSpring
{
	public spring_SunStrip_15_rear( int id )
	{
		super( id );

		designedMassOnWheel = getMessOnWheel(1187.0, 51.8, WHL_REAR);
		force = kgfPmm2NPm(4.5);
		restlength = Inch2Meter(8.5);
		minlength = Inch2Meter(7.0);
		maxlength = Inch2Meter(9.5);

		name_prefix = "Duhen SunStrip 1.5 DVC rear";
		brand_prestige_factor = 1.00;
		calcStuffs();
	}
}
