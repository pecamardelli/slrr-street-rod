package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class MC_R_wing extends Wing
{
	public MC_R_wing( int id )
	{
		super( id );
		carCategory = PACKAGE;

		name = "Chevrolet Chevelle rear wing";
		description = "";

		brand_new_prestige_value = 95.61;
		value = tHUF2USD(35);
	}
}
