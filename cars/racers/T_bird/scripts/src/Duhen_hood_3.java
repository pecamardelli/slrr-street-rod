package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Duhen_hood_3 extends Hood
{
	public Duhen_hood_3( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Drag hood";

		description = "";

		value = tHUF2USD(178.965);
		brand_new_prestige_value = 50.95;
		setMaxWear(kmToMaxWear(285000));
	}
}
