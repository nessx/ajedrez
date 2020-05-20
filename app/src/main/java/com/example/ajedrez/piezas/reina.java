package com.example.ajedrez.piezas;

import com.example.ajedrez.coordenadas;
import com.example.ajedrez.posicion;

import java.util.ArrayList;

public class reina extends pieza{
    public reina(boolean blanca) {
        super(blanca);
    }

    @Override
    public ArrayList<coordenadas> movperm(coordenadas coordenadas , posicion[][] tablero){
        ArrayList<coordenadas> movperm = new ArrayList<>();
        coordenadas c;
        movperm.clear();

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

        for(int i=1 ; i<8 ; i++){
            if((coordenadas.getX()+i)<8 && (coordenadas.getY()+i)<8){
                if(tablero[coordenadas.getX()+i][coordenadas.getY()+i].getpieza() == null){
                    c = new coordenadas(coordenadas.getX()+i , coordenadas.getY()+i);
                    movperm.add(c);
                }else{
                    if(tablero[coordenadas.getX()+i][coordenadas.getY()+i].getpieza().esblanca() != tablero[coordenadas.getX()][coordenadas.getY()].getpieza().esblanca()){
                        c = new coordenadas(coordenadas.getX()+i , coordenadas.getY()+i);
                        movperm.add(c);
                    }
                    break;
                }
            }
        }

        for(int i=1 ; i<8 ; i++){
            if((coordenadas.getX()-i)>=0 && (coordenadas.getY()+i)<8){
                if(tablero[coordenadas.getX()-i][coordenadas.getY()+i].getpieza() == null){
                    c = new coordenadas(coordenadas.getX()-i , coordenadas.getY()+i);
                    movperm.add(c);
                }else{
                    if(tablero[coordenadas.getX()-i][coordenadas.getY()+i].getpieza().esblanca() != tablero[coordenadas.getX()][coordenadas.getY()].getpieza().esblanca()){
                        c = new coordenadas(coordenadas.getX()-i , coordenadas.getY()+i);
                        movperm.add(c);
                    }
                    break;
                }

            }
        }

        for(int i=1 ; i<8 ; i++){
            if((coordenadas.getX()-i)>=0 && (coordenadas.getY()-i)>=0){
                if(tablero[coordenadas.getX()-i][coordenadas.getY()-i].getpieza() == null){
                    c = new coordenadas(coordenadas.getX()-i , coordenadas.getY()-i);
                    movperm.add(c);
                }else{
                    if(tablero[coordenadas.getX()-i][coordenadas.getY()-i].getpieza().esblanca() != tablero[coordenadas.getX()][coordenadas.getY()].getpieza().esblanca()){
                        c = new coordenadas(coordenadas.getX()-i , coordenadas.getY()-i);
                        movperm.add(c);
                    }
                    break;
                }

            }
        }

        for(int i=1 ; i<8 ; i++){
            if((coordenadas.getX()+i)<8 && (coordenadas.getY()-i)>=0){
                if(tablero[coordenadas.getX()+i][coordenadas.getY()-i].getpieza() == null){
                    c = new coordenadas(coordenadas.getX()+i , coordenadas.getY()-i);
                    movperm.add(c);
                }else{
                    if(tablero[coordenadas.getX()+i][coordenadas.getY()-i].getpieza().esblanca() != tablero[coordenadas.getX()][coordenadas.getY()].getpieza().esblanca()){
                        c = new coordenadas(coordenadas.getX()+i , coordenadas.getY()-i);
                        movperm.add(c);
                    }
                    break;
                }

            }
        }
        return movperm;
    }
}
