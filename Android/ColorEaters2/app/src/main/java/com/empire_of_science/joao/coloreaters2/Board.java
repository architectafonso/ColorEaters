package com.empire_of_science.joao.coloreaters2;

import java.util.Iterator;

/**
 * Created by João on 30/09/2016.
 * Represents the actual table of cells and the game pieces in it.
 * This class has information about the gameOverState of the game board.
 */
class Board implements Iterable<BoardPiece> {

    Animator animator;

    /**
     * The number of moves that the player can still use.
     */
    int movesLeft;

    /**
     * Holder of all the pieces, the actual board.
     */
    private BoardPiece[][] pieces = new BoardPiece[6][6];

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


    Board(String[] array) {
        if (array.length != 7) throw (new GameException("Provided Level has wrong number of strings: " + array.length));
        for (int y = 0; y < 6; y++){
            if (array[y].length() != 6)
                throw (new GameException("Provided Level has a bad string: " + array[y]));
            for (int x = 0; x < 6; x++){
                if (array[y].charAt(x) != ' '){
                    pieces[x][y] = BoardPiece.BoardPieceFactory(array[y].charAt(x), x, y);
                }
            }
        }
        movesLeft = Integer.parseInt(array[6]);
    }

    /**
     * Contains the gameOverState of the game concerning the need to end it if the player wins or loses.
     */
    GameOverState gameOverState = GameOverState.Continue;

    /**
     * Sets the gameOverState of the board to Win if there is no cake, to Lose if there is cake
     * and no more moves, and Continue in any other case.
     *
     * If it is not Continue, then keeps the current gameOverState, as a state that leads to
     * the end of the game has already been detected.
     */
    void setGameOverState() {
        if(gameOverState != GameOverState.Continue ) return;

        boolean zeroFood = true;
        for(BoardPiece piece : this)
            if(piece instanceof BoardPiece_Cake) zeroFood = false;

        if(zeroFood)
            this.gameOverState = GameOverState.Win;

        else if(this.movesLeft < 1)
            this.gameOverState = GameOverState.Lose;

        else
            this.gameOverState = GameOverState.Continue;
    }

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


    void removeEatenCake() {
        for (BoardPiece piece : this) {
            if (piece instanceof BoardPiece_EatenCake) {
                pieces[piece.boardX][piece.boardY] = null;
            }
        }
    }

    /**
     * This method makes every piece in this board to have its graphics coordinates set to the value
     * corresponding to their cell in the board, so they will appear in the right place.
     */
    void movePiecesToPlace() {
        for ( BoardPiece piece : this ) {
            piece.moveToPlace();
        }
    }

    /**
     * This method causes every BoardPiece_Eater in the board to eat, so that all cake to be eaten gets to have
     * toDelete = true eater pointing to their respective eater.
     * @return true if there is cake to be eaten.
     */
    boolean eat(){
        boolean hasEaten = false;
        for ( BoardPiece piece : this) {
            if (piece instanceof BoardPiece_Eater) {
                ((BoardPiece_Eater) piece).eat(this);
                hasEaten = true;
            }
        }
        return hasEaten;
    }

    void eatACake(int x, int y, BoardPiece_Eater eater){
        if ( !( pieces[x][y] instanceof BoardPiece_Cake ) ) {
            throw new GameException("Try to eat piece that's not cake @: " + x + ", " + y);
        }
        pieces[x][y] = new BoardPiece_EatenCake( (BoardPiece_Cake)(pieces[x][y]), eater );
    }

    /**
     * Selects the board cell at (x,y) if that is possible depending on which piece is there if any.
     * @param x Cell x coordinate.
     * @param y Cell y coordinate.
     * @return True if the cell was successfully selected.
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

    BoardPiece getPieceAt(int x, int y) {
        return pieces[x][y];
    }

    public Iterator<BoardPiece> iterator() {
        return new BoardIterator(this);
    }

    String[] toStringArray(){
        char[][] array = new char[6][];
        for (int y = 0; y < 6; y++){
            array[y] = new char[6];
        }
        for (BoardPiece p : this){
            if (!(p instanceof BoardPiece_EatenCake)){
                array[p.boardY][p.boardX] = BoardPiece.toChar(p, false);
            }
        }
        String[] stArray = new String[7];
        for (int y = 0; y < 6; y++){
            stArray[y] = new String(array[y]);
        }
        stArray[6] = String.valueOf(movesLeft);
        return stArray;
    }



}
