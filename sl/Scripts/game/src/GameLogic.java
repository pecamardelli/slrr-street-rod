package java.game;

import java.io.*;
import java.util.*;
import java.util.resource.*;
import java.render.*;	//Text
import java.render.osd.*;	//Text
import java.render.osd.dialog.*;	//Text
import java.sound.*;

import java.game.*;
import java.game.parts.*;

public class GameLogic extends GameType implements Runnable
{
	final static ResourceRef VEHICLETYPE_ROOT = new ResourceRef( cars:0x1000r );
	final static ResourceRef CHASSIS_ROOT = new ResourceRef( cars:0x0101r );
	final static ResourceRef MAPS_ROOT = new ResourceRef( MW_Mod:0x0ABCr );

	//new career player settings
	final static int INITIAL_PLAYER_MONEY = 100000;
	final static float INITIAL_PLAYER_PRESTIGE = 0.3;			//player starts at 60th place (ie. lamest club/20th)  [range 0.0-1.0]

	//new carreer opponent settings (for all 3 clubs) [range 0.0-1.0]
	final static float INITIAL_OPPONENT_PRESTIGE_MIN = 0.3;	//initial prestige of the opponent at 59th place
	final static float INITIAL_OPPONENT_PRESTIGE_MAX = 0.9;	//initial prestige of the opponent at 1st place  
	final static float INITIAL_OPPONENT_PRESTIGE_RND = 0.03;	//rnd prestige factor for all the opponents
	//level of the bots driving capabilities  [range 0.0-1.0]
	final static float INITIAL_OPPONENT_AI_MIN = 0.51;
	final static float INITIAL_OPPONENT_AI_MAX = 1.0;
	final static float INITIAL_OPPONENT_AI_RND = 0.0;
	//level of their cars power and tuning [range 0.0-1.0]
	final static float INITIAL_OPPONENT_VHC_MIN = 0.0;
	final static float INITIAL_OPPONENT_VHC_MAX = 0.9;
	final static float INITIAL_OPPONENT_VHC_RND = 0.3;
	//level of their cars power and tuning at the night races [range 0.0-1.0]
	final static float INITIAL_OPPONENT_NIGHT_VHC_MIN = 0.0;
	final static float INITIAL_OPPONENT_NIGHT_VHC_MAX = 1.2;
	final static float INITIAL_OPPONENT_NIGHT_VHC_RND = 0.1;

	//NIGHT RACE

	//ROC_VHC = 1.0

	final static int SAVEFILEID_MAIN = 0x87654321;
	final static int SAVEFILEVERSION_MAIN = 21;
	final static int SAVEFILEVERSION_MAIN_LOAD = 20;

	final public static int SFX_ENTERGARAGE	= frontend:0x007Dr;
	final public static int SFX_LEAVEGARAGE	= frontend:0x007Cr;
	final public static int SFX_WRENCH		= frontend:0x007Br;
	final public static int SFX_HORN		= sound:0x0015r;
	final public static int SFX_DECAL		= frontend:0x009Er;
	final public static int SFX_SPRAY		= frontend:0x009Cr;
	final public static int SFX_DRAGDROP	= frontend:0x009Dr;

	/*final*/ public static int HUMAN_SMILEY	= humans:0x00000009r;
	/*final*/ public static int HUMAN_OPPONENT	= humans:0x00000007r;
	/*final*/ public static int HUMAN_OPPONENT2	= humans:0x00000008r;		
	/*final*/ public static int HUMAN_PLAYER	= humans:0x0000000Cr;		
	/*final*/ public static int HUMAN_POLICEMAN = humans:0x00000018r;		

	static int colorNumber = 0;
	final static int RID_CARCOLOR_Baiern_Devils_eye_red		= colorNumber++; // cars:0x0000002Ar;
	final static int RID_CARCOLOR_Baiern_Spring_yellow		= colorNumber++; // cars:0x0000002Br;

	final static int RID_CARCOLOR_Einvagen_Zucker         = colorNumber++; // cars:0x00000042r;
	final static int RID_CARCOLOR_Einvagen_Tornado_rot    = colorNumber++; // cars:0x00000043r;
	final static int RID_CARCOLOR_Einvagen_Nacht          = colorNumber++; // cars:0x00000044r;
	final static int RID_CARCOLOR_Einvagen_Smaragd        = colorNumber++; // cars:0x00000045r;
	final static int RID_CARCOLOR_Einvagen_Black_mage     = colorNumber++; // cars:0x00000046r;
	final static int RID_CARCOLOR_Einvagen_Hamvas_Grun    = colorNumber++; // cars:0x00000047r;
	final static int RID_CARCOLOR_Einvagen_Indigo         = colorNumber++; // cars:0x00000048r;
	final static int RID_CARCOLOR_Einvagen_Jazz           = colorNumber++; // cars:0x00000049r;
	final static int RID_CARCOLOR_Einvagen_Antracit       = colorNumber++; // cars:0x0000004Ar;
	final static int RID_CARCOLOR_Einvagen_Mercator_Blau  = colorNumber++; // cars:0x0000004Br;
	final static int RID_CARCOLOR_Einvagen_Murano         = colorNumber++; // cars:0x0000004Cr;
	final static int RID_CARCOLOR_Einvagen_Champagner     = colorNumber++; // cars:0x0000004Dr;
	final static int RID_CARCOLOR_Einvagen_Ozean          = colorNumber++; // cars:0x0000004Er;
	final static int RID_CARCOLOR_Einvagen_Reflex         = colorNumber++; // cars:0x0000004Fr;
	final static int RID_CARCOLOR_Einvagen_Saratoga       = colorNumber++; // cars:0x00000050r;

	final static int RID_CARCOLOR_Used_Rusty_Cherry       = colorNumber++;
	final static int RID_CARCOLOR_Used_Rusty_Smaragd      = colorNumber++;
	final static int RID_CARCOLOR_Used_Rusty_Nacht	      = colorNumber++;
	final static int RID_CARCOLOR_Used_Rusty_Zucker       = colorNumber++;

	final static int CHEVROLET_CLASSIC_WHITE		= colorNumber++;
	final static int CHEVROLET_CORTEZ_SILVER		= colorNumber++;
	final static int CHEVROLET_LAGUNA_GRAY			= colorNumber++;
	final static int CHEVROLET_SHADOW_GRAY			= colorNumber++;
	final static int CHEVROLET_ASTRO_BLUE			= colorNumber++;
	final static int CHEVROLET_MULSANNE_BLUE		= colorNumber++;
	final static int CHEVROLET_BRIDGEHAMPTON_BLUE	= colorNumber++;
	final static int CHEVROLET_FATHOM_BLUE			= colorNumber++;
	final static int CHEVROLET_MISTY_TURQUOISE		= colorNumber++;
	final static int CHEVROLET_CITRUS_GREEN			= colorNumber++;
	final static int CHEVROLET_DONNYBROOK_GREEN		= colorNumber++;
	final static int CHEVROLET_GREEN_MIST			= colorNumber++;
	final static int CHEVROLET_FOREST_GREEN			= colorNumber++;
	final static int CHEVROLET_GOBI_BEIGE			= colorNumber++;
	final static int CHEVROLET_DAYTONA_YELLOW		= colorNumber++;
	final static int CHEVROLET_CAMARO_GOLD			= colorNumber++;
	final static int CHEVROLET_CHAMPAGNE_GOLD		= colorNumber++;
	final static int CHEVROLET_AUTUMN_GOLD			= colorNumber++;
	final static int CHEVROLET_CARAMEL_BRONZE		= colorNumber++;
	final static int CHEVROLET_DESERT_SAND			= colorNumber++;
	final static int CHEVROLET_CLASSIC_COPPER		= colorNumber++;
	final static int CHEVROLET_MONZA_RED			= colorNumber++;
	final static int CHEVROLET_CRANBERRY_RED		= colorNumber++;
	final static int CHEVROLET_MARLBORO_MAROON		= colorNumber++;
	final static int CHEVROLET_BLACK_CHERRY			= colorNumber++;
	final static int CHEVROLET_TUXEDO_BLACK			= colorNumber++;
	final static int CHEVROLET_GROTTO_BLUE			= colorNumber++;
	final static int CHEVROLET_ISLAND_TEAL			= colorNumber++;
	final static int CHEVROLET_ASH_GOLD				= colorNumber++;
	final static int CHEVROLET_GRECIAN_GREEN		= colorNumber++;
	final static int CHEVROLET_RALLYE_GREEN			= colorNumber++;
	final static int CHEVROLET_TRIPOLI_TURQUOISE	= colorNumber++;
	final static int CHEVROLET_TEAL_BLUE			= colorNumber++;
	final static int CHEVROLET_CORDOVAN_MAROON		= colorNumber++;
	final static int CHEVROLET_CORVETTE_BRONZE		= colorNumber++;
	final static int CHEVROLET_SEAFROST_GREEN		= colorNumber++;
	final static int CHEVROLET_MATADOR_RED			= colorNumber++;
	final static int CHEVROLET_PALOMINO_IVORY		= colorNumber++;
	final static int CHEVROLET_LE_MANS_BLUE			= colorNumber++;
	final static int CHEVROLET_SEQUOIA_GREEN		= colorNumber++;
	final static int CHEVROLET_BUTTERNUT_YELLOW		= colorNumber++;
	final static int CHEVROLET_BRITISH_GREEN		= colorNumber++;
	final static int CHEVROLET_ERMINE_WHITE			= colorNumber++;
	final static int CHEVROLET_RALLY_RED			= colorNumber++;
	final static int CHEVROLET_TAHOE_TURQUOISE_IRIDESCENT	= colorNumber++;
	final static int CHEVROLET_NANTUCKET_BLUE_IRIDESCENT	= colorNumber++;
	final static int CHEVROLET_ROYAL_PLUM_IRIDESCENT		= colorNumber++;
	final static int CHEVROLET_LYNNDALE_BLUE_IRIDESCENT		= colorNumber++;
	final static int CHEVROLET_DEEPWATER_BLUE_IRIDESCENT	= colorNumber++;
	final static int CHEVROLET_MADEIRA_MAROON_IRIDESCENT	= colorNumber++;
	final static int CHEVROLET_ELKHART_BLUE_IRIDESCENT		= colorNumber++;
	final static int CHEVROLET_MARINA_BLUE_IRIDESCENT		= colorNumber++;
	final static int CHEVROLET_BOLERO_RED					= colorNumber++;
	final static int CHEVROLET_GOODWOOD_GREEN_IRIDESCENT	= colorNumber++;
	final static int CHEVROLET_GRANADA_GOLD_IRIDESCENT		= colorNumber++;
	final static int CHEVROLET_SIERRA_FAWN_IRIDESCENT		= colorNumber++;
	final static int CHEVROLET_SUNFIRE_YELLOW				= colorNumber++;
	final static int CHEVROLET_MOUNTAIN_GREEN_IRIDESCENT	= colorNumber++;
	final static int CHEVROLET_CAPRI_CREAM					= colorNumber++;
	final static int CHEVROLET_SILVER_PEARL_IRIDESCENT		= colorNumber++;
	final static int CHEVROLET_EMERALD_TURQUOISE_IRIDESCENT	= colorNumber++;

