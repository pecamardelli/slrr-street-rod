package java.game.parts.running_gear.springs;

import java.game.parts.rgearpart.*;

public class spring_Ishima_WRS_rear extends AdjustableSpring
{
	public spring_Ishima_WRS_rear( int id )
	{
		super( id );

		designedMassOnWheel = getMessOnWheel(1434.0, 44.3, WHL_REAR);
		force = kgfPmm2NPm(7.2);
		restlength = Inch2Meter(7.0);
		minlength = Inch2Meter(5.0);
		maxlength = Inch2Meter(8.0);

		name_prefix = "Ishima Enula WR SuperTurizmo rear";
		brand_prestige_factor = 3.30;
		calcStuffs();
	}
}
