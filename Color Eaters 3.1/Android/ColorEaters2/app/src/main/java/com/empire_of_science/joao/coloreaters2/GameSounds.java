package com.empire_of_science.joao.coloreaters2;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.SoundPool;
import android.preference.PreferenceManager;

/**
 * Created by João on 29/09/2016.
 *
 * This class is a singleton and has methods to play any sound.
 * If sounds change only this class needs to be changed.
 * If rules change and there are other sounds to include, like the effect of an
 * special piece, use this class to create the sound player method, and just use it where necessary.
 */
class GameSounds {
    /**
     * Singleton instance.
     */
    private static GameSounds ourInstance;

    /**
     * Gets an instance of GameSounds.
     * Also sets soundOn accordingly to game preferences.
     * @param activity An activity to have access to resources.
     * @return GameSounds object.
     */
    static GameSounds getInstance(GameActivity activity) {
        // If there's no instance, creates it.
        if (ourInstance == null){
            ourInstance = new GameSounds(activity);
        }

        // Sets the sound on or off from preferences.
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(activity);
        // If no game preference exists for sound, creates it.
        if (!pref.contains("sound")) pref.edit().putBoolean("sound", true).commit();
        ourInstance.soundOn = pref.getBoolean("sound", true);

        return ourInstance;
    }

    /**
     * Reference to the eating sound.
     */
    private int eatSound;

    /**
     * Reference to the moving sound.
     */
    private int movingSound;

    /**
     * Reference to the selection sound.
     */
    private int selectionSound;

    /**
     * True if the sound is on.
     */
    private boolean soundOn;

    /**
     * The SoundPool object used to play the sounds.
     */
    private SoundPool soundPool;


    /**
     * Constructor sets the SoundPool and loads all the sounds.
     * @param activity Activity reference to access SoundPool.
     */
    @SuppressWarnings("deprecation")
    private GameSounds(GameActivity activity) {
        soundPool = new SoundPool(4, AudioManager.STREAM_MUSIC, 100);
        eatSound = soundPool.load(activity, R.raw.eatingsound, 1);
        movingSound = soundPool.load(activity, R.raw.movesound, 1);
        selectionSound = soundPool.load(activity, R.raw.selectionsound, 1);

    }

    /**
     * Plays the winning sound.
     * TODO
     */
    public void playWinSound(){

    }

    /**
     * Plays the lose sound.
     * TODO
     */
    public void playLoseSound() {

    }

    /**
     * Plays the move sound.
     * @param activity Allows calling API methods.
     */
    void playMoveSound(Activity activity) {
        if (soundOn) {
            AudioManager audioManager = (AudioManager) activity.getSystemService(Context.AUDIO_SERVICE);
            float curVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
            float maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
                soundPool.play(movingSound, curVolume / maxVolume, curVolume / maxVolume, 1, 0, 1F);
        }
    }

    /**
     * Plays the eating sound.
     * @param activity Allows calling API methods.
     */
    void playEatSound(Activity activity) {
        if (soundOn) {
            AudioManager audioManager = (AudioManager) activity.getSystemService(Context.AUDIO_SERVICE);
            float curVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
            float maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
            soundPool.play(eatSound, curVolume / maxVolume, curVolume / maxVolume, 1, 0, 1F);
        }
    }

    /**
     * Plays select and deselect sound.
     * @param activity Allows calling API methods.
     */
    void playSelectSound(Activity activity) {
        // Selection sound plays now.
        if (soundOn) {
            AudioManager audioManager = (AudioManager) activity.getSystemService(Context.AUDIO_SERVICE);
            float curVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
            float maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
            soundPool.play(selectionSound, curVolume / maxVolume, curVolume / maxVolume, 1, 0, 1F);
        }
    }
}
