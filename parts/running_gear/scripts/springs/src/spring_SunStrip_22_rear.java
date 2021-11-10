package java.game.parts.running_gear.springs;

import java.game.parts.rgearpart.*;

public class spring_SunStrip_22_rear extends AdjustableSpring
{
	public spring_SunStrip_22_rear( int id )
	{
		super( id );

		designedMassOnWheel = getMessOnWheel(1191.0, 51.2, WHL_REAR);
		force = kgfPmm2NPm(6.0);
		restlength = Inch2Meter(8.0);
		minlength = Inch2Meter(7.0);
		maxlength = Inch2Meter(9.0);

		name_prefix = "Duhen SunStrip 2.2 DVC rear";
		brand_prestige_factor = 1.15;
		calcStuffs();
	}
}
