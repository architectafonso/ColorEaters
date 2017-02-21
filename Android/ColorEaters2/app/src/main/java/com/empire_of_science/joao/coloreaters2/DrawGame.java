package com.empire_of_science.joao.coloreaters2;

/**
 * Created by João on 06/12/2016.
 *
 */

class DrawGame {
    private final GameSystem gameSystem;

    DrawGame ( GameSystem system) {
        gameSystem = system;
    }

    /**
     * Draws the different elements of the gameSystem, namely the background, the lines dividing the cells,
     * and all the pieces.
     * @param canvas The canvas to draw to.
     */
    void drawGame(Rectangle canvas) {
        // Sets the board dimensions.
        gameSystem.dimensions.setDimensions(canvas);
        Rectangle rect = gameSystem.dimensions.getEntireBoardRect();
        gameSystem.callbacks.drawBackground(rect.x, rect.y, rect.width, rect.height);
        drawSelection();
        drawBlockPieces(); // Drawn before the lines so it looks better.
        drawBoardLines();
        drawCake();
        drawEaters();
        // Also changes for the number of moves in the activity.
        gameSystem.callbacks.setNumberOfMoves(gameSystem.board.movesLeft);
        gameSystem.callbacks.terminateDraw();



    }

    /**
     * Draws the highlighting of the selected cell if there is one.
     */
    private void drawSelection(){
        if(gameSystem.board.hasSelected){
            Rectangle r = gameSystem.dimensions.getCellRect(gameSystem.board.selectedX, gameSystem.board.selectedY);
            gameSystem.callbacks.drawSelection(r.x, r.y, r.width, r.height);
        }
    }
    /**
     * Draws every eater piece.
     */
    private void drawEaters() {
        for (BoardPiece piece : gameSystem.board) {
            if(piece instanceof BoardPiece_Eater) {
                Rectangle r = gameSystem.dimensions.getGraphicsCoordinatesRect(piece.graphicsX, piece.graphicsY);
                //Finally draws the piece.
                gameSystem.callbacks.drawPiece(r.x, r.y, r.width, r.height, BoardPiece.toChar(piece, false));
            }
        }
    }

    /**
     * Draws every cake piece.
     */
    private void drawCake() {
        for (BoardPiece piece : gameSystem.board) {
            if(piece instanceof BoardPiece_Cake || piece instanceof BoardPiece_EatenCake) {

                Rectangle r = gameSystem.dimensions.getGraphicsCoordinatesRect(piece.graphicsX, piece.graphicsY);
                //Finally draws the piece!
                gameSystem.callbacks.drawPiece(r.x, r.y, r.width, r.height, BoardPiece.toChar(piece, true));
            }
        }

    }

    /**
     * Draws every blocking piece.
     */
    private void drawBlockPieces() {
        for (BoardPiece piece : gameSystem.board) if (piece instanceof BoardPiece_Block) {
            Rectangle r = gameSystem.dimensions.getGraphicsCoordinatesRect(piece.graphicsX, piece.graphicsY);
            //Finally draws the piece!
            gameSystem.callbacks.drawPiece(r.x, r.y, r.width, r.height, 'X');
        }
    }

    /**
     * Draws the board lines between the cells where pieces are.
     */
    private void drawBoardLines(){
        for(int index = 1; index < 6 ; index++){
            // Draws a vertical line.
            gameSystem.callbacks.drawVerticalLine(gameSystem.dimensions.getXOfVerticalBorders(index), gameSystem.dimensions.boardTop(),
                     gameSystem.dimensions.boardBottom() - gameSystem.dimensions.boardTop());
            // Draws an horizontal line.
            gameSystem.callbacks.drawHorizontalLine(gameSystem.dimensions.boardLeft(), gameSystem.dimensions.getYOfHorizontalBorders(index),
                    gameSystem.dimensions.boardRight() - gameSystem.dimensions.boardLeft());
        }
    }


}
