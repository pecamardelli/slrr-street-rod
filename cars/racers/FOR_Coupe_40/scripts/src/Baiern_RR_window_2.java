package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;

public class Baiern_RR_window_2 extends Window
{
	public Baiern_RR_window_2( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Baiern CoupeSport GT III rear right window";

		description = "The plastic replacement rear right window found in the CoupeSport GT III racecars.";

		value = tHUF2USD(13);
		brand_new_prestige_value = 70.00;
		setMaxWear(kmToMaxWear(500000.0));
	}
}
