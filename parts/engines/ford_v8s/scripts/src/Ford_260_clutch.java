package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.*;


public class Ford_260_clutch extends Clutch
{
	public Ford_260_clutch( int id )
	{
		super( id );
		name = "Ford 260 V8 clutch";
		description = "";
		brand_new_prestige_value = 38.53;

		value = tHUF2USD(32);
		setMaxWear(kmToMaxWear(280000.0));

		maxRPM = 13000.0;

		inertia = kgToInertia(4.2);

		check4warnings();
	}
}