	final static int MERCURY_FAWN					= colorNumber++;
	final static int MERCURY_CARNIVAL_RED			= colorNumber++;
	final static int MERCURY_PEACOCK				= colorNumber++;
	final static int MERCURY_PINK_FROST				= colorNumber++;
	final static int MERCURY_ANNIVERSARY_SILVER_IRIDESCENT	= colorNumber++;
	final static int MERCURY_SILVER_TURQUOISE_IRIDESCENT	= colorNumber++;
	final static int MERCURY_BURGUNDY_IRIDESCENT			= colorNumber++;
	final static int MERCURY_BITTERSWEET					= colorNumber++;
	final static int MERCURY_PACIFIC_BLUE_IRIDESCENT		= colorNumber++;
	final static int MERCURY_GLACIER_BLUE					= colorNumber++;
	final static int MERCURY_POLAR_WHITE					= colorNumber++;
	final static int MERCURY_PALOMINO						= colorNumber++;
	final static int MERCURY_PLATINUM_BEIGE_IRIDESCENT		= colorNumber++;
	final static int MERCURY_YELLOW_MIST					= colorNumber++;
	final static int MERCURY_AZTEC_GOLD						= colorNumber++;

	final static int DODGE_TURQUOISE			= colorNumber++;
	final static int DODGE_DARK_TURQUOISE		= colorNumber++;
	final static int DODGE_LIGHT_BLUE			= colorNumber++;
	final static int DODGE_IVORY				= colorNumber++;
	final static int DODGE_MEDIUM_BLUE			= colorNumber++;
	final static int DODGE_STEEL_GRAY			= colorNumber++;
	final static int DODGE_DARK_BLUE			= colorNumber++;
	final static int DODGE_VERMILION			= colorNumber++;
	final static int DODGE_LIGHT_GREEN			= colorNumber++;
	final static int DODGE_POLAR				= colorNumber++;
	final static int DODGE_FOREST_GREEN			= colorNumber++;
	final static int DODGE_BEIGE				= colorNumber++;
	final static int DODGE_AQUA					= colorNumber++;
	final static int DODGE_SANDALWOOD			= colorNumber++;
	final static int DODGE_SLATE_TURQUOISE		= colorNumber++;
	final static int DODGE_CORDOVAN				= colorNumber++;
	final static int DODGE_SILVER_IRIDESCENT	= colorNumber++;
	final static int DODGE_DARK_GREEN			= colorNumber++;
	final static int DODGE_BRIGHT_RED			= colorNumber++;
	final static int DODGE_RED_IRIDESCENT		= colorNumber++;
	final static int DODGE_YELLOW				= colorNumber++;
	final static int DODGE_CREAM				= colorNumber++;
	final static int DODGE_WHITE				= colorNumber++;
	final static int DODGE_BRONZE_IRIDESCENT	= colorNumber++;
	final static int DODGE_GOLD_IRIDESCENT		= colorNumber++;
	final static int DODGE_SANDSTONE_IRIDESCENT	= colorNumber++;
	final static int DODGE_MAUVE_IRIDESCENT		= colorNumber++;
	final static int DODGE_MAROON_IRIDESCENT	= colorNumber++;

	final static int PLYMOUTH_SILVER			= colorNumber++;
	final static int PLYMOUTH_ICE_BLUE			= colorNumber++;
	final static int PLYMOUTH_BLUE_FIRE			= colorNumber++;
	final static int PLYMOUTH_JAMAICA_BLUE		= colorNumber++;
	final static int PLYMOUTH_FROST_GREEN		= colorNumber++;
	final static int PLYMOUTH_LIMELIGHT			= colorNumber++;
	final static int PLYMOUTH_IVY_GREEN			= colorNumber++;
	final static int PLYMOUTH_SAND_PEBBLE_BEIGE	= colorNumber++;
	final static int PLYMOUTH_SEAFOAM_TURQUOISE	= colorNumber++;
	final static int PLYMOUTH_BARRACUDA_ORANGE	= colorNumber++;
	final static int PLYMOUTH_SCORCH_RED		= colorNumber++;
	final static int PLYMOUTH_HONEY_BRONZE		= colorNumber++;
	final static int PLYMOUTH_BRONZE_FIRE		= colorNumber++;
	final static int PLYMOUTH_SADDLE_BRONZE		= colorNumber++;
	final static int PLYMOUTH_ALPINE_WHITE		= colorNumber++;
	final static int PLYMOUTH_BLACK_VELVET		= colorNumber++;
	final static int PLYMOUTH_SUNFIRE_YELLOW	= colorNumber++;
	final static int PLYMOUTH_YELLOW_GOLD		= colorNumber++;
	final static int PLYMOUTH_SPANISH_GOLD		= colorNumber++;
	final static int PLYMOUTH_CITRON_GOLD		= colorNumber++;
	final static int PLYMOUTH_BAHAMA_YELLOW		= colorNumber++;
	final static int PLYMOUTH_ORANGE			= colorNumber++;
	final static int PLYMOUTH_RALLYE_GREEN		= colorNumber++;
	final static int PLYMOUTH_VITAMIN_C			= colorNumber++;

	final static int FORD_FOLKESTONE_GRAY		= colorNumber++;
	final static int FORD_YOSEMITE_GREEN		= colorNumber++;
	final static int FORD_CLOUD_MIST_GRAY		= colorNumber++;
	final static int FORD_ACADIA_GREEN			= colorNumber++;
	final static int FORD_MANDARIN_MAROON		= colorNumber++;
	final static int FORD_GARNET_MAROON			= colorNumber++;
	final static int FORD_SAHARA_TAN			= colorNumber++;
	final static int FORD_COSTWOLD_GRAY			= colorNumber++;
	final static int FORD_COMO_BLUE				= colorNumber++;
	final static int FORD_CIGARETTE_CREAM		= colorNumber++;
	final static int FORD_LYON_BLUE				= colorNumber++;
	final static int FORD_ROYAL_MAROON			= colorNumber++;
	final static int FORD_HIGHLAND_GREEN		= colorNumber++;
	final static int FORD_ACAPULCO_BLUE			= colorNumber++;
	final static int FORD_CANDYAPPLE_RED		= colorNumber++;
	final static int FORD_GULFSTREAM_AQUA		= colorNumber++;
	final static int FORD_TAHOE_TURQUOISE		= colorNumber++;
	final static int FORD_LIME_GOLD				= colorNumber++;
	final static int FORD_MEADOWLARK_YELLOW		= colorNumber++;
	final static int FORD_WIMBLEDON_WHITE		= colorNumber++;
	final static int FORD_PRESIDENTIAL_BLUE		= colorNumber++;
	final static int FORD_DIAMOND_BLUE			= colorNumber++;
	final static int FORD_SUNLIT_GOLD			= colorNumber++;
	final static int FORD_SEAFOAM_GREEN			= colorNumber++;
	final static int FORD_PEBBLE_BEIGE			= colorNumber++;
	final static int FORD_BRITTANY_BLUE			= colorNumber++;


	public static int[] CARCOLORS = new int[colorNumber];

	final static String	carrerSaveDir = "save/carrer/";
	final static String	tempSaveDir = "save/temp/";
	final static String	carSaveDir = "save/cars/";
	final static String	skinSaveDir = "save/skins/";
	final static String	controlSaveDir = "save/controls/";
	final static String	activeControlFile; //= controlSaveDir + "active_control_set";

	final static int ROC_ENTRYFEE  = 100000;
	 

	final static int		CLUBS = 3;
	final static int		CLUBMEMBERS = 20;

	final static String[]	CLUBNAMES = new String[CLUBS];

	final static int GM_INVALID		= 0;
	final static int GM_CARREER		= 1;
	final static int GM_FREERIDE	= 2;
	final static int GM_QUICKRACE	= 3;
	final static int GM_SINGLECAR	= 4;
	final static int GM_DEMO		= 5;
	final static int GM_MULTIPLAYER	= 6;

