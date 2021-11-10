package java.game.parts.running_gear.springs;

import java.game.parts.rgearpart.*;

public class spring_Focer_300_rear extends AdjustableSpring
{
	public spring_Focer_300_rear( int id )
	{
		super( id );

		designedMassOnWheel = getMessOnWheel(1446.0, 46.9, WHL_REAR);
		force = kgfPmm2NPm(6.5);
		restlength = Inch2Meter(7.0);
		minlength = Inch2Meter(6.0);
		maxlength = Inch2Meter(8.0);

		name_prefix = "Shimutshibu Focer 300 rear";
		brand_prestige_factor = 1.39;
		calcStuffs();
	}
}
