package java.game.parts.engines.Chrysler_V8_pak;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.*;


public class Transmission_A727_3spd extends Transmission
{
	public Transmission_A727_3spd( int id )
	{
		super( id );
		name = "Torqueflite A727 (TF-8) 3-speed transmission A";
		description = "";
		brand_new_prestige_value = 85.55;

		value = tHUF2USD(280.15);
		setMaxWear(kmToMaxWear(420000.0));

		gears 		= 3;
		ratio[0] 	= 0;
		ratio[1] 	= 3.682;
		ratio[2]	= 2.412;
		ratio[3] 	= 1.721;
		ratio[7] 	= -3.151;
		end_ratio 	= 2.000;

		starter_torque	= 40.0;

		adjustable_gears = 1+2+4;

		inertia = kgToInertia(13.0);
		maxRPM = 9000.0;

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
