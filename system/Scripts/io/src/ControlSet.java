package java.io;

import java.render.*;
import java.io.*;
import java.util.*;
import java.util.resource.*;
import java.sound.*;
import java.lang.*;

public class ControlSet
{
	final static int	CTRLFILEID = 0x4c525443;
	final static int	CTRLFILEVERSION = 16;
	final static int	NCONTROLS = 79;

	final static int	KEYBOARD = 0;
	final static int	MOUSE = 1;

	int					nDevices;
	String[]			deviceName;

	int[]				group = new int[NCONTROLS];
	int[]				vaxisID = new int[NCONTROLS];

	int[]				deviceID = new int[NCONTROLS];
	int[]				axisID = new int[NCONTROLS];
	float[]				from_min = new float[NCONTROLS];
	float[]				from_max = new float[NCONTROLS];
	float[]				to_min = new float[NCONTROLS];
	float[]				to_max = new float[NCONTROLS];

	float[]				dead_zone = new float[NCONTROLS];

	Vector	vasp = new Vector();	//VirtualAxisSmoothProperties Vector
	
	public ControlSet()
	{
		int		i;
		String	name;

		nDevices = 0;
		while( (name = Input.getDeviceName( nDevices )) != null )
		{
			nDevices++;
		}

		deviceName = new String[nDevices];
		for( i = 0; i < nDevices; i++ )
		{
			deviceName[i] = Input.getDeviceName( i );
		}

		defaults();
	}

	public int nitems()
	{
		return( NCONTROLS );
	}

	public void load( String fileName )
	{
		File ctrlFile = new File( fileName );

		if( ctrlFile.open( File.MODE_READ ) )
		{
			if( ctrlFile.readInt() == CTRLFILEID )
			{
				if( ctrlFile.readInt() == CTRLFILEVERSION )
				{
					int			i, j, n;
					String[]	remapName;
					int[]		remapID;

					n = ctrlFile.readInt();

					remapName = new String[n];
					remapID = new int[n];

					for( i = 0; i < n; i++ )
					{
						remapName[i] = ctrlFile.readString();
						remapID[i] = -1;
						for( j = 0; j < nDevices; j++ )
						{
							if( remapName[i] == deviceName[j] )
							{
								remapID[i] = j;
								break;
							}
						}
						if( j == nDevices )
						{
							// device not found, add to device list

							String[]	newNames = new String[nDevices + 1];

							for( j = 0; j < nDevices; j++ )
							{
								newNames[j] = deviceName[j];
							}
							newNames[j] = remapName[i];
							remapID[i] = -1 - j;		// not_found_id = -1 - id
							deviceName = newNames;
							nDevices++;
						}
					}

					n=ctrlFile.readInt();	//NCONTROLS
					for ( i = 0; i < n; i++ )
					{
						if (i<NCONTROLS)
						{
							int		id;

							group [i] = ctrlFile.readInt();
							vaxisID [i] = ctrlFile.readInt();

							id = ctrlFile.readInt();
							if( id < 0 )
							{
								// not_found_id
								id = -id - 1;
							}
							deviceID [i] = remapID [id];
							axisID [i] = ctrlFile.readInt();
							from_min [i] = ctrlFile.readFloat();
							from_max [i] = ctrlFile.readFloat();
							to_min [i] = ctrlFile.readFloat();
							to_max [i] = ctrlFile.readFloat();
//System.log( i+" dev "+deviceID [i]+" ax "+axisID [i]+" fmin "+from_min [i]+" fmax "+from_max [i]+" tmin "+to_min [i]+" tmax "+to_max [i]+" dz "+dead_zone [i]);
							dead_zone [i] = ctrlFile.readFloat();
						} else
						{//skip these
							ctrlFile.readInt();
							ctrlFile.readInt();

							ctrlFile.readInt();
							ctrlFile.readInt();
							ctrlFile.readFloat();
							ctrlFile.readFloat();
							ctrlFile.readFloat();
							ctrlFile.readFloat();
							ctrlFile.readFloat();
						}
					}

					n=ctrlFile.readInt();
					vasp = new Vector(n);
					for( i = 0; i < n; i++ )
					{
						vasp.addElement( new VirtualAxisSmoothProperties(ctrlFile) );
					}

				}
			}
			ctrlFile.close();
		}
	}

