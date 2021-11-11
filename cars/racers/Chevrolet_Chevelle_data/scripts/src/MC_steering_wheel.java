package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class MC_steering_wheel extends SteeringWheel
{
	public MC_steering_wheel( int id )
	{
		super( id );
		carCategory = COMMON;
		name = "Chevrolet Chevelle steering wheel";
		description = "";
		brand_new_prestige_value = 53.11;

		diameter = 440.0;
		value = tHUF2USD(18);
	}
}
