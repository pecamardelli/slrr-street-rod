package java.game.cars;

import java.util.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.airfueldeliverysystem.*;
import java.game.parts.enginemodels.*;

public class Ford_Deluxe_40 extends Ford_Deluxe_40_models
{
	public Ford_Deluxe_40( int id )
	{
		super( id );
		carCategory = PACKAGE;

		makerName = "Ford Motor Company";
		model = MODEL_FORD_DELUXE_40;
		vehicleName = "Ford Deluxe Coupe '40";
		name = "Ford Deluxe Coupe '40 chassis";

		description = "Ford Motor Company introduced its De Luxe Ford line in 1938 as an upscale alternative to bridge the gap between its base model (usually called Standard) and luxury Lincoln offerings. The 'Deluxe' name was used intermittently before and after this to specify an upscale trim, but the De Luxe Ford line was differentiated as a separate 'marque within a marque' with separate styling and pricing through 1940. During 1939, Ford had five lines of cars: Ford, De Luxe Ford, Mercury, Lincoln-Zephyr, and Lincoln. After the war, this was simplified to Ford, Mercury, and Lincoln. The 1941 Ford line included 'De Luxe' and 'Super De Luxe' trim, but these vehicles were not marketed as a separate line.";

		value = mHUF2USD(2.03);
		brand_new_prestige_value = 32.50;

		fully_stripped_drag = 0.61;

		exhaustSlotIDList = new Vector();
		exhaustSlotIDList.addElement( new Integer(22) );
	}

