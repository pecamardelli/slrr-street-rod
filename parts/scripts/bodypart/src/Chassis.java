package java.game.parts.bodypart;

import java.io.*;
import java.util.*;
import java.util.resource.*;
import java.render.osd.*;
import java.game.*;
import java.game.cars.*;
import java.game.parts.*;
import java.game.parts.enginepart.*;
import java.game.parts.rgearpart.*;
import java.game.parts.rgearpart.reciprocatingrgearpart.*;
import java.game.parts.enginepart.airfueldeliverysystem.*;

public class Chassis extends BodyPart
{
	//own vars
	float	max_steer = 0.7;

	//vars from engine block
	float	engine_torque = 0.0;
	float	engine_torque2 = 0.0;
//	float[]	torquetable = new float[16];
//	float[]	torquetable2 = new float[16];
//	float	table_stepsize = 500;	//torquetable stepsize
	float	engine_inertia = 10.0;
	float	maxRPM = 7000.0;
	float	RPM_limit = 20000.0;
	float	engine_friction_fwd = 0.0001;
	float	engine_friction_rev = 0.005;
	float	engine_mass = 40.0;
	float	engine_rpm_idle = 800.0;
	float	starter_torque = 0;
	float	fully_stripped_drag = 0.333;

	static int	MAKE_CUSTOM		= 0;
	static int	MAKE_BAIERN		= 1;
	static int	MAKE_DUHEN		= 2;
	static int	MAKE_EINVAGEN		= 3;
	static int	MAKE_ISHIMA		= 4;
	static int	MAKE_SHIMUTSHIBU	= 5;
	static int	MAKE_MC			= 6;
	static int	MAKE_EMER		= 7;
	static int	MAKE_HAULER_S_HEAVEN	= 8;
	static int	MAKE_PRIME		= 9;

	static int	MODEL_UNDEFINED		= -1;

	int	make = MAKE_CUSTOM;
	int	model = MODEL_UNDEFINED;

	final static int	DT_FWD = 1;
	final static int	DT_RWD = 2;
	int	drive_type;

	float	brake_balance = 0.5;
	int	brake_balance_can_be_set = 0;

	Vector	exhaustSlotIDList = null;
	
	Vector	PneumaticSA;

	float	diff_lock = 0.0;

	//vars from transmission
	int		gears = 0;
	float[]	ratio = new float[8];
	float	rearend_ratio = 3.3;

	float	ClutchF = 500.0;

	float	tank_nitro = 0.0;
	float	consumption_nitro = 0.0;

	//vars from wheels,brakes,suspensions
	int		wheels = 4;
	int		front_wheels = 2;
	int		uncommon_RG = 0;

	String	vehicleName = "unnamed";
	String	makerName = "unnamed";

	//vars calculated from body parts
	Vector3	wing_dir;		//fwd. dir. of wing profile
	Vector3	wing_F;			//pos and size of lift

//	int carID = Car.COMMON;

//	int		SFX_engine_up	=sound:0x00000003r;
//	int		SFX_engine_down	=sound:0x00000002r;
//	int		SFX_engine_idle	=sound:0x00000001r;
	int		SFX_trans_fwd	=sound:0x00000007r;
	int		SFX_trans_rev	=sound:0x00000009r;
	int		SFX_ignition	=sound:0x0000000Ar;
//	int		SFX_horn	=sound:0x00000015r;

//	float	rpm_engine_up	= 5000.0;
//	float	rpm_engine_down	= 2500.0;
//	float	rpm_engine_idle	=  700.0;
	float	rpm_trans_fwd	= 1400.0;
	float	rpm_trans_rev	= 1400.0;
	float	sfx_starter_rpm	=  200.0;
//	float	sfx_horn_pitch	=    1.0;

	int	suspend_update = 0;

	int[]	stock_parts_list_E  = null;
	int[]	stg_1_parts_list_E  = null;
	int[]	stg_2_parts_list_E  = null;
	int[]	parts_list_E  = null;

