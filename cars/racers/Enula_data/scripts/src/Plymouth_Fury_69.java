package java.game.cars;

import java.util.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.airfueldeliverysystem.*;
import java.game.parts.enginemodels.*;

public class Plymouth_Fury_69 extends Plymouth_Fury_69_models
{
	public Plymouth_Fury_69( int id )
	{
		super( id );
		carCategory = PACKAGE;

		makerName = "Plymouth";
		model = PLYMOUTH_SPORT_FURY_69;
		vehicleName = "Plymouth Sport Fury '69";
		name = "Plymouth Sport Fury '69 chassis";

		description = "The Plymouth Fury is a model of automobile which was produced by Plymouth from 1955 to 1978. It was introduced for the 1956 model year as a sub-series of the Plymouth Belvedere, becoming a separate series one level above the contemporary Belvedere for 1959. The Fury was a full-size car from 1959 to 1961, then a mid-size car from 1962 to 1964, again a full-size car from 1965 to 1974, and again a mid-size car from 1975 to 1978. From 1975 to 1977 the Fury was sold alongside the full-size Plymouth Gran Fury.";

		value = mHUF2USD(1.404);
		brand_new_prestige_value = 41.47;

		fully_stripped_drag = 0.55;

		exhaustSlotIDList = new Vector();
		exhaustSlotIDList.addElement( new Integer(22) );
	}

