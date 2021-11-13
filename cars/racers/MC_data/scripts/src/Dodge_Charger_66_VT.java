package java.game.cars;

import java.game.*;

public class Dodge_Charger_66_VT extends VehicleType
{
	public Dodge_Charger_66_VT( int id )
	{
		VehicleModel vmd;

	// DEMO mode //
		// Dodge Charger 440 '66 //
			// a full stock version //
			vmd=new VehicleModel( cars.racers.MC:0x00000006r, VS_DEMO );
			vtdarr.addElement( vmd );
			vmd.prevalence	= 1.0;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 1.0;
			vmd.stockPrestige=541;	vmd.fullPrestige= 638;
			vmd.stockQM = qm_stock_MC_GT;	vmd.fullQM = qm_full_MC_GT;
			vmd.vehicleName = "Dodge Charger '66";

			// a wild version //
			vmd=new VehicleModel( cars.racers.MC:0x00000006r, VS_DEMO );
			vtdarr.addElement( vmd );
			vmd.prevalence	= 1.0;
			vmd.minPower	= 1.5;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 2.0;	vmd.maxOptical	= 2.0;
			vmd.stockPrestige=541;	vmd.fullPrestige= 638;
			vmd.stockQM = qm_stock_MC_GT;	vmd.fullQM = qm_full_MC_GT;
			vmd.vehicleName = "Dodge Charger '66";

		prevalence = 0.0;

	// CAREER mode -> used car dealer //
		// Dodge Charger '66 //
			vmd=new VehicleModel( cars.racers.MC:0x00000006r, VS_USED );
			vtdarr.addElement( vmd );
			vmd.prevalence = 1700.0;
			vmd.minPower	= 0.5;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 0.55;	vmd.maxOptical	= 1.5;
			vmd.minTear	= 0.65;	vmd.maxTear	= 1.0;
			vmd.minWear	= 0.65;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=315;	vmd.fullPrestige= 411;
			vmd.stockQM = qm_stock_MC_GT;	vmd.fullQM = qm_full_MC_GT;
			vmd.vehicleName = "Dodge Charger '66";
			prevalence = vmd.prevalence;
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Cherry);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Smaragd);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Nacht);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Zucker);

			// wrecks/used/modified - in all colors //
			vmd=new VehicleModel( cars.racers.MC:0x00000006r, VS_USED );
			vtdarr.addElement( vmd );
			vmd.prevalence = 1700.0;
			vmd.minPower	= 0.5;	vmd.maxPower	= 2.0;
			vmd.minOptical	= 0.35;	vmd.maxOptical	= 2.0;
			vmd.minTear	= 0.25;	vmd.maxTear	= 1.0;
			vmd.minWear	= 0.25;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=412;	vmd.fullPrestige= 509;
			vmd.stockQM = qm_stock_MC_GT;	vmd.fullQM = qm_full_MC_GT;
			vmd.vehicleName = "Dodge Charger '66";
			prevalence = vmd.prevalence;
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Cherry);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Smaragd);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Nacht);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Zucker);

	// CAREER mode -> new car dealer //
			// all MC models are abandoned! //

	// CAREER mode -> races //
		// Dodge Charger '66 //
			vmd=new VehicleModel( cars.racers.MC:0x00000006r, VS_DRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = 2000.0;
			vmd.minPower	= 1.0;	vmd.maxPower	= 2.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 2.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=315;	vmd.fullPrestige= 411;
			vmd.stockQM = qm_stock_MC_GT;	vmd.fullQM = qm_full_MC_GT;
			vmd.vehicleName = "Dodge Charger '66";
			prevalence = vmd.prevalence;

			vmd=new VehicleModel( cars.racers.MC:0x00000006r, VS_NRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = 2000.0;
			vmd.minPower	= 1.5;	vmd.maxPower	= 2.0;
			vmd.minOptical	= 1.5;	vmd.maxOptical	= 2.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=415;	vmd.fullPrestige= 511;
			vmd.stockQM = qm_stock_MC_GT;	vmd.fullQM = qm_full_MC_GT;
			vmd.vehicleName = "Dodge Charger '66";
			prevalence = vmd.prevalence;
			
			vmd=new VehicleModel( cars.racers.MC:0x00000006r, VS_RRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = 2000.0;
			vmd.minPower	= 1.5;	vmd.maxPower	= 2.0;
			vmd.minOptical	= 1.5;	vmd.maxOptical	= 2.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=415;	vmd.fullPrestige= 511;
			vmd.stockQM = qm_stock_MC_GT;	vmd.fullQM = qm_full_MC_GT;
			vmd.vehicleName = "Dodge Charger '66";
			prevalence = vmd.prevalence;


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