	float	stg_1_engne_kit_limit = 1.33333333;
	float	stg_2_engne_kit_limit = 1.66666666;

	int[]	stock_parts_list_FL = null;
	int[]	stock_parts_list_FR = null;
	int[]	stock_parts_list_RL = null;
	int[]	stock_parts_list_RR = null;
	int[]	stock_parts_list_F  = null;
	int[]	stock_parts_list_Rr = null;
	int[]	stock_parts_list_L  = null;
	int[]	stock_parts_list_R  = null;
	int[]	stock_parts_list_T  = null;

	int[]	stg_1_parts_list_FL = null;
	int[]	stg_1_parts_list_FR = null;
	int[]	stg_1_parts_list_RL = null;
	int[]	stg_1_parts_list_RR = null;
	int[]	stg_1_parts_list_F  = null;
	int[]	stg_1_parts_list_Rr = null;
	int[]	stg_1_parts_list_L  = null;
	int[]	stg_1_parts_list_R  = null;
	int[]	stg_1_parts_list_T  = null;

	int[]	stg_2_parts_list_FL = null;
	int[]	stg_2_parts_list_FR = null;
	int[]	stg_2_parts_list_RL = null;
	int[]	stg_2_parts_list_RR = null;
	int[]	stg_2_parts_list_F  = null;
	int[]	stg_2_parts_list_Rr = null;
	int[]	stg_2_parts_list_L  = null;
	int[]	stg_2_parts_list_R  = null;
	int[]	stg_2_parts_list_T  = null;

	int[]	parts_list_FL = null;
	int[]	parts_list_FR = null;
	int[]	parts_list_RL = null;
	int[]	parts_list_RR = null;
	int[]	parts_list_F  = null;
	int[]	parts_list_Rr = null;
	int[]	parts_list_L  = null;
	int[]	parts_list_R  = null;
	int[]	parts_list_T  = null;

	float	stg_1_body_kit_limit = 1.33333333;
	float	stg_2_body_kit_limit = 1.66666666;

	int[]	stock_parts_list_RGear_suspensions = null;
	int[]	stock_parts_list_RGear_shocks = null;
	int[]	stock_parts_list_RGear_springs = null;
	int[]	stock_parts_list_RGear_brakes = null;
	int[]	stock_parts_list_RGear_sways = null;
	int[]	stock_parts_list_RGear_wheels = null;
	int[]	stock_parts_list_RGear_tyres = null;
	int[]	stock_parts_list_RGear_others = null;

	int[]	stg_1_parts_list_RGear_suspensions = null;
	int[]	stg_1_parts_list_RGear_shocks = null;
	int[]	stg_1_parts_list_RGear_springs = null;
	int[]	stg_1_parts_list_RGear_brakes = null;
	int[]	stg_1_parts_list_RGear_sways = null;
	int[]	stg_1_parts_list_RGear_wheels = null;
	int[]	stg_1_parts_list_RGear_tyres = null;
	int[]	stg_1_parts_list_RGear_others = null;

	int[]	stg_2_parts_list_RGear_suspensions = null;
	int[]	stg_2_parts_list_RGear_shocks = null;
	int[]	stg_2_parts_list_RGear_springs = null;
	int[]	stg_2_parts_list_RGear_brakes = null;
	int[]	stg_2_parts_list_RGear_sways = null;
	int[]	stg_2_parts_list_RGear_wheels = null;
	int[]	stg_2_parts_list_RGear_tyres = null;
	int[]	stg_2_parts_list_RGear_others = null;

	int[]	parts_list_RGear_suspensions = null;
	int[]	parts_list_RGear_shocks = null;
	int[]	parts_list_RGear_springs = null;
	int[]	parts_list_RGear_brakes = null;
	int[]	parts_list_RGear_sways = null;
	int[]	parts_list_RGear_wheels = null;
	int[]	parts_list_RGear_tyres = null;
	int[]	parts_list_RGear_others = null;

