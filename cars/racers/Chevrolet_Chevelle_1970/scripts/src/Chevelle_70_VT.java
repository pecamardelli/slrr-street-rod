package java.game.cars;

import java.game.*;

public class Chevelle_70_VT extends VehicleType
{
	public Chevelle_70_VT( int id )
	{
		VehicleModel vmd;
		float totalProduction = 2896.220; // Total production of Malibu, 2-door sport coupe V8 divided by 100. Source: http://chevellestuff.net/1970/style_prod_no.htm

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
			vmd.prevalence = totalProduction; // Total production of Malibu, 2-door sport coupe V8. Source: http://chevellestuff.net/1970/style_prod_no.htm
			vmd.minPower	= 0.5;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 0.95;	vmd.maxOptical	= 1.5;
			vmd.minTear	= 0.25;	vmd.maxTear	= 1.0;
			vmd.minWear	= 0.25;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=515;	vmd.fullPrestige= 611;
			vmd.stockQM = qm_stock_MC_GT;	vmd.fullQM = qm_full_MC_GT;
			vmd.vehicleName = "Chevrolet Chevelle '70";
			prevalence += vmd.prevalence;
			// vmd.addColorIndex(GameLogic.CHEVROLET_CLASSIC_WHITE);
			// vmd.addColorIndex(GameLogic.CHEVROLET_BRIDGEHAMPTON_BLUE);
			// vmd.addColorIndex(GameLogic.CHEVROLET_MARLBORO_MAROON);
			// vmd.addColorIndex(GameLogic.CHEVROLET_CORTEZ_SILVER);
			// vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Nacht);
			// vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Zucker);

	// CAREER mode -> new car dealer //
			// all MC models are abandoned! //

	// CAREER mode -> races //
		// Chevrolet Chevelle ´70 //
			vmd=new VehicleModel( cars.racers.Chevrolet_Chevelle_1970:0x00000006r, VS_DRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = totalProduction;
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
			vmd.prevalence = totalProduction;
			vmd.minPower	= 1.5;	vmd.maxPower	= 2.0;
			vmd.minOptical	= 1.5;	vmd.maxOptical	= 2.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=515;	vmd.fullPrestige= 611;
			vmd.stockQM = qm_stock_MC_GT;	vmd.fullQM = qm_full_MC_GT;
			vmd.vehicleName = "Chevrolet Chevelle '70";

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

		prevalence *= 1000.0;
	}
}
