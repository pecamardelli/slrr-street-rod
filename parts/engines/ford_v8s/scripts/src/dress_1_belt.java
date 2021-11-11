package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.cars.*;


public class dress_1_belt extends EnginePart
{
	public dress_1_belt( int id )
	{
		super( id );
		name = "Bosch alternator drive belt";
		description = "";
		brand_new_prestige_value = 35.73;

		value = tHUF2USD(7);
		setMaxWear(kmToMaxWear(300000.0));

		check4warnings();
	}
}