	float	stg_1_rgear_kit_limit = 1.33333333;
	float	stg_2_rgear_kit_limit = 1.66666666;

	int[]	parts_list  = null;

	public Chassis( int id )
	{
		super( id );

		name = "chassis";

		C_drag = 0.32;
		drag_center = new Vector3(0,0,0);
		suspend_update = 0;

		prestige_calc_weight = 90.0;

		PneumaticSA = new Vector(1);// New colector, put 1 empty object to it
	}

	public void finalize()
	{
		clearEventMask( EVENT_ANY );
		removeAllTimers();
		unregisterCallbacks();
	}

	public void save( File saveGame )
	{
		super.save( saveGame );

		int save_ver = 3;

		saveGame.write(save_ver);

		if (save_ver >= 1)
		{
			saveGame.write( wheels );
			int Wcounter = wheels;
			while( Wcounter-- )
			{
				saveGame.write( getWheelDamage( Wcounter ));
			}
		}
		if (save_ver >= 2)
		{
			saveGame.write( brake_balance );
		}
		if (save_ver >= 3)
		{
			float m = getMileage();
			saveGame.write( m );
		}
	}


	public void load( File saveGame )
	{
		suspend_update=1;

		super.load( saveGame );

		int save_ver = saveGame.readInt();

		if (save_ver >= 1)
		{
			wheels = saveGame.readInt();
			int Wcounter = wheels;
			while( Wcounter -- )
			{
				setWheelDamage( Wcounter, saveGame.readString() );
			}
		}
		if (save_ver >= 2)
		{
			brake_balance = saveGame.readFloat();
		}
		if (save_ver >= 3)
		{
			float m = saveGame.readFloat();
			setMileage ( m );
		}

		suspend_update=0;
		forceUpdate();
	}

	public void Hsuspension( int action, int type )
	{
		for( int i=0; i<=PneumaticSA.size()-1; i++ )
		{
			if( PneumaticSA.elementData[i] && PneumaticSA.elementData[i] instanceof Pneumatic_ShockAbsorber )
			{
				PneumaticSA.elementData[i].Use( action, type );
			}
		}
	}

	public float calcPoliceFine( float thoroughness )
	{
		float fine = super.calcPoliceFine(thoroughness);

		for( int i=attachedParts.size()-1; i>=0; i-- )
		{
			fine += attachedParts.elementAt(i).calcPoliceFine(thoroughness);
		}

		return fine;
	}

