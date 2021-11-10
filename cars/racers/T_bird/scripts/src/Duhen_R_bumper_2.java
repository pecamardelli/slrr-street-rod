package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Duhen_R_bumper_2 extends Bumper
{
	public Duhen_R_bumper_2( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Rear sport bumper";

		description = "";

		value = tHUF2USD(175.982);
		brand_new_prestige_value = 50.95;
		setMaxWear(kmToMaxWear(285000));
	}
}