	static int				gameMode;
	static int				timeout;

	static int				klampiPatch;	//continous races, cam set on the bot
	static int				played, saved;
	static int				carrerInProgress;

	static	String[]		kismajom;

	static	VehicleType[]	vehicleTypes;

	//carmarkets' state
	static	VehicleDescriptor[] carDescriptors_New;
	static	VehicleDescriptor[] carDescriptors_Used;

	static	float			dealerVisitTimeStamp_New;	//in hours
	static	float			dealerVisitTimeStamp_Used;


	static	Hotkey			hotkey0, hotkey1, hotkey2, hotkey3, hotkey4;

	// states //
	static	GameState		actualState;

	static	Garage			garage;
	static	RaceSetup		racesetup;

	//players
	static	int				numplayers=2;
	static	GameRef[]		controllers;
	ControlSet				controlSet2;

	static	Player			player, player2;

	static	Racer[]			speedymen = new Racer[CLUBS*CLUBMEMBERS];

	static	int				day;	
	static	float			time;	//sec
	static	float			timeFactor = 4.0;	//default 4x game time
	static	int				timeRefreshRate = 10;
	static	Text			timeTxt, dayTxt;
	static	Thread			timeRefresher;



	final static int		MotionB=0;	//motion blur
	final static int		cheats;// enable cheeaats buttons etc.
	final static ResourceRef[] ChassisRoot, MapRoot;
	final static Vector		MapBox, ChassisBox, DefaultSkinBox, PoliceManSkinBox;
	final static int[]		ChassisResNoumber;

