package com.example.ajedrez.piezas;

import com.example.ajedrez.Coordenadas;
import com.example.ajedrez.posicion;

import java.util.ArrayList;

public class rey extends Pieza {
    public rey(boolean blanca) {
        super( blanca);
    }

    @Override
    public ArrayList<Coordenadas> movperm(Coordenadas coordenadas , posicion[][] tablero){
        ArrayList<Coordenadas> movperm = new ArrayList<>();
        movperm.clear();
        Coordenadas c;

        if((coordenadas.getX()+1) <8 && (coordenadas.getY()+1)<8){
            if(tablero[coordenadas.getX()+1][coordenadas.getY()+1].getpieza() == null){
                c = new Coordenadas(coordenadas.getX()+1 , coordenadas.getY()+1);
                movperm.add(c);
            }else{
                if(tablero[coordenadas.getX()+1][coordenadas.getY()+1].getpieza().esblanca() != tablero[coordenadas.getX()][coordenadas.getY()].getpieza().esblanca()){
                    c = new Coordenadas(coordenadas.getX()+1 , coordenadas.getY()+1);
                    movperm.add(c);
                }
            }
        }

        if((coordenadas.getY()+1)<8){
            if(tablero[coordenadas.getX()][coordenadas.getY()+1].getpieza() == null){
                c = new Coordenadas(coordenadas.getX() , coordenadas.getY()+1);
                movperm.add(c);
            }else{
                if(tablero[coordenadas.getX()][coordenadas.getY()+1].getpieza().esblanca() != tablero[coordenadas.getX()][coordenadas.getY()].getpieza().esblanca()){
                    c = new Coordenadas(coordenadas.getX() , coordenadas.getY()+1);
                    movperm.add(c);
                }
            }
        }

        if((coordenadas.getX()-1) >=0 && (coordenadas.getY()+1)<8){
            if(tablero[coordenadas.getX()-1][coordenadas.getY()+1].getpieza() == null){
                c = new Coordenadas(coordenadas.getX()-1 , coordenadas.getY()+1);
                movperm.add(c);
            }else{
                if(tablero[coordenadas.getX()-1][coordenadas.getY()+1].getpieza().esblanca() != tablero[coordenadas.getX()][coordenadas.getY()].getpieza().esblanca()){
                    c = new Coordenadas(coordenadas.getX()-1 , coordenadas.getY()+1);
                    movperm.add(c);
                }
            }
        }

        if((coordenadas.getX()+1) <8 ){
            if(tablero[coordenadas.getX()+1][coordenadas.getY()].getpieza() == null){
                c = new Coordenadas(coordenadas.getX()+1 , coordenadas.getY());
                movperm.add(c);
            }else{
                if(tablero[coordenadas.getX()+1][coordenadas.getY()].getpieza().esblanca() != tablero[coordenadas.getX()][coordenadas.getY()].getpieza().esblanca()){
                    c = new Coordenadas(coordenadas.getX()+1 , coordenadas.getY());
                    movperm.add(c);
                }
            }
        }

        if((coordenadas.getX()-1) <8 ){
            if(tablero[coordenadas.getX()-1][coordenadas.getY()].getpieza() == null){
                c = new Coordenadas(coordenadas.getX()-1 , coordenadas.getY());
                movperm.add(c);
            }else{
                if(tablero[coordenadas.getX()-1][coordenadas.getY()].getpieza().esblanca() != tablero[coordenadas.getX()][coordenadas.getY()].getpieza().esblanca()){
                    c = new Coordenadas(coordenadas.getX()-1 , coordenadas.getY());
                    movperm.add(c);
                }
            }
        }

        if((coordenadas.getX()+1) <8 && (coordenadas.getY()-1)>=0){
            if(tablero[coordenadas.getX()+1][coordenadas.getY()-1].getpieza() == null){
                c = new Coordenadas(coordenadas.getX()+1 , coordenadas.getY()-1);
                movperm.add(c);
            }else{
                if(tablero[coordenadas.getX()+1][coordenadas.getY()-1].getpieza().esblanca() != tablero[coordenadas.getX()][coordenadas.getY()].getpieza().esblanca()){
                    c = new Coordenadas(coordenadas.getX()+1 , coordenadas.getY()-1);
                    movperm.add(c);
                }
            }
        }

        if((coordenadas.getY()-1)>=0){
            if(tablero[coordenadas.getX()][coordenadas.getY()-1].getpieza() == null){
                c = new Coordenadas(coordenadas.getX() , coordenadas.getY()-1);
                movperm.add(c);
            }else{
                if(tablero[coordenadas.getX()][coordenadas.getY()-1].getpieza().esblanca() != tablero[coordenadas.getX()][coordenadas.getY()].getpieza().esblanca()){
                    c = new Coordenadas(coordenadas.getX() , coordenadas.getY()-1);
                    movperm.add(c);
                }
            }
        }

        if((coordenadas.getX()-1) <8 && (coordenadas.getY()-1)>=0){
            if(tablero[coordenadas.getX()-1][coordenadas.getY()-1].getpieza() == null){
                c = new Coordenadas(coordenadas.getX()-1 , coordenadas.getY()-1);
                movperm.add(c);
            }else{
                if(tablero[coordenadas.getX()-1][coordenadas.getY()-1].getpieza().esblanca() != tablero[coordenadas.getX()][coordenadas.getY()].getpieza().esblanca()){
                    c = new Coordenadas(coordenadas.getX()-1 , coordenadas.getY()-1);
                    movperm.add(c);
                }
            }
        }
        
        return movperm;
    }
}
