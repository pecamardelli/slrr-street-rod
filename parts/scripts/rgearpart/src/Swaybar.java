package java.game.parts.rgearpart;

import java.render.osd.*;
import java.io.*;
import java.util.*;
import java.util.resource.*;
import java.game.cars.*;
import java.game.parts.*;
import java.game.parts.bodypart.*;
import java.game.parts.enginepart.*;

public class Swaybar extends RGearPart
{
	float force;
	float damping;
	
	final static float minValue = -5.0, maxValue = 5.0;
	float posX, posY, posZ, rotY, rotP, rotR = 0.0;
	float accuracy = 0.015;
	Part parent;
	int parentSlotID;
	
	int	adjustable = 0;
	float min_force = 0;
	float max_force = 0;
	float default_force = 0;
	
	public Swaybar( int id )
	{
		super( id );
		
		name = "Anti-roll bar";
		
		prestige_calc_weight = 20.0;
	}
	
	public void calcStuffs()
	{
		name = name_prefix + Float.toString( force, " %1.0f N/m " ) + /*Float.toString( damping, " %1.0f N/m/s dampened " ) + */"anti-roll bar";
		// value = HUF2USD( force );
		
		if( adjustable >= 1 && min_force > 0 && max_force > 0 )
		{
			name = name_prefix + Float.toString( force, " %1.0f N/m " ) + /*Float.toString( damping, " %1.0f N/m/s dampened " ) + */"adjustable anti-roll bar";
			if( default_force == 0 )
				default_force = force;
			value = HUF2USD( default_force );
			value *= 3;
		}
		
		updatevariables();
	}
	
	public void updatevariables()
	{
		getCar_LocalVersion();

		int parentSlotID = slotIDOnSlot( 1 );

		if (parentSlotID == 701)
		{
			the_car.queueEvent( null, EVENT_COMMAND, "add_rollbar 0 1 " + force + " " + damping );
		}
		else
		if (parentSlotID == 702)
		{
			the_car.queueEvent( null, EVENT_COMMAND, "add_rollbar 2 3 " + force + " " + damping );
		}
		else
		{
			return;
		}
//		System.log("anti-roll bar damping = " + damping);
//		System.log("anti-roll bar force   = " + force );
	}
	
	public void load( File saveGame )
	{
		super.load( saveGame );
		
		if (save_version >= SAVEFILEVERSION_PART)
		{
			posX	= saveGame.readFloat();
			posY	= saveGame.readFloat();
			posZ	= saveGame.readFloat();
			rotY	= saveGame.readFloat();
			rotP	= saveGame.readFloat();
			rotR	= saveGame.readFloat();
			
			if( adjustable >= 1 && min_force > 0 && max_force > 0 )
				force = saveGame.readFloat();
		}
		
		calcStuffs();
	}
	
	public void save( File saveGame )
	{
		super.save( saveGame );
		
		if (save_version >= SAVEFILEVERSION_PART)
		{
			saveGame.write( posX );
			saveGame.write( posY );
			saveGame.write( posZ );
			saveGame.write( rotY );
			saveGame.write( rotP );
			saveGame.write( rotR );
			
			if( adjustable >= 1 && min_force > 0 && max_force > 0 )
				saveGame.write( force );
		}
	}
	
	public int isTuneable()
	{
		return 1;
	}
	
	float old_posX, old_posY, old_posZ, old_rotY, old_rotP, old_rotR;
	float old_force, new_force;
	
