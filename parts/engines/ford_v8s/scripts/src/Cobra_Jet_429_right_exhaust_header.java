package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.*;


public class Cobra_Jet_429_right_exhaust_header extends ExhaustHeader
{
	public Cobra_Jet_429_right_exhaust_header( int id )
	{
		super( id );
		name = "Ford Cobra Jet 429 V8 right exhaust header";
		description = "";
		brand_new_prestige_value = 74.51;

		value = tHUF2USD(73);
		setMaxWear(kmToMaxWear(330000.0));

		efficiency = 0.95;

		check4warnings();
	}
}
