package java.game.cars;

import java.util.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.airfueldeliverysystem.*;


public class Duhen_Racing_SunStrip_2_0_CDVC extends Duhen_models
{
	public Duhen_Racing_SunStrip_2_0_CDVC( int id )
	{
		super( id );
		carCategory = PACKAGE;

		makerName = "Ford Motor Company";
		model = MODEL_RACING_SUNSTRIP_2_0_CDVC;
		vehicleName = "Ford Thunderbird 351 '57";
		name = "Ford Thunderbird '57 chassis";

		description = "The Ford Thunderbird began life in February 1953 in direct response to Chevrolet's new sports car, the Corvette, which was publicly unveiled in prototype form just a month before. Under rapid development, the Thunderbird went from idea to prototype in about a year, being unveiled to the public at the Detroit Auto Show on February 20, 1954. Like the Corvette, the Thunderbird had a two-seat coupe/convertible layout.Production of the Thunderbird began later on in 1954 on September 9 with the car beginning sales as a 1955 model on October 22, 1954. Though sharing some design characteristics with other Fords of the time, such as single, circular headlamps and tail lamps and modest tailfins, the Thunderbird was sleeker and more athletic in shape, and had features like a faux hood scoop and a 150 mph (240 km/h) speedometer hinting a higher performance nature that other Fords didn't possess. Mechanically though, the Thunderbird could trace its roots to other mainstream Fords. The Thunderbird's 102.0 inches (2,591 mm) wheelbase frame was mostly a shortened version of that used in other Fords while the car's standard 292 cu in (4.8 L) Y-block V8 came from Ford's Mercury division. Though inspired by, and positioned directly against, the Corvette, Ford billed the Thunderbird as a personal luxury car, putting a greater emphasis on the car's comfort and convenience features rather than its inherent sportiness.";

		value = mHUF2USD(12.733);
		brand_new_prestige_value = 70.0;

		fully_stripped_drag = 0.46;
		brake_balance_can_be_set = 1;

		exhaustSlotIDList = new Vector();
		exhaustSlotIDList.addElement( new Integer(21) );
	}

