package java.game.cars;

import java.game.parts.rgearpart.reciprocatingrgearpart.brake.*;

public class brake_R extends DiscBrake
{
	public brake_R( int id )
	{
		super( id );

		diam_mm			= 255.0;
		friction_disc		= RT_VENTEDGROOVED;
		friction_pad		= BP_BLACK_STUFF;
		number_of_calipers	= 1.0;
		force			= CL_FORCE_BRUTAL;

		name_prefix = "Chevrolet El Camino rear brake";
		brand_prestige_factor = 2.65;
		calcStuffs();

		renderID_FL = cars.racers.FTO:0x00001562r;
		renderID_FR = cars.racers.FTO:0x00001562r;
		renderID_RL = cars.racers.FTO:0x00001562r;
		renderID_RR = cars.racers.FTO:0x00001562r;
	}
}
