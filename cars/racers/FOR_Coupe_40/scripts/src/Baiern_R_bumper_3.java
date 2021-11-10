package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Baiern_R_bumper_3 extends Bumper
{
	public Baiern_R_bumper_3( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Ford De Luxe rear bumper 3";

		description = "The rear bumper for the CoupeSport GT III. It's made of carbon fiber to drastically reduce weight at the rear and increase lifetime while keeping durability. \n It also supports an integrated splitter to create downforce at the end. It can be adjusted from 5 to 45 degrees in 1 degree steps to produce 30 to 500 ? downforce.";

		value = tHUF2USD(416.815);
		brand_new_prestige_value = 85.0;
		setMaxWear(kmToMaxWear(600000.0));
	}
}
