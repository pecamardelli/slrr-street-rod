package java.game.cars;

import java.util.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.airfueldeliverysystem.*;
import java.game.parts.enginemodels.*;

public class El_Camino_70 extends El_Camino_models
{
	public El_Camino_70( int id )
	{
		super( id );
		carCategory = PACKAGE;

		makerName = "General Motors Company";
		model = MODEL_EL_CAMINO_70;
		vehicleName = "Chevrolet El Camino '70";
		name = "Chevrolet El Camino '70 Chassis";

		description = "The El Camino 1970 models received sheet metal revisions that gave the bodies a more squared-up stance, and interiors were also redesigned. The new SS396, which actually displaced 402 cu in (6.6 L) (although all emblems read 396) was available. Chevrolet's largest and most-powerful engine of the time was also put into a select few El Caminos. The LS6 454 CID engine, rated at 450 hp (336 kW) and 500 lb·ft (680 N·m) of torque, gave the El Camino 1/4-mile times in the lower 13-second range at around  108 mph (174 km/h).";

		value = mHUF2USD(1.142);
		brand_new_prestige_value = 51.20;

		fully_stripped_drag = 0.55;

		exhaustSlotIDList = new Vector();
		exhaustSlotIDList.addElement( new Integer(24) );
		exhaustSlotIDList.addElement( new Integer(39) );
	}

