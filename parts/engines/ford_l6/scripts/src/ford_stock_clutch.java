package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.*;


public class ford_stock_clutch extends Clutch
{
	public ford_stock_clutch( int id )
	{
		super( id );
		name = "Ford stock clutch";
		description = "A well designed light clutch made for the low to middle level performance Baierns. \n It's a 3.5 kg (7.72 pounds) diaphragm style clutch with a static pressure of 1250. \n Pressure plate diameter is 250 mm (9.84 inch), useful contact area is 452 sq.cm (70 sq.inch).";

		value = tHUF2USD(41);
		brand_new_prestige_value = 31.93;
		setMaxWear(kmToMaxWear(180000.0));

		maxRPM = 10000.0;
		inertia = kgToInertia(3.5);

		check4warnings();
	}
}
