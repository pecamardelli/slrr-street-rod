package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;


public class kit_GT_III_body extends Set
{
	public kit_GT_III_body( int id )
	{
		super( id );
		name = "Baiern CoupeSport GT III body kit";
		description = "";
	}

	public void build( Inventory inv )
	{
		inv.insertItem( cars.racers.FOR_Coupe_40:0x00000124r ); // FL quarterpanel 2
		inv.insertItem( cars.racers.FOR_Coupe_40:0x0000012Br ); // FR quarterpanel 2
		inv.insertItem( cars.racers.FOR_Coupe_40:0x00000123r ); // RL quarterpanel 2
		inv.insertItem( cars.racers.FOR_Coupe_40:0x00000129r ); // RR quarterpanel 2

		inv.insertItem( cars.racers.FOR_Coupe_40:0x00000122r ); // L sideskirt 2
		inv.insertItem( cars.racers.FOR_Coupe_40:0x00000127r ); // R sideskirt 2

		inv.insertItem( cars.racers.FOR_Coupe_40:0x00000120r ); // F bumper 3
		inv.insertItem( cars.racers.FOR_Coupe_40:0x0000011Fr ); // R bumper 3

		inv.insertItem( cars.racers.FOR_Coupe_40:0x0000011Cr ); // hood 2

		inv.insertItem( cars.racers.FOR_Coupe_40:0x00000121r ); // FL door 2
		inv.insertItem( cars.racers.FOR_Coupe_40:0x0000012Ar ); // FR door 2
	}
}
