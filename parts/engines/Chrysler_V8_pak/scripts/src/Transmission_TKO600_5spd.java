package java.game.parts.engines.Chrysler_V8_pak;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.*;


public class Transmission_TKO600_5spd extends Transmission
{
	public Transmission_TKO600_5spd( int id )
	{
		super( id );
		name = "TKO 600 5-Speed transmission M";
		description = "";
		brand_new_prestige_value = 195.95;

		value = tHUF2USD(570.85);
		setMaxWear(kmToMaxWear(520000.0));

		gears 		= 5;
		ratio[0] 	= 0;
		ratio[1] 	= 2.870;
		ratio[2] 	= 1.890;
		ratio[3] 	= 1.280;
		ratio[4] 	= 1.000;
		ratio[5] 	= 0.640;
		ratio[7] 	= -3.000;
		end_ratio 	= 3.230;

		starter_torque	= 50.0;

		adjustable_gears = 1+2+4;

		inertia = kgToInertia(9.0);
		maxRPM = 13000.0;

		check4warnings();

		drive_type = DT_RWD;
		drive_front_min = 0.0;
		drive_front_max = 0.0;
		def_drive_front = drive_front_min;
		drive_front = def_drive_front;

		diff_lock_min = 0.00;
		diff_lock_max = 1.00;
		def_diff_lock = 0.20;
		diff_lock = def_diff_lock;
	}
}
