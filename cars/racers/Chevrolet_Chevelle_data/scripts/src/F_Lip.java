package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class F_Lip extends Quarterpanel
{
	public F_Lip( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "F Lip";
		description = "";
		brand_new_prestige_value = 42.49;

		value = tHUF2USD(22.366);
	}
}
