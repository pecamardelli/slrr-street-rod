package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.cars.*;


public class Ford_260_alt_drive_belt extends EnginePart
{
	public Ford_260_alt_drive_belt( int id )
	{
		super( id );
		name = "Ford 260 V8 alternator drive belt";
		description = "";
		brand_new_prestige_value = 15.73;

		value = tHUF2USD(5);
		setMaxWear(kmToMaxWear(140000.0));

		check4warnings();
	}
}
