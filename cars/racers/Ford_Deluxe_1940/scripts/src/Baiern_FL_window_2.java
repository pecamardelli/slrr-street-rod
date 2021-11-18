package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Baiern_FL_window_2 extends Window
{
	public Baiern_FL_window_2( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Baiern CoupeSport GT III driver's window";

		description = "A replacement plastic driver's window for the CoupeSports GT III.";

		value = tHUF2USD(20);
		brand_new_prestige_value = 70.00;
		setMaxWear(kmToMaxWear(500000.0));
	}
}
