package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Baiern_F_windshield extends Windshield
{
	public Baiern_F_windshield( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Ford Deluxe front windshield";

		description = "The factory stock front windshield of all DevilSports and CoupeSports except for the GT III.";

		value = tHUF2USD(220);
		brand_new_prestige_value = 32.50;
		setMaxWear(kmToMaxWear(350000.0));
	}
}
