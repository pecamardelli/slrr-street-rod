package java.game.parts.running_gear.springs;

import java.game.parts.rgearpart.*;

public class spring_Focer_200_front extends AdjustableSpring
{
	public spring_Focer_200_front( int id )
	{
		super( id );

		designedMassOnWheel = getMessOnWheel(1439.0, 47.3, WHL_FRONT);
		force = kgfPmm2NPm(4.7);
		restlength = Inch2Meter(8.5);
		minlength = Inch2Meter(7.0);
		maxlength = Inch2Meter(9.5);

		name_prefix = "Shimutshibu Focer 200 front";
		brand_prestige_factor = 1.28;
		calcStuffs();
	}
}
