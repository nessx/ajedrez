package com.example.ajedrez;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ajedrez.piezas.pieza;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public Boolean Primerturno;
    public ArrayList<coordenadas> listacoordenadas = new ArrayList<>();
    public posicion[][] tablero = new posicion[8][8];
    public posicion[][] tablero2 = new posicion[8][8];
    public Boolean algoseleccionado = false;
    public coordenadas ultimaposicion = null ;
    public coordenadas posicionclickada = new coordenadas(0, 0);
    public TextView game_over;
    public TextView[][] vertablero = new TextView[8][8];
    public TextView[][] verfondodetrblero = new TextView[8][8];
    public ArrayList<posicion[][]> ultimosmovimientos = new ArrayList<>();
    public LinearLayout opciones_peon;
    public int numeromovimientos;

    //defino las piezas
    // "x" es la parte de arriba y "y" la de abajo de las piezas
    pieza xrey;
    pieza yrey;

    pieza xreina;
    pieza yreina;

    pieza xcaballo1;
    pieza xcaballo2;
    pieza ycaballo1;
    pieza ycaballo2;

    pieza xtorre1;
    pieza xtorre2;
    pieza wtorre1;
    pieza wtorre2;

    pieza xalfil1;
    pieza xalfil2;
    pieza yalfil1;
    pieza yalfil2;

    pieza xpeon1;
    pieza xpeon2;
    pieza xpeon3;
    pieza xpeon4;
    pieza xpeon5;
    pieza xpeon6;
    pieza xpeon7;
    pieza xpeon8;

    pieza ypeon1;
    pieza ypeon2;
    pieza ypeon3;
    pieza ypeon4;
    pieza ypeon5;
    pieza ypeon6;
    pieza ypeon7;
    pieza ypeon8;
    //end

    @Override
    public void onClick(View v) {

    }
}
