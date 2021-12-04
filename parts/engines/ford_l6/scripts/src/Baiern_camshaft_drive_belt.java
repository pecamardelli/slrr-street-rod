package java.game.parts.engines.ford_l6;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;

public class Baiern_camshaft_drive_belt extends Part
{
	public Baiern_camshaft_drive_belt( int id )
	{
		super( id );
		name = "Baiern camshaft drive belt";
		description = "A cheap but much more important part of the engine. Change it when needed to avoid the jumbling of the valves in the cylinder head. This belt costs only a few bucks and is quick and easy to change. Change it evey 14000-16000 kms (8750-10000 miles) instead of repairing the whole cilynder head for hard thousands.";

		value = tHUF2USD(3.5);
		brand_new_prestige_value = 25.55;
		setMaxWear(kmToMaxWear(18000.0));

		check4warnings();
	}
}
