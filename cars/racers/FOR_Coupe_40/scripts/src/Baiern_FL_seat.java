package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Baiern_FL_seat extends FrontSeat
{
	public Baiern_FL_seat( int id )
	{
		super( id );
		carCategory = COMMON;
		name = "Ford De Luxe seat";

		description = "The stock street bucket seat for the Baiern drivers. Very comfortable and has enough lateral support for high speed turns.";

		value = tHUF2USD(76);
		brand_new_prestige_value = 32.50;
		setMaxWear(kmToMaxWear(200000.0));
	}
}
