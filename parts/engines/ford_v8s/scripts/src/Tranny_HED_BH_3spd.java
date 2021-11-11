package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.*;


public class Tranny_HED_BH_3spd extends Transmission
{
	public Tranny_HED_BH_3spd( int id )
	{
		super( id );
		name = "Ford HED-BH 3-speed transmission";
		description = "First gear: \t 3.29 \n Second gear: \t 1.83 \n Third gear: \t 1.0 \n Final ratio: \t 3.73";
		brand_new_prestige_value = 55.15;

		value = tHUF2USD(260.195);
		setMaxWear(kmToMaxWear(400000));

		gears		= 3;
		ratio[0]	= 0;
		ratio[1]	= 3.290;
		ratio[2]	= 1.830;
		ratio[3]	= 1.000;
		ratio[7]	= -4.460;
		end_ratio	= 3.73;

		starter_torque	= 65.0;

		inertia = kgToInertia(18.0);
		maxRPM = 7000.0;

		check4warnings();

		drive_type = DT_RWD;
		drive_front_min = 0.0;
		drive_front_max = 0.0;
		def_drive_front = drive_front_min;
		drive_front = def_drive_front;

		diff_lock_min = 0.10;
		diff_lock_max = 0.60;
		def_diff_lock = 0.30;
		diff_lock = def_diff_lock;
	}
}
