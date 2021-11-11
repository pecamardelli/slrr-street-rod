package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class MC_FR_door extends FrontDoor
{
	public MC_FR_door( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Chevrolet Chevelle front right door";
		description = "";
		brand_new_prestige_value = 53.11;

		value = tHUF2USD(115.630);
	}

	public void addStockParts( int actcolor, float optical, float power )
	{
		super.addStockParts( actcolor, optical, power );

		float part_random;

		randomize( optical + power );

		// parts that have only one appearance //
		if ( optical >= 1.0 )
		{
			addPart( cars.racers.Chevrolet_Chevelle:0x000000BEr, "FR window", actcolor, optical, power );
			addPart( cars.racers.Chevrolet_Chevelle:0x000000C5r, "R mirror", actcolor, optical, power );
		} else
		{
			if ( optical >= random() ) addPart( cars.racers.Chevrolet_Chevelle:0x000000BEr, "FR window", actcolor, optical, power );
			if ( optical >= random() ) addPart( cars.racers.Chevrolet_Chevelle:0x000000C5r, "R mirror", actcolor, optical, power );
		}

		// parts that have multiple appearance //
		if ( optical <= 1.0 )
		{
		} else
		{

		}

	}
}
