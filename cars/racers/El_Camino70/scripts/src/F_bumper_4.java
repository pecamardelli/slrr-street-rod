package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class F_bumper_4 extends Bumper
{
	public F_bumper_4( int id )
	{
		super( id );
		carCategory = PACKAGE;

		name = "Front bumper replacement paintable";
		description = "";

		value = tHUF2USD(44.717);
		brand_new_prestige_value = 46.49;
	}
}
