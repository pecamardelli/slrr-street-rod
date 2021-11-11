package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.*;


public class Tranny_tremec_t56_6spd extends Transmission
{
	public Tranny_tremec_t56_6spd( int id )
	{
		super( id );
		name = "Tremec T56 Dual Overdrive 6-Speed transmission";
		description = "First gear: \t 3.35 \n Second gear: \t 2.07 \n Third gear: \t 1.35 \n Fourth gear: \t 1.000 \n Fifth gear: \t 0.8 \n Sixth gear: \t 0.63 \n Final ratio: \t 4.11";
		brand_new_prestige_value = 125.55;

		value = tHUF2USD(545.005);
		setMaxWear(kmToMaxWear(400000.5));

		gears 		= 6;
		ratio[0] 	= 0;
		ratio[1] 	= 3.350;
		ratio[2] 	= 2.070;
		ratio[3] 	= 1.350;
		ratio[4] 	= 1.000;
		ratio[5] 	= 0.800;
		ratio[6] 	= 0.630;
		ratio[7] 	= -3.280;
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
