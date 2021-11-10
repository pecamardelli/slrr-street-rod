package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Baiern_hood_2 extends Hood
{
	public Baiern_hood_2( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Ford De Luxe hood 2";

		description = "The hood of the CoupeSport GT IIIs. It's made of carbon fiber and has a ram intake opening specially designed for the GT III bi-turbo engine.";

		value = tHUF2USD(589.290);
		brand_new_prestige_value = 70.0;
		setMaxWear(kmToMaxWear(600000.0));
	}
}
