package com.empire_of_science.joao.coloreaters2;

/**
 * Created by João on 16/12/2016.
 */

public interface ColorEatersInterface {

    // Drawing methods.
    void drawBackground(int x, int y, int width, int height);
    void drawVerticalLine(int topX, int topY, int height);
    void drawHorizontalLine(int leftX, int leftY, int length);
    void drawPiece(int x, int y, int width, int height, char pieceType);
    void drawSelection(int x, int y, int width, int height);
    void terminateDraw();

    void win();
    void lose();
    void setNumberOfMoves(int numberOfMoves);
    void requestDraw();
    boolean isAnimationOn();
    boolean areSoundsOn();

    void playEatSound();
    void playMoveSound();
    void playSelectSound();


}
