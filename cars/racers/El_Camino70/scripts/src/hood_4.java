package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class hood_4 extends Hood
{
	public hood_4( int id )
	{
		super( id );
		carCategory = PACKAGE;

		name = "Hood with scoop";
		description = "";

		value = tHUF2USD(80.206);
		brand_new_prestige_value = 42.49;
	}
}
