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

public class AirCooler extends AdjustableEnginePart
{
	public AirCooler(){}

	public AirCooler( int id )
	{
		super( id );

		name = "Air coolers";
	}
}

