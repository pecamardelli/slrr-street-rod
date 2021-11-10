package java.game.parts.running_gear.springs;

import java.game.parts.rgearpart.*;

public class spring_Nonus_SGT_rear extends AdjustableSpring
{
	public spring_Nonus_SGT_rear( int id )
	{
		super( id );

		designedMassOnWheel = getMessOnWheel(1627.0, 48.1, WHL_REAR);
		force = kgfPmm2NPm(7.6);
		restlength = Inch2Meter(8.0);
		minlength = Inch2Meter(6.0);
		maxlength = Inch2Meter(9.5);

		name_prefix = "Emer Nonus StreetGT rear";
		brand_prestige_factor = 1.75;
		calcStuffs();
	}
}
