package java.game;

import java.io.*;
import java.util.*;
import java.util.resource.*;
import java.render.*; //Text
import java.render.osd.*; //Text
import java.render.osd.dialog.*; //Text
import java.sound.*;
import java.lang.*;

import java.game.parts.*;
import java.game.parts.bodypart.*;


// New painter by Harrison15 and Bigg Boss93
// Special thanks to Prof. Nan C. Schaller of Rochester University
// for HSV <-> RGB conversion example
// http://www.cs.rit.edu/~ncs/color/t_convert.html

public class Painter extends GameType implements GameState
{
	final static int RID_PAINT_SPRAY = frontend:0x0130r;
	final static int RID_PAINT_PART  = frontend:0x0131r;
	final static int RID_PAINT_DECAL = frontend:0x0132r; 

	final static int RID_PAINT_LOAD = frontend:0x0011r; 
	final static int RID_PAINT_SAVE = frontend:0x0072r; 

	final static int RID_SELL_PAINT = MW_Mod:0x0157r;
	final static int RID_LIST_PAINT = MW_Mod:0x0154r;

	final static int RID_GOTO_PICKR = MW_Mod:0x0155r;
	final static int RID_SVTO_PALET = MW_Mod:0x0156r;

	final static int RID_RGB_MODE = MW_Mod:0x0152r;
	final static int RID_HSV_MODE = MW_Mod:0x0153r;

	final static int RID_BACKGROUND = frontend:0x00C0r;
	final static int RID_BACKGROUND_RGB = frontend:0x00C0r;
	final static float BACKGROUND_HEIGHT = 0.40;

	final static float PARTS_VP_TOP = 0.848;
	final static float PARTS_VP_LEFT = 0.148;
	final static float PARTS_VP_WIDTH = 0.777;
	final static float PARTS_VP_HEIGHT = 0.140;

	final static int CMD_SCROLL_UP = 0;
	final static int CMD_SCROLL_DOWN = 1;
	final static int CMD_SPRAY = 2;
	final static int CMD_PART = 3;
	final static int CMD_DECALS = 4;

	final static ResourceRef PAINTBRUSH = new ResourceRef( misc.garage:0x0102r );
	final static SfxRef SfxSPRAY = new SfxRef( GameLogic.SFX_SPRAY );
	final static SfxRef SfxDECAL = new SfxRef( GameLogic.SFX_DECAL );
	final static SfxRef SfxWARN = new SfxRef( frontend:0x0081r );

	final static int RID_button_decal = misc.garage:0x0000008Cr;

	//0-63: colorbuttons hasznaljak!
	final static int CMD_DECALBUTTONS = 64;
	//64-68: decalsbuttons hasznaljak!
	final static int CMD_NONE = 100;

	final static int CMD_BRUSHINC = 102;
	final static int CMD_BRUSHDEC = 103;
	final static int CMD_BRUSHRCW = 104;
	final static int CMD_BRUSHRCCW = 105;
	final static int CMD_BRUSHFLIP = 106;
	final static int CMD_LOADSKIN = 107;
	final static int CMD_SAVESKIN = 108;
	final static int CMD_COPYSKIN = 109;
	final static int CMD_C_COPY = 110;
	final static int CMD_C_PAINT = 111;

	final static int MODE_NONE = 0;
	final static int MODE_PAINTCOLOR = 1;
	final static int MODE_PAINTPART = 2;
	final static int MODE_PAINTDECAL = 3;
	final static int MODE_COPY = 4;

	final static int COLORMODE_SWATCH = 0;
	final static int COLORMODE_CUSTOM = 1;

	final static int SLIDERMODE_RGB = 0;
	final static int SLIDERMODE_HSV = 1;

	final static int CMD_SLIDER_R = 112;
	final static int CMD_SLIDER_G = 113;
	final static int CMD_SLIDER_B = 114;

	final static int CMD_SLIDER_H = 115;
	final static int CMD_SLIDER_S = 116;
	final static int CMD_SLIDER_V = 117;

	final static int CMD_SAVE_PAINT = 118;
	final static int CMD_SWATCH = 119;
	final static int CMD_COLORPICKER = 120;
	final static int CMD_RGB = 121;
	final static int CMD_HSV = 122;
	final static int CMD_CLEARCOLORS = 123;
	final static int CMD_LOADCOLORS = 124;
	final static int CMD_SAVECOLORS = 125;

	final static int CMD_INPUTCOLOR = 126;

	ControlSetState css;

	PaintInventory paintCans;
	PaintShopDisplay temporaryCan;
	int overVehicle; //where is the pointer?

	int mode, colormode, slidermode;
	int lastPaintMode=MODE_PAINTPART;
	int lastColorMode=COLORMODE_CUSTOM;
	int lastSliderMode=SLIDERMODE_RGB;

	GameRef paintCursor;
	ResourceRef paintBrush;

	int brushColor=0xFFFFFFFF;
	float decalRotation;
	float decalSize = 0.7;
	int decalFlip;

	int paintRed = 255;
	int paintGreen = 255;
	int paintBlue = 255;
	int paintHue = 0;
	int paintSaturation = 0;
	int paintValue = 100;
	int queueHexColor = 0xFFFFFF;

	Button hexButton;

	String queueHexText;

	int usingRgbColor = 1;

	int[] newRgb = new int[3];
	int[] newHsv = new int[3];

	final static String	paletteSaveDir = "save/palettes/";
	final static String	paintCansFile = paletteSaveDir + "currentpaintcans";
	final static int	CANSFILEID = 0xe21cd8ba; //totally random hex hash - let's hope this works
	final static int	CANSFILEVERSION = 1;

	GameRef[] decalButtons;
	RenderRef[] decalButtonTypes = new RenderRef[8];
	RenderRef[] decalButtonInstances = new RenderRef[8];
	ResourceRef[] decalButtonTextures = new ResourceRef[8];
	int showDecals;

	int spraySfxID, spraySfxOn;

	int handleControls;

	Osd osd;
	int copyGroup, paintGroup, colorsGroup, decalsGroup, brushGroup, sprayGroup, osdGroup, colorMixer, rgbSliders, hsvSliders, paintSelector, scrollGroup;
	Text moneyTxt, infoline, invLineTxt;

	Player player;

	Gadget red0, red1;

	final static int PF_REDUCED_FUNCTIONALITY = 1;
	int flags;

	Rectangle copy_prev;
	int copy_texture, copy_status; // 0 copy, 1 paint
	Button copy_button, paint_button;

	Thread refresherThread;
	int oldQueueHexColor = queueHexColor;

