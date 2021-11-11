package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Klimaanlage extends Quarterpanel
{
	public Klimaanlage( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Klimaanlage";
		description = "";
		brand_new_prestige_value = 42.49;

		value = tHUF2USD(22.366);
	}
}
