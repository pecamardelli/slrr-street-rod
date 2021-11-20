package java.game.cars;

import java.game.*;

public class Chevrolet_Impala_SS_67_VT extends VehicleType
{
	public Chevrolet_Impala_SS_67_VT( int id )
	{
		VehicleModel vmd;
		float totalProduction = 756.00;

	// DEMO mode //
		// Chevrolet Impala SS '67 //
			// a full stock version //
			vmd=new VehicleModel( cars.racers.Nonus:0x00000006r, VS_DEMO );
			vtdarr.addElement( vmd );
			vmd.prevalence	= 1.0;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 1.0;
			vmd.stockPrestige=396;	vmd.fullPrestige= 460;
			vmd.stockQM = qm_stock_Emer_Nonus_Street_GT;	vmd.fullQM = qm_full_Emer_Nonus_Street_GT;
			vmd.vehicleName = "Chevrolet Impala SS '67";

			// a wild version //
			vmd=new VehicleModel( cars.racers.Nonus:0x00000006r, VS_DEMO );
			vtdarr.addElement( vmd );
			vmd.prevalence	= 1.0;
			vmd.minPower	= 1.5;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 2.0;	vmd.maxOptical	= 2.0;
			vmd.stockPrestige=396;	vmd.fullPrestige= 460;
			vmd.stockQM = qm_stock_Emer_Nonus_Street_GT;	vmd.fullQM = qm_full_Emer_Nonus_Street_GT;
			vmd.vehicleName = "Chevrolet Impala SS '67";

		prevalence = 0.0;

	// CAREER mode -> used car dealer //
		// Chevrolet Impala SS '67 //
			vmd=new VehicleModel( cars.racers.Nonus:0x00000006r, VS_USED );
			vtdarr.addElement( vmd );
			vmd.prevalence = totalProduction;
			vmd.minPower	= 0.5;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 0.95;	vmd.maxOptical	= 1.5;
			vmd.minTear	= 0.55;	vmd.maxTear	= 1.0;
			vmd.minWear	= 0.55;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=396;	vmd.fullPrestige= 460;
			vmd.stockQM = qm_stock_Emer_Nonus_Street_GT;	vmd.fullQM = qm_full_Emer_Nonus_Street_GT;
			vmd.vehicleName = "Chevrolet Impala SS '67";
			prevalence = vmd.prevalence;
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Cherry);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Smaragd);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Nacht);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Zucker);
			
	// CAREER mode -> new car dealer //
		// Chevrolet Impala SS '67 //
			vmd=new VehicleModel( cars.racers.Nonus:0x00000006r, VS_STOCK );
			vtdarr.addElement( vmd );
			vmd.prevalence = 1000.0;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 1.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=396;	vmd.fullPrestige= 460;
			vmd.stockQM = qm_stock_Emer_Nonus_Street_GT;	vmd.fullQM = qm_full_Emer_Nonus_Street_GT;
			vmd.vehicleName = "Chevrolet Impala SS '67";
			prevalence = vmd.prevalence;

	// CAREER mode -> races //
		// Chevrolet Impala SS '67 //
			vmd=new VehicleModel( cars.racers.Nonus:0x00000006r, VS_DRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = totalProduction*1.1;
			vmd.minPower	= 1.0;	vmd.maxPower	= 2.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 2.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=396;	vmd.fullPrestige= 460;
			vmd.stockQM = qm_stock_Emer_Nonus_Street_GT;	vmd.fullQM = qm_full_Emer_Nonus_Street_GT;
			vmd.vehicleName = "Chevrolet Impala SS '67";
			prevalence = vmd.prevalence;

			vmd=new VehicleModel( cars.racers.Nonus:0x00000006r, VS_NRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = totalProduction*0.9;
			vmd.minPower	= 1.25;	vmd.maxPower	= 1.6;
			vmd.minOptical	= 1.25;	vmd.maxOptical	= 1.6;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=396;	vmd.fullPrestige= 460;
			vmd.stockQM = qm_stock_Emer_Nonus_Street_GT;	vmd.fullQM = qm_full_Emer_Nonus_Street_GT;
			vmd.vehicleName = "Chevrolet Impala SS '67";
			prevalence = vmd.prevalence;
			
			vmd=new VehicleModel( cars.racers.Nonus:0x00000006r, VS_RRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = totalProduction*0.8;
			vmd.minPower	= 1.55;	vmd.maxPower	= 2.0;
			vmd.minOptical	= 1.55;	vmd.maxOptical	= 2.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=396;	vmd.fullPrestige= 460;
			vmd.stockQM = qm_stock_Emer_Nonus_Street_GT;	vmd.fullQM = qm_full_Emer_Nonus_Street_GT;
			vmd.vehicleName = "Chevrolet Impala SS '67";
			prevalence = vmd.prevalence;


		// make color indexes //
		addColorIndex(GameLogic.CHEVROLET_ERMINE_WHITE);
		addColorIndex(GameLogic.CHEVROLET_TAHOE_TURQUOISE_IRIDESCENT);
		addColorIndex(GameLogic.CHEVROLET_RALLY_RED);
		addColorIndex(GameLogic.CHEVROLET_NANTUCKET_BLUE_IRIDESCENT);
		addColorIndex(GameLogic.CHEVROLET_ROYAL_PLUM_IRIDESCENT);
		addColorIndex(GameLogic.CHEVROLET_LYNNDALE_BLUE_IRIDESCENT);
		addColorIndex(GameLogic.CHEVROLET_DEEPWATER_BLUE_IRIDESCENT);
		addColorIndex(GameLogic.CHEVROLET_MADEIRA_MAROON_IRIDESCENT);
		addColorIndex(GameLogic.CHEVROLET_ELKHART_BLUE_IRIDESCENT);
		addColorIndex(GameLogic.CHEVROLET_MARINA_BLUE_IRIDESCENT);
		addColorIndex(GameLogic.CHEVROLET_BOLERO_RED);
		addColorIndex(GameLogic.CHEVROLET_GOODWOOD_GREEN_IRIDESCENT);
		addColorIndex(GameLogic.CHEVROLET_GRANADA_GOLD_IRIDESCENT);
		addColorIndex(GameLogic.CHEVROLET_SIERRA_FAWN_IRIDESCENT);
		addColorIndex(GameLogic.CHEVROLET_SUNFIRE_YELLOW);
		addColorIndex(GameLogic.CHEVROLET_MOUNTAIN_GREEN_IRIDESCENT);
		addColorIndex(GameLogic.CHEVROLET_CAPRI_CREAM);
		addColorIndex(GameLogic.CHEVROLET_SILVER_PEARL_IRIDESCENT);
		addColorIndex(GameLogic.CHEVROLET_EMERALD_TURQUOISE_IRIDESCENT);

		//prevalence *= 1000.0;
	}
}
