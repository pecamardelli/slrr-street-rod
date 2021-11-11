package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.cars.*;


public class Edelbrock_5_blade_fan extends EnginePart
{
	public Edelbrock_5_blade_fan( int id )
	{
		super( id );
		name = "Edelbrock five blade fan";
		description = "";
		brand_new_prestige_value = 34.00;

		value = tHUF2USD(15);
		setMaxWear(kmToMaxWear(171000.0));

		check4warnings();
	}


}