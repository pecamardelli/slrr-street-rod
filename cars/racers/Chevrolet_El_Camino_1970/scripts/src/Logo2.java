package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Logo2 extends Quarterpanel
{
	public Logo2( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Logo chassis";
		description = "";
		brand_new_prestige_value = 42.49;

		value = tHUF2USD(12.366);
	}
}
