package com.empire_of_science.joao.coloreaters2;

/**
 * Created by João on 16/12/2016.
 */

class ColorEatersCallbacks implements ColorEatersInterface {

    private final GameView view;

    ColorEatersCallbacks(GameView view) { this.view = view; }



    @Override
    public void drawBackground(int x, int y, int width, int height) {
        view.gameDrawer.drawBackground(x, y, width, height);
    }

    @Override
    public void drawVerticalLine(int topX, int topY, int height) {
        view.gameDrawer.drawVerticalLine(topX, topY, height);
    }

    @Override
    public void drawHorizontalLine(int leftX, int leftY, int length) {
        view.gameDrawer.drawHorizontalLine(leftX, leftY, length);
    }




    @Override
    public void drawPiece(int x, int y, int width, int height, char pieceType) {
        view.gameDrawer.drawPiece(x, y, width, height, pieceType);
    }

    @Override
    public void drawSelection(int x, int y, int width, int height) {
        view.gameDrawer.drawSelection(x, y, width, height);
    }

    @Override
    public void terminateDraw() {
        view.gameDrawer.terminateDraw();
    }

    @Override
    public void win() {
        view.activity.win();
    }

    @Override
    public void lose() {
        view.activity.lose();
    }

    @Override
    public void setNumberOfMoves(int numberOfMoves) {
        view.activity.changeMoves(numberOfMoves);
    }

    @Override
    public void requestDraw() {
        view.invalidate();
    }

    @Override
    public boolean isAnimationOn() {
        return view.animationOn;
    }

    @Override
    public boolean areSoundsOn() {
        return false;
    }


    @Override
    public void playMoveSound() {
        view.sounds.playMoveSound();
    }

    @Override
    public void playEatSound() {
        view.sounds.playEatSound();
    }

    @Override
    public void playSelectSound() {
        view.sounds.playSelectSound();
    }
}
