package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Baiern_L_taillights extends Taillights
{
	public Baiern_L_taillights( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Ford Deluxe left taillights";

		description = "The stock left side taillights for all DevilSport and CoupeSport models. It has three sections: a 20W red indicator, a 25W/35W red city/brake light, and a bright 35W white reversing light. The city and brake bulbs use LEDs for saftey reasons and long lifetime.";

		value = tHUF2USD(53);
		brand_new_prestige_value = 32.50;
		setMaxWear(kmToMaxWear(300000.0));
	}
}
