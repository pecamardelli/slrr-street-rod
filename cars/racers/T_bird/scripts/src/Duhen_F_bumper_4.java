package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Duhen_F_bumper_4 extends Bumper
{
	public Duhen_F_bumper_4( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Front sport paintable bumper";

		description = "";

		value = tHUF2USD(184.931);
		brand_new_prestige_value = 50.95;
		setMaxWear(kmToMaxWear(285000));
	}
}
