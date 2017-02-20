package com.empire_of_science.joao.coloreaters2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Represents the entry screen of the app.
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * Changes to MainLevelMenuActivity in response to pressing PLAY button.
     * @param view PLAY button.
     */
    public void go(View view){
        Intent intent = new Intent(this, MainLevelMenuActivity.class);
        startActivity(intent);
    }

    /**
     * Changes to HelpActivity in response to pressing HELP button.
     * @param view HELP button.
     */
    public void toHelp(View view){
        Intent intent = new Intent(this, HelpActivity.class);
        startActivity(intent);
    }

    /**
     * Changes to AboutActivity in response to pressing ABOUT button.
     * @param view ABOUT button.
     */
    public void toAbout(View view){
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }

    /**
     * Changes to SettingsActivity in response to pressing SETTINGS button.
     * @param view SETTINGS button.
     */
    public void toSettings(View view){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
}
