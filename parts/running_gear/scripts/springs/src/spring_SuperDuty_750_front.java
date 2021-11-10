package java.game.parts.running_gear.springs;

import java.game.parts.rgearpart.*;

public class spring_SuperDuty_750_front extends AdjustableSpring
{
	public spring_SuperDuty_750_front( int id )
	{
		super( id );

		designedMassOnWheel = getMessOnWheel(2147.0, 47.5, WHL_FRONT);
		force = kgfPmm2NPm(8.5);
		restlength = Inch2Meter(8.0);
		minlength = Inch2Meter(2.0);
		maxlength = Inch2Meter(11.0);

		name_prefix = "Hauler's SuperDuty Extra 750 front";
		brand_prestige_factor = 1.75;
		calcStuffs();
	}
}
