package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.cars.*;


public class ford_three_line_radiator extends EnginePart
{
	public ford_three_line_radiator( int id )
	{
		super( id );
		name = "Ford stock three-line radiator";
		description = "";
		brand_new_prestige_value = 21.37;

		value = tHUF2USD(71.085);
		setMaxWear(kmToMaxWear(400000.0));

		check4warnings();
	}
}
