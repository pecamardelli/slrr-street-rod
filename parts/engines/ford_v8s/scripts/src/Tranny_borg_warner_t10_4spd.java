package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.*;


public class Tranny_borg_warner_t10_4spd extends Transmission
{
	public Tranny_borg_warner_t10_4spd( int id )
	{
		super( id );
		name = "Borg-Warner T10 4-speed transmission";
		description = "First gear: \t 2.54 \n Second gear: \t 1.89 \n Third gear: \t 1.51 \n Fourth gear: \t 1.000 \n Final ratio: \t 3.73";
		brand_new_prestige_value = 85.75;

		value = tHUF2USD(280.195);
		setMaxWear(kmToMaxWear(350000));

		gears		= 4;
		ratio[0]	= 0;
		ratio[1]	= 2.540;
		ratio[2]	= 1.890;
		ratio[3]	= 1.510;
		ratio[4]	= 1.000;
		ratio[7]	= -2.540;
		end_ratio	= 3.73;

		starter_torque	= 40.0;

		inertia = kgToInertia(12.0);
		maxRPM = 7000.0;

		check4warnings();

		drive_type = DT_RWD;
		drive_front_min = 0.0;
		drive_front_max = 0.0;
		def_drive_front = drive_front_min;
		drive_front = def_drive_front;

		diff_lock_min = 0.20;
		diff_lock_max = 0.20;
		def_diff_lock = 0.20;
		diff_lock = def_diff_lock;
	}
}
