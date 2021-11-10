package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Duhen_FR_quarterpanel extends Quarterpanel
{
	public Duhen_FR_quarterpanel( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Antena down";

		description = "";

		value = tHUF2USD(131.860);
		brand_new_prestige_value = 28.09;
		setMaxWear(kmToMaxWear(285000));
	}
}
