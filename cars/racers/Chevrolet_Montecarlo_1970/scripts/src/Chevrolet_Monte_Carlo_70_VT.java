package java.game.cars;

import java.game.*;

public class Chevrolet_Monte_Carlo_70_VT extends VehicleType
{
	public Chevrolet_Monte_Carlo_70_VT( int id )
	{
		VehicleModel vmd;
		float totalProduction = 1421.53/2;

	// DEMO mode //
		// Chevrolet Monte Carlo '70 //
			// a full stock version //
			vmd=new VehicleModel( cars.racers.Baiern:0x00000006r, VS_DEMO );
			vtdarr.addElement( vmd );
			vmd.prevalence	= 1.0;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 1.0;
			vmd.stockPrestige=329;	vmd.fullPrestige= 388;
			vmd.stockQM = qm_stock_Baiern_CoupeSport_2_5;	vmd.fullQM = qm_full_Baiern_CoupeSport_2_5;
			vmd.vehicleName = "Chevrolet Monte Carlo '70";

			// a wild version //
			vmd=new VehicleModel( cars.racers.Baiern:0x00000006r, VS_DEMO );
			vtdarr.addElement( vmd );
			vmd.prevalence	= 1.0;
			vmd.minPower	= 1.5;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 2.0;	vmd.maxOptical	= 2.0;
			vmd.stockPrestige=329;	vmd.fullPrestige= 388;
			vmd.stockQM = qm_stock_Baiern_CoupeSport_2_5;	vmd.fullQM = qm_full_Baiern_CoupeSport_2_5;
			vmd.vehicleName = "Chevrolet Monte Carlo '70";

		// Chevrolet Monte Carlo Vinyl Top '70 //
			// a full stock version //
			vmd=new VehicleModel( cars.racers.Baiern:0x00000157r, VS_DEMO );
			vtdarr.addElement( vmd );
			vmd.prevalence	= 1.0;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 1.0;
			vmd.stockPrestige=338;	vmd.fullPrestige= 395;
			vmd.stockQM = qm_stock_Baiern_DevilSport;	vmd.fullQM = qm_full_Baiern_DevilSport;
			vmd.vehicleName = "Chevrolet Monte Carlo Vinyl Top '70";

			// a wild version //
			vmd=new VehicleModel( cars.racers.Baiern:0x00000157r, VS_DEMO );
			vtdarr.addElement( vmd );
			vmd.prevalence	= 1.0;
			vmd.minPower	= 1.5;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 2.0;	vmd.maxOptical	= 2.0;
			vmd.stockPrestige=338;	vmd.fullPrestige= 395;
			vmd.stockQM = qm_stock_Baiern_DevilSport;	vmd.fullQM = qm_full_Baiern_DevilSport;
			vmd.vehicleName = "Chevrolet Monte Carlo Vinyl Top '70";

		prevalence = 0.0;

	// CAREER mode -> used car dealer //
		// Chevrolet Monte Carlo '70 //
			vmd=new VehicleModel( cars.racers.Baiern:0x00000006r, VS_USED );
			vtdarr.addElement( vmd );
			vmd.prevalence = totalProduction;
			vmd.minPower	= 0.5;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 0.95;	vmd.maxOptical	= 1.5;
			vmd.minTear	= 0.75;	vmd.maxTear	= 1.0;
			vmd.minWear	= 0.75;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=329;	vmd.fullPrestige= 388;
			vmd.stockQM = qm_stock_Baiern_CoupeSport_2_5;	vmd.fullQM = qm_full_Baiern_CoupeSport_2_5;
			vmd.vehicleName = "Chevrolet Monte Carlo '70";
			prevalence += vmd.prevalence;
			// vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Cherry);
			// vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Smaragd);
			// vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Nacht);
			// vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Zucker);

		// Chevrolet Monte Carlo Vinyl Top '70 //
			vmd=new VehicleModel( cars.racers.Baiern:0x00000157r, VS_USED );
			vtdarr.addElement( vmd );
			vmd.prevalence = totalProduction*0.8;
			vmd.minPower	= 0.5;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 0.95;	vmd.maxOptical	= 1.5;
			vmd.minTear	= 0.75;	vmd.maxTear	= 1.0;
			vmd.minWear	= 0.75;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=338;	vmd.fullPrestige= 395;
			vmd.stockQM = qm_stock_Baiern_DevilSport;	vmd.fullQM = qm_full_Baiern_DevilSport;
			vmd.vehicleName = "Chevrolet Monte Carlo Vinyl Top '70";
			prevalence += vmd.prevalence;
			// vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Cherry);
			// vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Smaragd);
			// vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Nacht);
			// vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Zucker);

		// Chevrolet Monte Carlo Fast & Fourious '70 //
			vmd=new VehicleModel( cars.racers.Baiern:0x000000FDr, VS_USED );
			vtdarr.addElement( vmd );
			vmd.prevalence = totalProduction*0.1;
			vmd.minPower	= 0.25;	vmd.maxPower	= 1.0;
			vmd.minOptical	= 0.95;	vmd.maxOptical	= 1.0;
			vmd.minTear	= 0.75;	vmd.maxTear	= 1.0;
			vmd.minWear	= 0.75;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=668;	vmd.fullPrestige= 722;
			vmd.stockQM = qm_stock_Baiern_CoupeSport_GT_III;	vmd.fullQM = qm_full_Baiern_CoupeSport_GT_III;
			vmd.vehicleName = "Chevrolet Monte Carlo Fast & Fourious '70";
			prevalence += vmd.prevalence;
			vmd.addColorIndex(GameLogic.CHEVROLET_MONZA_RED);
			vmd.exclusiveColors = 1;

	// CAREER mode -> new car dealer //
		// Chevrolet Monte Carlo '70 //
			vmd=new VehicleModel( cars.racers.Baiern:0x00000006r, VS_STOCK );
			vtdarr.addElement( vmd );
			vmd.prevalence = totalProduction;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 1.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=329;	vmd.fullPrestige= 388;
			vmd.stockQM = qm_stock_Baiern_CoupeSport_2_5;	vmd.fullQM = qm_full_Baiern_CoupeSport_2_5;
			vmd.vehicleName = "Chevrolet Monte Carlo '70";
			prevalence += vmd.prevalence;

		// Chevrolet Monte Carlo Vinyl Top '70 //
			vmd=new VehicleModel( cars.racers.Baiern:0x00000157r, VS_STOCK );
			vtdarr.addElement( vmd );
			vmd.prevalence = totalProduction*0.8;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 1.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=338;	vmd.fullPrestige= 395;
			vmd.stockQM = qm_stock_Baiern_DevilSport;	vmd.fullQM = qm_full_Baiern_DevilSport;
			vmd.vehicleName = "Chevrolet Monte Carlo Vinyl Top '70";
			prevalence += vmd.prevalence;

	// CAREER mode -> races //
		// Chevrolet Monte Carlo '70 //
			vmd=new VehicleModel( cars.racers.Baiern:0x00000006r, VS_DRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = totalProduction*0.5;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 1.5;
			vmd.minTear	= 0.8;	vmd.maxTear	= 1.0;
			vmd.minWear	= 0.8;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=329;	vmd.fullPrestige= 388;
			vmd.stockQM = qm_stock_Baiern_CoupeSport_2_5;	vmd.fullQM = qm_full_Baiern_CoupeSport_2_5;
			vmd.vehicleName = "Chevrolet Monte Carlo '70";
			prevalence += vmd.prevalence;

			vmd=new VehicleModel( cars.racers.Baiern:0x00000006r, VS_NRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = totalProduction*0.4;
			vmd.minPower	= 1.2;	vmd.maxPower	= 2.0;
			vmd.minOptical	= 1.2;	vmd.maxOptical	= 2.0;
			vmd.stockPrestige=329;	vmd.fullPrestige= 388;
			vmd.stockQM = qm_stock_Baiern_CoupeSport_2_5;	vmd.fullQM = qm_full_Baiern_CoupeSport_2_5;
			vmd.vehicleName = "Chevrolet Monte Carlo '70";
			
			vmd=new VehicleModel( cars.racers.Baiern:0x00000006r, VS_RRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = totalProduction*0.25;
			vmd.minPower	= 1.4;	vmd.maxPower	= 2.0;
			vmd.minOptical	= 1.2;	vmd.maxOptical	= 2.0;
			vmd.stockPrestige=329;	vmd.fullPrestige= 388;
			vmd.stockQM = qm_stock_Baiern_CoupeSport_2_5;	vmd.fullQM = qm_full_Baiern_CoupeSport_2_5;
			vmd.vehicleName = "Chevrolet Monte Carlo '70";

		// Chevrolet Monte Carlo Vinyl Top '70 //
			vmd=new VehicleModel( cars.racers.Baiern:0x00000157r, VS_DRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = totalProduction*0.4;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 1.5;
			vmd.minTear	= 0.8;	vmd.maxTear	= 1.0;
			vmd.minWear	= 0.8;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=338;	vmd.fullPrestige= 395;
			vmd.stockQM = qm_stock_Baiern_DevilSport;	vmd.fullQM = qm_full_Baiern_DevilSport;
			vmd.vehicleName = "Chevrolet Monte Carlo Vinyl Top '70";
			prevalence += vmd.prevalence;

			vmd=new VehicleModel( cars.racers.Baiern:0x00000157r, VS_NRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = totalProduction*0.18;
			vmd.minPower	= 1.2;	vmd.maxPower	= 2.0;
			vmd.minOptical	= 1.2;	vmd.maxOptical	= 2.0;
			vmd.stockPrestige=338;	vmd.fullPrestige= 395;
			vmd.stockQM = qm_stock_Baiern_DevilSport;	vmd.fullQM = qm_full_Baiern_DevilSport;
			vmd.vehicleName = "Chevrolet Monte Carlo Vinyl Top '70";
			
			vmd=new VehicleModel( cars.racers.Baiern:0x00000157r, VS_RRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = totalProduction*0.1;
			vmd.minPower	= 1.5;	vmd.maxPower	= 2.0;
			vmd.minOptical	= 1.2;	vmd.maxOptical	= 2.0;
			vmd.stockPrestige=338;	vmd.fullPrestige= 395;
			vmd.stockQM = qm_stock_Baiern_DevilSport;	vmd.fullQM = qm_full_Baiern_DevilSport;
			vmd.vehicleName = "Chevrolet Monte Carlo Vinyl Top '70";

		// Chevrolet Monte Carlo Fast & Fourious '70 //
			vmd=new VehicleModel( cars.racers.Baiern:0x000000FDr, VS_RRACE | VS_NRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = totalProduction;
			vmd.minPower	= 1.75;	vmd.maxPower	= 2.0;
			vmd.minOptical	= 1.75;	vmd.maxOptical	= 2.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=668;	vmd.fullPrestige= 722;
			vmd.stockQM = qm_stock_Baiern_CoupeSport_GT_III;	vmd.fullQM = qm_full_Baiern_CoupeSport_GT_III;
			vmd.vehicleName = "Chevrolet Monte Carlo Fast & Fourious '70";
			prevalence += vmd.prevalence;


		// make color indexes //
		addColorIndex(GameLogic.CHEVROLET_CLASSIC_WHITE);
		addColorIndex(GameLogic.CHEVROLET_CORTEZ_SILVER);
		addColorIndex(GameLogic.CHEVROLET_SHADOW_GRAY);
		addColorIndex(GameLogic.CHEVROLET_TUXEDO_BLACK);
		addColorIndex(GameLogic.CHEVROLET_ASTRO_BLUE);
		addColorIndex(GameLogic.CHEVROLET_FATHOM_BLUE);
		addColorIndex(GameLogic.CHEVROLET_MISTY_TURQUOISE);
		addColorIndex(GameLogic.CHEVROLET_GREEN_MIST);
		addColorIndex(GameLogic.CHEVROLET_FOREST_GREEN);
		addColorIndex(GameLogic.CHEVROLET_GOBI_BEIGE);
		addColorIndex(GameLogic.CHEVROLET_CHAMPAGNE_GOLD);
		addColorIndex(GameLogic.CHEVROLET_AUTUMN_GOLD);
		addColorIndex(GameLogic.CHEVROLET_DESERT_SAND);
		addColorIndex(GameLogic.CHEVROLET_CRANBERRY_RED);
		addColorIndex(GameLogic.CHEVROLET_BLACK_CHERRY);

//		prevalence *= 1000.0;
	}
}
