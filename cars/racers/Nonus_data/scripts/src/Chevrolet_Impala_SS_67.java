package java.game.cars;

import java.util.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.airfueldeliverysystem.*;
import java.game.parts.enginemodels.*;

public class Chevrolet_Impala_SS_67 extends Chevrolet_Impala_SS_67_models
{
	public Chevrolet_Impala_SS_67( int id )
	{
		super( id );
		carCategory = PACKAGE;

		makerName = "Chevrolet Motor Car Company";
		model = CHEVROLET_IMPALA_SS_67;
		vehicleName = "Chevrolet Impala SS '67";
		name = "Chevrolet Impala '67 chassis";

		description = "The 1967 Impala SS was less decorated than other Impalas; Super Sports had black grille accents and black-accented body-side and rear fender moldings. Lesser models leaned more toward brightwork inside and out. Buyers could choose either vinyl bucket seats with a center console, or a Strato-Bench seat with a fold-down center armrest. Standard wheel covers were the same as the optional full covers on other big Chevrolets, but the centers featured the SS logo surrounded by tri-color ring of red, white and blue. Chevrolet and Impala callouts on the body were all replaced by attractive Impala SS badges. Of the 76,055 Impala SS models built, just 2,124 were ordered with RPO Z24, a special performance package that included RPO F41 heavy-duty suspension and other performance goodies, RPO L36 (385 brake horsepower (287 kW) Turbo-Jet 427-cubic-inch (7.0 L) V8, as well as a special trim package that replaced the Impala SS badges with large SS427 emblems on the front grille and rear trim. None of these special cars had the name Impala anywhere on the body or interior, and Chevrolet often marketed them as the Chevrolet SS427, sans the Impala name. The Z24 package also included a special hood with fake chrome-plated intake. Only about 400 Super Sports had a six-cylinder engine from 1967 to 1968, 390 brake horsepower (290 kW) in 1969, or L72 (425 brake horsepower (317 kW)) from 1968 to 1969. Special SS427 badging, inside and out, was the rule, but few were sold, since muscle car enthusiasts were seeking big-block intermediates, such as the Chevelle SS396 and Plymouth Road Runner.";

		value = mHUF2USD(1.495);
		brand_new_prestige_value = 45.80;

		fully_stripped_drag = 0.48;

		exhaustSlotIDList = new Vector();
		exhaustSlotIDList.addElement( new Integer(998) );
	}

