package java.game.parts.running_gear.springs;

import java.game.parts.rgearpart.*;

public class spring_SunStrip_20_front extends AdjustableSpring
{
	public spring_SunStrip_20_front( int id )
	{
		super( id );

		designedMassOnWheel = getMessOnWheel(935.0, 52.5, WHL_FRONT);
		force = kgfPmm2NPm(10.5);
		restlength = Inch2Meter(6.5);
		minlength = Inch2Meter(5.5);
		maxlength = Inch2Meter(8.0);

		name_prefix = "Duhen Racing SunStrip 2.0 CDVC front";
		brand_prestige_factor = 2.25;
		calcStuffs();
	}
}
