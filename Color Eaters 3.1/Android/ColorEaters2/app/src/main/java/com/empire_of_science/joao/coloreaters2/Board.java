package com.empire_of_science.joao.coloreaters2;

/**
 * Created by João on 30/09/2016.
 * This class has information about the state of the game board and its pieces.
 */
class Board {

    /**
     * The number of moves that the player can still use.
     */
    int movesLeft;

    /**
     * Holder of all the pieces, the actual board.
     */
    BoardPiece[][] pieces = new BoardPiece[6][6];

    /**
     * Reference to the GameView that shows this board.
     */
    GameView view;

    /**
     * True if there is a selected piece.
     */
    boolean hasSelected = false;

    /**
     * Cell x coordinate of the selected piece.
     */
    int selectedX;

    /**
     * Cell y coordinate of the selected piece.
     */
    int selectedY;

    /**
     * Constructor sets the associated GameView.
     * @param v GameView that will present this Board.
     */
    Board(GameView v){
        view = v;
    }

    /**
     * Contains the state of the game concerning to need to end it if the player wins or loses.
     */
    GameOverState state = GameOverState.Continue;

    /**
     * Moves the selected piece to a location. Changes the board coordinates
     * of the piece but not the graphics coordinates that are used to draw them.
     * Also, removes selection.
     * @param x X coordinate where to move the selected piece.
     * @param y Y coordinate where to move the selected piece.
     */
    private void moveSelectedPiece(int x, int y){
        // If the destiny is empty just moves one piece.
        if (pieces[x][y] == null) {
            pieces[selectedX][selectedY].boardX = x;
            pieces[selectedX][selectedY].boardY = y;
            pieces[x][y] = pieces[selectedX][selectedY];
            pieces[selectedX][selectedY] = null;
        } else {
            // Else, has to trade the pieces using the hold variable.
            BoardPiece hold = pieces[x][y];
            pieces[selectedX][selectedY].boardX = x;
            pieces[selectedX][selectedY].boardY = y;
            hold.boardX = selectedX;
            hold.boardY = selectedY;
            pieces[x][y] = pieces[selectedX][selectedY];
            pieces[selectedX][selectedY] = hold;
        }
        // The selection is removed after moving.
        hasSelected = false;
    }

    /**
     * This method removes from the board every piece that has toDelete == true;
     * @return True if there were pieces to delete.
     */
    boolean deletePiecesToDelete() {
        boolean hasPiecesToDelete = false;
        for (BoardPiece[] array : pieces) for (BoardPiece piece : array) {
            if (piece != null && piece.toDelete) {
                pieces[piece.boardX][piece.boardY] = null;
                hasPiecesToDelete = true;
                piece.toDelete = false;

            }
        }
        return hasPiecesToDelete;
    }

    /**
     * This method makes every piece have the graphics coordinates corresponding to their
     * position in the board, so they will appear in the right place.
     */
    void stick() {
        for (BoardPiece[] array : pieces) for(BoardPiece piece : array) {
            if (piece != null) piece.stick();
        }
    }

    /**
     * This method causes every Eater in the board to eat, so that all cake to be eaten gets to have
     * toDelete = true and their eater set.
     * @return true if there is cake to be eaten.
     */
    boolean eat(){
        boolean hasEaten = false;
        for ( BoardPiece[] array : view.board.pieces) for (BoardPiece piece : array) {
            if (piece instanceof Eater) {
                ((Eater) piece).eat(view.board);
                hasEaten = true;
            }
        }
        return hasEaten;
    }

    /**
     * Selects the board cell at (x,y) if that is possible depending on which piece is there if any.
     * @param x Cell x coordinate.
     * @param y Cell y coordinate.
     * @return Tue if the cell was successful selected.
     */
    boolean trySelectCell(int x, int y){
        if (pieces[x][y] != null && (pieces[x][y].isSelectable(this))) {
            // If there was a movable piece in the selected cell selects it and invalidates.
            hasSelected = true;
            selectedX = x;
            selectedY = y;
            return true;
        }
        return false;
    }

    /**
     * Moves the selected piece to the cell at the specified coordinates, if possible, and in any
     * case sets hasSelected = false.
     * @param toX Cell coordinates where to move the selected piece.
     * @param toY  Cell coordinates where to move the selected piece.
     * @return True if move was successful.
     */
    boolean attemptMovementOfSelectedAndDeselect( int toX, int toY){
        hasSelected = false;
        if (pieces[selectedX][selectedY] != null && pieces[selectedX][selectedY].canDoMovement(this, toX, toY)){
            moveSelectedPiece(toX, toY);
            return true;
        }
        return false;
    }
}
