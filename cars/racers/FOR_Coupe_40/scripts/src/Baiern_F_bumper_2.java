package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Baiern_F_bumper_2 extends Bumper
{
	public Baiern_F_bumper_2( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Ford De Luxe front bumper 2";

		description = "A replacement front bumper for the DevilSport and CoupeSport models. It's made of plastic to reduce weight at the front and increase lifetime, but durability suffers this design.";

		value = tHUF2USD(160);
		brand_new_prestige_value = 41.91;
		setMaxWear(kmToMaxWear(500000.0));
	}
}
