package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class MC_FR_indicator extends IndicatorLights
{
	public MC_FR_indicator( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Chevrolet Chevelle front right indicator";
		description = "";
		brand_new_prestige_value = 53.11;

		value = tHUF2USD(12);
	}
}
