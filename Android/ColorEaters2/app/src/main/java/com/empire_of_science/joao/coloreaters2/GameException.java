package com.empire_of_science.joao.coloreaters2;

/**
 * Created by João on 07/10/2016.
 * Exception type used throughout the game.
 */
class GameException extends RuntimeException {
    /**
     * Calls super.
     * @param message Kind words.
     */
    GameException(String message){
        super(message);
    }
}
