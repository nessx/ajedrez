package com.example.ajedrez.piezas;

import com.example.ajedrez.coordenadas;
import com.example.ajedrez.posicion;

import java.util.ArrayList;

public class peon extends pieza {
    public peon(boolean blanca) {
        super(blanca);
    }

    @Override
    public ArrayList<coordenadas> movperm (coordenadas coordenadas , posicion[][] tablero){

        ArrayList<coordenadas> movperm = new ArrayList<>();
        movperm.clear();
        coordenadas c;

        if(tablero[coordenadas.getX()][coordenadas.getY()].getpieza().esblanca()){

            if(coordenadas.getX()<8 && coordenadas.getX()>=0 && (coordenadas.getY()-1)<8 && (coordenadas.getY()-1)>=0){
                if(tablero[coordenadas.getX()][coordenadas.getY()-1].getpieza()==null){
                    c=new coordenadas(coordenadas.getX() , coordenadas.getY() - 1);
                    movperm.add(c);

                    if((coordenadas.getY() == 6) && (tablero[coordenadas.getX()][coordenadas.getY() - 2].getpieza() == null)){
                        c = new coordenadas(coordenadas.getX(), coordenadas.getY() - 2);
                        movperm.add(c);
                    }
                }
            }

            if((coordenadas.getX()+1)<8 && (coordenadas.getX()+1)>=0 && (coordenadas.getY()-1)<8 && (coordenadas.getY()-1)>=0) {
                if (tablero[coordenadas.getX() + 1][coordenadas.getY() - 1].getpieza() != null) {
                    if(tablero[coordenadas.getX() + 1][coordenadas.getY() - 1].getpieza().esblanca() != tablero[coordenadas.getX()][coordenadas.getY()].getpieza().esblanca()){
                        c = new coordenadas(coordenadas.getX() + 1, coordenadas.getY() - 1);
                        movperm.add(c);
                    }
                }

            }

            if((coordenadas.getX()-1)<8 && (coordenadas.getX()-1)>=0 && (coordenadas.getY()-1)<8 && (coordenadas.getY()-1)>=0) {
                if (tablero[coordenadas.getX() - 1][coordenadas.getY() - 1].getpieza() != null) {
                    if(tablero[coordenadas.getX() - 1][coordenadas.getY() - 1].getpieza().esblanca() != tablero[coordenadas.getX()][coordenadas.getY()].getpieza().esblanca()){
                        c = new coordenadas(coordenadas.getX() - 1, coordenadas.getY() - 1);
                        movperm.add(c);
                    }
                }
            }

        }else{

            if((coordenadas.getX())<8 && (coordenadas.getX())>=0 && (coordenadas.getY()+1)<8 && (coordenadas.getY()+1)>=0) {
                if (tablero[coordenadas.getX()][coordenadas.getY() + 1].getpieza() == null) {
                    c = new coordenadas(coordenadas.getX(), coordenadas.getY() + 1);
                    movperm.add(c);

                    if(coordenadas.getY() == 1 && (tablero[coordenadas.getX()][coordenadas.getY() + 2].getpieza() == null)){
                        c = new coordenadas(coordenadas.getX(), coordenadas.getY() + 2);
                        movperm.add(c);
                    }
                }
            }

            if((coordenadas.getX()+1)<8 && (coordenadas.getX()+1)>=0 && (coordenadas.getY()+1)<8 && (coordenadas.getY()+1)>=0) {
                if (tablero[coordenadas.getX() + 1][coordenadas.getY() + 1].getpieza() != null) {
                    if(tablero[coordenadas.getX() + 1][coordenadas.getY() + 1].getpieza().esblanca() != tablero[coordenadas.getX()][coordenadas.getY()].getpieza().esblanca()){
                        c = new coordenadas(coordenadas.getX() + 1, coordenadas.getY() + 1);
                        movperm.add(c);
                    }
                }
            }

            if((coordenadas.getX()-1)<8 && (coordenadas.getX()-1)>=0 && (coordenadas.getY()+1)<8 && (coordenadas.getY()+1)>=0) {
                if (tablero[coordenadas.getX() - 1][coordenadas.getY() + 1].getpieza() != null) {
                    if(tablero[coordenadas.getX() - 1][coordenadas.getY() + 1].getpieza().esblanca() != tablero[coordenadas.getX()][coordenadas.getY()].getpieza().esblanca()){
                        c = new coordenadas(coordenadas.getX() - 1, coordenadas.getY() + 1);
                        movperm.add(c);
                    }
                }
            }

        }
        return movperm;
    }
}
