package java.game.cars;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;


public class kit_Racing_SunStrip_body extends Set
{
	public kit_Racing_SunStrip_body( int id )
	{
		super( id );
		name = "Duhen Racing SunStrip 2.0 CDVC body kit";
		description = "";
	}

	public void build( Inventory inv )
	{
		inv.insertItem( cars.racers.duhen:0x000000DEr ); // FL quarterpanel 2
		inv.insertItem( cars.racers.duhen:0x000000E0r ); // FR quarterpanel 2
		inv.insertItem( cars.racers.duhen:0x000000DDr ); // RL quarterpanel 2
		inv.insertItem( cars.racers.duhen:0x000000E2r ); // RR quarterpanel 2

		inv.insertItem( cars.racers.duhen:0x000000DCr ); // L sideskirt 2
		inv.insertItem( cars.racers.duhen:0x000000E1r ); // R sideskirt 2

		inv.insertItem( cars.racers.duhen:0x000000DFr ); // F bumper 2
		inv.insertItem( cars.racers.duhen:0x000000DBr ); // R bumper 2

		inv.insertItem( cars.racers.duhen:0x000000D9r ); // hood 2
	}
}
