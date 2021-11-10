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

public class Neon extends AdjustableBodyPart
{
	public Neon( int id )
	{
		super( id );

		name = "Neon";

		prestige_calc_weight = 0.1;
		drag_reduction = 0.005;

		catalog_view_ypr = new Ypr( 0.0, -0.7, 0.0 );
	}
}

