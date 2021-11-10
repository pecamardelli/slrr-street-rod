package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Shimutshibu_models extends Chassis
{
	static int	MODEL_FOCER_RC_200	= 1;
	static int	MODEL_FOCER_RC_300	= 2;
	static int	MODEL_FOCER_WRC		= 3;

	public Shimutshibu_models( int id )
	{
		super( id );
		carCategory = PACKAGE;

		make = MAKE_SHIMUTSHIBU;
	}

	public void updatevariables()
	{
		super.updatevariables();

		ResourceRef ref = new ResourceRef(sound:0x00000015r);
		setHornSFX(ref, 1.0, 1);
		setHornSFX(ref, 1.0, 3);
		ref.set(0);
		setHornSFX(ref, 1.0, 2);
	}
}
