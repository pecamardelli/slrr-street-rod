package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Chevrolet_Camaro_68_models extends Chassis
{
	static int	CHEVY_CAMARO_SS_VINYL_68	= 1;
	static int	CHEVY_CAMARO_RS_VINYL_68	= 2;
	static int	CHEVY_CAMARO_VINYL_68		= 3;
	static int	CHEVY_CAMARO_SS_68			= 4;
	static int	CHEVY_CAMARO_RS_68			= 5;
	static int	CHEVY_CAMARO_68				= 6;

	public Chevrolet_Camaro_68_models( int id )
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
