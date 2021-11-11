package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.*;


public class Ford_racing_right_exhaust_header_big_block extends ExhaustHeader
{
	public Ford_racing_right_exhaust_header_big_block( int id )
	{
		super( id );
		name = "Ford Racing right exhaust header (390 and 460)";
		description = "";
		brand_new_prestige_value = 84.51;

		value = tHUF2USD(106.401);
		setMaxWear(kmToMaxWear(430000.0));

		efficiency = 1.07;

		check4warnings();
	}
}
