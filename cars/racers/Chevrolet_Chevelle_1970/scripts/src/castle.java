package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class castle extends Quarterpanel
{
	public castle( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "castle";
		description = "";
		brand_new_prestige_value = 42.49;

		value = tHUF2USD(222.366);
	}
}
