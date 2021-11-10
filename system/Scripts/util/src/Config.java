package java.util;

import java.render.*;
import java.io.*;
import java.util.*;
import java.util.resource.*;
import java.sound.*;
import java.lang.*;

public class Config extends GameType
{
	// option values
	final static int	SHIGH = 3;
	final static int	HIGH = 2;
	final static int	MID  = 1;
	final static int	LOW  = 0;
	final static int	OFF  = -1;

	//----------------------------------------------------------------------------------

	//version information:
	static	String		version = "v2.2.1";
	static	int			acceptBuild = 601;	//ennel kisebb build-szamu exe eseten hibat jelez!

	//main render settings:
	static int			video_windowed = 1;
	static int			video_x = 1280;
	static int			video_y = 720;
	static int			video_depth = 32;
	static float		video_gamma = 1.0;
	static int			SysCursor = 1;
	static int			Sound_3D_HW = 2;
	static int			Sound_Mix_HW = 2;

	//debug settings:
	static int          loadConfigEnabled = 1;  // load options sets from file
	static int			majomParade = 0;		// enables all cheat buttons, cheat keys, etc.

	//initial gametype to load (after Config.class)
	static	int			init = sl:0x0040r;

	//texture
	static int			texture_size = 1;
	static float		texture_save_quality = 1.0;
	static int			texture_format = 3;
	
	//shadow
	static int			shadow_size = 1024;		//2-es shadow settingsnel szamit 
	static float		shadow_detail = 0.125f; //2-es shadow settingsnel szamit
	static int			shadows = 2;			//0-nincs, 1-folt, 2-real time rendered

	static int			mirror = 0;
	static int			flares = 1;
	static int			headlight_rays = 1;
	static int			BgScene = 1;

	static  float		object_detail = 0.03;
	static  float		object_detail_amp = 13.0;

	static float		particle_density = 1.0;
	static int			skidmark_max = 1000;

	static float		trafficDensity = 0.2;
	static float		pedestrianDensity = 0.1;

	static int			mapFog = 1;
	static int			dayRacers = 1;
	static int			nightRacers = 1;
	static int			driverModel = 1;
	static int			tuneableDoors = 0;
	static int			invAutoScroll = 1;
	static int			invGridSize = 2;
	static int			catalogStyle = 1;
	static int			carCatalogColor = 0;
	static int			swaybarsMode = 2;

	//camera settings
	static float		cameras_viewrange = 2500.0;

	static float		camera_int_clipplane = 0.1;
	static float		camera_int_viewrange = 1250.0;

	static float		camera_ext_clipplane = 0.2;
	static float		camera_ext_viewrange = 2500.0;

	// mirror
	static float		camera_mirror_viewrange = 50;
	static  float		mirror_object_detail = 0.03;
	static  float		mirror_object_detail_amp = 13.0;

	//camera settings
	static float		camera_AOV = 55.0;
	static float		camera_torque = 0.02;
	static float		camera_force = 2.0;
	static float		camera_damping = 1.0;
	static float		camera_perpdamping = 0.7;
	static float		camera_max_force = 20.0;

	static float		camera_look_ahead = 0.0;
	static float		camera_go_behind = 0.0;
	static float		camera_go_above = 0.0;
	static float		camera_distance = 5.0;
	static float		camera_FOV = 1.25*0.5;

	static float		head_move_steer = 1.0;
	static float		head_move_vel = 1.0;
	static float		head_move_acc = 1.0;

	static int			camera_render = 0;
	static int			camera_nocollision = 0; //to make a playable framerate even at Comm.area


	static	int			metricSystem = 1;	//0-mile, 1-km
	static	int			gpsMode;

	//0:manual+autoclutch 1:auto+autclutch 2:manual+clutch [3:auto+clutch] 5:semiauto [7:semiauto+clutch]
	static int			player_transmission = 1;
	static float		player_steeringhelp = 0.0;
	static float		player_abs = 0.0;
	static float		player_asr = 0.0;
	static float		player_esp = 0.0;

	static float		deformation = 1.6; // deformation of car's parts
	static float		external_damage = 0.25; // damage parts when hit
	static float		internal_damage = 1.0; // damage parts wear

	static float		player_damage_multiplier = 0.8;
	static float		player_change_distance = 10.0;
	static float		player_change_velocity = 2.0;
	static int			player_display = 0x0; //0x0201; // FPS, position text
	static int			MouseHelp = 0; // Info about object hovering by coursor

