package java.game.parts.engines.Chrysler_V8_pak;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;

public class dualquadair extends Part
{
	public dualquadair( int id )
	{
		super( id );
		name = "426 Dual Quad Air Cleaner";
		description = "Made by Fireful0 and CuPcaKe Drifting. HemiHeadW00-Heavy font created by Ray Larabie. Font obtained from https://www.onlinewebfonts.com/download/cb53b85a683438b4b828bfa3ea2416d6";

		brand_new_prestige_value = 15;

		value = 545.45;
		setMaxWear(100000.0);
		check4warnings();
	}

}