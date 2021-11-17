package java.game.cars;

import java.game.*;

public class Plymouth_Fury_69_VT extends VehicleType
{
	public Plymouth_Fury_69_VT( int id )
	{
		VehicleModel vmd;
		float totalProduction = 669.06;

	// DEMO mode //
		// Plymouth Sport Fury '69 //
			// a full stock version //
			vmd=new VehicleModel( cars.racers.Enula:0x00000006r, VS_DEMO );
			vtdarr.addElement( vmd );
			vmd.prevalence	= 1.0;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 1.0;
			vmd.stockPrestige=401;	vmd.fullPrestige= 422;
			vmd.stockQM = qm_stock_Ishima_Enula_WRY;	vmd.fullQM = qm_full_Ishima_Enula_WRY;
			vmd.vehicleName = "Plymouth Sport Fury '69";

			// a wild version //
			vmd=new VehicleModel( cars.racers.Enula:0x00000006r, VS_DEMO );
			vtdarr.addElement( vmd );
			vmd.prevalence	= 1.0;
			vmd.minPower	= 1.5;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 2.0;	vmd.maxOptical	= 2.0;
			vmd.stockPrestige=401;	vmd.fullPrestige= 422;
			vmd.stockQM = qm_stock_Ishima_Enula_WRY;	vmd.fullQM = qm_full_Ishima_Enula_WRY;
			vmd.vehicleName = "Plymouth Sport Fury '69";

		// Plymouth Sport Fury '69 //
			// a full stock version //
			vmd=new VehicleModel( cars.racers.Enula:0x00000006r, VS_DEMO );
			vtdarr.addElement( vmd );
			vmd.prevalence	= 1.0;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 1.0;
			vmd.stockPrestige=440;	vmd.fullPrestige= 473;
			vmd.stockQM = qm_stock_Ishima_Enula_WRZ;	vmd.fullQM = qm_full_Ishima_Enula_WRZ;
			vmd.vehicleName = "Plymouth Sport Fury '69";

			// a wild version //
			vmd=new VehicleModel( cars.racers.Enula:0x00000006r, VS_DEMO );
			vtdarr.addElement( vmd );
			vmd.prevalence	= 1.0;
			vmd.minPower	= 1.5;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 2.0;	vmd.maxOptical	= 2.0;
			vmd.stockPrestige=440;	vmd.fullPrestige= 473;
			vmd.stockQM = qm_stock_Ishima_Enula_WRZ;	vmd.fullQM = qm_full_Ishima_Enula_WRZ;
			vmd.vehicleName = "Plymouth Sport Fury '69";

		prevalence = 0.0;

	// CAREER mode -> used car dealer //
		// Plymouth Sport Fury '69 //
			vmd=new VehicleModel( cars.racers.Enula:0x00000006r, VS_USED );
			vtdarr.addElement( vmd );
			vmd.prevalence = totalProduction;
			vmd.minPower	= 0.5;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 0.95;	vmd.maxOptical	= 1.5;
			vmd.minTear	= 0.75;	vmd.maxTear	= 1.0;
			vmd.minWear	= 0.75;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=401;	vmd.fullPrestige= 422;
			vmd.stockQM = qm_stock_Ishima_Enula_WRY;	vmd.fullQM = qm_full_Ishima_Enula_WRY;
			vmd.vehicleName = "Plymouth Sport Fury '69";
			prevalence += vmd.prevalence;
			// vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Cherry);
			// vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Smaragd);
			// vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Nacht);
			// vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Zucker);

		// Plymouth Sport Fury Vinyl Top '69 // This model has been deleted from package, find out why.
			// vmd=new VehicleModel( cars.racers.Enula:0x00000006r, VS_USED );
			// vtdarr.addElement( vmd );
			// vmd.prevalence = 1800.0;
			// vmd.minPower	= 0.5;	vmd.maxPower	= 1.5;
			// vmd.minOptical	= 0.5;	vmd.maxOptical	= 1.5;
			// vmd.minTear	= 0.75;	vmd.maxTear	= 1.0;
			// vmd.minWear	= 0.75;	vmd.maxWear	= 1.0;
			// vmd.stockPrestige=440;	vmd.fullPrestige= 473;
			// vmd.stockQM = qm_stock_Ishima_Enula_WRZ;	vmd.fullQM = qm_full_Ishima_Enula_WRZ;
			// vmd.vehicleName = "Plymouth Sport Fury '69";
			// prevalence += vmd.prevalence;
			// vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Cherry);
			// vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Smaragd);
			// vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Nacht);
			// vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Zucker);

	// CAREER mode -> new car dealer //
		// Plymouth Sport Fury '69 //
			vmd=new VehicleModel( cars.racers.Enula:0x00000006r, VS_STOCK );
			vtdarr.addElement( vmd );
			vmd.prevalence = 1000.0;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 1.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=401;	vmd.fullPrestige= 422;
			vmd.stockQM = qm_stock_Ishima_Enula_WRY;	vmd.fullQM = qm_full_Ishima_Enula_WRY;
			vmd.vehicleName = "Plymouth Sport Fury '69";
			prevalence += vmd.prevalence;

		// Plymouth Sport Fury '69 //
			vmd=new VehicleModel( cars.racers.Enula:0x0000006r, VS_STOCK );
			vtdarr.addElement( vmd );
			vmd.prevalence = 1000.0;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 1.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=440;	vmd.fullPrestige= 473;
			vmd.stockQM = qm_stock_Ishima_Enula_WRZ;	vmd.fullQM = qm_full_Ishima_Enula_WRZ;
			vmd.vehicleName = "Plymouth Sport Fury '69";
			prevalence += vmd.prevalence;

	// CAREER mode -> races //
		// Plymouth Sport Fury '69 //
			vmd=new VehicleModel( cars.racers.Enula:0x00000006r, VS_DRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = totalProduction*1.2;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 1.5;
			vmd.minTear	= 0.8;	vmd.maxTear	= 1.0;
			vmd.minWear	= 0.8;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=401;	vmd.fullPrestige= 422;
			vmd.stockQM = qm_stock_Ishima_Enula_WRY;	vmd.fullQM = qm_full_Ishima_Enula_WRY;
			vmd.vehicleName = "Plymouth Sport Fury '69";
			prevalence += vmd.prevalence;

			vmd=new VehicleModel( cars.racers.Enula:0x00000006r, VS_NRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = totalProduction;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 1.5;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=401;	vmd.fullPrestige= 422;
			vmd.stockQM = qm_stock_Ishima_Enula_WRY;	vmd.fullQM = qm_full_Ishima_Enula_WRY;
			vmd.vehicleName = "Plymouth Sport Fury '69";
			
			vmd=new VehicleModel( cars.racers.Enula:0x00000006r, VS_RRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = totalProduction*0.8;
			vmd.minPower	= 1.5;	vmd.maxPower	= 2.0;
			vmd.minOptical	= 1.5;	vmd.maxOptical	= 2.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=401;	vmd.fullPrestige= 422;
			vmd.stockQM = qm_stock_Ishima_Enula_WRY;	vmd.fullQM = qm_full_Ishima_Enula_WRY;
			vmd.vehicleName = "Plymouth Sport Fury '69";

		// Plymouth Sport Fury '69 //
			vmd=new VehicleModel( cars.racers.Enula:0x00000006r, VS_DRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = totalProduction;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.6;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 1.6;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=440;	vmd.fullPrestige= 473;
			vmd.stockQM = qm_stock_Ishima_Enula_WRZ;	vmd.fullQM = qm_full_Ishima_Enula_WRZ;
			vmd.vehicleName = "Plymouth Sport Fury '69";
			prevalence += vmd.prevalence;

			vmd=new VehicleModel( cars.racers.Enula:0x00000006r, VS_NRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = totalProduction*1.2;
			vmd.minPower	= 1.25;	vmd.maxPower	= 1.6;
			vmd.minOptical	= 1.25;	vmd.maxOptical	= 1.6;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=440;	vmd.fullPrestige= 473;
			vmd.stockQM = qm_stock_Ishima_Enula_WRZ;	vmd.fullQM = qm_full_Ishima_Enula_WRZ;
			vmd.vehicleName = "Plymouth Sport Fury '69";
			
			vmd=new VehicleModel( cars.racers.Enula:0x00000006r, VS_RRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = totalProduction*0.8;
			vmd.minPower	= 1.25;	vmd.maxPower	= 2.0;
			vmd.minOptical	= 1.25;	vmd.maxOptical	= 2.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=440;	vmd.fullPrestige= 473;
			vmd.stockQM = qm_stock_Ishima_Enula_WRZ;	vmd.fullQM = qm_full_Ishima_Enula_WRZ;
			vmd.vehicleName = "Plymouth Sport Fury '69";

		// make color indexes //
		addColorIndex(GameLogic.PLYMOUTH_SILVER);
		addColorIndex(GameLogic.PLYMOUTH_ICE_BLUE);
		addColorIndex(GameLogic.PLYMOUTH_BLUE_FIRE);
		addColorIndex(GameLogic.PLYMOUTH_JAMAICA_BLUE);
		addColorIndex(GameLogic.PLYMOUTH_FROST_GREEN);
		addColorIndex(GameLogic.PLYMOUTH_LIMELIGHT);
		addColorIndex(GameLogic.PLYMOUTH_IVY_GREEN);
		addColorIndex(GameLogic.PLYMOUTH_SAND_PEBBLE_BEIGE);
		addColorIndex(GameLogic.PLYMOUTH_SEAFOAM_TURQUOISE);
		addColorIndex(GameLogic.PLYMOUTH_BARRACUDA_ORANGE);
		addColorIndex(GameLogic.PLYMOUTH_SCORCH_RED);
		addColorIndex(GameLogic.PLYMOUTH_HONEY_BRONZE);
		addColorIndex(GameLogic.PLYMOUTH_BRONZE_FIRE);
		addColorIndex(GameLogic.PLYMOUTH_SADDLE_BRONZE);
		addColorIndex(GameLogic.PLYMOUTH_ALPINE_WHITE);
		addColorIndex(GameLogic.PLYMOUTH_BLACK_VELVET);
		addColorIndex(GameLogic.PLYMOUTH_SUNFIRE_YELLOW);
		addColorIndex(GameLogic.PLYMOUTH_YELLOW_GOLD);
		addColorIndex(GameLogic.PLYMOUTH_SPANISH_GOLD);
		addColorIndex(GameLogic.PLYMOUTH_CITRON_GOLD);
		addColorIndex(GameLogic.PLYMOUTH_BAHAMA_YELLOW);
		addColorIndex(GameLogic.PLYMOUTH_ORANGE);
		addColorIndex(GameLogic.PLYMOUTH_RALLYE_GREEN);
		addColorIndex(GameLogic.PLYMOUTH_VITAMIN_C);

		//prevalence *= 1000.0;
	}
}
