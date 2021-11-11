package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.*;
import java.game.parts.enginepart.airfueldeliverysystem.*;


public class Ford_351_4brl_air_filter extends AirFilter
{
	public Ford_351_4brl_air_filter( int id )
	{
		super( id );
		name = "Ford 351 Boss V8 four-barrel air filter";
		description = "";
		brand_new_prestige_value = 35.80;

		value = tHUF2USD(22);

		stock_max_air_consumption = 0.3;
		setMaxWear(100000.0);
		dusted_efficiency = 0.35;

		check4warnings();
	}
}
