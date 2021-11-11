package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class air_intake_on_the_hood extends Quarterpanel
{
	public air_intake_on_the_hood( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "air intake on the hood";
		description = "";
		brand_new_prestige_value = 42.49;

		value = tHUF2USD(5.366);
	}
}