	public static int fileCheck( String fileName )
	{
		int	status;
		if( fileName != Controller.controlFile )
		{
			File ctrlFile = new File( fileName );

			if( ctrlFile.open( File.MODE_READ ) )
			{
				if( ctrlFile.readInt() == CTRLFILEID )
					if( ctrlFile.readInt() == CTRLFILEVERSION )
						status = 1;

				ctrlFile.close();
			}
		}
		return status;
	}


	public void save( String fileName )
	{
		File ctrlFile = new File( fileName );

		if( ctrlFile.open( File.MODE_WRITE ) )
		{
			int		i;

			ctrlFile.write( CTRLFILEID );
			ctrlFile.write( CTRLFILEVERSION );

			ctrlFile.write( nDevices );
			for( i = 0; i < nDevices; i++ )
			{
				ctrlFile.write( deviceName[i] );
			}
			ctrlFile.write( NCONTROLS );
			for( i = 0; i < NCONTROLS; i++ )
			{
				ctrlFile.write( group[i] );
				ctrlFile.write( vaxisID[i] );

				ctrlFile.write( deviceID[i] );
				ctrlFile.write( axisID[i] );
				ctrlFile.write( from_min[i] );
				ctrlFile.write( from_max[i] );
				ctrlFile.write( to_min[i] );
				ctrlFile.write( to_max[i] );

				ctrlFile.write( dead_zone[i] );
			}
			ctrlFile.write( vasp.size() );
			for( i = 0; i < vasp.size(); i++ )
			{
				vasp.elementAt( i ).write(ctrlFile);
			}
			ctrlFile.close();
		}
	}

	public void change( int i, int device, int axis )
	{
		if( i >= 0 && i < NCONTROLS )
		{
			deviceID [i] = device;
			axisID [i] = axis;
		}
	}

	public void define( int i, int gr, int vaxis, int device, int axis, float fmin, float fmax, float tmin, float tmax, float dz )
	{
		if( i >= 0 && i < NCONTROLS )
		{
			group [i]					= gr;
			vaxisID [i]					= vaxis;
			deviceID [i]				= device;
			axisID [i]					= axis;
			from_min [i]				= fmin;
			from_max [i]				= fmax;
			to_min [i]					= tmin;
			to_max [i]					= tmax;
			dead_zone [i]				= dz;
		}
	}


	//group identifiers:
	final static int DEFAULTSET = 0;
	final static int DRIVERSET = 1;
	final static int MENUSET = 2;
	final static int CAMTURNSET = 3;
	final static int CAMMOVESET = 4;
	final static int DEBUGCAMSET = 5;

