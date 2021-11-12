package java.game.parts.rgearpart.reciprocatingrgearpart;

import java.render.osd.*;
import java.io.*;
import java.util.*;
import java.util.resource.*;
import java.game.cars.*;
import java.game.*;
import java.game.parts.*;
import java.game.parts.bodypart.*;
import java.game.parts.enginepart.*;
import java.game.parts.rgearpart.*;
//removed useless stuff, added new stuff like roll resistance, friction_x(wasn't used in stock physics), par_8(don't know wtf is it)
//
//if you don't like tyres wearing too fast, look at line 111
public class Tyre extends ReciprocatingRGearPart
{
	final static int	tcSTREET = 0;
	final static int	tcSPORT = 1;
	final static int	tcSUPERSPORT = 2;
	final static int	tcDRAGRADIAL = 3;

	float	friction = 1.0;	//static friction coeff.
	float	sliction = 1.0;	//ratio of dynamic/static
	float	frictn_x = 1.0;	//factor (unused now)
	float	radius   = 0.01;
	float	stiffness = 10.0;
	float	rollres  = 0.01;	//rolling resistance
	float	loadcap  = 6000.0;	//load capacity
	float	loadsmooth = 0.5;
	float	CPatchMaximumAngle = 0.300;
	// everything unchanged above
	// Sala: the following variables are used for scripted calculations //

	float	insider_friction = 1.0;
	float	wheel_radius;
	float	profile_ratio;
	float	tyre_width;
	float	profile_height;
	float	min_radius;
	float	max_radius;
	float	slide_interval;

	float	min_rollres;
	float	optimal_inflation;
	float	inflation;
	float	par_8;

	int	maxRimWidth_i;
	int	minRimWidth_i;
	float	maxRimWidth;
	float	minRimWidth;

	float	default_fric=1.0;//unchanged
	float	fric_mul=1.40;//1.30 old
	float	load_mul2=10.500*3;// multiplied by 3.5
	float	CPatchMaxA=16.000;//unchanged
	float	CPatchMinA= 4.000;//unchanged
	float	slic_mul=1.3;//1.10 old
	float	rubber_rigidity=0.100;//calculates individually
	// look below for more
	float	load_mul=1.000;
	
	// debug vars, remove them after use //
	float	slide_cm;
	
	int[]	render_types = new int[22];
	String	tyre_size_label;

	public Tyre()
	{
		repair_max_wear = 0.0;
		prestige_calc_weight = 15.0;
		catalog_view_ypr = new Ypr( 1.571, -0.7, 0.0 );
	}

	public void SetInflation( float I )
	{
		SetInflation( I, 0 );
	}

	public void SetInflation( float I, int forced )
	{
		if (inflation != I || forced)
		{
			inflation = I;

			if (inflation < 0.5)
				inflation = 0.5;
			if (inflation > optimal_inflation)
				inflation = optimal_inflation;

			float misinflation;

			if (inflation < optimal_inflation)
				misinflation = inflation / optimal_inflation;
			else
				misinflation = optimal_inflation / inflation;

			misinflation = misinflation*misinflation*misinflation*0.6+0.4;

			insider_friction = friction * (0.75+0.25*(tyre_width/405.0)) * fric_mul;//changed from (0.5+0.5*(tyre_width/275.0)) to (0.6+0.4*(tyre_width/405.0))

			float t = profile_ratio*optimal_inflation/inflation;
			
			loadcap = 4000.0+(0.75+profile_ratio/0.4*0.25)*(0.9+0.1*t)*(tyre_width-165.0)*9.81*load_mul*1.350/friction/fric_mul/rubber_rigidity; // tyre: max load capacity (Ns = kgs*gravity)
			CPatchMaximumAngle = 3.1415926535897932384626433832795/180.0 * (CPatchMinA+(0.6+(405.0-tyre_width)/405.0*0.4) /* *misinflation */ *profile_ratio*(CPatchMaxA-CPatchMinA));
			stiffness = -18.0+(1.0-slide_interval)*(1.0-profile_ratio)*(0.5+0.5*misinflation)*40.0;// changed
			stiffness = clampTo(stiffness,4.0,20.0);
			radius = max_radius; // min_radius+(max_radius-min_radius)/misinflation;
			setMaxWear((0.15+(rubber_rigidity*rubber_rigidity*rubber_rigidity*rubber_rigidity))*50000000000.0*misinflation);
		}

		WheelRef w = getWheel();

		if (w)//this is where all variables goes to, straight to game exe(physics calculation).
		{
			w.setCPatch(tyre_width/2,CPatchMaximumAngle, 0.0);//this is new line
			w.setSliction( sliction );//w.setPacejka( 0, sliction )
			w.setPacejka( 1, 0.0 );
			w.setFriction( insider_friction );//w.setPacejka( 2, insider_friction )
			w.setPacejka( 3, 0.0 );//0.013 );
			w.setStiffness( stiffness ); //w.setPacejka( 4, stiffness )
			w.setPacejka( 5, 0.0 );
			w.setPacejka( 6, 0.0 );
			w.setPacejka( 7, 0.0 );
			w.setPacejka( 8, 0.0 );//par_8
			w.setPacejka( 9, 0.0 );
			w.setPacejka( 10, 0.0 );
			w.setMaxLoad( loadcap );//w.setPacejka( 11, loadcap )
			w.setPacejka( 12, 0.0 );//0.2 );
			w.setPacejka( 15, 0.0 );//load_progress //nominal load for stiffness?(google translate) //nevleges load a 'stiffness'-hez
			w.setPacejka( 16, 0.0 );//load_progress // +load ; 15+16 -nal lesz fel 'stiffness' ertek
			w.setFrictn_x( 1.0 );
			w.setLoadSmooth( loadsmooth );

			w.setRadius( radius );
			w.setWidth( tyre_width/1000.0 );
			w.setRollRes( 0.0 );
			w.setBearing( 20.0 );

			int whlID = getWheelID();

			if ((whlID>=0) && ((whlID % 2)==1))
				setSlotPos(1, new Vector3(0.0,0.0,0.0), new Ypr(0.0,0.0,0.0) );
			else
				setSlotPos(1, new Vector3(0.0,0.0,0.0), new Ypr(3.142,0.0,0.0) );
		}
	}

