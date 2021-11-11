package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Rollbar extends RearSeat
{
	public Rollbar( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Rollbar";
		description = "";
		brand_new_prestige_value = 42.49;

		value = tHUF2USD(38.946);
	}
}
