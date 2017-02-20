package com.empire_of_science.joao.coloreaters2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by João on 10/10/2016.
 * Composes GameDrawer having all the bitmaps.
 */
class DrawGameBitmaps {
    /**
     * Bitmap for the blue cake.
     */
    private final Bitmap blueCake;
    /**
     * Bitmap for the blue eater.
     */
    private final Bitmap blueEater;
    /**
     * Bitmap for the green cake.
     */
    private final Bitmap greenCake;
    /**
     * Bitmap for the green eater.
     */
    private final Bitmap greenEater;
    /**
     * Bitmap for the red cake.
     */
    private final Bitmap redCake;
    /**
     * Bitmap for the red eater.
     */
    private final Bitmap redEater;
    /**
     * Bitmap for the yellow cake.
     */
    private final Bitmap yellowCake;
    /**
     * Bitmap for the yellow eater.
     */
    private final Bitmap yellowEater;
    /**
     * Bitmap for the white cake.
     */
    private final Bitmap whiteCake;
    /**
     * Bitmap for the white eater.
     */
    private final Bitmap whiteEater;
    /**
     * Bitmap for the 'X' blocking piece.
     */
    private final Bitmap blockPiece;

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

    Bitmap getBlockPieceBitmap() {
        return blockPiece;
    }

    Bitmap getBitmap(char pieceType) {
        if (pieceType == 'X') return blockPiece;
        else if (Character.isLowerCase(pieceType)) return getCakeBitmap(pieceType);
        return getEaterBitmap(pieceType);
    }

    /**
     * Gets the bitmap of the cake with the corresponding color.
     * @param type The color of the cake piece.
     * @return Bitmap of the cake.
     */
    Bitmap getCakeBitmap(char type) {
        if (type == 'g') return greenCake;
        if (type == 'b') return blueCake;
        if (type == 'w') return whiteCake;
        if (type == 'y') return yellowCake;
        if (type == 'r') return redCake;
        return yellowCake;
    }

    /**
     * Gets the bitmap of the eater with the corresponding color.
     * @param type The color of the eater piece.
     * @return Bitmap of the eater.
     */
    Bitmap getEaterBitmap(char type) {
        if (type == 'G') return greenEater;
        if (type == 'B') return blueEater;
        if (type == 'W') return whiteEater;
        if (type == 'Y') return yellowEater;
        if (type == 'R') return redEater;
        else return yellowCake;
    }

}
