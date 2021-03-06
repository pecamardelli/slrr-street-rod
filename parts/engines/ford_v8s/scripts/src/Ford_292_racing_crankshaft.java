package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.*;
import java.game.cars.*;


public class Ford_292_racing_crankshaft extends Crankshaft
{
	public Ford_292_racing_crankshaft( int id )
	{
		super( id );
		name = "Ford Racing 292 V8 Crankshaft Stroker";
		description = "";
		brand_new_prestige_value = 71.61;

		value = tHUF2USD(135);
		setMaxWear(kmToMaxWear(526000.0));

		con_rod_slot_ID = 40;
		flywheel_slot_ID = 6;

		maxRPM = 9500.0;

		stroke = 85.82;
		main_bearing_diam = 45.05;
		con_bearing_diam = 45.05;

		inertia = kgToInertia(18.0);

		check4warnings();
	}

	public String isDynoable()
	{
		Part p;
		
		p = partOnSlot( 6 );
		if (!p)
			return "the engine is missing the flywheel.";

		p = partOnSlot( 32 );
		if (!p)
			return "the engine is missing the crankshaft timing gear.";

		p = partOnSlot( 33 );
		if (!p)
			return "the engine is missing the crankshaft pulley.";
		
		p = partOnSlot( 40 );
		if (!p)
			return "the engine is missing the connecting rods.";

		return super.isDynoable();
	}
}
