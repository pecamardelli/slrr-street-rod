package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.airfueldeliverysystem.*;


public class SL_Tuners_6_channel_NOS_rail extends NOSInjectorSystem
{
	public SL_Tuners_6_channel_NOS_rail( int id )
	{
		super( id );
		name = "SL Tuners 6 channel ported N2O system";
		description = "A ported nitrous oxidizer intake system for the serial injected and direct injected engines based on the Baiern and Emer inline-six blocks. This system will add 25 to 250 HP to your engine depending on tuning level and calibration. It has six 0.31 inch injectors and comes with an adjustable electronic module to ensure you achieve the best performance.";

		value = tHUF2USD(400.000);
		brand_new_prestige_value = 159.67;
		setMaxWear(kmToMaxWear(1000000.0));

		maxconsumption		= 5.44; // 720 lbs/hr
		minconsumption		= 0.544; // 72 lbs/hr
		nitro_consumption	= minconsumption;
		nitro_minRPM		= 2250.0;
		nitro_maxRPM		= 6000.0;
		nitro_minThrottle	= 0.9;

		check4warnings();
	}
}
