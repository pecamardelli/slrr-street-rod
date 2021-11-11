package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.*;


public class Ford_312_clutch extends Clutch
{
	public Ford_312_clutch( int id )
	{
		super( id );
		name = "Ford 312 V8 clutch";
		description = "";
		brand_new_prestige_value = 58.53;

		value = tHUF2USD(40);
		setMaxWear(kmToMaxWear(180000.0));

		maxRPM = 13000.0;

		inertia = kgToInertia(4.5);

		check4warnings();
	}
}
