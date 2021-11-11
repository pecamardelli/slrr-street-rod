package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.*;


public class Ford_460_right_exhaust_header extends ExhaustHeader
{
	public Ford_460_right_exhaust_header( int id )
	{
		super( id );
		name = "Ford 460 V8 right exhaust header";
		description = "";
		brand_new_prestige_value = 64.51;

		value = tHUF2USD(70);
		setMaxWear(kmToMaxWear(330000.0));

		efficiency = 0.93;

		check4warnings();
	}
}
