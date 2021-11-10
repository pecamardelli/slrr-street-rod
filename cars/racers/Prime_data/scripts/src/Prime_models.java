package java.game.cars;

import java.io.*;
import java.util.*;
import java.util.resource.*;
import java.game.parts.*;
import java.game.parts.bodypart.*;

public class Prime_models extends Chassis
{
	static int	MODEL_DLH_500		= 1;

	public Prime_models( int id )
	{
		super( id );
		carCategory = PACKAGE;

		make = MAKE_PRIME;
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
