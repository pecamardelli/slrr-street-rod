package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.camshaft.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.cylinderhead.*;
import java.game.cars.*;


public class Emer_MotorSport_GT2_cylinder_head extends DOHC_CylinderHead
{
	public Emer_MotorSport_GT2_cylinder_head( int id )
	{
		super( id );
		name = "Emer MotorSport GT2 cylinder head";
		description = "This head uses 2+2 valves for each 6 cylinders supported with long and strong titanium valve springs to let you choose valve lifts up to 25.4 mm (1.0 inch)! The combustion chamber has a 20.7 mm (0.82 inch) high dome. The valve head diameters are 32.0 mm (1.26 inch) on the intake side and 29.0 mm (1.14 inch) on the exhaust side. Stage II involves port optimization and polishing on both sides, stronger valve springs and lightweight reciprocating components.";

		value = tHUF2USD(6*45+290);
		brand_new_prestige_value = 80.02;
		setMaxWear(kmToMaxWear(411000.0));

		intake_manifold_slot_ID = 11;
		exhaust_header_slot_ID = 13;
		camshaft_bearing_slot_ID = 24;
		cover_slot_ID = 18;

		exhaust_camshaft_slot_ID = 4;
		intake_camshaft_slot_ID = 5;

		intake_efficiency_tuning = 1.250;
		exhaust_efficiency_tuning = 1.250;

		intake_valve_diam = 35.0;
		number_of_intake_valves_per_cylinder = 2.0;
		exhaust_valve_diam = 32.0;
		number_of_exhaust_valves_per_cylinder = 2.0;

		cc_dome_safe_clearance = 18.7;
		maxRPM = 20000.0;
		inertia = kgToInertia(6*0.25);

		T_loss = 80.0;
		Vmin = 81.27; // in cc //

		check4warnings();
	}

	public void addStockParts( Descriptor desc )
	{
		super.addStockParts( desc );

		getCar_LocalVersion();

		if (the_car.make == the_car.MAKE_EMER)
		{
			if (the_car.model == Emer_models.MODEL_MOTORSPORT_NONUS_GT2)
			{
				DOHC_Camshaft ec = addPart( parts.engines.ford_l6:0x000000E0r, "Emer_GT2_exhaust_camshaft", desc );
				DOHC_Camshaft ic = addPart( parts.engines.ford_l6:0x000000E1r, "Emer_GT2_intake_camshaft", desc );
				if (desc.power > 1.1)
				{
					if (desc.power < 1.3)
					{
						ec.advance = (desc.power-1.1)/0.2*(-15.0);
						ic.advance = (desc.power-1.1)/0.2*( 15.0);
					}
					else
					{
						ec.advance = -15.0;
						ic.advance =  15.0;
					}
				}
				addPart( parts.engines.ford_l6:0x0000008Br, "Emer_camshaft_bearing_bridge", desc );
				addPart( parts.engines.ford_l6:0x0000008Er, "Emer_MotorSport_GT2_cylinder_head_cover", desc );
				addPart( parts.engines.ford_l6:0x00000088r, "Emer_camshaft_drive_belt", desc );
				addPart( parts.engines.ford_l6:0x00000092r, "Emer_MotorSport_GT2_intake_manifold", desc );
				addPart( parts.engines.ford_l6:0x0000008Dr, "Emer_MotorSport_GT2_exhaust_header", desc );
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
