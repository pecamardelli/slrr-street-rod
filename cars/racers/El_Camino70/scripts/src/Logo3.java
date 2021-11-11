package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Logo3 extends Wing
{
	public Logo3( int id )
	{
		super( id );
		carCategory = PACKAGE;

		name = "Logo trunk";
		description = "";

		brand_new_prestige_value = 95.61;
		value = tHUF2USD(10.052);
	}
}
