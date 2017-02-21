package com.empire_of_science.joao.coloreaters2;


/**
 * Created by João on 19/11/2016.
 * Contains all of the information about the canvas coordinates of different points of the board
 * and it's used to get coordinates to draw the content of the board, and to check witch cell
 * corresponds to certain canvas coordinates.
 */
class BoardDimensions {

    private int lastCanvasWidth;
    private int lastCanvasHeight;
    private int lastCanvasX;
    private int lastCanvasY;

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

    private int cellSide;

    void setDimensions(Rectangle canvas){
        // Checks if there was any change since last setting of the dimensions.
        if (canvas.width == lastCanvasWidth && canvas.height == lastCanvasHeight
                && canvas.x == lastCanvasX && canvas.y == lastCanvasY) return;
        lastCanvasWidth = canvas.width;
        lastCanvasHeight = canvas.height;
        lastCanvasX = canvas.x;
        lastCanvasY = canvas.y;

        // Determines the boardSide and cellSide. Considers the possibility of the drawing part of
        // the canvas not to start at 0,0.
        if(canvas.height < canvas.width) {
            boardSide = canvas.height;
            xCoordinates[0]=((canvas.width -boardSide)/2) + canvas.x;
            yCoordinates[0]= canvas.y;
        }
        else {
            boardSide = canvas.width;
            xCoordinates[0]= canvas.x;
            yCoordinates[0]= ((canvas.height-boardSide)/2) + canvas.y;
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

    Rectangle  getEntireBoardRect() {
        return new Rectangle(xCoordinates[0], yCoordinates[0], boardSide, boardSide);
    }

    Rectangle getCellRect(int x, int y) {
        return new Rectangle (xCoordinates[x],  yCoordinates[y], cellSide,  cellSide);
    }

    Rectangle getGraphicsCoordinatesRect(int graphicsX, int graphicsY) {
        int left = xCoordinates[0] +  (int)(scale * graphicsX);
        int top = yCoordinates[0] +  (int)(scale * graphicsY);
        return new Rectangle(left, top, cellSide, cellSide);
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
}
