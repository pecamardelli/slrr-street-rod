package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.*;


public class Tranny_HEG_W_3spd extends Transmission
{
	public Tranny_HEG_W_3spd( int id )
	{
		super( id );
		name = "Ford HEG-W 3-speed transmission";
		description = "First gear: \t 2.42 \n Second gear: \t 1.61 \n Third gear: \t 1.00 \n Final ratio: \t 3.73";
		brand_new_prestige_value = 55.55;

		value = tHUF2USD(299.105);
		setMaxWear(kmToMaxWear(400000.5));

		gears 		= 3;
		ratio[0] 	= 0;
		ratio[1] 	= 2.420;
		ratio[2]	= 1.610;
		ratio[3] 	= 1.000;
		ratio[7] 	= -2.330;
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
