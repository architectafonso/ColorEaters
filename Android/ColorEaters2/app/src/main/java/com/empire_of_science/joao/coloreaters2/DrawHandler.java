package com.empire_of_science.joao.coloreaters2;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by João on 23/02/2017.
 * Copyright João Afonso.
 *
 * Handles the drawing of the game area.
 * Uses a BoardDimensions object to resolve where to draw the elements, and Bitmaps object to hold
 * the sprite sheets and the methods that return the rect to cut them.
 */

class DrawHandler {
    private Draw_Bitmaps bitmaps;
    private Paint backgroundPaint = new Paint();
    private Paint linesPaint = new Paint();


    /**
     * Sets the different resources.
     * @param gameSystem Reference from wich to reach an activity so that resources can be initialized.
     */
    DrawHandler(GameSystem gameSystem){
        bitmaps = new Draw_Bitmaps(gameSystem.gameView.activity);
        backgroundPaint.setColor(Color.BLACK);
        backgroundPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        linesPaint.setColor(Color.WHITE);
        linesPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    /**
     * Draws all of the elements into the canvas.
     * @param canvas The Android canvas to draw to.
     * @param gameSystem Has reference to BoardDimensions.
     */
    void draw(Canvas canvas, GameSystem gameSystem) {
        gameSystem.dimensions.setDimensions(canvas);
        drawBackground(canvas, gameSystem);
        drawBlockPieces(canvas, gameSystem);
        drawBoardLines(canvas, gameSystem);
        drawCake(canvas, gameSystem);
        drawEaters(canvas, gameSystem);
    }

    /**
     * Draws the black background.
     * @param canvas Canvas to draw into.
     * @param gameSystem Reference to the game.
     */
    private void drawBackground(Canvas canvas, GameSystem gameSystem){
        canvas.drawARGB(255, 255, 255, 255);
        Rect r = gameSystem.dimensions.getEntireBoardRect();
        canvas.drawRect(r, backgroundPaint);
    }

    /**
     * Draws all block pieces so they are underneath the lines, as that looks better.
     * @param canvas Canvas to draw into.
     * @param gameSystem Reference to the game.
     */
    private void drawBlockPieces(Canvas canvas, GameSystem gameSystem){
        for (BoardPiece piece : gameSystem.board){
            if (piece instanceof BoardPiece_Block){
                drawPiece(canvas, piece, gameSystem);
            }
        }
    }

    /**
     * Draws board lines in white.
     * @param canvas Canvas to draw into.
     * @param gameSystem Reference to the game.
     */
    private void drawBoardLines(Canvas canvas, GameSystem gameSystem){
        BoardDimensions d = gameSystem.dimensions;
        for (int index = 1; index < 6; index ++){

            canvas.drawLine(d.getXOfVerticalBorders(index), d.boardTop(),
                    d.getXOfVerticalBorders(index), d.boardBottom(), linesPaint);

            canvas.drawLine(d.boardLeft(), d.getYOfHorizontalBorders(index),
                    d.boardRight(), d.getYOfHorizontalBorders(index), linesPaint);
        }

    }

    /**
     * Draws the cake.
     * @param canvas Canvas to draw into.
     * @param gameSystem Reference to the game.
     */
    private void drawCake(Canvas canvas, GameSystem gameSystem){
        for (BoardPiece piece : gameSystem.board) {
            if (piece instanceof BoardPiece_Cake || piece instanceof BoardPiece_EatenCake || piece instanceof BoardPiece_FrozenCake){
                drawPiece(canvas, piece, gameSystem);
            }
        }
    }

    /**
     * Draws the eaters.
     * @param canvas Canvas to draw into.
     * @param gameSystem Reference to the game.
     */
    private void drawEaters(Canvas canvas, GameSystem gameSystem){
        for (BoardPiece piece : gameSystem.board) {
            if(piece instanceof BoardPiece_NormalEater || piece instanceof BoardPiece_FlyingFatso) {
                drawPiece(canvas, piece, gameSystem);
            }
        }
    }

    /**
     * Draw a specific piece.
     * @param canvas Canvas to draw into.
     * @param piece Piece to be drawn.
     * @param gameSystem Reference to the game.
     */
    private void drawPiece(Canvas canvas, BoardPiece piece , GameSystem gameSystem){
        Draw_Bitmaps.BitmapInfo bitmapInfo = bitmaps.getBitmap(piece);
        Rect r = gameSystem.dimensions.getGraphicsCoordinatesRect(piece.graphicsX, piece.graphicsY);
        canvas.drawBitmap(bitmapInfo.bitmap, bitmapInfo.rect, r, null);
    }
}
