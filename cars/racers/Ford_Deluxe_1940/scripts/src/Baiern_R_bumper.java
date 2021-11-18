package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Baiern_R_bumper extends Bumper
{
	public Baiern_R_bumper( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Ford Deluxe rear bumper";

		description = "The stock rear bumper for the DevilSport and CoupeSport models except for the GT III. It's made of plastic to reduce weight at the front and increase lifetime, but durability suffers this design.";

		value = tHUF2USD(100);
		brand_new_prestige_value = 32.50;
		setMaxWear(kmToMaxWear(700000.0));
	}
}