	public Painter( Player p, Osd o, Text mt, Text il, int ctrl )
	{
		createNativeInstance();
		
		player=p;
		osd=o;
		moneyTxt = mt;
		infoline = il;
		handleControls = ctrl;
		
		//initialize osd
		osd.globalHandler = this;
		
		Style butt0 = new Style( 0.45, 0.12, Frontend.mediumFont, Text.ALIGN_RIGHT, Osd.RRT_TEST );
		Style sld1 = new Style( 0.75, 0.06, Frontend.mediumFont, Text.ALIGN_LEFT, new ResourceRef(Osd.RID_SLD_BACK) );
		Style sldk =  new Style( 0.04, 0.05, Frontend.mediumFont, Text.ALIGN_RIGHT, new ResourceRef(Osd.RID_SLD_KNOB) );
		
		osd.createRectangle( 0.0, 1.0-(BACKGROUND_HEIGHT/2), 2.0, BACKGROUND_HEIGHT, -1, new ResourceRef( RID_BACKGROUND ) );
		
		osd.hideGroup( osdGroup=osd.endGroup() );
		
		Style buttonStyle = new Style( 0.12, 0.12, Frontend.mediumFont, Text.ALIGN_LEFT, null );
		Menu m = osd.createMenu( buttonStyle, -0.990, 0.76, 0.10, Osd.MD_HORIZONTAL );
		
		red0 = m.addItem( new ResourceRef( RID_PAINT_SPRAY ), CMD_SPRAY, "Spray paint" );
		m.addItem( new ResourceRef( RID_PAINT_PART ), CMD_PART, "Paint whole parts" );
		red1 = m.addItem( new ResourceRef( RID_PAINT_DECAL ), CMD_DECALS, "Apply decals" );
		
		m = osd.createMenu( buttonStyle, -0.990, 0.92, 0.10, Osd.MD_HORIZONTAL );
		
		m.addItem( new ResourceRef( RID_PAINT_LOAD ), CMD_LOADSKIN, "Load paint job" );
		m.addItem( new ResourceRef( RID_PAINT_SAVE ), CMD_SAVESKIN, "Save paint job" );
		// REMOVE THIS LINE IF NOT MWM
		m.addItem( new ResourceRef( MW_Mod:0x0098r ), CMD_COPYSKIN, "Copy part paint" );
		
		osd.hideGroup( paintGroup = osd.endGroup() );

		Style btnUp = new Style( 0.10, 0.10, 1.0, Frontend.mediumFont, Text.ALIGN_CENTER, new ResourceRef( Osd.RID_ARROWUP ) );
		Button upScrollArrow = osd.createButton( btnUp, 0.96, 0.76, CMD_SCROLL_UP, "Scroll up" );
		
		Style btnDn = new Style( 0.10, 0.10, 1.0, Frontend.mediumFont, Text.ALIGN_CENTER, new ResourceRef( Osd.RID_ARROWDN ) );
		Button downScrollArrow = osd.createButton( btnDn, 0.96, 0.92, CMD_SCROLL_DOWN, "Scroll down" );
		
		invLineTxt = osd.createText( "1", Frontend.smallFont, Text.ALIGN_CENTER, 0.96,  0.825);
		
		osd.hideGroup( scrollGroup=osd.endGroup() );
		
		osd.hideGroup( colorsGroup = osd.endGroup() );
		
		
		decalButtons=new GameRef[8];
		float k=-0.59, l=0.190;
		decalButtons[0] = osd.createButton( RID_button_decal, k, 0.84, null, Frontend.mediumFont, Text.ALIGN_LEFT, this, CMD_DECALBUTTONS ); k+=l;
		decalButtons[1] = osd.createButton( RID_button_decal, k, 0.84, null, Frontend.mediumFont, Text.ALIGN_LEFT, this, CMD_DECALBUTTONS+1 ); k+=l;
		decalButtons[2] = osd.createButton( RID_button_decal, k, 0.84, null, Frontend.mediumFont, Text.ALIGN_LEFT, this, CMD_DECALBUTTONS+2 ); k+=l;
		decalButtons[3] = osd.createButton( RID_button_decal, k, 0.84, null, Frontend.mediumFont, Text.ALIGN_LEFT, this, CMD_DECALBUTTONS+3 ); k+=l;
		decalButtons[4] = osd.createButton( RID_button_decal, k, 0.84, null, Frontend.mediumFont, Text.ALIGN_LEFT, this, CMD_DECALBUTTONS+4 ); k+=l;
		decalButtons[5] = osd.createButton( RID_button_decal, k, 0.84, null, Frontend.mediumFont, Text.ALIGN_LEFT, this, CMD_DECALBUTTONS+5 ); k+=l;
		decalButtons[6] = osd.createButton( RID_button_decal, k, 0.84, null, Frontend.mediumFont, Text.ALIGN_LEFT, this, CMD_DECALBUTTONS+6 ); k+=l;
		decalButtons[7] = osd.createButton( RID_button_decal, k, 0.84, null, Frontend.mediumFont, Text.ALIGN_LEFT, this, CMD_DECALBUTTONS+7 ); k+=l;
		
		osd.hideGroup( decalsGroup = osd.endGroup() );
		
		buttonStyle = new Style( 0.30, 0.1, Frontend.mediumFont, Text.ALIGN_LEFT, new ResourceRef(Mechanic.RID_BTN_L) );
		m = osd.createMenu( buttonStyle, -1.0, 0.15, 0 );
		m.addItem( "FLIP", CMD_BRUSHFLIP, "TAB or NUM 5 key" );
		m.addItem( "R. LEFT", CMD_BRUSHRCCW, "Q or NUM 4 key" );
		m.addItem( "R. RIGHT", CMD_BRUSHRCW, "W or NUM 6 key" );
		m.addItem( "BIGGER", CMD_BRUSHINC, "A or NUM 8 key" );
		m.addItem( "SMALLER", CMD_BRUSHDEC, "S or NUM 2 key" );
		
		osd.createHotkey( Input.RCDIK_TAB, Input.KEY, CMD_BRUSHFLIP, this );
		osd.createHotkey( Input.RCDIK_Q, Input.KEY, CMD_BRUSHRCCW, this );
		osd.createHotkey( Input.RCDIK_W, Input.KEY, CMD_BRUSHRCW, this );
		osd.createHotkey( Input.RCDIK_A, Input.KEY, CMD_BRUSHINC, this );
		osd.createHotkey( Input.RCDIK_S, Input.KEY, CMD_BRUSHDEC, this );
		
		osd.createHotkey( Input.RCDIK_NUMPAD4, Input.KEY, CMD_BRUSHRCCW, this );
		osd.createHotkey( Input.RCDIK_NUMPAD6, Input.KEY, CMD_BRUSHRCW, this );
		osd.createHotkey( Input.RCDIK_NUMPAD8, Input.KEY, CMD_BRUSHINC, this );
		osd.createHotkey( Input.RCDIK_NUMPAD2, Input.KEY, CMD_BRUSHDEC, this );
		osd.createHotkey( Input.RCDIK_NUMPAD5, Input.KEY, CMD_BRUSHFLIP, this ); 
		osd.hideGroup( brushGroup = osd.endGroup() );
		
		m = osd.createMenu( buttonStyle, -1.0, 0.45, 0 );
		m.addItem( "BIGGER", CMD_BRUSHINC, "A or NUM 8 key" );
		m.addItem( "SMALLER", CMD_BRUSHDEC, "S or NUM 2 key" );
		
		osd.createHotkey( Input.RCDIK_A, Input.KEY, CMD_BRUSHINC, this );
		osd.createHotkey( Input.RCDIK_S, Input.KEY, CMD_BRUSHDEC, this );
		
		osd.createHotkey( Input.RCDIK_NUMPAD8, Input.KEY, CMD_BRUSHINC, this );
		osd.createHotkey( Input.RCDIK_NUMPAD2, Input.KEY, CMD_BRUSHDEC, this );
		
		osd.hideGroup( sprayGroup = osd.endGroup() );
		
		osd.createRectangle( -0.8, 0.25, 0.4, 0.7, -1, new ResourceRef(MW_Mod:0x0034r) );//frame ptx
		copy_prev = osd.createRectangle( -0.8, 0.16, 0.35, 0.45, 0, new ResourceRef(Frontend:0x013Cr) );//empty ptx
		
		buttonStyle = new Style( 0.2, 0.09, Frontend.largeFont, Text.ALIGN_CENTER, null );
		m = osd.createMenu( buttonStyle, -0.8, 0.45, 0 );
		copy_button = m.addItem( "COPY", CMD_C_COPY );
		paint_button = m.addItem( "PAINT", CMD_C_PAINT );
		
		osd.hideGroup( copyGroup = osd.endGroup() );
		
		Style painterStyle = new Style( 0.12, 0.12, Frontend.mediumFont, Text.ALIGN_LEFT, null );
		//Menu pa = osd.createMenu( painterStyle, -0.995, 0.76, 0.10, Osd.MD_HORIZONTAL );
		
		Menu pa = osd.createMenu( butt0, PARTS_VP_LEFT-(PARTS_VP_WIDTH-0.013*4)*4/5-4*.013, PARTS_VP_TOP-(PARTS_VP_HEIGHT+0.025)*2/3-.01, 0.1 );
		pa.setSliderStyle( sld1, sldk );
		
		pa.addItem( "RED ", CMD_SLIDER_R, paintRed, 0, 255, 1, null ).printValue(" %1.0f");
		pa.addItem( "GREEN ", CMD_SLIDER_G, paintGreen, 0, 255, 1, null ).printValue(" %1.0f");
		pa.addItem( "BLUE ", CMD_SLIDER_B, paintBlue, 0, 255, 1, null ).printValue(" %1.0f");
		
		Style btnHsv = new Style( 0.10, 0.10, 1.0, Frontend.mediumFont, Text.ALIGN_CENTER, new ResourceRef( RID_HSV_MODE ) );
		Button gotoHsv = osd.createButton( btnHsv, 0.435, 0.76, CMD_HSV, "Switch to HSV color space" );
		
		osd.hideGroup( rgbSliders = osd.endGroup() );
		
		Menu pb = osd.createMenu( butt0, PARTS_VP_LEFT-(PARTS_VP_WIDTH-0.013*4)*4/5-4*.013, PARTS_VP_TOP-(PARTS_VP_HEIGHT+0.025)*2/3-.01, 0.1 );
		pb.setSliderStyle( sld1, sldk );
		
		pb.addItem( "HUE ", CMD_SLIDER_H, paintHue, 0.0, 360, 1, null ).printValue(" %1.0f");
		pb.addItem( "SAT ", CMD_SLIDER_S, paintSaturation, 0, 100, 1, null ).printValue(" %1.0f");
		pb.addItem( "VAL ", CMD_SLIDER_V, paintValue, 0, 100, 1, null ).printValue(" %1.0f");
		
		Style btnRgb = new Style( 0.10, 0.10, 1.0, Frontend.mediumFont, Text.ALIGN_CENTER, new ResourceRef( RID_RGB_MODE ) );
		Button gotoRgb = osd.createButton( btnRgb,0.435, 0.76, CMD_RGB, "Switch to RGB color space" );
		
		osd.hideGroup( hsvSliders = osd.endGroup() );
		
		Style butt2 = new Style( 0.45, 0.12, Frontend.mediumFont, Text.ALIGN_RIGHT, Osd.RRT_TEST );
		Menu t = osd.createMenu( butt2, 0.525, 0.935, 0 );
		hexButton = t.addItem( "#" + prepareHexString( queueHexColor ), CMD_INPUTCOLOR, "Enter new paint color" );
		
		Style btnList = new Style( 0.10, 0.10, 1.0, Frontend.mediumFont, Text.ALIGN_CENTER, new ResourceRef( RID_LIST_PAINT ) );
		
		Button gotoSwatches = osd.createButton( btnList, 0.90, 0.76, CMD_SWATCH, "Open color swatches" );
		
		Style btnSvToPl = new Style( 0.10, 0.10, 1.0, Frontend.mediumFont, Text.ALIGN_CENTER, new ResourceRef( RID_SVTO_PALET ) );
		
		Button savePaintCan = osd.createButton( btnSvToPl, 0.90, 0.92, CMD_SAVE_PAINT, "Save this color to the current palette" );
		
		Style btnLoad = new Style( 0.10, 0.10, 1.0, Frontend.mediumFont, Text.ALIGN_CENTER, new ResourceRef( RID_PAINT_LOAD ) );
		Style btnSave = new Style( 0.10, 0.10, 1.0, Frontend.mediumFont, Text.ALIGN_CENTER, new ResourceRef( RID_PAINT_SAVE ) );
		
		Button loadPalette = osd.createButton( btnLoad, 0.96, 0.76, CMD_LOADCOLORS, "Load saved palette" );
		Button savePalette = osd.createButton( btnSave, 0.96, 0.92, CMD_SAVECOLORS, "Save current palette" );
		
		osd.createRectangle( 0.0, 1.0-(BACKGROUND_HEIGHT/2), 2.0, BACKGROUND_HEIGHT, -1, new ResourceRef( RID_BACKGROUND_RGB ) );
		
		osd.hideGroup( colorMixer = osd.endGroup() );
		
		Style btnPicker = new Style( 0.10, 0.10, 1.0, Frontend.mediumFont, Text.ALIGN_CENTER, new ResourceRef( RID_GOTO_PICKR ) );
		
		Button gotoPicker = osd.createButton( btnPicker, 0.90, 0.76, CMD_COLORPICKER, "Go to RGB picker" );
		
		Style btnClearClrs = new Style( 0.10, 0.10, 1.0, Frontend.mediumFont, Text.ALIGN_CENTER, new ResourceRef( RID_SELL_PAINT ) );
		
		Button clearPaint = osd.createButton( btnClearClrs, 0.90, 0.92, CMD_CLEARCOLORS, "Clear all paint colors" );
		
		osd.hideGroup( paintSelector = osd.endGroup() );
		
		//se bug workaround, fix it! (test with new carrer)
		Part dummy = new Part();
		
		//paint cans
		temporaryCan = new PaintShopDisplay( player, PARTS_VP_LEFT+(PARTS_VP_WIDTH-0.013*4)*4/5+4*0.013, PARTS_VP_TOP, (PARTS_VP_WIDTH-0.013*4)/5, PARTS_VP_HEIGHT, this );
		
		paintCans = new PaintInventory( player, PARTS_VP_LEFT, PARTS_VP_TOP, PARTS_VP_WIDTH, PARTS_VP_HEIGHT, this );
		
		buildStockPaintList();
		
		if ( File.exists( paintCansFile ) )
			paintCans.load( paintCansFile );
		
		if( paintCans.lastCanId < paintCans.items.size() )
		{
			paintCans.paintColor = paintCans.getCanbyIndex( paintCans.lastCanId ).color;
			openHexColor( paintCans.paintColor );
		}
		else
		{
			paintCans.paintColor = paintCans.getCanbyIndex( paintCans.items.size()-1 ).color;
			openHexColor( paintCans.paintColor );
		}
		
		refreshDisplayCan();
	}

