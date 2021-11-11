package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.cylinderhead.*;
import java.game.cars.*;


public class Cobra_Jet_429_racing_radiator extends EnginePart
{
	public Cobra_Jet_429_racing_radiator( int id )
	{
		super( id );
		name = "Ford Racing Cobra Jet 429 V8 aluminium radiator";
		description = "";
		brand_new_prestige_value = 58.67;

		value = tHUF2USD(70);
		setMaxWear(kmToMaxWear(611000.0));

		check4warnings();
	}
}
