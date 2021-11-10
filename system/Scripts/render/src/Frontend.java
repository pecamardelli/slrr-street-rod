package java.render;

import java.render.osd.*;
import java.io.*;
import java.util.*;
import java.util.resource.*;

public class Frontend
{
	static ResourceRef defLoadingPic = new ResourceRef(frontend:0x00A8r);

	//global sfx
	final public static int SFX_MONEY		= frontend:0x009Br;
	final public static int SFX_QUESTION	= frontend:0x007Er;
	final public static int SFX_OK			= frontend:0x0080r;
	final public static int SFX_WARNING		= frontend:0x0081r;
	final public static int SFX_CAMERA		=   MW_Mod:0x0177r;

	final public static int SFX_MENU_MOVE	= frontend:0x0079r;
	final public static int SFX_MENU_BACK	= frontend:0x0078r;
	final public static int SFX_MENU_SELECT	= frontend:0x007Ar;

	// fonts
	public static ResourceRef       largeFont;
	public static ResourceRef       mediumFont;
	public static ResourceRef       smallFont;

	public static ResourceRef       pointers;

	//input queueing for osd's:
	static	Vector	inputQueue = new Vector();
	//

	//ide kellene tenni a jatek default viewportjat is!

	public static LoadingScreen		loadingScreen;

	static Thread hotkeyWatcherThread;

	static	GfxEngine	render;

	public static void init()
	{
		render = new GfxEngine();	//itt kellene inditani a render engine-t.....

		setFonts();

		loadingScreen = new LoadingScreen();

		hotkeyWatcherThread = new Thread( new HotkeyWatcher(), "Hotkey watcher" );
		hotkeyWatcherThread.start();
	}

	public static void destroy()
	{
		hotkeyWatcherThread.stop();
	}

	public static void setDefLoadingPic( ResourceRef pic )
	{
		defLoadingPic = pic;
	}

	public static void setFonts()
	{
		pointers = new ResourceRef( Text.RID_SYM_POINTERS );

		if( Config.video_y >= 1024 || Config.video_y >= 768 )
		{
			largeFont  = new ResourceRef( Text.RID_SLII24 );
			mediumFont = new ResourceRef( Text.RID_SLII24 );	//check carinfo!
			smallFont  = new ResourceRef( Text.RID_SLII17 );
		}
		else
		if( Config.video_x >= 800 || Config.video_y >= 600  )
		{
			largeFont  = new ResourceRef( Text.RID_SLII24 );
			mediumFont = new ResourceRef( Text.RID_SLII17 );
			smallFont  = new ResourceRef( Text.RID_SLII11 );
		}
		else
		if( Config.video_x >= 640 || Config.video_y >= 480  )
		{
			largeFont  = new ResourceRef( Text.RID_SLII17 );
			mediumFont = new ResourceRef( Text.RID_SLII11 );
			smallFont  = new ResourceRef( Text.RID_CONSOLE5 );	//check catalogus
		}
		else
		if( Config.video_y >= 320 || Config.video_y >= 240 )
		{
			largeFont  = new ResourceRef( Text.RID_CONSOLE10 );
			mediumFont = new ResourceRef( Text.RID_CONSOLE10 );
			smallFont  = new ResourceRef( Text.RID_CONSOLE5 );
		}
		else
		{
			largeFont  = new ResourceRef( Text.RID_CONSOLE5 );
			mediumFont = new ResourceRef( Text.RID_CONSOLE5 );
			smallFont  = new ResourceRef( Text.RID_CONSOLE5 );
		}
	}

	//call this when display mode changed
	public static void rebuild()
	{
		setFonts();

		for( int i=0; i<inputQueue.size(); i++ )
			inputQueue.elementAt( i ).rebuild();
	}
}

public class HotkeyWatcher implements Runnable
{
	public void run()
	{
		while(1)
		{
			Thread.sleep( 50 ); //theoretical 20 fps
	
			Osd focusedOsd = Frontend.inputQueue.lastElement();
			if( focusedOsd && Input.cursor && Input.cursor.controller )
				Input.checkHotkeys( Input.cursor.controller, focusedOsd );
		}
	}
}
