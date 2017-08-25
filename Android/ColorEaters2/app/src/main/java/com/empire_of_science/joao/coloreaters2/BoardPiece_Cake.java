package com.empire_of_science.joao.coloreaters2;

/**
 * Created by João on 31/10/2016.
 * Represents the BoardPiece_Cake.
 */
class BoardPiece_Cake extends BoardPiece_Edible {

    /**
     * The eater that have eaten this cake.
     */
    BoardPiece_NormalEater eater;


    /**
     * Calls super and sets te color.
     * @param x X cell coordinate.
     * @param y Y cell coordinate.
     * @param color The color of this cake.
     */
    BoardPiece_Cake(int x, int y, Colors color){
        super (x, y, color);
    }

    @Override
    public boolean getEaten(Board board, BoardPiece_Eater eater) {
        board.setPiece(boardX, boardY, new BoardPiece_EatenCake(this, eater));
        return true;
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
        boolean isNextDoor = (goToX == boardX && goToY == boardY + 1) ||
                (goToX == boardX && goToY == boardY - 1) ||
                (goToX == boardX + 1 && goToY == boardY ) ||
                (goToX == boardX - 1 && goToY == boardY);

        boolean hasRightKindOfPieceOrNone = (board.getPieceAt(goToX, goToY) instanceof BoardPiece_Cake ||
                board.getPieceAt(goToX, goToY) instanceof BoardPiece_NormalEater ||
                board.getPieceAt(goToX, goToY) == null);

        return isNextDoor && hasRightKindOfPieceOrNone;
    }

    /**
     * BoardPiece_Cake is selectable in all circumstances.
     * @param board The Board the piece belongs to.
     * @return Always true.
     */
    @Override
    boolean isSelectable(Board board) {
        return true;
    }
}
