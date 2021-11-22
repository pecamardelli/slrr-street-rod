package java.game.cars;

import java.util.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.airfueldeliverysystem.*;
import java.game.parts.enginemodels.*;

public class Dodge_330_63 extends Dodge_330_63_models
{
	public Dodge_330_63( int id )
	{
		super( id );
		carCategory = PACKAGE;

		makerName = "Dodge Division";
		model = MODEL_DODGE_330_63;
		vehicleName = "Dodge 330 '63";
		name = "Dodge 330 '63 chassis";

		description = "The Dodge 330 was a full-size automobile sold by Dodge from 1962 to and 1964, and was based on the B-body.[1] The coupe often used a 6-cylinder engine. The car was available as a 2dr Sedan or 4dr Sedan.[2] Base motor was the 225 Slant-Six. The 318 2bbl, 361 2bbl, 383 2bbl, 383 4bbl, and 426 4bbl were optional. As an intermediate trim level above the Dart, it came standard with a cigarette lighter, front foam cushions, and rear arm rests. The car rode a 119 wheelbase and was 208.1 inches long[4] along with the higher trimmed 440 and Polara.[5] In 1965, full sized Dodge's got bigger on the new C Body with 121 in (3,073 mm) wheelbase, and the 330 and 440 were both replaced by the new, bigger Polara. The 880 now took the Polara's former place in the lineup.The Dodge 330 Max Wedge was a 330 2 door sedan powered by the 426 Max Wedge with dual 4 Barrel Carburetors and 425 hp (317 kW). It was available in both years, mostly ordered as a super stocker for the race tracks. Civilian versions are rare today.";

		value = mHUF2USD(0.736148);
		brand_new_prestige_value = 25.0;

		fully_stripped_drag = 0.44;

		exhaustSlotIDList = new Vector();
		exhaustSlotIDList.addElement( new Integer(996) );
	}

