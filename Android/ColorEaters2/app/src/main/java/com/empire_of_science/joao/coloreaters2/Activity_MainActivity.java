package com.empire_of_science.joao.coloreaters2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Represents the entry screen of the app.
 */
public class Activity_MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * Changes to Activity_MainLevelMenuActivity in response to pressing PLAY button.
     * @param view PLAY button.
     */
    public void go(View view){
        Intent intent = new Intent(this, Activity_MainLevelMenuActivity.class);
        startActivity(intent);
    }

    /**
     * Changes to Activity_HelpActivity in response to pressing HELP button.
     * @param view HELP button.
     */
    public void toHelp(View view){
        Intent intent = new Intent(this, Activity_HelpActivity.class);
        startActivity(intent);
    }

    /**
     * Changes to Activity_AboutActivity in response to pressing ABOUT button.
     * @param view ABOUT button.
     */
    public void toAbout(View view){
        Intent intent = new Intent(this, Activity_AboutActivity.class);
        startActivity(intent);
    }

    /**
     * Changes to Activity_SettingsActivity in response to pressing SETTINGS button.
     * @param view SETTINGS button.
     */
    public void toSettings(View view){
        Intent intent = new Intent(this, Activity_SettingsActivity.class);
        startActivity(intent);
    }
}
