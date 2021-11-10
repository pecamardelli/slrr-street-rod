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
import java.game.parts.bodypart.*;
import java.game.parts.enginepart.*;
import java.game.parts.rgearpart.*;

public class Vehicle extends GameType
{
	final static int SAVEFILEID_VHC = 0x88664422;
	final static int SAVEFILEVERSION_VHC = 5;

	final static int SAVEFILEID_SKIN = 0x82549867;
	final static int SAVEFILEVERSION_SKIN = 0;

	//transmission variants
	final static int TRANSMISSION_MANUAL = 0;
	final static int TRANSMISSION_AUTO = 1;
	final static int TRANSMISSION_SEMIAUTO = 5;
	//can be OR-ed with this to get manual clutch:
	final static int TRANSMISSION_MANUALCLUTCH = 2;


	float	maxTestTrackSpeedSq;
	float	bestTestTrackAcc;   // 0-62.1 //
	float	bestTestTrackAcc120;// 0-124.2 //
	float	bestTestTrackTime0; // 1610 m //
	float	bestTestTrackTime0_speedSq;
	float	bestTestTrackTime1; // 1 lap //
	float	bestTestTrackTime2; // 402 m //
	float	bestTestTrackTime2_speedSq;

	int		races_won, races_lost;
	float	bestNightQM = 0.0;

	int		cruiseControl;

	Chassis	chassis;

	public Vehicle( Part chassis_ )
	{
		set( chassis_ );
		chassis = chassis_;

		setDefaultTransmission();
		setDefaultSteeringHelp();
		setDefaultASR();
		setDefaultABS();
	}

	public float calcPoliceFine( float thoroughness )
	{
		if (chassis)
			return chassis.calcPoliceFine( thoroughness );
		return 0.0;
	}

	public Vehicle( GameRef parent, int id, int colorIndex, float optical, float engine, float wear, float tear )
	{
		//getScriptInstance forbidden!!
		float t=System.currentTime();

		chassis = create( parent, new GameRef(id),	"0,0,0,0,0,0", "Vehicle" );

		if( chassis )
		{
			//a fizikat bekapcsolja az alkatreszek hozzaadasa!
			chassis.suspend_update = 1;
			chassis.addStockParts( new Descriptor( GameLogic.CARCOLORS[colorIndex], optical, engine, wear, tear) );
			chassis.suspend_update = 0;
			chassis.forceUpdate();
		}

		setDefaultTransmission();
		setDefaultSteeringHelp();
		setDefaultASR();
		setDefaultABS();

		setMatrix( null, null );	//ezzel leallitjuk a fizikajat.

//   if (chassis)
//  		System.log( "Vehicle created " + chassis.vehicleName + " " + (System.currentTime()-t) );
	}

	public int getInfo( int query )
	{ 
		return getInfo( query, 0 ); //igy elerjuk a hivatkozott peldany getinfojat!!! :)))
	}

	public native float getSpeedSquare();
	public native int getHorn();
	public native float hasCrime();

	//-----part iteracio:
	Vector	iteratorStack;

	public Part iteratePartsInit()	//mellesleg a chassis-t adja vissza
	{
		iteratorStack = new Vector();

		if( chassis )
		{
			iteratorStack.addElement( chassis );
			return chassis;
		}
		//else
			return null;
	}

	public Part iterateParts()	//garantaltan a chassisel kezd!
	{
		if( iteratorStack.size() )
		{
			Part p = iteratorStack.removeLastElement();

			for( int i=p.attachedParts.size()-1; i>=0; i-- )
				iteratorStack.addElement( p.attachedParts.elementAt(i));

			return p;
		}
		//else
			return null;
	}
	//------------------------


	public void wakeUp()	//alkatresz ki-be szereles utan hivando!
	{
		queueEvent( null, EVENT_COMMAND, "wakeup" );
	}

