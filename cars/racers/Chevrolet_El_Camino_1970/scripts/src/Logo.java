package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Logo extends Quarterpanel
{
	public Logo( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Logo grill";
		description = "";
		brand_new_prestige_value = 42.49;

		value = tHUF2USD(12.366);
	}
}
