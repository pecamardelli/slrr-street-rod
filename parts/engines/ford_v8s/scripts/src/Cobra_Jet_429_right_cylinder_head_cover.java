package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.cylinderhead.*;
import java.game.cars.*;


public class Cobra_Jet_429_right_cylinder_head_cover extends EnginePart
{
	public Cobra_Jet_429_right_cylinder_head_cover( int id )
	{
		super( id );
		name = "Ford Cobra Jet 429 V8 right cylinder head cover";
		description = "";
		brand_new_prestige_value = 48.67;

		value = tHUF2USD(26);
		setMaxWear(kmToMaxWear(511000.0));

		check4warnings();
	}
}
