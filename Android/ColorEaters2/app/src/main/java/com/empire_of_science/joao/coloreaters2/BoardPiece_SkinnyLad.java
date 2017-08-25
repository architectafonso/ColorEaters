package com.empire_of_science.joao.coloreaters2;


/**
 * Created by João on 31/07/2017.
 * Represents a eater that just eats the cake one place around it, but it can jump everywhere but
 * only to empty places.
 */

public class BoardPiece_SkinnyLad extends BoardPieceWithColor {

    BoardPiece_SkinnyLad(int x, int y, Colors color) { super(x, y, color); }



    /**
     * This piece can move to any cell as long as it is empty.
     * @param board The Board the piece belongs to.
     * @param goToX X coordinate of the cell this piece is supposed to move.
     * @param goToY Y coordinate of the cell this piece is supposed to move.
     * @return True if movement is possible.
     */
    @Override
    boolean canDoMovement(Board board, int goToX, int goToY) {
        return board.getPieceAt(goToX, goToY) == null;
    }

    @Override
    boolean isSelectable(Board board) {
        return true;
    }

}
