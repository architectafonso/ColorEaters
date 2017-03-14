package com.empire_of_science.joao.coloreaters2;

import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by João on 12/12/2016.
 * Handles the touch events.
 */

class TouchHandler {

    boolean hasPiece = false;
    private BoardPiece pieceBeingMoved = null;
    private int initialPieceLocationX;
    private int initialPieceLocationY;


    /**
     * Handles a touch.
     * The coordinates should be those of the entire canvas from which the rectangle was taken
     * that was passed to drawGame(Rectangle).
     * @param x Touch x coordinate.
     * @param y Touch y coordinate.
     */
    void handleTouch(int x, int y, BoardDimensions dimensions, Board board, MotionEvent event, GameView gameView) {

        if (event.getAction() == MotionEvent.ACTION_DOWN) actionDownHandler(x, y, dimensions, board);
        else if (event.getAction() == MotionEvent.ACTION_MOVE) actionMoveHandler(x, y, dimensions);
        else if (event.getAction() == MotionEvent.ACTION_UP) actionUpHandler(x, y, dimensions, board, gameView);
    }

    /**
     * Handles the action down, checking if a piece was grabbed.
     * @param x Event x coordinate.
     * @param y Event y coordinate.
     * @param dimensions BoardDimensions object to know location of cells.
     * @param board The Board containing the game.
     */
    private void actionDownHandler(int x, int y, BoardDimensions dimensions, Board board){

        // Checks if touch happened on a cell and sets touchX and touchY.
        // Ends if touch didn't happen on a cell.
        int[] cells;
        try {
            cells = dimensions.getWhichCellAtCanvasCoordinates(x, y);
        }
        catch(GameException e){
            return;
        }
        int cellX = cells[0];
        int cellY = cells[1];

        // If there is a piece at the touched location and if it is movable, then it selects it.
        // Also puts data of original location in right place.
        // If not, then returns.
        if (board.getPieceAt(cellX, cellY) != null && board.getPieceAt(cellX, cellY).isSelectable(board)) {
            pieceBeingMoved = board.getPieceAt(cellX, cellY);
            initialPieceLocationX = pieceBeingMoved.graphicsX;
            initialPieceLocationY = pieceBeingMoved.graphicsY;
            hasPiece = true;
        }

    }

    /**
     * Handles the move of a grabbed piece.
     * @param x Event x coordinate.
     * @param y Event y coordinate.
     * @param dimensions BoardDimensions object to know location of cells.
     */
    private void actionMoveHandler(int x, int y, BoardDimensions dimensions) {
        if (!hasPiece) return;

        pieceBeingMoved.graphicsX = dimensions.graphicsXFromCanvasCoordinates(x) - (1000 / 12);
        pieceBeingMoved.graphicsY = dimensions.graphicsYFromCanvasCoordinates(y) - (1000 / 12);
    }

    /**
     * If a piece is being moved by this touch, and if the touch ends at a location the piece can
     * be moved to, then the MoveHandler will be called in order to execute the appropriate action.
     * If a piece is being moved but the place the touch ends is not a valid cell for it to move,
     * then returnToPlace will be called so that the piece returns to its place.
     * If no piece is being moved by this touch, then nothing happens.
     */
    private void actionUpHandler(int x, int y, BoardDimensions dimensions, Board board, GameView gameView){
        if (!hasPiece) return;

        int [] result = new int[2];
        try {
            result = dimensions.getWhichCellAtCanvasCoordinates(x, y);
        }
        catch(GameException e){
            return;
        }catch (Exception e){
            Log.d("error", " " + x + " " + y);
        }
        int destinyX = result[0];
        int destinyY = result[1];

        if (pieceBeingMoved.canDoMovement(board, destinyX, destinyY)){
            MoveHandler.doTheMove(destinyX, destinyY, board, pieceBeingMoved, this, gameView, gameView.gameSystem);
        }
        else{
            returnToPlace(board);
        }
        hasPiece = false;
        pieceBeingMoved = null;
    }

    /**
     * Makes the piece to slowly return to place after being released in an illegal location.
     */
    private void returnToPlace(Board board) {
        int destinyX = initialPieceLocationX;
        int destinyY = initialPieceLocationY;
        int deltaX = (pieceBeingMoved.graphicsX - destinyX) / 10;
        int deltaY = (pieceBeingMoved.graphicsY - destinyY) / 10;

        for (int index = 0; index < 10; index ++){
            pieceBeingMoved.graphicsX -= deltaX;
            pieceBeingMoved.graphicsY -= deltaY;
            try{
                Thread.sleep(40);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        board.movePiecesToPlace();
        pieceBeingMoved = null;
        hasPiece = false;
    }

}
