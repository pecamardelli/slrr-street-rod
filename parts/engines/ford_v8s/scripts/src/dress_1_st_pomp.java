package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.cylinderhead.*;
import java.game.cars.*;


public class dress_1_st_pomp extends EnginePart
{
	public dress_1_st_pomp( int id )
	{
		super( id );
		name = "Polished steering pomp";
		description = "";
		brand_new_prestige_value = 65.67;

		value = tHUF2USD(28);
		setMaxWear(kmToMaxWear(311000.0));

		check4warnings();
	}
}
