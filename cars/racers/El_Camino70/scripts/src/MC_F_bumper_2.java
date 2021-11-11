package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class MC_F_bumper_2 extends Bumper
{
	public MC_F_bumper_2( int id )
	{
		super( id );
		carCategory = PACKAGE;

		name = "Front bumper stock with orange indicators";
		description = "";

		value = tHUF2USD(44.717);
		brand_new_prestige_value = 46.49;
	}
}
