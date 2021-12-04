package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.*;


public class ford_stock_exhaust_header extends ExhaustHeader
{
	public ford_stock_exhaust_header( int id )
	{
		super( id );
		name = "Ford stock exhaust header";
		description = "";
		brand_new_prestige_value = 36.01;

		value = tHUF2USD(45);
		setMaxWear(kmToMaxWear(300000.0));

		efficiency = 0.8;

		check4warnings();
	}
}
