package java.render.osd;

import java.render.*;
import java.io.*;
import java.util.*;
import java.util.resource.*;

public class TextBox
{
	Group		parent;
	ResourceRef charset;
	Viewport	vp;
	float		x, y, width;
	int			align, MaxLines, color=Text.DEF_COLOR;
	ResourceRef	background;
	Rectangle	rect;

	Vector		texts;

	public TextBox( Group parent_, ResourceRef charset_, Viewport vp_, int align_, String text, float left_, float top_, float width_, ResourceRef bg )
	{
		this( parent_, charset_, vp_, align_, text, left_, top_, width_, bg, 2000 );
	}

	public TextBox( Group parent_, ResourceRef charset_, Viewport vp_, int align_, String text, float left_, float top_, float width_, ResourceRef bg, int MaxLines_ )
	{
		parent = parent_;
		charset = charset_;
		vp = vp_;
		align = align_;
		x = left_;
		y = top_;
		width = width_;
		background = bg;
		MaxLines = MaxLines_;

		changeText( text );
	}

	public void changeText( String txt )
	{
		if( texts )
		{
			Text t;
			for( int i=0; i<texts.size(); i++ )
			{
				t = texts.elementAt( i );
				t.finalize();
			}
			texts=null;

			if( background )
				rect.finalize();
		}

		if( txt )
		{
			texts=new Vector();

			StringTokenizer tr = new StringTokenizer( txt, " " );
			String token;

			String delimiter = " ";
			float delimiterWidth = Text.getWidth( delimiter, charset, vp );

			String line;
			int lineNumber, end;
			float w, ww;
			float maxWidth;

			while( (token = tr.nextToken())!=null || line!=null )
			{
				if( token )
				{
					if (end>0) token = "\n"; // jump to line

					if( MaxLines-1 == lineNumber )
					{
						if( w + Text.getWidth(token+"  (...)", charset, vp) > width && end == 0)
						{//Put " (...)" as last word and stop showing nex text
							end = 1;
							token = " (...)";
						}
					}
					
					ww = Text.getWidth( token, charset, vp );
				}

				if( w+ww > width || token==null || token == "\n" )
				{	//create a line
					if( align == Text.ALIGN_LEFT )
					{
						texts.addElement( new Text( parent, charset, line, x, y, lineNumber, vp ));
					}
					else
					if( align == Text.ALIGN_RIGHT )
					{
						texts.addElement( new Text( parent, charset, line, x+(width-w), y, lineNumber, vp ));
					}
					else
					if( align == Text.ALIGN_CENTER )						{
						texts.addElement( new Text( parent, charset, line, x+(width-w)/2, y, lineNumber, vp ));
					}

					w=0.0;
					line=null;
					
					if(lineNumber >= MaxLines-1) break;// Stop writingnext lines

					lineNumber++;

					if( maxWidth < w )
						maxWidth = w;

					if(	token == "\n" )
						token=null;
				}
				
				if( token )
				{
					if( line )
					{
						line = line+delimiter+token;
						w+=delimiterWidth;
					}
					else
					{
						line=token;
					}

					w += ww;
				}
			}

			float height = lineNumber*2*( (1.2*Text.getFontSize( charset ))/(Config.video_y*vp.getHeight()) );

			changeColor( color );

			if( background )
				rect = parent.osd.createRectangle( x+width/2, y+height/2, width*1.1, height*1.1, 0, background );
		}
	}

	public void changeColor( int color_ )
	{
		color=color_;

		if( texts )
		{
			for( int i=0; i<texts.size(); i++ )
			{
				Text txt = texts.elementAt( i );
				if( txt )
					txt.changeColor( color );
			}
		}
	}
}
