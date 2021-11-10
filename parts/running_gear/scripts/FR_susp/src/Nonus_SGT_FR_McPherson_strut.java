package java.game.parts.running_gear.fr_susp;

import java.game.parts.*;
import java.game.parts.rgearpart.*;

public class Nonus_SGT_FR_McPherson_strut extends AdjustableSuspension
{
	public Nonus_SGT_FR_McPherson_strut ( int id )
	{
		super( id );

		name = "Emer Nonus StreetGT front right McPherson strut";

		value = tHUF2USD(98.0);
		brand_new_prestige_value = 43.0;

		VICx =  1.446;
		VICy = -0.025;

		LICy =  0.100;
		LICz =  1.500;

		camber =  0.0;
		toe    =  0.0;
		spacer =  0.0;

		side   = SD_RIGHT;

		setupDefaults();
	}

	public void updatevariables()
	{
		if (!the_car)
			getCar_LocalVersion();
		if (the_car)
		{
			int wheelID = getWheelID();
			WheelRef wheel = the_car.getWheel(wheelID);
			if (wheel)
			{
				wheel.setArm( 0.296,-0.294, 0.030, 0.000, 0.000, 0.000, 1.000);
				wheel.setHub( 0.000, 0.077+(side*spacer),-0.043,-0.004,-0.071+(side*camber*DEG2RAD), 0.407, 0.000-(side*toe*DEG2RAD),-0.071, 0.407, 0.000);

				the_car.setSlotPos(101+wheelID, new Vector3(0.124,0,0), null );
				the_car.setSlotPos(111+wheelID, new Vector3(0.113,0,0), null );

				setRollCenter(wheel);
				setSuspensionGeometry(wheel);
			}
		}
	}
}
