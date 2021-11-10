package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Duhen_R_wing extends Wing
{
	public Duhen_R_wing( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Trunk sport wing";

		description = "";

		value = tHUF2USD(32.763);
		brand_new_prestige_value = 60.0;
		setMaxWear(kmToMaxWear(485000.0));
	}
}
