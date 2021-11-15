package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class MC_F_bumper extends Bumper
{
	public MC_F_bumper( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Front bumper stock";

		description = "";

		value = tHUF2USD(48.946);
		brand_new_prestige_value = 42.49;
	}
}
