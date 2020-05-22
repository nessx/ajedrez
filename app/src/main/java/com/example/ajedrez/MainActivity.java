package com.example.ajedrez;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {
    CardView play,stats,help,about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);

        play = findViewById(R.id.play);
        stats = findViewById(R.id.stats);
        help = findViewById(R.id.help);
        about = findViewById(R.id.about);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, nombre.class);
                startActivity(intent);
            }
        });
    }
}

