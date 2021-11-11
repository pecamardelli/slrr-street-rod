package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.cars.*;


public class Mallory_ignition extends EnginePart
{
	public Mallory_ignition( int id )
	{
		super( id );
		name = "Mallory ignition distributor";
		description = "";
		brand_new_prestige_value = 31.37;

		value = tHUF2USD(41.085);
		setMaxWear(kmToMaxWear(500000.0));

		check4warnings();
	}
}
