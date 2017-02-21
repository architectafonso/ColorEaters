package com.empire_of_science.joao.coloreaters2;

/**
 * Created by João on 30/09/2016.
 *
 * Used to determine the gameOverState of the game concerning its end.
 */
enum GameOverState {
    /**
     * The game is to continue.
     */
    Continue,
    /**
     * The game was won by the player.
     */
    Win,
    /**
     * The game was lost by the player.
     */
    Lose,
    /**
     * Change to another activity was already requested, call for change again would
     * give an erratic behaviour.
     */
    AlreadyRequested
}
