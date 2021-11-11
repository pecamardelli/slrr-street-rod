package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.cars.*;


public class Ford_292_edelbrock_alternator extends EnginePart
{
	public Ford_292_edelbrock_alternator( int id )
	{
		super( id );
		name = "Ford 292 V8 Edelbrock alternator";
		description = "";
		brand_new_prestige_value = 44.37;

		value = tHUF2USD(42);
		setMaxWear(kmToMaxWear(426000.0));

		check4warnings();
	}
}
