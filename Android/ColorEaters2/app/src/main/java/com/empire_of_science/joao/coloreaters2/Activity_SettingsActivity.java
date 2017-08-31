package com.empire_of_science.joao.coloreaters2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 *Copyright João Afonso.
 *
 * Represents the activity where the user can change the app settings.
 *
 * Currently the settings are animation on/off and sounds on/off.
 */
public class Activity_SettingsActivity extends AppCompatActivity {


    /**
     * True if the sounds are not muted.
     */
    private boolean soundOn;

    /**
     * When created, gets the gameOverState of settings from preferences and sets the
     * buttons and texts.
     * @param savedInstanceState Not used.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Gets sound gameOverState from preferences.
        soundOn = PreferenceControl.getSoundOnOff(this);

        // Sets the buttons and texts.
        setSoundButtonAndText();
    }


    /**
     * Sets the sound button and text accordingly with the current gameOverState.
     */
    private void setSoundButtonAndText(){
        if (soundOn){
            ((TextView)findViewById(R.id.sound)).setText(R.string.sound_on);
            ((Button)findViewById(R.id.sound_button)).setText(R.string.turn_sound_off);
        } else {
            ((TextView)findViewById(R.id.sound)).setText(R.string.sound_off);
            ((Button)findViewById(R.id.sound_button)).setText(R.string.turn_sound_on);
        }
    }

    /**
     * Changes the sound gameOverState, called when pressing sound button.
     * @param view Sound button.
     */
    public void setSound(View view){
        soundOn = !soundOn;
        setSoundButtonAndText();
        PreferenceControl.setSoundOnOff(this, soundOn);
    }
}
