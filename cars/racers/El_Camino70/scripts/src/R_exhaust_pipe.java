package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.enginepart.*;


public class R_exhaust_pipe extends ExhaustPipe
{
	public R_exhaust_pipe( int id )
	{
		super( id );
		carCategory = PACKAGE;
		name = "Chevrolet El Camino right side exhaust pipe";

		description = "";

		value = tHUF2USD(32.120);
		brand_new_prestige_value = 62.00;
		setMaxWear(kmToMaxWear(500000.0));

		mufflerSlotIDList = new Vector();
		mufflerSlotIDList.addElement( new Integer(2) );
	}
}
