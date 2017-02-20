package com.empire_of_science.joao.coloreaters2;

import android.graphics.Color;

/**
 * Created by João on 30/09/2016.
 *
 * Loads a level from an Intent to the Board and GameActivity.
 */
class LevelLoader {

    /**
     * Checks the level format throwing exceptions if it isn't correct.
     * @param level The string[] that is in the levels files.
     */
    private static void checkLevelFormat(String[] level){
        if (level.length != 7)
            throw (new GameException("Provided Level Isn't in correct form - number of strings"));

        for (int x = 0; x < 6; x++) {
            if (level[x].length() != 6)
                throw (new GameException("Provided Level Isn't in correct form - wrong string: " + x));
        }
    }

    /*
     * Gets the right BoardPiece object from the character used in the levels files, and
     * adds it to the board.
     * It is going to be used...
     * @param board Board that is being build.
     * @param level
     * @param x
     * @param y
     */
    private static void putBoardPieceInBoard(Board board, char c, int x, int y){
        switch (c) {
            case 'b':
                board.pieces[x][y] = new Cake(x,y, Color.BLUE);
                break;
            case 'B':
                board.pieces[x][y] = new Eater(x,y, Color.BLUE);
                break;
            case 'g':
                board.pieces[x][y] = new Cake(x,y, Color.GREEN);
                break;
            case 'G':
                board.pieces[x][y] = new Eater(x,y, Color.GREEN);
                break;
            case 'r':
                board.pieces[x][y] = new Cake(x,y, Color.RED);
                break;
            case 'R':
                board.pieces[x][y] = new Eater(x,y, Color.RED);
                break;
            case 'y':
                board.pieces[x][y] = new Cake(x,y, Color.YELLOW);
                break;
            case 'Y':
                board.pieces[x][y] = new Eater(x,y, Color.YELLOW);
                break;
            case 'w':
                board.pieces[x][y] = new Cake(x,y, Color.WHITE);
                break;
            case 'W':
                board.pieces[x][y] = new Eater(x,y, Color.WHITE);
                break;
            case 'X':
                board.pieces[x][y] = new BlockBoardPiece(x,y);
                break;
            case ' ':
                break;
            default: throw (new GameException("Provided Level Isn't in correct form - Bad character"));
        }
    }

    private static int getNumberOfMoves(String[] level) {
        return Integer.parseInt(level[6]);
    }

    /**
     * Loads the pieces and number of moves into the provided Board.
     * @param levelPackage The levels package this level belongs to.
     * @param level The level to be loaded.
     * @param board The board have the level loaded.
     */
    static void loadLevel(int levelPackage, int level, Board board){
        String[] levelStrings = Levels.getLevel(levelPackage, level);

        // Checks for errors in the format.
        checkLevelFormat(levelStrings);

        //Foreach character in the Level String[]
        // put it on the list.
        for (int x = 0; x < 6; x++) for (int y = 0; y < 6; y++){
            putBoardPieceInBoard(board, levelStrings[y].charAt(x), x, y);
        }

        // Puts the list and the number of moves in the right place
        board.movesLeft = getNumberOfMoves(levelStrings);
    }
}
