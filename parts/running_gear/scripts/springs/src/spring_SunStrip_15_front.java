package java.game.parts.running_gear.springs;

import java.game.parts.rgearpart.*;

public class spring_SunStrip_15_front extends AdjustableSpring
{
	public spring_SunStrip_15_front( int id )
	{
		super( id );

		designedMassOnWheel = getMessOnWheel(1187.0, 51.8, WHL_FRONT);
		force = kgfPmm2NPm(4.5);
		restlength = Inch2Meter(8.5);
		minlength = Inch2Meter(7.0);
		maxlength = Inch2Meter(9.5);

		name_prefix = "Duhen SunStrip 1.5 DVC front";
		brand_prestige_factor = 1.00;
		calcStuffs();
	}
}
