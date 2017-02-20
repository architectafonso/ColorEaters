package com.empire_of_science.joao.coloreaters2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by João on 10/10/2016.
 * Composes DrawGame having all the bitmaps.
 */
class DrawGameBitmaps {
    /**
     * Bitmap for the blue cake.
     */
    Bitmap blueCake;
    /**
     * Bitmap for the blue eater.
     */
    Bitmap blueEater;
    /**
     * Bitmap for the green cake.
     */
    Bitmap greenCake;
    /**
     * Bitmap for the green eater.
     */
    Bitmap greenEater;
    /**
     * Bitmap for the red cake.
     */
    Bitmap redCake;
    /**
     * Bitmap for the red eater.
     */
    Bitmap redEater;
    /**
     * Bitmap for the yellow cake.
     */
    Bitmap yellowCake;
    /**
     * Bitmap for the yellow eater.
     */
    Bitmap yellowEater;
    /**
     * Bitmap for the white cake.
     */
    Bitmap whiteCake;
    /**
     * Bitmap for the white eater.
     */
    Bitmap whiteEater;
    /**
     * Bitmap for the 'X' blocking piece.
     */
    Bitmap blockPiece;

    /**
     * The constructor initializes all the bitmaps.
     * @param activity The GameActivity used to have access to resources.
     */
    DrawGameBitmaps(GameActivity activity) {

        blueCake = BitmapFactory.decodeResource(activity.getResources(), R.drawable.blue_cake);
        redCake = BitmapFactory.decodeResource(activity.getResources(), R.drawable.red_cake);
        whiteCake = BitmapFactory.decodeResource(activity.getResources(), R.drawable.white_cake);
        yellowCake = BitmapFactory.decodeResource(activity.getResources(), R.drawable.yellow_cake);
        greenCake = BitmapFactory.decodeResource(activity.getResources(), R.drawable.green_cake);

        blueEater = BitmapFactory.decodeResource(activity.getResources(), R.drawable.blue_eater);
        redEater = BitmapFactory.decodeResource(activity.getResources(), R.drawable.red_eater);
        whiteEater = BitmapFactory.decodeResource(activity.getResources(), R.drawable.white_eater);
        yellowEater = BitmapFactory.decodeResource(activity.getResources(), R.drawable.yellow_eater);
        greenEater = BitmapFactory.decodeResource(activity.getResources(), R.drawable.green_eater);

        blockPiece = BitmapFactory.decodeResource(activity.getResources(), R.drawable.lock);
    }

}
