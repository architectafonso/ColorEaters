package com.empire_of_science.joao.coloreaters2;

import android.os.Bundle;

import com.color.eaters.GameInitialStateInterface;

/**
 * Created by João on 07/12/2016.
 *
 */
class GameInitializer implements GameInitialStateInterface {

    private String[] pausedState;

    GameView view;

    private final int levelPackage;

    private final int level;

    GameInitializer(Bundle savedInstanceState) {
        level = savedInstanceState.getInt("level");
        levelPackage = savedInstanceState.getInt("levelPackage");
        pausedState = new String[7];
        for (int index = 0; index < 7; index++) {
            pausedState[index] = savedInstanceState.getString("" + index);
        }
    }

    GameInitializer(int levelPackage, int level) {
        this.level = level;
        this.levelPackage = levelPackage;

    }

    @Override
    public String[] getPausedState() {
        return pausedState;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public int getLevelPackage() {
        return levelPackage;
    }
}
