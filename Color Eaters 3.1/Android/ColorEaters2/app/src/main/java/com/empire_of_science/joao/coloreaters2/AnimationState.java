package com.empire_of_science.joao.coloreaters2;

/**
 * Created by João on 30/09/2016.
 * Enumeration of the animation states the game can be in.
 */
enum AnimationState {
    /**
     * Pieces are moving as ordered by the user.
     */
    Moving,

    /**
     * Pieces are moving because they were eaten.
     */
    Eating,

    /**
     * No pieces are moving.
     */
    NoAction
}
