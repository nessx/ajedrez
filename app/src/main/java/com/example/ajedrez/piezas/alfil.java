package com.example.ajedrez.piezas;
/**
 * <h1>Movimientos de Alfil</h1>
 * Aqui definimos los movimientos posibles que puede hacer el Alfil
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

public class alfil extends Pieza {
    public alfil(boolean blanca) {
        super(blanca);
    }

    @Override
    public ArrayList<Coordenadas> movperm(Coordenadas coordenadas , posicion[][] board){
        ArrayList<Coordenadas> movperm = new ArrayList<>();
        Coordenadas c;

        for(int i=1 ; i<8 ; i++){
            if((coordenadas.getX()+i)<8 && (coordenadas.getY()+i)<8){
                if(board[coordenadas.getX()+i][coordenadas.getY()+i].getpieza() == null){
                    c = new Coordenadas(coordenadas.getX()+i , coordenadas.getY()+i);
                    movperm.add(c);
                }else{
                    if(board[coordenadas.getX()+i][coordenadas.getY()+i].getpieza().esblanca() != board[coordenadas.getX()][coordenadas.getY()].getpieza().esblanca()){
                        c = new Coordenadas(coordenadas.getX()+i , coordenadas.getY()+i);
                        movperm.add(c);
                    }
                    break;
                }
            }
        }

        for(int i=1 ; i<8 ; i++){
            if((coordenadas.getX()-i)>=0 && (coordenadas.getY()+i)<8){
                if(board[coordenadas.getX()-i][coordenadas.getY()+i].getpieza() == null){
                    c = new Coordenadas(coordenadas.getX()-i , coordenadas.getY()+i);
                    movperm.add(c);
                }else{
                    if(board[coordenadas.getX()-i][coordenadas.getY()+i].getpieza().esblanca() != board[coordenadas.getX()][coordenadas.getY()].getpieza().esblanca()){
                        c = new Coordenadas(coordenadas.getX()-i , coordenadas.getY()+i);
                        movperm.add(c);
                    }
                    break;
                }

            }
        }

        for(int i=1 ; i<8 ; i++){
            if((coordenadas.getX()-i)>=0 && (coordenadas.getY()-i)>=0){
                if(board[coordenadas.getX()-i][coordenadas.getY()-i].getpieza() == null){
                    c = new Coordenadas(coordenadas.getX()-i , coordenadas.getY()-i);
                    movperm.add(c);
                }else{
                    if(board[coordenadas.getX()-i][coordenadas.getY()-i].getpieza().esblanca() != board[coordenadas.getX()][coordenadas.getY()].getpieza().esblanca()){
                        c = new Coordenadas(coordenadas.getX()-i , coordenadas.getY()-i);
                        movperm.add(c);
                    }
                    break;
                }

            }
        }

        for(int i=1 ; i<8 ; i++){
            if((coordenadas.getX()+i)<8 && (coordenadas.getY()-i)>=0){
                if(board[coordenadas.getX()+i][coordenadas.getY()-i].getpieza() == null){
                    c = new Coordenadas(coordenadas.getX()+i , coordenadas.getY()-i);
                    movperm.add(c);
                }else{
                    if(board[coordenadas.getX()+i][coordenadas.getY()-i].getpieza().esblanca() != board[coordenadas.getX()][coordenadas.getY()].getpieza().esblanca()){
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
