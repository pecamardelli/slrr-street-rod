package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.*;
import java.game.parts.enginepart.airfueldeliverysystem.*;


public class KN_2x4brl_air_filter extends AirFilter
{
	public KN_2x4brl_air_filter( int id )
	{
		super( id );
		name = "KN dual four-barrel air cleaner";
		description = "";
		brand_new_prestige_value = 36.80;

		value = tHUF2USD(38.561);

		stock_max_air_consumption = 0.5;
		setMaxWear(200000.0);
		dusted_efficiency = 0.45;

		check4warnings();
	}
}
