package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.cars.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.*;


public class ford_stock_drive_pulley extends Pulley
{
	public ford_stock_drive_pulley( int id )
	{
		super( id );
		name = "Ford stock drive pulley";
		description = "";
		brand_new_prestige_value = 14.34;

		value = tHUF2USD(14.756);
		setMaxWear(kmToMaxWear(400000.0));

		maxRPM = 120000.0;

		inertia = kgToInertia(0.05);

		check4warnings();
	}
}