	public void buildStockPaintList()
	{
		if( !paintCans.fileCheck( paletteSaveDir + "Basegame" ) )
		{
			// Basegame painter colors
			paintCans.addItem( new PaintCan(  0xF5F5F5, 1.0 ) );
			paintCans.addItem( new PaintCan(  0xB9B9B9, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x7F7F7F, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x505050, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x1D1D1D, 1.0 ) );

			paintCans.addItem( new PaintCan(  0xDC191A, 1.0 ) );
			paintCans.addItem( new PaintCan(  0xAE1515, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x800F0F, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x530A0A, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x250505, 1.0 ) );

			paintCans.addItem( new PaintCan(  0xF58E08, 1.0 ) );
			paintCans.addItem( new PaintCan(  0xC67308, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x8F5306, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x5F3704, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x251501, 1.0 ) );

			paintCans.addItem( new PaintCan(  0xECC613, 1.0 ) );
			paintCans.addItem( new PaintCan(  0xC0A10F, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x91790B, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x615109, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x312904, 1.0 ) );

			paintCans.addItem( new PaintCan(  0xDDE912, 1.0 ) );
			paintCans.addItem( new PaintCan(  0xB7C10E, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x8D950A, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x646A07, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x2E3103, 1.0 ) );

			paintCans.addItem( new PaintCan(  0x23E80E, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x1BB70D, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x158A09, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x0E5B06, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x083303, 1.0 ) );
	
			paintCans.addItem( new PaintCan(  0x12E9C3, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x0EBFA0, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x0A8F78, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x065B4C, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x033028, 1.0 ) );

			paintCans.addItem( new PaintCan(  0x0F3EED, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x0D32BC, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x0A2791, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x071B65, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x020B2E, 1.0 ) );

			paintCans.addItem( new PaintCan(  0xAA0CEB, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x8F0AC6, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x690892, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x44055F, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x20022D, 1.0 ) );

			paintCans.addItem( new PaintCan(  0xEF9DD9, 1.0 ) );
			paintCans.addItem( new PaintCan(  0xCC59AD, 1.0 ) );
			paintCans.addItem( new PaintCan(  0xA32D83, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x77165D, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x470836, 1.0 ) );

			paintCans.addItem( new PaintCan(  0xBAC7E1, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x92A2B1, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x6B7680, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x464D54, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x1F2225, 1.0 ) );

			paintCans.addItem( new PaintCan(  0xEEB70E, 1.0 ) );
			paintCans.addItem( new PaintCan(  0xB7E77E, 1.0 ) );
			paintCans.addItem( new PaintCan(  0xB3E6D2, 1.0 ) );
			paintCans.addItem( new PaintCan(  0xABA685, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x97AF97, 1.0 ) );

			paintCans.addItem( new PaintCan(  0xEEB621, 1.0 ) ); // OLD COLORS
			paintCans.addItem( new PaintCan(  0xE3E3E3, 1.0 ) );
			paintCans.addItem( new PaintCan(  0xD30C0C, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x740404, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x3A0A3C, 1.0 ) );

			paintCans.addItem( new PaintCan(  0xE78B06, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x215504, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x8F8F8F, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x505050, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x1F1F1F, 1.0 ) );

			paintCans.addItem( new PaintCan(  0xCA730D, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x10B5D7, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x004F60, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x5B2D08, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x041C5B, 1.0 ) );
			
			paintCans.save( paletteSaveDir + "BaseGame"  );
			paintCans.deleteAllCans();
		}
		
		if( !paintCans.fileCheck( paletteSaveDir + "UnknownMWM" ) )
		{
			// Colors from some unknown MWM color picker. Extracted from game by hand.
			// If you are the author of this color list, contact me.
			paintCans.addItem( new PaintCan(  0xFFFFFF, 1.0 ) );
			paintCans.addItem( new PaintCan(  0xEFEFEF, 1.0 ) );
			paintCans.addItem( new PaintCan(  0xE6E6E6, 1.0 ) );
			paintCans.addItem( new PaintCan(  0xDEDEDE, 1.0 ) );
			paintCans.addItem( new PaintCan(  0xD2D2D2, 1.0 ) );

			paintCans.addItem( new PaintCan(  0xC7C7C7, 1.0 ) );
			paintCans.addItem( new PaintCan(  0xBDBDBD, 1.0 ) );
			paintCans.addItem( new PaintCan(  0xB2B2B2, 1.0 ) );
			paintCans.addItem( new PaintCan(  0xA7A7A7, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x9C9C9C, 1.0 ) );

			paintCans.addItem( new PaintCan(  0x909090, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x818181, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x717171, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x666666, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x5A5A5A, 1.0 ) );

			paintCans.addItem( new PaintCan(  0x4C4C4C, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x414141, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x363636, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x2A2A2A, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x000000, 1.0 ) );

			paintCans.addItem( new PaintCan(  0xFF0000, 1.0 ) );
			paintCans.addItem( new PaintCan(  0xF00000, 1.0 ) );
			paintCans.addItem( new PaintCan(  0xE60000, 1.0 ) );
			paintCans.addItem( new PaintCan(  0xD70000, 1.0 ) );
			paintCans.addItem( new PaintCan(  0xC80000, 1.0 ) );

			paintCans.addItem( new PaintCan(  0xB40000, 1.0 ) );
			paintCans.addItem( new PaintCan(  0xA00000, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x910000, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x780000, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x640000, 1.0 ) );
	
			paintCans.addItem( new PaintCan(  0xFF9900, 1.0 ) );
			paintCans.addItem( new PaintCan(  0xDF8218, 1.0 ) );
			paintCans.addItem( new PaintCan(  0xDF9C18, 1.0 ) );
			paintCans.addItem( new PaintCan(  0xFF6600, 1.0 ) );
			paintCans.addItem( new PaintCan(  0xDF5A18, 1.0 ) );

			paintCans.addItem( new PaintCan(  0xFBFF00, 1.0 ) );
			paintCans.addItem( new PaintCan(  0xFFFF33, 1.0 ) );
			paintCans.addItem( new PaintCan(  0xFFCC33, 1.0 ) );
			paintCans.addItem( new PaintCan(  0xFFFF99, 1.0 ) );
			paintCans.addItem( new PaintCan(  0xFFFFCC, 1.0 ) );

			paintCans.addItem( new PaintCan(  0xDFDE39, 1.0 ) );
			paintCans.addItem( new PaintCan(  0xC6DE39, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x9CDE39, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x7BDE39, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x5ADE39, 1.0 ) );

			paintCans.addItem( new PaintCan(  0x00FF00, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x00EB00, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x00DC00, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x00C800, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x00B400, 1.0 ) );

			paintCans.addItem( new PaintCan(  0x00A500, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x009600, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x008200, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x007300, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x005F00, 1.0 ) );

			paintCans.addItem( new PaintCan(  0x00FFFF, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x18DFDF, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x5ADFDF, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x82DFDF, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x9CDFDF, 1.0 ) );

			paintCans.addItem( new PaintCan(  0x9CDFDF, 1.0 ) ); // This is a duplicate, but it's kept in order to preserve the color order
			paintCans.addItem( new PaintCan(  0xC6DEDF, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x82DFDE, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x9CDFDE, 1.0 ) );
			paintCans.addItem( new PaintCan(  0xC6DEDF, 1.0 ) ); // Another duplicate - this one on the same page - but whatever

			paintCans.addItem( new PaintCan(  0x0000FF, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x0000F0, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x0000D7, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x0000C3, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x0000AF, 1.0 ) );
			
			paintCans.addItem( new PaintCan(  0x0000FF, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x0000F0, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x0000D7, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x0000C3, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x0000AF, 1.0 ) );
			
			paintCans.addItem( new PaintCan(  0x0000A0, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x000091, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x00007D, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x00006E, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x00005F, 1.0 ) );
			
			paintCans.addItem( new PaintCan(  0x7318C3, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x9C18C3, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x9C39C3, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x9C5AC3, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x9C7BC3, 1.0 ) );

			paintCans.addItem( new PaintCan(  0xC318C3, 1.0 ) );
			paintCans.addItem( new PaintCan(  0xDE18C3, 1.0 ) );
			paintCans.addItem( new PaintCan(  0xDE39C3, 1.0 ) );
			paintCans.addItem( new PaintCan(  0xDE5AC3, 1.0 ) );
			paintCans.addItem( new PaintCan(  0xDE7BC3, 1.0 ) );
			
			paintCans.addItem( new PaintCan(  0x1839DF, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x187BDF, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x1884DF, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x18C3DF, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x0066FF, 1.0 ) );
			
			paintCans.addItem( new PaintCan(  0x663300, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x993300, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x996666, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x663333, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x999900, 1.0 ) );
			
			paintCans.addItem( new PaintCan(  0x669900, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x336600, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x99CC66, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x339900, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x339933, 1.0 ) );
			
			paintCans.addItem( new PaintCan(  0xFF3366, 1.0 ) );
			paintCans.addItem( new PaintCan(  0xCC3366, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x9966CC, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x9999FF, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x333366, 1.0 ) );
			
			paintCans.addItem( new PaintCan(  0x7B1839, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x845A39, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x397B5A, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x18395A, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x189C9C, 1.0 ) );
			
			paintCans.addItem( new PaintCan(  0xCCFF00, 1.0 ) );
			paintCans.addItem( new PaintCan(  0xCC9966, 1.0 ) );
			paintCans.addItem( new PaintCan(  0xCC0066, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x99CC33, 1.0 ) );
			paintCans.addItem( new PaintCan(  0xFF3333, 1.0 ) );
			
			paintCans.addItem( new PaintCan(  0xFF6633, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x9999FF, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x6699FF, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x333366, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x5A185A, 1.0 ) );
			
			paintCans.addItem( new PaintCan(  0x18C35A, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x7BDE5A, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x9CDE5A, 1.0 ) );
			paintCans.addItem( new PaintCan(  0xC6DE5A, 1.0 ) );
			paintCans.addItem( new PaintCan(  0xDFDE5A, 1.0 ) );
			
			paintCans.addItem( new PaintCan(  0x847B7B, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x5A7B7B, 1.0 ) );
			paintCans.addItem( new PaintCan(  0x9C7B7B, 1.0 ) );
			paintCans.addItem( new PaintCan(  0xC67B7B, 1.0 ) );
			paintCans.addItem( new PaintCan(  0xDF9C7B, 1.0 ) );
			
			paintCans.save( paletteSaveDir + "UnknownMWM"  );
			paintCans.deleteAllCans();
		}

		if( !paintCans.fileCheck( paletteSaveDir + "BB93_500ColorsMod" ) )
		{	
			// Colors from BB93 500+ colors mod.
			paintCans.addItem( new PaintCan( 0xFFFFFF, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFCFCFC, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFAFAFA, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xF7F7F7, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xF5F5F5, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xF2F2F2, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xF0F0F0, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xEDEDED, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xEBEBEB, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xE8E8E8, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xE5E5E5, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xE3E3E3, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xE0E0E0, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xDEDEDE, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xDBDBDB, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xD9D9D9, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xD6D6D6, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xD4D4D4, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xD1D1D1, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xCFCFCF, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xCCCCCC, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xC9C9C9, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xC7C7C7, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xC4C4C4, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xC2C2C2, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xBFBFBF, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xBDBDBD, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xBABABA, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xB8B8B8, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xB5B5B5, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xB3B3B3, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xB0B0B0, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xADADAD, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xABABAB, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xA6A6A6, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xA3A3A3, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xA1A1A1, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x9E9E9E, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x9C9C9C, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x999999, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x969696, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x949494, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x919191, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x8F8F8F, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x8C8C8C, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x8A8A8A, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x878787, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x858585, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x828282, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x7F7F7F, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x7D7D7D, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x7A7A7A, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x787878, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x757575, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x737373, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x707070, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x6E6E6E, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x6B6B6B, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x696969, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x666666, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x636363, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x616161, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x5E5E5E, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x5C5C5C, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x595959, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x575757, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x545454, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x525252, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x4F4F4F, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x4D4D4D, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x4A4A4A, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x474747, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x454545, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x424242, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x404040, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x3D3D3D, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x3B3B3B, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x383838, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x363636, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x333333, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x303030, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x2E2E2E, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x2B2B2B, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x292929, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x262626, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x242424, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x212121, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x1F1F1F, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x1C1C1C, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x1A1A1A, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x171717, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x141414, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x121212, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x0F0F0F, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x0D0D0D, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x0A0A0A, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x080808, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x050505, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x030303, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x000000, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xB0171F, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xDC143C, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFFB6C1, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFFAEB9, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xEEA2AD, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xCD8C95, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x8B5F65, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFFC0CB, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFFB5C5, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xEEA9B8, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xCD919E, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x8B636C, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xDB7093, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFF82AB, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xEE799F, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xCD6889, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x8B475D, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFFF0F5, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xEEE0E5, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xCDC1C5, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x8B8386, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFF3E96, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xEE3A8C, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xCD3278, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x8B2252, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xFF69B4, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFF6EB4, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xEE6AA7, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xCD6090, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x8B3A62, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x872657, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFF1493, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xEE1289, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xCD1076, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x8B0A50, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xFF34B3, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xEE30A7, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xCD2990, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x8B1C62, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xC71585, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xD02090, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xDA70D6, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFF83FA, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xEE7AE9, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xCD69C9, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x8B4789, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xD8BFD8, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFFE1FF, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xEED2EE, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xCDB5CD, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x8B7B8B, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFFBBFF, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xEEAEEE, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xCD96CD, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x8B668B, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xDDA0DD, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xEE82EE, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFF00FF, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xEE00EE, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xCD00CD, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x8B008B, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x800080, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xBA55D3, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xE066FF, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xD15FEE, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xB452CD, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x7A378B, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x9400D3, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x9932CC, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xBF3EFF, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xB23AEE, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x9A32CD, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x68228B, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x4B0082, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x8A2BE2, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x9B30FF, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x912CEE, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x7D26CD, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x551A8B, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x9370DB, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xAB82FF, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x9F79EE, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x8968CD, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x5D478B, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x483D8B, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x8470FF, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x7B68EE, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x6A5ACD, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x836FFF, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x7A67EE, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x6959CD, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x473C8B, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xF8F8FF, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xE6E6FA, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x0000FF, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x0000EE, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x0000CD, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x00008B, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x000080, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x191970, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x3D59AB, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x4169E1, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x4876FF, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x436EEE, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x3A5FCD, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x27408B, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x6495ED, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xB0C4DE, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xCAE1FF, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xBCD2EE, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xA2B5CD, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x6E7B8B, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x778899, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x708090, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xC6E2FF, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xB9D3EE, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x9FB6CD, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x6C7B8B, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x1E90FF, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x1C86EE, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x1874CD, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x104E8B, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xF0F8FF, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x4682B4, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x63B8FF, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x5CACEE, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x4F94CD, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x36648B, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x87CEFA, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xB0E2FF, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xA4D3EE, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x8DB6CD, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x607B8B, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x87CEFF, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x7EC0EE, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x6CA6CD, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x4A708B, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x87CEEB, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x00BFFF, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x00B2EE, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x009ACD, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x00688B, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x33A1C9, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xADD8E6, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xBFEFFF, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xB2DFEE, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x9AC0CD, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x68838B, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xB0E0E6, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x98F5FF, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x8EE5EE, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x7AC5CD, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x53868B, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x00F5FF, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x00E5EE, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x00C5CD, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x00868B, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x5F9EA0, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x00CED1, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xF0FFFF, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xE0EEEE, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xC1CDCD, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x838B8B, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xE0FFFF, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xD1EEEE, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xB4CDCD, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x7A8B8B, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xBBFFFF, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xAEEEEE, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x96CDCD, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x668B8B, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x2F4F4F, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x97FFFF, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x8DEEEE, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x79CDCD, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x528B8B, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x00FFFF, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x00EEEE, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x00CDCD, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x008B8B, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x008080, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x48D1CC, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x20B2AA, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x03A89E, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x40E0D0, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x808A87, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x00C78C, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x7FFFD4, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x76EEC6, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x66CDAA, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x458B74, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x00FA9A, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xF5FFFA, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x00FF7F, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x00EE76, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x00CD66, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x008B45, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x3CB371, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x54FF9F, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x4EEE94, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x43CD80, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x2E8B57, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x00C957, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xBDFCC9, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x3D9140, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xF0FFF0, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xE0EEE0, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xC1CDC1, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x838B83, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x8FBC8F, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xC1FFC1, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xB4EEB4, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x9BCD9B, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x698B69, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x98FB98, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x9AFF9A, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x90EE90, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x7CCD7C, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x548B54, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x32CD32, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x228B22, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x00FF00, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x00EE00, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x00CD00, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x008B00, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x008000, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x006400, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x308014, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x7CFC00, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x7FFF00, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x76EE00, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x66CD00, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x458B00, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xADFF2F, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xCAFF70, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xBCEE68, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xA2CD5A, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x6E8B3D, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x556B2F, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x6B8E23, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xC0FF3E, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xB3EE3A, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x9ACD32, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x698B22, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFFFFF0, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xEEEEE0, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xCDCDC1, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x8B8B83, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xF5F5DC, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFFFFE0, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xEEEED1, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xCDCDB4, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x8B8B7A, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFAFAD2, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFFFF00, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xEEEE00, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xCDCD00, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x8B8B00, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x808069, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x808000, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xBDB76B, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFFF68F, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xEEE685, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xCDC673, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x8B864E, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xF0E68C, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xEEE8AA, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFFFACD, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xEEE9BF, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xCDC9A5, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x8B8970, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFFEC8B, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xEEDC82, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xCDBE70, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x8B814C, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xE3CF57, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFFD700, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xEEC900, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xCDAD00, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x8B7500, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xFFF8DC, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xEEE8CD, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xCDC8B1, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x8B8878, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xDAA520, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xFFC125, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xEEB422, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xCD9B1D, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x8B6914, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xB8860B, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xFFB90F, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xEEAD0E, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xCD950C, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x8B6508, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFFA500, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xEE9A00, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xCD8500, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x8B5A00, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFFFAF0, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFDF5E6, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xF5DEB3, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFFE7BA, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xEED8AE, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xCDBA96, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x8B7E66, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xFFE4B5, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFFEFD5, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFFEBCD, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFFDEAD, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xEECFA1, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xCDB38B, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x8B795E, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFCE6C9, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xD2B48C, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x9C661F, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xFF9912, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFAEBD7, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFFEFDB, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xEEDFCC, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xCDC0B0, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x8B8378, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xDEB887, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFFD39B, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xEEC591, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xCDAA7D, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x8B7355, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFFE4C4, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xEED5B7, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xCDB79E, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x8B7D6B, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xE3A869, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xED9121, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFF8C00, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFF7F00, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xEE7600, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xCD6600, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x8B4500, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFF8000, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFFA54F, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xEE9A49, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xCD853F, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x8B5A2B, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFAF0E6, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFFDAB9, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xEECBAD, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xCDAF95, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x8B7765, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFFF5EE, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xEEE5DE, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xCDC5BF, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x8B8682, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xF4A460, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xC76114, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xD2691E, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFF7F24, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xEE7621, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xCD661D, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x8B4513, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x292421, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFF7D40, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xFF6103, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x8A360F, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xA0522D, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFF8247, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xEE7942, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xCD6839, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x8B4726, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFFA07A, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xEE9572, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xCD8162, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x8B5742, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFF7F50, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFF4500, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xEE4000, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xCD3700, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x8B2500, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x5E2612, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xE9967A, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFF8C69, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xEE8262, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xCD7054, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x8B4C39, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFF7256, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xEE6A50, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xCD5B45, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x8B3E2F, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x8A3324, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFF6347, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xEE5C42, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xCD4F39, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x8B3626, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFA8072, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFFE4E1, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xEED5D2, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xCDB7B5, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x8B7D7B, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFFFAFA, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xEEE9E9, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xCDC9C9, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x8B8989, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xBC8F8F, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFFC1C1, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xEEB4B4, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xCD9B9B, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x8B6969, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xF08080, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xCD5C5C, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFF6A6A, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xEE6363, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x8B3A3A, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xCD5555, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xA52A2A, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFF4040, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xEE3B3B, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xCD3333, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x8B2323, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xB22222, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFF3030, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xEE2C2C, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xCD2626, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x8B1A1A, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFF0000, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xEE0000, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xCD0000, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x8B0000, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x800000, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x8E388E, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x7171C6, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x7D9EC0, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x388E8E, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x71C671, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x8E8E38, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xC5C1AA, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xC67171, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x555555, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x1E1E1E, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x282828, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x515151, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x5B5B5B, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x848484, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x8E8E8E, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xAAAAAA, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xB7B7B7, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xC1C1C1, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xEAEAEA, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xF4F4F4, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xFFFFFF, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xF5F5F5, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xDCDCDC, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xD3D3D3, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xC0C0C0, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xA9A9A9, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x808080, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x696969, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x000000, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x001E00, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x380000, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x06002B, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x00003B, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xD79800, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x1ACA83, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x003B77, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x424C50, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x2A3B3A, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x8B0004, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x0A3527, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x15373C, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xD1C3AA, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xE4D69D, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x77000F, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x020304, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xDE9D00, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xB1D247, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x716A60, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x00635C, 1.0 ) );

			paintCans.addItem( new PaintCan( 0xC7AF8A, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x853331, 1.0 ) );
			paintCans.addItem( new PaintCan( 0xDFDED4, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x004E88, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x003F36, 1.0 ) );

			paintCans.addItem( new PaintCan( 0x4B513C, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x424F52, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x597F59, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x8B0004, 1.0 ) );
			paintCans.addItem( new PaintCan( 0x621C20, 1.0 ) );

			
			paintCans.save( paletteSaveDir + "BB93_500ColorsMod"  );
			paintCans.deleteAllCans();
		}
		
		// Stock catalog colors - Default_xxx.png
		paintCans.addItem( new PaintCan(  0x191919, 1.0 ) ); // Default_black.png
		paintCans.addItem( new PaintCan(  0x00115F, 1.0 ) ); // Default_blue.png
		paintCans.addItem( new PaintCan(  0x60310A, 1.0 ) ); // Default_brown.png
		paintCans.addItem( new PaintCan(  0x05BEE5, 1.0 ) ); // Default_cyan.png
		paintCans.addItem( new PaintCan(  0xC16B07, 1.0 ) ); // Default_gold.png
		paintCans.addItem( new PaintCan(  0x969696, 1.0 ) ); // Default_grey.png
		paintCans.addItem( new PaintCan(  0x215A00, 1.0 ) ); // Default_green.png
		paintCans.addItem( new PaintCan(  0xEF8D00, 1.0 ) ); // Default_orange.png
		paintCans.addItem( new PaintCan(  0x390B36, 1.0 ) ); // Default_purple.png
		paintCans.addItem( new PaintCan(  0xC80013, 1.0 ) ); // Default_red.png
		paintCans.addItem( new PaintCan(  0xEBEBEB, 1.0 ) ); // Default_white.png
		paintCans.addItem( new PaintCan(  0xF0BC32, 1.0 ) ); // Default_yellow.png
		
		// Dealer colors - Baiern
		paintCans.addItem( new PaintCan(  0x9B0000, 1.0 ) ); // Devils_eye_red.png
		// Spring yellow is the same as Default_yellow
		
		// Dealer colors - Einvagen
		paintCans.addItem( new PaintCan(  0x362E2F, 1.0 ) ); // Antracit.png
		paintCans.addItem( new PaintCan(  0x300E14, 1.0 ) ); // Black_mage.png
		paintCans.addItem( new PaintCan(  0xF8FFA0, 1.0 ) ); // Champagner.png
		paintCans.addItem( new PaintCan(  0x9B001B, 1.0 ) ); // Cherry.png
		paintCans.addItem( new PaintCan(  0x013223, 1.0 ) ); // Hamvas_Grun.png
		paintCans.addItem( new PaintCan(  0x083030, 1.0 ) ); // Indigo.png
		paintCans.addItem( new PaintCan(  0x102A72, 1.0 ) ); // Jazz.png
		paintCans.addItem( new PaintCan(  0x0053B6, 1.0 ) ); // Mercator_Blau.png
		paintCans.addItem( new PaintCan(  0x980027, 1.0 ) ); // Murano.png
		paintCans.addItem( new PaintCan(  0x00082E, 1.0 ) ); // Nacht.png
		paintCans.addItem( new PaintCan(  0x04283C, 1.0 ) ); // Ozean.png
		paintCans.addItem( new PaintCan(  0xB5B5B7, 1.0 ) ); // Reflex.png
		paintCans.addItem( new PaintCan(  0xFFD248, 1.0 ) ); // Saratoga.png
		paintCans.addItem( new PaintCan(  0x135A2C, 1.0 ) ); // Smaragd.png
		paintCans.addItem( new PaintCan(  0xB10012, 1.0 ) ); // Tornado_rot.png
		paintCans.addItem( new PaintCan(  0xF3F0DD, 1.0 ) ); // Zucker.png
		
		// Dealer colors - Duhen
		paintCans.addItem( new PaintCan(  0x181616, 1.0 ) ); // Black.png
		paintCans.addItem( new PaintCan(  0x049058, 1.0 ) ); // NickyGreen.png
		paintCans.addItem( new PaintCan(  0xC80313, 1.0 ) ); // SourCherry.png
		paintCans.addItem( new PaintCan(  0x7C7C7D, 1.0 ) ); // Tecno.png
		paintCans.addItem( new PaintCan(  0xECF2FC, 1.0 ) ); // WinterSnow.png
		
		// Dealer colors - Focer
		paintCans.addItem( new PaintCan(  0xBE0017, 1.0 ) ); // Flaming.png
		paintCans.addItem( new PaintCan(  0x015930, 1.0 ) ); // Greeny.png
		
		if( !paintCans.fileCheck( paletteSaveDir + "CarCatalog" ) )
			paintCans.save( paletteSaveDir + "CarCatalog" );
	}
	
	
	public void show()
	{
		if( player.decals.size() <= showDecals )
			showDecals = 0;
		
		if( flags & PF_REDUCED_FUNCTIONALITY )
		{
			red0.disable();
			red1.disable();
			
			lastPaintMode = MODE_PAINTPART;
			lastColorMode = COLORMODE_SWATCH;
			lastSliderMode = SLIDERMODE_RGB;
		}
		else
		{
			red0.enable();
			red1.enable();
		}
	
		changeMode( lastPaintMode, lastColorMode, lastSliderMode );
		
		/*if ( File.exists( paintCansFile ) )
			paintCans.load( paintCansFile );
		
		if( paintCans.lastCanId < paintCans.items.size() )
		{
			paintCans.paintColor = paintCans.getCanbyIndex( paintCans.lastCanId ).color;
		}
		else
		{
			paintCans.paintColor = paintCans.getCanbyIndex( paintCans.items.size()-1 ).color;
		}*/
		
//		temporaryCan.paintColor = temporaryCan.getCanbyIndex( temporaryCan.lastCanId ).color;
		
		Input.cursor.addHandler(this); //kivancsiak vagyunk ra, mit csinal az eger
		setEventMask( EVENT_CURSOR );
		
		if( handleControls )
		{
			Input.cursor.setPointer( Frontend.pointers, "D");
			Input.cursor.enable(1);
			Input.getAxis (1, -1);
			css = player.controller.reset();
			player.controller.activateState(ControlSet.CAMTURNSET);
		}
	}
	
