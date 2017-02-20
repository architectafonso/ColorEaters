package com.empire_of_science.joao.coloreaters2;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by João on 29/09/2016.
 * This class is a singleton that contains the method for drawing the actual pieces, so
 * that it is easier to change game graphics without changing activities and views.
 */
class DrawGame {

    /**
     * Static field to hold the singleton instance.
     */
    private static DrawGame drawGameHolder;

    /**
     * Returns an instance of DrawGame that has everything needed to draw every element of
     * the game.
     * @param activity The activity that calls for the DrawGame object,
     *                 so it can draw on the activity.
     * @return A DrawGame object.
     */
    static DrawGame getInstance(GameActivity activity)
    {
        if(drawGameHolder == null) {
            drawGameHolder = new DrawGame(activity);
            return drawGameHolder;
        }
        return drawGameHolder;
    }

    /**
     * This arrays has the x coordinates of the sides of the board and cell lines.
     */
    int[] xCoordinates = new int[7];

    /**
     * This array has the y coordinates of the top and bottom of the board and cell lines.
     */
    int[] yCoordinates = new int[7];

    /**
     * Used during calculations at onDraw. It represents the side of the game board square and
     * the shortest side of the canvas of the GameView.
     */
    private int boardSide;

    /**
     * If one multiplies the scale with an 0 to 1000 coordinate used by the pieces,
     * one gets the 0 to boardSide equivalent, which is what is used to actually draw
     * on the canvas.
     */
    private float scale;

    /**
     * Object containing the bitmaps.
     */
    private DrawGameBitmaps bitmaps;

    /**
     * Paint used to draw the background of the board.
     */
    private Paint backgroundPaint = new Paint();

    /**
     * Paint used to draw the lines dividing the cells.
     */
    private Paint linesPaint = new Paint();

    /**
     * Paint used to draw the highlighted cell.
     */
    private Paint selectedPaint = new Paint();

