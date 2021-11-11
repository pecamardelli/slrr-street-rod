package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.*;


public class Tranny_tremec_t45_5spd extends Transmission
{
	public Tranny_tremec_t45_5spd( int id )
	{
		super( id );
		name = "Tremec T45 5-Speed Overdrive transmission";
		description = "First gear: \t 3.37 \n Second gear: \t 1.99 \n Third gear: \t 1.33 \n Fourth gear: \t 1.000 \n Fifth gear: \t 0.67 \n Final ratio: \t 4.11";
		brand_new_prestige_value = 65.25;

		value = tHUF2USD(445.005);
		setMaxWear(kmToMaxWear(400000.5));

		gears 		= 5;
		ratio[0] 	= 0;
		ratio[1] 	= 3.370;
		ratio[2] 	= 1.990;
		ratio[3] 	= 1.330;
		ratio[4] 	= 1.000;
		ratio[5] 	= 0.670;
		ratio[7] 	= -3.220;
		end_ratio 	= 4.11;

		adjustable_gears = 1+2+4; // forward gears, reversing gear, end ratio //
		
		starter_torque = 100.0;

		inertia = kgToInertia(10.0);

		maxRPM = 9000.0;

		check4warnings();

		drive_type = DT_RWD;
		drive_front_min = 0.0;
		drive_front_max = 0.0;
		def_drive_front = drive_front_min;
		drive_front = def_drive_front;

		diff_lock_min = 1.00;
		diff_lock_max = 1.00;
		def_diff_lock = 1.00;
		diff_lock = def_diff_lock;
	}
}
