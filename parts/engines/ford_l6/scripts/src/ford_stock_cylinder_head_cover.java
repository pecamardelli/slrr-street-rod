package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;


public class ford_stock_cylinder_head_cover extends Part
{
	public ford_stock_cylinder_head_cover( int id )
	{
		super( id );
		name = "Ford stock cylinder head cover (for inline 6)";
		description = "";

		value = tHUF2USD(15);
		brand_new_prestige_value = 38.32;
		setMaxWear(kmToMaxWear(1000000.0));

		check4warnings();
	}
}
