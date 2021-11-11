package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.*;


public class Ford_racing_left_exhaust_header_small_block extends ExhaustHeader
{
	public Ford_racing_left_exhaust_header_small_block( int id )
	{
		super( id );
		name = "Ford Racing left exhaust header (260-351)";
		description = "";
		brand_new_prestige_value = 84.51;

		value = tHUF2USD(96.401);
		setMaxWear(kmToMaxWear(330000.0));

		efficiency = 1.07;

		check4warnings();
	}
}
