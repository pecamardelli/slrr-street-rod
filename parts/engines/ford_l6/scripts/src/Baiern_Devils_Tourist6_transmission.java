package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.*;


public class Baiern_Devils_Tourist6_transmission extends Transmission
{
	public Baiern_Devils_Tourist6_transmission( int id )
	{
		super( id );
		name = "Baiern Devils Tourist6 6 speed street transmission";
		description = "A transmission developed by Baiern Devils for the DevilSport model group. It has 6 comfortable ratios. \n 1st:3.97   2nd:3.1   3rd:1.8   4th:1.3   5th:1.0   6th:0.88 \n \n end ratio:3.73:1";

		value = tHUF2USD(184);
		brand_new_prestige_value = 68.98;
		setMaxWear(kmToMaxWear(642000.0));

		gears		= 6;
		ratio[0]	= 0;
		ratio[1]	= 4.1;
		ratio[2]	= 2.6;
		ratio[3]	= 1.8;
		ratio[4]	= 1.3;
		ratio[5]	= 1.0;
		ratio[6]	= 0.88;
		ratio[7]	= -3.33;
		end_ratio	= 3.73;
		starter_torque	= 0.0;

		amount_of_oil_needed = 0.0; // internally lubricated //
		best_lubrication_sliction=1.0;
		worst_lubrication_sliction=0.82;

		maxRPM = 10000.0;
		inertia = kgToInertia(11.5);

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