	public void buildTuningMenu( Menu m )
	{
		Slider s;
		
		old_posX = posX;
		old_posY = posY;
		old_posZ = posZ;
		old_rotY = rotY;
		old_rotP = rotP;
		old_rotR = rotR;
		
		old_force = force;
		new_force = force;
		
		accuracy = Part.latestAccuracy;
		
		s = m.addItem( "X", 1, posX, minValue, maxValue, (maxValue - minValue) / accuracy + 1, null );
		s.changeVLabelText( Float.toString(posX, "   %1.3f") );
		
		s = m.addItem( "Y", 2, posY, minValue, maxValue, (maxValue - minValue) / accuracy + 1, null );
		s.changeVLabelText( Float.toString(posY, "   %1.3f") );
		
		s = m.addItem( "Z", 3, posZ, minValue, maxValue, (maxValue - minValue) / accuracy + 1, null );
		s.changeVLabelText( Float.toString(posZ, "   %1.3f") );
		
		s = m.addItem( "Y", 4, rotY, -180.0, 180, 361, null );
		s.changeVLabelText( Float.toString(rotY, "   %1.0f degrees") );
		
		s = m.addItem( "P", 5, rotP, -180.0, 180, 361, null );
		s.changeVLabelText( Float.toString(rotP, "   %1.0f degrees") );
		
		s = m.addItem( "R", 6, rotR,-180.0, 180, 361, null );
		s.changeVLabelText( Float.toString(rotR, "   %1.0f degrees") );
		
		m.addItem( "Accuracy: " + Float.toString(accuracy, "%1.3f"), 7 );
		
		if( adjustable >= 1 && min_force > 0 && max_force > 0 )
		{
			m.addItem( "Reset Position", 0 );
			m.addSeparator();
			
			if( min_force > max_force )
			{
				float tmp = min_force;
				min_force = max_force;
				max_force = tmp;
			}
			
			s = m.addItem( "Force", 8, new_force, min_force, max_force, (max_force - min_force) / 500 + 1, null );
			s.changeVLabelText( Float.toString( new_force, "   %1.0f N/m" ) );
			m.addItem( "Reset Force", 9 );
		}
		else
		{
			m.addItem( "Reset", 0 );
		}
	}
	
	public void endTuningSession( int cancelled )
	{
		if( cancelled )
		{
			posX = old_posX;
			posY = old_posY;
			posZ = old_posZ;
			rotY = old_rotY;
			rotP = old_rotP;
			rotR = old_rotR;
			
			force = old_force;
		}
		else
		{
			force = new_force;
			calcStuffs();
			
			getCar_LocalVersion();
			if (the_car)
				the_car.forceUpdate();
		}
		
		if( parent != null )
			parent.setSlotPos( parentSlotID, new Vector3(posX,posZ,posY), new Ypr(deg2rad(rotY),deg2rad(rotP),deg2rad(rotR)) );
		
		Part.latestAccuracy = accuracy;
	}
	
	public void handleMessage( Event m )
	{
		if( m.cmd == 1 )
		{
			posX = ((Slider)m.gadget).value;
			((Slider)m.gadget).changeVLabelText( Float.toString(posX, "   %1.3f") );
		}
		else if( m.cmd == 2 )
		{
			posY = ((Slider)m.gadget).value;
			((Slider)m.gadget).changeVLabelText( Float.toString(posY, "   %1.3f") );
		}
		else if( m.cmd == 3 )
		{
			posZ = ((Slider)m.gadget).value;
			((Slider)m.gadget).changeVLabelText( Float.toString(posZ, "   %1.3f") );
		}
		else if( m.cmd == 4 )
		{
			rotY = ((Slider)m.gadget).value;
			((Slider)m.gadget).changeVLabelText( Float.toString(rotY, "   %1.0f degrees") );
		}
		else if( m.cmd == 5 )
		{
			rotP = ((Slider)m.gadget).value;
			((Slider)m.gadget).changeVLabelText( Float.toString(rotP, "   %1.0f degrees") );
		}
		else if( m.cmd == 6 )
		{
			rotR = ((Slider)m.gadget).value;
			((Slider)m.gadget).changeVLabelText( Float.toString(rotR, "   %1.0f degrees") );
		}
		else if( m.cmd == 7 )
		{
			if( equal( accuracy, 0.001 ) ) accuracy = 0.005;
			else if( equal( accuracy, 0.005 ) ) accuracy = 0.015;
			else if( equal( accuracy, 0.015 ) ) accuracy = 0.050;
			else if( equal( accuracy, 0.050 ) ) accuracy = 0.001;
			
			m.gadget.osd.findGadget( this, 1 ).setTicks( (maxValue - minValue) / accuracy + 1 );
			m.gadget.osd.findGadget( this, 2 ).setTicks( (maxValue - minValue) / accuracy + 1 );
			m.gadget.osd.findGadget( this, 3 ).setTicks( (maxValue - minValue) / accuracy + 1 );
			
			m.gadget.osd.findGadget( this, 7 ).changeLabelText( "Accuracy: " + Float.toString(accuracy, "%1.3f") );
		}
		else if( m.cmd == 8 )
		{
			new_force = ((Slider)m.gadget).value;
			((Slider)m.gadget).changeVLabelText( Float.toString( new_force, "   %1.0f N/m" ) );
		}
		else if( m.cmd == 9 )
		{
			new_force = default_force;
			
			m.gadget.osd.findGadget( this, 8 ).setValue( new_force );
			m.gadget.osd.findGadget( this, 8 ).changeVLabelText( Float.toString( new_force, "   %1.0f N/m" ) );
		}
		else if( m.cmd == 0 )
		{
			posX = 0.0;
			posY = 0.0;
			posZ = 0.0;
			rotY = 0.0;
			rotP = 0.0;
			rotR = 0.0;
			
			m.gadget.osd.findGadget( this, 1 ).setValue( posX );
			m.gadget.osd.findGadget( this, 1 ).changeVLabelText( Float.toString(posX, "   %1.3f") );
			
			m.gadget.osd.findGadget( this, 2 ).setValue( posY );
			m.gadget.osd.findGadget( this, 2 ).changeVLabelText( Float.toString(posY, "   %1.3f") );
			
			m.gadget.osd.findGadget( this, 3 ).setValue( posZ );
			m.gadget.osd.findGadget( this, 3 ).changeVLabelText( Float.toString(posZ, "   %1.3f") );
			
			m.gadget.osd.findGadget( this, 4 ).setValue( rotY );
			m.gadget.osd.findGadget( this, 4 ).changeVLabelText( Float.toString(rotY, "   %1.0f degrees") );
			
			m.gadget.osd.findGadget( this, 5 ).setValue( rotP );
			m.gadget.osd.findGadget( this, 5 ).changeVLabelText( Float.toString(rotP, "   %1.0f degrees") );
			
			m.gadget.osd.findGadget( this, 6 ).setValue( rotR );
			m.gadget.osd.findGadget( this, 6 ).changeVLabelText( Float.toString(rotR, "   %1.0f degrees") );
		}
		
		if( parent != null )
			parent.setSlotPos( parentSlotID, new Vector3( posX,posZ,posY ), new Ypr( deg2rad(rotY),deg2rad(rotP),deg2rad(rotR) ) );
	}
	//---------tuning
	
