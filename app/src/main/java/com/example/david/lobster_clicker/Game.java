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
    private int lobsterCount=0;
    private TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        lobster= (Button) findViewById((R.id.lobster));
        lobster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lobsterCount++;
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
    }
}
