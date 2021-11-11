package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class R_bumper2 extends Bumper
{
	public R_bumper2( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Rear bumper paintable";
		description = "";
		brand_new_prestige_value = 42.49;

		value = tHUF2USD(30.052);
	}
}
