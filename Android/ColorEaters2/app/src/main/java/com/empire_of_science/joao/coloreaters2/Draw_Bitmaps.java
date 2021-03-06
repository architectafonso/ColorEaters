package com.empire_of_science.joao.coloreaters2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

/**
 * Created by João on 10/10/2016.
 * Copyright João Afonso.
 * Composes GameDrawer having all the bitmaps.
 */
class Draw_Bitmaps {
    /**
     * Bitmap for the blue cake.
     */
    private final Bitmap blueCake;
    /**
     * Bitmap for the green cake.
     */
    private final Bitmap greenCake;

    /**
     * Bitmap for the red cake.
     */
    private final Bitmap redCake;
    /**
     * Bitmap for the yellow cake.
     */
    private final Bitmap yellowCake;
    /**
     * Bitmap for the white cake.
     */
    private final Bitmap whiteCake;
    /**
     * Bitmap for the 'X' blocking piece.
     */
    private final Bitmap blockPiece;

    private final Bitmap eaterSprite;

    private final Bitmap whiteFrozenCake;
    private final Bitmap redFrozenCake;
    private final Bitmap greenFrozenCake;
    private final Bitmap blueFrozenCake;
    private final Bitmap yellowFrozenCake;

    private final Bitmap whiteFlyingFatso;
    private final Bitmap redFlyingFatso;
    private final Bitmap blueFlyingFatso;
    private final Bitmap greenFlyingFatso;
    private final Bitmap yellowFlyingFatso;



    /**
     * The constructor initializes all the bitmaps.
     * @param activity The Activity_GameActivity used to have access to resources.
     */
    Draw_Bitmaps(Activity_GameActivity activity) {

        blueCake = BitmapFactory.decodeResource(activity.getResources(), R.drawable.blue_cake);
        redCake = BitmapFactory.decodeResource(activity.getResources(), R.drawable.red_cake);
        whiteCake = BitmapFactory.decodeResource(activity.getResources(), R.drawable.white_cake);
        yellowCake = BitmapFactory.decodeResource(activity.getResources(), R.drawable.yellow_cake);
        greenCake = BitmapFactory.decodeResource(activity.getResources(), R.drawable.green_cake);

        blockPiece = BitmapFactory.decodeResource(activity.getResources(), R.drawable.lock);

        eaterSprite = BitmapFactory.decodeResource(activity.getResources(), R.drawable.eater_sprite_sheet);

        whiteFrozenCake = BitmapFactory.decodeResource(activity.getResources(), R.drawable.white_frozen_cake);
        redFrozenCake = BitmapFactory.decodeResource(activity.getResources(), R.drawable.red_frozen_cake);
        greenFrozenCake = BitmapFactory.decodeResource(activity.getResources(), R.drawable.green_frozen_cake);
        blueFrozenCake = BitmapFactory.decodeResource(activity.getResources(), R.drawable.blue_frozen_cake);
        yellowFrozenCake = BitmapFactory.decodeResource(activity.getResources(), R.drawable.yellow_frozen_cake);

        whiteFlyingFatso = BitmapFactory.decodeResource(activity.getResources(), R.drawable.white_flying_fatso);
        redFlyingFatso = BitmapFactory.decodeResource(activity.getResources(), R.drawable.red_flying_fatso);
        yellowFlyingFatso = BitmapFactory.decodeResource(activity.getResources(), R.drawable.yellow_flying_fatso);
        blueFlyingFatso = BitmapFactory.decodeResource(activity.getResources(), R.drawable.blue_flying_fatso);
        greenFlyingFatso = BitmapFactory.decodeResource(activity.getResources(), R.drawable.green_flying_fatso);
    }


    /**
     * Returns the bitmap info to draw the respective piece.
     * @param piece The piece to be drawn.
     * @return Bitmap info to draw the piece.
     */
    BitmapInfo getBitmap(BoardPiece piece) {
        if (piece instanceof BoardPiece_Block) return new BitmapInfo(blockPiece, new Rect(0, 0, 99, 99));
        if (piece instanceof BoardPiece_EatenCake || piece instanceof BoardPiece_Cake) {
            switch (((BoardPieceWithColor)piece).color) {
                case Green: return new BitmapInfo( greenCake, new Rect(0, 0, 99, 99));
                case Red: return new BitmapInfo( redCake, new Rect(0, 0, 99, 99));
                case White: return new BitmapInfo( whiteCake, new Rect(0, 0, 99, 99));
                case Yellow: return new BitmapInfo( yellowCake, new Rect(0, 0, 99, 99));
                case Blue: return new BitmapInfo( blueCake, new Rect(0, 0, 99, 99));
                default: throw new GameException(" weirdly colored piece ");
            }
        }
        if (piece instanceof BoardPiece_NormalEater){
            switch (((BoardPiece_NormalEater)piece).color){
                case Green: return new BitmapInfo(eaterSprite, new Rect(100, piece.animationLoopState * 100, 199, (piece.animationLoopState * 100)+99));
                case Red: return new BitmapInfo(eaterSprite, new Rect(200, piece.animationLoopState * 100, 299, (piece.animationLoopState * 100)+99));
                case White: return new BitmapInfo(eaterSprite, new Rect(300, piece.animationLoopState * 100, 399, (piece.animationLoopState * 100)+99));
                case Yellow: return new BitmapInfo(eaterSprite, new Rect(400, piece.animationLoopState * 100, 499, (piece.animationLoopState * 100)+99));
                case Blue: return new BitmapInfo(eaterSprite, new Rect(0, piece.animationLoopState * 100, 99, (piece.animationLoopState * 100)+99));
                default: throw new GameException(" weirdly colored piece ");
            }
        }
        if (piece instanceof BoardPiece_FlyingFatso){
            switch(((BoardPiece_FlyingFatso)piece).color){
                case Green: return new BitmapInfo(greenFlyingFatso, new Rect(0, 0, 99, 99));
                case Blue: return new BitmapInfo(blueFlyingFatso, new Rect(0, 0, 99, 99));
                case Yellow: return new BitmapInfo(yellowFlyingFatso, new Rect(0, 0, 99, 99));
                case White: return new BitmapInfo(whiteFlyingFatso, new Rect(0, 0, 99, 99));
                case Red: return new BitmapInfo(redFlyingFatso, new Rect(0, 0, 99, 99));
            }
        }
        if (piece instanceof BoardPiece_FrozenCake){
            switch(((BoardPiece_FrozenCake)piece).color){
                case Green: return new BitmapInfo(greenFrozenCake, new Rect(0, 0, 99, 99));
                case Blue: return new BitmapInfo(blueFrozenCake, new Rect(0, 0, 99, 99));
                case Yellow: return new BitmapInfo(yellowFrozenCake, new Rect(0, 0, 99, 99));
                case White: return new BitmapInfo(whiteFrozenCake, new Rect(0, 0, 99, 99));
                case Red: return new BitmapInfo(redFrozenCake, new Rect(0, 0, 99, 99));
            }
        }
        throw new GameException(" weirdly colored piece ");
    }

    /**
     * Has information about the bitmap to draw a piece, has it can be in a sprite sheet, so it
     * has to be cut in accordance with some rect.
     */
    class BitmapInfo {
        BitmapInfo(Bitmap bit, Rect r) {bitmap = bit; rect = r;}
        Bitmap bitmap;
        Rect rect;
    }
}
