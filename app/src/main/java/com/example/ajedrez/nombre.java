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
    public TextView textosel,nombres;
    Button enviareleccion,enviarnombre;
    public EditText name;
    public boolean turnos;
    final int random_int = (int)(Math.random() * (2 - 1 + 1) + 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name);

        nombres = findViewById(R.id.name);
        enviarnombre = findViewById(R.id.enviar);
        textosel = findViewById(R.id.nombres);

        //no configured
        enviareleccion = findViewById(R.id.selenviar);

        enviarnombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombres.setVisibility(View.INVISIBLE);
                enviarnombre.setVisibility(View.INVISIBLE);
                selficha.setVisibility(View.VISIBLE);
                if (random_int==1){
                    textosel.setText("Jugador 1 elije ficha");

                }
                else if (random_int==2){
                    textosel.setText("Jugador 2 elije ficha");
                }
            }
        });

        selficha = (RadioGroup) findViewById(R.id.selficha);
        selficha.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.optblanca) {
                    Toast.makeText(getApplicationContext(), "Elegiste: blanca",
                            Toast.LENGTH_SHORT).show();
                    turnos = true;
                } else if (checkedId == R.id.optnegra) {
                    Toast.makeText(getApplicationContext(), "Elegiste: negras",
                            Toast.LENGTH_SHORT).show();
                    turnos = false;
                } else {
                    Toast.makeText(getApplicationContext(), "No las seleccionado nada",
                            Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(nombre.this, juego.class);
                startActivity(intent);
            }
        });
    }
    //turno
    Boolean geturno(){
        return turnos;
    }

    public void setutno(Boolean turnos){
        this.turnos=turnos;
    }
    //turno
}