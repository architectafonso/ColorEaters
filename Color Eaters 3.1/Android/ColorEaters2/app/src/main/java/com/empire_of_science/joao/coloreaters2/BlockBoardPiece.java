package com.empire_of_science.joao.coloreaters2;

/**
 * Created by João on 30/09/2016.
 * Represents the 'X' pieces that do not move during the game.
 */
class BlockBoardPiece extends BoardPiece {



    /**
     * The constructor sets the pieces x and y board coordinates.
     * Also sets the graphics coordinates accordingly.
     * @param x Board x coordinate.
     * @param y Board y coordinate.
     */
    BlockBoardPiece(int x, int y){
        boardX = x;
        boardY = y;
        stick();
    }

    @Override
    public boolean canDoMovement(Board board, int goToX, int goToY) {
        return false;
    }

    @Override
    public boolean isSelectable(Board board) { return false; }
}
