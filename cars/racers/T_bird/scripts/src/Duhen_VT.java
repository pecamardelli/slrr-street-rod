package java.game.cars;

import java.game.*;

public class Duhen_VT extends VehicleType
{
	public Duhen_VT( int id )
	{
		VehicleModel vmd;

	// DEMO mode //
		// SunStrip 1.5 DVC //
			// a full stock version //
			vmd=new VehicleModel( cars.racers.Duhen:0x00000006r, VS_DEMO );
			vtdarr.addElement( vmd );
			vmd.prevalence	= 0.0;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 1.0;
			vmd.stockPrestige=265;	vmd.fullPrestige= 286;
			vmd.stockQM = qm_stock_Duhen_SunStrip_1_5_DVC;	vmd.fullQM = qm_full_Duhen_SunStrip_1_5_DVC;
			vmd.vehicleName = "Duhen SunStrip 1.5 DVC";

			// a wild version //
			vmd=new VehicleModel( cars.racers.Duhen:0x00000006r, VS_DEMO );
			vtdarr.addElement( vmd );
			vmd.prevalence	= 0.0;
			vmd.minPower	= 1.5;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 2.0;	vmd.maxOptical	= 2.0;
			vmd.stockPrestige=265;	vmd.fullPrestige= 286;
			vmd.stockQM = qm_stock_Duhen_SunStrip_1_5_DVC;	vmd.fullQM = qm_full_Duhen_SunStrip_1_5_DVC;
			vmd.vehicleName = "Duhen SunStrip 1.5 DVC";

		// SunStrip 1.8 DVC //
			// a full stock version //
			vmd=new VehicleModel( cars.racers.Duhen:0x00000126r, VS_DEMO );
			vtdarr.addElement( vmd );
			vmd.prevalence	= 0.0;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 1.0;
			vmd.stockPrestige=292;	vmd.fullPrestige= 313;
			vmd.stockQM = qm_stock_Duhen_SunStrip_1_8_DVC;	vmd.fullQM = qm_full_Duhen_SunStrip_1_8_DVC;
			vmd.vehicleName = "Duhen SunStrip 1.8 DVC";

			// a wild version //
			vmd=new VehicleModel( cars.racers.Duhen:0x00000126r, VS_DEMO );
			vtdarr.addElement( vmd );
			vmd.prevalence	= 0.0;
			vmd.minPower	= 1.5;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 2.0;	vmd.maxOptical	= 2.0;
			vmd.stockPrestige=292;	vmd.fullPrestige= 313;
			vmd.stockQM = qm_stock_Duhen_SunStrip_1_8_DVC;	vmd.fullQM = qm_full_Duhen_SunStrip_1_8_DVC;
			vmd.vehicleName = "Duhen SunStrip 1.8 DVC";

		// SunStrip 2.2 DVC //
			// a full stock version //
			vmd=new VehicleModel( cars.racers.Duhen:0x00000127r, VS_DEMO );
			vtdarr.addElement( vmd );
			vmd.prevalence	= 0.0;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 1.0;
			vmd.stockPrestige=297;	vmd.fullPrestige= 317;
			vmd.stockQM = qm_stock_Duhen_SunStrip_2_2_DVC;	vmd.fullQM = qm_full_Duhen_SunStrip_2_2_DVC;
			vmd.vehicleName = "Duhen SunStrip 2.2 DVC";

			// a wild version //
			vmd=new VehicleModel( cars.racers.Duhen:0x00000127r, VS_DEMO );
			vtdarr.addElement( vmd );
			vmd.prevalence	= 0.0;
			vmd.minPower	= 1.5;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 2.0;	vmd.maxOptical	= 2.0;
			vmd.stockPrestige=297;	vmd.fullPrestige= 317;
			vmd.stockQM = qm_stock_Duhen_SunStrip_2_2_DVC;	vmd.fullQM = qm_full_Duhen_SunStrip_2_2_DVC;
			vmd.vehicleName = "Duhen SunStrip 2.2 DVC";

		prevalence = 0.0;

	// CAREER mode -> used car dealer //
		// SunStrip 1.5 DVC //
			vmd=new VehicleModel( cars.racers.Duhen:0x00000006r, VS_USED );
			vtdarr.addElement( vmd );
			vmd.prevalence = 0.0;
			vmd.minPower	= 0.5;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 0.1;	vmd.maxOptical	= 1.5;
			vmd.minTear	= 0.25;	vmd.maxTear	= 1.0;
			vmd.minWear	= 0.25;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=265;	vmd.fullPrestige= 286;
			vmd.stockQM = qm_stock_Duhen_SunStrip_1_5_DVC;	vmd.fullQM = qm_full_Duhen_SunStrip_1_5_DVC;
			vmd.vehicleName = "Duhen SunStrip 1.5 DVC";
			prevalence += vmd.prevalence;
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Cherry);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Smaragd);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Nacht);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Zucker);

		// SunStrip 1.8 DVC //
			vmd=new VehicleModel( cars.racers.Duhen:0x00000126r, VS_USED );
			vtdarr.addElement( vmd );
			vmd.prevalence = 0.0;
			vmd.minPower	= 0.5;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 0.1;	vmd.maxOptical	= 1.5;
			vmd.minTear	= 0.25;	vmd.maxTear	= 1.0;
			vmd.minWear	= 0.25;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=292;	vmd.fullPrestige= 313;
			vmd.stockQM = qm_stock_Duhen_SunStrip_1_8_DVC;	vmd.fullQM = qm_full_Duhen_SunStrip_1_8_DVC;
			vmd.vehicleName = "Duhen SunStrip 1.8 DVC";
			prevalence += vmd.prevalence;
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Cherry);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Smaragd);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Nacht);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Zucker);

		// SunStrip 2.2 DVC //
			vmd=new VehicleModel( cars.racers.Duhen:0x00000127r, VS_USED );
			vtdarr.addElement( vmd );
			vmd.prevalence = 0.0;
			vmd.minPower	= 0.5;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 0.1;	vmd.maxOptical	= 1.5;
			vmd.minTear	= 0.25;	vmd.maxTear	= 1.0;
			vmd.minWear	= 0.25;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=297;	vmd.fullPrestige= 317;
			vmd.stockQM = qm_stock_Duhen_SunStrip_2_2_DVC;	vmd.fullQM = qm_full_Duhen_SunStrip_2_2_DVC;
			vmd.vehicleName = "Duhen SunStrip 2.2 DVC";
			prevalence += vmd.prevalence;
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Cherry);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Smaragd);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Nacht);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Zucker);

		// Racing SunStrip 2.0 CDVC //
			vmd=new VehicleModel( cars.racers.T_bird:0x00000128r, VS_USED );
			vtdarr.addElement( vmd );
			vmd.prevalence = 600.0;
			vmd.minPower	= 0.5;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 0.1;	vmd.maxOptical	= 1.5;
			vmd.minTear	= 0.25;	vmd.maxTear	= 1.0;
			vmd.minWear	= 0.25;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=458;	vmd.fullPrestige= 482;
			vmd.stockQM = qm_stock_Duhen_Racing_SunStrip_2_0_CDVC;	vmd.fullQM = qm_full_Duhen_Racing_SunStrip_2_0_CDVC;
			vmd.vehicleName = "Ford Thunderbird 351 '57";
			prevalence += vmd.prevalence;
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Cherry);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Smaragd);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Nacht);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Zucker);

	// CAREER mode -> new car dealer //
		// SunStrip 1.5 DVC //
			vmd=new VehicleModel( cars.racers.Duhen:0x00000006r, VS_STOCK );
			vtdarr.addElement( vmd );
			vmd.prevalence = 0.0;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 1.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=265;	vmd.fullPrestige= 286;
			vmd.stockQM = qm_stock_Duhen_SunStrip_1_5_DVC;	vmd.fullQM = qm_full_Duhen_SunStrip_1_5_DVC;
			vmd.vehicleName = "Duhen SunStrip 1.5 DVC";
			prevalence += vmd.prevalence;

		// SunStrip 1.8 DVC //
			vmd=new VehicleModel( cars.racers.Duhen:0x00000126r, VS_STOCK );
			vtdarr.addElement( vmd );
			vmd.prevalence = 0.0;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 1.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=292;	vmd.fullPrestige= 313;
			vmd.stockQM = qm_stock_Duhen_SunStrip_1_8_DVC;	vmd.fullQM = qm_full_Duhen_SunStrip_1_8_DVC;
			vmd.vehicleName = "Duhen SunStrip 1.8 DVC";
			prevalence += vmd.prevalence;

		// SunStrip 2.2 DVC //
			vmd=new VehicleModel( cars.racers.Duhen:0x00000127r, VS_STOCK );
			vtdarr.addElement( vmd );
			vmd.prevalence = 0.0;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 1.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=297;	vmd.fullPrestige= 317;
			vmd.stockQM = qm_stock_Duhen_SunStrip_2_2_DVC;	vmd.fullQM = qm_full_Duhen_SunStrip_2_2_DVC;
			vmd.vehicleName = "Duhen SunStrip 2.2 DVC";
			prevalence += vmd.prevalence;

	// CAREER mode -> race //
		// SunStrip 1.5 DVC //
			vmd=new VehicleModel( cars.racers.Duhen:0x00000006r, VS_DRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = 0.0;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 2.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=265;	vmd.fullPrestige= 286;
			vmd.stockQM = qm_stock_Duhen_SunStrip_1_5_DVC;	vmd.fullQM = qm_full_Duhen_SunStrip_1_5_DVC;
			vmd.vehicleName = "Duhen SunStrip 1.5 DVC";
			prevalence += vmd.prevalence;

		// SunStrip 1.8 DVC //
			vmd=new VehicleModel( cars.racers.Duhen:0x00000126r, VS_DRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = 0.0;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.75;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 2.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=292;	vmd.fullPrestige= 313;
			vmd.stockQM = qm_stock_Duhen_SunStrip_1_8_DVC;	vmd.fullQM = qm_full_Duhen_SunStrip_1_8_DVC;
			vmd.vehicleName = "Duhen SunStrip 1.8 DVC";
			prevalence += vmd.prevalence;

			vmd=new VehicleModel( cars.racers.Duhen:0x00000126r, VS_NRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = 0.0;
			vmd.minPower	= 1.7;	vmd.maxPower	= 2.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 2.0;
			vmd.stockPrestige=292;	vmd.fullPrestige= 313;
			vmd.stockQM = qm_stock_Duhen_SunStrip_1_8_DVC;	vmd.fullQM = qm_full_Duhen_SunStrip_1_8_DVC;
			vmd.vehicleName = "Duhen SunStrip 1.8 DVC";

		// SunStrip 2.2 DVC //
			vmd=new VehicleModel( cars.racers.Duhen:0x00000127r, VS_DRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = 0.0;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 2.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=297;	vmd.fullPrestige= 317;
			vmd.stockQM = qm_stock_Duhen_SunStrip_2_2_DVC;	vmd.fullQM = qm_full_Duhen_SunStrip_2_2_DVC;
			vmd.vehicleName = "Duhen SunStrip 2.2 DVC";
			prevalence += vmd.prevalence;

			vmd=new VehicleModel( cars.racers.Duhen:0x00000127r, VS_NRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = 0.0;
			vmd.minPower	= 1.7;	vmd.maxPower	= 2.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 2.0;
			vmd.stockPrestige=297;	vmd.fullPrestige= 317;
			vmd.stockQM = qm_stock_Duhen_SunStrip_2_2_DVC;	vmd.fullQM = qm_full_Duhen_SunStrip_2_2_DVC;
			vmd.vehicleName = "Duhen SunStrip 2.2 DVC";

		// Racing SunStrip 2.0 CDVC //
			vmd=new VehicleModel( cars.racers.T_bird:0x00000128r, VS_DRACE | VS_NRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = 900.0;
			vmd.minPower	= 1.0;	vmd.maxPower	= 2.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 2.0;
			vmd.minTear	= 0.75;	vmd.maxTear	= 1.0;
			vmd.minWear	= 0.75;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=458;	vmd.fullPrestige= 482;
			vmd.stockQM = qm_stock_Duhen_Racing_SunStrip_2_0_CDVC;	vmd.fullQM = qm_full_Duhen_Racing_SunStrip_2_0_CDVC;
			vmd.vehicleName = "Ford Thunderbird 351 '57";
			prevalence += vmd.prevalence;

			vmd=new VehicleModel( cars.racers.T_bird:0x00000128r, VS_RRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = 800.0;
			vmd.minPower	= 1.4;	vmd.maxPower	= 2.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 2.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=458;	vmd.fullPrestige= 482;
			vmd.stockQM = qm_stock_Duhen_Racing_SunStrip_2_0_CDVC;	vmd.fullQM = qm_full_Duhen_Racing_SunStrip_2_0_CDVC;
			vmd.vehicleName = "Ford Thunderbird 351 '57";

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
