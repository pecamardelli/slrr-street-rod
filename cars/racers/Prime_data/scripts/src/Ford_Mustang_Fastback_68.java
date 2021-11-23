package java.game.cars;

import java.io.*;
import java.util.*;
import java.util.resource.*;
import java.game.parts.*;
import java.game.parts.enginepart.airfueldeliverysystem.*;
import java.game.parts.enginemodels.*;

public class Ford_Mustang_Fastback_68 extends Ford_Mustang_models
{
	public Ford_Mustang_Fastback_68( int id )
	{
		super( id );
		carCategory = PACKAGE;

		makerName = "Ford Motor Company";
		model = FORD_MUSTANG_FASTBACK_68;
		vehicleName = "Ford Mustang Fastback '68";
		name = "Ford Mustang '68 chassis";

		description = "Changes for the 1968 model increased safety with a two-spoke energy-absorbing steering wheel, along with newly introduced shoulder belts. Other changes included front and rear side markers, FORD lettering removed from hood, rearview mirror moved from frame to windshield, a 302 cu in (4.9 L) V8 engine was now available, and C-Stripe graphics were added. The 1968 Ford Mustang GT Fastback reached iconic status after it was featured in the 1968 film Bullitt, starring Steve McQueen. In the film, McQueen drove a modified 1968 Mustang GT 2+2 Fastback. Two vehicles were used in the filming of the movie and only one is still in existence today.";

		value = mHUF2USD(6.141);
		brand_new_prestige_value = 95.90;

		fully_stripped_drag = 0.61;
		brake_balance_can_be_set = 1;

		exhaustSlotIDList = new Vector();
		exhaustSlotIDList.addElement( new Integer(36) );
		exhaustSlotIDList.addElement( new Integer(37) );
	}

