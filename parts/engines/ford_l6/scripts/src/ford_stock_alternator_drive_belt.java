package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;

public class ford_stock_alternator_drive_belt extends Part
{
	public ford_stock_alternator_drive_belt( int id )
	{
		super( id );
		name = "Ford stock alternator drive belt";
		description = "You need this belt for driving the alternator. It can be used with all Ford and 100% compatible alternators.";

		value = tHUF2USD(7.1);
		brand_new_prestige_value = 25.55;
		setMaxWear(kmToMaxWear(60000.0));

		check4warnings();
	}
}
