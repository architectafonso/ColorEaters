package com.empire_of_science.joao.coloreaters2;

/**
 * Created by João on 17/08/2015.
 * Has the method to return the level's String[] that is then used by LevelLoader to create the
 * necessary board.
 * Each level package has a method called getLevel( int level) that returns a string[] with this format:
 * 6 strings of 6 characters and another with the number of moves.
 * Characters used right now:
 * b, B - blue cake and eater;
 * g, G - green cake and eater;
 * w, W - white cake and eater;
 * r, R - red cake and eater;
 * y, Y - yellow cake and eater;
 * X - blocking X piece.
 *
 * Use LevelLoader.loadLevel to actually get an board with the level loaded.
 */
class Levels {

    /**
     * This method calls the level package to obtain the level and to convert it.
     * Each Levels_x class is a game package.
     * @param levelPackage Group of 20 levels chosen by the user.
     * @param level Level to be returned.
     * @return BoardPiece ArrayList with all the pieces of the level.
     */
    public static String[] getLevel(int levelPackage, int level){
        switch(levelPackage){
            case 1:
                return Levels_1.getLevel(level);
            case 2:
                return Levels_2.getLevel(level);
            case 3:
                return Levels_3.getLevel(level);
            case 4:
                return Levels_4.getLevel(level);
            case 5:
                return Levels_5.getLevel(level);
            case 6:
                return Levels_6.getLevel(level);
            case 7:
                return Levels_7.getLevel(level);
            default:
                return new String[0];
        }
    }
}