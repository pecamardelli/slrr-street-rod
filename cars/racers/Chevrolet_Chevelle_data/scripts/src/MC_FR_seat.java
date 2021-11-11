package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class MC_FR_seat extends FrontSeat
{
	public MC_FR_seat( int id )
	{
		super( id );
		carCategory = COMMON;
		name = "Chevrolet Chevelle passenger's seat";
		description = "";
		brand_new_prestige_value = 53.11;

		value = tHUF2USD(44);
	}
}
