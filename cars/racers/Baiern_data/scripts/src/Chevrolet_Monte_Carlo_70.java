package java.game.cars;

import java.util.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.airfueldeliverysystem.*;
import java.game.parts.enginemodels.*;


public class Chevrolet_Monte_Carlo_70 extends Chevrolet_Monte_Carlo_70_models
{
	public Chevrolet_Monte_Carlo_70( int id )
	{
		super( id );
		carCategory = PACKAGE;

		makerName = "General Motors Company";
		model = MODEL_MONTE_CARLO_70;
		vehicleName = "Chevrolet Monte Carlo '70";
		name = "Chevrolet Monte Carlo '70 chassis";

		description = "The Monte Carlo started as a Chevrolet counterpart to the Pontiac Grand Prix, as conceived by Elliot M. (Pete) Estes, general manager of Chevrolet, and Chevrolet's chief stylist, David Holls. They modeled the styling on the contemporary Cadillac Eldorado, although much of the body and structure were shared with the Chevrolet Chevelle (firewall, windshield, decklid, and rear window were the same). New exterior 'coke bottle styling' featured concealed windshield wipers. A light monitoring system was optional. Optional engines included the four-barrel carbureted Turbo-Fire 350 CID small block V8, rated at 300 hp (224 kW) at 4800 rpm and 380 lb·ft (515 Nm) at 3200 rpm, the Turbo-Fire 400 (400 CID/6.5 L) with a two-barrel carburetor, rated at 265 hp (198 kW) at 4800 rpm and 400 lb·ft (542 Nm) at 3800 rpm, and the Turbo-Jet 400 (402 CID/6.6 L) with a four-barrel carburetor, rated at 330 hp (246 kW) at 4800 rpm and 410 lb·ft (515 Nm) at 3200 rpm). Note that the two Chevrolet 400 CID V8s offered this year were actually two different designs. The two-barrel carbureted Turbo-Fire 400 was a Small Block Chevrolet V8 engine, similar, but different internally, to the 350, while the Turbo-Jet 400 was a slightly enlarged version of the 396 CID big block V8 and had an actual displacement of 402 CID.";

		value = mHUF2USD(1.855);
		brand_new_prestige_value = 32.50;

		fully_stripped_drag = 0.61;

		exhaustSlotIDList = new Vector();
		exhaustSlotIDList.addElement( new Integer(22) );
	}

