package java.game.parts.running_gear.springs;

import java.game.parts.rgearpart.*;

public class spring_Baiern_GT_rear extends AdjustableSpring
{
	public spring_Baiern_GT_rear( int id )
	{
		super( id );

		designedMassOnWheel = getMessOnWheel(1141.0, 48.5, WHL_REAR);
		force = kgfPmm2NPm(12.5);
		restlength = Inch2Meter(7.5);
		minlength = Inch2Meter(6.5);
		maxlength = Inch2Meter(8.5);

		name_prefix = "Baiern CoupeSport GT III rear";
		brand_prestige_factor = 1.8;
		calcStuffs();
	}
}
