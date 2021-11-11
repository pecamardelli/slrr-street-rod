package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.cylinderhead.*;
import java.game.cars.*;


public class Ford_351_390_radiator_1 extends EnginePart
{
	public Ford_351_390_radiator_1( int id )
	{
		super( id );
		name = "Ford 351/390 V8 radiator";
		description = "";
		brand_new_prestige_value = 38.67;

		value = tHUF2USD(40);
		setMaxWear(kmToMaxWear(511000.0));

		check4warnings();
	}
}