	public void addStockParts( Descriptor desc )
	{
		stock_parts_list_E = EngineModels.getChryslerEngine( EngineModels.CHRYSLER_V8_318 );

		stock_parts_list_FL = new int[4];
		stock_parts_list_FL[ 0] = cars.racers.einvagen:0x000000BAr; // "L headlights" //
		stock_parts_list_FL[ 1] = cars.racers.einvagen:0x000000B0r; // "FL quarterpanel" //
		stock_parts_list_FL[ 2] = cars.racers.einvagen:0x000000A6r; // "Stock lower front panel" //
		stock_parts_list_FL[ 3] = cars.racers.einvagen:0x000000A4r; // "Stock front grille" //

		stock_parts_list_FR = new int[2];
		stock_parts_list_FR[ 0] = cars.racers.einvagen:0x000000BFr; // "R headlights" //
		stock_parts_list_FR[ 1] = cars.racers.einvagen:0x000000B4r; // "FR quarterpanel" //

		stock_parts_list_RL = new int[1];
		stock_parts_list_RL[ 0] = cars.racers.einvagen:0x000000BCr; // "L taillights" //

		stock_parts_list_RR = new int[1];
		stock_parts_list_RR[ 0] = cars.racers.einvagen:0x000000C2r; // "R taillights" //

		stock_parts_list_F  = new int[3];
		stock_parts_list_F[ 0] = cars.racers.einvagen:0x000000ACr; // "F bumper" //
		stock_parts_list_F[ 1] = cars.racers.einvagen:0x000000B8r; // "hood" //
		stock_parts_list_F[ 2] = cars.racers.einvagen:0x000000AEr; // "F windshield" //

		stock_parts_list_Rr = new int[4];
		stock_parts_list_Rr[ 0] = cars.racers.einvagen:0x000000BDr; // "R bumper" //
		stock_parts_list_Rr[ 1] = cars.racers.einvagen:0x000000BEr; // "R door" //
		stock_parts_list_Rr[ 2] = cars.racers.einvagen:0x000000B7r; // "hat holder" //
		stock_parts_list_Rr[ 3] = cars.racers.einvagen:0x000000C1r; // "R seats" //


		stock_parts_list_L  = new int[3];
		stock_parts_list_L[ 0] = cars.racers.einvagen:0x000000AFr; // "FL door" //
		stock_parts_list_L[ 1] = cars.racers.einvagen:0x000000C7r; // "RL door" //
		stock_parts_list_L[ 2] = cars.racers.einvagen:0x000000B1r; // "FL seat" //

		stock_parts_list_R  = new int[17];
		stock_parts_list_R[ 0] = cars.racers.einvagen:0x000000B3r; // "FR door" //
		stock_parts_list_R[ 1] = cars.racers.einvagen:0x000000C9r; // "RR door" //
		stock_parts_list_R[ 2] = cars.racers.einvagen:0x000000B5r; // "FR seat" //
		stock_parts_list_R[ 3] = cars.racers.einvagen:0x0000213Cr; // "Stock floor interior panel" //
		stock_parts_list_R[ 4] = cars.racers.einvagen:0x0000113Cr; // "Stock roof interior panel" //
		stock_parts_list_R[ 5] = cars.racers.einvagen:0x000040B7r; // "Stock right door interior panel" //
		stock_parts_list_R[ 6] = cars.racers.einvagen:0x000030B7r; // "Stock left door interior panel" //
		stock_parts_list_R[ 7] = cars.racers.einvagen:0x000020B7r; // "Stock rear right interior panel" //
		stock_parts_list_R[ 8] = cars.racers.einvagen:0x000010B7r; // "Stock rear left interior panel" //
		stock_parts_list_R[ 9] = cars.racers.einvagen:0x0000013Cr; // "Stock trunk carpeting" //
		stock_parts_list_R[ 10] = cars.racers.einvagen:0x000000C3r; // "Stock rear windshield" //
		stock_parts_list_R[ 11] = cars.racers.einvagen:0x000000C8r; // "Stock rear left window" //
		stock_parts_list_R[ 12] = cars.racers.einvagen:0x000000CAr; // "Stock rear right window" //
		stock_parts_list_R[ 13] = cars.racers.einvagen:0x00000130r; // "Stock right foglight" //
		stock_parts_list_R[ 14] = cars.racers.einvagen:0x00000131r; // "Stock left foglight" //
		stock_parts_list_R[ 15] = cars.racers.einvagen:0x0000012Cr; // "Stock left indicator" //
		stock_parts_list_R[ 16] = cars.racers.einvagen:0x000000C6r; // "Stock right indicator" //

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
		stock_parts_list_RGear_brakes[ 0] = stock_parts_list_RGear_brakes[ 1] = parts:0x0000015Er; // "brake_MC_GT_front" //
		stock_parts_list_RGear_brakes[ 2] = stock_parts_list_RGear_brakes[ 3] = parts:0x0000016Fr; // "brake_MC_GT_rear" //

//		stock_parts_list_RGear_sways = new int[2];
//		stock_parts_list_RGear_sways[ 0] = parts:0x00000185r; // "swaybar_Einvagen_GT_front" //
//		stock_parts_list_RGear_sways[ 1] = parts:0x00000186r; // "swaybar_Einvagen_GT_rear" //

		stock_parts_list_RGear_wheels = new int[4];
		stock_parts_list_RGear_tyres = new int[4];
		stock_parts_list_RGear_wheels[ 0] = stock_parts_list_RGear_wheels[ 1] = cars.racers.einvagen:0x000010B0r; // Chrysler steel 15x8
		stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.einvagen:0x000010B0r; // Chrysler steel 15x8
		stock_parts_list_RGear_tyres[ 0] = stock_parts_list_RGear_tyres[ 1] = cars.racers.einvagen:0x000010BDr; // "tyre 215 50 15 8.0 LOD CATALOG GARAGE" //
		stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.einvagen:0x000010BDr; // "tyre 255 50 15 9.5 LOD CATALOG GARAGE" //
		
		super.addStockParts( desc );

		addPart( cars.racers.Einvagen:0x000000CBr, "steering wheel" );

		addPart( cars.racers.Einvagen:0x00000136r, "stock_exhaust_pipe" );
		addPart( parts.mufflers:0x0000001Br, "muffler type 08" );

		if (desc.power > 1.25)
		{
			addPart( parts.wings:0x00000024r, "wing" );
		}

		if (desc.power > 1.25)
		{
			NOSInjectorSystem N2Oinjector=addPart( parts.engines.Einvagen_Duhen_Ishima_Focer:0x00000052r, "NOS injector" );
			N2Oinjector.nitro_consumption = clampTo(N2Oinjector.maxconsumption*((desc.power-1.25)/0.75*0.550+0.150),N2Oinjector.minconsumption,N2Oinjector.maxconsumption);
			if (desc.power > 1.8)
			{
				addPart( parts:0x000001C1r, "12pds canister" );
				addPart( parts:0x000001BFr, "24pds canister" );
			}
			else
			if (desc.power > 1.5)
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
