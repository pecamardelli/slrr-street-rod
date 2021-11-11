package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class RL_inset extends Quarterpanel
{
	public RL_inset( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "RL inset";
		description = "";
		brand_new_prestige_value = 42.49;

		value = tHUF2USD(15);
	}
}