	public void addStockParts( float color, float optical, float engine )
	{
		//khm!!! szebben kellene!
		chassis.addStockParts( color, optical, engine );
	}

	//-------
	public void setDefaultTransmission()
	{
		setTransmission( Config.player_transmission );
	}

	public void setTransmission( int tr )
	{
		queueEvent( null, EVENT_COMMAND, "transmission " + tr  );
	}
	//-------
	public void setDefaultSteeringHelp()
	{
		setSteeringHelp( Config.player_steeringhelp );
	}

	public void setSteeringHelp( float sh )
	{
		queueEvent( null, EVENT_COMMAND, "steerhelp " + sh  );
	}
	//-------
	public void setDefaultASR()
	{
		setASR( Config.player_asr );
	}

	public void setASR( float sh )
	{
		queueEvent( null, EVENT_COMMAND, "asr " + sh  );
	}
	//-------
	public void setDefaultABS()
	{
		setABS( Config.player_abs );
	}

	public void setABS( float sh )
	{
		queueEvent( null, EVENT_COMMAND, "abs " + sh  );
	}


	//------- nincs belol default, 
	public void setDifflock( float sh )	//0/1 racionalis, de az engine a floatost is kezeli
	{
		queueEvent( null, EVENT_COMMAND, "difflock " + sh  );
	}

	public void setCruiseControl( int cc )
	{
		cruiseControl = cc;
		queueEvent( null, EVENT_COMMAND, "cruise " + cc  );
	}

	public int getCruiseControl()
	{
		return cruiseControl;
	}

	//-------
	public void setDamageMultiplier( float f )
	{
		queueEvent( null, GameType.EVENT_COMMAND, "damage_multiplier " + f );
	}

	public String toString()
	{	
		if (chassis)
		{
			return chassis.vehicleName;
		}
		else
		if (GameLogic.player.car)
		{
			return "<NO CHASSIS FOUND>";
		}
		else
		{
			return "<NO CAR FOUND>";
		}
	}

	//return null if everything is fine, otherwise the error String
	public String canTakeSeat()
	{
		String error = isDriveable2();

		if (error)
			return error;

		// check others like driver's seat, steering wheel, etc... //

		return null;
	}

	public String isDriveable()
	{
		String error = isDriveable2();

		if (error)
			return "You can't drive this car because " + error;
		return null;
	}

	public String isTestable()
	{
		String result = null;

		if( chassis )
		{
			if( chassis.getConditionNoAttach() == 0.0 )
				return "the chassis is totally damaged.";

			Part part = null;
			Block engine = null;
			Battery battery = null;

			Part swheel = null;
			FrontSeat drvseat = null;

			for( int i=chassis.attachedParts.size()-1; i>=0; i-- )
			{
				part = chassis.attachedParts.elementAt(i);

				if (part)
				{
					result = part.isDriveable();
					if (result)
						return result;

					if (part instanceof Block)
						engine = part;
					else
					if (part instanceof Battery)
						battery = part;
					else
					if (part instanceof SteeringWheel)
						swheel = part;
					else
					if (part instanceof FrontSeat)
					{
						if (part.slotIDOnSlot(1)==901)
							drvseat = part;
					}
					else
						part = null;
				}
			}

			if( !engine )
				return "there's no engine installed.";
			else
			if( engine.dynodata.maxTorque <= 0.0)
				return "the engine is not in working condition.";

			if (chassis.starter_torque == 0.0)
			{
				return "there's problem with the starter.";
			}

			if( !battery )
			{
				return "the car is missing a battery.";
			}

			if( !swheel )
				return "there's no steering wheel installed.";

			if( !drvseat )
				return "there's no driver's seat installed.";
		}

		return null;
	}

