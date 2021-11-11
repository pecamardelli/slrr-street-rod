package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.cars.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.*;


public class Ford_260_pulley extends Pulley
{
	public Ford_260_pulley( int id )
	{
		super( id );
		name = "Ford 260 V8 driver pulley";
		description = "";
		brand_new_prestige_value = 24.34;

		value = tHUF2USD(12);
		setMaxWear(kmToMaxWear(400000.0));

		maxRPM = 120000.0;

		inertia = kgToInertia(0.05);

		check4warnings();
	}
}
