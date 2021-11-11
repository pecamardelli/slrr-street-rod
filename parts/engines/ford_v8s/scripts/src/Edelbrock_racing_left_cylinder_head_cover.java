package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.cylinderhead.*;
import java.game.cars.*;


public class Edelbrock_racing_left_cylinder_head_cover extends EnginePart
{
	public Edelbrock_racing_left_cylinder_head_cover( int id )
	{
		super( id );
		name = "Edelbrock Racing left cylinder head cover";
		description = "";
		brand_new_prestige_value = 52.67;

		value = tHUF2USD(35);
		setMaxWear(kmToMaxWear(511000.0));

		check4warnings();
	}
}
