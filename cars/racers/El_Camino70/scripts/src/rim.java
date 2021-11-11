package java.game.cars;

import java.render.osd.*;
import java.io.*;
import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.parts.rgearpart.reciprocatingrgearpart.*;

public class rim extends Wheel
{
	float f_offset, default_offset, old_offset, diameter, width;

	public rim ( int id )
	{
		name = "Rim stock";

		rim_type = rtFACTORY;
		diameter = 16.0;
		width = 11.0;
		default_offset = 0.0;
		f_offset = default_offset;
		SetupWheel( diameter, width, default_offset);
		
		description = "Variable offset";
	}
	
	public void updatevariables()
	{
		super.updatevariables();
		setSlotPos( 1, new Vector3(f_offset/1000.0, 0, 0), null );
	}
	
	public void load( File saveGame )
	{
		super.load( saveGame );

		int	save_ver = saveGame.readInt();

		if (save_ver >= 1)
		{
			f_offset = saveGame.readFloat();
			setSlotPos( 1, new Vector3(f_offset/1000.0, 0, 0), null );
		}
	}

	public void save( File saveGame )
	{
		super.save( saveGame );

		int	save_ver = 2;

		saveGame.write( save_ver );
		if (save_ver >= 1)
		{
			saveGame.write( f_offset );
		}
	}
	
	public int isTuneable()
	{
		return true;
	}
	
	public void buildTuningMenu( Menu m )
	{
		old_offset = f_offset;

		m.addItem( "Offset", 1, f_offset, -105.0, 65.0, 1.1, null ).printValue("   %1.1f");
		
		m.addItem( "Reset to factory defaults",			0);	//this should always be with cmd=0
		
		GameLogic.player.car.wakeUp();
	}

	public void endTuningSession( int cancelled )
	{
		if( cancelled )
		{
			f_offset = old_offset;
		}
		else
		{
			if (f_offset != old_offset)
				GameLogic.spendTime(5*60);
			getCar_LocalVersion();
			if (the_car)
				the_car.forceUpdate();
		}
	}

	public void handleMessage( Event m )
	{
		if( m.cmd == 0 )
		{
			f_offset = default_offset;
			m.gadget.osd.findGadget( this, 1 ).setValue( default_offset );
			setSlotPos( 1, new Vector3(f_offset/1000.0, 0, 0), null );
		}
		else
		if( m.cmd == 1 )
		{
			f_offset = ((Slider)m.gadget).value;
			((Slider)m.gadget).changeVLabelText( Float.toString(f_offset, "   %1.1f"));
			setSlotPos( 1, new Vector3(f_offset/1000.0, 0, 0), null );
		}
	}
}
