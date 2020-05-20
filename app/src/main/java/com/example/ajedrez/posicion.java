package com.example.ajedrez;

import com.example.ajedrez.piezas.Pieza;

public class posicion {
    private Pieza pieza;


    posicion(Pieza pieza ) {
        this.pieza = pieza;
    }

    public Pieza getpieza() {
        return pieza;

    }

    void setpieza(Pieza pieza) {
        this.pieza = pieza;
    }
}