	static	float		wheel_gndfeedback_factor= 7.0;
	static	float		wheel_brake_factor	= 6.0;
	static	float		engine_inertia_factor	= 6.0;

	static float		target_angle_weight = 0.5f;

	static float		controller_deadzone = 0.00f;
	static float		mouseSensitivity = 0.8f;                // 0.0 .. 1.0

	static int			ForceFeedBack = 1;
	static float		FFB_strength = 1.0f;
	static float		FFB_strength_emulated = 0.0333;

	//physics settings
	static float		gravity = 9.81;                 //normal earth gravity
	static float		ground_friction = 1.0;
	static int			ground_precache = 1;

	//resource settings
	static int			resource_refreshrate = 4096;//2048;
	static int			resource_loadrate = 1024;//512;

	static int			mem_vertex_max  = (4096*4096);
	static int			mem_vertex_min  = (2048*2048);
	static int			mem_texture_max = (4096*4096);
	static int			mem_texture_min = (2048*2048);
	static int			mem_instance_max= (12288);
	static int			mem_instance_min= (4096);
	static int			mem_sound_max = (1920*1920);
	static int			mem_sound_min = (1920*1920);


//	static int			mem_vertex_max  = (2048*2048);
//	static int			mem_vertex_min  = (2048*2048);
//	static int			mem_texture_max = (2048*2048);
//	static int			mem_texture_min = (2048*2048);
//	static int			mem_instance_max= (12288);
//	static int			mem_instance_min= (4096);
//	static int			mem_sound_max = (1920*1920);
//	static int			mem_sound_min = (1920*1920);

//	static int			mem_vertex_max  = (80*12288*12288);
//	static int			mem_vertex_min  = (16*8192*8192);
//	static int			mem_texture_max = (80*12288*12288);
//	static int			mem_texture_min = (40*8192*8192);
//	static int			mem_instance_max= (12288);
//	static int			mem_instance_min= (8192);
//	static int			mem_sound_max = (66*12288*12288);
//	static int			mem_sound_min = (12*8192*8192);

	//display arrows pointing to the opposition in multiplayer?
	static int			mp_arrows_on = 1; 

	static float		deadZoneAccelerate = 0.0;
	static float		deadZoneBrake = 0.0;
	static float		deadZoneSteering = 0.0;
	static float		deadZoneClutch = 0.0;

	static float		throttleSpeed = 0.0200f;
	static float		brakeSpeed =    0.0200f;
	static float		steerSpeed =    0.0100f;
	static float		steerhelp_turn = 1.0f;

	static float		throttlePower = 2.5f;
	static float		brakePower = 2.5f;
	static float		steeringPower = 1.5f;
	static float		clutchPower = 2.5f;

//-----------------------------------------------------------------------------------------

	final static int SAVEFILEID = 0xFEDCBA98;
	final static int SAVEFILEVERSION = 12;

	public Config( int id )
	{
		if( !loadConfig( "save/game/options" ) )
		{
			//variableless default settings
			Sound.setVolume( Sound.CHANNEL_EFFECTS, 0.75 );
			Sound.setVolume( Sound.CHANNEL_MUSIC,   0.50 );
			Sound.setVolume( Sound.CHANNEL_ENGINE,  0.75 );
		}
	}

	public void finalize()
	{
		saveConfig( "save/game/options" );
		super.finalize();
	}

