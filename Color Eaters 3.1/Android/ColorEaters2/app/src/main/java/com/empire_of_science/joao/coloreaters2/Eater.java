package com.empire_of_science.joao.coloreaters2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by João on 31/10/2016.
 */

public class Eater extends BoardPiece{

    int color;

    Eater(int x, int y, int color ) {
        boardX = x;
        boardY = y;
        this.color = color;
        graphicsX = (1000/6) * x;
        graphicsY = (1000/6) * y;
    }


    boolean eat(Board board) {
        return EatProbe.ProbeAndSetToDelete(board, this);
    }

    @Override
    public boolean canDoMovement(Board board, int goToX, int goToY) {
        boolean isNextDoor = ((goToX == boardX && goToY == boardY + 1) ||
                (goToX == boardX && goToY == boardY - 1) ||
                (goToX == boardX + 1 && goToY == boardY ) ||
                (goToX == boardX - 1 && goToY == boardY));
        boolean hasRightKindOfPieceOrNone = (board.pieces[goToX][goToY] instanceof Cake ||
                board.pieces[goToX][goToY] instanceof Eater ||
                board.pieces[goToX][goToY] == null);

        return isNextDoor  && hasRightKindOfPieceOrNone ;
    }

    @Override
    public boolean isSelectable(Board board) {
        return true;
    }
}
