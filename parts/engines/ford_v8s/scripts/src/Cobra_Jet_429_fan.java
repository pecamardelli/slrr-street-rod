package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.cars.*;


public class Cobra_Jet_429_fan extends EnginePart
{
	public Cobra_Jet_429_fan( int id )
	{
		super( id );
		name = "Ford Cobra Jet 429 V8 cooling fan";
		description = "";
		brand_new_prestige_value = 35.00;

		value = tHUF2USD(10);
		setMaxWear(kmToMaxWear(151000.0));

		check4warnings();
	}


}