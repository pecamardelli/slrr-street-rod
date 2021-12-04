package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.*;


public class Emer_StreetGT_exhaust_header extends ExhaustHeader
{
	public Emer_StreetGT_exhaust_header( int id )
	{
		super( id );
		name = "Emer Nonus StreetGT exhaust header";
		description = "";
		brand_new_prestige_value = 36.01;

		value = tHUF2USD(40);
		setMaxWear(kmToMaxWear(200000.0));

		efficiency = 0.87;

		check4warnings();
	}
}
