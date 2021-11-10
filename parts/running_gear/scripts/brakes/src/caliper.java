package java.game.parts.running_gear.brakes;

import java.game.parts.*;

public class caliper extends Part
{
	public caliper( int id )
	{
		super( id );
		carCategory = COMMON;
		name = "Universal Paintable Caliper";
		description = "";
		brand_new_prestige_value = 42.49;

		value = tHUF2USD(35.579);
	}
}
