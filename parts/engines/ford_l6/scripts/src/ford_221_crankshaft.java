package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.*;
import java.game.cars.*;

public class ford_221_crankshaft extends Crankshaft
{
	public ford_221_crankshaft( int id )
	{
		super( id );
		name = "Ford 221 stock crankshaft";
		description = "";

		value = tHUF2USD(39);
		brand_new_prestige_value = 84.30;
		setMaxWear(kmToMaxWear(526000.0));

		con_rod_slot_ID = 9;
		flywheel_slot_ID = 37;

		stroke = 87.88;
		main_bearing_diam = 44.0;
		con_bearing_diam = 44.05;

		maxRPM = 9000.0;
		inertia = kgToInertia(12.300);

		check4warnings();
	}
	
	public String isDynoable()
	{
		Part p;

		p = partOnSlot( 32 );
		if (!p)
			return "the engine is missing the crankshaft timing gear.";
		
		p = partOnSlot( 33 );
		if (!p)
			return "the engine is missing the drive pulley.";

		return super.isDynoable();
	}
}
