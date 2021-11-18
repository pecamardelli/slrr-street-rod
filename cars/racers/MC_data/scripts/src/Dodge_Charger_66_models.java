package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.parts.bodypart.*;


public class Dodge_Charger_66_models extends Chassis
{
	static int	DODGE_CHARGER_66			= 1;
	static int	DODGE_CHARGER_440_66		= 2;
	static int	DODGE_CHARGER_HEMI_66		= 3;

	public Dodge_Charger_66_models( int id )
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
