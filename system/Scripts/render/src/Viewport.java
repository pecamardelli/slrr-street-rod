package java.render;

import java.io.*;
import java.util.*;
import java.util.resource.*;

public class Viewport extends ResourceRef
{
	//finals mirrored from "resource.h"
	final static int RENDERFLAG_CLEARDEPTH = 0x00000001;
	final static int RENDERFLAG_CLEARTARGET	= 0x00000002;

	public Viewport(){ super(); }
	public Viewport( int pri, float x, float y, float w, float h ){ super(); create( pri, x, y, w, h ); }

	//adott aspectu viewportot keszit
	//(x,y)  a vp bal felso sarka a globalis [0;1] koordinatarendszerben
	//(dx,dy) eltolas a viewport koordianarendszereben (egyseg a viewport szelessege, magassaga)
	//ezaltal tetszolegesen lehet alignolni a viewportot
	//size=1.0-nal a viewport legalabb 1 tengely menten erinti a kepernyo szelet
	public Viewport( int pri, float x, float y, float size, float aspect, float dx, float dy )
	{ 
		super(); 
		
		float screenAspect = Config.video_x/(1.0*Config.video_y);
		float iksz, ipszilon;

		if( aspect == 0.0 )
		{
			iksz=ipszilon=1.0;
		}
		else
		if( aspect >= screenAspect ) //szelesvasznu
		{
			iksz=1.0;
			ipszilon=screenAspect/aspect;
		}
		else
		if( aspect < screenAspect ) //magas+keskeny
		{
			iksz=aspect/screenAspect;
			ipszilon=1.0;
		}

		iksz*=size;
		ipszilon*=size;

		dx*=iksz;
		dy*=ipszilon;

		create( pri, x+dx, y+dy, iksz, ipszilon ); 
	}

	public void finalize()
	{
		destroy();
		super.finalize();
	}

	public native void create( int pri, float x, float y, float w, float h );
	public native void destroy();

	public void activate(){ activate( RENDERFLAG_CLEARDEPTH ); }  
	public native void activate( int renderflags );
	public native void deactivate();

	//return physical aspect ratio
	public native float getAspect();

	//return dimensions relative to screen size
	public native float getWidth();
	public native float getHeight();
	public native float getTop();
	public native float getLeft();
	public native void resize( float x, float y, float w, float h );

	public native Vector3 unproject( Vector3 v, int cameraId );
}
