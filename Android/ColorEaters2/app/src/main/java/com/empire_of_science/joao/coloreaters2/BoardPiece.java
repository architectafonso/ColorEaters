package com.empire_of_science.joao.coloreaters2;


import java.util.Random;

/**
 * Created by João on 14/08/2015.
 * This abstract class represents every board piece of any kind.
 */
abstract class BoardPiece {

    /**
     * Stage of the piece's background animation.
     * Can be a number from 0 to 4.
     */
    int animationLoopState = 0;

    /**
     * Coordinates for the horizontal precise position of the piece in the view.
     * Used because of animations. Will be a value between 0 and 1000.
     */
    int graphicsX;

    /**
     * Coordinates for the vertical precise position of the piece in the view.
     * Used because of animations. Will be a value between 0 and 1000.
     */
    int graphicsY;

    /**
     * Board horizontal coordinate for the board cell the piece is in.
     * Will be a value between 0 and 5.
     */
    int boardX;

    /**
     * Board vertical coordinate for the board cell the piece is in.
     * Will be a value between 0 and 5.
     */
    int boardY;

    /**
     * Sets both the board cell coordinates and the graphics coordinates.
     * @param x X cell coordinate.
     * @param y Y cell coordinate.
     */
    BoardPiece(int x, int y){
        boardX = x;
        boardY = y;
        moveToPlace();
    }

    /**
     * Returns a board piece from the letter used in the string array that defines a level or
     * paused state.
     * @param c Char that defines the piece.
     * @param x X cell coordinate the piece is gonna be in.
     * @param y Y cell coordinate the piece is gonna be in.
     * @return The wanted piece.
     */
    static BoardPiece BoardPieceFactory(char c, int x, int y) {
        if (c == 'X') return new BoardPiece_Block(x, y);
        switch (c) {
            case 'b':
                return  new BoardPiece_Cake(x,y, Colors.Blue);
            case 'B':
                return  new BoardPiece_Eater(x,y, Colors.Blue);
            case 'g':
                return  new BoardPiece_Cake(x,y, Colors.Green);
            case 'G':
                return  new BoardPiece_Eater(x,y, Colors.Green);
            case 'r':
                return  new BoardPiece_Cake(x,y, Colors.Red);
            case 'R':
                return  new BoardPiece_Eater(x,y, Colors.Red);
            case 'y':
                return  new BoardPiece_Cake(x,y, Colors.Yellow);
            case 'Y':
                return  new BoardPiece_Eater(x,y, Colors.Yellow);
            case 'w':
                return  new BoardPiece_Cake(x,y, Colors.White);
            case 'W':
                return  new BoardPiece_Eater(x,y, Colors.White);
            case ' ':
                return null;
            default: throw (new GameException("Provided Level Isn't in correct form - Bad character: " + c));
        }
    }


    /**
     * Gets the char that represents this piece in the string arrays used to store levels and saved
     * state, or a space if p is null.
     * If the piece is eaten cake, than it is the same as null, as it is eaten anyway.
     * @param p The BoardPiece.
     * @return The corresponding character.
     */
    static char toChar(BoardPiece p) {
        if (p instanceof  BoardPiece_EatenCake) return ' ';
        if (p == null) return ' ';
        if (p instanceof BoardPiece_Block) return 'X';
        if (p instanceof BoardPiece_Eater) {
            switch (((BoardPiece_Eater) p).color) {
                case Green: return 'G';
                case Red: return 'R';
                case Yellow: return 'Y';
                case White: return 'W';
                case Blue: return 'B';
                default: throw (new GameException("Provided Level Isn't in correct form - Bad character"));

            }
        }
        if (p instanceof BoardPiece_Cake) // Is eaten cake considered always true here.
        {
            switch (((BoardPieceWithColor) p).color) {
                case Green: return 'g';
                case Red: return 'r';
                case Yellow: return 'y';
                case White: return 'w';
                case Blue: return 'b';
                default: throw (new GameException("Provided Level Isn't in correct form - Bad character"));
            }
        }
        return ' ';
    }


    /**
     * Makes sure the canvas float coordinates are set in accordance with board position.
     * This allows to make sure that the position is the one of the cell the piece is in after the
     * animations.
     * The graphics coordinates are set with a value between 0 and 1000 and during GameView's onDraw
     * that is converted to the actual canvas coordinates.
     */
    void moveToPlace(){
        graphicsX = (1000/6)* boardX;
        graphicsY = (1000/6)* boardY;
    }

    /**
     * Each piece can decide if a certain move to a board cell is legal or not.
     * @param board The Board the piece belongs to.
     * @param goToX X coordinate of the cell this piece is supposed to move.
     * @param goToY Y coordinate of the cell this piece is supposed to move.
     * @return True if the move is possible in accordance with the rules.
     */
    abstract boolean canDoMovement(Board board, int goToX, int goToY);

    /**
     * Each piece can decide if it is selectable when in a certain position in the board.
     * @param board The Board the piece belongs to.
     * @return True if the piece can be selected.
     */
    abstract boolean isSelectable(Board board);

}