	public void SetupRubber( int RT )
	{
		String 	compound_label;

		if (RT == tcSPORT) // sport tyre //
		{
			rubber_rigidity	=    0.850;
			load_mul	=    0.800*load_mul2;
			friction	=    default_fric/rubber_rigidity;	// tyre: static friction (compound efficiency)
			sliction	=    0.740*slic_mul;		// tyre: slip ratio (sliction*friction = slipfriction)
			loadsmooth	=    0.300;
			compound_label	= " medium compound sport tyre";
			police_check_fine_value = 0.0;
		} else
		if (RT == tcSUPERSPORT) // supersport tyre //
		{
			rubber_rigidity	=    0.750;
			load_mul	=    0.850*load_mul2;
			friction	=    default_fric/rubber_rigidity;	// tyre: static friction (compound efficiency)
			sliction	=    0.760*slic_mul;		// tyre: slip ratio (sliction*friction = slipfriction)
			frictn_x	=    friction;//changed from 1.00			// tyre: longitudinal friction and sliction * ratio = horizontal friction and sliction
			loadsmooth	=    0.250;
			compound_label	= " soft compound racing tyre";
			police_check_fine_value = 50.0;
		} else
		if (RT == tcDRAGRADIAL) // drag-radial //
		{
			rubber_rigidity	=    0.550;
			load_mul	=    1.800*load_mul2;
			friction	=    default_fric/rubber_rigidity;	// tyre: static friction (compound efficiency)
			sliction	=    0.720*slic_mul;		// tyre: slip ratio (sliction*friction = slipfriction)
			frictn_x	=    friction;//changed from 1.00			// tyre: longitudinal friction and sliction * ratio = horizontal friction and sliction
			loadsmooth	=    0.750;
			compound_label	= " drag radial";
			police_check_fine_value = 50.0;
		}
		else
		if (RT == tcSTREET) // street tyre //
		{
			rubber_rigidity	=    1.000;
			load_mul	=    0.750*load_mul2;
			friction	=    default_fric/rubber_rigidity;	// tyre: static friction (compound efficiency)
			sliction	=    0.700*slic_mul;		// tyre: slip ratio (sliction*friction = slipfriction)
			frictn_x	=    friction;//changed from 1.00			// tyre: longitudinal friction and sliction * ratio = horizontal friction and sliction
			loadsmooth	=    0.500;
			compound_label	= " hard compound street tyre";
			police_check_fine_value = 0.0;
		}
		else
		{
			rubber_rigidity	=    1.000;
			load_mul	=    0.750*load_mul2;
			friction	=    default_fric/rubber_rigidity;	// tyre: static friction (compound efficiency)
			sliction	=    0.700*slic_mul;		// tyre: slip ratio (sliction*friction = slipfriction)
			frictn_x	=    friction;//changed from 1.00			// tyre: longitudinal friction and sliction * ratio = horizontal friction and sliction
			loadsmooth	=    0.500;
			compound_label	= " tyre";
			police_check_fine_value = 0.0;
		}
		value /= rubber_rigidity;
		brand_new_prestige_value = 25.0/rubber_rigidity + tyre_width/10.0-20.0;
		if(name=="<unnamed>")//doesn't change tyres name if there's one
		name = tyre_size_label+compound_label;// removed name_prefix
	}

