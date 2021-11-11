package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class MC_FL_indicator extends IndicatorLights
{
	public MC_FL_indicator( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Chevrolet Chevelle front left indicator";
		description = "";
		brand_new_prestige_value = 53.11;

		value = tHUF2USD(12);
	}
}
