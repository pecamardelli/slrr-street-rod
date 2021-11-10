package java.game.parts.running_gear.springs;

import java.game.parts.rgearpart.*;

public class spring_Ishima_WRS_front extends AdjustableSpring
{
	public spring_Ishima_WRS_front( int id )
	{
		super( id );

		designedMassOnWheel = getMessOnWheel(1434.0, 44.3, WHL_FRONT);
		force = kgfPmm2NPm(7.8);
		restlength = Inch2Meter(7.5);
		minlength = Inch2Meter(5.5);
		maxlength = Inch2Meter(9.0);

		name_prefix = "Ishima Enula WR SuperTurizmo front";
		brand_prestige_factor = 3.30;
		calcStuffs();
	}
}
