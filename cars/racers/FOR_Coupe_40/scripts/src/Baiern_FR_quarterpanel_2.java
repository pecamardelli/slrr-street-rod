package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Baiern_FR_quarterpanel_2 extends Quarterpanel
{
	public Baiern_FR_quarterpanel_2( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Baiern CoupeSport GT III front right quarterpanel";

		description = "The front right quarterpanel of the CoupeSport GT III. It is made of carbon fiber for weight reduction. It has street-legal space for tyres measuring 26.0 inch outer diameter and 13.0 inch width. Maximum sizes achievable may vary with modifying front track and rim offset.";

		value = tHUF2USD(623.785);
		brand_new_prestige_value = 70.0;
		setMaxWear(kmToMaxWear(500000.0));
	}
}
