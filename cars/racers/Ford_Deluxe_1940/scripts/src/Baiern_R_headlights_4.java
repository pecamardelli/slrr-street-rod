package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;

public class Baiern_R_headlights_4 extends Headlights
{
	public Baiern_R_headlights_4( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "SL Tuners Baiern 3beam Carbon right headlights";

		description = "One of the right side replacemet headlights applicable to the Baiern cars. Made by the ultimate tuner team, SL Tuners.";

		value = tHUF2USD(70.000);
		brand_new_prestige_value = 70.0;
		setMaxWear(kmToMaxWear(200000.0));
	}
}
