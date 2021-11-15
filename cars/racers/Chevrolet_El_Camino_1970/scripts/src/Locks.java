package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Locks extends Splitter
{
	public Locks( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Hood locks";
		description = "";
		brand_new_prestige_value = 53.11;

		value = tHUF2USD(25.000);
	}
}
