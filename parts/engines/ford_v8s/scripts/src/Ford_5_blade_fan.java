package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.cars.*;


public class Ford_5_blade_fan extends EnginePart
{
	public Ford_5_blade_fan( int id )
	{
		super( id );
		name = "Ford 5 blade fan";
		description = "";
		brand_new_prestige_value = 28.00;

		value = tHUF2USD(6);
		setMaxWear(kmToMaxWear(111000.0));

		check4warnings();
	}


}