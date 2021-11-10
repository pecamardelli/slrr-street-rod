package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Baiern_R_bumper_2 extends Bumper
{
	public Baiern_R_bumper_2( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Ford De Luxe rear bumper 2";

		description = "A replacement rear bumper for the DevilSport and CoupeSport models. It's made of plastic to reduce weight at the rear end.";

		value = tHUF2USD(157);
		brand_new_prestige_value = 38.0;
		setMaxWear(kmToMaxWear(400000.0));
	}
}
