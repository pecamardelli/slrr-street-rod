package java.game.parts.running_gear.springs;

import java.game.parts.rgearpart.*;

public class spring_Ishima_WRZ_rear extends AdjustableSpring
{
	public spring_Ishima_WRZ_rear( int id )
	{
		super( id );

		designedMassOnWheel = getMessOnWheel(1514.0, 44.2, WHL_REAR);
		force = kgfPmm2NPm(5.3);
		restlength = Inch2Meter(7.0);
		minlength = Inch2Meter(6.0);
		maxlength = Inch2Meter(8.0);

		name_prefix = "Ishima Enula WRZ rear";
		brand_prestige_factor = 1.50;
		calcStuffs();
	}
}
