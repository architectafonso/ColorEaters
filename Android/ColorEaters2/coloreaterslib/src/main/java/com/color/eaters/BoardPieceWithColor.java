package com.color.eaters;

/**
 * Created by João on 13/01/2017.
 */

abstract class BoardPieceWithColor extends BoardPiece {
    BoardPieceWithColor(int x, int y, Colors color) {
        super(x, y);
        this.color = color;
    }

    final Colors color;
}
