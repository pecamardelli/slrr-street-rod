package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;

public class Baiern_Devils_6SFi_cylinder_head_cover extends Part
{
	public Baiern_Devils_6SFi_cylinder_head_cover( int id )
	{
		super( id );
		name = "Baiern Devils 6SFi cylinder head cover";
		description = "A light alloy valve cover painted to black with the Baiern Devils and 6SFi logos in red.";

		value = tHUF2USD(15);
		brand_new_prestige_value = 76.64;
		setMaxWear(kmToMaxWear(1000000.0));

		check4warnings();
	}
}
