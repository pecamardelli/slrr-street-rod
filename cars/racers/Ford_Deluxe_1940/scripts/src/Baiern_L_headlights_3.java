package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;

public class Baiern_L_headlights_3 extends Headlights
{
	public Baiern_L_headlights_3( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "SL Tuners Baiern 3beam left headlights";

		description = "One of the left side replacemet headlights applicable to the Baiern cars. Made by the ultimate tuner team, SL Tuners.";

		value = tHUF2USD(60.000);
		brand_new_prestige_value = 50.0;
		setMaxWear(kmToMaxWear(200000.0));
	}
}
