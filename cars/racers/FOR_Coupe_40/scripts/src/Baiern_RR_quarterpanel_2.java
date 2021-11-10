package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Baiern_RR_quarterpanel_2 extends Quarterpanel
{
	public Baiern_RR_quarterpanel_2( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Baiern CoupeSport GT III rear right quarterpanel";

		description = "The rear right quarterpanel of the CoupeSport GT III. It is made of carbon fiber for weight reduction. It has street-legal space for tyres measuring 24.0 inch outer diameter and 15.5 inch width. Maximum sizes achievable may vary with modifying rear track and rim offset.";

		value = tHUF2USD(668.341);
		brand_new_prestige_value = 70.0;
		setMaxWear(kmToMaxWear(500000.0));
	}
}
