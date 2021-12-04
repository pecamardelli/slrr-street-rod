package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;

public class Emer_alternator_drive_belt extends Part
{
	public Emer_alternator_drive_belt( int id )
	{
		super( id );
		name = "Emer alternator drive belt";
		description = "You need this belt for driving the alternator. It can be used with all Baiern and 100% compatible alternators.";

		value = tHUF2USD(1.1);
		brand_new_prestige_value = 30.20;
		setMaxWear(kmToMaxWear(30000.0));

		check4warnings();
	}
}
