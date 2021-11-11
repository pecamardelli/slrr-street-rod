package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.cars.*;


public class Ford_4_blade_fan extends EnginePart
{
	public Ford_4_blade_fan( int id )
	{
		super( id );
		name = "Ford 4 blade fan";
		description = "";
		brand_new_prestige_value = 25.00;

		value = tHUF2USD(5);
		setMaxWear(kmToMaxWear(151000.0));

		check4warnings();
	}


}