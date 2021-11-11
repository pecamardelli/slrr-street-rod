package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.*;


public class Cobra_Jet_429_left_exhaust_header extends ExhaustHeader
{
	public Cobra_Jet_429_left_exhaust_header( int id )
	{
		super( id );
		name = "Ford Cobra Jet 429 V8 left exhaust header";
		description = "";
		brand_new_prestige_value = 84.51;

		value = tHUF2USD(72);
		setMaxWear(kmToMaxWear(330000.0));

		efficiency = 0.9;

		check4warnings();
	}
}
