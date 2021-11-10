package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Duhen_FL_window_2 extends Window
{
	public Duhen_FL_window_2( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Driver's window";

		description = "";

		value = tHUF2USD(21.098);
		brand_new_prestige_value = 28.09;
		setMaxWear(kmToMaxWear(285000));
	}
}
