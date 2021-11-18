package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;

public class Baiern_RL_window extends Window
{
	public Baiern_RL_window( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Ford Deluxe rear left window";

		description = "The stock clear rear left window of the CoupeSport models except for the GT III.";

		value = tHUF2USD(19);
		brand_new_prestige_value = 32.50;
		setMaxWear(kmToMaxWear(350000.0));
	}
}
