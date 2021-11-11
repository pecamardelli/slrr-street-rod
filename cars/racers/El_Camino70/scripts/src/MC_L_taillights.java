package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class MC_L_taillights extends Taillights
{
	public MC_L_taillights( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Left taillights";
		description = "";
		brand_new_prestige_value = 53.11;

		value = tHUF2USD(9.579);
	}
}