	public void defaults()
	{
		//figyelem! sorrend fix!
		vasp.addElement( new VirtualAxisSmoothProperties(Input.AXIS_THROTTLE,		0.10,	0.20*Config.throttleSpeed,	0.50*Config.throttleSpeed,	0.30*Config.throttleSpeed,	Config.throttlePower ) );
		vasp.addElement( new VirtualAxisSmoothProperties(Input.AXIS_BRAKE,		0.10,	0.20*Config.brakeSpeed,		0.50*Config.brakeSpeed,		0.30*Config.brakeSpeed,		Config.brakePower ) );
		vasp.addElement( new VirtualAxisSmoothProperties(Input.AXIS_TURN_LEFTRIGHT,	0.10,	0.25*Config.steerSpeed,		0.35*Config.steerSpeed,		0.25*Config.steerSpeed,		Config.steeringPower ) );
		vasp.addElement( new VirtualAxisSmoothProperties(Input.AXIS_CLUTCH,		0.10,	0.20,				0.50,				0.30,				Config.clutchPower ) );

		// primary controls
		// ezeket menubol at lehet definialni, fix helyen kell lenniuk (0..14)!!	
		define ( 0, 1, Input.AXIS_THROTTLE, KEYBOARD, Input.RCDIK_UP, 0.0, 1.0, 0.0, 1.0, Config.deadZoneAccelerate );
		define ( 1, 1, Input.AXIS_BRAKE, KEYBOARD, Input.RCDIK_DOWN, 0.0, 1.0, 0.0, 1.0, Config.deadZoneBrake );
		define ( 2, 1, Input.AXIS_TURN_LEFTRIGHT, KEYBOARD, Input.RCDIK_LEFT, 0.0, 1.0, 0.0, 1.0, Config.deadZoneSteering );
		define ( 3, 1, Input.AXIS_TURN_LEFTRIGHT, KEYBOARD, Input.RCDIK_RIGHT, 0.0, 1.0, 0.0, -1.0, Config.deadZoneSteering );

		define ( 4, 1, Input.AXIS_HANDBRAKE, KEYBOARD, Input.RCDIK_SPACE, 0.0, 1.0, 0.0, 1.0, 0.0 );
		define ( 5, 1, Input.AXIS_GEAR_UPDOWN, KEYBOARD, Input.RCDIK_A, 0.0, 200.0, 0.0, 200.0, 0.0 );
		define ( 6, 1, Input.AXIS_GEAR_UPDOWN, KEYBOARD, Input.RCDIK_Z, 0.0, 200.0, 0.0, -200.0, 0.0 );
		define ( 7, 1, Input.AXIS_CLUTCH, KEYBOARD, Input.RCDIK_C, 0.0, 200.0, 0.0, 200.0, Config.deadZoneClutch );
		define ( 8, 1, Input.AXIS_NITRO, KEYBOARD, Input.RCDIK_N, 0.0, 1.0, 0.0, 1.0, 0.0 );
		define ( 9, 1, Input.AXIS_HORN, KEYBOARD, Input.RCDIK_H, 0.0, 1.0, 0.0, 1.0, 0.0 );
		define (10, 0, Input.AXIS_MENU, KEYBOARD, Input.RCDIK_ESCAPE, 0.0, 1.0, 0.0, 1.0, 0.0 );
		define (11, 0, Input.AXIS_MUSIC_SELECT_NEXT, KEYBOARD, Input.RCDIK_PERIOD, 0.0, 1.0, 0.0, 1.0, 0.0 );
		define (12, 0, Input.AXIS_MUSIC_SELECT_PREV, KEYBOARD, Input.RCDIK_COMMA, 0.0, 1.0, 0.0, 1.0, 0.0 );
		define (13, 0, Input.AXIS_MUSIC_VOLUME_UP, KEYBOARD, Input.RCDIK_NUMPADSTAR, 0.0, 1.0, 0.0, 1.0, 0.0 );
		define (14, 0, Input.AXIS_MUSIC_VOLUME_DOWN, KEYBOARD, Input.RCDIK_NUMPADSLASH, 0.0, 1.0, 0.0, 1.0, 0.0 );

		/*define (15, 1, Input.AXIS_SPECIAL_1, KEYBOARD, Input.RCDIK_NUMPAD7, 0.0, 1.0, 0.0, 1.0, 0.0 );
		define (16, 1, Input.AXIS_SPECIAL_2, KEYBOARD, Input.RCDIK_NUMPAD8, 0.0, 1.0, 0.0, 1.0, 0.0 );
		define (17, 1, Input.AXIS_SPECIAL_3, KEYBOARD, Input.RCDIK_NUMPAD9, 0.0, 1.0, 0.0, 1.0, 0.0 );
		define (18, 1, Input.AXIS_SPECIAL_4, KEYBOARD, Input.RCDIK_NUMPAD4, 0.0, 1.0, 0.0, 1.0, 0.0 );
		define (19, 1, Input.AXIS_SPECIAL_5, KEYBOARD, Input.RCDIK_NUMPAD5, 0.0, 1.0, 0.0, 1.0, 0.0 );
		define (20, 1, Input.AXIS_SPECIAL_6, KEYBOARD, Input.RCDIK_NUMPAD6, 0.0, 1.0, 0.0, 1.0, 0.0 );
		define (21, 1, Input.AXIS_SPECIAL_7, KEYBOARD, Input.RCDIK_NUMPAD1, 0.0, 1.0, 0.0, 1.0, 0.0 );
		define (22, 1, Input.AXIS_SPECIAL_8, KEYBOARD, Input.RCDIK_NUMPAD2, 0.0, 1.0, 0.0, 1.0, 0.0 );
		define (23, 1, Input.AXIS_FIRE_PRI, KEYBOARD, Input.RCDIK_NUMPAD3, 0.0, 1.0, 0.0, 1.0, 0.0 );
		define (24, 1, Input.AXIS_FIRE_SEC, KEYBOARD, Input.RCDIK_NUMPAD0, 0.0, 1.0, 0.0, 1.0, 0.0 );*/

		// secondary controls
		// ezeket menubol at lehet definialni, fix helyen kell lenniuk (15..24)!!
		define (15, 1, Input.AXIS_THROTTLE, -1, -1, 0.0, 1.0, 0.0, 1.0, Config.deadZoneAccelerate );
		define (16, 1, Input.AXIS_BRAKE, -1, -1, 0.0, 1.0, 0.0, 1.0, Config.deadZoneBrake );
		define (17, 1, Input.AXIS_TURN_LEFTRIGHT, -1, -1, 0.0, 1.0, 0.0, 1.0, Config.deadZoneSteering );
		define (18, 1, Input.AXIS_TURN_LEFTRIGHT, -1, -1, 0.0, 1.0, 0.0, -1.0, Config.deadZoneSteering );

		define (19, 1, Input.AXIS_HANDBRAKE, -1, -1, 0.0, 1.0, 0.0, 1.0, 0.0 );
		define (20, 1, Input.AXIS_GEAR_UPDOWN, -1, -1, 0.0, 200.0, 0.0, 200.0, 0.0 );
		define (21, 1, Input.AXIS_GEAR_UPDOWN, -1, -1, 0.0, 200.0, 0.0, -200.0, 0.0 );
		define (22, 1, Input.AXIS_CLUTCH, -1, -1, 0.0, 200.0, 0.0, 200.0, Config.deadZoneClutch );
		define (23, 1, Input.AXIS_NITRO, -1, -1, 0.0, 1.0, 0.0, 1.0, 0.0 );
		define (24, 1, Input.AXIS_HORN, -1, -1, 0.0, 1.0, 0.0, 1.0, 0.0 );

		// other controls
		// ezeket nem lehet atdefinialni, tetszoleges sorrendben lehetnek
		define (25, 0, Input.AXIS_PRINTSCREEN, KEYBOARD, Input.RCDIK_F12, 0.0, 1.0, 0.0, 1.0, 0.0 );
		define (26, 0, Input.AXIS_SHIFT_LOOK, MOUSE, 4, 0.0, 1.0, 0.0, 1.0, 0.0 );			// right mouse button
		define (27, 0, Input.AXIS_MENU, KEYBOARD, Input.RCDIK_ESCAPE, 0.0, 1.0, 0.0, 1.0, 0.0 );
		define (28, 0, Input.AXIS_LOOK_FWDBACK, KEYBOARD, Input.RCDIK_PGUP, 0.0, 1.0, 0.0, -0.010, 0.0 );
		define (29, 0, Input.AXIS_LOOK_FWDBACK, KEYBOARD, Input.RCDIK_PGDN, 0.0, 1.0, 0.0, 0.010, 0.0 );
		define (30, 0, Input.AXIS_LOOK_FWDBACK, MOUSE, 2, -1.5, 1.5, 1.0, -1.0, 0.0 );	// wheel

		define (31, 0, Input.AXIS_CURSOR_BUTTON1, MOUSE, 3, 0.0, 1.0, 0.0, 1.0, 0.0 );
		define (32, 0, Input.AXIS_CURSOR_BUTTON2, MOUSE, 4, 0.0, 1.0, 0.0, 1.0, 0.0 );
		define (33, 0, Input.AXIS_CURSOR_X, MOUSE, 0, -1.0, 1.0, -1.0, 1.0, 0.0 );
		define (34, 0, Input.AXIS_CURSOR_Y, MOUSE, 1, -1.0, 1.0, -1.0, 1.0, 0.0 );

		define (35, 1, Input.AXIS_LOOK_PREVNEXT, KEYBOARD, Input.RCDIK_F1, 0.0, 1.0, 0.0, 1.0, 0.0 );
		define (36, 1, Input.AXIS_LOOK_PREVNEXT, KEYBOARD, Input.RCDIK_F2, 0.0, 1.0, 0.0, -1.0, 0.0 );
		define (37, 1, Input.AXIS_LOOK_REAR, KEYBOARD, Input.RCDIK_F5, 0.0, 1.0, 0.0, 1.0, 0.0 );

		//menu control group
		define (38, 2, Input.AXIS_SELECT, KEYBOARD, Input.RCDIK_ENTER, 0.0, 1.0, 0.0, 1.0, 0.0 );
		define (39, 2, Input.AXIS_SELECT, KEYBOARD, Input.RCDIK_NUMPADENTER, 0.0, 1.0, 0.0, 1.0, 0.0 );
		define (40, 2, Input.AXIS_SELECT, KEYBOARD, Input.RCDIK_SPACE, 0.0, 1.0, 0.0, 1.0, 0.0 );
		define (41, 2, Input.AXIS_CANCEL, KEYBOARD, Input.RCDIK_ESCAPE, 0.0, 1.0, 0.0, 1.0, 0.0 );
		define (42, 2, Input.AXIS_MENU_UP, KEYBOARD, Input.RCDIK_UP, 0.0, 1.0, 0.0, 1.0, 0.0 );
		define (43, 2, Input.AXIS_MENU_DOWN, KEYBOARD, Input.RCDIK_DOWN, 0.0, 1.0, 0.0, 1.0, 0.0);
		define (44, 2, Input.AXIS_MENU_LEFT, KEYBOARD, Input.RCDIK_LEFT, 0.0, 1.0, 0.0, 1.0, 0.0 );
		define (45, 2, Input.AXIS_MENU_RIGHT, KEYBOARD, Input.RCDIK_RIGHT, 0.0, 1.0, 0.0, 1.0, 0.0 );
		//define (46, 2, Input.AXIS_MENU_UP, MOUSE, 2, 0.0, 2.0, 0.0, 1.0, 0.0 );	// wheel
		//define (47, 2, Input.AXIS_MENU_DOWN, MOUSE, 2, -2.0, 0.0, 1.0, 0.0, 0.0 );	// wheel

		//look with keys (eg garage no menu)
		define (48, 3, Input.AXIS_LOOK_UPDOWN, KEYBOARD, Input.RCDIK_UP, 0.0, 1.0, 0.0, 0.003, 0.0 );
		define (49, 3, Input.AXIS_LOOK_UPDOWN, KEYBOARD, Input.RCDIK_DOWN, 0.0, 1.0, 0.0, -0.003, 0.0 );
		define (50, 3, Input.AXIS_LOOK_LEFTRIGHT, KEYBOARD, Input.RCDIK_LEFT, 0.0, 1.0, 0.0, 0.005, 0.0 );
		define (51, 3, Input.AXIS_LOOK_LEFTRIGHT, KEYBOARD, Input.RCDIK_RIGHT, 0.0, 1.0, 0.0,  -0.005, 0.0 );
		//define (52, 3, Input.AXIS_LOOK_FWDBACK, MOUSE, 2, -10.0, 10.0, 1.0, -1.0, 0.0 );	// wheel

		//move with keys (eg for shop)
		define (53, 4, Input.AXIS_MOVE_FWDBACK, KEYBOARD, Input.RCDIK_UP, 0.0, 1.0, 0.0, 1.0, 0.0 );
		define (54, 4, Input.AXIS_MOVE_FWDBACK, KEYBOARD, Input.RCDIK_DOWN, 0.0, 1.0, 0.0, -1.0, 0.0 );
		define (55, 4, Input.AXIS_MOVE_LEFTRIGHT, KEYBOARD, Input.RCDIK_LEFT, 0.0, 1.0, 0.0, 1.0, 0.0 );
		define (56, 4, Input.AXIS_MOVE_LEFTRIGHT, KEYBOARD, Input.RCDIK_RIGHT, 0.0, 1.0, 0.0, -1.0, 0.0 );
		//define (57, 4, Input.AXIS_LOOK_FWDBACK, MOUSE, 2, -10.0, 10.0, 1.0, -1.0, 0.0 );	// wheel

		//extras for freestyle camera
		define (57, 5, Input.AXIS_MOVE_FWDBACK, KEYBOARD, Input.RCDIK_A, 0.0, 1.0, 0.0, 1.0, 0.0 );
		define (58, 5, Input.AXIS_MOVE_FWDBACK, KEYBOARD, Input.RCDIK_Z, 0.0, 1.0, 0.0, -1.0, 0.0 );
		define (59, 5, Input.AXIS_MOVE_LEFTRIGHT, KEYBOARD, Input.RCDIK_LEFT, 0.0, 1.0, 0.0, 1.0, 0.0 );
		define (60, 5, Input.AXIS_MOVE_LEFTRIGHT, KEYBOARD, Input.RCDIK_RIGHT, 0.0, 1.0, 0.0, -1.0, 0.0 );
		define (61, 5, Input.AXIS_MOVE_UPDOWN, KEYBOARD, Input.RCDIK_UP, 0.0, 1.0, 0.0, 1.0, 0.0 );
		define (62, 5, Input.AXIS_MOVE_UPDOWN, KEYBOARD, Input.RCDIK_DOWN, 0.0, 1.0, 0.0, -1.0, 0.0 );
		define (63, 5, Input.AXIS_LOOK_ZOOM, KEYBOARD, Input.RCDIK_NUMPADPLUS, 0.0, 1.0, 0.0, -0.01, 0.0 );
		define (64, 5, Input.AXIS_LOOK_ZOOM, KEYBOARD, Input.RCDIK_NUMPADMINUS, 0.0, 1.0, 0.0, 0.01, 0.0 );

		define (65, 1, Input.AXIS_SPECIAL_1, KEYBOARD, Input.RCDIK_NUMPAD7, 0.0, 1.0, 0.0, 1.0, 0.0 );
		define (66, 1, Input.AXIS_SPECIAL_2, KEYBOARD, Input.RCDIK_NUMPAD8, 0.0, 1.0, 0.0, 1.0, 0.0 );
		define (67, 1, Input.AXIS_SPECIAL_3, KEYBOARD, Input.RCDIK_NUMPAD9, 0.0, 1.0, 0.0, 1.0, 0.0 );
		define (68, 1, Input.AXIS_SPECIAL_4, KEYBOARD, Input.RCDIK_NUMPAD4, 0.0, 1.0, 0.0, 1.0, 0.0 );
		define (69, 1, Input.AXIS_SPECIAL_5, KEYBOARD, Input.RCDIK_NUMPAD5, 0.0, 1.0, 0.0, 1.0, 0.0 );
		define (70, 1, Input.AXIS_SPECIAL_6, KEYBOARD, Input.RCDIK_NUMPAD6, 0.0, 1.0, 0.0, 1.0, 0.0 );
		define (71, 1, Input.AXIS_SPECIAL_7, KEYBOARD, Input.RCDIK_NUMPAD1, 0.0, 1.0, 0.0, 1.0, 0.0 );
		define (72, 1, Input.AXIS_SPECIAL_8, KEYBOARD, Input.RCDIK_NUMPAD2, 0.0, 1.0, 0.0, 1.0, 0.0 );
		define (73, 1, Input.AXIS_FIRE_PRI, KEYBOARD, Input.RCDIK_NUMPAD3, 0.0, 1.0, 0.0, 1.0, 0.0 );
		define (74, 1, Input.AXIS_FIRE_SEC, KEYBOARD, Input.RCDIK_NUMPAD0, 0.0, 1.0, 0.0, 1.0, 0.0 );

		define (75, 1, Input.AXIS_HELP, KEYBOARD, Input.RCDIK_S, 0.0, 1.0, 0.0, 1.0, 0.0 ); // Cruise control
		define (76, 1, Input.AXIS_LOOK_REAR, KEYBOARD, Input.RCDIK_B, 0.0, 1.0, 0.0, 1.0, 0.0 );
		define (77, 1, Input.AXIS_MAP, KEYBOARD, Input.RCDIK_M, 0.0, 1.0, 0.0, 1.0, 0.0 );

		define (78, 0, Input.AXIS_MENU, KEYBOARD, Input.RCDIK_ESCAPE, 0.0, 1.0, 0.0, 1.0, 0.0 );
	}

