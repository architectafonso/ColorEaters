package com.empire_of_science.joao.coloreaters2;

/**
 * Created by João on 24/08/2017.
 */

public abstract class BoardPiece_Eater extends BoardPieceWithColor{
    public BoardPiece_Eater(int x, int y, Colors color){
        super(x, y, color);
    }

    /**
     * Makes every piece that is going to be eaten by this eater have toDelete true and an
     * reference to this eater.
     * @param board The board this piece is in.
     * @return True if there was any piece to eat.
     */
    boolean eat(Board board) {
        return EatProbe.ProbeAndSetToDelete(board, this);
    }

}
