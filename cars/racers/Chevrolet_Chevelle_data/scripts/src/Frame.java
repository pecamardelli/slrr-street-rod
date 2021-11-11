package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Frame extends Quarterpanel
{
	public Frame( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Frame";
		description = "";
		brand_new_prestige_value = 42.49;

		value = tHUF2USD(52.366);
	}
}
