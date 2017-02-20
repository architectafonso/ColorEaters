package com.empire_of_science.joao.coloreaters2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class GameActivity extends Activity {

    /**
     * The Game View acquired at onCreate().
     */
    GameView gameView;

    /**
     * The level that will be played.
     */
    public int level;

    /**
     * The level package that the level belongs to.
     */
    public int levelPackage;


    /**
     * Gets the gameView and sets the game pieces, the level, number of moves, and also sets
     * the animation and sound on or off.
     *
     * Has to request ad, and set the number of moves and level on the respective views.
     *
     * @param savedInstanceState Game saved from rotation.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Gets the GameView.
        gameView = (GameView) findViewById(R.id.gameV);

        // Sets the ad banner.
        AdControl.setAdd(this);

        // If it's getting the level first time, gets level from Intent, using loadLevel.
        if(savedInstanceState == null){
            level = getIntent().getExtras().getInt("level");
            levelPackage = getIntent().getExtras().getInt("levelPackage");
            LevelLoader.loadLevel(levelPackage, level, gameView.board);
            gameView.invalidate();
        }
        // If the game has been rotated or interrupted, gets info from
        // Bundle using RotationController.
        else
        {
            level = savedInstanceState.getInt("level");
            levelPackage = savedInstanceState.getInt("levelPackage");
            RotationController.load(savedInstanceState, gameView);
        }

        // Sets the number of moves to display. Actual ID depends on the layout, could be
        // moves_left or moves_left_large_3, because in tablets in landscape the number of moves
        // uses 3 text views.
        TextView text = (TextView)findViewById(R.id.moves_left);           //gets text view
        if (text == null){
            ((TextView)findViewById(R.id.moves_left_large_3)).setText("" + gameView.board.movesLeft);
        }else {
            String s = getResources().getString(R.string.moves_left);
            text.setText(s + gameView.board.movesLeft);
        }

        // Sets the level text view.
        TextView lev = (TextView)findViewById(R.id.level);
        String s = getResources().getString(R.string.level_indicator);
        lev.setText(s + " " + levelPackage + "/" + level);

        // Sets the animation on or off.
        gameView.animation.animationOn = PreferenceControl.getAnimationOnOff(this);
    }

    /**
     * This method has to save the state of the game for when the device is rotated.
     *
     * @param outState The bundle caring the game state info.
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Saves Pieces info to the bundle using RotationController.
        RotationController.save(outState, gameView);

        // Gets and puts game data on the bundle.
        outState.putInt("level", level);
        outState.putInt("levelPackage", levelPackage);
        outState.putInt("movesLeft", gameView.board.movesLeft);
    }


    /**
     * If back button is pressed, goes to the level selection menu for the appropriate package.
     * The intent will have "levelPackage".
     */
    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, LevelMenuActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("levelPackage", levelPackage);
        startActivity(intent);
    }


    /**
     * Called by the view when the user wins the game.
     * Also called from onSaveInstanceState.
     */
    public void win(){
        gameView.board.state = GameOverState.AlreadyRequested;
        Intent intent = new Intent(this, WinActivity.class);
        intent.putExtra("level", level);
        intent.putExtra("levelPackage", levelPackage);
        startActivity(intent);
    }

    /**
     * Called by the view when the user loses the game.
     * Also called from onSaveInstanceState.
     */
    public void lose(){
        gameView.board.state = GameOverState.AlreadyRequested;
        Intent intent = new Intent(this, LoseActivity.class);
        intent.putExtra("level", level);
        intent.putExtra("levelPackage", levelPackage);
        startActivity(intent);
    }


    /**
     * Sets the number of moves on the screen.
     * @param moves moves left.
     */
    public void changeMoves(int moves){
        TextView text = (TextView)findViewById(R.id.moves_left);
        if (text == null){
            ((TextView)findViewById(R.id.moves_left_large_3)).setText( "" + moves);
        }else {
            String s = getResources().getString(R.string.moves_left);
            text.setText(s + moves);
        }
    }

    /**
     * Called by Restart button.
     * Restarts this activity with same intent.
     *
     * @param view pressed button.
     */
    public void restart(View view){
        Intent intent = getIntent();
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return (id == R.id.action_settings)||super.onOptionsItemSelected(item);
    }
}