	public void addStockParts( Descriptor desc )
	{
		// stock 1 stuff //
		float number = random();

		if ( number < 0.2 )
		{
			stock_parts_list_E = EngineModels.getFordEngine( EngineModels.FORD_V8_292 );
		}
		else if ( number < 0.58 )
		{
			stock_parts_list_E = EngineModels.getFordEngine( EngineModels.FORD_V8_302 );
		}
		else if ( number < 0.8 )
		{
			stock_parts_list_E = EngineModels.getFordEngine( EngineModels.FORD_V8_390 );
		}
		else
		{
			stock_parts_list_E = EngineModels.getFordEngine( EngineModels.FORD_V8_429 );
		}

		stock_parts_list_FL = new int[1];
		stock_parts_list_FL[ 0] = cars.racers.prime:0x000000DBr; // "FL quarterpanel" //

		stock_parts_list_FR = new int[1];
		stock_parts_list_FR[ 0] = cars.racers.prime:0x000000D8r; // "FR quarterpanel" //

		stock_parts_list_RL = new int[2];
		stock_parts_list_RL[ 0] = cars.racers.prime:0x000000B9r; // "L taillights" //
		stock_parts_list_RL[ 1] = cars.racers.prime:0x000000DCr; // "RL quarterpanel" //

		stock_parts_list_RR = new int[2];
		stock_parts_list_RR[ 0] = cars.racers.prime:0x000000C8r; // "R taillights" //
		stock_parts_list_RR[ 1] = cars.racers.prime:0x000000D7r; // "RR quarterpanel" //

		stock_parts_list_F  = new int[9];
		stock_parts_list_F[ 0] = cars.racers.prime:0x000000D9r; // "F spoiler" //
		stock_parts_list_F[ 1] = cars.racers.prime:0x000000D6r; // "F bumper" //
		stock_parts_list_F[ 2] = cars.racers.prime:0x000000D5r; // "F mask" //
		stock_parts_list_F[ 3] = cars.racers.prime:0x000000B8r; // "L foglight" //
		stock_parts_list_F[ 4] = cars.racers.prime:0x000000C9r; // "R foglight" //
		stock_parts_list_F[ 5] = cars.racers.prime:0x000000C0r; // "L headlights" //
		stock_parts_list_F[ 6] = cars.racers.prime:0x000000C5r; // "R headlights" //
		stock_parts_list_F[ 7] = cars.racers.prime:0x000000DAr; // "hood" //
		stock_parts_list_F[ 8] = cars.racers.prime:0x000000BCr; // "F windshield" //

		stock_parts_list_Rr = new int[4];
		stock_parts_list_Rr[ 0] = cars.racers.prime:0x000000BFr; // "R bumper" //
		stock_parts_list_Rr[ 1] = cars.racers.prime:0x000000BAr; // "trunk" //
		stock_parts_list_Rr[ 2] = cars.racers.prime:0x000000BEr; // "R windshield" //
		stock_parts_list_Rr[ 3] = cars.racers.prime:0x000000BBr; // "R seats" //

		stock_parts_list_L  = new int[6];
		stock_parts_list_L[ 0] = cars.racers.prime:0x000000CCr; // "L sideskirt" //
		stock_parts_list_L[ 1] = cars.racers.prime:0x000000B7r; // "FL door" //
		stock_parts_list_L[ 3] = cars.racers.prime:0x000000DDr; // "L mirror" //
		stock_parts_list_L[ 2] = cars.racers.prime:0x000000BDr; // "FL window" //
		stock_parts_list_L[ 4] = cars.racers.prime:0x000000D3r; // "Mustang front seat" //
		stock_parts_list_L[ 5] = cars.racers.prime:0x000000D3r; // "Mustang front seat" //

		stock_parts_list_R  = new int[39];
		stock_parts_list_R[ 0] = cars.racers.prime:0x000000C1r; // "R sideskirt" //
		stock_parts_list_R[ 1] = cars.racers.prime:0x000000C6r; // "FR door" //
		stock_parts_list_R[ 2] = cars.racers.prime:0x000000DEr; // "R mirror" //
		stock_parts_list_R[ 3] = cars.racers.prime:0x000000C7r; // "FR window" //
		stock_parts_list_R[ 4] = cars.racers.prime:0x000000D4r; // "FR seat" //
		stock_parts_list_R[ 5] = cars.racers.prime:0x0000A0BAr; // "Stock rear panel" //
		stock_parts_list_R[ 6] = cars.racers.prime:0x0000A0CCr; // "Stock rear left vent" //
		stock_parts_list_R[ 7] = cars.racers.prime:0x0000B0CCr; // "Stock rear right vent" //
		stock_parts_list_R[ 8] = cars.racers.prime:0x000010D9r; // "Stock front grille" //
		stock_parts_list_R[ 9] = cars.racers.prime:0x000010D1r; // "Stock left door window frame (chrome)" //
		stock_parts_list_R[ 10] = cars.racers.prime:0x00001AD1r; // "Stock right door window frame (chrome)" //
		stock_parts_list_R[ 11] = cars.racers.prime:0x000010D3r; // "Stock left chrome door locker" //
		stock_parts_list_R[ 12] = cars.racers.prime:0x00001AD3r; // "Stock right chrome door locker" //
		stock_parts_list_R[ 13] = cars.racers.prime:0x0000C0BAr; // "Front windshield chrome trim" //
		stock_parts_list_R[ 14] = cars.racers.prime:0x0000B0BAr; // "Stock rear windshield chrome trim" //
		stock_parts_list_R[ 15] = cars.racers.prime:0x0000A2CCr; // "Stock left door bay chrome trim" //
		stock_parts_list_R[ 16] = cars.racers.prime:0x0000B2CCr; // "Stock right door bay chrome trim" //
		stock_parts_list_R[ 17] = cars.racers.prime:0x000010D5r; // "Stock front mask chrome trim" //
		stock_parts_list_R[ 18] = cars.racers.prime:0x000010DAr; // "Stock hood chrome trim" //
		stock_parts_list_R[ 19] = cars.racers.prime:0x000010BAr; // "Stock trunk trim" //
		stock_parts_list_R[ 20] = cars.racers.prime:0x000010DCr; // "Stock rear left fender trim" //
		stock_parts_list_R[ 21] = cars.racers.prime:0x000020DCr; // "Stock rear right fender trim" //
		stock_parts_list_R[ 22] = cars.racers.prime:0x000010DDr; // "Stock rearview mirror" //
		stock_parts_list_R[ 23] = cars.racers.prime:0x000030BAr; // "Stock floor carpeting" //
		stock_parts_list_R[ 24] = cars.racers.prime:0x000040BAr; // "Stock roof carpeting" //
		stock_parts_list_R[ 25] = cars.racers.prime:0x000080BAr; // "Stock front left door carpeting" //
		stock_parts_list_R[ 26] = cars.racers.prime:0x000090BAr; // "Stock front right door carpeting" //
		stock_parts_list_R[ 27] = cars.racers.prime:0x000060BAr; // "Stock left side carpeting" //
		stock_parts_list_R[ 28] = cars.racers.prime:0x000070BAr; // "Stock right side carpeting" //
		stock_parts_list_R[ 29] = cars.racers.prime:0x000050BAr; // "Stock rear carpeting" //
		stock_parts_list_R[ 30] = cars.racers.prime:0x000020BAr; // "Stock trunk carpeting" //
		stock_parts_list_R[ 31] = cars.racers.prime:0x000000C7r; // "Stock passenger's window" //
		stock_parts_list_R[ 32] = cars.racers.prime:0x000000BDr; // "Stock driver's window" //
		stock_parts_list_R[ 33] = cars.racers.prime:0x000000B9r; // "Stock left taillights" //
		stock_parts_list_R[ 34] = cars.racers.prime:0x000000C8r; // "Stock right taillights" //
		stock_parts_list_R[ 35] = cars.racers.prime:0x000010C9r; // "Reverse gear light" //
		stock_parts_list_R[ 36] = cars.racers.prime:0x000010C9r; // "Reverse gear light" //
		stock_parts_list_R[ 37] = cars.racers.prime:0x000010D2r; // "Stock front left indicator" //
		stock_parts_list_R[ 38] = cars.racers.prime:0x000012D2r; // "Stock front right indicator" //

	// running gear parts lists //

		// stock 1 stuff //

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
//		stock_parts_list_RGear_sways[ 0] = parts:0x000001A0r; // "swaybar_Prime_front" //
//		stock_parts_list_RGear_sways[ 1] = parts:0x000001A1r; // "swaybar_Prime_rear" //

		stock_parts_list_RGear_wheels = new int[4];
		stock_parts_list_RGear_wheels[ 0] = stock_parts_list_RGear_wheels[ 1] = cars.racers.prime:0x0000C0B0r; // "rim Prime_DLH 9.0 17 ET -30 LOD CATALOG GARAGE" //
		stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.prime:0x0000C0B0r; // "rim Prime_DLH 10.0 17 ET -30 LOD CATALOG GARAGE" //

		stock_parts_list_RGear_tyres = new int[4];
		stock_parts_list_RGear_tyres[ 0] = stock_parts_list_RGear_tyres[ 1] = cars.racers.nonus:0x000010C0r; // "tyre 235 45 17 9.0 LOD CATALOG GARAGE" //
		stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.nonus:0x000010C0r; // "tyre 265 45 17 11.0 LOD CATALOG GARAGE" //

		super.addStockParts( desc );

		addPart( cars.racers.Prime:0x000000C4r, "steering wheel" );

		addPart( cars.racers.Prime:0x00000009r, "L_stock_exhaust_pipe" );

	}
}