	//Instance methods---------------------------------------------------------------------------//
	//------------------------------------------------------------------------------------------//
	public GameLogic()
	{
		createNativeInstance();

		//at this point, the system global loadingscreen is already displayed
		//we only have to turn it off when the game specific startup process finished

		//patch...
		activeControlFile = Controller.controlFile;

		//these should be statics:
		CLUBNAMES[0]="Green Slip";
		CLUBNAMES[1]="Blue Cheetah";
		CLUBNAMES[2]="Red Flame";

		CARCOLORS[RID_CARCOLOR_Baiern_Devils_eye_red]	  = cars:0x0000002Ar;
		CARCOLORS[RID_CARCOLOR_Baiern_Spring_yellow]	  = cars:0x0000002Br;

		CARCOLORS[RID_CARCOLOR_Einvagen_Zucker]         = cars:0x00000042r;
		CARCOLORS[RID_CARCOLOR_Einvagen_Tornado_rot]    = cars:0x00000043r;
		CARCOLORS[RID_CARCOLOR_Einvagen_Nacht]          = cars:0x00000044r;
		CARCOLORS[RID_CARCOLOR_Einvagen_Smaragd]        = cars:0x00000045r;
		CARCOLORS[RID_CARCOLOR_Einvagen_Black_mage]     = cars:0x00000046r;
		CARCOLORS[RID_CARCOLOR_Einvagen_Hamvas_Grun]    = cars:0x00000047r;
		CARCOLORS[RID_CARCOLOR_Einvagen_Indigo]         = cars:0x00000048r;
		CARCOLORS[RID_CARCOLOR_Einvagen_Jazz]           = cars:0x00000049r;
		CARCOLORS[RID_CARCOLOR_Einvagen_Antracit]       = cars:0x0000004Ar;
		CARCOLORS[RID_CARCOLOR_Einvagen_Mercator_Blau]  = cars:0x0000004Br;
		CARCOLORS[RID_CARCOLOR_Einvagen_Murano]         = cars:0x0000004Cr;
		CARCOLORS[RID_CARCOLOR_Einvagen_Champagner]     = cars:0x0000004Dr;
		CARCOLORS[RID_CARCOLOR_Einvagen_Ozean]          = cars:0x0000004Er;
		CARCOLORS[RID_CARCOLOR_Einvagen_Reflex]         = cars:0x0000004Fr;
		CARCOLORS[RID_CARCOLOR_Einvagen_Saratoga]       = cars:0x00000050r;

		CARCOLORS[RID_CARCOLOR_Used_Rusty_Cherry]		= cars:0x00000065r;
		CARCOLORS[RID_CARCOLOR_Used_Rusty_Smaragd]      = cars:0x00000066r;
		CARCOLORS[RID_CARCOLOR_Used_Rusty_Nacht]        = cars:0x00000067r;
		CARCOLORS[RID_CARCOLOR_Used_Rusty_Zucker]       = cars:0x00000068r;

		CARCOLORS[CHEVROLET_CLASSIC_WHITE]		        = cars:0x00000A2Ar;
		CARCOLORS[CHEVROLET_CORTEZ_SILVER]		  	 	= cars:0x00000A2Br;
		CARCOLORS[CHEVROLET_LAGUNA_GRAY]		  	 	= cars:0x00000A2Cr;
		CARCOLORS[CHEVROLET_SHADOW_GRAY]		  	 	= cars:0x00000A2Dr;
		CARCOLORS[CHEVROLET_ASTRO_BLUE]			  	 	= cars:0x00000A2Er;
		CARCOLORS[CHEVROLET_MULSANNE_BLUE]		  	 	= cars:0x00000A2Fr;
		CARCOLORS[CHEVROLET_BRIDGEHAMPTON_BLUE]	  	 	= cars:0x00000A30r;
		CARCOLORS[CHEVROLET_FATHOM_BLUE]	  	 		= cars:0x00000A31r;
		CARCOLORS[CHEVROLET_MISTY_TURQUOISE]  	 		= cars:0x00000A32r;
		CARCOLORS[CHEVROLET_CITRUS_GREEN] 	 	 		= cars:0x00000A33r;
		CARCOLORS[CHEVROLET_DONNYBROOK_GREEN]	 	 	= cars:0x00000A34r;
		CARCOLORS[CHEVROLET_GREEN_MIST]			 	 	= cars:0x00000A35r;
		CARCOLORS[CHEVROLET_FOREST_GREEN]		 	 	= cars:0x00000A36r;
		CARCOLORS[CHEVROLET_GOBI_BEIGE]			 	 	= cars:0x00000A37r;
		CARCOLORS[CHEVROLET_DAYTONA_YELLOW]		 	 	= cars:0x00000A38r;
		CARCOLORS[CHEVROLET_CAMARO_GOLD]		 	 	= cars:0x00000A39r;
		CARCOLORS[CHEVROLET_CHAMPAGNE_GOLD]		 	 	= cars:0x00000A3Ar;
		CARCOLORS[CHEVROLET_AUTUMN_GOLD]		 	 	= cars:0x00000A3Br;
		CARCOLORS[CHEVROLET_CARAMEL_BRONZE]		 	 	= cars:0x00000A3Cr;
		CARCOLORS[CHEVROLET_DESERT_SAND]		 	 	= cars:0x00000A3Dr;
		CARCOLORS[CHEVROLET_CLASSIC_COPPER]		 	 	= cars:0x00000A3Er;
		CARCOLORS[CHEVROLET_MONZA_RED]		 		 	= cars:0x00000A3Fr;
		CARCOLORS[CHEVROLET_CRANBERRY_RED]	 		 	= cars:0x00000A40r;
		CARCOLORS[CHEVROLET_MARLBORO_MAROON] 		 	= cars:0x00000A41r;
		CARCOLORS[CHEVROLET_BLACK_CHERRY]	 		 	= cars:0x00000A42r;
		CARCOLORS[CHEVROLET_TUXEDO_BLACK]	 		 	= cars:0x00000A43r;
		CARCOLORS[CHEVROLET_GROTTO_BLUE]	 		 	= cars:0x00000A7Er;
		CARCOLORS[CHEVROLET_ISLAND_TEAL]	 		 	= cars:0x00000A7Fr;
		CARCOLORS[CHEVROLET_ASH_GOLD]		 		 	= cars:0x00000A80r;
		CARCOLORS[CHEVROLET_GRECIAN_GREEN]			 	= cars:0x00000A81r;
		CARCOLORS[CHEVROLET_RALLYE_GREEN]			 	= cars:0x00000A82r;
		CARCOLORS[CHEVROLET_TRIPOLI_TURQUOISE]		 	= cars:0x00000A83r;
		CARCOLORS[CHEVROLET_TEAL_BLUE]				 	= cars:0x00000A84r;
		CARCOLORS[CHEVROLET_CORDOVAN_MAROON]		 	= cars:0x00000A85r;
		CARCOLORS[CHEVROLET_CORVETTE_BRONZE]		 	= cars:0x00000A86r;
		CARCOLORS[CHEVROLET_SEAFROST_GREEN]			 	= cars:0x00000A87r;
		CARCOLORS[CHEVROLET_MATADOR_RED]			 	= cars:0x00000A88r;
		CARCOLORS[CHEVROLET_PALOMINO_IVORY]			 	= cars:0x00000A89r;
		CARCOLORS[CHEVROLET_LE_MANS_BLUE]			 	= cars:0x00000A8Ar;
		CARCOLORS[CHEVROLET_SEQUOIA_GREEN]			 	= cars:0x00000A8Br;
		CARCOLORS[CHEVROLET_BUTTERNUT_YELLOW]		 	= cars:0x00000A8Cr;
		CARCOLORS[CHEVROLET_BRITISH_GREEN]			 	= cars:0x00000A8Dr;
		CARCOLORS[CHEVROLET_ERMINE_WHITE]			 	= cars:0x00000A96r;
		CARCOLORS[CHEVROLET_TAHOE_TURQUOISE_IRIDESCENT] 	= cars:0x00000A97r;
		CARCOLORS[CHEVROLET_RALLY_RED] 						= cars:0x00000A98r;
		CARCOLORS[CHEVROLET_NANTUCKET_BLUE_IRIDESCENT]		= cars:0x00000A99r;
		CARCOLORS[CHEVROLET_ROYAL_PLUM_IRIDESCENT]			= cars:0x00000A9Ar;
		CARCOLORS[CHEVROLET_LYNNDALE_BLUE_IRIDESCENT]		= cars:0x00000A9Br;
		CARCOLORS[CHEVROLET_DEEPWATER_BLUE_IRIDESCENT]		= cars:0x00000A9Cr;
		CARCOLORS[CHEVROLET_MADEIRA_MAROON_IRIDESCENT]		= cars:0x00000A9Dr;
		CARCOLORS[CHEVROLET_ELKHART_BLUE_IRIDESCENT]		= cars:0x00000A9Er;
		CARCOLORS[CHEVROLET_MARINA_BLUE_IRIDESCENT]			= cars:0x00000A9Fr;
		CARCOLORS[CHEVROLET_BOLERO_RED]						= cars:0x00000AA0r;
		CARCOLORS[CHEVROLET_GOODWOOD_GREEN_IRIDESCENT]		= cars:0x00000AA1r;
		CARCOLORS[CHEVROLET_GRANADA_GOLD_IRIDESCENT]		= cars:0x00000AA2r;
		CARCOLORS[CHEVROLET_SIERRA_FAWN_IRIDESCENT]			= cars:0x00000AA3r;
		CARCOLORS[CHEVROLET_SUNFIRE_YELLOW]					= cars:0x00000AA4r;
		CARCOLORS[CHEVROLET_MOUNTAIN_GREEN_IRIDESCENT]		= cars:0x00000AA5r;
		CARCOLORS[CHEVROLET_CAPRI_CREAM]					= cars:0x00000AA6r;
		CARCOLORS[CHEVROLET_SILVER_PEARL_IRIDESCENT]		= cars:0x00000AA7r;
		CARCOLORS[CHEVROLET_EMERALD_TURQUOISE_IRIDESCENT]	= cars:0x00000AA8r;

		CARCOLORS[MERCURY_FAWN]				 		 	= cars:0x00000A45r;
		CARCOLORS[MERCURY_CARNIVAL_RED]				 	= cars:0x00000A46r;
		CARCOLORS[MERCURY_PEACOCK]					 	= cars:0x00000A47r;
		CARCOLORS[MERCURY_PINK_FROST]				 	= cars:0x00000A48r;
		CARCOLORS[MERCURY_ANNIVERSARY_SILVER_IRIDESCENT]	= cars:0x00000A49r;
		CARCOLORS[MERCURY_SILVER_TURQUOISE_IRIDESCENT]		= cars:0x00000A4Ar;
		CARCOLORS[MERCURY_BURGUNDY_IRIDESCENT]				= cars:0x00000A4Br;
		CARCOLORS[MERCURY_BITTERSWEET]					= cars:0x00000A4Cr;
		CARCOLORS[MERCURY_PACIFIC_BLUE_IRIDESCENT]		= cars:0x00000A4Dr;
		CARCOLORS[MERCURY_GLACIER_BLUE]					= cars:0x00000A4Er;
		CARCOLORS[MERCURY_POLAR_WHITE]					= cars:0x00000A4Fr;
		CARCOLORS[MERCURY_PALOMINO]						= cars:0x00000A50r;
		CARCOLORS[MERCURY_PLATINUM_BEIGE_IRIDESCENT]	= cars:0x00000A51r;
		CARCOLORS[MERCURY_YELLOW_MIST]					= cars:0x00000A52r;
		CARCOLORS[MERCURY_AZTEC_GOLD]					= cars:0x00000A53r;

		CARCOLORS[DODGE_TURQUOISE]					= cars:0x00000A55r;
		CARCOLORS[DODGE_DARK_TURQUOISE]				= cars:0x00000A56r;
		CARCOLORS[DODGE_LIGHT_BLUE]					= cars:0x00000A57r;
		CARCOLORS[DODGE_IVORY]						= cars:0x00000A58r;
		CARCOLORS[DODGE_MEDIUM_BLUE]				= cars:0x00000A59r;
		CARCOLORS[DODGE_STEEL_GRAY]					= cars:0x00000A5Ar;
		CARCOLORS[DODGE_DARK_BLUE]					= cars:0x00000A5Br;
		CARCOLORS[DODGE_VERMILION]					= cars:0x00000A5Cr;
		CARCOLORS[DODGE_LIGHT_GREEN]				= cars:0x00000A5Dr;
		CARCOLORS[DODGE_POLAR]						= cars:0x00000A5Er;
		CARCOLORS[DODGE_FOREST_GREEN]				= cars:0x00000A5Fr;
		CARCOLORS[DODGE_BEIGE]						= cars:0x00000A60r;
		CARCOLORS[DODGE_AQUA]						= cars:0x00000A61r;
		CARCOLORS[DODGE_SANDALWOOD]					= cars:0x00000A62r;
		CARCOLORS[DODGE_SLATE_TURQUOISE]			= cars:0x00000A63r;
		CARCOLORS[DODGE_CORDOVAN]					= cars:0x00000A64r;
		CARCOLORS[DODGE_SILVER_IRIDESCENT]			= cars:0x00000A8Ar;
		CARCOLORS[DODGE_DARK_GREEN]					= cars:0x00000A8Br;
		CARCOLORS[DODGE_BRIGHT_RED]					= cars:0x00000A8Cr;
		CARCOLORS[DODGE_RED_IRIDESCENT]				= cars:0x00000A8Dr;
		CARCOLORS[DODGE_YELLOW]						= cars:0x00000A8Er;
		CARCOLORS[DODGE_CREAM]						= cars:0x00000A8Fr;
		CARCOLORS[DODGE_WHITE]						= cars:0x00000A90r;
		CARCOLORS[DODGE_BRONZE_IRIDESCENT]			= cars:0x00000A91r;
		CARCOLORS[DODGE_GOLD_IRIDESCENT]			= cars:0x00000A92r;
		CARCOLORS[DODGE_SANDSTONE_IRIDESCENT]		= cars:0x00000A93r;
		CARCOLORS[DODGE_MAUVE_IRIDESCENT]			= cars:0x00000A94r;
		CARCOLORS[DODGE_MAROON_IRIDESCENT]			= cars:0x00000A95r;

		CARCOLORS[PLYMOUTH_SILVER]					= cars:0x00000A66r;
		CARCOLORS[PLYMOUTH_ICE_BLUE]				= cars:0x00000A67r;
		CARCOLORS[PLYMOUTH_BLUE_FIRE]				= cars:0x00000A68r;
		CARCOLORS[PLYMOUTH_JAMAICA_BLUE]			= cars:0x00000A69r;
		CARCOLORS[PLYMOUTH_FROST_GREEN]				= cars:0x00000A6Ar;
		CARCOLORS[PLYMOUTH_LIMELIGHT]				= cars:0x00000A6Br;
		CARCOLORS[PLYMOUTH_IVY_GREEN]				= cars:0x00000A6Cr;
		CARCOLORS[PLYMOUTH_SAND_PEBBLE_BEIGE]		= cars:0x00000A6Dr;
		CARCOLORS[PLYMOUTH_SEAFOAM_TURQUOISE]		= cars:0x00000A6Er;
		CARCOLORS[PLYMOUTH_BARRACUDA_ORANGE]		= cars:0x00000A6Fr;
		CARCOLORS[PLYMOUTH_SCORCH_RED]				= cars:0x00000A70r;
		CARCOLORS[PLYMOUTH_HONEY_BRONZE]			= cars:0x00000A71r;
		CARCOLORS[PLYMOUTH_BRONZE_FIRE]				= cars:0x00000A72r;
		CARCOLORS[PLYMOUTH_SADDLE_BRONZE]			= cars:0x00000A73r;
		CARCOLORS[PLYMOUTH_ALPINE_WHITE]			= cars:0x00000A74r;
		CARCOLORS[PLYMOUTH_BLACK_VELVET]			= cars:0x00000A75r;
		CARCOLORS[PLYMOUTH_SUNFIRE_YELLOW]			= cars:0x00000A76r;
		CARCOLORS[PLYMOUTH_YELLOW_GOLD]				= cars:0x00000A77r;
		CARCOLORS[PLYMOUTH_SPANISH_GOLD]			= cars:0x00000A78r;
		CARCOLORS[PLYMOUTH_CITRON_GOLD]				= cars:0x00000A79r;
		CARCOLORS[PLYMOUTH_BAHAMA_YELLOW]			= cars:0x00000A7Ar;
		CARCOLORS[PLYMOUTH_ORANGE]					= cars:0x00000A7Br;
		CARCOLORS[PLYMOUTH_RALLYE_GREEN]			= cars:0x00000A7Cr;
		CARCOLORS[PLYMOUTH_VITAMIN_C]				= cars:0x00000A7Dr;

		CARCOLORS[FORD_FOLKESTONE_GRAY]				= cars:0x00000A7Fr;
		CARCOLORS[FORD_YOSEMITE_GREEN]				= cars:0x00000A80r;
		CARCOLORS[FORD_CLOUD_MIST_GRAY]				= cars:0x00000A81r;
		CARCOLORS[FORD_ACADIA_GREEN]				= cars:0x00000A82r;
		CARCOLORS[FORD_MANDARIN_MAROON]				= cars:0x00000A83r;
		CARCOLORS[FORD_GARNET_MAROON]				= cars:0x00000A84r;
		CARCOLORS[FORD_SAHARA_TAN]					= cars:0x00000A85r;
		CARCOLORS[FORD_COSTWOLD_GRAY]				= cars:0x00000A86r;
		CARCOLORS[FORD_COMO_BLUE]					= cars:0x00000A87r;
		CARCOLORS[FORD_CIGARETTE_CREAM]				= cars:0x00000A88r;
		CARCOLORS[FORD_ROYAL_MAROON]				= cars:0x00000AAAr;
		CARCOLORS[FORD_HIGHLAND_GREEN]				= cars:0x00000AABr;
		CARCOLORS[FORD_ACAPULCO_BLUE]				= cars:0x00000AACr;
		CARCOLORS[FORD_CANDYAPPLE_RED]				= cars:0x00000AADr;
		CARCOLORS[FORD_GULFSTREAM_AQUA]				= cars:0x00000AAEr;
		CARCOLORS[FORD_TAHOE_TURQUOISE]				= cars:0x00000AAFr;
		CARCOLORS[FORD_LIME_GOLD]					= cars:0x00000AB0r;
		CARCOLORS[FORD_MEADOWLARK_YELLOW]			= cars:0x00000AB1r;
		CARCOLORS[FORD_WIMBLEDON_WHITE]				= cars:0x00000AB2r;
		CARCOLORS[FORD_PRESIDENTIAL_BLUE]			= cars:0x00000AB3r;
		CARCOLORS[FORD_DIAMOND_BLUE]				= cars:0x00000AB4r;
		CARCOLORS[FORD_SUNLIT_GOLD]					= cars:0x00000AB5r;
		CARCOLORS[FORD_SEAFOAM_GREEN]				= cars:0x00000AB6r;
		CARCOLORS[FORD_PEBBLE_BEIGE]				= cars:0x00000AB7r;
		CARCOLORS[FORD_BRITTANY_BLUE]				= cars:0x00000AB8r;



		kismajom = new String[5];
		kismajom[0] = "mfunfspd";	// letmeroc
		kismajom[1] = "npofz";		// money
		kismajom[2] = "qspnpujpo";	// promotion
		kismajom[3] = "difbujoh";	// cheating
		kismajom[4] = "ujnfnbdijof";// timemachine

		// A B C D E F G H I J K L M N O P Q R S T U V W X Y Z //

		Math.randomize();

		//precache sound files
		new SfxRef( City.RID_SPEECH3 ).cache();
		new SfxRef( City.RID_SPEECH2 ).cache();
		new SfxRef( City.RID_SPEECH1 ).cache();
		new SfxRef( City.RID_SPEECHGO ).cache();
		new SfxRef( City.RID_SFX_DAY_WIN ).cache();
		new SfxRef( City.RID_SFX_DAY_LOOSE ).cache();

		//open all needed libraries:

		System.rpkScan( "parts\\engines\\" );
		System.rpkScan( "parts\\" );
		System.rpkScan( "cars\\racers\\" );
		System.rpkScan( "cars\\fake_racers\\" );
		System.rpkScan( "maps\\" );
		System.openLib( "MW_Mod.rpk" );

		//valo city preload by BB93
		System.openLib( "maps\\city.rpk" );
		System.openLib( "maps\\city2.rpk" );
		System.openLib( "sl\\Scripts\\City.class" );
		System.openLib( "sl\\Scripts\\Valocity.class" );

		//valo dealers preload by BB93
		System.openLib( "sl\\Scripts\\CarMarket.class" );
		System.openLib( "misc\\dealer.rpk" );
		System.openLib( "misc\\dealer2.rpk" );

		//main menu preload by BB93
		System.openLib( "sl\\Scripts\\MainMenu.class" );
		//System.openLib( "maps\\Addon_Maps\\Home.rpk" );

		initVehicleTypes();

		MWM_Items_Scan();

		float key = Math.random()*100;
		if( MainMenu.Check(key) != Math.sqrt(key)+3.75 )
		{
			new WarningDialog( GameLogic.player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "PROTECTION ERROR", "Miran Wichur Mod protection error: \n \n CORRUPTED FILES \n \n Sorry game will be close. \n Please reinstall Miran Wichur Mod." ).display();
			GameLogic.changeActiveSection( null );
		}

		preCacheGametypes( new GameRef( humans:0x00000001r ) );
		preCacheGametypes( new GameRef( cars:0x00000004r ) );	//traffic cars

		preCacheGametypes( new GameRef( maps.city:0x00000001r ) ); //valo city preload by BB93
		preCacheGametypes( new GameRef( maps.city:0x00000002r ) ); //valo city preload by BB93
		preCacheGametypes( new GameRef( maps.city:0x0000000Dr ) ); //valo city preload by BB93
		
		preCacheGametypes( new GameRef( maps.city2:0x00000001r ) ); //valo city preload by BB93
		preCacheGametypes( new GameRef( maps.city2:0x00000002r ) ); //valo city preload by BB93

		preCacheGametypes( new GameRef( humans:0x0000002fr ) ); //humans preload by BB93
		preCacheGametypes( new GameRef( humans:0x00000030r ) ); //humans preload by BB93
		preCacheGametypes( new GameRef( humans:0x00000031r ) ); //humans preload by BB93
		preCacheGametypes( new GameRef( humans:0x00000032r ) ); //humans preload by BB93
		preCacheGametypes( new GameRef( humans:0x00000033r ) ); //humans preload by BB93
		preCacheGametypes( new GameRef( humans:0x00000034r ) ); //humans preload by BB93

		preCacheGametypes( new GameRef( misc.dealer:0x00000001r ) ); //dealer preload by BB93
		preCacheGametypes( new GameRef( misc.dealer:0x00000002r ) ); //dealer preload by BB93
		preCacheGametypes( new GameRef( misc.dealer:0x0000000Fr ) ); //dealer preload by BB93

		preCacheGametypes( new GameRef( misc.dealer2:0x00000001r ) ); //dealer2 preload by BB93
		preCacheGametypes( new GameRef( misc.dealer2:0x00000002r ) ); //dealer2 preload by BB93
		preCacheGametypes( new GameRef( misc.dealer2:0x0000000Dr ) ); //dealer2 preload by BB93

		//preCacheGametypes( new GameRef( Maps.Addon_Maps.Home:0x00000001r ) ); //MainMenu preload

		preCacheGametypes( new GameRef( sl:0x00000040r ) ); //java preload

		//init controllers
		controllers = new GameRef[numplayers];

		//select the controllers who will play
		int[] joined = new int[Input.MAXPLAYERS];
		int i;
		do
		{
			int join;
			float t=0.0;
			for( int j=0; j<Input.MAXPLAYERS; j++)
			{

				if( !joined[j] && Input.isPlayerActive(j) && Input.player_input[j] >= t )
				{
					t=Input.player_input[j];
					join=j;
				}
			}

			controllers[i]=Input.controllers[join];
			joined[join]=1;

		}while( ++i < numplayers );

	//initialize player
		player = new Player();
		player.controller=controllers[0];

		Input.cursor.setController( player.controller );	//ki fogja iranyitani a kamerat egerrel?

		//def controlset state:
		player.controller.reset();
		player.controller.activateState(ControlSet.MENUSET);
		
	//initialize player2
		player2 = new Player();
		player2.controller=controllers[1];
		//player2.controller=new Controller( player2, "0 0 1" );

		//player2.controller.controlFile = "save/controls/Player2_control_set";
		//player2.controller.setcontrol();
		
		//player2.controller.reset();
		//player2.controller.activateState( ControlSet.DRIVERSET );
		//player2.controller.user_Add( Input.AXIS_THORTTLE,	0, Input.RCDIK_W,	1.0f, 1.0f, 0.0f, 1.0f);

		//controlSet2 = new ControlSet();
		//controlSet2.load( "active_control_set_Player2" );
		//player2.controller.setcontrol( controlSet2 );

		garage = new Garage();

		//player.showOsd();	//fps, other debug texts (only for debugging!!!)

		hotkey0 = new Hotkey( Input.AXIS_MUSIC_VOLUME_UP,	Input.VIRTUAL, Input.AXIS_MUSIC_VOLUME_UP, this );
		hotkey1 = new Hotkey( Input.AXIS_MUSIC_VOLUME_DOWN,	Input.VIRTUAL, Input.AXIS_MUSIC_VOLUME_DOWN, this );
		hotkey2 = new Hotkey( Input.AXIS_MUSIC_SELECT_NEXT, Input.VIRTUAL, Input.AXIS_MUSIC_SELECT_NEXT, this );
		hotkey3 = new Hotkey( Input.AXIS_MUSIC_SELECT_PREV, Input.VIRTUAL, Input.AXIS_MUSIC_SELECT_PREV, this );
		hotkey4 = new Hotkey( Input.AXIS_PRINTSCREEN,		Input.VIRTUAL, Input.AXIS_PRINTSCREEN, this );

		timeRefresher = new Thread( this, "Game time refresher" );
		timeRefresher.start();

		setEventMask( EVENT_HOTKEY|EVENT_TIME );

		addTimer( timeRefreshRate, 0 );	//simulated game time counter trigger

		//finished startup, now turn off the loading screen
		//Frontend.loadingScreen.hide();

		//DEFAULT START:
		changeActiveSection( new SplashScreen( new ResourceRef( frontend:0x0005r ) ) );
		//DEFAULT START WITHOUT SPLASHSCREEN:
		//changeActiveSection( new MainMenu() );

		//DENES-START
		/*
        loadDefaults();
//		player.car = new Vehicle( player, cars.racers.duhen:0x00000006r, 1.0, 1.0, 1.0, 1.0, 1.0 );
//		player.car = Vehicle.load( carSaveDir + "xxx", player );
		player.car = new Vehicle();
		player.car.create_native( player, new GameRef(cars.racers.einvagen:0x113r),	"0,0,0,0,0,0", "dummycar" );

		player.club = 2;
		//changeActiveSection( new MainMenu() );
		changeActiveSection( garage );
		//changeActiveSection( new TestTrack() );
		//changeActiveSection( city );
		/**///END!

        //KLAMPI-START
        /*
        loadDefaults();
        changeActiveSection( garage );
        changeActiveSection( city );
        /**///END!

		//SALA-START
		/*
		loadDefaults();

		float optical = 1.001+Math.random()*0.998;
		float power = 1.001+Math.random()*0.998;

		int cheat_mode = 2;

//		int cheat_car = cars.racers.Einvagen:0x00000006r; // 110 GT
//		int cheat_car = cars.racers.Einvagen:0x00000112r; // 110 GTK (110 GT Kompressor)
//		int cheat_car = cars.racers.Einvagen:0x00000113r; // 140 GTA

//		int cheat_car = cars.racers.Duhen:0x00000006r; // SunStrip 1.5 DVC
//		int cheat_car = cars.racers.Duhen:0x00000126r; // SunStrip 1.8 DVC
//		int cheat_car = cars.racers.Duhen:0x00000127r; // SunStrip 2.2 DVC
//		int cheat_car = cars.racers.Duhen:0x00000128r; // Racing SunStrip 2.0 CDVC

//		int cheat_car = cars.racers.Focer:0x00000006r; // Focer RC 200
//		int cheat_car = cars.racers.Focer:0x00000107r; // Focer RC 300
//		int cheat_car = cars.racers.Focer:0x00000108r; // Focer WRC

//		int cheat_car = cars.racers.Enula:0x00000006r; // Enula WRY
//		int cheat_car = cars.racers.Enula:0x0000017Cr; // Enula WRZ
//		int cheat_car = cars.racers.Enula:0x0000017Er; // Enula WR SuperTurizmo

		int cheat_car = cars.racers.Baiern:0x00000006r; // CoupeSport
//		int cheat_car = cars.racers.Baiern:0x00000157r; // DevilSport
//		int cheat_car = cars.racers.Baiern:0x000000FDr; // CoupeSport GT III

//		int cheat_car = cars.racers.Nonus:0x00000006r; // Nonus Street GT
//		int cheat_car = cars.racers.Nonus:0x000000DFr; // MotorSport Nonus GT II

//		int cheat_car = cars.racers.SuperDuty:0x00000006r; // SuperDuty 500
//		int cheat_car = cars.racers.SuperDuty:0x00000112r; // SuperDuty Extra 750

//		int cheat_car = cars.racers.MC:0x00000006r; // GT
//		int cheat_car = cars.racers.MC:0x00000109r; // GT-B
//		int cheat_car = cars.racers.MC:0x0000010Ar; // GT Limited Edition

//		int cheat_car = cars.racers.Prime:0x00000006r; // DLH 500

//		int cheat_car = cars.fake_racers.Teg:0x00000006r;
//		int cheat_car = cars.traffic.Ambulance:0x00000006r;

		if (cheat_mode == 1)
		{
			optical = 1.001;
			power = 1.001;
		}
		else
		if (cheat_mode == 2)
		{
			optical = 2.0;
			power = 2.0;
		}

		System.log ("Creating cheat car:");
		System.log ("                    optical = "+optical);
		System.log ("                    power = "+power);
		System.log ("                    (optical+power)*0.5 = "+((optical+power)*0.5));

		Descriptor d = new Descriptor(Math.random(), optical, power, 1.0, 1.0);

		player.car = new Vehicle( player, cheat_car, d.color, d.optical, d.power, d.wear, d.tear );

		player.club = 0;
		changeActiveSection( new MainMenu() );
		player.name="Sala";
		player.character = new ResourceRef( Racer.RID_FEJ );

		setTime( 12*3600 );

//		changeActiveSection( garage );
//		changeActiveSection( new City() );
		changeActiveSection( new TestTrack() );
//		changeActiveSection( new CarInfo( player.car ) );
		/**///END!
		updateDriverModels();
	}

