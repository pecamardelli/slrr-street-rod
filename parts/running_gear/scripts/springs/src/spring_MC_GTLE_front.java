package java.game.parts.running_gear.springs;

import java.game.parts.rgearpart.*;

public class spring_MC_GTLE_front extends AdjustableSpring
{
	public spring_MC_GTLE_front( int id )
	{
		super( id );

		designedMassOnWheel = getMessOnWheel(1869.0, 47.2, WHL_FRONT);
		force = kgfPmm2NPm(6.1);
		restlength = Inch2Meter(8.5);
		minlength = Inch2Meter(6.0);
		maxlength = Inch2Meter(10.0);

		name_prefix = "MC GTLE front";
		brand_prestige_factor = 2.65;
		calcStuffs();
	}
}
