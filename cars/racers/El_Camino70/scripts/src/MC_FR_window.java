package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class MC_FR_window extends Window
{
	public MC_FR_window( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Passenger's window";
		description = "";
		brand_new_prestige_value = 42.49;

		value = tHUF2USD(25.579);
	}
}
