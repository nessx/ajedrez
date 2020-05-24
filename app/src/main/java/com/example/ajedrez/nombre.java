package com.example.ajedrez;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class nombre extends AppCompatActivity{
    //boton radio
    public RadioGroup selficha;
    public RadioButton optblanca, optnegra;
    Button enviarnombre;
    public TextView textosel,name,name2;
    public boolean selcolor;
    final int random_int = (int)(Math.random() * (2 - 1 + 1) + 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name);

        name = findViewById(R.id.name);
        name2 = findViewById(R.id.name2);

        enviarnombre = findViewById(R.id.enviar);
        textosel = findViewById(R.id.nombres);

        selficha = (RadioGroup) findViewById(R.id.selficha);

        enviarnombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String Jugador1 = name.getText().toString();
                final String Jugador2 = name2.getText().toString();
                name.setVisibility(View.INVISIBLE);
                name2.setVisibility(View.INVISIBLE);
                enviarnombre.setVisibility(View.INVISIBLE);
                selficha.setVisibility(View.VISIBLE);

                final Intent intent = new Intent(nombre.this, juego.class);
                if (random_int==1){
                    textosel.setText(Jugador1+" elije ficha");

                    selficha.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedId) {
                            if (checkedId == R.id.optblanca){
                                Toast.makeText(getApplicationContext(), "Elegiste: blanca",
                                        Toast.LENGTH_SHORT).show();
                            } else if (checkedId == R.id.optnegra) {
                                Toast.makeText(getApplicationContext(), "Elegiste: negras",
                                        Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getApplicationContext(), "No las seleccionado nada",
                                        Toast.LENGTH_SHORT).show();
                            }
                            intent.putExtra("JUGADOR2", Jugador2);
                            intent.putExtra("JUGADOR1", Jugador1);
                            startActivity(intent);
                        }
                    });
                }
                else if (random_int==2){
                    textosel.setText(Jugador2+" elije ficha");
                    selficha.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedId) {
                            if (checkedId == R.id.optblanca){
                                Toast.makeText(getApplicationContext(), "Elegiste: blanca",
                                        Toast.LENGTH_SHORT).show();
                            } else if (checkedId == R.id.optnegra) {
                                Toast.makeText(getApplicationContext(), "Elegiste: negras",
                                        Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getApplicationContext(), "No las seleccionado nada",
                                        Toast.LENGTH_SHORT).show();
                            }
                            intent.putExtra("JUGADOR2", Jugador2);
                            intent.putExtra("JUGADOR1", Jugador1);
                            startActivity(intent);
                        }
                    });
                }
            }
        });
    }
}