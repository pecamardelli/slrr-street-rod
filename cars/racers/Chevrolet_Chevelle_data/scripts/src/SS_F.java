package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class SS_F extends Quarterpanel
{
	public SS_F( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "SS";
		description = "";
		brand_new_prestige_value = 42.49;

		value = tHUF2USD(7.366);
	}
}
