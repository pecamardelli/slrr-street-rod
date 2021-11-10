package java.game.parts.rgearpart;

import java.render.osd.*;
import java.io.*;
import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.cars.*;
import java.game.parts.*;
import java.game.parts.bodypart.*;
import java.game.parts.enginepart.*;

public class AdjustableSwaybar extends Swaybar
{
	final float force_difference = 2000.0;
	
	public AdjustableSwaybar( int id )
	{
		super( id );
		
		adjustable = 1;
	}
	
	public void calcStuffs()
	{
		min_force = force - force_difference;
		max_force = force + force_difference;
		
		super.calcStuffs();
		updateName();
	}
	
	public void endTuningSession( int cancelled )
	{
		super.endTuningSession( cancelled );
		updateName();
	}
	
	private void updateName()
	{
		name = name_prefix + Float.toString( force, " %1.0f N/m " ) + /*Float.toString( damping, " %1.0f N/m/s dampened " ) + */"anti-roll bar";
	}
}
