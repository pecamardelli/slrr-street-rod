package java.game.cars;

import java.util.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.airfueldeliverysystem.*;
import java.game.parts.enginemodels.*;

public class Ford_Pick_Up_Custom_40 extends Ford_Pick_Up_40_models
{
	public Ford_Pick_Up_Custom_40( int id )
	{
		super( id );
		carCategory = PACKAGE;

		makerName = "Ford Motor USA";
		model = MODEL_PICK_UP_CUSTOM_40;
		vehicleName = "Hauler's SuperDuty Extra 750";
		name = "Hauler's SuperDuty chassis";

		description = "A high flat-topped hood dominated the front look of the 1940 model, as the grille spread out to reach the fenders to differentiate the Deluxe line and the headlights were pushed wider still. The standard Ford inherited the grille of the 1939 model with blackout on each side of a heavy chrome center; heavier headlight surrounds serve as another major differentiator from the 1939. 1940 was the last year of the 1937 design and its smaller V8 engine, with a straight-six engine to be reintroduced the following year. Sealed-beam headlights were one of the few major advances for 1940, while a hydraulic top was new on the convertible.";

		value = mHUF2USD(1.041);
		brand_new_prestige_value = 72.90;

		fully_stripped_drag = 0.55;

		exhaustSlotIDList = new Vector();
		exhaustSlotIDList.addElement( new Integer(18) );
		exhaustSlotIDList.addElement( new Integer(23) );
	}

