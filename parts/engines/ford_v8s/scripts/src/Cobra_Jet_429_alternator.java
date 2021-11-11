package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.cars.*;


public class Cobra_Jet_429_alternator extends EnginePart
{
	public Cobra_Jet_429_alternator( int id )
	{
		super( id );
		name = "Ford Cobra Jet 429 V8 alternator";
		description = "";
		brand_new_prestige_value = 44.37;

		value = tHUF2USD(40);
		setMaxWear(kmToMaxWear(400000.0));

		check4warnings();
	}
}
