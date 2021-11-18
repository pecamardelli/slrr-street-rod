package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Baiern_R_windshield extends Windshield
{
	public Baiern_R_windshield( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Ford Deluxe rear windshield";

		description = "The factory stock rear windshield of all CoupeSports except for the GT III.";

		value = tHUF2USD(170);
		brand_new_prestige_value = 32.50;
		setMaxWear(kmToMaxWear(350000.0));
	}
}
