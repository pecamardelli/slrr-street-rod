package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.*;


public class Cobra_Jet_429_pistons extends Piston
{
	public Cobra_Jet_429_pistons( int id )
	{
		super( id );
		name = "Ford Cobra Jet 429 V8 pistons";
		description = "";
		brand_new_prestige_value = 91.68;

		value = tHUF2USD(48);
		setMaxWear(kmToMaxWear(411000.0));

		maxRPM = 7750.0;

		bore = 110.7;
		length_from_wrist_pin_center_to_crown_base = 62.00;
		crown_height = 22.19;
		crown_volume = 66.00;
		length_from_lowest_safe_belt_to_crown_base = 47.00;

		inertia = kgToInertia(8*0.620);

		check4warnings();
	}
}
