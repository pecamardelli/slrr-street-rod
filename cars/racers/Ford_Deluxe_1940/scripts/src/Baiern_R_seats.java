package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Baiern_R_seats extends RearSeat
{
	public Baiern_R_seats( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Ford Deluxe cagerace";

		description = "The stock rear seats for the DevilSport and CoupeSport models, but not for the GT III. It's full leather, breathes well and is comfortable for long trips.";

		value = tHUF2USD(98);
		brand_new_prestige_value = 32.50;
		setMaxWear(kmToMaxWear(200000.0));
	}
}
