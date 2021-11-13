package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Ford_Pick_Up_40_models extends Chassis
{
	static int	MODEL_PICK_UP_40		= 1;
	static int	MODEL_PICK_UP_CUSTOM_40	= 2;

	public Ford_Pick_Up_40_models( int id )
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
