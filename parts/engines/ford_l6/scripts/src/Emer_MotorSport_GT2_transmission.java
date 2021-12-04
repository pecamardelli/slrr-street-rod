package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.*;


public class Emer_MotorSport_GT2_transmission extends Transmission
{
	public Emer_MotorSport_GT2_transmission( int id )
	{
		super( id );
		name = "Emer MotorSport GT2 6 speed race transmission";
		description = "A fully customizable racing transmission designed to drive the rear wheel through a driveshaft. There are no front-wheel extension slots on this transmission. Emer MotorSport Division (EMD) created this fine long-lasting, superlight tranny for the MotorSport Nonus GT2. It's very rare to find.";

		value = tHUF2USD(654);
		brand_new_prestige_value = 153.28;
		setMaxWear(kmToMaxWear(700000.0));

		gears		= 6;
		ratio[0]	= 0;
		ratio[1]	= 4.21;
		ratio[2]	= 2.49;
		ratio[3]	= 1.66;
		ratio[4]	= 1.24;
		ratio[5]	= 1;
		ratio[6]	= 0.875;
		ratio[7]	= -4.0;
		end_ratio	= 2.88;
		starter_torque	= 0.0;

		adjustable_gears = 1+2+4; // forward gears, reversing gear, end ratio //

		amount_of_oil_needed = 0.0; // internally lubricated //
		best_lubrication_sliction=0.99;
		worst_lubrication_sliction=0.45;

		maxRPM = 20000.0;
		inertia = kgToInertia(13.8);

		check4warnings();

		drive_type = DT_RWD;
		drive_front_min = 0.0;
		drive_front_max = 0.0;
		def_drive_front = drive_front_min;
		drive_front = def_drive_front;

		diff_lock_min = 0.10;
		diff_lock_max = 0.90;
		def_diff_lock = 0.30;
		diff_lock = def_diff_lock;
	}
}
