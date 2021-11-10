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

public class ValoCity_Track extends Track
{	
	final static String MapName = "Valo City";
	final static String MapDescription = "\n Welcome to ValoCity! \n \n There you can race with opponents from your club or take a part in 1/4 mile drag races.";
	final static String MapAuthor = "Author: Invictus";
	final static ResourceRef MapImage = new ResourceRef(MW_Mod:0x0053r);
	final static float	TS_Version = 1.0;

	//public ValoCity_Track()

	public void StartMap()
	{
		GameLogic.changeActiveSection( new Valocity() );
		Frontend.loadingScreen.show();
	}
}