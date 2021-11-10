package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Duhen_L_mirror extends Mirror
{
	public Duhen_L_mirror( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Left mirror";

		description = "The stock left mirror for all the SunStrips.";

		value = tHUF2USD(26.372);
		brand_new_prestige_value = 35.12;
		setMaxWear(kmToMaxWear(285000));
	}
}
