package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class L_Tumanky extends Headlights
{
	public L_Tumanky( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "L Tumanky";
		description = "";
		brand_new_prestige_value = 53.11;

		value = tHUF2USD(5.579);
	}
}
