package com.example.ajedrez.piezas;
/**
 * <h1>Movimientos de Reina</h1>
 * Aqui definimos los movimientos posibles que puede hacer la Reina
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

public class reina extends Pieza {
    public reina(boolean blanca) {
        super(blanca);
    }

    @Override
    public ArrayList<Coordenadas> movperm(Coordenadas coordenadas , posicion[][] tablero){
        ArrayList<Coordenadas> movperm = new ArrayList<>();
        Coordenadas c;
        movperm.clear();

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

        for(int i=1 ; i<8 ; i++){
            if((coordenadas.getX()+i)<8 && (coordenadas.getY()+i)<8){
                if(tablero[coordenadas.getX()+i][coordenadas.getY()+i].getpieza() == null){
                    c = new Coordenadas(coordenadas.getX()+i , coordenadas.getY()+i);
                    movperm.add(c);
                }else{
                    if(tablero[coordenadas.getX()+i][coordenadas.getY()+i].getpieza().esblanca() != tablero[coordenadas.getX()][coordenadas.getY()].getpieza().esblanca()){
                        c = new Coordenadas(coordenadas.getX()+i , coordenadas.getY()+i);
                        movperm.add(c);
                    }
                    break;
                }
            }
        }

        for(int i=1 ; i<8 ; i++){
            if((coordenadas.getX()-i)>=0 && (coordenadas.getY()+i)<8){
                if(tablero[coordenadas.getX()-i][coordenadas.getY()+i].getpieza() == null){
                    c = new Coordenadas(coordenadas.getX()-i , coordenadas.getY()+i);
                    movperm.add(c);
                }else{
                    if(tablero[coordenadas.getX()-i][coordenadas.getY()+i].getpieza().esblanca() != tablero[coordenadas.getX()][coordenadas.getY()].getpieza().esblanca()){
                        c = new Coordenadas(coordenadas.getX()-i , coordenadas.getY()+i);
                        movperm.add(c);
                    }
                    break;
                }

            }
        }

        for(int i=1 ; i<8 ; i++){
            if((coordenadas.getX()-i)>=0 && (coordenadas.getY()-i)>=0){
                if(tablero[coordenadas.getX()-i][coordenadas.getY()-i].getpieza() == null){
                    c = new Coordenadas(coordenadas.getX()-i , coordenadas.getY()-i);
                    movperm.add(c);
                }else{
                    if(tablero[coordenadas.getX()-i][coordenadas.getY()-i].getpieza().esblanca() != tablero[coordenadas.getX()][coordenadas.getY()].getpieza().esblanca()){
                        c = new Coordenadas(coordenadas.getX()-i , coordenadas.getY()-i);
                        movperm.add(c);
                    }
                    break;
                }

            }
        }

        for(int i=1 ; i<8 ; i++){
            if((coordenadas.getX()+i)<8 && (coordenadas.getY()-i)>=0){
                if(tablero[coordenadas.getX()+i][coordenadas.getY()-i].getpieza() == null){
                    c = new Coordenadas(coordenadas.getX()+i , coordenadas.getY()-i);
                    movperm.add(c);
                }else{
                    if(tablero[coordenadas.getX()+i][coordenadas.getY()-i].getpieza().esblanca() != tablero[coordenadas.getX()][coordenadas.getY()].getpieza().esblanca()){
                        c = new Coordenadas(coordenadas.getX()+i , coordenadas.getY()-i);
                        movperm.add(c);
                    }
                    break;
                }

            }
        }
        return movperm;
    }
}
