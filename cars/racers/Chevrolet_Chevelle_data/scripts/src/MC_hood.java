package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class MC_hood extends Hood
{
	public MC_hood( int id )
	{
		super( id );
		carCategory = PACKAGE;

		name = "Chevrolet Chevelle hood";
		description = "";

		value = tHUF2USD(114);
		brand_new_prestige_value = 42.49;
	}
}
