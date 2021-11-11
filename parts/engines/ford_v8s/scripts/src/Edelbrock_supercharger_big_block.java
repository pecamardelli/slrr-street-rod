package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.*;
import java.game.parts.enginepart.airfueldeliverysystem.charger.*;
import java.game.cars.*;

public class Edelbrock_supercharger_big_block extends SuperCharger
{
	public Edelbrock_supercharger_big_block( int id )
	{
		super( id );
		name = "Edelbrock 7.0 psi roots type supercharger (302/312/351/390/460)";
		description = "";
		brand_new_prestige_value = 105.05;

		value = tHUF2USD(550);

		pulley_diameter = 60.0; // in milimeters //
		pulley_width	= 60.0; // in milimeters //

		calculateOptandRange (900.0, 2500.0);
		default_rpm_turbo_mul = 2.5;
		P_turbo_max	= 1.15;
	}

	public void updatevariables()
	{
		rpm_turbo_mul = default_rpm_turbo_mul;
		setMaxWear(kmToMaxWear(9000.0));
	}

	public String isDynoable()
	{
		Part p;

		p = partOnSlot( 9 );
		if (!p)
			return "the supercharger is missing the fuel system.";

		p = partOnSlot( 15 );
		if (!p)
			return "the supercharger is missing the drive belt.";

		return super.isDynoable();
	}
}