	public void addStockParts( Descriptor desc )
	{
		float number = random();
		EngineModels engine;
		engine = new EngineModels();		
		stock_parts_list_E = engine.getFordEngine( EngineModels.FORD_V8_260 );

		stock_parts_list_FL = new int[2];
		stock_parts_list_FL[ 0] = cars.racers.superduty:0x000000B6r; // "L headlights" //
		stock_parts_list_FL[ 1] = cars.racers.superduty:0x000000BBr; // "FL quarterpanel" //

		stock_parts_list_FR = new int[2];
		stock_parts_list_FR[ 0] = cars.racers.superduty:0x000000C6r; // "R headlights" //
		stock_parts_list_FR[ 1] = cars.racers.superduty:0x000000BEr; // "FR quarterpanel" //

		stock_parts_list_RL = new int[1];
//		stock_parts_list_RL[ 0] = cars.racers.superduty:0x000000B8r; // "L taillights" //
		stock_parts_list_RL[ 0] = cars.racers.superduty:0x000000C3r; // "RL quarterpanel 2" //

		stock_parts_list_RR = new int[1];
//		stock_parts_list_RR[ 0] = cars.racers.superduty:0x000000C5r; // "R taillights" //
		stock_parts_list_RR[ 0] = cars.racers.superduty:0x000000C8r; // "RR quarterpanel 2" //

		stock_parts_list_F  = new int[3];
		stock_parts_list_F[ 0] = cars.racers.superduty:0x000000C4r; // "F bumper 2" //
		stock_parts_list_F[ 1] = cars.racers.superduty:0x000000C2r; // "hood 2" //
		stock_parts_list_F[ 2] = cars.racers.superduty:0x000000B1r; // "F windshield" //

		stock_parts_list_Rr = new int[3];
		stock_parts_list_Rr[ 0] = cars.racers.superduty:0x000000B9r; // "R bumper 2" //
		stock_parts_list_Rr[ 1] = cars.racers.superduty:0x000000BDr; // "R door" //
		stock_parts_list_Rr[ 2] = cars.racers.superduty:0x000000B2r; // "R windshield" //

		stock_parts_list_L  = new int[3];
		stock_parts_list_L[ 0] = cars.racers.superduty:0x000000CDr; // "L sideskirt 2" //
		stock_parts_list_L[ 1] = cars.racers.superduty:0x000000C9r; // "FL door" //
		stock_parts_list_L[ 2] = cars.racers.superduty:0x000000B3r; // "FL seat" //

		stock_parts_list_R  = new int[3];
		stock_parts_list_R[ 0] = cars.racers.superduty:0x000000CFr; // "R sideskirt 2" //
		stock_parts_list_R[ 1] = cars.racers.superduty:0x000000C0r; // "FR door" //
		stock_parts_list_R[ 2] = cars.racers.superduty:0x000000CBr; // "FR seat" //

		// stage 1 stuffs //

		stg_1_engne_kit_limit = 1.50;

		stg_1_parts_list_E  = new int[2];
		stg_1_parts_list_E[ 0] = parts.engines.MC_Prime_SuperDuty:0x00000001r; // "6.5L V8" //
		stg_1_parts_list_E[ 1] = parts:0x000053FFr; // "stock battery" //

		stg_1_parts_list_F  = new int[4];
		stg_1_parts_list_F[ 0] = cars.racers.superduty:0x000000D0r; // "F brush guard" //
		stg_1_parts_list_F[ 1] = cars.racers.superduty:0x000000C4r; // "F bumper 2" //
		stg_1_parts_list_F[ 2] = cars.racers.superduty:0x000000C2r; // "hood 2" //
		stg_1_parts_list_F[ 3] = cars.racers.superduty:0x000000B1r; // "F windshield" //

		stg_1_parts_list_Rr = new int[4];
		stg_1_parts_list_Rr[ 0] = cars.racers.superduty:0x000000B9r; // "R bumper 2" //
		stg_1_parts_list_Rr[ 1] = cars.racers.superduty:0x000000BDr; // "R door" //
		stg_1_parts_list_Rr[ 2] = cars.racers.superduty:0x000000D1r; // "rollbar" //
		stg_1_parts_list_Rr[ 3] = cars.racers.superduty:0x000000B2r; // "R windshield" //

	// running gear parts lists //

		// stock 1 stuff //

		stock_parts_list_RGear_suspensions = new int[4];
		stock_parts_list_RGear_suspensions[ 0] = parts:0x000001F8r; // "SuperDuty_750_FL_McPherson_strut" //
		stock_parts_list_RGear_suspensions[ 1] = parts:0x000001F9r; // "SuperDuty_750_FR_McPherson_strut" //
		stock_parts_list_RGear_suspensions[ 2] = parts:0x000001FAr; // "SuperDuty_750_RL_trailing_arm" //
		stock_parts_list_RGear_suspensions[ 3] = parts:0x000001FBr; // "SuperDuty_750_RR_trailing_arm" //

		stock_parts_list_RGear_shocks = new int[4];
		stock_parts_list_RGear_shocks[ 0] = stock_parts_list_RGear_shocks[ 1] = parts:0x000001B2r; // "shock_absorber_SuperDuty_750_front" //
		stock_parts_list_RGear_shocks[ 2] = stock_parts_list_RGear_shocks[ 3] = parts:0x000001B3r; // "shock_absorber_SuperDuty_750_rear" //

		stock_parts_list_RGear_springs = new int[4];
		stock_parts_list_RGear_springs[ 0] = stock_parts_list_RGear_springs[ 1] = parts:0x000001DCr; // "spring_SuperDuty_750_front" //
		stock_parts_list_RGear_springs[ 2] = stock_parts_list_RGear_springs[ 3] = parts:0x000001DDr; // "spring_SuperDuty_750_rear" //

		stock_parts_list_RGear_brakes = new int[4];
		stock_parts_list_RGear_brakes[ 0] = stock_parts_list_RGear_brakes[ 1] = parts:0x00000159r; // "brake_SuperDuty_750_front" //
		stock_parts_list_RGear_brakes[ 2] = stock_parts_list_RGear_brakes[ 3] = parts:0x0000015Dr; // "brake_SuperDuty_750_rear" //

//		stock_parts_list_RGear_sways = new int[2];
//		stock_parts_list_RGear_sways[ 0] = parts:0x00000191r; // "swaybar_SuperDuty_750_front" //
//		stock_parts_list_RGear_sways[ 1] = parts:0x00000192r; // "swaybar_SuperDuty_750_rear" //

		stock_parts_list_RGear_wheels = new int[4];
		stock_parts_list_RGear_wheels[ 0] = stock_parts_list_RGear_wheels[ 1] = cars.racers.FOR_Coupe_40:0x00001028r; // "DevilSport_5_8.0x17_ET_0" //
		stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.FOR_Coupe_40:0x00001028r; // "DevilSport_5_8.0x17_ET_0" //

		stock_parts_list_RGear_tyres = new int[4];
		stock_parts_list_RGear_tyres[ 0] = stock_parts_list_RGear_tyres[ 1] = cars.racers.FOR_Coupe_40:0x00001029r; // "205_55_17_sport" //
		stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.FOR_Coupe_40:0x00001029r; // "205_55_17_sport" //

		super.addStockParts( desc );

		addPart( cars.racers.SuperDuty:0x000000B4r, "steering wheel" );

		addPart( cars.racers.SuperDuty:0x00000114r, "L_stock_exhaust_pipe" );
		addPart( cars.racers.SuperDuty:0x0000011Ar, "R_stock_exhaust_pipe" );
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