	// ps2 controller on pc
	public int ps2emu()
	{
		String	name;
		int		i, device = -1;

		i = 0;
		while( ( name = Input.getDeviceName( i ) ) != null )
		{
			if( name == "4 axis 16 button joystick" )
			{
				device = i;
				break;
			}
			i++;
		}

		if( device < 0 )
			return( -1 );

		// primary controls
		// ezeket menubol at lehet definialni, fix helyen kell lenniuk (0..14)!!	
		define ( 0, 1, Input.AXIS_THROTTLE, device, 2, 0.0, 1.0, 0.0, 1.0, Config.deadZoneAccelerate );
		define ( 1, 1, Input.AXIS_BRAKE, device, 2, 0.0, -1.0, 0.0, 1.0, Config.deadZoneBrake );
		define ( 2, 1, Input.AXIS_TURN_LEFTRIGHT, device, 1, 0.0, 1.0, 0.0, 1.0, Config.deadZoneSteering );
		define ( 3, 1, Input.AXIS_TURN_LEFTRIGHT, device, 1, 0.0, -1.0, 0.0, -1.0, Config.deadZoneSteering );

		define ( 4, 1, Input.AXIS_HANDBRAKE, device, 6, 0.0, 1.0, 0.0, 1.0, 0.0 );
		define ( 5, 1, Input.AXIS_GEAR_UPDOWN, device, 9, 0.0, 200.0, 0.0, 200.0, 0.0 );
		define ( 6, 1, Input.AXIS_GEAR_UPDOWN, device, 8, 0.0, 200.0, 0.0, -200.0, 0.0 );
		define ( 7, 1, Input.AXIS_CLUTCH, device, 10, 0.0, 200.0, 0.0, 200.0, Config.deadZoneClutch );
		define ( 8, 1, Input.AXIS_NITRO, device, 11, 0.0, 1.0, 0.0, 1.0, 0.0 );
		define ( 9, 1, Input.AXIS_HORN, device, 14, 0.0, 1.0, 0.0, 1.0, 0.0 );

		return( 0 );
	}
}



class	VirtualAxisSmoothProperties
{
	int		vAxisID;
	float	center_range;
	float	factor_center;
	float	factor_opposite;
	float	factor_same;
	float	power;

	public VirtualAxisSmoothProperties( int vID, float cr, float fc, float fo, float fs, float pow )
	{
		vAxisID = vID;
		center_range = cr;
		factor_center = fc;
		factor_opposite = fo;
		factor_same = fs;
		power = pow;
	}
	

	public VirtualAxisSmoothProperties( File saveFile )
	{
		read( saveFile );
	}

	public void write( File saveFile )
	{
		saveFile.write( vAxisID );

		saveFile.write( center_range );
		saveFile.write( factor_center );
		saveFile.write( factor_opposite );
		saveFile.write( factor_same );
		saveFile.write( power );
	}

	public void read( File saveFile )
	{
		vAxisID = saveFile.readInt();

		center_range = saveFile.readFloat();
		factor_center = saveFile.readFloat();
		factor_opposite = saveFile.readFloat();
		factor_same = saveFile.readFloat();
		power = saveFile.readFloat();
	}
}
