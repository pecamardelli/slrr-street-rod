package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.cars.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.*;


public class Ford_390_pulley extends Pulley
{
	public Ford_390_pulley( int id )
	{
		super( id );
		name = "Ford 390 V8 driver pulley";
		description = "";
		brand_new_prestige_value = 19.34;

		value = tHUF2USD(15);
		setMaxWear(kmToMaxWear(400000.0));

		maxRPM = 12000.0;

		inertia = kgToInertia(0.05);

		check4warnings();
	}
}
