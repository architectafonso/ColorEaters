package com.empire_of_science.joao.coloreaters2;

/**
 * Created by João on 11/01/2017.
 * Copyright João Afonso.
 */

class BoardPiece_EatenCake extends BoardPieceWithColor {
    @Override
    boolean isSelectable(Board board) {
        return false;
    }

    @Override
    boolean canDoMovement(Board board, int goToX, int goToY) {
        return false;
    }


    /**
     * The eater that has eaten this cake.
     */
    BoardPiece eater;

    BoardPiece_EatenCake(BoardPiece_Cake original, BoardPiece eater){
        super(original.boardX, original.boardY, original.color);
        graphicsX = original.graphicsX;
        graphicsY = original.graphicsY;
        this.eater = eater;
    }

    int deltaX;
    int deltaY;
}
