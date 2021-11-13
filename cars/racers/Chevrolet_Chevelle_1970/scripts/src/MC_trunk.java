package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class MC_trunk extends Trunk
{
	public MC_trunk( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Chevrolet Chevelle trunk";
		description = "";
		brand_new_prestige_value = 42.49;

		value = tHUF2USD(80);
	}
}
