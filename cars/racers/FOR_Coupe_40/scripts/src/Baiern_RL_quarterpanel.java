package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Baiern_RL_quarterpanel extends Quarterpanel
{
	public Baiern_RL_quarterpanel( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Baiern CoupeSport/DevilSport rear left quarterpanel";

		description = "The stock rear left quarterpanel of the DevilSports and CoupeSports except for the GT III. It has street-legal space for tyres measuring 24.0 inch outer diameter and 13.5 inch width. Maximum sizes achievable may vary with modifying rear track and rim offset.";

		value = tHUF2USD(210);
		brand_new_prestige_value = 32.50;
		setMaxWear(kmToMaxWear(200000.0));
	}
}
