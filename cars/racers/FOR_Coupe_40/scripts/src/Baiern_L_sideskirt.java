package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Baiern_L_sideskirt extends Sideskirt
{
	public Baiern_L_sideskirt( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Baiern CoupeSport/DevilSport left sideskirt";

		description = "The stock left sideskirt of the DevilSport and CoupeSport models except for the GT III.";

		value = tHUF2USD(28);
		brand_new_prestige_value = 32.50;
		setMaxWear(kmToMaxWear(200000.0));
	}
}
