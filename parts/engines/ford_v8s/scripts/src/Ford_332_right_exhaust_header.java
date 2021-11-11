package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.*;


public class Ford_332_right_exhaust_header extends ExhaustHeader
{
	public Ford_332_right_exhaust_header( int id )
	{
		super( id );
		name = "Ford 332 V8 right exhaust header";
		description = "";
		brand_new_prestige_value = 59.51;

		value = tHUF2USD(58);
		setMaxWear(kmToMaxWear(330000.0));

		efficiency = 0.9;

		check4warnings();
	}
}