	public void updatevariables()
	{
		C_drag = fully_stripped_drag;
		diff_lock = 0.0;
		updateDifflock();

		WheelRef whl;

		drive_type = 0;
		int i;
		int j;
		for (i=0; i<wheels; i++)
		{
			whl = getWheel(i);
			if (whl)
			{
				whl.setDrive(0.0);
				whl.setInstantCenter( 10000.0, 10000.0, 10000.0, 10000.0, 10000.0, 10000.0 );
			}
		}
	
		super.updatevariables();

		// collect chassis specific police fine values //

		police_check_fine_value = 0;
		if (exhaustSlotIDList)
			for (i=0; i<exhaustSlotIDList.size(); i++)
			{
				Part p = partOnSlot(exhaustSlotIDList.elementAt(i).intValue());
				if (!p || !(p instanceof ExhaustPipe))
					police_check_fine_value += 200;
				else
				{
					ExhaustPipe ep = (ExhaustPipe)p;
					ep.police_check_fine_value = 0;
					if (ep.mufflerSlotIDList)
					for (j=0; j<ep.mufflerSlotIDList.size(); j++)
					{
						Part m = ep.partOnSlot(ep.mufflerSlotIDList.elementAt(j).intValue());
						if (!m || !(m instanceof ExhaustTip))
							ep.police_check_fine_value += 100;
					}
				}
			}

		RPM_limit = 12000.0;

		Part other;

		if( uncommon_RG == 0 ) // Running gear updating, installing order
		{
			if( Config.swaybarsMode == 1 )
			{
				other = partOnSlot(701);
				if(other && other instanceof Swaybar) {
					other.updatevariables();
				}
				else {
					queueEvent( null, EVENT_COMMAND, "add_rollbar 0 1 0 0" );
					queueEvent( null, EVENT_COMMAND, "rem_rollbar 0 1 0 0" );
				}
				other = partOnSlot(702);
				if(other && other instanceof Swaybar) {
					other.updatevariables();
				}
				else {
					queueEvent( null, EVENT_COMMAND, "add_rollbar 2 3 0 0" );
					queueEvent( null, EVENT_COMMAND, "rem_rollbar 2 3 0 0" );
				}
			}
			else
			if( Config.swaybarsMode == 2 )
			{
				// Settings by BenyUK
				queueEvent( null, EVENT_COMMAND, "add_rollbar 0 1 1500 1950" );
				queueEvent( null, EVENT_COMMAND, "add_rollbar 2 3 1500 1950" );
			}

			int[] has = new int[5];

			for(int i=0; i<wheels; i++)
			{
				has[0] = 0;
				has[1] = 0;
				has[2] = 0;
				has[3] = 0;
				has[4] = 0;

				WheelRef	whl = getWheel(i);

				other = partOnSlot(111+i);
				if (other && other instanceof Brake)
				{
					other.updatevariables();
					has[1] = 1;
				}

				other = partOnSlot(101+i);
				if (other && other instanceof Wheel)
				{
					other.updatevariables();
					has[2] = 1;
				}

				other = partOnSlot(311+i);
				if (other && other instanceof Spring)
				{
					other.updatevariables();
					has[4] = 1;
				}

				other = partOnSlot(301+i);
				if (other && other instanceof ShockAbsorber || other && other instanceof Pneumatic_ShockAbsorber)
				{
					other.updatevariables();
					has[3] = 1;
				}

				other = partOnSlot(121+i);
				if (other && other instanceof Suspension)
				{
					has[0] = 1;
					other.updatevariables();
				}

				// 0-suspension, 1-brake, 2-rim, 3-shock, 4-spring //
				if (has[2]) // the rim is put on, so the rim and the tyre can be changed //
				{
					// enable these //
					disableSlot(101+i,0); // rim

					// disable these //
					disableSlot(111+i,1); // brake
					disableSlot(311+i,1); // spring
					disableSlot(301+i,1); // shock
					disableSlot(121+i,1); // suspension
				}
				else
				if (has[1]) // the brake is put on, so the rim and the brake can be changed //
				{
					// enable these //
					disableSlot(101+i,0); // rim
					disableSlot(111+i,0); // brake

					// disable these //
					disableSlot(311+i,1); // spring
					disableSlot(301+i,1); // shock
					disableSlot(121+i,1); // suspension
				}
				else
				if (has[4]) // the spring is put on, so the spring and the shock can be changed //
				{
					// disable these //
					disableSlot(101+i,1); // rim

					// enable these //
					disableSlot(111+i,0); // brake
					disableSlot(311+i,0); // spring

					// disable these //
					disableSlot(301+i,1); // shock
					disableSlot(121+i,1); // suspension
				}
				else
				if (has[3]) // the shock is put on, so the shock and the spring can be changed //
				{
					// disable these //
					disableSlot(101+i,1); // rim
					disableSlot(111+i,1); // brake

					// enable these //
					disableSlot(311+i,0); // spring
					disableSlot(301+i,0); // shock

					// disable these //
					disableSlot(121+i,1); // suspension
				}
				else
				if (has[0]) // the suspension is put on, so the shock and the suspension can be changed //
				{
					// disable these //
					disableSlot(101+i,1); // rim
					disableSlot(111+i,1); // brake
					disableSlot(311+i,1); // spring

					// enable these //
					disableSlot(301+i,0); // shock
					disableSlot(121+i,0); // suspension
				}
				else
				{
					// disable these //
					disableSlot(101+i,1); // rim
					disableSlot(111+i,1); // brake
					disableSlot(311+i,1); // spring
					disableSlot(301+i,1); // shock

					// enable these //
					disableSlot(121+i,0); // suspension
				}
			}
		}

//		System.log("--- end of wheel updates ---");

		Part part = null;
		Block engine = null;

		int slotIndex;
		int slotID;
		int slots = getSlots();

		for( slotIndex=0; slotIndex<slots; slotIndex++ )
		{
			slotID = getSlotID( slotIndex );
			part = partOnSlot(slotID);

			if (part)
			{
				if (part instanceof Block)
				{
					engine = part;
				}
				if (part instanceof BodyPart)
				{
					BodyPart p = (BodyPart)part;
					C_drag -= p.drag_reduction;
				}
			}
		}

		if (C_drag < 0.0)
			C_drag = 0.0;

		if (engine)
		{
			engine.updatevariables();	// calc. dynodata

//			SFX_trans_fwd = engine.SFX_trans_fwd;
//			SFX_trans_rev = engine.SFX_trans_rev;
//			SFX_ignition = engine.SFX_ignition;

//			rpm_trans_fwd = engine.rpm_trans_fwd;
//			rpm_trans_rev = engine.rpm_trans_rev;
//	       		sfx_starter_rpm = engine.sfx_starter_rpm;

			DynoData dyno = engine.dynodata;

			int RPMstep = 250;

			RPM_limit = dyno.RPM_limit;
			if (dyno.maxRPM < 100)
				dyno.maxRPM = dyno.RPM_limit*1.25;
			int desired_steps = dyno.maxRPM/RPMstep;
			dyno.maxRPM = desired_steps*RPMstep;
			dyno.calcDyno ( desired_steps );
//			dyno.LogVars();

			engine_torque = dyno.torque;
			engine_torque2 = dyno.torque2;
			maxRPM = dyno.maxRPM;

			engine_inertia = engine.inertia;
			engine_friction_fwd = engine.friction_fwd;
			engine_friction_rev = engine.friction_rev;
			engine_rpm_idle = engine.rpm_idle;

			consumption_nitro = dyno.nitro_consumption;
		} else
		{
			engine_torque = 0.0f;
			engine_torque2 = 0.0f;
			engine_inertia = 10.0f;
			maxRPM = 7000.0;
			engine_friction_fwd = 0.0001;
			engine_friction_rev = 0.005;
			starter_torque = 0;

			gears = 0;
			ratio[0] = 0.0;
			ratio[1] = 3.5;
			ratio[2] = 2.7;
			ratio[3] = 1.9;
			ratio[4] = 1.3;
			ratio[5] = 0.0;
			ratio[6] = 0.0;
			ratio[7] = -4.0;
		}

//		System.log("chassis: engine_inertia = "+engine_inertia);
//		System.log("chassis: engine_friction_fwd = "+engine_friction_fwd);
//		System.log("chassis: engine_friction_rev = "+engine_friction_rev);

		other = partOnSlot(999); // steering wheel //
		if (other)
		{
			other.updatevariables();
		}

		tank_nitro = 0.0;
		for(int i=500; i<520; i++)
		{
			other = partOnSlot(i); // nitro tanks //
			if (other && other instanceof Canister)
			{
				other.updatevariables();
				tank_nitro += ((Canister)other).capacity;
			}
		}
	}

