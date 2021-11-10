package java.game.parts.bodypart;

import java.io.*;
import java.util.*;
import java.util.resource.*;
import java.render.osd.*;
import java.game.*;
import java.game.cars.*;
import java.game.parts.*;
import java.game.parts.enginepart.*;
import java.game.parts.rgearpart.*;
import java.game.parts.rgearpart.reciprocatingrgearpart.*;

public class Wing extends AdjustableBodyPart
{
	public Wing( int id )
	{
		super( id );

		name = "Wing";

		prestige_calc_weight = 25.0;

		catalog_view_ypr = new Ypr( 3.142+0.25, -0.7, 0.0 );
		drag_reduction = 0.035;
	}
}

