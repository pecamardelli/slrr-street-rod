package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.cylinderhead.*;
import java.game.cars.*;


public class Ford_racing_radiator_big_block extends EnginePart
{
	public Ford_racing_radiator_big_block( int id )
	{
		super( id );
		name = "Ford Racing aluminium radiator (390-460)";
		description = "";
		brand_new_prestige_value = 38.67;

		value = tHUF2USD(39.512);
		setMaxWear(kmToMaxWear(611000.0));

		check4warnings();
	}
}
