package com.empire_of_science.joao.coloreaters2;

/**
 * Created by João on 13/01/2017.
 * Copyright João Afonso.
 * Represents any block piece that has a color.
 */
abstract class BoardPieceWithColor extends BoardPiece {
    BoardPieceWithColor(int x, int y, Colors color) {
        super(x, y);
        this.color = color;
    }

    final Colors color;
}
