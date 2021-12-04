package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;

public class Baiern_GT_III_cylinder_head_cover extends Part
{
	public Baiern_GT_III_cylinder_head_cover( int id )
	{
		super( id );
		name = "Baiern GT III cylinder head cover";
		description = "An ultra-light valve cover painted to blue with the Baiern Racer, Baiern Devils and 6SFi GT III logos in red. The material of this valve cover helps the head dissipate more heat then the standard head covers, thus extending lifetime of the engine.";

		value = tHUF2USD(45);
		brand_new_prestige_value = 191.60;
		setMaxWear(kmToMaxWear(2000000.0));

		check4warnings();
	}
}
