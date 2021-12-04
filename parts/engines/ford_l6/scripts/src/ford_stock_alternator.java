package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.cars.*;


public class ford_stock_alternator extends EnginePart
{
	public ford_stock_alternator( int id )
	{
		super( id );
		name = "Indiel-Lucas stock alternator";
		description = "This part generates the electrical power needed for igniting the air fuel mixture in the engine. It is driven by a belt that connects to the crankshaft. \n In short race conditions you may dismount this part to produce some more horsepower because the battery holds enough charge for ignition, but only for some minutes.";

		value = tHUF2USD(39);
		brand_new_prestige_value = 38.32;
		setMaxWear(kmToMaxWear(400000.0));

		check4warnings();
	}


	public String isDynoable()
	{
		Part p;

		p = partOnSlot( 42 );
		if (!p)
			return "the alternator is missing the drive belt.";

		return super.isDynoable();
	}
}
