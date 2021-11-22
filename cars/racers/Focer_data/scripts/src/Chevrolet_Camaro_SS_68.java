package java.game.cars;

import java.util.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.airfueldeliverysystem.*;
import java.game.parts.enginemodels.*;

public class Chevrolet_Camaro_SS_68 extends Chevrolet_Camaro_68_models
{
	public Chevrolet_Camaro_SS_68( int id )
	{
		super( id );
		carCategory = PACKAGE;

		makerName = "General Motors Company";
		model = CHEVY_CAMARO_SS_68;
		vehicleName = "Chevrolet Camaro SS '68";
		name = "Chevrolet Camaro '68 chassis";
		description = "The first-generation Chevrolet Camaro appeared in Chevrolet dealerships in September 1966, for the 1967 model year on a brand-new rear-wheel drive GM F-body platform and was available as a 2-door, 2+2 seat, hardtop (no B or center pillar) or convertible with a choice of six-cylinder and V8 power plants. The first-generation Camaro was built through the 1969 model year. The SS performance package consisted of a 350 or 396 cu in V8 engine and chassis upgrades for better handling and to deal with the additional power. The SS featured non-functional air inlets on the hood, special striping, and SS badging.";

		// easter egg: EE-RC200C on the LCD screen built into the dash //

		value = mHUF2USD(7.75);
		brand_new_prestige_value = 50.0;

		fully_stripped_drag = 0.55;
		brake_balance_can_be_set = 1;

		exhaustSlotIDList = new Vector();
		exhaustSlotIDList.addElement( new Integer(39) );
	}

