package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.*;

public class Emer_MotorSport_Nonus_GT2_pistons extends Piston
{
	public Emer_MotorSport_Nonus_GT2_pistons( int id )
	{
		super( id );
		name = "Emer MotorSport Nonus GT2 pistons";
		description = "";
		brand_new_prestige_value = 80.01;

		value = tHUF2USD(6*35);
		setMaxWear(kmToMaxWear(205000.0));

		bore = 90.0;
		length_from_wrist_pin_center_to_crown_base = 22.31;
		crown_height = 17.07;
		crown_volume = 60.00;
		length_from_lowest_safe_belt_to_crown_base = 10.77;

		maxRPM = 20000.0;
		inertia = kgToInertia(6*0.390);

		check4warnings();
	}
}
