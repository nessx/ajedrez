package com.example.ajedrez.piezas;

import com.example.ajedrez.coordenadas;
import com.example.ajedrez.posicion;

import java.util.ArrayList;

public class torre extends pieza {
    public torre(boolean blanca) {
        super(blanca);
    }

    @Override
    public ArrayList<coordenadas> movperm(coordenadas coordenadas , posicion[][] tablero){

        ArrayList<coordenadas> movperm = new ArrayList<>();
        movperm.clear();
        coordenadas c ;

        for(int i=(coordenadas.getX()+1) ; i<8 ;i++){
            if(tablero[i][coordenadas.getY()].getpieza() == null){
                c = new coordenadas(i , coordenadas.getY());
                movperm.add(c);
            }else{
                if(tablero[i][coordenadas.getY()].getpieza().esblanca() != tablero[coordenadas.getX()][coordenadas.getY()].getpieza().esblanca()){
                    c = new coordenadas(i , coordenadas.getY());
                    movperm.add(c);
                }
                break;
            }
        }

        for(int i=(coordenadas.getX()-1) ; i>=0 ; i--){
            if(tablero[i][coordenadas.getY()].getpieza() == null){
                c = new coordenadas(i , coordenadas.getY());
                movperm.add(c);
            }else{
                if(tablero[i][coordenadas.getY()].getpieza().esblanca() != tablero[coordenadas.getX()][coordenadas.getY()].getpieza().esblanca()){
                    c = new coordenadas(i , coordenadas.getY());
                    movperm.add(c);
                }
                break;
            }
        }

        for(int i=(coordenadas.getY()-1) ; i>=0 ; i--){
            if(tablero[coordenadas.getX()][i].getpieza() == null){
                c = new coordenadas( coordenadas.getX() , i);
                movperm.add(c);
            }else{
                if(tablero[coordenadas.getX()][i].getpieza().esblanca() != tablero[coordenadas.getX()][coordenadas.getY()].getpieza().esblanca()){
                    c = new coordenadas( coordenadas.getX() , i);
                    movperm.add(c);
                }
                break;
            }
        }

        for(int i=(coordenadas.getY()+1) ; i<8 ;i++){
            if(tablero[coordenadas.getX()][i].getpieza() == null){
                c = new coordenadas(coordenadas.getX() , i);
                movperm.add(c);
            }else{
                if(tablero[coordenadas.getX()][i].getpieza().esblanca() != tablero[coordenadas.getX()][coordenadas.getY()].getpieza().esblanca()){
                    c = new coordenadas(coordenadas.getX() , i);
                    movperm.add(c);
                }
                break;
            }
        }
        return movperm;
    }
}
