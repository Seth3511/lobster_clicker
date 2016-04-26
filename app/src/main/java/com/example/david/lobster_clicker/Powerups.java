package com.example.david.lobster_clicker;

import java.util.*;  // needed for Scanner
import java.io.*;    // needed for File and FileNotFoundException

public class Powerups
{
	private double powerupOneCost;  //base cost of first power up.
	private double powerupTwoCost;  //base cost of second power up.
	private double oneIncrease;	 //multiplier for increasing the cost of the first powerup.
	private double twoIncrease;   //multiplier for increasing the cost of the second powerup.
	private int mOne;	//5x multiplier.
	private int mTwo;   //12x multiplier.
	public Powerups()
	{
		powerupOneCost = 5000;
		powerupTwoCost = 10000;
		oneIncrease= 1.1;
		twoIncrease= 1.5;
		mOne = 2;
		mTwo = 3;
	}
	/**
	 * activates the first power up, calls increaseOne().
	 * @param
	 * @return mOne, the 5x multiplier
	 */
	public int activatePowerupOne()
	{
		increaseOne();
		return mOne;
	}
	/**
	 * activates the second power up, calls increaseTwo().
	 * @param
	 * @return mTwo, the 12x multiplier
	 */
	public int activatePowerupTwo()
	{
		increaseTwo();
		return mTwo;
	}
	/**
	 * Increases the cost of the powerup and the amount it is going to increase the next time.
	 * @param
	 * @return void
	 * Makes cost equal to the cost * the increase. Then adds 1 to the increase value.
	 */
	private void increaseOne()
	{
		powerupOneCost = powerupOneCost * oneIncrease;
		oneIncrease+= .1;
	}
	/**
	 * Increases the cost of the powerup and the amount it is going to increase the next time.
	 * @param
	 * @return void
	 * Makes cost equal to the cost * the increase. Then adds 2 to the increase value.
	 */
	private void increaseTwo()
	{
		powerupTwoCost = powerupTwoCost * twoIncrease;
		twoIncrease+= .2;
	}
	public double getPowerupOneCost(){return (int)powerupOneCost;}
	public double getPowerupTwoCost(){return (int)powerupTwoCost;}
}