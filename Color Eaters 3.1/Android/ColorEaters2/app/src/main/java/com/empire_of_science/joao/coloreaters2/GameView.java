package com.empire_of_science.joao.coloreaters2;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Requirements:
 * The activity that hosts this view must be an GameActivity or one that extends it.
 * TODO: falar o on que deve iniciar.
 * It also needs to  set the numberOfMoves, the level pieces and animationOn.
 */
public class GameView extends View {

    /**
     * The board that has the pieces and their state in the game.
     */
    Board board = new Board(this);

    /**
     * Contains the method to actually draw the pieces and board.
     * Initialized by onCreate of the activity.
     */
    DrawGame drawGame;

    /**
     * Has the methods for executing the animation when needed.
     * Member animationOn initialized by onCreate of the activity.
     */
    GameAnimation animation = new GameAnimation(this);

    /**
     * The context activity.
     * Allows calling it to end the game and change the number of moves.
     */
    public GameActivity activity;


    /**
     * Class to get the sounds, it is initialized by onCreate on teh Activity.
     */
    GameSounds gameSounds;

    /**
     * Constructor sets the activity and calls initialize.
     * @param context The GameActivity.
     */
    public GameView(Context context) {
        super(context);
        activity = (GameActivity)context;
        initialize();
    }
    /**
     * Constructor sets the activity and calls initialize.
     * @param context The GameActivity.
     * @param attrs Not used attributes.
     */
    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        activity = (GameActivity)context;
        initialize();
    }
    /**
     * Constructor sets the activity and calls initialize.
     * @param context The GameActivity.
     * @param attrs Not used attributes.
     * @param defStyle Not used parameter.
     */
    public GameView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        activity = (GameActivity)context;
        initialize();
    }

    /**
     *
     */
    private void initialize(){
        // Sets the DrawGame object in to draw the board and its pieces.
        drawGame = DrawGame.getInstance(activity);
        gameSounds = GameSounds.getInstance(activity);
    }


    /**
     *
     * @param event The event from which to get the touched cell.
     * @return True always.
     */
    @Override
    public boolean onTouchEvent(@NonNull MotionEvent event){

        // Continues only if action down and if no animation is running.
        if(event.getAction()!= MotionEvent.ACTION_DOWN || animation.state != AnimationState.NoAction) return true;

        // Checks if touch happened on a cell and sets touchX and touchY.
        // Ends if touch didn't happen on a cell.
        int[] cells = new int[2];
        if (!drawGame.getWhichCellAtCanvasCoordinates(event.getX(), event.getY(), cells)) return true;
        int touchedX = cells[0];
        int touchedY = cells[1];

        // If no cell is selected, it selects cell if it has something that, in accordance with
        // game rules, can be moved, calls for invalidate() and then returns.
        if (!board.hasSelected){
            if (board.trySelectCell(touchedX, touchedY)){
                gameSounds.playSelectSound(activity) ;
                invalidate();
            }
            return true;                                // Ends touch event handling.
        }

        // At this point, some move was requested.

        if ( board.attemptMovementOfSelectedAndDeselect(touchedX, touchedY)){
            board.movesLeft--;
            if (board.eat()) gameSounds.playEatSound(activity);
            else gameSounds.playMoveSound(activity);
            actuallyMoveAndEatDirectlyOrThroughAnimation();
            return true;
        } else {
            gameSounds.playSelectSound(activity);
            invalidate();
            return true;
        }
    }

    private void actuallyMoveAndEatDirectlyOrThroughAnimation(){
        if (animation.animationOn) {
            animation.startAnimation();
            return;
        }
        board.deletePiecesToDelete();
        board.stick();
        GameOverControl.setGameOverState(board);
        if (board.state == GameOverState.Win) activity.win();
        if (board.state == GameOverState.Lose) activity.lose();
        invalidate();
    }

    /**
     *
     * @param canvas The canvas on which the board will be drawn.
     *
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Performs the animation if some is currently active.
        animation.performAnimationFrame();

        // Draws the current state of the game.
        drawGame.drawGame(canvas, board);

        // If the animation state is NoAction, that means that the animation ended, so
        // tests for winning or losing.
        if (animation.state == AnimationState.NoAction) {
            if (board.state == GameOverState.Win) activity.win();
            if (board.state == GameOverState.Lose) activity.lose();
        }

        // Also changes for the number of moves in the activity.
        activity.changeMoves(board.movesLeft);

        // If the animation has left a necessity for redrawing calls invalidate and
        // sets needsRedraw as false.
        if (animation.needsRedraw) {
            animation.needsRedraw = false;
            invalidate();

        }
    }
}
