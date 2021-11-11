package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.cars.*;


public class Edelbrock_supercharger_drive_belt_small_block extends EnginePart
{
	public Edelbrock_supercharger_drive_belt_small_block( int id )
	{
		super( id );
		name = "Edelbrock roots type supercharger drive belt (260/292/332)";
		description = "";
		brand_new_prestige_value = 48.60;

		value = tHUF2USD(18);
		setMaxWear(kmToMaxWear(160000.0));

		check4warnings();
	}
}