	public void finalize()
	{
		timeRefresher.stop();

		hotkey0.inactivate();
		hotkey1.inactivate();
		hotkey2.inactivate();
		hotkey3.inactivate();
		hotkey4.inactivate();
	}

	public static native int kismajomCheck( String[] kismajomArray );

	//game time tracker
    public void handleEvent( GameRef obj_ref, int event, int param )
    {
        if( event == EVENT_TIME )
        {
			GameLogic.spendTime( GameLogic.timeRefreshRate*GameLogic.timeFactor );
			addTimer( GameLogic.timeRefreshRate, 0 );
		}
	}

	//handler of global game keys
	public void handleEvent( Hotkey hk )
	{
		int command = hk.command;

		if( command == Input.AXIS_MUSIC_VOLUME_UP )
			Sound.increaseVolume( 1, 0.1 );
		else 
		if( command == Input.AXIS_MUSIC_VOLUME_DOWN )
			Sound.decreaseVolume( 1, 0.1 );
		else 
		if( command == Input.AXIS_MUSIC_SELECT_NEXT )
			Sound.nextTrack();
		else 
		if( command == Input.AXIS_MUSIC_SELECT_PREV )
			Sound.prevTrack();
		else 
		if( command == Input.AXIS_PRINTSCREEN )
		{
			GfxEngine.printScreenIndexed( "screenshots\\sl_shot" );
			new SfxRef( Frontend.SFX_CAMERA ).play();
		}
	}