	//for used car generator: creates parts for 'required' slots, sets default color (from a set)
	public void addStockParts()
	{
		addStockParts( GameLogic.CARCOLORS[0], 2.0*Math.random(), 2.0*Math.random() );
	}

	public void addStockParts( Descriptor desc )
	{
//		super.addStockParts( desc );

		int TextureID = desc.color;
		setTexture( TextureID );

/////////////////////// ToDo: Descriptor.power should be completeness_level ///////////////////////
///////////////////////// ToDo: Descriptor.optical should be tuning_level /////////////////////////

		int crash_count = (1-desc.tear) * 10;//crash_times * 10; // * desc.crash_count_override; //

		int part_looper;
		float CRASH_BADNESS_DAMPING = 0.79432823472428150206591828283639; // drops to 0.1 in five steps == inv 0.1^5//

		parts_list_E  = stock_parts_list_E;
		parts_list_FL = stock_parts_list_FL;
		parts_list_FR = stock_parts_list_FR;
		parts_list_RL = stock_parts_list_RL;
		parts_list_RR = stock_parts_list_RR;
		parts_list_F  = stock_parts_list_F;
		parts_list_Rr = stock_parts_list_Rr;
		parts_list_L  = stock_parts_list_L;
		parts_list_R  = stock_parts_list_R;
		parts_list_T  = stock_parts_list_T;

		if (desc.power >= stg_2_engne_kit_limit)
		{
			if (stg_2_parts_list_E)  parts_list_E  = stg_2_parts_list_E;
		}
		else
		if (desc.power >= stg_1_engne_kit_limit)
		{
			if (stg_1_parts_list_E)  parts_list_E  = stg_1_parts_list_E;
		}

		if (desc.optical >= stg_2_body_kit_limit)
		{
			if (stg_2_parts_list_FL) parts_list_FL = stg_2_parts_list_FL;
			if (stg_2_parts_list_FR) parts_list_FR = stg_2_parts_list_FR;
			if (stg_2_parts_list_RL) parts_list_RL = stg_2_parts_list_RL;
			if (stg_2_parts_list_RR) parts_list_RR = stg_2_parts_list_RR;
			if (stg_2_parts_list_F)  parts_list_F  = stg_2_parts_list_F;
			if (stg_2_parts_list_Rr) parts_list_Rr = stg_2_parts_list_Rr;
			if (stg_2_parts_list_L)  parts_list_L  = stg_2_parts_list_L;
			if (stg_2_parts_list_R)  parts_list_R  = stg_2_parts_list_R;
			if (stg_2_parts_list_T)  parts_list_T  = stg_2_parts_list_T;
		}
		else
		if (desc.optical >= stg_1_body_kit_limit)
		{
			if (stg_1_parts_list_FL) parts_list_FL = stg_1_parts_list_FL;
			if (stg_1_parts_list_FR) parts_list_FR = stg_1_parts_list_FR;
			if (stg_1_parts_list_RL) parts_list_RL = stg_1_parts_list_RL;
			if (stg_1_parts_list_RR) parts_list_RR = stg_1_parts_list_RR;
			if (stg_1_parts_list_F)  parts_list_F  = stg_1_parts_list_F;
			if (stg_1_parts_list_Rr) parts_list_Rr = stg_1_parts_list_Rr;
			if (stg_1_parts_list_L)  parts_list_L  = stg_1_parts_list_L;
			if (stg_1_parts_list_R)  parts_list_R  = stg_1_parts_list_R;
			if (stg_1_parts_list_T)  parts_list_T  = stg_1_parts_list_T;
		}

		parts_list_RGear_suspensions = stock_parts_list_RGear_suspensions;
		parts_list_RGear_shocks = stock_parts_list_RGear_shocks;
		parts_list_RGear_springs = stock_parts_list_RGear_springs;
		parts_list_RGear_brakes = stock_parts_list_RGear_brakes;
		parts_list_RGear_sways = stock_parts_list_RGear_sways;
		parts_list_RGear_wheels = stock_parts_list_RGear_wheels;
		parts_list_RGear_tyres = stock_parts_list_RGear_tyres;
		parts_list_RGear_others = stock_parts_list_RGear_others;

		if (desc.power >= stg_2_rgear_kit_limit)
		{
			if (stg_2_parts_list_RGear_suspensions)  parts_list_RGear_suspensions  = stg_2_parts_list_RGear_suspensions;
			if (stg_2_parts_list_RGear_shocks)       parts_list_RGear_shocks       = stg_2_parts_list_RGear_shocks;
			if (stg_2_parts_list_RGear_springs)      parts_list_RGear_springs      = stg_2_parts_list_RGear_springs;
			if (stg_2_parts_list_RGear_brakes)       parts_list_RGear_brakes       = stg_2_parts_list_RGear_brakes;
			if (stg_2_parts_list_RGear_sways)        parts_list_RGear_sways        = stg_2_parts_list_RGear_sways;
			if (stg_2_parts_list_RGear_wheels)       parts_list_RGear_wheels       = stg_2_parts_list_RGear_wheels;
			if (stg_2_parts_list_RGear_tyres)        parts_list_RGear_tyres        = stg_2_parts_list_RGear_tyres;
			if (stg_2_parts_list_RGear_others)       parts_list_RGear_others       = stg_2_parts_list_RGear_others;
		}
		else
		if (desc.power >= stg_1_rgear_kit_limit)
		{
			if (stg_1_parts_list_RGear_suspensions)  parts_list_RGear_suspensions  = stg_1_parts_list_RGear_suspensions;
			if (stg_1_parts_list_RGear_shocks)       parts_list_RGear_shocks       = stg_1_parts_list_RGear_shocks;
			if (stg_1_parts_list_RGear_springs)      parts_list_RGear_springs      = stg_1_parts_list_RGear_springs;
			if (stg_1_parts_list_RGear_brakes)       parts_list_RGear_brakes       = stg_1_parts_list_RGear_brakes;
			if (stg_1_parts_list_RGear_sways)        parts_list_RGear_sways        = stg_1_parts_list_RGear_sways;
			if (stg_1_parts_list_RGear_wheels)       parts_list_RGear_wheels       = stg_1_parts_list_RGear_wheels;
			if (stg_1_parts_list_RGear_tyres)        parts_list_RGear_tyres        = stg_1_parts_list_RGear_tyres;
			if (stg_1_parts_list_RGear_others)       parts_list_RGear_others       = stg_1_parts_list_RGear_others;
		}

		Descriptor d;

		Vector partLists = new Vector();
		partLists.addElement( parts_list_E );
		partLists.addElement( parts_list_FL );
		partLists.addElement( parts_list_FR );
		partLists.addElement( parts_list_RL );
		partLists.addElement( parts_list_RR );
		partLists.addElement( parts_list_F );
		partLists.addElement( parts_list_Rr );
		partLists.addElement( parts_list_L );
		partLists.addElement( parts_list_R );
		partLists.addElement( parts_list_T );


		// Here starts the car crashing section
		// We need to set the chassis condition first
		this.setTear( desc.tear );
		this.setWear( desc.wear );

		while( crash_count-- && partLists.size() )
		{
			float crash_badness = random(); // * desc.crash_badness_override; //
			float crash_badness_range = crash_badness;

			if (crash_badness!=0.0)
				crash_badness = crash_badness/crash_badness;

			crash_badness = clampTo(crash_badness,0.01,1.0); // from small tick to devastating crash //

			parts_list = partLists.removeElementAt( random() * partLists.size() );

			d = new Descriptor(desc);
			// because d is a clone of desc, desc is the state of the chassis, and if the chassis was hurt badly, the part will be hurt at least that badly //

			for (part_looper=0; part_looper<parts_list.length; part_looper++)
			{
				d.tear *= crash_badness+(random()*crash_badness_range-crash_badness_range/2.0);
				d.tear = clampTo(d.tear,0.0582285,1.0);
				crash_badness *= CRASH_BADNESS_DAMPING; // dampening as we get further into the car //
				d.tear = 1-d.tear;
				float r=random()*0.5;
				d.wear = desc.wear + (1.0-desc.wear)*r;

				if (random() >= d.tear*d.wear*2.0)
				{
					int t = GameLogic.CARCOLORS.length*random();
					d.color = GameLogic.CARCOLORS[t];
				}
				else
					d.color = desc.color;

				Part p = addPart( parts_list [part_looper], "???", d);

				d.tear = 1-d.tear;
			}
		}

		// the running gear will always be present (and flawless, sorry) - Sala //
		partLists.addElement( parts_list_RGear_suspensions );
		partLists.addElement( parts_list_RGear_shocks );
		partLists.addElement( parts_list_RGear_springs );
		partLists.addElement( parts_list_RGear_brakes );
		partLists.addElement( parts_list_RGear_sways );
		partLists.addElement( parts_list_RGear_wheels );
		partLists.addElement( parts_list_RGear_tyres );
		partLists.addElement( parts_list_RGear_others );

		d = new Descriptor(desc);

		// add any segments left that were not used in crashing //
		while( partLists.size() )
		{
			parts_list = partLists.removeElementAt(0);

			for (part_looper=0; part_looper<parts_list.length; part_looper++)
				if (random() <= desc.optical)
				{
					float r=random()*0.5;
					float r2=random()*0.5;
					d.tear = desc.tear + (1.0-desc.tear)*r;
					d.wear = desc.wear + (1.0-desc.wear)*r2;
					Part p = addPart( parts_list [part_looper], "???", d);
				}
		}
	}

