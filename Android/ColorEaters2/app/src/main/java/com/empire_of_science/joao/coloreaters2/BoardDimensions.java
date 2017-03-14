package com.empire_of_science.joao.coloreaters2;


import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * Created by João on 19/11/2016.
 * Contains all of the information about the canvas coordinates of different points of the board
 * and it's used to get coordinates to draw the content of the board, and to check witch cell
 * corresponds to certain canvas coordinates.
 */
class BoardDimensions {

    private int lastCanvasWidth;
    private int lastCanvasHeight;

    /**
     * This arrays has the x coordinates of the sides of the board and cell lines.
     */
    private final int[] xCoordinates = new int[7];

    /**
     * This array has the y coordinates of the top and bottom of the board and cell lines.
     */
    private final int[] yCoordinates = new int[7];

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
     * The size of the side of 1 of the 36 cells of the board.
     */
    private int cellSide;

    /**
     * Sets the dimensions from canvas, only if the canvas have changed since last time.
     * @param canvas The canvas stuff will be drawn to.
     */
    void setDimensions(Canvas canvas){
        // Checks if there was any change since last setting of the dimensions.
        if (canvas.getWidth() == lastCanvasWidth && canvas.getHeight() == lastCanvasHeight) return;
        lastCanvasWidth = canvas.getWidth();
        lastCanvasHeight = canvas.getHeight();


        // Determines the boardSide and cellSide. Considers the possibility of the drawing part of
        // the canvas not to start at 0,0.
        if(canvas.getHeight() < canvas.getWidth()) {
            boardSide = canvas.getHeight();
            xCoordinates[0]=((canvas.getWidth() -boardSide)/2);
            yCoordinates[0]= 0;
        }
        else {
            boardSide = canvas.getWidth();
            xCoordinates[0]= 0;
            yCoordinates[0]= ((canvas.getHeight()-boardSide)/2);
        }

        cellSide = boardSide / 6;

        //all of the other dimensions are set cellSide apart
        for(int index = 1; index < 7; index++){
            xCoordinates[index] = xCoordinates[index-1] + (cellSide);
            yCoordinates[index] = yCoordinates[index-1] + (cellSide);
        }
        // The scale is set, it is the number one has to multiply
        // the 0 to 1000 piece coordinate to get the 0 to boardSide coordinate.
        scale = boardSide / 1000F;


    }

    Rect getEntireBoardRect() {
        return new Rect(xCoordinates[0], yCoordinates[0], xCoordinates[6], yCoordinates[6]);
    }

    /**
     * NOT IN USE AS THERE IS NO SELECTION RIGHT NOW; PRESERVED BECAUSE MIGHT EXIST AGAIN.
     * @param x Cell x coordinate.
     * @param y Cell y coordinate.
     * @return The cell rect.
     */
    Rect getCellRect(int x, int y) {
        return new Rect (xCoordinates[x],  yCoordinates[y], xCoordinates[x+1],  yCoordinates[y+1]);
    }

    /**
     * Gets the rect where to drawn in the canvas a certain piece from the piece's graphics coordinates.
     * @param graphicsX Piece's graphicsX.
     * @param graphicsY Piece's graphicsY.
     * @return The rect where to draw a piece.
     */
    Rect getGraphicsCoordinatesRect(int graphicsX, int graphicsY) {
        int left = xCoordinates[0] +  (int)(scale * graphicsX);
        int top = yCoordinates[0] +  (int)(scale * graphicsY);
        return new Rect(left, top, left + cellSide, top + cellSide);
    }

    /**
     * Gets the coordinates of the cell that has the specified point in canvas coordinates.
     * The result is in the form of an array.
     * @param x The canvas x coordinate.
     * @param y The canvas y coordinate.
     * @return Array with cell coordinates, x = [0], y = [1].
     * @throws GameException If the touch didn't happen on a cell.
     */
    int[] getWhichCellAtCanvasCoordinates(float x, float y) throws GameException{
        Boolean touchOnCellX = false;
        Boolean touchOnCellY = false;

        int[] result = new int[2];

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

        if(!(touchOnCellX) && (touchOnCellY)){
            throw new GameException("No cell was touched");
        }

        return result;
    }

    int getXOfVerticalBorders(int line) {
        return xCoordinates[line];
    }

    int getYOfHorizontalBorders(int line) {
        return yCoordinates[line];
    }

    int boardTop() {
        return yCoordinates[0];
    }

    int boardBottom() {
        return yCoordinates[6];
    }

    int boardLeft() {
        return xCoordinates[0];
    }

    int boardRight() {
        return xCoordinates[6];
    }


    /**
     * Returns an x graphics coordinate, that goes from 0 to 1000, from the actual Android canvas
     * coordinate.
     * @param canvasX The coordinate in the canvas.
     * @return Graphics x coordinate.
     */
    int graphicsXFromCanvasCoordinates(int canvasX){
        if (canvasX < xCoordinates[0]) return 0;
        if (canvasX > xCoordinates[6]) return 1000;
        int size = xCoordinates[6] - xCoordinates[0];
        int displacement = canvasX - xCoordinates[0];
        return (displacement * 1000) / size;
        
    }
    /**
     * Returns an Y graphics coordinate, that goes from 0 to 1000, from the actual Android canvas
     * coordinate.
     * @param canvasY The coordinate in the canvas.
     * @return Graphics Y coordinate.
     */
    int graphicsYFromCanvasCoordinates(int canvasY) {
        if (canvasY < yCoordinates[0]) return 0;
        if (canvasY > yCoordinates[6]) return 1000;
        int size = yCoordinates[6] - yCoordinates[0];
        int displacement = canvasY - yCoordinates[0];
        return (displacement * 1000) / size;
    }
}
