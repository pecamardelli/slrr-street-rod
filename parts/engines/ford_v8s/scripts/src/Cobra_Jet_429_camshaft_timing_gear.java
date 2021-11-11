package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.cars.*;


public class Cobra_Jet_429_camshaft_timing_gear extends EnginePart
{
	public Cobra_Jet_429_camshaft_timing_gear( int id )
	{
		super( id );
		name = "Ford Cobra Jet 429 camshaft timing gear";
		description = "";

		brand_new_prestige_value = 45.86;
		value = tHUF2USD(22);
		setMaxWear(kmToMaxWear(200000.0));

		check4warnings();
	}

	public String isDynoable()
	{
		Part p;

		p = partOnSlot( 22 );
		if (!p)
			return "the engine is missing the timing chain.";

		return super.isDynoable();
	}
}