    /**
     * The constructor initializes all of the bitmaps from resources.
     * @param activity An reference to an activity is needed to get the resources.
     */
    private DrawGame(GameActivity activity) {

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

    /**
     * Sets the fields that concern the board dimensions.
     * @param canvas The canvas which size is used to get the board dimensions.
     */
    private void determineBoardDimensions(Canvas canvas){
        if(canvas.getHeight() < canvas.getWidth()) {
            boardSide = canvas.getHeight();
            xCoordinates[0]=(canvas.getWidth()-boardSide)/2;
            yCoordinates[0]=0;
        }
        else {
            boardSide = canvas.getWidth();
            xCoordinates[0]=0;
            yCoordinates[0]=(canvas.getHeight()-boardSide)/2;
        }
        //all of the other dimensions are set (boardSide / 6) apart
        for(int index = 1; index < 7; index++){
            xCoordinates[index] = xCoordinates[index-1] + (boardSide/6);
            yCoordinates[index] = yCoordinates[index-1] + (boardSide/6);
        }
        // The scale is set, it is the number one has to multiply
        // the 0 to 1000 piece coordinate to get the 0 to boardSide coordinate.
        scale = boardSide / 1000F;
    }

    /**
     * Draws the background of the board.
     * @param canvas The canvas to draw to.
     */
    private void drawBackground(Canvas canvas){
        canvas.drawRect(xCoordinates[0], yCoordinates[0],
                xCoordinates[0] + boardSide, yCoordinates[0] + boardSide,
                backgroundPaint);
    }

    /**
     * Draws the highlighting of the selected cell if there is one.
     * @param canvas The canvas to draw to.
     * @param board The board containing the information about selected cell.
     */
    private void drawSelection(Canvas canvas, Board board){
        if(board.hasSelected){
            canvas.drawRect((float) xCoordinates[board.selectedX], (float) yCoordinates[board.selectedY],
                    (float) xCoordinates[board.selectedX + 1], (float) yCoordinates[board.selectedY + 1],
                    selectedPaint);
        }
    }

    /**
     * Draws the board lines between the cells where pieces are.
     * @param canvas The canvas to draw to.
     */
    private void drawBoardLines(Canvas canvas){
        for(int index = 1; index < 6 ; index++){
            canvas.drawLine(xCoordinates[index], yCoordinates[0], xCoordinates[index], yCoordinates[6], linesPaint);
            canvas.drawLine(xCoordinates[0], yCoordinates[index], xCoordinates[6], yCoordinates[index], linesPaint);
        }
    }

    /**
     * Draws every blocking piece.
     * @param board The board where the pieces are.
     * @param canvas The canvas to draw to.
     */
    private void drawBlockPieces(Board board, Canvas canvas) {
        int side = boardSide / 6;
        for (BoardPiece[] array : board.pieces) for (BoardPiece piece : array) if (piece instanceof BlockBoardPiece) {
            int left = xCoordinates[0] +  (int)(scale * piece.graphicsX);
            int top = yCoordinates[0] +  (int)(scale * piece.graphicsY);
            int right = left +  side;
            int bottom = top +  side;
            //Creates the bitmap rectangle
            Rect r = new Rect(left, top, right, bottom);
            //Finally draws the piece!
            canvas.drawBitmap(bitmaps.blockPiece, null, r, null);
        }
    }

    /**
     * Draws every cake piece.
     * @param board The board where the pieces are.
     * @param canvas The canvas to draw to.
     */
    private void drawCake(Board board, Canvas canvas) {
        int side = boardSide / 6;
        for (BoardPiece[] array : board.pieces) for (BoardPiece piece : array) {
            if(piece instanceof Cake) {

                Bitmap bitmap = getCakeBitmap(((Cake) piece).color);

                int left = xCoordinates[0] +  (int)(scale * piece.graphicsX);
                int top = yCoordinates[0] +  (int)(scale * piece.graphicsY);
                int right = left +  side;
                int bottom = top +  side;
                //Creates the bitmap rectangle
                Rect r = new Rect(left, top, right, bottom);
                //Finally draws the piece!
                canvas.drawBitmap(bitmap, null, r, null);
            }
        }

    }

    /**
     * Gets the bitmap of the cake with the corresponding color.
     * @param color The color of the cake piece.
     * @return Bitmap of the cake.
     */
    private Bitmap getCakeBitmap(int color) {
        if (color == Color.GREEN)  return bitmaps.greenCake;
        if (color == Color.BLUE)   return bitmaps.blueCake;
        if (color == Color.WHITE)  return bitmaps.whiteCake;
        if (color == Color.YELLOW) return bitmaps.yellowCake;
        if (color == Color.RED)    return bitmaps.redCake;
        return bitmaps.yellowCake;
    }

    /**
     * Draws every eater piece.
     * @param board The board where the pieces are.
     * @param canvas The canvas to draw to.
     */
    private void drawEaters(Board board, Canvas canvas) {
        int side = boardSide / 6;
        for (BoardPiece[] array : board.pieces) for (BoardPiece piece : array) {
            if(piece instanceof Eater) {

                Bitmap bitmap = getEaterBitmap(((Eater) piece).color);

                int left = xCoordinates[0] +  (int)(scale * piece.graphicsX) + 10;
                int top = yCoordinates[0] +  (int)(scale * piece.graphicsY) + 10;
                int right = left +  side - 10;
                int bottom = top +  side -10;
                //Creates the bitmap rectangle
                Rect r = new Rect(left, top, right, bottom);
                //Finally draws the piece!
                canvas.drawBitmap(bitmap, null, r, null);
            }
        }
    }

    /**
     * Gets the bitmap of the eater with the corresponding color.
     * @param color The color of the eater piece.
     * @return Bitmap of the eater.
     */
    private Bitmap getEaterBitmap(int color) {
        if (color == Color.GREEN)  return bitmaps.greenEater;
        if (color == Color.BLUE)   return bitmaps.blueEater;
        if (color == Color.WHITE)  return bitmaps.whiteEater;
        if (color == Color.YELLOW) return bitmaps.yellowEater;
        if (color == Color.RED)    return bitmaps.redEater;
        else return bitmaps.yellowCake;
    }

    /**
     * Draws the different elements of the game, namely the background, the lines dividing the cells,
     * and all the pieces.
     * @param canvas The canvas to draw to.
     * @param board The board of the game.
     */
    void drawGame(Canvas canvas, Board board) {

        // Sets the board dimensions.
        determineBoardDimensions(canvas);

        drawBackground(canvas);

        drawSelection(canvas, board);

        drawBlockPieces(board, canvas); // Drawn before the lines so it looks better.

        drawBoardLines(canvas);

        drawCake(board, canvas);

        drawEaters(board, canvas);

    }

    /**
     * Returns the cells at canvas coordinates in the array at the result
     * parameter and returns false if the touch didn't happen on a cell.
     * @param x The x coordinate on the canvas.
     * @param y The y coordinate on the canvas.
     * @param result Reference to the array that will get the cell coordinates, [0] = x and [1] = y.
     * @return True if canvas coordinates correspond to a cell and false otherwise.
     */
    boolean getWhichCellAtCanvasCoordinates(float x, float y, int[] result){
        Boolean touchOnCellX = false;
        Boolean touchOnCellY = false;

        for(int testX = 0; testX < 6; testX++) {
            if (x > xCoordinates[testX] && x < xCoordinates[testX + 1]) {
                touchOnCellX = true;
                result[0] = testX;
            }
        }

        for(int testY = 0; testY < 6; testY++){
            if(y > yCoordinates[testY] && y < yCoordinates[testY+1]){
                touchOnCellY = true;
                result[1] = testY;
            }
        }

        return (touchOnCellX) && (touchOnCellY);
    }
 }
