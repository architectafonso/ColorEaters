package com.empire_of_science.joao.coloreaters2;

/**
 * Created by João on 11/01/2017.
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


    BoardPiece_Eater eater;

    BoardPiece_EatenCake(BoardPiece_Cake original, BoardPiece_Eater eater){
        super(original.boardX, original.boardY, original.color);
        graphicsX = original.graphicsX;
        graphicsY = original.graphicsY;
        this.eater = eater;
    }
}
