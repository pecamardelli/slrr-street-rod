package java.game.parts.enginepart.airfueldeliverysystem.charger;

import java.render.osd.*;
import java.io.*;
import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.cars.*;
import java.game.parts.*;
import java.game.parts.bodypart.*;
import java.game.parts.enginepart.*;
import java.game.parts.rgearpart.*;
import java.game.parts.enginepart.airfueldeliverysystem.*;

public class SuperCharger extends Charger
{
	final float diameter_difference_min = 10.0; // in milimeters //
	final float diameter_difference_max = 20.0; // in milimeters //

	float	pulley_diameter = 1.0; // in milimeters //
	float	pulley_width	= 1.0; // in milimeters //
	float	default_rpm_turbo_mul	= 1.0;

	float	def_pulley_diameter = 1.0;
	float	def_P_turbo_max = 1.0;

	int  	defaults_was_set = 0;

	public SuperCharger( int id )
	{
		super( id );

		name = "supercharger";
	}

	public void updatevariables()
	{
	}

	public float kmToMaxWear(float km)
	{
		if (rpm_turbo_mul>0.0)
			return super.kmToMaxWear(km)*(default_rpm_turbo_mul/rpm_turbo_mul)*(default_rpm_turbo_mul/rpm_turbo_mul);
		return super.kmToMaxWear(km);
	}

	public void fillDynoData( DynoData dd, int parentSlot )
	{
		updatevariables();

		super.fillDynoData(dd,parentSlot);

		dd.rpm_turbo_mul = rpm_turbo_mul;
		dd.rpm_turbo_opt = rpm_turbo_opt*rpm_turbo_mul*rpm_turbo_mul;
		dd.rpm_turbo_range = rpm_turbo_range*rpm_turbo_mul*rpm_turbo_mul;

		if (default_rpm_turbo_mul>0.0)
			dd.P_turbo_max = P_turbo_max*rpm_turbo_mul/default_rpm_turbo_mul;
		else
			dd.P_turbo_max = P_turbo_max;

		if (P_turbo_waste>0.0)
			dd.P_turbo_waste = P_turbo_waste;
		else
			dd.P_turbo_waste = dd.P_turbo_max;
	}

	public void setupDefaults()
	{
		def_pulley_diameter = pulley_diameter;
		def_P_turbo_max = P_turbo_max;
		defaults_was_set = 1;
	}

	public void recalcStuffs()
	{
		P_turbo_max = def_P_turbo_max * ( def_pulley_diameter / pulley_diameter );
	}

	public void load( File saveGame )
	{
		super.load( saveGame );

		if( !defaults_was_set ) setupDefaults();

		if (save_version >= SAVEFILEVERSION_PART)
		{
			int	save_ver = saveGame.readInt();

			if (save_ver >= 1)
			{
				pulley_diameter = saveGame.readFloat();
				recalcStuffs();
			}
		}
	}

	public void save( File saveGame )
	{
		super.save( saveGame );

		if (save_version >= SAVEFILEVERSION_PART)
		{
			int	save_ver = 2;
			saveGame.write( save_ver );

			if (save_ver >= 1)
			{
				saveGame.write( pulley_diameter );
			}
		}
	}


	public int isTuneable()
	{
		return 1;
	}

	float old_pulley_diameter;

	public void buildTuningMenu( Menu m )
	{
		if( !defaults_was_set ) setupDefaults();

		old_pulley_diameter = pulley_diameter;

		float min_diameter = def_pulley_diameter - diameter_difference_min;
		float max_diameter = def_pulley_diameter + diameter_difference_max;
		if( pulley_diameter < diameter_difference_min ) min_diameter = pulley_diameter;
		m.addItem( "Pulley diameter", 1, pulley_diameter, min_diameter, max_diameter, max_diameter - min_diameter + 1, null ).printValue( "   %1.0f mm" );

		m.addItem( "Reset to factory defaults", 0 );
	}

	public void endTuningSession( int cancelled )
	{
		if( cancelled )
		{
			pulley_diameter = old_pulley_diameter;
			recalcStuffs();
		}
		else
		{
			recalcStuffs();

			getCar_LocalVersion();
			if (the_car)
				the_car.forceUpdate();
		}
	}

	public void handleMessage( Event m )
	{
		if( m.cmd == 0 )
		{
			pulley_diameter = def_pulley_diameter;
			m.gadget.osd.findGadget( this, 1 ).setValue( pulley_diameter );
		}
		else
		if( m.cmd == 1 )
		{
			pulley_diameter = ((Slider)m.gadget).value;
			((Slider)m.gadget).setValue( pulley_diameter );
		}
	}
}
