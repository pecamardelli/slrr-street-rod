package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class MC_R_bumper extends Bumper
{
	public MC_R_bumper( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Chevrolet Chevelle rear bumper";
		description = "";
		brand_new_prestige_value = 42.49;

		value = tHUF2USD(55);
	}
}
