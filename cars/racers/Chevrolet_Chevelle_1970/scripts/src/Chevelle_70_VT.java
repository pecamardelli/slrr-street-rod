package java.game.cars;

import java.game.*;

public class Chevelle_70_VT extends VehicleType
{
	public Chevelle_70_VT( int id )
	{
		VehicleModel vmd;

	// DEMO mode //
		// Chevrolet Chevelle ´70 //
			// a full stock version //
			vmd=new VehicleModel( cars.racers.Chevrolet_Chevelle_1970:0x00000006r, VS_USED );
			vtdarr.addElement( vmd );
			vmd.prevalence = 1.0;
			vmd.minPower	= 0.5;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 0.35;	vmd.maxOptical	= 1.5;
			vmd.minTear	= 0.25;	vmd.maxTear	= 1.0;
			vmd.minWear	= 0.25;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=515;	vmd.fullPrestige= 611;
			vmd.stockQM = qm_stock_MC_GT;	vmd.fullQM = qm_full_MC_GT;
			vmd.vehicleName = "Chevrolet Chevelle ´70";

		prevalence = 0.0;

	// CAREER mode -> used car dealer //
		// Chevrolet Chevelle ´70 //
			vmd=new VehicleModel( cars.racers.Chevrolet_Chevelle_1970:0x00000006r, VS_USED );
			vtdarr.addElement( vmd );
			vmd.prevalence = 1777.0;
			vmd.minPower	= 0.5;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 0.35;	vmd.maxOptical	= 1.5;
			vmd.minTear	= 0.25;	vmd.maxTear	= 1.0;
			vmd.minWear	= 0.25;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=515;	vmd.fullPrestige= 611;
			vmd.stockQM = qm_stock_MC_GT;	vmd.fullQM = qm_full_MC_GT;
			vmd.vehicleName = "Chevrolet Chevelle '70";
			prevalence += vmd.prevalence;
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Cherry);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Smaragd);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Nacht);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Zucker);

	// CAREER mode -> new car dealer //
			// all MC models are abandoned! //

	// CAREER mode -> races //
		// Chevrolet Chevelle ´70 //
			vmd=new VehicleModel( cars.racers.Chevrolet_Chevelle_1970:0x00000006r, VS_DRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = 2120.0;
			vmd.minPower	= 1.0;	vmd.maxPower	= 2.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 2.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=515;	vmd.fullPrestige= 611;
			vmd.stockQM = qm_stock_MC_GT;	vmd.fullQM = qm_full_MC_GT;
			vmd.vehicleName = "Chevrolet Chevelle '70";
			prevalence += vmd.prevalence;

			vmd=new VehicleModel( cars.racers.MC:0x00000006r, VS_NRACE | VS_RRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = 2000.0;
			vmd.minPower	= 1.5;	vmd.maxPower	= 2.0;
			vmd.minOptical	= 1.5;	vmd.maxOptical	= 2.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=515;	vmd.fullPrestige= 611;
			vmd.stockQM = qm_stock_MC_GT;	vmd.fullQM = qm_full_MC_GT;
			vmd.vehicleName = "Chevrolet Chevelle '70";

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
