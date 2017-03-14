package com.empire_of_science.joao.coloreaters2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by João on 20/11/2016.
 * Iterates over the Board to return every BoardPiece in the game.
 */
class BoardIterator implements Iterator<BoardPiece> {

    /**
     * Coordinate of the last checked cell.
     */
    private int currentX = -1; // Has to start at -1 because Next() assumes it is in the cell of last returned piece.
    /**
     * Coordinate of the last checked cell.
     */
    private int currentY = 0;

    /**
     * The board this iterates over.
     */
    private final Board board;

    /**
     * The constructor sets the board.
     * @param b The board this iterates over.
     */
    BoardIterator(Board b) {
        board = b;
    }


    /**
     * Checks if there is an piece not yet returned.
     * @return True if there is another piece to return.
     */
    @Override
    public boolean hasNext() {
        int x = currentX;
        int y = currentY;
        while (true) {
            x++;
            if (x > 5) { x = 0; y++; }
            if (y > 5) return false;
            if (board.getPieceAt(x, y) != null) break;
        }
        return true;
    }

    /**
     * Gets the next piece.
     * @return The next BoardPiece in the Board.
     */
    @Override
    public BoardPiece next() {
        while (true) {
            currentX++;
            if (currentX > 5) { currentX = 0; currentY++; }
            if (currentY > 5) throw new NoSuchElementException();
            if (board.getPieceAt(currentX, currentY) != null) break;
        }
        return board.getPieceAt(currentX, currentY);
    }

    @Override
    public void remove() {

    }



}
