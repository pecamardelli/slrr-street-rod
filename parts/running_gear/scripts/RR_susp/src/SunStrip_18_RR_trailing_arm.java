package java.game.parts.running_gear.rr_susp;

import java.game.parts.*;
import java.game.parts.rgearpart.*;

public class SunStrip_18_RR_trailing_arm extends AdjustableSuspension
{
	public SunStrip_18_RR_trailing_arm ( int id )
	{
		super( id );

		name = "Duhen SunStrip 1.8 DVC rear right trailing-arm";

		value = tHUF2USD(63.0);
		brand_new_prestige_value = 35.0;

		VICx =  1.380;
		VICy = -0.160;

		LICy = -0.150;
		LICz = -0.600;

		camber = -2.0;
		toe    = -1.5;
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
				wheel.setArm( 0.420,-0.352, 0.24-0.058,-0.176,-0.904, 0.000, 1.077);
				wheel.setHub(-1.000,-0.121, 0.000, 0.000, 0.000, 0.000, 0.000, 0.000, 0.000, 0.000);

				the_car.setSlotPos(101+wheelID, new Vector3( 0.024-(side*spacer),0,0), null );
				the_car.setSlotPos(111+wheelID, new Vector3( 0.013-(side*spacer),0,0), null );

				the_car.setSlotPos(121+wheelID, new Vector3((-1)*(side*spacer),0,0), null );
				the_car.setSlotPos(301+wheelID, new Vector3((-1)*(side*spacer),0,0), null );
				the_car.setSlotPos(311+wheelID, new Vector3((-1)*(side*spacer),0,0), null );

				setRollCenter(wheel);
				setSuspensionGeometry(wheel);
			}
		}
	}
}
