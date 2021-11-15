package java.game.cars;

import java.game.*;

public class Dodge_330_63_VT extends VehicleType
{
	public Dodge_330_63_VT( int id )
	{
		VehicleModel vmd;
		float totalProduction = 1481.94;

	// DEMO mode //
		// Dodge 330 '63 //
			// a full stock version //
			vmd=new VehicleModel( cars.racers.Einvagen:0x00000006r, VS_DEMO );
			vtdarr.addElement( vmd );
			vmd.prevalence	= 1.0;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 1.0;
			vmd.stockPrestige=204;	vmd.fullPrestige= 244;
			vmd.stockQM = qm_stock_Einvagen_110_GT;	vmd.fullQM = qm_full_Einvagen_110_GT;
			vmd.vehicleName = "Dodge 330 '63";

			// a wild version //
			vmd=new VehicleModel( cars.racers.Einvagen:0x00000006r, VS_DEMO );
			vtdarr.addElement( vmd );
			vmd.prevalence	= 1.0;
			vmd.minPower	= 1.5;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 2.0;	vmd.maxOptical	= 2.0;
			vmd.stockPrestige=204;	vmd.fullPrestige= 244;
			vmd.stockQM = qm_stock_Einvagen_110_GT;	vmd.fullQM = qm_full_Einvagen_110_GT;
			vmd.vehicleName = "Dodge 330 '63";
			
		prevalence = 0.0;

	// CAREER mode -> used car dealer //
		// Dodge 330 '63 //
			vmd=new VehicleModel( cars.racers.Einvagen:0x00000006r, VS_USED );
			vtdarr.addElement( vmd );
			vmd.prevalence = totalProduction;
			vmd.minPower	= 0.5;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 0.95;	vmd.maxOptical	= 1.5;
			vmd.minTear	= 0.75;	vmd.maxTear	= 1.0;
			vmd.minWear	= 0.75;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=204;	vmd.fullPrestige= 244;
			vmd.stockQM = qm_stock_Einvagen_110_GT;	vmd.fullQM = qm_full_Einvagen_110_GT;
			vmd.vehicleName = "Dodge 330 '63";
			prevalence = vmd.prevalence;
			// vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Cherry);
			// vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Smaragd);
			// vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Nacht);
			// vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Zucker);

	// CAREER mode -> new car dealer //
		// Dodge 330 '63 //
			vmd=new VehicleModel( cars.racers.Einvagen:0x00000006r, VS_STOCK );
			vtdarr.addElement( vmd );
			vmd.prevalence = totalProduction;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 1.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=204;	vmd.fullPrestige= 244;
			vmd.stockQM = qm_stock_Einvagen_110_GT;	vmd.fullQM = qm_full_Einvagen_110_GT;
			vmd.vehicleName = "Dodge 330 '63";
			prevalence = vmd.prevalence;

	// CAREER mode -> races //
		// Dodge 330 '63 //
			vmd=new VehicleModel( cars.racers.Einvagen:0x00000006r, VS_DRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = totalProduction*1.2;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 1.5;
			vmd.minTear	= 0.8;	vmd.maxTear	= 1.0;
			vmd.minWear	= 0.8;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=204;	vmd.fullPrestige= 244;
			vmd.stockQM = qm_stock_Einvagen_110_GT;	vmd.fullQM = qm_full_Einvagen_110_GT;
			vmd.vehicleName = "Dodge 330 '63";
			prevalence = vmd.prevalence;
			
			vmd=new VehicleModel( cars.racers.Einvagen:0x00000006r, VS_NRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = totalProduction*1.15;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 1.5;
			vmd.minTear	= 0.8;	vmd.maxTear	= 1.0;
			vmd.minWear	= 0.8;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=204;	vmd.fullPrestige= 244;
			vmd.stockQM = qm_stock_Einvagen_110_GT;	vmd.fullQM = qm_full_Einvagen_110_GT;
			vmd.vehicleName = "Dodge 330 '63";
			prevalence = vmd.prevalence;
			
			vmd=new VehicleModel( cars.racers.Einvagen:0x00000006r, VS_RRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = totalProduction*0.9;
			vmd.minPower	= 1.0;	vmd.maxPower	= 2.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 2.0;
			vmd.minTear	= 0.8;	vmd.maxTear	= 1.0;
			vmd.minWear	= 0.8;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=204;	vmd.fullPrestige= 244;
			vmd.stockQM = qm_stock_Einvagen_110_GT;	vmd.fullQM = qm_full_Einvagen_110_GT;
			vmd.vehicleName = "Dodge 330 '63";
			prevalence = vmd.prevalence;

		// make color indexes //
		addColorIndex(GameLogic.DODGE_TURQUOISE);
		addColorIndex(GameLogic.DODGE_DARK_TURQUOISE);
		addColorIndex(GameLogic.DODGE_LIGHT_BLUE);
		addColorIndex(GameLogic.DODGE_IVORY);
		addColorIndex(GameLogic.DODGE_MEDIUM_BLUE);
		addColorIndex(GameLogic.DODGE_STEEL_GRAY);
		addColorIndex(GameLogic.DODGE_DARK_BLUE);
		addColorIndex(GameLogic.DODGE_VERMILION);
		addColorIndex(GameLogic.DODGE_LIGHT_BLUE);
		addColorIndex(GameLogic.DODGE_POLAR);
		addColorIndex(GameLogic.DODGE_FOREST_GREEN);
		addColorIndex(GameLogic.DODGE_BEIGE);
		addColorIndex(GameLogic.DODGE_AQUA);
		addColorIndex(GameLogic.DODGE_SANDALWOOD);
		addColorIndex(GameLogic.DODGE_SLATE_TURQUOISE);
		addColorIndex(GameLogic.DODGE_CORDOVAN);

//		prevalence *= 1000.0;
	}
}