	public void addStockParts( Descriptor desc )
	{
		// stock 1 stuff //
		float number = random();

		if(number < 0.33)
		{
			stock_parts_list_E = EngineModels.getGmEngine( EngineModels.GM_V8_350 );
		}
		else if(number < 0.55)
		{
			stock_parts_list_E = EngineModels.getGmEngine( EngineModels.GM_V8_396 );
		}
		else
		{
			stock_parts_list_E = EngineModels.getGmEngine( EngineModels.GM_V8_454 );
		}

		stock_parts_list_FL = new int[2];
		stock_parts_list_FL[ 0] = cars.racers.baiern:0x00000111r; // "L headlights" //
		stock_parts_list_FL[ 1] = cars.racers.baiern:0x00000110r; // "FL quarterpanel" //

		stock_parts_list_FR = new int[2];
		stock_parts_list_FR[ 0] = cars.racers.baiern:0x00000117r; // "R headlights" //
		stock_parts_list_FR[ 1] = cars.racers.baiern:0x00000116r; // "FR quarterpanel" //

		stock_parts_list_RL = new int[2];
		stock_parts_list_RL[ 0] = cars.racers.baiern:0x00000108r; // "L taillights" //
		stock_parts_list_RL[ 1] = cars.racers.baiern:0x00000109r; // "RL quarterpanel" //

		stock_parts_list_RR = new int[2];
		stock_parts_list_RR[ 0] = cars.racers.baiern:0x00000114r; // "R taillights" //
		stock_parts_list_RR[ 1] = cars.racers.baiern:0x00000119r; // "RR quarterpanel" //

		stock_parts_list_F  = new int[4];
		stock_parts_list_F[ 0] = cars.racers.baiern:0x0000010Fr; // "F bumper" //
		stock_parts_list_F[ 1] = cars.racers.baiern:0x0000010Dr; // "hood" //
		stock_parts_list_F[ 2] = cars.racers.baiern:0x0000010Br; // "F windshield" //
		stock_parts_list_F[ 3] = cars.racers.baiern:0x0000011Dr; // "Stock front grille" //

		stock_parts_list_Rr = new int[8];
		stock_parts_list_Rr[ 0] = cars.racers.baiern:0x00000107r; // "R bumper" //
		stock_parts_list_Rr[ 1] = cars.racers.baiern:0x00000118r; // "trunk" //
		stock_parts_list_Rr[ 2] = cars.racers.baiern:0x00000102r; // "R windshield" //
		stock_parts_list_Rr[ 3] = cars.racers.baiern:0x00000106r; // "R seats" //
		stock_parts_list_Rr[ 4] = cars.racers.baiern:0x00000120r; // "Rear logo" //
		stock_parts_list_Rr[ 5] = cars.racers.baiern:0x0000411Fr; // "Trunk carpet" //
		stock_parts_list_Rr[ 6] = cars.racers.baiern:0x0000311Fr; // "Hat holder" //
		stock_parts_list_Rr[ 7] = cars.racers.baiern:0x0000211Fr; // "Floor carpet" //

		stock_parts_list_L  = new int[8];
		stock_parts_list_L[ 0] = cars.racers.baiern:0x0000011Er; // "L sideskirt" //
		stock_parts_list_L[ 1] = cars.racers.baiern:0x00000115r; // "FL door" //
		stock_parts_list_L[ 2] = cars.racers.baiern:0x00000104r; // "L mirror" //
		stock_parts_list_L[ 3] = cars.racers.baiern:0x0000010Er; // "FL window" //
		stock_parts_list_L[ 4] = cars.racers.baiern:0x0000010Ar; // "RL window" //
		stock_parts_list_L[ 5] = cars.racers.baiern:0x00000103r; // "FL seat" //
		stock_parts_list_L[ 6] = cars.racers.baiern:0x0000011Br; // "Left body emblem" //
		stock_parts_list_L[ 7] = cars.racers.baiern:0x0000511Fr; // "Left carpeting" //

		stock_parts_list_R  = new int[9];
		stock_parts_list_R[ 0] = cars.racers.baiern:0x00000126r; // "R sideskirt" //
		stock_parts_list_R[ 1] = cars.racers.baiern:0x00000128r; // "FR door" //
		stock_parts_list_R[ 2] = cars.racers.baiern:0x0000011Ar; // "R mirror" //
		stock_parts_list_R[ 3] = cars.racers.baiern:0x00000112r; // "FR window" //
		stock_parts_list_R[ 4] = cars.racers.baiern:0x0000010Cr; // "RR window" //
		stock_parts_list_R[ 5] = cars.racers.baiern:0x00000113r; // "FR seat" //
		stock_parts_list_R[ 6] = cars.racers.baiern:0x0000011Fr; // "Right body emblem" //
		stock_parts_list_R[ 7] = cars.racers.baiern:0x0000611Fr; // "Right carpeting" //
		stock_parts_list_R[ 8] = cars.racers.baiern:0x0000111Fr; // "Stock roof carpeting" //

	// running gear parts lists //
		// stock 1 stuff //

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
		stock_parts_list_RGear_wheels[ 0] = stock_parts_list_RGear_wheels[ 1] = cars.racers.baiern:0x000020E0r; // "DevilSport_5_8.0x17_ET_0" //
		stock_parts_list_RGear_wheels[ 2] = stock_parts_list_RGear_wheels[ 3] = cars.racers.baiern:0x000020E0r; // "DevilSport_5_8.0x17_ET_0" //

		stock_parts_list_RGear_tyres = new int[4];
		stock_parts_list_RGear_tyres[ 0] = stock_parts_list_RGear_tyres[ 1] = cars.racers.baiern:0x000010D0r; // "205_55_17_sport" //
		stock_parts_list_RGear_tyres[ 2] = stock_parts_list_RGear_tyres[ 3] = cars.racers.baiern:0x000010D0r; // "205_55_17_sport" //

		super.addStockParts( desc );

		addPart( cars.racers.Baiern:0x00000105r, "steering wheel" );

		addPart( cars.racers.Baiern:0x00000182r, "stock_exhaust_pipe" );
		addPart( parts.mufflers:0x0000001Fr, "muffler type 12" );
		addPart( parts.mufflers:0x0000001Fr, "muffler type 12" );

		if (desc.power > 1.25)
		{
			addPart( parts.wings:0x00000024r, "wing" );
		}

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
