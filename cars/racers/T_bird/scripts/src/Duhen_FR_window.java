package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Duhen_FR_window extends Window
{
	public Duhen_FR_window( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Convertible passenger's window";

		description = "";

		value = tHUF2USD(21.098);
		brand_new_prestige_value = 28.09;
		setMaxWear(kmToMaxWear(285000));
	}
}
