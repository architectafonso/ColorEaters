package com.empire_of_science.joao.coloreaters2;

/**
 * Created by João on 31/10/2016.
 * Copyright João Afonso.
 * Represents an eater.
 */
class BoardPiece_NormalEater extends BoardPiece_Eater {

    /**
     * Calls super and sets the color.
     * @param x X cell coordinate.
     * @param y Y cell coordinate.
     * @param color The color of this eater.
     */
    BoardPiece_NormalEater(int x, int y, Colors color ) {
        super (x, y, color);
    }

    /**
     * This piece can move to a cell right next door if it is empty or if it contains a
     * cake or eater.
     * @param board The Board the piece belongs to.
     * @param goToX X coordinate of the cell this piece is supposed to move.
     * @param goToY Y coordinate of the cell this piece is supposed to move.
     * @return True if movement is possible.
     */
    @Override
    boolean canDoMovement(Board board, int goToX, int goToY) {
        boolean isNextDoor = ((goToX == boardX && goToY == boardY + 1) ||
                (goToX == boardX && goToY == boardY - 1) ||
                (goToX == boardX + 1 && goToY == boardY ) ||
                (goToX == boardX - 1 && goToY == boardY));
        boolean hasRightKindOfPieceOrNone = (board.getPieceAt(goToX, goToY) instanceof BoardPiece_Cake ||
                board.getPieceAt(goToX, goToY) instanceof BoardPiece_NormalEater ||
                board.getPieceAt(goToX, goToY) == null);

        return isNextDoor  && hasRightKindOfPieceOrNone ;
    }

    /**
     * Eaters are selectable in all circumstances.
     * @param board The Board the piece belongs to.
     * @return Always true.
     */
    @Override
    boolean isSelectable(Board board) {
        return true;
    }
}
