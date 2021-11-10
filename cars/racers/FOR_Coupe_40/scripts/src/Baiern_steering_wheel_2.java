package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;

public class Baiern_steering_wheel_2 extends SteeringWheel
{
	public Baiern_steering_wheel_2( int id )
	{
		super( id );
		carCategory = COMMON;
		name = "Baiern DevilSport steering wheel";

		description = "The stock 41 cm (16.0 inch) steering wheel for all Baiern Devils DevilSport. It features the official logo of Individual Baiern Tuners Ltd. on the center between the horn buttons.";

		diameter = 410.0;

		value = tHUF2USD(55);
		brand_new_prestige_value = 34.0;
		setMaxWear(kmToMaxWear(450000.0));
	}
}
