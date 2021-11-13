package java.game.cars;

import java.game.*;

public class Ford_Mustang_VT extends VehicleType
{
	public Ford_Mustang_VT( int id )
	{
		VehicleModel vmd;

		prevalence = 0.0;

	// CAREER mode -> used car dealer //
		// Ford Mustang Fastback '68 //
			vmd=new VehicleModel( cars.racers.Prime:0x00001006r, VS_USED );
			vtdarr.addElement( vmd );
			vmd.prevalence = 1900.0;
			vmd.minPower	= 0.5;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 0.4;	vmd.maxOptical	= 1.5;
			vmd.minTear	= 0.55;	vmd.maxTear	= 1.0;
			vmd.minWear	= 0.55;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=876;	vmd.fullPrestige= 982;
			vmd.stockQM = qm_stock_Prime_DLH_500;	vmd.fullQM = qm_full_Prime_DLH_500;
			vmd.vehicleName = "Ford Mustang Fastback '68";
			prevalence += vmd.prevalence;
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Cherry);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Smaragd);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Nacht);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Zucker);
		
		// Shelby GT500 '68 //
			vmd=new VehicleModel( cars.racers.Prime:0x00002006r, VS_USED );
			vtdarr.addElement( vmd );
			vmd.prevalence = 1300.0;
			vmd.minPower	= 0.5;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 0.1;	vmd.maxOptical	= 1.5;
			vmd.minTear	= 0.5;	vmd.maxTear	= 1.0;
			vmd.minWear	= 0.5;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=876;	vmd.fullPrestige= 982;
			vmd.stockQM = qm_stock_Prime_DLH_500;	vmd.fullQM = qm_full_Prime_DLH_500;
			vmd.vehicleName = "Shelby GT500 '68";
			prevalence += vmd.prevalence;
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Cherry);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Smaragd);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Nacht);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Zucker);
		
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
			vmd.prevalence = 900.0;
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
			vmd.prevalence = 2000.0;
			vmd.minPower	= 1.0;	vmd.maxPower	= 2.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 2.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=876;	vmd.fullPrestige= 982;
			vmd.stockQM = qm_stock_Prime_DLH_500;	vmd.fullQM = qm_full_Prime_DLH_500;
			vmd.vehicleName = "Ford Mustang Fastback '68";
			
			vmd=new VehicleModel( cars.racers.Prime:0x00001006r, VS_NRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = 2200.0;
			vmd.minPower	= 1.25;	vmd.maxPower	= 2.0;
			vmd.minOptical	= 1.25;	vmd.maxOptical	= 2.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.2;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.2;
			vmd.stockPrestige=876;	vmd.fullPrestige= 982;
			vmd.stockQM = qm_stock_Prime_DLH_500;	vmd.fullQM = qm_full_Prime_DLH_500;
			vmd.vehicleName = "Ford Mustang Fastback '68";
			
			vmd=new VehicleModel( cars.racers.Prime:0x00001006r, VS_RRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = 2400.0;
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
			vmd.prevalence = 1400.0;
			vmd.minPower	= 1.25;	vmd.maxPower	= 2.0;
			vmd.minOptical	= 1.25;	vmd.maxOptical	= 2.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=876;	vmd.fullPrestige= 982;
			vmd.stockQM = qm_stock_Prime_DLH_500;	vmd.fullQM = qm_full_Prime_DLH_500;
			vmd.vehicleName = "Shelby GT500 '68";
			
			vmd=new VehicleModel( cars.racers.Prime:0x00002006r, VS_NRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = 2200.0;
			vmd.minPower	= 1.25;	vmd.maxPower	= 2.0;
			vmd.minOptical	= 1.25;	vmd.maxOptical	= 2.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=876;	vmd.fullPrestige= 982;
			vmd.stockQM = qm_stock_Prime_DLH_500;	vmd.fullQM = qm_full_Prime_DLH_500;
			vmd.vehicleName = "Shelby GT500 '68";
			
			vmd=new VehicleModel( cars.racers.Prime:0x00002006r, VS_RRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = 2600.0;
			vmd.minPower	= 1.25;	vmd.maxPower	= 2.0;
			vmd.minOptical	= 1.25;	vmd.maxOptical	= 2.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.2;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.2;
			vmd.stockPrestige=876;	vmd.fullPrestige= 982;
			vmd.stockQM = qm_stock_Prime_DLH_500;	vmd.fullQM = qm_full_Prime_DLH_500;
			vmd.vehicleName = "Shelby GT500 '68";

		// make color indexes //
		addColorIndex(GameLogic.RID_CARCOLOR_Baiern_Devils_eye_red);
		addColorIndex(GameLogic.RID_CARCOLOR_Baiern_Spring_yellow);

		addColorIndex(GameLogic.RID_CARCOLOR_Einvagen_Zucker);
		addColorIndex(GameLogic.RID_CARCOLOR_Einvagen_Tornado_rot);
		addColorIndex(GameLogic.RID_CARCOLOR_Einvagen_Nacht);
		addColorIndex(GameLogic.RID_CARCOLOR_Einvagen_Smaragd);
		addColorIndex(GameLogic.RID_CARCOLOR_Einvagen_Black_mage);
		addColorIndex(GameLogic.RID_CARCOLOR_Einvagen_Hamvas_Grun);
		addColorIndex(GameLogic.RID_CARCOLOR_Einvagen_Indigo);
		addColorIndex(GameLogic.RID_CARCOLOR_Einvagen_Jazz);
		addColorIndex(GameLogic.RID_CARCOLOR_Einvagen_Antracit);
		addColorIndex(GameLogic.RID_CARCOLOR_Einvagen_Mercator_Blau);
		addColorIndex(GameLogic.RID_CARCOLOR_Einvagen_Murano);
		addColorIndex(GameLogic.RID_CARCOLOR_Einvagen_Champagner);
		addColorIndex(GameLogic.RID_CARCOLOR_Einvagen_Ozean);
		addColorIndex(GameLogic.RID_CARCOLOR_Einvagen_Reflex);
		addColorIndex(GameLogic.RID_CARCOLOR_Einvagen_Saratoga);

//		prevalence *= 1000.0;
	}
}
