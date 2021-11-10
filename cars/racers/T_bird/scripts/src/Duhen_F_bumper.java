package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Duhen_F_bumper extends Bumper
{
	public Duhen_F_bumper( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Front bumper";

		description = "";

		value = tHUF2USD(52.744);
		brand_new_prestige_value = 28.09;
		setMaxWear(kmToMaxWear(285000));
	}
}
