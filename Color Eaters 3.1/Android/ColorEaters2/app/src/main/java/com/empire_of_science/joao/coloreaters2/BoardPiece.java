package com.empire_of_science.joao.coloreaters2;

/**
 * Created by João on 14/08/2015.
 * This abstract class represents every board piece of any kind.
 */
abstract class BoardPiece {

    /**
     * Board horizontal coordinate for the board cell the piece is in.
     * Will be a value between 0 and 5.
     */
    int boardX;

    /**
     * Board vertical coordinate for the board cell the piece is in.
     * Will be a value between 0 and 5.
     */
    int boardY;

    /**
     * Coordinates for the horizontal precise position of the piece in the view.
     * Used because of animations. Will be a value between 0 and 1000.
     */
    int graphicsX;

    /**
     * Coordinates for the vertical precise position of the piece in the view.
     * Used because of animations. Will be a value between 0 and 1000.
     */
    int graphicsY;

    /**
     * Set true during a test to check for pieces to be eaten.
     * If it's set true, this piece will be deleted when Board.deletePiecesToDelete() is called.
     */
    boolean toDelete;

    /**
     * How much the piece should move horizontally per frame to reach the animation destiny.
     */
    int deltaX;

    /**
     * How much the piece should move vertically per frame to reach the animation destiny.
     */
    int deltaY;

    /**
     * Makes sure the canvas float coordinates are set in accordance with board position.
     * This allows to make sure that the position is the one of the cell the piece is in after the
     * animations.
     * The graphics coordinates are set with a value between 0 and 1000 and during GameView's onDraw
     * that is converted to the actual canvas coordinates.
     */
    void stick(){
        graphicsX = (1000/6)* boardX;
        graphicsY = (1000/6)* boardY;
    }

    /**
     * 
     * @param board
     * @param goToX
     * @param goToY
     * @return
     */
    public abstract boolean canDoMovement(Board board, int goToX, int goToY);

    public abstract boolean isSelectable(Board board);
}