	public void addStockParts( Descriptor desc )
	{
		// stock 1 stuffs //
		stock_parts_list_E  = new int[27];
		stock_parts_list_E[ 0] = parts:0x000053FFr; // "stock battery" //
		stock_parts_list_E[ 1] = parts.engines.DEXTERV8s:0x0000004Er;	// Dexter Ford 351 Block
		stock_parts_list_E[ 2] = parts.engines.DEXTERV8s:0x00000048r;	// Dexter Ford 351 Crankshaft
		stock_parts_list_E[ 3] = parts.engines.DEXTERV8s:0x00000AFCr;	// Dexter Ford 351 Connecting Rods
		stock_parts_list_E[ 4] = parts.engines.DEXTERV8s:0x00000102r;	// Dexter Ford 351 Pistons
		stock_parts_list_E[ 5] = parts.engines.DEXTERV8s:0x0000009Br;	// Dexter Universal Crankshaft Bearing Bridge
		stock_parts_list_E[ 6] = parts.engines.DEXTERV8s:0x000000A6r;	// Dexter Universal Flywheel
		stock_parts_list_E[ 7] = parts.engines.DEXTERV8s:0x000000A7r;	// Dexter Universal Clutch
		stock_parts_list_E[ 8] = parts.engines.DEXTERV8s:0x00000095r;	// Dexter Universal Oil Pan
		stock_parts_list_E[ 9] = parts.engines.DEXTERV8s:0x0000A096r;	// Dexter Universal Oil Filter
		stock_parts_list_E[ 10] = parts.engines.DEXTERV8s:0x00000097r;	// Dexter Universal Alternator Drive Belt
		stock_parts_list_E[ 11] = parts.engines.DEXTERV8s:0x00000096r;	// Dexter Universal Alternator
		stock_parts_list_E[ 12] = parts.engines.DEXTERV8s:0x0000004Dr;	// Dexter Ford Left 302-351 Cylinder Head
		stock_parts_list_E[ 13] = parts.engines.DEXTERV8s:0x0000000Br;	// Dexter Ford Right 302-351 Cylinder Head
		stock_parts_list_E[ 14] = parts.engines.DEXTERV8s:0x000000B3r;	// Dexter Ford V8 Camshaft
		stock_parts_list_E[ 15] = parts.engines.DEXTERV8s:0x000000B3r;	// Dexter Ford V8 Camshaft
		stock_parts_list_E[ 16] = parts.engines.DEXTERV8s:0x000000BDr;	// Dexter Edelbrock Left Head Cover
		stock_parts_list_E[ 17] = parts.engines.DEXTERV8s:0x000000BCr;	// Dexter Edelbrock Right Head Cover
		stock_parts_list_E[ 18] = parts.engines.DEXTERV8s:0x0000004Br;	// Dexter Ford Intake Manifold Converter
		stock_parts_list_E[ 19] = parts.engines.DEXTERV8s:0x0000008Ar;	// Dexter Ford 4 Barrel Intake Manifold
		stock_parts_list_E[ 20] = parts.engines.DEXTERV8s:0x000000A3r;	// Dexter Ford 4 Barrel Carburetor
		stock_parts_list_E[ 21] = parts.engines.DEXTERV8s:0x00000086r;	// Dexter Universal Oval Air Filter
		stock_parts_list_E[ 22] = parts.engines.DEXTERV8s:0x0000009Ar;	// Dexter Universal Timing Chain Cover
		stock_parts_list_E[ 23] = parts.engines.DEXTERV8s:0x00000046r;	// Dexter Universal Wires
		stock_parts_list_E[ 24] = parts.engines.DEXTERV8s:0x000000B0r;	// Dexter Universal Left Exhaust Header
		stock_parts_list_E[ 25] = parts.engines.DEXTERV8s:0x000000B2r;	// Dexter Universal Right Exhaust Header
		stock_parts_list_E[ 26] = parts.engines.DEXTERV8s:0x00000103r;	// Dexter VR4E Lock Up Racing Transmission
		

		stock_parts_list_T  = new int[1];

		stock_parts_list_FL = new int[2];
		stock_parts_list_FL[ 0] = cars.racers.T_bird:0x000000C0r; // "L headlights" //
		stock_parts_list_FL[ 1] = cars.racers.T_bird:0x000000CCr; // "FL quarterpanel" //

		stock_parts_list_FR = new int[2];
		stock_parts_list_FR[ 0] = cars.racers.T_bird:0x000000CEr; // "R headlights" //
		stock_parts_list_FR[ 1] = cars.racers.T_bird:0x000000E0r; // "FR quarterpanel 2" //

		stock_parts_list_RL = new int[1];
		stock_parts_list_RL[ 0] = cars.racers.T_bird:0x000000C9r; // "L taillights" //

		stock_parts_list_RR = new int[1];
		stock_parts_list_RR[ 0] = cars.racers.T_bird:0x000000CDr; // "R taillights" //

		stock_parts_list_F  = new int[3];
		stock_parts_list_F[ 0] = cars.racers.T_bird:0x000000C1r; // "F bumper" //
		stock_parts_list_F[ 1] = cars.racers.T_bird:0x000000C6r; // "hood" //
		stock_parts_list_F[ 2] = cars.racers.T_bird:0x000000D1r; // "F windshield" //

		stock_parts_list_Rr = new int[2];
		stock_parts_list_Rr[ 0] = cars.racers.T_bird:0x000000C2r; // "R bumper 2" //
		stock_parts_list_Rr[ 1] = cars.racers.T_bird:0x000000D2r; // "trunk" //

		stock_parts_list_L = new int[4];
		stock_parts_list_L[ 0] = cars.racers.T_bird:0x000000D4r; // "FL door" //
		stock_parts_list_L[ 1] = cars.racers.T_bird:0x000000CBr; // "FL window" //
		stock_parts_list_L[ 2] = cars.racers.T_bird:0x000000D8r; // "L mirror" //
		stock_parts_list_L[ 3] = cars.racers.T_bird:0x000000D7r; // "FL seat" //

		stock_parts_list_R = new int[2];
		stock_parts_list_R[ 0] = cars.racers.T_bird:0x000000D0r; // "FR door" //
		stock_parts_list_R[ 1] = cars.racers.T_bird:0x000000CAr; // "FR window" //

	// running gear parts lists //

		// stock 1 stuffs //

		stock_parts_list_RGear_suspensions = new int[4];
		stock_parts_list_RGear_suspensions[ 0] = parts:0x00000E11r; // "SunStrip_20_FL_McPherson_strut" //
		stock_parts_list_RGear_suspensions[ 1] = parts:0x00000E13r; // "SunStrip_20_FR_McPherson_strut" //
		stock_parts_list_RGear_suspensions[ 2] = parts:0x00000E15r; // "SunStrip_20_RL_trailing_arm" //
		stock_parts_list_RGear_suspensions[ 3] = parts:0x00000E18r; // "SunStrip_20_RR_trailing_arm" //

/*		stock_parts_list_RGear_shocks = new int[4];
		stock_parts_list_RGear_shocks[ 0] = stock_parts_list_RGear_shocks[ 1] = parts.MrSir_Running_Gear:0x00000E29r; // "shock_absorber_SunStrip_20_front" //
		stock_parts_list_RGear_shocks[ 2] = stock_parts_list_RGear_shocks[ 3] = parts.MrSir_Running_Gear:0x00000E29r; // "shock_absorber_SunStrip_20_rear" //

		stock_parts_list_RGear_springs = new int[4];
		stock_parts_list_RGear_springs[ 0] = stock_parts_list_RGear_springs[ 1] = parts.MrSir_Running_Gear:0x00000E83r; // "spring_SunStrip_20_front" //
		stock_parts_list_RGear_springs[ 2] = stock_parts_list_RGear_springs[ 3] = parts.MrSir_Running_Gear:0x00000E83r; // "spring_SunStrip_20_rear" //

stock_parts_list_RGear_brakes = new int[8];
		stock_parts_list_RGear_brakes[ 0] = stock_parts_list_RGear_brakes[ 1] = parts.CMS_Brakes:0x00000E13r; // "brake_Focer_200_front" //
		stock_parts_list_RGear_brakes[ 2] = stock_parts_list_RGear_brakes[ 3] = parts.CMS_Brakes:0x00000E13r; // "brake_Focer_200_rear" //
        stock_parts_list_RGear_brakes[ 4] = stock_parts_list_RGear_brakes[ 5] = parts.CMS_Brakes:0x00000E28r; // "caliper_Focer_200_front" //
		stock_parts_list_RGear_brakes[ 6] = stock_parts_list_RGear_brakes[ 7] = parts.CMS_Brakes:0x00000E28r; // "caliper_Focer_200_rear" */
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
//		stock_parts_list_RGear_sways[ 0] = parts:0x00000182r; // "swaybar_SunStrip_20_front" //
//		stock_parts_list_RGear_sways[ 1] = parts:0x00000184r; // "swaybar_SunStrip_20_rear" //

		stock_parts_list_RGear_wheels = new int[4];
		stock_parts_list_RGear_wheels[ 0] = stock_parts_list_RGear_wheels[ 1] = cars.racers.T_bird:0x00001028r; // "Ford Thunderbird Rim 15x8" //
		stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.T_bird:0x00001028r; // "Ford Thunderbird Rim 15x8" //

		stock_parts_list_RGear_tyres = new int[4];
		stock_parts_list_RGear_tyres[ 0] = stock_parts_list_RGear_tyres[ 1] = parts.wheels:0x000003CFr; // "tyre 195 50 16 7.5 LOD CATALOG GARAGE" //
		stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = parts.wheels:0x000003CFr; // "tyre 195 50 16 7.5 LOD CATALOG GARAGE" //

		/*
		stock_parts_list_RGear_tyres = new int[4];
		stock_parts_list_RGear_tyres[ 0] = stock_parts_list_RGear_tyres[ 1] = parts.mopar_tires:0x00009997r; // "Whitewalls 15x8" //
		stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = parts.mopar_tires:0x00009997r; // "Whitewalls 15x8" */

		super.addStockParts( desc );

		addPart( cars.racers.T_bird:0x000000D6r, "steering wheel" );

		if (desc.power > 1.8)
		{
			NOSInjectorSystem N2Oinjector=addPart( parts.engines.Einvagen_Duhen_Ishima_Focer:0x00000052r, "NOS injector" );
			N2Oinjector.nitro_consumption = clampTo(N2Oinjector.maxconsumption*((desc.power-1.8)/0.2*0.750+0.250),N2Oinjector.minconsumption,N2Oinjector.maxconsumption);
			addPart( parts:0x000001C1r, "12pds canister" );
			addPart( parts:0x000001BFr, "24pds canister" );
		}

		addPart( cars.racers.T_bird:0x0000023Br, "turbo_exhaust_pipe" );
		addPart( parts.mufflers:0x0000001Fr, "muffler type 12" );
	}
}
