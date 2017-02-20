package com.empire_of_science.joao.coloreaters2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * Activity shown when the player solves a level. Allows go to the next level and return to level
 * menu. Sets the level as solved.
 */
public class WinActivity extends Activity {

    /**
     * Level data that allows going to the next level.
     */
    private int level;
    /**
     * Level data that allows going to the next level.
     */
    private int levelPackage;

    /**
     * When activity starts the level and level package are set.
     * If it is started with savedInstanceState==null, sets the level as solved, by getting the
     * level package string from sharedPreferences (or creating one) and setting the character
     * corresponding to this level as y instead of n.
     * @param savedInstanceState Bundle with level and levelPackage.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        //If it's starting now
        if(savedInstanceState==null) {
            level = getIntent().getExtras().getInt("level");
            levelPackage = getIntent().getExtras().getInt("levelPackage");
            // save winning of the gameSystem on preferences
            PreferenceControl.setWonGame(this, levelPackage, level);
        }

        //If it's restarting after rotation or pause
        else {
            level = savedInstanceState.getInt("level");
            levelPackage = savedInstanceState.getInt("levelPackage");
        }
    }

    /**
     * Called when user decides to go back.
     * Goes to the level menu activity for this level package.
     */
    private void goBack(){
        Intent intent = new Intent(this, LevelMenuActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("levelPackage", levelPackage);
        startActivity(intent);
    }

    /**
     * Calls goBack().
     * @param view Back button.
     */
    public void back(View view){goBack();}

    /**
     * Calls goBack().
     */
    @Override
    public void onBackPressed() {goBack();}

    /**
     * Starts the next level, if the level is 20 then returns to levels menu.
     * @param view The return button.
     */
    public void next(View view){
        if(level+1 <= 20) {
            Intent intent = new Intent(this, GameActivity.class);
            intent.putExtra("level", level + 1);
            intent.putExtra("levelPackage", levelPackage);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, LevelMenuActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("levelPackage", levelPackage);
            startActivity(intent);
        }
    }

    /**
     * Has to save the level and level Package.
     * @param outState Gets level and levelPackage.
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putInt("level", level);
        outState.putInt("levelPackage", levelPackage);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_win, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
