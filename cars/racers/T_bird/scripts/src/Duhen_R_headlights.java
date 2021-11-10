package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Duhen_R_headlights extends Headlights
{
	public Duhen_R_headlights( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Right headlights";

		description = "The stock right headlights for all the SunStrips. A simple dual halogen headlight with 40W city bulbs and 45W for the highway. The indicator is a standard amber bulb.";

		value = tHUF2USD(21.098);
		brand_new_prestige_value = 35.12;
		setMaxWear(kmToMaxWear(285000));
	}
}
