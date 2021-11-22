package java.game.cars;

import java.util.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.airfueldeliverysystem.*;
import java.game.parts.enginemodels.*;

public class Mercury_Park_Lane_64 extends Mercury_Park_Lane_64_models
{
	public Mercury_Park_Lane_64( int id )
	{
		super( id );
		carCategory = PACKAGE;

		makerName = "Mercury Division";
		model = MODEL_PARK_LANE_64;
		vehicleName = "Mercury Park Lane '64";
		name = "Mercury Park Lane '64 chassis";

		description = "The Park Lane was introduced in 1958 and was applied to Mercury's premium automobile line. The Park Lane name had first been used for a 1956 Ford two door station wagon model that was supposed to compete with the Chevrolet Nomad. 1958 Park Lane's wheelbase was 125 inches, 3 inches longer than other Mercury models, length was 220.2 inches and other models 213.2 inches. For the 1959 model year the Park Lane's wheelbase was increased to 128 inches (3,300 mm), two inches longer than the rest of the Mercury line. In 1960, its wheelbase was reduced to 126 inches (3,200 mm), matching the rest of the Mercury line, overall length was 219.2 inches for all full size Mercurys. 1960 Park Lanes were available as a two-door hardtop, four door hardtop or convertible. The chassis was shared with the Colony Park station wagon. The name was reinstated in 1964 as Mercury again attempted to retrench its models in the price gap between Ford and Lincoln. Most Park Lanes had a 'Breezeway' window, a powered reverse slanted rear window that could be lowered into the body, first used on the Mercury Turnpike Cruiser and the 1958-60 Lincoln Continental. Park Lanes were available with the Marauder package (as were all full-size '64 Mercurys) which featured the 'fastback' roof design in place of the Breezeway, and which were also used on the popular full-size Ford line.";

		value = mHUF2USD(1.071);
		brand_new_prestige_value = 30.0;

		fully_stripped_drag = 0.48;

		exhaustSlotIDList = new Vector();
		exhaustSlotIDList.addElement( new Integer(21) );
	}

