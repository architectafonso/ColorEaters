package com.color.eaters;

/**
 * Created by João on 09/12/2016.
 *
 * This class represents an object that refers a BoardPiece and makes it move during animations.
 */

class Animation_PieceMover {

    private final int deltaX;
    private final int deltaY;
    final BoardPiece piece;

    Animation_PieceMover(BoardPiece piece, int destinyX, int destinyY) {
        this.piece = piece;

        deltaX = (destinyX - piece.graphicsX) / 10;
        deltaY = (destinyY - piece.graphicsY) / 10;
    }

    void move()
    {
        piece.graphicsX += deltaX;
        piece.graphicsY += deltaY;
    }



}
