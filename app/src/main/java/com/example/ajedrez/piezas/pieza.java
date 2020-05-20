package com.example.ajedrez.piezas;

import com.example.ajedrez.coordenadas;
import com.example.ajedrez.posicion;

import java.util.ArrayList;

public class pieza {

    private boolean blanca;

    pieza(boolean blanca) {
        this.blanca = blanca;
    }

    public ArrayList<coordenadas> movperm(coordenadas coordenadas , posicion[][] tablero){
        ArrayList<coordenadas> movperm = new ArrayList<>();
        coordenadas c;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                c = new coordenadas(i,j);
                movperm.add(c);
            }
        }
        return movperm;
    }

    public boolean esblanca() {
        return blanca;
    }
}