	public void calcStuffs()
	{
		for (minRimWidth_i=0; minRimWidth_i<21; minRimWidth_i++)
			if (render_types[minRimWidth_i])
			{
				minRimWidth = minRimWidth_i*0.5+5.0;
				break;
			}

		for (maxRimWidth_i=20; maxRimWidth_i>=0; maxRimWidth_i--)
			if (render_types[maxRimWidth_i])
			{
				maxRimWidth = maxRimWidth_i*0.5+5.0;
				break;
			}
			
		float R = wheel_radius*2.0/25.4;
		if(maxRimWidth==minRimWidth)//a bit description fix, not much
		description = "This "+name+" is a "+Float.toString(tyre_width, "%1.0f mm wide ")+" tyre, diameter is "+Float.toString(R, "%1.0f inch at the rims and the height of sidewalls is ")+Float.toString(profile_height, "%1.0f mm. ")+Float.toString(R, "It is compatible with all %1.0f inch rims ")+Float.toString(minRimWidth, "that are %1.1f inch width.");
		else
		description = "This "+name+" is a "+Float.toString(tyre_width, "%1.0f mm wide ")+" tyre, diameter is "+Float.toString(R, "%1.0f inch at the rims and the height of sidewalls is ")+Float.toString(profile_height, "%1.0f mm. ")+Float.toString(R, "It is compatible with all %1.0f inch rims ")+Float.toString(minRimWidth, "that are between %1.1f and ")+Float.toString(maxRimWidth, "%1.1f inch width.");
		
		if (police_check_fine_value > 0.0)
			description = description + Float.toString(police_check_fine_value, " This tyre is not street legal! Police may fine you up to $%1.0f!");
	}

	public String installCheck( Part p, int[] slotId )
	{
		if (p)
		{
			if (p instanceof Wheel)
			{
				Wheel wheel = p;
				int wr1=wheel.wheel_radius*1000.0;
				int wr2=wheel_radius;
				if (wr1 != wr2)
					return "The tyre inner radius does not match the rim!";
				else
				if (wheel.rim_width > maxRimWidth)
					return "This tyre is too narrow for this rim!";
				else
				if (wheel.rim_width < minRimWidth)
					return "This tyre is too wide for this rim!";

				return null;
			}
			else
				return "Tyres can only be installed on rims!";
		}
		//else
		return "There's nothing to install this part to!";
	}

	public void SetupTyre( float W, float r, float R, float rW, int compound_type )
	{
		SetupTyre( W, r, R, rW, compound_type, -1.0 );
	}

	public void SetupTyre( float W, float r, float R, float rW, int compound_type, float optI )
	{
		value = HUF2USD(W*80+2500*(R-13.0));

		wheel_radius	= R*25.4/2.0;
		tyre_width	= W;
		profile_ratio	= r/100.0;
		if (optI > 0.0)
			optimal_inflation = optI;
		slide_cm	= (tyre_width-rW*25.4)/10.0;
		slide_interval	= (tyre_width-rW*25.4)/tyre_width; // Sala: percentage to the tyre width //
		if (slide_interval < 0.0)
			slide_interval = 0.0;
		if (slide_interval > 1.0)
			slide_interval = 1.0;

		profile_height	= tyre_width*profile_ratio;
		max_radius      = (wheel_radius+profile_height)/1000.0; // Sala: mm -> m //
		min_radius      = wheel_radius/1000.0; // Sala: 1.5cm more than rim diameter, mm -> m //
		if (max_radius < min_radius)
			min_radius = max_radius-0.01;

		SetupRubber(compound_type);
		if (optI > 0.0)
			SetInflation(optimal_inflation);
	}

	public void updatevariables()
	{
		SetInflation(inflation,1);
	}

	public void load( File saveGame )
	{
		super.load( saveGame );

		int	save_ver = saveGame.readInt();

		if (save_ver >= 1)
		{
			inflation = saveGame.readFloat();
		}
	}

	public void save( File saveGame )
	{
		super.save( saveGame );

		int	save_ver = 1;

		saveGame.write( save_ver );
		if (save_ver >= 1)
		{
			saveGame.write( inflation );
		}
	}

	//---------tuning
	public int isTuneable()
	{
		return 1;
	}

	// backup values //
	float	old_inflation;	
	float	new_inflation;

	public void buildTuningMenu( Menu m )
	{
		old_inflation = inflation;
		new_inflation = inflation;
		m.addItem( "Inflation",		1, inflation, 0.5, optimal_inflation, (optimal_inflation-0.5)/0.1+1, null ).changeVLabelText( Float.toString(new_inflation, "%1.2f bar")+Float.toString(new_inflation*14.7, " (%1.2f psi)"));
	}

	public void endTuningSession( int cancelled )
	{
		if( cancelled )
		{
			SetInflation(old_inflation,1);
		}
		else
		{
			SetInflation(new_inflation,1);
			GameLogic.spendTime(1*60);
		}

		getCar_LocalVersion();
		if (the_car)
			the_car.forceUpdate();
	}

	public void handleMessage( Event m )
	{
		if( m.cmd == 1 )
		{
			new_inflation = ((Slider)m.gadget).value;
			((Slider)m.gadget).changeVLabelText( Float.toString(new_inflation, "%1.2f bar")+Float.toString(new_inflation*14.7, " (%1.2f psi)"));
		}
	}
	//---------tuning
}
