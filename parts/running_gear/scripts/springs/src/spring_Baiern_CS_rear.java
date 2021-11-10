package java.game.parts.running_gear.springs;

import java.game.parts.rgearpart.*;

public class spring_Baiern_CS_rear extends AdjustableSpring
{
	public spring_Baiern_CS_rear( int id )
	{
		super( id );

		designedMassOnWheel = getMessOnWheel(1489.0, 47.8, WHL_REAR);
		force = kgfPmm2NPm(7.5);
		restlength = Inch2Meter(8.5);
		minlength = Inch2Meter(7.0);
		maxlength = Inch2Meter(9.5);

		name_prefix = "Baiern CoupeSport 2.5 rear";
		brand_prestige_factor = 1.2;
		calcStuffs();
	}
}
