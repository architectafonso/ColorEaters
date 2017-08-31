package com.empire_of_science.joao.coloreaters2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * Copyright João Afonso.
 * Activity shown when the player loses the gameSystem.
 * Allows restart the gameSystem and return to levels menu of this package.
 */
public class Activity_LoseActivity extends Activity {

    /**
     * Level information to allow return to the level package and restart of the same level.
     */
    private int level, levelPackage;

    /**
     * When starts has to get the level and level package.
     * @param savedInstanceState The bundle with data.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose);
        if(savedInstanceState==null) {
            level = getIntent().getExtras().getInt("level");
            levelPackage = getIntent().getExtras().getInt("levelPackage");
        } else {
            level = savedInstanceState.getInt("level");
            levelPackage = savedInstanceState.getInt("levelPackage");
        }
    }

    /**
     * When the screen is rotated level and level package have to be saved.
     * @param outState The bundle.
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("level", level);
        outState.putInt("levelPackage", levelPackage);
    }

    /**
     * When back is pressed goes to the right level package.
     * The intent has FLAG_ACTIVITY_CLEAR_TOP to remove other activities from memory.
     */
    private void goBack(){
        Intent intent = new Intent(this, Activity_LevelMenuActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("levelPackage", levelPackage);
        startActivity(intent);
    }

    /**
     * When back layout button is pressed calls goBack().
     * @param view Back button.
     */
    public void back(View view){goBack();}

    /**
     * When back is pressed calls goBack().
     */
    @Override
    public void onBackPressed(){goBack();}


    /**
     * When restart is pressed starts the Activity_GameActivity with the same level and level package.
     * @param view Restart button.
     */
    public void restart(View view){
        Intent intent = new Intent(this, Activity_GameActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("level", level);
        intent.putExtra("levelPackage", levelPackage);
        intent.putExtra("fromMenu", true);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_lose, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        // noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}