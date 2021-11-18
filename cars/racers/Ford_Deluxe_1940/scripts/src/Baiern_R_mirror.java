package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Baiern_R_mirror extends Mirror
{
	public Baiern_R_mirror( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Ford Deluxe right mirror";

		description = "The stock right mirror for all CoupeSport and DevilSport models.";

		value = tHUF2USD(28);
		brand_new_prestige_value = 32.50;
		setMaxWear(kmToMaxWear(200000.0));
	}
}
