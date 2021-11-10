package java.game.parts.engines.Chrysler_V8_pak;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;


public class defiant_aircleaner extends Part
{
	public defiant_aircleaner( int id )
	{
		super( id );
		name = "Chrome Air Cleaner";
		description = "Special thanks to Defiant for creating this air cleaner!";

		brand_new_prestige_value = 15;

		value = 545.45;
		setMaxWear(100000.0);
		check4warnings();
	}

}