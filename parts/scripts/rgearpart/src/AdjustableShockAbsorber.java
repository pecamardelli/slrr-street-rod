package java.game.parts.rgearpart;

import java.render.osd.*;
import java.io.*;
import java.util.*;
import java.util.resource.*;
import java.game.*;
import java.game.cars.*;
import java.game.parts.*;
import java.game.parts.bodypart.*;
import java.game.parts.enginepart.*;

public class AdjustableShockAbsorber extends ShockAbsorber
{
	final float damping_difference = 1000.0;
	
	public AdjustableShockAbsorber( int id )
	{
		super( id );
		
		adjustable_damping = 1;
		adjustable_rebound_factor = 1;
		
		rebound_factor_interval = 0.1;
	}
	
	public void calcStuffs()
	{
		min_damping = damping - damping_difference;
		max_damping = damping + damping_difference;
		
		super.calcStuffs();
		updateName();
	}
	
	public void load( File saveGame )
	{
		super.load( saveGame );
		updateName();
	}
	
	public void endTuningSession( int cancelled )
	{
		super.endTuningSession( cancelled );
		updateName();
	}
	
	private void updateName()
	{
		int dI = damping;
		String wi_text = "";
		
		if (whats_inside == WI_GAS)
			wi_text = "gas";
		else
		if (whats_inside == WI_OIL)
			wi_text = "oil";
		else
		if (whats_inside == WI_GAS_OIL)
			wi_text = "oil-gas";
		
		name = name_prefix + " " + dI + " N/m/s " + wi_text + " shock";
	}
}
