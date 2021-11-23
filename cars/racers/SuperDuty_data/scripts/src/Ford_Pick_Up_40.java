package java.game.cars;

import java.util.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.airfueldeliverysystem.*;
import java.game.parts.enginemodels.*;

public class Ford_Pick_Up_40 extends Ford_Pick_Up_40_models
{
	public Ford_Pick_Up_40( int id )
	{
		super( id );
		carCategory = PACKAGE;

		makerName = "Ford Motor USA";
		model = MODEL_PICK_UP_40;
		vehicleName = "Ford Pick Up 1/2 ton '40";
		name = "Ford Pick Up '40 chassis";

		description = "A high flat-topped hood dominated the front look of the 1940 model, as the grille spread out to reach the fenders to differentiate the Deluxe line and the headlights were pushed wider still. The standard Ford inherited the grille of the 1939 model with blackout on each side of a heavy chrome center; heavier headlight surrounds serve as another major differentiator from the 1939. 1940 was the last year of the 1937 design and its smaller V8 engine, with a straight-six engine to be reintroduced the following year. Sealed-beam headlights were one of the few major advances for 1940, while a hydraulic top was new on the convertible.";

		value = mHUF2USD(0.688);
		brand_new_prestige_value = 33.40;
 
		fully_stripped_drag = 0.54;

		exhaustSlotIDList = new Vector();
		exhaustSlotIDList.addElement( new Integer(18) );
		exhaustSlotIDList.addElement( new Integer(23) );
	}

