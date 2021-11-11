package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Lip extends Quarterpanel
{
	public Lip( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Lip paintable";
		description = "";
		brand_new_prestige_value = 42.49;

		value = tHUF2USD(22.366);
	}
}