	public Part getparent()
	{
		return partOnSlot(getSlotID(-1));
	}
	
	public int getparentSlotID()
	{
		int slotIndex;
		int slotID;
		int slots = getparent().getSlots();
		int parentSlotID = getparent().getSlotID( -1 );
		
		for( slotIndex=0; slotIndex<slots; slotIndex++ )
		{
			slotID = getparent().getSlotID( slotIndex );
			if( slotID != parentSlotID )
			{
				Part p;
				p = getparent().partOnSlot(slotID);
				if( p == this )
				{
					return slotID;
				}
			}
		}
		return 0;
	}
	
	public void install()
	{
		super.install();
		parent = getparent();
		parentSlotID = getparentSlotID();
		if( parent == null ) return;
		parent.setSlotPos( parentSlotID, new Vector3( posX,posZ,posY ), new Ypr( deg2rad(rotY),deg2rad(rotP),deg2rad(rotR) ) );
	}
	
	public void repair()
	{
		super.repair();
		if( parent == null ) return;
		Thread SetPosAgain = new SetAgain( posX, posY, posZ, rotY, rotP, rotR, parent, parentSlotID );
		SetPosAgain.start();
	}
	
	public float deg2rad( float deg )
	{
		return ( deg * 3.141 / 180 );
	}
	
	private int equal( float a, float b )
	{
		return -0.0005 < a - b && a - b < 0.0005;
	}
}

public class SetAgain extends Thread
{
	float posX, posY, posZ, rotY, rotP, rotR;
	Part parent;
	int parentSlotID;
	
	public SetAgain( float posX2, float posY2, float posZ2, float rotY2, float rotP2, float rotR2, Part parent2, int pID )
	{
		posX = posX2;
		posY = posY2;
		posZ = posZ2;
		rotY = rotY2;
		rotP = rotP2;
		rotR = rotR2;
		
		parent = parent2;
		parentSlotID = pID;
	}
	
	public void run()
	{
		parent.setSlotPos( parentSlotID, new Vector3( posX,posZ,posY ), new Ypr( deg2rad(rotY),deg2rad(rotP),deg2rad(rotR) ) );
		super.stop();
	}
	
	public float deg2rad( float deg )
	{
		return ( deg * 3.141 / 180 );
	}
}
