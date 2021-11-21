package java.game.cars;

import java.game.*;

public class Ford_Mustang_VT extends VehicleType
{
	public Ford_Mustang_VT( int id )
	{
		VehicleModel vmd;
		float mustangProduction = 425.81;
		float shelbyProduction = 44.50;

		prevalence = 0.0;

	// CAREER mode -> used car dealer //
		// Ford Mustang Fastback '68 //
			vmd=new VehicleModel( cars.racers.Prime:0x00001006r, VS_USED );
			vtdarr.addElement( vmd );
			vmd.prevalence = mustangProduction;
			vmd.minPower	= 0.5;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 0.94;	vmd.maxOptical	= 1.5;
			vmd.minTear	= 0.55;	vmd.maxTear	= 1.0;
			vmd.minWear	= 0.55;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=876;	vmd.fullPrestige= 982;
			vmd.stockQM = qm_stock_Prime_DLH_500;	vmd.fullQM = qm_full_Prime_DLH_500;
			vmd.vehicleName = "Ford Mustang Fastback '68";
			prevalence += vmd.prevalence;
			// vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Cherry);
			// vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Smaragd);
			// vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Nacht);
			// vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Zucker);
		
		// Shelby GT500 '68 //
			vmd=new VehicleModel( cars.racers.Prime:0x00002006r, VS_USED );
			vtdarr.addElement( vmd );
			vmd.prevalence = shelbyProduction;
			vmd.minPower	= 0.5;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 0.98;	vmd.maxOptical	= 1.5;
			vmd.minTear	= 0.75;	vmd.maxTear	= 1.0;
			vmd.minWear	= 0.75;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=876;	vmd.fullPrestige= 982;
			vmd.stockQM = qm_stock_Prime_DLH_500;	vmd.fullQM = qm_full_Prime_DLH_500;
			vmd.vehicleName = "Shelby GT500 '68";
			prevalence += vmd.prevalence;
			// vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Cherry);
			// vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Smaragd);
			// vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Nacht);
			// vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Zucker);
		
	// CAREER mode -> new car dealer //
		// Ford Mustang Fastback '68 //
			vmd=new VehicleModel( cars.racers.Prime:0x00001006r, VS_STOCK );
			vtdarr.addElement( vmd );
			vmd.prevalence = 1000.0;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 1.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=876;	vmd.fullPrestige= 982;
			vmd.stockQM = qm_stock_Prime_DLH_500;	vmd.fullQM = qm_full_Prime_DLH_500;
			vmd.vehicleName = "Ford Mustang Fastback '68";
			prevalence += vmd.prevalence;
		
		// Shelby GT500 '68 //
			vmd=new VehicleModel( cars.racers.Prime:0x00002006r, VS_STOCK );
			vtdarr.addElement( vmd );
			vmd.prevalence = 1000.0;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 1.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=876;	vmd.fullPrestige= 982;
			vmd.stockQM = qm_stock_Prime_DLH_500;	vmd.fullQM = qm_full_Prime_DLH_500;
			vmd.vehicleName = "Shelby GT500 '68";
			prevalence += vmd.prevalence;
		
	// CAREER mode -> races //
		// Ford Mustang Fastback '68 //
			vmd=new VehicleModel( cars.racers.Prime:0x00001006r, VS_DRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = mustangProduction*2;
			vmd.minPower	= 1.0;	vmd.maxPower	= 2.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 2.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=876;	vmd.fullPrestige= 982;
			vmd.stockQM = qm_stock_Prime_DLH_500;	vmd.fullQM = qm_full_Prime_DLH_500;
			vmd.vehicleName = "Ford Mustang Fastback '68";
			
			vmd=new VehicleModel( cars.racers.Prime:0x00001006r, VS_NRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = mustangProduction*2.4;
			vmd.minPower	= 1.25;	vmd.maxPower	= 2.0;
			vmd.minOptical	= 1.25;	vmd.maxOptical	= 2.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.2;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.2;
			vmd.stockPrestige=876;	vmd.fullPrestige= 982;
			vmd.stockQM = qm_stock_Prime_DLH_500;	vmd.fullQM = qm_full_Prime_DLH_500;
			vmd.vehicleName = "Ford Mustang Fastback '68";
			
			vmd=new VehicleModel( cars.racers.Prime:0x00001006r, VS_RRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = mustangProduction*2.5;
			vmd.minPower	= 1.5;	vmd.maxPower	= 2.0;
			vmd.minOptical	= 1.5;	vmd.maxOptical	= 2.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.2;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.2;
			vmd.stockPrestige=876;	vmd.fullPrestige= 982;
			vmd.stockQM = qm_stock_Prime_DLH_500;	vmd.fullQM = qm_full_Prime_DLH_500;
			vmd.vehicleName = "Ford Mustang Fastback '68";
		
		// Shelby GT500 '68 //		
			vmd=new VehicleModel( cars.racers.Prime:0x00002006r, VS_DRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = shelbyProduction*2;
			vmd.minPower	= 1.25;	vmd.maxPower	= 2.0;
			vmd.minOptical	= 1.25;	vmd.maxOptical	= 2.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=876;	vmd.fullPrestige= 982;
			vmd.stockQM = qm_stock_Prime_DLH_500;	vmd.fullQM = qm_full_Prime_DLH_500;
			vmd.vehicleName = "Shelby GT500 '68";
			
			vmd=new VehicleModel( cars.racers.Prime:0x00002006r, VS_NRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = shelbyProduction*10;
			vmd.minPower	= 1.25;	vmd.maxPower	= 2.0;
			vmd.minOptical	= 1.25;	vmd.maxOptical	= 2.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=876;	vmd.fullPrestige= 982;
			vmd.stockQM = qm_stock_Prime_DLH_500;	vmd.fullQM = qm_full_Prime_DLH_500;
			vmd.vehicleName = "Shelby GT500 '68";
			
			vmd=new VehicleModel( cars.racers.Prime:0x00002006r, VS_RRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = shelbyProduction*10;
			vmd.minPower	= 1.25;	vmd.maxPower	= 2.0;
			vmd.minOptical	= 1.25;	vmd.maxOptical	= 2.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.2;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.2;
			vmd.stockPrestige=876;	vmd.fullPrestige= 982;
			vmd.stockQM = qm_stock_Prime_DLH_500;	vmd.fullQM = qm_full_Prime_DLH_500;
			vmd.vehicleName = "Shelby GT500 '68";

		// make color indexes //
		addColorIndex(GameLogic.FORD_ROYAL_MAROON);
		addColorIndex(GameLogic.FORD_HIGHLAND_GREEN);
		addColorIndex(GameLogic.FORD_ACAPULCO_BLUE);
		addColorIndex(GameLogic.FORD_CANDYAPPLE_RED);
		addColorIndex(GameLogic.FORD_GULFSTREAM_AQUA);
		addColorIndex(GameLogic.FORD_TAHOE_TURQUOISE);
		addColorIndex(GameLogic.FORD_LIME_GOLD);
		addColorIndex(GameLogic.FORD_MEADOWLARK_YELLOW);
		addColorIndex(GameLogic.FORD_WIMBLEDON_WHITE);
		addColorIndex(GameLogic.FORD_PRESIDENTIAL_BLUE);
		addColorIndex(GameLogic.FORD_DIAMOND_BLUE);
		addColorIndex(GameLogic.FORD_SUNLIT_GOLD);
		addColorIndex(GameLogic.FORD_SEAFOAM_GREEN);
		addColorIndex(GameLogic.FORD_PEBBLE_BEIGE);
		addColorIndex(GameLogic.FORD_BRITTANY_BLUE);

		//prevalence *= 1000.0;
	}
}
