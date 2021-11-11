package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class R_Lip extends Quarterpanel
{
	public R_Lip( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "R Lip";
		description = "";
		brand_new_prestige_value = 42.49;

		value = tHUF2USD(28);
	}
}
