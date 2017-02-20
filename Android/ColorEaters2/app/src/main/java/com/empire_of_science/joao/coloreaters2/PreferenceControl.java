package com.empire_of_science.joao.coloreaters2;

import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by João on 10/10/2016.
 *
 * This class contains the methods to read and write to preferences.
 *
 * There are the following shared preferences:
 *
 * Strings with name "1", "2" and so on, that are the levels packages solving history.
 * This strings have 20 characters, that are n for unsolved levels and y for solved levels.
 * To check if level 3 of package 4 was solved, get string named "4" from preferences and
 * check the char at index 2 (the third one).
 *
 * Booleans "sound" and "animation", should be true if sound or animations are turned on.
 *
 * Make sure to always call a method to get a value from preferences as those also create the
 * preference if it doesn't exist.
 */
class PreferenceControl {

    /**
     * Gets the history of beaten levels from preferences, for a certain levels package.
     * If it doesn't exist, creates it.
     * It comes in the form of a string of 20 characters that are n for unbeaten levels and
     * y for beaten levels. To get the first level check char at index 0 and so on.
     *
     * @param activity Reference to an activity to have access to preferences.
     * @param levelPackage The package which history you want.
     * @return String of 20 characters, y if the level was beaten and n otherwise.
     */
    static String getPackageHistoryOrMakeIt(Activity activity, int levelPackage) {
        // Gets the gameSystem solving history.
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(activity);
        String beatenLevels = pref.getString(String.valueOf(levelPackage), " ");
        // If there is no info for this package, creates it.
        if (beatenLevels.equals(" ")) {
            pref.edit().putString(String.valueOf(levelPackage), "nnnnnnnnnnnnnnnnnnnn").apply();
            beatenLevels = "nnnnnnnnnnnnnnnnnnnn";
        }
        return beatenLevels;
    }

    /**
     * Saves to preferences that a certain level was solved.
     * @param activity Reference to an activity for access to SharedPreferences.
     * @param levelPackage Of the won level.
     * @param level Won level.
     */
    static void setWonGame(Activity activity, int levelPackage, int level) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(activity);
        // Gets the string with the history of this package.
        String levelPackageHistory = PreferenceControl.getPackageHistoryOrMakeIt(activity, levelPackage);
        char[] b = levelPackageHistory.toCharArray();
        // Changes the char at the right position.
        if (level > 0)              // Guards against bug when rotates at the same time it's moving.
            b[level - 1] = 'y';
        levelPackageHistory = String.valueOf(b);
        // Gets the new string saved to preferences.
        pref.edit().putString(String.valueOf(levelPackage), levelPackageHistory).apply();
    }

    /**
     * Gets from preferences the player's sound preferences.
     * @param activity Reference to an activity to access to preferences.
     * @return True if the sound is turned on, false if turned off.
     */
    static boolean getSoundOnOff (Activity activity){
        // Gets the gameSystem solving history.
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(activity);
        if (!pref.contains("sound")) {
            pref.edit().putBoolean("sound", true).apply();
            return true;
        }
        return pref.getBoolean("sound", true);

    }

    /**
     * Gets from preferences the player's animation preferences.
     * @param activity Reference to an activity for access to SharedPreferences.
     * @return True if animations are turned on, false if turned off.
     */
    static boolean getAnimationOnOff (Activity activity){

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(activity);
        if (!pref.contains("animation")) {
            pref.edit().putBoolean("animation", true).apply();
            return true;
        }
        return pref.getBoolean("animation", true);


    }

    /**
     * Saves to the preferences that the user wants the animations on or off.
     * @param activity Reference to an activity for access to preferences.
     * @param on True if animations are to be turned on or false if to be turned off.
     */
    static void setAnimationOnOff (Activity activity, boolean on) {

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(activity);
        pref.edit().putBoolean("animation", on).commit();
    }

    /**
     * Saves to the preferences that the user wants the sounds on or off.
     * @param activity Reference to an activity for access to preferences.
     * @param on True if the sound is to be turned on or false if to be turned off.
     */
    static void setSoundOnOff (Activity activity, boolean on) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(activity);
        pref.edit().putBoolean("sound", on).commit();
    }


}
