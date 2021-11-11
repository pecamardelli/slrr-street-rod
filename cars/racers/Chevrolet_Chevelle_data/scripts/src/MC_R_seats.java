package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class MC_R_seats extends RearSeat
{
	public MC_R_seats( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Chevrolet Chevelle rear seats";
		description = "";
		brand_new_prestige_value = 42.49;

		value = tHUF2USD(44);
	}
}
