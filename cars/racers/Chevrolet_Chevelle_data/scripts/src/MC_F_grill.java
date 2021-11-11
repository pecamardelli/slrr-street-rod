package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.*;


public class MC_F_grill extends Part
{
	public MC_F_grill( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Chevrolet Chevelle front grill";
		description = "";
		brand_new_prestige_value = 42.49;

		value = tHUF2USD(25.579);
	}
}
