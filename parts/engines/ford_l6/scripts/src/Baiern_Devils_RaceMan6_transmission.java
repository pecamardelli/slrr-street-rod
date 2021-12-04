package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.*;


public class Baiern_Devils_RaceMan6_transmission extends Transmission
{
	public Baiern_Devils_RaceMan6_transmission( int id )
	{
		super( id );
		name = "Baiern Devils RaceMan6 6 speed race transmission";
		description = "A superlight transmission developed by Baiern Devils for the CoupeSport GT III. It has 6 gears with tight ratios, all adjustable from 1st to 6th, reverse and end ratio are fixed. \n From the outside, it is the same except for some minor modifications, but in the housing there are straight-cut gears made of billet 6033 aluminium, planted on titanium shafts to reduce reciprocating weight as much as possible, so increase durability. \n The rotating parts alltogether weigh no more than 6.5 kgs that reduces clutch slip to a very low level. \n 1st:2.7   2nd:2.2   3rd:1.8   4th:1.5   5th:1.2   6th:1.0 \n \n end ratio:2.73:1";

		value = tHUF2USD(492);
		brand_new_prestige_value = 114.96;
		setMaxWear(kmToMaxWear(720000.0));

		gears		= 6;
		ratio[0]	= 0;
		ratio[1]	= 2.7;
		ratio[2]	= 2.2;
		ratio[3]	= 1.8;
		ratio[4]	= 1.5;
		ratio[5]	= 1.2;
		ratio[6]	= 1.0;
		ratio[7]	= -3.0;
		end_ratio	= 2.73;
		starter_torque	= 0.0;

		adjustable_gears = 1; // forward gears //

		amount_of_oil_needed = 0.0; // internally lubricated //
		best_lubrication_sliction=1.0;
		worst_lubrication_sliction=0.9;

		maxRPM = 14000.0;
		inertia = kgToInertia(6.5);

		check4warnings();

		drive_type = DT_RWD;
		drive_front_min = 0.0;
		drive_front_max = 0.0;
		def_drive_front = drive_front_min;
		drive_front = def_drive_front;

		diff_lock_min = 0.10;
		diff_lock_max = 0.70;
		def_diff_lock = diff_lock_min;
		diff_lock = def_diff_lock;
	}
}
