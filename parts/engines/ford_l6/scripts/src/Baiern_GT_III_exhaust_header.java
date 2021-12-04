package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.*;


public class Baiern_GT_III_exhaust_header extends ExhaustHeader
{
	public Baiern_GT_III_exhaust_header( int id )
	{
		super( id );
		name = "Baiern GT III exhaust header";
		description = "The relatively short-life 6-2-1 exhaust header. \n This product is not compatible with turbochargers but you can use it on a supercharged engine. \n All the six outlets are oval 60x40 mm (2.36x1.57 inch) pipes and come together in 3 cylinder groups to a 50 mm (1.97 inch) circular collector then end in a 60 mm (2.36 inch) circular main tube. Pipes cross each other in as far as possible firing order to maintain the most effective exhaust.";

		value = tHUF2USD(240);
		brand_new_prestige_value = 153.28;
		setMaxWear(kmToMaxWear(330000.0));

		efficiency = 0.93;

		check4warnings();
	}
}