	public void hide()
	{
		clearEventMask( EVENT_ANY );
		Input.cursor.remHandler(this);
		
		
		if( handleControls )
			{
				Input.cursor.setPointer( Frontend.pointers, "J");
				Input.cursor.enable(0);
				player.controller.reset(css);
			}
		
		paintCans.save( paintCansFile );
		changeMode(MODE_NONE, COLORMODE_SWATCH, SLIDERMODE_RGB);
		osd.hideGroup(osdGroup);
		
		infoline.changeText( null );
	}

	public void changeMode( int newMode, int newColorMode, int newSliderMode )
	{
		if( mode != newMode || colormode != newColorMode || slidermode != newSliderMode )
		{
			if( mode == MODE_PAINTCOLOR )
			{
				paintCans.hide();
				temporaryCan.hide();
				if( refresherThread )
				{
					refresherThread.stop();
					refresherThread = null;
				}
				osd.hideGroup( osdGroup );
				osd.hideGroup( paintGroup );
				osd.hideGroup( colorsGroup );
				osd.hideGroup( paintSelector );
				osd.hideGroup( colorMixer );
				osd.hideGroup( rgbSliders );
				osd.hideGroup( hsvSliders );
				osd.hideGroup( sprayGroup );
				osd.hideGroup( scrollGroup );
				lastPaintMode=mode;
				lastColorMode=colormode;
				lastSliderMode=slidermode;
			}
			else
			if( mode == MODE_PAINTPART )
			{
				paintCans.hide();
				temporaryCan.hide();
				if( refresherThread )
				{
					refresherThread.stop();
					refresherThread = null;
				}
				osd.hideGroup( osdGroup );
				osd.hideGroup( paintGroup );
				osd.hideGroup( colorsGroup );
				osd.hideGroup( paintSelector );
				osd.hideGroup( colorMixer );
				osd.hideGroup( rgbSliders );
				osd.hideGroup( hsvSliders );
				osd.hideGroup( scrollGroup );
				lastPaintMode=mode;
				lastColorMode=colormode;
				lastSliderMode=slidermode;
			}
			else
			if( mode == MODE_PAINTDECAL )
			{
				clearDecalButtons();
				osd.hideGroup( osdGroup );
				osd.hideGroup( paintGroup );
				osd.hideGroup( decalsGroup );
				osd.hideGroup( brushGroup );
				osd.hideGroup( scrollGroup );
				lastPaintMode=mode;
				lastColorMode=colormode;
				lastSliderMode=slidermode;
			}
			else
			if( mode == MODE_COPY )
			{
				osd.hideGroup( copyGroup );
				osd.hideGroup( osdGroup );
				osd.hideGroup( paintGroup );
				osd.hideGroup( decalsGroup );
				osd.hideGroup( brushGroup );
				osd.hideGroup( scrollGroup );
				lastPaintMode=mode;
				lastColorMode=colormode;
				lastSliderMode=slidermode;
			}
			
			mode=newMode;
			colormode = newColorMode;
			slidermode = newSliderMode;
			
			//-----------mode ONs
			if( mode == MODE_PAINTCOLOR )
			{
				
				invLineTxt.changeText( Integer.toString( temporaryCan.currentLine()+1 ) );
				osd.showGroup( paintGroup );
				osd.showGroup( colorsGroup );
				osd.showGroup( sprayGroup );
				
				if ( colormode == COLORMODE_CUSTOM )
				{
					osd.showGroup( colorMixer );
					if( slidermode == SLIDERMODE_HSV )
					{
						osd.showGroup( hsvSliders );
					}
					else
					{
						osd.showGroup( rgbSliders );
					}
					temporaryCan.show();
					refresherThread = new Thread( this, "Temporary can color refresher" );
					refresherThread.start();
				}
				else
				{
					paintCans.show();
					osd.showGroup( osdGroup );
					osd.showGroup( paintSelector );
					osd.showGroup( scrollGroup );
				}
				
				paintBrush=PAINTBRUSH;
			}
			else
			if( mode == MODE_PAINTPART )
			{
				invLineTxt.changeText( Integer.toString( temporaryCan.currentLine()+1 ) );
				osd.showGroup( paintGroup );
				osd.showGroup( colorsGroup );
				
				if( colormode == COLORMODE_CUSTOM )
				{
					osd.showGroup( colorMixer );
					if( slidermode == SLIDERMODE_HSV )
					{
						osd.showGroup( hsvSliders );
					}
					else
					{
						osd.showGroup( rgbSliders );
					}
					temporaryCan.show();
					refresherThread = new Thread( this, "Temporary can color refresher" );
					refresherThread.start();
				}
				else
				{
					paintCans.show();
					osd.showGroup( osdGroup );
					osd.showGroup( paintSelector );
					osd.showGroup( scrollGroup );
				}
			}
			else
			if( mode == MODE_PAINTDECAL )
			{
				setDecalButtons();
				if( !player.decals.isEmpty() )
				{
					paintBrush=player.decals.elementAt( showDecals );
				}
				else
				paintBrush=null;
				
				osd.showGroup( osdGroup );
				osd.showGroup( paintGroup );
				osd.showGroup( decalsGroup );
				osd.showGroup( brushGroup );
				osd.showGroup( scrollGroup );
			}
			else
			if( mode == MODE_COPY )
			{
				osd.showGroup( paintGroup );
				osd.showGroup( copyGroup );
				osd.showGroup( osdGroup );
				
				if( copy_texture )
					copy_prev.changeTexture( new ResourceRef(copy_texture) ); 
				else
					copy_prev.changeTexture( new ResourceRef(Frontend:0x013Cr) );
				
				Input.cursor.setPointer( Frontend.pointers, "J");
				copy_status = 0;// copy
				copy_button.disable();
				copy_button.label.txt.changeColor( 0xFFFFCB00 );
				paint_button.enable();
			}
		}
	}

