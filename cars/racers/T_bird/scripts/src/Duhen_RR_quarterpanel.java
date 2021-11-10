package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Duhen_RR_quarterpanel extends Quarterpanel
{
	public Duhen_RR_quarterpanel( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "DRear right quarterpanel";

		description = "";

		value = tHUF2USD(131.860);
		brand_new_prestige_value = 28.09;
		setMaxWear(kmToMaxWear(285000));
	}
}