	public void addStockParts( Descriptor desc )
	{
		// stock 1 stuffs //

		EngineModels engine;
		engine = new EngineModels();		
		stock_parts_list_E = engine.getGmEngine();

		stock_parts_list_FL = new int[2];
		stock_parts_list_FL[ 0] = cars.racers.El_Camino70:0x000000A8r; // "L headlights" //
		stock_parts_list_FL[ 1] = cars.racers.El_Camino70:0x000000B9r; // "FL quarterpanel" //

		stock_parts_list_FR = new int[2];
		stock_parts_list_FR[ 0] = cars.racers.El_Camino70:0x000000BCr; // "R headlights" //
		stock_parts_list_FR[ 1] = cars.racers.El_Camino70:0x000000C4r; // "FR quarterpanel" //

		stock_parts_list_RL = new int[2];
		stock_parts_list_RL[ 0] = cars.racers.El_Camino70:0x000000ACr; // "L taillights" //

		stock_parts_list_RR = new int[2];
		stock_parts_list_RR[ 0] = cars.racers.El_Camino70:0x000000BDr; // "R taillights" //

		stock_parts_list_F  = new int[6];
		stock_parts_list_F[ 0] = cars.racers.El_Camino70:0x000000A7r; // "F bumper" //
		stock_parts_list_F[ 4] = cars.racers.El_Camino70:0x000000B6r; // "hood" //
		stock_parts_list_F[ 5] = cars.racers.El_Camino70:0x000000B0r; // "F windshield" //

		stock_parts_list_Rr = new int[4];
		stock_parts_list_Rr[ 0] = cars.racers.El_Camino70:0x000000AAr; // "R bumper" //
		stock_parts_list_Rr[ 1] = cars.racers.El_Camino70:0x000000ADr; // "trunk" //
		stock_parts_list_Rr[ 2] = cars.racers.El_Camino70:0x000000B1r; // "R windshield" //
		stock_parts_list_Rr[ 3] = cars.racers.El_Camino70:0x000000ABr; // "Logo" //

		stock_parts_list_L  = new int[4];
		stock_parts_list_L[ 0] = cars.racers.El_Camino70:0x000000AEr; // "FL door" //
		stock_parts_list_L[ 1] = cars.racers.El_Camino70:0x000000B2r; // "FL seat" //
		stock_parts_list_L[ 2] = cars.racers.El_Camino70:0x000000C1r; // "L_mirror" //
		stock_parts_list_L[ 3] = cars.racers.El_Camino70:0x000000AFr; // "FL_window" //

		stock_parts_list_R  = new int[4];
		stock_parts_list_R[ 0] = cars.racers.El_Camino70:0x000000C2r; // "FR door" //
		stock_parts_list_R[ 1] = cars.racers.El_Camino70:0x000000BFr; // "FR seat" //
		stock_parts_list_R[ 2] = cars.racers.El_Camino70:0x000000C5r; // "R_mirror" //
		stock_parts_list_R[ 3] = cars.racers.El_Camino70:0x000000BEr; // "FR_window" //

	// running gear parts lists //

		// stock 1 stuffs //

        stock_parts_list_RGear_suspensions = new int[4];
		stock_parts_list_RGear_suspensions[ 0] = parts:0x000001FCr; // "MC_GT_FL_McPherson_strut" //
		stock_parts_list_RGear_suspensions[ 1] = parts:0x000001FDr; // "MC_GT_FR_McPherson_strut" //
		stock_parts_list_RGear_suspensions[ 2] = parts:0x000001FEr; // "MC_GT_RL_trailing_arm" //
		stock_parts_list_RGear_suspensions[ 3] = parts:0x000001FFr; // "MC_GT_RR_trailing_arm" //

		stock_parts_list_RGear_shocks = new int[4];
		stock_parts_list_RGear_shocks[ 0] = stock_parts_list_RGear_shocks[ 1] = parts:0x000001B4r; // "shock_absorber_MC_GT_front" //
		stock_parts_list_RGear_shocks[ 2] = stock_parts_list_RGear_shocks[ 3] = parts:0x000001B5r; // "shock_absorber_MC_GT_rear" //

		stock_parts_list_RGear_springs = new int[4];
		stock_parts_list_RGear_springs[ 0] = stock_parts_list_RGear_springs[ 1] = parts:0x000001DEr; // "spring_MC_GT_front" //
		stock_parts_list_RGear_springs[ 2] = stock_parts_list_RGear_springs[ 3] = parts:0x000001DFr; // "spring_MC_GT_rear" //

		stock_parts_list_RGear_brakes = new int[4];
		stock_parts_list_RGear_brakes[ 0] = stock_parts_list_RGear_brakes[ 1] = cars.racers.El_Camino70:0x00001565r; // "brake_Focer_200_front" //
		stock_parts_list_RGear_brakes[ 2] = stock_parts_list_RGear_brakes[ 3] = cars.racers.El_Camino70:0x00001566r; // "brake_Focer_200_rear" //

		stock_parts_list_RGear_wheels = new int[4];
		stock_parts_list_RGear_wheels[ 0] = stock_parts_list_RGear_wheels[ 1] = cars.racers.El_Camino70:0x00001165r; // "rim Star_II 8.5 17 ET -30 LOD CATALOG GARAGE" //
		stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.El_Camino70:0x00001165r; // "rim Star_II 8.5 17 ET -30 LOD CATALOG GARAGE" //

		stock_parts_list_RGear_tyres = new int[4];
		stock_parts_list_RGear_tyres[ 0] = stock_parts_list_RGear_tyres[ 1] = cars.racers.El_Camino70:0x00001466r; // "Tire" //
		stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.El_Camino70:0x00001466r; // "Tire" //

		super.addStockParts( desc );

		addPart( cars.racers.El_Camino70:0x000000B3r, "steering wheel" );

		addPart( cars.racers.El_Camino70:0x00000129r, "stock_L_exhaust_pipe" );
		addPart( cars.racers.El_Camino70:0x0000012Ar, "stock_R_exhaust_pipe" );
		addPart( parts.mufflers:0x0000001Fr, "muffler type 12" );
		addPart( parts.mufflers:0x0000001Fr, "muffler type 12" );

		if (desc.power > 1.4)
		{
			NOSInjectorSystem N2Oinjector=addPart( parts.engines.MC_Prime_SuperDuty:0x000000BFr, "NOS injector" );
			N2Oinjector.nitro_consumption = clampTo(N2Oinjector.maxconsumption*((desc.power-1.4)/0.6*0.500+0.500),N2Oinjector.minconsumption,N2Oinjector.maxconsumption);
			if (desc.power > 1.8)
			{
				addPart( parts:0x000001C1r, "12pds canister" );
				addPart( parts:0x000001C1r, "12pds canister" );
				addPart( parts:0x000001BFr, "24pds canister" );
				addPart( parts:0x000001BFr, "24pds canister" );
			}
			else
			if (desc.power > 1.6)
			{
				addPart( parts:0x000001BFr, "24pds canister" );
				addPart( parts:0x000001BFr, "24pds canister" );
			}
			else
			{
				addPart( parts:0x000001C1r, "12pds canister" );
				addPart( parts:0x000001C1r, "12pds canister" );
			}
		}
	}
}
