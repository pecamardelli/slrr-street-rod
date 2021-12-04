package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.*;


public class sprint_exhaust_header extends ExhaustHeader
{
	public sprint_exhaust_header( int id )
	{
		super( id );
		name = "Sprint exhaust header";
		description = "";

		value = tHUF2USD(79);
		brand_new_prestige_value = 38.32;
		setMaxWear(kmToMaxWear(200000.0));

		efficiency = 0.95;

		check4warnings();
	}
}
