package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.enginepart.*;


public class Baiern_stock_exhaust_pipe extends ExhaustPipe
{
	public Baiern_stock_exhaust_pipe( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Ford Deluxe stock exhaust pipe";

		description = "The stock exhaust system for all DevilSport and CoupeSport models except for the GT III.";

		value = tHUF2USD(210.000);
		brand_new_prestige_value = 33.00;
		setMaxWear(kmToMaxWear(500000.0));

		mufflerSlotIDList = new Vector();
		mufflerSlotIDList.addElement( new Integer(2) );
		mufflerSlotIDList.addElement( new Integer(3) );
	}
}
