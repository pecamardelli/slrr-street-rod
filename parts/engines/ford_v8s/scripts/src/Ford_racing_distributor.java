package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.cars.*;


public class Ford_racing_distributor extends EnginePart
{
	public Ford_racing_distributor( int id )
	{
		super( id );
		name = "Ford Racing distributor";
		description = "";
		brand_new_prestige_value = 41.37;

		value = tHUF2USD(51.085);
		setMaxWear(kmToMaxWear(700000.0));

		check4warnings();
	}
}
