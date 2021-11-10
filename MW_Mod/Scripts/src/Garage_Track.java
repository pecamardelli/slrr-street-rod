package java.game;

import java.io.*;
import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.render.*;	//Text
import java.render.osd.*;	//Text
import java.sound.*;
import java.render.osd.dialog.*; //Dialog Window

import java.game.parts.*;
import java.game.parts.enginepart.*;

public class Garage_Track extends Track
{
	final static String MapName = "Garage";
	final static String MapDescription = "\n It is default game's Garage \n \n You can use this map to take some sweet garage screenshots.";
	final static String MapAuthor = "Author: Mike Shinoda";
	final static ResourceRef MapImage = new ResourceRef(MW_Mod:0x0110r);
	final static float	TS_Version = 1.0;

	int[]	garageID, garageStuffID;
	ResourceRef	[]	garageEnvMaps;
	int garageIndex = 0;
	RenderRef stuff;

	public Garage_Track()
	{
		posStart = new Vector3( 0.000, 0.000, 0.000 ); // Start car position
		oriStart = new Ypr( 0.000, 0.000, 0.000 ); // Start car rotation

		//map = new GroundRef( misc.garage:0x0000007Ar );
		//map = new GroundRef( misc.garage:0x00000006r );
		//map = new GroundRef( misc.garage:0x000000C7r );

		garageID = new int[GameLogic.CLUBS]; garageStuffID = new int[GameLogic.CLUBS];
		garageID[0] = Garage.RID_GARAGE1; garageStuffID[0] = Garage.RID_GARAGE1_STUFF;
		garageID[1] = Garage.RID_GARAGE2; garageStuffID[1] = Garage.RID_GARAGE2_STUFF;
		garageID[2] = Garage.RID_GARAGE3; garageStuffID[2] = Garage.RID_GARAGE3_STUFF;

		garageEnvMaps = new ResourceRef[GameLogic.CLUBS];
		garageEnvMaps[0] = new ResourceRef( maps.skydome:0x0036r );
		garageEnvMaps[1] = new ResourceRef( maps.skydome:0x0037r );
		garageEnvMaps[2] = new ResourceRef( maps.skydome:0x0038r );

		if( GameLogic.player )
		{
			garageIndex = GameLogic.player.club;
		}

		map = new GroundRef( garageID[garageIndex] );
		stuff = new RenderRef( map, garageStuffID[garageIndex], null );
	}

	public void StartMap()
	{
		GameLogic.changeActiveSection( new Garage_Track() );
	}

	public void enter( GameState prev_state )
	{
		GfxEngine.setGlobalEnvmap( garageEnvMaps[garageIndex] );

		Frontend.loadingScreen.show();
		GfxEngine.flush();
		super.enter( prev_state );
	}

	public void exit( GameState next_state )
	{
		stuff.destroy();

		super.exit( next_state );
	}
}
