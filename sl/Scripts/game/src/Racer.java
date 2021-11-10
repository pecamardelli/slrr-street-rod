package java.game;

import java.io.*;
import java.util.*;
import java.util.resource.*;
import java.render.*;	//Text
import java.render.osd.*;	//Text
import java.sound.*;

public class Racer extends GameType
{
	final static int	RID_FEJ = frontend:0x00dar;
	final static float	PRESTIGE_STEP = 0.05;

	final static int	PRESTIGE_SCALE = 300;	//a 0-1 tartomany ide skallazzuk fel!
	final static int	VHC_PRESTIGE_SCALE = 100;	//a 0-1 tartomany ide skallazzuk fel!

	Vehicle		car;
	String		name;
	RenderRef	render, driverID; // driverID: now it is ready driver render, no just ID (Driver Selector)
	ResourceRef	character;

//	int		driverID;	//rendor, driver, player, etc gametype ids

	float	prestige;	//0..1;
	int		money=10000;
	int		club;

	int		lastRaceDay = -1;
	int		enabledPinkSlips = 0;

	float	bestQMtime=0.0;
	float	bestQMspd=0.0;
	
	public Racer()
	{
		createNativeInstance();
	}

	//--------------------------------prestige szamitas-----------------------------------

	public void increasePrestige( float f )
	{
		float amount = (1.0-prestige)*f;
		float limit = 0.02*f/PRESTIGE_STEP;
		if( amount > limit )
			amount = limit;
		prestige+=amount;
	}
	public void decreasePrestige( float f )
	{
		float amount = prestige*f;
		float limit = 0.02*f/PRESTIGE_STEP;
		if( amount > limit )
			amount = limit;
		prestige-=amount;
	}

	public float getCarPrestige()
	{
		if( car )
			return car.getPrestige();

		return 0.0;
	}

	public String getPrestigeString()
	{
		int pprestige, cprestige, aprestige;
		pprestige = prestige*PRESTIGE_SCALE;
		cprestige = getCarPrestige() * VHC_PRESTIGE_SCALE;

		aprestige = pprestige*0.5 + cprestige*0.5;

//		return aprestige + " (" + pprestige +  ":" + cprestige + ")";
		return pprestige +  "/" + cprestige;
	}

	//versenyzes pontszamitasa:
	public void calcPrestige( Racer challenged, int abandon, int iwon )
	{
		if( prestige != challenged.prestige )
			if( prestige < challenged.prestige )
			{
				increasePrestige(PRESTIGE_STEP);
				challenged.decreasePrestige(PRESTIGE_STEP);
			}
			else
			{
				decreasePrestige(PRESTIGE_STEP);
				challenged.increasePrestige(PRESTIGE_STEP);
			}

		if( abandon )
		{
			challenged.decreasePrestige(PRESTIGE_STEP);
		}
		else
		{
			if( iwon )
			{
				increasePrestige(2*PRESTIGE_STEP);
				challenged.decreasePrestige(2*PRESTIGE_STEP);
			}
			else
			{
				decreasePrestige(2*PRESTIGE_STEP);
				challenged.increasePrestige(2*PRESTIGE_STEP);
			}
		}
	}

	public void save( File saveGame )
	{
		//ToDo: save name_seed, (current)car, club, prestige, money, etc.
//		car.save( saveGame );

		int save_ver = 1;
		saveGame.write(save_ver);
		if (save_ver >= 1)
		{
			// dummy save_ver for further compatibility
		}
	}

	public void load( File saveGame )
	{
//		car.load( saveGame );

		int save_ver;
		save_ver = saveGame.readInt();

		if (save_ver >= 1)
		{
			// dummy save_ver for further compatibility
		}
	}

}

