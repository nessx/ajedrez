package com.example.ajedrez;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.ajedrez.piezas.Pieza;
import com.example.ajedrez.piezas.alfil;
import com.example.ajedrez.piezas.caballo;
import com.example.ajedrez.piezas.peon;
import com.example.ajedrez.piezas.reina;
import com.example.ajedrez.piezas.rey;
import com.example.ajedrez.piezas.torre;

import java.util.ArrayList;

public class juego extends AppCompatActivity implements View.OnClickListener{

    //Declacion de vartiables
    public Boolean Primerturno;
    public Boolean eleccion;
    public ArrayList<Coordenadas> listacoordenadas = new ArrayList<>();
    public posicion[][] tablero = new posicion[8][8];
    public posicion[][] tablero2 = new posicion[8][8];
    public Boolean algoseleccionado = false;

    public RadioGroup selficha;
    public RadioButton optblanca, optnegra;

    public TextView textosel;
    public Button selenviar;

    public Coordenadas ultimaposicion = null ;
    public Coordenadas posicionclickada = new Coordenadas(0, 0);
    public TextView juego_terminado,titulo,ganador;
    public TextView[][] ftablero = new TextView[8][8];
    public TextView[][] fondodetablero = new TextView[8][8];
    public ArrayList<posicion[][]> ultimovimiento = new ArrayList<>();
    public LinearLayout opciones_peon;
    public int numeromovimientos;

    //recogiendo nombre
    public Button enviar;
    public EditText name;

    //defino las piezas
    // "x" es la parte de arriba (negras) y "y" la de abajo de las piezas (blancas)
    Pieza xrey, yrey;

    Pieza xreina, yreina;

    Pieza xcaballo1, xcaballo2, ycaballo1, ycaballo2;

    Pieza xtorre1, xtorre2, ytorre1, ytorre2;

    Pieza xalfil1, xalfil2, yalfil1, yalfil2;

    Pieza xpeon1,xpeon2, xpeon3, xpeon4, xpeon5, xpeon6, xpeon7, xpeon8;

    Pieza ypeon1, ypeon2, ypeon3, ypeon4, ypeon5, ypeon6, ypeon7, ypeon8;

    public TextView selplayer1,selplayer2;
    //end

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // hace que la barra de notificacion sea transparente
        if (Build.VERSION.SDK_INT >= 29) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        setContentView(R.layout.activity_main);

        inicializartablero();
        juego_terminado = (TextView)findViewById(R.id.juego_terminado);
        titulo = (TextView)findViewById(R.id.titulo);
        ganador = (TextView)findViewById(R.id.ganador);
        opciones_peon = (LinearLayout)findViewById(R.id.opciones_peon);

        juego_terminado.setVisibility(View.INVISIBLE);
        opciones_peon.setVisibility(View.INVISIBLE);

        //eleccion de bando
        selplayer1 = findViewById(R.id.selplayer1);
        selplayer2 = findViewById(R.id.selplayer2);

        String seleplayer1 = (String) getIntent().getStringExtra("JUGADOR1");
        selplayer1.setText(seleplayer1);

