package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.cars.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.*;


public class dress_1_pul extends Pulley
{
	public dress_1_pul( int id )
	{
		super( id );
		name = "Motorcraft driver pulley";
		description = "Larger diameter.";
		brand_new_prestige_value = 49.34;

		value = tHUF2USD(25);
		setMaxWear(kmToMaxWear(800000.0));

		maxRPM = 120000.0;

		inertia = kgToInertia(0.05);

		check4warnings();
	}
}
