package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Inset_FR_quarterpanel extends Quarterpanel
{
	public Inset_FR_quarterpanel( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Inset front right quarterpanel";
		description = "";
		brand_new_prestige_value = 42.49;

		value = tHUF2USD(12.366);
	}
}
