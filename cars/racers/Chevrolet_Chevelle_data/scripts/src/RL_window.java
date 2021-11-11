package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class RL_window extends Quarterpanel
{
	public RL_window( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "RL window";
		description = "";
		brand_new_prestige_value = 42.49;

		value = tHUF2USD(25);
	}
}
