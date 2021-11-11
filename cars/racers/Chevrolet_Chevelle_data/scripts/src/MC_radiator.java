package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.enginepart.*;

public class MC_radiator extends Radiator
{
	public MC_radiator( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "MC radiator";
		description = "";
		brand_new_prestige_value = 53.11;

		value = tHUF2USD(78);
	}
}
