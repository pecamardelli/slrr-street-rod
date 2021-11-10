package java.game.parts.running_gear.springs;

import java.game.parts.rgearpart.*;

public class spring_Ishima_WRY_rear extends AdjustableSpring
{
	public spring_Ishima_WRY_rear( int id )
	{
		super( id );

		designedMassOnWheel = getMessOnWheel(1509.0, 44.0, WHL_REAR);
		force = kgfPmm2NPm(5.0);
		restlength = Inch2Meter(7.0);
		minlength = Inch2Meter(6.0);
		maxlength = Inch2Meter(8.0);

		name_prefix = "Ishima Enula WRY rear";
		brand_prestige_factor = 1.30;
		calcStuffs();
	}
}
