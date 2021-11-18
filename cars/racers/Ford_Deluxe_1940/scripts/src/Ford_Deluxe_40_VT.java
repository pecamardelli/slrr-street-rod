package java.game.cars;

import java.game.*;

public class Ford_Deluxe_40_VT extends VehicleType
{
	public Ford_Deluxe_40_VT( int id )
	{
		VehicleModel vmd;
		float totalProduction = 336.93;

	// DEMO mode //
		// Ford Deluxe Coupe '40 //
			// a full stock version //
			vmd=new VehicleModel( cars.racers.Ford_Deluxe_1940:0x00000006r, VS_DEMO );
			vtdarr.addElement( vmd );
			vmd.prevalence	= 1.0;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 1.0;
			vmd.stockPrestige=329;	vmd.fullPrestige= 388;
			vmd.stockQM = qm_stock_Baiern_CoupeSport_2_5;	vmd.fullQM = qm_full_Baiern_CoupeSport_2_5;
			vmd.vehicleName = "Ford Deluxe Coupe '40";

			// a wild version //
			vmd=new VehicleModel( cars.racers.Ford_Deluxe_1940:0x00000006r, VS_DEMO );
			vtdarr.addElement( vmd );
			vmd.prevalence	= 1.0;
			vmd.minPower	= 1.5;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 2.0;	vmd.maxOptical	= 2.0;
			vmd.stockPrestige=329;	vmd.fullPrestige= 388;
			vmd.stockQM = qm_stock_Baiern_CoupeSport_2_5;	vmd.fullQM = qm_full_Baiern_CoupeSport_2_5;
			vmd.vehicleName = "Ford Deluxe Coupe '40";

		prevalence = 0.0;

	// CAREER mode -> used car dealer //
		// Ford Deluxe Coupe '40 //
			vmd=new VehicleModel( cars.racers.Ford_Deluxe_1940:0x00000006r, VS_USED );
			vtdarr.addElement( vmd );
			vmd.prevalence = totalProduction;
			vmd.minPower	= 0.5;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 0.95;	vmd.maxOptical	= 1.5;
			vmd.minTear	= 0.5;	vmd.maxTear	= 1.0;
			vmd.minWear	= 0.5;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=329;	vmd.fullPrestige= 388;
			vmd.stockQM = qm_stock_Baiern_CoupeSport_2_5;	vmd.fullQM = qm_full_Baiern_CoupeSport_2_5;
			vmd.vehicleName = "Ford Deluxe Coupe '40";
			prevalence += vmd.prevalence;
			// vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Cherry);
			// vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Smaragd);
			// vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Nacht);
			// vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Zucker);

	// CAREER mode -> new car dealer //
		// Ford Deluxe Coupe '40 //
			vmd=new VehicleModel( cars.racers.Ford_Deluxe_1940:0x00000006r, VS_STOCK );
			vtdarr.addElement( vmd );
			vmd.prevalence = 1000.0;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 1.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=329;	vmd.fullPrestige= 388;
			vmd.stockQM = qm_stock_Baiern_CoupeSport_2_5;	vmd.fullQM = qm_full_Baiern_CoupeSport_2_5;
			vmd.vehicleName = "Ford Deluxe Coupe '40";
			prevalence += vmd.prevalence;


	// CAREER mode -> races //
		// Ford Deluxe Coupe '40 //
			vmd=new VehicleModel( cars.racers.Ford_Deluxe_1940:0x00000006r, VS_DRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = totalProduction*0.6;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 1.5;
			vmd.minTear	= 0.8;	vmd.maxTear	= 1.0;
			vmd.minWear	= 0.8;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=329;	vmd.fullPrestige= 388;
			vmd.stockQM = qm_stock_Baiern_CoupeSport_2_5;	vmd.fullQM = qm_full_Baiern_CoupeSport_2_5;
			vmd.vehicleName = "Ford Deluxe Coupe '40";
			prevalence += vmd.prevalence;

			vmd=new VehicleModel( cars.racers.Ford_Deluxe_1940:0x00000006r, VS_NRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = totalProduction*0.5;
			vmd.minPower	= 1.8;	vmd.maxPower	= 2.0;
			vmd.minOptical	= 1.2;	vmd.maxOptical	= 2.0;
			vmd.stockPrestige=329;	vmd.fullPrestige= 388;
			vmd.stockQM = qm_stock_Baiern_CoupeSport_2_5;	vmd.fullQM = qm_full_Baiern_CoupeSport_2_5;
			vmd.vehicleName = "Ford Deluxe Coupe '40";
			
			vmd=new VehicleModel( cars.racers.Ford_Deluxe_1940:0x00000006r, VS_RRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = totalProduction*0.45;
			vmd.minPower	= 1.8;	vmd.maxPower	= 2.0;
			vmd.minOptical	= 1.2;	vmd.maxOptical	= 2.0;
			vmd.stockPrestige=329;	vmd.fullPrestige= 388;
			vmd.stockQM = qm_stock_Baiern_CoupeSport_2_5;	vmd.fullQM = qm_full_Baiern_CoupeSport_2_5;
			vmd.vehicleName = "Ford Deluxe Coupe '40";


		// make color indexes //
		addColorIndex(GameLogic.FORD_FOLKESTONE_GRAY);
		addColorIndex(GameLogic.FORD_YOSEMITE_GREEN);
		addColorIndex(GameLogic.FORD_CLOUD_MIST_GRAY);
		addColorIndex(GameLogic.FORD_ACADIA_GREEN);
		addColorIndex(GameLogic.FORD_MANDARIN_MAROON);
		addColorIndex(GameLogic.FORD_GARNET_MAROON);
		addColorIndex(GameLogic.FORD_SAHARA_TAN);
		addColorIndex(GameLogic.FORD_COSTWOLD_GRAY);
		addColorIndex(GameLogic.FORD_COMO_BLUE);
		addColorIndex(GameLogic.FORD_CIGARETTE_CREAM);
		addColorIndex(GameLogic.FORD_LYON_BLUE);

		//prevalence *= 1000.0;
	}
}
