package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Wing extends Quarterpanel
{
	public Wing( int id )
	{
		super( id );
		carCategory = PACKAGE;

		name = "Rear wing";
		description = "The tuners are back. And they are wilder than ever! This quarter panel ensures street legality for your high powered dragracer MC. These wide panels give space for wheels up to 405mm wide!";

		value = tHUF2USD(42.366);
		brand_new_prestige_value = 42.49;
	}
}
