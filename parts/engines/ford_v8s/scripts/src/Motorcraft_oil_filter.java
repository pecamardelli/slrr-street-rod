package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.cars.*;


public class Motorcraft_oil_filter extends EnginePart
{
	public Motorcraft_oil_filter( int id )
	{
		super( id );
		name = "Motorcraft oil filter";
		description = "XXX.";
		brand_new_prestige_value = 28.67;

		value = tHUF2USD(19.512);
		setMaxWear(kmToMaxWear(111000.0));

		check4warnings();
	}
}