package java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart;

import java.render.osd.*;
import java.io.*;
import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.cars.*;
import java.game.parts.*;
import java.game.parts.bodypart.*;
import java.game.parts.enginepart.*;
import java.game.parts.enginepart.slidingenginepart.*;
import java.game.parts.enginepart.airfueldeliverysystem.*;
import java.game.parts.rgearpart.*;

public class CylinderHead extends ReciprocatingEnginePart
{
	final float diameter_difference = 2.5; // in milimeters //

	// actual //
	float	T_loss = 0.0;
	float	Vmin = 0.0;

	float	in_min = 0.0;
	float	out_min = 0.0;
	float	in_max = 0.0;
	float	out_max = 0.0;

	float	time_in_open = 0.0;
	float	time_in_close = 0.0;
	float	time_out_open = 0.0;
	float	time_out_close = 0.0;

	float	time_spark_min = 0.0;
	float	time_spark_inc = 0.0;
	float	time_spark_RPM0	= 0.0;
	float	time_spark_RPM1	= 0.0;

	float	intake_efficiency_tuning = 1.0;
	float	exhaust_efficiency_tuning = 1.0;

	int	intake_manifold_slot_ID = 0;
	int	exhaust_header_slot_ID = 0;
	int	camshaft_bearing_slot_ID = 0;
	int	cover_slot_ID = 0;

	// misc //
	float	cc_dome_safe_clearance = 0.0; // in milimeters //
	float	intake_tunnel_area = 0.0; // in square milimeters //
	float	exhaust_tunnel_area = 0.0; // in square milimeters //
	float	intake_valve_diam = 0.0; // in milimeters //
	float	number_of_intake_valves_per_cylinder = 0.0;
	float	exhaust_valve_diam = 0.0; // in milimeters //
	float	number_of_exhaust_valves_per_cylinder = 0.0;
	float	bore = 1.0;
	float	no_exhaust_police_fine = 150.0;

	float	def_intake_valve_diam = 0.0; // in milimeters //
	float	def_exhaust_valve_diam = 0.0; // in milimeters //

	int  	defaults_was_set = 0;

	public CylinderHead(){}

	public CylinderHead( int id )
	{
		super( id );

		name = "Cylinder head";

		prestige_calc_weight = 30.0;
	}

	public void updatevariables()
	{
		in_min = 0.0;
		in_max = 0.0;
		out_min = 0.0;
		out_max = 0.0;

		float w = 0.9+0.1*getWear();

		if (!getExhaustHeader())
			police_check_fine_value = no_exhaust_police_fine;
		else
			police_check_fine_value = 0;

		intake_tunnel_area = w*(intake_valve_diam*intake_valve_diam*0.25*0.01*3.1416*number_of_intake_valves_per_cylinder);
		exhaust_tunnel_area = w*(exhaust_valve_diam*exhaust_valve_diam*0.25*0.01*3.1416*number_of_exhaust_valves_per_cylinder);
	}

	public Part getIntakeManifold()
	{
		if (intake_manifold_slot_ID <= 0)
			return null;

		Part res = partOnSlot(intake_manifold_slot_ID);

		if (res && res instanceof IntakeManifold)
			return res;
//		else
//			System.log("!!!Intake manifold required on slot!!!");

		return null;
	}

	public Part getExhaustHeader()
	{
		if (exhaust_header_slot_ID <= 0)
			return null;

		Part res = partOnSlot(exhaust_header_slot_ID);

		if (res && res instanceof ExhaustHeader)
			return res;
//		else
//			System.log("!!!Exhaust header required on slot!!!");

		return null;
	}

	public Part getCamshaftBearing()
	{
		if (camshaft_bearing_slot_ID <= 0)
			return null;

		Part res = partOnSlot(camshaft_bearing_slot_ID);

		if (res && res instanceof SlidingEnginePart)
			return res;
//		else
//			System.log("!!!Camshaft bearing bridge required on slot!!!");

		return null;
	}

	public Part getCover()
	{
		if (cover_slot_ID <= 0)
			return null;

		Part res = partOnSlot(cover_slot_ID);

		return res;
	}

	public float getInertia()
	{
		return super.getInertia()*2.0; // the valves, springs, ... 2x because it rotates twice faster than the crankshaft //
	}

