package com.example.david.lobster_clicker;

import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Timer;
import java.util.TimerTask;


public class Game extends AppCompatActivity {
    private Button homeButton;
    private Button lobster;
    private Button PowerupX5;
    private Button PowerupX12;
    private Button auto;
    private Powerups powerup;
    private int lobsterMulti = 1;
    private double lobsterCount = 0;
    private TextView display;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        powerup = new Powerups();
        final BuildingContainer buildings = new BuildingContainer(1);

        /**Thread thread = new Thread(new Runnable() {
        @Override public void run() {
        while (true) {
        lobsterCount = lobsterCount + buildings.generateLobsters();
        display = (TextView) findViewById(R.id.countDisplay);
        display.setText(Math.round(lobsterCount) + " Lobsters");
        try {
        Thread.sleep(1000);
        } catch (InterruptedException e) {
        e.printStackTrace();
        }
        }

        }
        });
         thread.start();**/


        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            lobsterCount = lobsterCount + buildings.generateLobsters();
                            display = (TextView) findViewById(R.id.countDisplay);
                            display.setText(Math.round(lobsterCount) + " Lobsters");
                        }
                    });
            }

            }, 0, 1000);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        display = (TextView) findViewById(R.id.powerupCost1);
        display.setText(Math.round(powerup.getPowerupOneCost()) + " Lobsters");
        display = (TextView) findViewById(R.id.powerupCost2);
        display.setText(Math.round(powerup.getPowerupTwoCost()) + " Lobsters");
        display = (TextView) findViewById(R.id.autoPrice);
        display.setText(Math.round(buildings.clickers[0].buildCost()) + " Lobsters");
        lobster = (Button) findViewById((R.id.lobster));
        lobster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lobsterCount = lobsterCount + (1 * lobsterMulti);
                display = (TextView) findViewById(R.id.countDisplay);
                display.setText(Math.round(lobsterCount) + " Lobsters");
            }
        });
        auto = (Button) findViewById(R.id.autoclick);
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
        PowerupX5 = (Button) findViewById(R.id.powerup1);
        PowerupX5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cost = (int) powerup.getPowerupOneCost();
                if (lobsterCount >= cost) {
                    int temp = powerup.activatePowerupOne();
                    lobsterMulti = lobsterMulti * temp;
                    lobsterCount = lobsterCount - cost;
                    display = (TextView) findViewById(R.id.countDisplay);
                    display.setText(Math.round(lobsterCount) + " Lobsters");
                    display = (TextView) findViewById(R.id.powerupCost1);
                    display.setText(Math.round(powerup.getPowerupOneCost()) + " Lobsters");
                }
            }
        });
        PowerupX12 = (Button) findViewById(R.id.powerup2);
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
        //http://stackoverflow.com/questions/14814714/update-textview-every-second
        //start
        /**Thread t = new Thread() {

        @Override public void run() {
        while (!isInterrupted()) {
        runOnUiThread(new Runnable() {
        @Override public void run() {
        display = (TextView) findViewById(R.id.countDisplay);
        display.setText(Math.round(lobsterCount) + " Lobsters");
        }
        });
        }
        }
        };
         t.start();**/
        //end


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Game Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.david.lobster_clicker/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Game Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.david.lobster_clicker/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
