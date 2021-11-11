package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class MC_FL_door extends FrontDoor
{
	public MC_FL_door( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Front left door";
		description = "";
		brand_new_prestige_value = 53.11;

		value = tHUF2USD(115.630);
	}
}
