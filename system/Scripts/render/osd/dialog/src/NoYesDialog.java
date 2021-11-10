package java.render.osd.dialog;

import java.io.*;
import java.util.*;
import java.util.resource.*;
import java.render.*;
import java.render.osd.*;


public class NoYesDialog extends TextDialog
{
	public NoYesDialog( Controller ctrl, int myflags, String mytitle, String mybody )
	{
		super( ctrl, myflags, mytitle, "YES;NO", mybody );
		osd.defSelection=1;
	}
	public NoYesDialog( Controller ctrl, int myflags, String mytitle, String mybody, float size, float aspect )
	{
		super( ctrl, myflags, mytitle, "YES;NO", mybody, size, aspect );
		osd.defSelection=1;
	}
}

