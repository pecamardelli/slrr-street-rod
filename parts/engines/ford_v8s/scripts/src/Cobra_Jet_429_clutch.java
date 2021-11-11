package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.*;


public class Cobra_Jet_429_clutch extends Clutch
{
	public Cobra_Jet_429_clutch( int id )
	{
		super( id );
		name = "Ford Cobra Jet 429 V8 clutch";
		description = "";
		brand_new_prestige_value = 88.53;

		value = tHUF2USD(50);
		setMaxWear(kmToMaxWear(180000.0));

		maxRPM = 13000.0;

		inertia = kgToInertia(4.6);

		check4warnings();
	}
}
