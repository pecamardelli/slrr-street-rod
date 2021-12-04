package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.*;


public class Emer_camshaft_bearing_bridge extends SlidingEnginePart
{
	public Emer_camshaft_bearing_bridge( int id )
	{
		super( id );
		name = "Emer camshaft bearing bridge";
		description = "It's the bearing used in all Emer inline-6 engines. It's very durable, and is not too expensive to change, but take good care of your engine especially the lubrication.";

		value = tHUF2USD(2*16);
		brand_new_prestige_value = 38.32;
		setMaxWear(kmToMaxWear(250000.0));

		check4warnings();
	}
}