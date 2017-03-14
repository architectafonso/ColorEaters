package com.empire_of_science.joao.coloreaters2;

/**
 * Created by João on 23/02/2017.
 *
 * Animates the eaters. It waits for 1 second wit animationsState of pieces in 0, then moves them.
 */
class BackgroundAnimator {

    private boolean isWaiting = true;
    private int accumulatedInterval = 0;
    private int numberOfAnimationsExecuted = 0;
    private int animationFrame = 0;

    /**
     * Updates the time that has passed and if it is enough time, activates the animation.
     * @param interval Time since last call to animate in milliseconds.
     */
    private void waitingFrame (int interval){
        accumulatedInterval += interval;
        if (accumulatedInterval >= 1000){
            accumulatedInterval = 0;
            animationFrame = 0;
            isWaiting = false;
        }
        animationFrame = 0;
    }

    /**
     * Performs an update of the time since last change of frame and resets it and calls performMove
     * if enough time has passed.
     * @param interval Time since lst call to animate in milliseconds.
     */
    private void activeFrame (int interval){
        accumulatedInterval += interval;
        if (accumulatedInterval >= 50){
            performMove();
            accumulatedInterval = 0;
        }
    }

    /**
     * Updates the frame. If it is the last frame of an animation loop, resets the loop and updates
     * the number of animations counter. If it reaches its limit, then ends this period of animations
     * and background animations will wait for a while.
     */
    private void performMove(){
        animationFrame ++;
        if (animationFrame >= 5) {
            numberOfAnimationsExecuted ++;
            animationFrame = 0;
        }
        if (numberOfAnimationsExecuted >= 4){
            numberOfAnimationsExecuted = 0;
            animationFrame = 0;
            isWaiting = true;
        }
    }

    /**
     * Call every frame to do background animations like change the sprite sheet rect for pieces.
     * It can change the animationLoopStage of a board piece.
     * @param board The board containing the pieces to be animated.
     * @param interval Time passed since last call in milliseconds.
     */
    void animate(Board board, int interval){
        if (isWaiting) {
            waitingFrame(interval);
        }
        else {
            activeFrame(interval);
        }
        for (BoardPiece piece : board) {
            piece.animationLoopState = animationFrame;
        }
    }


}
