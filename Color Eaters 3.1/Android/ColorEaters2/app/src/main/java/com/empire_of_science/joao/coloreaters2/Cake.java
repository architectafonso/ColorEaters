package com.empire_of_science.joao.coloreaters2;


/**
 * Created by João on 31/10/2016.
 */

class Cake extends BoardPiece {

    public int color;
    public Eater eater;

    Cake(int x, int y, int color){
        boardX = x;
        boardY = y;
        this.color = color;
        graphicsX = (1000/6) * x;
        graphicsY = (1000/6) * y;
    }

    @Override
    public boolean canDoMovement(Board board, int goToX, int goToY) {
        boolean isNextDoor = (goToX == boardX && goToY == boardY + 1) ||
                (goToX == boardX && goToY == boardY - 1) ||
                (goToX == boardX + 1 && goToY == boardY ) ||
                (goToX == boardX - 1 && goToY == boardY);

        boolean hasRightKindOfPieceOrNone = (board.pieces[goToX][goToY] instanceof Cake ||
                board.pieces[goToX][goToY] instanceof Eater ||
                board.pieces[goToX][goToY] == null);

        return isNextDoor && hasRightKindOfPieceOrNone;
    }

    @Override
    public boolean isSelectable(Board board) {
        return true;
    }
}