        String seleplayer2 = (String) getIntent().getStringExtra("JUGADOR2");
        selplayer2.setText(seleplayer2);
    }
    //END

    private void inicializartablero() {
        // "x" es la parte de arriba (negras) y "y" la de abajo de las piezas (blancas)
        xrey = new rey(false);
        yrey = new rey(true);

        xreina = new reina(false);
        yreina = new reina(true);

        xtorre1 = new torre(false);
        xtorre2 = new torre(false);
        ytorre1 = new torre(true);
        ytorre2 = new torre(true);

        xcaballo1 = new caballo(false);
        xcaballo2 = new caballo(false);
        ycaballo1 = new caballo(true);
        ycaballo2 = new caballo(true);

        xalfil1 = new alfil(false);
        xalfil2 = new alfil(false);
        yalfil1 = new alfil(true);
        yalfil2 = new alfil(true);

        xpeon1 = new peon(false);
        xpeon2 = new peon(false);
        xpeon3 = new peon(false);
        xpeon4 = new peon(false);
        xpeon5 = new peon(false);
        xpeon6 = new peon(false);
        xpeon7 = new peon(false);
        xpeon8 = new peon(false);

        ypeon1 = new peon(true);
        ypeon2 = new peon(true);
        ypeon3 = new peon(true);
        ypeon4 = new peon(true);
        ypeon5 = new peon(true);
        ypeon6 = new peon(true);
        ypeon7 = new peon(true);
        ypeon8 = new peon(true);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tablero[i][j] = new posicion(null);
                tablero2[i][j] = new posicion(null);
            }
        }

        //aigna piezas a cada espacio en la matriz
        tablero[0][7].setpieza(ytorre1);
        tablero[1][7].setpieza(ycaballo1);
        tablero[2][7].setpieza(yalfil1);
        tablero[3][7].setpieza(yreina);
        tablero[4][7].setpieza(yrey);
        tablero[5][7].setpieza(yalfil2);
        tablero[6][7].setpieza(ycaballo2);
        tablero[7][7].setpieza(ytorre2);

        tablero[0][6].setpieza(ypeon1);
        tablero[1][6].setpieza(ypeon2);
        tablero[2][6].setpieza(ypeon3);
        tablero[3][6].setpieza(ypeon4);
        tablero[4][6].setpieza(ypeon5);
        tablero[5][6].setpieza(ypeon6);
        tablero[6][6].setpieza(ypeon7);
        tablero[7][6].setpieza(ypeon8);

        tablero[0][0].setpieza(xtorre1);
        tablero[1][0].setpieza(xcaballo1);
        tablero[2][0].setpieza(xalfil1);
        tablero[3][0].setpieza(xreina);
        tablero[4][0].setpieza(xrey);
        tablero[5][0].setpieza(xalfil2);
        tablero[6][0].setpieza(xcaballo2);
        tablero[7][0].setpieza(xtorre2);

        tablero[0][1].setpieza(xpeon1);
        tablero[1][1].setpieza(xpeon2);
        tablero[2][1].setpieza(xpeon3);
        tablero[3][1].setpieza(xpeon4);
        tablero[4][1].setpieza(xpeon5);
        tablero[5][1].setpieza(xpeon6);
        tablero[6][1].setpieza(xpeon7);
        tablero[7][1].setpieza(xpeon8);

        //primera tanda de numeros
        ftablero[0][0] = (TextView) findViewById(R.id.A8);
        fondodetablero[0][0] = (TextView) findViewById(R.id.AA8);
        ftablero[1][0] = (TextView) findViewById(R.id.B8);
        fondodetablero[1][0] = (TextView) findViewById(R.id.BB8);
        ftablero[2][0] = (TextView) findViewById(R.id.C8);
        fondodetablero[2][0] = (TextView) findViewById(R.id.CC8);
        ftablero[3][0] = (TextView) findViewById(R.id.D8);
        fondodetablero[3][0] = (TextView) findViewById(R.id.DD8);
        ftablero[4][0] = (TextView) findViewById(R.id.E8);
        fondodetablero[4][0] = (TextView) findViewById(R.id.EE8);
        ftablero[5][0] = (TextView) findViewById(R.id.F8);
        fondodetablero[5][0] = (TextView) findViewById(R.id.FF8);
        ftablero[6][0] = (TextView) findViewById(R.id.G8);
        fondodetablero[6][0] = (TextView) findViewById(R.id.GG8);
        ftablero[7][0] = (TextView) findViewById(R.id.H8);
        fondodetablero[7][0] = (TextView) findViewById(R.id.HH8);

        //segunda tanda de numeros
        ftablero[0][1] = (TextView) findViewById(R.id.A7);
        fondodetablero[0][1] = (TextView) findViewById(R.id.AA7);
        ftablero[1][1] = (TextView) findViewById(R.id.B7);
        fondodetablero[1][1] = (TextView) findViewById(R.id.BB7);
        ftablero[2][1] = (TextView) findViewById(R.id.C7);
        fondodetablero[2][1] = (TextView) findViewById(R.id.CC7);
        ftablero[3][1] = (TextView) findViewById(R.id.D7);
        fondodetablero[3][1] = (TextView) findViewById(R.id.DD7);
        ftablero[4][1] = (TextView) findViewById(R.id.E7);
        fondodetablero[4][1] = (TextView) findViewById(R.id.EE7);
        ftablero[5][1] = (TextView) findViewById(R.id.F7);
        fondodetablero[5][1] = (TextView) findViewById(R.id.FF7);
        ftablero[6][1] = (TextView) findViewById(R.id.G7);
        fondodetablero[6][1] = (TextView) findViewById(R.id.GG7);
        ftablero[7][1] = (TextView) findViewById(R.id.H7);
        fondodetablero[7][1] = (TextView) findViewById(R.id.HH7);

        //tercera tanta de numeros
        ftablero[0][2] = (TextView) findViewById(R.id.A6);
        fondodetablero[0][2] = (TextView) findViewById(R.id.AA6);
        ftablero[1][2] = (TextView) findViewById(R.id.B6);
        fondodetablero[1][2] = (TextView) findViewById(R.id.BB6);
        ftablero[2][2] = (TextView) findViewById(R.id.C6);
        fondodetablero[2][2] = (TextView) findViewById(R.id.CC6);
        ftablero[3][2] = (TextView) findViewById(R.id.D6);
        fondodetablero[3][2] = (TextView) findViewById(R.id.DD6);
        ftablero[4][2] = (TextView) findViewById(R.id.E6);
        fondodetablero[4][2] = (TextView) findViewById(R.id.EE6);
        ftablero[5][2] = (TextView) findViewById(R.id.F6);
        fondodetablero[5][2] = (TextView) findViewById(R.id.FF6);
        ftablero[6][2] = (TextView) findViewById(R.id.G6);
        fondodetablero[6][2] = (TextView) findViewById(R.id.GG6);
        ftablero[7][2] = (TextView) findViewById(R.id.H6);
        fondodetablero[7][2] = (TextView) findViewById(R.id.HH6);


        //cuarta tanda de numeros
        ftablero[0][3] = (TextView) findViewById(R.id.A5);
        fondodetablero[0][3] = (TextView) findViewById(R.id.AA5);
        ftablero[1][3] = (TextView) findViewById(R.id.B5);
        fondodetablero[1][3] = (TextView) findViewById(R.id.BB5);
        ftablero[2][3] = (TextView) findViewById(R.id.C5);
        fondodetablero[2][3] = (TextView) findViewById(R.id.CC5);
        ftablero[3][3] = (TextView) findViewById(R.id.D5);
        fondodetablero[3][3] = (TextView) findViewById(R.id.DD5);
        ftablero[4][3] = (TextView) findViewById(R.id.E5);
        fondodetablero[4][3] = (TextView) findViewById(R.id.EE5);
        ftablero[5][3] = (TextView) findViewById(R.id.F5);
        fondodetablero[5][3] = (TextView) findViewById(R.id.FF5);
        ftablero[6][3] = (TextView) findViewById(R.id.G5);
        fondodetablero[6][3] = (TextView) findViewById(R.id.GG5);
        ftablero[7][3] = (TextView) findViewById(R.id.H5);
        fondodetablero[7][3] = (TextView) findViewById(R.id.HH5);

        //QUINTA TANDA DE NUMEROS
        ftablero[0][4] = (TextView) findViewById(R.id.A4);
        fondodetablero[0][4] = (TextView) findViewById(R.id.AA4);
        ftablero[1][4] = (TextView) findViewById(R.id.B4);
        fondodetablero[1][4] = (TextView) findViewById(R.id.BB4);
        ftablero[2][4] = (TextView) findViewById(R.id.C4);
        fondodetablero[2][4] = (TextView) findViewById(R.id.CC4);
        ftablero[3][4] = (TextView) findViewById(R.id.D4);
        fondodetablero[3][4] = (TextView) findViewById(R.id.DD4);
        ftablero[4][4] = (TextView) findViewById(R.id.E4);
        fondodetablero[4][4] = (TextView) findViewById(R.id.EE4);
        ftablero[5][4] = (TextView) findViewById(R.id.F4);
        fondodetablero[5][4] = (TextView) findViewById(R.id.FF4);
        ftablero[6][4] = (TextView) findViewById(R.id.G4);
        fondodetablero[6][4] = (TextView) findViewById(R.id.GG4);
        ftablero[7][4] = (TextView) findViewById(R.id.H4);
        fondodetablero[7][4] = (TextView) findViewById(R.id.HH4);

        //SEXTA TANDA
        ftablero[0][5] = (TextView) findViewById(R.id.A3);
        fondodetablero[0][5] = (TextView) findViewById(R.id.AA3);
        ftablero[1][5] = (TextView) findViewById(R.id.B3);
        fondodetablero[1][5] = (TextView) findViewById(R.id.BB3);
        ftablero[2][5] = (TextView) findViewById(R.id.C3);
        fondodetablero[2][5] = (TextView) findViewById(R.id.CC3);
        ftablero[3][5] = (TextView) findViewById(R.id.D3);
        fondodetablero[3][5] = (TextView) findViewById(R.id.DD3);
        ftablero[4][5] = (TextView) findViewById(R.id.E3);
        fondodetablero[4][5] = (TextView) findViewById(R.id.EE3);
        ftablero[5][5] = (TextView) findViewById(R.id.F3);
        fondodetablero[5][5] = (TextView) findViewById(R.id.FF3);
        ftablero[6][5] = (TextView) findViewById(R.id.G3);
        fondodetablero[6][5] = (TextView) findViewById(R.id.GG3);
        ftablero[7][5] = (TextView) findViewById(R.id.H3);
        fondodetablero[7][5] = (TextView) findViewById(R.id.HH3);

        //SEPTIMA TANDA
        ftablero[0][6] = (TextView) findViewById(R.id.A2);
        fondodetablero[0][6] = (TextView) findViewById(R.id.AA2);
        ftablero[1][6] = (TextView) findViewById(R.id.B2);
        fondodetablero[1][6] = (TextView) findViewById(R.id.BB2);
        ftablero[2][6] = (TextView) findViewById(R.id.C2);
        fondodetablero[2][6] = (TextView) findViewById(R.id.CC2);
        ftablero[3][6] = (TextView) findViewById(R.id.D2);
        fondodetablero[3][6] = (TextView) findViewById(R.id.DD2);
        ftablero[4][6] = (TextView) findViewById(R.id.E2);
        fondodetablero[4][6] = (TextView) findViewById(R.id.EE2);
        ftablero[5][6] = (TextView) findViewById(R.id.F2);
        fondodetablero[5][6] = (TextView) findViewById(R.id.FF2);
        ftablero[6][6] = (TextView) findViewById(R.id.G2);
        fondodetablero[6][6] = (TextView) findViewById(R.id.GG2);
        ftablero[7][6] = (TextView) findViewById(R.id.H2);
        fondodetablero[7][6] = (TextView) findViewById(R.id.HH2);

        //OCTAVA TANDA
        ftablero[0][7] = (TextView) findViewById(R.id.A1);
        fondodetablero[0][7] = (TextView) findViewById(R.id.AA1);
        ftablero[1][7] = (TextView) findViewById(R.id.B1);
        fondodetablero[1][7] = (TextView) findViewById(R.id.BB1);
        ftablero[2][7] = (TextView) findViewById(R.id.C1);
        fondodetablero[2][7] = (TextView) findViewById(R.id.CC1);
        ftablero[3][7] = (TextView) findViewById(R.id.D1);
        fondodetablero[3][7] = (TextView) findViewById(R.id.DD1);
        ftablero[4][7] = (TextView) findViewById(R.id.E1);
        fondodetablero[4][7] = (TextView) findViewById(R.id.EE1);
        ftablero[5][7] = (TextView) findViewById(R.id.F1);
        fondodetablero[5][7] = (TextView) findViewById(R.id.FF1);
        ftablero[6][7] = (TextView) findViewById(R.id.G1);
        fondodetablero[6][7] = (TextView) findViewById(R.id.GG1);
        ftablero[7][7] = (TextView) findViewById(R.id.H1);
        fondodetablero[7][7] = (TextView) findViewById(R.id.HH1);

        for(int g=0;g<8;g++){
            for(int h=0;h<8;h++){
                if(tablero[g][h].getpieza()==null){
                    tablero2[g][h].setpieza(null);
                }else{
                    tablero2[g][h].setpieza(tablero[g][h].getpieza());
                }
            }
        }

        numeromovimientos = 0;
        algoseleccionado = false;

        //si esto es true, las blancas tienen el primer turno si es falso lo tienen las negras
        nombre turno = new nombre();
        //no usado

        Primerturno = true;

        settablero();
    }

    private void settablero() {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                Pieza p = tablero[i][j].getpieza();
                int x;

                if (tablero[i][j].getpieza() != null) {
                    if (p instanceof rey) x = 0;
                    else if (p instanceof reina) x = 1;
                    else if (p instanceof torre) x = 2;
                    else if (p instanceof alfil) x = 3;
                    else if (p instanceof caballo) x = 4;
                    else if (p instanceof peon) x = 5;
                    else x = 6;

                    switch (x) {
                        case 0:
                            if (p.esblanca()) {
                                ftablero[i][j].setBackgroundResource(R.drawable.wrey);
                            } else {
                                ftablero[i][j].setBackgroundResource(R.drawable.brey);
                            }
                            break;

                        case 1:
                            if (p.esblanca()) {
                                ftablero[i][j].setBackgroundResource(R.drawable.wreina);
                            } else {
                                ftablero[i][j].setBackgroundResource(R.drawable.breina);
                            }
                            break;

                        case 2:
                            if (p.esblanca()) {
                                ftablero[i][j].setBackgroundResource(R.drawable.wtorre);
                            } else {
                                ftablero[i][j].setBackgroundResource(R.drawable.btorre);
                            }
                            break;

                        case 3:
                            if (p.esblanca()) {
                                ftablero[i][j].setBackgroundResource(R.drawable.walfil);
                            } else {
                                ftablero[i][j].setBackgroundResource(R.drawable.balfil);
                            }
                            break;

                        case 4:
                            if (p.esblanca()) {
                                ftablero[i][j].setBackgroundResource(R.drawable.wcaballo);
                            } else {
                                ftablero[i][j].setBackgroundResource(R.drawable.bcaballo);
                            }
                            break;

                        case 5:
                            if (p.esblanca()) {
                                ftablero[i][j].setBackgroundResource(R.drawable.wpeon);
                            } else {
                                ftablero[i][j].setBackgroundResource(R.drawable.bpeon);
                            }
                            break;

                        default:

                    }
                }else{
                    ftablero[i][j].setBackgroundResource(0);
                }
            }
        }
        reypeligro();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.A8:
                posicionclickada = new Coordenadas(0, 0);
                break;
            case R.id.B8:
                posicionclickada.setX(1);
                posicionclickada.setY(0);
                break;
            case R.id.C8:
                posicionclickada.setX(2);
                posicionclickada.setY(0);
                break;
            case R.id.D8:
                posicionclickada.setX(3);
                posicionclickada.setY(0);
                break;
            case R.id.E8:
                posicionclickada.setX(4);
                posicionclickada.setY(0);
                break;
            case R.id.F8:
                posicionclickada.setX(5);
                posicionclickada.setY(0);
                break;
            case R.id.G8:
                posicionclickada.setX(6);
                posicionclickada.setY(0);
                break;
            case R.id.H8:
                posicionclickada.setX(7);
                posicionclickada.setY(0);
                break;

            case R.id.A7:
                posicionclickada.setX(0);
                posicionclickada.setY(1);
                break;
            case R.id.B7:
                posicionclickada.setX(1);
                posicionclickada.setY(1);
                break;
            case R.id.C7:
                posicionclickada.setX(2);
                posicionclickada.setY(1);
                break;
            case R.id.D7:
                posicionclickada.setX(3);
                posicionclickada.setY(1);
                break;
            case R.id.E7:
                posicionclickada.setX(4);
                posicionclickada.setY(1);
                break;
            case R.id.F7:
                posicionclickada.setX(5);
                posicionclickada.setY(1);
                break;
            case R.id.G7:
                posicionclickada.setX(6);
                posicionclickada.setY(1);
                break;
            case R.id.H7:
                posicionclickada.setX(7);
                posicionclickada.setY(1);
                break;

            case R.id.A6:
                posicionclickada.setX(0);
                posicionclickada.setY(2);
                break;
            case R.id.B6:
                posicionclickada.setX(1);
                posicionclickada.setY(2);
                break;
            case R.id.C6:
                posicionclickada.setX(2);
                posicionclickada.setY(2);
                break;
            case R.id.D6:
                posicionclickada.setX(3);
                posicionclickada.setY(2);
                break;
            case R.id.E6:
                posicionclickada.setX(4);
                posicionclickada.setY(2);
                break;
            case R.id.F6:
                posicionclickada.setX(5);
                posicionclickada.setY(2);
                break;
            case R.id.G6:
                posicionclickada.setX(6);
                posicionclickada.setY(2);
                break;
            case R.id.H6:
                posicionclickada.setX(7);
                posicionclickada.setY(2);
                break;

            case R.id.A5:
                posicionclickada.setX(0);
                posicionclickada.setY(3);
                break;
            case R.id.B5:
                posicionclickada.setX(1);
                posicionclickada.setY(3);
                break;
            case R.id.C5:
                posicionclickada.setX(2);
                posicionclickada.setY(3);
                break;
            case R.id.D5:
                posicionclickada.setX(3);
                posicionclickada.setY(3);
                break;
            case R.id.E5:
                posicionclickada.setX(4);
                posicionclickada.setY(3);
                break;
            case R.id.F5:
                posicionclickada.setX(5);
                posicionclickada.setY(3);
                break;
            case R.id.G5:
                posicionclickada.setX(6);
                posicionclickada.setY(3);
                break;
            case R.id.H5:
                posicionclickada.setX(7);
                posicionclickada.setY(3);
                break;

            case R.id.A4:
                posicionclickada.setX(0);
                posicionclickada.setY(4);
                break;
            case R.id.B4:
                posicionclickada.setX(1);
                posicionclickada.setY(4);
                break;
            case R.id.C4:
                posicionclickada.setX(2);
                posicionclickada.setY(4);
                break;
            case R.id.D4:
                posicionclickada.setX(3);
                posicionclickada.setY(4);
                break;
            case R.id.E4:
                posicionclickada.setX(4);
                posicionclickada.setY(4);
                break;
            case R.id.F4:
                posicionclickada.setX(5);
                posicionclickada.setY(4);
                break;
            case R.id.G4:
                posicionclickada.setX(6);
                posicionclickada.setY(4);
                break;
            case R.id.H4:
                posicionclickada.setX(7);
                posicionclickada.setY(4);
                break;

            case R.id.A3:
                posicionclickada.setX(0);
                posicionclickada.setY(5);
                break;
            case R.id.B3:
                posicionclickada.setX(1);
                posicionclickada.setY(5);
                break;
            case R.id.C3:
                posicionclickada.setX(2);
                posicionclickada.setY(5);
                break;
            case R.id.D3:
                posicionclickada.setX(3);
                posicionclickada.setY(5);
                break;
            case R.id.E3:
                posicionclickada.setX(4);
                posicionclickada.setY(5);
                break;
            case R.id.F3:
                posicionclickada.setX(5);
                posicionclickada.setY(5);
                break;
            case R.id.G3:
                posicionclickada.setX(6);
                posicionclickada.setY(5);
                break;
            case R.id.H3:
                posicionclickada.setX(7);
                posicionclickada.setY(5);
                break;

            case R.id.A2:
                posicionclickada.setX(0);
                posicionclickada.setY(6);
                break;
            case R.id.B2:
                posicionclickada.setX(1);
                posicionclickada.setY(6);
                break;
            case R.id.C2:
                posicionclickada.setX(2);
                posicionclickada.setY(6);
                break;
            case R.id.D2:
                posicionclickada.setX(3);
                posicionclickada.setY(6);
                break;
            case R.id.E2:
                posicionclickada.setX(4);
                posicionclickada.setY(6);
                break;
            case R.id.F2:
                posicionclickada.setX(5);
                posicionclickada.setY(6);
                break;
            case R.id.G2:
                posicionclickada.setX(6);
                posicionclickada.setY(6);
                break;
            case R.id.H2:
                posicionclickada.setX(7);
                posicionclickada.setY(6);
                break;

            case R.id.A1:
                posicionclickada.setX(0);
                posicionclickada.setY(7);
                break;
            case R.id.B1:
                posicionclickada.setX(1);
                posicionclickada.setY(7);
                break;
            case R.id.C1:
                posicionclickada.setX(2);
                posicionclickada.setY(7);
                break;
            case R.id.D1:
                posicionclickada.setX(3);
                posicionclickada.setY(7);
                break;
            case R.id.E1:
                posicionclickada.setX(4);
                posicionclickada.setY(7);
                break;
            case R.id.F1:
                posicionclickada.setX(5);
                posicionclickada.setY(7);
                break;
            case R.id.G1:
                posicionclickada.setX(6);
                posicionclickada.setY(7);
                break;
            case R.id.H1:
                posicionclickada.setX(7);
                posicionclickada.setY(7);
                break;
        }

        if (!algoseleccionado) {
            if(tablero[posicionclickada.getX()][posicionclickada.getY()].getpieza() == null) {
                reypeligro();
                return;
            }else{
                if(tablero[posicionclickada.getX()][posicionclickada.getY()].getpieza().esblanca() != Primerturno){
                    reypeligro();
                    return;
                }else{
                    listacoordenadas.clear();
                    listacoordenadas = tablero[posicionclickada.getX()][posicionclickada.getY()].getpieza().movperm(posicionclickada, tablero);
                    fondodetablero[posicionclickada.getX()][posicionclickada.getY()].setBackgroundResource(R.color.colormov);
                    setColorposicionperm(listacoordenadas);
                    algoseleccionado = true;
                }
            }
        } else {
            if(tablero[posicionclickada.getX()][posicionclickada.getY()].getpieza() == null){
                if(moverselec(listacoordenadas , posicionclickada)){

                    registrotablero();
                    if(tablero[posicionclickada.getX()][posicionclickada.getY()].getpieza() instanceof rey){
                        if(tablero[posicionclickada.getX()][posicionclickada.getY()].getpieza().esblanca() != Primerturno){
                            juego_terminado.setVisibility(View.VISIBLE);

                            //test
                            titulo.setVisibility(View.INVISIBLE);
                        }
                    }
                    tablero[posicionclickada.getX()][posicionclickada.getY()].setpieza(tablero[ultimaposicion.getX()][ultimaposicion.getY()].getpieza());
                    tablero[ultimaposicion.getX()][ultimaposicion.getY()].setpieza(null);

                    reypeligro();
                    resetcolorposicionperm(listacoordenadas);
                    ftablero[ultimaposicion.getX()][ultimaposicion.getY()].setBackgroundResource(0);
                    resetColorAtultimaposicionition(ultimaposicion);
                    algoseleccionado = false;
                    Primerturno = !Primerturno;
                    revisorpeon();

                }else{
                    resetColorAtultimaposicionition(ultimaposicion);
                    resetcolorposicionperm(listacoordenadas);
                    algoseleccionado = false;
                }

            }else{
                if(tablero[posicionclickada.getX()][posicionclickada.getY()].getpieza() == null) {
                    reypeligro();
                    return;

                }else{
                    if(tablero[posicionclickada.getX()][posicionclickada.getY()].getpieza() !=null){
                        if(tablero[posicionclickada.getX()][posicionclickada.getY()].getpieza().esblanca() != Primerturno){
                            if(moverselec(listacoordenadas , posicionclickada)){
                                registrotablero();

                                //si la reina muere esto es global tanto como si muere la tuya como la de el
                                //el metodo instanceof es -> SI ES UN
                                if(tablero[posicionclickada.getX()][posicionclickada.getY()].getpieza() instanceof rey){
                                    if(tablero[posicionclickada.getX()][posicionclickada.getY()].getpieza().esblanca() != Primerturno){
                                        juego_terminado.setVisibility(View.VISIBLE);
                                    }
                                }

                                //si muere el rey negro
                                if(tablero[posicionclickada.getX()][posicionclickada.getY()].getpieza() == xrey){
                                    String seleplayer1 = (String) getIntent().getStringExtra("JUGADOR1");
                                    ganador.setVisibility(View.VISIBLE);
                                    ganador.setText(seleplayer1+" Ha ganado");

                                    //titulo.setVisibility(View.INVISIBLE);
                                }

                                //si muere el rey blanco
                                if(tablero[posicionclickada.getX()][posicionclickada.getY()].getpieza() == yrey){
                                    //titulo.setVisibility(View.INVISIBLE);

                                    String seleplayer2 = (String) getIntent().getStringExtra("JUGADOR2");
                                    ganador.setVisibility(View.VISIBLE);
                                    ganador.setText(seleplayer2+" Ha ganado");
                                }

                                tablero[posicionclickada.getX()][posicionclickada.getY()].setpieza(tablero[ultimaposicion.getX()][ultimaposicion.getY()].getpieza());
                                tablero[ultimaposicion.getX()][ultimaposicion.getY()].setpieza(null);

                                resetcolorposicionperm(listacoordenadas);
                                ftablero[ultimaposicion.getX()][ultimaposicion.getY()].setBackgroundResource(0);
                                resetColorAtultimaposicionition(ultimaposicion);

                                algoseleccionado = false;
                                Primerturno = !Primerturno;
                                revisorpeon();
                            }else{
                                resetColorAtultimaposicionition(ultimaposicion);
                                resetcolorposicionperm(listacoordenadas);
                                algoseleccionado = false;
                            }

                        }else{
                            if(tablero[posicionclickada.getX()][posicionclickada.getY()].getpieza().esblanca() != Primerturno){
                                reypeligro();
                                return;
                            }

                            resetColorAtultimaposicionition(ultimaposicion);
                            resetcolorposicionperm(listacoordenadas);

                            listacoordenadas.clear();
                            listacoordenadas = tablero[posicionclickada.getX()][posicionclickada.getY()].getpieza().movperm(posicionclickada, tablero);
                            fondodetablero[posicionclickada.getX()][posicionclickada.getY()].setBackgroundResource(R.color.colormov);
                            setColorposicionperm(listacoordenadas);
                            algoseleccionado = true;
                        }
                    }
                }
            }
        }

        reypeligro();
        ultimaposicion = new Coordenadas(posicionclickada.getX(), posicionclickada.getY());
        settablero();
    }

    public void registrotablero(){
        numeromovimientos++;
        ultimovimiento.add(numeromovimientos-1 ,tablero2 );

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ultimovimiento.get(numeromovimientos-1)[i][j] = new posicion(null);
            }
        }

        for(int g=0;g<8;g++){
            for(int h=0;h<8;h++){
                if(tablero[g][h].getpieza()==null){
                    ultimovimiento.get(numeromovimientos-1)[g][h].setpieza(null);
                }else{
                    ultimovimiento.get(numeromovimientos-1)[g][h].setpieza(tablero[g][h].getpieza());
                }
            }
        }
    }

    //Opcion para volver atras
    public void atras(View v){
        if(numeromovimientos>0) {

            for(int g=0;g<8;g++){
                for(int h=0;h<8;h++){
                    if(ultimovimiento.get(numeromovimientos-1)[g][h].getpieza()==null){
                        tablero[g][h].setpieza(null);
                    }else{
                        tablero[g][h].setpieza(ultimovimiento.get(numeromovimientos-1)[g][h].getpieza());
                    }
                }
            }
            numeromovimientos--;

            settablero();
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if((i+j)%2==0){
                        fondodetablero[i][j].setBackgroundResource(R.color.colortablerooscuro);
                    }else{
                        fondodetablero[i][j].setBackgroundResource(R.color.colortableroclaro);
                    }
                }
            }
            reypeligro();
            Primerturno = !Primerturno;
            juego_terminado.setVisibility(View.INVISIBLE);
        }
    }
    //END
    public void selectpeon(View v){
        int x = v.getId();
        switch (x){
            case R.id.peon_reina :
                if(posicionclickada.getY() == 0){
                    tablero[posicionclickada.getX()][posicionclickada.getY()].setpieza(new reina(true));
                    ftablero[posicionclickada.getX()][posicionclickada.getY()].setBackgroundResource(R.drawable.wreina);
                }else{
                    tablero[posicionclickada.getX()][posicionclickada.getY()].setpieza(new reina(false));
                    ftablero[posicionclickada.getX()][posicionclickada.getY()].setBackgroundResource(R.drawable.breina);
                }
                break;
            case R.id.peon_torre :
                if(posicionclickada.getY() == 0){
                    tablero[posicionclickada.getX()][posicionclickada.getY()].setpieza(new torre(true));
                    ftablero[posicionclickada.getX()][posicionclickada.getY()].setBackgroundResource(R.drawable.wtorre);
                }else{
                    tablero[posicionclickada.getX()][posicionclickada.getY()].setpieza(new torre(false));
                    ftablero[posicionclickada.getX()][posicionclickada.getY()].setBackgroundResource(R.drawable.btorre);
                }
                break;
            case R.id.peon_alfil :
                if(posicionclickada.getY() == 0){
                    tablero[posicionclickada.getX()][posicionclickada.getY()].setpieza(new alfil(true));
                    ftablero[posicionclickada.getX()][posicionclickada.getY()].setBackgroundResource(R.drawable.walfil);
                }else{
                    tablero[posicionclickada.getX()][posicionclickada.getY()].setpieza(new alfil(false));
                    ftablero[posicionclickada.getX()][posicionclickada.getY()].setBackgroundResource(R.drawable.balfil);
                }
                break;
            case R.id.peon_caballo :
                if(posicionclickada.getY() == 0){
                    tablero[posicionclickada.getX()][posicionclickada.getY()].setpieza(new caballo(true));
                    ftablero[posicionclickada.getX()][posicionclickada.getY()].setBackgroundResource(R.drawable.wcaballo);
                }else{
                    tablero[posicionclickada.getX()][posicionclickada.getY()].setpieza(new caballo(false));
                    ftablero[posicionclickada.getX()][posicionclickada.getY()].setBackgroundResource(R.drawable.balfil);

                }
                break;
        }
        opciones_peon.setVisibility(View.INVISIBLE);
    }

    private void resetcolorposicionperm(ArrayList<Coordenadas> listacoordenadas) {
        for(int i=0; i<listacoordenadas.size(); i++){
            if((listacoordenadas.get(i).getX() + listacoordenadas.get(i).getY())%2==0){
                fondodetablero[listacoordenadas.get(i).getX()][listacoordenadas.get(i).getY()].setBackgroundResource(R.color.colortablerooscuro);
            }else {
                fondodetablero[listacoordenadas.get(i).getX()][listacoordenadas.get(i).getY()].setBackgroundResource(R.color.colortableroclaro);
            }
        }
    }

    void setColorposicionperm(ArrayList<Coordenadas> list){

        for(int i=0; i<list.size(); i++){
            if(tablero[list.get(i).getX()][list.get(i).getY()].getpieza() == null){
                fondodetablero[list.get(i).getX()][list.get(i).getY()].setBackgroundResource(R.color.colorposdispo);
            }else{
                fondodetablero[list.get(i).getX()][list.get(i).getY()].setBackgroundResource(R.color.colorpeligro);
            }
        }
    }

    private boolean moverselec(ArrayList<Coordenadas> piece, Coordenadas coordinate) {
        Boolean permitido = false;
        for(int i =0;i<piece.size();i++){
            if(piece.get(i).getX() == coordinate.getX()  &&  piece.get(i).getY() == coordinate.getY()){
                permitido = true;
                break;
            }
        }
        return permitido;
    }

    private void resetColorAtultimaposicionition(Coordenadas ultimaposicion){
        if((ultimaposicion.getX() + ultimaposicion.getY())%2==0){
            fondodetablero[ultimaposicion.getX()][ultimaposicion.getY()].setBackgroundResource(R.color.colortablerooscuro);
        }else {
            fondodetablero[ultimaposicion.getX()][ultimaposicion.getY()].setBackgroundResource(R.color.colortableroclaro);
        }
    }

    private void reypeligro(){
        ArrayList<Coordenadas> List = new ArrayList<>();

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(tablero[i][j].getpieza() != null){
                    List.clear();
                    Coordenadas c = new Coordenadas(i,j);
                    List = tablero[i][j].getpieza().movperm(c,tablero);

                    for (int x=0;x<List.size();x++){
                        if(tablero[List.get(x).getX()][List.get(x).getY()].getpieza() instanceof rey){

                            if((List.get(x).getX()+List.get(x).getY())%2==0){
                                fondodetablero[List.get(x).getX()][List.get(x).getY()].setBackgroundResource(R.color.colortablerooscuro);
                            }else{
                                fondodetablero[List.get(x).getX()][List.get(x).getY()].setBackgroundResource(R.color.colortableroclaro);
                            }

                            if(tablero[i][j].getpieza().esblanca() != tablero[List.get(x).getX()][List.get(x).getY()].getpieza().esblanca()){
                                fondodetablero[List.get(x).getX()][List.get(x).getY()].setBackgroundResource(R.color.colorreyenpeligro);
                            }
                        }
                    }
                }
            }
        }
    }

    private void revisorpeon(){
        if(tablero[posicionclickada.getX()][posicionclickada.getY()].getpieza() instanceof peon){
            if(tablero[posicionclickada.getX()][posicionclickada.getY()].getpieza().esblanca()){
                if(posicionclickada.getY() == 0){
                    opciones_peon.setVisibility(View.VISIBLE);
                }
            }else{
                if(posicionclickada.getY() == 7){
                    opciones_peon.setVisibility(View.VISIBLE);
                    opciones_peon.setRotation(180);
                }
            }
        }
        reypeligro();
    }
}
