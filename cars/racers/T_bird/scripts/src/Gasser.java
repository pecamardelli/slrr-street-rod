package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Gasser extends Windshield
{
	public Gasser( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Gasser running gear";

		description = "";

		value = tHUF2USD(94.940);
		brand_new_prestige_value = 35.12;
		setMaxWear(kmToMaxWear(285000));
	}
}
