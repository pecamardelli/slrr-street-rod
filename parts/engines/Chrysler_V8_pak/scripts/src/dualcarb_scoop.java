package java.game.parts.engines.Chrysler_V8_pak;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;

public class dualcarb_scoop extends Part
{
	public dualcarb_scoop( int id )
	{
		super( id );
		name = "Hood Scoop For Dual Quad Carbs";
		description = "Hood Scoop For Dual Quad Carbs. 3d by IJC / Fireful0 in Aug of 2016. Finished 2/5/18.";

		brand_new_prestige_value = 15;

		value = 545.45;
		setMaxWear(100000.0);
		check4warnings();
	}

}