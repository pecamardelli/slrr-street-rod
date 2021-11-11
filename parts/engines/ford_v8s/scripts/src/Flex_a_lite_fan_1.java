package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.cars.*;


public class Flex_a_lite_fan_1 extends EnginePart
{
	public Flex_a_lite_fan_1( int id )
	{
		super( id );
		name = "Flex a Lite cooling fan";
		description = "";
		brand_new_prestige_value = 35.00;

		value = tHUF2USD(7);
		setMaxWear(kmToMaxWear(151000.0));

		check4warnings();
	}


}