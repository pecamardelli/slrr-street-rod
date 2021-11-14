package java.game.cars;

import java.game.*;

public class Mercury_Park_Lane_64_VT extends VehicleType
{
	public Mercury_Park_Lane_64_VT( int id )
	{
		VehicleModel vmd;
		float totalProduction = 187.64;

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
			vmd.prevalence = totalProduction;
			vmd.minPower	= 0.5;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 0.5;	vmd.maxOptical	= 1.5;
			vmd.minTear	= 0.75;	vmd.maxTear	= 1.0;
			vmd.minWear	= 0.75;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=265;	vmd.fullPrestige= 286;
			vmd.stockQM = qm_stock_Duhen_SunStrip_1_5_DVC;	vmd.fullQM = qm_full_Duhen_SunStrip_1_5_DVC;
			vmd.vehicleName = "Mercury Park Lane '64";
			prevalence += vmd.prevalence;
			// vmd.addColorIndex(GameLogic.MERCURY_FAWN);
			// vmd.addColorIndex(GameLogic.MERCURY_CARNIVAL_RED);
			// vmd.addColorIndex(GameLogic.MERCURY_PEACOCK);
			// vmd.addColorIndex(GameLogic.MERCURY_PINK_FROST);
			// vmd.addColorIndex(GameLogic.MERCURY_ANNIVERSARY_SILVER_IRIDESCENT);
			// vmd.addColorIndex(GameLogic.MERCURY_SILVER_TURQUOISE_IRIDESCENT);
			// vmd.addColorIndex(GameLogic.MERCURY_BURGUNDY_IRIDESCENT);
			// vmd.addColorIndex(GameLogic.MERCURY_BITTERSWEET);
			// vmd.addColorIndex(GameLogic.MERCURY_PACIFIC_BLUE_IRIDESCENT);
			// vmd.addColorIndex(GameLogic.MERCURY_GLACIER_BLUE);
			// vmd.addColorIndex(GameLogic.MERCURY_POLAR_WHITE);
			// vmd.addColorIndex(GameLogic.MERCURY_PALOMINO);
			// vmd.addColorIndex(GameLogic.MERCURY_PLATINUM_BEIGE_IRIDESCENT);
			// vmd.addColorIndex(GameLogic.MERCURY_YELLOW_MIST);
			// vmd.addColorIndex(GameLogic.MERCURY_AZTEC_GOLD);

		// Mercury Park Lane Vinyl Top '64 //
			vmd=new VehicleModel( cars.racers.Duhen:0x00000126r, VS_USED );
			vtdarr.addElement( vmd );
			vmd.prevalence = totalProduction;
			vmd.minPower	= 0.5;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 0.5;	vmd.maxOptical	= 1.5;
			vmd.minTear	= 0.75;	vmd.maxTear	= 1.0;
			vmd.minWear	= 0.75;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=292;	vmd.fullPrestige= 313;
			vmd.stockQM = qm_stock_Duhen_SunStrip_1_8_DVC;	vmd.fullQM = qm_full_Duhen_SunStrip_1_8_DVC;
			vmd.vehicleName = "Mercury Park Lane Vinyl Top '64";
			prevalence += vmd.prevalence;
			// vmd.addColorIndex(GameLogic.MERCURY_FAWN);
			// vmd.addColorIndex(GameLogic.MERCURY_CARNIVAL_RED);
			// vmd.addColorIndex(GameLogic.MERCURY_PEACOCK);
			// vmd.addColorIndex(GameLogic.MERCURY_PINK_FROST);
			// vmd.addColorIndex(GameLogic.MERCURY_ANNIVERSARY_SILVER_IRIDESCENT);
			// vmd.addColorIndex(GameLogic.MERCURY_SILVER_TURQUOISE_IRIDESCENT);
			// vmd.addColorIndex(GameLogic.MERCURY_BURGUNDY_IRIDESCENT);
			// vmd.addColorIndex(GameLogic.MERCURY_BITTERSWEET);
			// vmd.addColorIndex(GameLogic.MERCURY_PACIFIC_BLUE_IRIDESCENT);
			// vmd.addColorIndex(GameLogic.MERCURY_GLACIER_BLUE);
			// vmd.addColorIndex(GameLogic.MERCURY_POLAR_WHITE);
			// vmd.addColorIndex(GameLogic.MERCURY_PALOMINO);
			// vmd.addColorIndex(GameLogic.MERCURY_PLATINUM_BEIGE_IRIDESCENT);
			// vmd.addColorIndex(GameLogic.MERCURY_YELLOW_MIST);
			// vmd.addColorIndex(GameLogic.MERCURY_AZTEC_GOLD);

		// Mercury Park Lane White Top '64 //
			vmd=new VehicleModel( cars.racers.Duhen:0x00000127r, VS_USED );
			vtdarr.addElement( vmd );
			vmd.prevalence = totalProduction;
			vmd.minPower	= 0.5;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 0.5;	vmd.maxOptical	= 1.5;
			vmd.minTear	= 0.75;	vmd.maxTear	= 1.0;
			vmd.minWear	= 0.75;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=297;	vmd.fullPrestige= 317;
			vmd.stockQM = qm_stock_Duhen_SunStrip_2_2_DVC;	vmd.fullQM = qm_full_Duhen_SunStrip_2_2_DVC;
			vmd.vehicleName = "Mercury Park Lane White Top '64";
			prevalence += vmd.prevalence;
			// vmd.addColorIndex(GameLogic.MERCURY_FAWN);
			// vmd.addColorIndex(GameLogic.MERCURY_CARNIVAL_RED);
			// vmd.addColorIndex(GameLogic.MERCURY_PEACOCK);
			// vmd.addColorIndex(GameLogic.MERCURY_PINK_FROST);
			// vmd.addColorIndex(GameLogic.MERCURY_ANNIVERSARY_SILVER_IRIDESCENT);
			// vmd.addColorIndex(GameLogic.MERCURY_SILVER_TURQUOISE_IRIDESCENT);
			// vmd.addColorIndex(GameLogic.MERCURY_BURGUNDY_IRIDESCENT);
			// vmd.addColorIndex(GameLogic.MERCURY_BITTERSWEET);
			// vmd.addColorIndex(GameLogic.MERCURY_PACIFIC_BLUE_IRIDESCENT);
			// vmd.addColorIndex(GameLogic.MERCURY_GLACIER_BLUE);
			// vmd.addColorIndex(GameLogic.MERCURY_POLAR_WHITE);
			// vmd.addColorIndex(GameLogic.MERCURY_PALOMINO);
			// vmd.addColorIndex(GameLogic.MERCURY_PLATINUM_BEIGE_IRIDESCENT);
			// vmd.addColorIndex(GameLogic.MERCURY_YELLOW_MIST);
			// vmd.addColorIndex(GameLogic.MERCURY_AZTEC_GOLD);

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
			vmd.prevalence = totalProduction*0.6;
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
			vmd.prevalence = totalProduction*0.5;
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
			vmd.prevalence = totalProduction*0.2;
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
			vmd.prevalence = totalProduction*0.6;
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
			vmd.prevalence = totalProduction*0.5;
			vmd.minPower	= 1.7;	vmd.maxPower	= 2.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 2.0;
			vmd.stockPrestige=292;	vmd.fullPrestige= 313;
			vmd.stockQM = qm_stock_Duhen_SunStrip_1_8_DVC;	vmd.fullQM = qm_full_Duhen_SunStrip_1_8_DVC;
			vmd.vehicleName = "Mercury Park Lane Vinyl Top '64";
			
			vmd=new VehicleModel( cars.racers.Duhen:0x00000126r, VS_RRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = totalProduction*0.18;
			vmd.minPower	= 1.7;	vmd.maxPower	= 2.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 2.0;
			vmd.stockPrestige=292;	vmd.fullPrestige= 313;
			vmd.stockQM = qm_stock_Duhen_SunStrip_1_8_DVC;	vmd.fullQM = qm_full_Duhen_SunStrip_1_8_DVC;
			vmd.vehicleName = "Mercury Park Lane Vinyl Top '64";

		// Mercury Park Lane White Top '64 //
			vmd=new VehicleModel( cars.racers.Duhen:0x00000127r, VS_DRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = totalProduction*0.6;
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
			vmd.prevalence = totalProduction*0.5;
			vmd.minPower	= 1.7;	vmd.maxPower	= 2.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 2.0;
			vmd.stockPrestige=297;	vmd.fullPrestige= 317;
			vmd.stockQM = qm_stock_Duhen_SunStrip_2_2_DVC;	vmd.fullQM = qm_full_Duhen_SunStrip_2_2_DVC;
			vmd.vehicleName = "Mercury Park Lane White Top '64";
			
			vmd=new VehicleModel( cars.racers.Duhen:0x00000127r, VS_RRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = totalProduction*0.22;
			vmd.minPower	= 1.7;	vmd.maxPower	= 2.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 2.0;
			vmd.stockPrestige=297;	vmd.fullPrestige= 317;
			vmd.stockQM = qm_stock_Duhen_SunStrip_2_2_DVC;	vmd.fullQM = qm_full_Duhen_SunStrip_2_2_DVC;
			vmd.vehicleName = "Mercury Park Lane White Top '64";


		// make color indexes //
		addColorIndex(GameLogic.MERCURY_FAWN);
		addColorIndex(GameLogic.MERCURY_CARNIVAL_RED);
		addColorIndex(GameLogic.MERCURY_PEACOCK);
		addColorIndex(GameLogic.MERCURY_PINK_FROST);
		addColorIndex(GameLogic.MERCURY_ANNIVERSARY_SILVER_IRIDESCENT);
		addColorIndex(GameLogic.MERCURY_SILVER_TURQUOISE_IRIDESCENT);
		addColorIndex(GameLogic.MERCURY_BURGUNDY_IRIDESCENT);
		addColorIndex(GameLogic.MERCURY_BITTERSWEET);
		addColorIndex(GameLogic.MERCURY_PACIFIC_BLUE_IRIDESCENT);
		addColorIndex(GameLogic.MERCURY_GLACIER_BLUE);
		addColorIndex(GameLogic.MERCURY_POLAR_WHITE);
		addColorIndex(GameLogic.MERCURY_PALOMINO);
		addColorIndex(GameLogic.MERCURY_PLATINUM_BEIGE_IRIDESCENT);
		addColorIndex(GameLogic.MERCURY_YELLOW_MIST);
		addColorIndex(GameLogic.MERCURY_AZTEC_GOLD);

//		prevalence *= 1000.0;
	}
}
