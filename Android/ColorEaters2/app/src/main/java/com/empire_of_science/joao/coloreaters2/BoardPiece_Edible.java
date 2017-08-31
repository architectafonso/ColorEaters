package com.empire_of_science.joao.coloreaters2;

/**
 * Created by João on 24/08/2017.
 * Copyright João Afonso.
 */

abstract class BoardPiece_Edible extends BoardPieceWithColor{
    BoardPiece_Edible(int x, int y, Colors color){
        super(x,y,color);
    }


    /**
     *
     * @param board
     * @param eater
     * @return
     */
    public abstract boolean getEaten(Board board, BoardPiece_Eater eater);
}
