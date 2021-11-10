package java.game;

import java.io.*;
import java.util.*;
import java.util.resource.*;
import java.render.*;	//Text
import java.render.osd.*;	//Text
import java.render.osd.dialog.*;	//Text
import java.sound.*;
import java.game.parts.*;

/********************************************
*			Driver Selector v1.1			*
*		By Miran, base on Wichur's script	*
*				XII.2007					*
********************************************/

public class DriverSelect extends Scene implements GameState
{

	final static int  	CMD_BACK	= 1;
	final static int  	CMD_OK		= 2;
	final static int  	CMD_ABOUT	= 3;
	final static int  	CMD_DRIVER	= 4;
	final static int  	CMD_PREV	= 5;
	final static int  	CMD_NEXT	= 6;
	final static int  	CMD_UP		= 7;
	final static int  	CMD_DOWN	= 8;

	final static int	CMD_SKIN0 = 20;
	final static int	CMD_SKIN1 = 21;
	final static int	CMD_SKIN2 = 22;
	final static int	CMD_SKIN3 = 23;
	final static int	CMD_SKIN4 = 24;
	final static int	CMD_SKIN5 = 25;
	final static int	CMD_SKIN6 = 26;
	final static int	CMD_SKIN7 = 27;
	final static int	CMD_SKIN8 = 28;
	final static int	CMD_SKIN9 = 29;

	final static int	CMD_NODRIVER	= 30;
	final static int	CMD_DEFAULT		= 31;
	final static int	CMD_POLICEMAN	= 32;

	int ModelsAmount = 3;

// OSD stuff:
	Button UpButton, DownButton, TakeButton, ItemButton0, ItemButton1, ItemButton2, ItemButton3, ItemButton4, ItemButton5, ItemButton6, ItemButton7, ItemButton8, ItemButton9;
	Style Menu_Button, Menu_Center, bsm, Menu_Left, Menu_Right;
	Text CurrentPageText, ModelInfo;
	Menu m;
	GameState prev_state;

	final static int	 BackGroundVideo;
	ResourceRef CurrentTexure, CurrentTextureRes, OrginalMeshRes, OrginalTextureRes, TempTxt;
	int			Mode, CurrentPage, CurrentName, Amount, number, CurrentModel;
	RenderRef	CurrentDriver, TempRender;
	
	GameRef		Scene;
	Camera		Cam;
	RenderRef	Sun, Light;

	String		CurrentBoxDirectory;
	Vector		CurrentBox, ModelsBox;

	Osd				osd;
	GameState		parentState;
	Bot				bot;
	Player			player;
	Vehicle			Vehicle;
	
	public DriverSelect()
	{
		float key = Math.random()*100;
		if( MainMenu.Check(key) != Math.sqrt(key)+3.75 )
		{
			new WarningDialog( GameLogic.player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "PROTECTION ERROR", "Miran Wichur Mod protection error: \n \n CORRUPTED FILES \n \n Sorry game will be close. \n Please reinstall Miran Wichur Mod." ).display();
			GameLogic.changeActiveSection( null );
		}

		createNativeInstance();

		Mode = 0;
	}

	public DriverSelect( int p )
	{
		float key = Math.random()*100;
		if( MainMenu.Check(key) != Math.sqrt(key)+3.75 )
		{
			new WarningDialog( GameLogic.player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "PROTECTION ERROR", "Miran Wichur Mod protection error: \n \n CORRUPTED FILES \n \n Sorry game will be close. \n Please reinstall Miran Wichur Mod." ).display();
			GameLogic.changeActiveSection( null );
		}

		createNativeInstance();

		Mode = p;
	}

	final static public float Check( float key )
	{
		return Math.sqrt(key)+3.75;
	}

    public void enter( GameState prevState )
    {
		Frontend.loadingScreen.show();

		osd = new Osd();
		osd.globalHandler = this;

		setEventMask( EVENT_TIME );

		createOSDObjects();
		osd.show();

		Input.cursor.enable(1);
		setEventMask( EVENT_CURSOR );

		if( !parentState )
			parentState=prevState;

		if( !prevState instanceof Garage )
			new SfxRef( GameLogic.SFX_LEAVEGARAGE ).play();

		Frontend.loadingScreen.display();
	}

	public void exit( GameState nextState )
	{
		Frontend.loadingScreen.show();

		clearEventMask( EVENT_ANY );
		removeAllTimers();
		Input.cursor.enable(0);

		Light.destroy();

		osd.hide();
		osd.finalize();

		if( !nextState instanceof Garage )
		{
			new SfxRef( GameLogic.SFX_LEAVEGARAGE ).play(); 
		}
		//osd background renderer cleanup
		if( BackGroundVideo )
			GfxEngine.closeVideo();

		Frontend.loadingScreen.display();
	}

