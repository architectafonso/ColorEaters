package com.empire_of_science.joao.coloreaters2;

/**
 * Created by João on 10/03/2017.
 * Represents the eaters that can move to any other position in the board, but only to empty cells.
 * The flying fatsos' character is the one to the left of their color's letter in an qwerty keyboard.
 * Example: blue flying fatso is 'n'
 *
 * TODO: bitmaps, character, eating process, and use in some level.
 */

public class BoardPiece_FlyingFatso extends BoardPieceWithColor {
    BoardPiece_FlyingFatso(int x, int y, Colors color) { super(x, y, color); }

    @Override
    boolean isSelectable(Board board) {
        return true;
    }

    @Override
    boolean canDoMovement(Board board, int goToX, int goToY) {
        return board.getPieceAt(goToX, goToY) == null;
    }


}
