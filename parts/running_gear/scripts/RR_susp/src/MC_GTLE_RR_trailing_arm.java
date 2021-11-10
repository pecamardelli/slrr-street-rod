package java.game.parts.running_gear.rr_susp;

import java.game.parts.*;
import java.game.parts.rgearpart.*;

public class MC_GTLE_RR_trailing_arm extends AdjustableSuspension
{
	public MC_GTLE_RR_trailing_arm ( int id )
	{
		super( id );

		name = "MC GTLE rear right trailing-arm";

		value = tHUF2USD(93.3);
		brand_new_prestige_value = 50.0;

		VICx = -0.646;
		VICy = -0.125;

		LICy = -0.130;
		LICz = -0.500;

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