	public void changeMode( int newMode )
	{
		changeMode( newMode, colormode, slidermode );
	}
	
	public void changeColorMode( int newColorMode )
	{
		changeMode( mode, newColorMode, slidermode );
	}
	
	public void changeSliderMode( int newSliderMode )
	{
		changeMode( mode, colormode, newSliderMode );
	}
	
	public void changePaintSource (int newPaintSource )
	{
		usingRgbColor = newPaintSource;
	}
	
	native void doPaint( GameRef cursor, int color, int brush, int temp, float rot, float size, int flip );
	native void paintPart( GameRef cursor, int color );
	native void xPaint( GameRef part );
	
	public void beginPaint( int cursor_id )
	{
		paintCursor=new GameRef( cursor_id );
		enableControlHook();
	}
	
	public void endPaint()
	{
		disableControlHook();
		paintCursor=null;
	}
	
	public void setDecalButtons()
	{
		int max = player.decals.size();
		
		clearDecalButtons();
		
		for( int i=0; i<decalButtons.length; i++ )
		{
			//a gomb tipus (kicsi)
			RenderRef base = new RenderRef( misc.garage:0x0083r );
			
			if( max > showDecals+i )
			{
				//duplikaljuk a tipust, hogy a texturamodositas egyedi legyen
				decalButtonTypes[i] = new RenderRef();
				decalButtonTypes[i].duplicate( base );
				
				ResourceRef baseTex = new ResourceRef(misc.garage:0x0103r);//a gomb tipus default texturaja
				ResourceRef rr = player.decals.elementAt( showDecals+i ); //az uj textura
				//lecsereljuk!
				decalButtonTypes[i].changeResource( baseTex, rr );
				decalButtonTextures[i] = rr;
				
				decalButtonInstances[i] = new RenderRef(decalButtons[i], decalButtonTypes[i].id(), "decal button");
				decalButtons[i].queueEvent( null, GameType.EVENT_COMMAND, "render " + decalButtonInstances[i].id() );
			}
			else
			{
				decalButtonTypes[i] = null;//base;
			}
		
		}
		
		invLineTxt.changeText( Integer.toString( (showDecals+1)/decalButtons.length+1 ) );
	}
	
