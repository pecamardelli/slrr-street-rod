package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.cars.*;


public class Cobra_Jet_429_alternator_drive_belt extends EnginePart
{
	public Cobra_Jet_429_alternator_drive_belt( int id )
	{
		super( id );
		name = "Ford Cobra Jet 429 V8 alternator drive belt";
		description = "";
		brand_new_prestige_value = 45.73;

		value = tHUF2USD(8);
		setMaxWear(kmToMaxWear(100000.0));

		check4warnings();
	}
}
