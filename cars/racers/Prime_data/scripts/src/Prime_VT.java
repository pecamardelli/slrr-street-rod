package java.game.cars;

import java.game.*;

public class Prime_VT extends VehicleType
{
	public Prime_VT( int id )
	{
		VehicleModel vmd;

		prevalence = 0.0;

		// make color indexes //
		addColorIndex(GameLogic.RID_CARCOLOR_Einvagen_Reflex);

//		prevalence *= 1000.0;
	}
}
