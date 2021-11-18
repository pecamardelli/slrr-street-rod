package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Baiern_L_sideskirt_2 extends Sideskirt
{
	public Baiern_L_sideskirt_2( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Baiern Devils CoupeSport GT III left sideskirt";

		description = "The left sideskirt of the CoupeSport GT III. Features enhanced air dynamics and air passages to the rear brake system to enhance efficiency.";

		value = tHUF2USD(71.865);
		brand_new_prestige_value = 50.0;
		setMaxWear(kmToMaxWear(400000.0));
	}
}
