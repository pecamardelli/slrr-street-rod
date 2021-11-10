package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Duhen_R_bumper extends Bumper
{
	public Duhen_R_bumper( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Rear bumper";

		description = "";

		value = tHUF2USD(47.469);
		brand_new_prestige_value = 28.09;
		setMaxWear(kmToMaxWear(285000));
	}
}
