package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class MC_F_windshield extends Windshield
{
	public MC_F_windshield( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Front windshield";
		description = "";
		brand_new_prestige_value = 53.11;

		value = tHUF2USD(73.470);
	}
}
