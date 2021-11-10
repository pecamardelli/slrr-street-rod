package java.game.parts.running_gear.springs;

import java.game.parts.rgearpart.*;

public class spring_MC_GTB_rear extends AdjustableSpring
{
	public spring_MC_GTB_rear( int id )
	{
		super( id );

		designedMassOnWheel = getMessOnWheel(1869.0, 47.2, WHL_REAR);
		force = kgfPmm2NPm(4.4);
		restlength = Inch2Meter(8.5);
		minlength = Inch2Meter(6.0);
		maxlength = Inch2Meter(10.0);

		name_prefix = "MC GT-B rear";
		brand_prestige_factor = 1.90;
		calcStuffs();
	}
}
