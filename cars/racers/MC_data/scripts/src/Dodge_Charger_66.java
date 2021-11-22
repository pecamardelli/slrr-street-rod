package java.game.cars;

import java.util.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.airfueldeliverysystem.*;
import java.game.parts.enginemodels.*;

public class Dodge_Charger_66 extends Dodge_Charger_66_models
{
	public Dodge_Charger_66( int id )
	{
		super( id );
		carCategory = PACKAGE;

		makerName = "Dodge Brothers Motor Vehicle Company";
		model = DODGE_CHARGER_66;
		vehicleName = "Dodge Charger '66";
		name = "Dodge Charger '66 chassis";

		description = "A mid-1966 surprise was Dodge's Coronet-based Charger fastback. Sharing its chassis and front-end sheet-metal with the mid-sized Dodge Coronet, the Charger still looked a lot like a Coronet or AMC’s conceptually similar Rambler Marlin substantially more expensive than either. The Charger with a $3,100 base price was immediately paired up in the automotive press with American Motors' year-old Marlin, another fastback specialty machine that came in at around $2,850 and some called the Charger a good-looking Marlin. The Charger's interior was different from all other cars with its back seats that folded down and created a station wagon or camper usefulness. The Charger didn't begin with the performance/ muscle car image, though you could get a Hemi with it. The Charger evolved into possibly the top Chrysler-made muscle car. The 1966 and 1967 model years of the Charger are also the only Dodge cars that displayed the Fratzog Emblem on the grill as well as the trunk hatch.";

		value = mHUF2USD(8.242);
		brand_new_prestige_value = 51.20;

		fully_stripped_drag = 0.55;

		exhaustSlotIDList = new Vector();
		exhaustSlotIDList.addElement( new Integer(24) );
		exhaustSlotIDList.addElement( new Integer(39) );
	}

