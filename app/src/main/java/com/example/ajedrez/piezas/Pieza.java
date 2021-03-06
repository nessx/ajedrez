package com.example.ajedrez.piezas;
/**
 * <h1>Movimientos de Pieza</h1>
 * Aqui definimos el molde de las piezas que crearemos despues
 * <p>
 * <b>Nota:</b> el tablero es de 8x8 asi que todas tienen que poder
 * moverse por este campo
 *
 * @author  Jeremy, Nestor, Hector
 * @version 1.0
 * @since   24-05-2020
 */

import com.example.ajedrez.Coordenadas;
import com.example.ajedrez.posicion;

import java.util.ArrayList;

public class Pieza {

    private boolean blanca;
    //si este boobleano es falso todas son negras

    Pieza(boolean blanca) {
        this.blanca = blanca;
    }

    public ArrayList<Coordenadas> movperm(Coordenadas coordenadas , posicion[][] tablero){
        ArrayList<Coordenadas> movperm = new ArrayList<>();
        Coordenadas c;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                c = new Coordenadas(i,j);
                movperm.add(c);
            }
        }
        return movperm;
    }

    public boolean esblanca() {
        return blanca;
    }
}
