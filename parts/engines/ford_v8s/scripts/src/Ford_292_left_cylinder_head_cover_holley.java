package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.cylinderhead.*;
import java.game.cars.*;


public class Ford_292_left_cylinder_head_cover_holley extends EnginePart
{
	public Ford_292_left_cylinder_head_cover_holley( int id )
	{
		super( id );
		name = "Holley 292 V8 left cylinder head cover";
		description = "";
		brand_new_prestige_value = 39.67;

		value = tHUF2USD(18);
		setMaxWear(kmToMaxWear(511000.0));

		check4warnings();
	}
}
