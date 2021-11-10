package java.game.parts.running_gear.springs;

import java.game.parts.rgearpart.*;

public class spring_SuperDuty_500_rear extends AdjustableSpring
{
	public spring_SuperDuty_500_rear( int id )
	{
		super( id );

		designedMassOnWheel = getMessOnWheel(2101.0, 47.7, WHL_REAR);
		force = kgfPmm2NPm(7.2);
		restlength = Inch2Meter(8.0);
		minlength = Inch2Meter(2.0);
		maxlength = Inch2Meter(11.0);

		name_prefix = "Hauler's SuperDuty 500 rear";
		brand_prestige_factor = 1.55;
		calcStuffs();
	}
}
