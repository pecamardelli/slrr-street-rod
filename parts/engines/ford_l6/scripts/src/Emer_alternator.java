package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.cars.*;


public class Emer_alternator extends EnginePart
{
	public Emer_alternator( int id )
	{
		super( id );
		name = "Emer alternator";
		description = "This part generates the electrical power needed for igniting the air fuel mixture in the engine. It is driven by a belt that connects to the crankshaft. \n In short race conditions you may dismount this part to produce some more horsepower because the battery holds enough charge for ignition, but only for some minutes.";

		value = tHUF2USD(19);
		brand_new_prestige_value = 13.60;
		setMaxWear(kmToMaxWear(300000.0));

		check4warnings();
	}

	public void addStockParts( Descriptor desc )
	{
		super.addStockParts( desc );

		getCar_LocalVersion();

		if (the_car.make == the_car.MAKE_EMER)
		{
			if (the_car.model == Emer_models.MODEL_NONUS_STREET_GT)
			{
				addPart( parts.engines.ford_l6:0x00000087r, "Emer_alternator_drive_belt", desc );
			}
			else
			if (the_car.model == Emer_models.MODEL_MOTORSPORT_NONUS_GT2)
			{
				addPart( parts.engines.ford_l6:0x00000087r, "Emer_alternator_drive_belt", desc );
			}
		}
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
