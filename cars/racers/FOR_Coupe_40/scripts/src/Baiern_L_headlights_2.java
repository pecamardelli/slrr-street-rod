package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Baiern_L_headlights_2 extends Headlights
{
	public Baiern_L_headlights_2( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Baiern CoupeSport GT III left headlights";

		description = "The left side headlights of the CoupeSport GT III. A simplified xenon headlight based on the factory stock part, covered with a black painted alloy sheet to defend the headlight body from injury.";

		value = tHUF2USD(173.912);
		brand_new_prestige_value = 50.0;
		setMaxWear(kmToMaxWear(400000.0));
	}
}
