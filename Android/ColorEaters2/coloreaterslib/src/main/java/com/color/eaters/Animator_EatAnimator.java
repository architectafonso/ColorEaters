package com.color.eaters;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by João on 09/12/2016.
 *
 */

class Animator_EatAnimator extends Animator {

    private final Board board;
    private final GameSystem gameSystem;

    private final List<Animation_PieceMover> movers = new ArrayList<>(36);

    Animator_EatAnimator(Board board, GameSystem gameSystem) {
        this.board = board;
        this.gameSystem = gameSystem;
        board.eat();
        for ( BoardPiece piece : board) {
            if (piece instanceof BoardPiece_EatenCake) {
                movers.add (
                        new Animation_PieceMover(
                                piece, ((BoardPiece_EatenCake)piece).eater.graphicsX, ((BoardPiece_EatenCake)piece).eater.graphicsY
                        )
                );
            }
        }
    }

    @Override
    public void executeAnimationFrame() {
        if ( frame > 10) executeTerminatingFrame();
        else if ( frame == 10) executeFinalEatFrame();
        else executeEatFrame();

    }

    /**
     * The existence of this method allows the animator to still exist for one frame after
     * animation ended, so redraw of the last modifications still occurs (because there is an
     * animation at the end of drawing).
     */
    private void executeTerminatingFrame() {
        gameSystem.endIfNecessary();
        board.animator = null;
    }

    private void executeFinalEatFrame() {
        board.movePiecesToPlace();
        board.removeEatenCake();
        frame++;
    }

    private void executeEatFrame() {
        for ( Animation_PieceMover mover : movers)
            mover.move();
        frame ++;
    }
}
