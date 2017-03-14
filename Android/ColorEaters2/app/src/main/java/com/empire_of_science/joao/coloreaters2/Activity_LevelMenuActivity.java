package com.empire_of_science.joao.coloreaters2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Level selection menu.
 */
public class Activity_LevelMenuActivity extends AppCompatActivity {

    /**
     *  The levels package from which the user will chose the levels.
     *  Transmitted from the package selected activity or from the gameSystem, win or lose activities
     *  when back is pressed.
     */
    private int Package;

    /**
     * Gets the Package from Intent or Bundle.
     * Sets the color of buttons in accordance with they having been beaten.
     * If no gameSystem package history for this package is found on shared preferences, creates it.
     *
     * @param savedInstanceState Contains the package.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_menu);

        // Gets the level package.
        if (savedInstanceState != null){
            Package = savedInstanceState.getInt("levelPackage", 1);
        }else{
            Package = getIntent().getIntExtra("levelPackage", 1);
        }
        setTitle(getResources().getString(R.string.level_package) + " " + Package);

        String beatenLevels = PreferenceControl.getPackageHistoryOrMakeIt(this, Package);

        changeLevelsColorsAsHistory(beatenLevels);
    }

    /**
     * Changes the color of the text in the buttons to green if the level was completed
     * and to red if not.
     * @param history The history in the format of a string with 20 characters that are n for
     *                an uncompleted level and y for an completed one.
     */
    private void changeLevelsColorsAsHistory(String history) {
        // Changes the buttons text color.
        for (int x = 1; x <= 20; x++){
            int id = getResources().getIdentifier("level_"+ (x), "id", getPackageName());
            Button button = (Button)findViewById(id);
            if (history.charAt(x-1) == 'n') button.setTextColor(Color.RED);
            else button.setTextColor(Color.rgb(0, 140, 0));
        }
    }

    /**
     * Saves the gameSystem package for reconstruction.
     *
     * @param saveInstanceState Has to get levelPackage.
     */
    @Override
    public void onSaveInstanceState(Bundle saveInstanceState){
        saveInstanceState.putInt("levelPackage", Package);
    }

    /**
     * Called when a level button is pressed.
     * Gets the level from the button text and starts Activity_GameActivity, sending in the intent
     * the right levelPackage and level.
     *
     * @param view Pressed Button.
     */
    public void startGame(View view){
        Intent intent = new Intent(this, Activity_GameActivity.class);
        Button pressedButton = (Button)view;
        int levelInt = Integer.parseInt(pressedButton.getText().toString());
        intent.putExtra("level", levelInt);
        intent.putExtra("levelPackage", Package);
        startActivity(intent);
    }

    /**
     * Pressing back goes to Activity_MainLevelMenuActivity where another levels package can be selected
     * or go to the main menu.
     */
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, Activity_MainLevelMenuActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

}
