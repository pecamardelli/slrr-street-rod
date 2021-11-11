package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Plymouth_Fury_69_models extends Chassis
{
	static int	PLYMOUTH_SPORT_FURY_69			= 1;
	static int	PLYMOUTH_SPORT_FURY_69_VINYL	= 2;

	public Plymouth_Fury_69_models( int id )
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
