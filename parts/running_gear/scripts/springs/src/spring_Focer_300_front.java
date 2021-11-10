package java.game.parts.running_gear.springs;

import java.game.parts.rgearpart.*;

public class spring_Focer_300_front extends AdjustableSpring
{
	public spring_Focer_300_front( int id )
	{
		super( id );

		designedMassOnWheel = getMessOnWheel(1446.0, 46.9, WHL_FRONT);
		force = kgfPmm2NPm(6.8);
		restlength = Inch2Meter(8.5);
		minlength = Inch2Meter(7.0);
		maxlength = Inch2Meter(9.5);

		name_prefix = "Shimutshibu Focer 300 front";
		brand_prestige_factor = 1.39;
		calcStuffs();
	}
}
