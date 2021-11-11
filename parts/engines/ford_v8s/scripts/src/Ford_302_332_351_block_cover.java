package java.game.parts.engines.ford_v8s;

import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.*;
import java.game.cars.*;


public class Ford_302_332_351_block_cover extends EnginePart
{
	public Ford_302_332_351_block_cover( int id )
	{
		super( id );
		name = "Ford 302/332/351 V8 block cover";
		description = "";
		brand_new_prestige_value = 28.00;

		value = tHUF2USD(18);
		setMaxWear(kmToMaxWear(211000.0));

		check4warnings();
	}


}