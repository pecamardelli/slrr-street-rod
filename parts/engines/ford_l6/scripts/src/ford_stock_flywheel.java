package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.*;
import java.game.cars.*;


public class ford_stock_flywheel extends Flywheel
{
	public ford_stock_flywheel( int id )
	{
		super( id );
		name = "Ford stock flywheel";
		description = "";

		value = tHUF2USD(31);
		brand_new_prestige_value = 38.32;
		setMaxWear(kmToMaxWear(320000.0));

		clutch_slot_ID = 36;

		maxRPM = 9000.0;
		inertia = kgToInertia(10.0);

		check4warnings();
	}
}
