package java.game.parts.running_gear.springs;

import java.game.parts.rgearpart.*;

public class spring_Ishima_WRY_front extends AdjustableSpring
{
	public spring_Ishima_WRY_front( int id )
	{
		super( id );

		designedMassOnWheel = getMessOnWheel(1509.0, 44.0, WHL_FRONT);
		force = kgfPmm2NPm(5.3);
		restlength = Inch2Meter(8.5);
		minlength = Inch2Meter(7.0);
		maxlength = Inch2Meter(9.5);

		name_prefix = "Ishima Enula WRY front";
		brand_prestige_factor = 1.30;
		calcStuffs();
	}
}
