package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Palka extends Quarterpanel
{
	public Palka( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Palka";
		description = "";
		brand_new_prestige_value = 42.49;

		value = tHUF2USD(22.366);
	}
}
