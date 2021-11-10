package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Duhen_targa_top extends TargaTop
{
	public Duhen_targa_top( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Top";

		description = "";

		value = tHUF2USD(58.018);
		brand_new_prestige_value = 49.16;
		setMaxWear(kmToMaxWear(285000));
	}
}
