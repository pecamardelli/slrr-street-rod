package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;

public class Emer_MotorSport_GT2_cylinder_head_cover extends Part
{
	public Emer_MotorSport_GT2_cylinder_head_cover( int id )
	{
		super( id );
		name = "Emer MotorSport Nonus GT2 cylinder head cover";
		description = "A bronze valve cover painted to black with the Emer Nonus GT2 logo.";

		value = tHUF2USD(40.872);
		brand_new_prestige_value = 114.96;
		setMaxWear(kmToMaxWear(1000000.0));

		check4warnings();
	}
}
