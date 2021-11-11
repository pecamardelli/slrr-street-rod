package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class R_Tumanky extends Headlights
{
	public R_Tumanky( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "R Tumanky";
		description = "";
		brand_new_prestige_value = 53.11;

		value = tHUF2USD(10);
	}
}