	//------------------------------------------------------------------------------------------//
	//------------------------------------------------------------------------------------------//
	//Static


	//vehicle creation cucc

	public static void initVehicleTypes()
	{
		//a tomb GameRefeket tartalmaz
		ResourceRef[] ct = VEHICLETYPE_ROOT.getChildNodes();

		vehicleTypes = new VehicleType[ct.length];

		for( int i=ct.length-1; i>=0; i-- )
		{
			GameRef xa = new GameRef();
			vehicleTypes[i] = xa.create( null, ct[i], null, "VehicleType" );

			//konstruktor is hivhatna, na mindegy...
			vehicleTypes[i].init();
		}
	}

	public static void MWM_Items_Scan()
	{
	//------- Chassis Scaning
		ChassisRoot = CHASSIS_ROOT.getChildNodes();
		ChassisBox = new Vector(1);// New colector, put 1 empty object to it
		ChassisResNoumber = new int[ChassisRoot.length];
		int correct = 0;

		for (int i=0; i<=ChassisRoot.length-1; i++ )// Searching Chassis and collecting at ChassisBox :)
		{
			if( ChassisRoot[i].isScripted() )
			{
				ChassisResNoumber[correct] = i;
				correct++;

				GameRef xa = new GameRef();
				ChassisBox.addElement( xa.create(null, new GameRef(ChassisRoot[i]), "0,0,0,0,0,0,", "chassis") );
			}
		}
	//------- Tracks Scaning

		System.rpkScan( "maps\\Addon_Maps\\" ); //System.openLib( "parts.rpk" );

		MapRoot = MAPS_ROOT.getChildNodes();
		MapBox = new Vector(1);// New colector, put 1 empty object to it

		for (int i=0; i<=MapRoot.length-1; i++ )// Searching Maps and collecting at MapBox
		{
			GameRef xa = new GameRef();
			MapBox.addElement( xa.create( null, new GameRef(MapRoot[i]), "0,0,0,0,0,0", "load Track script" ) );
		}
	
	//------- Driver Skins Scaning: Default Driver  
		DefaultSkinBox = new Vector(1);// New colector, put 1 empty object to it
		
		FindFile ff = new FindFile();
		String name=ff.first( "humans/drivers/Default_Driver/*.*", FindFile.FILES_ONLY );
		while( name )
		{

			DefaultSkinBox.addElement( name );

			name = ff.next();
		}
		ff.close();

	//-------Driver Skins Scaning: Police Man 
		PoliceManSkinBox = new Vector(1);// New colector, put 1 empty object to it
		
		ff=null;
		ff = new FindFile();
		name=ff.first( "humans/drivers/PoliceMan_Driver/*.*", FindFile.FILES_ONLY );
		while( name )
		{
			PoliceManSkinBox.addElement( name );

			name = ff.next();
		}
		ff.close();
	}

	//adott setbol
	public static VehicleDescriptor getVehicleDescriptor( int set )
	{
		return getVehicleDescriptor( set, -1 );
	}

	//adott setbol, nem random beallitasok, hanem linearisan valtozo (param 0-1)
	public static VehicleDescriptor getVehicleDescriptor( int set, float param )
	{
		VehicleType vt = getVehicleType( set );
		return vt.getVehicleDescriptor( set, param );
	}

