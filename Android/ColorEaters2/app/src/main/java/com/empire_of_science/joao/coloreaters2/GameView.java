package com.empire_of_science.joao.coloreaters2;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Copyright João Afonso.
 * Requirements:
 * The activity that hosts this view must be an Activity_GameActivity or one that extends it.
 * It also needs to  set the numberOfMoves, the level pieces and animationOn.
 */
public class GameView extends SurfaceView implements Runnable {

    public GameSystem gameSystem;
    GameSounds sounds;
    Thread drawThread = null;
    SurfaceHolder holder;
    boolean isDrawing = false;

    /**
     * The context activity.
     * Allows calling it to end the gameSystem and change the number of moves.
     */
    public final Activity_GameActivity activity;


    /**
     * Constructor sets the activity.
     * @param context The Activity_GameActivity.
     */
    public GameView(Context context) {
        super(context);
        activity = (Activity_GameActivity)context;
    }
    /**
     * Constructor sets the activity.
     * @param context The Activity_GameActivity.
     * @param attrs Not used attributes.
     */
    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        activity = (Activity_GameActivity)context;
    }

    /**
     * Constructor sets the activity.
     * @param context The Activity_GameActivity.
     * @param attrs Not used attributes.
     * @param defStyle Not used parameter.
     */
    public GameView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        activity = (Activity_GameActivity)context;
    }


    /**
     * Initializes the game info, with the bundle for when a rotation has happened.
     * @param savedInstanceState The bundle with paused game info.
     * @param view The GameView.
     */
    public void initialize( Bundle savedInstanceState, GameView view){
        gameSystem = new GameSystem (savedInstanceState, view);
        sounds = GameSounds.getInstance( activity);
        holder = getHolder();
    }

    /**
     * Initializes the game info, with the information about the game level and package, when the
     * level is starting to be played.
     */
    public void initialize( int levelPackage, int level){
        gameSystem = new GameSystem(levelPackage, level, this);
        sounds = GameSounds.getInstance( activity);
        holder = getHolder();
    }

    /**
     * The touch logic is in the touchHandler.handleTouch.
     * @param event The event from which to get the touched cell.
     * @return True always.
     */
    @Override
    public boolean onTouchEvent(@NonNull MotionEvent event){
        gameSystem.touchHandler.handleTouch((int)event.getX() , (int)event.getY(), gameSystem.dimensions, gameSystem.board, event, this);
        return true;
    }

    /**
     * The drawing thread animates and draws.
     */
    @Override
    public void run() {
        while (isDrawing){
            if(!holder.getSurface().isValid()){
                continue;
            }
            Canvas canvas = holder.lockCanvas();
            int timeInterval = getTimeInterval();
            gameSystem.backgroundAnimator.animate(gameSystem.board, timeInterval);
            gameSystem.drawHandler.draw(canvas, gameSystem);
            holder.unlockCanvasAndPost(canvas);
        }
    }


    /**
     * Gets the time from last call in milliseconds.
     * @return The time in milliseconds.
     */
    int getTimeInterval(){
        long currentTime = System.currentTimeMillis();
        if (lastTime == 0) {
            lastTime = currentTime;
            return 0;
        }
        long timeInterval = currentTime - lastTime;
        lastTime = currentTime;
        return (int) timeInterval;
    }

    private long lastTime = 0;

    /**
     * Pauses the thread.
     */
    public void pause() {
        isDrawing = false;
        while (true){
            try{
                drawThread.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            break;
        }
        drawThread = null;
    }

    /**
     * Resumes the drawing thread.
     */
    public void resume() {
        isDrawing = true;
        drawThread = new Thread(this);
        drawThread.start();
    }
}
