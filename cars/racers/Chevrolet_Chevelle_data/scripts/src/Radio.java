package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Radio extends Quarterpanel
{
	public Radio( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Radio";
		description = "";
		brand_new_prestige_value = 42.49;

		value = tHUF2USD(30);
	}
}
