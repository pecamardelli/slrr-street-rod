package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.*;


public class Edelbrock_351_390_left_exhaust_header extends ExhaustHeader
{
	public Edelbrock_351_390_left_exhaust_header( int id )
	{
		super( id );
		name = "Edelbrock 351/390 V8 left exhaust header";
		description = "";
		brand_new_prestige_value = 74.51;

		value = tHUF2USD(88);
		setMaxWear(kmToMaxWear(530000.0));

		efficiency = 0.98;

		check4warnings();
	}
}