	public void createOSDObjects()
	{
		Scene = new Dummy( WORLDTREEROOT );
		Cam = new Camera( Scene, osd.getViewport(), 8 );
		Cam.setMatrix( new Vector3(-2.6,0.0,-2.2), new Ypr(-2.0,0,0) );
			
		RenderRef Sun = new RenderRef(maps.skydome:0x0024r);
		Sun.setLight( 0x00DC6464, 0x00646464, 0x00C8C8C8);
		Light = new RenderRef( Scene, Sun, "light for this scene" );

	// Create Styles:
		Menu_Center = new Style( 0.4, 0.13, Frontend.mediumFont, Text.ALIGN_CENTER, null );
		Menu_Left = new Style( 0.4, 0.13, Frontend.mediumFont, Text.ALIGN_LEFT, Osd.RRT_TEST );
		Menu_Right = new Style( 0.4, 0.13, Frontend.mediumFont, Text.ALIGN_RIGHT, Osd.RRT_TEST );
		Menu_Button = new Style( 0.12, 0.12, Frontend.mediumFont, Text.ALIGN_CENTER, null );

		osd.createHeader( "DRIVER SELECTOR" );
		osd.createBG(new ResourceRef(system:0x0016r));

		CurrentPageText = osd.createText( "", Frontend.largeFont, Text.ALIGN_CENTER, -0.6, -0.86 ); CurrentPageText.changeColor(0xFFC0C0C0);// "Unselected" gray

		m = osd.createMenu( Menu_Button, -0.90,  -0.833, Osd.MD_VERTICAL ); 
		UpButton = m.addItem( new ResourceRef( frontend:0x00AFr ), CMD_UP, "Prev Page" );

		m = osd.createMenu( Menu_Button, -0.30,  -0.833, Osd.MD_VERTICAL ); 
		DownButton = m.addItem( new ResourceRef( frontend:0x00AFr ), CMD_DOWN, "Next Page" );

		m = osd.createMenu( Menu_Right, 0.98, -0.95, 0 );
		m.addItem( "ABOUT", CMD_ABOUT );

		m= osd.createMenu( Menu_Left, -0.98, -0.60, 0 );
		ItemButton0 = m.addItem( "" , CMD_SKIN0 );
		ItemButton1 = m.addItem( "" , CMD_SKIN1 );
		ItemButton2 = m.addItem( "" , CMD_SKIN2 );
		ItemButton3 = m.addItem( "" , CMD_SKIN3 );
		ItemButton4 = m.addItem( "" , CMD_SKIN4 );
		ItemButton5 = m.addItem( "" , CMD_SKIN5 );
		ItemButton6 = m.addItem( "" , CMD_SKIN6 );
		ItemButton7 = m.addItem( "" , CMD_SKIN7 );
		ItemButton8 = m.addItem( "" , CMD_SKIN8 );
		ItemButton9 = m.addItem( "" , CMD_SKIN9 );

		m = osd.createMenu( Menu_Right, 0.98, 0.95, 0 );
		TakeButton = m.addItem( "TAKE IT", CMD_OK );

		osd.createText( "CHANGE MODEL", Frontend.largeFont, Text.ALIGN_CENTER, 0.01, -0.980 ).changeColor(0xFFC0C0C0);// "Unselected" gray
		ModelInfo = osd.createText( "-NO MODEL SELECTED-", Frontend.largeFont, Text.ALIGN_CENTER, 0.01, 0.920 ); ModelInfo.changeColor(0xFFC0C0C0);// "Unselected" gray

		m = osd.createMenu( Menu_Button, -0.35,  0.94, Osd.MD_VERTICAL ); 
		m.addItem( new ResourceRef( frontend:0x0085r ), CMD_PREV, "Prev Model" );

		m = osd.createMenu( Menu_Button, 0.35,  0.94, Osd.MD_VERTICAL ); 
		m.addItem( new ResourceRef( frontend:0x0088r ), CMD_NEXT, "Next Model" );

		m = osd.createMenu( Menu_Left, -0.98, 0.95, 0 );
		m.addItem( "BACK" , CMD_BACK );
		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL|Osd.HK_STATIC, CMD_BACK, this );// ESC key = CMD_BACK

