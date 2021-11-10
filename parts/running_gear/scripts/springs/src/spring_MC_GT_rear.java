package java.game.parts.running_gear.springs;

import java.game.parts.rgearpart.*;

public class spring_MC_GT_rear extends AdjustableSpring
{
	public spring_MC_GT_rear( int id )
	{
		super( id );

		designedMassOnWheel = getMessOnWheel(1867.0, 47.5, WHL_REAR);
		force = kgfPmm2NPm(4.2);
		restlength = Inch2Meter(8.5);
		minlength = Inch2Meter(6.0);
		maxlength = Inch2Meter(10.0);

		name_prefix = "MC GT rear";
		brand_prestige_factor = 2.00;
		calcStuffs();
	}
}
