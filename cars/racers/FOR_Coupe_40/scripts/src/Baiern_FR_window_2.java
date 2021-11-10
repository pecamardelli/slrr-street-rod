package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Baiern_FR_window_2 extends Window
{
	public Baiern_FR_window_2( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Baiern CoupeSport GT III passenger's window";

		description = "A replacement plastic passenger's window for the CoupeSports GT III.";

		value = tHUF2USD(20);
		brand_new_prestige_value = 70.00;
		setMaxWear(kmToMaxWear(500000.0));
	}
}
