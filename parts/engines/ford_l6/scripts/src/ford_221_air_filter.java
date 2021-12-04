package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.*;
import java.game.parts.enginepart.airfueldeliverysystem.*;


public class ford_221_air_filter extends AirFilter
{
	public ford_221_air_filter( int id )
	{
		super( id );
		name = "Ford 221 stock air filter";
		description = "";
		brand_new_prestige_value = 25.80;

		value = tHUF2USD(31.561);

		stock_max_air_consumption = 0.3;
		setMaxWear(100000.0);
		dusted_efficiency = 0.25;

		check4warnings();
	}
}
