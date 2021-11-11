package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.enginepart.*;


public class MC_stock_R_exhaust_pipe extends ExhaustPipe
{
	public MC_stock_R_exhaust_pipe( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Chevrolet El Camino stock right exhaust pipe";

		description = "The stock right side exhaust system for the MC GT and GTB.";

		value = tHUF2USD(32.120);
		brand_new_prestige_value = 62.00;
		setMaxWear(kmToMaxWear(500000.0));

		mufflerSlotIDList = new Vector();
		mufflerSlotIDList.addElement( new Integer(2) );
	}
}
