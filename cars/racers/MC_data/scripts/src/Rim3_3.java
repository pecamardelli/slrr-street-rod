package java.game.cars;

import java.game.parts.rgearpart.reciprocatingrgearpart.*;

public class Rim3_3 extends Wheel
{
	public Rim3_3 ( int id )
	{
		name = "WELD Racing 10 Spoke 15.0x15 rim";

		rim_type = rtFACTORY;
		SetupWheel( 15.0, 15.0, 0.0);
		value = tHUF2USD(54.999);
	}
}
