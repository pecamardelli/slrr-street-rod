package java.game.cars;

import java.util.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.airfueldeliverysystem.*;
import java.game.parts.enginemodels.*;

public class Chevrolet_Monte_Carlo_FF_70 extends Chevrolet_Monte_Carlo_70_models
{
	public Chevrolet_Monte_Carlo_FF_70( int id )
	{
		super( id );
		carCategory = PACKAGE;

		makerName = "General Motors Company";
		model = MODEL_MONTE_CARLO_FF_70;
		vehicleName = "Chevrolet Monte Carlo Fast & Fourious '70";
		name = "Chevrolet Monte Carlo '70 chassis";

		description = "Replica of Monte Carlo of the movie Fast And Furious Drift Out.";

		value = mHUF2USD(2.0);
		brand_new_prestige_value = 90.0;

		fully_stripped_drag = 0.61;
		brake_balance_can_be_set = 1;

		exhaustSlotIDList = new Vector();
		exhaustSlotIDList.addElement( new Integer(22) );
	}

	public void addStockParts( Descriptor desc )
	{
		// stock 1 stuffs //

		float number = random();
		EngineModels engine;
		engine = new EngineModels();		
		stock_parts_list_E = engine.getGmEngine();

		stock_parts_list_FL = new int[4];
		stock_parts_list_FL[ 0] = cars.racers.baiern:0x00000165r; // "L headlights 2" //
		stock_parts_list_FL[ 1] = cars.racers.baiern:0x00000124r; // "FL quarterpanel 2" //
		stock_parts_list_FL[ 2] = cars.racers.baiern:0x0000A11Dr; // "Vintage front grille" //
		stock_parts_list_FL[ 3] = cars.racers.baiern:0x0000010Fr; // "Stock front bumper" //

		stock_parts_list_FR = new int[2];
		stock_parts_list_FR[ 0] = cars.racers.baiern:0x00000166r; // "R headlights 2" //
		stock_parts_list_FR[ 1] = cars.racers.baiern:0x0000012Br; // "FR quarterpanel 2" //

		stock_parts_list_RL = new int[2];
		stock_parts_list_RL[ 0] = cars.racers.baiern:0x00000108r; // "L taillights" //
		stock_parts_list_RL[ 1] = cars.racers.baiern:0x00000123r; // "RL quarterpanel 2" //

		stock_parts_list_RR = new int[3];
		stock_parts_list_RR[ 0] = cars.racers.baiern:0x00000114r; // "R taillights" //
		stock_parts_list_RR[ 1] = cars.racers.baiern:0x00000129r; // "RR quarterpanel 2" //
		stock_parts_list_RR[ 2] = cars.racers.baiern:0x00000107r; // "Stock rear bumper" //

		stock_parts_list_L  = new int[7];
		stock_parts_list_L[ 0] = cars.racers.baiern:0x00000122r; // "L sideskirt 2" //
		stock_parts_list_L[ 1] = cars.racers.baiern:0x00000121r; // "FL door 2" //
		stock_parts_list_L[ 2] = cars.racers.baiern:0x00000104r; // "L mirror" //
		stock_parts_list_L[ 3] = cars.racers.baiern:0x0000010Er; // "FL window" //
		stock_parts_list_L[ 4] = cars.racers.baiern:0x0000010Ar; // "RL window" //
		stock_parts_list_L[ 5] = parts.interior:0x00000049r; // "FL seat" //
		stock_parts_list_L[ 6] = cars.racers.baiern:0x0000011Br; // "Left body emblem" //

		stock_parts_list_R  = new int[6];
		stock_parts_list_R[ 0] = cars.racers.baiern:0x00000127r; // "R sideskirt 2" //
		stock_parts_list_R[ 1] = cars.racers.baiern:0x0000012Ar; // "FR door 2" //
		stock_parts_list_R[ 2] = cars.racers.baiern:0x0000011Ar; // "R mirror" //
		stock_parts_list_R[ 3] = cars.racers.baiern:0x00000112r; // "FR window" //
		stock_parts_list_R[ 4] = cars.racers.baiern:0x0000010Cr; // "RR window" //
		stock_parts_list_R[ 5] = parts.interior:0x00000049r; // "FR seat" //

		stock_parts_list_F  = new int[3];
		stock_parts_list_F[ 0] = cars.racers.baiern:0x00000120r; // "F bumper 3" //
		stock_parts_list_F[ 1] = cars.racers.baiern:0x00000125r; // "Cowl-induction plastic hood" //
		stock_parts_list_F[ 2] = cars.racers.baiern:0x0000010Br; // "F windshield" //

		stock_parts_list_Rr = new int[3];
		stock_parts_list_Rr[ 0] = cars.racers.baiern:0x0000011Fr; // "R bumper 3" //
		stock_parts_list_Rr[ 1] = cars.racers.baiern:0x00000118r; // "trunk" //
		stock_parts_list_Rr[ 2] = cars.racers.baiern:0x00000102r; // "R windshield" //

	// running gear parts lists //

		// stock 1 stuffs //

		stock_parts_list_RGear_suspensions = new int[4];
		stock_parts_list_RGear_suspensions[ 0] = parts:0x000000F4r; // "Baiern_GT_FL_McPherson_strut" //
		stock_parts_list_RGear_suspensions[ 1] = parts:0x000000F5r; // "Baiern_GT_FR_McPherson_strut" //
		stock_parts_list_RGear_suspensions[ 2] = parts:0x000000F6r; // "Baiern_GT_RL_trailing_arm" //
		stock_parts_list_RGear_suspensions[ 3] = parts:0x000000F7r; // "Baiern_GT_RR_trailing_arm" //

		stock_parts_list_RGear_shocks = new int[4];
		stock_parts_list_RGear_shocks[ 0] = stock_parts_list_RGear_shocks[ 1] = parts:0x000000ECr; // "shock_absorber_Baiern_GT_front" //
		stock_parts_list_RGear_shocks[ 2] = stock_parts_list_RGear_shocks[ 3] = parts:0x000000EDr; // "shock_absorber_Baiern_GT_rear" //

		stock_parts_list_RGear_springs = new int[4];
		stock_parts_list_RGear_springs[ 0] = stock_parts_list_RGear_springs[ 1] = parts:0x000000F2r; // "spring_Baiern_GT_front" //
		stock_parts_list_RGear_springs[ 2] = stock_parts_list_RGear_springs[ 3] = parts:0x000000F3r; // "spring_Baiern_GT_rear" //

		stock_parts_list_RGear_brakes = new int[4];
		stock_parts_list_RGear_brakes[ 0] = stock_parts_list_RGear_brakes[ 1] = parts:0x000000DAr; // "brake_Baiern_GT_front" //
		stock_parts_list_RGear_brakes[ 2] = stock_parts_list_RGear_brakes[ 3] = parts:0x000000DBr; // "brake_Baiern_GT_rear" //

//		stock_parts_list_RGear_sways = new int[2];
//		stock_parts_list_RGear_sways[ 0] = parts:0x0000021Dr; // "swaybar_Baiern_GT_front" //
//		stock_parts_list_RGear_sways[ 1] = parts:0x0000021Er; // "swaybar_Baiern_GT_rear" //

		stock_parts_list_RGear_wheels = new int[4];
		stock_parts_list_RGear_wheels[ 0] = stock_parts_list_RGear_wheels[ 1] = cars.racers.baiern:0x000030E0r; // "rim Baiern_DTM 11.0 19 ET -25 LOD CATALOG GARAGE" //
		stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.baiern:0x00003AE0r; // "rim Baiern_DTM 13.0 19 ET -40 LOD CATALOG GARAGE" //

		stock_parts_list_RGear_tyres = new int[4];
		stock_parts_list_RGear_tyres[ 0] = stock_parts_list_RGear_tyres[ 1] = cars.racers.baiern:0x000020D0r; // "tyre 255 25 19 11.0 LOD CATALOG GARAGE" //
		stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.baiern:0x00002AD0r; // "tyre 295 20 19 13.0 LOD CATALOG GARAGE" //

		super.addStockParts( desc );

		addPart( parts.interior:0x00000024r, "steering wheel" );

		addPart( cars.racers.Baiern:0x00000182r, "stock_exhaust_pipe" );
		addPart( parts.mufflers:0x0000001Fr, "muffler type 12" );
		addPart( parts.mufflers:0x0000001Fr, "muffler type 12" );

		if (desc.power > 1.25)
		{
			addPart( parts.wings:0x00000027r, "wing" );
		}
		else
		{
			addPart( parts.wings:0x0000002Br, "wing" );
		}

		if (desc.power > 1.1)
		{
			NOSInjectorSystem N2Oinjector=addPart( parts.engines.Baiern_Emer:0x00000051r, "NOS injector" );
			N2Oinjector.nitro_consumption = clampTo(N2Oinjector.maxconsumption*((desc.power-1.1)/0.9*0.700+0.200),N2Oinjector.minconsumption,N2Oinjector.maxconsumption);
			if (desc.power > 1.5)
			{
				addPart( parts:0x000001C1r, "12pds canister" );
				addPart( parts:0x000001BFr, "24pds canister" );
			}
			else
			if (desc.power > 1.3)
			{
				addPart( parts:0x000001BFr, "24pds canister" );
			}
			else
			{
				addPart( parts:0x000001C1r, "12pds canister" );
			}
		}
	}
}
