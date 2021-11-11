package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.cars.*;


public class FoMoCo_oil_filter extends EnginePart
{
	public FoMoCo_oil_filter( int id )
	{
		super( id );
		name = "FoMoCo oil filter";
		description = "";
		brand_new_prestige_value = 38.67;

		value = tHUF2USD(4);
		setMaxWear(kmToMaxWear(151000.0));

		check4warnings();
	}
}