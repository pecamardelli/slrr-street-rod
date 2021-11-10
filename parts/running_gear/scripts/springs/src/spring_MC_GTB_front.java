package java.game.parts.running_gear.springs;

import java.game.parts.rgearpart.*;

public class spring_MC_GTB_front extends AdjustableSpring
{
	public spring_MC_GTB_front( int id )
	{
		super( id );

		designedMassOnWheel = getMessOnWheel(1869.0, 47.2, WHL_FRONT);
		force = kgfPmm2NPm(5.5);
		restlength = Inch2Meter(8.5);
		minlength = Inch2Meter(6.0);
		maxlength = Inch2Meter(10.0);

		name_prefix = "MC GT-B front";
		brand_prestige_factor = 1.90;
		calcStuffs();
	}
}
