package com.color.eaters;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by João on 09/12/2016.
 * Moves the pieces that need to be moved.
 */
class Animator_MoveAnimator extends Animator {

    private final Board board;
    private final List<Animation_PieceMover> movers = new ArrayList<>(36);
    private final GameSystem gameSystem;

    Animator_MoveAnimator(Board board, GameSystem gameSystem) {
        this.board = board;
        this.gameSystem = gameSystem;
        for (BoardPiece piece : board)
            if ( piece.graphicsX != piece.boardX * (1000 / 6)
                    || piece.graphicsY != piece.boardY * (1000 / 6))
                movers.add(new Animation_PieceMover(piece, piece.boardX * (1000 / 6), piece.boardY * (1000 / 6)));
    }


    @Override
    public void executeAnimationFrame() {
        if ( frame >= 10) executeFinalMoveFrame();
        else executeMoveFrame();
    }

    /**
     * Note: can movePiecesToPlace in final one because it is going to be replaced by EatAnimator, which means
     * that there is still a redraw for sure!
     */
    private void executeFinalMoveFrame() {
        board.movePiecesToPlace();
        board.animator = new Animator_EatAnimator( board, gameSystem );
    }


    private void executeMoveFrame() {
        for (Animation_PieceMover mover : movers) {
            mover.move();
        }
        frame ++;
    }
}
