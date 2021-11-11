package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.*;
import java.game.parts.enginepart.airfueldeliverysystem.*;


public class Motorcraft_4brl_blower extends AirFilter
{
	public Motorcraft_4brl_blower( int id )
	{
		super( id );
		name = "Motorcraft four-barrel blower";
		description = "";
		brand_new_prestige_value = 39.80;

		value = tHUF2USD(39.561);

		stock_max_air_consumption = 0.5;
		setMaxWear(200000.0);
		dusted_efficiency = 0.45;

		check4warnings();
	}
}
