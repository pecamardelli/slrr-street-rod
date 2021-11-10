package java.game.parts.engines.Chrysler_V8_pak;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;



public class air_cleaner_426 extends Part
{
	public air_cleaner_426( int id )
	{
		super( id );
		name = "426 Hemi Air Cleaner";
		description = "3d model by MF_FLED@GOM-TEAM. Put in game by Fireful0.";
		brand_new_prestige_value = 95.35;

		value = tHUF2USD(180.45);
		setMaxWear(kmToMaxWear(330000.0));

		check4warnings();
	}
}