package java.game.cars;

import java.game.*;

public class Mercury_Park_Lane_64_VT extends VehicleType
{
	public Mercury_Park_Lane_64_VT( int id )
	{
		VehicleModel vmd;

	// DEMO mode //
		// Mercury Park Lane '64 //
			// a full stock version //
			vmd=new VehicleModel( cars.racers.Duhen:0x00000006r, VS_DEMO );
			vtdarr.addElement( vmd );
			vmd.prevalence	= 1.0;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 1.0;
			vmd.stockPrestige=265;	vmd.fullPrestige= 286;
			vmd.stockQM = qm_stock_Duhen_SunStrip_1_5_DVC;	vmd.fullQM = qm_full_Duhen_SunStrip_1_5_DVC;
			vmd.vehicleName = "Mercury Park Lane '64";

			// a wild version //
			vmd=new VehicleModel( cars.racers.Duhen:0x00000006r, VS_DEMO );
			vtdarr.addElement( vmd );
			vmd.prevalence	= 1.0;
			vmd.minPower	= 1.5;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 2.0;	vmd.maxOptical	= 2.0;
			vmd.stockPrestige=265;	vmd.fullPrestige= 286;
			vmd.stockQM = qm_stock_Duhen_SunStrip_1_5_DVC;	vmd.fullQM = qm_full_Duhen_SunStrip_1_5_DVC;
			vmd.vehicleName = "Mercury Park Lane '64";

		// Mercury Park Lane Vinyl Top '64 //
			// a full stock version //
			vmd=new VehicleModel( cars.racers.Duhen:0x00000126r, VS_DEMO );
			vtdarr.addElement( vmd );
			vmd.prevalence	= 1.0;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 1.0;
			vmd.stockPrestige=292;	vmd.fullPrestige= 313;
			vmd.stockQM = qm_stock_Duhen_SunStrip_1_8_DVC;	vmd.fullQM = qm_full_Duhen_SunStrip_1_8_DVC;
			vmd.vehicleName = "Mercury Park Lane Vinyl Top '64";

			// a wild version //
			vmd=new VehicleModel( cars.racers.Duhen:0x00000126r, VS_DEMO );
			vtdarr.addElement( vmd );
			vmd.prevalence	= 1.0;
			vmd.minPower	= 1.5;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 2.0;	vmd.maxOptical	= 2.0;
			vmd.stockPrestige=292;	vmd.fullPrestige= 313;
			vmd.stockQM = qm_stock_Duhen_SunStrip_1_8_DVC;	vmd.fullQM = qm_full_Duhen_SunStrip_1_8_DVC;
			vmd.vehicleName = "Mercury Park Lane Vinyl Top '64";

		// Mercury Park Lane White Top '64 //
			// a full stock version //
			vmd=new VehicleModel( cars.racers.Duhen:0x00000127r, VS_DEMO );
			vtdarr.addElement( vmd );
			vmd.prevalence	= 1.0;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 1.0;
			vmd.stockPrestige=297;	vmd.fullPrestige= 317;
			vmd.stockQM = qm_stock_Duhen_SunStrip_2_2_DVC;	vmd.fullQM = qm_full_Duhen_SunStrip_2_2_DVC;
			vmd.vehicleName = "Mercury Park Lane White Top '64";

			// a wild version //
			vmd=new VehicleModel( cars.racers.Duhen:0x00000127r, VS_DEMO );
			vtdarr.addElement( vmd );
			vmd.prevalence	= 1.0;
			vmd.minPower	= 1.5;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 2.0;	vmd.maxOptical	= 2.0;
			vmd.stockPrestige=297;	vmd.fullPrestige= 317;
			vmd.stockQM = qm_stock_Duhen_SunStrip_2_2_DVC;	vmd.fullQM = qm_full_Duhen_SunStrip_2_2_DVC;
			vmd.vehicleName = "Mercury Park Lane White Top '64";

		prevalence = 0.0;

	// CAREER mode -> used car dealer //
		// Mercury Park Lane '64 //
			vmd=new VehicleModel( cars.racers.Duhen:0x00000006r, VS_USED );
			vtdarr.addElement( vmd );
			vmd.prevalence = 1700.0;
			vmd.minPower	= 0.5;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 0.5;	vmd.maxOptical	= 1.5;
			vmd.minTear	= 0.75;	vmd.maxTear	= 1.0;
			vmd.minWear	= 0.75;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=265;	vmd.fullPrestige= 286;
			vmd.stockQM = qm_stock_Duhen_SunStrip_1_5_DVC;	vmd.fullQM = qm_full_Duhen_SunStrip_1_5_DVC;
			vmd.vehicleName = "Mercury Park Lane '64";
			prevalence += vmd.prevalence;
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Cherry);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Smaragd);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Nacht);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Zucker);

		// Mercury Park Lane Vinyl Top '64 //
			vmd=new VehicleModel( cars.racers.Duhen:0x00000126r, VS_USED );
			vtdarr.addElement( vmd );
			vmd.prevalence = 1620.0;
			vmd.minPower	= 0.5;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 0.5;	vmd.maxOptical	= 1.5;
			vmd.minTear	= 0.75;	vmd.maxTear	= 1.0;
			vmd.minWear	= 0.75;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=292;	vmd.fullPrestige= 313;
			vmd.stockQM = qm_stock_Duhen_SunStrip_1_8_DVC;	vmd.fullQM = qm_full_Duhen_SunStrip_1_8_DVC;
			vmd.vehicleName = "Mercury Park Lane Vinyl Top '64";
			prevalence += vmd.prevalence;
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Cherry);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Smaragd);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Nacht);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Zucker);

		// Mercury Park Lane White Top '64 //
			vmd=new VehicleModel( cars.racers.Duhen:0x00000127r, VS_USED );
			vtdarr.addElement( vmd );
			vmd.prevalence = 1700.0;
			vmd.minPower	= 0.5;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 0.5;	vmd.maxOptical	= 1.5;
			vmd.minTear	= 0.75;	vmd.maxTear	= 1.0;
			vmd.minWear	= 0.75;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=297;	vmd.fullPrestige= 317;
			vmd.stockQM = qm_stock_Duhen_SunStrip_2_2_DVC;	vmd.fullQM = qm_full_Duhen_SunStrip_2_2_DVC;
			vmd.vehicleName = "Mercury Park Lane White Top '64";
			prevalence += vmd.prevalence;
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Cherry);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Smaragd);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Nacht);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Zucker);

	// CAREER mode -> new car dealer //
		// Mercury Park Lane '64 //
			vmd=new VehicleModel( cars.racers.Duhen:0x00000006r, VS_STOCK );
			vtdarr.addElement( vmd );
			vmd.prevalence = 1000.0;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 1.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=265;	vmd.fullPrestige= 286;
			vmd.stockQM = qm_stock_Duhen_SunStrip_1_5_DVC;	vmd.fullQM = qm_full_Duhen_SunStrip_1_5_DVC;
			vmd.vehicleName = "Mercury Park Lane '64";
			prevalence += vmd.prevalence;

		// Mercury Park Lane Vinyl Top '64 //
			vmd=new VehicleModel( cars.racers.Duhen:0x00000126r, VS_STOCK );
			vtdarr.addElement( vmd );
			vmd.prevalence = 1000.0;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 1.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=292;	vmd.fullPrestige= 313;
			vmd.stockQM = qm_stock_Duhen_SunStrip_1_8_DVC;	vmd.fullQM = qm_full_Duhen_SunStrip_1_8_DVC;
			vmd.vehicleName = "Mercury Park Lane Vinyl Top '64";
			prevalence += vmd.prevalence;

		// Mercury Park Lane White Top '64 //
			vmd=new VehicleModel( cars.racers.Duhen:0x00000127r, VS_STOCK );
			vtdarr.addElement( vmd );
			vmd.prevalence = 1000.0;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 1.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=297;	vmd.fullPrestige= 317;
			vmd.stockQM = qm_stock_Duhen_SunStrip_2_2_DVC;	vmd.fullQM = qm_full_Duhen_SunStrip_2_2_DVC;
			vmd.vehicleName = "Mercury Park Lane White Top '64";
			prevalence += vmd.prevalence;

	// CAREER mode -> race //
		// Mercury Park Lane '64 //
			vmd=new VehicleModel( cars.racers.Duhen:0x00000006r, VS_DRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = 1950.0;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 2.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=265;	vmd.fullPrestige= 286;
			vmd.stockQM = qm_stock_Duhen_SunStrip_1_5_DVC;	vmd.fullQM = qm_full_Duhen_SunStrip_1_5_DVC;
			vmd.vehicleName = "Mercury Park Lane '64";
			prevalence += vmd.prevalence;
			
			vmd=new VehicleModel( cars.racers.Duhen:0x00000006r, VS_NRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = 1600.0;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 2.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=265;	vmd.fullPrestige= 286;
			vmd.stockQM = qm_stock_Duhen_SunStrip_1_5_DVC;	vmd.fullQM = qm_full_Duhen_SunStrip_1_5_DVC;
			vmd.vehicleName = "Mercury Park Lane '64";
			prevalence += vmd.prevalence;
			
			vmd=new VehicleModel( cars.racers.Duhen:0x00000006r, VS_RRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = 1200.0;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 2.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=265;	vmd.fullPrestige= 286;
			vmd.stockQM = qm_stock_Duhen_SunStrip_1_5_DVC;	vmd.fullQM = qm_full_Duhen_SunStrip_1_5_DVC;
			vmd.vehicleName = "Mercury Park Lane '64";
			prevalence += vmd.prevalence;

		// Mercury Park Lane Vinyl Top '64 //
			vmd=new VehicleModel( cars.racers.Duhen:0x00000126r, VS_DRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = 1900.0;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.75;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 2.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=292;	vmd.fullPrestige= 313;
			vmd.stockQM = qm_stock_Duhen_SunStrip_1_8_DVC;	vmd.fullQM = qm_full_Duhen_SunStrip_1_8_DVC;
			vmd.vehicleName = "Mercury Park Lane Vinyl Top '64";
			prevalence += vmd.prevalence;

			vmd=new VehicleModel( cars.racers.Duhen:0x00000126r, VS_NRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = 1600.0;
			vmd.minPower	= 1.7;	vmd.maxPower	= 2.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 2.0;
			vmd.stockPrestige=292;	vmd.fullPrestige= 313;
			vmd.stockQM = qm_stock_Duhen_SunStrip_1_8_DVC;	vmd.fullQM = qm_full_Duhen_SunStrip_1_8_DVC;
			vmd.vehicleName = "Mercury Park Lane Vinyl Top '64";
			
			vmd=new VehicleModel( cars.racers.Duhen:0x00000126r, VS_RRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = 1200.0;
			vmd.minPower	= 1.7;	vmd.maxPower	= 2.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 2.0;
			vmd.stockPrestige=292;	vmd.fullPrestige= 313;
			vmd.stockQM = qm_stock_Duhen_SunStrip_1_8_DVC;	vmd.fullQM = qm_full_Duhen_SunStrip_1_8_DVC;
			vmd.vehicleName = "Mercury Park Lane Vinyl Top '64";

		// Mercury Park Lane White Top '64 //
			vmd=new VehicleModel( cars.racers.Duhen:0x00000127r, VS_DRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = 1900.0;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 2.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=297;	vmd.fullPrestige= 317;
			vmd.stockQM = qm_stock_Duhen_SunStrip_2_2_DVC;	vmd.fullQM = qm_full_Duhen_SunStrip_2_2_DVC;
			vmd.vehicleName = "Mercury Park Lane White Top '64";
			prevalence += vmd.prevalence;

			vmd=new VehicleModel( cars.racers.Duhen:0x00000127r, VS_NRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = 1500.0;
			vmd.minPower	= 1.7;	vmd.maxPower	= 2.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 2.0;
			vmd.stockPrestige=297;	vmd.fullPrestige= 317;
			vmd.stockQM = qm_stock_Duhen_SunStrip_2_2_DVC;	vmd.fullQM = qm_full_Duhen_SunStrip_2_2_DVC;
			vmd.vehicleName = "Mercury Park Lane White Top '64";
			
			vmd=new VehicleModel( cars.racers.Duhen:0x00000127r, VS_RRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = 1100.0;
			vmd.minPower	= 1.7;	vmd.maxPower	= 2.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 2.0;
			vmd.stockPrestige=297;	vmd.fullPrestige= 317;
			vmd.stockQM = qm_stock_Duhen_SunStrip_2_2_DVC;	vmd.fullQM = qm_full_Duhen_SunStrip_2_2_DVC;
			vmd.vehicleName = "Mercury Park Lane White Top '64";


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
