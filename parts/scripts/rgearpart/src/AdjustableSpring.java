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

public class AdjustableSpring extends Spring
{
	final float difference = 2.0;
	
	float length, default_restlength, default_minlength, default_maxlength;
	float initial_value;
	
	public AdjustableSpring( int id )
	{
		super( id );
	}
	
	public void calcStuffs()
	{
		default_restlength = restlength;
		default_minlength = minlength;
		default_maxlength = maxlength;
		
		length = Meter2Inch( default_restlength );
		
		super.calcStuffs();
		
		initial_value = value;
	}
	
	public void recalcStuffs()
	{
		restlength = Inch2Meter( length );
		minlength = restlength - (default_restlength - default_minlength);
		maxlength = restlength + (default_maxlength - default_restlength);
		
		super.calcStuffs();
		
		value = initial_value;
		updatevariables();
	}
	
	public void load( File saveGame )
	{
		super.load( saveGame );
		
		if (save_version >= SAVEFILEVERSION_PART)
		{
			int	save_ver = saveGame.readInt();
			
			if (save_ver >= 1)
			{
				length = saveGame.readFloat();
			}
			
			recalcStuffs();
		}
	}
	
	public void save( File saveGame )
	{
		super.save( saveGame );
		
		if (save_version >= SAVEFILEVERSION_PART)
		{
			int	save_ver = 1;
			saveGame.write( save_ver );
			
			if (save_ver >= 1)
			{
				saveGame.write( length );
			}
		}
	}
	
	//---------tuning
	public int isTuneable()
	{
		return 1;
	}
	
	float old_restlength;
	
	public void buildTuningMenu( Menu m )
	{
		old_restlength = Inch2Meter( length );
		
		float min_length = Meter2Inch( default_restlength ) - difference;
		float max_length = Meter2Inch( default_restlength ) + difference;
		
		m.addItem( "Ride Height", 1, length, min_length, max_length, (max_length - min_length) / 0.01 + 1, null ).printValue( "   %1.2f inches" );
		m.addItem( "Reset to factory defaults", 0 );
		
		GameLogic.player.car.wakeUp();
	}
	
	public void endTuningSession( int cancelled )
	{
		if( cancelled )
		{
			length = Meter2Inch( old_restlength );
		}
		else
		{
			if( length != Meter2Inch( old_restlength ) )
				GameLogic.spendTime( 5*60 );
		}
		
		recalcStuffs();
		
		getCar_LocalVersion();
		if( the_car )
			the_car.forceUpdate();
	}
	
	public void handleMessage( Event m )
	{
		if( m.cmd == 0 )
		{
			length = Meter2Inch( default_restlength );
			m.gadget.osd.findGadget( this, 1 ).setValue( length );
		}
		else
		if( m.cmd == 1 )
		{
			length = ((Slider)m.gadget).value;	
			m.gadget.osd.findGadget( this, 1 ).setValue( length );
		}
	}
	
	public float Meter2Inch( float m )
	{
		return 1000.0*m/25.4;
	}
}
