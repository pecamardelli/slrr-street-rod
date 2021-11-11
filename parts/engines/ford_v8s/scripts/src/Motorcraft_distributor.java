package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.cars.*;


public class Motorcraft_distributor extends EnginePart
{
	public Motorcraft_distributor( int id )
	{
		super( id );
		name = "Motorcraft distributor";
		description = "";
		brand_new_prestige_value = 31.37;

		value = tHUF2USD(31.085);
		setMaxWear(kmToMaxWear(500000.0));

		check4warnings();
	}
}
