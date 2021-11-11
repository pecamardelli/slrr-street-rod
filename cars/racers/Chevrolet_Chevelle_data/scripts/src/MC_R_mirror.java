package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class MC_R_mirror extends Mirror
{
	public MC_R_mirror( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Chevrolet Chevelle right mirror";
		description = "";
		brand_new_prestige_value = 53.11;

		value = tHUF2USD(13);
	}
}
