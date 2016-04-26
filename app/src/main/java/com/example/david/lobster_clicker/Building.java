
/**
 * Created by David on 4/23/2016.
 */
public class Building {
	double rate;
	double cost;
	double n;
	public Building(double lobsterRate, double baseCost, double num){
		rate= lobsterRate;
		cost=baseCost;
		n=num;
	}
	public double buildCost(){
		return (cost * Math.pow(1.15,n));
	}

	public double purchase(double score)
	{
		if(score>=buildCost())
		{
			double num=buildCost();
			n++;
			return num;
		}
		else
			return 0;
	}

	public double generate()
	{
		return rate*n;
	}
}
