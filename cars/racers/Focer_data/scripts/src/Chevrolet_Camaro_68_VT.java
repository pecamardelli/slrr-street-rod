package java.game.cars;

import java.game.*;

public class Chevrolet_Camaro_68_VT extends VehicleType
{
	public Chevrolet_Camaro_68_VT( int id )
	{
		VehicleModel vmd;

	// DEMO mode //
		// Chevrolet Camaro SS Vinyl Top '68 //
			// a full stock version //
			vmd=new VehicleModel( cars.racers.Focer:0x00000006r, VS_DEMO );
			vtdarr.addElement( vmd );
			vmd.prevalence	= 1.0;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 1.0;
			vmd.stockPrestige=397;	vmd.fullPrestige= 426;
			vmd.stockQM = qm_stock_Shimutshibu_Focer_RC_200;	vmd.fullQM = qm_full_Shimutshibu_Focer_RC_200;
			vmd.vehicleName = "Chevrolet Camaro SS Vinyl Top '68";

			// a wild version //
			vmd=new VehicleModel( cars.racers.Focer:0x00000006r, VS_DEMO );
			vtdarr.addElement( vmd );
			vmd.prevalence	= 1.0;
			vmd.minPower	= 1.5;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 2.0;	vmd.maxOptical	= 2.0;
			vmd.stockPrestige=397;	vmd.fullPrestige= 426;
			vmd.stockQM = qm_stock_Shimutshibu_Focer_RC_200;	vmd.fullQM = qm_full_Shimutshibu_Focer_RC_200;
			vmd.vehicleName = "Chevrolet Camaro SS Vinyl Top '68";

		// Chevrolet Camaro RS Vinyl Top '68 //
			// a full stock version //
			vmd=new VehicleModel( cars.racers.Focer:0x00002006r, VS_DEMO );
			vtdarr.addElement( vmd );
			vmd.prevalence	= 1.0;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 1.0;
			vmd.stockPrestige=475;	vmd.fullPrestige= 508;
			vmd.stockQM = qm_stock_Shimutshibu_Focer_RC_200;	vmd.fullQM = qm_full_Shimutshibu_Focer_RC_200;
			vmd.vehicleName = "Chevrolet Camaro RS Vinyl Top '68";

			// a wild version //
			vmd=new VehicleModel( cars.racers.Focer:0x00002006r, VS_DEMO );
			vtdarr.addElement( vmd );
			vmd.prevalence	= 1.0;
			vmd.minPower	= 1.5;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 2.0;	vmd.maxOptical	= 2.0;
			vmd.stockPrestige=475;	vmd.fullPrestige= 508;
			vmd.stockQM = qm_stock_Shimutshibu_Focer_RC_200;	vmd.fullQM = qm_full_Shimutshibu_Focer_RC_200;
			vmd.vehicleName = "Chevrolet Camaro RS Vinyl Top '68";

		prevalence = 0.0;

	// CAREER mode -> used car dealer //
		// Chevrolet Camaro SS Vinyl Top '68 //
			vmd=new VehicleModel( cars.racers.Focer:0x00000006r, VS_USED );
			vtdarr.addElement( vmd );
			vmd.prevalence = 2000.0;
			vmd.minPower	= 0.5;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 0.5;	vmd.maxOptical	= 1.5;
			vmd.minTear	= 0.75;	vmd.maxTear	= 1.0;
			vmd.minWear	= 0.75;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=397;	vmd.fullPrestige= 426;
			vmd.stockQM = qm_stock_Shimutshibu_Focer_RC_200;	vmd.fullQM = qm_full_Shimutshibu_Focer_RC_200;
			vmd.vehicleName = "Chevrolet Camaro SS Vinyl Top '68";
			prevalence = vmd.prevalence;
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Cherry);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Smaragd);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Nacht);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Zucker);

		// Chevrolet Camaro RS Vinyl Top '68 //
			vmd=new VehicleModel( cars.racers.Focer:0x00002006r, VS_USED );
			vtdarr.addElement( vmd );
			vmd.prevalence = 1800.0;
			vmd.minPower	= 0.5;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 0.5;	vmd.maxOptical	= 1.5;
			vmd.minTear	= 0.75;	vmd.maxTear	= 1.0;
			vmd.minWear	= 0.75;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=475;	vmd.fullPrestige= 508;
			vmd.stockQM = qm_stock_Shimutshibu_Focer_RC_200;	vmd.fullQM = qm_full_Shimutshibu_Focer_RC_200;
			vmd.vehicleName = "Chevrolet Camaro RS Vinyl Top '68";
			prevalence = vmd.prevalence;
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Cherry);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Smaragd);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Nacht);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Zucker);

		// Chevrolet Camaro Vinyl Top '68 //
			vmd=new VehicleModel( cars.racers.Focer:0x00003006r, VS_USED );
			vtdarr.addElement( vmd );
			vmd.prevalence = 1900.0;
			vmd.minPower	= 0.5;	vmd.maxPower	= 1.0;
			vmd.minOptical	= 0.5;	vmd.maxOptical	= 1.0;
			vmd.minTear	= 0.75;	vmd.maxTear	= 0.9;
			vmd.minWear	= 0.75;	vmd.maxWear	= 0.75;
			vmd.stockPrestige=599;	vmd.fullPrestige= 632;
			vmd.stockQM = qm_stock_Shimutshibu_Focer_RC_200;	vmd.fullQM = qm_full_Shimutshibu_Focer_RC_200;
			vmd.vehicleName = "Chevrolet Camaro Vinyl Top '68";
			prevalence = vmd.prevalence;
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Cherry);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Smaragd);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Nacht);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Zucker);
			
		// Chevrolet Camaro SS '68 //
			vmd=new VehicleModel( cars.racers.Focer:0x00000107r, VS_USED );
			vtdarr.addElement( vmd );
			vmd.prevalence = 2000.0;
			vmd.minPower	= 0.5;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 0.35;	vmd.maxOptical	= 1.5;
			vmd.minTear	= 0.75;	vmd.maxTear	= 1.0;
			vmd.minWear	= 0.75;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=397;	vmd.fullPrestige= 426;
			vmd.stockQM = qm_stock_Shimutshibu_Focer_RC_300;	vmd.fullQM = qm_full_Shimutshibu_Focer_RC_300;
			vmd.vehicleName = "Chevrolet Camaro 396 '68";
			prevalence = vmd.prevalence;
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Cherry);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Smaragd);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Nacht);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Zucker);

		// Chevrolet Camaro RS '68 //
			vmd=new VehicleModel( cars.racers.Focer:0x00002107r, VS_USED );
			vtdarr.addElement( vmd );
			vmd.prevalence = 1800.0;
			vmd.minPower	= 0.5;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 0.35;	vmd.maxOptical	= 1.5;
			vmd.minTear	= 0.75;	vmd.maxTear	= 1.0;
			vmd.minWear	= 0.75;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=475;	vmd.fullPrestige= 508;
			vmd.stockQM = qm_stock_Shimutshibu_Focer_RC_300;	vmd.fullQM = qm_full_Shimutshibu_Focer_RC_300;
			vmd.vehicleName = "Chevrolet Camaro RS '68";
			prevalence = vmd.prevalence;
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Cherry);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Smaragd);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Nacht);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Zucker);

		// Chevrolet Camaro '68 //
			vmd=new VehicleModel( cars.racers.Focer:0x00003107r, VS_USED );
			vtdarr.addElement( vmd );
			vmd.prevalence = 2100.0;
			vmd.minPower	= 0.45;	vmd.maxPower	= 1.0;
			vmd.minOptical	= 0.4;	vmd.maxOptical	= 1.0;
			vmd.minTear	= 0.65;	vmd.maxTear	= 0.9;
			vmd.minWear	= 0.65;	vmd.maxWear	= 0.75;
			vmd.stockPrestige=599;	vmd.fullPrestige= 632;
			vmd.stockQM = qm_stock_Shimutshibu_Focer_RC_300;	vmd.fullQM = qm_full_Shimutshibu_Focer_RC_300;
			vmd.vehicleName = "Chevrolet Camaro '68";
			prevalence = vmd.prevalence;
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Cherry);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Smaragd);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Nacht);
			vmd.addColorIndex(GameLogic.RID_CARCOLOR_Used_Rusty_Zucker);

	// CAREER mode -> new car dealer //
		// Chevrolet Camaro SS Vinyl Top '68 //
			vmd=new VehicleModel( cars.racers.Focer:0x00000006r, VS_STOCK );
			vtdarr.addElement( vmd );
			vmd.prevalence = 1000.0;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 1.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=397;	vmd.fullPrestige= 426;
			vmd.stockQM = qm_stock_Shimutshibu_Focer_RC_200;	vmd.fullQM = qm_full_Shimutshibu_Focer_RC_200;
			vmd.vehicleName = "Chevrolet Camaro SS Vinyl Top '68";
			prevalence = vmd.prevalence;

		// Chevrolet Camaro RS Vinyl Top '68 //
			vmd=new VehicleModel( cars.racers.Focer:0x00002006r, VS_STOCK );
			vtdarr.addElement( vmd );
			vmd.prevalence = 1000.0;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 1.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=475;	vmd.fullPrestige= 508;
			vmd.stockQM = qm_stock_Shimutshibu_Focer_RC_200;	vmd.fullQM = qm_full_Shimutshibu_Focer_RC_200;
			vmd.vehicleName = "Chevrolet Camaro RS Vinyl Top '68";
			prevalence = vmd.prevalence;
			
		// Chevrolet Camaro Vinyl Top '68 //
			vmd=new VehicleModel( cars.racers.Focer:0x00003006r, VS_STOCK );
			vtdarr.addElement( vmd );
			vmd.prevalence = 1000.0;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 1.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=475;	vmd.fullPrestige= 508;
			vmd.stockQM = qm_stock_Shimutshibu_Focer_RC_200;	vmd.fullQM = qm_full_Shimutshibu_Focer_RC_200;
			vmd.vehicleName = "Chevrolet Camaro Vinyl Top '68";
			prevalence = vmd.prevalence;
		
		// Chevrolet Camaro SS '68 //
			vmd=new VehicleModel( cars.racers.Focer:0x00000107r, VS_STOCK );
			vtdarr.addElement( vmd );
			vmd.prevalence = 1000.0;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 1.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=397;	vmd.fullPrestige= 426;
			vmd.stockQM = qm_stock_Shimutshibu_Focer_RC_300;	vmd.fullQM = qm_full_Shimutshibu_Focer_RC_300;
			vmd.vehicleName = "Chevrolet Camaro SS '68";
			prevalence = vmd.prevalence;

		// Chevrolet Camaro RS '68 //
			vmd=new VehicleModel( cars.racers.Focer:0x00002107r, VS_STOCK );
			vtdarr.addElement( vmd );
			vmd.prevalence = 1000.0;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 1.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=475;	vmd.fullPrestige= 508;
			vmd.stockQM = qm_stock_Shimutshibu_Focer_RC_300;	vmd.fullQM = qm_full_Shimutshibu_Focer_RC_300;
			vmd.vehicleName = "Chevrolet Camaro RS '68";
			prevalence = vmd.prevalence;
			
		// Chevrolet Camaro '68 //
			vmd=new VehicleModel( cars.racers.Focer:0x00003107r, VS_STOCK );
			vtdarr.addElement( vmd );
			vmd.prevalence = 1000.0;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.0;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 1.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=475;	vmd.fullPrestige= 508;
			vmd.stockQM = qm_stock_Shimutshibu_Focer_RC_300;	vmd.fullQM = qm_full_Shimutshibu_Focer_RC_300;
			vmd.vehicleName = "Chevrolet Camaro '68";
			prevalence = vmd.prevalence;

	// CAREER mode -> races //
		// Chevrolet Camaro SS Vinyl Top '68 //
			vmd=new VehicleModel( cars.racers.Focer:0x00000006r, VS_DRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = 2100.0;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 1.5;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=397;	vmd.fullPrestige= 426;
			vmd.stockQM = qm_stock_Shimutshibu_Focer_RC_200;	vmd.fullQM = qm_full_Shimutshibu_Focer_RC_200;
			vmd.vehicleName = "Chevrolet Camaro SS Vinyl Top '68";
			prevalence = vmd.prevalence;

			vmd=new VehicleModel( cars.racers.Focer:0x00000006r, VS_NRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = 2000.0;
			vmd.minPower	= 1.45;	vmd.maxPower	= 1.9;
			vmd.minOptical	= 1.45;	vmd.maxOptical	= 1.9;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=397;	vmd.fullPrestige= 426;
			vmd.stockQM = qm_stock_Shimutshibu_Focer_RC_200;	vmd.fullQM = qm_full_Shimutshibu_Focer_RC_200;
			vmd.vehicleName = "Chevrolet Camaro SS Vinyl Top '68";
			prevalence = vmd.prevalence;

			vmd=new VehicleModel( cars.racers.Focer:0x00000006r, VS_RRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = 2000.0;
			vmd.minPower	= 1.45;	vmd.maxPower	= 1.9;
			vmd.minOptical	= 1.45;	vmd.maxOptical	= 1.9;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=397;	vmd.fullPrestige= 426;
			vmd.stockQM = qm_stock_Shimutshibu_Focer_RC_200;	vmd.fullQM = qm_full_Shimutshibu_Focer_RC_200;
			vmd.vehicleName = "Chevrolet Camaro SS Vinyl Top '68";
			prevalence = vmd.prevalence;
			
		// Chevrolet Camaro RS Vinyl Top '68 //
			vmd=new VehicleModel( cars.racers.Focer:0x00002006r, VS_DRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = 2000.0;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 1.5;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=475;	vmd.fullPrestige= 508;
			vmd.stockQM = qm_stock_Shimutshibu_Focer_RC_200;	vmd.fullQM = qm_full_Shimutshibu_Focer_RC_200;
			vmd.vehicleName = "Chevrolet Camaro RS Vinyl Top '68";
			prevalence = vmd.prevalence;

			vmd=new VehicleModel( cars.racers.Focer:0x00002006r, VS_NRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = 2000.0;
			vmd.minPower	= 1.5;	vmd.maxPower	= 2.0;
			vmd.minOptical	= 1.5;	vmd.maxOptical	= 2.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=475;	vmd.fullPrestige= 508;
			vmd.stockQM = qm_stock_Shimutshibu_Focer_RC_200;	vmd.fullQM = qm_full_Shimutshibu_Focer_RC_200;
			vmd.vehicleName = "Chevrolet Camaro RS Vinyl Top '68";
			prevalence = vmd.prevalence;
			
			vmd=new VehicleModel( cars.racers.Focer:0x00002006r, VS_RRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = 2000.0;
			vmd.minPower	= 1.5;	vmd.maxPower	= 2.0;
			vmd.minOptical	= 1.5;	vmd.maxOptical	= 2.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=475;	vmd.fullPrestige= 508;
			vmd.stockQM = qm_stock_Shimutshibu_Focer_RC_200;	vmd.fullQM = qm_full_Shimutshibu_Focer_RC_200;
			vmd.vehicleName = "Chevrolet Camaro RS Vinyl Top '68";
			prevalence = vmd.prevalence;

		// Chevrolet Camaro 350 Vinyl Top '68 //
			vmd=new VehicleModel( cars.racers.Focer:0x00003006r, VS_DRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = 2000.0;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.7;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 1.8;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=599;	vmd.fullPrestige= 632;
			vmd.stockQM = qm_stock_Shimutshibu_Focer_RC_200;	vmd.fullQM = qm_full_Shimutshibu_Focer_RC_200;
			vmd.vehicleName = "Chevrolet Camaro Vinyl Top '68";
			prevalence = vmd.prevalence;

			vmd=new VehicleModel( cars.racers.Focer:0x00003006r, VS_NRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = 2000.0;
			vmd.minPower	= 1.7;	vmd.maxPower	= 2.0;
			vmd.minOptical	= 1.5;	vmd.maxOptical	= 2.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=599;	vmd.fullPrestige= 632;
			vmd.stockQM = qm_stock_Shimutshibu_Focer_RC_200;	vmd.fullQM = qm_full_Shimutshibu_Focer_RC_200;
			vmd.vehicleName = "Chevrolet Camaro Vinyl Top '68";
			prevalence = vmd.prevalence;
			
			vmd=new VehicleModel( cars.racers.Focer:0x00003006r, VS_RRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = 2000.0;
			vmd.minPower	= 1.7;	vmd.maxPower	= 2.0;
			vmd.minOptical	= 1.5;	vmd.maxOptical	= 2.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=599;	vmd.fullPrestige= 632;
			vmd.stockQM = qm_stock_Shimutshibu_Focer_RC_200;	vmd.fullQM = qm_full_Shimutshibu_Focer_RC_200;
			vmd.vehicleName = "Chevrolet Camaro Vinyl Top '68";
			prevalence = vmd.prevalence;
			
		// Chevrolet Camaro SS '68 //
			vmd=new VehicleModel( cars.racers.Focer:0x00000107r, VS_DRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = 2000.0;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 1.5;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=397;	vmd.fullPrestige= 426;
			vmd.stockQM = qm_stock_Shimutshibu_Focer_RC_300;	vmd.fullQM = qm_full_Shimutshibu_Focer_RC_300;
			vmd.vehicleName = "Chevrolet Camaro SS '68";
			prevalence = vmd.prevalence;

			vmd=new VehicleModel( cars.racers.Focer:0x00000107r, VS_NRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = 2000.0;
			vmd.minPower	= 1.45;	vmd.maxPower	= 1.9;
			vmd.minOptical	= 1.45;	vmd.maxOptical	= 1.9;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=397;	vmd.fullPrestige= 426;
			vmd.stockQM = qm_stock_Shimutshibu_Focer_RC_300;	vmd.fullQM = qm_full_Shimutshibu_Focer_RC_300;
			vmd.vehicleName = "Chevrolet Camaro SS '68";
			prevalence = vmd.prevalence;

			vmd=new VehicleModel( cars.racers.Focer:0x00000107r, VS_RRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = 2000.0;
			vmd.minPower	= 1.45;	vmd.maxPower	= 1.9;
			vmd.minOptical	= 1.45;	vmd.maxOptical	= 1.9;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=397;	vmd.fullPrestige= 426;
			vmd.stockQM = qm_stock_Shimutshibu_Focer_RC_300;	vmd.fullQM = qm_full_Shimutshibu_Focer_RC_300;
			vmd.vehicleName = "Chevrolet Camaro SS '68";
			prevalence = vmd.prevalence;
			
		// Chevrolet Camaro RS '68 //
			vmd=new VehicleModel( cars.racers.Focer:0x00002107r, VS_DRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = 2000.0;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.5;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 1.5;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=475;	vmd.fullPrestige= 508;
			vmd.stockQM = qm_stock_Shimutshibu_Focer_RC_300;	vmd.fullQM = qm_full_Shimutshibu_Focer_RC_300;
			vmd.vehicleName = "Chevrolet Camaro RS '68";
			prevalence = vmd.prevalence;

			vmd=new VehicleModel( cars.racers.Focer:0x00002107r, VS_NRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = 2000.0;
			vmd.minPower	= 1.5;	vmd.maxPower	= 2.0;
			vmd.minOptical	= 1.5;	vmd.maxOptical	= 2.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=475;	vmd.fullPrestige= 508;
			vmd.stockQM = qm_stock_Shimutshibu_Focer_RC_300;	vmd.fullQM = qm_full_Shimutshibu_Focer_RC_300;
			vmd.vehicleName = "Chevrolet Camaro RS '68";
			prevalence = vmd.prevalence;
			
			vmd=new VehicleModel( cars.racers.Focer:0x00002107r, VS_RRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = 2000.0;
			vmd.minPower	= 1.5;	vmd.maxPower	= 2.0;
			vmd.minOptical	= 1.5;	vmd.maxOptical	= 2.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=475;	vmd.fullPrestige= 508;
			vmd.stockQM = qm_stock_Shimutshibu_Focer_RC_300;	vmd.fullQM = qm_full_Shimutshibu_Focer_RC_300;
			vmd.vehicleName = "Chevrolet Camaro RS '68";
			prevalence = vmd.prevalence;

		// Chevrolet Camaro '68 //
			vmd=new VehicleModel( cars.racers.Focer:0x00003107r, VS_DRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = 2000.0;
			vmd.minPower	= 1.0;	vmd.maxPower	= 1.7;
			vmd.minOptical	= 1.0;	vmd.maxOptical	= 1.8;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=599;	vmd.fullPrestige= 632;
			vmd.stockQM = qm_stock_Shimutshibu_Focer_RC_300;	vmd.fullQM = qm_full_Shimutshibu_Focer_RC_300;
			vmd.vehicleName = "Chevrolet Camaro '68";
			prevalence = vmd.prevalence;

			vmd=new VehicleModel( cars.racers.Focer:0x00003107r, VS_NRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = 2000.0;
			vmd.minPower	= 1.7;	vmd.maxPower	= 2.0;
			vmd.minOptical	= 1.5;	vmd.maxOptical	= 2.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=599;	vmd.fullPrestige= 632;
			vmd.stockQM = qm_stock_Shimutshibu_Focer_RC_300;	vmd.fullQM = qm_full_Shimutshibu_Focer_RC_300;
			vmd.vehicleName = "Chevrolet Camaro '68";
			prevalence = vmd.prevalence;
			
			vmd=new VehicleModel( cars.racers.Focer:0x00003107r, VS_RRACE );
			vtdarr.addElement( vmd );
			vmd.prevalence = 2000.0;
			vmd.minPower	= 1.7;	vmd.maxPower	= 2.0;
			vmd.minOptical	= 1.5;	vmd.maxOptical	= 2.0;
			vmd.minTear	= 1.0;	vmd.maxTear	= 1.0;
			vmd.minWear	= 1.0;	vmd.maxWear	= 1.0;
			vmd.stockPrestige=599;	vmd.fullPrestige= 632;
			vmd.stockQM = qm_stock_Shimutshibu_Focer_RC_300;	vmd.fullQM = qm_full_Shimutshibu_Focer_RC_300;
			vmd.vehicleName = "Chevrolet Camaro '68";
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
