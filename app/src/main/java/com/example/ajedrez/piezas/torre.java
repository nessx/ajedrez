package com.example.ajedrez.piezas;
/**
 * <h1>Movimientos de Torre</h1>
 * Aqui definimos los movimientos posibles que puede hacer la Torre
 * <p>
 * <b>Nota:</b> usamos como referencia el objeto pieza
 *
 * @author  Jeremy, Nestor, Hector
 * @version 1.0
 * @since   24-05-2020
 */

import com.example.ajedrez.Coordenadas;
import com.example.ajedrez.posicion;

import java.util.ArrayList;

public class torre extends Pieza {
    public torre(boolean blanca) {
        super(blanca);
    }

    @Override
    public ArrayList<Coordenadas> movperm(Coordenadas coordenadas , posicion[][] tablero){

        ArrayList<Coordenadas> movperm = new ArrayList<>();
        movperm.clear();
        Coordenadas c ;

        for(int i=(coordenadas.getX()+1) ; i<8 ;i++){
            if(tablero[i][coordenadas.getY()].getpieza() == null){
                c = new Coordenadas(i , coordenadas.getY());
                movperm.add(c);
            }else{
                if(tablero[i][coordenadas.getY()].getpieza().esblanca() != tablero[coordenadas.getX()][coordenadas.getY()].getpieza().esblanca()){
                    c = new Coordenadas(i , coordenadas.getY());
                    movperm.add(c);
                }
                break;
            }
        }

        for(int i=(coordenadas.getX()-1) ; i>=0 ; i--){
            if(tablero[i][coordenadas.getY()].getpieza() == null){
                c = new Coordenadas(i , coordenadas.getY());
                movperm.add(c);
            }else{
                if(tablero[i][coordenadas.getY()].getpieza().esblanca() != tablero[coordenadas.getX()][coordenadas.getY()].getpieza().esblanca()){
                    c = new Coordenadas(i , coordenadas.getY());
                    movperm.add(c);
                }
                break;
            }
        }

        for(int i=(coordenadas.getY()-1) ; i>=0 ; i--){
            if(tablero[coordenadas.getX()][i].getpieza() == null){
                c = new Coordenadas( coordenadas.getX() , i);
                movperm.add(c);
            }else{
                if(tablero[coordenadas.getX()][i].getpieza().esblanca() != tablero[coordenadas.getX()][coordenadas.getY()].getpieza().esblanca()){
                    c = new Coordenadas( coordenadas.getX() , i);
                    movperm.add(c);
                }
                break;
            }
        }

        for(int i=(coordenadas.getY()+1) ; i<8 ;i++){
            if(tablero[coordenadas.getX()][i].getpieza() == null){
                c = new Coordenadas(coordenadas.getX() , i);
                movperm.add(c);
            }else{
                if(tablero[coordenadas.getX()][i].getpieza().esblanca() != tablero[coordenadas.getX()][coordenadas.getY()].getpieza().esblanca()){
                    c = new Coordenadas(coordenadas.getX() , i);
                    movperm.add(c);
                }
                break;
            }
        }
        return movperm;
    }
}
