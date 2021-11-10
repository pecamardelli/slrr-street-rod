package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Duhen_RL_quarterpanel extends Quarterpanel
{
	public Duhen_RL_quarterpanel( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Rear left quarterpanel";

		description = "";

		value = tHUF2USD(131.860);
		brand_new_prestige_value = 28.09;
		setMaxWear(kmToMaxWear(285000));
	}
}
