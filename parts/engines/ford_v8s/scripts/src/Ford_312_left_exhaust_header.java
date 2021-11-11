package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.*;


public class Ford_312_left_exhaust_header extends ExhaustHeader
{
	public Ford_312_left_exhaust_header( int id )
	{
		super( id );
		name = "Ford 312 V8 left exhaust header";
		description = "";
		brand_new_prestige_value = 64.51;

		value = tHUF2USD(55);
		setMaxWear(kmToMaxWear(330000.0));

		efficiency = 0.9;

		check4warnings();
	}
}