	public void addStockParts( Descriptor desc )
	{
		float number = random();
		float number2;		
		stock_parts_list_E = EngineModels.getChryslerEngine( EngineModels.CHRYSLER_V8_318 );
		
		stock_parts_list_FL = new int[2];
		stock_parts_list_FL[ 0] = cars.racers.mc:0x000000A8r; // "L headlights" //
		stock_parts_list_FL[ 1] = cars.racers.mc:0x000000B9r; // "FL quarterpanel" //

		stock_parts_list_FR = new int[2];
		stock_parts_list_FR[ 0] = cars.racers.mc:0x000000BCr; // "R headlights" //
		stock_parts_list_FR[ 1] = cars.racers.mc:0x000000C4r; // "FR quarterpanel" //

		stock_parts_list_RL = new int[2];
		stock_parts_list_RL[ 0] = cars.racers.mc:0x000000ACr; // "L taillights" //
		stock_parts_list_RL[ 1] = cars.racers.mc:0x000000BBr; // "RL quarterpanel" //

		stock_parts_list_RR = new int[2];
		stock_parts_list_RR[ 0] = cars.racers.mc:0x000000BDr; // "R taillights" //
		stock_parts_list_RR[ 1] = cars.racers.mc:0x000000C3r; // "RR quarterpanel" //

		stock_parts_list_F  = new int[6];
		stock_parts_list_F[ 0] = cars.racers.mc:0x000000A7r; // "F bumper" //
		stock_parts_list_F[ 1] = cars.racers.mc:0x000000B8r; // "F grill frame A" //
		stock_parts_list_F[ 2] = cars.racers.mc:0x000000BAr; // "F grill frame B" //
		stock_parts_list_F[ 3] = cars.racers.mc:0x000000B7r; // "F grill" //
		stock_parts_list_F[ 4] = cars.racers.mc:0x000000B6r; // "hood" //
		stock_parts_list_F[ 5] = cars.racers.mc:0x000000B0r; // "F windshield" //

		stock_parts_list_Rr = new int[4];
		stock_parts_list_Rr[ 0] = cars.racers.mc:0x000000AAr; // "R bumper" //
		stock_parts_list_Rr[ 1] = cars.racers.mc:0x000000ADr; // "trunk" //
		stock_parts_list_Rr[ 2] = cars.racers.mc:0x000000B1r; // "R windshield" //
		stock_parts_list_Rr[ 3] = cars.racers.mc:0x000000B4r; // "R seats" //

		stock_parts_list_L  = new int[2];
		stock_parts_list_L[ 0] = cars.racers.mc:0x000000AEr; // "FL door" //
		stock_parts_list_L[ 1] = cars.racers.mc:0x000000B2r; // "FL seat" //

		stock_parts_list_R  = new int[25];
		stock_parts_list_R[ 0] = cars.racers.mc:0x000000C2r; // "FR door" //
		stock_parts_list_R[ 1] = cars.racers.mc:0x000000BFr; // "FR seat" //
		stock_parts_list_R[ 3] = cars.racers.mc:0x000000C5r; // "R view mirror" //
		stock_parts_list_R[ 4] = cars.racers.mc:0x000030C3r; // "R wheel bay chrome trim" //
		stock_parts_list_R[ 5] = cars.racers.mc:0x000030BBr; // "L wheel bay chrome trim" //
		stock_parts_list_R[ 6] = cars.racers.mc:0x000040BBr; // "L sidescirt chrome trim" //
		stock_parts_list_R[ 7] = cars.racers.mc:0x000040C3r; // "R sidescirt chrome trim" //
		stock_parts_list_R[ 8] = cars.racers.mc:0x000020BBr; // "L middle chrome trim" //
		stock_parts_list_R[ 9] = cars.racers.mc:0x000020C3r; // "R middle chrome trim" //
		stock_parts_list_R[ 10] = cars.racers.mc:0x000010C3r; // "R upper chrome trim" //
		stock_parts_list_R[ 11] = cars.racers.mc:0x000010BBr; // "L upper chrome trim" //
		stock_parts_list_R[ 12] = cars.racers.mc:0x00000110r; // "Stock floor carpeting" //
		stock_parts_list_R[ 13] = cars.racers.mc:0x0000A110r; // "Stock roof carpeting" //
		stock_parts_list_R[ 14] = cars.racers.mc:0x0000A410r; // "Stock left side carpeting" //
		stock_parts_list_R[ 15] = cars.racers.mc:0x0000A510r; // "Stock right side carpeting" //
		stock_parts_list_R[ 16] = cars.racers.mc:0x0000B110r; // "Stock rear carpeting" //
		stock_parts_list_R[ 17] = cars.racers.mc:0x0000C110r; // "Stock trunk carpeting" //
		stock_parts_list_R[ 18] = cars.racers.mc:0x00002011r; // "Stock shifter" //
		stock_parts_list_R[ 19] = cars.racers.mc:0x00000AB0r; // "Stock rear left window" //
		stock_parts_list_R[ 20] = cars.racers.mc:0x00000BB0r; // "Stock rear right window" //
		stock_parts_list_R[ 21] = cars.racers.mc:0x000000B4r; // "Stock rear seat" //
		stock_parts_list_R[ 22] = cars.racers.mc:0x000000B2r; // "Stock front seat" //
		stock_parts_list_R[ 23] = cars.racers.mc:0x00001011r; // "Stock rear view mirror" //
		stock_parts_list_R[ 24] = cars.racers.mc:0x00000111r; // "Stock console" //

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
//		stock_parts_list_RGear_sways[ 0] = parts:0x00000199r; // "swaybar_MC_GT_front" //
//		stock_parts_list_RGear_sways[ 1] = parts:0x0000019Ar; // "swaybar_MC_GT_rear" //


		stock_parts_list_RGear_wheels = new int[4];
		stock_parts_list_RGear_tyres = new int[4];
		
		switch ( stock_parts_list_E[ 1] )
		{
			case parts.engines.Chrysler_V8_pak:0x0000E318r:
				stock_parts_list_RGear_wheels[ 0] = stock_parts_list_RGear_wheels[ 1] = parts.mopar_wheels:0x00009975r; // Chrysler steel 15x8
				stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = parts.mopar_wheels:0x00009975r; // Chrysler steel 15x8
				stock_parts_list_RGear_tyres[ 0] = stock_parts_list_RGear_tyres[ 1] = cars.racers.mc:0x000011ABr; // "tyre 215 50 15 8.0 LOD CATALOG GARAGE" //
				stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.mc:0x000011ABr; // "tyre 255 50 15 9.5 LOD CATALOG GARAGE" //
				break;
			case parts.engines.Chrysler_V8_pak:0x0000E340r:
				number = random();
				
				if ( number < 0.5 )
				{
					stock_parts_list_RGear_wheels[ 0] = stock_parts_list_RGear_wheels[ 1] = parts.mopar_wheels:0x00009975r; // Chrysler steel 15x8
					stock_parts_list_RGear_tyres[ 0] = stock_parts_list_RGear_tyres[ 1] = cars.racers.mc:0x000011ABr; // 
					
					number2 = random();
					
					if ( number2 < 0.7 )
					{
						stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = parts.mopar_wheels:0x00009975r; // Chrysler steel 15x8
						stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.mc:0x000011ABr; // "tyre 255 50 15 9.5 LOD CATALOG GARAGE" //
					}
					else
					{
						stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = parts.mopar_wheels:0x000015C5r; // Chrysler steel 15x11
						stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.mc:0x000012ABr; //
					}
				}
				else
				{
					stock_parts_list_RGear_wheels[ 0] = stock_parts_list_RGear_wheels[ 1] = cars.racers.mc:0x0000110Br; //
					stock_parts_list_RGear_tyres[ 0] = stock_parts_list_RGear_tyres[ 1] = cars.racers.mc:0x000011ABr; // 
					
					number2 = random();
					
					if ( number2 < 0.6 )
					{
						stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.mc:0x0000110Br; //
						stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.mc:0x000011ABr; //
					}
					else
					{
						stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.mc:0x0000120Br; //
						stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.mc:0x000012ABr; //
					}
				}
				break;
			case parts.engines.Chrysler_V8_pak:0x0000E360r:
				number = random();
				
				if ( number < 0.5 )
				{
					stock_parts_list_RGear_wheels[ 0] = stock_parts_list_RGear_wheels[ 1] = parts.mopar_wheels:0x00009975r; // Chrysler steel 15x8
					stock_parts_list_RGear_tyres[ 0] = stock_parts_list_RGear_tyres[ 1] = cars.racers.mc:0x000011ABr; // 
					
					number2 = random();
					
					if ( number2 < 0.7 )
					{
						stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = parts.mopar_wheels:0x00009975r; // Chrysler steel 15x8
						stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.mc:0x000011ABr; // "tyre 255 50 15 9.5 LOD CATALOG GARAGE" //
					}
					else
					{
						stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = parts.mopar_wheels:0x000015C5r; // Chrysler steel 15x11
						stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.mc:0x000012ABr; //
					}
				}
				else
				{
					stock_parts_list_RGear_wheels[ 0] = stock_parts_list_RGear_wheels[ 1] = cars.racers.mc:0x0000110Br; //
					stock_parts_list_RGear_tyres[ 0] = stock_parts_list_RGear_tyres[ 1] = cars.racers.mc:0x000011ABr; // 
					
					number2 = random();
					
					if ( number2 < 0.6 )
					{
						stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.mc:0x0000110Br; //
						stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.mc:0x000011ABr; //
					}
					else
					{
						stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.mc:0x0000120Br; //
						stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.mc:0x000012ABr; //
					}
				}
				break;
			case parts.engines.Chrysler_V8_pak:0x0000E361r:
				number = random();
				
				if ( number < 0.4 )
				{
					stock_parts_list_RGear_wheels[ 0] = stock_parts_list_RGear_wheels[ 1] = cars.racers.mc:0x0000110Br; //
					stock_parts_list_RGear_tyres[ 0] = stock_parts_list_RGear_tyres[ 1] = cars.racers.mc:0x000011ABr; // 
					
					number2 = random();
					
					if ( number2 < 0.6 )
					{
						stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.mc:0x0000110Br; //
						stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.mc:0x000011ABr; //
					}
					else
					{
						stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.mc:0x0000120Br; //
						stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.mc:0x000012ABr; //
					}
				}
				else
				{
					stock_parts_list_RGear_wheels[ 0] = stock_parts_list_RGear_wheels[ 1] = cars.racers.mc:0x0000210Br; //
					stock_parts_list_RGear_tyres[ 0] = stock_parts_list_RGear_tyres[ 1] = cars.racers.mc:0x000011ABr; // 
					
					number2 = random();
					
					if ( number2 < 0.6 )
					{
						stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.mc:0x0000210Br; //
						stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.mc:0x000011ABr; //
					}
					else
					{
						stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.mc:0x0000220Br; //
						stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.mc:0x000012ABr; //
					}
				}
				break;
			case parts.engines.Chrysler_V8_pak:0x0000E383r:
				number = random();
				
				if ( number < 0.3 )
				{
					stock_parts_list_RGear_wheels[ 0] = stock_parts_list_RGear_wheels[ 1] = cars.racers.mc:0x0000110Br; //
					stock_parts_list_RGear_tyres[ 0] = stock_parts_list_RGear_tyres[ 1] = cars.racers.mc:0x000011ABr; // 
					
					number2 = random();
					
					if ( number2 < 0.6 )
					{
						stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.mc:0x0000110Br; //
						stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.mc:0x000011ABr; //
					}
					else
					{
						stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.mc:0x0000120Br; //
						stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.mc:0x000012ABr; //
					}
				}
				else if ( number < 0.6 )
				{
					stock_parts_list_RGear_wheels[ 0] = stock_parts_list_RGear_wheels[ 1] = cars.racers.mc:0x0000210Br; //
					stock_parts_list_RGear_tyres[ 0] = stock_parts_list_RGear_tyres[ 1] = cars.racers.mc:0x000011ABr; // 
					
					number2 = random();
					
					if ( number2 < 0.6 )
					{
						stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.mc:0x0000210Br; //
						stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.mc:0x000011ABr; //
					}
					else
					{
						stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.mc:0x0000220Br; //
						stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.mc:0x000012ABr; //
					}
				}
				else
				{
					stock_parts_list_RGear_wheels[ 0] = stock_parts_list_RGear_wheels[ 1] = cars.racers.MC:0x0000210Br; // Cragar black 15x8
					stock_parts_list_RGear_tyres[ 0] = stock_parts_list_RGear_tyres[ 1] = cars.racers.Nonus:0x000020C0r; // Goodyear Eagle ST 215/60
					
					number2 = random();
					
					if ( number2 < 0.5 )
					{
						stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.MC:0x0000210Br; // Cragar black 15x8
						stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.Nonus:0x000020C0r; // Goodyear Eagle ST 215/60
					}
					else
					{
						stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.MC:0x0000220Br; // Cragar black 15x10
						stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.Nonus:0x00002AC0r; // Goodyear Eagle ST 255/60
					}
				}
				break;
			case parts.engines.Chrysler_V8_pak:0x0000E400r:
				number = random();
				
				if ( number < 0.5 )
				{
					stock_parts_list_RGear_wheels[ 0] = stock_parts_list_RGear_wheels[ 1] = parts.mopar_wheels:0x00009975r; // Chrysler steel 15x8
					stock_parts_list_RGear_tyres[ 0] = stock_parts_list_RGear_tyres[ 1] = cars.racers.mc:0x000011ABr; // 
					
					number2 = random();
					
					if ( number2 < 0.7 )
					{
						stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = parts.mopar_wheels:0x00009975r; // Chrysler steel 15x8
						stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.mc:0x000011ABr; // "tyre 255 50 15 9.5 LOD CATALOG GARAGE" //
					}
					else
					{
						stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = parts.mopar_wheels:0x000015C5r; // Chrysler steel 15x11
						stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.mc:0x000012ABr; //
					}
				}
				else
				{
					stock_parts_list_RGear_wheels[ 0] = stock_parts_list_RGear_wheels[ 1] = cars.racers.mc:0x0000110Br; //
					stock_parts_list_RGear_tyres[ 0] = stock_parts_list_RGear_tyres[ 1] = cars.racers.mc:0x000011ABr; // 
					
					number2 = random();
					
					if ( number2 < 0.6 )
					{
						stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.mc:0x0000110Br; //
						stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.mc:0x000011ABr; //
					}
					else
					{
						stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.mc:0x0000120Br; //
						stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.mc:0x000012ABr; //
					}
				}
				break;
			case parts.engines.Chrysler_V8_pak:0x0000E440r:
				number = random();
				
				if ( number < 0.22 )
				{
					stock_parts_list_RGear_wheels[ 0] = stock_parts_list_RGear_wheels[ 1] = cars.racers.mc:0x0000110Br; //
					stock_parts_list_RGear_tyres[ 0] = stock_parts_list_RGear_tyres[ 1] = cars.racers.mc:0x000011ABr; // 
					
					number2 = random();
					
					if ( number2 < 0.6 )
					{
						stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.mc:0x0000110Br; //
						stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.mc:0x000011ABr; //
					}
					else
					{
						stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.mc:0x0000120Br; //
						stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.mc:0x000012ABr; //
					}
				}
				else if ( number < 0.48 )
				{
					stock_parts_list_RGear_wheels[ 0] = stock_parts_list_RGear_wheels[ 1] = cars.racers.mc:0x0000210Br; //
					stock_parts_list_RGear_tyres[ 0] = stock_parts_list_RGear_tyres[ 1] = cars.racers.mc:0x000011ABr; // 
					
					number2 = random();
					
					if ( number2 < 0.3 )
					{
						stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.mc:0x0000210Br; //
						stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.mc:0x000011ABr; //
					}
					else
					{
						stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.mc:0x0000220Br; //
						stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.mc:0x000012ABr; //
					}
				}
				else if ( number < 0.78 )
				{
					stock_parts_list_RGear_wheels[ 0] = stock_parts_list_RGear_wheels[ 1] = cars.racers.MC:0x0000210Br; // Cragar black 15x8
					stock_parts_list_RGear_tyres[ 0] = stock_parts_list_RGear_tyres[ 1] = cars.racers.Nonus:0x000020C0r; // Goodyear Eagle ST 215/60
					
					number2 = random();
					
					if ( number2 < 0.5 )
					{
						stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.MC:0x0000210Br; // Cragar black 15x8
						stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.Nonus:0x000020C0r; // Goodyear Eagle ST 215/60
					}
					else
					{
						stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.MC:0x0000220Br; // Cragar black 15x10
						stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.Nonus:0x00002AC0r; // Goodyear Eagle ST 255/60
					}
				}
				else
				{
					stock_parts_list_RGear_wheels[ 0] = stock_parts_list_RGear_wheels[ 1] = parts.mopar_wheels:0x0000D915r; // Cragar G/T 15x8
					stock_parts_list_RGear_tyres[ 0] = stock_parts_list_RGear_tyres[ 1] = cars.racers.Nonus:0x000020C0r; // Goodyear Eagle ST 215/60
					
					number2 = random();
					
					if ( number2 < 0.5 )
					{
						stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = parts.mopar_wheels:0x0000D915r; // Cragar G/T 15x8
						stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.Nonus:0x000020C0r; // Goodyear Eagle ST 215/60
					}
					else
					{
						stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = parts.mopar_wheels:0x0000D9C5r; // Cragar G/T 15x11
						stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.Nonus:0x00002AC0r; // Goodyear Eagle ST 255/60
					}
				}
				break;
			case parts.engines.Chrysler_V8_pak:0x0000E426r:
				number = random();
				
				if ( number < 0.32 )
				{
					stock_parts_list_RGear_wheels[ 0] = stock_parts_list_RGear_wheels[ 1] = cars.racers.mc:0x0000310Br; //
					stock_parts_list_RGear_tyres[ 0] = stock_parts_list_RGear_tyres[ 1] = cars.racers.mc:0x000011ABr; // 
					
					number2 = random();
					
					if ( number2 < 0.6 )
					{
						stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.mc:0x0000310Br; //
						stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.mc:0x000011ABr; //
					}
					else
					{
						stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.mc:0x0000320Br; //
						stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.mc:0x000012ABr; //
					}
				}
				else if ( number < 0.53 )
				{
					stock_parts_list_RGear_wheels[ 0] = stock_parts_list_RGear_wheels[ 1] = cars.racers.mc:0x0000210Br; //
					stock_parts_list_RGear_tyres[ 0] = stock_parts_list_RGear_tyres[ 1] = cars.racers.mc:0x000011ABr; // 
					
					number2 = random();
					
					if ( number2 < 0.3 )
					{
						stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.mc:0x0000210Br; //
						stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.mc:0x000011ABr; //
					}
					else
					{
						stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.mc:0x0000220Br; //
						stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.mc:0x000012ABr; //
					}
				}
				else if ( number < 0.81 )
				{
					stock_parts_list_RGear_wheels[ 0] = stock_parts_list_RGear_wheels[ 1] = cars.racers.MC:0x0000210Br; // Cragar black 15x8
					stock_parts_list_RGear_tyres[ 0] = stock_parts_list_RGear_tyres[ 1] = cars.racers.Nonus:0x000020C0r; // Goodyear Eagle ST 215/60
					
					number2 = random();
					
					if ( number2 < 0.5 )
					{
						stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.MC:0x0000210Br; // Cragar black 15x8
						stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.Nonus:0x000020C0r; // Goodyear Eagle ST 215/60
					}
					else
					{
						stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.MC:0x0000220Br; // Cragar black 15x10
						stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.Nonus:0x00002AC0r; // Goodyear Eagle ST 255/60
					}
				}
				else
				{
					stock_parts_list_RGear_wheels[ 0] = stock_parts_list_RGear_wheels[ 1] = parts.mopar_wheels:0x0000D915r; // Cragar G/T 15x8
					stock_parts_list_RGear_tyres[ 0] = stock_parts_list_RGear_tyres[ 1] = cars.racers.Nonus:0x000020C0r; // Goodyear Eagle ST 215/60
					
					number2 = random();
					
					if ( number2 < 0.5 )
					{
						stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = parts.mopar_wheels:0x0000D915r; // Cragar G/T 15x8
						stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.Nonus:0x000020C0r; // Goodyear Eagle ST 215/60
					}
					else
					{
						stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = parts.mopar_wheels:0x0000D9C5r; // Cragar G/T 15x11
						stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.Nonus:0x00002AC0r; // Goodyear Eagle ST 255/60
					}
				}
				break;
		}
		

		super.addStockParts( desc );

		addPart( cars.racers.MC:0x000000B3r, "steering wheel" );

		addPart( cars.racers.MC:0x00000129r, "stock_L_exhaust_pipe" );
		addPart( cars.racers.MC:0x0000012Ar, "stock_R_exhaust_pipe" );
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
