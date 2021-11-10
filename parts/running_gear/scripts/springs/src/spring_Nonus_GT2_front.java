package java.game.parts.running_gear.springs;

import java.game.parts.rgearpart.*;

public class spring_Nonus_GT2_front extends AdjustableSpring
{
	public spring_Nonus_GT2_front( int id )
	{
		super( id );

		designedMassOnWheel = getMessOnWheel(1437.0, 49.9, WHL_FRONT);
		force = kgfPmm2NPm(12.0);
		restlength = Inch2Meter(7.0);
		minlength = Inch2Meter(6.0);
		maxlength = Inch2Meter(8.0);

		name_prefix = "Emer Motorsport Nonus GT2 front";
		brand_prestige_factor = 3.85;
		calcStuffs();
	}
}
