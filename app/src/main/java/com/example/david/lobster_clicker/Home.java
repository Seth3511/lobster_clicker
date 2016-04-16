package com.example.david.lobster_clicker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {
    private Button PlayButton;
    private Button creditButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        PlayButton = (Button) findViewById(R.id.play);
        PlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, Game.class));
            }
        });
        creditButton = (Button) findViewById(R.id.credits);
        creditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, Credits.class));
            }
        });
    }
}
