package java.game.cars;

import java.game.parts.rgearpart.reciprocatingrgearpart.*;

public class stock_rim extends Wheel
{
	public stock_rim ( int id )
	{
		name = "Ford De Luxe stock rim 15x8";

		rim_type = rtFACTORY;
		SetupWheel( 15.0, 8.0, 20.0);
	}
}
