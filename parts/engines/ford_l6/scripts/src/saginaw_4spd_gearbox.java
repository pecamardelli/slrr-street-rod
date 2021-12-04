package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.*;


public class saginaw_4spd_gearbox extends Transmission
{
	public saginaw_4spd_gearbox( int id )
	{
		super( id );
		name = "Saginaw four speed transmission";
		description = "Ratios: \n \n 1st: 2.85   2nd: 2.02  3rd: 1.35   4th: 1 \n \n end ratio: 3.07:1";

		value = tHUF2USD(127);
		brand_new_prestige_value = 63.87;
		setMaxWear(kmToMaxWear(300000.0));

		gears		= 4;
		ratio[0]	= 0;
		ratio[1]	= 2.85;
		ratio[2]	= 2.02;
		ratio[3]	= 1.35;
		ratio[4]	= 1;
		ratio[7]	=-2.85;
		end_ratio	= 3.07;
		starter_torque	= 0.0;

		amount_of_oil_needed = 0.0; // internally lubricated //
		best_lubrication_sliction=0.99;
		worst_lubrication_sliction=0.45;

		maxRPM = 10000.0;
		inertia = kgToInertia(13.8);

		check4warnings();

		drive_type = DT_RWD;
		drive_front_min = 0.0;
		drive_front_max = 0.0;
		def_drive_front = drive_front_min;
		drive_front = def_drive_front;

		diff_lock_min = 0.15;
		diff_lock_max = 0.15;
		def_diff_lock = 0.15;
		diff_lock = def_diff_lock;
	}
}
