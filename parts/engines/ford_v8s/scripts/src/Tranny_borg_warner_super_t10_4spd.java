package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.*;


public class Tranny_borg_warner_super_t10_4spd extends Transmission
{
	public Tranny_borg_warner_super_t10_4spd( int id )
	{
		super( id );
		name = "Borg-Warner Super T10 4-speed transmission";
		description = "First gear: \t 2.43 \n Second gear: \t 1.61 \n Third gear: \t 1.23 \n Fourth gear: \t 1.000 \n Final ratio: \t 3.9";
		brand_new_prestige_value = 85.85;

		value = tHUF2USD(311.000);
		setMaxWear(kmToMaxWear(400000.5));

		gears 	    = 4;
		ratio[0] 	= 0;
		ratio[1] 	= 2.430;
		ratio[2]	= 1.610;
		ratio[3] 	= 1.230;
		ratio[4] 	= 1.000;
		ratio[7] 	= -2.430;
		end_ratio 	= 3.9;

		starter_torque 	= 80.0;

		inertia = kgToInertia(18.0);

		maxRPM = 8000.0; 

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
