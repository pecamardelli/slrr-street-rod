package java.game.parts.engines.Chrysler_V8_pak;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;


public class Mstmdrnaircleaner extends Part
{
	public Mstmdrnaircleaner( int id )
	{
		super( id );
		name = "Air Cleaner";
		description = "Fun little air cleaner";
		brand_new_prestige_value = 17.09;

		value = tHUF2USD(80);
		setMaxWear(kmToMaxWear(500000.0));
		check4warnings();

	}
}

