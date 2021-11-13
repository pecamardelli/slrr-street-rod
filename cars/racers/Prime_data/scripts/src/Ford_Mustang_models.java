package java.game.cars;

import java.io.*;
import java.util.*;
import java.util.resource.*;
import java.game.parts.*;
import java.game.parts.bodypart.*;

public class Ford_Mustang_models extends Chassis
{
	static int	FORD_MUSTANG_FASTBACK_68		= 1;
	static int	SHELBY_GT500_68					= 2;

	public Ford_Mustang_models( int id )
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
