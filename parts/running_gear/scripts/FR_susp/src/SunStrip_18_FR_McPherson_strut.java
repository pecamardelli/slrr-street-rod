package java.game.parts.running_gear.fr_susp;

import java.game.parts.*;
import java.game.parts.rgearpart.*;

public class SunStrip_18_FR_McPherson_strut extends AdjustableSuspension
{
	public SunStrip_18_FR_McPherson_strut ( int id )
	{
		super( id );

		name = "Duhen SunStrip 1.8 DVC front right McPherson strut";

		value = tHUF2USD(56.0);
		brand_new_prestige_value = 37.0;

		VICx =  1.336;
		VICy = -0.125;

		LICy = -0.130;
		LICz =  0.800;

		camber = -1.0;
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
