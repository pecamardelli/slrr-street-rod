package java.render;

import java.io.*;
import java.util.*;
import java.util.resource.*;


public class GfxEngine
{
	static int psLastFreeIndex=100;

	public static native void forceRendering();
	public static native void setGlobalEnvmap( ResourceRef texture );
	public static native int numDisplayModes();
	public static native int currDisplayMode();
	public static native String displayModeName( int i );
	public static native void changeVideoMode( int width, int height, int depth );
	public static native void printScreen( String filename );
	public static native void flush();

	public static native int openVideo( String filename, int non_exclusive, int loop );
	public static native void closeVideo();
	public static native int isPlayingVideo();

	public static void playVideo( String videofile )
	{
		float timewarp = System.timeWarp(0.0);
		int	prevPointerState = Input.cursor.enable(0);
		MessagePort mp = new MessagePort();
		Osd o = new Osd(1.0, 0.0, 128);
		o.iLevel = Osd.IL_KEYS;
		o.show();
		o.alienMp = mp;
		o.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, 0, null );
		o.createHotkey( Input.AXIS_SELECT, Input.VIRTUAL, 0, null );

		if( (GfxEngine.openVideo( videofile, 0, 0 )==0) )
		{
			while( GfxEngine.isPlayingVideo() && !mp.getMessage() )
			{
				Thread.sleep( 100 );
			}

			GfxEngine.closeVideo();
		}

		o.hide();
		Input.cursor.enable(prevPointerState);
		System.timeWarp(timewarp);
	}

	public static void printScreenIndexed( String filename )
	{
		String indexedName;
		while( 1 )
		{
			indexedName = filename+psLastFreeIndex+".tga";
			psLastFreeIndex++;
			if( !File.exists( indexedName ) )
			{
				printScreen( indexedName );
				break;
			}
		}
	}

}