	public void clearDecalButtons()
	{
		for( int i=0; i<decalButtons.length; i++ )
		{
			if( decalButtonInstances[i] )
			{
				decalButtonInstances[i].destroy();
				decalButtonInstances[i]=null;
			}
			if( decalButtonTypes[i] )
			{
				decalButtonTypes[i].destroy();
				decalButtonTypes[i]=null;
			}
			if( decalButtonTextures[i] )
			{
				decalButtonTextures[i].unload();
				decalButtonTextures[i] = null;
			}
		}
	}
	
	
	
	public void handleEvent( GameRef obj_ref, int event, String param )
	{
		int tok = -1;
		
		if( event == EVENT_CURSOR )
		{
			int ec = param.token( ++tok ).intValue();
			
			int cursor_id = param.token( ++tok ).intValue();
			
			if (ec == GameType.EC_LCLICK)
			{
				int obj_id = param.token( ++tok ).intValue(); //ignored now
				Vector3 obj_pos = new Vector3(param.token( ++tok ).floatValue(),
				param.token( ++tok ).floatValue(),
				param.token( ++tok ).floatValue());
				Vector3 worldpos = new Vector3(param.token( ++tok ).floatValue(),
				param.token( ++tok ).floatValue(),
				param.token( ++tok ).floatValue());
				GameRef dest = obj_ref;
				int cat = dest.getInfo(GameType.GII_CATEGORY);
				
				if (mode==MODE_PAINTPART )
				{ 
					if( cat == GIR_CAT_PART || cat == GIR_CAT_VEHICLE )
					{
						SfxSPRAY.play(worldpos, 0.0, 1.0, 1.0, 0); 
						if( usingRgbColor )
							paintPart( new GameRef( cursor_id ), temporaryCan.paintColor|0xFF000000 );
						else
							paintPart( new GameRef( cursor_id ), paintCans.paintColor|0xFF000000 );
					}
				}
				else
				if (mode==MODE_PAINTDECAL)
				{ 
					if( cat == GIR_CAT_PART || cat == GIR_CAT_VEHICLE )
					{
						if( paintBrush )
						{
							SfxDECAL.play(worldpos, 0.0, 1.0, 1.0, 0); 
							doPaint( new GameRef( cursor_id), brushColor, paintBrush.id(), 0, decalRotation, decalSize, decalFlip );
							
							//itt biztos hogy Decal tipusu, es a player.decals-ban van
							if( !(-- ((Decal)paintBrush).stickies ) )
							{
								player.decals.removeElement( paintBrush );
								paintBrush=null;
								
								int max = player.decals.size(); //kiurult sor?
								if( showDecals >= decalButtons.length && showDecals >= max)
									showDecals-=decalButtons.length;
								
								setDecalButtons();
								infoline.changeText( null );
							}
							else
							{
								infoline.changeText( ((Decal)paintBrush).stickies + " stickies left" ); //mirrored!
							}
						}
					}
				}
				else
				if( mode == MODE_COPY )
				{
					if( copy_status == 0)// Copy
					{
						Object part = obj_ref.getScriptInstance();
						if( part instanceof Part || part instanceof Chassis ) // clicked object is part or chassis
						{
							copy_texture = part.getTexture();
							
							if( copy_texture )
								copy_prev.changeTexture( new ResourceRef(copy_texture) ); 
							else
							{
								SfxWARN.play();
								copy_prev.changeTexture( new ResourceRef(Frontend:0x013Cr) );
								
							}
							
							//infoline.changeText(copy_texture); //Debug
						}
					}
					else // Paint
					{
						Object part = obj_ref.getScriptInstance();
						if( part instanceof Part || part instanceof Chassis ) // clicked object is part or chassis
						{
							int tmp_texture = part.getTexture();// check is this part paintable
							
							if( copy_texture && tmp_texture )
							{
								SfxDECAL.play(worldpos, 0.0, 1.0, 1.0, 0);
								
								ResourceRef temp_texture = new ResourceRef();
								temp_texture.duplicate(new ResourceRef(copy_texture));
								
								part.setTexture( temp_texture.id() );
								
							}
							else
							SfxWARN.play();
						}
					}
				}
			}
			else
			if (ec == GameType.EC_LDOWN)
			{
				if( overVehicle )
				{
					if (mode==MODE_PAINTCOLOR)
					{
						Vector3 worldpos = Input.cursor.getPickedPos();
						spraySfxID = SfxSPRAY.play( worldpos, 0.0, 1.0, 1.0, SfxRef.SFX_LOOP | SfxRef.SFX_NOAUTOSTOP, Input.cursor.id() ); //start looped sfx
						spraySfxOn=1;
						beginPaint( cursor_id );
					}
				}
			} 
			else
			if (ec == GameType.EC_LUP)
			{
				if (mode==MODE_PAINTCOLOR)
				{
					if( spraySfxOn )
					{
						SfxSPRAY.stop( spraySfxID ); //end looped sfx
						spraySfxOn=0;
					}
					endPaint();
				}
			}
			else
			if (ec == GameType.EC_HOVER)
			{
				GameRef part, dest = new GameRef(param.token( ++tok ).intValue());
				int objectChanged;
				
				Object p = dest.getScriptInstance();
				if( p instanceof Part )
				{
					if( !overVehicle )
					{
						overVehicle=1;
						objectChanged=1;
					}
				}
				else
				{
					if( overVehicle )
					{
						overVehicle=0;
						objectChanged=1;
					}
				}
				
				if (mode==MODE_PAINTDECAL)
				{
					if( objectChanged )
					{
						if( overVehicle )
						{
							beginPaint( cursor_id );
						}
						else
						{
							endPaint();
							//flush texture
							if( player.car )
								xPaint( player.car );
						}
					}
				}
			}
			else
			if (ec == GameType.EC_RDRAGBEGIN)
			{
				//enable camera control with mouse
				//player.controller.user_Add( Input.AXIS_LOOK_UPDOWN, ControlSet.MOUSE, 1, -1.0f, 1.0f, -1.0f, 1.0f);
				//player.controller.user_Add( Input.AXIS_LOOK_LEFTRIGHT, ControlSet.MOUSE, 0, -1.0f, 1.0f, -1.0f, 1.0f);
				//disable cursor movement
				player.controller.user_Del( Input.AXIS_CURSOR_X, ControlSet.MOUSE, 0 );
				player.controller.user_Del( Input.AXIS_CURSOR_Y, ControlSet.MOUSE, 1 );
				Input.cursor.cursor.queueEvent( null, GameType.EVENT_COMMAND, "lock" );
			} 
			else
			if (ec == GameType.EC_RDRAGEND)
			{
				//disable camera control with mouse
				//player.controller.user_Del( Input.AXIS_LOOK_UPDOWN, ControlSet.MOUSE, 1 );
				//player.controller.user_Del( Input.AXIS_LOOK_LEFTRIGHT, ControlSet.MOUSE, 0 );
				//enable cursor movement
				player.controller.user_Add( Input.AXIS_CURSOR_X, ControlSet.MOUSE, 0, -1.0f, 1.0f, -1.0f, 1.0f);
				player.controller.user_Add( Input.AXIS_CURSOR_Y, ControlSet.MOUSE, 1, -1.0f, 1.0f, -1.0f, 1.0f);
				Input.cursor.cursor.queueEvent( null, GameType.EVENT_COMMAND, "unlock" );
			} 
		}
	}
	
