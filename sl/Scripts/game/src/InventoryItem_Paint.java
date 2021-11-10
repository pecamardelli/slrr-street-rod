package java.game;

import java.io.*;
import java.util.*;
import java.util.resource.*;
import java.render.*;	//Text
import java.render.osd.*;	//Text
import java.sound.*;

public class InventoryItem_Paint extends InventoryItem
{
	PaintCan paintCan;

	public InventoryItem_Paint( Inventory inv, PaintCan can )
	{
		super( inv );
		paintCan = can;
	}

	public PaintCan getCan()
	{
		return paintCan;
	}

	//visualization
	RenderRef canObject;

	public void show( InventoryPanel ip )
	{
		canObject = new RenderRef( localroot, frontend:0x0021r, "cannaatska" );
		canObject.setColor( paintCan.color );
		ip.createDefCamera( 0.13, 1 );	//size, enableRotate
		ip.createDefLight();
	}

	public void hide( InventoryPanel ip )
	{
		ip.cleanup();
		canObject.destroy();
		canObject = null;
	}

	public void finalize()
	{
		if( canObject )
		{
			canObject.destroy();
			canObject = null;
		}
	}

	public String getInfo()
	{
		return "#" + prepareHexString( paintCan.color );
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
}
