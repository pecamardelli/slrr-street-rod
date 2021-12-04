package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.cylinderhead.*;
import java.game.cars.*;


public class Baiern_Devils_6SFi_cylinder_head extends DOHC_CylinderHead
{
	public Baiern_Devils_6SFi_cylinder_head( int id )
	{
		super( id );
		name = "Baiern Devils 6SFi cylinder head";
		description = "This head uses 2+2 valves for each 6 cylinders supported with long and strong titanium valve springs to let you choose valve lifts up to 25.4 mm (1.0 inch)! The combustion chamber has a 20.7 mm (0.82 inch) high dome. The valve head diameters are 32.0 mm (1.26 inch) on the intake side and 29.0 mm (1.14 inch) on the exhaust side. Stage II involves port optimization and polishing on both sides, stronger valve springs and lightweight reciprocating components.";

		value = tHUF2USD(6*45+290);
		brand_new_prestige_value = 38.32;
		setMaxWear(kmToMaxWear(411000.0));

		intake_manifold_slot_ID = 11;
		exhaust_header_slot_ID = 13;
		camshaft_bearing_slot_ID = 24;
		cover_slot_ID = 18;

		exhaust_camshaft_slot_ID = 4;
		intake_camshaft_slot_ID = 5;

		intake_efficiency_tuning = 1.25;
		exhaust_efficiency_tuning = 1.25;

		intake_valve_diam = 33.0;
		number_of_intake_valves_per_cylinder = 2.0;
		exhaust_valve_diam = 30.5;
		number_of_exhaust_valves_per_cylinder = 2.0;

		cc_dome_safe_clearance = 18.7;
		inertia = kgToInertia(6*0.25);

		T_loss = 80.0;
		Vmin = 81.27; // in cc //

		check4warnings();
	}

	public void addStockParts( Descriptor desc )
	{
		super.addStockParts( desc );

		getCar_LocalVersion();

		if (the_car.make == the_car.MAKE_BAIERN)
		{
			if (the_car.model == Baiern_models.MODEL_COUPESPORT_GT_III)
			{
				addPart( parts.engines.ford_l6:0x00000099r, "Baiern_GT_III_exhaust_camshaft", desc );
				addPart( parts.engines.ford_l6:0x0000009Ar, "Baiern_GT_III_intake_camshaft", desc );
				addPart( parts.engines.ford_l6:0x00000058r, "Baiern_camshaft_bearing_bridge", desc );
				addPart( parts.engines.ford_l6:0x000000BBr, "Baiern_GT_III_cylinder_head_cover", desc );
				addPart( parts.engines.ford_l6:0x00000047r, "Baiern_camshaft_drive_belt", desc );
				addPart( parts.engines.ford_l6:0x00000097r, "Baiern_GT_III_intake_manifold", desc );
				addPart( parts.engines.ford_l6:0x00000098r, "Baiern_GT_III_exhaust_header", desc );
			}
			else
			if (the_car.model == Baiern_models.MODEL_DEVILSPORT)
			{
				addPart( parts.engines.ford_l6:0x00000059r, "Baiern_Kraftwerk_2_5_exhaust_camshaft", desc );
				addPart( parts.engines.ford_l6:0x0000005Ar, "Baiern_Kraftwerk_2_5_intake_camshaft", desc );
				addPart( parts.engines.ford_l6:0x00000058r, "Baiern_camshaft_bearing_bridge", desc );
				addPart( parts.engines.ford_l6:0x0000009Br, "Baiern_Devils_6SFi_cylinder_head_cover", desc );
				addPart( parts.engines.ford_l6:0x00000047r, "Baiern_camshaft_drive_belt", desc );
				addPart( parts.engines.ford_l6:0x0000004Ar, "Baiern_Kraftwerk_2_5_intake_manifold", desc );
				addPart( parts.engines.ford_l6:0x0000004Cr, "Baiern_Kraftwerk_2_5_exhaust_header", desc );
			}
			else
			if (the_car.model == Baiern_models.MODEL_DEVILSPORT_TURBO)
			{
				addPart( parts.engines.ford_l6:0x00000059r, "Baiern_Kraftwerk_2_5_exhaust_camshaft", desc );
				addPart( parts.engines.ford_l6:0x0000005Ar, "Baiern_Kraftwerk_2_5_intake_camshaft", desc );
				addPart( parts.engines.ford_l6:0x00000058r, "Baiern_camshaft_bearing_bridge", desc );
				addPart( parts.engines.ford_l6:0x000000B7r, "Baiern_Devils_Turbo_6SFi_cylinder_head_cover", desc );
				addPart( parts.engines.ford_l6:0x00000047r, "Baiern_camshaft_drive_belt", desc );
				addPart( parts.engines.ford_l6:0x0000004Ar, "Baiern_Kraftwerk_2_5_intake_manifold", desc );
				addPart( parts.engines.ford_l6:0x0000007Cr, "Baiern_Devils_Turbo_exhaust_header", desc );
			}
			else
			if (the_car.model == Baiern_models.MODEL_DEVILSPORT_BITURBO)
			{
				addPart( parts.engines.ford_l6:0x00000059r, "Baiern_Kraftwerk_2_5_exhaust_camshaft", desc );
				addPart( parts.engines.ford_l6:0x0000005Ar, "Baiern_Kraftwerk_2_5_intake_camshaft", desc );
				addPart( parts.engines.ford_l6:0x00000058r, "Baiern_camshaft_bearing_bridge", desc );
				addPart( parts.engines.ford_l6:0x000000BAr, "Baiern_Devils_BiTurbo_6SFi_cylinder_head_cover", desc );
				addPart( parts.engines.ford_l6:0x00000047r, "Baiern_camshaft_drive_belt", desc );
				addPart( parts.engines.ford_l6:0x0000004Ar, "Baiern_Kraftwerk_2_5_intake_manifold", desc );
				addPart( parts.engines.ford_l6:0x0000007Ar, "Baiern_Devils_BiTurbo_exhaust_header", desc );
			}
		}
	}

	public String isDynoable()
	{
		Part p;

		p = partOnSlot( 22 );
		if (!p)
			return "the engine is missing the camshaft drive belt.";

		return super.isDynoable();
	}
}