	public void addStockParts( Descriptor desc )
	{
		float number = random();
		float number2;
		EngineModels engine;
		engine = new EngineModels();		
		stock_parts_list_E = engine.getChryslerEngine();
		
		stock_parts_list_FL = new int[2];
		stock_parts_list_FL[ 0] = cars.racers.enula:0x0000011Dr; // "L headlights" //
		stock_parts_list_FL[ 1] = cars.racers.enula:0x00000123r; // "FL quarterpanel" //

		stock_parts_list_FR = new int[2];
		stock_parts_list_FR[ 0] = cars.racers.enula:0x00000120r; // "R headlights" //
		stock_parts_list_FR[ 1] = cars.racers.enula:0x00000129r; // "FR quarterpanel" //

		stock_parts_list_RL = new int[2];
		stock_parts_list_RL[ 0] = cars.racers.enula:0x0000011Fr; // "L taillights" //
		stock_parts_list_RL[ 1] = cars.racers.enula:0x0000012Ar; // "RL quarterpanel" //

		stock_parts_list_RR = new int[2];
		stock_parts_list_RR[ 0] = cars.racers.enula:0x0000013Br; // "R taillights" //
		stock_parts_list_RR[ 1] = cars.racers.enula:0x0000012Cr; // "RR quarterpanel" //

		stock_parts_list_F  = new int[3];
		stock_parts_list_F[ 0] = cars.racers.enula:0x0000012Br; // "F bumper" //
		stock_parts_list_F[ 1] = cars.racers.enula:0x00000125r; // "Stock hood" //
		stock_parts_list_F[ 2] = cars.racers.enula:0x0000011Br; // "F windshield" //

		stock_parts_list_Rr = new int[4];
		stock_parts_list_Rr[ 0] = cars.racers.enula:0x00000124r; // "R bumper" //
		stock_parts_list_Rr[ 1] = cars.racers.enula:0x0000011Er; // "trunk" //
		stock_parts_list_Rr[ 2] = cars.racers.enula:0x00000114r; // "R windshield" //
		stock_parts_list_Rr[ 3] = cars.racers.enula:0x00000109r; // "R seats" //

		stock_parts_list_L  = new int[4];
		stock_parts_list_L[ 0] = cars.racers.enula:0x00000121r; // "L sideskirt" //
		stock_parts_list_L[ 1] = cars.racers.enula:0x00000106r; // "FL door" //
		stock_parts_list_L[ 2] = cars.racers.enula:0x00000127r; // "RL door" //
		stock_parts_list_L[ 3] = cars.racers.enula:0x00000108r; // "FL seat" //

		stock_parts_list_R  = new int[14];
		stock_parts_list_R[ 0] = cars.racers.enula:0x00000122r; // "R sideskirt" //
		stock_parts_list_R[ 1] = cars.racers.enula:0x00000119r; // "FR door" //
		stock_parts_list_R[ 2] = cars.racers.enula:0x00000128r; // "RR door" //
		stock_parts_list_R[ 3] = cars.racers.enula:0x0000011Ar; // "FR seat" //
		stock_parts_list_R[ 4] = cars.racers.enula:0x00000137r; // "RR window" //
		stock_parts_list_R[ 5] = cars.racers.enula:0x00000135r; // "RL window" //
		stock_parts_list_R[ 6] = cars.racers.enula:0x00001132r; // "Stock floor carpeting" //
		stock_parts_list_R[ 7] = cars.racers.enula:0x00003132r; // "Stock roof carpeting" //
		stock_parts_list_R[ 8] = cars.racers.enula:0x00002132r; // "Stock rear carpeting" //
		stock_parts_list_R[ 9] = cars.racers.enula:0x00004132r; // "Stock left side carpeting" //
		stock_parts_list_R[ 10] = cars.racers.enula:0x00005132r; // "Stock right side carpeting" //
		stock_parts_list_R[ 11] = cars.racers.enula:0x00000132r; // "Stock trunk carpeting" //
		stock_parts_list_R[ 12] = cars.racers.enula:0x00000176r; // "Plymouth hood emblem" //
		stock_parts_list_R[ 13] = cars.racers.enula:0x0000010Br; // "Chrysler star hood badge" //

	// running gear parts lists //

		// stock 1 stuffs //

		stock_parts_list_RGear_suspensions = new int[4];
		stock_parts_list_RGear_suspensions[ 0] = parts:0x00004009r; // "WRY_FL_McPherson" //
		stock_parts_list_RGear_suspensions[ 1] = parts:0x000040FCr; // "WRY_FR_McPherson" //
		stock_parts_list_RGear_suspensions[ 2] = parts:0x000040FDr; // "WRY_RL_Trailing-arm" //
		stock_parts_list_RGear_suspensions[ 3] = parts:0x000040FEr; // "WRY_RR_Trailing-arm" //

		stock_parts_list_RGear_shocks = new int[4];
		stock_parts_list_RGear_shocks[ 0] = stock_parts_list_RGear_shocks[ 1] = parts:0x000000FDr; // "WRY_front" //
		stock_parts_list_RGear_shocks[ 2] = stock_parts_list_RGear_shocks[ 3] = parts:0x000000FCr; // "WRY_rear" //

		stock_parts_list_RGear_springs = new int[4];
		stock_parts_list_RGear_springs[ 0] = stock_parts_list_RGear_springs[ 1] = parts:0x000000FEr; // "WRY_front" //
		stock_parts_list_RGear_springs[ 2] = stock_parts_list_RGear_springs[ 3] = parts:0x000000FFr; // "WRY_rear" //

		stock_parts_list_RGear_brakes = new int[4];
		stock_parts_list_RGear_brakes[ 0] = stock_parts_list_RGear_brakes[ 1] = parts:0x00000100r; // "WRY_front" //
		stock_parts_list_RGear_brakes[ 2] = stock_parts_list_RGear_brakes[ 3] = parts:0x00000101r; // "WRY_rear" //

//		stock_parts_list_RGear_sways = new int[2];
//		stock_parts_list_RGear_sways[ 0] = parts:0x00000193r; // "WRY_front" //
//		stock_parts_list_RGear_sways[ 1] = parts:0x00000194r; // "WRY_rear" //

		stock_parts_list_RGear_wheels = new int[4];
		stock_parts_list_RGear_tyres = new int[4];
		
		switch ( stock_parts_list_E[ 1] )
		{
			case parts.engines.Chrysler_V8_pak:0x0000E318r:
				stock_parts_list_RGear_wheels[ 0] = stock_parts_list_RGear_wheels[ 1] = cars.racers.enula:0x0000010Cr; // 
				stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.enula:0x0000010Cr; // 
				stock_parts_list_RGear_tyres[ 0] = stock_parts_list_RGear_tyres[ 1] = cars.racers.enula:0x00000117r; // 
				stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.enula:0x00000117r; //
				break;
			case parts.engines.Chrysler_V8_pak:0x0000E360r:
				number = random();

				stock_parts_list_RGear_wheels[ 0] = stock_parts_list_RGear_wheels[ 1] = cars.racers.enula:0x0000010Cr; // 
				stock_parts_list_RGear_tyres[ 0] = stock_parts_list_RGear_tyres[ 1] = cars.racers.enula:0x00000117r; // 
				
				number2 = random();
				
				if ( number2 < 0.66 )
				{
					stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.enula:0x0000010Cr; // 
					stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.enula:0x00000117r; //
				}
				else
				{
					stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.enula:0x0000110Cr; //
					stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.enula:0x00001117r; //
				}
				break;
			case parts.engines.Chrysler_V8_pak:0x0000E361r:
				number = random();

				stock_parts_list_RGear_wheels[ 0] = stock_parts_list_RGear_wheels[ 1] = cars.racers.enula:0x0000010Cr; // 
				stock_parts_list_RGear_tyres[ 0] = stock_parts_list_RGear_tyres[ 1] = cars.racers.enula:0x00000117r; // 
				
				number2 = random();
				
				if ( number2 < 0.66 )
				{
					stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.enula:0x0000010Cr; // 
					stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.enula:0x00000117r; //
				}
				else
				{
					stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.enula:0x0000110Cr; //
					stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.enula:0x00001117r; //
				}
				break;
			case parts.engines.Chrysler_V8_pak:0x0000E383r:
				number = random();
				
				stock_parts_list_RGear_wheels[ 0] = stock_parts_list_RGear_wheels[ 1] = cars.racers.enula:0x0000010Cr; // 
				stock_parts_list_RGear_tyres[ 0] = stock_parts_list_RGear_tyres[ 1] = cars.racers.enula:0x00000117r; // 
				
				if ( number < 0.46 )
				{
					stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.enula:0x0000010Cr; // 
					stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.enula:0x00000117r; //
				}
				else
				{
					stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.enula:0x0000110Cr; //
					stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.enula:0x00001117r; //
				}
				break;
			case parts.engines.Chrysler_V8_pak:0x0000E400r:
				number = random();
				
				stock_parts_list_RGear_wheels[ 0] = stock_parts_list_RGear_wheels[ 1] = cars.racers.enula:0x0000010Cr; // 
				stock_parts_list_RGear_tyres[ 0] = stock_parts_list_RGear_tyres[ 1] = cars.racers.enula:0x00000117r; // 
				
				if ( number < 0.32 )
				{
					stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.enula:0x0000010Cr; // 
					stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.enula:0x00000117r; //
				}
				else
				{
					stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.enula:0x0000110Cr; //
					stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.enula:0x00001117r; //
				}
				break;
			case parts.engines.Chrysler_V8_pak:0x0000E440r:
				number = random();
				
				if ( number < 0.42 )
				{
					stock_parts_list_RGear_wheels[ 0] = stock_parts_list_RGear_wheels[ 1] = cars.racers.enula:0x0000010Cr; // 
					stock_parts_list_RGear_tyres[ 0] = stock_parts_list_RGear_tyres[ 1] = cars.racers.enula:0x00000117r; // 
					
					number2 = random();
					
					if ( number2 < 0.4 )
					{
						stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.enula:0x0000010Cr; // 
						stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.enula:0x00000117r; //
					}
					else
					{
						stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.enula:0x0000110Cr; //
					stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.enula:0x00001117r; //
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

		addPart( cars.racers.Enula:0x0000011Cr, "steering wheel" );

		if (desc.power > 1.1 && desc.power < 1.3)
		{
			NOSInjectorSystem N2Oinjector=addPart( parts.engines.Einvagen_Duhen_Ishima_Focer:0x00000052r, "NOS injector" );
			N2Oinjector.nitro_consumption = clampTo(N2Oinjector.maxconsumption*((desc.power-1.1)/0.2*0.500+0.500),N2Oinjector.minconsumption,N2Oinjector.maxconsumption);
			if (desc.power > 1.2)
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
		if (desc.power > 1.5)
		{
			NOSInjectorSystem N2Oinjector=addPart( parts.engines.Einvagen_Duhen_Ishima_Focer:0x00000052r, "NOS injector" );
			N2Oinjector.nitro_consumption = clampTo(N2Oinjector.maxconsumption*((desc.power-1.5)/0.5*0.700+0.300),N2Oinjector.minconsumption,N2Oinjector.maxconsumption);
			addPart( parts:0x000001C1r, "12pds canister" );
			addPart( parts:0x000001BFr, "24pds canister" );
		}

		addPart( cars.racers.Enula:0x00000111r, "stock_exhaust_pipe" );
		addPart( parts.mufflers:0x0000001Br, "muffler type 08" );
	}
}