	public int saveConfig( String filename )
	{
		File.delete( filename );

		File f = new File( filename );
		if( f.open( File.MODE_WRITE ) && loadConfigEnabled )
		{
			f.write( SAVEFILEID );
			f.write( SAVEFILEVERSION );

			f.write( video_windowed );
			f.write( video_x );
			f.write( video_y );
			f.write( video_depth );
			f.write( video_gamma );

			f.write( texture_size );

			f.write( shadow_size );
			f.write( shadow_detail );
			f.write( shadows );

			f.write( cameras_viewrange );
			f.write( camera_mirror_viewrange );

			f.write( mirror );
			f.write( flares );
			f.write( headlight_rays );
			f.write( BgScene );

			f.write( particle_density );
			f.write( skidmark_max );

			f.write( resource_refreshrate );
			f.write( resource_loadrate );

			f.write( object_detail );
			f.write( object_detail_amp );

			f.write( player_transmission );
			f.write( player_steeringhelp );
			f.write( player_asr );
			f.write( player_abs );

			f.write( player_damage_multiplier );
			f.write( deformation );
			f.write( internal_damage );

			f.write( trafficDensity );
			f.write( pedestrianDensity );

			f.write( mapFog );
			f.write( dayRacers );
			f.write( nightRacers );
			f.write( driverModel );
			f.write( tuneableDoors );
			f.write( invAutoScroll );
			f.write( invGridSize );
			f.write( catalogStyle );
			f.write( carCatalogColor );
			f.write( swaybarsMode );

			f.write( mouseSensitivity );

			f.write( Sound.getVolume( Sound.CHANNEL_EFFECTS ) );
			f.write( Sound.getVolume( Sound.CHANNEL_MUSIC  ) );
			f.write( Sound.getVolume( Sound.CHANNEL_ENGINE ) );

			f.write( metricSystem );
			f.write( gpsMode );

			f.write( FFB_strength );
			f.write( FFB_strength_emulated );

			f.write( ground_friction );

			f.write( Sound_3D_HW );
			f.write( Sound_Mix_HW );

			f.write( head_move_steer );
			f.write( head_move_vel );
			f.write( head_move_acc );

			f.close();
			return 1;
		}
		return 0;
	}

	public int loadConfig( String filename )
	{
		int	success;

		File f = new File( filename );
		if( loadConfigEnabled )
		{
			if( f.open( File.MODE_READ ) )
			{
				if( f.readInt() == SAVEFILEID )
				{
					if( f.readInt() == SAVEFILEVERSION )
					{
						video_windowed = f.readInt();
						video_x = f.readInt();
						video_y = f.readInt();
						video_depth = f.readInt();
						video_gamma = f.readFloat();

						texture_size = f.readInt();

						shadow_size = f.readInt();
						shadow_detail = f.readFloat();
						shadows = f.readInt();

						cameras_viewrange = f.readFloat();
						camera_ext_viewrange = cameras_viewrange;
						camera_int_viewrange = cameras_viewrange;
						camera_mirror_viewrange = f.readFloat();

						mirror = f.readInt();
						flares = f.readInt();
						headlight_rays = f.readInt();
						BgScene = f.readFloat();

						particle_density = f.readFloat();
						skidmark_max = f.readInt();

						resource_refreshrate = f.readInt();
						resource_loadrate = f.readInt();

						object_detail = f.readFloat();
						object_detail_amp = f.readFloat();

						player_transmission = f.readInt();
						player_steeringhelp = f.readFloat();
						player_asr = f.readFloat();
						player_abs = f.readFloat();

						player_damage_multiplier = f.readFloat();
						deformation = f.readFloat();
						internal_damage = f.readFloat();

						trafficDensity = f.readFloat();
						pedestrianDensity = f.readFloat();

						mapFog = f.readInt();
						dayRacers = f.readInt();
						nightRacers = f.readInt();
						driverModel = f.readInt();
						tuneableDoors = f.readInt();
						invAutoScroll = f.readInt();
						invGridSize = f.readInt();
						catalogStyle = f.readInt();
						carCatalogColor = f.readInt();
						swaybarsMode = f.readInt();

						mouseSensitivity = f.readFloat();

						Sound.setVolume( Sound.CHANNEL_EFFECTS, f.readFloat() );
						Sound.setVolume( Sound.CHANNEL_MUSIC,  f.readFloat() );
						Sound.setVolume( Sound.CHANNEL_ENGINE, f.readFloat() );

						metricSystem = f.readInt();
						gpsMode = f.readInt();

						FFB_strength = f.readFloat();
						FFB_strength_emulated = f.readFloat();

						ground_friction = f.readFloat();

						Sound_3D_HW = f.readInt();
						Sound_Mix_HW = f.readInt();

						head_move_steer = f.readFloat();
						head_move_vel = f.readFloat();
						head_move_acc = f.readFloat();

						success=1;
					}
				}
				f.close();
			}
		}

		if( metricSystem == 0 )
			System.setMeasure( 1600 );
		else
			System.setMeasure( 1000 );

		return success;
	}


	//cseles cucc..
	public	int	FILD = 1;
}


public class VideoMode
{
	float width, height;
	int	depth;
	int	windowed;

	public VideoMode( float w, float h, int d, int win )
	{
		width=w;
		height=h;
		depth=d;
		windowed=win;
	}
}
