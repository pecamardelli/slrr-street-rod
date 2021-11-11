package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.*;


public class Tranny_borg_warner_t18_4spd extends Transmission
{
	public Tranny_borg_warner_t18_4spd( int id )
	{
		super( id );
		name = "Borg-Warner T18 4-speed transmission";
		description = "Specially for trucks! \n First gear: \t 4.02 \n Second gear: \t 2.41 \n Third gear: \t 1.41 \n Fourth gear: \t 1.000 \n Final ratio: \t 3.73";
		brand_new_prestige_value = 65.55;

		value = tHUF2USD(237.135);
		setMaxWear(kmToMaxWear(570000.5));

		gears 		= 4;
		ratio[0] 	= 0;
		ratio[1] 	= 4.020;
		ratio[2]	= 2.410;
		ratio[3] 	= 1.410;
		ratio[4] 	= 1.000;
		ratio[7] 	= -4.420;
		end_ratio 	= 3.73;

		starter_torque 	= 80.0;

		inertia = kgToInertia(18.0);

		maxRPM = 7000.0;

		check4warnings();

		drive_type = DT_RWD;
		drive_front_min = 0.0;
		drive_front_max = 0.0;
		def_drive_front = drive_front_min;
		drive_front = def_drive_front;

		diff_lock_min = 0.00;
		diff_lock_max = 0.00;
		def_diff_lock = 0.00;
		diff_lock = def_diff_lock;
	}
}
