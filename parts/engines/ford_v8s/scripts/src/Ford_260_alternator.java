package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.cars.*;


public class Ford_260_alternator extends EnginePart
{
	public Ford_260_alternator( int id )
	{
		super( id );
		name = "Ford 260 V8 alternator";
		description = "";
		brand_new_prestige_value = 22.37;

		value = tHUF2USD(35);
		setMaxWear(kmToMaxWear(400000.0));

		check4warnings();
	}
}
