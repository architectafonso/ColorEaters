package com.empire_of_science.joao.coloreaters2;

import java.util.Iterator;

/**
 * Created by João on 30/09/2016.
 * Copyright João Afonso.
 * Represents the actual table of cells and the game pieces in it.
 * This class has information about the gameOverState of the game board.
 */
class Board implements Iterable<BoardPiece> {

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
            if(piece instanceof BoardPiece_Edible) zeroFood = false;
        if(zeroFood)
            this.gameOverState = GameOverState.Win;
        else if(this.movesLeft < 1)
            this.gameOverState = GameOverState.Lose;
        else
            this.gameOverState = GameOverState.Continue;
    }

    public void setPiece(int x, int y, BoardPiece p){
        pieces[x][y] = p;
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

    /**
     * Removes all the pieces that are dead, flying fatsos with isDead == true and Eaten Cake.
     * This happens after animation of eating so that they show during the animation.
     */
    void removeDeadPieces() {
        for (BoardPiece piece : this) {
            if (piece instanceof BoardPiece_EatenCake ||
                    (piece instanceof BoardPiece_FlyingFatso && ((BoardPiece_FlyingFatso) piece).isDead)) {
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
     * This method causes every BoardPiece_Eater in the board to eat.
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
        // Only now it really unfreezes, because otherwise unfreezed cake could be eaten by another
        // eater at the same eating event.
        for ( BoardPiece piece : this) {
            if (piece instanceof BoardPiece_FrozenCake && ((BoardPiece_FrozenCake)piece).unfreezing){
                pieces[piece.boardX][piece.boardY] = new BoardPiece_Cake(
                        piece.boardX, piece.boardY, ((BoardPiece_FrozenCake)piece).color
                );
            }
        }
        return hasEaten;
    }

    /**
     * Moves one piece to another cell, and swaps if there was another piece there, returns that
     * other piece so that its move can be animated.
     * Also, it kills a flying fatso if it is moving.
     * @param fromX X coordinate of the cell of the piece to be moved.
     * @param fromY Y coordinate of the cell of the piece to be moved.
     * @param toX X coordinate of the cell the piece is supposed to move to.
     * @param toY Y coordinate of the cell the piece is supposed to move to.
     * @return The piece that is swaped or null.
     */
    BoardPiece movePiece_ReturnPieceAtDestinyOrNull(int fromX, int fromY, int toX, int toY){
        if (pieces[fromX][fromY] != null && pieces[fromX][fromY].canDoMovement(this, toX, toY)){
            if (pieces[toX][toY] == null) {
                // Kills a lying fatso as it moves.
                if (pieces[fromX][fromY] instanceof BoardPiece_FlyingFatso)
                    ((BoardPiece_FlyingFatso)pieces[fromX][fromY]).isDead=true;
                pieces[fromX][fromY].boardX = toX;
                pieces[fromX][fromY].boardY = toY;
                pieces[toX][toY] = pieces[fromX][fromY];
                pieces[fromX][fromY] = null;
                return null;
            }
            // Else, has to trade the pieces using the hold variable.
            BoardPiece hold = pieces[toX][toY];     // Creates hold and puts piece that was on destiny there.
            pieces[fromX][fromY].boardX = toX;
            pieces[fromX][fromY].boardY = toY;
            hold.boardX = fromX;
            hold.boardY = fromY;
            pieces[toX][toY] = pieces[fromX][fromY];
            pieces[fromX][fromY] = hold;
            return hold;
        }
        return null;
    }

    /**
     * Returns piece in the cell.
     * @param x Cell x coordinate.
     * @param y Cell y coordinate.
     * @return Piece in the cell.
     */
    BoardPiece getPieceAt(int x, int y) {
        return pieces[x][y];
    }

    /**
     * Returns teh iterator that iterates over the pieces in this board.
     * @return Iterator.
     */
    public Iterator<BoardPiece> iterator() {
        return new BoardIterator(this);
    }

    /**
     * Returns teh string array representing the state of the level, in the same format the levels
     * are stored.
     * @return String array representing the level.
     */
    String[] toStringArray(){
        char[][] array = new char[6][];
        for (int y = 0; y < 6; y++){
            array[y] = new char[]{' ', ' ', ' ', ' ', ' ', ' '};
        }
        for (BoardPiece p : this){
            if (!(p instanceof BoardPiece_EatenCake)){
                array[p.boardY][p.boardX] = BoardPiece.toChar(p);
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
