package java.game.cars;

import java.game.*;

public class El_Camino_VT extends VehicleType
{
	public El_Camino_VT( int id )
	{
		VehicleModel vmd;
		float totalProduction = 477.07;

	// DEMO mode //
		// Chevrolet El Camino '70 //
			// a full stock version //
			vmd=new VehicleModel( cars.racers.Chevrolet_El_Camino_1970:0x00000006r, VS_DEMO );
			vtdarr.addElement( vmd );
			vmd.prevalence	= 1.0;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 1.0;
			vmd.stockPrestige=541;	vmd.fullPrestige= 638;
			vmd.stockQM = qm_stock_MC_GT;	vmd.fullQM = qm_full_MC_GT;
			vmd.vehicleName = "Chevrolet El Camino '70";

			// a wild version //
			vmd=new VehicleModel( cars.racers.Chevrolet_El_Camino_1970:0x00000006r, VS_DEMO );
			vtdarr.addElement( vmd );
			vmd.prevalence	= 1.0;
			vmd.minPower	= 1.5;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 2.0;	vmd.maxOptical	= 2.0;
			vmd.stockPrestige=541;	vmd.fullPrestige= 638;
			vmd.stockQM = qm_stock_MC_GT;	vmd.fullQM = qm_full_MC_GT;
			vmd.vehicleName = "Chevrolet El Camino '70";

		prevalence = 0.0;

	// CAREER mode -> used car dealer //
		// Chevrolet El Camino '70 //
			vmd=new VehicleModel( cars.racers.Chevrolet_El_Camino_1970:0x00000006r, VS_USED );
			vtdarr.addElement( vmd );
			vmd.prevalence = totalProduction;
			vmd.minPower	= 0.5;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 0.95;	vmd.maxOptical	= 1.5;
			vmd.minTear	= 0.25;	vmd.maxTear	= 1.0;
			vmd.minWear	= 0.25;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=515;	vmd.fullPrestige= 611;
			vmd.stockQM = qm_stock_MC_GT;	vmd.fullQM = qm_full_MC_GT;
			vmd.vehicleName = "Chevrolet El Camino '70";
			prevalence += vmd.prevalence;
			// vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Cherry);
			// vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Smaragd);
			// vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Nacht);
			// vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Zucker);

	// CAREER mode -> new car dealer //
			// all MC models are abandoned! //

	// CAREER mode -> races //
		// Chevrolet El Camino '70 //
			vmd=new VehicleModel( cars.racers.Chevrolet_El_Camino_1970:0x00000006r, VS_DRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = totalProduction*1.2;
			vmd.minPower	= 1.0;	vmd.maxPower	= 2.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 2.0;
			vmd.minTear	= 0.8;	vmd.maxTear	= 1.0;
			vmd.minWear	= 0.8;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=515;	vmd.fullPrestige= 611;
			vmd.stockQM = qm_stock_MC_GT;	vmd.fullQM = qm_full_MC_GT;
			vmd.vehicleName = "Chevrolet El Camino '70";
			prevalence += vmd.prevalence;

			vmd=new VehicleModel( cars.racers.Chevrolet_El_Camino_1970:0x00000006r, VS_NRACE | VS_RRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = totalProduction*0.7;
			vmd.minPower	= 1.5;	vmd.maxPower	= 2.0;
			vmd.minOptical	= 1.5;	vmd.maxOptical	= 2.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=515;	vmd.fullPrestige= 611;
			vmd.stockQM = qm_stock_MC_GT;	vmd.fullQM = qm_full_MC_GT;
			vmd.vehicleName = "Chevrolet El Camino '70";

		// make color indexes //
		addColorIndex(GameLogic.CHEVROLET_CLASSIC_WHITE);
		addColorIndex(GameLogic.CHEVROLET_CORTEZ_SILVER);
		addColorIndex(GameLogic.CHEVROLET_SHADOW_GRAY);
		addColorIndex(GameLogic.CHEVROLET_TUXEDO_BLACK);
		addColorIndex(GameLogic.CHEVROLET_ASTRO_BLUE);
		addColorIndex(GameLogic.CHEVROLET_ASTRO_BLUE);
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
