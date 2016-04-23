package com.example.david.lobster_clicker;

/**
 * Created by David on 4/23/2016.
 */
public class UpgradePrice {

    public int buildCost(double currentBuilds, double baseCost){
        return (int) (baseCost * Math.pow(1.15,currentBuilds));
    }
}
