package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Baiern_hood extends Hood
{
	public Baiern_hood( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Ford De Luxe hood";

		description = "The stock hood of the DevilSports and CoupeSports except for the GT III.";

		value = tHUF2USD(178);
		brand_new_prestige_value = 32.50;
		setMaxWear(kmToMaxWear(200000.0));
	}
}
