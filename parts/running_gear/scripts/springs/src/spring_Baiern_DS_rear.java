package java.game.parts.running_gear.springs;

import java.game.parts.rgearpart.*;

public class spring_Baiern_DS_rear extends AdjustableSpring
{
	public spring_Baiern_DS_rear( int id )
	{
		super( id );

		designedMassOnWheel = getMessOnWheel(1433.0, 49.4, WHL_REAR);
		force = kgfPmm2NPm(8.1);
		restlength = Inch2Meter(8.0);
		minlength = Inch2Meter(6.5);
		maxlength = Inch2Meter(9.5);

		name_prefix = "Baiern DevilSport rear";
		brand_prestige_factor = 1.4;
		calcStuffs();
	}
}
