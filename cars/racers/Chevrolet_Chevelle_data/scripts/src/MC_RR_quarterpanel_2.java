package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class MC_RR_quarterpanel_2 extends Quarterpanel
{
	public MC_RR_quarterpanel_2( int id )
	{
		super( id );
		carCategory = PACKAGE;

		name = "SL Tuners MC DraggStarr rear right quarterpanel";
		description = "The tuners are back. And they are wilder than ever! This quarter panel ensures street legality for your high powered dragracer MC. These wide panels give space for wheels up to 405mm wide!";

		value = tHUF2USD(65);
		brand_new_prestige_value = 42.49;
	}
}
