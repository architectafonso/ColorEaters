package com.empire_of_science.joao.coloreaters2;

/**
 * Created by João on 30/09/2016.
 * Copyright João Afonso.
 * Represents the 'X' pieces that do not move during the game.
 */
class BoardPiece_Block extends BoardPiece {


    /**
     * Calls super.
     * @param x Board x coordinate.
     * @param y Board y coordinate.
     */
    BoardPiece_Block(int x, int y){
        super (x, y);
    }

    /**
     * The block piece can never move.
     * @param board The Board the piece belongs to.
     * @param goToX X coordinate of the cell this piece is supposed to move.
     * @param goToY Y coordinate of the cell this piece is supposed to move.
     * @return Always false.
     */
    @Override
    boolean canDoMovement(Board board, int goToX, int goToY) {
        return false;
    }

    /**
     * This piece is never selectable.
     * @param board The Board the piece belongs to.
     * @return Always false.
     */
    @Override
    boolean isSelectable(Board board) { return false; }
}
