package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Korobka extends Quarterpanel
{
	public Korobka( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Korobka";
		description = "";
		brand_new_prestige_value = 42.49;

		value = tHUF2USD(22.366);
	}
}
