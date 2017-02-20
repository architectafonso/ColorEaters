package com.empire_of_science.joao.coloreaters2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Represents the activity where the user can change the app settings.
 *
 * Currently the settings are animation on/off and sounds on/off.
 */
public class SettingsActivity extends AppCompatActivity {

    /**
     * True if the animations are activated.
     */
    public boolean animationOn;
    /**
     * True if the sounds are not muted.
     */
    public boolean soundOn;

    /**
     * When created, gets the state of settings from preferences and sets the
     * buttons and texts.
     * @param savedInstanceState Not used.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Gets sound state from preferences.
        soundOn = PreferenceControl.getSoundOnOff(this);

        // gets animation state from preferences.
        animationOn = PreferenceControl.getAnimationOnOff(this);

        // Sets the buttons and texts.
        setSoundButtonAndText();
        setAnimationButtonAndText();
    }

    /**
     * Sets the animation button and text accordingly with the current state.
     */
    private void setAnimationButtonAndText(){
        if (animationOn){
            ((TextView)findViewById(R.id.animation)).setText(R.string.animation_on);
            ((Button)findViewById(R.id.animation_button)).setText(R.string.turn_animation_off);
        } else {
            ((TextView)findViewById(R.id.animation)).setText(R.string.animation_off);
            ((Button)findViewById(R.id.animation_button)).setText(R.string.turn_animation_on);
        }
    }

    /**
     * Sets the sound button and text accordingly with the current state.
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
     * Changes the sound state, called when pressing sound button.
     * @param view Sound button.
     */
    public void setSound(View view){
        soundOn = !soundOn;
        setSoundButtonAndText();
        PreferenceControl.setSoundOnOff(this, soundOn);
    }

    /**
     * Changes the animation state, called when pressing sound button.
     * @param view Animation button.
     */
    public void setAnimation(View view){
        animationOn = !animationOn;
        setAnimationButtonAndText();
        PreferenceControl.setAnimationOnOff(this, animationOn);
    }
}