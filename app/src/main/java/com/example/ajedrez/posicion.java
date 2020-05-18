package com.example.ajedrez;

import com.example.ajedrez.piezas.pieza;

public class posicion {
    private pieza pieza;


    posicion(pieza pieza ) {
        this.pieza = pieza;
    }

    public pieza getpieza() {
        return pieza;

    }

    void setpieza(pieza pieza) {
        this.pieza = pieza;
    }
}
