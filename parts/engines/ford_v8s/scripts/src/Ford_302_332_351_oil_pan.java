package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.*;


public class Ford_302_332_351_oil_pan extends OilPan
{
	public Ford_302_332_351_oil_pan( int id )
	{
		super( id );
		name = "Ford 302/332/351 V8 oil pan";
		description = "";
		brand_new_prestige_value = 53.01;

		value = tHUF2USD(35);
		setMaxWear(kmToMaxWear(426000.0));

		friction_fwd = 0.0001;
		friction_rev = 0.0001;

		check4warnings();
	}
}
