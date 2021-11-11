package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.*;
import java.game.parts.enginepart.airfueldeliverysystem.*;


public class Ford_332_4brl_air_filter extends AirFilter
{
	public Ford_332_4brl_air_filter( int id )
	{
		super( id );
		name = "Ford 332 V8 four-barrel air filter";
		description = "";
		brand_new_prestige_value = 35.80;

		value = tHUF2USD(20);

		stock_max_air_consumption = 0.32;
		setMaxWear(150000.0);
		dusted_efficiency = 0.27;

		check4warnings();
	}
}
