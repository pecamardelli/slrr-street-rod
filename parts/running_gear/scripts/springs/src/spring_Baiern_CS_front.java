package java.game.parts.running_gear.springs;

import java.game.parts.rgearpart.*;

public class spring_Baiern_CS_front extends AdjustableSpring
{
	public spring_Baiern_CS_front( int id )
	{
		super( id );

		designedMassOnWheel = getMessOnWheel(1489.0, 47.8, WHL_FRONT);
		force = kgfPmm2NPm(7.3);
		restlength = Inch2Meter(8.5);
		minlength = Inch2Meter(7.0);
		maxlength = Inch2Meter(9.5);

		name_prefix = "Baiern CoupeSport 2.5 front";
		brand_prestige_factor = 1.2;
		calcStuffs();
	}
}
