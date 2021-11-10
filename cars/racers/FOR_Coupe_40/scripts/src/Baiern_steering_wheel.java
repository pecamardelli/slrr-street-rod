package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;

public class Baiern_steering_wheel extends SteeringWheel
{
	public Baiern_steering_wheel( int id )
	{
		super( id );
		carCategory = COMMON;
		name = "Ford De Luxe steering wheel";

		description = "The stock 42 cm (16.5 inch) steering wheel for all Baiern CoupeSport models except for the GT III. It features the official logo of Baiern Cars Gmbh. on the center between the horn buttons.";

		diameter = 420.0;

		value = tHUF2USD(35);
		brand_new_prestige_value = 32.50;
		setMaxWear(kmToMaxWear(350000.0));
	}
}