	public void updateDifflock()
	{
//		setDifflock(diff_lock);
		queueEvent( null, EVENT_COMMAND, "difflock " + diff_lock  );
	}

	//---------tuning
	public int isTuneable()
	{
		return brake_balance_can_be_set;
	}

	// backup values //
	float	old_brake_balance;

	public void buildTuningMenu( Menu m )
	{
		old_brake_balance = brake_balance;
		if (brake_balance_can_be_set)
			m.addItem( "F-R brake balance",		1, -brake_balance, -1.0, 0.0, 51, null ).changeVLabelText( Float.toString(brake_balance*100.0, "%1.1f %%"));
	}

	public void endTuningSession( int cancelled )
	{
		if( cancelled )
		{
			brake_balance = old_brake_balance;
		}
		else
		{
			getCar_LocalVersion();
			if (the_car)
				the_car.forceUpdate();
			GameLogic.spendTime(3*60);
		}
	}

	public void handleMessage( Event m )
	{
		if( m.cmd == 1 )
		{
			brake_balance = -((Slider)m.gadget).value;
			((Slider)m.gadget).changeVLabelText( Float.toString(brake_balance*100.0, "%1.1f %%"));
		}
	}
	//---------tuning

	//public int getCarID(){ return carID; }

	public native float getTorque( float RPM, float boost );
	public native float getMass( );
	public native Vector3 getCM( );
	public native Vector3 getMin( );
	public native Vector3 getMax( );
	public native Vector3 getWheelPos( int n );
	public native void forceUpdate( );
	public native String getWheelDamage( int index );
	public native void setWheelDamage( int index, String data );
	public native void setCooling( float min, float max, float spd ); // default: 10, 50, 0.01 ; spd az negyzetes!!!! - Sala //

	public native SfxTable getSfxTable( int id );
	public native void setSfxExhaustMinVol(float f);
	public native void setSteerWheelRadius(float f);
	public native void setSteerWheel(float r, float z);
	public native void setHornSFX( ResourceRef sfx, float pitch, int index );
	public native void setNitroSFX( ResourceRef sfx, float pitch );

	public native float getMileage(	);
	public native void setMileage( float m );

	public native void setBuck( int partID, int buckid, float freq, float prob, float rpmdep, float amp );

	public native int getWheels();
	public native WheelRef getWheel( int id );
}