	public void addStockParts( Descriptor desc )
	{	
		stock_parts_list_E = EngineModels.getFordEngine( EngineModels.FORD_V8_260 );

		stock_parts_list_FL = new int[3];
		stock_parts_list_FL[ 0] = cars.racers.superduty:0x000000B6r; // "L headlights" //
		stock_parts_list_FL[ 1] = cars.racers.superduty:0x000010BBr; // "FL fender inner" //
		stock_parts_list_FL[ 2] = cars.racers.superduty:0x000000BBr; // "FL quarterpanel" //

		stock_parts_list_FR = new int[3];
		stock_parts_list_FR[ 0] = cars.racers.superduty:0x000000C6r; // "R headlights" //
		stock_parts_list_FR[ 1] = cars.racers.superduty:0x000010BEr; // "R fender inner" //
		stock_parts_list_FR[ 2] = cars.racers.superduty:0x000000BEr; // "FR quarterpanel" //

		stock_parts_list_RL = new int[2];
		stock_parts_list_RL[ 0] = cars.racers.superduty:0x000000B8r; // "L taillights" //
		stock_parts_list_RL[ 1] = cars.racers.superduty:0x000000BCr; // "RL quarterpanel" //

		stock_parts_list_RR = new int[2];
		stock_parts_list_RR[ 0] = cars.racers.superduty:0x000000C5r; // "R taillights" //
		stock_parts_list_RR[ 1] = cars.racers.superduty:0x000000CAr; // "RR quarterpanel" //

		stock_parts_list_F  = new int[7];
		stock_parts_list_F[ 0] = cars.racers.superduty:0x000000B0r; // "F bumper" //
		stock_parts_list_F[ 1] = cars.racers.superduty:0x000000B5r; // "hood" //
		stock_parts_list_F[ 2] = cars.racers.superduty:0x000000C4r; // "F grille" //		
		stock_parts_list_F[ 3] = cars.racers.superduty:0x000000B1r; // "F windshield" //
		stock_parts_list_F[ 4] = cars.racers.superduty:0x0000A0C7r; // "Stock flatbed woodern floor" //
		stock_parts_list_F[ 5] = cars.racers.superduty:0x0000B0B9r; // "Stock front carpeting" //
		stock_parts_list_F[ 6] = cars.racers.superduty:0x0000A0B9r; // "Stock floor carpeting" //

		stock_parts_list_Rr = new int[3];
		stock_parts_list_Rr[ 0] = cars.racers.superduty:0x000000C7r; // "R bumper" //
		stock_parts_list_Rr[ 1] = cars.racers.superduty:0x000000BDr; // "R door" //
		stock_parts_list_Rr[ 2] = cars.racers.superduty:0x000000B2r; // "R windshield" //

		stock_parts_list_L  = new int[4];
		stock_parts_list_L[ 0] = cars.racers.superduty:0x000000CEr; // "L sideskirt" //
		stock_parts_list_L[ 1] = cars.racers.superduty:0x000000C9r; // "FL door" //
		stock_parts_list_L[ 2] = cars.racers.superduty:0x000000B3r; // "FL seat" //
		stock_parts_list_L[ 3] = cars.racers.superduty:0x000000CDr; // "Left flatbed side stand" //

		stock_parts_list_R  = new int[6];
		stock_parts_list_R[ 0] = cars.racers.superduty:0x000000CCr; // "R sideskirt" //
		stock_parts_list_R[ 1] = cars.racers.superduty:0x000000C0r; // "FR door" //
		stock_parts_list_R[ 2] = cars.racers.superduty:0x000000CBr; // "FR seat" //
		stock_parts_list_R[ 3] = cars.racers.superduty:0x000000CFr; // "Right flatbed side stand" //
		stock_parts_list_R[ 4] = cars.racers.superduty:0x0000C0B9r; // "Stock wiper" //
		stock_parts_list_R[ 5] = cars.racers.superduty:0x000000B9r; // "Stock rear wall and roof carpeting" //

	// running gear parts lists //

		// stock 1 stuff //

		stock_parts_list_RGear_suspensions = new int[4];
		stock_parts_list_RGear_suspensions[ 0] = parts:0x000001F4r; // "SuperDuty_500_FL_McPherson_strut" //
		stock_parts_list_RGear_suspensions[ 1] = parts:0x000001F5r; // "SuperDuty_500_FR_McPherson_strut" //
		stock_parts_list_RGear_suspensions[ 2] = parts:0x000001F6r; // "SuperDuty_500_RL_trailing_arm" //
		stock_parts_list_RGear_suspensions[ 3] = parts:0x000001F7r; // "SuperDuty_500_RR_trailing_arm" //

		stock_parts_list_RGear_shocks = new int[4];
		stock_parts_list_RGear_shocks[ 0] = stock_parts_list_RGear_shocks[ 1] = parts:0x000001B0r; // "shock_absorber_SuperDuty_500_front" //
		stock_parts_list_RGear_shocks[ 2] = stock_parts_list_RGear_shocks[ 3] = parts:0x000001B1r; // "shock_absorber_SuperDuty_500_rear" //

		stock_parts_list_RGear_springs = new int[4];
		stock_parts_list_RGear_springs[ 0] = stock_parts_list_RGear_springs[ 1] = parts:0x000001DAr; // "spring_SuperDuty_500_front" //
		stock_parts_list_RGear_springs[ 2] = stock_parts_list_RGear_springs[ 3] = parts:0x000001DBr; // "spring_SuperDuty_500_rear" //

		stock_parts_list_RGear_brakes = new int[4];
		stock_parts_list_RGear_brakes[ 0] = stock_parts_list_RGear_brakes[ 1] = parts:0x00000157r; // "brake_SuperDuty_500_front" //
		stock_parts_list_RGear_brakes[ 2] = stock_parts_list_RGear_brakes[ 3] = parts:0x00000158r; // "brake_SuperDuty_500_rear" //

//		stock_parts_list_RGear_sways = new int[2];
//		stock_parts_list_RGear_sways[ 0] = parts:0x0000018Fr; // "swaybar_SuperDuty_500_front" //
//		stock_parts_list_RGear_sways[ 1] = parts:0x00000190r; // "swaybar_SuperDuty_500_rear" //

		stock_parts_list_RGear_wheels = new int[4];
		stock_parts_list_RGear_wheels[ 0] = stock_parts_list_RGear_wheels[ 1] = cars.racers.superduty:0x000010B0r; // "DevilSport_5_8.0x17_ET_0" //
		stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.superduty:0x000010B0r; // "DevilSport_5_8.0x17_ET_0" //

		stock_parts_list_RGear_tyres = new int[4];
		stock_parts_list_RGear_tyres[ 0] = stock_parts_list_RGear_tyres[ 1] = cars.racers.superduty:0x000010C7r; // "205_55_17_sport" //
		stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.superduty:0x000010C7r; // "205_55_17_sport" //

		super.addStockParts( desc );

		addPart( cars.racers.SuperDuty:0x000000B4r, "steering wheel" );

		addPart( cars.racers.SuperDuty:0x00000114r, "L_stock_exhaust_pipe" );
		addPart( cars.racers.SuperDuty:0x0000011Ar, "R_stock_exhaust_pipe" );
		addPart( parts.mufflers:0x0000001Fr, "muffler type 12" );
		addPart( parts.mufflers:0x0000001Fr, "muffler type 12" );

		if (desc.power > 1.25)
		{
			NOSInjectorSystem N2Oinjector=addPart( parts.engines.MC_Prime_SuperDuty:0x000000BFr, "NOS injector" );
			N2Oinjector.nitro_consumption = clampTo(N2Oinjector.maxconsumption*((desc.power-1.25)/0.75*0.500+0.500),N2Oinjector.minconsumption,N2Oinjector.maxconsumption);
			if (desc.power > 1.6)
			{
				addPart( parts:0x000001C1r, "12pds canister" );
				addPart( parts:0x000001C1r, "12pds canister" );
				addPart( parts:0x000001BFr, "24pds canister" );
				addPart( parts:0x000001BFr, "24pds canister" );
			}
			else
			{
				addPart( parts:0x000001BFr, "24pds canister" );
				addPart( parts:0x000001BFr, "24pds canister" );
			}
		}
	}
}
