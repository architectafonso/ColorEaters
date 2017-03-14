package com.empire_of_science.joao.coloreaters2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

/**
 * Activity that allows player to chose the level package that contains the wanted level.
 */
public class Activity_MainLevelMenuActivity extends AppCompatActivity {

    /**
     * When starts has to set the title.
     * @param savedInstanceState Not used.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_level_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(getResources().getString(R.string.choose_level_package));
    }

    /**
     * When a button is pressed goes to the level menu activity, with the intent containing the
     * right level package. The chosen level package is obtained from the button text.
     * @param view The pressed button.
     */
    public void chooseLevel(View view){
        int LevelPackage =  Integer.parseInt(((String)((Button)view).getText()));
        Intent intent = new Intent(this, Activity_LevelMenuActivity.class);
        intent.putExtra("levelPackage", LevelPackage);
        startActivity(intent);
    }
}
