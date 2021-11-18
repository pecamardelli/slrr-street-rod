package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Baiern_R_windshield_2 extends Windshield
{
	public Baiern_R_windshield_2( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Baiern CoupeSport GT III rear windshield";

		description = "The platsic replacement rear windshield for the CoupeSports GT III racercars.";

		value = tHUF2USD(60);
		brand_new_prestige_value = 82.00;
		setMaxWear(kmToMaxWear(500000.0));
	}
}
