package java.game.parts.engines.Chrysler_V8_pak;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;


public class air_scoop extends Part
{
	public air_scoop( int id )
	{
		super( id );
		name = "Black Air Scoop";
		description = "Made by Fireful0";

		brand_new_prestige_value = 15;

		value = 545.45;
		setMaxWear(100000.0);
		check4warnings();
	}

}