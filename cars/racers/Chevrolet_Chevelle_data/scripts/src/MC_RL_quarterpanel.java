package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class MC_RL_quarterpanel extends Quarterpanel
{
	public MC_RL_quarterpanel( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "MC rear left quarterpanel";
		description = "";
		brand_new_prestige_value = 42.49;

		value = tHUF2USD(65);
	}
}
