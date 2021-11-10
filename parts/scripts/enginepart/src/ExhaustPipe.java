package java.game.parts.enginepart;

import java.render.osd.*;
import java.io.*;
import java.util.*;
import java.util.resource.*;
import java.game.cars.*;
import java.game.parts.*;
import java.game.parts.bodypart.*;
import java.game.parts.enginepart.*;
import java.game.parts.rgearpart.*;

public class ExhaustPipe extends AdjustableEnginePart
{
	float	efficiency = 1.0;
	Vector	mufflerSlotIDList = null;

	public ExhaustPipe(){}

	public ExhaustPipe( int id )
	{
		super( id );

		name = "Exhaust pipe";

		prestige_calc_weight = 22.5;
	}
}