	public void addStockParts( Descriptor desc )
	{

	// body parts lists //

		// stock 1 stuff //

		float number = random();
		float number2;
		
		if ( number < 0.2 )
		{
			stock_parts_list_E = EngineModels.getGmEngine( EngineModels.GM_V8_283 );
		}
		else if ( number < 0.34 )
		{
			stock_parts_list_E = EngineModels.getGmEngine( EngineModels.GM_V8_307 );
		}
		else if ( number < 0.48 )
		{
			stock_parts_list_E = EngineModels.getGmEngine( EngineModels.GM_V8_327 );
		}
		else if ( number < 0.68 )
		{
			stock_parts_list_E = EngineModels.getGmEngine( EngineModels.GM_V8_350 );
		}
		else if ( number < 0.81 )
		{
			stock_parts_list_E = EngineModels.getGmEngine( EngineModels.GM_V8_396 );
		}
		else if ( number < 0.93 )
		{
			stock_parts_list_E = EngineModels.getGmEngine( EngineModels.GM_V8_427 );
		}
		else
		{
			stock_parts_list_E = EngineModels.getGmEngine( EngineModels.GM_V8_454 );
		}

		stock_parts_list_FL = new int[2];
		stock_parts_list_FL[ 0] = cars.racers.nonus:0x000000A1r; // "L headlights" //
		stock_parts_list_FL[ 1] = cars.racers.nonus:0x000000A0r; // "FL quarterpanel" //

		stock_parts_list_FR = new int[2];
		stock_parts_list_FR[ 0] = cars.racers.nonus:0x0000009Ar; // "R headlights" //
		stock_parts_list_FR[ 1] = cars.racers.nonus:0x000000A3r; // "FR quarterpanel" //

		stock_parts_list_RL = new int[2];
		stock_parts_list_RL[ 0] = cars.racers.nonus:0x0000009Dr; // "L taillights" //
		stock_parts_list_RL[ 1] = cars.racers.nonus:0x000000A8r; // "RL quarterpanel" //

		stock_parts_list_RR = new int[2];
		stock_parts_list_RR[ 0] = cars.racers.nonus:0x000000A7r; // "R taillights" //
		stock_parts_list_RR[ 1] = cars.racers.nonus:0x000000A9r; // "RR quarterpanel" //

		stock_parts_list_F  = new int[3];
		stock_parts_list_F[ 0] = cars.racers.nonus:0x0000009Cr; // "F bumper" //
		stock_parts_list_F[ 1] = cars.racers.nonus:0x00000092r; // "hood" //
		stock_parts_list_F[ 2] = cars.racers.nonus:0x000000A2r; // "F windshield" //

		stock_parts_list_Rr = new int[4];
		stock_parts_list_Rr[ 0] = cars.racers.nonus:0x0000009Fr; // "R bumper" //
		stock_parts_list_Rr[ 1] = cars.racers.nonus:0x0000009Er; // "trunk" //
		stock_parts_list_Rr[ 2] = cars.racers.nonus:0x00000094r; // "R windshield" //
		stock_parts_list_Rr[ 3] = cars.racers.nonus:0x00000099r; // "R seats" //

		stock_parts_list_L  = new int[3];
		stock_parts_list_L[ 0] = cars.racers.nonus:0x00000093r; // "FL door" //
		stock_parts_list_L[ 1] = cars.racers.nonus:0x00000096r; // "RL window" //
		stock_parts_list_L[ 2] = cars.racers.nonus:0x00000097r; // "FL seat" //

		stock_parts_list_R  = new int[11];
		stock_parts_list_R[ 0] = cars.racers.nonus:0x000000A6r; // "FR door" //
		stock_parts_list_R[ 1] = cars.racers.nonus:0x000000A5r; // "RR window" //
		stock_parts_list_R[ 2] = cars.racers.nonus:0x000000AAr; // "FR seat" //
		stock_parts_list_R[ 3] = cars.racers.nonus:0x00000112r; // "Stock front grille" //
		stock_parts_list_R[ 4] = cars.racers.nonus:0x00000111r; // "Stock rear panel" //
		stock_parts_list_R[ 5] = cars.racers.nonus:0x00000081r; // "Stock roof carpeting" //
		stock_parts_list_R[ 6] = cars.racers.nonus:0x0000010Dr; // "Stock central console" //
		stock_parts_list_R[ 7] = cars.racers.nonus:0x0000010Er; // "Stock rear right carpeting" //
		stock_parts_list_R[ 8] = cars.racers.nonus:0x00000109r; // "Stock hat holder" //
		stock_parts_list_R[ 9] = cars.racers.nonus:0x0000A09Er; // "Stock trunk carpet" //
		stock_parts_list_R[ 10] = cars.racers.nonus:0x00000099r; // "Impala rear seats" //

	// running gear parts lists //

		// stock 1 stuff //

		//////////////////
		// SUSPENSSIONS //
		//////////////////
		
		number = random();
					
		if ( number < 0.6 )
		{
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
		}
		else
		{
			stock_parts_list_RGear_suspensions = new int[4];
			stock_parts_list_RGear_suspensions[ 0] = parts:0x00000205r; // "MC_GTLE_FL_McPherson_strut" //
			stock_parts_list_RGear_suspensions[ 1] = parts:0x00000206r; // "MC_GTLE_FR_McPherson_strut" //
			stock_parts_list_RGear_suspensions[ 2] = parts:0x00000207r; // "MC_GTLE_RL_trailing_arm" //
			stock_parts_list_RGear_suspensions[ 3] = parts:0x00000208r; // "MC_GTLE_RR_trailing_arm" //

			stock_parts_list_RGear_shocks = new int[4];
			stock_parts_list_RGear_shocks[ 0] = stock_parts_list_RGear_shocks[ 1] = parts:0x000001B9r; // "shock_absorber_MC_GTLE_front" //
			stock_parts_list_RGear_shocks[ 2] = stock_parts_list_RGear_shocks[ 3] = parts:0x000001BAr; // "shock_absorber_MC_GTLE_rear" //

			stock_parts_list_RGear_springs = new int[4];
			stock_parts_list_RGear_springs[ 0] = stock_parts_list_RGear_springs[ 1] = parts:0x000001E2r; // "spring_MC_GTLE_front" //
			stock_parts_list_RGear_springs[ 2] = stock_parts_list_RGear_springs[ 3] = parts:0x000001E3r; // "spring_MC_GTLE_rear" //

			stock_parts_list_RGear_brakes = new int[4];
			stock_parts_list_RGear_brakes[ 0] = stock_parts_list_RGear_brakes[ 1] = parts:0x00000172r; // "brake_MC_GTLE_front" //
			stock_parts_list_RGear_brakes[ 2] = stock_parts_list_RGear_brakes[ 3] = parts:0x00000173r; // "brake_MC_GTLE_rear" //
		}


//		stock_parts_list_RGear_sways = new int[2];
//		stock_parts_list_RGear_sways[ 0] = parts:0x0000018Br; // "swaybar_Nonus_SGT_front" //
//		stock_parts_list_RGear_sways[ 1] = parts:0x0000018Cr; // "swaybar_Nonus_SGT_rear" //

		///////////////////
		// RIM SELECTION //
		///////////////////
		
		int rim_front;
		int rim_back;
		
		number = random();
		
		stock_parts_list_RGear_wheels = new int[4];	
		
		if ( number < 0.58 )
		{
			stock_parts_list_RGear_wheels[ 0] = stock_parts_list_RGear_wheels[ 1] = cars.racers.nonus:0x000010B0r; // 15x8
			rim_front = 8;
			
			number2 = random();
					
			if ( number2 < 0.62 )
			{
				stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.nonus:0x000010B0r; //
				rim_back = 8;
			}
			else
			{
				stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.nonus:0x00001AB0r; //
				rim_back = 10;
			}
		}
		else
		{
			stock_parts_list_RGear_wheels[ 0] = stock_parts_list_RGear_wheels[ 1] = cars.racers.nonus:0x000020B0r; // 15x8
			rim_front = 8;
			
			number2 = random();
					
			if ( number2 < 0.62 )
			{
				stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.nonus:0x000020B0r; //
				rim_back = 8;
			}
			else
			{
				stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.nonus:0x00002AB0r; //
				rim_back = 10;
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
					stock_parts_list_RGear_tyres[ 0] = stock_parts_list_RGear_tyres[ 1] = cars.racers.nonus:0x000010C0r; //
				}
				else
				{
					stock_parts_list_RGear_tyres[ 0] = stock_parts_list_RGear_tyres[ 1] = cars.racers.nonus:0x000020C0r; //
				}
				break;
			case 10:
				if ( number < 0.58 )
				{
					stock_parts_list_RGear_tyres[ 0] = stock_parts_list_RGear_tyres[ 1] = cars.racers.nonus:0x00001AC0r; //
				}
				else
				{
					stock_parts_list_RGear_tyres[ 0] = stock_parts_list_RGear_tyres[ 1] = cars.racers.nonus:0x00002AC0r; //
				}
				break;
		}
		
		number = random();
		
		switch ( rim_back )
		{
			case 8:
				if ( number < 0.58 )
				{
					stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.nonus:0x000010C0r; //
				}
				else
				{
					stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.nonus:0x000020C0r; //
				}
				break;
			case 10:
				if ( number < 0.58 )
				{
					stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.nonus:0x00001AC0r; //
				}
				else
				{
					stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.nonus:0x00002AC0r; //
				}
				break;
		}
		
		super.addStockParts( desc );

		addPart( cars.racers.Nonus:0x00000098r, "steering wheel" );

		addPart( cars.racers.Nonus:0x000000E5r, "stock_exhaust_pipe" );
		addPart( parts.mufflers:0x0000001Fr, "muffler type 12" );
		addPart( parts.mufflers:0x0000001Fr, "muffler type 12" );

		if (desc.power > 1.25)
		{
			addPart( parts.wings:0x0000002Ar, "wing" );
		}

		if (desc.power > 1.05 && desc.power < 1.2)
		{
			NOSInjectorSystem N2Oinjector=addPart( parts.engines.Baiern_Emer:0x00000051r, "NOS injector" );
			N2Oinjector.nitro_consumption = clampTo(N2Oinjector.maxconsumption*((desc.power-1.05)/0.15*0.300+0.500),N2Oinjector.minconsumption,N2Oinjector.maxconsumption);
			if (desc.power > 1.1)
			{
				addPart( parts:0x000001C1r, "12pds canister" );
				addPart( parts:0x000001BFr, "24pds canister" );
			}
			else
			{
				addPart( parts:0x000001BFr, "24pds canister" );
			}
		}
		else
		if (desc.power > 1.4)
		{
			NOSInjectorSystem N2Oinjector=addPart( parts.engines.Baiern_Emer:0x00000051r, "NOS injector" );
			N2Oinjector.nitro_consumption = clampTo(N2Oinjector.maxconsumption*((desc.power-1.4)/0.6*0.800+0.200),N2Oinjector.minconsumption,N2Oinjector.maxconsumption);
			addPart( parts:0x000001C1r, "12pds canister" );
			addPart( parts:0x000001BFr, "24pds canister" );
		}
	}
}
