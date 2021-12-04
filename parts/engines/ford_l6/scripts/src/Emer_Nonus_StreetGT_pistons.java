package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.*;

public class Emer_Nonus_StreetGT_pistons extends Piston
{
	public Emer_Nonus_StreetGT_pistons( int id )
	{
		super( id );
		name = "Emer Nonus StreetGT pistons";
		description = "";
		brand_new_prestige_value = 40.01;

		value = tHUF2USD(6*21);
		setMaxWear(kmToMaxWear(270000.0));

		bore = 86.0;
		length_from_wrist_pin_center_to_crown_base = 22.31;
		crown_height = 17.07;
		crown_volume = 54.13;
		length_from_lowest_safe_belt_to_crown_base = 10.77;

		maxRPM = 10000.0;
		inertia = kgToInertia(6*0.275);

		check4warnings();
	}
}
