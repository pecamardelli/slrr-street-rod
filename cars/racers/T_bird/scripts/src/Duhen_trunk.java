package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Duhen_trunk extends Trunk
{
	public Duhen_trunk( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Trunk door";

		description = "";

		value = tHUF2USD(73.842);
		brand_new_prestige_value = 28.09;
		setMaxWear(kmToMaxWear(285000));
	}
}
