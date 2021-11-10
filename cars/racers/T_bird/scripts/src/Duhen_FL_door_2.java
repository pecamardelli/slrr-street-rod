package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Duhen_FL_door_2 extends FrontDoor
{
	public Duhen_FL_door_2( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Driver's door";

		description = "";

		value = tHUF2USD(68.567);
		brand_new_prestige_value = 35.12;
		setMaxWear(kmToMaxWear(285000));
	}
}
