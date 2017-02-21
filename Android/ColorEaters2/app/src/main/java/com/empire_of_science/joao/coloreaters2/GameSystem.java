package com.empire_of_science.joao.coloreaters2;

/**
 * Created by João on 06/12/2016.
 *
 * GameSystem has 4 methods corresponding to the 4 things that can happen to the game:
 * Get a touch/click input,
 * Request a draw,
 * Create the game,
 * Request state of the game to pause or rotation of the screen as in Android.
 *
 *
 */

public class GameSystem {

    ///////////////////////////////////////////////////////////////////////////////////////////////////
    // General stuff and fields
    /////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * The object that receives callback calls and implements them for the specific platform.
     */
    final ColorEatersInterface callbacks;
    public final Board board;
    final BoardDimensions dimensions;
    private final DrawGame drawGame;

    //////////////////////////////////////////////////////////////////////////////////////////////////
    // Graphics and Drawing Stuff
    ///////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Instructs the library to execute callback methods that draw each element of the game.
     * The methods must be implemented in the ColorEatersInterface passed to the constructor of
     * this GameSystem.
     * This allows for the logic of drawing the elements to be in this library, with each
     * implementation only needing to implement the methods that individually draw bitmaps, lines
     * and rectangles into each framework.
     * The drawing rectangle represents the drawing area for the game. If it doesn't match
     * the size of the entire available canvas, use the y and x arguments to specify the top left
     * corner of the drawing area in relation to the actual canvas. The callback methods
     * will consider that actual canvas in which there is the drawing area.
     * If it is not square, the game will be drawn in a square centered in the middle,
     * with the side as big as the smaller side of the rectangle.
     * @param x The upper left x coordinate of the drawing rectangle.
     * @param y The upper left y coordinate of the drawing rectangle.
     * @param height The height of the drawing rectangle.
     * @param width The width of the drawing rectangle.
     * @return True if a redraw is necessary, if that is the case instruct view to invalidate or
     * equivalent so that animate_DrawGame_CheckRedrawIsNeeded is called again.
     */
    public boolean animate_DrawGame_CheckRedrawIsNeeded(int x, int y, int width, int height){
        Rectangle r = new Rectangle(x, y, width, height);

        dimensions.setDimensions(r);

        if (board.animator != null)
            board.animator.executeAnimationFrame();

        drawGame.drawGame(r);



        // Only if there is an animation right now it will need to redraw the game.
        // Consider that the last frame of an animation is to destroy it, doesn't move anything.
        return board.animator != null;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////
    // Level creation stuff
    //////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     *
     * @param callbacks The object that implements callbacks and that will
     * @param ini The GameInitialStateInterface object that has info about how this game should
     *            begin.
     */
    public GameSystem(ColorEatersInterface callbacks, GameInitialStateInterface ini) {

        this.callbacks = callbacks;

        if (ini.getPausedState() == null)
            board = new Board(Levels.getLevel(ini.getLevelPackage(), ini.getLevel()));
        else
            board = new Board(ini.getPausedState());

        drawGame = new DrawGame(this);
        dimensions = new BoardDimensions();

        callbacks.setNumberOfMoves(board.movesLeft);
        callbacks.requestDraw();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Touch Stuff
    ////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Should be called every time a touch happens on the game area, with coordinates from 0 to
     * 1000.
     * @param x The graphics x coordinate.
     * @param y The graphics y coordinate.
     */
    public void touchHandler(int x, int y)
    {
        TouchHandler.handleTouch(x, y, this);
    }

    /**
     * This method is called every time the game has to be saved, for instance, when an smartphone
     *
     * @return The String[] representing the state of the game.
     */
    public String[] requestPauseAndPersistGame() {
        endIfNecessary();
        return board.toStringArray();
    }

    void endIfNecessary() {
        if (board.gameOverState == GameOverState.Continue) return;
        if (board.gameOverState == GameOverState.Win) callbacks.win();
        else if (board.gameOverState == GameOverState.Lose) callbacks.lose();
        board.gameOverState = GameOverState.AlreadyRequested;
    }
}
