package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.*;


public class Ford_390_oil_pan extends OilPan
{
	public Ford_390_oil_pan( int id )
	{
		super( id );
		name = "Ford 390 V8 oil pan";
		description = "";
		brand_new_prestige_value = 33.01;

		value = tHUF2USD(45);
		setMaxWear(kmToMaxWear(426000.0));

		friction_fwd = 0.0001;
		friction_rev = 0.0001;

		check4warnings();
	}
}
