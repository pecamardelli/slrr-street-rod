package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.cars.*;


public class Big_block_cover_chrome extends EnginePart
{
	public Big_block_cover_chrome( int id )
	{
		super( id );
		name = "Chromic big block cover (390/460)";
		description = "";
		brand_new_prestige_value = 39.00;

		value = tHUF2USD(20);
		setMaxWear(kmToMaxWear(671000.0));

		check4warnings();
	}


}