	public void addStockParts( Descriptor desc )
	{	
		stock_parts_list_E = EngineModels.getFordEngine( EngineModels.FORD_V8_260 );

		stock_parts_list_T  = new int[1];
		stock_parts_list_T[ 0] = cars.racers.Duhen:0x000000C3r; // "targa top" //

		stock_parts_list_FL = new int[2];
		stock_parts_list_FL[ 0] = cars.racers.duhen:0x000000C0r; // "L headlights" //
		stock_parts_list_FL[ 1] = cars.racers.duhen:0x000000CCr; // "FL quarterpanel" //

		stock_parts_list_FR = new int[2];
		stock_parts_list_FR[ 0] = cars.racers.duhen:0x000000CEr; // "R headlights" //
		stock_parts_list_FR[ 1] = cars.racers.duhen:0x000000D5r; // "FR quarterpanel" //

		stock_parts_list_RL = new int[2];
		stock_parts_list_RL[ 0] = cars.racers.duhen:0x000000C9r; // "L taillights" //
		stock_parts_list_RL[ 1] = cars.racers.duhen:0x000000C7r; // "RL quarterpanel" //

		stock_parts_list_RR = new int[2];
		stock_parts_list_RR[ 0] = cars.racers.duhen:0x000000CDr; // "R taillights" //
		stock_parts_list_RR[ 1] = cars.racers.duhen:0x000000C8r; // "RR quarterpanel" //

		stock_parts_list_F  = new int[6];
		stock_parts_list_F[ 0] = cars.racers.duhen:0x000000C1r; // "F bumper" //
		stock_parts_list_F[ 1] = cars.racers.duhen:0x000000C6r; // "hood" //
		stock_parts_list_F[ 2] = cars.racers.duhen:0x000000D1r; // "F windshield" //
		stock_parts_list_F[ 3] = cars.racers.duhen:0x000000DFr; // "Stock Front Grille" //
		stock_parts_list_F[ 4] = cars.racers.duhen:0x000000CEr; // "R headlights" //
		stock_parts_list_F[ 5] = cars.racers.duhen:0x000000C0r; // "L headlights" //

		stock_parts_list_Rr = new int[5];
		stock_parts_list_Rr[ 0] = cars.racers.duhen:0x000000C2r; // "R bumper" //
		stock_parts_list_Rr[ 1] = cars.racers.duhen:0x000000D2r; // "trunk" //
		stock_parts_list_Rr[ 2] = cars.racers.duhen:0x000000BFr; // "R windshield" //
		stock_parts_list_Rr[ 3] = cars.racers.duhen:0x00000ABFr; // "RL window" //
		stock_parts_list_Rr[ 4] = cars.racers.duhen:0x00000BBFr; // "RR window" //

		stock_parts_list_L  = new int[6];
		stock_parts_list_L[ 0] = cars.racers.duhen:0x000000C5r; // "L sideskirt" //
		stock_parts_list_L[ 1] = cars.racers.duhen:0x000000D4r; // "FL door" //
		stock_parts_list_L[ 2] = cars.racers.duhen:0x000000CBr; // "FL window" //
		stock_parts_list_L[ 3] = cars.racers.duhen:0x000000D8r; // "L mirror" //
		stock_parts_list_L[ 4] = cars.racers.duhen:0x000000D7r; // "Stock front seat" //
		stock_parts_list_L[ 5] = cars.racers.duhen:0x000000D7r; // "Stock front seat" //

		stock_parts_list_R  = new int[18];
		stock_parts_list_R[ 0] = cars.racers.duhen:0x000000C4r; // "R sideskirt" //
		stock_parts_list_R[ 1] = cars.racers.duhen:0x000000D0r; // "FR door" //
		stock_parts_list_R[ 2] = cars.racers.duhen:0x000000CAr; // "FR window" //
		stock_parts_list_R[ 3] = cars.racers.duhen:0x000000CFr; // "R mirror" //
		stock_parts_list_R[ 4] = cars.racers.duhen:0x000000D3r; // "FR seat" //
		stock_parts_list_R[ 5] = cars.racers.duhen:0x000000DBr; // "Stock rear panel" //
		//stock_parts_list_R[ 6] = cars.racers.duhen:0x000010C5r; // "Left wheel bay cover" //
		stock_parts_list_R[ 7] = cars.racers.duhen:0x000010C4r; // "Antenna" //
		stock_parts_list_R[ 8] = cars.racers.duhen:0x000010C4r; // "Antenna" //
		stock_parts_list_R[ 9] = cars.racers.duhen:0x00000BCFr; // "Trunk emblem" //
		stock_parts_list_R[ 10] = cars.racers.duhen:0x000010D8r; // "Rear view mirror" //
		stock_parts_list_R[ 11] = cars.racers.duhen:0x00000FC3r; // "Stock console" //
		stock_parts_list_R[ 12] = cars.racers.duhen:0x000010C7r; // "Stock shifter" //
		stock_parts_list_R[ 13] = cars.racers.duhen:0x00000AC3r; // "Stock floor carpeting" //
		stock_parts_list_R[ 14] = cars.racers.duhen:0x00000CC3r; // "Stock rear right carpeting" //
		stock_parts_list_R[ 15] = cars.racers.duhen:0x00000BC3r; // "Stock rear left carpeting" //
		stock_parts_list_R[ 16] = cars.racers.duhen:0x00000DC3r; // "Stock rear carpeting" //
		stock_parts_list_R[ 17] = cars.racers.duhen:0x00000EC3r; // "Stock trunk floormat" //


	// running gear parts lists //

		// stock 1 stuffs //

		stock_parts_list_RGear_suspensions = new int[4];
		stock_parts_list_RGear_suspensions[ 0] = parts:0x00000209r; // "Prime_FL_McPherson_strut" //
		stock_parts_list_RGear_suspensions[ 1] = parts:0x0000020Ar; // "Prime_FR_McPherson_strut" //
		stock_parts_list_RGear_suspensions[ 2] = parts:0x0000020Br; // "Prime_RL_trailing_arm" //
		stock_parts_list_RGear_suspensions[ 3] = parts:0x0000020Cr; // "Prime_RR_trailing_arm" //

		stock_parts_list_RGear_shocks = new int[4];
		stock_parts_list_RGear_shocks[ 0] = stock_parts_list_RGear_shocks[ 1] = parts:0x000001BBr; // "shock_absorber_Prime_front" //
		stock_parts_list_RGear_shocks[ 2] = stock_parts_list_RGear_shocks[ 3] = parts:0x000001BDr; // "shock_absorber_Prime_rear" //

		stock_parts_list_RGear_springs = new int[4];
		stock_parts_list_RGear_springs[ 0] = stock_parts_list_RGear_springs[ 1] = parts:0x000001E4r; // "spring_Prime_front" //
		stock_parts_list_RGear_springs[ 2] = stock_parts_list_RGear_springs[ 3] = parts:0x000001E5r; // "spring_Prime_rear" //

		stock_parts_list_RGear_brakes = new int[4];
		stock_parts_list_RGear_brakes[ 0] = stock_parts_list_RGear_brakes[ 1] = parts:0x00000174r; // "brake_Prime_front" //
		stock_parts_list_RGear_brakes[ 2] = stock_parts_list_RGear_brakes[ 3] = parts:0x00000175r; // "brake_Prime_rear" //

//		stock_parts_list_RGear_sways = new int[2];
//		stock_parts_list_RGear_sways[ 0] = parts:0x000041FFr; // "SS_15_25000Nm_2500Nms" //
//		stock_parts_list_RGear_sways[ 1] = parts:0x000041FFr; // "SS_15_25000Nm_2500Nms" //

		stock_parts_list_RGear_wheels = new int[4];
		stock_parts_list_RGear_wheels[ 0] = stock_parts_list_RGear_wheels[ 1] = cars.racers.duhen:0x000010ADr; // "Star_II_9.5x17_ET-30" //
		stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.duhen:0x000010ADr; // "Star_II_9.5x17_ET-30" //

		stock_parts_list_RGear_tyres = new int[4];
		stock_parts_list_RGear_tyres[ 0] = stock_parts_list_RGear_tyres[ 1] = cars.racers.duhen:0x000010BDr; // "245_45_17_sport" //
		stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.duhen:0x000010BDr; // "245_45_17_sport" //

		super.addStockParts( desc );

		addPart( cars.racers.Duhen:0x000000D6r, "steering wheel" );

		if (desc.power > 1.8)
		{
			NOSInjectorSystem N2Oinjector=addPart( parts.engines.Einvagen_Duhen_Ishima_Focer:0x00000052r, "NOS injector" );
			N2Oinjector.nitro_consumption = clampTo(N2Oinjector.maxconsumption*((desc.power-1.8)/0.2*0.700+0.300),N2Oinjector.minconsumption,N2Oinjector.maxconsumption);
			addPart( parts:0x000001C1r, "12pds canister" );
			addPart( parts:0x000001BFr, "24pds canister" );
		}

		addPart( cars.racers.Duhen:0x0000013Br, "stock_exhaust_pipe" );
		addPart( parts.mufflers:0x0000001Br, "muffler type 08" );
	}
}
