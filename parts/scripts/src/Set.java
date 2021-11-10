package java.game.parts;

import java.io.*;
import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.cars.*;
import java.game.parts.bodypart.*;

public class Set extends GameType
{
	String	name;
	String	description;
	int		logo;

	public void save( File saveGame )
	{
		saveGame.write( name );
		saveGame.write( description );
	}

	public static Set createFromFile( File saveGame )
	{
		Set result = new Set();

		result.name = saveGame.readString();
		result.description = saveGame.readString();

		return result;
	}
}