	public void control( float t )
	{
		if( mode == MODE_PAINTDECAL )
		{
			if( paintBrush )
				doPaint( paintCursor, brushColor, paintBrush.id(), 1, decalRotation, decalSize, decalFlip);
		}
		else
		if( mode == MODE_PAINTCOLOR )
		{
			Vector3 worldpos = Input.cursor.getPickedPos();
			spraySfxID = SfxSPRAY.play( worldpos, 0.0, 1.0, 1.0, SfxRef.SFX_LOOP | SfxRef.SFX_NOAUTOSTOP, Input.cursor.id() ); //update looped sfx
			
			doPaint( paintCursor, temporaryCan.paintColor|0x66000000, paintBrush.id(), 0, decalRotation, decalSize, decalFlip);
		}
	}
	
	public void osdCommand( int cmd )
	{
		if( cmd == CMD_LOADSKIN )
		{
			VehicleSkinFileReqDialog d = new VehicleSkinFileReqDialog( player.controller, Dialog.DF_FREEZE|Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "LOAD PAINT JOB", "LOAD", GameLogic.skinSaveDir, "*" );
			
			if( d.display() == 0 )
			{
				String filename = GameLogic.skinSaveDir + d.fileName;
				player.car.loadSkin( filename );
			}
		}
		else
		if( cmd == CMD_SAVESKIN )
		{
			VehicleSkinFileReqDialog d = new VehicleSkinFileReqDialog( player.controller, Dialog.DF_FREEZE|Dialog.DF_MODAL|Dialog.DF_DEFAULTBG|Dialog.FRF_SAVE, "SAVE PAINT JOB", "SAVE", GameLogic.skinSaveDir, "*" );
			
			if( d.display() == 0 )
			{
				String filename = GameLogic.skinSaveDir + d.fileName;
				if (File.exists(filename))
				{
					File.delete( filename );
					File.delete( filename + ".*" );
				}
				player.car.saveSkin( filename );
				
				new WarningDialog( player.controller, Dialog.DF_FREEZE|Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "SAVE PAINT JOB", "Paint job has been saved." ).display();
			}
		}
		else
		if( cmd == CMD_SCROLL_UP )
		{
			if(( mode == MODE_PAINTCOLOR || mode == MODE_PAINTPART ) && colormode == COLORMODE_SWATCH )
			{
				paintCans.upScroll();
				invLineTxt.changeText( Integer.toString( paintCans.currentLine()+1 ) );
			}
			else
			if( mode == MODE_PAINTDECAL )
			{
				int max = player.decals.size();
				if( max > decalButtons.length )
				{
					if( showDecals >= decalButtons.length )
					{
						showDecals-=decalButtons.length;
					}
					else
					{
						showDecals=(max-1)-((max-1)%decalButtons.length);
					}
					setDecalButtons();
				}
			}
		}
		else
		if( cmd == CMD_SCROLL_DOWN )
		{
			if(( mode == MODE_PAINTCOLOR || mode == MODE_PAINTPART ) && colormode == COLORMODE_SWATCH )
			{
				paintCans.downScroll();
				invLineTxt.changeText( Integer.toString( paintCans.currentLine()+1 ) );
			}
			else
			if( mode == MODE_PAINTDECAL )
			{
				int max = player.decals.size();
				if( max > decalButtons.length )
				{
					if( showDecals+decalButtons.length < max )
					{
						showDecals+=decalButtons.length;
					}
					else
					{
						showDecals=0;
					}
					setDecalButtons();
				}
			}
		}
		else
		if( cmd == CMD_C_COPY )
		{
			copy_button.disable();
			copy_button.label.txt.changeColor( 0xFFFFCB00 );
			paint_button.enable();
			
			copy_status = 0;
			Input.cursor.setPointer( Frontend.pointers, "J"); //Default arrow
		}
		else
		if( cmd == CMD_C_PAINT )
		{
			copy_button.enable();
			paint_button.disable();
			paint_button.label.txt.changeColor( 0xFFFFCB00 );
			
			copy_status = 1;
			Input.cursor.setPointer( Frontend.pointers, "D"); // spray
		}
		else
		if( cmd == CMD_COPYSKIN )
		{
			changeMode( MODE_COPY );
		}
		if( cmd == CMD_SPRAY )
		{
			changeMode( MODE_PAINTCOLOR );
		}
		else
		if( cmd == CMD_PART )
		{
			changeMode( MODE_PAINTPART );
		}
		else
		if( cmd == CMD_DECALS )
		{
			changeMode( MODE_PAINTDECAL );
		}
		else
		if( cmd == CMD_BRUSHRCCW )
		{
			decalRotation -= 0.025;
		}
		else
		if( cmd == CMD_BRUSHRCW )
		{
			decalRotation += 0.025;
		}
		else
		if( cmd == CMD_BRUSHINC )
		{
			if( decalSize < 4.2 )
				decalSize+= 0.025;
		}
		else
		if( cmd == CMD_BRUSHDEC )
		{
			if( decalSize > 0.05 )
				decalSize-= 0.025;
		}
		else
		if( cmd == CMD_BRUSHFLIP )
		{
			decalFlip=1-decalFlip;
		}
		else
		if( cmd >= CMD_DECALBUTTONS && cmd <= CMD_DECALBUTTONS + decalButtons.length )
		{
			int decalIndex = showDecals+cmd-CMD_DECALBUTTONS;
			if( player.decals.size() > decalIndex )
			{
				paintBrush=player.decals.elementAt( decalIndex );
				infoline.changeText( ((Decal)paintBrush).stickies + " stickies left" ); //mirrored!
			}
		}
		if( cmd >= CMD_SLIDER_R && cmd <= CMD_SLIDER_B )
		{
			if( cmd == CMD_SLIDER_R )
				paintRed = osd.sliderValue;
			if( cmd == CMD_SLIDER_G )
				paintGreen = osd.sliderValue;
			if( cmd == CMD_SLIDER_B )
				paintBlue = osd.sliderValue;
			queueHexColor = rgb2hex( paintRed, paintGreen, paintBlue );
			usingRgbColor = 1;
			//refreshDisplayCan();
		}
		if( cmd >= CMD_SLIDER_H && cmd <= CMD_SLIDER_V )
		{
			if( cmd == CMD_SLIDER_H )
				paintHue = osd.sliderValue;
			if( cmd == CMD_SLIDER_S )
				paintSaturation = osd.sliderValue;
			if( cmd == CMD_SLIDER_V )
				paintValue = osd.sliderValue;
			newRgb = PainterExtensions.hsv2rgb( paintHue, paintSaturation, paintValue );
			paintRed = newRgb[0];
			paintGreen = newRgb[1];
			paintBlue = newRgb[2];
			queueHexColor = rgb2hex( paintRed, paintGreen, paintBlue );
			usingRgbColor = 1;
			//refreshDisplayCan();
		}
		else
		if( cmd == CMD_SAVE_PAINT )
		{
			paintCans.addItem( new PaintCan( queueHexColor, 1.0 ) );
		}
		if( cmd == CMD_SWATCH )
		{
			changeColorMode( COLORMODE_SWATCH );
		}
		if( cmd == CMD_COLORPICKER )
		{
			changeColorMode( COLORMODE_CUSTOM );
		}
		if( cmd == CMD_RGB )
		{
			osd.findGadget( this, CMD_SLIDER_R ).setValue( paintRed );
			osd.findGadget( this, CMD_SLIDER_G ).setValue( paintGreen );
			osd.findGadget( this, CMD_SLIDER_B ).setValue( paintBlue );
			changeSliderMode( SLIDERMODE_RGB );
		}
		if( cmd == CMD_HSV )
		{
			newHsv = PainterExtensions.rgb2hsv( paintRed, paintGreen, paintBlue );
			paintHue = newHsv[0];
			paintSaturation = newHsv[1];
			paintValue = newHsv[2];
			osd.findGadget( this, CMD_SLIDER_H ).setValue( paintHue );
			osd.findGadget( this, CMD_SLIDER_S ).setValue( paintSaturation );
			osd.findGadget( this, CMD_SLIDER_V ).setValue( paintValue );
			changeSliderMode( SLIDERMODE_HSV );
		}
		if( cmd == CMD_CLEARCOLORS )
		{
			int reallyDelete;

			reallyDelete = ( 0 == new NoYesDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "Clear all paint colors", "This will delete all your paint colors except the last one in the list. Do you really want to clear all your paint colors?" ).display() );
			
			if( reallyDelete )
			{
				paintCans.cleanCans();
				paintCans.save( paintCansFile );
				new SfxRef( Frontend.SFX_MONEY ).play();
			}
		}
		if( cmd == CMD_LOADCOLORS )
		{
			ColorPaletteFileReqDialog d = new ColorPaletteFileReqDialog( player.controller, Dialog.DF_FREEZE|Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "LOAD COLOR PALETTE", "LOAD", paletteSaveDir, "*" );
			
			if( d.display() == 0 )
			{
				String filename = paletteSaveDir + d.fileName;
				paintCans.load( filename );
			}
		}
		else
		if( cmd == CMD_SAVECOLORS )
		{
			ColorPaletteFileReqDialog d = new ColorPaletteFileReqDialog( player.controller, Dialog.DF_FREEZE|Dialog.DF_MODAL|Dialog.DF_DEFAULTBG|Dialog.FRF_SAVE, "SAVE COLOR PALETTE", "SAVE", paletteSaveDir, "*" );
			
			if( d.display() == 0 )
			{
				String filename = paletteSaveDir + d.fileName;
				if (File.exists(filename))
				{
					File.delete( filename );
				}
				paintCans.save( filename );
				
				new WarningDialog( player.controller, Dialog.DF_FREEZE|Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "SAVE COLOR PALETTE", "The current color palette has been saved to '" + filename + "'." ).display();
			}
		}
		else
		if( cmd == CMD_INPUTCOLOR )
		{
			int typedColor;
			StringRequesterDialog d = new StringRequesterDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG|Dialog.SIF_NOEMPTY, "Enter New Paint Color (Format: R255, G255, B255)", "" );
			if( d.display() == 0 )
			{
				String typedR = d.input.token( 0, "," );
				String typedG = d.input.token( 1, "," );
				String typedB = d.input.token( 2, "," );
				if( typedR && typedG && typedB )
				{
					typedColor = rgb2hex( typedR.intValue(), typedG.intValue(), typedB.intValue() );
					openHexColor( typedColor );
				}
			}
		}
	}
	
	public int rgb2hex( int R, int G, int B )
	{
		int hexColor = 0x000000;
		hexColor = hexColor + (0x010000*R) + (0x000100*G) + (0x000001*B);
		return hexColor;
	}
	
	public String prepareHexString( int input )
	{
		String storeString = Integer.toHexString( input ).token( 1, "x" );
		String prepareString = "";
		int i;
		if( storeString.token(i, "123456789abcdef").length() > 2 )
		{
			int newzeros = storeString.token(0, "123456789abcdef").length()-2;
			for( i = 0; i < newzeros; i++ )
			{
				prepareString = prepareString + "0";
			}
		}
		for( i = 0; i <= 2; i++)
		{
			prepareString = prepareString + ( storeString.token(i, "0") ) + ( storeString.token(1+i, "123456789abcdef") );
		}
		return prepareString;
	}
	
	public void openHexColor( int newColor )
	{
		int newRed = newColor / 0x00010000;
		int newGreen = (newColor-newRed*0x00010000) / 0x00000100;
		int newBlue = newColor-newGreen*0x00000100-newRed*0x00010000;
		paintRed = newRed;
		paintGreen = newGreen;
		paintBlue = newBlue;
		osd.findGadget( this, CMD_SLIDER_R ).setValue( newRed );
		osd.findGadget( this, CMD_SLIDER_G ).setValue( newGreen );
		osd.findGadget( this, CMD_SLIDER_B ).setValue( newBlue );
		queueHexColor = newColor;
		refreshDisplayCan();
		
		newHsv = PainterExtensions.rgb2hsv( paintRed, paintGreen, paintBlue );
		paintHue = newHsv[0];
		paintSaturation = newHsv[1];
		paintValue = newHsv[2];
		osd.findGadget( this, CMD_SLIDER_H ).setValue( paintHue );
		osd.findGadget( this, CMD_SLIDER_S ).setValue( paintSaturation );
		osd.findGadget( this, CMD_SLIDER_V ).setValue( paintValue );
	}
	
	public void refreshDisplayCan()
	{
		temporaryCan.removeItem( temporaryCan.lastCanId );
		temporaryCan.addItem( new PaintCan( queueHexColor, 1.0 ) );
		hexButton.changeLabelText( "#" + prepareHexString( queueHexColor ) );
	}
	
	public void run()
	{
		for(;;)
		{
			if( queueHexColor != oldQueueHexColor )
			{
				oldQueueHexColor = queueHexColor;
				refreshDisplayCan();
			}

			refresherThread.sleep( 40 );
		}
	}
}