	public void addStockParts( Descriptor desc )
	{
		// stock 1 stuffs //

		float number = random();
		float number2;		
		stock_parts_list_E = EngineModels.getGmEngine( EngineModels.GM_V8_283 );
				
		stock_parts_list_FL = new int[2];
		stock_parts_list_FL[ 0] = cars.racers.focer:0x000000A3r; // "L headlights" //
		stock_parts_list_FL[ 1] = cars.racers.focer:0x000000AEr; // "FL quarterpanel" //

		stock_parts_list_FR = new int[2];
		stock_parts_list_FR[ 0] = cars.racers.focer:0x000000BAr; // "R headlights" //
		stock_parts_list_FR[ 1] = cars.racers.focer:0x000000B8r; // "FR quarterpanel" //

		stock_parts_list_RL = new int[2];
		stock_parts_list_RL[ 0] = cars.racers.focer:0x000000A5r; // "L taillights" //
		stock_parts_list_RL[ 1] = cars.racers.focer:0x000000B2r; // "RL quarterpanel" //

		stock_parts_list_RR = new int[2];
		stock_parts_list_RR[ 0] = cars.racers.focer:0x000000BBr; // "R taillights" //
		stock_parts_list_RR[ 1] = cars.racers.focer:0x000000B9r; // "RR quarterpanel" //

		stock_parts_list_F  = new int[3];
		stock_parts_list_F[ 0] = cars.racers.focer:0x000000AFr; // "F bumper" //
		
		stock_parts_list_T  = new int[1];
		stock_parts_list_T[ 0] = cars.racers.focer:0x000000C1r; // "Rf airduct" //

		stock_parts_list_FL = new int[2];
		stock_parts_list_FL[ 0] = cars.racers.focer:0x000000A3r; // "L headlights" //
		stock_parts_list_FL[ 1] = cars.racers.focer:0x000000AEr; // "FL quarterpanel" //

		stock_parts_list_FR = new int[2];
		stock_parts_list_FR[ 0] = cars.racers.focer:0x000000BAr; // "R headlights" //
		stock_parts_list_FR[ 1] = cars.racers.focer:0x000000B8r; // "FR quarterpanel" //

		stock_parts_list_RL = new int[2];
		stock_parts_list_RL[ 0] = cars.racers.focer:0x000000A5r; // "L taillights" //
		stock_parts_list_RL[ 1] = cars.racers.focer:0x000000B2r; // "RL quarterpanel" //

		stock_parts_list_RR = new int[2];
		stock_parts_list_RR[ 0] = cars.racers.focer:0x000000BBr; // "R taillights" //
		stock_parts_list_RR[ 1] = cars.racers.focer:0x000000B9r; // "RR quarterpanel" //

		stock_parts_list_F  = new int[3];
		stock_parts_list_F[ 0] = cars.racers.focer:0x000000AFr; // "F bumper" //
		
		number = random();
		
		if ( number < 0.2 )
		{
			stock_parts_list_F[ 1] = cars.racers.focer:0x000020A4r; // "Cowl-induction hood" //
		}
		else if ( number < 0.4 )
		{
			stock_parts_list_F[ 1] = cars.racers.focer:0x000030A4r; // "Fiber glass blower hood" //
		}
		else
		{
			stock_parts_list_F[ 1] = cars.racers.focer:0x000000A4r; // "hood" //
		}

		stock_parts_list_F[ 2] = cars.racers.focer:0x000000BDr; // "F windshield" //

		stock_parts_list_Rr = new int[5];
		stock_parts_list_Rr[ 0] = cars.racers.focer:0x000000B3r; // "R bumper" //
		stock_parts_list_Rr[ 1] = cars.racers.focer:0x000000A6r; // "trunk" //
		stock_parts_list_Rr[ 2] = cars.racers.focer:0x000000C2r; // "R wing" //
		stock_parts_list_Rr[ 3] = cars.racers.focer:0x00000AA7r; // "R windshield" //
		stock_parts_list_Rr[ 4] = cars.racers.focer:0x000000ACr; // "R seats" //

		stock_parts_list_L  = new int[7];
		stock_parts_list_L[ 0] = cars.racers.focer:0x000000B0r; // "L sideskirt" //
		stock_parts_list_L[ 1] = cars.racers.focer:0x000000A8r; // "FL door" //
		stock_parts_list_L[ 2] = cars.racers.focer:0x000000B1r; // "RL door" //
		stock_parts_list_L[ 3] = cars.racers.focer:0x000000ADr; // "FL window" //
		stock_parts_list_L[ 4] = cars.racers.focer:0x000000BFr; // "L mirror" //
		stock_parts_list_L[ 5] = cars.racers.focer:0x000000B4r; // "RL window" //
		stock_parts_list_L[ 6] = cars.racers.focer:0x000000AAr; // "FL seat" //

		stock_parts_list_R  = new int[41];
		stock_parts_list_R[ 0] = cars.racers.focer:0x000000BEr; // "R sideskirt" //
		stock_parts_list_R[ 1] = cars.racers.focer:0x000000B6r; // "FR door" //
		stock_parts_list_R[ 2] = cars.racers.focer:0x000000B7r; // "RR door" //
		stock_parts_list_R[ 3] = cars.racers.focer:0x000000A9r; // "FR window" //
		stock_parts_list_R[ 4] = cars.racers.focer:0x000000C0r; // "R mirror" //
		stock_parts_list_R[ 5] = cars.racers.focer:0x000000B5r; // "RR window" //
		//stock_parts_list_R[ 6] = cars.racers.focer:0x000000BCr; // "Racing rollcage" //
		stock_parts_list_R[ 7] = cars.racers.focer:0x000010AEr; // "Stock left mud guard" //
		stock_parts_list_R[ 8] = cars.racers.focer:0x000010B8r; // "Stock right mud guard" //
		stock_parts_list_R[ 9] = cars.racers.focer:0x00000AAEr; // "Stock front left fender (w black strip)" //
		stock_parts_list_R[ 10] = cars.racers.focer:0x00000AB8r; // "Stock front right fender (w black strip)" //
		stock_parts_list_R[ 11] = cars.racers.focer:0x00002AAFr; // "Stock grille bay upper panel (w black strip)" //
		stock_parts_list_R[ 12] = cars.racers.focer:0x000051AFr; // "SS front grille" //
		stock_parts_list_R[ 13] = cars.racers.focer:0x000030AFr; // "SS front lower valance panel" //
		stock_parts_list_R[ 14] = cars.racers.focer:0x000040AFr; // "Stock front grille filler" //
		stock_parts_list_R[ 15] = cars.racers.focer:0x000010AFr; // "Stock front under-windshield panel" //
		stock_parts_list_R[ 16] = cars.racers.focer:0x000000AFr; // "Stock front bumper" //
		stock_parts_list_R[ 17] = cars.racers.focer:0x000011AFr; // "Stock front heater air fins" //
		stock_parts_list_R[ 18] = cars.racers.focer:0x000000C1r; // "Stock wipers" //
		stock_parts_list_R[ 19] = cars.racers.focer:0x000010BFr; // "Stock rear view mirror" //
		stock_parts_list_R[ 20] = cars.racers.focer:0x000030AEr; // "Stock left fender wheel bay trim" //
		stock_parts_list_R[ 21] = cars.racers.focer:0x000020AEr; // "Stock left fender horizontal trim" //
		stock_parts_list_R[ 22] = cars.racers.focer:0x000030B8r; // "Stock right fender wheel bay trim" //
		stock_parts_list_R[ 23] = cars.racers.focer:0x000020B8r; // "Stock right fender horizontal trim" //
		stock_parts_list_R[ 24] = cars.racers.focer:0x000010C1r; // "Stock console" //
		stock_parts_list_R[ 25] = cars.racers.focer:0x000020C1r; // "Stock shifter" //
		stock_parts_list_R[ 26] = cars.racers.focer:0x000010BDr; // "Stock roof carpeting" //
		stock_parts_list_R[ 27] = cars.racers.focer:0x000030BDr; // "Stock left side carpeting" //
		stock_parts_list_R[ 28] = cars.racers.focer:0x000040BDr; // "Stock right side carpeting" //
		stock_parts_list_R[ 29] = cars.racers.focer:0x000050BDr; // "Stock rear carpeting" //
		stock_parts_list_R[ 30] = cars.racers.focer:0x000060BDr; // "Stock trunk carpeting" //
		stock_parts_list_R[ 31] = cars.racers.focer:0x000021AFr; // "Front upper camaro emblem" //
		stock_parts_list_R[ 32] = cars.racers.focer:0x00005AAFr; // "SS grille emblem" //
		stock_parts_list_R[ 33] = cars.racers.focer:0x000040AEr; // "Stock left fender camaro emblem" //
		stock_parts_list_R[ 34] = cars.racers.focer:0x000040B8r; // "Stock right fender camaro emblem" //
		stock_parts_list_R[ 35] = cars.racers.focer:0x000020BDr; // "Stock floor carpeting" //
		stock_parts_list_R[ 36] = cars.racers.focer:0x000010B3r; // "Stock rear panel" //
		stock_parts_list_R[ 37] = cars.racers.focer:0x000000A5r; // "Stock left taillights" //
		stock_parts_list_R[ 38] = cars.racers.focer:0x000000BBr; // "Stock right taillights" //
		stock_parts_list_R[ 39] = cars.racers.focer:0x000020B3r; // "SS fuel cup" //
		stock_parts_list_R[ 40] = cars.racers.focer:0x000000AAr; // "Stock front seat" //

	// running gear parts lists //

		// stock 1 stuffs //

		//////////////////
		// SUSPENSSIONS //
		//////////////////
		
		number = random();
					
		if ( number < 0.6 )
		{
			stock_parts_list_RGear_suspensions = new int[4];
			stock_parts_list_RGear_suspensions[ 0] = parts:0x00000211r; // "Focer_300_FL_McPherson_strut" //
			stock_parts_list_RGear_suspensions[ 1] = parts:0x00000212r; // "Focer_300_FR_McPherson_strut" //
			stock_parts_list_RGear_suspensions[ 2] = parts:0x00000213r; // "Focer_300_RL_trailing_arm" //
			stock_parts_list_RGear_suspensions[ 3] = parts:0x00000214r; // "Focer_300_RR_trailing_arm" //

			stock_parts_list_RGear_shocks = new int[4];
			stock_parts_list_RGear_shocks[ 0] = stock_parts_list_RGear_shocks[ 1] = parts:0x000001C6r; // "shock_absorber_Focer_300_front" //
			stock_parts_list_RGear_shocks[ 2] = stock_parts_list_RGear_shocks[ 3] = parts:0x000001D3r; // "shock_absorber_Focer_300_rear" //

			stock_parts_list_RGear_springs = new int[4];
			stock_parts_list_RGear_springs[ 0] = stock_parts_list_RGear_springs[ 1] = parts:0x000001E8r; // "spring_Focer_300_front" //
			stock_parts_list_RGear_springs[ 2] = stock_parts_list_RGear_springs[ 3] = parts:0x000001E9r; // "spring_Focer_300_rear" //
			
			stock_parts_list_RGear_brakes = new int[4];
			stock_parts_list_RGear_brakes[ 0] = stock_parts_list_RGear_brakes[ 1] = parts:0x00000178r; // "brake_Focer_300_front" //
			stock_parts_list_RGear_brakes[ 2] = stock_parts_list_RGear_brakes[ 3] = parts:0x00000179r; // "brake_Focer_300_rear" //
		}
		else
		{
			stock_parts_list_RGear_suspensions = new int[4];
			stock_parts_list_RGear_suspensions[ 0] = parts:0x00000215r; // "Focer_WRC_FL_McPherson_strut" //
			stock_parts_list_RGear_suspensions[ 1] = parts:0x00000216r; // "Focer_WRC_FR_McPherson_strut" //
			stock_parts_list_RGear_suspensions[ 2] = parts:0x00000217r; // "Focer_WRC_RL_trailing_arm" //
			stock_parts_list_RGear_suspensions[ 3] = parts:0x00000218r; // "Focer_WRC_RR_trailing_arm" //

			stock_parts_list_RGear_shocks = new int[4];
			stock_parts_list_RGear_shocks[ 0] = stock_parts_list_RGear_shocks[ 1] = parts:0x000001D4r; // "shock_absorber_Focer_WRC_front" //
			stock_parts_list_RGear_shocks[ 2] = stock_parts_list_RGear_shocks[ 3] = parts:0x000001D5r; // "shock_absorber_Focer_WRC_rear" //

			stock_parts_list_RGear_springs = new int[4];
			stock_parts_list_RGear_springs[ 0] = stock_parts_list_RGear_springs[ 1] = parts:0x000001EAr; // "spring_Focer_WRC_front" //
			stock_parts_list_RGear_springs[ 2] = stock_parts_list_RGear_springs[ 3] = parts:0x000001EBr; // "spring_Focer_WRC_rear" //
			
			stock_parts_list_RGear_brakes = new int[4];
			stock_parts_list_RGear_brakes[ 0] = stock_parts_list_RGear_brakes[ 1] = parts:0x0000017Ar; // "brake_Focer_WRC_front" //
			stock_parts_list_RGear_brakes[ 2] = stock_parts_list_RGear_brakes[ 3] = parts:0x0000017Br; // "brake_Focer_WRC_rear" //
		}

//		stock_parts_list_RGear_sways = new int[2];
//		stock_parts_list_RGear_sways[ 0] = parts:0x000001A4r; // "swaybar_Focer_300_front" //
//		stock_parts_list_RGear_sways[ 1] = parts:0x000001A6r; // "swaybar_Focer_300_rear" //

		///////////////////
		// RIM SELECTION //
		///////////////////
		
		int rim_front;
		int rim_back;
		
		number = random();
		
		stock_parts_list_RGear_wheels = new int[4];	
		
		if ( number < 0.38 )
		{
			stock_parts_list_RGear_wheels[ 0] = stock_parts_list_RGear_wheels[ 1] = cars.racers.focer:0x00003119r; // 15x8
			rim_front = 8;
			
			number2 = random();
					
			if ( number2 < 0.62 )
			{
				stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.focer:0x00003119r; //
				rim_back = 8;
			}
			else
			{
				stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.focer:0x00001A19r; //
				rim_back = 10;
			}
		}
		else if ( number < 0.63 )
		{
			stock_parts_list_RGear_wheels[ 0] = stock_parts_list_RGear_wheels[ 1] = cars.racers.focer:0x00002119r; // 15x8
			rim_front = 8;
			
			number2 = random();
					
			if ( number2 < 0.62 )
			{
				stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.focer:0x00002119r; //
				rim_back = 8;
			}
			else
			{
				stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.focer:0x00002A19r; //
				rim_back = 10;
			}
		}
		else if ( number < 0.83 )
		{
			stock_parts_list_RGear_wheels[ 0] = stock_parts_list_RGear_wheels[ 1] = cars.racers.focer:0x00003119r; // 15x8
			rim_front = 8;
			
			number2 = random();
					
			if ( number2 < 0.62 )
			{
				stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.focer:0x00003119r; //
				rim_back = 8;
			}
			else
			{
				stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.focer:0x00003A19r; //
				rim_back = 10;
			}
		}
		else
		{
			stock_parts_list_RGear_wheels[ 0] = stock_parts_list_RGear_wheels[ 1] = cars.racers.focer:0x00004119r; // 15x8
			rim_front = 8;
			
			number2 = random();
					
			if ( number2 < 0.62 )
			{
				stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.focer:0x00004119r; //
				rim_back = 8;
			}
			else if ( number2 < 0.87 )
			{
				stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.focer:0x00004A19r; //
				rim_back = 10;
			}
			else
			{
				stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.focer:0x00004B19r; //
				rim_back = 15;
			}
		}
		
		////////////////////
		// Tyre SELECTION //
		////////////////////

		stock_parts_list_RGear_tyres = new int[4];
		
		number = random();
		
		switch ( rim_front )
		{
			case 8:
				if ( number < 0.58 )
				{
					stock_parts_list_RGear_tyres[ 0] = stock_parts_list_RGear_tyres[ 1] = cars.racers.focer:0x0000111Er; //
				}
				else
				{
					stock_parts_list_RGear_tyres[ 0] = stock_parts_list_RGear_tyres[ 1] = cars.racers.focer:0x0000211Er; //
				}
				break;
			case 10:
				if ( number < 0.58 )
				{
					stock_parts_list_RGear_tyres[ 0] = stock_parts_list_RGear_tyres[ 1] = cars.racers.focer:0x00001A1Er; //
				}
				else
				{
					stock_parts_list_RGear_tyres[ 0] = stock_parts_list_RGear_tyres[ 1] = cars.racers.focer:0x00002A1Er; //
				}
				break;
		}
		
		number = random();
		
		switch ( rim_back )
		{
			case 8:
				if ( number < 0.58 )
				{
					stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.focer:0x0000111Er; //
				}
				else
				{
					stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.focer:0x0000211Er; //
				}
				break;
			case 10:
				if ( number < 0.58 )
				{
					stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.focer:0x00001A1Er; //
				}
				else
				{
					stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.focer:0x00002A1Er; //
				}
				break;
			case 15:
					stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.focer:0x00002B1Er; //
				break;
		}

		super.addStockParts( desc );

		addPart( cars.racers.Focer:0x000000ABr, "steering wheel" );

	}
}
