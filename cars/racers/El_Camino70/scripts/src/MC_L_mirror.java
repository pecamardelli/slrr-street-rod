package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class MC_L_mirror extends Mirror
{
	public MC_L_mirror( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Left mirror";
		description = "";
		brand_new_prestige_value = 53.11;

		value = tHUF2USD(14.473);
	}
}
