import java.util.*;  // needed for Scanner
import java.io.*;    // needed for File and FileNotFoundException

public class Powerups
{
	private int powerupOneCost;  //base cost of first power up.
	private int powerupTwoCost;  //base cost of second power up.
	private int oneIncrease;	 //multiplier for increasing the cost of the first powerup.
	private int twoIncrease;   //multiplier for increasing the cost of the second powerup.
	private int mOne;	//5x multiplier.
	private int mTwo;   //12x multiplier.
	public Powerups()
	{
		powerupOneCost = 1000;
		powerupTwoCost = 2000;
		mOne = 5;
		mTwo = 12;
	}
	/**
	 * activates the first power up, calls increaseOne().
	 * @param
	 * @return mOne, the 5x multiplier
	 */
	public int activatePowerupOne
	{
		increaseOne();
		return mOne;
	}
	/**
	 * activates the second power up, calls increaseTwo().
	 * @param
	 * @return mTwo, the 12x multiplier
	 */
	public int activatePowerupTwo
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
		oneIncrease++;
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
		twoIncrease+= 2;
	}
}