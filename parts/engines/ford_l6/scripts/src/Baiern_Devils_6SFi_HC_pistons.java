package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.*;

public class Baiern_Devils_6SFi_HC_pistons extends Piston
{
	public Baiern_Devils_6SFi_HC_pistons( int id )
	{
		super( id );
		name = "Baiern Devils 6SFi 3.6 pistons";
		description = "A set of 6 pistons only for the 93.0 mm (3.66 inch) bored Baiern Devils 6SFi 3.6 block and Baiern Devils cylinder heads. \n This piston set gives a 10.9:1 compression ratio in stock form. \n There should be enough room in the head for the +17.1 mm (+0.67 inch) high piston crowns. Each of the pistons weigh only 450 grams (15.9 ounces), so the peak RPM of the crankshaft may reach 9000 if supported with similarly light and strong connecting rods. Not recommended for forced induction due to the very high static compression ratios with factory connecting rods.";

		value = tHUF2USD(6*23);
		brand_new_prestige_value = 76.64;
		setMaxWear(kmToMaxWear(218000.0));

		bore = 93.0;
		length_from_wrist_pin_center_to_crown_base = 37.56;
		crown_height = 19.85;
		crown_volume = 70.56;
		length_from_lowest_safe_belt_to_crown_base = 24.14;

		maxRPM = 10000.0;
		inertia = kgToInertia(6*0.450);

		check4warnings();
	}
}