	private static VehicleType getVehicleType( int set )
	{
		VehicleType vt;
		float	grossPrevalence, grossPrevalence2;

		for( int i=vehicleTypes.length-1; i>=0; i-- )
		{
			//don't use empty vts
			if( vehicleTypes[i].vtdarr.size() == 0 ) continue;

			if( set & vehicleTypes[i].vehicleSetMask )
				grossPrevalence += vehicleTypes[i].prevalence;
		}

		grossPrevalence*=Math.random();

		for( int i=vehicleTypes.length-1; i>=0; i-- )
		{
			//don't use empty vts
			if( vehicleTypes[i].vtdarr.size() == 0 ) continue;

			if( set & vehicleTypes[i].vehicleSetMask )
			{
				grossPrevalence2 += vehicleTypes[i].prevalence;
				if( grossPrevalence2 > grossPrevalence )
				{
					vt = vehicleTypes[i];
					break;
				}
			}
		}

		return vt;
	}


	public static void preCacheGametypes( ResourceRef root )
	{
		root=root.getFirstChild();
		while( root )
		{
			root.cache();
			root=root.getNextChild();
		}
	}


	//time cucc
	public static void setTimerText( Text day, Text hour )
	{
		timeTxt = hour;
		dayTxt = day;
		timeRefresher.notify();
	}

	public static void setTimerText( Text txt )
	{
		setTimerText( txt, null );
	}

	//kulso time interface begin----------
	public static void setTime( float t )
	{
		time = t;
		System.syncGameTime( time );
	}

	public static float getTime()
	{
		return time;
	}


	public static void spendTime( float dt )
	{
		time+=dt;
	
		while( time > 24*3600 )
		{
			time-=24*3600;
			day++;
		}

		timeRefresher.notify();
		System.syncGameTime( time );
	}
	//kulso time interface end----------

	//mode 0-kiszereles 1-beszereles
	public static float mechTime( Part part, int mode )
	{
		if( !(Mechanic.flags&Mechanic.MF_FREE_REPAIRS) )
		{
			float time = 60 + part.value/50 + part.isComplex()*60;

			if( mode )
				time*=3.0;

			return time;
		}

		return 0.0;
	}
	//---------------------------

	public static void run()
	{
		while(1)
		{
			timeRefresher.wait();
			if( timeTxt )
			{
				timeTxt.changeText( String.timeToString( time, String.TCF_NOSECONDS|String.TCF_US ) );
			}

			if( dayTxt )
			{
				dayTxt.changeText( day );
			}
		}
	}

	//----------------------------------------------------------
	//kizarolag day race!
	public static int canChallenge( Racer challenger, Racer challenged )
	{
		float	limit = 0.05;

//		System.log(challenger.club + " :: " + challenged.club);
		if( challenger.prestige+limit >= challenged.prestige  )
		{
			if( challenger.club == challenged.club )
			{
//				System.log("ok");
				return 1;
			}
		}

//				System.log("nope");
		return 0;
	}

	//----------------------------------------------------------
	//day+night
	public static void challenge( int challenger_id, int challenged_id, int abandon, int challenger_won, int affectRanking )
	{
		//pontok szmitasa
		speedymen[challenger_id].calcPrestige( speedymen[challenged_id], abandon, challenger_won );

		//felcsereljuk oket, ha a kisebb rankingu gyozott
		if( affectRanking )
		{
			if( !abandon && ((challenger_id < challenged_id && challenger_won) || (challenger_id > challenged_id && !challenger_won)))
			{
				Racer winner;
				if( challenger_won)
					winner=speedymen[challenger_id];
				else
					winner=speedymen[challenged_id];

				int prevPlayerRanking;
				if( speedymen[challenger_id] instanceof Player )
					prevPlayerRanking = findRacer( speedymen[challenger_id] );
				else
				if( speedymen[challenged_id] instanceof Player )
					prevPlayerRanking = findRacer( speedymen[challenged_id] );


				//felcsereljuk oket
				Racer tmp = speedymen[challenger_id];
				speedymen[challenger_id]=speedymen[challenged_id];
				speedymen[challenged_id]=tmp;
		
				//kulonbozo klubban voltak? akkor a klub id-t is cserljuk!
				if( speedymen[challenger_id].club != speedymen[challenged_id].club )
				{
					int	tmp = speedymen[challenger_id].club;
					speedymen[challenger_id].club = speedymen[challenged_id].club;
					speedymen[challenged_id].club = tmp;
				}

				//elso lett csoportjaban? megjutalmazzuk!
				if( winner instanceof Player )
				{
					if( player.club == GameLogic.CLUBS-1 )
					{	//top klubban a legjobb 5 koze ert (ROC)
						if( findRacer( winner ) >= speedymen.length-5 && prevPlayerRanking < speedymen.length-5 )	
						{
							new CongratsDialog( ((Player)winner).controller, Dialog.DF_HIGHPRI|Dialog.DF_MODAL|Dialog.DF_FULLSCREEN|Dialog.DF_FREEZE, frontend:0x008Dr + player.club ).display();
						}
					}
					else	//valamelyik club csucsara ert
					{
						if( findRacer( winner ) % CLUBMEMBERS == CLUBMEMBERS-1 )	
						{
							new CongratsDialog( ((Player)winner).controller, Dialog.DF_HIGHPRI|Dialog.DF_MODAL|Dialog.DF_FULLSCREEN|Dialog.DF_FREEZE, frontend:0x008Dr + player.club ).display();
						}
					}
				}
			}
		}
	}

	public static int findRacer( Racer rc )
	{
		for( int i=0; i<speedymen.length; i++ )
			if( speedymen[i] == rc )
				return i;
		return -1;
	}

//----------------------------------------------------------------------

	public static void changeActiveSection( GameState state )
	{
		if( actualState )
		{
			actualState.exit( state );
		}

		GameState oldState = actualState;
		actualState = state;

		if( actualState )
		{
			actualState.enter( oldState );
		}
		else
		{
			//destroy();
			System.exit();
		}
	}

	//---------------------------------- Game I/O ---------------------------------

	public static int autoSave()
	{
		if( played && !saved )
		{
			if( gameMode == GM_CARREER && carrerInProgress )
			{
				new WarningDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "CAREER INFO", "You are exiting your ongoing career. \n Your career has been automatically saved." ).display();

				autoSaveQuiet();
				new SfxRef( Frontend.SFX_OK ).play(); 
			}
		}

