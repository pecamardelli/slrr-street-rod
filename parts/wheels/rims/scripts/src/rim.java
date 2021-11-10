package java.game.parts.wheels.rims;

import java.game.parts.rgearpart.reciprocatingrgearpart.*;

public class rim extends Wheel
{
	public rim( int id )
	{
		name = "Steelie 8.0x15 ET+25 rim";

		rim_type = rtFACTORY;
		SetupWheel( 15.0, 8.0, 0.0 );
	}
}
