package java.render.osd;

import java.render.*;
import java.io.*;
import java.util.*;
import java.util.resource.*;

public class Gadget
{
	final static ResourceRef	HIGHLIGHT_NORMAL	= new ResourceRef(frontend:0x012Br);
	final static ResourceRef	HIGHLIGHT_DISABLED	= new ResourceRef(frontend:0x013Cr);
	final static float			HIGHLIGHT_NORMAL_SCALE		= 1.0;
	final static float			HIGHLIGHT_DISABLED_SCALE	= 1.1;
	final static float			HIGHLIGHT_ACTIVE_SCALE		= 1.2;
	
	Osd		osd;
	PhysicsRef phy;	//a fizikai (es input objektum)
	Rectangle rect; //latvany objektum

	//float	x, y, w, h;
	//int		pri;

	Label	label;

	int		cmd;
	Object	handler;
	String	tooltip;
	int		disabled;
	int		pressed;
	int		dropEnabled;

	int		noleaverelease;	//leave-re nem kuld release-t!
	int		nofocus;

	int		highliteMethod = Osd.HL_LABELCOLOR;
	Rectangle	hr;

	//for the button->slider contact so far
	Gadget parent;


	public Gadget( Osd o, PhysicsRef p, Rectangle r, int c, Object h )
	{
		osd = o;
		phy = p;
		rect = r;
		cmd = c;
		handler = h;
	}

	public void setLabel( Text txt )
	{
		label = new Label( txt );
	}

	public Text getLabel()
	{
		if (label)
			return label.txt;
		return null;
	}

	public String getLabelText()
	{
		if( label )
			return label.txt.text;

		return null;
	}

	public void changeLabelText( String newtxt )
	{
		if( label )
			label.txt.changeText( newtxt );
	}

	public void changeTexture( ResourceRef newTexture )
	{
		if( rect )
			rect.changeTexture( newTexture );
	}



	public void setToolTip( String t )
	{
		tooltip = t;
	}

	public void enableDrop()
	{
		dropEnabled = 1;
	}



	public void disable()
	{ 
		disabled = 1; 

		if( osd.pointedGadget == this )
			osd.deactivateText();

		if( label )
			label.txt.changeColor( Osd.COLOR_DISABLED );
	}
	public void enable()
	{ 
		disabled = 0; 
		if( label )
			label.txt.changeColor( Osd.COLOR_UNSELECTED );
	}

	public void focus()
	{ 
		if( highliteMethod & Osd.HL_LABELCOLOR && label )
			label.txt.changeColor( Osd.COLOR_SELECTED );

		if( highliteMethod & Osd.HL_BACKLIGHT && rect )
		{
			Vector3 p2 = new Vector3( rect.pos );
			if( !disabled )
			{
				p2.z-=0.0005; //fel prioritasi szinttel hatrebb :)
				hr = new Rectangle( rect.root, p2, new RectangleTemplate( rect.rt.width*HIGHLIGHT_NORMAL_SCALE, rect.rt.height*HIGHLIGHT_NORMAL_SCALE, HIGHLIGHT_NORMAL ) );
			}
			else
			{
				p2.z+=0.0005; //fel prioritasi szinttel hatrebb :)
				hr = new Rectangle( rect.root, p2, new RectangleTemplate( rect.rt.width*HIGHLIGHT_DISABLED_SCALE, rect.rt.height*HIGHLIGHT_DISABLED_SCALE, HIGHLIGHT_DISABLED ) );
			}
		}
	}
	public void unfocus()
	{ 
		if( highliteMethod & Osd.HL_LABELCOLOR && label )
			label.txt.changeColor( Osd.COLOR_UNSELECTED );

		if( hr )
		{
			hr.finalize();
			hr=null;
		}
	}

	public void press()
	{ 
		pressed=1; 
		
		if( highliteMethod & Osd.HL_LABELCOLOR && label )
			label.txt.changeColor( Osd.COLOR_PRESSED );

		if( hr )
		{
			hr.finalize();
			hr=null;
		}
		if( highliteMethod & Osd.HL_BACKLIGHT && rect )
		{
			Vector3 p2 = new Vector3( rect.pos );
			p2.z-=0.0005; //fel prioritasi szinttel hatrebb :)
			hr = new Rectangle( rect.root, p2, new RectangleTemplate( rect.rt.width*HIGHLIGHT_ACTIVE_SCALE, rect.rt.height*HIGHLIGHT_ACTIVE_SCALE, HIGHLIGHT_NORMAL ) );
		}

		osd.pressEffect();
	}
	public void release()
	{ 
		pressed=0; 

		if( highliteMethod & Osd.HL_LABELCOLOR && label )
			label.txt.changeColor( Osd.COLOR_SELECTED );

		if( hr )
		{
			hr.finalize();
			hr=null;
		}
		if( highliteMethod & Osd.HL_BACKLIGHT && rect )
		{
			Vector3 p2 = new Vector3( rect.pos );
			p2.z-=0.0005; //fel prioritasi szinttel hatrebb :)
			hr = new Rectangle( rect.root, p2, new RectangleTemplate( rect.rt.width*HIGHLIGHT_NORMAL_SCALE, rect.rt.height*HIGHLIGHT_NORMAL_SCALE, HIGHLIGHT_NORMAL ) );
		}

		osd.pressEffectStop();
	}

	public void click(){}

	public void sendMessage()
	{
		if( handler )
		{
			int x;
			if( handler instanceof GameType )
			{
				MessagePort mp = ((GameType)handler).mp;

				if( mp )
				{
					Event e =  new Event( cmd, Event.F_GAD_CHANGE );
					e.gadget = this;
					mp.putMessage( e );

					x=1;
				}
			}

			if( !x )
				handler.osdCommand( cmd );
		}
	}

	public Vector3 getHotSpot()
	{
		return phy.getPos();
	}

}

