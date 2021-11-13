package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Chevrolet_Impala_SS_67_models extends Chassis
{
	static int	CHEVROLET_IMPALA_SS_67		= 1;

	public Chevrolet_Impala_SS_67_models( int id )
	{
		super( id );
		carCategory = PACKAGE;

		make = MAKE_CUSTOM;
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
