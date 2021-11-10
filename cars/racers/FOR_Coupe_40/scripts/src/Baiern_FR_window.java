package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Baiern_FR_window extends Window
{
	public Baiern_FR_window( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Ford De Luxe passenger's window";

		description = "The stock clear passenger's window of the DevilSports and CoupeSports except for the GT III.";

		value = tHUF2USD(28);
		brand_new_prestige_value = 32.50;
		setMaxWear(kmToMaxWear(200000.0));
	}
}
