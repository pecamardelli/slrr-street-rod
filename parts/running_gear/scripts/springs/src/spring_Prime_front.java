package java.game.parts.running_gear.springs;

import java.game.parts.rgearpart.*;

public class spring_Prime_front extends AdjustableSpring
{
	public spring_Prime_front( int id )
	{
		super( id );

		designedMassOnWheel = getMessOnWheel(1799.0, 46.4, WHL_FRONT);
		force = kgfPmm2NPm(7.0);
		restlength = Inch2Meter(8.0);
		minlength = Inch2Meter(6.0);
		maxlength = Inch2Meter(10.0);

		name_prefix = "Prime DLH 500 front";
		brand_prestige_factor = 3.25;
		calcStuffs();
	}
}
