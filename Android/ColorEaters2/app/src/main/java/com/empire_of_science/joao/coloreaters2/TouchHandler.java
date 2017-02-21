package com.empire_of_science.joao.coloreaters2;

/**
 * Created by João on 12/12/2016.
 * Handles the touch events.
 */

class TouchHandler {


    /**
     * Handles a touch.
     * The coordinates should be those of the entire canvas from which the rectangle was taken
     * that was passed to drawGame(Rectangle).
     * @param x Touch x coordinate.
     * @param y Touch y coordinate.
     * @param gameSystem Associated GameSystem.
     */
    static void handleTouch(int x, int y, GameSystem gameSystem) {

        Board board = gameSystem.board;
        BoardDimensions dimensions = gameSystem.dimensions;

        // Continues only if no animation is going on.
        if (board.animator != null) return;

        // Checks if touch happened on a cell and sets touchX and touchY.
        // Ends if touch didn't happen on a cell.
        int[] cells = new int[2];
        if (!dimensions.getWhichCellAtCanvasCoordinates(x, y, cells)) return;
        int touchedX = cells[0];
        int touchedY = cells[1];

        // If no cell is selected, it selects cell if it has something that, in accordance with
        // game rules, can be moved, calls for invalidate() and then returns.
        if (!board.hasSelected){
            if (board.trySelectCell(touchedX, touchedY)){
                gameSystem.callbacks.playSelectSound() ;
                gameSystem.callbacks.requestDraw();
            }
            return;                               // Ends touch event handling.
        }

        // At this point, some move was requested.

        // Tries to move the selected piece to touched cell.
        if ( board.attemptMovementOfSelectedAndDeselect(touchedX, touchedY)){
            // If movement happened, decrements movesLeft, sets pieces to eat, plays right sound
            // and actually moves and eats either straight away or by setting the animation.
            board.movesLeft--;
            gameSystem.callbacks.setNumberOfMoves(board.movesLeft);
            if (board.eat()) gameSystem.callbacks.playEatSound();
            else gameSystem.callbacks.playMoveSound();
            actuallyMoveAndEatDirectlyOrThroughAnimation(gameSystem);
            gameSystem.callbacks.requestDraw();
            gameSystem.board.setGameOverState();
        } else {
            gameSystem.callbacks.playSelectSound();
            gameSystem.callbacks.requestDraw();
        }
    }


    /**
     * Makes any movement of pieces in the Board be reflected in the graphics coordinates,
     * and also actually eats th pieces set toDelete.
     * Does this directly or, if animations are turned on, by calling methods of GameAnimation,
     * that do this in several animation frames.
     */
    private static void actuallyMoveAndEatDirectlyOrThroughAnimation(GameSystem gameSystem){
        if (gameSystem.callbacks.isAnimationOn()) {
            gameSystem.board.animator = new Animator_MoveAnimator(gameSystem.board, gameSystem);
            return;
        }
        gameSystem.board.removeEatenCake();
        gameSystem.board.movePiecesToPlace();
        gameSystem.endIfNecessary();
        gameSystem.callbacks.requestDraw();
    }
}
