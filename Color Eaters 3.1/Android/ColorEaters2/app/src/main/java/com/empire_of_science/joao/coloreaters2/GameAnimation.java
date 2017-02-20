package com.empire_of_science.joao.coloreaters2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by João on 30/09/2016.
 *
 * Has methods that allow the different animations of moving pieces.
 * An object of this class will be a field of the Game View.
 */
class GameAnimation {

    /**
     * True if the user has the animations turned on
     */
    boolean animationOn;

    /**
     * Associated GameView.
     */
    GameView view;

    /**
     * True if at the next drawing of the GameView it will request another
     * redrawing by calling invalidate().
     */
    boolean needsRedraw = false;

    /**
     * The animation frame. Always set to 1 at the beginning of the animation.
     */
    private int frame = 0;

    /**
     * The animation currently happening, NoAction if there's no animation going on.
     */
    AnimationState state = AnimationState.NoAction;

    /**
     * List of pieces that have to be moved during a move animation.
     */
    private List<BoardPiece> movingPieces = new ArrayList<>();

    /**
     * The constructor sets the view that has this GameAnimation.
     * @param view Associated GameView.
     */
    GameAnimation(GameView view){
        this.view = view;
    }

    /**
     * Performs a frame of the appropriate animation.
     * If state is moving and the frame is 10, changes to eating animation if there is
     * something to eat, or ends the animation..
     * If state is eating and the frame is 10, ends the animation.
     */
    void performAnimationFrame() {
        // If move or swap was requested but animation is disabled, simply does deletion and
        // performs stick() on the pieces so they are immediately in their final location.
        if (state == AnimationState.Moving) {
            movingFrame();
        }
        if (state == AnimationState.Eating){
            eatingFrame();
        }
        if (state == AnimationState.NoAction){
            GameOverControl.setGameOverState(view.board);
            if (view.board.state == GameOverState.Win) view.activity.win();
            if (view.board.state == GameOverState.Lose) view.activity.lose();

        }
    }

    /**
     * Performs a frame of moving the pieces following the user's input.
     */
    private void movingFrame() {
        for (BoardPiece piece : movingPieces) {
            piece.graphicsX += piece.deltaX;
            piece.graphicsY += piece.deltaY;
        }
        frame ++;
        needsRedraw = true;
        if (frame > 9){
            terminateMovingAnimation();
        }
    }

    /**
     * Performs a frame of the pieces moving in the direction of their eater
     * if they have been eaten.
     */
    private void eatingFrame() {
        for (BoardPiece p : movingPieces){
            p.graphicsX += p.deltaX;
            p.graphicsY += p.deltaY;
        }
        frame ++;
        needsRedraw = true;
        if (frame > 9) {
            terminateEatingAnimation();
        }
    }

    /**
     * Called during en last frame of moving animation.
     * If there are pieces to eat, starts eating animation, if not simply ends animation.
     */
    private void terminateMovingAnimation() {
        if (view.board.eat()){
            view.board.stick();
            startEatingAnimation();
            needsRedraw = true;
        } else {
            state = AnimationState.NoAction;
            view.board.stick();
            needsRedraw = true;
            view.gameSounds.playMoveSound(view.activity);
        }
    }

    private void startEatingAnimation(){
        state = AnimationState.Eating;
        frame = 1;
        view.gameSounds.playEatSound(view.activity);
        movingPieces.clear();
        for (BoardPiece[] array : view.board.pieces) for (BoardPiece piece : array){
            if (piece instanceof Cake && piece.toDelete){
                piece.deltaX = (((Cake) piece).eater.graphicsX - piece.graphicsX) / 10;
                piece.deltaY = (((Cake) piece).eater.graphicsY - piece.graphicsY) / 10;
                movingPieces.add(piece);
            }
        }
    }

    /**
     * Called at the last frame of eat animation.
     */
    private void terminateEatingAnimation() {
        state = AnimationState.NoAction;
        view.board.stick();
        needsRedraw = true;
        view.board.deletePiecesToDelete();
    }

    /**
     * Called when an animation is requested.
     * If a piece has graphics coordinates that are not the right ones for their board coordinates,
     * the piece's deltaX and deltaY are set and the piece is added to movingPieces.
     * Also the state is changed to Moving and the view is requested to invalidate.
     */
    void startAnimation (){
        movingPieces.clear();
        for(int x = 0; x < 6; x++) for (int y = 0; y < 6; y++) {
            if (view.board.pieces[x][y] != null) setPieceToMoveIfNecessary(view.board.pieces[x][y]);
        }
        frame = 1;
        state = AnimationState.Moving;
        view.invalidate();
    }

    private void setPieceToMoveIfNecessary(BoardPiece piece){
        if (piece.graphicsX != (piece.boardX * 1000 / 6) || piece.graphicsY != (piece.boardY * 1000 / 6)) {
            movingPieces.add(piece);
            int destinyX = piece.boardX * 1000 / 6;
            int destinyY = piece.boardY * 1000 / 6;
            piece.deltaX = (destinyX - piece.graphicsX) / 10;
            piece.deltaY = (destinyY - piece.graphicsY) / 10;
        }
    }

}


