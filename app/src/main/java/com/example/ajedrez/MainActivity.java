package com.example.ajedrez;
/**
 * <h1>Menu inicial</h1>
 * Aqui estan los botones que se ven apenas iniciar la app:
 * Jugar (Inicia el juego)
 * Estadisticas (Muestra las estadisticas de las partidas)
 * Sobre nosotros (Informacion de los creadores de la app)
 * Solicitar ayuda (Informacion de las normas de juego)
 *
 * @author  Jeremy, Nestor, Hector
 * @version 1.0
 * @since   24-05-2020
 */
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

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Ayuda.class);
                startActivity(intent);
            }
        });
    }
}

