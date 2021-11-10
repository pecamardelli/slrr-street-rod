package java.game.parts.running_gear.springs;

import java.game.parts.rgearpart.*;

public class spring_Prime_rear extends AdjustableSpring
{
	public spring_Prime_rear( int id )
	{
		super( id );

		designedMassOnWheel = getMessOnWheel(1799.0, 46.4, WHL_REAR);
		force = kgfPmm2NPm(8.5);
		restlength = Inch2Meter(8.0);
		minlength = Inch2Meter(6.0);
		maxlength = Inch2Meter(10.0);

		name_prefix = "Prime DLH 500 rear";
		brand_prestige_factor = 3.25;
		calcStuffs();
	}
}
