package com.empire_of_science.joao.coloreaters2;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.color.eaters.GameSystem;

/**
 * Requirements:
 * The activity that hosts this view must be an GameActivity or one that extends it.
 * It also needs to  set the numberOfMoves, the level pieces and animationOn.
 */
public class GameView extends View {

    private final ColorEatersCallbacks callbacks = new ColorEatersCallbacks(this);



    /**
     * Contains the method to actually draw the pieces and board.
     * Initialized by the initialize() method
     */
    GameDrawer gameDrawer;

    /**
     * The context activity.
     * Allows calling it to end the gameSystem and change the number of moves.
     */
    public final GameActivity activity;


    /**
     * Constructor sets the activity.
     * @param context The GameActivity.
     */
    public GameView(Context context) {
        super(context);
        activity = (GameActivity)context;
    }
    /**
     * Constructor sets the activity.
     * @param context The GameActivity.
     * @param attrs Not used attributes.
     */
    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        activity = (GameActivity)context;
    }

    /**
     * Constructor sets the activity.
     * @param context The GameActivity.
     * @param attrs Not used attributes.
     * @param defStyle Not used parameter.
     */
    public GameView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        activity = (GameActivity)context;
    }

    /**
     * Called by constructors, gets the GameDrawer and gameSounds objects.
     */
    public void initialize(GameInitializer gameInitializer){
        gameSystem = new GameSystem(callbacks, gameInitializer);
        // Sets the GameDrawer object in to draw the board and its pieces.
        gameDrawer = new GameDrawer(activity);
        sounds = GameSounds.getInstance(activity);
    }

    public GameSystem gameSystem;

    public boolean animationOn;

    GameSounds sounds;



    /**
     * When the view is touched, determines the cell touched, if any.
     * Selects if none selected and a selectable piece is there.
     * Moves if selected piece can do a valid move to this cell, otherwise simply deselects.
     * If a move happened, reduces number of moves and calls for eating either directly or
     * through animation.
     * @param event The event from which to get the touched cell.
     * @return True always.
     */
    @Override
    public boolean onTouchEvent(@NonNull MotionEvent event){

        // Continues only if action down.
        if(event.getAction()!= MotionEvent.ACTION_DOWN) return true;

        gameSystem.touchHandler((int)event.getX() , (int)event.getY());

        return true;
    }



    /**
     * Calls the animation object to perform a frame if an animation is happening,
     * draws the current gameOverState of the gameSystem, sets the right number of moves in the activity and
     * invalidates if the animation requires it.
     * @param canvas The canvas on which the board will be drawn.
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Draws the current gameOverState of the gameSystem.
        gameDrawer.canvas = canvas;
        boolean redrawIsNeeded =
                gameSystem.animate_DrawGame_CheckRedrawIsNeeded( 0, 0, canvas.getWidth(), canvas.getHeight() );
        gameDrawer.canvas = null;
        if (redrawIsNeeded) invalidate();
    }
}
