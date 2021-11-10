package java.game.parts.running_gear.springs;

import java.game.parts.rgearpart.*;

public class spring_Baiern_DS_front extends AdjustableSpring
{
	public spring_Baiern_DS_front( int id )
	{
		super( id );

		designedMassOnWheel = getMessOnWheel(1433.0, 49.4, WHL_FRONT);
		force = kgfPmm2NPm(8.1);
		restlength = Inch2Meter(8.0);
		minlength = Inch2Meter(6.5);
		maxlength = Inch2Meter(9.5);

		name_prefix = "Baiern DevilSport front";
		brand_prestige_factor = 1.4;
		calcStuffs();
	}
}
