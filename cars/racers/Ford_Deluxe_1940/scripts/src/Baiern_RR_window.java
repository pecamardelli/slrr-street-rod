package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;

public class Baiern_RR_window extends Window
{
	public Baiern_RR_window( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Ford Deluxe rear right window";

		description = "The stock clear rear right window of the CoupeSport models except for the GT III.";

		value = tHUF2USD(19);
		brand_new_prestige_value = 32.50;
		setMaxWear(kmToMaxWear(350000.0));
	}
}
