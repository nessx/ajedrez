package com.example.ajedrez;
/**
 * <h1>Coordenadas</h1>
 * Aqui definimos el tamaño del tablero con sus ejes X e Y
 * <p>
 *
 * @author  Jeremy, Nestor, Hector
 * @version 1.0
 * @since   24-05-2020
 */
public class Coordenadas {
    private int x;
    private int y;

    public Coordenadas(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void setX(int x)
    {
        this.x = x;
    }

    public int getX() {

        return x;
    }

    public int getY() {

        return y;
    }

    void setY(int y) {
        this.y = y;
    }
}

