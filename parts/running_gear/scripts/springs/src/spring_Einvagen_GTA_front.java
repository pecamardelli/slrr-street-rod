package java.game.parts.running_gear.springs;

import java.game.parts.rgearpart.*;

public class spring_Einvagen_GTA_front extends AdjustableSpring
{
	public spring_Einvagen_GTA_front( int id )
	{
		super( id );

		designedMassOnWheel = getMessOnWheel(1301.0, 55.3, WHL_FRONT);
		force = kgfPmm2NPm(7.2);
		restlength = Inch2Meter(8.5);
		minlength = Inch2Meter(6.0);
		maxlength = Inch2Meter(9.5);

		name_prefix = "Einvagen 140 GTA front";
		brand_prestige_factor = 1.20;
		calcStuffs();
	}
}