	public float getSlictionLoss()
	{
		float res = super.getSlictionLoss();
		SlidingEnginePart cam_bearing = getCamshaftBearing();

		if (cam_bearing)
			res *= cam_bearing.getSlictionLoss();

		return res;
	}

	public void fillDynoData( DynoData dd, int parentSlot )
	{
		dd.T_loss = T_loss;
		super.fillDynoData( dd, parentSlot );
	}

	public void check4warnings()
	{
/*		super.check4warnings();
		if (!intake_manifold_slot_ID)
			System.log("   intake_manifold_slot_ID is 0");
		if (!exhaust_header_slot_ID)
			System.log("   exhaust_header_slot_ID is 0");
		if (!camshaft_bearing_slot_ID)
			System.log("   camshaft_bearing_slot_ID is 0");
*/	}

	public String isDynoable()
	{
		Part p;

		p = getIntakeManifold();
		if (!p && intake_manifold_slot_ID)
			return "It's missing the intake.";

		p = getCamshaftBearing();
		if (!p && camshaft_bearing_slot_ID)
			return "It's missing the camshaft bearing bridge.";

		p = getCover();
		if (!p && cover_slot_ID)
			return "It's missing the cylinder head cover.";

		return super.isDynoable();
	}

	public void setupDefaults()
	{
		def_intake_valve_diam = intake_valve_diam;
		def_exhaust_valve_diam = exhaust_valve_diam;
		defaults_was_set = 1;
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
				intake_valve_diam = saveGame.readFloat();
				exhaust_valve_diam = saveGame.readFloat();
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
				saveGame.write( intake_valve_diam );
				saveGame.write( exhaust_valve_diam );
			}
		}
	}


	public int isTuneable()
	{
		return 1;
	}

	float	old_intake_valve_diam;
	float	old_exhaust_valve_diam;

	public void buildTuningMenu( Menu m )
	{
		if( !defaults_was_set ) setupDefaults();

		old_intake_valve_diam = intake_valve_diam;
		old_exhaust_valve_diam = exhaust_valve_diam;

		float addition = 0.0001;

		float min_intake_diam = def_intake_valve_diam;
		float max_intake_diam = def_intake_valve_diam + diameter_difference + addition;
		float min_exhaust_diam = def_exhaust_valve_diam;
		float max_exhaust_diam = def_exhaust_valve_diam + diameter_difference + addition;

		m.addItem( "Intake valve diameter", 1, intake_valve_diam, min_intake_diam, max_intake_diam, (max_intake_diam - min_intake_diam) * 10 + 1, null ).printValue( "   %1.1f mm" );
		m.addItem( "Exhaust valve diameter", 2, exhaust_valve_diam, min_exhaust_diam, max_exhaust_diam, (max_exhaust_diam - min_exhaust_diam) * 10 + 1, null ).printValue( "   %1.1f mm" );

		m.addItem( "Reset to factory defaults", 0 );
	}

	public void endTuningSession( int cancelled )
	{
		if( cancelled )
		{
			intake_valve_diam = old_intake_valve_diam;
			exhaust_valve_diam = old_exhaust_valve_diam;
		}
		else
		{
			if (old_intake_valve_diam != intake_valve_diam)
				GameLogic.spendTime(64*60);
			if (old_exhaust_valve_diam != exhaust_valve_diam)
				GameLogic.spendTime(64*60);

			getCar_LocalVersion();
			if (the_car)
				the_car.forceUpdate();
		}
	}

	public void handleMessage( Event m )
	{
		if( m.cmd == 0 )
		{
			intake_valve_diam = def_intake_valve_diam;
			m.gadget.osd.findGadget( this, 1 ).setValue( intake_valve_diam );
			exhaust_valve_diam = def_exhaust_valve_diam;
			m.gadget.osd.findGadget( this, 2 ).setValue( exhaust_valve_diam );
		}
		else
		if( m.cmd == 1 )
		{
			intake_valve_diam = ((Slider)m.gadget).value;
			((Slider)m.gadget).setValue( intake_valve_diam );
		}
		else
		if( m.cmd == 2 )
		{
			exhaust_valve_diam = ((Slider)m.gadget).value;
			((Slider)m.gadget).setValue( exhaust_valve_diam );
		}
	}
}
