package java.game.parts.running_gear.rl_susp;

import java.game.parts.*;
import java.game.parts.rgearpart.*;

public class SunStrip_20_RL_trailing_arm extends AdjustableSuspension
{
	public SunStrip_20_RL_trailing_arm ( int id )
	{
		super( id );

		name = "Duhen Racing SunStrip 2.0 CDVC rear left trailing-arm";

		value = tHUF2USD(77.0);
		brand_new_prestige_value = 40.0;

		VICx =  0.880;
		VICy =  0.010;

		LICy =  0.100;
		LICz = -0.600;

		camber = -1.5;
		toe    = -2.0;
		spacer =  0.0;

		side   = SD_LEFT;

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
				wheel.setArm( 0.420, 0.352, 0.24-0.058,-0.176, 0.904, 0.000, 1.077);
				wheel.setHub(-1.000, 0.121, 0.000, 0.000, 0.000, 0.000, 0.000, 0.000, 0.000, 0.000);

				the_car.setSlotPos(101+wheelID, new Vector3(-0.024-(side*spacer),0,0), null );
				the_car.setSlotPos(111+wheelID, new Vector3(-0.013-(side*spacer),0,0), null );

				the_car.setSlotPos(121+wheelID, new Vector3((-1)*(side*spacer),0,0), null );
				the_car.setSlotPos(301+wheelID, new Vector3((-1)*(side*spacer),0,0), null );
				the_car.setSlotPos(311+wheelID, new Vector3((-1)*(side*spacer),0,0), null );

				setRollCenter(wheel);
				setSuspensionGeometry(wheel);
			}
		}
	}
}
