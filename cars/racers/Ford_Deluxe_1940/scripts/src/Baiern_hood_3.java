package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Baiern_hood_3 extends Hood
{
	public Baiern_hood_3( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Baiern Devils CoupeSport/DevilSport replacement hood";

		description = "A replacement hood for the DevilSport and CoupeSport models. It's made of plastic to reduce weight at the front, but durability suffers this design.";

		value = tHUF2USD(273);
		brand_new_prestige_value = 38.09;
		setMaxWear(kmToMaxWear(400000.0));
	}
}
