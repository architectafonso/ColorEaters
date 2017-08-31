package com.empire_of_science.joao.coloreaters2;

import android.os.Bundle;

import com.color.eaters.Levels;

/**
 * Created by João on 06/12/2016.
 * Copyright João Afonso.
 *
 * GameSystem is used to not crowd the view too much.
 *
 */

class GameSystem {



    public final Board board;
    GameView gameView;
    BackgroundAnimator backgroundAnimator = new BackgroundAnimator();
    DrawHandler drawHandler;
    BoardDimensions dimensions = new BoardDimensions();
    TouchHandler touchHandler = new TouchHandler();


    /**
     * Constructor for when the game was paused due to rotation.
     * @param savedInstanceState Bundle with game info.
     * @param view The GameView.
     */
    GameSystem( Bundle savedInstanceState, GameView view) {

        String[] pausedState = new String[7];
        for (int index = 0; index < 7; index++) {
            pausedState[index] = savedInstanceState.getString("" + index);
        }
        gameView = view;
        board = new Board(pausedState);
        view.activity.changeMoves(board.movesLeft);
        view.invalidate();
        drawHandler = new DrawHandler(this);
    }

    /**
     * Constructor for when the game is created from the level selection menu.
     * @param levelPackage The package of levels.
     * @param level The level in teh package.
     * @param view The GameView.
     */
    GameSystem( int levelPackage, int level, GameView view) {
        gameView = view;
        board = new Board(Levels.getLevel(levelPackage, level));
        view.activity.changeMoves(board.movesLeft);
        view.invalidate();
        drawHandler = new DrawHandler(this);
    }


    /**
     * This method is called every time the game has to be saved, for instance, when an smartphone rotates.
     *
     * @return The String[] representing the state of the game.
     */
    String[] requestPauseAndPersistGame() {
        endIfNecessary();
        return board.toStringArray();
    }


    /**
     * This changes to win or lose activity if necessary.
     */
    void endIfNecessary() {
        if (board.gameOverState == GameOverState.Continue) return;
        if (board.gameOverState == GameOverState.Win) gameView.activity.win();
        else if (board.gameOverState == GameOverState.Lose) gameView.activity.lose();
        board.gameOverState = GameOverState.AlreadyRequested;
    }
}
