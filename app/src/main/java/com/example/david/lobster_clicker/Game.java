package com.example.david.lobster_clicker;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Game extends AppCompatActivity {
    private Button homeButton;
    private Button lobster;
    private Button PowerupX5;
    private Button PowerupX12;
    private Button auto;
    private Powerups powerup;
    private int lobsterMulti=1;
    private double lobsterCount=0;
    private TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        powerup= new Powerups();
        final BuildingContainer buildings= new BuildingContainer(1);
        /*
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    lobsterCount=lobsterCount+buildings.generateLobsters();
                    display = (TextView) findViewById(R.id.countDisplay);
                    display.setText(Math.round(lobsterCount) + " Lobsters");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();
        */
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        display= (TextView) findViewById(R.id.powerupCost1);
        display.setText( Math.round(powerup.getPowerupOneCost()) + " Lobsters");
        display= (TextView) findViewById(R.id.powerupCost2);
        display.setText( Math.round(powerup.getPowerupTwoCost()) + " Lobsters");
        display= (TextView) findViewById(R.id.autoPrice);
        display.setText(Math.round(buildings.clickers[0].buildCost()) + " Lobsters");
        lobster= (Button) findViewById((R.id.lobster));
        lobster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lobsterCount = lobsterCount + 1 * lobsterMulti;
                display = (TextView) findViewById(R.id.countDisplay);
                display.setText(Math.round(lobsterCount) + " Lobsters");
            }
        });
        auto= (Button) findViewById(R.id.autoclick);
        auto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lobsterCount >= buildings.clickers[0].buildCost()) {
                    lobsterCount = lobsterCount - buildings.purchase(0, lobsterCount);
                    display = (TextView) findViewById(R.id.autoPrice);
                    display.setText(Math.round(buildings.clickers[0].buildCost()) + " Lobsters");
                    display = (TextView) findViewById(R.id.countDisplay);
                    display.setText(Math.round(lobsterCount) + " Lobsters");

                }
            }
        });
        homeButton = (Button) findViewById(R.id.home);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        PowerupX5= (Button) findViewById(R.id.powerup1);
        PowerupX5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cost= (int)powerup.getPowerupOneCost();
                if(lobsterCount >= cost) {
                    int temp = powerup.activatePowerupOne();
                    lobsterMulti = lobsterMulti * temp;
                    lobsterCount=lobsterCount-cost;
                    display= (TextView) findViewById(R.id.countDisplay);
                    display.setText(Math.round(lobsterCount)+" Lobsters");
                    display= (TextView) findViewById(R.id.powerupCost1);
                    display.setText(Math.round(powerup.getPowerupOneCost())+" Lobsters");
                }
            }
        });
        PowerupX12= (Button) findViewById(R.id.powerup2);
        PowerupX12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cost = (int) powerup.getPowerupTwoCost();
                if (lobsterCount >= cost) {
                    int temp = powerup.activatePowerupTwo();
                    lobsterMulti = lobsterMulti * temp;
                    lobsterCount = lobsterCount - cost;
                    display = (TextView) findViewById(R.id.countDisplay);
                    display.setText(Math.round(lobsterCount) + " Lobsters");
                    display = (TextView) findViewById(R.id.powerupCost2);
                    display.setText(Math.round(powerup.getPowerupTwoCost()) + " Lobsters");
                }
            }
        });

    }
}
