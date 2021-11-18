package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Baiern_trunk extends Trunk
{
	public Baiern_trunk( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Ford Deluxe trunk";

		description = "The stock trunk door for all DevilSport and CoupeSport models except for the GT III.";

		value = tHUF2USD(98);
		brand_new_prestige_value = 32.50;
		setMaxWear(kmToMaxWear(300000.0));
	}
}
