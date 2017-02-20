package com.empire_of_science.joao.coloreaters2;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by João on 29/09/2016.
 * This class is a singleton that contains the method for drawing the actual pieces, so
 * that it is easier to change gameSystem graphics without changing activities and views.
 */
class GameDrawer {

    Canvas canvas;

    /**
     * Object containing the bitmaps.
     */
    private final DrawGameBitmaps bitmaps;

    /**
     * Paint used to draw the background of the board.
     */
    private final Paint backgroundPaint = new Paint();

    /**
     * Paint used to draw the lines dividing the cells.
     */
    private final Paint linesPaint = new Paint();

    /**
     * Paint used to draw the highlighted cell.
     */
    private final Paint selectedPaint = new Paint();

    /**
     * The constructor initializes all of the bitmaps from resources.
     * @param activity An reference to an activity is needed to get the resources.
     */
    GameDrawer(GameActivity activity) {

        // Initialize the bitmaps.
        bitmaps = new DrawGameBitmaps(activity);

        // Initialize the paints.
        backgroundPaint.setColor(Color.BLACK);
        backgroundPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        linesPaint.setColor(Color.WHITE);
        linesPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        selectedPaint.setColor(Color.GRAY);
        selectedPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    void drawSelection(int x, int y, int width, int height) {
        Rect r = new Rect(x, y, x + width, y + height);
        canvas.drawRect( r, selectedPaint);
    }

    void drawBackground(int x, int y, int width, int height) {
        canvas.drawRect(x, y, x + width, y + height, backgroundPaint);
    }

    void drawPiece(int x, int y, int width, int height, char pieceType) {
        Bitmap bitmap = bitmaps.getBitmap(pieceType);
        Rect rect = new Rect(x, y, x + width, y+height);
        canvas.drawBitmap(bitmap, null, rect, null);
    }

    void drawHorizontalLine(int leftX, int leftY, int length) {
        canvas.drawLine(leftX, leftY, leftX + length, leftY, linesPaint);
    }

    void drawVerticalLine(int topX, int topY, int height) {
        canvas.drawLine(topX, topY, topX, topY + height, linesPaint);
    }

    void terminateDraw () { canvas = null; }


}
