package java.game.parts.running_gear.springs;

import java.game.parts.rgearpart.*;

public class spring_Nonus_GT2_rear extends AdjustableSpring
{
	public spring_Nonus_GT2_rear( int id )
	{
		super( id );

		designedMassOnWheel = getMessOnWheel(1437.0, 49.9, WHL_REAR);
		force = kgfPmm2NPm(12.0);
		restlength = Inch2Meter(7.0);
		minlength = Inch2Meter(6.0);
		maxlength = Inch2Meter(8.0);

		name_prefix = "Emer Motorsport Nonus GT2 rear";
		brand_prestige_factor = 3.85;
		calcStuffs();
	}
}
