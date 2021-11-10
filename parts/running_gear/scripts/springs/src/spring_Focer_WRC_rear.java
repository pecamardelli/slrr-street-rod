package java.game.parts.running_gear.springs;

import java.game.parts.rgearpart.*;

public class spring_Focer_WRC_rear extends AdjustableSpring
{
	public spring_Focer_WRC_rear( int id )
	{
		super( id );

		designedMassOnWheel = getMessOnWheel(1377.0, 48.2, WHL_REAR);
		force = kgfPmm2NPm(7.0);
		restlength = Inch2Meter(7.0);
		minlength = Inch2Meter(6.0);
		maxlength = Inch2Meter(8.0);

		name_prefix = "Shimutshibu Focer WRC rear";
		brand_prestige_factor = 3.50;
		calcStuffs();
	}
}
