package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class MC_FL_window extends Window
{
	public MC_FL_window( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Driver's window";
		description = "";
		brand_new_prestige_value = 42.49;

		value = tHUF2USD(25.579);
	}
}
