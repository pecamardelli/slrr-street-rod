package java.game;

import java.io.*;
import java.util.*;
import java.util.resource.*;
import java.lang.*;

// New painter by Harrison15 and Bigg Boss93
// Special thanks to Prof. Nan C. Schaller of Rochester University
// for HSV <-> RGB conversion example
// http://www.cs.rit.edu/~ncs/color/t_convert.html

// RGB colors are [0,255]
// h = [0,360], s = [0,100], v = [0,100]
// h is automatically reset to 0 if saturation = 0

public class PainterExtensions
{
	private PainterExtensions()
	{
	}

	//hsvOut[0] = hue, hsvOut[1] = saturation, hsvOut[2] = value
	public static int[] rgb2hsv( int r, int g, int b )
	{
		int[] hsvOut = new int[3];
		float min, max, delta, hue;
		
		if( r >= g && r >= b )
			max = r;
		else if( g >= r && g >= b )
			max = g;
		else if( b >= r && b >= g )
			max = b;
		
		if( r <= g && r <= b )
			min = r;
		else if( g <= r && g <= b )
			min = g;
		else if( b <= r && b <= g )
			min = b;
		
		hsvOut[2] = max*100/255;
		
		delta = max-min;
		
		if( delta != 0 )
		{
			hsvOut[1] = delta*100/max;
		}
		else // r = g = b = 0, so greyscale
		{
			hsvOut[1] = 0;
			hsvOut[0] = 0;
			return hsvOut;
		}
		
		if ( r == max ) // red region -yellow to magenta
		{
			hue = g-b;
			hue = (hue/delta);
		}
		else
		if ( g == max ) // green region - cyan to yellow
		{
			hue = b-r;
			hue = 2+(hue/delta);
		}
		else
		if ( b == max ) // blue region - magenta to cyan
		{
			hue = r-g;
			hue = 4+(hue/delta);
		}
		
		hsvOut[0] = hue*60;
		if ( hsvOut[0] < 0 )
			hsvOut[0] += 360;
		if ( hsvOut[0] > 360 )
			hsvOut[0] -= 360;
		return hsvOut;
	}
	
	public static int[] hsv2rgb( float h, float s, float v )	
	{
		float r,g,b;
		int[] rgbOut = new int[3];
		int i;
		
		float hInt;
		float f, x, y, z;
		float hprime = h/60;
		
		i = newfloor( hprime );
		
		f = h-(i*60);
		x = (v/100) * ( 1-s/100 );
		y = (v/100) * ( 1-(s/100)*(f/60) );
		z = (v/100) * ( 1-(s/100)*(1-(f/60)) );
		
		if( h == 360 )
			i = 0;
		
		switch( i )
		{
		case 0:
			r = v/100;
			g = z;
			b = x;
			break;
		case 1:
			r = y;
			g = v/100;
			b = x;
			break;
		case 2:
			r = x;
			g = v/100;
			b = z;
			break;
		case 3:
			r = x;
			g = y;
			b = v/100;
			break;
		case 4:
			r = z;
			g = x;
			b = v/100;
			break;
		default:		// case 5:
			r = v/100;
			g = x;
			b = y;
			break;
		}
		
		rgbOut[0] = newround(r*255);
		rgbOut[1] = newround(g*255);
		rgbOut[2] = newround(b*255);
		
		return rgbOut;
	}

	//The following sequence of operations has to be substituted for
	// some of java.lang.Math, because SLRR is dumb and doesn't have
	// large parts of it.
	
	public static int newround( float f )
	{
		return f;
	}
	
	
	public static int newfloor( float f )
	{
		float fInt;
		fInt = newround( f );
		if( fInt > f )
			return fInt-1;
		return fInt;
	}
}