	public String isDriveable2()
	{
		String result = null;

		if( chassis )
		{
			if( chassis.getConditionNoAttach() == 0.0 )
				return "the chassis is totally damaged.";

			Part part = null;
			Block engine = null;
			Battery battery = null;

			Part swheel = null;
			FrontSeat drvseat = null;

			for( int i=chassis.attachedParts.size()-1; i>=0; i-- )
			{
				part = chassis.attachedParts.elementAt(i);

				if (part)
				{
					result = part.isDriveable();
					if (result)
						return result;

					if (part instanceof Block)
						engine = part;
					else
					if (part instanceof Battery)
						battery = part;
					else
					if(part instanceof SteeringWheel)
						swheel = part;
					else
					if (part instanceof FrontSeat)
					{
						if (part.slotIDOnSlot(1)==901)
							drvseat = part;
					}
					else
						part = null;
				}
			}

			if( !engine )
				return "there's no engine installed.";
			else
			if( engine.dynodata.maxTorque <= 0.0)
				return "the engine is not in working condition.";

			if (chassis.starter_torque == 0.0)
			{
				return "there's problem with the starter.";
			}

			if( !battery )
			{
				return "the car is missing a battery.";
			}

			if( !swheel )
				return "there's no steering wheel installed.";

			if( !drvseat )
				return "there's no driver's seat installed.";

			//futomuellenorzes:
			int wheel;
			int wheels = 0;

			for (wheel=0; wheel<chassis.wheels; wheel++)
			{
				WheelRef whl = chassis.getWheel(wheel);
				if (whl)
				{
					Part p = chassis.partOnSlot(101+wheel);
					if (p)
					{
						String r = p.isDriveable();
						if (r)
							return r;
						wheels++;
					}
				}
			}

			if ( wheels == 0 && chassis.wheels > 0 )
				return "there are no wheels on the car.";
			else
			if ( wheels < chassis.wheels-3 )
				return "some wheels are missing from the car.";
			else
			if ( wheels == chassis.wheels-3 )
				return "three wheels are missing from the car.";
			else
			if ( wheels == chassis.wheels-2 )
				return "two wheels are missing from the car.";
			else
			if ( wheels == chassis.wheels-1 )
				return "one wheel is missing from the car.";
		}

		return null;
	}

	//nem illik hivni part iterator loopbol!!
	public int getTotalPrice()
	{
		if( chassis )
			return chassis.currentPrice();

		return 0;
	}

	public void repair()
	{
		if( chassis )
		{
			chassis.repair();
			chassis.forceUpdate();
			wakeUp();
		}
	}

	public float getPrestigeMultiplier()
	{
		float k = races_won-races_lost;

		if ( k > 300)
			k = 300;
		else
		if ( k < -90)
			k = -90;

		if (k<0.0)
			return 1.0-Math.sqrt((-k)/100.0);
		else
		if (k>0.0)
			return 1.0+Math.sqrt(k/100.0);

		return 1.0;
	}

	public float getPrestige()
	{
		if (!chassis)
			return 0.0;

		float p = chassis.currentPrestige();
		float m = getPrestigeMultiplier();

		/*
		System.log("current car prestige is: "+p);
		System.log("current car prestige multiplier is: "+m);
		System.log("current car combined prestige is: "+(p*m));
		*/

		return p*m;
	}

	public static Vehicle load( String filename, GameRef world )	
	{
		Vehicle car;

		File saveGame = new File( filename );
		if( saveGame.open( File.MODE_READ ) )
		{
			if( saveGame.readInt() == SAVEFILEID_VHC )
			{
				if( saveGame.readInt() == SAVEFILEVERSION_VHC )
				{
					Chassis chas = Part.createFromFile( saveGame, world );
					car = new Vehicle( chas );

					car.maxTestTrackSpeedSq = saveGame.readFloat();
					car.bestTestTrackAcc = saveGame.readFloat();
					car.bestTestTrackAcc120 = saveGame.readFloat();
					car.bestTestTrackTime0 = saveGame.readFloat();
					car.bestTestTrackTime0_speedSq = saveGame.readFloat();
					car.bestTestTrackTime1 = saveGame.readFloat();
					car.bestTestTrackTime2 = saveGame.readFloat();
					car.bestTestTrackTime2_speedSq = saveGame.readFloat();

					car.races_won=saveGame.readInt();
					car.races_lost=saveGame.readInt();

					car.bestNightQM = saveGame.readFloat();
					//vege

					//miert is kell ez?
					car.wakeUp();
				}
			}
			saveGame.close();
		}


		return car;
	}

