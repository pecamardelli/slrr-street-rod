package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Duhen_L_taillights extends Taillights
{
	public Duhen_L_taillights( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Left taillights";

		description = "";

		value = tHUF2USD(21.098);
		brand_new_prestige_value = 35.12;
		setMaxWear(kmToMaxWear(285000.0));
	}
}
