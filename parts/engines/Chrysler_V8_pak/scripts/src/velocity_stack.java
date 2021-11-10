package java.game.parts.engines.Chrysler_V8_pak;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;


public class velocity_stack extends Part
{
	public velocity_stack( int id )
	{
		super( id );
		name = "Velocity Stack";
		description = "Made by Fireful0";

		value = 545.45;
		setMaxWear(100000.0);
		check4warnings();
	}

}