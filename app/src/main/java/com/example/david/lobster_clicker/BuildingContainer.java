package com.example.david.lobster_clicker;

import com.example.david.lobster_clicker.Building;

public class BuildingContainer
{
	Building[] clickers;
	int n;
	
	public BuildingContainer(int n)
	{
		this.n=n;
		clickers=new Building[n];
		
		for(int i=0;i<n;i++)
		{
			clickers[i]=new Building(Math.pow(10,i-1),Math.pow(10,i+1),0);
		}
	}

	public double purchase(int i, double score)
	{
		return clickers[i].purchase(score);
	}

	public double generate()
	{
		double x=0;
		for(int i=0;i<n;i++)
		{
			x+=clickers[i].generate();
		}
		
		return x;
	}
}
