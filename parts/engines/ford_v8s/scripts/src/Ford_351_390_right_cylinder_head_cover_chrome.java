package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.cylinderhead.*;
import java.game.cars.*;


public class Ford_351_390_right_cylinder_head_cover_chrome extends EnginePart
{
	public Ford_351_390_right_cylinder_head_cover_chrome( int id )
	{
		super( id );
		name = "Ford 351/390 V8 right chrome cylinder head cover";
		description = "";
		brand_new_prestige_value = 38.67;

		value = tHUF2USD(25);
		setMaxWear(kmToMaxWear(511000.0));

		check4warnings();
	}
}
