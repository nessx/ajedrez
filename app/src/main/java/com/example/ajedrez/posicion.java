package com.example.ajedrez;
/**
 * <h1>Posicion</h1>
 * Aqui creamos un metodo getter y setter para
 * saber donde estan las piezas (en general)
 *
 * @author  Jeremy, Nestor, Hector
 * @version 1.0
 * @since   24-05-2020
 */
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
