package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Duhen_steering_wheel extends SteeringWheel
{
	public Duhen_steering_wheel( int id )
	{
		super( id );
		carCategory = COMMON;
		name = "Thunderbird steering wheel";

		description = "";

		diameter = 420.0;

		value = tHUF2USD(21.098);
		brand_new_prestige_value = 35.12;
		setMaxWear(kmToMaxWear(285000.0));
	}
}
