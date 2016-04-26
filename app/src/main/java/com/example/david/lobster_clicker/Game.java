package com.example.david.lobster_clicker;

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
    private Powerups powerup;
    private int lobsterMulti=1;
    private int lobsterCount=0;
    private TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        powerup= new Powerups();
        display= (TextView) findViewById(R.id.powerupCost1);
        display.setText((int)powerup.getPowerupOneCost()+" Lobsters");
        display= (TextView) findViewById(R.id.powerupCost2);
        display.setText((int)powerup.getPowerupTwoCost()+" Lobsters");

        lobster= (Button) findViewById((R.id.lobster));
        lobster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lobsterCount= lobsterCount+ 1*lobsterMulti;
                display= (TextView) findViewById(R.id.countDisplay);
                display.setText(lobsterCount+" Lobsters");
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
                    display.setText(lobsterCount+" Lobsters");
                    display= (TextView) findViewById(R.id.powerupCost1);
                    display.setText((int)powerup.getPowerupOneCost()+" Lobsters");
                }
            }
        });
        PowerupX12= (Button) findViewById(R.id.powerup2);
        PowerupX12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cost= (int)powerup.getPowerupTwoCost();
                if(lobsterCount >= cost) {
                    int temp = powerup.activatePowerupTwo();
                    lobsterMulti = lobsterMulti * temp;
                    lobsterCount=lobsterCount-cost;
                    display= (TextView) findViewById(R.id.countDisplay);
                    display.setText(lobsterCount+" Lobsters");
                    display= (TextView) findViewById(R.id.powerupCost2);
                    display.setText((int)powerup.getPowerupTwoCost()+" Lobsters");
                }
            }
        });
    }
}
