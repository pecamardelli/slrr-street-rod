package java.game.parts.running_gear.springs;

import java.game.parts.rgearpart.*;

public class spring_SunStrip_18_rear extends AdjustableSpring
{
	public spring_SunStrip_18_rear( int id )
	{
		super( id );

		designedMassOnWheel = getMessOnWheel(1208.0, 50.6, WHL_REAR);
		force = kgfPmm2NPm(5.5);
		restlength = Inch2Meter(8.5);
		minlength = Inch2Meter(7.0);
		maxlength = Inch2Meter(9.5);

		name_prefix = "Duhen SunStrip 1.8 DVC rear";
		brand_prestige_factor = 1.10;
		calcStuffs();
	}
}
