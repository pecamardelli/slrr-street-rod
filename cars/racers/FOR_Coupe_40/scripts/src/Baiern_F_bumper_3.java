package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Baiern_F_bumper_3 extends Bumper
{
	public Baiern_F_bumper_3( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Ford De Luxe front bumper 3";

		description = "The front bumper of the CoupeSport GT III. It is made of carbon fiber for weight reduction. \n It also supports an integrated splitter to create downforce at the front. It can be adjusted from 5 to 45 degrees in 1 degree steps to produce 30 to 500 ? downforce.";

		value = tHUF2USD(405.316);
		brand_new_prestige_value = 85.0;
		setMaxWear(kmToMaxWear(200000.0));
	}
}