	public void addStockParts( Descriptor desc )
	{
		// stock 1 stuffs //		
		stock_parts_list_E = EngineModels.getFordEngine( EngineModels.FORD_V8_260 );

		stock_parts_list_FL = new int[2];
		stock_parts_list_FL[ 0] = cars.racers.Ford_Deluxe_1940:0x00000111r; // "L headlights" //
		stock_parts_list_FL[ 1] = cars.racers.Ford_Deluxe_1940:0x00000110r; // "FL quarterpanel" //

		stock_parts_list_FR = new int[2];
		stock_parts_list_FR[ 0] = cars.racers.Ford_Deluxe_1940:0x00000117r; // "R headlights" //
		stock_parts_list_FR[ 1] = cars.racers.Ford_Deluxe_1940:0x00000116r; // "FR quarterpanel" //

		stock_parts_list_RL = new int[2];
		stock_parts_list_RL[ 0] = cars.racers.Ford_Deluxe_1940:0x00000108r; // "L taillights" //
		stock_parts_list_RL[ 1] = cars.racers.Ford_Deluxe_1940:0x00000109r; // "RL quarterpanel" //

		stock_parts_list_RR = new int[2];
		stock_parts_list_RR[ 0] = cars.racers.Ford_Deluxe_1940:0x00000114r; // "R taillights" //
		stock_parts_list_RR[ 1] = cars.racers.Ford_Deluxe_1940:0x00000119r; // "RR quarterpanel" //

		stock_parts_list_F  = new int[3];
		stock_parts_list_F[ 0] = cars.racers.Ford_Deluxe_1940:0x0000010Fr; // "F bumper" //
		stock_parts_list_F[ 1] = cars.racers.Ford_Deluxe_1940:0x0000010Dr; // "hood" //
		stock_parts_list_F[ 2] = cars.racers.Ford_Deluxe_1940:0x0000010Br; // "F windshield" //

		stock_parts_list_Rr = new int[3];
		stock_parts_list_Rr[ 0] = cars.racers.Ford_Deluxe_1940:0x00000107r; // "R bumper" //
		stock_parts_list_Rr[ 1] = cars.racers.Ford_Deluxe_1940:0x00000118r; // "trunk" //
		stock_parts_list_Rr[ 2] = cars.racers.Ford_Deluxe_1940:0x00000102r; // "R windshield" //

		stock_parts_list_L  = new int[6];
		stock_parts_list_L[ 0] = cars.racers.Ford_Deluxe_1940:0x0000011Er; // "L sideskirt" //
		stock_parts_list_L[ 1] = cars.racers.Ford_Deluxe_1940:0x00000115r; // "FL door" //
		stock_parts_list_L[ 2] = cars.racers.Ford_Deluxe_1940:0x00000104r; // "L mirror" //
		stock_parts_list_L[ 3] = cars.racers.Ford_Deluxe_1940:0x0000010Er; // "FL window" //
		stock_parts_list_L[ 4] = cars.racers.Ford_Deluxe_1940:0x0000010Ar; // "RL window" //
		stock_parts_list_L[ 5] = cars.racers.Ford_Deluxe_1940:0x00000103r; // "FL seat" //

		stock_parts_list_R  = new int[6];
		stock_parts_list_R[ 0] = cars.racers.Ford_Deluxe_1940:0x00000126r; // "R sideskirt" //
		stock_parts_list_R[ 1] = cars.racers.Ford_Deluxe_1940:0x00000128r; // "FR door" //
		stock_parts_list_R[ 2] = cars.racers.Ford_Deluxe_1940:0x0000011Ar; // "R mirror" //
		stock_parts_list_R[ 3] = cars.racers.Ford_Deluxe_1940:0x00000112r; // "FR window" //
		stock_parts_list_R[ 4] = cars.racers.Ford_Deluxe_1940:0x0000010Cr; // "RR window" //
		stock_parts_list_R[ 5] = cars.racers.Ford_Deluxe_1940:0x00000113r; // "FR seat" //

	// running gear parts lists //

		// stock 1 stuffs //

		stock_parts_list_RGear_suspensions = new int[4];
		stock_parts_list_RGear_suspensions[ 0] = parts:0x000000F8r; // "Baiern_CS_FL_McPherson_strut" //
		stock_parts_list_RGear_suspensions[ 1] = parts:0x000000F9r; // "Baiern_CS_FR_McPherson_strut" //
		stock_parts_list_RGear_suspensions[ 2] = parts:0x000000FAr; // "Baiern_CS_RL_trailing_arm" //
		stock_parts_list_RGear_suspensions[ 3] = parts:0x00000109r; // "Baiern_CS_RR_trailing_arm" //

		stock_parts_list_RGear_shocks = new int[4];
		stock_parts_list_RGear_shocks[ 0] = stock_parts_list_RGear_shocks[ 1] = parts:0x000000FDr; // "Baiern_CS_front" //
		stock_parts_list_RGear_shocks[ 2] = stock_parts_list_RGear_shocks[ 3] = parts:0x000000FCr; // "Baiern_CS_rear" //

		stock_parts_list_RGear_springs = new int[4];
		stock_parts_list_RGear_springs[ 0] = stock_parts_list_RGear_springs[ 1] = parts:0x000000EEr; // "Baiern_CS_front" //
		stock_parts_list_RGear_springs[ 2] = stock_parts_list_RGear_springs[ 3] = parts:0x000000EFr; // "Baiern_CS_rear" //

		stock_parts_list_RGear_brakes = new int[4];
		stock_parts_list_RGear_brakes[ 0] = stock_parts_list_RGear_brakes[ 1] = parts:0x000000D6r; // "Baiern_CS_front" //
		stock_parts_list_RGear_brakes[ 2] = stock_parts_list_RGear_brakes[ 3] = parts:0x000000D7r; // "Baiern_CS_rear" //

//		stock_parts_list_RGear_sways = new int[2];
//		stock_parts_list_RGear_sways[ 0] = parts:0x00000219r; // "Baiern_CS_front" //
//		stock_parts_list_RGear_sways[ 1] = parts:0x0000021Ar; // "Baiern_CS_rear" //

		stock_parts_list_RGear_wheels = new int[4];
		stock_parts_list_RGear_wheels[ 0] = stock_parts_list_RGear_wheels[ 1] = cars.racers.Ford_Deluxe_1940:0x00001028r; // "DevilSport_5_8.0x17_ET_0" //
		stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.Ford_Deluxe_1940:0x00001028r; // "DevilSport_5_8.0x17_ET_0" //

		stock_parts_list_RGear_tyres = new int[4];
		stock_parts_list_RGear_tyres[ 0] = stock_parts_list_RGear_tyres[ 1] = cars.racers.Ford_Deluxe_1940:0x00001029r; // "205_55_17_sport" //
		stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.Ford_Deluxe_1940:0x00001029r; // "205_55_17_sport" //

		super.addStockParts( desc );

		addPart( cars.racers.Ford_Deluxe_1940:0x00000105r, "steering wheel" );

		addPart( cars.racers.Ford_Deluxe_1940:0x00000182r, "stock_exhaust_pipe" );
		addPart( parts.mufflers:0x0000001Fr, "muffler type 12" );
		addPart( parts.mufflers:0x0000001Fr, "muffler type 12" );

		if (desc.power > 1.3)
		{
			NOSInjectorSystem N2Oinjector=addPart( parts.engines.Baiern_Emer:0x00000051r, "NOS injector" );
			N2Oinjector.nitro_consumption = clampTo(N2Oinjector.maxconsumption*((desc.power-1.3)/0.7*0.500+0.200),N2Oinjector.minconsumption,N2Oinjector.maxconsumption);
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
