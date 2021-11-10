package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;
import parts:part.root.BodyPart.*;


public class Baiern_FR_quarterpanel extends Quarterpanel
{
	public Baiern_FR_quarterpanel( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Baiern CoupeSport/DevilSport front right quarterpanel";

		description = "The stock front right quarterpanel of the DevilSports and CoupeSports except for the GT III. It has street-legal space for tyres measuring 24.0 inch outer diameter and 11.0 inch width. Maximum sizes achievable may vary with modifying front track, rim offset and steering lock.";

		value = tHUF2USD(188);
		brand_new_prestige_value = 32.50;
		setMaxWear(kmToMaxWear(300000.0));
	}
}