		CurrentModel = CMD_DEFAULT;
		osdCommand( CMD_DEFAULT );
	}

	public void RefreshRender()
	{
		//if(TempRender) TempRender.destroy();
		//TempRender = null;
		if(CurrentDriver) CurrentDriver.destroy();  
		
		TempRender = new RenderRef();
		TempRender.duplicate( new RenderRef(OrginalMeshRes) );
		TempRender.changeResource( OrginalTextureRes, CurrentTextureRes ); // Change texture
		
		CurrentDriver = new RenderRef( Scene, TempRender, "Driver Render" );
	}

	public void RefreshOsd()
	{
		Amount = CurrentBox.size()-1;
		CurrentName = CurrentPage*10;

		if(Amount+1 > 10)
		{
			CurrentPageText.changeText("Current Page: " + (CurrentPage+1));
		
		// Prev page button
			if(CurrentPage > 0)
			{
				UpButton.changeTexture( new ResourceRef( frontend:0x0085r ) ); // Left Arrow
				UpButton.enable();
			}
			else
			{
				UpButton.changeTexture( new ResourceRef( frontend:0x00AFr ) ); // Empty.ptx
				UpButton.disable();
			}
		
		//  Next page button
			if( Amount+1 > CurrentName+10 )
			{
				DownButton.changeTexture( new ResourceRef( frontend:0x0088r ) ); // Right Arrow
				DownButton.enable();
			}
			else
			{
				DownButton.changeTexture( new ResourceRef( frontend:0x00AFr ) ); // Empty.ptx
				DownButton.disable();
			}
		}
		else
		{
			CurrentPageText.changeText("");

			UpButton.changeTexture( new ResourceRef( frontend:0x00AFr ) ); // Empty.ptx
			UpButton.disable();

			DownButton.changeTexture( new ResourceRef( frontend:0x00AFr ) ); // Empty.ptx
			DownButton.disable();
		}


		if( CurrentName + 0 <= Amount ) { ItemButton0.changeLabelText(CurrentBox.elementData[CurrentName+0]); ItemButton0.enable(); } else { ItemButton0.changeLabelText( "" ); ItemButton0.disable(); }
		if( CurrentName + 1 <= Amount ) { ItemButton1.changeLabelText(CurrentBox.elementData[CurrentName+1]); ItemButton1.enable(); } else { ItemButton1.changeLabelText( "" ); ItemButton1.disable(); }
		if( CurrentName + 2 <= Amount ) { ItemButton2.changeLabelText(CurrentBox.elementData[CurrentName+2]); ItemButton2.enable(); } else { ItemButton2.changeLabelText( "" ); ItemButton2.disable(); }
		if( CurrentName + 3 <= Amount ) { ItemButton3.changeLabelText(CurrentBox.elementData[CurrentName+3]); ItemButton3.enable(); } else { ItemButton3.changeLabelText( "" ); ItemButton3.disable(); }
		if( CurrentName + 4 <= Amount ) { ItemButton4.changeLabelText(CurrentBox.elementData[CurrentName+4]); ItemButton4.enable(); } else { ItemButton4.changeLabelText( "" ); ItemButton4.disable(); }
		if( CurrentName + 5 <= Amount ) { ItemButton5.changeLabelText(CurrentBox.elementData[CurrentName+5]); ItemButton5.enable(); } else { ItemButton5.changeLabelText( "" ); ItemButton5.disable(); }
		if( CurrentName + 6 <= Amount ) { ItemButton6.changeLabelText(CurrentBox.elementData[CurrentName+6]); ItemButton6.enable(); } else { ItemButton6.changeLabelText( "" ); ItemButton6.disable(); }
		if( CurrentName + 7 <= Amount ) { ItemButton7.changeLabelText(CurrentBox.elementData[CurrentName+7]); ItemButton7.enable(); } else { ItemButton7.changeLabelText( "" ); ItemButton7.disable(); }
		if( CurrentName + 8 <= Amount ) { ItemButton8.changeLabelText(CurrentBox.elementData[CurrentName+8]); ItemButton8.enable(); } else { ItemButton8.changeLabelText( "" ); ItemButton8.disable(); }
		if( CurrentName + 9 <= Amount ) { ItemButton9.changeLabelText(CurrentBox.elementData[CurrentName+9]); ItemButton9.enable(); } else { ItemButton9.changeLabelText( "" ); ItemButton9.disable(); }
	}

	public void osdCommand( int cmd )
	{
		if( cmd >= CMD_SKIN0 && cmd <= CMD_SKIN9 ) //All 10 buttons
		{
			if(cmd == CMD_SKIN0) number=0;
			if(cmd == CMD_SKIN1) number=1;
			if(cmd == CMD_SKIN2) number=2;
			if(cmd == CMD_SKIN3) number=3;
			if(cmd == CMD_SKIN4) number=4;
			if(cmd == CMD_SKIN5) number=5;
			if(cmd == CMD_SKIN6) number=6;
			if(cmd == CMD_SKIN7) number=7;
			if(cmd == CMD_SKIN8) number=8;
			if(cmd == CMD_SKIN9) number=9;

			if(CurrentTextureRes) CurrentTextureRes.destroy();

			CurrentTextureRes = new ResourceRef();
			CurrentTextureRes.makeTexture( new ResourceRef(system:0x0008r), CurrentBoxDirectory+CurrentBox.elementData[CurrentName+number]);

			RefreshRender();
		}
		else
		if( cmd == CMD_OK )
		{
			if( Mode == 1 )
			{
				GameLogic.player.driverID = new RenderRef();
				GameLogic.player.driverID.duplicate(TempRender);
			}
			else
			if( Mode == 2 )
			{
				GameLogic.player2.driverID = new RenderRef();
				GameLogic.player2.driverID.duplicate(TempRender);
			}

			GameLogic.changeActiveSection( parentState );
		}
		else
		if( cmd == CMD_BACK )
		{
			GameLogic.changeActiveSection( parentState );
		}
		else
		if( cmd == CMD_NEXT )
		{
			if(CurrentModel >= CMD_NODRIVER+ModelsAmount-1)
				CurrentModel = CMD_NODRIVER;
			else
				CurrentModel+=1;
			
			osdCommand( CurrentModel );
		}
		else
		if( cmd == CMD_PREV )
		{
			if(CurrentModel <= CMD_NODRIVER)
				CurrentModel = CMD_NODRIVER+ModelsAmount-1;
			else
				CurrentModel-= 1;
			
			osdCommand( CurrentModel );
		}
		else
		if( cmd == CMD_UP )
		{
			CurrentPage-=1;
			RefreshOsd();
		}
		else
		if( cmd == CMD_DOWN )
		{
			CurrentPage+=1;
			RefreshOsd();
		}
		else
		if( cmd == CMD_ABOUT )
		{
			new WarningDialog( GameLogic.player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG|Dialog.DF_WIDE, "DRIVER SELECTOR v1.1", " \n You can add new skins! Copy *.dds, *.png or *.bmp file to humans/drivers/[model name]_driver directory. \n \n By Miran" ).display();
		}
		else
		if( cmd == CMD_NODRIVER )
		{
			CurrentPage = 0;
			
			CurrentBox = new Vector(1);
			CurrentBox.addElement( new String() );

			if(CurrentDriver) CurrentDriver.destroy();
			TempRender = new RenderRef();

			RefreshOsd();
			ItemButton0.disable();

			ModelInfo.changeText("NO DRIVER MODEL");
		}
		else
		if( cmd == CMD_DEFAULT )
		{
			CurrentPage = 0;
			
			CurrentBox = GameLogic.DefaultSkinBox;

			CurrentBoxDirectory = "humans/drivers/Default_Driver/";
			OrginalTextureRes = new ResourceRef(humans:0x000Dr);
			OrginalMeshRes = new ResourceRef(humans:0x000Cr);

			if(CurrentTextureRes) CurrentTextureRes.destroy();
			CurrentTextureRes = new ResourceRef();
			CurrentTextureRes.makeTexture( new ResourceRef(system:0x0008r), "humans/drivers/Default_Driver/Default.dds");

			ModelInfo.changeText("Default - " + CurrentBox.size() + " skins");

			RefreshRender();
			RefreshOsd();
		}
		else
		if( cmd == CMD_POLICEMAN )
		{
			CurrentPage = 0;
			
			CurrentBox = GameLogic.PoliceManSkinBox;

			CurrentBoxDirectory = "humans/drivers/PoliceMan_Driver/";
			OrginalTextureRes = new ResourceRef(humans:0x001Ar);
			OrginalMeshRes = new ResourceRef(humans:0x0018r);

			if(CurrentTextureRes) CurrentTextureRes.destroy();
			CurrentTextureRes = new ResourceRef();
			CurrentTextureRes.makeTexture( new ResourceRef(system:0x0008r), "humans/drivers/PoliceMan_Driver/Default.dds");

			ModelInfo.changeText("Policeman - " + CurrentBox.size() + " skins");

			RefreshRender();
			RefreshOsd();
		}
	}

	public void show()
	{
		super.show();
		osd.show();
	}

	public void hide()
	{
		osd.hide();
		super.hide();
	}
}