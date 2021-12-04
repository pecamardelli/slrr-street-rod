package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.*;


public class Emer_StreetGT_transmission extends Transmission
{
	public Emer_StreetGT_transmission( int id )
	{
		super( id );
		name = "Emer StreetGT 6 speed street transmission";
		description = "";
		brand_new_prestige_value = 64.02;

		value = tHUF2USD(127);
		setMaxWear(kmToMaxWear(300000.0));

		gears		= 6;
		ratio[0]	= 0;
		ratio[1]	= 3.827;
		ratio[2]	= 2.360;
		ratio[3]	= 1.685;
		ratio[4]	= 1.312;
		ratio[5]	= 1.000;
		ratio[6]	= 0.793;
		ratio[7]	=-4.000;
		end_ratio	= 4.470;
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

		diff_lock_min = 0.25;
		diff_lock_max = 0.25;
		def_diff_lock = 0.25;
		diff_lock = def_diff_lock;
	}
}
