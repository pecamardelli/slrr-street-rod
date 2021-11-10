package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Duhen_L_headlights extends Headlights
{
	public Duhen_L_headlights( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Left headlights";

		description = "";

		value = tHUF2USD(21.098);
		brand_new_prestige_value = 35.12;
		setMaxWear(kmToMaxWear(285000));
	}
}
