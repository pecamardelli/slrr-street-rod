package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.cars.*;


public class dress_1_alt extends EnginePart
{
	public dress_1_alt( int id )
	{
		super( id );
		name = "Bosch 105 amp. alternator";
		description = "";
		brand_new_prestige_value = 54.37;

		value = tHUF2USD(45);
		setMaxWear(kmToMaxWear(500000.0));

		check4warnings();
	}
}
