package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class MC_R_taillights extends Taillights
{
	public MC_R_taillights( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Chevrolet Chevelle right taillights";
		description = "";
		brand_new_prestige_value = 53.11;

		value = tHUF2USD(12);
	}
}