	public static int fileCheck( String filename )
	{
		int status;
		File saveGame = new File( filename );

		if( saveGame.open( File.MODE_READ ) )
		{
			if( saveGame.readInt() == SAVEFILEID_VHC )
				if( saveGame.readInt() == SAVEFILEVERSION_VHC )
					status = 1;

			saveGame.close();
		}

		return status;
	}

	public static int fileCheck_Skin( String filename )
	{
		int result;
		File saveGame = new File( filename );
		if( saveGame.open( File.MODE_READ ) )
		{
			if( saveGame.readInt() == SAVEFILEID_SKIN )
				if( saveGame.readInt() == SAVEFILEVERSION_SKIN )
					result = 1;

			saveGame.close();
		}

		return result;
	}


	public void save( String filename )
	{
		File saveGame = new File( filename );
		if( saveGame.open( File.MODE_WRITE ) )
		{
			saveGame.write( SAVEFILEID_VHC );
			saveGame.write( SAVEFILEVERSION_VHC );

			//tenyleges mentes:
			if (chassis)
				chassis.save( saveGame );

			saveGame.write( maxTestTrackSpeedSq );
			saveGame.write( bestTestTrackAcc );
			saveGame.write( bestTestTrackAcc120 );
			saveGame.write( bestTestTrackTime0 );
			saveGame.write( bestTestTrackTime0_speedSq );
			saveGame.write( bestTestTrackTime1 );
			saveGame.write( bestTestTrackTime2 );
			saveGame.write( bestTestTrackTime2_speedSq );

			saveGame.write( races_won );
			saveGame.write( races_lost );

			saveGame.write( bestNightQM );
			//vege

			saveGame.close();
		}
	}

	public void loadSkin( String filename )
	{
		int numParts;
		Part p;
		iteratePartsInit();
		while( p = iterateParts() )
			numParts++;

		int[] skinned = new int[numParts];
		
		File saveGame = new File( filename );
		if( saveGame.open( File.MODE_READ ) )
		{
			if( saveGame.readInt() == SAVEFILEID_SKIN )
			{
				if( saveGame.readInt() == SAVEFILEVERSION_SKIN )
				{
					int id, textureId;
					int	partIndex;

					while( (id = saveGame.readResID() ) )
					{
						textureId = saveGame.readResID();

						partIndex=0;
						iteratePartsInit();
						while( (p = iterateParts()) )
						{
							if( !skinned[partIndex] )
							{
								if( p.getInfo( GameType.GII_TYPE ) == id )
								{
									p.setTexture( textureId );

									skinned[partIndex]=1;
									break;
								}
							}

							partIndex++;
						}
					}
				}
			}
			saveGame.close();
		}

	}

	public void saveSkin( String filename )
	{
		iteratePartsInit();

		File saveGame = new File( filename );
		if( saveGame.open( File.MODE_WRITE ) )
		{
			saveGame.write( SAVEFILEID_SKIN );
			saveGame.write( SAVEFILEVERSION_SKIN );
			Part p;
			int texID;

			while( (p = iterateParts()) )
			{
				texID = p.getTexture();

				if( texID )
				{
					saveGame.write( new GameRef(p.getInfo( GameType.GII_TYPE )) );
	
					ResourceRef texture = new ResourceRef(texID);
					saveGame.write( texture );
				}
			}

			saveGame.write( 0 );
		}
		saveGame.close();
	}

}