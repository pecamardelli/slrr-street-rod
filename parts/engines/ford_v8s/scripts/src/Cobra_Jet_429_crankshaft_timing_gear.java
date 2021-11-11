package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.cars.*;


public class Cobra_Jet_429_crankshaft_timing_gear extends EnginePart
{
	public Cobra_Jet_429_crankshaft_timing_gear( int id )
	{
		super( id );
		name = "Ford Cobra Jet 429 crankshaft timing gear";
		description = "";

		brand_new_prestige_value = 40.86;
		value = tHUF2USD(20);
		setMaxWear(kmToMaxWear(200000.0));

		check4warnings();
	}


}