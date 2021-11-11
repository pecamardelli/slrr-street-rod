package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.cars.*;


public class Big_block_cover extends EnginePart
{
	public Big_block_cover( int id )
	{
		super( id );
		name = "Big block cover (390/460)";
		description = "";
		brand_new_prestige_value = 34.00;

		value = tHUF2USD(18);
		setMaxWear(kmToMaxWear(671000.0));

		check4warnings();
	}


}