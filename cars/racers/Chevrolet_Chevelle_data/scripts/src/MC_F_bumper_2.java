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

		name = "MC GT B-series front bumper";
		description = "The stock front bumper found on the B-series first gen MC GT.";

		value = tHUF2USD(44.717);
		brand_new_prestige_value = 46.49;
	}
}