class PaintInventory extends VisualInventory
{
	int paintColor;
	int lastCanId;

	final static int	CANSFILEID = 0xe21cd8ba; //totally random hex hash - let's hope this works
	final static int	CANSFILEVERSION = 1;
	
	Painter painter;
	
	public PaintInventory( Player player, float left, float top, float width, float height, Painter p )
	{
		super( player, left, top, width, height, 1 );
		painter = p;
		
		// super( player );
		
		// initVisuals( left, top, width, height );
	}
	
	public PaintInventory( Player player, float left, float top, float width, float height, Painter p, int intr )
	{
		super( player, left, top, width, height, intr );
		painter = p;
		
		// super( player );
		
		// initVisuals( left, top, width, height );
	}
	
// 	public void leftClick( int id )
// 	{
// 		if( id >= items.size() ) //sohasem legyen ures!!
// 		id = items.size()-1;
// 		
//		lastCanId=id;
//
//	 	PaintCan pc = getCanbyIndex( id );
// 		paintColor = pc.color;
//
//	 	new SfxRef( Frontend.SFX_MENU_SELECT ).play(); 
// 	}
	
// 	public void leftDragNDrop( GameRef draggedOnto, GameRef draggedItem )
// 	{
// 	}
	
	public void panelLeftClick( int index )
	{
		index += currentLine()*partsPerLine;
		
		if( index < items.size() ) //sohasem legyen ures!!
		{
			lastCanId=index;
			painter.changePaintSource(0);
			
			PaintCan pc = getCanbyIndex( index );
			paintColor = pc.color;
			painter.openHexColor( paintColor );
			
			new SfxRef( Frontend.SFX_MENU_SELECT ).play();
		}
	}
	
	public void panelSwap( int index_a, Gadget dropped )
	{
	}
	
	public void panelDragNDrop( int index, GameRef dropped )
	{
	}
	
	public int addItem( PaintCan p )
	{
		if( !items.size() )
			paintColor=p.color;
		
		return super.addItem( p );
	}
	
	public void removeItem( int index )
	{
		super.removeItem( index );
	}
	
	public void removeItem( InventoryItem item )
	{
		super.removeItem( item );
	}
	
	public void save( String fileName )
	{
		File cansFile = new File( fileName );

		if( cansFile.open( File.MODE_WRITE ) )
		{
			int		i;

			cansFile.write( CANSFILEID );
			cansFile.write( CANSFILEVERSION );

			cansFile.write( this.items.size() );
			cansFile.write( this.lastCanId );
			//System.log("Saved header, number of colors = " + this.items.size() );
			for( i = 0; i < this.items.size(); i++ )
			{
				PaintCan pc = getCanbyIndex( i );
				cansFile.write( pc.color );
			}
			cansFile.close();
		}
	}

	public static int fileCheck( String fileName )
	{
		int	status;
		if( fileName != Painter.paintCansFile )
		{
			File cansFile = new File( fileName );

			if( cansFile.open( File.MODE_READ ) )
			{
				if( cansFile.readInt() == CANSFILEID )
					if( cansFile.readInt() == CANSFILEVERSION )
						status = 1;

				cansFile.close();
			}
		}
		return status;
	}

	public void load( String fileName )	
	{
		File cansFile = new File( fileName );
		if( cansFile.open( File.MODE_READ ) )
		{
			if( cansFile.readInt() == CANSFILEID )
			{
				if( cansFile.readInt() == CANSFILEVERSION )
				{
					items = new Vector();
					int			i, n;
					int[]			newColors;
					n = cansFile.readInt();
					lastCanId = cansFile.readInt();
					//System.log("Read header, number of colors = " + n);
					for( i = 0; i < n; i++ )
					{
						this.addItem( new PaintCan( cansFile.readInt(), 1.0 ) );
					}
					scrollTo( lastCanId );
					painter.invLineTxt.changeText( Integer.toString( this.currentLine()+1 ) );
				}
			}
			cansFile.close();
		}
	}
	
	public void deleteAllCans()
	{
		items = new Vector();
		scrollTo( 0 );
		painter.invLineTxt.changeText( Integer.toString( this.currentLine()+1 ) );
	}
	
	public void cleanCans()
	{
		deleteAllCans();
		this.addItem( new PaintCan( painter.queueHexColor, 1.0 ) );
	}
}

class PaintShopDisplay extends PaintInventory
{
	public void initVisuals( float left, float top, float width, float height )
	{
		partsPerLine = 1;
		linesPerPage = 1;
		//mely itemek lehetnek lathatoak kezdetben?
		cline=0;
		start = cline * partsPerLine;
		stop = start + linesPerPage * partsPerLine;

		float hSpacing = 0.013, vSpacing = 0.01;
		float	itemWidth, itemHeight;
		itemWidth=(width-(partsPerLine-1)*hSpacing)/partsPerLine;
		itemHeight=(height-(linesPerPage-1)*vSpacing)/linesPerPage;

		panels=new InventoryPanel[partsPerLine*linesPerPage];

		int	index;
		float cheight=top;
		for( int i=0; i<linesPerPage; i++ )
		{
			float cwidth=left;
			for( int j=0; j<partsPerLine; j++ )
			{
				index = i*partsPerLine+j;
				panels[index]=new InventoryPanel( this, index, cwidth, cheight, itemWidth, itemHeight );
				cwidth+=itemWidth+hSpacing;
			}
			cheight+=itemHeight+vSpacing;
		}
	}
	
	public void panelLeftClick( int index )
	{
		index += currentLine();
		
		if( index < items.size() ) //sohasem legyen ures!!
		{
			lastCanId=index;
			painter.changePaintSource(1);
			
			PaintCan pc = getCanbyIndex( index );
			paintColor = pc.color;
			
			new SfxRef( Frontend.SFX_MENU_SELECT ).play();
		}
	}
}

//
class VehicleSkinFileReqDialog extends FileRequesterDialog
{
	public VehicleSkinFileReqDialog( Controller ctrl, int myflags, String mytitle, String OKButtonText, String path, String mask )
	{
		super( ctrl, myflags, mytitle, OKButtonText, path, mask );
	}
	
	public int validator( String filename )
	{
		return Vehicle.fileCheck_Skin( filename );
	}
}

class ColorPaletteFileReqDialog extends FileRequesterDialog
{	
	public ColorPaletteFileReqDialog( Controller ctrl, int myflags, String mytitle, String OKButtonText, String path, String mask )
	{
		super( ctrl, myflags, mytitle, OKButtonText, path, mask );
	}
	
	public int validator( String filename )
	{
		return PaintInventory.fileCheck( filename );
	}
}