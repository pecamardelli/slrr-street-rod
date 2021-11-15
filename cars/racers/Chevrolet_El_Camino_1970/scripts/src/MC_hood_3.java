package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class MC_hood_3 extends Hood
{
	public MC_hood_3( int id )
	{
		super( id );
		carCategory = PACKAGE;

		name = "Hood Cowl Induction";
		description = "";

		value = tHUF2USD(80.206);
		brand_new_prestige_value = 42.49;
	}
}
