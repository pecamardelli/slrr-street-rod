package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.*;
import java.game.parts.enginepart.airfueldeliverysystem.*;


public class Edelbrock_racing_air_cleaner extends AirFilter
{
	public Edelbrock_racing_air_cleaner( int id )
	{
		super( id );
		name = "Edelbrock Racing four-barrel air filter";
		description = "";
		brand_new_prestige_value = 45.80;

		value = tHUF2USD(35);

		stock_max_air_consumption = 0.52;
		setMaxWear(300000.0);
		dusted_efficiency = 0.45;

		check4warnings();
	}
}