		return 1;	//1-OK, go ahead; 0-save cancelled
	}

	public static void autoSaveQuiet()
	{
		if( gameMode == GM_CARREER && carrerInProgress )
		{
			String dirname = player.name + "-" + (player.club+1) /*", " + String.timeToString( time, String.TCF_NOSECONDS ) */;
			save( GameLogic.carrerSaveDir + dirname + "/" );
		}
	}


	public static int save( String filename )
	{
		//delete all the old savegame files:
		File.delete( filename, "*" );

		File saveGame = new File( filename + "main"  );
		if( saveGame.open( File.MODE_WRITE ) )
		{
			saveGame.write( SAVEFILEID_MAIN );
			saveGame.write( SAVEFILEVERSION_MAIN );

//			player.save( saveGame );
			//TEMP.:
			int player_global_rank = findRacer(player);
			saveGame.write( player.character );
			saveGame.write( player.money );
			saveGame.write( player.prestige );
			saveGame.write( player_global_rank );
			saveGame.write( player.flags );
			saveGame.write( player.name );
			saveGame.write( player.races_won );
			saveGame.write( player.races_lost );
			saveGame.write( player.hints );
			saveGame.write( player.winPinkSlips );

			//partsbin
			player.parts.save( saveGame );

			//decals
			int	num_decals = player.decals.size();
			saveGame.write( num_decals );
			for( int i=0; i<num_decals; i++ )
			{
				Decal d = player.decals.elementAt( i );
				saveGame.write( d );
				saveGame.write( d.stickies );
			}


			//ToDo: save standings (rank,prestige,etc. of all other racers)
			//exclude player, because he has different structure
			for( int i=0; i<speedymen.length; i++ )
			{
				if( i != player_global_rank )
				{
					saveGame.write( speedymen[i].fileid );
					saveGame.write( speedymen[i].seed );
					saveGame.write( speedymen[i].prestige );
					speedymen[i].botVd.save( saveGame );
					speedymen[i].nightVd.save( saveGame );

					speedymen[i].save( saveGame );
				}
			}

			//save carmarket cars:
			saveGame.write( carDescriptors_New.length );
			for( int i=0; i<carDescriptors_New.length; i++ )
				if( carDescriptors_New[i] )
				{
					saveGame.write( 1 );
					carDescriptors_New[i].save( saveGame );
				}
				else
					saveGame.write( 0 );

			saveGame.write( carDescriptors_Used.length );
			for( int i=0; i<carDescriptors_Used.length; i++ )
				if( carDescriptors_Used[i] )
				{
					saveGame.write( 1 );
					carDescriptors_Used[i].save( saveGame );
				}
				else
					saveGame.write( 0 );

			//

			player.carlot.lockPlayerCar();

			int	dummy;

			saveGame.write( player.carlot.curcar );	//last used car
			saveGame.write( getTime() );
			saveGame.write( day );

			saveGame.write( dummy );
			saveGame.write( dummy );
			saveGame.write( dummy );
			saveGame.write( dummy );
			saveGame.write( dummy );
			saveGame.write( dummy );
			saveGame.write( dummy );

			saveGame.close();


			//save cars
			player.carlot.saveCar( player.carlot.curcar );
			player.carlot.releasePlayerCar();

			//nem moveolhatunk, merthogy mi van ha meg tovabb jatszik a user!
			File.copy( tempSaveDir, "PlayerCar*", filename );

			return 1;
		}
		return 0;
	}

	public static int fileCheck( String filename )
	{
		int	status;
		File saveGame = new File( filename + "/main" );

		if( saveGame.open( File.MODE_READ ) )
		{
			if( saveGame.readInt() == SAVEFILEID_MAIN )
				if( saveGame.readInt() >= SAVEFILEVERSION_MAIN_LOAD )
					status = 1;

			saveGame.close();
		}

		return status;
	}

	public static int load( String filename )
	{
		int	error;	//0 - OK
		int	version;
		File saveGame = new File( filename + "main" );

		if( saveGame.open( File.MODE_READ ) )
		{
			if( saveGame.readInt() == SAVEFILEID_MAIN )
			{
				version = saveGame.readInt();
				if( version >= SAVEFILEVERSION_MAIN_LOAD )
				{
					erase();
		
					int player_global_rank;
					player.character = new ResourceRef( saveGame.readResID() );
					player.money = saveGame.readInt();
					player.prestige = saveGame.readFloat(); 
					player_global_rank = saveGame.readInt();
					player.flags = saveGame.readInt();
					player.name = saveGame.readString();
					player.races_won = saveGame.readInt();
					player.races_lost = saveGame.readInt();
					player.hints = saveGame.readInt();
					if (version > 20)
						player.winPinkSlips = saveGame.readInt();
					player.club = player_global_rank/CLUBMEMBERS;
					speedymen[player_global_rank]=player;

					player.parts.load( saveGame );

					int	num_decals = saveGame.readInt();
					for( int i=0; i<num_decals; i++ )
					{
						int id = saveGame.readResID();
						Decal rd = new Decal( id );
						rd.stickies=saveGame.readInt();

						player.decals.addElement( rd );	
					}

					for( int i=0; i<speedymen.length; i++ )
					{
						if( i != player_global_rank )
						{
							speedymen[i] = new Bot( saveGame.readInt(), saveGame.readInt(), (1.0+i)/speedymen.length ); 
							speedymen[i].prestige = saveGame.readFloat();
							speedymen[i].botVd = new VehicleDescriptor().load( saveGame );
							speedymen[i].nightVd = new VehicleDescriptor().load( saveGame );
							speedymen[i].club = i/CLUBMEMBERS;

							speedymen[i].load( saveGame );
						}
					}

					loadUnsavedData();
				}
				else
				{
					error=-1;	//VERSION_CONFLICT
				}
			}
			else
			{
				error=-2;	//FILE CORRUPT
			}

			//fill carmarket:
			carDescriptors_New = new VehicleDescriptor[saveGame.readInt()];
			for( int i=0; i<carDescriptors_New.length; i++ )
				if( saveGame.readInt() )
					carDescriptors_New[i] = new VehicleDescriptor().load( saveGame );

			carDescriptors_Used = new VehicleDescriptor[saveGame.readInt()];
			for( int i=0; i<carDescriptors_Used.length; i++ )
				if( saveGame.readInt() )
					carDescriptors_Used[i] = new VehicleDescriptor().load( saveGame );


			//load cars:
			if( !error )
			{
				File.delete( tempSaveDir, "*" );
				File.copy( filename, "PlayerCar*", tempSaveDir );
	
				player.carlot.scanCars();

				int dummy;

				player.carlot.curcar = saveGame.readInt();
				player.carlot.old_curcar = player.carlot.curcar;

				setTime( saveGame.readFloat() );
				day = saveGame.readInt();

				dummy = saveGame.readInt();
				dummy = saveGame.readInt();
				dummy = saveGame.readInt();
				dummy = saveGame.readInt();
				dummy = saveGame.readInt();
				dummy = saveGame.readInt();
				dummy = saveGame.readInt();

				player.carlot.releasePlayerCar();
			}
			saveGame.close();

		}
		else
		{
			error=-3;	//FILE MISSING
		}

		return error;
	}

	public static void updateDriverModels()
	{
		if( Config.driverModel == 1 )
		{
			//HUMAN_SMILEY	= humans:0x00000009r;
			HUMAN_OPPONENT	= humans:0x00000007r;
			HUMAN_OPPONENT2	= humans:0x00000008r;		
			HUMAN_PLAYER	= humans:0x0000000Cr;		
			HUMAN_POLICEMAN = humans:0x00000018r;		
		}
		else
		{
			//HUMAN_SMILEY	= humans:0x00000000r;
			HUMAN_OPPONENT	= humans:0x00000000r;
			HUMAN_OPPONENT2	= humans:0x00000000r;
			HUMAN_PLAYER	= humans:0x00000000r;
			HUMAN_POLICEMAN = humans:0x00000000r;
		}
		player.driverID = new RenderRef( GameLogic.HUMAN_PLAYER );
	}

	public static void loadUnsavedData()
	{
		player.driverID = new RenderRef( GameLogic.HUMAN_PLAYER );

		timeout = 0;
		gameMode = GM_CARREER;
		setTime( 12*3600 );
		day = 1;
	}

	//default settings
	public static void loadDefaults()
	{
		erase();

		//felejtse el az elozo jatekallas slotjait!
		player.carlot.scanCars();

		//player
		player.money = INITIAL_PLAYER_MONEY;
		player.prestige = INITIAL_PLAYER_PRESTIGE;
		player.club = 0;
		player.flags = 0;
		player.hints = 0;
		player.winPinkSlips = 0;

		if( !player.character )	//eg for free ride..
		{
			player.character=new ResourceRef( Racer.RID_FEJ );
			player.name = "Player";
		}

		//other racers
		speedymen[0] = player;
		int diff=-1;
		for( int i=1; i<speedymen.length; i++ )
		{
			if( player.character.id() == Racer.RID_FEJ+i+diff )
				diff++;	//atugratjuk a playerrel egyezo kinezetu botot!

			speedymen[i] = new Bot( i+diff, i*7243, INITIAL_OPPONENT_AI_MIN+((INITIAL_OPPONENT_AI_MAX-INITIAL_OPPONENT_AI_MIN)*i/speedymen.length) + INITIAL_OPPONENT_AI_RND*(Math.random()*2.0-1.0) ); 
			speedymen[i].botVd = getVehicleDescriptor( VehicleType.VS_DRACE, INITIAL_OPPONENT_VHC_MIN+((INITIAL_OPPONENT_VHC_MAX-INITIAL_OPPONENT_VHC_MIN)*i/speedymen.length) + INITIAL_OPPONENT_VHC_RND*(Math.random()*2.0-1.0) );
			speedymen[i].nightVd = getVehicleDescriptor( VehicleType.VS_NRACE, INITIAL_OPPONENT_NIGHT_VHC_MIN+((INITIAL_OPPONENT_NIGHT_VHC_MAX-INITIAL_OPPONENT_NIGHT_VHC_MIN)*i/speedymen.length) + INITIAL_OPPONENT_NIGHT_VHC_RND*(Math.random()*2.0-1.0) );
			speedymen[i].bestNightQM = speedymen[i].nightVd.estimateQM();
		}

		// sort racers (excluding player) by night car prestige... - Sala
		for (int i=1; i<speedymen.length-1; i++)
			for (int j=i+1; j<speedymen.length; j++)
				if (speedymen[i].nightVd.estimateQM() < speedymen[j].nightVd.estimateQM())
				{
					Bot temp = speedymen[i];
					speedymen[i] = speedymen[j];
					speedymen[j] = temp;
				}

		for( int i=1; i<speedymen.length; i++ )
		{
			speedymen[i].prestige = INITIAL_OPPONENT_PRESTIGE_MIN+((INITIAL_OPPONENT_PRESTIGE_MAX-INITIAL_OPPONENT_PRESTIGE_MIN)*i/speedymen.length) + INITIAL_OPPONENT_PRESTIGE_RND*(Math.random()*2.0-1.0);
			speedymen[i].club = i/CLUBMEMBERS;
		}

/*
		System.log("-----------------------------------------------------------------------");
		for( int i=1; i<speedymen.length; i++ )
		{
			if (i%20 == 0)
				System.log("-----------------------------------------------------------------------");
			Bot b = speedymen[i];
			System.log("  #"+i+": club: "+b.club+"\tprestige: "+(b.prestige*Racer.PRESTIGE_SCALE)+"\tnight stuffs: "+b.nightVd.vehicleName+" ("+(b.nightVd.estimatePrestige()*Racer.VHC_PRESTIGE_SCALE)+" - "+b.nightVd.estimateQM()+")\tday stuffs: "+b.botVd.vehicleName+" ("+(b.botVd.estimatePrestige()*Racer.VHC_PRESTIGE_SCALE)+" - "+b.botVd.estimateQM()+")");
		}
		System.log("-----------------------------------------------------------------------");
*/

		loadUnsavedData();

		carDescriptors_New = CarMarket.getInitialCars( 0 );
		carDescriptors_Used = CarMarket.getInitialCars( 1 );

		//jobb lennne ha mentenenk+betoltenenk!
		dealerVisitTimeStamp_Used = 0.0;
		dealerVisitTimeStamp_New = 0.0;
	}

	//kitorli az aktualis jatekallast a memoriabol es a diskrol
	public static void erase()
	{
		//neutralize player: 		//patch until a really new player will be created:

		if( player.car )
		{
			player.car.destroy();
			player.car = null;
		}

		
		//player.parts.destroyAll();
		player.parts = new Inventory( player );
		player.carlot = new CarLot( player );

		while( !player.decals.isEmpty() )
		{
			ResourceRef rr = player.decals.elementAt( 0 );
			rr.unload();
			rr.destroy();
			player.decals.removeElementAt( 0 );
		}

		File.delete( tempSaveDir, "*" );

		carDescriptors_New = null;
		carDescriptors_Used = null;

		played = 0;
		saved = 0;

		carrerInProgress = 0;
	}
}
