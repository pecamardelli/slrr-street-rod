package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.*;


public class Ford_260_292_312_pistons extends Piston
{
	public Ford_260_292_312_pistons( int id )
	{
		super( id );
		name = "Ford 260/292/312 V8 pistons";
		description = "";
		brand_new_prestige_value = 71.68;

		value = tHUF2USD(28);
		setMaxWear(kmToMaxWear(411000.0));

		maxRPM = 7750.0;

		bore = 94.0;
		length_from_wrist_pin_center_to_crown_base = 62.00;
		crown_height = 22.19;
		crown_volume = 63.00;
		length_from_lowest_safe_belt_to_crown_base = 47.00;

		inertia = kgToInertia(8*0.620);

		check4warnings();
	}
}
