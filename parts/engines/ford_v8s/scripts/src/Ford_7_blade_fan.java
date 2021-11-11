package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.cars.*;


public class Ford_7_blade_fan extends EnginePart
{
	public Ford_7_blade_fan( int id )
	{
		super( id );
		name = "FoMoCo seven blade fan";
		description = "";
		brand_new_prestige_value = 28.00;

		value = tHUF2USD(7);
		setMaxWear(kmToMaxWear(171000.0));

		check4warnings();
	}


}