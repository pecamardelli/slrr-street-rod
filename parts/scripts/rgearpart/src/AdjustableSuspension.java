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

public class AdjustableSuspension extends Suspension
{
	final float camber_difference = 10.0;
	final float toe_difference = 2.0;
	final float spacer_difference = 0.2;
	
	float default_camber, default_toe, default_spacer;
	float spacer = 0.0;
	
	public AdjustableSuspension( int id )
	{
		super( id );
	}
	
	public void setupDefaults()
	{
		default_camber = camber;
		default_toe = toe;
		default_spacer = spacer;
	}
	
	public void load( File saveGame )
	{
		super.load( saveGame );
		
		if (save_version >= SAVEFILEVERSION_PART)
		{
			int	save_ver = saveGame.readInt();
			
			if (save_ver >= 1)
			{
				camber = saveGame.readFloat();
				toe = saveGame.readFloat();
				spacer = saveGame.readFloat();
			}
		}
	}
	
	public void save( File saveGame )
	{
		super.save( saveGame );
		
		if (save_version >= SAVEFILEVERSION_PART)
		{
			int	save_ver = 2;
			saveGame.write( save_ver );
			
			if (save_ver >= 1)
			{
				saveGame.write( camber );
				saveGame.write( toe );
				saveGame.write( spacer );
			}
		}
	}
	
	
	//---------tuning
	public int isTuneable()
	{
		return 1;
	}
	
	float old_camber, old_toe, old_spacer;
	
	public void buildTuningMenu( Menu m )
	{
		old_camber = camber;
		old_toe = toe;
		old_spacer = spacer;
		
		float addition = 0.00001;
		
		float min_camber = -camber_difference - addition;
		float max_camber = camber_difference + addition;
		
		float min_toe = -toe_difference - addition;
		float max_toe = toe_difference + addition;
		
		float min_spacer = -spacer_difference - addition;
		float max_spacer = spacer_difference + addition;
		
		m.addItem( "Camber", 1, camber, min_camber, max_camber, (max_camber - min_camber) / 0.5 + 1, null ).printValue( "   %1.2f deg" );
		m.addItem( "Toe", 2, toe, min_toe, max_toe, (max_toe - min_toe) / 0.1 + 1, null ).printValue( "   %1.2f deg" );
		m.addItem( "Spacer", 3, spacer, min_spacer, max_spacer, (max_spacer - min_spacer) / 0.01 + 1, null ).printValue( "   %1.3f m" );
		m.addItem( "Reset to factory defaults", 0);
		
		GameLogic.player.car.wakeUp();
	}
	
	public void endTuningSession( int cancelled )
	{
		if( cancelled )
		{
			camber = old_camber;
			toe = old_toe;
			spacer = old_spacer;
		}
		else
		{
			if (camber != old_camber)
				GameLogic.spendTime(5*60);
			if (toe != old_toe)
				GameLogic.spendTime(5*60);
			if (spacer != old_spacer)
				GameLogic.spendTime(5*60);
			
			getCar_LocalVersion();
			if (the_car)
				the_car.forceUpdate();
		}
		
		updatevariables();
	}
	
	public void handleMessage( Event m )
	{
		if( m.cmd == 0 )
		{
			camber = default_camber;
			toe = default_toe;
			spacer = default_spacer;
			
			m.gadget.osd.findGadget( this, 1 ).setValue( camber );
			m.gadget.osd.findGadget( this, 2 ).setValue( toe );
			m.gadget.osd.findGadget( this, 3 ).setValue( spacer );
		}
		else
		if( m.cmd == 1 )
		{
			camber = ((Slider)m.gadget).value;
			m.gadget.osd.findGadget( this, 1 ).setValue( camber );
		}
		else
		if( m.cmd == 2 )
		{
			toe = ((Slider)m.gadget).value;
			m.gadget.osd.findGadget( this, 2 ).setValue( toe );
		}
		else
		if( m.cmd == 3 )
		{
			spacer = ((Slider)m.gadget).value;
			m.gadget.osd.findGadget( this, 3 ).setValue( spacer );
		}
	}
}
